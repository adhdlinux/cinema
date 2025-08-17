package com.uwetrottmann.thetvdb.entities;

public class SeriesImageQueryResult {
    public String fileName;
    public int id;
    public String keyType;
    public Integer languageId;
    public RatingsInfo ratingsInfo;
    public String resolution;
    public String subKey;
    public String thumbnail;

    public class RatingsInfo {
        public Double average;
        public Integer count;

        public RatingsInfo() {
        }
    }
}
