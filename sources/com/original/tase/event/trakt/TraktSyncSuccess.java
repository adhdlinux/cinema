package com.original.tase.event.trakt;

public class TraktSyncSuccess extends TraktSyncEvent {
    private TraktSyncSuccess() {
    }

    public TraktSyncSuccess(TraktSyncType traktSyncType) {
        this.f33807a = traktSyncType;
    }
}
