package com.example.finalproject;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("image")
    private String image;

    @SerializedName("text")
    private String text;

    @SerializedName("published_date")
    private String published_date;

    @SerializedName("title")
    private String title;

    @SerializedName("created_date")
    private String created_date;

    public String getimg(){
        return image;
    }

    public String gettext(){
        return text;
    }

    public String getdate(){
        return published_date;
    }

    public String gettitle(){
        return title;
    }

    public String getcdate(){
        return created_date;
    }


}
