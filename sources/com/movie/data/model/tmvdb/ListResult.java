package com.movie.data.model.tmvdb;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ListResult {
    private double average_rating;
    private Object backdrop_path;
    private CommentsBean comments;
    private CreatedByBean created_by;
    private String description;
    private int id;
    private String iso_3166_1;
    private String iso_639_1;
    private String name;
    private ObjectIdsBean object_ids;
    private int page;
    private Object poster_path;
    @SerializedName("public")
    private boolean publicX;
    private List<ResultsBean> results;
    private int revenue;
    private int runtime;
    private String sort_by;
    private int total_pages;
    private int total_results;

    public static class CommentsBean {
    }

    public static class CreatedByBean {
        private String gravatar_hash;
        private String id;
        private String name;
        private String username;

        public String getGravatar_hash() {
            return this.gravatar_hash;
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getUsername() {
            return this.username;
        }

        public void setGravatar_hash(String str) {
            this.gravatar_hash = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setUsername(String str) {
            this.username = str;
        }
    }

    public static class ObjectIdsBean {
    }

    public static class ResultsBean {
        private String backdrop_path;
        private String first_air_date;
        private List<Integer> genre_ids;
        private int id;
        private String media_type;
        private String name;
        private List<String> origin_country;
        private String original_language;
        private String original_name;
        private String overview;
        private double popularity;
        private String poster_path;
        private double vote_average;
        private int vote_count;

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

    public double getAverage_rating() {
        return this.average_rating;
    }

    public Object getBackdrop_path() {
        return this.backdrop_path;
    }

    public CommentsBean getComments() {
        return this.comments;
    }

    public CreatedByBean getCreated_by() {
        return this.created_by;
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return this.id;
    }

    public String getIso_3166_1() {
        return this.iso_3166_1;
    }

    public String getIso_639_1() {
        return this.iso_639_1;
    }

    public String getName() {
        return this.name;
    }

    public ObjectIdsBean getObject_ids() {
        return this.object_ids;
    }

    public int getPage() {
        return this.page;
    }

    public Object getPoster_path() {
        return this.poster_path;
    }

    public List<ResultsBean> getResults() {
        return this.results;
    }

    public int getRevenue() {
        return this.revenue;
    }

    public int getRuntime() {
        return this.runtime;
    }

    public String getSort_by() {
        return this.sort_by;
    }

    public int getTotal_pages() {
        return this.total_pages;
    }

    public int getTotal_results() {
        return this.total_results;
    }

    public boolean isPublicX() {
        return this.publicX;
    }

    public void setAverage_rating(double d2) {
        this.average_rating = d2;
    }

    public void setBackdrop_path(Object obj) {
        this.backdrop_path = obj;
    }

    public void setComments(CommentsBean commentsBean) {
        this.comments = commentsBean;
    }

    public void setCreated_by(CreatedByBean createdByBean) {
        this.created_by = createdByBean;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setIso_3166_1(String str) {
        this.iso_3166_1 = str;
    }

    public void setIso_639_1(String str) {
        this.iso_639_1 = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setObject_ids(ObjectIdsBean objectIdsBean) {
        this.object_ids = objectIdsBean;
    }

    public void setPage(int i2) {
        this.page = i2;
    }

    public void setPoster_path(Object obj) {
        this.poster_path = obj;
    }

    public void setPublicX(boolean z2) {
        this.publicX = z2;
    }

    public void setResults(List<ResultsBean> list) {
        this.results = list;
    }

    public void setRevenue(int i2) {
        this.revenue = i2;
    }

    public void setRuntime(int i2) {
        this.runtime = i2;
    }

    public void setSort_by(String str) {
        this.sort_by = str;
    }

    public void setTotal_pages(int i2) {
        this.total_pages = i2;
    }

    public void setTotal_results(int i2) {
        this.total_results = i2;
    }
}
