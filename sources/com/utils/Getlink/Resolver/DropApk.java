package com.utils.Getlink.Resolver;

import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import com.utils.Getlink.Resolver.premium.PremiumResolver;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DropApk extends PremiumResolver {
    public String c() {
        return "DropApk";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        mediaSource.getStreamLink();
        String streamLink = mediaSource.getStreamLink();
        String b2 = Regex.b(streamLink, "(?:\\/|\\.)([0-9a-zA-Z-]+)\\.(?:com|be|live|to|io)\\/([0-9a-zA-Z-]+)", 2, 2);
        if (!b2.isEmpty()) {
            super.l(mediaSource, observableEmitter);
            String str = BaseProvider.j(streamLink) + "/embed-" + b2 + ".html";
            ArrayList arrayList = new ArrayList();
            String m2 = HttpHelper.i().m(str, new Map[0]);
            arrayList.add(m2);
            if (JsUnpacker.m30920(m2)) {
                arrayList.addAll(JsUnpacker.m30916(m2));
            }
            Iterator<ResolveResult> it2 = k(str, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
            while (it2.hasNext()) {
                ResolveResult next = it2.next();
                if (next.getResolvedQuality() != null && next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                    next.setResolvedQuality(mediaSource.getQuality());
                }
                observableEmitter.onNext(BaseResolver.a(mediaSource, next));
            }
        }
    }
}
