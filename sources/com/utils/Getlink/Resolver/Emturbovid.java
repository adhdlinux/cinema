package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;

public class Emturbovid extends BaseResolver {
    public String c() {
        return "Emturbovid";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        if (!Regex.a(streamLink, "(?:\\/|\\.)(emturbovid)\\.(?:cam|com|be|co|to|so|watch|re|pm|wf|re|yt)(?:/embed-|/e/|/d/|/t/)([0-9a-zA-Z-]+)", 2).isEmpty()) {
            String a2 = Regex.a(HttpHelper.i().m(streamLink, mediaSource.getPlayHeader()), "urlPlay\\s*=\\s*[\"']([^\"']+)[\"']", 1);
            if (!a2.isEmpty()) {
                ResolveResult resolveResult = new ResolveResult(c(), a2, mediaSource.getQuality());
                HashMap hashMap = new HashMap();
                hashMap.put("Origin", BaseProvider.j(streamLink));
                hashMap.put("Referer", BaseProvider.j(streamLink) + "/");
                hashMap.put("User-Agent", Constants.C);
                resolveResult.setPlayHeader(hashMap);
                observableEmitter.onNext(BaseResolver.a(mediaSource, resolveResult));
            }
        }
    }
}
