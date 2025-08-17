package com.extension;

import com.original.tase.model.media.MediaSource;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

public final class CinemaWorker$startProvider$3 implements Function<MediaSource, MediaSource> {
    CinemaWorker$startProvider$3() {
    }

    /* renamed from: a */
    public MediaSource apply(MediaSource mediaSource) throws Exception {
        Intrinsics.f(mediaSource, "mediaSource");
        return b(mediaSource);
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0164 A[Catch:{ all -> 0x01a4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.original.tase.model.media.MediaSource b(com.original.tase.model.media.MediaSource r18) {
        /*
            r17 = this;
            r1 = r18
            java.lang.String r0 = "m33107(...)"
            java.lang.String r2 = "this as java.lang.String).toLowerCase(locale)"
            java.lang.String r3 = "getDefault(...)"
            java.lang.String r4 = "mediaSource"
            kotlin.jvm.internal.Intrinsics.f(r1, r4)
            java.lang.String r5 = r18.getStreamLink()     // Catch:{ all -> 0x01a4 }
            java.lang.String r6 = "getStreamLink(...)"
            kotlin.jvm.internal.Intrinsics.e(r5, r6)     // Catch:{ all -> 0x01a4 }
            int r6 = r5.length()     // Catch:{ all -> 0x01a4 }
            r7 = 1
            int r6 = r6 - r7
            r8 = 0
            r9 = 0
        L_0x001e:
            if (r8 > r6) goto L_0x0043
            if (r9 != 0) goto L_0x0024
            r10 = r8
            goto L_0x0025
        L_0x0024:
            r10 = r6
        L_0x0025:
            char r10 = r5.charAt(r10)     // Catch:{ all -> 0x01a4 }
            r11 = 32
            int r10 = kotlin.jvm.internal.Intrinsics.h(r10, r11)     // Catch:{ all -> 0x01a4 }
            if (r10 > 0) goto L_0x0033
            r10 = 1
            goto L_0x0034
        L_0x0033:
            r10 = 0
        L_0x0034:
            if (r9 != 0) goto L_0x003d
            if (r10 != 0) goto L_0x003a
            r9 = 1
            goto L_0x001e
        L_0x003a:
            int r8 = r8 + 1
            goto L_0x001e
        L_0x003d:
            if (r10 != 0) goto L_0x0040
            goto L_0x0043
        L_0x0040:
            int r6 = r6 + -1
            goto L_0x001e
        L_0x0043:
            int r6 = r6 + r7
            java.lang.CharSequence r5 = r5.subSequence(r8, r6)     // Catch:{ all -> 0x01a4 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01a4 }
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ all -> 0x01a4 }
            kotlin.jvm.internal.Intrinsics.e(r6, r3)     // Catch:{ all -> 0x01a4 }
            java.lang.String r5 = r5.toLowerCase(r6)     // Catch:{ all -> 0x01a4 }
            kotlin.jvm.internal.Intrinsics.e(r5, r2)     // Catch:{ all -> 0x01a4 }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x01a4 }
            r6.<init>()     // Catch:{ all -> 0x01a4 }
            java.lang.String r6 = "//[^/]*(ntcdn|micetop)\\.[^/]{2,8}/"
            java.lang.String r6 = com.original.tase.utils.Regex.a(r5, r6, r7)     // Catch:{ all -> 0x01a4 }
            kotlin.jvm.internal.Intrinsics.e(r6, r0)     // Catch:{ all -> 0x01a4 }
            int r6 = r6.length()     // Catch:{ all -> 0x01a4 }
            if (r6 != 0) goto L_0x0070
            r6 = 1
            goto L_0x0071
        L_0x0070:
            r6 = 0
        L_0x0071:
            java.lang.String r8 = "userAgent"
            java.lang.String r9 = "user-agent"
            java.lang.String r10 = "https://vidnode.net/"
            java.lang.String r11 = "vidnode.net"
            java.lang.String r12 = "getPlayHeader(...)"
            java.lang.String r13 = "referer"
            java.lang.String r14 = ""
            r15 = 0
            java.lang.String r4 = "User-Agent"
            java.lang.String r7 = "Referer"
            if (r6 != 0) goto L_0x0100
            java.util.HashMap r0 = r18.getPlayHeader()     // Catch:{ all -> 0x01a4 }
            kotlin.jvm.internal.Intrinsics.e(r0, r12)     // Catch:{ all -> 0x01a4 }
            boolean r6 = r0.containsKey(r7)     // Catch:{ all -> 0x01a4 }
            if (r6 == 0) goto L_0x009a
            java.lang.Object r6 = r0.get(r7)     // Catch:{ all -> 0x01a4 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x01a4 }
            goto L_0x00a8
        L_0x009a:
            boolean r6 = r0.containsKey(r13)     // Catch:{ all -> 0x01a4 }
            if (r6 == 0) goto L_0x00a7
            java.lang.Object r6 = r0.get(r13)     // Catch:{ all -> 0x01a4 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x01a4 }
            goto L_0x00a8
        L_0x00a7:
            r6 = r14
        L_0x00a8:
            if (r6 == 0) goto L_0x00bc
            java.util.Locale r12 = java.util.Locale.getDefault()     // Catch:{ all -> 0x01a4 }
            kotlin.jvm.internal.Intrinsics.e(r12, r3)     // Catch:{ all -> 0x01a4 }
            java.lang.String r3 = r6.toLowerCase(r12)     // Catch:{ all -> 0x01a4 }
            kotlin.jvm.internal.Intrinsics.e(r3, r2)     // Catch:{ all -> 0x01a4 }
            if (r3 != 0) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r14 = r3
        L_0x00bc:
            java.lang.String r2 = "vidcdn_pro/"
            r3 = 2
            r6 = 0
            boolean r2 = kotlin.text.StringsKt__StringsKt.L(r5, r2, r6, r3, r15)     // Catch:{ all -> 0x01a4 }
            if (r2 == 0) goto L_0x00d0
            boolean r2 = kotlin.text.StringsKt__StringsKt.L(r14, r11, r6, r3, r15)     // Catch:{ all -> 0x01a4 }
            if (r2 != 0) goto L_0x00d0
            r0.put(r7, r10)     // Catch:{ all -> 0x01a4 }
            goto L_0x00e7
        L_0x00d0:
            java.lang.String r2 = "s7_ntcdn_us/"
            r3 = 2
            r6 = 0
            boolean r2 = kotlin.text.StringsKt__StringsKt.L(r5, r2, r6, r3, r15)     // Catch:{ all -> 0x01a4 }
            if (r2 == 0) goto L_0x00e7
            java.lang.String r2 = "m4ufree.info"
            boolean r2 = kotlin.text.StringsKt__StringsKt.L(r14, r2, r6, r3, r15)     // Catch:{ all -> 0x01a4 }
            if (r2 != 0) goto L_0x00e7
            java.lang.String r2 = "http://m4ufree.info/"
            r0.put(r7, r2)     // Catch:{ all -> 0x01a4 }
        L_0x00e7:
            boolean r2 = r0.containsKey(r4)     // Catch:{ all -> 0x01a4 }
            if (r2 != 0) goto L_0x00fb
            boolean r2 = r0.containsKey(r9)     // Catch:{ all -> 0x01a4 }
            if (r2 != 0) goto L_0x00fb
            java.lang.String r2 = com.original.Constants.C     // Catch:{ all -> 0x01a4 }
            kotlin.jvm.internal.Intrinsics.e(r2, r8)     // Catch:{ all -> 0x01a4 }
            r0.put(r4, r2)     // Catch:{ all -> 0x01a4 }
        L_0x00fb:
            r1.setPlayHeader(r0)     // Catch:{ all -> 0x01a4 }
            goto L_0x01ab
        L_0x0100:
            java.lang.String r6 = "//[^/]*(vidcdn)\\.pro/stream/"
            r15 = 1
            java.lang.String r6 = com.original.tase.utils.Regex.a(r5, r6, r15)     // Catch:{ all -> 0x01a4 }
            kotlin.jvm.internal.Intrinsics.e(r6, r0)     // Catch:{ all -> 0x01a4 }
            int r0 = r6.length()     // Catch:{ all -> 0x01a4 }
            if (r0 != 0) goto L_0x0111
            goto L_0x0112
        L_0x0111:
            r15 = 0
        L_0x0112:
            if (r15 != 0) goto L_0x017f
            java.lang.String r0 = ".m3u8"
            r16 = r14
            r6 = 0
            r14 = 0
            r15 = 2
            boolean r0 = kotlin.text.StringsKt__StringsKt.L(r5, r0, r14, r15, r6)     // Catch:{ all -> 0x01a4 }
            if (r0 != 0) goto L_0x017f
            java.util.HashMap r0 = r18.getPlayHeader()     // Catch:{ all -> 0x01a4 }
            kotlin.jvm.internal.Intrinsics.e(r0, r12)     // Catch:{ all -> 0x01a4 }
            boolean r5 = r0.containsKey(r7)     // Catch:{ all -> 0x01a4 }
            if (r5 == 0) goto L_0x0135
            java.lang.Object r5 = r0.get(r7)     // Catch:{ all -> 0x01a4 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x01a4 }
            goto L_0x0144
        L_0x0135:
            boolean r5 = r0.containsKey(r13)     // Catch:{ all -> 0x01a4 }
            if (r5 == 0) goto L_0x0142
            java.lang.Object r5 = r0.get(r13)     // Catch:{ all -> 0x01a4 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x01a4 }
            goto L_0x0144
        L_0x0142:
            r5 = r16
        L_0x0144:
            if (r5 == 0) goto L_0x0159
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ all -> 0x01a4 }
            kotlin.jvm.internal.Intrinsics.e(r6, r3)     // Catch:{ all -> 0x01a4 }
            java.lang.String r3 = r5.toLowerCase(r6)     // Catch:{ all -> 0x01a4 }
            kotlin.jvm.internal.Intrinsics.e(r3, r2)     // Catch:{ all -> 0x01a4 }
            if (r3 != 0) goto L_0x0157
            goto L_0x0159
        L_0x0157:
            r14 = r3
            goto L_0x015b
        L_0x0159:
            r14 = r16
        L_0x015b:
            r2 = 0
            r3 = 2
            r5 = 0
            boolean r2 = kotlin.text.StringsKt__StringsKt.L(r14, r11, r5, r3, r2)     // Catch:{ all -> 0x01a4 }
            if (r2 != 0) goto L_0x0167
            r0.put(r7, r10)     // Catch:{ all -> 0x01a4 }
        L_0x0167:
            boolean r2 = r0.containsKey(r4)     // Catch:{ all -> 0x01a4 }
            if (r2 != 0) goto L_0x017b
            boolean r2 = r0.containsKey(r9)     // Catch:{ all -> 0x01a4 }
            if (r2 != 0) goto L_0x017b
            java.lang.String r2 = com.original.Constants.C     // Catch:{ all -> 0x01a4 }
            kotlin.jvm.internal.Intrinsics.e(r2, r8)     // Catch:{ all -> 0x01a4 }
            r0.put(r4, r2)     // Catch:{ all -> 0x01a4 }
        L_0x017b:
            r1.setPlayHeader(r0)     // Catch:{ all -> 0x01a4 }
            goto L_0x01ab
        L_0x017f:
            java.util.HashMap r0 = r18.getPlayHeader()     // Catch:{ all -> 0x01a4 }
            if (r0 != 0) goto L_0x018d
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x01a4 }
            r0.<init>()     // Catch:{ all -> 0x01a4 }
            r1.setPlayHeader(r0)     // Catch:{ all -> 0x01a4 }
        L_0x018d:
            java.util.HashMap r0 = r18.getPlayHeader()     // Catch:{ all -> 0x01a4 }
            boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x01a4 }
            if (r0 != 0) goto L_0x01ab
            java.util.HashMap r0 = r18.getPlayHeader()     // Catch:{ all -> 0x01a4 }
            kotlin.jvm.internal.Intrinsics.e(r0, r12)     // Catch:{ all -> 0x01a4 }
            java.lang.String r2 = com.original.Constants.C     // Catch:{ all -> 0x01a4 }
            r0.put(r4, r2)     // Catch:{ all -> 0x01a4 }
            goto L_0x01ab
        L_0x01a4:
            r0 = move-exception
            r2 = 0
            boolean[] r2 = new boolean[r2]
            com.original.tase.Logger.d(r0, r2)
        L_0x01ab:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.extension.CinemaWorker$startProvider$3.b(com.original.tase.model.media.MediaSource):com.original.tase.model.media.MediaSource");
    }
}
