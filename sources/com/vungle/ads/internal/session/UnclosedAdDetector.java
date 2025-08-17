package com.vungle.ads.internal.session;

import android.content.Context;
import com.google.android.gms.ads.RequestConfiguration;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.executor.FutureResult;
import com.vungle.ads.internal.model.UnclosedAd;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.SerializersModule;

public final class UnclosedAdDetector {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FILENAME = "unclosed_ad";
    private static final Json json = JsonKt.b((Json) null, UnclosedAdDetector$Companion$json$1.INSTANCE, 1, (Object) null);
    private final Context context;
    private final Executors executors;
    private File file;
    private final PathProvider pathProvider;
    private final String sessionId;
    private final CopyOnWriteArrayList<UnclosedAd> unclosedAdList = new CopyOnWriteArrayList<>();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UnclosedAdDetector(Context context2, String str, Executors executors2, PathProvider pathProvider2) {
        Intrinsics.f(context2, "context");
        Intrinsics.f(str, JsonStorageKeyNames.SESSION_ID_KEY);
        Intrinsics.f(executors2, "executors");
        Intrinsics.f(pathProvider2, "pathProvider");
        this.context = context2;
        this.sessionId = str;
        this.executors = executors2;
        this.pathProvider = pathProvider2;
        this.file = pathProvider2.getUnclosedAdFile(FILENAME);
        File file2 = this.file;
        if (file2 != null && !file2.exists()) {
            this.file.createNewFile();
        }
    }

