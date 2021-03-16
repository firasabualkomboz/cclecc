package com.example.cclecc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolderView> {

    List<Users> usersList = new ArrayList<>();

    @NonNull
    @Override
    public UserHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserHolderView(LayoutInflater.from(parent.getContext()).inflate(R.layout.datauser, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolderView holder, int position) {
        holder.bind(usersList.get(position));
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class UserHolderView extends RecyclerView.ViewHolder {
        TextView txtName, txtNumber, txtAddress;

        public UserHolderView(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.viewname);
            txtNumber = itemView.findViewById(R.id.viewnumber);
            txtAddress = itemView.findViewById(R.id.veiwaddress);
        }

        public void bind(Users users) {
            txtName.setText(users.getName());
            txtNumber.setText(users.getNumber());
            txtAddress.setText(users.getAddress());
        }

    }
}
