package com.utils.Getlink.Resolver;

import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.utils.Getlink.Resolver.premium.PremiumResolver;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Gomo extends PremiumResolver {
    public String c() {
        return "Gomo";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        mediaSource.getStreamLink();
        super.l(mediaSource, observableEmitter);
        ArrayList arrayList = new ArrayList();
        String m2 = HttpHelper.i().m(streamLink, new Map[0]);
        arrayList.add(m2);
        if (JsUnpacker.m30920(m2)) {
            arrayList.addAll(JsUnpacker.m30916(m2));
        }
        Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
        while (it2.hasNext()) {
            ResolveResult next = it2.next();
            next.setResolvedQuality(mediaSource.getQuality());
            observableEmitter.onNext(BaseResolver.a(mediaSource, next));
        }
    }
}
