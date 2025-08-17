package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;

public class Xstreamcdn extends BaseResolver {
    public String c() {
        return "Xstreamcdn";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String a2 = Regex.a(mediaSource.getStreamLink(), "(?://|\\.)(xstreamcdn\\.com)/(?:v)?/?([0-9A-Za-z]+)", 2);
        if (!a2.isEmpty()) {
            HashMap<String, String> c2 = Constants.c();
            c2.put("referer", mediaSource.getStreamLink());
            HttpHelper i2 = HttpHelper.i();
            ArrayList<ArrayList<String>> f2 = Regex.f(i2.l("https://xstreamcdn.com/api/source/" + a2, "r=&d=xstreamcdn.com", c2).replace("\\/", "/"), "['\"]?file['\"]?\\s*:\\s*['\"]([^'\"]+)['\"]\\s*,\\s*['\"]?label['\"]?\\s*:\\s*['\"]?(\\d{3,4})p", 2, true);
            ArrayList arrayList = f2.get(0);
            ArrayList arrayList2 = f2.get(1);
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", Constants.C);
            hashMap.put("referer", mediaSource.getStreamLink());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                try {
                    String str = (String) arrayList.get(i3);
                    String str2 = (String) arrayList2.get(i3);
                    if (!str.isEmpty()) {
                        ResolveResult resolveResult = new ResolveResult(c(), str, str2);
                        resolveResult.setPlayHeader(hashMap);
                        observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult));
                    }
                } catch (Throwable th) {
                    Logger.d(th, new boolean[0]);
                }
            }
        }
    }
}
