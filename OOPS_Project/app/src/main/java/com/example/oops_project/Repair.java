package com.example.oops_project;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;

import androidx.room.PrimaryKey;
import androidx.room.Entity;

import static android.app.Activity.RESULT_OK;

@Entity(tableName = "repair_table")
public class Repair {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private String priority;
    private int priorityNumber;
    private String date;
    private String time;

    public Repair(String title, String description, String priority, int priorityNumber, String date, String time) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.priorityNumber = priorityNumber;
        this.date = date;
        this.time = time;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getPriorityNumber() {
        return priorityNumber;
    }

    public void setPriorityNumber(int priorityNumber) {
        this.priorityNumber = priorityNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
