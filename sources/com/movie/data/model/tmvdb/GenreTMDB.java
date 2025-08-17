package com.movie.data.model.tmvdb;

import com.database.entitys.GenreEntity;
import java.util.List;

public class GenreTMDB {
    private List<GenresBean> genres;

    public static class GenresBean {
        private int id;
        private String name;

        public GenreEntity convertToEntity() {
            GenreEntity genreEntity = new GenreEntity();
            genreEntity.b(getId());
            genreEntity.c(getName());
            return genreEntity;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void setId(int i2) {
            this.id = i2;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public List<GenresBean> getGenres() {
        return this.genres;
    }

    public void setGenres(List<GenresBean> list) {
        this.genres = list;
    }
}
