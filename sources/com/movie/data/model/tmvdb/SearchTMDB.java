package com.movie.data.model.tmvdb;

import com.database.entitys.MovieEntity;
import com.movie.data.model.MovieConverter;
import java.util.List;

public class SearchTMDB {
    private int page;
    private List<ResultsBean> results;
    private int total_pages;
    private int total_results;

    public static class ResultsBean implements MovieConverter {
        private boolean adult;
        private String backdrop_path;
        private String first_air_date;
        private List<Integer> genre_ids;
        private int id;
        private String media_type;
        private String name;
        private List<String> origin_country;
        private String original_language;
        private String original_name;
        private String original_title;
        private String overview;
        private double popularity;
        private String poster_path;
        private String release_date;
        private String title;
        private boolean video;
        private double vote_average;
        private int vote_count;

        public MovieEntity convert() {
            if (getMedia_type().equals("tv")) {
                if (getFirst_air_date() == null || getPoster_path() == null) {
                    return null;
                }
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
            } else if (getRelease_date() == null || getPoster_path() == null) {
                return null;
            } else {
                MovieEntity movieEntity2 = new MovieEntity();
                movieEntity2.setTmdbID((long) getId());
                movieEntity2.setPoster_path(getPoster_path());
                movieEntity2.setBackdrop_path(getBackdrop_path());
                movieEntity2.setName(getTitle());
                movieEntity2.setRealeaseDate(getRelease_date());
                movieEntity2.setOverview(getOverview());
                movieEntity2.setVote(Double.valueOf(getVote_average()));
                movieEntity2.setTV(Boolean.FALSE);
                return movieEntity2;
            }
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

        public String getMedia_type() {
            return this.media_type;
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

        public String getOriginal_title() {
            return this.original_title;
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

        public String getRelease_date() {
            return this.release_date;
        }

        public String getTitle() {
            return this.title;
        }

        public double getVote_average() {
            return this.vote_average;
        }

        public int getVote_count() {
            return this.vote_count;
        }

        public boolean isAdult() {
            return this.adult;
        }

        public boolean isVideo() {
            return this.video;
        }

        public void setAdult(boolean z2) {
            this.adult = z2;
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

        public void setMedia_type(String str) {
            this.media_type = str;
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

        public void setOriginal_title(String str) {
            this.original_title = str;
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

        public void setRelease_date(String str) {
            this.release_date = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setVideo(boolean z2) {
            this.video = z2;
        }

        public void setVote_average(double d2) {
            this.vote_average = d2;
        }

        public void setVote_count(int i2) {
            this.vote_count = i2;
        }
    }

    public int getPage() {
        return this.page;
    }

    public List<ResultsBean> getResults() {
        return this.results;
    }

    public int getTotal_pages() {
        return this.total_pages;
    }

    public int getTotal_results() {
        return this.total_results;
    }

    public void setPage(int i2) {
        this.page = i2;
    }

    public void setResults(List<ResultsBean> list) {
        this.results = list;
    }

    public void setTotal_pages(int i2) {
        this.total_pages = i2;
    }

    public void setTotal_results(int i2) {
        this.total_results = i2;
    }
}
