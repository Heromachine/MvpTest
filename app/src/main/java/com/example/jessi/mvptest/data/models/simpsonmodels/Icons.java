package com.example.jessi.mvptest.data.models.simpsonmodels;

import com.google.gson.annotations.SerializedName;

public class Icons {

    @SerializedName("URL")
    private String URL;

    public Icons() {
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
