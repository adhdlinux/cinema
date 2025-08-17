package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Map;

public class JetLoad extends BaseResolver {
    public String c() {
        return "JetLoad";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String m2 = HttpHelper.i().m(streamLink, new Map[0]);
        HashMap hashMap = new HashMap();
        hashMap.put("Origin", "https://jetload.net");
        hashMap.put("Referer", streamLink);
        hashMap.put("User-Agent", Constants.C);
        String a2 = Regex.a(m2, "x_source\\s*=\\s*['\"]([^'\"]+[^'\"])['\"]", 1);
        if (!a2.isEmpty()) {
            ResolveResult resolveResult = new ResolveResult(c(), a2, mediaSource.getQuality());
            resolveResult.setPlayHeader(hashMap);
            observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult));
        }
        String a3 = Regex.a(m2, "<input[^>]*file_low.*value\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>", 1);
        String a4 = Regex.a(m2, "<input[^>]*file_med.*value\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>", 1);
        String a5 = Regex.a(m2, "<input[^>]*file_name.*value\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>", 1);
        String a6 = Regex.a(m2, "<input[^>]*srv.*value\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>", 1);
        String a7 = Regex.a(m2, "<input[^>]*archive.*value\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>", 1);
        if (!a6.isEmpty()) {
            if (!a7.isEmpty()) {
                a5 = "archive/" + a5;
            }
            if (a3.equals("1") && a4.equals("1")) {
                ResolveResult resolveResult2 = new ResolveResult(c(), a6 + "/v2/schema/" + a5 + "/master.m3u8", mediaSource.getQuality());
                resolveResult2.setPlayHeader(hashMap);
                observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult2));
            }
            if (a3.equals("1")) {
                ResolveResult resolveResult3 = new ResolveResult(c(), a6 + "/v2/schema/" + a5 + "/med.m3u8", mediaSource.getQuality());
                resolveResult3.setPlayHeader(hashMap);
                observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult3));
                return;
            }
            ResolveResult resolveResult4 = new ResolveResult(c(), a6 + "/v2/schema/" + a5 + "/low.m3u8", mediaSource.getQuality());
            resolveResult4.setPlayHeader(hashMap);
            observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult4));
        }
    }
}
