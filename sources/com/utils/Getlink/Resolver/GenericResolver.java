package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public abstract class GenericResolver extends BaseResolver {
    public String c() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String q2 = q();
        String p2 = p();
        if (!s()) {
            String a2 = Regex.a(streamLink, p2, 2);
            if (!a2.isEmpty()) {
                if (q2.isEmpty()) {
                    q2 = BaseProvider.j(streamLink);
                }
                streamLink = r(q2, a2);
            } else {
                return;
            }
        }
        String str = streamLink;
        ArrayList arrayList = new ArrayList();
        HashMap<String, String> hashMap = new HashMap<>();
        if (n()) {
            hashMap = mediaSource.getPlayHeader();
        }
        HashMap<String, String> hashMap2 = hashMap;
        String m2 = HttpHelper.i().m(str, hashMap2);
        arrayList.add(m2);
        if (JsUnpacker.m30920(m2)) {
            arrayList.addAll(JsUnpacker.m30916(m2));
        }
        if (o()) {
            hashMap2.put("User-Agent", Constants.C);
            hashMap2.put("Referer", str);
            String g2 = HttpHelper.i().g(str);
            if (!g2.isEmpty()) {
                hashMap2.put("Cookie", g2);
            }
        }
        Iterator<ResolveResult> it2 = k(str, arrayList, o(), hashMap2, mediaSource.getQuality()).iterator();
        while (it2.hasNext()) {
            ResolveResult next = it2.next();
            next.getResolvedLink();
            if (next.getResolvedQuality() != null && next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                next.setResolvedQuality("HQ");
            }
            if (next.getResolvedQuality() == null || next.getResolvedQuality().isEmpty()) {
                next.setResolvedQuality(mediaSource.getQuality());
            }
            String a3 = Regex.a(next.getResolvedQuality(), "(\\d{3,4})p", 1);
            if (!a3.isEmpty()) {
                next.setResolvedQuality(a3);
            }
            observableEmitter.onNext(BaseResolver.a(mediaSource, next));
        }
    }

    /* access modifiers changed from: protected */
    public boolean n() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean o();

    /* access modifiers changed from: protected */
    public abstract String p();

    /* access modifiers changed from: protected */
    public abstract String q();

    /* access modifiers changed from: protected */
    public String r(String str, String str2) {
        return str + "/embed-" + str2 + ".html";
    }

    /* access modifiers changed from: protected */
    public boolean s() {
        return false;
    }
}
