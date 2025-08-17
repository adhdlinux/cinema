package com.vungle.ads.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.AdExpiredError;
import com.vungle.ads.AdExpiredOnPlayError;
import com.vungle.ads.AdNotLoadedCantPlay;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.ConcurrentPlaybackUnsupported;
import com.vungle.ads.InvalidAdStateError;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.VungleAdSize;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.SDKExecutors;
import com.vungle.ads.internal.load.AdLoaderCallback;
import com.vungle.ads.internal.load.BaseAdLoader;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.presenter.AdPlayCallback;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.task.CleanupJob;
import com.vungle.ads.internal.task.JobRunner;
import com.vungle.ads.internal.ui.AdActivity;
import com.vungle.ads.internal.ui.PresenterAdOpenCallback;
import com.vungle.ads.internal.util.ActivityManager;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

public abstract class AdInternal implements AdLoaderCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "AdInternal";
    /* access modifiers changed from: private */
    public static final boolean THROW_ON_ILLEGAL_TRANSITION = false;
    private static final Json json = JsonKt.b((Json) null, AdInternal$Companion$json$1.INSTANCE, 1, (Object) null);
    private AdLoaderCallback adLoaderCallback;
    private AdState adState = AdState.NEW;
    private AdPayload advertisement;
    private BaseAdLoader baseAdLoader;
    private BidPayload bidPayload;
    private final Context context;
    private TimeIntervalMetric loadMetric;
    private LogEntry logEntry;
    private Placement placement;
    private WeakReference<Context> playContext;
    private TimeIntervalMetric requestMetric;
    private final TimeIntervalMetric showToValidationMetric;
    private final Lazy signalManager$delegate;
    private final TimeIntervalMetric validationToPresentMetric;
    private final Lazy vungleApiClient$delegate;

    public enum AdState {
        ;

        static final class ERROR extends AdState {
            ERROR(String str, int i2) {
                super(str, i2, (DefaultConstructorMarker) null);
            }

            public boolean canTransitionTo(AdState adState) {
                Intrinsics.f(adState, "adState");
                if (adState == AdState.FINISHED) {
                    return true;
                }
                return false;
            }
        }

        static final class FINISHED extends AdState {
            FINISHED(String str, int i2) {
                super(str, i2, (DefaultConstructorMarker) null);
            }

            public boolean canTransitionTo(AdState adState) {
                Intrinsics.f(adState, "adState");
                return false;
            }
        }

        static final class LOADING extends AdState {
            LOADING(String str, int i2) {
                super(str, i2, (DefaultConstructorMarker) null);
            }

            public boolean canTransitionTo(AdState adState) {
                Intrinsics.f(adState, "adState");
                if (adState == AdState.READY || adState == AdState.ERROR) {
                    return true;
                }
                return false;
            }
        }

        static final class NEW extends AdState {
            NEW(String str, int i2) {
                super(str, i2, (DefaultConstructorMarker) null);
            }

            public boolean canTransitionTo(AdState adState) {
                Intrinsics.f(adState, "adState");
                if (adState == AdState.LOADING || adState == AdState.READY || adState == AdState.ERROR) {
                    return true;
                }
                return false;
            }
        }

        static final class PLAYING extends AdState {
            PLAYING(String str, int i2) {
                super(str, i2, (DefaultConstructorMarker) null);
            }

            public boolean canTransitionTo(AdState adState) {
                Intrinsics.f(adState, "adState");
                if (adState == AdState.FINISHED || adState == AdState.ERROR) {
                    return true;
                }
                return false;
            }
        }

        static final class READY extends AdState {
            READY(String str, int i2) {
                super(str, i2, (DefaultConstructorMarker) null);
            }

            public boolean canTransitionTo(AdState adState) {
                Intrinsics.f(adState, "adState");
                if (adState == AdState.PLAYING || adState == AdState.FINISHED || adState == AdState.ERROR) {
                    return true;
                }
                return false;
            }
        }

        public abstract boolean canTransitionTo(AdState adState);

        public final boolean isTerminalState() {
            return CollectionsKt__CollectionsKt.i(FINISHED, ERROR).contains(this);
        }

        public final AdState transitionTo(AdState adState) {
            Intrinsics.f(adState, "adState");
            if (this != adState && !canTransitionTo(adState)) {
                String str = "Cannot transition from " + name() + " to " + adState.name();
                if (!AdInternal.THROW_ON_ILLEGAL_TRANSITION) {
                    Logger.Companion.e(AdInternal.TAG, "Illegal state transition", new IllegalStateException(str));
                } else {
                    throw new IllegalStateException(str);
                }
            }
            return adState;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static /* synthetic */ void getJson$annotations() {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdState.values().length];
            iArr[AdState.NEW.ordinal()] = 1;
            iArr[AdState.LOADING.ordinal()] = 2;
            iArr[AdState.READY.ordinal()] = 3;
            iArr[AdState.PLAYING.ordinal()] = 4;
            iArr[AdState.FINISHED.ordinal()] = 5;
            iArr[AdState.ERROR.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AdInternal(Context context2) {
        Intrinsics.f(context2, "context");
        this.context = context2;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        this.vungleApiClient$delegate = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new AdInternal$special$$inlined$inject$1(context2));
        this.showToValidationMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS);
        this.validationToPresentMetric = new TimeIntervalMetric(Sdk$SDKMetric.SDKMetricType.AD_VALIDATION_TO_PRESENT_DURATION_MS);
        this.signalManager$delegate = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new AdInternal$special$$inlined$inject$2(context2));
    }

    /* renamed from: _set_adState_$lambda-1$lambda-0  reason: not valid java name */
    private static final JobRunner m137_set_adState_$lambda1$lambda0(Lazy<? extends JobRunner> lazy) {
        return (JobRunner) lazy.getValue();
    }

    public static /* synthetic */ VungleError canPlayAd$default(AdInternal adInternal, boolean z2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z2 = false;
            }
            return adInternal.canPlayAd(z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: canPlayAd");
    }

    private final SignalManager getSignalManager() {
        return (SignalManager) this.signalManager$delegate.getValue();
    }

    private final VungleApiClient getVungleApiClient() {
        return (VungleApiClient) this.vungleApiClient$delegate.getValue();
    }

    /* renamed from: loadAd$lambda-2  reason: not valid java name */
    private static final OMInjector m138loadAd$lambda2(Lazy<OMInjector> lazy) {
        return lazy.getValue();
    }

    /* renamed from: loadAd$lambda-3  reason: not valid java name */
    private static final SDKExecutors m139loadAd$lambda3(Lazy<SDKExecutors> lazy) {
        return lazy.getValue();
    }

    /* renamed from: loadAd$lambda-4  reason: not valid java name */
    private static final PathProvider m140loadAd$lambda4(Lazy<PathProvider> lazy) {
        return lazy.getValue();
    }

    /* renamed from: loadAd$lambda-5  reason: not valid java name */
    private static final Downloader m141loadAd$lambda5(Lazy<? extends Downloader> lazy) {
        return (Downloader) lazy.getValue();
    }

    /* renamed from: onSuccess$lambda-10$lambda-7  reason: not valid java name */
    private static final SDKExecutors m142onSuccess$lambda10$lambda7(Lazy<SDKExecutors> lazy) {
        return lazy.getValue();
    }

    /* renamed from: onSuccess$lambda-10$lambda-8  reason: not valid java name */
    private static final PathProvider m143onSuccess$lambda10$lambda8(Lazy<PathProvider> lazy) {
        return lazy.getValue();
    }

    public void adLoadedAndUpdateConfigure$vungle_ads_release(AdPayload adPayload) {
        Intrinsics.f(adPayload, "advertisement");
    }

    public final VungleError canPlayAd(boolean z2) {
        VungleError vungleError;
        AdPayload adPayload = this.advertisement;
        if (adPayload == null) {
            vungleError = new AdNotLoadedCantPlay("adv is null on onPlay=" + z2);
        } else {
            boolean z3 = false;
            if (adPayload != null && adPayload.hasExpired()) {
                z3 = true;
            }
            if (!z3) {
                AdState adState2 = this.adState;
                if (adState2 == AdState.PLAYING) {
                    vungleError = new ConcurrentPlaybackUnsupported();
                } else if (adState2 == AdState.READY) {
                    return null;
                } else {
                    Sdk$SDKError.Reason reason = Sdk$SDKError.Reason.INVALID_PLAY_PARAMETER;
                    vungleError = new InvalidAdStateError(reason, this.adState + " is not READY");
                }
            } else if (z2) {
                vungleError = new AdExpiredOnPlayError();
            } else {
                vungleError = new AdExpiredError("adv has expired on canPlayAd()");
            }
        }
        if (z2) {
            vungleError.setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
        }
        return vungleError;
    }

    public final void cancelDownload$vungle_ads_release() {
        BaseAdLoader baseAdLoader2 = this.baseAdLoader;
        if (baseAdLoader2 != null) {
            baseAdLoader2.cancel();
        }
    }

    public abstract VungleAdSize getAdSizeForAdRequest();

    public final AdState getAdState() {
        return this.adState;
    }

    public final AdPayload getAdvertisement() {
        return this.advertisement;
    }

    public final BidPayload getBidPayload() {
        return this.bidPayload;
    }

    public final Context getContext() {
        return this.context;
    }

    public final LogEntry getLogEntry$vungle_ads_release() {
        return this.logEntry;
    }

    public final Placement getPlacement() {
        return this.placement;
    }

    public final TimeIntervalMetric getShowToValidationMetric$vungle_ads_release() {
        return this.showToValidationMetric;
    }

    public final TimeIntervalMetric getValidationToPresentMetric$vungle_ads_release() {
        return this.validationToPresentMetric;
    }

    public final boolean isErrorTerminal$vungle_ads_release(int i2) {
        return this.adState == AdState.READY && i2 == 304;
    }

    public abstract boolean isValidAdSize(VungleAdSize vungleAdSize);

    public abstract boolean isValidAdTypeForPlacement(Placement placement2);

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0088, code lost:
        if (r2 == false) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009c, code lost:
        if (r2 == false) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009e, code lost:
        r9.onFailure(new com.vungle.ads.InvalidWaterfallPlacementError(r0).setLogEntry$vungle_ads_release(r1.logEntry).logError$vungle_ads_release());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b0, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void loadAd(java.lang.String r27, java.lang.String r28, com.vungle.ads.internal.load.AdLoaderCallback r29) {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
            r8 = r28
            r9 = r29
            java.lang.String r2 = "placementId"
            kotlin.jvm.internal.Intrinsics.f(r0, r2)
            java.lang.String r2 = "adLoaderCallback"
            kotlin.jvm.internal.Intrinsics.f(r9, r2)
            com.vungle.ads.AnalyticsClient r10 = com.vungle.ads.AnalyticsClient.INSTANCE
            com.vungle.ads.internal.protos.Sdk$SDKMetric$SDKMetricType r11 = com.vungle.ads.internal.protos.Sdk$SDKMetric.SDKMetricType.LOAD_AD_API
            r12 = 0
            com.vungle.ads.internal.util.LogEntry r14 = r1.logEntry
            r15 = 0
            r16 = 10
            r17 = 0
            com.vungle.ads.AnalyticsClient.logMetric$vungle_ads_release$default(r10, r11, r12, r14, r15, r16, r17)
            com.vungle.ads.internal.protos.Sdk$SDKMetric$SDKMetricType r2 = com.vungle.ads.internal.protos.Sdk$SDKMetric.SDKMetricType.AD_LOAD_TO_CALLBACK_ADO_DURATION_MS
            com.vungle.ads.TimeIntervalMetric r3 = new com.vungle.ads.TimeIntervalMetric
            r3.<init>(r2)
            r1.loadMetric = r3
            r3.markStart()
            r1.adLoaderCallback = r9
            com.vungle.ads.VungleAds$Companion r2 = com.vungle.ads.VungleAds.Companion
            boolean r2 = r2.isInitialized()
            if (r2 != 0) goto L_0x004d
            com.vungle.ads.SdkNotInitialized r0 = new com.vungle.ads.SdkNotInitialized
            java.lang.String r2 = "SDK not initialized"
            r0.<init>(r2)
            com.vungle.ads.internal.util.LogEntry r2 = r1.logEntry
            com.vungle.ads.VungleError r0 = r0.setLogEntry$vungle_ads_release(r2)
            com.vungle.ads.VungleError r0 = r0.logError$vungle_ads_release()
            r9.onFailure(r0)
            return
        L_0x004d:
            com.vungle.ads.internal.ConfigManager r2 = com.vungle.ads.internal.ConfigManager.INSTANCE
            com.vungle.ads.internal.model.Placement r3 = r2.getPlacement(r0)
            r10 = 0
            r11 = 1
            if (r3 == 0) goto L_0x00b1
            r1.placement = r3
            boolean r2 = r1.isValidAdTypeForPlacement(r3)
            if (r2 != 0) goto L_0x0076
            com.vungle.ads.PlacementAdTypeMismatchError r0 = new com.vungle.ads.PlacementAdTypeMismatchError
            java.lang.String r2 = r3.getReferenceId()
            r0.<init>(r2)
            com.vungle.ads.internal.util.LogEntry r2 = r1.logEntry
            com.vungle.ads.VungleError r0 = r0.setLogEntry$vungle_ads_release(r2)
            com.vungle.ads.VungleError r0 = r0.logError$vungle_ads_release()
            r9.onFailure(r0)
            return
        L_0x0076:
            boolean r2 = r3.getHeaderBidding()
            if (r2 == 0) goto L_0x008a
            if (r8 == 0) goto L_0x0087
            int r2 = r28.length()
            if (r2 != 0) goto L_0x0085
            goto L_0x0087
        L_0x0085:
            r2 = 0
            goto L_0x0088
        L_0x0087:
            r2 = 1
        L_0x0088:
            if (r2 != 0) goto L_0x009e
        L_0x008a:
            boolean r2 = r3.getHeaderBidding()
            if (r2 != 0) goto L_0x00ca
            if (r8 == 0) goto L_0x009b
            int r2 = r28.length()
            if (r2 != 0) goto L_0x0099
            goto L_0x009b
        L_0x0099:
            r2 = 0
            goto L_0x009c
        L_0x009b:
            r2 = 1
        L_0x009c:
            if (r2 != 0) goto L_0x00ca
        L_0x009e:
            com.vungle.ads.InvalidWaterfallPlacementError r2 = new com.vungle.ads.InvalidWaterfallPlacementError
            r2.<init>(r0)
            com.vungle.ads.internal.util.LogEntry r0 = r1.logEntry
            com.vungle.ads.VungleError r0 = r2.setLogEntry$vungle_ads_release(r0)
            com.vungle.ads.VungleError r0 = r0.logError$vungle_ads_release()
            r9.onFailure(r0)
            return
        L_0x00b1:
            long r2 = r2.configLastValidatedTimestamp()
            r4 = -1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x025a
            com.vungle.ads.internal.model.Placement r12 = new com.vungle.ads.internal.model.Placement
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r12
            r3 = r27
            r2.<init>((java.lang.String) r3, (boolean) r4, (java.lang.String) r5, (int) r6, (kotlin.jvm.internal.DefaultConstructorMarker) r7)
            r1.placement = r12
            r3 = r12
        L_0x00ca:
            com.vungle.ads.VungleAdSize r0 = r26.getAdSizeForAdRequest()
            boolean r2 = r1.isValidAdSize(r0)
            r4 = 0
            if (r2 != 0) goto L_0x00ee
            com.vungle.ads.InvalidBannerSizeError r2 = new com.vungle.ads.InvalidBannerSizeError
            if (r0 == 0) goto L_0x00dd
            java.lang.String r4 = r0.toString()
        L_0x00dd:
            r2.<init>(r4)
            com.vungle.ads.internal.util.LogEntry r0 = r1.logEntry
            com.vungle.ads.VungleError r0 = r2.setLogEntry$vungle_ads_release(r0)
            com.vungle.ads.VungleError r0 = r0.logError$vungle_ads_release()
            r9.onFailure(r0)
            return
        L_0x00ee:
            com.vungle.ads.internal.AdInternal$AdState r2 = r1.adState
            com.vungle.ads.internal.AdInternal$AdState r5 = com.vungle.ads.internal.AdInternal.AdState.NEW
            if (r2 == r5) goto L_0x013f
            int[] r0 = com.vungle.ads.internal.AdInternal.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r0 = r0[r2]
            switch(r0) {
                case 1: goto L_0x0139;
                case 2: goto L_0x0111;
                case 3: goto L_0x010e;
                case 4: goto L_0x010b;
                case 5: goto L_0x0108;
                case 6: goto L_0x0105;
                default: goto L_0x00ff;
            }
        L_0x00ff:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0105:
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r0 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.AD_ALREADY_FAILED
            goto L_0x0113
        L_0x0108:
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r0 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.AD_CONSUMED
            goto L_0x0113
        L_0x010b:
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r0 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.AD_IS_PLAYING
            goto L_0x0113
        L_0x010e:
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r0 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.AD_ALREADY_LOADED
            goto L_0x0113
        L_0x0111:
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r0 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.AD_IS_LOADING
        L_0x0113:
            com.vungle.ads.InvalidAdStateError r2 = new com.vungle.ads.InvalidAdStateError
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.vungle.ads.internal.AdInternal$AdState r4 = r1.adState
            r3.append(r4)
            java.lang.String r4 = " state is incorrect for load"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r0, r3)
            com.vungle.ads.internal.util.LogEntry r0 = r1.logEntry
            com.vungle.ads.VungleError r0 = r2.setLogEntry$vungle_ads_release(r0)
            com.vungle.ads.VungleError r0 = r0.logError$vungle_ads_release()
            r9.onFailure(r0)
            return
        L_0x0139:
            kotlin.NotImplementedError r0 = new kotlin.NotImplementedError
            r0.<init>(r4, r11, r4)
            throw r0
        L_0x013f:
            com.vungle.ads.internal.protos.Sdk$SDKMetric$SDKMetricType r2 = com.vungle.ads.internal.protos.Sdk$SDKMetric.SDKMetricType.AD_REQUEST_TO_CALLBACK_ADO_DURATION_MS
            com.vungle.ads.TimeIntervalMetric r5 = new com.vungle.ads.TimeIntervalMetric
            r5.<init>(r2)
            r1.requestMetric = r5
            r5.markStart()
            if (r8 == 0) goto L_0x0156
            int r2 = r28.length()
            if (r2 != 0) goto L_0x0154
            goto L_0x0156
        L_0x0154:
            r2 = 0
            goto L_0x0157
        L_0x0156:
            r2 = 1
        L_0x0157:
            if (r2 != 0) goto L_0x01b8
            kotlinx.serialization.json.Json r2 = json     // Catch:{ IllegalArgumentException -> 0x018f, all -> 0x0177 }
            kotlinx.serialization.modules.SerializersModule r5 = r2.a()     // Catch:{ IllegalArgumentException -> 0x018f, all -> 0x0177 }
            java.lang.Class<com.vungle.ads.internal.model.BidPayload> r6 = com.vungle.ads.internal.model.BidPayload.class
            kotlin.reflect.KType r6 = kotlin.jvm.internal.Reflection.h(r6)     // Catch:{ IllegalArgumentException -> 0x018f, all -> 0x0177 }
            kotlinx.serialization.KSerializer r5 = kotlinx.serialization.SerializersKt.b(r5, r6)     // Catch:{ IllegalArgumentException -> 0x018f, all -> 0x0177 }
            java.lang.String r6 = "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>"
            kotlin.jvm.internal.Intrinsics.d(r5, r6)     // Catch:{ IllegalArgumentException -> 0x018f, all -> 0x0177 }
            java.lang.Object r2 = r2.b(r5, r8)     // Catch:{ IllegalArgumentException -> 0x018f, all -> 0x0177 }
            com.vungle.ads.internal.model.BidPayload r2 = (com.vungle.ads.internal.model.BidPayload) r2     // Catch:{ IllegalArgumentException -> 0x018f, all -> 0x0177 }
            r1.bidPayload = r2     // Catch:{ IllegalArgumentException -> 0x018f, all -> 0x0177 }
            goto L_0x01b8
        L_0x0177:
            r0 = move-exception
            com.vungle.ads.AdMarkupJsonError r2 = new com.vungle.ads.AdMarkupJsonError
            java.lang.String r0 = r0.getLocalizedMessage()
            r2.<init>(r0)
            com.vungle.ads.internal.util.LogEntry r0 = r1.logEntry
            com.vungle.ads.VungleError r0 = r2.setLogEntry$vungle_ads_release(r0)
            com.vungle.ads.VungleError r0 = r0.logError$vungle_ads_release()
            r9.onFailure(r0)
            return
        L_0x018f:
            r0 = move-exception
            com.vungle.ads.AdMarkupInvalidError r2 = new com.vungle.ads.AdMarkupInvalidError
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unable to decode payload into BidPayload object. Error: "
            r3.append(r4)
            java.lang.String r0 = r0.getLocalizedMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            com.vungle.ads.internal.util.LogEntry r0 = r1.logEntry
            com.vungle.ads.VungleError r0 = r2.setLogEntry$vungle_ads_release(r0)
            com.vungle.ads.VungleError r0 = r0.logError$vungle_ads_release()
            r9.onFailure(r0)
            return
        L_0x01b8:
            com.vungle.ads.internal.AdInternal$AdState r2 = com.vungle.ads.internal.AdInternal.AdState.LOADING
            r1.setAdState(r2)
            com.vungle.ads.ServiceLocator$Companion r2 = com.vungle.ads.ServiceLocator.Companion
            android.content.Context r2 = r1.context
            kotlin.LazyThreadSafetyMode r5 = kotlin.LazyThreadSafetyMode.SYNCHRONIZED
            com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$1 r6 = new com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$1
            r6.<init>(r2)
            kotlin.Lazy r2 = kotlin.LazyKt__LazyJVMKt.a(r5, r6)
            android.content.Context r6 = r1.context
            com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$2 r7 = new com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$2
            r7.<init>(r6)
            kotlin.Lazy r6 = kotlin.LazyKt__LazyJVMKt.a(r5, r7)
            android.content.Context r7 = r1.context
            com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$3 r9 = new com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$3
            r9.<init>(r7)
            kotlin.Lazy r7 = kotlin.LazyKt__LazyJVMKt.a(r5, r9)
            android.content.Context r9 = r1.context
            com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$4 r12 = new com.vungle.ads.internal.AdInternal$loadAd$$inlined$inject$4
            r12.<init>(r9)
            kotlin.Lazy r5 = kotlin.LazyKt__LazyJVMKt.a(r5, r12)
            if (r8 == 0) goto L_0x01f5
            int r8 = r28.length()
            if (r8 != 0) goto L_0x01f6
        L_0x01f5:
            r10 = 1
        L_0x01f6:
            if (r10 == 0) goto L_0x021e
            com.vungle.ads.internal.load.AdRequest r8 = new com.vungle.ads.internal.load.AdRequest
            r8.<init>(r3, r4, r0)
            com.vungle.ads.internal.load.DefaultAdLoader r0 = new com.vungle.ads.internal.load.DefaultAdLoader
            android.content.Context r12 = r1.context
            com.vungle.ads.internal.network.VungleApiClient r13 = r26.getVungleApiClient()
            com.vungle.ads.internal.executor.SDKExecutors r14 = m139loadAd$lambda3(r6)
            com.vungle.ads.internal.omsdk.OMInjector r15 = m138loadAd$lambda2(r2)
            com.vungle.ads.internal.downloader.Downloader r16 = m141loadAd$lambda5(r5)
            com.vungle.ads.internal.util.PathProvider r17 = m140loadAd$lambda4(r7)
            r11 = r0
            r18 = r8
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)
            r1.baseAdLoader = r0
            goto L_0x0248
        L_0x021e:
            com.vungle.ads.internal.load.AdRequest r4 = new com.vungle.ads.internal.load.AdRequest
            com.vungle.ads.internal.model.BidPayload r8 = r1.bidPayload
            r4.<init>(r3, r8, r0)
            com.vungle.ads.internal.load.RealtimeAdLoader r0 = new com.vungle.ads.internal.load.RealtimeAdLoader
            android.content.Context r3 = r1.context
            com.vungle.ads.internal.network.VungleApiClient r20 = r26.getVungleApiClient()
            com.vungle.ads.internal.executor.SDKExecutors r21 = m139loadAd$lambda3(r6)
            com.vungle.ads.internal.omsdk.OMInjector r22 = m138loadAd$lambda2(r2)
            com.vungle.ads.internal.downloader.Downloader r23 = m141loadAd$lambda5(r5)
            com.vungle.ads.internal.util.PathProvider r24 = m140loadAd$lambda4(r7)
            r18 = r0
            r19 = r3
            r25 = r4
            r18.<init>(r19, r20, r21, r22, r23, r24, r25)
            r1.baseAdLoader = r0
        L_0x0248:
            com.vungle.ads.internal.load.BaseAdLoader r0 = r1.baseAdLoader
            if (r0 != 0) goto L_0x024d
            goto L_0x0252
        L_0x024d:
            com.vungle.ads.internal.util.LogEntry r2 = r1.logEntry
            r0.setLogEntry$vungle_ads_release(r2)
        L_0x0252:
            com.vungle.ads.internal.load.BaseAdLoader r0 = r1.baseAdLoader
            if (r0 == 0) goto L_0x0259
            r0.loadAd(r1)
        L_0x0259:
            return
        L_0x025a:
            com.vungle.ads.PlacementNotFoundError r2 = new com.vungle.ads.PlacementNotFoundError
            r2.<init>(r0)
            com.vungle.ads.internal.util.LogEntry r0 = r1.logEntry
            com.vungle.ads.VungleError r0 = r2.setLogEntry$vungle_ads_release(r0)
            com.vungle.ads.VungleError r0 = r0.logError$vungle_ads_release()
            r9.onFailure(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.AdInternal.loadAd(java.lang.String, java.lang.String, com.vungle.ads.internal.load.AdLoaderCallback):void");
    }

    public void onFailure(VungleError vungleError) {
        Intrinsics.f(vungleError, MRAIDPresenter.ERROR);
        setAdState(AdState.ERROR);
        TimeIntervalMetric timeIntervalMetric = this.loadMetric;
        if (timeIntervalMetric != null) {
            timeIntervalMetric.setMetricType(Sdk$SDKMetric.SDKMetricType.AD_LOAD_TO_FAIL_CALLBACK_DURATION_MS);
            timeIntervalMetric.markEnd();
            AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(timeIntervalMetric, this.logEntry, String.valueOf(vungleError.getCode()));
        }
        AdLoaderCallback adLoaderCallback2 = this.adLoaderCallback;
        if (adLoaderCallback2 != null) {
            adLoaderCallback2.onFailure(vungleError);
        }
    }

    public void onSuccess(AdPayload adPayload) {
        Intrinsics.f(adPayload, "advertisement");
        this.advertisement = adPayload;
        setAdState(AdState.READY);
        adLoadedAndUpdateConfigure$vungle_ads_release(adPayload);
        AdLoaderCallback adLoaderCallback2 = this.adLoaderCallback;
        if (adLoaderCallback2 != null) {
            adLoaderCallback2.onSuccess(adPayload);
        }
        TimeIntervalMetric timeIntervalMetric = this.loadMetric;
        if (timeIntervalMetric != null) {
            if (!adPayload.adLoadOptimizationEnabled()) {
                timeIntervalMetric.setMetricType(Sdk$SDKMetric.SDKMetricType.AD_LOAD_TO_CALLBACK_DURATION_MS);
            }
            timeIntervalMetric.markEnd();
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, timeIntervalMetric, this.logEntry, (String) null, 4, (Object) null);
        }
        TimeIntervalMetric timeIntervalMetric2 = this.requestMetric;
        if (timeIntervalMetric2 != null) {
            if (!adPayload.adLoadOptimizationEnabled()) {
                timeIntervalMetric2.setMetricType(Sdk$SDKMetric.SDKMetricType.AD_REQUEST_TO_CALLBACK_DURATION_MS);
            }
            timeIntervalMetric2.markEnd();
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, timeIntervalMetric2, this.logEntry, (String) null, 4, (Object) null);
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            Context context2 = this.context;
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
            Lazy a2 = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new AdInternal$onSuccess$lambda10$$inlined$inject$1(context2));
            Lazy a3 = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new AdInternal$onSuccess$lambda10$$inlined$inject$2(this.context));
            List tpatUrls$default = AdPayload.getTpatUrls$default(adPayload, Constants.AD_LOAD_DURATION, String.valueOf(timeIntervalMetric2.getValue()), (String) null, 4, (Object) null);
            if (tpatUrls$default != null) {
                new TpatSender(getVungleApiClient(), this.logEntry, m142onSuccess$lambda10$lambda7(a2).getIoExecutor(), m143onSuccess$lambda10$lambda8(a3), getSignalManager()).sendTpats(tpatUrls$default, m142onSuccess$lambda10$lambda7(a2).getJobExecutor());
            }
        }
    }

    public final void play(Context context2, AdPlayCallback adPlayCallback) {
        WeakReference<Context> weakReference;
        Intrinsics.f(adPlayCallback, "adPlayCallback");
        this.showToValidationMetric.markStart();
        if (context2 != null) {
            weakReference = new WeakReference<>(context2);
        } else {
            weakReference = null;
        }
        this.playContext = weakReference;
        VungleError canPlayAd = canPlayAd(true);
        if (canPlayAd != null) {
            adPlayCallback.onFailure(canPlayAd);
            if (isErrorTerminal$vungle_ads_release(canPlayAd.getCode())) {
                setAdState(AdState.ERROR);
                return;
            }
            return;
        }
        AdPayload adPayload = this.advertisement;
        if (adPayload != null) {
            AdInternal$play$callbackWrapper$1 adInternal$play$callbackWrapper$1 = new AdInternal$play$callbackWrapper$1(adPlayCallback, this);
            cancelDownload$vungle_ads_release();
            renderAd$vungle_ads_release(adInternal$play$callbackWrapper$1, adPayload);
        }
    }

    public void renderAd$vungle_ads_release(AdPlayCallback adPlayCallback, AdPayload adPayload) {
        Context context2;
        Intrinsics.f(adPayload, "advertisement");
        AdActivity.Companion companion = AdActivity.Companion;
        companion.setEventListener$vungle_ads_release(new AdInternal$renderAd$1(adPlayCallback, this.placement));
        companion.setAdvertisement$vungle_ads_release(adPayload);
        companion.setBidPayload$vungle_ads_release(this.bidPayload);
        WeakReference<Context> weakReference = this.playContext;
        if (weakReference == null || (context2 = weakReference.get()) == null) {
            context2 = this.context;
        }
        Intrinsics.e(context2, "playContext?.get() ?: context");
        Placement placement2 = this.placement;
        if (placement2 != null) {
            Intent createIntent = companion.createIntent(context2, placement2.getReferenceId(), adPayload.eventId());
            ActivityManager.Companion companion2 = ActivityManager.Companion;
            if (!companion2.isForeground()) {
                Logger.Companion.d(TAG, "The ad activity is in background on play.");
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(Sdk$SDKMetric.SDKMetricType.VIEW_NOT_VISIBLE_ON_PLAY), this.logEntry, (String) null, 4, (Object) null);
            }
            this.showToValidationMetric.markEnd();
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.showToValidationMetric, this.logEntry, (String) null, 4, (Object) null);
            this.validationToPresentMetric.markStart();
            companion2.startWhenForeground(context2, (Intent) null, createIntent, (PresenterAdOpenCallback) null);
        }
    }

    public final void setAdState(AdState adState2) {
        AdPayload adPayload;
        String eventId;
        Intrinsics.f(adState2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (!(!adState2.isTerminalState() || (adPayload = this.advertisement) == null || (eventId = adPayload.eventId()) == null)) {
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            Lazy a2 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new AdInternal$_set_adState_$lambda1$$inlined$inject$1(this.context));
            m137_set_adState_$lambda1$lambda0(a2).execute(CleanupJob.Companion.makeJobInfo(eventId));
        }
        this.adState = this.adState.transitionTo(adState2);
    }

    public final void setAdvertisement(AdPayload adPayload) {
        this.advertisement = adPayload;
    }

    public final void setBidPayload(BidPayload bidPayload2) {
        this.bidPayload = bidPayload2;
    }

    public final void setLogEntry$vungle_ads_release(LogEntry logEntry2) {
        this.logEntry = logEntry2;
    }

    public final void setPlacement(Placement placement2) {
        this.placement = placement2;
    }
}
