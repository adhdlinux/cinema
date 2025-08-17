package com.original.tase.utils;

import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import okhttp3.Response;

public class SourceObservableUtils {
    public static boolean a(Response response, MediaSource mediaSource) {
        try {
            if (response.request() != null) {
                String httpUrl = response.request().url().toString();
                if (!httpUrl.toLowerCase().contains(".m3u8")) {
                    return false;
                }
                mediaSource.setStreamLink(httpUrl);
                return true;
            }
        } catch (Throwable th) {
            Logger.d(th, false);
        }
        return false;
    }

    public static MediaSource b(MediaSource mediaSource) {
        try {
            if (mediaSource.getPlayHeader() == null) {
                mediaSource.setPlayHeader(new HashMap());
            }
            if (!mediaSource.getPlayHeader().containsKey("User-Agent")) {
                mediaSource.getPlayHeader().put("User-Agent", Constants.C);
            }
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
        }
        return mediaSource;
    }

    public static boolean c(String str) {
        String lowerCase = str.trim().toLowerCase();
        if (GoogleVideoHelper.e(str) || lowerCase.contains("amazonaws") || lowerCase.contains("amazon.") || lowerCase.contains("yandex") || lowerCase.contains("vulture.") || lowerCase.contains("mediafire.") || lowerCase.contains("/docs/securesc/") || lowerCase.contains("googleapis") || lowerCase.contains("hulu.so") || lowerCase.contains("cloudfront") || lowerCase.contains("cdn.") || lowerCase.contains("dfcdn.") || lowerCase.contains("ntcdn.") || lowerCase.contains("micetop.") || lowerCase.contains("/proxy") || lowerCase.contains("proxy/") || lowerCase.contains("5.189.155.231") || lowerCase.contains("streamcherry.xyz") || lowerCase.contains("up2stream") || lowerCase.contains("real-debrid") || lowerCase.contains("juicyapi") || lowerCase.contains("fruity") || lowerCase.contains("streamy.") || lowerCase.contains("moviestime") || lowerCase.contains("m4ufree") || lowerCase.contains("gomovieshd.to") || lowerCase.contains("/videoplayback?data=") || lowerCase.contains("html5player") || lowerCase.contains("anyplayer.") || lowerCase.contains("gdplayer") || ((lowerCase.contains("mehliz") && !lowerCase.contains("search") && !lowerCase.contains("/?s=")) || lowerCase.contains("gphoto.stream") || lowerCase.contains("vidcloud") || lowerCase.contains("dropboxusercontent.") || lowerCase.contains("archive.org"))) {
            return false;
        }
        return true;
    }

    public static Observable<MediaSource> d(final MediaSource mediaSource) {
        return Observable.create(new ObservableOnSubscribe<MediaSource>() {
            public void subscribe(ObservableEmitter<MediaSource> observableEmitter) {
                try {
                    if (!MediaSource.this.isTorrent()) {
                        if (MediaSource.this.getFileSize() > 0) {
                            if (!MediaSource.this.isAlldebrid() && !MediaSource.this.isRealdebrid()) {
                                if (MediaSource.this.isPremiumize()) {
                                }
                            }
                        }
                        String streamLink = MediaSource.this.getStreamLink();
                        boolean c2 = SourceObservableUtils.c(streamLink);
                        HashMap hashMap = new HashMap();
                        if (MediaSource.this.getPlayHeader() != null) {
                            hashMap.putAll(MediaSource.this.getPlayHeader());
                        }
                        HashMap<String, String> b2 = SourceUtils.b(hashMap);
                        if (MediaSource.this.isHLS()) {
                            b2.put("Range", "bytes=0-");
                            c2 = false;
                        } else {
                            b2.put("Range", "bytes=0-1");
                        }
                        Response w2 = HttpHelper.i().w(streamLink, c2, b2);
                        if (w2 != null && w2.code() < 400) {
                            if (!MediaSource.this.isHLS()) {
                                if (!SourceObservableUtils.a(w2, MediaSource.this)) {
                                    long h2 = HttpHelper.h(w2, true, new boolean[0]);
                                    if (h2 > 20971520) {
                                        MediaSource.this.setFileSize(h2);
                                        MediaSource.this.setResolved(true);
                                        observableEmitter.onNext(MediaSource.this);
                                    }
                                    w2.body().close();
                                }
                            }
                            String string = w2.body().string();
                            if (!string.isEmpty()) {
                                ArrayList<String> g2 = Regex.g(string, "RESOLUTION=\\d{3,4}x(\\d{3,4})", 1, true);
                                if (!g2.isEmpty()) {
                                    Collections.sort(g2, new Comparator<String>() {
                                        /* renamed from: a */
                                        public int compare(String str, String str2) {
                                            return Integer.parseInt(str2) - Integer.parseInt(str);
                                        }
                                    });
                                    String str = g2.get(0);
                                    if (!str.isEmpty()) {
                                        MediaSource.this.setQuality(str);
                                    }
                                }
                                if (string.contains("EXTM3U") || string.contains("#EXT") || string.contains("BANDWIDTH")) {
                                    MediaSource.this.setHLS(true);
                                    MediaSource.this.setResolved(true);
                                    observableEmitter.onNext(MediaSource.this);
                                }
                            }
                            w2.body().close();
                        }
                        observableEmitter.onComplete();
                        return;
                    }
                    observableEmitter.onNext(MediaSource.this);
                    observableEmitter.onComplete();
                } catch (Throwable th) {
                    Logger.d(th, new boolean[0]);
                }
            }
        }).subscribeOn(Schedulers.c());
    }
}