    private final /* synthetic */ <T> T decodeJson(String str) {
        Json json2 = json;
        SerializersModule a2 = json2.a();
        Intrinsics.l(6, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        KSerializer<Object> b2 = SerializersKt.b(a2, (KType) null);
        Intrinsics.d(b2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return json2.b(b2, str);
    }

    private final List<UnclosedAd> readUnclosedAdFromFile() {
        return (List) new FutureResult(this.executors.getIoExecutor().submit(new c(this))).get(1000, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001b A[Catch:{ Exception -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0043 A[Catch:{ Exception -> 0x0049 }] */
    /* renamed from: readUnclosedAdFromFile$lambda-2  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List m204readUnclosedAdFromFile$lambda2(com.vungle.ads.internal.session.UnclosedAdDetector r5) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            com.vungle.ads.internal.util.FileUtility r0 = com.vungle.ads.internal.util.FileUtility.INSTANCE     // Catch:{ Exception -> 0x0049 }
            java.io.File r5 = r5.file     // Catch:{ Exception -> 0x0049 }
            java.lang.String r5 = r0.readString(r5)     // Catch:{ Exception -> 0x0049 }
            if (r5 == 0) goto L_0x0018
            int r0 = r5.length()     // Catch:{ Exception -> 0x0049 }
            if (r0 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r0 = 0
            goto L_0x0019
        L_0x0018:
            r0 = 1
        L_0x0019:
            if (r0 != 0) goto L_0x0043
            kotlinx.serialization.json.Json r0 = json     // Catch:{ Exception -> 0x0049 }
            kotlinx.serialization.modules.SerializersModule r1 = r0.a()     // Catch:{ Exception -> 0x0049 }
            java.lang.Class<java.util.List> r2 = java.util.List.class
            kotlin.reflect.KTypeProjection$Companion r3 = kotlin.reflect.KTypeProjection.f40475c     // Catch:{ Exception -> 0x0049 }
            java.lang.Class<com.vungle.ads.internal.model.UnclosedAd> r4 = com.vungle.ads.internal.model.UnclosedAd.class
            kotlin.reflect.KType r4 = kotlin.jvm.internal.Reflection.h(r4)     // Catch:{ Exception -> 0x0049 }
            kotlin.reflect.KTypeProjection r3 = r3.a(r4)     // Catch:{ Exception -> 0x0049 }
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.i(r2, r3)     // Catch:{ Exception -> 0x0049 }
            kotlinx.serialization.KSerializer r1 = kotlinx.serialization.SerializersKt.b(r1, r2)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>"
            kotlin.jvm.internal.Intrinsics.d(r1, r2)     // Catch:{ Exception -> 0x0049 }
            java.lang.Object r5 = r0.b(r1, r5)     // Catch:{ Exception -> 0x0049 }
            java.util.List r5 = (java.util.List) r5     // Catch:{ Exception -> 0x0049 }
            goto L_0x006b
        L_0x0043:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0049 }
            r5.<init>()     // Catch:{ Exception -> 0x0049 }
            goto L_0x006b
        L_0x0049:
            r5 = move-exception
            com.vungle.ads.internal.util.Logger$Companion r0 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Fail to read unclosed ad file "
            r1.append(r2)
            java.lang.String r5 = r5.getMessage()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            java.lang.String r1 = "UnclosedAdDetector"
            r0.e(r1, r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
        L_0x006b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.session.UnclosedAdDetector.m204readUnclosedAdFromFile$lambda2(com.vungle.ads.internal.session.UnclosedAdDetector):java.util.List");
    }

    /* access modifiers changed from: private */
    /* renamed from: retrieveUnclosedAd$lambda-1  reason: not valid java name */
    public static final void m205retrieveUnclosedAd$lambda1(UnclosedAdDetector unclosedAdDetector) {
        Intrinsics.f(unclosedAdDetector, "this$0");
        try {
            FileUtility.deleteAndLogIfFailed(unclosedAdDetector.file);
        } catch (Exception e2) {
            Logger.Companion companion = Logger.Companion;
            companion.e("UnclosedAdDetector", "Fail to delete file " + e2.getMessage());
        }
    }

    private final void writeUnclosedAdToFile(List<UnclosedAd> list) {
        try {
            Json json2 = json;
            KSerializer<Object> b2 = SerializersKt.b(json2.a(), Reflection.i(List.class, KTypeProjection.f40475c.a(Reflection.h(UnclosedAd.class))));
            Intrinsics.d(b2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            this.executors.getIoExecutor().execute(new b(this, json2.c(b2, list)));
        } catch (Throwable th) {
            Logger.Companion companion = Logger.Companion;
            companion.e("UnclosedAdDetector", "Fail to write unclosed ad file " + th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: writeUnclosedAdToFile$lambda-3  reason: not valid java name */
    public static final void m206writeUnclosedAdToFile$lambda3(UnclosedAdDetector unclosedAdDetector, String str) {
        Intrinsics.f(unclosedAdDetector, "this$0");
        Intrinsics.f(str, "$jsonContent");
        FileUtility.INSTANCE.writeString(unclosedAdDetector.file, str);
    }

    public final void addUnclosedAd(UnclosedAd unclosedAd) {
        Intrinsics.f(unclosedAd, "ad");
        unclosedAd.setSessionId(this.sessionId);
        this.unclosedAdList.add(unclosedAd);
        writeUnclosedAdToFile(this.unclosedAdList);
    }

    public final Context getContext() {
        return this.context;
    }

    public final Executors getExecutors() {
        return this.executors;
    }

    public final PathProvider getPathProvider() {
        return this.pathProvider;
    }

    public final void removeUnclosedAd(UnclosedAd unclosedAd) {
        Intrinsics.f(unclosedAd, "ad");
        if (this.unclosedAdList.contains(unclosedAd)) {
            this.unclosedAdList.remove(unclosedAd);
            writeUnclosedAdToFile(this.unclosedAdList);
        }
    }

    public final List<UnclosedAd> retrieveUnclosedAd() {
        ArrayList arrayList = new ArrayList();
        List<UnclosedAd> readUnclosedAdFromFile = readUnclosedAdFromFile();
        if (readUnclosedAdFromFile != null) {
            arrayList.addAll(readUnclosedAdFromFile);
        }
        this.executors.getIoExecutor().execute(new a(this));
        return arrayList;
    }
}
