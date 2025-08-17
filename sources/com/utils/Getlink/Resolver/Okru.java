package com.utils.Getlink.Resolver;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.ResolveResult;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.original.tase.utils.Utils;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Okru extends BaseResolver {
    private HashMap<String, String> n() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mobile", "144p");
        hashMap.put("lowest", "240p");
        hashMap.put("low", "360p");
        hashMap.put("sd", "480p");
        hashMap.put("hd", "720p");
        hashMap.put("full", "1080p");
        hashMap.put("quad", "QuadHD");
        hashMap.put("ultra", "4K");
        return hashMap;
    }

    public String c() {
        return "ok.ru";
    }

    /* access modifiers changed from: protected */
    public void l(MediaSource mediaSource, ObservableEmitter<? super MediaSource> observableEmitter) {
        JsonElement a2;
        JsonElement m2;
        String str;
        String b2 = Regex.b(mediaSource.getStreamLink(), "(?://|\\.)(ok\\.ru|odnoklassniki\\.ru)/(?:videoembed|video|moviePlayer)/([A-Za-z0-9-]+)", 2, 2);
        if (b2.isEmpty()) {
            b2 = Regex.a(mediaSource.getStreamLink(), "[\\?\\&]mid=(\\d+)", 1);
            if (b2.isEmpty()) {
                b2 = Regex.a(mediaSource.getStreamLink(), "st\\.mvId=(\\d+)", 1);
            }
        }
        if (!b2.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("Referer", "https://ok.ru/videoembed/" + b2);
            HttpHelper i2 = HttpHelper.i();
            String replaceAll = i2.l("https://ok.ru/dk?cmd=videoPlayerMetadata&mid=" + Utils.k(b2, new boolean[0]), "cmd=videoPlayerMetadata&mid=" + Utils.k(b2, new boolean[0]), hashMap).replaceAll("[^\\x00-\\x7F]+", " ");
            if (!replaceAll.isEmpty() && !replaceAll.contains(MRAIDPresenter.ERROR) && (a2 = new JsonParser().a(replaceAll)) != null && !a2.h() && a2.i() && (m2 = a2.c().m("videos")) != null && !m2.h() && m2.g()) {
                HashMap<String, String> n2 = n();
                Iterator<JsonElement> it2 = m2.b().iterator();
                ArrayList<ResolveResult> arrayList = new ArrayList<>();
                while (it2.hasNext()) {
                    JsonElement next = it2.next();
                    if (next != null && !next.h() && next.i()) {
                        String lowerCase = next.c().m("name").e().trim().toLowerCase();
                        String e2 = next.c().m(ImagesContract.URL).e();
                        if (!e2.isEmpty()) {
                            if (n2.containsKey(lowerCase)) {
                                str = n2.get(lowerCase);
                            } else {
                                str = "HQ";
                            }
                            if (!h().contains(str)) {
                                ResolveResult resolveResult = new ResolveResult(c(), e2, str);
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put(TheTvdb.HEADER_ACCEPT, "*/*");
                                hashMap2.put("User-Agent", Constants.C);
                                hashMap2.put("Origin", "https://ok.ru");
                                hashMap2.put("Referer", "https://ok.ru/");
                                hashMap2.put("Cookie", HttpHelper.i().g("https://ok.ru/"));
                                resolveResult.setPlayHeader(hashMap2);
                                arrayList.add(resolveResult);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    Collections.reverse(arrayList);
                    for (ResolveResult a3 : arrayList) {
                        observableEmitter.onNext(BaseResolver.a(mediaSource, a3));
                    }
                }
            }
        }
    }
}
