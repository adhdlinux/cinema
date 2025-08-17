package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import com.utils.kotlin.AesHelper;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FixOne extends BaseProvider {

    /* renamed from: f  reason: collision with root package name */
    public static String f37318f = Deobfuscator$app$ProductionRelease.a(-241080522715332L);

    /* renamed from: e  reason: collision with root package name */
    private String f37319e = Utils.getProvider(25);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        HashMap hashMap = new HashMap();
        String a2 = Deobfuscator$app$ProductionRelease.a(-244787079491780L);
        hashMap.put(a2, this.f37319e + Deobfuscator$app$ProductionRelease.a(-243378330218692L));
        String m2 = HttpHelper.i().m(str, hashMap);
        String a3 = Regex.a(m2, Deobfuscator$app$ProductionRelease.a(-243404100022468L), 1);
        if (!a3.isEmpty()) {
            m2 = HttpHelper.i().m(a3, hashMap);
            String a4 = Deobfuscator$app$ProductionRelease.a(-243541538975940L);
            hashMap.put(a4, BaseProvider.j(a3) + Deobfuscator$app$ProductionRelease.a(-243507179237572L));
            hashMap.put(Deobfuscator$app$ProductionRelease.a(-243498589302980L), BaseProvider.j(a3));
            if (!Regex.a(m2, Deobfuscator$app$ProductionRelease.a(-243468524531908L), 1).isEmpty()) {
                if (f37318f.isEmpty()) {
                    HttpHelper i2 = HttpHelper.i();
                    f37318f = i2.m(Constants.E + Deobfuscator$app$ProductionRelease.a(-243026142900420L), new Map[0]);
                }
                String c2 = AesHelper.f37691a.c(Regex.a(m2, Deobfuscator$app$ProductionRelease.a(-243223711396036L), 1), Regex.a(m2, Deobfuscator$app$ProductionRelease.a(-243859366555844L), 1), f37318f.getBytes(StandardCharsets.UTF_8), false, Deobfuscator$app$ProductionRelease.a(-244009690411204L));
                if (c2 != null && !c2.isEmpty()) {
                    String a5 = Regex.a(c2.replace(Deobfuscator$app$ProductionRelease.a(-243644618191044L), Deobfuscator$app$ProductionRelease.a(-243636028256452L)), Deobfuscator$app$ProductionRelease.a(-243631733289156L), 1);
                    if (!a5.isEmpty()) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(Deobfuscator$app$ProductionRelease.a(-243696157798596L), Deobfuscator$app$ProductionRelease.a(-243700452765892L));
                        hashMap2.put(Deobfuscator$app$ProductionRelease.a(-242274523623620L), Deobfuscator$app$ProductionRelease.a(-242261638721732L));
                        hashMap2.put(Deobfuscator$app$ProductionRelease.a(-242180034343108L), Deobfuscator$app$ProductionRelease.a(-242390487740612L));
                        hashMap2.put(Deobfuscator$app$ProductionRelease.a(-242399077675204L), Deobfuscator$app$ProductionRelease.a(-242334653165764L));
                        hashMap2.put(Deobfuscator$app$ProductionRelease.a(-242003940683972L), Deobfuscator$app$ProductionRelease.a(-241939516174532L));
                        String a6 = Deobfuscator$app$ProductionRelease.a(-241926631272644L);
                        hashMap2.put(a6, BaseProvider.j(a3) + Deobfuscator$app$ProductionRelease.a(-242167149441220L));
                        hashMap2.put(Deobfuscator$app$ProductionRelease.a(-242158559506628L), BaseProvider.j(a3));
                        MediaSource mediaSource = new MediaSource(A(), Deobfuscator$app$ProductionRelease.a(-242128494735556L), false);
                        mediaSource.setStreamLink(a5);
                        mediaSource.setPlayHeader(hashMap2);
                        mediaSource.setQuality(Deobfuscator$app$ProductionRelease.a(-242064070226116L));
                        observableEmitter.onNext(mediaSource);
                    }
                }
            }
        }
        String a7 = Regex.a(m2, Deobfuscator$app$ProductionRelease.a(-242832869372100L), 1);
        if (!a7.isEmpty()) {
            String d2 = BaseProvider.d(com.original.tase.utils.Utils.q(a7));
            if (!d2.isEmpty()) {
                Iterator<String> it2 = Regex.g(d2, Deobfuscator$app$ProductionRelease.a(-242940243554500L), 1, true).iterator();
                while (it2.hasNext()) {
                    HttpHelper i3 = HttpHelper.i();
                    String a8 = Regex.a(i3.m(this.f37319e + Deobfuscator$app$ProductionRelease.a(-242532221661380L) + it2.next(), hashMap), Deobfuscator$app$ProductionRelease.a(-242497861923012L), 1);
                    if (!a8.isEmpty()) {
                        MediaSource mediaSource2 = new MediaSource(A(), Deobfuscator$app$ProductionRelease.a(-241187896897732L), false);
                        mediaSource2.setStreamLink(a8);
                        mediaSource2.setPlayHeader(hashMap);
                        mediaSource2.setQuality(Deobfuscator$app$ProductionRelease.a(-241157832126660L));
                        observableEmitter.onNext(mediaSource2);
                    }
                }
            }
        }
    }

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-241110587486404L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo, String.format(Deobfuscator$app$ProductionRelease.a(-244662525440196L), new Object[]{this.f37319e, Long.valueOf(movieInfo.tmdbID)}));
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo, String.format(Deobfuscator$app$ProductionRelease.a(-244851504001220L), new Object[]{this.f37319e, Long.valueOf(movieInfo.tmdbID), movieInfo.session, movieInfo.eps}));
    }
}
