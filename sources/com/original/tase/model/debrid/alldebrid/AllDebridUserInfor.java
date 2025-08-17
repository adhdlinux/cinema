package com.original.tase.model.debrid.alldebrid;

public class AllDebridUserInfor {
    public String avatar;
    public String email;
    public String expiration;
    public Integer id;
    public String locale;
    public Integer points;
    public Integer premium;
    public String type;
    public String username;

    public AllDebridUserInfor(String str, String str2, String str3, Integer num, String str4, Integer num2, Integer num3, String str5, String str6) {
        this.avatar = str;
        this.email = str2;
        this.expiration = str3;
        this.id = num;
        this.locale = str4;
        this.points = num2;
        this.premium = num3;
        this.type = str5;
        this.username = str6;
    }

    public String toString() {
        return "AllDebridUserInfor{avatar='" + this.avatar + '\'' + ", email='" + this.email + '\'' + ", expiration='" + this.expiration + '\'' + ", id=" + this.id + ", locale='" + this.locale + '\'' + ", points=" + this.points + ", premium=" + this.premium + ", type='" + this.type + '\'' + ", username='" + this.username + '\'' + '}';
    }
}
