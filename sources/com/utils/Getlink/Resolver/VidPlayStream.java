package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.utils.Getlink.Provider.BaseProvider;
import com.utils.kotlin.AesHelper;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

public final class VidPlayStream extends BaseResolver {

    /* renamed from: e  reason: collision with root package name */
    private String f37550e = Deobfuscator$app$ProductionRelease.a(-258883162157252L);

    /* renamed from: f  reason: collision with root package name */
    private final String f37551f = Deobfuscator$app$ProductionRelease.a(-258878867189956L);

    private final String n(String str, String str2) {
        List<String> a2;
        String str3;
        String str4 = str2;
        HttpHelper i2 = HttpHelper.i();
        String o2 = i2.o(this.f37550e + Deobfuscator$app$ProductionRelease.a(-257117930598596L), str4);
        Regex regex = new Regex(Deobfuscator$app$ProductionRelease.a(-257113635631300L));
        Intrinsics.c(o2);
        MatchResult c2 = Regex.c(regex, o2, 0, 2, (Object) null);
        if (c2 == null || (a2 = c2.a()) == null || (str3 = a2.get(1)) == null) {
            return null;
        }
        List k2 = CollectionsKt__CollectionsKt.k(str3);
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            k2.add(String.valueOf(str3.charAt(i3 % str3.length()) + str.charAt(i3)));
        }
        return this.f37550e + Deobfuscator$app$ProductionRelease.a(-257070685958340L) + CollectionsKt___CollectionsKt.J(k2, Deobfuscator$app$ProductionRelease.a(-257259664519364L), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + '?' + StringsKt__StringsKt.G0(str4, Deobfuscator$app$ProductionRelease.a(-257285434323140L), (String) null, 2, (Object) null);
    }

    private final String o(String str, List<String> list) {
        Cipher instance = Cipher.getInstance(Deobfuscator$app$ProductionRelease.a(-257165175238852L));
        Cipher instance2 = Cipher.getInstance(Deobfuscator$app$ProductionRelease.a(-257182355108036L));
        Charset charset = Charsets.f40513b;
        byte[] bytes = list.get(0).getBytes(charset);
        Intrinsics.e(bytes, Deobfuscator$app$ProductionRelease.a(-256855937593540L));
        instance.init(2, new SecretKeySpec(bytes, Deobfuscator$app$ProductionRelease.a(-256976196677828L)), instance.getParameters());
        byte[] bytes2 = list.get(1).getBytes(charset);
        Intrinsics.e(bytes2, Deobfuscator$app$ProductionRelease.a(-256924657070276L));
        instance2.init(2, new SecretKeySpec(bytes2, Deobfuscator$app$ProductionRelease.a(-255395648712900L)), instance2.getParameters());
        byte[] bytes3 = str.getBytes(charset);
        Intrinsics.e(bytes3, Deobfuscator$app$ProductionRelease.a(-255618987012292L));
        byte[] doFinal = instance.doFinal(bytes3);
        Intrinsics.e(doFinal, Deobfuscator$app$ProductionRelease.a(-255189490282692L));
        byte[] doFinal2 = instance2.doFinal(doFinal);
        Intrinsics.e(doFinal2, Deobfuscator$app$ProductionRelease.a(-255099295969476L));
        return StringsKt__StringsJVMKt.C(AesHelper.f37691a.b(doFinal2), Deobfuscator$app$ProductionRelease.a(-255352699039940L), Deobfuscator$app$ProductionRelease.a(-255309749366980L), false, 4, (Object) null);
    }

    private final List<String> p() {
        ArrayList<String> h2 = com.original.tase.utils.Regex.h(HttpHelper.i().m(this.f37551f, new Map[0]), Deobfuscator$app$ProductionRelease.a(-257276844388548L), true);
        Intrinsics.e(h2, Deobfuscator$app$ProductionRelease.a(-257251074584772L));
        return h2;
    }

    public String c() {
        return Deobfuscator$app$ProductionRelease.a(-258539564773572L);
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        boolean z2;
        int i2;
        boolean z3;
        Intrinsics.c(mediaSource);
        String streamLink = mediaSource.getStreamLink();
        String j2 = BaseProvider.j(streamLink);
        Intrinsics.e(j2, Deobfuscator$app$ProductionRelease.a(-259295479017668L));
        this.f37550e = j2;
        String b2 = com.original.tase.utils.Regex.b(streamLink, Deobfuscator$app$ProductionRelease.a(-259226759540932L), 2, 2);
        Intrinsics.c(b2);
        if (b2.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            String o2 = o(b2, p());
            Intrinsics.c(streamLink);
            String n2 = n(o2, streamLink);
            HashMap<String, String> c2 = Constants.c();
            c2.put(Deobfuscator$app$ProductionRelease.a(-257581787066564L), Deobfuscator$app$ProductionRelease.a(-257826600202436L));
            c2.put(Deobfuscator$app$ProductionRelease.a(-257349858832580L), streamLink);
            c2.put(Deobfuscator$app$ProductionRelease.a(-257315499094212L), Deobfuscator$app$ProductionRelease.a(-257560312230084L));
            String m2 = HttpHelper.i().m(n2, c2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(m2);
            if (JsUnpacker.m30920(m2)) {
                arrayList.addAll(JsUnpacker.m30916(m2));
            }
            Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
            Intrinsics.e(it2, Deobfuscator$app$ProductionRelease.a(-258135837847748L));
            while (it2.hasNext()) {
                ResolveResult next = it2.next();
                Intrinsics.d(next, Deobfuscator$app$ProductionRelease.a(-258350586212548L));
                ResolveResult resolveResult = next;
                if (resolveResult.getResolvedQuality() != null) {
                    String resolvedQuality = resolveResult.getResolvedQuality();
                    Intrinsics.e(resolvedQuality, Deobfuscator$app$ProductionRelease.a(-258028463665348L));
                    int length = resolvedQuality.length() - 1;
                    int i3 = 0;
                    boolean z4 = false;
                    while (i3 <= length) {
                        if (!z4) {
                            i2 = i3;
                        } else {
                            i2 = length;
                        }
                        if (Intrinsics.h(resolvedQuality.charAt(i2), 32) <= 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z4) {
                            if (!z3) {
                                z4 = true;
                            } else {
                                i3++;
                            }
                        } else if (!z3) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    String obj = resolvedQuality.subSequence(i3, length + 1).toString();
                    Locale locale = Locale.getDefault();
                    Intrinsics.e(locale, Deobfuscator$app$ProductionRelease.a(-256550994915524L));
                    String lowerCase = obj.toLowerCase(locale);
                    Intrinsics.e(lowerCase, Deobfuscator$app$ProductionRelease.a(-256482275438788L));
                    if (Intrinsics.a(lowerCase, Deobfuscator$app$ProductionRelease.a(-256284706943172L))) {
                        resolveResult.setResolvedQuality(mediaSource.getQuality());
                    }
                }
                if (GoogleVideoHelper.n(resolveResult.getResolvedLink())) {
                    resolveResult.setResolverName(Deobfuscator$app$ProductionRelease.a(-256237462302916L));
                }
                resolveResult.setResolvedQuality(mediaSource.getQuality());
                Intrinsics.c(observableEmitter);
                MediaSource a2 = BaseResolver.a(mediaSource, resolveResult);
                Intrinsics.e(a2, Deobfuscator$app$ProductionRelease.a(-256220282433732L));
                observableEmitter.onNext(a2);
            }
        }
    }
}
