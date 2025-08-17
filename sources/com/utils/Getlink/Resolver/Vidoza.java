package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Resolver.premium.PremiumResolver;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Vidoza extends PremiumResolver {
    public String c() {
        return "Vidoza";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        HashMap hashMap;
        String streamLink = mediaSource.getStreamLink();
        String s2 = s();
        String r2 = r();
        String a2 = Regex.a(streamLink, r2, 2);
        if (!a2.isEmpty()) {
            if (s2.isEmpty()) {
                s2 = "http://" + Regex.a(streamLink, r2, 1);
            }
            super.l(mediaSource, observableEmitter);
            if (!Utils.f37611d) {
                String t2 = t(s2, a2);
                ArrayList arrayList = new ArrayList();
                String m2 = HttpHelper.i().m(t2, new Map[0]);
                arrayList.add(m2);
                if (JsUnpacker.m30920(m2)) {
                    arrayList.addAll(JsUnpacker.m30916(m2));
                }
                if (q()) {
                    hashMap = new HashMap();
                    hashMap.put("User-Agent", Constants.C);
                    hashMap.put("Referer", t2);
                    hashMap.put("Cookie", HttpHelper.i().g(t2));
                } else {
                    hashMap = null;
                }
                Iterator<ResolveResult> it2 = k(t2, arrayList, q(), hashMap, mediaSource.getQuality()).iterator();
                while (it2.hasNext()) {
                    ResolveResult next = it2.next();
                    if (next.getResolvedQuality() != null && next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                        next.setResolvedQuality("HQ");
                    }
                    observableEmitter.onNext(BaseResolver.a(mediaSource, next));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean q() {
        return false;
    }

    /* access modifiers changed from: protected */
    public String r() {
        return "(?://|\\.)(vidoza|videzz)\\.(?:net|co)/(?:embed-)?([0-9a-zA-Z]+)";
    }

    /* access modifiers changed from: protected */
    public String s() {
        return "http://vidoza.net";
    }

    /* access modifiers changed from: protected */
    public String t(String str, String str2) {
        return str + "/embed-" + str2 + ".html";
    }
}
