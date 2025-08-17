package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.squareup.duktape.Duktape;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Yourbox extends BaseResolver {
    public String c() {
        return "Yourbox";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String b2 = Regex.b(streamLink, "(?:\\/|\\.)(youdbox)\\.(?:com|net|live|link|io|org|club|site|\\w+)\\/(?:embed-|)([0-9a-zA-Z-]+)", 2, 2);
        if (!b2.isEmpty()) {
            String m2 = HttpHelper.i().m(String.format("https://youdbox.net/embed-%s.html", new Object[]{b2}), new Map[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(m2);
            if (JsUnpacker.m30920(m2)) {
                arrayList.addAll(JsUnpacker.m30916(m2));
            }
            String a2 = Regex.a(m2, "\\((\\w+)\\.reverse\\(\\)\\.join", 1);
            if (!a2.isEmpty()) {
                String replace = "function acb(){var a=####;return a.reverse().join(\"\")}acb();".replace("####", Regex.a(m2, "var\\s*" + a2 + "\\s*=\\s*(.+['\"]\\])[\\s\\S];var", 1));
                Duktape create = Duktape.create();
                try {
                    Object evaluate = create.evaluate(replace);
                    if (evaluate == null) {
                        create.close();
                        return;
                    } else {
                        arrayList.add(evaluate.toString());
                        create.close();
                    }
                } catch (Throwable unused) {
                }
            }
            Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
            HashMap hashMap = new HashMap();
            hashMap.put("referer", streamLink);
            hashMap.put("user-agent", Constants.C);
            while (it2.hasNext()) {
                ResolveResult next = it2.next();
                if (next.getResolvedLink().contains("mp4") || next.getResolvedLink().contains("m3u8")) {
                    if (next.getResolvedQuality() != null && next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                        next.setResolvedQuality(mediaSource.getQuality());
                    }
                    next.setPlayHeader(hashMap);
                    observableEmitter.onNext(BaseResolver.a(mediaSource, next));
                }
            }
        }
    }
}
