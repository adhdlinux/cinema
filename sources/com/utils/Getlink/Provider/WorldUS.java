package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.HunterPacker;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;

public class WorldUS extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37496e = Utils.getProvider(67);

    /* renamed from: f  reason: collision with root package name */
    private HashMap f37497f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private String f37498g = "HD";

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7");
        hashMap.put("upgrade-insecure-requests", "1");
        hashMap.put("cookie", "SL_G_WPT_TO=en; SL_GWPT_Show_Hide_tmp=1; SL_wptGlobTipTmp=1");
        String decodesource = HunterPacker.INSTANCE.decodesource(HttpHelper.i().m(str, hashMap));
        if (decodesource != null && !decodesource.isEmpty()) {
            String a2 = Regex.a(decodesource, "['\"]?file['\"]?\\s*:\\s*['\"]([^'\"]+)['\"]", 1);
            if (!a2.isEmpty()) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("Referer", str);
                hashMap2.put("Origin", BaseProvider.i(str));
                MediaSource mediaSource = new MediaSource(A(), "CDN-FastServer", false);
                mediaSource.setStreamLink(a2);
                mediaSource.setQuality("HD");
                mediaSource.setPlayHeader(hashMap2);
                observableEmitter.onNext(mediaSource);
            }
        }
    }

    public String A() {
        return "WorldUS";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo, String.format("%s/directstream.php?video_id=%s", new Object[]{this.f37496e, movieInfo.imdbIDStr}));
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo, String.format("%s/directstream.php?video_id=%s&s=%s&e=%s", new Object[]{this.f37496e, movieInfo.imdbIDStr, movieInfo.session, movieInfo.eps}));
    }
}
