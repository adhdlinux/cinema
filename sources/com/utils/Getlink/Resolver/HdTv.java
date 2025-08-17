package com.utils.Getlink.Resolver;

import com.original.tase.Logger;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class HdTv extends BaseResolver {

    /* renamed from: e  reason: collision with root package name */
    String[] f37523e = {"azm.to", "netu.tv", "hqq.tv", "waaw.tv", "waaw1.tv", "yandexcdn.com", "netu.io", "netu.to", "hqq.to", "waaw.to", "goo.gl", "hqq.to"};

    public static int n(int i2, int i3) {
        return new Random().nextInt((i3 - i2) + 1) + i2;
    }

    public String c() {
        return "HD-TV";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        if (!Regex.b(streamLink, "(?:\\/|\\.)(waaw|netu|hqq)\\.(?:com|be|co|to|cc|tech|me|site)\\/(?:v|e|f)\\/([0-9a-zA-Z]+)", 2, 2).isEmpty()) {
            String[] strArr = this.f37523e;
            String str = strArr[n(0, strArr.length - 1)];
            BaseProvider.j(streamLink);
            HashMap<String, String> playHeader = mediaSource.getPlayHeader();
            Logger.a(mediaSource.toString2());
            String m2 = HttpHelper.i().m(streamLink, new Map[0]);
            Regex.a(m2, "videokey':\\s*'([^']+)", 1);
            Regex.a(m2, "videokey':\\s*'([^']+)", 1);
            ArrayList arrayList = new ArrayList();
            arrayList.add(m2);
            Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
            while (it2.hasNext()) {
                ResolveResult next = it2.next();
                if (next.getResolvedLink().contains("mp4") || next.getResolvedLink().contains("m3u8")) {
                    if (next.getResolvedQuality() != null && next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                        next.setResolvedQuality(mediaSource.getQuality());
                    }
                    next.setPlayHeader(playHeader);
                    observableEmitter.onNext(BaseResolver.a(mediaSource, next));
                }
            }
        }
    }
}
