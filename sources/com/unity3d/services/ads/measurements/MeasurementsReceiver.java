package com.unity3d.services.ads.measurements;

import android.annotation.SuppressLint;
import android.os.OutcomeReceiver;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import kotlin.jvm.internal.Intrinsics;

@SuppressLint({"NewApi", "MissingPermission"})
public final class MeasurementsReceiver implements OutcomeReceiver<Object, Exception> {
    private final MeasurementsEvents errorEvent;
    private final IEventSender eventSender;
    private final MeasurementsEvents successEvent;

    public MeasurementsReceiver(IEventSender iEventSender, MeasurementsEvents measurementsEvents, MeasurementsEvents measurementsEvents2) {
        Intrinsics.f(iEventSender, "eventSender");
        Intrinsics.f(measurementsEvents, "successEvent");
        Intrinsics.f(measurementsEvents2, "errorEvent");
        this.eventSender = iEventSender;
        this.successEvent = measurementsEvents;
        this.errorEvent = measurementsEvents2;
    }

    public void onResult(Object obj) {
        Intrinsics.f(obj, "p0");
        this.eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, this.successEvent, new Object[0]);
    }

    public void onError(Exception exc) {
        Intrinsics.f(exc, MRAIDPresenter.ERROR);
        this.eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, this.errorEvent, exc.toString());
    }
}
