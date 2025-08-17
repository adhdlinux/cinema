package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.scar.adapter.common.IScarInterstitialAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.core.misc.EventSubject;

public class ScarInterstitialAdHandler extends ScarAdHandlerBase implements IScarInterstitialAdListenerWrapper {
    public ScarInterstitialAdHandler(ScarAdMetadata scarAdMetadata, EventSubject<GMAEvent> eventSubject, GMAEventSender gMAEventSender) {
        super(scarAdMetadata, eventSubject, gMAEventSender);
    }

    public void onAdClosed() {
        if (!this._eventSubject.eventQueueIsEmpty()) {
            super.onAdSkipped();
        }
        super.onAdClosed();
    }

    public void onAdFailedToShow(int i2, String str) {
        this._gmaEventSender.send(GMAEvent.INTERSTITIAL_SHOW_ERROR, this._scarAdMetadata.c(), this._scarAdMetadata.d(), str, Integer.valueOf(i2));
    }

    public void onAdImpression() {
        this._gmaEventSender.send(GMAEvent.INTERSTITIAL_IMPRESSION_RECORDED, new Object[0]);
    }

    public void onAdLeftApplication() {
        this._gmaEventSender.send(GMAEvent.AD_LEFT_APPLICATION, new Object[0]);
    }
}
