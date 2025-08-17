package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import io.reactivex.ObservableEmitter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Movcloud extends BaseResolver {
    public String c() {
        return "Movcloud";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String b2 = Regex.b(streamLink, "(?:\\/|\\.)(movcloud)\\.(?:com|net|live|link|io)\\/(?:v|embed)\\/([0-9a-zA-Z-]+)", 2, 2);
        if (!b2.isEmpty()) {
            BaseProvider.j(streamLink);
            try {
                new URL(streamLink).getHost();
            } catch (Throwable th) {
                Logger.d(th, new boolean[0]);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("referer", streamLink);
            hashMap.put("User-Agent", Constants.C);
            String replace = HttpHelper.i().m("https://api.movcloud.net/stream/" + b2, hashMap).replace("\\/", "/");
            ArrayList arrayList = new ArrayList();
            arrayList.add(replace);
            if (JsUnpacker.m30920(replace)) {
                arrayList.addAll(JsUnpacker.m30916(replace));
            }
            Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
            while (it2.hasNext()) {
                ResolveResult next = it2.next();
                if (next.getResolvedQuality() != null && next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                    next.setResolvedQuality(mediaSource.getQuality());
                }
                next.setPlayHeader(hashMap);
                observableEmitter.onNext(BaseResolver.a(mediaSource, next));
            }
        }
    }
}
