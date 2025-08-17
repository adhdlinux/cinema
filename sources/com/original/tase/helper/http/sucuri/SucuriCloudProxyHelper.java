package com.original.tase.helper.http.sucuri;

import android.util.Base64;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.helper.http.HttpHelper;
import com.squareup.duktape.Duktape;
import com.uwetrottmann.thetvdb.TheTvdb;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import okhttp3.CacheControl;
import okhttp3.Request;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class SucuriCloudProxyHelper {
    /* JADX INFO: finally extract failed */
    private static String a(String str) {
        Object obj;
        Duktape create = Duktape.create();
        try {
            obj = create.evaluate(c(str));
            create.close();
        } catch (Throwable th) {
            try {
                Logger.d(th, new boolean[0]);
                create.close();
                obj = null;
            } catch (Throwable th2) {
                create.close();
                throw th2;
            }
        }
        if (obj != null) {
            try {
                return new String(Base64.decode(obj.toString(), 0), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static boolean b(String str, String str2) {
        Iterator it2 = Jsoup.b(str2).q0("script").iterator();
        while (it2.hasNext()) {
            String Z = ((Element) it2.next()).Z();
            if (e(Z)) {
                HttpHelper.i().D(str, a(Z));
                return true;
            }
        }
        return false;
    }

    private static String c(String str) {
        return "document = {cookie: \"\"};\nlocation = {reload: function(){/*Empty method of location.reload()*/}};\n\n{jsCode};\n\nDuktape.enc('base64', document.cookie.toString());".replace("{jsCode}", str);
    }

    public static String d(String str, String str2) {
        String m2 = HttpHelper.i().m(str2, new Map[0]);
        if (!b(str, m2)) {
            return m2;
        }
        return HttpHelper.i().u(new Request.Builder().get().url(str2).tag(HttpHelper.f33895d).addHeader("User-Agent", Constants.C).addHeader("Referer", str).addHeader("Host", str.replace("https://", "").replace("http://", "").replace("/", "")).addHeader("Cookie", HttpHelper.i().g(str2)).addHeader(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8").addHeader(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US;q=0.6,en;q=0.4").cacheControl(CacheControl.FORCE_NETWORK).build());
    }

    public static boolean e(String str) {
        return str.contains("sucuri_cloudproxy_js");
    }
}
