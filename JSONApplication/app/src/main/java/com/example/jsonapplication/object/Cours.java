package com.example.jsonapplication.object;

import com.google.gson.annotations.SerializedName;

public class Cours {

    @SerializedName("course_name")
    private String courseName;

    @SerializedName("price")
    private int mPrice;

    public Cours(String courseName, int mPrice) {
        this.courseName = courseName;
        this.mPrice = mPrice;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "courseName='" + courseName + '\'' +
                ", mPrice=" + mPrice +
                '}';
    }
}
