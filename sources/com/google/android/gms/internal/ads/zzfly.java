package com.google.android.gms.internal.ads;

import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public final class zzfly extends zzflm {
    private zzfpx<Integer> zza;
    private zzfpx<Integer> zzb;
    private zzflx zzc;
    private HttpURLConnection zzd;

    zzfly() {
        this(zzflv.zza, zzflw.zza, (zzflx) null);
    }

    zzfly(zzfpx<Integer> zzfpx, zzfpx<Integer> zzfpx2, zzflx zzflx) {
        this.zza = zzfpx;
        this.zzb = zzfpx2;
        this.zzc = zzflx;
    }

    static /* synthetic */ Integer zzf() {
        return -1;
    }

    static /* synthetic */ Integer zzg() {
        return -1;
    }

    public static void zzs(HttpURLConnection httpURLConnection) {
        zzfln.zza();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public void close() {
        zzs(this.zzd);
    }

    public HttpURLConnection zzm() throws IOException {
        zzfln.zzb(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzflx zzflx = this.zzc;
        zzflx.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzflx.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    public HttpURLConnection zzn(zzflx zzflx, int i2, int i3) throws IOException {
        this.zza = new zzflo(i2);
        this.zzb = new zzflp(i3);
        this.zzc = zzflx;
        return zzm();
    }

    public HttpURLConnection zzo(Network network, URL url, int i2, int i3) throws IOException {
        this.zza = new zzflq(i2);
        this.zzb = new zzflr(i3);
        this.zzc = new zzfls(network, url);
        return zzm();
    }

    public URLConnection zzr(URL url, int i2) throws IOException {
        this.zza = new zzflt(i2);
        this.zzc = new zzflu(url);
        return zzm();
    }
}
