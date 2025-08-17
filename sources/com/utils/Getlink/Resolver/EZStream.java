package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.helper.js.JuicyDecoder;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EZStream extends BaseResolver {
    public String c() {
        return "EZStream";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String b2 = Regex.b(streamLink, "(?:\\/|\\.)(ninjastream|highstream|hdvid|wolfstream|playtube|anonfiles|evoload|streamvid)\\.(?:com|be|to|tv|fun|ws|io|co)\\/(?:v/|f/|watch/|player/|embed-|e/)([0-9a-zA-Z-]+)", 2, 2);
        if (streamLink.contains("evoload")) {
            Logger.a(streamLink);
        }
        if (!b2.isEmpty()) {
            String i2 = BaseProvider.i(streamLink);
            String j2 = BaseProvider.j(streamLink);
            String a2 = Regex.a(i2, "\\.(\\w+)\\.", 1);
            if (a2.isEmpty()) {
                a2 = Regex.a(i2, "(\\w+)\\.", 1);
            }
            String str = a2.substring(0, 1).toUpperCase() + a2.substring(1);
            String replace = HttpHelper.i().m(streamLink, new Map[0]).replace("\\/", "/");
            ArrayList arrayList = new ArrayList();
            Iterator it2 = Regex.f(replace, "(JuicyCodes\\.Run\\s*\\(.*?\\)\\s*;)", 1, true).get(0).iterator();
            while (it2.hasNext()) {
                String m30924 = JuicyDecoder.m30924((String) it2.next());
                if (!m30924.isEmpty() && JsUnpacker.m30920(m30924)) {
                    arrayList.addAll(JsUnpacker.m30916(m30924));
                }
            }
            arrayList.add(replace);
            if (JsUnpacker.m30920(replace)) {
                arrayList.addAll(JsUnpacker.m30916(replace));
            }
            if (j2.contains("evoload")) {
                HashMap hashMap = new HashMap();
                hashMap.put("accept", "*/*");
                hashMap.put("referer", streamLink);
                String m2 = HttpHelper.i().m(Regex.a(HttpHelper.i().m(j2 + "/e/", hashMap), "src=['\"]([^'\"]+.jsx)['\"]", 1), hashMap);
                String m3 = HttpHelper.i().m(Regex.a(m2, "axios.get\\(['\"]([^'\"]+)['\"]\\)\\.then\\(function\\(csrv_token\\)", 1), hashMap);
                if (!m3.isEmpty()) {
                    String a3 = Regex.a(m2, "captcha_pass\\s*=\\s*['\"]([^'\"]+)['\"]", 1);
                    hashMap.put("accept", "application/json, text/plain, */*");
                    hashMap.put("content-type", "application/json; charset=utf-8");
                    arrayList.add(HttpHelper.i().q(j2 + "/SecurePlayer", String.format("{\"code\":\"%s\",\"token\":\"ok\",\"csrv_token\":\"%s\",\"pass\":\"%s\",\"reff\":\"\"}", new Object[]{b2, m3, a3}), false, hashMap));
                } else {
                    return;
                }
            }
            Iterator<ResolveResult> it3 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("accept", "*/*");
            hashMap2.put("origin", "https://" + i2);
            hashMap2.put("referer", streamLink);
            hashMap2.put("user-agent", Constants.C);
            while (it3.hasNext()) {
                ResolveResult next = it3.next();
                if (next.getResolvedLink().contains("mp4") || next.getResolvedLink().contains("m3u8")) {
                    if (next.getResolvedQuality() != null && next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                        next.setResolvedQuality(mediaSource.getQuality());
                    }
                    next.setResolverName(str);
                    next.setPlayHeader(hashMap2);
                    observableEmitter.onNext(BaseResolver.a(mediaSource, next));
                } else {
                    MediaSource mediaSource2 = mediaSource;
                    ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
                }
            }
        }
    }
}
