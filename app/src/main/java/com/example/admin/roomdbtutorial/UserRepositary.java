package com.example.admin.roomdbtutorial;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.admin.roomdbtutorial.model.UserModel;
import com.example.admin.roomdbtutorial.model.dao.UserDao;

import java.util.List;

import androidx.lifecycle.LiveData;

public class UserRepositary {

    private UserDao userDao;
    private LiveData<List<UserModel>> userModels;
    public Application application;

    public UserRepositary(Application application) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        userDao = appDatabase.userDao();
        userModels = userDao.getAllUser();
        this.application = application;
    }

    public void insert(UserModel userModel) {
        new InsertUser(userDao, application).execute(userModel);
    }

    public void update(UserModel userModel) {
        new UpdateUser(userDao, application).execute(userModel);
    }

    public LiveData<List<UserModel>> getUserModels() {
        return userModels;
    }

    public void delete(UserModel userModel) {
        new DeleteUser(userDao, application).execute(userModel);
    }

    private static class InsertUser extends AsyncTask<UserModel, Void, Void> {

        private UserDao userDao;
        private Application application;

        private InsertUser(UserDao userDao, Application application) {
            this.userDao = userDao;
            this.application = application;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {
            userDao.insertUser(userModels[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(application.getApplicationContext(),"User Inserted Successfully", Toast.LENGTH_SHORT ).show();
        }
    }

    private static class UpdateUser extends AsyncTask<UserModel, Void, Void> {

        private UserDao userDao;
        private Application application;

        private UpdateUser(UserDao userDao, Application application) {
            this.userDao = userDao;
            this.application = application;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {
            userDao.updateUser(userModels[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(application.getApplicationContext(),"User Update Successfully", Toast.LENGTH_SHORT ).show();
        }
    }

    private static class DeleteUser extends AsyncTask<UserModel, Void, Void> {

        private UserDao userDao;
        private Application application;

        private DeleteUser(UserDao userDao, Application application) {
            this.userDao = userDao;
            this.application = application;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {
            userDao.deleteUser(userModels[0]);
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(application.getApplicationContext(),"User Delete Successfully", Toast.LENGTH_SHORT ).show();
        }
    }
}
