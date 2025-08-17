package com.utils.Getlink.Provider;

import com.facebook.common.util.UriUtil;
import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.TitleHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.js.JsUnpacker;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.HashMap;

public class Afdah extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f37238e = Utils.getProvider(65).split(",");

    public String A() {
        return "Afdah";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String str;
        String str2;
        MovieInfo movieInfo2 = movieInfo;
        ObservableEmitter<? super MediaSource> observableEmitter2 = observableEmitter;
        String lowerCase = (TitleHelper.h(movieInfo2.name, "_") + "_" + movieInfo2.year).toLowerCase();
        new ArrayList();
        new ArrayList();
        String[] strArr = f37238e;
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            String str3 = strArr[i3];
            if (!observableEmitter.isDisposed()) {
                String str4 = str3 + "/watch_" + com.original.tase.utils.Utils.k(lowerCase, new boolean[i2]) + ".html";
                if (str3.contains("watch32hd") || str3.contains("putlocker") || str3.contains("afdah.org") || str3.contains("xmovies08")) {
                    str4 = str3 + "/watch?v=" + com.original.tase.utils.Utils.k(lowerCase, new boolean[i2]).replace("_", "-");
                }
                HashMap hashMap = new HashMap();
                hashMap.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
                hashMap.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US;q=0.6,en;q=0.4");
                hashMap.put("upgrade-insecure-requests", "1");
                hashMap.put("Referer", str3 + "/");
                String o2 = HttpHelper.i().o(str4, str3);
                if (o2 != null && !o2.isEmpty()) {
                    String b2 = Regex.b(o2, "var\\s+frame_url\\s*=\\s*['\"]\\s*(.*?vidlink\\.org.*?)\\s*['\"]", 1, 34);
                    if (!b2.isEmpty()) {
                        str = Regex.a(o2, "embed\\/([0-9a-zA-Z-]+)", 1);
                    } else {
                        str = "";
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("user-agent", Constants.C);
                    if (b2.isEmpty()) {
                        continue;
                    } else {
                        if (b2.startsWith("//")) {
                            b2 = "https:" + b2;
                        } else if (b2.startsWith(":")) {
                            b2 = UriUtil.HTTP_SCHEME + b2;
                        } else if (b2.startsWith("/")) {
                            b2 = "https://vidlink.org" + b2;
                        }
                        HashMap<String, String> c2 = Constants.c();
                        c2.put("Origin", "https://vidlink.org");
                        c2.put("Referer", b2);
                        String m2 = HttpHelper.i().m("https://vidlink.org/embed/info?postID=" + str, c2);
                        if (JsUnpacker.m30920(m2)) {
                            str2 = Regex.a(JsUnpacker.m30918(m2).toString(), "embed_urls['\"]\\s*:\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1);
                        } else {
                            str2 = Regex.a(m2, "embed_urls['\"]\\s*:\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1);
                        }
                        if (!str2.isEmpty()) {
                            String replace = str2.replace("\\/", "/");
                            if (replace.startsWith("//")) {
                                replace = "https:" + replace;
                            }
                            String str5 = "FastServer";
                            if (GoogleVideoHelper.n(replace)) {
                                boolean n2 = GoogleVideoHelper.n(replace);
                                if (n2) {
                                    str5 = "GoogleVideo";
                                }
                                MediaSource mediaSource = new MediaSource("Afdah", str5, false);
                                mediaSource.setOriginalLink(replace);
                                mediaSource.setStreamLink(replace);
                                if (n2) {
                                    HashMap hashMap3 = new HashMap();
                                    hashMap3.put("User-Agent", Constants.C);
                                    mediaSource.setPlayHeader(hashMap3);
                                }
                                mediaSource.setQuality("HD");
                                observableEmitter2.onNext(mediaSource);
                            } else {
                                MediaSource mediaSource2 = new MediaSource(A(), str5, false);
                                mediaSource2.setStreamLink(replace);
                                mediaSource2.setPlayHeader(hashMap2);
                                mediaSource2.setQuality("1080p");
                                observableEmitter2.onNext(mediaSource2);
                                return;
                            }
                        }
                        i2 = 0;
                    }
                }
                i3++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
    }
}
