package com.utils.Getlink.Resolver;

import com.facebook.common.util.UriUtil;
import com.google.gson.JsonParser;
import com.original.tase.Logger;
import com.original.tase.helper.DateTimeHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import io.reactivex.ObservableEmitter;

public class AmazonDrive extends BaseResolver {
    public String c() {
        return "AmazonDrive";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        String streamLink = mediaSource.getStreamLink();
        String a2 = Regex.a(streamLink, "(?://|\\.)(amazon\\.com)/clouddrive/share/([0-9a-zA-Z]+)", 2);
        if (!a2.isEmpty()) {
            String o2 = HttpHelper.i().o("https://www.amazon.com/drive/v1/shares/" + a2 + "?shareId=" + a2 + "&resourceVersion=V2&ContentType=JSON&_=" + DateTimeHelper.g() + "29", streamLink);
            if (!o2.isEmpty()) {
                try {
                    String o3 = HttpHelper.i().o("https://www.amazon.com/drive/v1/nodes/" + new JsonParser().a(o2).c().m("nodeInfo").c().m("id").e() + "/children?asset=ALL&tempLink=true&limit=1&searchOnFamily=false&shareId=" + a2 + "&offset=0&resourceVersion=V2&ContentType=JSON&_=" + DateTimeHelper.g() + "30", streamLink);
                    if (!o3.isEmpty()) {
                        try {
                            String e2 = new JsonParser().a(o3).c().m("data").b().l(0).c().m("tempLink").e();
                            if (e2.startsWith("//")) {
                                e2 = "http:" + e2;
                            } else if (e2.startsWith("/")) {
                                e2 = "https://www.amazon.com" + e2;
                            } else if (!e2.startsWith(UriUtil.HTTP_SCHEME)) {
                                e2 = "https://www.amazon.com/" + e2;
                            }
                            observableEmitter.onNext(BaseResolver.a(mediaSource, new ResolveResult(c(), e2, "HD")));
                        } catch (Exception e3) {
                            Logger.d(e3, new boolean[0]);
                        }
                    }
                } catch (Exception e4) {
                    Logger.d(e4, new boolean[0]);
                }
            }
        }
    }
}
