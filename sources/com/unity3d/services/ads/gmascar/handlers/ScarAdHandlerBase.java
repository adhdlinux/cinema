package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.scar.adapter.common.IScarAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.core.misc.EventSubject;
import com.unity3d.services.core.misc.IEventListener;

public abstract class ScarAdHandlerBase implements IScarAdListenerWrapper {
    protected final EventSubject<GMAEvent> _eventSubject;
    protected final GMAEventSender _gmaEventSender;
    protected final ScarAdMetadata _scarAdMetadata;

    public ScarAdHandlerBase(ScarAdMetadata scarAdMetadata, EventSubject<GMAEvent> eventSubject, GMAEventSender gMAEventSender) {
        this._scarAdMetadata = scarAdMetadata;
        this._eventSubject = eventSubject;
        this._gmaEventSender = gMAEventSender;
    }

    public void onAdClicked() {
        this._gmaEventSender.send(GMAEvent.AD_CLICKED, new Object[0]);
    }

    public void onAdClosed() {
        this._gmaEventSender.send(GMAEvent.AD_CLOSED, new Object[0]);
        this._eventSubject.unsubscribe();
    }

    public void onAdFailedToLoad(int i2, String str) {
        this._gmaEventSender.send(GMAEvent.LOAD_ERROR, this._scarAdMetadata.c(), this._scarAdMetadata.d(), str, Integer.valueOf(i2));
    }

    public void onAdLoaded() {
        this._gmaEventSender.send(GMAEvent.AD_LOADED, this._scarAdMetadata.c(), this._scarAdMetadata.d());
    }

    public void onAdOpened() {
        this._gmaEventSender.send(GMAEvent.AD_STARTED, new Object[0]);
        this._eventSubject.subscribe(new IEventListener<GMAEvent>() {
            public void onNextEvent(GMAEvent gMAEvent) {
                ScarAdHandlerBase.this._gmaEventSender.send(gMAEvent, new Object[0]);
            }
        });
    }

    public void onAdSkipped() {
        this._gmaEventSender.send(GMAEvent.AD_SKIPPED, new Object[0]);
    }
}
