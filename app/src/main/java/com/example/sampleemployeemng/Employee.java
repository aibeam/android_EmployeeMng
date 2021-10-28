package com.example.sampleemployeemng;

import android.os.Parcel;
import android.os.Parcelable;

public class Employee implements Parcelable {
    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };
    private int id, age;
    private String name, mobile;

    public Employee(int id, String name, int age, String mobile){
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Employee(Parcel p) {
        this.id = p.readInt();
        this.name = p.readString();
        this.age = p.readInt();
        this.mobile = p.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(age);
        dest.writeString(name);
        dest.writeString(mobile);
    }
}