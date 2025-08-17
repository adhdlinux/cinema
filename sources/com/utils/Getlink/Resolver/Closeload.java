package com.utils.Getlink.Resolver;

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
import java.util.Map;

public class Closeload extends BaseResolver {
    public String c() {
        return "Closeload";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String m2 = HttpHelper.i().m(streamLink, new Map[0]);
        ArrayList arrayList = new ArrayList();
        arrayList.add(m2);
        if (JsUnpacker.m30920(m2)) {
            arrayList.addAll(JsUnpacker.m30916(m2));
        }
        ArrayList<String> g2 = Regex.g(arrayList.toString(), "=\"(aHR.*?)\";", 1, false);
        HashMap hashMap = new HashMap();
        hashMap.put("Referer", streamLink);
        Iterator<String> it2 = g2.iterator();
        while (it2.hasNext()) {
            String d2 = BaseProvider.d(it2.next());
            if (!d2.isEmpty()) {
                ResolveResult resolveResult = new ResolveResult(c(), d2, "HD");
                resolveResult.setPlayHeader(hashMap);
                observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult));
            }
        }
        Iterator<ResolveResult> it3 = k(streamLink, arrayList, true, hashMap, mediaSource.getQuality()).iterator();
        while (it3.hasNext()) {
            ResolveResult next = it3.next();
            if (next.getResolvedQuality() != null && next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                next.setResolvedQuality("HQ");
            }
            if (next.getResolvedQuality() == null || next.getResolvedQuality().isEmpty()) {
                next.setResolvedQuality(mediaSource.getQuality());
            }
            String a2 = Regex.a(next.getResolvedQuality(), "(\\d{3,4})p", 1);
            if (!a2.isEmpty()) {
                next.setResolvedQuality(a2);
            }
            observableEmitter.onNext(BaseResolver.a(mediaSource, next));
        }
    }
}
