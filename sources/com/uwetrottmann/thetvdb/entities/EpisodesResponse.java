package com.uwetrottmann.thetvdb.entities;

import java.util.List;

public class EpisodesResponse extends ErrorResponse {
    public List<Episode> data;
    public Links links;
}
