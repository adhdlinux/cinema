package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import io.michaelrocks.paranoid.Deobfuscator$app$ProductionRelease;
import io.reactivex.ObservableEmitter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Ridomovies extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    String f37429e = Utils.getProvider(3);

    private void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        HashMap hashMap = new HashMap();
        String a2 = Deobfuscator$app$ProductionRelease.a(-212330011635908L);
        hashMap.put(a2, this.f37429e + Deobfuscator$app$ProductionRelease.a(-212295651897540L));
        String replace = Regex.a(HttpHelper.i().m(String.format(Deobfuscator$app$ProductionRelease.a(-212252702224580L), new Object[]{this.f37429e, str}), new Map[0]).replace(Deobfuscator$app$ProductionRelease.a(-212209752551620L), Deobfuscator$app$ProductionRelease.a(-212235522355396L)), Deobfuscator$app$ProductionRelease.a(-212231227388100L), 1).replace(Deobfuscator$app$ProductionRelease.a(-213163235291332L), Deobfuscator$app$ProductionRelease.a(-213115990651076L));
        if (!replace.isEmpty()) {
            MediaSource mediaSource = new MediaSource(A(), Deobfuscator$app$ProductionRelease.a(-213107400716484L), false);
            mediaSource.setStreamLink(replace);
            mediaSource.setPlayHeader(hashMap);
            mediaSource.setQuality(Deobfuscator$app$ProductionRelease.a(-213042976207044L));
            observableEmitter.onNext(mediaSource);
        }
    }

    public String A() {
        return Deobfuscator$app$ProductionRelease.a(-211621342032068L);
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(observableEmitter, movieInfo, K);
        }
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        String K = K(movieInfo);
        if (!K.isEmpty()) {
            J(observableEmitter, movieInfo, K);
        }
    }

    public String K(MovieInfo movieInfo) {
        boolean z2;
        if (movieInfo.getType().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        try {
            JSONArray jSONArray = new JSONObject(HttpHelper.i().m(String.format(Deobfuscator$app$ProductionRelease.a(-213064451043524L), new Object[]{this.f37429e, movieInfo.imdbIDStr}), new Map[0])).getJSONObject(Deobfuscator$app$ProductionRelease.a(-213236249735364L)).getJSONArray(Deobfuscator$app$ProductionRelease.a(-213180415160516L));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject.getJSONObject(Deobfuscator$app$ProductionRelease.a(-213189005095108L)).getString(Deobfuscator$app$ProductionRelease.a(-212828227842244L)).equals(movieInfo.imdbIDStr)) {
                    String string = jSONObject.getString(Deobfuscator$app$ProductionRelease.a(-212798163071172L));
                    if (z2) {
                        return Deobfuscator$app$ProductionRelease.a(-212811047973060L) + string;
                    }
                    String a2 = Regex.a(HttpHelper.i().m(String.format(Deobfuscator$app$ProductionRelease.a(-212776688234692L), new Object[]{this.f37429e, string, movieInfo.session, movieInfo.eps}), new Map[0]).replace(Deobfuscator$app$ProductionRelease.a(-212922717122756L), Deobfuscator$app$ProductionRelease.a(-212914127188164L)), Deobfuscator$app$ProductionRelease.a(-211501082947780L), 1);
                    if (a2.isEmpty()) {
                        return Deobfuscator$app$ProductionRelease.a(-211595572228292L);
                    }
                    return Deobfuscator$app$ProductionRelease.a(-211638521901252L) + a2;
                }
            }
            return Deobfuscator$app$ProductionRelease.a(-211591277260996L);
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }
}
