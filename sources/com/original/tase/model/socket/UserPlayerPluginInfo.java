package com.original.tase.model.socket;

public class UserPlayerPluginInfo {
    public String IP;
    public boolean iConnect;
    public String serverIP;
    public String userName;

    public UserPlayerPluginInfo(String str, String str2, boolean z2, String str3) {
        this.IP = str;
        this.iConnect = z2;
        this.serverIP = str2;
        this.userName = str3;
    }

    public UserPlayerPluginInfo(String str, boolean z2) {
        this.IP = str;
        this.iConnect = z2;
        this.userName = "";
    }
}
