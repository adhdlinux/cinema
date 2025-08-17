package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.kotlin.AesHelper;
import io.reactivex.ObservableEmitter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MoflixStream extends BaseResolver {

    /* renamed from: e  reason: collision with root package name */
    static String f37524e = "";

    public String c() {
        return "Moflix-Stream";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        ArrayList arrayList = new ArrayList();
        String m2 = HttpHelper.i().m(streamLink, new Map[0]);
        if (!m2.contains("Not Found") && !m2.contains("File was deleted") && !m2.contains("is no longer available")) {
            if (!Regex.a(m2, "Encrypted\\s*=\\s*'([^']+)", 1).isEmpty()) {
                if (f37524e.isEmpty()) {
                    HttpHelper i2 = HttpHelper.i();
                    f37524e = i2.m(Constants.E + "resolver/mvapi.js", new Map[0]);
                }
                String c2 = AesHelper.f37691a.c(Regex.a(m2, "['\"]s['\"]\\s*[:=]\\s*['\"]([^'\"]+)['\"]", 1), Regex.a(m2, "['\"]ct['\"]\\s*[:=]\\s*['\"]([^'\"]+)['\"]", 1), f37524e.getBytes(StandardCharsets.UTF_8), false, "AES/CBC/PKCS5PADDING");
                if (c2 != null && !c2.isEmpty()) {
                    arrayList.add(c2.replace("\\", ""));
                }
            }
            arrayList.add(m2);
            if (JsUnpacker.m30920(m2)) {
                arrayList.addAll(JsUnpacker.m30916(m2));
            }
            Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
            while (it2.hasNext()) {
                ResolveResult next = it2.next();
                if (next.getResolvedQuality() == null || !next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                    next.setResolvedQuality(mediaSource.getQuality());
                } else {
                    next.setResolvedQuality("HQ");
                }
                observableEmitter.onNext(BaseResolver.a(mediaSource, next));
            }
        }
    }
}
