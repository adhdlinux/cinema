package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.scar.adapter.common.signals.ISignalCollectionListener;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;

public class SignalsHandler implements ISignalCollectionListener {
    private GMAEventSender _gmaEventSender;

    public SignalsHandler(GMAEventSender gMAEventSender) {
        this._gmaEventSender = gMAEventSender;
    }

    public void onSignalsCollected(String str) {
        this._gmaEventSender.send(GMAEvent.SIGNALS, str);
    }

    public void onSignalsCollectionFailed(String str) {
        this._gmaEventSender.send(GMAEvent.SIGNALS_ERROR, str);
    }
}
