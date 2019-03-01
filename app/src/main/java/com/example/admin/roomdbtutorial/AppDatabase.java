package com.example.admin.roomdbtutorial;

import android.app.Application;
import android.content.Context;

import com.example.admin.roomdbtutorial.model.UserModel;
import com.example.admin.roomdbtutorial.model.dao.UserDao;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserModel.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public abstract UserDao userDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "UserTable")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDatabase;
    }
}
