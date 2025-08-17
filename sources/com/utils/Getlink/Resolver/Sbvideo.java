package com.utils.Getlink.Resolver;

import com.google.gson.Gson;
import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import com.utils.kotlin.KotlinHelper;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Sbvideo extends BaseResolver {

    /* renamed from: e  reason: collision with root package name */
    public static final char[] f37542e = "0123456789ABCDEF".toCharArray();

    /* renamed from: f  reason: collision with root package name */
    public static SbsConfig f37543f = new SbsConfig("watchsb", "sbstream", "/375664356a494546326c4b797c7c6e756577776778623171737/", "");

    /* renamed from: g  reason: collision with root package name */
    public static boolean f37544g = false;

    private static void n() {
        if (!f37544g) {
            f37544g = true;
            HttpHelper i2 = HttpHelper.i();
            String m2 = i2.m(Constants.E + "resolver/sbs.js", new Map[0]);
            if (!m2.isEmpty()) {
                f37543f = (SbsConfig) new Gson().l(m2, SbsConfig.class);
            }
        }
    }

    public String c() {
        return "Sbvideo";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        n();
        String streamLink = mediaSource.getStreamLink();
        String b2 = Regex.b(streamLink, "(?://|\\.)(sblona|sbvideo|sbembed|watchsb|sbspeed|sblongvu|vidmovie|streamsss|sbnet|sbplay\\d+)\\.(?:to|com|net|xyz|one)/(?:embed-|play/|e/|d/|v/|)?([a-zA-Z0-9]+)", 2, 2);
        Regex.b(streamLink, "(?://|\\.)(sbvideo|sbembed)\\.(?:to|com|net)/(?:embed-|play/|e/)?([a-zA-Z0-9]+)", 1, 2);
        if (!b2.isEmpty()) {
            BaseProvider.j(streamLink);
            String o2 = o(BaseProvider.j(streamLink), b2);
            HashMap hashMap = new HashMap();
            hashMap.put(TheTvdb.HEADER_ACCEPT, "*/*");
            hashMap.put("Referer", BaseProvider.j(streamLink) + "/");
            hashMap.put("Origin", BaseProvider.j(streamLink));
            SbsConfig sbsConfig = f37543f;
            hashMap.put(sbsConfig.f37538a, sbsConfig.f37539b);
            hashMap.put("User-Agent", Constants.C);
            String m2 = HttpHelper.i().m(o2, hashMap);
            ArrayList arrayList = new ArrayList();
            arrayList.add(m2);
            if (JsUnpacker.m30920(m2)) {
                arrayList.addAll(JsUnpacker.m30916(m2));
            }
            Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
            while (it2.hasNext()) {
                ResolveResult next = it2.next();
                if (next.getResolvedQuality() == null || next.getResolvedQuality().isEmpty() || next.getResolvedQuality().length() < 2) {
                    next.setResolvedQuality(mediaSource.getQuality());
                }
                hashMap.put("Host", BaseProvider.i(next.getResolvedLink()));
                next.setPlayHeader(hashMap);
                observableEmitter.onNext(BaseResolver.a(mediaSource, next));
            }
        }
    }

    public String o(String str, String str2) {
        String c2 = KotlinHelper.f37692a.c(str2);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(f37543f.f37540c);
        if (c2 == null) {
            return "";
        }
        sb.append(c2);
        if (!f37543f.f37541d.isEmpty()) {
            sb.append(f37543f.f37541d);
        }
        return sb.toString();
    }
}
