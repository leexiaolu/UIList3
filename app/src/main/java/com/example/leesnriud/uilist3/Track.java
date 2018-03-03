package com.example.leesnriud.uilist3;

/**
 * Created by lee.snriud on 2018/3/3.
 */

public class Track {

    private int track_icon;
    private  String track_name;

    public Track(){

    }

    public Track(int track_icon, String track_name) {
        this.track_icon = track_icon;
        this.track_name = track_name;
    }

    public int getTrack_icon() {
        return track_icon;
    }

    public void setTrack_icon(int track_icon) {
        this.track_icon = track_icon;
    }

    public String getTrack_name() {
        return track_name;
    }

    public void setTrack_name(String track_name) {
        this.track_name = track_name;
    }


}
