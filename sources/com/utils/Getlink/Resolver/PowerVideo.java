package com.utils.Getlink.Resolver;

import com.original.tase.Logger;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.Iterator;

public class PowerVideo extends BaseResolver {
    public String c() {
        return "PowerVideo";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String a2 = Regex.a(mediaSource.getStreamLink(), "(?://|\\.)((?:powvideo\\.net|povw1deo\\.com))/(?:embed-|iframe-|preview-)?([0-9a-zA-Z]+)", 2);
        if (!a2.isEmpty()) {
            String str = "http://powvideo.net/iframe-" + a2 + "-954x562.html";
            String o2 = HttpHelper.i().o(str, str.replace("iframe-", "preview-"));
            if (!o2.contains("Video is processing now") && !o2.contains("File was deleted")) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(o2);
                if (JsUnpacker.m30920(o2)) {
                    arrayList.addAll(JsUnpacker.m30916(o2));
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Iterator it3 = Regex.f((String) it2.next(), "src\\s*:\\s*[\"'](http[^\"']+\\.(?:mp4|m3u8))[\"']", 1, true).get(0).iterator();
                    while (it3.hasNext()) {
                        String str2 = (String) it3.next();
                        try {
                            String b2 = Regex.b(str2, "([0-9a-z]{40,})", 1, 2);
                            String sb = new StringBuilder(b2).reverse().toString();
                            observableEmitter.onNext(BaseResolver.a(mediaSource, new ResolveResult(c(), str2.replace(b2, sb.substring(0, 2) + sb.substring(3, sb.length())), "HQ")));
                        } catch (Throwable th) {
                            Logger.d(th, new boolean[0]);
                        }
                    }
                }
            }
        }
    }
}
