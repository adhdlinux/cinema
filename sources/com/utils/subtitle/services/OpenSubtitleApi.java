package com.utils.subtitle.services;

import com.domain.network.api.openSubtitle.OpenSubtitleOAuthSettings;
import com.movie.FreeMoviesApp;
import com.movie.data.api.GlobalVariable;
import com.movie.data.model.MovieInfo;
import com.utils.Utils;
import com.utils.subtitle.SubtitleInfo;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import com.utils.subtitle.services.openSubtitle.models.Data;
import com.utils.subtitle.services.openSubtitle.models.Subtitles;
import com.utils.subtitle.services.openSubtitle.models.UserInfoResponse;
import io.reactivex.ObservableEmitter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import l1.a;
import retrofit2.Response;

public class OpenSubtitleApi extends SubServiceBase {

    /* renamed from: d  reason: collision with root package name */
    private OpenSubtitleV1Api f37753d;

    public OpenSubtitleApi(OpenSubtitleV1Api openSubtitleV1Api) {
        this.f37753d = openSubtitleV1Api;
    }

    public void j(MovieInfo movieInfo, ObservableEmitter<? super ArrayList<SubtitleInfo>> observableEmitter) {
        boolean z2;
        Response<Subtitles> response;
        MovieInfo movieInfo2 = movieInfo;
        ObservableEmitter<? super ArrayList<SubtitleInfo>> observableEmitter2 = observableEmitter;
        OpenSubtitleOAuthSettings openSubtitleOAuthSettings = OpenSubtitleOAuthSettings.f19367a;
        if (!openSubtitleOAuthSettings.b().isEmpty()) {
            try {
                Response<UserInfoResponse> execute = this.f37753d.getUsers().execute();
                if (execute.isSuccessful() && execute.body() != null) {
                    openSubtitleOAuthSettings.f(execute.body().getData());
                }
                if (openSubtitleOAuthSettings.c() == null) {
                    return;
                }
                if (openSubtitleOAuthSettings.c().getVip() || openSubtitleOAuthSettings.c().getRemaining_downloads() > 0) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        GlobalVariable.c().b().getOpensubtitle_user_agent();
                        if (movieInfo.getType().intValue() == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        int parseInt = Integer.parseInt(movieInfo2.imdbIDStr.replaceAll("[^0-9]", ""));
                        int i2 = (int) movieInfo2.tmdbID;
                        String str = movieInfo2.name;
                        String a2 = a.a(",", FreeMoviesApp.p().getStringSet("pref_sub_language_international_v3", new HashSet(Arrays.asList(new String[]{Locale.getDefault().getLanguage()}))));
                        String str2 = movieInfo2.imdbIDStr;
                        if (str2 == null || str2.isEmpty()) {
                            parseInt = Integer.parseInt(Utils.o(movieInfo2.tmdbID, z2));
                        }
                        if (movieInfo.getSession().intValue() > -1) {
                            String.format("/season-%s", new Object[]{movieInfo2.session});
                        }
                        if (movieInfo.getEps().intValue() > -1) {
                            String.format("/episode-%s", new Object[]{movieInfo2.eps});
                        }
                        if (movieInfo.getType().intValue() == 1) {
                            response = this.f37753d.searchSubtitle((String) null, Integer.valueOf(parseInt), Integer.valueOf(i2), (Integer) null, (Integer) null, (Integer) null, (Integer) null, str, "movie", a2, (Integer) null, 1).execute();
                        } else {
                            response = this.f37753d.searchSubtitle((String) null, (Integer) null, (Integer) null, Integer.valueOf(parseInt), Integer.valueOf(i2), Integer.valueOf(movieInfo2.session), Integer.valueOf(movieInfo2.eps), str, "episode", a2, (Integer) null, 1).execute();
                        }
                        if (response.isSuccessful() && response.body() != null) {
                            for (Data next : response.body().getData()) {
                                arrayList.add(new SubtitleInfo(next.getAttributes().getFiles().get(0).getFile_name() + " [Download count :" + " " + next.getAttributes().getDownload_count() + "]", String.valueOf(next.getAttributes().getFiles().get(0).getFile_id()), next.getAttributes().getLanguage(), next.getAttributes().getDownload_count(), SubtitleInfo.Source.OpenSubtitleApi));
                            }
                        }
                        observableEmitter2.onNext(arrayList);
                    } catch (Exception unused) {
                        observableEmitter2.onNext(new ArrayList());
                    }
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }
}
