package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NonResolver extends BaseResolver {

    /* renamed from: f  reason: collision with root package name */
    static String f37525f = "";

    /* renamed from: e  reason: collision with root package name */
    String f37526e = "(GoogleVideo|CDN)";

    public String c() {
        return "UnKown";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (mediaSource.getHostName() != null && mediaSource.getProviderName() != null && mediaSource.getStreamLink() != null) {
            if (f37525f.isEmpty()) {
                HttpHelper i2 = HttpHelper.i();
                f37525f = i2.m(Constants.E + "resolver/nonhost.js", new Map[0]);
            }
            String streamLink = mediaSource.getStreamLink();
            if (mediaSource.isHLS() || mediaSource.isDownload() || GoogleVideoHelper.n(mediaSource.getStreamLink())) {
                ResolveResult resolveResult = new ResolveResult(mediaSource.getHostName(), streamLink, mediaSource.getQuality());
                if (mediaSource.getPlayHeader() != null && mediaSource.getPlayHeader().size() > 0) {
                    resolveResult.setPlayHeader(mediaSource.getPlayHeader());
                }
                observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult));
            } else if (f37525f.isEmpty() || Regex.a(mediaSource.getStreamLink(), f37525f, 1).isEmpty()) {
                Logger.b("NEEDIMPLEMENT", mediaSource.toStringAllObjs());
            } else {
                Logger.b("NEEDIMPLEMENT UnKown", mediaSource.toStringAllObjs());
                ArrayList arrayList = new ArrayList();
                String m2 = HttpHelper.i().m(streamLink, mediaSource.getPlayHeader());
                arrayList.add(m2);
                if (JsUnpacker.m30920(m2)) {
                    arrayList.addAll(JsUnpacker.m30916(m2));
                }
                Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
                while (it2.hasNext()) {
                    ResolveResult next = it2.next();
                    if (next.getResolvedQuality() != null && next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                        next.setResolvedQuality(mediaSource.getQuality());
                    }
                    if (mediaSource.getPlayHeader() != null && mediaSource.getPlayHeader().size() > 0) {
                        next.setPlayHeader(mediaSource.getPlayHeader());
                    }
                    observableEmitter.onNext(BaseResolver.a(mediaSource, next));
                }
            }
        }
    }
}
