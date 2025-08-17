package com.vungle.ads.internal;

import android.content.Context;
import android.os.Build;
import androidx.core.content.PermissionChecker;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.InitializationListener;
import com.vungle.ads.InvalidAppId;
import com.vungle.ads.OutOfMemory;
import com.vungle.ads.SdkNotInitialized;
import com.vungle.ads.SdkVersionTooLow;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.VungleAds;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.load.MraidJsLoader;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.network.VungleHeader;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.task.CleanupJob;
import com.vungle.ads.internal.task.JobRunner;
import com.vungle.ads.internal.task.ResendTpatJob;
import com.vungle.ads.internal.util.ActivityManager;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import com.vungle.ads.internal.util.ThreadUtil;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class VungleInitializer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "VungleInitializer";
    private final CopyOnWriteArrayList<InitializationListener> initializationCallbackArray = new CopyOnWriteArrayList<>();
    private AtomicBoolean isInitialized = new AtomicBoolean(false);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void configure(Context context, String str) {
        boolean z2;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        Lazy a2 = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new VungleInitializer$configure$$inlined$inject$1(context));
        try {
            Lazy a3 = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new VungleInitializer$configure$$inlined$inject$2(context));
            ConfigManager configManager = ConfigManager.INSTANCE;
            ConfigPayload cachedConfig = configManager.getCachedConfig(m152configure$lambda5(a3), str);
            if (cachedConfig != null) {
                ConfigManager.initWithConfig$vungle_ads_release$default(configManager, context, cachedConfig, true, (SingleValueMetric) null, 8, (Object) null);
                z2 = true;
            } else {
                z2 = false;
            }
            AnalyticsClient.INSTANCE.init$vungle_ads_release(m151configure$lambda4(a2), m153configure$lambda6(LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new VungleInitializer$configure$$inlined$inject$3(context))).getLoggerExecutor(), configManager.getLogLevel(), configManager.getMetricsEnabled());
            this.isInitialized.set(true);
            onInitSuccess();
            Logger.Companion companion2 = Logger.Companion;
            companion2.d(TAG, "Running cleanup and resend tpat jobs. " + Thread.currentThread().getId());
            Lazy a4 = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new VungleInitializer$configure$$inlined$inject$4(context));
            m154configure$lambda7(a4).execute(CleanupJob.Companion.makeJobInfo$default(CleanupJob.Companion, (String) null, 1, (Object) null));
            m154configure$lambda7(a4).execute(ResendTpatJob.Companion.makeJobInfo());
            if (!z2) {
                configManager.fetchConfigAsync$vungle_ads_release(context, new VungleInitializer$configure$1(this, context));
            } else {
                downloadMraidJs(context);
            }
        } catch (Throwable th) {
            Logger.Companion.e(TAG, "Cannot get config", th);
        }
    }

    /* renamed from: configure$lambda-4  reason: not valid java name */
    private static final VungleApiClient m151configure$lambda4(Lazy<VungleApiClient> lazy) {
        return lazy.getValue();
    }

    /* renamed from: configure$lambda-5  reason: not valid java name */
    private static final FilePreferences m152configure$lambda5(Lazy<FilePreferences> lazy) {
        return lazy.getValue();
    }

    /* renamed from: configure$lambda-6  reason: not valid java name */
    private static final Executors m153configure$lambda6(Lazy<? extends Executors> lazy) {
        return (Executors) lazy.getValue();
    }

    /* renamed from: configure$lambda-7  reason: not valid java name */
    private static final JobRunner m154configure$lambda7(Lazy<? extends JobRunner> lazy) {
        return (JobRunner) lazy.getValue();
    }

    /* access modifiers changed from: private */
    public final void downloadMraidJs(Context context) {
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        MraidJsLoader.downloadJs$default(MraidJsLoader.INSTANCE, m156downloadMraidJs$lambda8(LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new VungleInitializer$downloadMraidJs$$inlined$inject$1(context))), m157downloadMraidJs$lambda9(LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new VungleInitializer$downloadMraidJs$$inlined$inject$2(context))), m155downloadMraidJs$lambda10(LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new VungleInitializer$downloadMraidJs$$inlined$inject$3(context))).getBackgroundExecutor(), (MraidJsLoader.DownloadResultListener) null, (AdPayload) null, 24, (Object) null);
    }

    /* renamed from: downloadMraidJs$lambda-10  reason: not valid java name */
    private static final Executors m155downloadMraidJs$lambda10(Lazy<? extends Executors> lazy) {
        return (Executors) lazy.getValue();
    }

    /* renamed from: downloadMraidJs$lambda-8  reason: not valid java name */
    private static final PathProvider m156downloadMraidJs$lambda8(Lazy<PathProvider> lazy) {
        return lazy.getValue();
    }

    /* renamed from: downloadMraidJs$lambda-9  reason: not valid java name */
    private static final Downloader m157downloadMraidJs$lambda9(Lazy<? extends Downloader> lazy) {
        return (Downloader) lazy.getValue();
    }

    private final boolean hasInvalidChar(String str) {
        boolean z2;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isLetterOrDigit(charAt) || charAt == '.') {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: init$lambda-0  reason: not valid java name */
    private static final Executors m158init$lambda0(Lazy<? extends Executors> lazy) {
        return (Executors) lazy.getValue();
    }

    /* renamed from: init$lambda-1  reason: not valid java name */
    private static final VungleApiClient m159init$lambda1(Lazy<VungleApiClient> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-2  reason: not valid java name */
    public static final void m160init$lambda2(Context context, String str, VungleInitializer vungleInitializer, Lazy lazy) {
        Intrinsics.f(context, "$context");
        Intrinsics.f(str, "$appId");
        Intrinsics.f(vungleInitializer, "this$0");
        Intrinsics.f(lazy, "$vungleApiClient$delegate");
        PrivacyManager.INSTANCE.init(context);
        m159init$lambda1(lazy).initialize(str);
        vungleInitializer.configure(context, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-3  reason: not valid java name */
    public static final void m161init$lambda3(VungleInitializer vungleInitializer) {
        Intrinsics.f(vungleInitializer, "this$0");
        vungleInitializer.onInitError(new OutOfMemory("Config: Out of Memory").logError$vungle_ads_release());
    }

    private final boolean isAppIdInvalid(String str) {
        return StringsKt__StringsJVMKt.v(str) || hasInvalidChar(str);
    }

    public static /* synthetic */ void isInitialized$vungle_ads_release$annotations() {
    }

    private final void onInitError(VungleError vungleError) {
        ThreadUtil.INSTANCE.runOnUiThread(new e(this, vungleError));
        String localizedMessage = vungleError.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = "Exception code is " + vungleError.getCode();
        }
        Logger.Companion.e(TAG, localizedMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: onInitError$lambda-12  reason: not valid java name */
    public static final void m162onInitError$lambda12(VungleInitializer vungleInitializer, VungleError vungleError) {
        Intrinsics.f(vungleInitializer, "this$0");
        Intrinsics.f(vungleError, "$exception");
        Logger.Companion.e(TAG, "onError");
        for (InitializationListener onError : vungleInitializer.initializationCallbackArray) {
            onError.onError(vungleError);
        }
        vungleInitializer.initializationCallbackArray.clear();
    }

    private final void onInitSuccess() {
        Logger.Companion companion = Logger.Companion;
        companion.d(TAG, "onSuccess " + Thread.currentThread().getId());
        ThreadUtil.INSTANCE.runOnUiThread(new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onInitSuccess$lambda-14  reason: not valid java name */
    public static final void m163onInitSuccess$lambda14(VungleInitializer vungleInitializer) {
        Intrinsics.f(vungleInitializer, "this$0");
        for (InitializationListener onSuccess : vungleInitializer.initializationCallbackArray) {
            onSuccess.onSuccess();
        }
        vungleInitializer.initializationCallbackArray.clear();
    }

    public final void deInit$vungle_ads_release() {
        ServiceLocator.Companion.deInit();
        VungleApiClient.Companion.reset$vungle_ads_release();
        this.isInitialized.set(false);
    }

    public final void init(String str, Context context, InitializationListener initializationListener) {
        Intrinsics.f(str, "appId");
        Intrinsics.f(context, "context");
        Intrinsics.f(initializationListener, "initializationCallback");
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(Sdk$SDKMetric.SDKMetricType.SDK_INIT_API), (LogEntry) null, (String) null, 6, (Object) null);
        this.initializationCallbackArray.add(initializationListener);
        ActivityManager.Companion.init(context);
        if (isAppIdInvalid(str)) {
            onInitError(new InvalidAppId("App id invalid: " + str + ", package name: " + context.getPackageName()).logError$vungle_ads_release());
        } else if (Build.VERSION.SDK_INT < 25) {
            Logger.Companion.e(TAG, "SDK is supported only for API versions 25 and above.");
            onInitError(new SdkVersionTooLow("SDK is supported only for API versions 25 and above.").logError$vungle_ads_release());
        } else {
            ConfigManager.INSTANCE.setAppId$vungle_ads_release(str);
            if (this.isInitialized.get()) {
                Logger.Companion.d(TAG, "init already complete");
                onInitSuccess();
            } else if (PermissionChecker.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0 && PermissionChecker.a(context, "android.permission.INTERNET") == 0) {
                ServiceLocator.Companion companion = ServiceLocator.Companion;
                LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
                m158init$lambda0(LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new VungleInitializer$init$$inlined$inject$1(context))).getBackgroundExecutor().execute(new b(context, str, this, LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new VungleInitializer$init$$inlined$inject$2(context))), new c(this));
            } else {
                Logger.Companion.e(TAG, "Network permissions not granted");
                onInitError(new SdkNotInitialized("Network permissions not granted").logError$vungle_ads_release());
            }
        }
    }

    public final boolean isInitialized() {
        return this.isInitialized.get();
    }

    public final AtomicBoolean isInitialized$vungle_ads_release() {
        return this.isInitialized;
    }

    public final void setInitialized$vungle_ads_release(AtomicBoolean atomicBoolean) {
        Intrinsics.f(atomicBoolean, "<set-?>");
        this.isInitialized = atomicBoolean;
    }

    public final void setIntegrationName(VungleAds.WrapperFramework wrapperFramework, String str) {
        boolean z2;
        String str2;
        Intrinsics.f(wrapperFramework, "wrapperFramework");
        Intrinsics.f(str, "wrapperFrameworkVersion");
        if (wrapperFramework == VungleAds.WrapperFramework.none) {
            Logger.Companion.e(TAG, "Wrapper is null or is none");
            return;
        }
        VungleHeader vungleHeader = VungleHeader.INSTANCE;
        String headerUa = vungleHeader.getHeaderUa();
        if (str.length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            str2 = '/' + str;
        } else {
            str2 = "";
        }
        String str3 = wrapperFramework.name() + str2;
        if (StringsKt__StringsKt.L(headerUa, str3, false, 2, (Object) null)) {
            Logger.Companion.w(TAG, "Wrapper info already set");
            return;
        }
        vungleHeader.setHeaderUa(headerUa + ';' + str3);
        if (isInitialized()) {
            Logger.Companion.w(TAG, "VUNGLE WARNING: SDK already initialized, you should've set wrapper info before");
        }
    }
}
