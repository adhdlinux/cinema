package com.utils.subtitle.services;

import com.google.gson.Gson;
import com.movie.FreeMoviesApp;
import com.movie.data.api.GlobalVariable;
import com.movie.data.model.MovieInfo;
import com.original.tase.Logger;
import com.original.tase.helper.http.HttpHelper;
import com.utils.Utils;
import com.utils.subtitle.SubtitleInfo;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleModel;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

public class OpenSubtitleRest extends SubServiceBase {
    public void j(MovieInfo movieInfo, ObservableEmitter<? super ArrayList<SubtitleInfo>> observableEmitter) {
        boolean z2;
        MovieInfo movieInfo2 = movieInfo;
        ObservableEmitter<? super ArrayList<SubtitleInfo>> observableEmitter2 = observableEmitter;
        try {
            String opensubtitle_user_agent = GlobalVariable.c().b().getOpensubtitle_user_agent();
            char c2 = 0;
            if (movieInfo.getType().intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            StringBuilder sb = new StringBuilder();
            String str = movieInfo2.fileName;
            if (str != null) {
                sb.append(String.format("/query-%s", new Object[]{str.replace(" ", "%20")}));
            } else {
                String str2 = movieInfo2.imdbIDStr;
                if (str2 != null) {
                    if (!str2.isEmpty()) {
                        sb.append(String.format("/imdbid-%s", new Object[]{movieInfo2.imdbIDStr.replaceAll("[^0-9]", "")}));
                    }
                }
                sb.append(String.format("/imdbid-%s", new Object[]{Utils.o(movieInfo2.tmdbID, z2)}));
            }
            if (movieInfo.getSession().intValue() > -1) {
                sb.append(String.format("/season-%s", new Object[]{movieInfo2.session}));
            }
            if (movieInfo.getEps().intValue() > -1) {
                sb.append(String.format("/episode-%s", new Object[]{movieInfo2.eps}));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", opensubtitle_user_agent);
            ArrayList arrayList = new ArrayList();
            for (String d2 : FreeMoviesApp.p().getStringSet("pref_sub_language_international_v3", new HashSet(Arrays.asList(new String[]{Locale.getDefault().getLanguage()})))) {
                String d3 = LanguageId.a().d(d2);
                StringBuilder sb2 = new StringBuilder("https://rest.opensubtitles.org/search" + sb);
                Object[] objArr = new Object[1];
                objArr[c2] = d3;
                sb2.append(String.format("/sublanguageid-%s", objArr));
                HttpHelper i2 = HttpHelper.i();
                String sb3 = sb2.toString();
                Map[] mapArr = new Map[1];
                mapArr[c2] = hashMap;
                String m2 = i2.m(sb3, mapArr);
                Logger.b("OpenSubtitlesV2", m2);
                OpenSubtitleModel[] openSubtitleModelArr = (OpenSubtitleModel[]) new Gson().l(m2, OpenSubtitleModel[].class);
                int length = openSubtitleModelArr.length;
                int i3 = 0;
                while (i3 < length) {
                    OpenSubtitleModel openSubtitleModel = openSubtitleModelArr[i3];
                    if (openSubtitleModel.getSubLanguageID().contains(d3)) {
                        arrayList.add(new SubtitleInfo(openSubtitleModel.getSubFileName(), openSubtitleModel.getZipDownloadLink().replace("\\/", "/"), openSubtitleModel.getLanguageName(), Integer.parseInt(openSubtitleModel.getSubDownloadsCnt()), SubtitleInfo.Source.OpenSubtitleRest));
                    }
                    i3++;
                    c2 = 0;
                }
            }
            observableEmitter2.onNext(arrayList);
        } catch (Exception unused) {
            observableEmitter2.onNext(new ArrayList());
        }
    }
}
