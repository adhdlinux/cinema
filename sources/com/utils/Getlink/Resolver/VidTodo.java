package com.utils.Getlink.Resolver;

import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VidTodo extends BaseResolver {
    public String c() {
        return "VidTodo";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String a2 = Regex.a(streamLink, "(?://|\\.)((?:vidtodo|vidtod|vidstodo|vidtudu|playvidto|vidtoup|vixtodo)\\.(?:com|me|pro))/(?:embed-)?([0-9a-zA-Z]+)", 2);
        if (!a2.isEmpty()) {
            String str = BaseProvider.j(streamLink) + "/" + a2;
            ArrayList arrayList = new ArrayList();
            String m2 = HttpHelper.i().m(str, new Map[0]);
            arrayList.add(m2);
            if (JsUnpacker.m30920(m2)) {
                arrayList.addAll(JsUnpacker.m30916(m2));
            }
            Iterator<ResolveResult> it2 = k(str, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
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
