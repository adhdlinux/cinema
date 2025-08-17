package com.original.tase.model.socket;

import com.google.gson.Gson;

public class ClientObject {
    private boolean ishsl;
    private String originalLink;
    private String player;
    private String streamlink;
    private double timeplay;
    private String title;
    private boolean useheader;
    private String useragent;

    public ClientObject(String str, String str2, boolean z2, String str3, double d2, String str4, String str5, boolean z3) {
        this.player = str;
        this.streamlink = str2;
        this.ishsl = z2;
        this.title = str3;
        this.timeplay = d2;
        this.originalLink = str4;
        this.useragent = str5;
        this.useheader = z3;
    }

    public String getFilename() {
        return this.title;
    }

    public String getOriginalLink() {
        return this.originalLink;
    }

    public String getPlayer() {
        return this.player;
    }

    public String getStreamlink() {
        return this.streamlink;
    }

    public double getTimeplay() {
        return this.timeplay;
    }

    public String getTitle() {
        return this.title;
    }

    public String getuseragent() {
        return this.useragent;
    }

    public boolean isIsHSL() {
        return this.ishsl;
    }

    public boolean isUseheader() {
        return this.useheader;
    }

    public boolean ishsl() {
        return this.ishsl;
    }

    public void setFilename(String str) {
        this.title = str;
    }

    public void setHSL(boolean z2) {
        this.ishsl = z2;
    }

    public void setIsHSL(boolean z2) {
        this.ishsl = z2;
    }

    public void setOriginalLink(String str) {
        this.originalLink = str;
    }

    public void setPlayer(String str) {
        this.player = str;
    }

    public void setStreamlink(String str) {
        this.streamlink = str;
    }

    public void setTimeplay(double d2) {
        this.timeplay = d2;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUseheader(boolean z2) {
        this.useheader = z2;
    }

    public void setuseragent(String str) {
        this.useragent = str;
    }

    public String toString() {
        return new Gson().u(this);
    }
}
