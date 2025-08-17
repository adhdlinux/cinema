package com.utils.Getlink.Resolver;

import com.original.tase.helper.DateTimeHelper;
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

public class Vidcloudpng extends BaseResolver {
    public String c() {
        return "CDN-FastServer";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String j2 = BaseProvider.j(streamLink);
        HttpHelper.i().m(streamLink, new Map[0]);
        HashMap hashMap = new HashMap();
        new ArrayList();
        if (streamLink.contains("vidcloudpng.")) {
            String a2 = Regex.a(streamLink, "\\?id=([a-zA-Z0-9]+)", 1);
            String m2 = HttpHelper.i().m(String.format(j2 + "/playlist/%s/%s", new Object[]{a2, DateTimeHelper.g()}), hashMap);
            Iterator it2 = Regex.f(m2, "(\\/hls\\/[0-9a-zA-Z]+\\/[0-9a-zA-Z]+\\.m3u8)", 1, true).get(0).iterator();
            Iterator it3 = Regex.f(m2, "RESOLUTION=\\w+x(\\w+)", 1, true).get(0).iterator();
            Regex.a(streamLink, "(http.*\\.[\\w\\d+]+)\\/", 1);
            while (it2.hasNext()) {
                String str = (String) it2.next();
                String str2 = (String) it3.next();
                if (Integer.parseInt(str2) > 1080) {
                    str2 = "1080";
                }
                if (str.startsWith("/")) {
                    str = j2 + str;
                }
                mediaSource.setPlayHeader(hashMap);
                observableEmitter.onNext(BaseResolver.a(mediaSource, new ResolveResult(c(), str, str2)));
            }
        }
    }
}
