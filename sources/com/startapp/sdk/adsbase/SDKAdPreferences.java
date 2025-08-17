package com.startapp.sdk.adsbase;

import java.io.Serializable;

public class SDKAdPreferences implements Serializable {
    private static final long serialVersionUID = 1;
    private String age = null;
    private Gender gender = null;

    public enum Gender {
        MALE("m"),
        FEMALE("f");
        
        private String gender;

        private Gender(String str) {
            this.gender = str;
        }

        public static Gender parseString(String str) {
            Gender[] values = values();
            for (int i2 = 0; i2 < 2; i2++) {
                Gender gender2 = values[i2];
                if (gender2.getGender().equals(str)) {
                    return gender2;
                }
            }
            return null;
        }

        public String getGender() {
            return this.gender;
        }

        public String toString() {
            return getGender();
        }
    }

    public String getAge() {
        return this.age;
    }

    public Gender getGender() {
        return this.gender;
    }

    public SDKAdPreferences setAge(int i2) {
        this.age = Integer.toString(i2);
        return this;
    }

    public SDKAdPreferences setGender(Gender gender2) {
        this.gender = gender2;
        return this;
    }

    public String toString() {
        return "SDKAdPreferences [gender=" + this.gender + ", age=" + this.age + "]";
    }

    public SDKAdPreferences setAge(String str) {
        this.age = str;
        return this;
    }
}
