package com.movie.data.model.tmvdb;

import java.util.List;

public class SeasonTMDB {
    private String _id;
    private String air_date;
    private List<EpisodesBean> episodes;
    private int id;
    private String name;
    private String overview;
    private String poster_path;
    private int season_number;

    public static class EpisodesBean {
        private String air_date;
        private List<?> crew;
        private int episode_number;
        private List<?> guest_stars;
        private int id;
        private String name;
        private String overview;
        private Object production_code;
        private int season_number;
        private int show_id;
        private String still_path;
        private double vote_average;
        private int vote_count;

        public String getAir_date() {
            return this.air_date;
        }

        public List<?> getCrew() {
            return this.crew;
        }

        public int getEpisode_number() {
            return this.episode_number;
        }

        public List<?> getGuest_stars() {
            return this.guest_stars;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getOverview() {
            return this.overview;
        }

        public Object getProduction_code() {
            return this.production_code;
        }

        public int getSeason_number() {
            return this.season_number;
        }

        public int getShow_id() {
            return this.show_id;
        }

        public String getStill_path() {
            return this.still_path;
        }

        public double getVote_average() {
            return this.vote_average;
        }

        public int getVote_count() {
            return this.vote_count;
        }

        public void setAir_date(String str) {
            this.air_date = str;
        }

        public void setCrew(List<?> list) {
            this.crew = list;
        }

        public void setEpisode_number(int i2) {
            this.episode_number = i2;
        }

        public void setGuest_stars(List<?> list) {
            this.guest_stars = list;
        }

        public void setId(int i2) {
            this.id = i2;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setOverview(String str) {
            this.overview = str;
        }

        public void setProduction_code(Object obj) {
            this.production_code = obj;
        }

        public void setSeason_number(int i2) {
            this.season_number = i2;
        }

        public void setShow_id(int i2) {
            this.show_id = i2;
        }

        public void setStill_path(String str) {
            this.still_path = str;
        }

        public void setVote_average(double d2) {
            this.vote_average = d2;
        }

        public void setVote_count(int i2) {
            this.vote_count = i2;
        }
    }

    public String getAir_date() {
        return this.air_date;
    }

    public List<EpisodesBean> getEpisodes() {
        return this.episodes;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getOverview() {
        return this.overview;
    }

    public String getPoster_path() {
        return this.poster_path;
    }

    public int getSeason_number() {
        return this.season_number;
    }

    public String get_id() {
        return this._id;
    }

    public void setAir_date(String str) {
        this.air_date = str;
    }

    public void setEpisodes(List<EpisodesBean> list) {
        this.episodes = list;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOverview(String str) {
        this.overview = str;
    }

    public void setPoster_path(String str) {
        this.poster_path = str;
    }

    public void setSeason_number(int i2) {
        this.season_number = i2;
    }

    public void set_id(String str) {
        this._id = str;
    }
}
