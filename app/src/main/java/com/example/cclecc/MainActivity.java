package com.example.cclecc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText editTextproductname;
    EditText editTextpriceproduct;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextproductname = findViewById(R.id.nameproduct);
        editTextpriceproduct = findViewById(R.id.priceproduct);


    }

    public void savetofirebase(View v){

       String productname = editTextproductname.getText().toString();
       String priceproduct = editTextpriceproduct.getText().toString();

        Map<String,Object> product = new HashMap<>();
        product.put("product name " ,productname);
        product.put("product price " , priceproduct);

        db.collection("products").add(product)
        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d("FAZ","this is data added ");
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("FAZ","this is data non added ");
            }
        })
        ;

    }




}