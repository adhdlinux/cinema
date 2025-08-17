package com.utils.Getlink.Resolver;

import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Map;

public class VeryStream extends BaseResolver {
    public String c() {
        return "CDN-Stream";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String m2 = HttpHelper.i().m(streamLink, new Map[0]);
        HashMap hashMap = new HashMap();
        hashMap.put("Referer", streamLink);
        String a2 = Regex.a(m2, "<p.*?id=\"videolink\">(.*)<\\/p>", 1);
        if (!a2.isEmpty()) {
            ResolveResult resolveResult = new ResolveResult(c(), "https://verystream.com/gettoken/" + a2 + "?mime=true", mediaSource.getQuality());
            resolveResult.setPlayHeader(hashMap);
            observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult));
        }
    }
}
