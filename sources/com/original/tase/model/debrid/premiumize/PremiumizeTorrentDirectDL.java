package com.original.tase.model.debrid.premiumize;

import java.util.List;

public class PremiumizeTorrentDirectDL {
    private List<ContentBean> content;
    private String status;

    public static class ContentBean {
        private String link;
        private String path;
        private String size;
        private String stream_link;
        private String transcode_status;

        public String getLink() {
            return this.link;
        }

        public String getPath() {
            return this.path;
        }

        public String getSize() {
            return this.size;
        }

        public String getStream_link() {
            return this.stream_link;
        }

        public String getTranscode_status() {
            return this.transcode_status;
        }

        public void setLink(String str) {
            this.link = str;
        }

        public void setPath(String str) {
            this.path = str;
        }

        public void setSize(String str) {
            this.size = str;
        }

        public void setStream_link(String str) {
            this.stream_link = str;
        }

        public void setTranscode_status(String str) {
            this.transcode_status = str;
        }
    }

    public List<ContentBean> getContent() {
        return this.content;
    }

    public String getStatus() {
        return this.status;
    }

    public void setContent(List<ContentBean> list) {
        this.content = list;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
