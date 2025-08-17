package com.utils.Getlink.Resolver;

import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okhttp3.MultipartBody;

public class Hollymoviehd extends BaseResolver {
    public String c() {
        return "Hollymoviehd";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String a2 = Regex.a(streamLink, "(?:v|embed)[=/]([0-9a-zA-Z-]+)", 1);
        if (!a2.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            String m2 = HttpHelper.i().m(streamLink, new Map[0]);
            String a3 = Regex.a(m2, "recaptcha\\/api\\.js\\?render=([0-9a-zA-Z-]+)", 1);
            if (!a3.isEmpty()) {
                String y2 = Utils.y(streamLink, a3, BaseProvider.j(streamLink));
                if (!y2.isEmpty()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Origin", BaseProvider.j(streamLink));
                    hashMap.put("Referer", streamLink);
                    hashMap.put(TheTvdb.HEADER_ACCEPT, "*/*");
                    hashMap.put("Cookie", a2 + "=7; SL_G_WPT_TO=en; SL_GWPT_Show_Hide_tmp=1; SL_wptGlobTipTmp=1");
                    MultipartBody build = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("token", y2).build();
                    m2 = HttpHelper.i().y(streamLink, build, hashMap);
                }
            }
            arrayList.add(m2);
            if (JsUnpacker.m30920(m2)) {
                arrayList.addAll(JsUnpacker.m30916(m2));
            }
            Iterator<ResolveResult> it2 = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator();
            while (it2.hasNext()) {
                ResolveResult next = it2.next();
                if (next.getResolvedQuality() == null || !next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                    next.setResolvedQuality(mediaSource.getQuality());
                } else {
                    next.setResolvedQuality("HQ");
                }
                observableEmitter.onNext(BaseResolver.a(mediaSource, next));
            }
        }
    }
}
