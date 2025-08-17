package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.Constants;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Map;

public class Kisscartoon extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37369e = Utils.getProvider(1);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, String str) {
        String a2 = Regex.a(HttpHelper.i().m(str, new Map[0]), Deobfuscator$app$ProductionRelease.a(-212557644902596L), 1);
        if (!a2.isEmpty()) {
            boolean contains = a2.contains(Deobfuscator$app$ProductionRelease.a(-212755213398212L));
            if (contains) {
                MediaSource mediaSource = new MediaSource(A(), A(), false);
                mediaSource.setStreamLink(a2);
                mediaSource.setQuality(Deobfuscator$app$ProductionRelease.a(-212695083856068L));
                if (contains) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Deobfuscator$app$ProductionRelease.a(-212716558692548L), Constants.C);
                    mediaSource.setPlayHeader(hashMap);
                }
                mediaSource.setCachedLink(true);
                mediaSource.setProviderName(A());
                observableEmitter.onNext(mediaSource);
                return;
            }
            z(observableEmitter, a2, Deobfuscator$app$ProductionRelease.a(-212634954313924L), false);
        }
    }

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-212622069412036L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String str;
        Deobfuscator$app$ProductionRelease.a(-214301401624772L);
        if (!movieInfo.imdbIDStr.isEmpty()) {
            str = String.format(Deobfuscator$app$ProductionRelease.a(-214297106657476L), new Object[]{this.f37369e, movieInfo.imdbIDStr});
        } else {
            str = String.format(Deobfuscator$app$ProductionRelease.a(-213927739470020L), new Object[]{Long.valueOf(movieInfo.tmdbID)});
        }
        J(observableEmitter, str);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String str;
        Deobfuscator$app$ProductionRelease.a(-213867609927876L);
        if (!movieInfo.imdbIDStr.isEmpty()) {
            str = String.format(Deobfuscator$app$ProductionRelease.a(-213863314960580L), new Object[]{this.f37369e, movieInfo.imdbIDStr, movieInfo.session, movieInfo.eps});
        } else {
            str = String.format(Deobfuscator$app$ProductionRelease.a(-214035113652420L), new Object[]{Long.valueOf(movieInfo.tmdbID), movieInfo.session, movieInfo.eps});
        }
        J(observableEmitter, str);
    }
}
