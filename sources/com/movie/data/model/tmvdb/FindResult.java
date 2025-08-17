package com.movie.data.model.tmvdb;

import java.util.List;

public class FindResult {
    private List<?> movie_results;
    private List<?> person_results;
    private List<TvEpisodeResultsBean> tv_episode_results;
    private List<?> tv_results;
    private List<?> tv_season_results;

    public static class TvEpisodeResultsBean {
        private String air_date;
        private int episode_number;
        private long id;
        private String name;
        private String overview;
        private String production_code;
        private int season_number;
        private long show_id;
        private String still_path;
        private double vote_average;
        private int vote_count;

        public String getAir_date() {
            return this.air_date;
        }

        public int getEpisode_number() {
            return this.episode_number;
        }

        public long getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getOverview() {
            return this.overview;
        }

        public String getProduction_code() {
            return this.production_code;
        }

        public int getSeason_number() {
            return this.season_number;
        }

        public long getShow_id() {
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

        public void setEpisode_number(int i2) {
            this.episode_number = i2;
        }

        public void setId(long j2) {
            this.id = j2;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setOverview(String str) {
            this.overview = str;
        }

        public void setProduction_code(String str) {
            this.production_code = str;
        }

        public void setSeason_number(int i2) {
            this.season_number = i2;
        }

        public void setShow_id(long j2) {
            this.show_id = j2;
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

    public List<?> getMovie_results() {
        return this.movie_results;
    }

    public List<?> getPerson_results() {
        return this.person_results;
    }

    public List<TvEpisodeResultsBean> getTv_episode_results() {
        return this.tv_episode_results;
    }

    public List<?> getTv_results() {
        return this.tv_results;
    }

    public List<?> getTv_season_results() {
        return this.tv_season_results;
    }

    public void setMovie_results(List<?> list) {
        this.movie_results = list;
    }

    public void setPerson_results(List<?> list) {
        this.person_results = list;
    }

    public void setTv_episode_results(List<TvEpisodeResultsBean> list) {
        this.tv_episode_results = list;
    }

    public void setTv_results(List<?> list) {
        this.tv_results = list;
    }

    public void setTv_season_results(List<?> list) {
        this.tv_season_results = list;
    }
}
