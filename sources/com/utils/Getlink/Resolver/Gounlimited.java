package com.utils.Getlink.Resolver;

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

public class Gounlimited extends PremiumResolver {
    public String c() {
        return "Gounlimited";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String a2 = Regex.a(mediaSource.getStreamLink(), "(?://|\\.)(gounlimited\\.to)(?:/embed-|/)([0-9a-zA-Z]+)", 2);
        if (!a2.isEmpty()) {
            super.l(mediaSource, observableEmitter);
            if (!Utils.f37611d) {
                String str = "https://gounlimited.to/embed-" + a2 + ".html";
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
}
