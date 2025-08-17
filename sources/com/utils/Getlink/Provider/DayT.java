package com.utils.Getlink.Provider;

import com.google.gson.Gson;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.Step;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public final class DayT extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private final String f37302e;

    /* renamed from: f  reason: collision with root package name */
    private String f37303f = Deobfuscator$app$ProductionRelease.a(-262817352200388L);

    public DayT() {
        String provider = Utils.getProvider(76);
        Intrinsics.e(provider, Deobfuscator$app$ProductionRelease.a(-262856006906052L));
        this.f37302e = provider;
    }

    private final String J(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            int V = StringsKt__StringsKt.V(str2, charAt, 0, false, 6, (Object) null);
            if (V != -1) {
                charAt = str3.charAt(V);
            }
            arrayList.add(Character.valueOf(charAt));
        }
        return CollectionsKt___CollectionsKt.J(arrayList, Deobfuscator$app$ProductionRelease.a(-260223191953604L), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private final void N(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        boolean z2;
        boolean z3;
        String K = K(Deobfuscator$app$ProductionRelease.a(-263590446313668L), L());
        String m2 = HttpHelper.i().m(str, new Map[0]);
        String j2 = BaseProvider.j(str);
        try {
            Iterator it2 = Jsoup.b(m2).q0(Deobfuscator$app$ProductionRelease.a(-263551791608004L)).g(Deobfuscator$app$ProductionRelease.a(-263534611738820L)).iterator();
            Intrinsics.e(it2, Deobfuscator$app$ProductionRelease.a(-262078617825476L));
            HashMap<String, String> c2 = Constants.c();
            while (it2.hasNext()) {
                Object next = it2.next();
                Intrinsics.d(next, Deobfuscator$app$ProductionRelease.a(-262052848021700L));
                String c3 = ((Element) next).c(Deobfuscator$app$ProductionRelease.a(-261756495278276L));
                HttpHelper i2 = HttpHelper.i();
                StringCompanionObject stringCompanionObject = StringCompanionObject.f40434a;
                String a2 = Deobfuscator$app$ProductionRelease.a(-261722135539908L);
                List<Step> M = M(K);
                Intrinsics.c(c3);
                String format = String.format(a2, Arrays.copyOf(new Object[]{j2, c3, R(M, c3)}, 3));
                Intrinsics.e(format, Deobfuscator$app$ProductionRelease.a(-261850984558788L));
                Iterator<String> it3 = Regex.g(i2.m(format, c2), Deobfuscator$app$ProductionRelease.a(-262546769260740L), 1, true).iterator();
                while (it3.hasNext()) {
                    String next2 = it3.next();
                    HttpHelper i3 = HttpHelper.i();
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.f40434a;
                    String a3 = Deobfuscator$app$ProductionRelease.a(-262692798148804L);
                    List<Step> M2 = M(K);
                    Intrinsics.c(next2);
                    String format2 = String.format(a3, Arrays.copyOf(new Object[]{j2, next2, R(M2, next2)}, 3));
                    Intrinsics.e(format2, Deobfuscator$app$ProductionRelease.a(-262276186321092L));
                    String a4 = Regex.a(i3.m(format2, new Map[0]), Deobfuscator$app$ProductionRelease.a(-262456574947524L), 1);
                    Intrinsics.c(a4);
                    if (a4.length() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        String Q = Q(M(K), a4);
                        if (Q.length() == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            MediaSource mediaSource = new MediaSource(A(), Deobfuscator$app$ProductionRelease.a(-260983401164996L), false);
                            mediaSource.setStreamLink(Q);
                            mediaSource.setPlayHeader(c2);
                            mediaSource.setQuality(Deobfuscator$app$ProductionRelease.a(-260918976655556L));
                            observableEmitter.onNext(mediaSource);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private final String O(String str, String str2) {
        Charset charset = Charsets.f40513b;
        byte[] bytes = str2.getBytes(charset);
        Intrinsics.e(bytes, Deobfuscator$app$ProductionRelease.a(-260416465481924L));
        byte[] h2 = Base64.h(Base64.f40394c.r(), bytes, 0, 0, 6, (Object) null);
        byte[] bytes2 = str.getBytes(charset);
        Intrinsics.e(bytes2, Deobfuscator$app$ProductionRelease.a(-260536724566212L));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, Deobfuscator$app$ProductionRelease.a(-260038508359876L));
        Cipher instance = Cipher.getInstance(Deobfuscator$app$ProductionRelease.a(-260055688229060L));
        instance.init(2, secretKeySpec, instance.getParameters());
        byte[] doFinal = instance.doFinal(h2);
        Intrinsics.e(doFinal, Deobfuscator$app$ProductionRelease.a(-260279026528452L));
        return new String(doFinal, charset);
    }

    private final String P(String str, String str2) {
        Charset charset = Charsets.f40513b;
        byte[] bytes = str.getBytes(charset);
        Intrinsics.e(bytes, Deobfuscator$app$ProductionRelease.a(-261326998548676L));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, Deobfuscator$app$ProductionRelease.a(-260004148621508L));
        Cipher instance = Cipher.getInstance(Deobfuscator$app$ProductionRelease.a(-260021328490692L));
        instance.init(1, secretKeySpec, instance.getParameters());
        byte[] bytes2 = str2.getBytes(charset);
        Intrinsics.e(bytes2, Deobfuscator$app$ProductionRelease.a(-259969788883140L));
        byte[] doFinal = instance.doFinal(bytes2);
        Base64 r2 = Base64.f40394c.r();
        Intrinsics.c(doFinal);
        byte[] bytes3 = Base64.l(r2, doFinal, 0, 0, 6, (Object) null).getBytes(charset);
        Intrinsics.e(bytes3, Deobfuscator$app$ProductionRelease.a(-259540292153540L));
        Intrinsics.c(bytes3);
        return new String(bytes3, charset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0012, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String Q(java.util.List<? extends com.original.tase.model.Step> r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            com.utils.Getlink.Provider.DayT$vrfDecrypt$$inlined$sortedByDescending$1 r0 = new com.utils.Getlink.Provider.DayT$vrfDecrypt$$inlined$sortedByDescending$1
            r0.<init>()
            java.util.List r8 = kotlin.collections.CollectionsKt___CollectionsKt.T(r8, r0)
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x0011:
            r1 = r9
        L_0x0012:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00e2
            java.lang.Object r9 = r8.next()
            com.original.tase.model.Step r9 = (com.original.tase.model.Step) r9
            java.lang.String r0 = r9.getMethod()
            if (r0 == 0) goto L_0x0012
            int r2 = r0.hashCode()
            r3 = 0
            r4 = 0
            switch(r2) {
                case -1396204209: goto L_0x00ba;
                case 112675: goto L_0x008f;
                case 3116345: goto L_0x0086;
                case 1099846370: goto L_0x006d;
                case 1989774883: goto L_0x002e;
                default: goto L_0x002d;
            }
        L_0x002d:
            goto L_0x0012
        L_0x002e:
            r5 = -261206739464388(0xffff126f1114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r5)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x003e
            goto L_0x0012
        L_0x003e:
            java.util.List r0 = r9.getKeys()
            if (r0 == 0) goto L_0x004c
            r2 = 1
            java.lang.Object r0 = r0.get(r2)
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4
        L_0x004c:
            if (r4 != 0) goto L_0x004f
            goto L_0x0012
        L_0x004f:
            kotlin.jvm.internal.Intrinsics.c(r4)
            java.util.List r9 = r9.getKeys()
            java.lang.Object r9 = r9.get(r3)
            r2 = -261168084758724(0xffff12781114cf3c, double:NaN)
            java.lang.String r0 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)
            kotlin.jvm.internal.Intrinsics.e(r9, r0)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r1 = r7.J(r1, r4, r9)
            goto L_0x0012
        L_0x006d:
            r2 = -261202444497092(0xffff12701114cf3c, double:NaN)
            java.lang.String r9 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)
            boolean r9 = r0.equals(r9)
            if (r9 != 0) goto L_0x007d
            goto L_0x0012
        L_0x007d:
            java.lang.CharSequence r9 = kotlin.text.StringsKt___StringsKt.T0(r1)
            java.lang.String r1 = r9.toString()
            goto L_0x0012
        L_0x0086:
            r2 = -261567516717252(0xffff121b1114cf3c, double:NaN)
            io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)
            goto L_0x0012
        L_0x008f:
            r5 = -261550336848068(0xffff121f1114cf3c, double:NaN)
            java.lang.String r2 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r5)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00a0
            goto L_0x0012
        L_0x00a0:
            java.util.List r9 = r9.getKeys()
            if (r9 == 0) goto L_0x00ad
            java.lang.Object r9 = r9.get(r3)
            r4 = r9
            java.lang.String r4 = (java.lang.String) r4
        L_0x00ad:
            if (r4 != 0) goto L_0x00b1
            goto L_0x0012
        L_0x00b1:
            kotlin.jvm.internal.Intrinsics.c(r4)
            java.lang.String r1 = r7.O(r4, r1)
            goto L_0x0012
        L_0x00ba:
            r2 = -261271163973828(0xffff12601114cf3c, double:NaN)
            java.lang.String r9 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r2)
            boolean r9 = r0.equals(r9)
            if (r9 != 0) goto L_0x00cb
            goto L_0x0012
        L_0x00cb:
            java.lang.String r9 = new java.lang.String
            kotlin.io.encoding.Base64$Default r0 = kotlin.io.encoding.Base64.f40394c
            kotlin.io.encoding.Base64 r0 = r0.r()
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            byte[] r0 = kotlin.io.encoding.Base64.g(r0, r1, r2, r3, r4, r5)
            java.nio.charset.Charset r1 = kotlin.text.Charsets.f40513b
            r9.<init>(r0, r1)
            goto L_0x0011
        L_0x00e2:
            r8 = -261404307960004(0xffff12411114cf3c, double:NaN)
            java.lang.String r8 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r8)
            java.lang.String r8 = java.net.URLDecoder.decode(r1, r8)
            r0 = -261344178417860(0xffff124f1114cf3c, double:NaN)
            java.lang.String r9 = io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease.a(r0)
            kotlin.jvm.internal.Intrinsics.e(r8, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.Getlink.Provider.DayT.Q(java.util.List, java.lang.String):java.lang.String");
    }

    private final String R(List<? extends Step> list, String str) {
        for (Step step : CollectionsKt___CollectionsKt.T(list, new DayT$vrfEncrypt$$inlined$sortedBy$1())) {
            String method = step.getMethod();
            if (method != null) {
                String str2 = null;
                switch (method.hashCode()) {
                    case -1396204209:
                        if (method.equals(Deobfuscator$app$ProductionRelease.a(-260833077309636L))) {
                            Charset charset = Charsets.f40513b;
                            byte[] bytes = str.getBytes(charset);
                            Intrinsics.e(bytes, Deobfuscator$app$ProductionRelease.a(-261515977109700L));
                            byte[] encode = android.util.Base64.encode(bytes, 10);
                            Intrinsics.e(encode, Deobfuscator$app$ProductionRelease.a(-261636236193988L));
                            str = new String(encode, charset);
                            break;
                        } else {
                            break;
                        }
                    case 112675:
                        if (!method.equals(Deobfuscator$app$ProductionRelease.a(-260596854108356L))) {
                            break;
                        } else {
                            List<String> keys = step.getKeys();
                            if (keys != null) {
                                str2 = keys.get(0);
                            }
                            if (str2 != null) {
                                Intrinsics.c(str2);
                                str = P(str2, str);
                                break;
                            } else {
                                break;
                            }
                        }
                    case 3116345:
                        Deobfuscator$app$ProductionRelease.a(-260614033977540L);
                        break;
                    case 1099846370:
                        if (method.equals(Deobfuscator$app$ProductionRelease.a(-260764357832900L))) {
                            str = StringsKt___StringsKt.T0(str).toString();
                            break;
                        } else {
                            break;
                        }
                    case 1989774883:
                        if (!method.equals(Deobfuscator$app$ProductionRelease.a(-260803012538564L))) {
                            break;
                        } else {
                            List<String> keys2 = step.getKeys();
                            if (keys2 != null) {
                                str2 = keys2.get(0);
                            }
                            if (str2 != null) {
                                Intrinsics.c(str2);
                                String str3 = step.getKeys().get(1);
                                Intrinsics.e(str3, Deobfuscator$app$ProductionRelease.a(-260729998094532L));
                                str = J(str, str2, str3);
                                break;
                            } else {
                                break;
                            }
                        }
                }
            }
        }
        return str;
    }

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-258904636993732L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        Intrinsics.f(movieInfo, Deobfuscator$app$ProductionRelease.a(-262813057233092L));
        Intrinsics.f(observableEmitter, Deobfuscator$app$ProductionRelease.a(-263044985467076L));
        StringCompanionObject stringCompanionObject = StringCompanionObject.f40434a;
        String format = String.format(Deobfuscator$app$ProductionRelease.a(-262963381088452L), Arrays.copyOf(new Object[]{this.f37302e, movieInfo.imdbIDStr}, 2));
        Intrinsics.e(format, Deobfuscator$app$ProductionRelease.a(-263732180234436L));
        N(observableEmitter, movieInfo, format);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        Intrinsics.f(movieInfo, Deobfuscator$app$ProductionRelease.a(-263637690953924L));
        Intrinsics.f(observableEmitter, Deobfuscator$app$ProductionRelease.a(-263869619187908L));
        StringCompanionObject stringCompanionObject = StringCompanionObject.f40434a;
        String format = String.format(Deobfuscator$app$ProductionRelease.a(-263788014809284L), Arrays.copyOf(new Object[]{this.f37302e, movieInfo.imdbIDStr, movieInfo.session, movieInfo.eps}, 4));
        Intrinsics.e(format, Deobfuscator$app$ProductionRelease.a(-263410057687236L));
        N(observableEmitter, movieInfo, format);
    }

    public final String K(String str, String str2) {
        Intrinsics.f(str, Deobfuscator$app$ProductionRelease.a(-260218896986308L));
        Intrinsics.f(str2, Deobfuscator$app$ProductionRelease.a(-260236076855492L));
        try {
            String string = new JSONObject(str2).getString(str);
            Intrinsics.e(string, Deobfuscator$app$ProductionRelease.a(-260201717117124L));
            return string;
        } catch (Exception unused) {
            return Deobfuscator$app$ProductionRelease.a(-258762903072964L);
        }
    }

    public final String L() {
        boolean z2;
        if (this.f37303f.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            String m2 = HttpHelper.i().m(Deobfuscator$app$ProductionRelease.a(-261112250183876L), new Map[0]);
            Intrinsics.e(m2, Deobfuscator$app$ProductionRelease.a(-260682753454276L));
            this.f37303f = m2;
        }
        return this.f37303f;
    }

    public final List<Step> M(String str) {
        Intrinsics.f(str, Deobfuscator$app$ProductionRelease.a(-258758608105668L));
        Object l2 = new Gson().l(str, Step[].class);
        Intrinsics.e(l2, Deobfuscator$app$ProductionRelease.a(-258724248367300L));
        return ArraysKt___ArraysKt.Q((Object[]) l2);
    }
}
