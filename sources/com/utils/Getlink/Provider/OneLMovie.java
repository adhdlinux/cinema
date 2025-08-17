package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.DirectoryIndexHelper;
import com.original.tase.helper.crypto.AESEncrypter;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OneLMovie extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37397e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f37398f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f37399g = "";

    /* renamed from: h  reason: collision with root package name */
    private String f37400h = "";

    /* renamed from: i  reason: collision with root package name */
    private String f37401i = "";

    public String A() {
        return "OneLMovie";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (!J().isEmpty() && BaseProvider.v() && !this.f37401i.isEmpty()) {
            K(movieInfo, observableEmitter, "0", "0", movieInfo.year, true);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        if (!J().isEmpty() && BaseProvider.v() && !this.f37401i.isEmpty()) {
            K(movieInfo, observableEmitter, movieInfo.session, movieInfo.eps, "0", true);
        }
    }

    public String J() {
        try {
            HttpHelper i2 = HttpHelper.i();
            String m2 = i2.m(Constants.E + "provider/hmv.txt", new Map[0]);
            String d2 = AESEncrypter.d(m2, Utils.ae());
            Logger.b("OneLMovie ", d2);
            if (d2 != null) {
                if (!d2.isEmpty()) {
                    String[] split = d2.split("##");
                    this.f37397e = split[0];
                    this.f37398f = split[1];
                    this.f37399g = split[2];
                    this.f37400h = split[3];
                    this.f37401i = split[4].replace(" ", "");
                    return m2;
                }
            }
            return "";
        } catch (Throwable th) {
            Logger.c(th, "OneLMovie cccc", new boolean[0]);
            return "";
        }
    }

    public void K(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter, String str, String str2, String str3, boolean z2) {
        String format = String.format(this.f37398f, new Object[]{movieInfo.name.toLowerCase(), str, str2, Utils.md5(movieInfo.name.toLowerCase() + str.toString() + this.f37397e + str2.toString()).toString(), str3});
        if (z2) {
            format = format + this.f37401i;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("user-agent", this.f37399g);
        Iterator it2 = Regex.f(HttpHelper.i().l(this.f37400h, format, hashMap).replace("\\/", "/"), "link[\"]\\s*:\\s*['\"]([^'\"]+[^'\"]*)['\"]", 1, true).get(0).iterator();
        DirectoryIndexHelper directoryIndexHelper = new DirectoryIndexHelper();
        String str4 = "HD";
        while (it2.hasNext()) {
            String str5 = (String) it2.next();
            A();
            DirectoryIndexHelper.ParsedLinkModel c2 = directoryIndexHelper.c(str5);
            c2.e(str4);
            if (!c2.c().equalsIgnoreCase("HQ")) {
                str4 = c2.c();
            }
            String t2 = t(c2.b());
            HashMap hashMap2 = new HashMap();
            hashMap2.put("user-agent", Constants.C);
            if (t2.isEmpty()) {
                t2 = A();
            }
            MediaSource mediaSource = new MediaSource(t2, "CDN", false);
            mediaSource.setStreamLink(str5);
            mediaSource.setPlayHeader(hashMap2);
            mediaSource.setQuality(str4);
            observableEmitter.onNext(mediaSource);
        }
    }
}
