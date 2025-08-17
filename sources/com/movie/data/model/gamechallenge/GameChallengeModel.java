package com.movie.data.model.gamechallenge;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GameChallengeModel {

    /* renamed from: android  reason: collision with root package name */
    private List<AndroidBean> f31944android;

    public static class AndroidBean {
        private String description;
        private String icon;
        private String name;
        @SerializedName("package")
        private String packageX;
        private String secret;

        public String getDescription() {
            return this.description;
        }

        public String getIcon() {
            return this.icon;
        }

        public String getName() {
            return this.name;
        }

        public String getPackageX() {
            return this.packageX;
        }

        public String getSecret() {
            return this.secret;
        }

        public void setDescription(String str) {
            this.description = str;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPackageX(String str) {
            this.packageX = str;
        }

        public void setSecret(String str) {
            this.secret = str;
        }
    }

    public List<AndroidBean> getAndroid() {
        return this.f31944android;
    }

    public void setAndroid(List<AndroidBean> list) {
        this.f31944android = list;
    }
}
