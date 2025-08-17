package com.utils.Getlink.Resolver;

import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JJDecoder;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MstreamTo extends BaseResolver {
    public String c() {
        return "MstreamTo";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        if (!Utils.f37611d) {
            ArrayList arrayList = new ArrayList();
            String m2 = HttpHelper.i().m(streamLink, new Map[0]);
            if (JsUnpacker.m30920(m2)) {
                arrayList.addAll(JsUnpacker.m30916(m2));
            }
            String decode = new JJDecoder().decode(Regex.a(m2, "\\$=.*\\(\\)\\)\\(\\)\\;", 0).replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "").replace("\r", ""));
            arrayList.add(decode);
            Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
            if (!it2.hasNext()) {
                String a2 = Regex.a(decode, "['\"]src['\"]\\s*[,|:]\\s*['\"]([^'\"]+[^'\"])['\"]", 1);
                if (!a2.isEmpty()) {
                    observableEmitter.onNext(BaseResolver.a(mediaSource, new ResolveResult(c(), a2, mediaSource.getQuality())));
                }
            }
            while (it2.hasNext()) {
                ResolveResult next = it2.next();
                if (next.getResolvedQuality() != null && next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                    next.setResolvedQuality(mediaSource.getQuality());
                }
                observableEmitter.onNext(BaseResolver.a(mediaSource, next));
            }
        }
    }
}
