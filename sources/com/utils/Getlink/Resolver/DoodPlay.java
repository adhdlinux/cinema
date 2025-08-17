package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.squareup.duktape.Duktape;
import com.utils.Getlink.Provider.BaseProvider;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Map;

public class DoodPlay extends BaseResolver {
    public String c() {
        return "DoodPlay";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String a2 = Regex.a(streamLink, "(?:\\/|\\.)(dood|doodstream|doods|d0000d|d\\d+d.)\\.(?:cam|com|be|co|to|so|watch|re|pm|wf|re|yt|la|pro|li|\\w+)(?:/embed-|/e/|/d/)([0-9a-zA-Z-]+)", 2);
        if (!a2.isEmpty()) {
            String j2 = BaseProvider.j(streamLink);
            String str = j2 + "/e/" + a2;
            String m2 = HttpHelper.i().m(str, new Map[0]);
            String a3 = Regex.a(m2, "get\\([\"']([^'\"]+)[\"'],\\s*f", 1);
            String a4 = Regex.a(m2, "token=([0-9a-zA-Z]+)", 1);
            if (!a3.isEmpty()) {
                if (a3.startsWith("/")) {
                    a3 = j2 + a3;
                }
                HashMap<String, String> c2 = Constants.c();
                c2.put("Referer", str);
                String m3 = HttpHelper.i().m(a3, c2);
                String format = String.format("function makePlay(){for(var e=\"\",n=\"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789\",r=n.length,a=0;a<10;a++)e+=n.charAt(Math.floor(Math.random()*r));return e+\"%s\"+Date.now()}makePlay();", new Object[]{a4});
                Duktape create = Duktape.create();
                try {
                    Object evaluate = create.evaluate(format);
                    if (evaluate != null && !evaluate.toString().isEmpty()) {
                        String str2 = m3 + evaluate + "?token=" + a4;
                        HashMap hashMap = new HashMap();
                        hashMap.put("User-Agent", Constants.C);
                        hashMap.put(TheTvdb.HEADER_ACCEPT, "*/*");
                        hashMap.put("Accept-Encoding", "identity;q=1, *;q=0");
                        hashMap.put("Referer", BaseProvider.j(str) + "/");
                        hashMap.put("host", BaseProvider.i(str2));
                        ResolveResult resolveResult = new ResolveResult(c(), str2, mediaSource.getQuality());
                        resolveResult.setPlayHeader(hashMap);
                        observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult));
                    }
                } catch (Throwable unused) {
                }
                create.close();
            }
        }
    }
}
