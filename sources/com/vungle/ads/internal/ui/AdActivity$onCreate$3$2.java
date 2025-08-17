package com.vungle.ads.internal.ui;

import android.view.MotionEvent;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.ui.view.MRAIDAdWidget;

public final class AdActivity$onCreate$3$2 implements MRAIDAdWidget.OnViewTouchListener {
    final /* synthetic */ AdActivity this$0;

    AdActivity$onCreate$3$2(AdActivity adActivity) {
        this.this$0 = adActivity;
    }

    public boolean onTouch(MotionEvent motionEvent) {
        MRAIDPresenter mraidPresenter$vungle_ads_release = this.this$0.getMraidPresenter$vungle_ads_release();
        if (mraidPresenter$vungle_ads_release == null) {
            return false;
        }
        mraidPresenter$vungle_ads_release.onViewTouched(motionEvent);
        return false;
    }
}
