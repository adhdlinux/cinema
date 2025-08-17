package com.chartboost.sdk.impl;

import com.facebook.react.uimanager.ViewProps;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public enum d8 {
    GET_PARAMETERS("getParameters"),
    GET_MAX_SIZE("getMaxSize"),
    GET_SCREEN_SIZE("getScreenSize"),
    GET_CURRENT_POSITION("getCurrentPosition"),
    GET_DEFAULT_POSITION("getDefaultPosition"),
    GET_ORIENTATION_PROPERTIES("getOrientationProperties"),
    CLICK("click"),
    CLOSE(MRAIDPresenter.CLOSE),
    SKIPPED("skipped"),
    VIDEO_COMPLETED("videoCompleted"),
    VIDEO_RESUMED("videoResumed"),
    VIDEO_PAUSED("videoPaused"),
    VIDEO_REPLAY("videoReplay"),
    CURRENT_VIDEO_DURATION("currentVideoDuration"),
    TOTAL_VIDEO_DURATION("totalVideoDuration"),
    SHOW("show"),
    ERROR(MRAIDPresenter.ERROR),
    WARNING("warning"),
    DEBUG("debug"),
    TRACKING("tracking"),
    OPEN_URL("openUrl"),
    SET_ORIENTATION_PROPERTIES(MRAIDPresenter.SET_ORIENTATION_PROPERTIES),
    REWARD("reward"),
    REWARDED_VIDEO_COMPLETED("rewardedVideoCompleted"),
    PLAY_VIDEO("playVideo"),
    PAUSE_VIDEO("pauseVideo"),
    CLOSE_VIDEO("closeVideo"),
    MUTE_VIDEO("mute"),
    UNMUTE_VIDEO("unmute"),
    OM_MEASUREMENT_RESOURCES("OMMeasurementResources"),
    START(ViewProps.START),
    BUFFER_START("bufferStart"),
    BUFFER_END("bufferEnd"),
    VIDEO_FINISHED("videoFinished"),
    VIDEO_STARTED("videoStarted"),
    VIDEO_ENDED("videoEnded"),
    VIDEO_FAILED("videoFailed"),
    PLAYBACK_TIME("playbackTime"),
    ON_BACKGROUND("onBackground"),
    ON_FOREGROUND("onForeground");
    

    /* renamed from: c  reason: collision with root package name */
    public static final a f17423c = null;

    /* renamed from: d  reason: collision with root package name */
    public static final Map f17424d = null;

    /* renamed from: b  reason: collision with root package name */
    public final String f17447b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d8 a(String str) {
            Intrinsics.f(str, "cmdName");
            return (d8) d8.f17424d.get(str);
        }

        public a() {
        }
    }

    static {
        int i2;
        f17423c = new a((DefaultConstructorMarker) null);
        d8[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.b(MapsKt__MapsJVMKt.d(values.length), 16));
        for (d8 d8Var : values) {
            linkedHashMap.put(d8Var.f17447b, d8Var);
        }
        f17424d = linkedHashMap;
    }

    /* access modifiers changed from: public */
    d8(String str) {
        this.f17447b = str;
    }

    public final String c() {
        return this.f17447b;
    }
}
