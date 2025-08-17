package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.squareup.duktape.Duktape;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P2PCDN extends BaseResolver {
    public String c() {
        return "CDN-FastServer";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String a2 = Regex.a(HttpHelper.i().m(streamLink, new Map[0]).replace("\\/", "/"), "\\s*var\\s*hd=(\\[\\{.*\\}\\])\\r?\\n", 1);
        if (!a2.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("accept", "*/*");
            hashMap.put("user-agent", Constants.C);
            String replace = "var hd=####;function btoa(t){var r,n,e,a,h,u,c=\"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=\",o=0,i=0,s=\"\",d=[];if(!t)return t;for(;r=63&(h=t.charCodeAt(o++)<<16|t.charCodeAt(o++)<<8|t.charCodeAt(o++))>>18,n=63&h>>12,e=63&h>>6,a=63&h,d[i++]=c.charAt(r)+c.charAt(n)+c.charAt(e)+c.charAt(a),o<t.length;);return s=d.join(\"\"),((u=t.length%3)?s.slice(0,u-3):s)+\"===\".slice(u||3)}function et(t){try{return t.split(\"\").reverse().join(\"\")}catch(t){return\"\"}}function setup(t){return\"https://hls.hdv.fun/m3u8/\"+t+\".m3u8?u=\"+btoa(et(btoa(et(Math.random().toString(36).substring(10)+Date.now()))))}function acb(){var t=[];for(var r in hd){var n={src:setup(hd[r].name),type:hd[r].quality,res:hd[r].res.toString()};t.push(n)}return JSON.stringify(t)}acb();".replace("####", a2);
            Duktape create = Duktape.create();
            try {
                Object evaluate = create.evaluate(replace);
                ArrayList arrayList = new ArrayList();
                if (evaluate != null) {
                    arrayList.add(evaluate.toString());
                    ResolveResult next = k(streamLink, arrayList, false, (HashMap<String, String>) null, mediaSource.getQuality()).iterator().next();
                    if (next.getResolvedQuality() != null && next.getResolvedQuality().trim().toLowerCase().equals("sd")) {
                        next.setResolvedQuality(mediaSource.getQuality());
                    }
                    next.setPlayHeader(hashMap);
                    observableEmitter.onNext(BaseResolver.a(mediaSource, next));
                }
            } catch (Throwable unused) {
            }
            create.close();
        }
    }
}
