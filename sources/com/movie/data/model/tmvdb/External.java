package com.movie.data.model.tmvdb;

import com.database.entitys.MovieEntity;
import com.movie.data.model.MovieConverter;
import java.util.List;

@Deprecated
public class External {
    private String created_by;
    private String description;
    private int favorite_count;
    private String id;
    private String iso_639_1;
    private int item_count;
    private List<ItemsBean> items;
    private String name;
    private Object poster_path;

    public static class ItemsBean implements MovieConverter {
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
        private double vote_count;

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

        public double getVote_count() {
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

        public void setVote_count(double d2) {
            this.vote_count = d2;
        }
    }

    public String getCreated_by() {
        return this.created_by;
    }

    public String getDescription() {
        return this.description;
    }

    public int getFavorite_count() {
        return this.favorite_count;
    }

    public String getId() {
        return this.id;
    }

    public String getIso_639_1() {
        return this.iso_639_1;
    }

    public int getItem_count() {
        return this.item_count;
    }

    public List<ItemsBean> getItems() {
        return this.items;
    }

    public String getName() {
        return this.name;
    }

    public Object getPoster_path() {
        return this.poster_path;
    }

    public void setCreated_by(String str) {
        this.created_by = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setFavorite_count(int i2) {
        this.favorite_count = i2;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIso_639_1(String str) {
        this.iso_639_1 = str;
    }

    public void setItem_count(int i2) {
        this.item_count = i2;
    }

    public void setItems(List<ItemsBean> list) {
        this.items = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPoster_path(Object obj) {
        this.poster_path = obj;
    }
}
