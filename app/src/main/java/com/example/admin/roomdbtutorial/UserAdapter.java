package com.example.admin.roomdbtutorial;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.roomdbtutorial.model.UserModel;
import com.example.admin.roomdbtutorial.model.UserViewModel;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {


    private Context context;
    private UserViewModel userViewModel;
    private List<UserModel> userModels = new ArrayList<>();
    ViewUsersActivity viewUsersActivity;

    public UserAdapter(Context context) {
        this.context = context;
        this.viewUsersActivity = (ViewUsersActivity) context;
        userViewModel = ViewModelProviders.of(viewUsersActivity).get(UserViewModel.class);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_user, null);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserModel userModel = userModels.get(position);
        holder.tvFirstName.setText(userModel.getFirstName());
        holder.tvLastName.setText(userModel.getLastName());
        holder.tvEmail.setText(userModel.getEmailId());
        holder.tvMobilrNumber.setText(userModel.getMobileNumber());
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, UpdateActivity.class);
            intent.putExtra("userDetails", userModels.get(position));
            context.startActivity(intent);
        });
        holder.cardView.setOnLongClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(viewUsersActivity);
            builder.setTitle("Are you sure delete user?");
            builder.setPositiveButton("Yes", (dialogInterface, i) -> {
                userModels.remove(position);
                userViewModel.deleteUser(userModel);
            });
            builder.setNegativeButton("No", (dialogInterface, i) -> dialogInterface.dismiss());

            AlertDialog ad = builder.create();
            ad.show();
            return true;
        });

    }

    @Override
    public int getItemCount() {
        return userModels.isEmpty() ? 0 : userModels.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvFirstName)
        AppCompatTextView tvFirstName;
        @BindView(R.id.tvLastName)
        AppCompatTextView tvLastName;
        @BindView(R.id.tvEmail)
        AppCompatTextView tvEmail;
        @BindView(R.id.tvMobilrNumber)
        AppCompatTextView tvMobilrNumber;
        @BindView(R.id.cardView)
        MaterialCardView cardView;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setUserList(List<UserModel> userModels) {
        this.userModels = userModels;
        notifyDataSetChanged();
    }
}
