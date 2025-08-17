package com.movie.data.model.tmvdb;

import com.database.entitys.MovieEntity;
import com.movie.data.model.MovieConverter;
import java.util.List;

public class ExternalTV {
    private List<?> movie_results;
    private List<?> person_results;
    private List<?> tv_episode_results;
    private List<TvResultsBean> tv_results;
    private List<?> tv_season_results;

    public static class TvResultsBean implements MovieConverter {
        private String backdrop_path;
        private String first_air_date;
        private List<Integer> genre_ids;
        private int id;
        private String name;
        private List<String> origin_country;
        private String original_language;
        private String original_name;
        private String overview;
        private double popularity;
        private String poster_path;
        private double vote_average;
        private int vote_count;

        public MovieEntity convert() {
            MovieEntity movieEntity = new MovieEntity();
            movieEntity.setTmdbID((long) getId());
            movieEntity.setPoster_path(getPoster_path());
            movieEntity.setBackdrop_path(getBackdrop_path());
            movieEntity.setName(getName());
            movieEntity.setRealeaseDate(getFirst_air_date());
            movieEntity.setOverview(getOverview());
            movieEntity.setVote(Double.valueOf(getVote_average()));
            movieEntity.setTV(Boolean.TRUE);
            return movieEntity;
        }

        public String getBackdrop_path() {
            return this.backdrop_path;
        }

        public String getFirst_air_date() {
            return this.first_air_date;
        }

        public List<Integer> getGenre_ids() {
            return this.genre_ids;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public List<String> getOrigin_country() {
            return this.origin_country;
        }

        public String getOriginal_language() {
            return this.original_language;
        }

        public String getOriginal_name() {
            return this.original_name;
        }

        public String getOverview() {
            return this.overview;
        }

        public double getPopularity() {
            return this.popularity;
        }

        public String getPoster_path() {
            return this.poster_path;
        }

        public double getVote_average() {
            return this.vote_average;
        }

        public int getVote_count() {
            return this.vote_count;
        }

        public void setBackdrop_path(String str) {
            this.backdrop_path = str;
        }

        public void setFirst_air_date(String str) {
            this.first_air_date = str;
        }

        public void setGenre_ids(List<Integer> list) {
            this.genre_ids = list;
        }

        public void setId(int i2) {
            this.id = i2;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setOrigin_country(List<String> list) {
            this.origin_country = list;
        }

        public void setOriginal_language(String str) {
            this.original_language = str;
        }

        public void setOriginal_name(String str) {
            this.original_name = str;
        }

        public void setOverview(String str) {
            this.overview = str;
        }

        public void setPopularity(double d2) {
            this.popularity = d2;
        }

        public void setPoster_path(String str) {
            this.poster_path = str;
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

    public List<?> getTv_episode_results() {
        return this.tv_episode_results;
    }

    public List<TvResultsBean> getTv_results() {
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

    public void setTv_episode_results(List<?> list) {
        this.tv_episode_results = list;
    }

    public void setTv_results(List<TvResultsBean> list) {
        this.tv_results = list;
    }

    public void setTv_season_results(List<?> list) {
        this.tv_season_results = list;
    }
}
