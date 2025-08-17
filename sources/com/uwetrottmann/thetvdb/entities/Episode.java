package com.uwetrottmann.thetvdb.entities;

import java.util.List;

public class Episode {
    public Integer absoluteNumber;
    public Integer airedEpisodeNumber;
    public Integer airedSeason;
    public Integer airedSeasonID;
    public Integer airsAfterSeason;
    public Integer airsBeforeEpisode;
    public Integer airsBeforeSeason;
    public List<String> directors;
    public String dvdChapter;
    public String dvdDiscid;
    public Double dvdEpisodeNumber;
    public Integer dvdSeason;
    public String episodeName;
    public String filename;
    public String firstAired;
    public List<String> guestStars;
    public Integer id;
    public String imdbId;
    public Translations language;
    public Long lastUpdated;
    public Integer lastUpdatedBy;
    public String overview;
    public String productionCode;
    public Integer seriesId;
    public String showUrl;
    public Double siteRating;
    public Integer siteRatingCount;
    public String thumbAdded;
    public Integer thumbAuthor;
    public String thumbHeight;
    public String thumbWidth;
    public List<String> writers;

    public static class Translations {
        public String episodeName;
        public String overview;
    }
}
