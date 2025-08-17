package com.uwetrottmann.trakt5.entities;

import java.util.List;
import org.threeten.bp.OffsetDateTime;

public class Season {
    public Integer aired_episodes;
    public Integer episode_count;
    public List<Episode> episodes;
    public OffsetDateTime first_aired;
    public SeasonIds ids;
    public String network;
    public Integer number;
    public String overview;
    public Double rating;
    public String title;
    public Integer votes;
}
