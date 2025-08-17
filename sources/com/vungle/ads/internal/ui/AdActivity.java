package com.vungle.ads.internal.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.vungle.ads.ConcurrentPlaybackUnsupported;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.model.UnclosedAd;
import com.vungle.ads.internal.omsdk.OMTracker;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.presenter.AdEventListener;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.presenter.PresenterDelegate;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.ui.view.MRAIDAdWidget;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.RingerModeReceiver;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public abstract class AdActivity extends Activity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REQUEST_KEY_EVENT_ID_EXTRA = "request_eventId";
    public static final String REQUEST_KEY_EXTRA = "request";
    private static final String TAG = "AdActivity";
    /* access modifiers changed from: private */
    public static AdPayload advertisement;
    /* access modifiers changed from: private */
    public static BidPayload bidPayload;
    /* access modifiers changed from: private */
    public static AdEventListener eventListener;
    /* access modifiers changed from: private */
    public static PresenterDelegate presenterDelegate;
    private boolean isReceiverRegistered;
    private MRAIDAdWidget mraidAdWidget;
    private MRAIDPresenter mraidPresenter;
    private String placementRefId = "";
    private final RingerModeReceiver ringerModeReceiver = new RingerModeReceiver();
    /* access modifiers changed from: private */
    public UnclosedAd unclosedAd;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String getEventId(Intent intent) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    return extras.getString(AdActivity.REQUEST_KEY_EVENT_ID_EXTRA);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        /* access modifiers changed from: private */
        public final String getPlacement(Intent intent) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    return extras.getString(AdActivity.REQUEST_KEY_EXTRA);
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        public static /* synthetic */ void getREQUEST_KEY_EVENT_ID_EXTRA$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getREQUEST_KEY_EXTRA$vungle_ads_release$annotations() {
        }

        public final Intent createIntent(Context context, String str, String str2) {
            Intrinsics.f(str, "placement");
            Intent intent = new Intent(context, VungleActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            Bundle bundle = new Bundle();
            bundle.putString(AdActivity.REQUEST_KEY_EXTRA, str);
            bundle.putString(AdActivity.REQUEST_KEY_EVENT_ID_EXTRA, str2);
            intent.putExtras(bundle);
            return intent;
        }

        public final AdPayload getAdvertisement$vungle_ads_release() {
            return AdActivity.advertisement;
        }

        public final BidPayload getBidPayload$vungle_ads_release() {
            return AdActivity.bidPayload;
        }

        public final AdEventListener getEventListener$vungle_ads_release() {
            return AdActivity.eventListener;
        }

        public final PresenterDelegate getPresenterDelegate$vungle_ads_release() {
            return AdActivity.presenterDelegate;
        }

        public final void setAdvertisement$vungle_ads_release(AdPayload adPayload) {
            AdActivity.advertisement = adPayload;
        }

        public final void setBidPayload$vungle_ads_release(BidPayload bidPayload) {
            AdActivity.bidPayload = bidPayload;
        }

        public final void setEventListener$vungle_ads_release(AdEventListener adEventListener) {
            AdActivity.eventListener = adEventListener;
        }

        public final void setPresenterDelegate$vungle_ads_release(PresenterDelegate presenterDelegate) {
            AdActivity.presenterDelegate = presenterDelegate;
        }
    }

    public static /* synthetic */ void getMraidAdWidget$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getMraidPresenter$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getPlacementRefId$vungle_ads_release$annotations() {
    }

    private final void hideSystemUi() {
        WindowInsetsControllerCompat a2 = WindowCompat.a(getWindow(), getWindow().getDecorView());
        Intrinsics.e(a2, "getInsetsController(window, window.decorView)");
        a2.b(2);
        a2.a(WindowInsetsCompat.Type.b());
    }

    private final void onConcurrentPlaybackError(String str) {
        LogEntry logEntry;
        ConcurrentPlaybackUnsupported concurrentPlaybackUnsupported = new ConcurrentPlaybackUnsupported();
        AdPayload adPayload = advertisement;
        if (adPayload != null) {
            logEntry = adPayload.getLogEntry$vungle_ads_release();
        } else {
            logEntry = null;
        }
        VungleError logError$vungle_ads_release = concurrentPlaybackUnsupported.setLogEntry$vungle_ads_release(logEntry).logError$vungle_ads_release();
        AdEventListener adEventListener = eventListener;
        if (adEventListener != null) {
            adEventListener.onError(logError$vungle_ads_release, str);
        }
        Logger.Companion companion = Logger.Companion;
        companion.e(TAG, "onConcurrentPlaybackError: " + logError$vungle_ads_release.getLocalizedMessage());
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final SignalManager m213onCreate$lambda0(Lazy<SignalManager> lazy) {
        return lazy.getValue();
    }

    /* renamed from: onCreate$lambda-4  reason: not valid java name */
    private static final Executors m214onCreate$lambda4(Lazy<? extends Executors> lazy) {
        return (Executors) lazy.getValue();
    }

    /* renamed from: onCreate$lambda-5  reason: not valid java name */
    private static final Platform m215onCreate$lambda5(Lazy<? extends Platform> lazy) {
        return (Platform) lazy.getValue();
    }

    /* renamed from: onCreate$lambda-6  reason: not valid java name */
    private static final OMTracker.Factory m216onCreate$lambda6(Lazy<OMTracker.Factory> lazy) {
        return lazy.getValue();
    }

    public boolean canRotate$vungle_ads_release() {
        return false;
    }

    public final MRAIDAdWidget getMraidAdWidget$vungle_ads_release() {
        return this.mraidAdWidget;
    }

    public final MRAIDPresenter getMraidPresenter$vungle_ads_release() {
        return this.mraidPresenter;
    }

    public final String getPlacementRefId$vungle_ads_release() {
        return this.placementRefId;
    }

    public void onBackPressed() {
        MRAIDPresenter mRAIDPresenter = this.mraidPresenter;
        if (mRAIDPresenter != null) {
            mRAIDPresenter.handleExit();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.f(configuration, "newConfig");
        try {
            super.onConfigurationChanged(configuration);
            int i2 = configuration.orientation;
            if (i2 == 2) {
                Logger.Companion.d(TAG, "landscape");
            } else if (i2 == 1) {
                Logger.Companion.d(TAG, "portrait");
            }
            MRAIDPresenter mRAIDPresenter = this.mraidPresenter;
            if (mRAIDPresenter != null) {
                mRAIDPresenter.onViewConfigurationChanged();
            }
        } catch (Exception e2) {
            Logger.Companion companion = Logger.Companion;
            companion.e(TAG, "onConfigurationChanged: " + e2.getLocalizedMessage());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.vungle.ads.internal.util.LogEntry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.vungle.ads.internal.model.UnclosedAd} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r15) {
        /*
            r14 = this;
            super.onCreate(r15)
            r15 = 1
            r14.requestWindowFeature(r15)
            android.view.Window r0 = r14.getWindow()
            r1 = 16777216(0x1000000, float:2.3509887E-38)
            r0.setFlags(r1, r1)
            com.vungle.ads.internal.ui.AdActivity$Companion r0 = Companion
            android.content.Intent r1 = r14.getIntent()
            java.lang.String r2 = "intent"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)
            java.lang.String r1 = r0.getPlacement(r1)
            if (r1 != 0) goto L_0x0023
            java.lang.String r1 = ""
        L_0x0023:
            r14.placementRefId = r1
            com.vungle.ads.internal.model.AdPayload r12 = advertisement
            com.vungle.ads.internal.ConfigManager r9 = com.vungle.ads.internal.ConfigManager.INSTANCE
            com.vungle.ads.internal.model.Placement r1 = r9.getPlacement(r1)
            r3 = 0
            if (r1 == 0) goto L_0x0154
            if (r12 != 0) goto L_0x0034
            goto L_0x0154
        L_0x0034:
            android.view.Window r4 = r14.getWindow()
            android.view.View r4 = r4.getDecorView()
            r5 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r4.setBackgroundColor(r5)
            com.vungle.ads.internal.ui.view.MRAIDAdWidget r13 = new com.vungle.ads.internal.ui.view.MRAIDAdWidget     // Catch:{ InstantiationException -> 0x0135 }
            r13.<init>(r14)     // Catch:{ InstantiationException -> 0x0135 }
            com.vungle.ads.ServiceLocator$Companion r4 = com.vungle.ads.ServiceLocator.Companion
            kotlin.LazyThreadSafetyMode r10 = kotlin.LazyThreadSafetyMode.SYNCHRONIZED
            com.vungle.ads.internal.ui.AdActivity$onCreate$$inlined$inject$1 r4 = new com.vungle.ads.internal.ui.AdActivity$onCreate$$inlined$inject$1
            r4.<init>(r14)
            kotlin.Lazy r4 = kotlin.LazyKt__LazyJVMKt.a(r10, r4)
            android.content.Intent r5 = r14.getIntent()
            kotlin.jvm.internal.Intrinsics.e(r5, r2)
            java.lang.String r0 = r0.getEventId(r5)
            if (r0 == 0) goto L_0x0067
            com.vungle.ads.internal.model.UnclosedAd r2 = new com.vungle.ads.internal.model.UnclosedAd
            r5 = 2
            r2.<init>((java.lang.String) r0, (java.lang.String) r3, (int) r5, (kotlin.jvm.internal.DefaultConstructorMarker) r3)
            r3 = r2
        L_0x0067:
            r14.unclosedAd = r3
            if (r3 == 0) goto L_0x0072
            com.vungle.ads.internal.signals.SignalManager r0 = m213onCreate$lambda0(r4)
            r0.recordUnclosedAd(r3)
        L_0x0072:
            com.vungle.ads.internal.ui.AdActivity$onCreate$3$1 r0 = new com.vungle.ads.internal.ui.AdActivity$onCreate$3$1
            r0.<init>(r14, r4)
            r13.setCloseDelegate(r0)
            com.vungle.ads.internal.ui.AdActivity$onCreate$3$2 r0 = new com.vungle.ads.internal.ui.AdActivity$onCreate$3$2
            r0.<init>(r14)
            r13.setOnViewTouchListener(r0)
            com.vungle.ads.internal.ui.AdActivity$onCreate$3$3 r0 = new com.vungle.ads.internal.ui.AdActivity$onCreate$3$3
            r0.<init>(r14)
            r13.setOrientationDelegate(r0)
            com.vungle.ads.internal.ui.AdActivity$onCreate$$inlined$inject$2 r0 = new com.vungle.ads.internal.ui.AdActivity$onCreate$$inlined$inject$2
            r0.<init>(r14)
            kotlin.Lazy r0 = kotlin.LazyKt__LazyJVMKt.a(r10, r0)
            com.vungle.ads.internal.ui.AdActivity$onCreate$$inlined$inject$3 r2 = new com.vungle.ads.internal.ui.AdActivity$onCreate$$inlined$inject$3
            r2.<init>(r14)
            kotlin.Lazy r2 = kotlin.LazyKt__LazyJVMKt.a(r10, r2)
            com.vungle.ads.internal.executor.Executors r3 = m214onCreate$lambda4(r0)
            com.vungle.ads.internal.executor.VungleThreadPoolExecutor r6 = r3.getOffloadExecutor()
            com.vungle.ads.internal.ui.VungleWebClient r11 = new com.vungle.ads.internal.ui.VungleWebClient
            com.vungle.ads.internal.signals.SignalManager r7 = m213onCreate$lambda0(r4)
            com.vungle.ads.internal.platform.Platform r8 = m215onCreate$lambda5(r2)
            r3 = r11
            r4 = r12
            r5 = r1
            r3.<init>(r4, r5, r6, r7, r8)
            com.vungle.ads.internal.ui.AdActivity$onCreate$$inlined$inject$4 r3 = new com.vungle.ads.internal.ui.AdActivity$onCreate$$inlined$inject$4
            r3.<init>(r14)
            kotlin.Lazy r3 = kotlin.LazyKt__LazyJVMKt.a(r10, r3)
            com.vungle.ads.internal.omsdk.OMTracker$Factory r3 = m216onCreate$lambda6(r3)
            boolean r4 = r9.omEnabled()
            if (r4 == 0) goto L_0x00ce
            boolean r4 = r12.omEnabled()
            if (r4 == 0) goto L_0x00ce
            goto L_0x00cf
        L_0x00ce:
            r15 = 0
        L_0x00cf:
            com.vungle.ads.internal.omsdk.OMTracker r9 = r3.make(r15)
            com.vungle.ads.internal.executor.Executors r15 = m214onCreate$lambda4(r0)
            com.vungle.ads.internal.executor.VungleThreadPoolExecutor r8 = r15.getJobExecutor()
            r11.setWebViewObserver(r9)
            com.vungle.ads.internal.util.RingerModeReceiver r15 = r14.ringerModeReceiver
            r15.setWebClient(r11)
            com.vungle.ads.internal.presenter.MRAIDPresenter r15 = new com.vungle.ads.internal.presenter.MRAIDPresenter
            com.vungle.ads.internal.model.BidPayload r10 = bidPayload
            com.vungle.ads.internal.platform.Platform r0 = m215onCreate$lambda5(r2)
            r3 = r15
            r4 = r13
            r5 = r12
            r6 = r1
            r7 = r11
            r11 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            com.vungle.ads.internal.presenter.AdEventListener r0 = eventListener
            r15.setEventListener(r0)
            com.vungle.ads.internal.presenter.PresenterDelegate r0 = presenterDelegate
            r15.setPresenterDelegate$vungle_ads_release(r0)
            r15.prepare()
            android.view.ViewGroup$LayoutParams r0 = r13.getLayoutParams()
            r14.setContentView(r13, r0)
            com.vungle.ads.AdConfig r0 = r12.getAdConfig()
            if (r0 == 0) goto L_0x0130
            java.lang.String r0 = r0.getWatermark$vungle_ads_release()
            if (r0 == 0) goto L_0x0130
            com.vungle.ads.internal.ui.WatermarkView r1 = new com.vungle.ads.internal.ui.WatermarkView
            r1.<init>(r14, r0)
            android.view.Window r0 = r14.getWindow()
            android.view.View r0 = r0.getDecorView()
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r2)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r0.addView(r1)
            r1.bringToFront()
        L_0x0130:
            r14.mraidAdWidget = r13
            r14.mraidPresenter = r15
            return
        L_0x0135:
            com.vungle.ads.internal.presenter.AdEventListener r15 = eventListener
            if (r15 == 0) goto L_0x0150
            com.vungle.ads.AdCantPlayWithoutWebView r0 = new com.vungle.ads.AdCantPlayWithoutWebView
            r0.<init>()
            com.vungle.ads.internal.util.LogEntry r1 = r12.getLogEntry$vungle_ads_release()
            com.vungle.ads.VungleError r0 = r0.setLogEntry$vungle_ads_release(r1)
            com.vungle.ads.VungleError r0 = r0.logError$vungle_ads_release()
            java.lang.String r1 = r14.placementRefId
            r15.onError(r0, r1)
        L_0x0150:
            r14.finish()
            return
        L_0x0154:
            com.vungle.ads.internal.presenter.AdEventListener r15 = eventListener
            if (r15 == 0) goto L_0x0172
            com.vungle.ads.AdNotLoadedCantPlay r0 = new com.vungle.ads.AdNotLoadedCantPlay
            java.lang.String r1 = "Can not play fullscreen ad"
            r0.<init>(r1)
            if (r12 == 0) goto L_0x0165
            com.vungle.ads.internal.util.LogEntry r3 = r12.getLogEntry$vungle_ads_release()
        L_0x0165:
            com.vungle.ads.VungleError r0 = r0.setLogEntry$vungle_ads_release(r3)
            com.vungle.ads.VungleError r0 = r0.logError$vungle_ads_release()
            java.lang.String r1 = r14.placementRefId
            r15.onError(r0, r1)
        L_0x0172:
            r14.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.ui.AdActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        MRAIDPresenter mRAIDPresenter = this.mraidPresenter;
        if (mRAIDPresenter != null) {
            mRAIDPresenter.detach(isChangingConfigurations() | true ? 1 : 0);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        Intrinsics.f(intent, "intent");
        super.onNewIntent(intent);
        Companion companion = Companion;
        Intent intent2 = getIntent();
        Intrinsics.e(intent2, "getIntent()");
        String access$getPlacement = companion.getPlacement(intent2);
        String access$getPlacement2 = companion.getPlacement(intent);
        Intent intent3 = getIntent();
        Intrinsics.e(intent3, "getIntent()");
        String access$getEventId = companion.getEventId(intent3);
        String access$getEventId2 = companion.getEventId(intent);
        if ((access$getPlacement != null && access$getPlacement2 != null && !Intrinsics.a(access$getPlacement, access$getPlacement2)) || (access$getEventId != null && access$getEventId2 != null && !Intrinsics.a(access$getEventId, access$getEventId2))) {
            Logger.Companion companion2 = Logger.Companion;
            companion2.d(TAG, "Tried to play another placement " + access$getPlacement2 + " while playing " + access$getPlacement);
            onConcurrentPlaybackError(access$getPlacement2);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        try {
            if (this.isReceiverRegistered) {
                unregisterReceiver(this.ringerModeReceiver);
                this.isReceiverRegistered = false;
                Logger.Companion companion = Logger.Companion;
                companion.d(TAG, "unregisterReceiver(): " + this.ringerModeReceiver.hashCode());
            }
        } catch (Exception e2) {
            Logger.Companion companion2 = Logger.Companion;
            companion2.e(TAG, "unregisterReceiver error: " + e2.getLocalizedMessage());
        }
        MRAIDPresenter mRAIDPresenter = this.mraidPresenter;
        if (mRAIDPresenter != null) {
            mRAIDPresenter.stop();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        hideSystemUi();
        try {
            if (!this.isReceiverRegistered) {
                registerReceiver(this.ringerModeReceiver, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
                this.isReceiverRegistered = true;
                Logger.Companion companion = Logger.Companion;
                companion.d(TAG, "registerReceiver(): " + this.ringerModeReceiver.hashCode());
            }
        } catch (Exception e2) {
            Logger.Companion companion2 = Logger.Companion;
            companion2.e(TAG, "registerReceiver error: " + e2.getLocalizedMessage());
        }
        MRAIDPresenter mRAIDPresenter = this.mraidPresenter;
        if (mRAIDPresenter != null) {
            mRAIDPresenter.start();
        }
    }

    public final void setMraidAdWidget$vungle_ads_release(MRAIDAdWidget mRAIDAdWidget) {
        this.mraidAdWidget = mRAIDAdWidget;
    }

    public final void setMraidPresenter$vungle_ads_release(MRAIDPresenter mRAIDPresenter) {
        this.mraidPresenter = mRAIDPresenter;
    }

    public final void setPlacementRefId$vungle_ads_release(String str) {
        Intrinsics.f(str, "<set-?>");
        this.placementRefId = str;
    }

    public void setRequestedOrientation(int i2) {
        if (canRotate$vungle_ads_release()) {
            super.setRequestedOrientation(i2);
        }
    }
}
