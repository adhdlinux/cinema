package com.vungle.ads.internal.network;

import com.google.android.gms.common.internal.ImagesContract;
import com.vungle.ads.TpatError;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.model.ErrorInfo;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.ui.AdActivity;
import com.vungle.ads.internal.util.LogEntry;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.text.Regex;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

public final class TpatSender {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FAILED_GENERIC_TPATS = "FAILED_GENERIC_TPATS";
    private static final String FAILED_TPATS = "FAILED_TPATS";
    private static final int MAX_RETRIES = 5;
    private static final String TAG = "TpatSender";
    private final FilePreferences genericTpatFilePreferences;
    private final LogEntry logEntry;
    private final SignalManager signalManager;
    private final FilePreferences tpatFilePreferences;
    private final VungleApiClient vungleApiClient;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            iArr[HttpMethod.GET.ordinal()] = 1;
            iArr[HttpMethod.POST.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TpatSender(VungleApiClient vungleApiClient2, LogEntry logEntry2, Executor executor, PathProvider pathProvider, SignalManager signalManager2) {
        Intrinsics.f(vungleApiClient2, "vungleApiClient");
        Intrinsics.f(executor, "ioExecutor");
        Intrinsics.f(pathProvider, "pathProvider");
        this.vungleApiClient = vungleApiClient2;
        this.logEntry = logEntry2;
        this.signalManager = signalManager2;
        FilePreferences.Companion companion = FilePreferences.Companion;
        this.tpatFilePreferences = companion.get(executor, pathProvider, FilePreferences.TPAT_FAILED_FILENAME);
        this.genericTpatFilePreferences = companion.get(executor, pathProvider, FilePreferences.GENERIC_TPAT_FAILED_FILENAME);
    }

    private final Map<String, GenericTpatRequest> getStoredGenericTpats() {
        Object obj;
        String string = this.genericTpatFilePreferences.getString(FAILED_GENERIC_TPATS);
        if (string == null) {
            return new LinkedHashMap();
        }
        try {
            Result.Companion companion = Result.f40263c;
            Json.Default defaultR = Json.f41116d;
            SerializersModule a2 = defaultR.a();
            KTypeProjection.Companion companion2 = KTypeProjection.f40475c;
            KSerializer<Object> b2 = SerializersKt.b(a2, Reflection.d(Reflection.j(Map.class, companion2.a(Reflection.h(String.class)), companion2.a(Reflection.h(GenericTpatRequest.class)))));
            Intrinsics.d(b2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            obj = Result.b((Map) defaultR.b(b2, string));
        } catch (Throwable th) {
            Result.Companion companion3 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        Throwable e2 = Result.e(obj);
        if (e2 != null) {
            Logger.Companion companion4 = Logger.Companion;
            companion4.e(TAG, "Failed to decode stored generic tpats: " + e2);
        }
        if (Result.g(obj)) {
            obj = null;
        }
        Map<String, GenericTpatRequest> map = (Map) obj;
        if (map == null) {
            return new LinkedHashMap();
        }
        return map;
    }

    private final Map<String, Integer> getStoredTpats() {
        Object obj;
        String string = this.tpatFilePreferences.getString(FAILED_TPATS);
        if (string == null) {
            return new LinkedHashMap();
        }
        try {
            Result.Companion companion = Result.f40263c;
            Json.Default defaultR = Json.f41116d;
            SerializersModule a2 = defaultR.a();
            KTypeProjection.Companion companion2 = KTypeProjection.f40475c;
            KSerializer<Object> b2 = SerializersKt.b(a2, Reflection.d(Reflection.j(Map.class, companion2.a(Reflection.h(String.class)), companion2.a(Reflection.h(Integer.TYPE)))));
            Intrinsics.d(b2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            obj = Result.b((Map) defaultR.b(b2, string));
        } catch (Throwable th) {
            Result.Companion companion3 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        Throwable e2 = Result.e(obj);
        if (e2 != null) {
            Logger.Companion companion4 = Logger.Companion;
            companion4.e(TAG, "Failed to decode stored tpats: " + e2);
        }
        if (Result.g(obj)) {
            obj = null;
        }
        Map<String, Integer> map = (Map) obj;
        if (map == null) {
            return new LinkedHashMap();
        }
        return map;
    }

    private final void logTpatError(ErrorInfo errorInfo, String str) {
        Logger.Companion companion = Logger.Companion;
        companion.e(TAG, "Failed with " + errorInfo.getDescription() + ", url:" + str);
        Sdk$SDKError.Reason reason = errorInfo.getReason();
        new TpatError(reason, "Fail to send " + str + ", error: " + errorInfo.getDescription()).setLogEntry$vungle_ads_release(this.logEntry).logErrorNoReturnValue$vungle_ads_release();
    }

    private final void saveStoredGenericTpats(Map<String, GenericTpatRequest> map) {
        Object obj;
        try {
            Result.Companion companion = Result.f40263c;
            FilePreferences filePreferences = this.genericTpatFilePreferences;
            Json.Default defaultR = Json.f41116d;
            SerializersModule a2 = defaultR.a();
            KTypeProjection.Companion companion2 = KTypeProjection.f40475c;
            KSerializer<Object> b2 = SerializersKt.b(a2, Reflection.d(Reflection.j(Map.class, companion2.a(Reflection.h(String.class)), companion2.a(Reflection.h(GenericTpatRequest.class)))));
            Intrinsics.d(b2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            filePreferences.put(FAILED_GENERIC_TPATS, defaultR.c(b2, map)).apply();
            obj = Result.b(Unit.f40298a);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        if (Result.e(obj) != null) {
            Logger.Companion companion4 = Logger.Companion;
            companion4.e(TAG, "Failed to encode the about to storing generic tpats: " + map);
        }
    }

    private final void saveStoredTpats(Map<String, Integer> map) {
        Object obj;
        try {
            Result.Companion companion = Result.f40263c;
            FilePreferences filePreferences = this.tpatFilePreferences;
            Json.Default defaultR = Json.f41116d;
            SerializersModule a2 = defaultR.a();
            KTypeProjection.Companion companion2 = KTypeProjection.f40475c;
            KSerializer<Object> b2 = SerializersKt.b(a2, Reflection.d(Reflection.j(Map.class, companion2.a(Reflection.h(String.class)), companion2.a(Reflection.h(Integer.TYPE)))));
            Intrinsics.d(b2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            filePreferences.put(FAILED_TPATS, defaultR.c(b2, map)).apply();
            obj = Result.b(Unit.f40298a);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        if (Result.e(obj) != null) {
            Logger.Companion companion4 = Logger.Companion;
            companion4.e(TAG, "Failed to encode the about to storing tpats: " + map);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendGenericTpat$lambda-3  reason: not valid java name */
    public static final void m189sendGenericTpat$lambda3(TpatSender tpatSender, String str, GenericTpatRequest genericTpatRequest, String str2, boolean z2) {
        int i2;
        ErrorInfo errorInfo;
        GenericTpatRequest genericTpatRequest2;
        TpatSender tpatSender2 = tpatSender;
        String str3 = str;
        String str4 = str2;
        Intrinsics.f(tpatSender2, "this$0");
        Intrinsics.f(str3, "$url");
        Intrinsics.f(genericTpatRequest, "$request");
        Intrinsics.f(str4, "$urlWithSessionId");
        Map<String, GenericTpatRequest> storedGenericTpats = tpatSender.getStoredGenericTpats();
        GenericTpatRequest genericTpatRequest3 = storedGenericTpats.get(str3);
        if (genericTpatRequest3 != null) {
            i2 = genericTpatRequest3.getAttempt();
        } else {
            i2 = 0;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[genericTpatRequest.getMethod().ordinal()];
        if (i3 == 1) {
            errorInfo = VungleApiClient.pingTPAT$default(tpatSender2.vungleApiClient, str2, genericTpatRequest.getHeaders(), (String) null, (HttpMethod) null, tpatSender2.logEntry, 12, (Object) null);
        } else if (i3 == 2) {
            errorInfo = tpatSender2.vungleApiClient.pingTPAT(str2, genericTpatRequest.getHeaders(), genericTpatRequest.getBody(), HttpMethod.POST, tpatSender2.logEntry);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (errorInfo != null) {
            if (!errorInfo.getErrorIsTerminal() && z2) {
                if (i2 >= 5) {
                    storedGenericTpats.remove(str3);
                    tpatSender2.saveStoredGenericTpats(storedGenericTpats);
                    new TpatError(Sdk$SDKError.Reason.TPAT_RETRY_FAILED, str4).setLogEntry$vungle_ads_release(tpatSender2.logEntry).logErrorNoReturnValue$vungle_ads_release();
                } else {
                    GenericTpatRequest genericTpatRequest4 = storedGenericTpats.get(str3);
                    if (genericTpatRequest4 != null) {
                        genericTpatRequest2 = GenericTpatRequest.copy$default(genericTpatRequest4, (HttpMethod) null, (Map) null, (String) null, i2 + 1, 7, (Object) null);
                    } else {
                        genericTpatRequest2 = null;
                    }
                    if (genericTpatRequest2 == null) {
                        genericTpatRequest2 = new GenericTpatRequest(genericTpatRequest.getMethod(), genericTpatRequest.getHeaders(), genericTpatRequest.getBody(), i2 + 1);
                    }
                    storedGenericTpats.put(str3, genericTpatRequest2);
                    tpatSender2.saveStoredGenericTpats(storedGenericTpats);
                }
            }
            tpatSender2.logTpatError(errorInfo, str4);
        } else if (i2 != 0) {
            storedGenericTpats.remove(str3);
            tpatSender2.saveStoredGenericTpats(storedGenericTpats);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendTpat$lambda-2  reason: not valid java name */
    public static final void m190sendTpat$lambda2(TpatSender tpatSender, String str, String str2) {
        int i2;
        Intrinsics.f(tpatSender, "this$0");
        Intrinsics.f(str, "$url");
        Intrinsics.f(str2, "$urlWithSessionId");
        Map<String, Integer> storedTpats = tpatSender.getStoredTpats();
        Integer num = storedTpats.get(str);
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        ErrorInfo pingTPAT$default = VungleApiClient.pingTPAT$default(tpatSender.vungleApiClient, str2, (Map) null, (String) null, (HttpMethod) null, tpatSender.logEntry, 14, (Object) null);
        if (pingTPAT$default != null) {
            if (!pingTPAT$default.getErrorIsTerminal()) {
                if (i2 >= 5) {
                    storedTpats.remove(str);
                    tpatSender.saveStoredTpats(storedTpats);
                    new TpatError(Sdk$SDKError.Reason.TPAT_RETRY_FAILED, str2).setLogEntry$vungle_ads_release(tpatSender.logEntry).logErrorNoReturnValue$vungle_ads_release();
                } else {
                    storedTpats.put(str, Integer.valueOf(i2 + 1));
                    tpatSender.saveStoredTpats(storedTpats);
                }
            }
            tpatSender.logTpatError(pingTPAT$default, str2);
        } else if (i2 != 0) {
            storedTpats.remove(str);
            tpatSender.saveStoredTpats(storedTpats);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendWinNotification$lambda-0  reason: not valid java name */
    public static final void m191sendWinNotification$lambda0(TpatSender tpatSender, String str) {
        Intrinsics.f(tpatSender, "this$0");
        Intrinsics.f(str, "$url");
        ErrorInfo pingTPAT$default = VungleApiClient.pingTPAT$default(tpatSender.vungleApiClient, str, (Map) null, (String) null, (HttpMethod) null, tpatSender.logEntry, 14, (Object) null);
        if (pingTPAT$default != null) {
            Sdk$SDKError.Reason reason = Sdk$SDKError.Reason.AD_WIN_NOTIFICATION_ERROR;
            new TpatError(reason, "Fail to send " + str + ", error: " + pingTPAT$default.getDescription()).setLogEntry$vungle_ads_release(tpatSender.logEntry).logErrorNoReturnValue$vungle_ads_release();
        }
    }

    public final LogEntry getLogEntry() {
        return this.logEntry;
    }

    public final SignalManager getSignalManager() {
        return this.signalManager;
    }

    public final VungleApiClient getVungleApiClient() {
        return this.vungleApiClient;
    }

    public final String injectSessionIdToUrl(String str) {
        String str2;
        boolean z2;
        Intrinsics.f(str, ImagesContract.URL);
        SignalManager signalManager2 = this.signalManager;
        if (signalManager2 == null || (str2 = signalManager2.getUuid()) == null) {
            str2 = "";
        }
        if (str2.length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return str;
        }
        String quote = Pattern.quote(Constants.SESSION_ID);
        Intrinsics.e(quote, "quote(Constants.SESSION_ID)");
        return new Regex(quote).h(str, str2);
    }

    public final void resendStoredTpats$vungle_ads_release(Executor executor) {
        Intrinsics.f(executor, "executor");
        for (Map.Entry<String, Integer> key : getStoredTpats().entrySet()) {
            sendTpat((String) key.getKey(), executor);
        }
        for (Map.Entry next : getStoredGenericTpats().entrySet()) {
            GenericTpatRequest genericTpatRequest = (GenericTpatRequest) next.getValue();
            sendGenericTpat((String) next.getKey(), new GenericTpatRequest(genericTpatRequest.getMethod(), (Map) genericTpatRequest.getHeaders(), genericTpatRequest.getBody(), 0, 8, (DefaultConstructorMarker) null), true, executor);
        }
    }

    public final void sendGenericTpat(String str, GenericTpatRequest genericTpatRequest, boolean z2, Executor executor) {
        Intrinsics.f(str, ImagesContract.URL);
        Intrinsics.f(genericTpatRequest, AdActivity.REQUEST_KEY_EXTRA);
        Intrinsics.f(executor, "executor");
        executor.execute(new a(this, str, genericTpatRequest, injectSessionIdToUrl(str), z2));
    }

    public final void sendTpat(String str, Executor executor) {
        Intrinsics.f(str, ImagesContract.URL);
        Intrinsics.f(executor, "executor");
        executor.execute(new b(this, str, injectSessionIdToUrl(str)));
    }

    public final void sendTpats(Iterable<String> iterable, Executor executor) {
        Intrinsics.f(iterable, "urls");
        Intrinsics.f(executor, "executor");
        for (String sendTpat : iterable) {
            sendTpat(sendTpat, executor);
        }
    }

    public final void sendWinNotification(String str, Executor executor) {
        Intrinsics.f(str, "urlString");
        Intrinsics.f(executor, "executor");
        executor.execute(new c(this, injectSessionIdToUrl(str)));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TpatSender(VungleApiClient vungleApiClient2, LogEntry logEntry2, Executor executor, PathProvider pathProvider, SignalManager signalManager2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(vungleApiClient2, (i2 & 2) != 0 ? null : logEntry2, executor, pathProvider, (i2 & 16) != 0 ? null : signalManager2);
    }
}
