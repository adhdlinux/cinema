package com.uwetrottmann.trakt5.entities;

public class ScrobbleProgress extends GenericProgress {
    public String app_date;
    public String app_version;

    private ScrobbleProgress(String str, String str2) {
        this.app_version = str;
        this.app_date = str2;
    }

    public ScrobbleProgress(SyncEpisode syncEpisode, double d2, String str, String str2) {
        this(str, str2);
        this.episode = syncEpisode;
        this.progress = Double.valueOf(d2);
    }

    public ScrobbleProgress(SyncMovie syncMovie, double d2, String str, String str2) {
        this(str, str2);
        this.movie = syncMovie;
        this.progress = Double.valueOf(d2);
    }
}
