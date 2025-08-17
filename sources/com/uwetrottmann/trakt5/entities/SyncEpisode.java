package com.uwetrottmann.trakt5.entities;

import com.google.gson.annotations.SerializedName;
import com.uwetrottmann.trakt5.enums.Audio;
import com.uwetrottmann.trakt5.enums.AudioChannels;
import com.uwetrottmann.trakt5.enums.Hdr;
import com.uwetrottmann.trakt5.enums.MediaType;
import com.uwetrottmann.trakt5.enums.Rating;
import com.uwetrottmann.trakt5.enums.Resolution;
import org.threeten.bp.OffsetDateTime;

public class SyncEpisode {
    public Audio audio;
    public AudioChannels audio_channels;
    public OffsetDateTime collected_at;
    public Hdr hdr;
    public EpisodeIds ids;
    @SerializedName("3d")
    public Boolean is3d;
    public MediaType media_type;
    public Integer number;
    public OffsetDateTime rated_at;
    public Rating rating;
    public Resolution resolution;
    public Integer season;
    public OffsetDateTime watched_at;

    public SyncEpisode audio(Audio audio2) {
        this.audio = audio2;
        return this;
    }

    public SyncEpisode audioChannels(AudioChannels audioChannels) {
        this.audio_channels = audioChannels;
        return this;
    }

    public SyncEpisode collectedAt(OffsetDateTime offsetDateTime) {
        this.collected_at = offsetDateTime;
        return this;
    }

    public SyncEpisode hdr(Hdr hdr2) {
        this.hdr = hdr2;
        return this;
    }

    public SyncEpisode id(EpisodeIds episodeIds) {
        this.ids = episodeIds;
        return this;
    }

    public SyncEpisode is3d(Boolean bool) {
        this.is3d = bool;
        return this;
    }

    public SyncEpisode mediaType(MediaType mediaType) {
        this.media_type = mediaType;
        return this;
    }

    public SyncEpisode number(int i2) {
        this.number = Integer.valueOf(i2);
        return this;
    }

    public SyncEpisode ratedAt(OffsetDateTime offsetDateTime) {
        this.rated_at = offsetDateTime;
        return this;
    }

    public SyncEpisode rating(Rating rating2) {
        this.rating = rating2;
        return this;
    }

    public SyncEpisode resolution(Resolution resolution2) {
        this.resolution = resolution2;
        return this;
    }

    public SyncEpisode season(int i2) {
        this.season = Integer.valueOf(i2);
        return this;
    }

    public SyncEpisode watchedAt(OffsetDateTime offsetDateTime) {
        this.watched_at = offsetDateTime;
        return this;
    }
}
