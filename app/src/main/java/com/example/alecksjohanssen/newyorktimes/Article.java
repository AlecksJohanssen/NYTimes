package com.example.alecksjohanssen.newyorktimes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by AlecksJohanssen on 3/16/2016.
 */
public class Article implements Serializable{
    String webUrl;

    public String getWebUrl() {
        return webUrl;
    }

    public String getHeadLine() {
        return headLine;
    }

    public String getThumbNail() {
        return thumbNail;
    }

    String headLine;
    String thumbNail;

    public Article(JSONObject jsonObject) {
        try {
            this.webUrl = jsonObject.getString("web_url");
            this.headLine = jsonObject.getJSONObject("headline").getString("main");
            JSONArray multimedia = jsonObject.getJSONArray("multimedia");
            if (multimedia.length() > 0) {
                JSONObject multimediaJSon = multimedia.getJSONObject(0);
                this.thumbNail = "http://www.nytimes.com/" + multimediaJSon.getString("url");
            } else {
                this.thumbNail = "";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Article> fromJSONArray(JSONArray array) {
        ArrayList<Article> results = new ArrayList<>();
        {

            for (int x = 0; x < array.length(); x++)
                try {
                    results.add(new Article(array.getJSONObject(x)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            return results;
        }
    }
}