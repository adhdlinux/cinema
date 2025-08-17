package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;

public class ClubPlay extends BaseResolver {
    public String c() {
        return "ClubPlay";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String replace = mediaSource.getStreamLink().replace("\\/", "/");
        if (replace.endsWith("\\")) {
            replace = replace.substring(0, replace.length() - 1);
        }
        HashMap<String, String> c2 = Constants.c();
        if (mediaSource.getPlayHeader() == null) {
            c2.put("User-Agent", Constants.C);
        } else {
            c2.putAll(mediaSource.getPlayHeader());
        }
        c2.put("referer", replace);
        String replace2 = replace.replace("view", "list");
        String a2 = Regex.a(HttpHelper.i().m(replace2, c2), "link['\"]:['\"]([^'\"]+)['\"]", 1);
        if (!a2.isEmpty()) {
            ResolveResult resolveResult = new ResolveResult(c(), a2, mediaSource.getQuality());
            resolveResult.setPlayHeader(c2);
            observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult));
        }
    }
}
