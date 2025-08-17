package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.helper.js.JuicyDecoder;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import com.utils.Getlink.Resolver.premium.PremiumResolver;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Streamvid extends PremiumResolver {
    public String c() {
        return "Streamvid";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        if (!Regex.b(streamLink, "(?:\\/|\\.)(streamvid)\\.(?:com|be|to|tv|fun|co|io|net)\\/(?:v/|f/|watch/|player/|e/|embed-)([0-9a-zA-Z-]+)", 2, 2).isEmpty()) {
            super.l(mediaSource, observableEmitter);
            if (!Utils.f37611d) {
                ArrayList arrayList = new ArrayList();
                String m2 = HttpHelper.i().m(streamLink, new Map[0]);
                Iterator it2 = Regex.f(m2, "(JuicyCodes\\.Run\\s*\\(.*?\\)\\s*;)", 1, true).get(0).iterator();
                while (it2.hasNext()) {
                    String m30924 = JuicyDecoder.m30924((String) it2.next());
                    if (!m30924.isEmpty() && JsUnpacker.m30920(m30924)) {
                        arrayList.addAll(JsUnpacker.m30916(m30924));
                    }
                }
                arrayList.add(m2);
                if (JsUnpacker.m30920(m2)) {
                    arrayList.addAll(JsUnpacker.m30916(m2));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("accept", "*/*");
                hashMap.put("origin", BaseProvider.j(streamLink));
                hashMap.put("referer", BaseProvider.j(streamLink) + "/");
                hashMap.put("user-agent", Constants.C);
                hashMap.put("Accept-Encoding", "identity;q=1, *;q=0");
                hashMap.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US,en;q=0.9,zh-HK;q=0.8,zh-TW;q=0.7,zh;q=0.6");
                Iterator<ResolveResult> it3 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
                while (it3.hasNext()) {
                    ResolveResult next = it3.next();
                    if (next.getResolvedLink().contains("mp4") || next.getResolvedLink().contains("m3u8")) {
                        if (next.getResolvedQuality() != null && next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                            next.setResolvedQuality(mediaSource.getQuality());
                        }
                        next.setPlayHeader(hashMap);
                        observableEmitter.onNext(BaseResolver.a(mediaSource, next));
                    }
                }
            }
        }
    }
}
