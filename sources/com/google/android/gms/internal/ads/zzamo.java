package com.google.android.gms.internal.ads;

import com.uwetrottmann.trakt5.TraktV2;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class zzamo extends zzalk {
    private final Object zza = new Object();
    private final zzalp zzb;

    public zzamo(int i2, String str, zzalp zzalp, zzalo zzalo) {
        super(i2, str, zzalo);
        this.zzb = zzalp;
    }

    /* access modifiers changed from: protected */
    public final zzalq zzh(zzalg zzalg) {
        String str;
        try {
            byte[] bArr = zzalg.zzb;
            Map map = zzalg.zzc;
            String str2 = "ISO-8859-1";
            if (map != null) {
                String str3 = (String) map.get(TraktV2.HEADER_CONTENT_TYPE);
                if (str3 != null) {
                    String[] split = str3.split(";", 0);
                    int i2 = 1;
                    while (true) {
                        if (i2 >= split.length) {
                            break;
                        }
                        String[] split2 = split[i2].trim().split("=", 0);
                        if (split2.length == 2 && split2[0].equals("charset")) {
                            str2 = split2[1];
                            break;
                        }
                        i2++;
                    }
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzalg.zzb);
        }
        return zzalq.zzb(str, zzamh.zzb(zzalg));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzz */
    public void zzo(String str) {
        zzalp zzalp;
        synchronized (this.zza) {
            zzalp = this.zzb;
        }
        zzalp.zza(str);
    }
}
