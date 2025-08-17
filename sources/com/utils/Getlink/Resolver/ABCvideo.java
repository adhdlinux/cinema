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
import java.util.Map;

public class ABCvideo extends BaseResolver {
    public String c() {
        return "ABCvideo";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        MediaSource mediaSource2 = mediaSource;
        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
        String streamLink = mediaSource.getStreamLink();
        String b2 = Regex.b(streamLink, "(?:\\/|\\.)(abcvideo)\\.(?:com|be|co|to|cc)(?:/embed-|/)([0-9a-zA-Z]+)", 2, 2);
        if (!b2.isEmpty()) {
            String j2 = BaseProvider.j(streamLink);
            try {
                j2 = new URL(streamLink).getHost();
            } catch (Throwable th) {
                Logger.d(th, new boolean[0]);
            }
            String str = "https://" + j2 + "/" + b2;
            HashMap hashMap = new HashMap();
            hashMap.put("referer", str);
            hashMap.put("User-Agent", Constants.C);
            String m2 = HttpHelper.i().m(str, new Map[0]);
            String a2 = Regex.a(m2, "\\(['\"]([0-9a-zA-Z-]+)['\"]\\,['\"]([0-9a-zA-Z-]+)['\"]\\,['\"]([0-9a-zA-Z-]+)['\"]\\)", 1);
            String a3 = Regex.a(m2, "\\(['\"]([0-9a-zA-Z-]+)['\"]\\,['\"]([0-9a-zA-Z-]+)['\"]\\,['\"]([0-9a-zA-Z-]+)['\"]\\)", 2);
            String a4 = Regex.a(m2, "\\(['\"]([0-9a-zA-Z-]+)['\"]\\,['\"]([0-9a-zA-Z-]+)['\"]\\,['\"]([0-9a-zA-Z-]+)['\"]\\)", 3);
            ArrayList arrayList = new ArrayList();
            arrayList.add(m2);
            if (JsUnpacker.m30920(m2)) {
                arrayList.addAll(JsUnpacker.m30916(m2));
            }
            String m3 = HttpHelper.i().m("https://" + j2 + "/dl?op=download_orig" + String.format("&id=%s&mode=%s&hash=%s", new Object[]{a2, a3, a4}), hashMap);
            Iterator it2 = Regex.f(m3, "href=['\"]([^'\"]+(mkv|mp4|avi))['\"]", 1, true).get(0).iterator();
            while (it2.hasNext()) {
                ResolveResult resolveResult = new ResolveResult(c(), (String) it2.next(), mediaSource.getQuality());
                resolveResult.setPlayHeader(hashMap);
                observableEmitter2.onNext(BaseResolver.a(mediaSource2, resolveResult));
            }
            if (JsUnpacker.m30920(m3)) {
                arrayList.addAll(JsUnpacker.m30916(m3));
            }
            Iterator<ResolveResult> it3 = k(str, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
            while (it3.hasNext()) {
                ResolveResult next = it3.next();
                if (next.getResolvedQuality() == null || !next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                    next.setResolvedQuality("HD");
                } else {
                    next.setResolvedQuality(mediaSource.getQuality());
                }
                next.setPlayHeader(hashMap);
                observableEmitter2.onNext(BaseResolver.a(mediaSource2, next));
            }
        }
    }
}
