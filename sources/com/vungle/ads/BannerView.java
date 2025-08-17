package com.vungle.ads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.ImpressionTracker;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.omsdk.OMTracker;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.ui.VungleWebClient;
import com.vungle.ads.internal.ui.WatermarkView;
import com.vungle.ads.internal.ui.view.MRAIDAdWidget;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.ViewUtility;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class BannerView extends RelativeLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "BannerView";
    private MRAIDAdWidget adWidget;
    private final AdPayload advertisement;
    private int calculatedPixelHeight;
    private int calculatedPixelWidth;
    private final AtomicBoolean destroyed = new AtomicBoolean(false);
    private WatermarkView imageView;
    private final Lazy impressionTracker$delegate;
    /* access modifiers changed from: private */
    public final AtomicBoolean isInvisibleLogged = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public boolean isOnImpressionCalled;
    private final Placement placement;
    /* access modifiers changed from: private */
    public MRAIDPresenter presenter;
    private final AtomicBoolean presenterStarted = new AtomicBoolean(false);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerView(Context context, Placement placement2, AdPayload adPayload, VungleAdSize vungleAdSize, AdConfig adConfig, AdPlayCallback adPlayCallback, BidPayload bidPayload) throws InstantiationException {
        super(context);
        Context context2 = context;
        Placement placement3 = placement2;
        AdPayload adPayload2 = adPayload;
        AdPlayCallback adPlayCallback2 = adPlayCallback;
        Intrinsics.f(context2, "context");
        Intrinsics.f(placement3, "placement");
        Intrinsics.f(adPayload2, "advertisement");
        Intrinsics.f(vungleAdSize, "adSize");
        Intrinsics.f(adConfig, "adConfig");
        Intrinsics.f(adPlayCallback2, "adPlayCallback");
        this.placement = placement3;
        this.advertisement = adPayload2;
        boolean z2 = false;
        this.impressionTracker$delegate = LazyKt__LazyJVMKt.b(new BannerView$impressionTracker$2(context2));
        ViewUtility viewUtility = ViewUtility.INSTANCE;
        this.calculatedPixelHeight = viewUtility.dpToPixels(context2, vungleAdSize.getHeight());
        this.calculatedPixelWidth = viewUtility.dpToPixels(context2, vungleAdSize.getWidth());
        BannerView$adEventListener$1 bannerView$adEventListener$1 = new BannerView$adEventListener$1(adPlayCallback2, placement3);
        try {
            MRAIDAdWidget mRAIDAdWidget = new MRAIDAdWidget(context2);
            this.adWidget = mRAIDAdWidget;
            mRAIDAdWidget.setCloseDelegate(new MRAIDAdWidget.CloseDelegate(this) {
                final /* synthetic */ BannerView this$0;

                {
                    this.this$0 = r1;
                }

                public void close() {
                    this.this$0.finishAdInternal(false);
                }
            });
            mRAIDAdWidget.setOnViewTouchListener(new MRAIDAdWidget.OnViewTouchListener(this) {
                final /* synthetic */ BannerView this$0;

                {
                    this.this$0 = r1;
                }

                public boolean onTouch(MotionEvent motionEvent) {
                    MRAIDPresenter access$getPresenter$p = this.this$0.presenter;
                    if (access$getPresenter$p == null) {
                        return false;
                    }
                    access$getPresenter$p.onViewTouched(motionEvent);
                    return false;
                }
            });
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
            Lazy a2 = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new BannerView$special$$inlined$inject$1(context2));
            OMTracker.Factory r3 = m125_init_$lambda2(LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new BannerView$special$$inlined$inject$2(context2)));
            if (ConfigManager.INSTANCE.omEnabled() && adPayload.omEnabled()) {
                z2 = true;
            }
            OMTracker make = r3.make(z2);
            Lazy a3 = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new BannerView$special$$inlined$inject$3(context2));
            VungleWebClient vungleWebClient = r2;
            OMTracker oMTracker = make;
            VungleWebClient vungleWebClient2 = new VungleWebClient(adPayload, placement2, m124_init_$lambda1(a2).getOffloadExecutor(), (SignalManager) null, m126_init_$lambda3(a3), 8, (DefaultConstructorMarker) null);
            VungleWebClient vungleWebClient3 = vungleWebClient;
            vungleWebClient3.setWebViewObserver(oMTracker);
            MRAIDPresenter mRAIDPresenter = r2;
            MRAIDPresenter mRAIDPresenter2 = new MRAIDPresenter(mRAIDAdWidget, adPayload, placement2, vungleWebClient3, m124_init_$lambda1(a2).getJobExecutor(), oMTracker, bidPayload, m126_init_$lambda3(a3));
            mRAIDPresenter.setEventListener(bannerView$adEventListener$1);
            this.presenter = mRAIDPresenter;
            String watermark$vungle_ads_release = adConfig.getWatermark$vungle_ads_release();
            if (watermark$vungle_ads_release != null) {
                this.imageView = new WatermarkView(context2, watermark$vungle_ads_release);
            }
        } catch (InstantiationException e2) {
            bannerView$adEventListener$1.onError(new AdCantPlayWithoutWebView().setLogEntry$vungle_ads_release(this.advertisement.getLogEntry$vungle_ads_release()).logError$vungle_ads_release(), this.placement.getReferenceId());
            throw e2;
        }
    }

    /* renamed from: _init_$lambda-1  reason: not valid java name */
    private static final Executors m124_init_$lambda1(Lazy<? extends Executors> lazy) {
        return (Executors) lazy.getValue();
    }

    /* renamed from: _init_$lambda-2  reason: not valid java name */
    private static final OMTracker.Factory m125_init_$lambda2(Lazy<OMTracker.Factory> lazy) {
        return lazy.getValue();
    }

    /* renamed from: _init_$lambda-3  reason: not valid java name */
    private static final Platform m126_init_$lambda3(Lazy<? extends Platform> lazy) {
        return (Platform) lazy.getValue();
    }

    /* access modifiers changed from: private */
    public final void checkHardwareAcceleration() {
        Logger.Companion companion = Logger.Companion;
        companion.w(TAG, "hardwareAccelerated = " + isHardwareAccelerated());
        if (!isHardwareAccelerated()) {
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, Sdk$SDKMetric.SDKMetricType.HARDWARE_ACCELERATE_DISABLED, 0, this.advertisement.getLogEntry$vungle_ads_release(), (String) null, 10, (Object) null);
        }
    }

    private final ImpressionTracker getImpressionTracker() {
        return (ImpressionTracker) this.impressionTracker$delegate.getValue();
    }

    private final void renderAd() {
        ViewParent viewParent;
        MRAIDAdWidget mRAIDAdWidget = this.adWidget;
        if (mRAIDAdWidget != null) {
            if (mRAIDAdWidget != null) {
                viewParent = mRAIDAdWidget.getParent();
            } else {
                viewParent = null;
            }
            if (!Intrinsics.a(viewParent, this)) {
                addView(this.adWidget, this.calculatedPixelWidth, this.calculatedPixelHeight);
                WatermarkView watermarkView = this.imageView;
                if (watermarkView != null) {
                    addView(watermarkView, this.calculatedPixelWidth, this.calculatedPixelHeight);
                    WatermarkView watermarkView2 = this.imageView;
                    if (watermarkView2 != null) {
                        watermarkView2.bringToFront();
                    }
                }
            }
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.calculatedPixelHeight;
            layoutParams.width = this.calculatedPixelWidth;
            requestLayout();
        }
    }

    private final void setAdVisibility(boolean z2) {
        MRAIDPresenter mRAIDPresenter;
        if (this.isOnImpressionCalled && !this.destroyed.get() && (mRAIDPresenter = this.presenter) != null) {
            mRAIDPresenter.setAdVisibility(z2);
        }
    }

    public final void finishAdInternal(boolean z2) {
        int i2;
        if (!this.destroyed.get()) {
            this.destroyed.set(true);
            if (z2) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            int i3 = i2 | 2;
            MRAIDPresenter mRAIDPresenter = this.presenter;
            if (mRAIDPresenter != null) {
                mRAIDPresenter.stop();
            }
            MRAIDPresenter mRAIDPresenter2 = this.presenter;
            if (mRAIDPresenter2 != null) {
                mRAIDPresenter2.detach(i3);
            }
            getImpressionTracker().destroy();
            try {
                ViewParent parent = getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this);
                }
                removeAllViews();
            } catch (Exception e2) {
                Logger.Companion companion = Logger.Companion;
                companion.d(TAG, "Removing webView error: " + e2);
            }
        }
    }

    public final AdPayload getAdvertisement() {
        return this.advertisement;
    }

    public final Placement getPlacement() {
        return this.placement;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger.Companion.d(TAG, "onAttachedToWindow()");
        if (!this.presenterStarted.getAndSet(true)) {
            MRAIDPresenter mRAIDPresenter = this.presenter;
            if (mRAIDPresenter != null) {
                mRAIDPresenter.prepare();
            }
            getImpressionTracker().addView(this, new BannerView$onAttachedToWindow$1(this));
        }
        renderAd();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        boolean z2;
        super.onWindowVisibilityChanged(i2);
        if (i2 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        setAdVisibility(z2);
    }
}
