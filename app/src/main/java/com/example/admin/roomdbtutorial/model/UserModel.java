package com.example.admin.roomdbtutorial.model;

import com.example.admin.roomdbtutorial.BR;

import java.io.Serializable;
import java.util.Objects;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserModel extends BaseObservable implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "firstName")
    private String firstName;

    @ColumnInfo(name = "lastName")
    private String lastName;

    @ColumnInfo(name = "email")
    private String emailId;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "phoneNumber")
    private String mobileNumber;


    /**
     * Getter and Setter method.
     */
    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (!Objects.equals(this.id, id)) {
            this.id = id;
            notifyPropertyChanged(BR.id);
        }

    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!Objects.equals(this.firstName, firstName)) {
            this.firstName = firstName;
            notifyPropertyChanged(BR.firstName);
        }
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!Objects.equals(this.lastName, lastName)) {
            this.lastName = lastName;
            notifyPropertyChanged(BR.lastName);
        }
    }

    @Bindable
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        if (!Objects.equals(this.emailId, emailId)) {
            this.emailId = emailId;
            notifyPropertyChanged(BR.emailId);
        }
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!Objects.equals(this.password, password)) {
            this.password = password;
            notifyPropertyChanged(BR.password);
        }
    }

    @Bindable
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        if (!Objects.equals(this.mobileNumber, mobileNumber)) {
            this.mobileNumber = mobileNumber;
            notifyPropertyChanged(BR.mobileNumber);
        }
    }
}
