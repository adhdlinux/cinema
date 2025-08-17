package com.utils.Getlink.Resolver;

import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ViduPlayer extends BaseResolver {
    public String c() {
        return "ViduPlayer";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String a2 = Regex.a(HttpHelper.i().m(streamLink, new Map[0]), "<script.*>(eval.*)", 1);
        ArrayList arrayList = new ArrayList();
        if (JsUnpacker.m30920(a2)) {
            arrayList.addAll(JsUnpacker.m30918(a2));
            Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
            while (it2.hasNext()) {
                ResolveResult next = it2.next();
                if (next.getResolvedQuality() == null || !next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                    next.setResolvedQuality("HD");
                } else {
                    next.setResolvedQuality("HQ");
                }
                observableEmitter.onNext(BaseResolver.a(mediaSource, next));
            }
        }
    }
}
