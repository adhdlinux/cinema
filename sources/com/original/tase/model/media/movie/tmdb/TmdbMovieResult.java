package com.original.tase.model.media.movie.tmdb;

import java.util.List;

public class TmdbMovieResult {
    private int page;
    private List<ResultsBean> results;
    private int total_pages;
    private int total_results;

    public static class ResultsBean {
        private boolean adult;
        private String backdrop_path;
        private int id;
        private String original_language;
        private String original_title;
        private String overview;
        private String poster_path;
        private String release_date;
        private String title;
        private boolean video;

        public String getBackdrop_path() {
            return this.backdrop_path;
        }

        public int getId() {
            return this.id;
        }

        public String getOriginal_language() {
            return this.original_language;
        }

        public String getOriginal_title() {
            return this.original_title;
        }

        public String getOverview() {
            return this.overview;
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

        public void setId(int i2) {
            this.id = i2;
        }

        public void setOriginal_language(String str) {
            this.original_language = str;
        }

        public void setOriginal_title(String str) {
            this.original_title = str;
        }

        public void setOverview(String str) {
            this.overview = str;
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
