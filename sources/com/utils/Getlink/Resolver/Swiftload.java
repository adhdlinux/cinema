package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Swiftload extends BaseResolver {
    private static int n(int i2, String str) {
        for (int i3 : p(str)) {
            i2 ^= i3;
        }
        return i2;
    }

    public static String o(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < str2.length()) {
            int i3 = i2 + 2;
            sb.append((char) n(Integer.parseInt(str2.substring(i2, i3), 16), str));
            i2 = i3;
        }
        return sb.toString();
    }

    private static int[] p(String str) {
        int[] iArr = new int[str.length()];
        for (int i2 = 0; i2 < str.length(); i2++) {
            iArr[i2] = str.charAt(i2);
        }
        return iArr;
    }

    public String c() {
        return "Swiftload";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", Constants.C);
        hashMap.put("Referer", streamLink);
        ArrayList arrayList = new ArrayList();
        String m2 = HttpHelper.i().m(streamLink, hashMap);
        String o2 = o(Regex.a(m2, "decrypt\\(['\"]([^'\"]+)['\"]", 1), Regex.a(m2, "<input[^>]+id=\"swhash\"\\s*value=['\"]([^'\"]+)['\"][^>]*>", 1));
        if (!o2.isEmpty()) {
            observableEmitter.onNext(BaseResolver.a(mediaSource, new ResolveResult(c(), o2, "HD")));
        }
        arrayList.add(m2);
        if (JsUnpacker.m30920(m2)) {
            arrayList.addAll(JsUnpacker.m30918(m2));
        }
        Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
        while (it2.hasNext()) {
            ResolveResult next = it2.next();
            if (next.getResolvedQuality() == null || !next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                next.setResolvedQuality("HD");
            } else {
                next.setResolvedQuality(mediaSource.getQuality());
            }
            next.setPlayHeader(hashMap);
            observableEmitter.onNext(BaseResolver.a(mediaSource, next));
        }
    }
}
