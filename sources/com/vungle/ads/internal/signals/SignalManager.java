package com.vungle.ads.internal.signals;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.facebook.ads.AudienceNetworkActivity;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.UnclosedAd;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.session.UnclosedAdDetector;
import com.vungle.ads.internal.util.ActivityManager;
import com.vungle.ads.internal.util.PathProvider;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

public final class SignalManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String SESSION_COUNT_KEY = "vungle_signal_session_count";
    private static final int SESSION_COUNT_NOT_SET = -1;
    public static final String SESSION_TIME_KEY = "vungle_signal_session_creation_time";
    public static final int SIGNAL_VERSION = 1;
    private static final String TAG = "SignalManager";
    public static final long TWENTY_FOUR_HOURS_MILLIS = 86400000;
    private final Context context;
    private SessionData currentSession;
    private long enterBackgroundTime;
    private long enterForegroundTime = System.currentTimeMillis();
    private final Lazy filePreferences$delegate;
    private final Json json = JsonKt.b((Json) null, SignalManager$json$1.INSTANCE, 1, (Object) null);
    private ConcurrentHashMap<String, Long> mapOfLastLoadTimes = new ConcurrentHashMap<>();
    private int sessionCount = -1;
    private long sessionDuration;
    private long sessionSeriesCreatedTime;
    private UnclosedAdDetector unclosedAdDetector;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SignalManager(Context context2) {
        Intrinsics.f(context2, "context");
        this.context = context2;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        this.filePreferences$delegate = LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new SignalManager$special$$inlined$inject$1(context2));
        registerNotifications();
        this.sessionSeriesCreatedTime = getFilePreferences().getLong(SESSION_TIME_KEY, -1);
        updateSessionCount();
        this.currentSession = new SessionData(this.sessionCount);
        UnclosedAdDetector unclosedAdDetector2 = new UnclosedAdDetector(context2, this.currentSession.getSessionId(), m207_init_$lambda0(LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new SignalManager$special$$inlined$inject$2(context2))), m208_init_$lambda1(LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new SignalManager$special$$inlined$inject$3(context2))));
        this.unclosedAdDetector = unclosedAdDetector2;
        this.currentSession.setUnclosedAd(unclosedAdDetector2.retrieveUnclosedAd());
    }

    /* renamed from: _init_$lambda-0  reason: not valid java name */
    private static final Executors m207_init_$lambda0(Lazy<? extends Executors> lazy) {
        return (Executors) lazy.getValue();
    }

    /* renamed from: _init_$lambda-1  reason: not valid java name */
    private static final PathProvider m208_init_$lambda1(Lazy<PathProvider> lazy) {
        return lazy.getValue();
    }

    public static /* synthetic */ void getCurrentSession$vungle_ads_release$annotations() {
    }

    private final void registerNotifications() {
        ActivityManager.Companion.addLifecycleListener(new SignalManager$registerNotifications$1(this));
    }

    private final void updateSessionCount() {
        if (this.sessionCount == -1) {
            this.sessionCount = getFilePreferences().getInt(SESSION_COUNT_KEY, 0);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.sessionSeriesCreatedTime;
        long j3 = currentTimeMillis - j2;
        if (j2 < 0 || j3 >= TWENTY_FOUR_HOURS_MILLIS) {
            this.sessionCount = 1;
            getFilePreferences().put(SESSION_TIME_KEY, currentTimeMillis);
            this.sessionSeriesCreatedTime = currentTimeMillis;
        } else {
            this.sessionCount++;
        }
        getFilePreferences().put(SESSION_COUNT_KEY, this.sessionCount);
        getFilePreferences().apply();
    }

    private final void updateSessionDuration() {
        this.currentSession.setSessionDuration((this.sessionDuration + System.currentTimeMillis()) - this.enterForegroundTime);
    }

    public final void createNewSessionData() {
        updateSessionCount();
        this.currentSession = new SessionData(this.sessionCount);
    }

    public final String generateSignals() {
        updateSessionDuration();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("1:");
            Json json2 = this.json;
            SessionData sessionData = this.currentSession;
            KSerializer<Object> b2 = SerializersKt.b(json2.a(), Reflection.h(SessionData.class));
            Intrinsics.d(b2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            sb.append(json2.c(b2, sessionData));
            return sb.toString();
        } catch (Error | Exception unused) {
            return null;
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final SessionData getCurrentSession$vungle_ads_release() {
        return this.currentSession;
    }

    public final long getEnterBackgroundTime() {
        return this.enterBackgroundTime;
    }

    public final long getEnterForegroundTime() {
        return this.enterForegroundTime;
    }

    public final FilePreferences getFilePreferences() {
        return (FilePreferences) this.filePreferences$delegate.getValue();
    }

    public final ConcurrentHashMap<String, Long> getMapOfLastLoadTimes() {
        return this.mapOfLastLoadTimes;
    }

    public final int getSessionCount() {
        return this.sessionCount;
    }

    public final long getSessionDuration() {
        return this.sessionDuration;
    }

    public final long getSessionSeriesCreatedTime() {
        return this.sessionSeriesCreatedTime;
    }

    public final synchronized SignaledAd getSignaledAd(String str) {
        long currentTimeMillis;
        Long l2;
        Intrinsics.f(str, AudienceNetworkActivity.PLACEMENT_ID);
        currentTimeMillis = System.currentTimeMillis();
        if (this.mapOfLastLoadTimes.containsKey(str)) {
            l2 = this.mapOfLastLoadTimes.get(str);
        } else {
            l2 = null;
        }
        this.mapOfLastLoadTimes.put(str, Long.valueOf(currentTimeMillis));
        return new SignaledAd(l2, currentTimeMillis);
    }

    public final String getUuid() {
        return this.currentSession.getSessionId();
    }

    public final synchronized void increaseSessionDepthCounter() {
        SessionData sessionData = this.currentSession;
        sessionData.setSessionDepthCounter(sessionData.getSessionDepthCounter() + 1);
    }

    public final void recordUnclosedAd(UnclosedAd unclosedAd) {
        Intrinsics.f(unclosedAd, "unclosedAd");
        if (!ConfigManager.INSTANCE.signalsDisabled()) {
            this.unclosedAdDetector.addUnclosedAd(unclosedAd);
        }
    }

    public final void registerSignaledAd(Context context2, SignaledAd signaledAd) {
        Intrinsics.f(signaledAd, "signaledAd");
        this.currentSession.getSignaledAd().clear();
        this.currentSession.getSignaledAd().add(signaledAd);
        this.currentSession.getSignaledAd().get(0).setScreenOrientation(screenOrientation(context2));
    }

    public final void removeUnclosedAd(UnclosedAd unclosedAd) {
        Intrinsics.f(unclosedAd, "unclosedAd");
        if (!ConfigManager.INSTANCE.signalsDisabled()) {
            this.unclosedAdDetector.removeUnclosedAd(unclosedAd);
        }
    }

    public final int screenOrientation(Context context2) {
        Integer num;
        Configuration configuration;
        if (context2 == null) {
            context2 = this.context;
        }
        Resources resources = context2.getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(configuration.orientation);
        }
        if (num != null && num.intValue() == 2) {
            return 2;
        }
        if (num != null && num.intValue() == 1) {
            return 1;
        }
        if (num != null && num.intValue() == 0) {
            return 0;
        }
        return -1;
    }

    public final void setCurrentSession$vungle_ads_release(SessionData sessionData) {
        Intrinsics.f(sessionData, "<set-?>");
        this.currentSession = sessionData;
    }

    public final void setEnterBackgroundTime(long j2) {
        this.enterBackgroundTime = j2;
    }

    public final void setEnterForegroundTime(long j2) {
        this.enterForegroundTime = j2;
    }

    public final void setMapOfLastLoadTimes(ConcurrentHashMap<String, Long> concurrentHashMap) {
        Intrinsics.f(concurrentHashMap, "<set-?>");
        this.mapOfLastLoadTimes = concurrentHashMap;
    }

    public final void setSessionCount(int i2) {
        this.sessionCount = i2;
    }

    public final void setSessionDuration(long j2) {
        this.sessionDuration = j2;
    }

    public final void setSessionSeriesCreatedTime(long j2) {
        this.sessionSeriesCreatedTime = j2;
    }

    public final void updateTemplateSignals(String str) {
        boolean z2;
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 && (true ^ this.currentSession.getSignaledAd().isEmpty())) {
            this.currentSession.getSignaledAd().get(0).setTemplateSignals(str);
        }
    }
}
