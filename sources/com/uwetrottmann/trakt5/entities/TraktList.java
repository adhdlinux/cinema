package com.uwetrottmann.trakt5.entities;

import com.uwetrottmann.trakt5.enums.ListPrivacy;
import com.uwetrottmann.trakt5.enums.SortBy;
import com.uwetrottmann.trakt5.enums.SortHow;
import org.threeten.bp.OffsetDateTime;

public class TraktList {
    public Boolean allow_comments;
    public Integer comment_count;
    public OffsetDateTime created_at;
    public String description;
    public Boolean display_numbers;
    public ListIds ids;
    public Integer item_count;
    public Integer likes;
    public String name;
    public ListPrivacy privacy;
    public SortBy sort_by;
    public SortHow sort_how;
    public OffsetDateTime updated_at;
    public User user;

    public TraktList allowComments(boolean z2) {
        this.allow_comments = Boolean.valueOf(z2);
        return this;
    }

    public TraktList description(String str) {
        this.description = str;
        return this;
    }

    public TraktList displayNumbers(boolean z2) {
        this.display_numbers = Boolean.valueOf(z2);
        return this;
    }

    public TraktList id(ListIds listIds) {
        this.ids = listIds;
        return this;
    }

    public TraktList name(String str) {
        this.name = str;
        return this;
    }

    public TraktList privacy(ListPrivacy listPrivacy) {
        this.privacy = listPrivacy;
        return this;
    }

    public TraktList sortBy(SortBy sortBy) {
        this.sort_by = sortBy;
        return this;
    }

    public TraktList sortHow(SortHow sortHow) {
        this.sort_how = sortHow;
        return this;
    }
}
