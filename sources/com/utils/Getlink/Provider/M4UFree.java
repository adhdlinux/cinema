package com.utils.Getlink.Provider;

import android.util.Base64;
import com.facebook.common.util.UriUtil;
import com.facebook.imageutils.JfifUtil;
import com.movie.data.model.MovieInfo;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.crypto.AES256Cryptor;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntProgression;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public final class M4UFree extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37375e;

    /* renamed from: f  reason: collision with root package name */
    private List<String> f37376f = CollectionsKt__CollectionsKt.i("HP-UX", "Linux i686", "Linux armv7l", "Mac68K", "MacPPC", "MacIntel", "SunOS", "Win16", "Win32", "WinCE", "iPhone", "iPod", "iPad", "Android", "BlackBerry", "Opera");

    public M4UFree() {
        String provider = Utils.getProvider(69);
        Intrinsics.e(provider, "getProvider(...)");
        this.f37375e = provider;
    }

    public String A() {
        return "M4UFree";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        Intrinsics.f(movieInfo, "movieInfo");
        String str = movieInfo.name;
        Intrinsics.e(str, "name");
        String str2 = movieInfo.year;
        Intrinsics.e(str2, "year");
        String P = P(str, str2, -1, -1);
        if (P != null) {
            String str3 = movieInfo.name;
            Intrinsics.e(str3, "name");
            M(P, -1, -1, str3, observableEmitter);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        Intrinsics.f(movieInfo, "movieInfo");
    }

    public final String J(String str) {
        Intrinsics.f(str, "base64Str");
        byte[] decode = Base64.decode(str, 0);
        Intrinsics.c(decode);
        return ArraysKt___ArraysKt.K(decode, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, M4UFree$base64ToHex$1.f37377f, 30, (Object) null);
    }

    public final String K(String str, String str2) {
        boolean z2;
        Intrinsics.f(str, "input");
        Intrinsics.f(str2, "key");
        String d2 = AES256Cryptor.d(str, str2);
        if (d2 == null || d2.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "";
        }
        Intrinsics.c(d2);
        return J(d2);
    }

    public final String L(String str, String str2) {
        Intrinsics.f(str, "input");
        Intrinsics.f(str2, "key");
        String c2 = AES256Cryptor.c(O(str), str2);
        Intrinsics.c(c2);
        return c2;
    }

    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r4v42 */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x02f7  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02f9  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x031e  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0321  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void M(java.lang.String r21, int r22, int r23, java.lang.String r24, io.reactivex.ObservableEmitter<? super com.original.tase.model.media.MediaSource> r25) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r25
            java.lang.String r3 = "url"
            kotlin.jvm.internal.Intrinsics.f(r1, r3)
            java.lang.String r3 = "filename"
            r4 = r24
            kotlin.jvm.internal.Intrinsics.f(r4, r3)
            com.original.tase.helper.http.HttpHelper r3 = com.original.tase.helper.http.HttpHelper.i()
            r4 = 0
            java.util.Map[] r5 = new java.util.Map[r4]
            java.lang.String r3 = r3.m(r1, r5)
            org.jsoup.nodes.Document r3 = org.jsoup.Jsoup.b(r3)
            java.lang.String r5 = "meta[name=csrf-token]"
            org.jsoup.select.Elements r5 = r3.q0(r5)
            java.lang.String r6 = "content"
            java.lang.String r5 = r5.a(r6)
            java.lang.String r6 = "attr(...)"
            kotlin.jvm.internal.Intrinsics.e(r5, r6)
            java.util.HashMap r6 = com.original.Constants.c()
            java.lang.String r7 = "ʽ(...)"
            kotlin.jvm.internal.Intrinsics.e(r6, r7)
            java.util.HashMap r8 = com.original.Constants.c()
            kotlin.jvm.internal.Intrinsics.e(r8, r7)
            java.lang.String r7 = "Accept"
            java.lang.String r9 = "*/*"
            r6.put(r7, r9)
            java.lang.String r10 = "Origin"
            java.lang.String r11 = r0.f37375e
            r6.put(r10, r11)
            java.lang.String r10 = "Referer"
            r6.put(r10, r1)
            r8.put(r7, r9)
            java.lang.String r7 = com.original.Constants.C
            java.lang.String r9 = "userAgent"
            kotlin.jvm.internal.Intrinsics.e(r7, r9)
            java.lang.String r10 = "User-Agent"
            r8.put(r10, r7)
            com.original.tase.helper.http.HttpHelper r7 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.String r1 = r7.g(r1)
            if (r1 == 0) goto L_0x0076
            java.lang.String r7 = "Cookie"
            java.lang.Object r1 = r6.put(r7, r1)
            java.lang.String r1 = (java.lang.String) r1
        L_0x0076:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r7 = "getLink hashMap2: "
            r1.append(r7)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            java.lang.String r7 = "M4UFree"
            android.util.Log.d(r7, r1)
            java.lang.String r1 = "div.le-server"
            org.jsoup.select.Elements r1 = r3.q0(r1)
            java.lang.String r3 = "span[data][class][id]"
            org.jsoup.select.Elements r1 = r1.g(r3)
            java.util.Iterator r1 = r1.iterator()
            java.lang.String r3 = "iterator(...)"
            kotlin.jvm.internal.Intrinsics.e(r1, r3)
        L_0x00a1:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x037d
            java.lang.Object r3 = r1.next()
            java.lang.String r8 = "null cannot be cast to non-null type org.jsoup.nodes.Element"
            kotlin.jvm.internal.Intrinsics.d(r3, r8)
            org.jsoup.nodes.Element r3 = (org.jsoup.nodes.Element) r3
            java.lang.String r8 = "data"
            java.lang.String r3 = r3.c(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "getLink playdata: "
            r8.append(r10)
            r8.append(r3)
            java.lang.String r8 = r8.toString()
            android.util.Log.d(r7, r8)
            com.original.tase.helper.http.HttpHelper r8 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = r0.f37375e
            r10.append(r11)
            java.lang.String r11 = "/ajax"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "m4u="
            r11.append(r12)
            r11.append(r3)
            java.lang.String r3 = "&_token="
            r11.append(r3)
            r11.append(r5)
            java.lang.String r3 = r11.toString()
            r11 = 1
            java.util.Map[] r12 = new java.util.Map[r11]
            r12[r4] = r6
            java.lang.String r3 = r8.l(r10, r3, r12)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "getLink: "
            r8.append(r10)
            r8.append(r3)
            java.lang.String r8 = r8.toString()
            android.util.Log.d(r7, r8)
            if (r3 == 0) goto L_0x0124
            int r8 = r3.length()
            if (r8 != 0) goto L_0x0122
            goto L_0x0124
        L_0x0122:
            r8 = 0
            goto L_0x0125
        L_0x0124:
            r8 = 1
        L_0x0125:
            if (r8 != 0) goto L_0x00a1
            java.lang.String r8 = "<iframe[^>]+src=['\"]([^'\"]+)['\"][^>]*>"
            java.lang.String r8 = com.original.tase.utils.Regex.a(r3, r8, r11)
            kotlin.jvm.internal.Intrinsics.c(r8)
            int r10 = r8.length()
            if (r10 != 0) goto L_0x0138
            r10 = 1
            goto L_0x0139
        L_0x0138:
            r10 = 0
        L_0x0139:
            if (r10 == 0) goto L_0x0141
            java.lang.String r8 = "['\"]?file['\"]?\\s*:\\s*['\"]?([^'\"]+)"
            java.lang.String r8 = com.original.tase.utils.Regex.a(r3, r8, r11)
        L_0x0141:
            if (r8 == 0) goto L_0x014c
            int r3 = r8.length()
            if (r3 != 0) goto L_0x014a
            goto L_0x014c
        L_0x014a:
            r3 = 0
            goto L_0x014d
        L_0x014c:
            r3 = 1
        L_0x014d:
            if (r3 != 0) goto L_0x00a1
            kotlin.jvm.internal.Intrinsics.c(r8)
            java.lang.String r3 = "//"
            r10 = 2
            r12 = 0
            boolean r13 = kotlin.text.StringsKt__StringsJVMKt.G(r8, r3, r4, r10, r12)
            java.lang.String r14 = "https:"
            if (r13 == 0) goto L_0x016d
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r14)
            r13.append(r8)
            java.lang.String r8 = r13.toString()
        L_0x016d:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r15 = "getLink iframe: "
            r13.append(r15)
            r13.append(r8)
            java.lang.String r13 = r13.toString()
            android.util.Log.d(r7, r13)
            kotlin.jvm.internal.Intrinsics.c(r8)
            java.lang.String r13 = "playm4u"
            boolean r13 = kotlin.text.StringsKt__StringsKt.L(r8, r13, r4, r10, r12)
            java.lang.String r15 = "CDN-FastServer"
            if (r13 == 0) goto L_0x0344
            com.original.tase.helper.http.HttpHelper r13 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r10 = r0.f37375e
            r4.append(r10)
            r10 = 47
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = r13.o(r8, r4)
            if (r4 == 0) goto L_0x01b4
            int r13 = r4.length()
            if (r13 != 0) goto L_0x01b2
            goto L_0x01b4
        L_0x01b2:
            r13 = 0
            goto L_0x01b5
        L_0x01b4:
            r13 = 1
        L_0x01b5:
            if (r13 != 0) goto L_0x0341
            java.lang.String r13 = "idfile(?:\\w+|)\\s*=\\s*['\"]([^'\"]+[^'\"])['\"]"
            java.lang.String r13 = com.original.tase.utils.Regex.a(r4, r13, r11)
            java.lang.String r10 = "m33107(...)"
            kotlin.jvm.internal.Intrinsics.e(r13, r10)
            java.lang.String r12 = "idUser(?:\\w+|)\\s*=\\s*['\"]([^'\"]+[^'\"])['\"]"
            java.lang.String r12 = com.original.tase.utils.Regex.a(r4, r12, r11)
            kotlin.jvm.internal.Intrinsics.e(r12, r10)
            java.lang.String r11 = "jcLycoRJT6OWjoWspgLMOZwS3aSS0lEn"
            java.lang.String r11 = r0.L(r13, r11)
            r16 = r1
            java.lang.String r1 = "PZZ3J3LDbLT0GY7qSA5wW5vchqgpO36O"
            java.lang.String r1 = r0.L(r12, r1)
            r17 = r5
            java.lang.String r5 = "DOMAIN_API(?:\\w+|)\\s*=\\s*['\"]([^'\"]+[^'\"])['\"]"
            r18 = r6
            r6 = 1
            java.lang.String r5 = com.original.tase.utils.Regex.a(r4, r5, r6)
            kotlin.jvm.internal.Intrinsics.e(r5, r10)
            r19 = r4
            r4 = 0
            r6 = 0
            r10 = 2
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.G(r5, r3, r4, r10, r6)
            if (r3 == 0) goto L_0x0201
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r14)
            r3.append(r5)
            java.lang.String r5 = r3.toString()
        L_0x0201:
            java.lang.String r3 = "/"
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.s(r5, r3, r4, r10, r6)
            if (r3 != 0) goto L_0x021a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r4 = 47
            r3.append(r4)
            java.lang.String r5 = r3.toString()
        L_0x021a:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r4 = com.utils.Getlink.Provider.BaseProvider.j(r8)
            java.lang.String r6 = "getBaseurl(...)"
            kotlin.jvm.internal.Intrinsics.e(r4, r6)
            java.lang.String r6 = "origin"
            r3.put(r6, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = com.utils.Getlink.Provider.BaseProvider.j(r8)
            r4.append(r6)
            r6 = 47
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.String r6 = "referer"
            r3.put(r6, r4)
            java.lang.String r4 = com.original.Constants.C
            kotlin.jvm.internal.Intrinsics.e(r4, r9)
            java.lang.String r6 = "user-agent"
            r3.put(r6, r4)
            int r4 = r13.length()
            if (r4 <= 0) goto L_0x0259
            r4 = 1
            goto L_0x025a
        L_0x0259:
            r4 = 0
        L_0x025a:
            if (r4 == 0) goto L_0x02e2
            int r4 = r12.length()
            if (r4 <= 0) goto L_0x0264
            r4 = 1
            goto L_0x0265
        L_0x0264:
            r4 = 0
        L_0x0265:
            if (r4 == 0) goto L_0x02e2
            java.lang.String r4 = r0.f37375e
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.f40434a
            r6 = 5
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r10 = 0
            r8[r10] = r11
            r10 = 1
            r8[r10] = r1
            r1 = 2
            r8[r1] = r4
            r1 = 3
            java.lang.String r4 = "MacIntel"
            r8[r1] = r4
            r1 = 4
            r8[r1] = r4
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r8, r6)
            java.lang.String r4 = "{\"idfile\":\"%s\",\"iduser\":\"%s\",\"domain_play\":\"%s\",\"platform\":\"%s\",\"hlsSupport\":true,\"jwplayer\":{\"Browser\":{\"androidNative\":false,\"chrome\":true,\"edge\":false,\"facebook\":false,\"firefox\":false,\"ie\":false,\"msie\":false,\"safari\":false,\"version\":{\"version\":\"129.0.0.0\",\"major\":129,\"minor\":0}},\"OS\":{\"android\":false,\"iOS\":false,\"mobile\":false,\"mac\":true,\"iPad\":false,\"iPhone\":false,\"windows\":false,\"tizen\":false,\"tizenApp\":false,\"version\":{\"version\":\"10_15_7\",\"major\":10,\"minor\":15}},\"Features\":{\"iframe\":true,\"passiveEvents\":true,\"backgroundLoading\":true}}}"
            java.lang.String r1 = java.lang.String.format(r4, r1)
            java.lang.String r4 = "format(format, *args)"
            kotlin.jvm.internal.Intrinsics.e(r1, r4)
            java.lang.String r4 = "vlVbUQhkOhoSfyteyzGeeDzU0BHoeTyZ"
            java.lang.String r1 = r0.K(r1, r4)
            com.original.tase.helper.http.HttpHelper r4 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = "playiframe"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "data="
            r6.append(r8)
            r6.append(r1)
            r8 = 124(0x7c, float:1.74E-43)
            r6.append(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r1)
            java.lang.String r1 = "KRWN3AdgmxEMcd2vLN1ju9qKe8Feco5h"
            r8.append(r1)
            java.lang.String r1 = r8.toString()
            java.lang.String r1 = com.original.tase.helper.crypto.MD5Utils.a(r1)
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            r6 = 1
            java.util.Map[] r8 = new java.util.Map[r6]
            r10 = 0
            r8[r10] = r3
            java.lang.String r4 = r4.l(r5, r1, r8)
            goto L_0x02e5
        L_0x02e2:
            r6 = 1
            r4 = r19
        L_0x02e5:
            kotlin.jvm.internal.Intrinsics.c(r4)
            java.lang.String r1 = "data['\"]\\s*:\\s*['\"]([^'\"]+[^'\"])['\"]"
            java.lang.String r1 = com.original.tase.utils.Regex.a(r4, r1, r6)
            if (r1 == 0) goto L_0x02f9
            int r4 = r1.length()
            if (r4 != 0) goto L_0x02f7
            goto L_0x02f9
        L_0x02f7:
            r4 = 0
            goto L_0x02fa
        L_0x02f9:
            r4 = 1
        L_0x02fa:
            if (r4 != 0) goto L_0x0313
            kotlin.jvm.internal.Intrinsics.c(r1)
            java.lang.String r4 = "http"
            r5 = 0
            r8 = 2
            r10 = 0
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.G(r1, r4, r10, r8, r5)
            if (r4 != 0) goto L_0x0313
            kotlin.jvm.internal.Intrinsics.c(r1)
            java.lang.String r4 = "oJwmvmVBajMaRCTklxbfjavpQO7SZpsL"
            java.lang.String r1 = r0.L(r1, r4)
        L_0x0313:
            if (r1 == 0) goto L_0x031e
            int r4 = r1.length()
            if (r4 != 0) goto L_0x031c
            goto L_0x031e
        L_0x031c:
            r11 = 0
            goto L_0x031f
        L_0x031e:
            r11 = 1
        L_0x031f:
            if (r11 != 0) goto L_0x033b
            com.original.tase.model.media.MediaSource r4 = new com.original.tase.model.media.MediaSource
            java.lang.String r5 = r20.A()
            r6 = 0
            r4.<init>(r5, r15, r6)
            r4.setStreamLink(r1)
            r4.setPlayHeader(r3)
            java.lang.String r1 = "1080"
            r4.setQuality((java.lang.String) r1)
            if (r2 == 0) goto L_0x033b
            r2.onNext(r4)
        L_0x033b:
            r1 = r16
            r5 = r17
            r6 = r18
        L_0x0341:
            r4 = 0
            goto L_0x00a1
        L_0x0344:
            r16 = r1
            r17 = r5
            r18 = r6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "getLink to resolver: "
            r1.append(r3)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r7, r1)
            com.original.tase.model.media.MediaSource r1 = new com.original.tase.model.media.MediaSource
            java.lang.String r3 = r20.A()
            r4 = 0
            r1.<init>(r3, r15, r4)
            r1.setStreamLink(r8)
            java.lang.String r3 = "HD"
            r1.setQuality((java.lang.String) r3)
            if (r2 == 0) goto L_0x0375
            r2.onNext(r1)
        L_0x0375:
            r1 = r16
            r5 = r17
            r6 = r18
            goto L_0x00a1
        L_0x037d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.M4UFree.M(java.lang.String, int, int, java.lang.String, io.reactivex.ObservableEmitter):void");
    }

    public final byte[] N(String str) {
        Intrinsics.f(str, "hex");
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        IntProgression i2 = RangesKt___RangesKt.i(RangesKt___RangesKt.j(0, length), 2);
        int a2 = i2.a();
        int b2 = i2.b();
        int d2 = i2.d();
        if ((d2 > 0 && a2 <= b2) || (d2 < 0 && b2 <= a2)) {
            while (true) {
                String substring = str.substring(a2, a2 + 2);
                Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                bArr[a2 / 2] = (byte) (Integer.parseInt(substring, CharsKt__CharJVMKt.a(16)) & JfifUtil.MARKER_FIRST_BYTE);
                if (a2 == b2) {
                    break;
                }
                a2 += d2;
            }
        }
        return bArr;
    }

    public final String O(String str) {
        Intrinsics.f(str, "hex");
        String encodeToString = Base64.encodeToString(N(str), 0);
        Intrinsics.e(encodeToString, "encodeToString(...)");
        return encodeToString;
    }

    public final String P(String str, String str2, int i2, int i3) {
        boolean z2;
        Intrinsics.f(str, "name");
        Intrinsics.f(str2, "year");
        if (i2 < 0 || i3 < 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            str2 = 'S' + com.original.tase.utils.Utils.i(i2) + 'E' + com.original.tase.utils.Utils.i(i3);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        hashMap.put("referer", this.f37375e + '/');
        hashMap.put("origin", this.f37375e);
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.ROOT;
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        sb.append(lowerCase);
        sb.append(' ');
        String lowerCase2 = str2.toLowerCase(locale);
        Intrinsics.e(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        sb.append(lowerCase2);
        String h2 = TitleHelper.h(sb.toString(), "-");
        Intrinsics.e(h2, "replaceAllkeywithTarget(...)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f40434a;
        String format = String.format("%s/search/%s.html", Arrays.copyOf(new Object[]{this.f37375e, h2}, 2));
        Intrinsics.e(format, "format(format, *args)");
        Iterator it2 = Jsoup.b(HttpHelper.i().m(format, new Map[0])).q0("div.row div.item").g("a[href]").iterator();
        Intrinsics.e(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next = it2.next();
            Intrinsics.d(next, "null cannot be cast to non-null type org.jsoup.nodes.Element");
            Element element = (Element) next;
            String c2 = element.c("title");
            Intrinsics.c(c2);
            Locale locale2 = Locale.ROOT;
            String lowerCase3 = c2.toLowerCase(locale2);
            Intrinsics.e(lowerCase3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            String h3 = TitleHelper.h(lowerCase3, "");
            Intrinsics.e(h3, "replaceAllkeywithTarget(...)");
            StringBuilder sb2 = new StringBuilder();
            String lowerCase4 = str.toLowerCase(locale2);
            Intrinsics.e(lowerCase4, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            sb2.append(lowerCase4);
            String lowerCase5 = str2.toLowerCase(locale2);
            Intrinsics.e(lowerCase5, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            sb2.append(lowerCase5);
            String h4 = TitleHelper.h(sb2.toString(), "");
            Intrinsics.e(h4, "replaceAllkeywithTarget(...)");
            if (StringsKt__StringsJVMKt.G(h3, h4, false, 2, (Object) null)) {
                String c3 = element.c("href");
                Intrinsics.e(c3, "attr(...)");
                if (!StringsKt__StringsKt.L(c3, UriUtil.HTTP_SCHEME, false, 2, (Object) null)) {
                    return this.f37375e + '/' + c3;
                } else if (!StringsKt__StringsJVMKt.G(c3, "/", false, 2, (Object) null)) {
                    return c3;
                } else {
                    return this.f37375e + c3;
                }
            }
        }
        return "";
    }
}
