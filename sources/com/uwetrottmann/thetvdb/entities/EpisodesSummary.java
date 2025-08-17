package com.uwetrottmann.thetvdb.entities;

import java.util.ArrayList;
import java.util.List;

public class EpisodesSummary {
    public Integer airedEpisodes;
    public List<Integer> airedSeasons = new ArrayList();
    public Integer dvdEpisodes;
    public List<Integer> dvdSeasons = new ArrayList();
}
