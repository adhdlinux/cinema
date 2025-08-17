package com.movie.data.model.premiumize;

import java.util.List;

public class FolderList {
    private List<BreadcrumbsBean> breadcrumbs;
    private List<ContentBean> content;
    private String folder_id;
    private String name;
    private String parent_id;
    private String status;

    public static class BreadcrumbsBean {
        private String id;
        private String name;

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public static class ContentBean {
        private int created_at;
        private String id;
        private String ip;
        private String link;
        private String mime_type;
        private String name;
        private String resx;
        private long size;
        private String stream_link;
        private String transcode_status;
        private String type;
        private String vcodec;
        private String virus_scan;

        public int getCreated_at() {
            return this.created_at;
        }

        public String getId() {
            return this.id;
        }

        public String getIp() {
            return this.ip;
        }

        public String getLink() {
            return this.link;
        }

        public String getMime_type() {
            return this.mime_type;
        }

        public String getName() {
            return this.name;
        }

        public String getResx() {
            return this.resx;
        }

        public long getSize() {
            return this.size;
        }

        public String getStream_link() {
            return this.stream_link;
        }

        public String getTranscode_status() {
            return this.transcode_status;
        }

        public String getType() {
            return this.type;
        }

        public String getVcodec() {
            return this.vcodec;
        }

        public String getVirus_scan() {
            return this.virus_scan;
        }

        public void setCreated_at(int i2) {
            this.created_at = i2;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setIp(String str) {
            this.ip = str;
        }

        public void setLink(String str) {
            this.link = str;
        }

        public void setMime_type(String str) {
            this.mime_type = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setResx(String str) {
            this.resx = str;
        }

        public void setSize(long j2) {
            this.size = j2;
        }

        public void setStream_link(String str) {
            this.stream_link = str;
        }

        public void setTranscode_status(String str) {
            this.transcode_status = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setVcodec(String str) {
            this.vcodec = str;
        }

        public void setVirus_scan(String str) {
            this.virus_scan = str;
        }
    }

    public List<BreadcrumbsBean> getBreadcrumbs() {
        return this.breadcrumbs;
    }

    public List<ContentBean> getContent() {
        return this.content;
    }

    public String getFolder_id() {
        return this.folder_id;
    }

    public String getName() {
        return this.name;
    }

    public String getParent_id() {
        return this.parent_id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setBreadcrumbs(List<BreadcrumbsBean> list) {
        this.breadcrumbs = list;
    }

    public void setContent(List<ContentBean> list) {
        this.content = list;
    }

    public void setFolder_id(String str) {
        this.folder_id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setParent_id(String str) {
        this.parent_id = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
