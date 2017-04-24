package com.example.android.firebaserecyclerview;

/**
 * Created by ccteuser on 4/18/17.
 */

public class SchoolOfEducation {

    public String id;
    public String name;
    public int totalEnrollment;
    public int yearOfFoundation;

    public SchoolOfEducation(String id, String name, int totalEnrollment, int yearOfFoundation) {
        this.id = id;
        this.name = name;
        this.totalEnrollment = totalEnrollment;
        this.yearOfFoundation = yearOfFoundation;
    }

    public SchoolOfEducation(String name, int totalEnrollment, int yearOfFoundation) {
        this.name = name;
        this.totalEnrollment = totalEnrollment;
        this.yearOfFoundation = yearOfFoundation;
    }
}