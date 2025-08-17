package com.iab.omid.library.applovin.adsession.media;

import com.vungle.ads.internal.Constants;

public enum PlayerState {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL("normal"),
    EXPANDED("expanded"),
    FULLSCREEN(Constants.TEMPLATE_TYPE_FULLSCREEN);
    
    private final String playerState;

    private PlayerState(String str) {
        this.playerState = str;
    }

    public String toString() {
        return this.playerState;
    }
}
