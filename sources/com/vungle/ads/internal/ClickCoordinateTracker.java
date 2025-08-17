package com.vungle.ads.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.TpatError;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.util.PathProvider;
import com.vungle.ads.internal.util.ViewUtility;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

public final class ClickCoordinateTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String MACRO_DOWN_X = Pattern.quote("{{{down_x}}}");
    private static final String MACRO_DOWN_Y = Pattern.quote("{{{down_y}}}");
    private static final String MACRO_HEIGHT = Pattern.quote("{{{height}}}");
    private static final String MACRO_REQ_HEIGHT = Pattern.quote("{{{req_height}}}");
    private static final String MACRO_REQ_WIDTH = Pattern.quote("{{{req_width}}}");
    private static final String MACRO_UP_X = Pattern.quote("{{{up_x}}}");
    private static final String MACRO_UP_Y = Pattern.quote("{{{up_y}}}");
    private static final String MACRO_WIDTH = Pattern.quote("{{{width}}}");
    private static final String TAG = "ClickCoordinateTracker";
    private final AdPayload advertisement;
    private final Context context;
    private final ClickCoordinate currentClick = new ClickCoordinate(new Coordinate(Integer.MIN_VALUE, Integer.MIN_VALUE), new Coordinate(Integer.MIN_VALUE, Integer.MIN_VALUE));
    private final Executor executor;
    private final Lazy executors$delegate;
    private final Lazy vungleApiClient$delegate;

    public static final class ClickCoordinate {
        private Coordinate downCoordinate;
        private Coordinate upCoordinate;

        public ClickCoordinate(Coordinate coordinate, Coordinate coordinate2) {
            Intrinsics.f(coordinate, "downCoordinate");
            Intrinsics.f(coordinate2, "upCoordinate");
            this.downCoordinate = coordinate;
            this.upCoordinate = coordinate2;
        }

        public static /* synthetic */ ClickCoordinate copy$default(ClickCoordinate clickCoordinate, Coordinate coordinate, Coordinate coordinate2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                coordinate = clickCoordinate.downCoordinate;
            }
            if ((i2 & 2) != 0) {
                coordinate2 = clickCoordinate.upCoordinate;
            }
            return clickCoordinate.copy(coordinate, coordinate2);
        }

        public final Coordinate component1() {
            return this.downCoordinate;
        }

        public final Coordinate component2() {
            return this.upCoordinate;
        }

        public final ClickCoordinate copy(Coordinate coordinate, Coordinate coordinate2) {
            Intrinsics.f(coordinate, "downCoordinate");
            Intrinsics.f(coordinate2, "upCoordinate");
            return new ClickCoordinate(coordinate, coordinate2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClickCoordinate)) {
                return false;
            }
            ClickCoordinate clickCoordinate = (ClickCoordinate) obj;
            return Intrinsics.a(this.downCoordinate, clickCoordinate.downCoordinate) && Intrinsics.a(this.upCoordinate, clickCoordinate.upCoordinate);
        }

        public final Coordinate getDownCoordinate() {
            return this.downCoordinate;
        }

        public final Coordinate getUpCoordinate() {
            return this.upCoordinate;
        }

        public int hashCode() {
            return (this.downCoordinate.hashCode() * 31) + this.upCoordinate.hashCode();
        }

        public final boolean ready() {
            return (this.downCoordinate.getX() == Integer.MIN_VALUE || this.downCoordinate.getY() == Integer.MIN_VALUE || this.upCoordinate.getX() == Integer.MIN_VALUE || this.upCoordinate.getY() == Integer.MIN_VALUE) ? false : true;
        }

        public final void setDownCoordinate(Coordinate coordinate) {
            Intrinsics.f(coordinate, "<set-?>");
            this.downCoordinate = coordinate;
        }

        public final void setUpCoordinate(Coordinate coordinate) {
            Intrinsics.f(coordinate, "<set-?>");
            this.upCoordinate = coordinate;
        }

        public String toString() {
            return "ClickCoordinate(downCoordinate=" + this.downCoordinate + ", upCoordinate=" + this.upCoordinate + ')';
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class Coordinate {

        /* renamed from: x  reason: collision with root package name */
        private final int f37839x;

        /* renamed from: y  reason: collision with root package name */
        private final int f37840y;

        public Coordinate(int i2, int i3) {
            this.f37839x = i2;
            this.f37840y = i3;
        }

        public static /* synthetic */ Coordinate copy$default(Coordinate coordinate, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = coordinate.f37839x;
            }
            if ((i4 & 2) != 0) {
                i3 = coordinate.f37840y;
            }
            return coordinate.copy(i2, i3);
        }

        public final int component1() {
            return this.f37839x;
        }

        public final int component2() {
            return this.f37840y;
        }

        public final Coordinate copy(int i2, int i3) {
            return new Coordinate(i2, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Coordinate)) {
                return false;
            }
            Coordinate coordinate = (Coordinate) obj;
            return this.f37839x == coordinate.f37839x && this.f37840y == coordinate.f37840y;
        }

        public final int getX() {
            return this.f37839x;
        }

        public final int getY() {
            return this.f37840y;
        }

        public int hashCode() {
            return (this.f37839x * 31) + this.f37840y;
        }

        public String toString() {
            return "Coordinate(x=" + this.f37839x + ", y=" + this.f37840y + ')';
        }
    }

    public static final class DeviceScreenInfo {
        private final Context context;
        private final DisplayMetrics dm;

        public DeviceScreenInfo(Context context2) {
            Intrinsics.f(context2, "context");
            this.context = context2;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.dm = displayMetrics;
            Object systemService = context2.getSystemService("window");
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        }

        public static /* synthetic */ DeviceScreenInfo copy$default(DeviceScreenInfo deviceScreenInfo, Context context2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                context2 = deviceScreenInfo.context;
            }
            return deviceScreenInfo.copy(context2);
        }

        public final Context component1() {
            return this.context;
        }

        public final DeviceScreenInfo copy(Context context2) {
            Intrinsics.f(context2, "context");
            return new DeviceScreenInfo(context2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeviceScreenInfo) && Intrinsics.a(this.context, ((DeviceScreenInfo) obj).context);
        }

        public final Context getContext() {
            return this.context;
        }

        public final int getDeviceHeight() {
            return this.dm.heightPixels;
        }

        public final int getDeviceWidth() {
            return this.dm.widthPixels;
        }

        public int hashCode() {
            return this.context.hashCode();
        }

        public String toString() {
            return "DeviceScreenInfo(context=" + this.context + ')';
        }
    }

    public ClickCoordinateTracker(Context context2, AdPayload adPayload, Executor executor2) {
        Intrinsics.f(context2, "context");
        Intrinsics.f(adPayload, "advertisement");
        Intrinsics.f(executor2, "executor");
        this.context = context2;
        this.advertisement = adPayload;
        this.executor = executor2;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        this.vungleApiClient$delegate = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new ClickCoordinateTracker$special$$inlined$inject$1(context2));
        this.executors$delegate = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new ClickCoordinateTracker$special$$inlined$inject$2(context2));
    }

    public static /* synthetic */ void getCurrentClick$vungle_ads_release$annotations() {
    }

    private final int getDeviceHeight() {
        return new DeviceScreenInfo(this.context).getDeviceHeight();
    }

    private final int getDeviceWidth() {
        return new DeviceScreenInfo(this.context).getDeviceWidth();
    }

    private final Executors getExecutors() {
        return (Executors) this.executors$delegate.getValue();
    }

    private final int getRequestedHeight() {
        int adHeight = this.advertisement.adHeight();
        if (adHeight == 0) {
            return getDeviceHeight();
        }
        return ViewUtility.INSTANCE.dpToPixels(this.context, adHeight);
    }

    private final int getRequestedWidth() {
        int adWidth = this.advertisement.adWidth();
        if (adWidth == 0) {
            return getDeviceWidth();
        }
        return ViewUtility.INSTANCE.dpToPixels(this.context, adWidth);
    }

    private final VungleApiClient getVungleApiClient() {
        return (VungleApiClient) this.vungleApiClient$delegate.getValue();
    }

    private final void sendClickCoordinates() {
        boolean z2;
        List<String> tpatUrls$default = AdPayload.getTpatUrls$default(this.advertisement, AdPayload.TPAT_CLICK_COORDINATES_URLS, (String) null, (String) null, 6, (Object) null);
        Collection collection = tpatUrls$default;
        if (collection == null || collection.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            new TpatError(Sdk$SDKError.Reason.EMPTY_TPAT_ERROR, "Empty urls for tpat: video.clickCoordinates").setLogEntry$vungle_ads_release(this.advertisement.getLogEntry$vungle_ads_release()).logErrorNoReturnValue$vungle_ads_release();
            return;
        }
        int requestedWidth = getRequestedWidth();
        int requestedHeight = getRequestedHeight();
        int requestedWidth2 = getRequestedWidth();
        int requestedHeight2 = getRequestedHeight();
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        Context context2 = this.context;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        TpatSender tpatSender = new TpatSender(getVungleApiClient(), this.advertisement.getLogEntry$vungle_ads_release(), getExecutors().getIoExecutor(), m144sendClickCoordinates$lambda0(LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new ClickCoordinateTracker$sendClickCoordinates$$inlined$inject$1(context2))), m145sendClickCoordinates$lambda1(LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new ClickCoordinateTracker$sendClickCoordinates$$inlined$inject$2(this.context))));
        for (String h2 : tpatUrls$default) {
            String str = MACRO_REQ_WIDTH;
            Intrinsics.e(str, "MACRO_REQ_WIDTH");
            String h3 = new Regex(str).h(h2, String.valueOf(requestedWidth));
            String str2 = MACRO_REQ_HEIGHT;
            Intrinsics.e(str2, "MACRO_REQ_HEIGHT");
            String h4 = new Regex(str2).h(h3, String.valueOf(requestedHeight));
            String str3 = MACRO_WIDTH;
            Intrinsics.e(str3, "MACRO_WIDTH");
            String h5 = new Regex(str3).h(h4, String.valueOf(requestedWidth2));
            String str4 = MACRO_HEIGHT;
            Intrinsics.e(str4, "MACRO_HEIGHT");
            String h6 = new Regex(str4).h(h5, String.valueOf(requestedHeight2));
            String str5 = MACRO_DOWN_X;
            Intrinsics.e(str5, "MACRO_DOWN_X");
            String h7 = new Regex(str5).h(h6, String.valueOf(this.currentClick.getDownCoordinate().getX()));
            String str6 = MACRO_DOWN_Y;
            Intrinsics.e(str6, "MACRO_DOWN_Y");
            String h8 = new Regex(str6).h(h7, String.valueOf(this.currentClick.getDownCoordinate().getY()));
            String str7 = MACRO_UP_X;
            Intrinsics.e(str7, "MACRO_UP_X");
            String h9 = new Regex(str7).h(h8, String.valueOf(this.currentClick.getUpCoordinate().getX()));
            String str8 = MACRO_UP_Y;
            Intrinsics.e(str8, "MACRO_UP_Y");
            tpatSender.sendTpat(new Regex(str8).h(h9, String.valueOf(this.currentClick.getUpCoordinate().getY())), this.executor);
        }
    }

    /* renamed from: sendClickCoordinates$lambda-0  reason: not valid java name */
    private static final PathProvider m144sendClickCoordinates$lambda0(Lazy<PathProvider> lazy) {
        return lazy.getValue();
    }

    /* renamed from: sendClickCoordinates$lambda-1  reason: not valid java name */
    private static final SignalManager m145sendClickCoordinates$lambda1(Lazy<SignalManager> lazy) {
        return lazy.getValue();
    }

    public final ClickCoordinate getCurrentClick$vungle_ads_release() {
        return this.currentClick;
    }

    public final void trackCoordinate(MotionEvent motionEvent) {
        Intrinsics.f(motionEvent, "event");
        if (this.advertisement.isClickCoordinatesTrackingEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.currentClick.setDownCoordinate(new Coordinate((int) motionEvent.getX(), (int) motionEvent.getY()));
            } else if (action == 1) {
                this.currentClick.setUpCoordinate(new Coordinate((int) motionEvent.getX(), (int) motionEvent.getY()));
                if (this.currentClick.ready()) {
                    sendClickCoordinates();
                }
            }
        }
    }
}
