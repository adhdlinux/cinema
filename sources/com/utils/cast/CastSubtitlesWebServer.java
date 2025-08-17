package com.utils.cast;

import com.original.tase.Logger;
import com.uwetrottmann.trakt5.TraktV2;
import fi.iki.elonen.NanoHTTPD;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CastSubtitlesWebServer extends NanoHTTPD {

    /* renamed from: n  reason: collision with root package name */
    private Map<String, Object> f37643n;

    public CastSubtitlesWebServer(int i2) {
        super(i2);
    }

    public static String C(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[((int) file.length())];
            fileInputStream.read(bArr);
            String str = new String(bArr, StandardCharsets.UTF_8);
            fileInputStream.close();
            return str;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void D(Map<String, Object> map) {
        if (this.f37643n == null) {
            this.f37643n = new HashMap();
        }
        for (Map.Entry next : map.entrySet()) {
            if (!this.f37643n.containsKey(next.getKey())) {
                this.f37643n.put((String) next.getKey(), next.getValue());
            }
        }
    }

    public NanoHTTPD.Response u(NanoHTTPD.IHTTPSession iHTTPSession) {
        try {
            Map<String, Object> map = this.f37643n;
            if (map != null) {
                if (!map.isEmpty()) {
                    String lowerCase = iHTTPSession.b().toLowerCase();
                    if (lowerCase.startsWith("/")) {
                        lowerCase = lowerCase.substring(1, lowerCase.length());
                    }
                    if (this.f37643n.containsKey(lowerCase)) {
                        Object obj = this.f37643n.get(lowerCase);
                        if (obj instanceof String) {
                            String str = (String) this.f37643n.get(lowerCase);
                            if (str != null) {
                                if (!str.isEmpty()) {
                                    NanoHTTPD.Response s2 = NanoHTTPD.s(NanoHTTPD.Response.Status.OK, "application/ttml+xml", str);
                                    s2.a("Access-Control-Allow-Origin", "*");
                                    s2.a(TraktV2.HEADER_CONTENT_TYPE, "application/ttml+xml; charset=utf-8");
                                    return s2;
                                }
                            }
                            Logger.d(new RuntimeException("mSubsMap doesn't contain the corresponding subtitles key"), true);
                            return NanoHTTPD.s(NanoHTTPD.Response.Status.NOT_FOUND, "text/plain", "");
                        } else if (obj instanceof File) {
                            return NanoHTTPD.s(NanoHTTPD.Response.Status.OK, "text/plain", C((File) obj));
                        }
                    }
                    return NanoHTTPD.s(NanoHTTPD.Response.Status.INTERNAL_ERROR, "text/plain", "Failed to upload file.");
                }
            }
            Logger.d(new RuntimeException("mSubsMap is null"), true);
            return NanoHTTPD.s(NanoHTTPD.Response.Status.NOT_FOUND, "text/plain", "");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
