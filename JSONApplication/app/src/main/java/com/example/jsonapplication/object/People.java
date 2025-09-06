package com.example.jsonapplication.object;

import com.google.gson.annotations.SerializedName;

public class People {

    @SerializedName("name")
    private String mName;

    @SerializedName("email")
    private String mEmail;

    @SerializedName("age")
    private int age;

    Cours cours;

    public People(String mName, String mEmail, int age, Cours cours) {
        this.mName = mName;
        this.mEmail = mEmail;
        this.age = age;
        this.cours = cours;
    }

    @Override
    public String toString() {
        return "People{" +
                "mName='" + mName + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", age=" + age +
                ", cours=" + cours +
                '}';
    }
}
