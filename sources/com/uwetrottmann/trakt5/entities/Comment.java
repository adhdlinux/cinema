package com.uwetrottmann.trakt5.entities;

import org.threeten.bp.OffsetDateTime;

public class Comment {
    public String comment;
    public OffsetDateTime created_at;
    public Episode episode;
    public Integer id;
    public Integer likes;
    public Movie movie;
    public Integer parent_id;
    public Integer replies;
    public Boolean review;
    public Show show;
    public Boolean spoiler;
    public OffsetDateTime updated_at;
    public User user;
    public Integer user_rating;

    public Comment() {
    }

    public Comment(Movie movie2, String str, boolean z2, boolean z3) {
        this(str, z2, z3);
        this.movie = movie2;
    }

    public Comment(Show show2, String str, boolean z2, boolean z3) {
        this(str, z2, z3);
        this.show = show2;
    }

    public Comment(Episode episode2, String str, boolean z2, boolean z3) {
        this(str, z2, z3);
        this.episode = episode2;
    }

    public Comment(String str, boolean z2, boolean z3) {
        this.comment = str;
        this.spoiler = Boolean.valueOf(z2);
        this.review = Boolean.valueOf(z3);
    }
}
