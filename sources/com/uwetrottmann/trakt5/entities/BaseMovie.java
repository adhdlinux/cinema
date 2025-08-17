package com.uwetrottmann.trakt5.entities;

import org.threeten.bp.OffsetDateTime;

public class BaseMovie {
    public OffsetDateTime collected_at;
    public OffsetDateTime last_updated_at;
    public OffsetDateTime last_watched_at;
    public OffsetDateTime listed_at;
    public Metadata metadata;
    public Movie movie;
    public int plays;
}
