package com.yoku.house.ads.helper;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.uwetrottmann.trakt5.TraktV2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HouseAdsHelper {
    public static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    static String b(String str) {
        Document document;
        try {
            document = Jsoup.a(str.trim()).c(true).a(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT).b("Connection", "keep-alive").b("Cache-Control", "max-age=0").b(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8").b("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36").b(TraktV2.HEADER_CONTENT_TYPE, "application/x-www-form-urlencoded").b("Referer", "HouseAds (App)").b("Accept-Encoding", "gzip,deflate,sdch").b(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US,en;q=0.8,ru;q=0.6").get();
        } catch (Exception e2) {
            Log.e("HouseAds", e2.getMessage());
            document = null;
        }
        if (document != null) {
            return document.w0().v0();
        }
        return "";
    }
}
