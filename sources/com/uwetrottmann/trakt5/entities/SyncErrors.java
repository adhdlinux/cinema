package com.uwetrottmann.trakt5.entities;

import java.util.List;

public class SyncErrors {
    public List<SyncEpisode> episodes;
    public List<Long> ids;
    public List<SyncMovie> movies;
    public List<SyncPerson> people;
    public List<SyncSeason> seasons;
    public List<SyncShow> shows;
}
