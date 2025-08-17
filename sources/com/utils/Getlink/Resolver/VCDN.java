package com.utils.Getlink.Resolver;

import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.Map;

public class VCDN extends BaseResolver {
    public String c() {
        return "VCDN";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String b2 = Regex.b(mediaSource.getStreamLink(), "(?://|\\.)(vcdn\\.(?:com|io))/(?:v)/([0-9a-zA-Z]+)", 2, 2);
        if (!b2.isEmpty()) {
            ArrayList<ArrayList<String>> f2 = Regex.f(HttpHelper.i().q("https://vcdn.io/api/source/" + b2, "r=", false, new Map[0]).replace("\\/", "/"), "['\"]?file['\"]?\\s*:\\s*['\"]([^'\"]+)['\"]\\s*,\\s*['\"]?label['\"]?\\s*:\\s*['\"]?(\\d{3,4})p", 2, true);
            ArrayList arrayList = f2.get(0);
            ArrayList arrayList2 = f2.get(1);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    String str = (String) arrayList.get(i2);
                    if (str.startsWith("/")) {
                        str = "https://vcdn.io" + str;
                    }
                    observableEmitter.onNext(BaseResolver.a(mediaSource, new ResolveResult(c(), str, (String) arrayList2.get(i2))));
                } catch (Throwable unused) {
                }
            }
        }
    }
}
