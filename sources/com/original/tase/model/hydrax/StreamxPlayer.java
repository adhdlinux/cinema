package com.original.tase.model.hydrax;

import com.google.gson.annotations.SerializedName;

public class StreamxPlayer {
    private String height;
    private String key;
    private String type;
    private String value;
    private String width;

    public static class TracksBean {
        @SerializedName("default")
        private boolean defaultX;
        private String file;
        private String kind;
        private String label;

        public String getFile() {
            return this.file;
        }

        public String getKind() {
            return this.kind;
        }

        public String getLabel() {
            return this.label;
        }

        public boolean isDefaultX() {
            return this.defaultX;
        }

        public void setDefaultX(boolean z2) {
            this.defaultX = z2;
        }

        public void setFile(String str) {
            this.file = str;
        }

        public void setKind(String str) {
            this.kind = str;
        }

        public void setLabel(String str) {
            this.label = str;
        }
    }

    public String getHeight() {
        return this.height;
    }

    public String getKey() {
        return this.key;
    }

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public String getWidth() {
        return this.width;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public void setWidth(String str) {
        this.width = str;
    }
}
