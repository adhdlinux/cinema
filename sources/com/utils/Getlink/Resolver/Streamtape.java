package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Streamtape extends BaseResolver {
    public String c() {
        return "Streamtape";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String b2 = Regex.b(mediaSource.getStreamLink(), "(?:\\/|\\.)(streamtape|strtape|adblockeronstreamtape|streamta)\\.(?:com|be|co|to|cc|tech|me|site)\\/(?:v|e)\\/([0-9a-zA-Z]+)", 2, 2);
        if (!b2.isEmpty()) {
            String str = "https://streamta.site/e/" + b2;
            HashMap hashMap = new HashMap();
            hashMap.put("referer", mediaSource.getOriginalLink());
            hashMap.put("User-Agent", Constants.C);
            String m2 = HttpHelper.i().m(str, hashMap);
            ArrayList arrayList = new ArrayList();
            arrayList.add(m2);
            if (JsUnpacker.m30920(m2)) {
                arrayList.addAll(JsUnpacker.m30916(m2));
            }
            String a2 = Regex.a(m2, "robotlink'\\)\\.innerHTML = '(.+?)'\\+ \\('(.+?)'\\)", 1);
            String substring = Regex.a(m2, "robotlink'\\)\\.innerHTML = '(.+?)'\\+ \\('(.+?)'\\)", 2).substring(3);
            if (!a2.isEmpty() && !substring.isEmpty()) {
                String str2 = a2 + substring;
                if (str2.startsWith("/")) {
                    str2 = "/" + str2;
                }
                if (str2.startsWith("//")) {
                    str2 = "https:" + str2 + "&stream=1";
                }
                ResolveResult resolveResult = new ResolveResult(c(), str2, mediaSource.getQuality());
                resolveResult.setPlayHeader(hashMap);
                observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult));
            }
            Iterator<ResolveResult> it2 = k(str, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
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
}
