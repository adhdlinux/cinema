package com.utils.Getlink.Resolver;

import com.facebook.common.util.UriUtil;
import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Mp4Upload extends BaseResolver {
    public String c() {
        return "Mp4Upload";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String b2 = Regex.b(streamLink, "(?://|\\.)(mp4upload\\.(?:com))/(?:embed-)?([0-9a-zA-Z]+)", 2, 2);
        if (!b2.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", Constants.C);
            hashMap.put("Referer", streamLink);
            hashMap.put("Cookie", HttpHelper.i().g(streamLink));
            HttpHelper i2 = HttpHelper.i();
            Iterator<String> it2 = JsUnpacker.m30918(i2.m("https://www.mp4upload.com/embed-" + b2 + ".html", new Map[0])).iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                Iterator it3 = Regex.e(next, "['\"]?file['\"]?\\s*:\\s*['\"]?([^'\"]+)", 1, 2).get(0).iterator();
                if (!it3.hasNext()) {
                    it3 = Regex.e(next, "player.src\\(['\"]([^'\"]+[^'\"]*)['\"]\\)", 1, 2).get(0).iterator();
                }
                while (it3.hasNext()) {
                    String str = (String) it3.next();
                    if (!str.isEmpty() && !str.endsWith(".srt") && !str.endsWith(".vtt") && !str.endsWith(".png") && !str.endsWith(".jpg") && str.contains(UriUtil.HTTP_SCHEME)) {
                        ResolveResult resolveResult = new ResolveResult(c(), str, mediaSource.getQuality());
                        resolveResult.setPlayHeader(hashMap);
                        observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult));
                    }
                }
            }
        }
    }
}
