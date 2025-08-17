package com.unity3d.services.ads.measurements;

import android.annotation.SuppressLint;
import android.os.OutcomeReceiver;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.jvm.internal.Intrinsics;

@SuppressLint({"NewApi", "MissingPermission"})
public final class MeasurementsStatusReceiver implements OutcomeReceiver<Integer, Exception> {
    private final IEventSender eventSender;

    public MeasurementsStatusReceiver(IEventSender iEventSender) {
        Intrinsics.f(iEventSender, "eventSender");
        this.eventSender = iEventSender;
    }

    public /* bridge */ /* synthetic */ void onResult(Object obj) {
        onResult(((Number) obj).intValue());
    }

    public void onError(Exception exc) {
        Intrinsics.f(exc, MRAIDPresenter.ERROR);
        this.eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, MeasurementsEvents.NOT_AVAILABLE, MeasurementsErrors.ERROR_EXCEPTION, exc.toString());
    }

    public void onResult(int i2) {
        this.eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, MeasurementsEvents.AVAILABLE, Integer.valueOf(i2));
    }
}
