package com.movie.data.api.imdb;

import com.database.entitys.MovieEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.ResponseBody;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class IMDBUtils {
    public static MovieEntity a(String str, ResponseBody responseBody, boolean z2) throws IOException {
        Document b2 = Jsoup.b(responseBody.string());
        if (!z2) {
            Element r02 = b2.r0("div.title_wrapper");
            String v02 = r02.r0(".originalTitle").v0();
            Elements q02 = r02.q0(".subtext a");
            String h2 = b2.q0("div.ratingValue strong span[itemprop]").h();
            ArrayList arrayList = new ArrayList();
            Iterator it2 = q02.iterator();
            String str2 = "";
            while (it2.hasNext()) {
                Element element = (Element) it2.next();
                if (element.toString().contains("genres")) {
                    arrayList.add(element.v0());
                } else if (element.toString().contains("releaseinfo")) {
                    str2 = element.v0();
                }
            }
            String v03 = b2.r0("div.summary_text").v0();
            String c2 = b2.r0(".poster a img[src]").c("src");
            MovieEntity movieEntity = new MovieEntity();
            movieEntity.setImdbIDStr(str);
            movieEntity.setTV(Boolean.FALSE);
            movieEntity.setPoster_path(c2);
            movieEntity.setName(v02);
            movieEntity.setRealeaseDate(str2);
            movieEntity.setVote(Double.valueOf(h2));
            movieEntity.setOverview(v03);
            return movieEntity;
        }
        String c3 = b2.r0(".poster a img[src]").c("src");
        MovieEntity movieEntity2 = new MovieEntity();
        movieEntity2.setPoster_path(c3);
        return movieEntity2;
    }
}
