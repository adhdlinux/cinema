package com.utils.Getlink.Resolver;

import com.facebook.common.util.UriUtil;
import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

public final class Dropload extends BaseResolver {
    public String c() {
        return "Dropload";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        boolean z2;
        boolean z3;
        Intrinsics.c(mediaSource);
        String streamLink = mediaSource.getStreamLink();
        String a2 = Regex.a(streamLink, "(?://|\\.)(dropload)\\.(?:tv|cc|to|co|sx|io)/(?:embed-|e/|d/|v/)?([0-9a-zA-Z]+)", 2);
        Intrinsics.e(a2, "m33107(...)");
        if (a2.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            String str = BaseProvider.j(streamLink) + "/e/" + a2 + ".html";
            ArrayList arrayList = new ArrayList();
            String m2 = HttpHelper.i().m(str, new Map[0]);
            Intrinsics.c(m2);
            if (!StringsKt__StringsKt.L(m2, "Not Found", false, 2, (Object) null)) {
                Intrinsics.c(m2);
                if (!StringsKt__StringsKt.L(m2, "File was deleted", false, 2, (Object) null)) {
                    Intrinsics.c(m2);
                    if (!StringsKt__StringsKt.L(m2, "is no longer available", false, 2, (Object) null)) {
                        arrayList.add(m2);
                        if (JsUnpacker.m30920(m2)) {
                            arrayList.addAll(JsUnpacker.m30916(m2));
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("Referer", BaseProvider.j(str) + '/');
                        String str2 = Constants.C;
                        Intrinsics.e(str2, "userAgent");
                        hashMap.put("User-Agent", str2);
                        String a3 = Regex.a(arrayList.toString(), "[\"']?((?:https:|http:)[^\\s\"']*(?:m3u8|mp4|mkv)[^\\s\"']*)[\"']?", 1);
                        Intrinsics.e(a3, "m33107(...)");
                        if (a3.length() == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            String M0 = StringsKt__StringsKt.M0(a3, "master", (String) null, 2, (Object) null);
                            String m3 = HttpHelper.i().m(a3, hashMap);
                            Intrinsics.c(m3);
                            for (String str3 : StringsKt__StringsKt.v0(StringsKt__StringsKt.G0(m3, "#EXT-X-STREAM-INF:", (String) null, 2, (Object) null), new String[]{"#EXT-X-STREAM-INF:"}, false, 0, 6, (Object) null)) {
                                String M02 = StringsKt__StringsKt.M0(StringsKt__StringsKt.G0(StringsKt__StringsKt.G0(str3, "RESOLUTION=", (String) null, 2, (Object) null), "x", (String) null, 2, (Object) null), ",", (String) null, 2, (Object) null);
                                String M03 = StringsKt__StringsKt.M0(StringsKt__StringsKt.G0(str3, ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, (String) null, 2, (Object) null), ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, (String) null, 2, (Object) null);
                                if (!StringsKt__StringsJVMKt.G(M03, UriUtil.HTTP_SCHEME, false, 2, (Object) null)) {
                                    M03 = M0 + M03;
                                }
                                String i2 = BaseProvider.i(M03);
                                Intrinsics.e(i2, "getBasehosturl(...)");
                                hashMap.put("Host", i2);
                                hashMap.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US;q=0.6,en;q=0.4");
                                String c2 = c();
                                if (M02 == null) {
                                    M02 = "HD";
                                }
                                ResolveResult resolveResult = new ResolveResult(c2, M03, M02);
                                resolveResult.setPlayHeader(hashMap);
                                Intrinsics.c(observableEmitter);
                                MediaSource a4 = BaseResolver.a(mediaSource, resolveResult);
                                Intrinsics.e(a4, "convertResolverResultToMediaSouce(...)");
                                observableEmitter.onNext(a4);
                            }
                        }
                    }
                }
            }
        }
    }
}
