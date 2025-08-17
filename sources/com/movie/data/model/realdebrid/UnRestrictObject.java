package com.movie.data.model.realdebrid;

import java.util.List;

public class UnRestrictObject {
    private List<AlternativeBean> alternative;
    private String chunks;
    private String crc;
    private String download;
    private String filename;
    private long filesize;
    private String host;
    private String id;
    private String link;
    private String streamable;
    private String type;

    public static class AlternativeBean {
        private String download;
        private String filename;
        private String id;
        private String type;

        public String getDownload() {
            return this.download;
        }

        public String getFilename() {
            return this.filename;
        }

        public String getId() {
            return this.id;
        }

        public String getType() {
            return this.type;
        }

        public void setDownload(String str) {
            this.download = str;
        }

        public void setFilename(String str) {
            this.filename = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setType(String str) {
            this.type = str;
        }
    }

    public List<AlternativeBean> getAlternative() {
        return this.alternative;
    }

    public String getChunks() {
        return this.chunks;
    }

    public String getCrc() {
        return this.crc;
    }

    public String getDownload() {
        return this.download;
    }

    public String getFilename() {
        return this.filename;
    }

    public long getFilesize() {
        return this.filesize;
    }

    public String getHost() {
        return this.host;
    }

    public String getId() {
        return this.id;
    }

    public String getLink() {
        return this.link;
    }

    public String getStreamable() {
        return this.streamable;
    }

    public String getType() {
        return this.type;
    }

    public void setAlternative(List<AlternativeBean> list) {
        this.alternative = list;
    }

    public void setChunks(String str) {
        this.chunks = str;
    }

    public void setCrc(String str) {
        this.crc = str;
    }

    public void setDownload(String str) {
        this.download = str;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setFilesize(long j2) {
        this.filesize = j2;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setStreamable(String str) {
        this.streamable = str;
    }

    public void setType(String str) {
        this.type = str;
    }
}
