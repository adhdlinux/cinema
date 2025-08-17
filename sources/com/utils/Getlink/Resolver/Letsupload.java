package com.utils.Getlink.Resolver;

import android.util.Base64;
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

public class Letsupload extends BaseResolver {
    public String c() {
        try {
            return new String(Base64.decode("SHlkcmFY", 10), "UTF-8");
        } catch (Exception unused) {
            return new String(Base64.decode("SHlkcmFY", 10));
        }
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        mediaSource.getStreamLink();
        String streamLink = mediaSource.getStreamLink();
        String b2 = Regex.b(streamLink, "(?:\\/|\\.)([0-9a-zA-Z-]+)\\.(?:com|be|live|to|co)\\/([0-9a-zA-Z-]+)", 2, 2);
        if (!b2.isEmpty()) {
            String str = BaseProvider.j(streamLink) + "/plugins/mediaplayer/site/_embed.php?u=" + b2 + "&w=640&h=320";
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
