package com.uwetrottmann.trakt5.entities;

import com.google.gson.annotations.SerializedName;
import com.uwetrottmann.trakt5.enums.Audio;
import com.uwetrottmann.trakt5.enums.AudioChannels;
import com.uwetrottmann.trakt5.enums.Hdr;
import com.uwetrottmann.trakt5.enums.MediaType;
import com.uwetrottmann.trakt5.enums.Rating;
import com.uwetrottmann.trakt5.enums.Resolution;
import org.threeten.bp.OffsetDateTime;

public class SyncMovie {
    public Audio audio;
    public AudioChannels audio_channels;
    public OffsetDateTime collected_at;
    public Hdr hdr;
    public MovieIds ids;
    @SerializedName("3d")
    public Boolean is3d;
    public MediaType media_type;
    public OffsetDateTime rated_at;
    public Rating rating;
    public Resolution resolution;
    public OffsetDateTime watched_at;

    public SyncMovie audio(Audio audio2) {
        this.audio = audio2;
        return this;
    }

    public SyncMovie audioChannels(AudioChannels audioChannels) {
        this.audio_channels = audioChannels;
        return this;
    }

    public SyncMovie collectedAt(OffsetDateTime offsetDateTime) {
        this.collected_at = offsetDateTime;
        return this;
    }

    public SyncMovie hdr(Hdr hdr2) {
        this.hdr = hdr2;
        return this;
    }

    public SyncMovie id(MovieIds movieIds) {
        this.ids = movieIds;
        return this;
    }

    public SyncMovie is3d(Boolean bool) {
        this.is3d = bool;
        return this;
    }

    public SyncMovie mediaType(MediaType mediaType) {
        this.media_type = mediaType;
        return this;
    }

    public SyncMovie ratedAt(OffsetDateTime offsetDateTime) {
        this.rated_at = offsetDateTime;
        return this;
    }

    public SyncMovie rating(Rating rating2) {
        this.rating = rating2;
        return this;
    }

    public SyncMovie resolution(Resolution resolution2) {
        this.resolution = resolution2;
        return this;
    }

    public SyncMovie watchedAt(OffsetDateTime offsetDateTime) {
        this.watched_at = offsetDateTime;
        return this;
    }
}
