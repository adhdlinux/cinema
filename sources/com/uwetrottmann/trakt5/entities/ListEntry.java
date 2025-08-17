package com.uwetrottmann.trakt5.entities;

import org.threeten.bp.OffsetDateTime;

public class ListEntry {
    public Episode episode;
    public Long id;
    public OffsetDateTime listed_at;
    public Movie movie;
    public Person person;
    public Integer rank;
    public Show show;
    public String type;
}
