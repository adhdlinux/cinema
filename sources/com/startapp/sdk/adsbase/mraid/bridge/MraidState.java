package com.startapp.sdk.adsbase.mraid.bridge;

public enum MraidState {
    LOADING,
    DEFAULT,
    EXPANDED,
    RESIZED,
    HIDDEN;

    public String toString() {
        return name().toLowerCase();
    }
}
