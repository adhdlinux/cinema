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

public class ZPlayer extends PremiumResolver {
    public String c() {
        return "ZPlayer";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        ArrayList arrayList = new ArrayList();
        String m2 = HttpHelper.i().m(streamLink, new Map[0]);
        if (!m2.contains("Not Found") && !m2.contains("File was deleted") && !m2.contains("is no longer available")) {
            arrayList.add(m2);
            if (JsUnpacker.m30920(m2)) {
                arrayList.addAll(JsUnpacker.m30916(m2));
            }
            Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
            while (it2.hasNext()) {
                ResolveResult next = it2.next();
                if (next.getResolvedLink().contains(".mp4") || next.getResolvedLink().contains("m3u8") || next.getResolvedLink().endsWith(".dll")) {
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
}
