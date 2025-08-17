package com.original.tase.model.media;

import java.util.List;

public class TmdbVideosBean {
    private List<ResultsBean> results;

    public static class ResultsBean {
        private String id;
        private String iso_3166_1;
        private String iso_639_1;
        private String key;
        private String name;
        private String site;
        private int size;
        private String type;

        public String getId() {
            return this.id;
        }

        public String getIso_3166_1() {
            return this.iso_3166_1;
        }

        public String getIso_639_1() {
            return this.iso_639_1;
        }

        public String getKey() {
            return this.key;
        }

        public String getName() {
            return this.name;
        }

        public String getSite() {
            return this.site;
        }

        public int getSize() {
            return this.size;
        }

        public String getType() {
            return this.type;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setIso_3166_1(String str) {
            this.iso_3166_1 = str;
        }

        public void setIso_639_1(String str) {
            this.iso_639_1 = str;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setSite(String str) {
            this.site = str;
        }

        public void setSize(int i2) {
            this.size = i2;
        }

        public void setType(String str) {
            this.type = str;
        }
    }

    public List<ResultsBean> getResults() {
        return this.results;
    }

    public void setResults(List<ResultsBean> list) {
        this.results = list;
    }
}
