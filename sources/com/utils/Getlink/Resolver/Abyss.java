package com.utils.Getlink.Resolver;

import com.google.gson.Gson;
import com.movie.data.model.hidrax.VideoQuality;
import com.original.tase.helper.DateTimeHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.original.tase.utils.Utils;
import com.utils.Getlink.Provider.BaseProvider;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Abyss extends BaseResolver {
    public String c() {
        return Deobfuscator$app$ProductionRelease.a(-183253083041988L);
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        MediaSource mediaSource2 = mediaSource;
        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
        String streamLink = mediaSource.getStreamLink();
        HashMap hashMap = new HashMap();
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-183261672976580L), Deobfuscator$app$ProductionRelease.a(-183231608205508L));
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-182372614746308L), Deobfuscator$app$ProductionRelease.a(-182308190236868L));
        if (mediaSource.getPlayHeader() != null) {
            hashMap.putAll(mediaSource.getPlayHeader());
        } else {
            hashMap.put(Deobfuscator$app$ProductionRelease.a(-182278125465796L), Deobfuscator$app$ProductionRelease.a(-182518643634372L));
        }
        ArrayList arrayList = new ArrayList();
        String m2 = HttpHelper.i().m(streamLink, hashMap);
        String a2 = Regex.a(m2, Deobfuscator$app$ProductionRelease.a(-182389794615492L), 1);
        String a3 = Utils.a(Regex.a(m2, Deobfuscator$app$ProductionRelease.a(-182020427428036L), 1));
        if (!a3.isEmpty()) {
            String a4 = Regex.a(a3, Deobfuscator$app$ProductionRelease.a(-182205111021764L), 1);
            String a5 = Regex.a(a3, Deobfuscator$app$ProductionRelease.a(-180633152991428L), 1);
            if (!a2.isEmpty() && !a4.isEmpty() && !a5.isEmpty()) {
                String str = Deobfuscator$app$ProductionRelease.a(-180796361748676L) + DateTimeHelper.g();
                HashMap hashMap2 = new HashMap();
                hashMap2.put(Deobfuscator$app$ProductionRelease.a(-180366865019076L), streamLink.replace(BaseProvider.i(streamLink), Deobfuscator$app$ProductionRelease.a(-180332505280708L)));
                VideoQuality videoQuality = (VideoQuality) new Gson().l(a2, VideoQuality.class);
                if (!videoQuality.getFullHd().isEmpty()) {
                    ResolveResult resolveResult = new ResolveResult(c(), String.format(Deobfuscator$app$ProductionRelease.a(-180585908351172L), new Object[]{a4, a5, str}), Deobfuscator$app$ProductionRelease.a(-180469944234180L));
                    resolveResult.setPlayHeader(hashMap2);
                    observableEmitter2.onNext(BaseResolver.a(mediaSource2, resolveResult));
                }
                if (!videoQuality.getHd().isEmpty()) {
                    ResolveResult resolveResult2 = new ResolveResult(c(), String.format(Deobfuscator$app$ProductionRelease.a(-180482829136068L), new Object[]{a4, a5, str}), Deobfuscator$app$ProductionRelease.a(-181191498739908L));
                    resolveResult2.setPlayHeader(hashMap2);
                    observableEmitter2.onNext(BaseResolver.a(mediaSource2, resolveResult2));
                }
                if (!videoQuality.getSd().isEmpty()) {
                    ResolveResult resolveResult3 = new ResolveResult(c(), String.format(Deobfuscator$app$ProductionRelease.a(-181208678609092L), new Object[]{a4, a5, str}), Deobfuscator$app$ProductionRelease.a(-181414837039300L));
                    resolveResult3.setPlayHeader(hashMap2);
                    observableEmitter2.onNext(BaseResolver.a(mediaSource2, resolveResult3));
                }
            }
        }
        arrayList.add(m2);
        if (JsUnpacker.m30920(m2)) {
            arrayList.addAll(JsUnpacker.m30916(m2));
        }
        Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
        while (it2.hasNext()) {
            ResolveResult next = it2.next();
            if (next.getResolvedQuality() != null && next.getResolvedQuality().trim().toLowerCase().equals(Deobfuscator$app$ProductionRelease.a(-181363297431748L))) {
                next.setResolvedQuality(mediaSource.getQuality());
            }
            observableEmitter2.onNext(BaseResolver.a(mediaSource2, next));
        }
    }
}
