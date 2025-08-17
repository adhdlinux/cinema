package com.vungle.ads.internal.network.converters;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import okhttp3.ResponseBody;

public final class JsonConverter<E> implements Converter<ResponseBody, E> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Json json = JsonKt.b((Json) null, JsonConverter$Companion$json$1.INSTANCE, 1, (Object) null);
    private final KType kType;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public JsonConverter(KType kType2) {
        Intrinsics.f(kType2, "kType");
        this.kType = kType2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        kotlin.io.CloseableKt.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E convert(okhttp3.ResponseBody r6) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0027
            java.lang.String r1 = r6.string()     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x000a
            goto L_0x0027
        L_0x000a:
            kotlinx.serialization.json.Json r2 = json     // Catch:{ all -> 0x0020 }
            kotlinx.serialization.json.Json$Default r3 = kotlinx.serialization.json.Json.f41116d     // Catch:{ all -> 0x0020 }
            kotlinx.serialization.modules.SerializersModule r3 = r3.a()     // Catch:{ all -> 0x0020 }
            kotlin.reflect.KType r4 = r5.kType     // Catch:{ all -> 0x0020 }
            kotlinx.serialization.KSerializer r3 = kotlinx.serialization.SerializersKt.b(r3, r4)     // Catch:{ all -> 0x0020 }
            java.lang.Object r1 = r2.b(r3, r1)     // Catch:{ all -> 0x0020 }
            kotlin.io.CloseableKt.a(r6, r0)
            return r1
        L_0x0020:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r1 = move-exception
            kotlin.io.CloseableKt.a(r6, r0)
            throw r1
        L_0x0027:
            kotlin.io.CloseableKt.a(r6, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.converters.JsonConverter.convert(okhttp3.ResponseBody):java.lang.Object");
    }
}
