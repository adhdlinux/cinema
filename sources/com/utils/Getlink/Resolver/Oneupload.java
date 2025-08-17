package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Oneupload extends BaseResolver {
    public String c() {
        return "Oneupload";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", Constants.C);
        hashMap.put("Referer", streamLink);
        ArrayList arrayList = new ArrayList();
        String m2 = HttpHelper.i().m(streamLink, hashMap);
        arrayList.add(m2);
        if (JsUnpacker.m30920(m2)) {
            arrayList.addAll(JsUnpacker.m30918(m2));
        }
        Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
        while (it2.hasNext()) {
            ResolveResult next = it2.next();
            if (next.getResolvedQuality() == null || !next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                next.setResolvedQuality("HD");
            } else {
                next.setResolvedQuality(mediaSource.getQuality());
            }
            next.setPlayHeader(hashMap);
            observableEmitter.onNext(BaseResolver.a(mediaSource, next));
        }
    }
}
