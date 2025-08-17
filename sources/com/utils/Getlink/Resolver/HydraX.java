package com.utils.Getlink.Resolver;

import android.util.Base64;
import com.facebook.common.util.UriUtil;
import com.google.gson.Gson;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.hydrax.StreamXResponse;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.uwetrottmann.trakt5.TraktV2;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class HydraX extends BaseResolver {
    public String c() {
        return "HydraX";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String str;
        MediaSource mediaSource2 = mediaSource;
        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
        String replace = mediaSource.getStreamLink().replace("\\/", "/");
        if (replace.endsWith("\\")) {
            replace = replace.substring(0, replace.length() - 1);
        }
        HashMap hashMap = new HashMap();
        if (mediaSource.getPlayHeader() == null) {
            hashMap.put("User-Agent", Constants.C);
        } else {
            hashMap.putAll(mediaSource.getPlayHeader());
        }
        String m2 = HttpHelper.i().m(replace, hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        String a2 = Regex.a(m2, "Player\\s*\\((\\{.*\\})\\);", 1);
        if (!a2.isEmpty()) {
            String a3 = Regex.a(a2, "[\"']key[\"']\\s*:\\s*[\"']([^\"']+[^\"'])[\"']", 1);
            String a4 = Regex.a(a2, "[\"']type[\"']\\s*:\\s*[\"']([^\"']+[^\"'])[\"']", 1);
            String a5 = Regex.a(a2, "[\"']value[\"']\\s*:\\s*[\"']([^\"']+[^\"'])[\"']", 1);
            if (a3 == null) {
                String a6 = Regex.a(m2, "['\"]?file['\"]?\\s*:\\s*['\"]?([^'\"]+)", 1);
                if (!a6.isEmpty()) {
                    ResolveResult resolveResult = new ResolveResult(c(), a6.replace("\\/", "/"), "HD");
                    resolveResult.setPlayHeader(hashMap2);
                    observableEmitter2.onNext(BaseResolver.a(mediaSource2, resolveResult));
                }
                String b2 = Regex.b(m2, "<iframe[^>]+src=\"([^\"]+)\"[^>]*>", 1, 2);
                if (!b2.isEmpty()) {
                    String m3 = HttpHelper.i().m(b2, hashMap);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(m3);
                    if (JsUnpacker.m30920(m3)) {
                        arrayList.addAll(JsUnpacker.m30916(m3));
                    }
                    Iterator<ResolveResult> it2 = k(b2, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
                    while (it2.hasNext()) {
                        ResolveResult next = it2.next();
                        if (next.getResolvedQuality() != null && next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                            next.setResolvedQuality(mediaSource.getQuality());
                        }
                        next.setPlayHeader(hashMap2);
                        observableEmitter2.onNext(BaseResolver.a(mediaSource2, next));
                    }
                }
            } else if (a5.isEmpty()) {
                HashMap<String, String> c2 = Constants.c();
                c2.put("accept", "application/json, text/javascript, */*; q=0.01");
                c2.put("origin", "https://play.voxzer.org");
                c2.put("content-type", TraktV2.CONTENT_TYPE_JSON);
                c2.put("referer", mediaSource.getStreamLink());
                String a7 = Regex.a(HttpHelper.i().q("https://play.voxzer.org/data", String.format("{\"code\":\"%s\"}", new Object[]{Regex.a(mediaSource.getStreamLink(), "\\?v=(.*)", 1)}), false, c2), "['\"]?url['\"]?\\s*:\\s*['\"]?([^'\"]+)", 1);
                if (!a7.isEmpty()) {
                    if (!a7.startsWith(UriUtil.HTTP_SCHEME)) {
                        try {
                            str = new String(Base64.decode(a7, 10), "UTF-8");
                        } catch (Throwable th) {
                            Logger.d(th, new boolean[0]);
                            str = new String(Base64.decode(a7, 10));
                        }
                        a5 = str;
                    } else {
                        a5 = a7;
                    }
                }
                String format = String.format("https://multi.hydrax.net/%s?type=%s&value=%s", new Object[]{a3, a4, a5});
                StreamXResponse streamXResponse = (StreamXResponse) new Gson().l(HttpHelper.i().m(format, hashMap2), StreamXResponse.class);
                if (streamXResponse != null) {
                    String link = streamXResponse.getLink();
                    if (!link.isEmpty()) {
                        ResolveResult resolveResult2 = new ResolveResult(c(), link, mediaSource.getQuality());
                        resolveResult2.setPlayHeader(hashMap2);
                        observableEmitter2.onNext(BaseResolver.a(mediaSource2, resolveResult2));
                    }
                }
            }
        }
    }
}
