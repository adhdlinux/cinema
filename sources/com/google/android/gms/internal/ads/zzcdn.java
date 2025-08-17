package com.google.android.gms.internal.ads;

import com.facebook.common.util.UriUtil;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public final /* synthetic */ class zzcdn implements zzflx {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzcdn(String str) {
        this.zza = str;
    }

    public final URLConnection zza() {
        String str = this.zza;
        int i2 = zzcdo.zzd;
        zzt.zzw();
        int intValue = ((Integer) zzba.zzc().zzb(zzbbm.zzz)).intValue();
        URL url = new URL(str);
        int i3 = 0;
        while (true) {
            i3++;
            if (i3 <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(intValue);
                openConnection.setReadTimeout(intValue);
                if (openConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    zzbzq zzbzq = new zzbzq((String) null);
                    zzbzq.zzc(httpURLConnection, (byte[]) null);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzbzq.zze(httpURLConnection, responseCode);
                    if (responseCode / 100 != 3) {
                        return httpURLConnection;
                    }
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (headerField != null) {
                        URL url2 = new URL(url, headerField);
                        String protocol = url2.getProtocol();
                        if (protocol == null) {
                            throw new IOException("Protocol is null");
                        } else if (protocol.equals(UriUtil.HTTP_SCHEME) || protocol.equals(UriUtil.HTTPS_SCHEME)) {
                            zzbzr.zze("Redirecting to ".concat(headerField));
                            httpURLConnection.disconnect();
                            url = url2;
                        } else {
                            throw new IOException("Unsupported scheme: ".concat(protocol));
                        }
                    } else {
                        throw new IOException("Missing Location header in redirect");
                    }
                } else {
                    throw new IOException("Invalid protocol.");
                }
            } else {
                throw new IOException("Too many redirects (20)");
            }
        }
    }
}
