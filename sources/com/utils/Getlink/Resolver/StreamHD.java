package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import com.uwetrottmann.trakt5.TraktV2;
import io.reactivex.ObservableEmitter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class StreamHD extends BaseResolver {
    public String c() {
        return "Fembed";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String b2 = Regex.b(streamLink, "(?:\\/|\\.)(streamlare|sltube|slmaxed)\\.(?:com|be|live|link|io|org|club)\\/(?:v|f|e)\\/([0-9a-zA-Z-]+)", 2, 2);
        if (!b2.isEmpty()) {
            String j2 = BaseProvider.j(streamLink);
            try {
                j2 = new URL(streamLink).getHost();
            } catch (Throwable th) {
                Logger.d(th, new boolean[0]);
            }
            String str = j2;
            String a2 = Regex.a(str, "\\.(\\w+)\\.", 1);
            if (a2.isEmpty()) {
                a2 = Regex.a(str, "(\\w+)\\.", 1);
            }
            String str2 = a2.substring(0, 1).toUpperCase() + a2.substring(1);
            HashMap<String, String> c2 = Constants.c();
            c2.put("content-type", TraktV2.CONTENT_TYPE_JSON);
            c2.put("origin", "https://" + str);
            c2.put("referer", streamLink);
            String replace = HttpHelper.i().q("https://" + str + "/api/video/stream/get", String.format("{\"id\":\"%s\"}", new Object[]{b2}), false, c2).replace("\\/", "/");
            ArrayList arrayList = new ArrayList();
            arrayList.add(replace);
            if (JsUnpacker.m30920(replace)) {
                arrayList.addAll(JsUnpacker.m30916(replace));
            }
            Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
            HashMap hashMap = new HashMap();
            hashMap.put("accept", "*/*");
            hashMap.put("origin", "https://" + str);
            hashMap.put("referer", streamLink);
            hashMap.put("user-agent", Constants.C);
            while (it2.hasNext()) {
                ResolveResult next = it2.next();
                if (next.getResolvedQuality() != null && next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                    next.setResolvedQuality(mediaSource.getQuality());
                }
                next.setResolverName(str2);
                next.setPlayHeader(hashMap);
                observableEmitter.onNext(BaseResolver.a(mediaSource, next));
            }
        }
    }
}
