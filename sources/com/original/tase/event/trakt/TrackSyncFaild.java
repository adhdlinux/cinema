package com.original.tase.event.trakt;

public class TrackSyncFaild extends TraktSyncEvent {
    private TrackSyncFaild() {
    }

    public TrackSyncFaild(TraktSyncType traktSyncType) {
        this.f33807a = traktSyncType;
    }
}
