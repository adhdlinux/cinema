package com.utils.Getlink.Provider;

import com.movie.data.model.MovieInfo;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import io.reactivex.ObservableEmitter;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Movie25V2 extends BaseProvider {

    /* renamed from: e  reason: collision with root package name */
    private String f37382e = Utils.getProvider(75);

    public String A() {
        return "Movie25V2";
    }

    /* access modifiers changed from: protected */
    public void B(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo, String.format("%s/data/search/?lang=%s&keyword=%s", new Object[]{this.f37382e, 2, com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0]).replace("+", "%20")}));
    }

    /* access modifiers changed from: protected */
    public void D(MovieInfo movieInfo, ObservableEmitter<? super MediaSource> observableEmitter) {
        J(observableEmitter, movieInfo, String.format("%s/data/search/?lang=%s&keyword=%s", new Object[]{this.f37382e, 2, com.original.tase.utils.Utils.k(movieInfo.name, new boolean[0]).replace("+", "%20")}));
    }

    public void J(ObservableEmitter<? super MediaSource> observableEmitter, MovieInfo movieInfo, String str) {
        MovieInfo movieInfo2 = movieInfo;
        boolean z2 = true;
        if (movieInfo.getType().intValue() != 1) {
            z2 = false;
        }
        String m2 = HttpHelper.i().m(str, new Map[0]);
        if (!m2.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray(m2);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String string = jSONObject.getString("imdb_id");
                    if (!string.isEmpty() && string.equals(movieInfo2.imdbIDStr)) {
                        if (!z2) {
                            String string2 = jSONObject.getString("s");
                            if (!string2.isEmpty()) {
                                if (!string2.equals(movieInfo2.session)) {
                                }
                            }
                        }
                        JSONArray jSONArray2 = jSONObject.getJSONArray("streams");
                        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                            if (!z2) {
                                String string3 = jSONObject.getString("e");
                                if (!string3.isEmpty()) {
                                    if (!string3.equals(movieInfo2.eps)) {
                                    }
                                }
                            }
                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                            String string4 = jSONObject2.getString("stream");
                            String string5 = jSONObject2.getString("source");
                            if (!string4.isEmpty()) {
                                if (string4.startsWith("//")) {
                                    string4 = "https:" + string4;
                                }
                                String replace = string4.replace("\\/", "/");
                                if (string5.isEmpty()) {
                                    string5 = A();
                                }
                                x(observableEmitter, replace, "HD", string5, new boolean[0]);
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
    }
}
