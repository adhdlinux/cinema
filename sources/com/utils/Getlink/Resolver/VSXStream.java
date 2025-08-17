package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;

public class VSXStream extends BaseResolver {
    public String c() {
        return "VSXStream";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        if (!Regex.b(streamLink, "(?:\\/|\\.)(voe)\\.(?:com|be|live|to|io|sx)(?:/v|/f|/e|)\\/([0-9a-zA-Z-]+)", 2, 2).isEmpty()) {
            HashMap<String, String> c2 = Constants.c();
            c2.put("referer", streamLink);
            String replace = HttpHelper.i().m(streamLink, c2).replace("\\/", "/");
            String a2 = Regex.a(replace, "location\\.href\\s*=\\s*['\"]([^'\"]+)['\"]", 1);
            if (!a2.isEmpty()) {
                replace = HttpHelper.i().o(a2, streamLink);
            }
            String a3 = Regex.a(replace, "['\"]hls['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1);
            String a4 = Regex.a(replace, "['\"]video_height['\"]\\s*:\\s*(\\d+)", 1);
            if (a4.isEmpty()) {
                a4 = mediaSource.getQuality();
            }
            if (!a3.isEmpty()) {
                if (a3.startsWith("aHR0")) {
                    a3 = BaseProvider.d(a3);
                }
                ResolveResult resolveResult = new ResolveResult(c(), a3, a4);
                resolveResult.setPlayHeader(c2);
                observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult));
            }
            String a5 = Regex.a(replace, "['\"]mp4['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1);
            if (a5.isEmpty()) {
                String a6 = Regex.a(replace, "let\\s*(?:wc0|[0-9a-f]+)\\s*=\\s*'([^']+)", 1);
                if (!a6.isEmpty()) {
                    a5 = Regex.a(new StringBuilder(BaseProvider.d(a6)).reverse().toString(), "['\"]file['\"]\\s*:\\s*['\"]([^'\"]+)['\"]", 1).replace("\\/", "/");
                }
            }
            if (!a5.isEmpty()) {
                ResolveResult resolveResult2 = new ResolveResult(c(), a5, a4);
                resolveResult2.setPlayHeader(c2);
                observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult2));
            }
        }
    }
}
