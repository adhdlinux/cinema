package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import com.utils.kotlin.AesHelper;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BestTvFix extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37261e = Utils.getProvider(68);

    /* renamed from: f  reason: collision with root package name */
    private String f37262f = Deobfuscator$app$ProductionRelease.a(-184979659894980L);

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-184666127282372L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(movieInfo, observableEmitter);
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(movieInfo, observableEmitter);
    }

    public void J(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        boolean z2;
        JSONObject jSONObject;
        String str;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        String str2 = Deobfuscator$app$ProductionRelease.a(-184932415254724L) + movieInfo.tmdbID;
        if (!z2) {
            str2 = Deobfuscator$app$ProductionRelease.a(-184915235385540L) + movieInfo.tmdbID;
        }
        String str3 = this.f37261e + Deobfuscator$app$ProductionRelease.a(-185649674793156L) + AesHelper.f37691a.b(str2.getBytes()) + Deobfuscator$app$ProductionRelease.a(-185580955316420L);
        HashMap hashMap = new HashMap();
        hashMap.put(Deobfuscator$app$ProductionRelease.a(-185812883550404L), this.f37261e);
        if (!z2) {
            str3 = String.format(Deobfuscator$app$ProductionRelease.a(-185344732115140L), new Object[]{this.f37261e, Regex.a(HttpHelper.i().m(str3, hashMap), Deobfuscator$app$ProductionRelease.a(-185778523812036L), 1), movieInfo.session, movieInfo.eps});
        }
        String m2 = HttpHelper.i().m(str3, hashMap);
        if (!z2) {
            try {
                jSONObject = new JSONObject(m2).getJSONObject(Deobfuscator$app$ProductionRelease.a(-183978932515012L));
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            jSONObject = new JSONObject(m2).getJSONObject(Deobfuscator$app$ProductionRelease.a(-183944572776644L));
        }
        JSONArray jSONArray = jSONObject.getJSONArray(Deobfuscator$app$ProductionRelease.a(-183953162711236L));
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            String string = jSONObject2.getString(Deobfuscator$app$ProductionRelease.a(-183923097940164L));
            String string2 = jSONObject2.getString(Deobfuscator$app$ProductionRelease.a(-184146436239556L));
            String a2 = Regex.a(string2, Deobfuscator$app$ProductionRelease.a(-184112076501188L), 1);
            if (!a2.isEmpty()) {
                string2 = a2;
            }
            boolean n2 = GoogleVideoHelper.n(string);
            String A = A();
            if (n2) {
                str = Deobfuscator$app$ProductionRelease.a(-184099191599300L);
            } else {
                str = Deobfuscator$app$ProductionRelease.a(-183738414346436L);
            }
            MediaSource mediaSource = new MediaSource(A, str, false);
            mediaSource.setStreamLink(string);
            if (n2) {
                mediaSource.setPlayHeader(hashMap);
            }
            if (n2) {
                string2 = GoogleVideoHelper.h(string);
            }
            mediaSource.setQuality(string2);
            observableEmitter.onNext(mediaSource);
        }
    }
}
