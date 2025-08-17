package com.utils.Getlink.Resolver;

import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class Them4uFree extends BaseResolver {
    public String c() {
        return "Them4uFree";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        if (streamLink.contains("them4ufree")) {
            String a2 = Regex.a(streamLink, "\\?v=(.*)", 1);
            HashMap<String, String> c2 = Constants.c();
            c2.put("User-Agent", Constants.C);
            c2.put("Origin", "http://them4ufree.com");
            c2.put("Referer", streamLink);
            c2.put(TheTvdb.HEADER_ACCEPT, "application/json, text/javascript, */*; q=0.01");
            HttpHelper i2 = HttpHelper.i();
            try {
                String str = new JSONObject(i2.q("http://them4ufree.com/api-tt/playlist.php", "v=" + a2, true, c2)).getString("playlist").toString();
                if (str != null) {
                    mediaSource.setStreamLink(str);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            observableEmitter.onNext(mediaSource);
        }
    }
}
