package com.utils.Getlink.Resolver;

import com.facebook.common.util.UriUtil;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Ronemo extends BaseResolver {
    public String c() {
        return "Ronemo";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        if (streamLink.contains("vidlink")) {
            String b2 = Regex.b(streamLink, "(?:\\/|\\.)(vidlink)\\.(?:com|be|live|link|org)\\/(?:v|f|embed)\\/([0-9a-zA-Z-]+)", 2, 2);
            HashMap<String, String> c2 = Constants.c();
            c2.put("Origin", "https://vidlink.org");
            c2.put("Referer", streamLink);
            String replace = HttpHelper.i().m("https://vidlink.org/embed/info?postID=" + b2, c2).replace("\\/", "/");
            if (JsUnpacker.m30920(replace)) {
                streamLink = Regex.a(JsUnpacker.m30918(replace).toString(), "embed_urls['\"]\\s*:\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1);
            } else {
                streamLink = Regex.a(replace, "embed_urls['\"]\\s*:\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1);
            }
        }
        String b3 = Regex.b(streamLink, "(?:\\/|\\.)(ronemo)\\.(?:com|be|live|link|io)\\/(?:v|f|embed)\\/([0-9a-zA-Z-]+)", 2, 2);
        if (!b3.isEmpty()) {
            String j2 = BaseProvider.j(streamLink);
            try {
                j2 = new URL(streamLink).getHost();
            } catch (Throwable th) {
                Logger.d(th, new boolean[0]);
            }
            String replace2 = HttpHelper.i().m("https://" + j2 + "/api/video/get-source-link?videoUid=" + b3, new Map[0]).replace("\\/", "/");
            String a2 = Regex.a(replace2, "link['\"]\\s*:\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1);
            HashMap hashMap = new HashMap();
            hashMap.put(TheTvdb.HEADER_ACCEPT, "*/*");
            hashMap.put("User-Agent", Constants.C);
            hashMap.put("Referer", BaseProvider.j(streamLink) + "/");
            hashMap.put("Origin", BaseProvider.j(streamLink));
            if (!a2.isEmpty()) {
                if (!a2.startsWith(UriUtil.HTTP_SCHEME)) {
                    a2 = "https://hls.ronemo.com/" + a2;
                }
                hashMap.put("Host", BaseProvider.i(a2));
                Logger.a(a2);
                String a3 = Regex.a(replace2, "(\\d{3,4}p)", 1);
                if (a3.isEmpty()) {
                    a3 = "HD";
                }
                ResolveResult resolveResult = new ResolveResult(c(), a2, a3);
                resolveResult.setPlayHeader(hashMap);
                observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult));
            }
        }
    }
}
