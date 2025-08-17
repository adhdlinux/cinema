package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.core.misc.EventSubject;

public class ScarRewardedAdHandler extends ScarAdHandlerBase implements IScarRewardedAdListenerWrapper {
    private boolean _hasEarnedReward = false;

    public ScarRewardedAdHandler(ScarAdMetadata scarAdMetadata, EventSubject<GMAEvent> eventSubject, GMAEventSender gMAEventSender) {
        super(scarAdMetadata, eventSubject, gMAEventSender);
    }

    public void onAdClosed() {
        if (!this._hasEarnedReward) {
            super.onAdSkipped();
        }
        super.onAdClosed();
    }

    public void onAdFailedToShow(int i2, String str) {
        this._gmaEventSender.send(GMAEvent.REWARDED_SHOW_ERROR, this._scarAdMetadata.c(), this._scarAdMetadata.d(), str, Integer.valueOf(i2));
    }

    public void onAdImpression() {
        this._gmaEventSender.send(GMAEvent.REWARDED_IMPRESSION_RECORDED, new Object[0]);
    }

    public void onUserEarnedReward() {
        this._hasEarnedReward = true;
        this._gmaEventSender.send(GMAEvent.AD_EARNED_REWARD, new Object[0]);
    }
}
