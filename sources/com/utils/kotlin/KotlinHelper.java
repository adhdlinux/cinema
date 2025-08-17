package com.utils.kotlin;

import android.util.Base64;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.common.internal.ImagesContract;
import com.original.tase.helper.DateTimeHelper;
import com.original.tase.model.ResolveResult;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

public final class KotlinHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f37692a = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final String f37693b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static final String h(String str, String str2) {
            List<String> a2;
            String str3;
            String str4 = null;
            MatchResult c2 = Regex.c(new Regex(',' + str2 + "=((?:0x)?([0-9a-fA-F]+))"), str, 0, 2, (Object) null);
            if (!(c2 == null || (a2 = c2.a()) == null || (str3 = a2.get(1)) == null)) {
                str4 = StringsKt__StringsKt.m0(str3, "0x");
            }
            Intrinsics.c(str4);
            return str4;
        }

        private final byte[] o(byte[] bArr) {
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                bArr[i2] = (byte) (bArr[i2] + new Integer[]{4, 3, -2, 5, 2, -4, -4, 2}[i2 % 8].intValue());
            }
            return bArr;
        }

        public final int[] a(int[] iArr, int[] iArr2) {
            Intrinsics.f(iArr, "z");
            Intrinsics.f(iArr2, "Q0");
            try {
                int length = iArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = iArr[i2] ^ iArr2[i2 % iArr2.length];
                }
                return iArr;
            } catch (Exception unused) {
                return null;
            }
        }

        public final String b() {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < 12; i2++) {
                Companion companion = KotlinHelper.f37692a;
                sb.append(companion.e().charAt(Random.f40443b.d(companion.e().length())));
            }
            String sb2 = sb.toString();
            Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }

        public final String c(String str) {
            Intrinsics.f(str, "id");
            char[] charArray = (b() + "||" + str + "||" + b() + "||streamsb").toCharArray();
            Intrinsics.e(charArray, "this as java.lang.String).toCharArray()");
            return ArraysKt___ArraysKt.L(charArray, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, KotlinHelper$Companion$encodeId$1.f37694f, 30, (Object) null);
        }

        public final String d(Regex regex, String str) {
            List<String> a2;
            Intrinsics.f(regex, "<this>");
            Intrinsics.f(str, "str");
            MatchResult c2 = Regex.c(regex, str, 0, 2, (Object) null);
            if (c2 == null || (a2 = c2.a()) == null) {
                return null;
            }
            return (String) CollectionsKt___CollectionsKt.E(a2, 1);
        }

        public final String e() {
            return KotlinHelper.f37693b;
        }

        public final String f(String str, String str2) {
            Intrinsics.f(str, "jsonString");
            Intrinsics.f(str2, "Q3");
            Iterable<String> v02 = StringsKt__StringsKt.v0(StringsKt__StringsKt.p0(str, "[", "]"), new String[]{","}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(v02, 10));
            for (String N0 : v02) {
                arrayList.add(Integer.valueOf(Integer.parseInt(StringsKt__StringsKt.N0(N0).toString())));
            }
            int[] a2 = a(CollectionsKt___CollectionsKt.Z(arrayList), l(Integer.parseInt("" + str2)));
            if (a2 == null) {
                return "";
            }
            ArrayList<Number> arrayList2 = new ArrayList<>();
            for (int valueOf : a2) {
                arrayList2.add(Integer.valueOf(valueOf));
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.p(arrayList2, 10));
            for (Number intValue : arrayList2) {
                arrayList3.add(Byte.valueOf((byte) intValue.intValue()));
            }
            return AesHelper.f37691a.b(CollectionsKt___CollectionsKt.W(arrayList3));
        }

        public final List<List<Integer>> g(String str) {
            List list;
            Intrinsics.f(str, "script");
            Iterable<MatchResult> l2 = SequencesKt___SequencesKt.l(Regex.e(new Regex("case\\s*0x[0-9a-f]+:(?![^;]*=partKey)\\s*\\w+\\s*=\\s*(\\w+)\\s*,\\s*\\w+\\s*=\\s*(\\w+);"), str, 0, 2, (Object) null));
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(l2, 10));
            for (MatchResult matchResult : l2) {
                try {
                    list = CollectionsKt__CollectionsKt.i(Integer.valueOf(Integer.parseInt(h(str, matchResult.a().get(1)), CharsKt__CharJVMKt.a(16))), Integer.valueOf(Integer.parseInt(h(str, matchResult.a().get(2)), CharsKt__CharJVMKt.a(16))));
                } catch (NumberFormatException unused) {
                    list = CollectionsKt__CollectionsKt.f();
                }
                arrayList.add(list);
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object next : arrayList) {
                if (!((List) next).isEmpty()) {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }

        public final List<ResolveResult> i(String str, String str2, String str3) {
            String str4;
            Intrinsics.f(str, "source");
            Intrinsics.f(str2, "hostname");
            Intrinsics.f(str3, "referer");
            String G0 = StringsKt__StringsKt.G0(str, "sources:[", (String) null, 2, (Object) null);
            if (G0 != null) {
                str4 = StringsKt__StringsKt.M0(G0, "],", (String) null, 2, (Object) null);
            } else {
                str4 = null;
            }
            if (str4 == null) {
                return CollectionsKt__CollectionsKt.f();
            }
            HashSet hashSet = new HashSet();
            ArrayList<Pair> arrayList = new ArrayList<>();
            for (Object next : SequencesKt___SequencesKt.l(SequencesKt___SequencesKt.k(Regex.e(new Regex("\"file\":\"(\\S+?)\".*?res=(\\d+)"), str4, 0, 2, (Object) null), KotlinHelper$Companion$getSourceGdriverplayer$1.f37695f))) {
                if (hashSet.add((String) ((Pair) next).d())) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.p(arrayList, 10));
            for (Pair pair : arrayList) {
                String str5 = (String) pair.b();
                arrayList2.add(new ResolveResult(str2, KotlinHelper.f37692a.k((String) pair.a()) + "&res=" + str5 + "&ref=" + URLEncoder.encode(str3, AudienceNetworkActivity.WEBVIEW_ENCODING) + "&t=" + DateTimeHelper.e() + '}', str5));
            }
            return arrayList2;
        }

        public final String j(String str) {
            String str2;
            String d2;
            List<String> k2;
            Intrinsics.f(str, "eval");
            String d3 = d(new Regex("null,['|\"](\\w+)['|\"]"), str);
            if (d3 == null || (k2 = new Regex("\\D+").k(d3, 0)) == null) {
                str2 = null;
            } else {
                str2 = CollectionsKt___CollectionsKt.J(k2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, KotlinHelper$Companion$getpassGdriverplayer$password$1.f37696f, 30, (Object) null);
            }
            Companion companion = KotlinHelper.f37692a;
            Regex regex = new Regex("var pass = \"(\\S+?)\"");
            if (str2 == null || (d2 = companion.d(regex, str2)) == null) {
                return "";
            }
            return d2;
        }

        public final String k(String str) {
            Intrinsics.f(str, ImagesContract.URL);
            if (!StringsKt__StringsJVMKt.G(str, "//", false, 2, (Object) null)) {
                return str;
            }
            return "https:" + str;
        }

        public final int[] l(int i2) {
            return new int[]{(-16777216 & i2) >> 24, (16711680 & i2) >> 16, (65280 & i2) >> 8, i2 & JfifUtil.MARKER_FIRST_BYTE};
        }

        public final String m(String str, String str2) {
            Intrinsics.f(str, "input");
            Intrinsics.f(str2, "key");
            Charset charset = Charsets.f40513b;
            byte[] bytes = str.getBytes(charset);
            Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] decode = Base64.decode(bytes, 8);
            Intrinsics.e(decode, "decode(...)");
            byte[] bytes2 = str2.getBytes(charset);
            Intrinsics.e(bytes2, "this as java.lang.String).getBytes(charset)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, "RC4");
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(2, secretKeySpec, instance.getParameters());
            byte[] doFinal = instance.doFinal(decode);
            Intrinsics.e(doFinal, "doFinal(...)");
            String decode2 = URLDecoder.decode(new String(doFinal, charset), AudienceNetworkActivity.WEBVIEW_ENCODING);
            Intrinsics.e(decode2, "decode(...)");
            return decode2;
        }

        public final String n(String str, String str2) {
            Intrinsics.f(str, "input");
            Intrinsics.f(str2, "key");
            Charset charset = Charsets.f40513b;
            byte[] bytes = str2.getBytes(charset);
            Intrinsics.e(bytes, "this as java.lang.String).getBytes(charset)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "RC4");
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, secretKeySpec, instance.getParameters());
            byte[] bytes2 = str.getBytes(charset);
            Intrinsics.e(bytes2, "this as java.lang.String).getBytes(charset)");
            byte[] encode = Base64.encode(Base64.encode(instance.doFinal(bytes2), 10), 10);
            Intrinsics.c(encode);
            ArraysKt___ArraysKt.M(encode);
            byte[] encode2 = Base64.encode(encode, 10);
            Intrinsics.c(encode2);
            byte[] o2 = o(encode2);
            Intrinsics.c(o2);
            String encode3 = URLEncoder.encode(new String(o2, charset), AudienceNetworkActivity.WEBVIEW_ENCODING);
            Intrinsics.e(encode3, "encode(...)");
            return encode3;
        }
    }
}
