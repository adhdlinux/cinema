package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.AADecoder;
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

public class Userload extends BaseResolver {
    public String c() {
        return "Userload";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String a2 = Regex.a(streamLink, "(?:\\/|\\.)(userload)\\.(?:cam|com|be|co|to|cc)(?:/embed/|/f/)([0-9a-zA-Z-]+)", 2);
        if (!a2.isEmpty()) {
            String j2 = BaseProvider.j(streamLink);
            String str = j2 + "/embed/" + a2;
            String m2 = HttpHelper.i().m(j2 + "/api/assets/userload/js/videojs.js", new Map[0]);
            if (AADecoder.m30915(m2)) {
                m2 = AADecoder.m30914(m2);
            }
            int i2 = 1;
            String replace = Regex.a(m2, "t.send\\(['\"](\\w+)=['\"]([^'\"]+)['\"]&(\\w+)=['\"]([^'\"]+)\\)\\}", 1).replace("+", "");
            String replace2 = Regex.a(m2, "t.send\\(['\"](\\w+)=['\"]([^'\"]+)['\"]&(\\w+)=['\"]([^'\"]+)\\)\\}", 2).replace("+", "");
            String replace3 = Regex.a(m2, "t.send\\(['\"](\\w+)=['\"]([^'\"]+)['\"]&(\\w+)=['\"]([^'\"]+)\\)\\}", 3).replace("+", "");
            int i3 = 4;
            String replace4 = Regex.a(m2, "t.send\\(['\"](\\w+)=['\"]([^'\"]+)['\"]&(\\w+)=['\"]([^'\"]+)\\)\\}", 4).replace("+", "");
            if (!replace.isEmpty() && !replace2.isEmpty() && !replace3.isEmpty() && !replace4.isEmpty()) {
                String m3 = HttpHelper.i().m(str, new Map[0]);
                ArrayList arrayList = new ArrayList();
                arrayList.add(m3);
                if (JsUnpacker.m30920(m3)) {
                    arrayList.addAll(JsUnpacker.m30918(m3));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("User-Agent", Constants.C);
                hashMap.put("Referer", BaseProvider.j(str) + "/");
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str2 = (String) it2.next();
                    Object[] objArr = new Object[i2];
                    objArr[0] = replace2.replace("+", "");
                    String a3 = Regex.a(str2, String.format("var\\s*%s\\s*=\\s*[\"']([^'\"]+)['\"]", objArr), i2);
                    Object[] objArr2 = new Object[i2];
                    objArr2[0] = replace4.replace("+", "");
                    String a4 = Regex.a(str2, String.format("var\\s*%s\\s*=\\s*[\"']([^'\"]+)['\"]", objArr2), i2);
                    if (a3.isEmpty()) {
                        MediaSource mediaSource2 = mediaSource;
                        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
                    } else if (!a4.isEmpty()) {
                        Object[] objArr3 = new Object[i3];
                        objArr3[0] = replace;
                        objArr3[1] = a3;
                        objArr3[2] = replace3;
                        objArr3[3] = a4;
                        String l2 = HttpHelper.i().l(j2 + "/api/request/", String.format("%s=%s&%s=%s", objArr3), hashMap);
                        if (!l2.isEmpty()) {
                            ResolveResult resolveResult = new ResolveResult(c(), l2.trim(), mediaSource.getQuality());
                            resolveResult.setPlayHeader(hashMap);
                            observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult));
                        } else {
                            MediaSource mediaSource3 = mediaSource;
                            ObservableEmitter<? super MediaSource> observableEmitter3 = observableEmitter;
                        }
                        i2 = 1;
                        i3 = 4;
                    }
                }
            }
        }
    }
}
