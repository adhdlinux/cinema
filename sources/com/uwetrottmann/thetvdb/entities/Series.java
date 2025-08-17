package com.uwetrottmann.thetvdb.entities;

import java.util.ArrayList;
import java.util.List;

public class Series {
    public String added;
    public Integer addedBy;
    public String airsDayOfWeek;
    public String airsTime;
    public List<String> aliases = new ArrayList();
    public String banner;
    public String firstAired;
    public List<String> genre = new ArrayList();
    public Integer id;
    public String imdbId;
    public Long lastUpdated;
    public String network;
    public String networkId;
    public String overview;
    public String rating;
    public String runtime;
    public String seriesName;
    public Double siteRating;
    public Integer siteRatingCount;
    public String slug;
    public String status;
    public String zap2itId;
}
