package com.example.cclecc;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText editTextusername;
    EditText editTextnumberuser;
    EditText editTextaddress;
    RecyclerView recyclerView;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    List<Users> users = new ArrayList<>();
    UserAdapter adapter = new UserAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextusername = findViewById(R.id.namesuer);
        editTextnumberuser = findViewById(R.id.namberuser);
        editTextaddress = findViewById(R.id.useraddress);
        recyclerView = findViewById(R.id.listView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getData();
    }

    public void savetofirebase(View v) {

        String username = editTextusername.getText().toString();
        String numberuser = editTextnumberuser.getText().toString();
        String useraddress = editTextaddress.getText().toString();

        Users users = new Users(username, useraddress, numberuser);

        db.collection("contact").add(users)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("FAZ", "this is data added ");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("FAZ", "this is data non added ");
                    }
                })
        ;

    }

  
    private void getData() {
        db.collection("contact").addSnapshotListener((queryDocumentSnapshots, e) -> {
            users.clear();
            if (e == null) {
                queryDocumentSnapshots.forEach(queryDocumentSnapshot -> {
                    Users user = queryDocumentSnapshot.toObject(Users.class);
                    users.add(user);
                });
                adapter.usersList.clear();
                adapter.usersList.addAll(users);
                adapter.notifyDataSetChanged();
            }
        });
    }

}