package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzfbi;

final class zzm extends WebViewClient {
    final /* synthetic */ zzs zza;

    zzm(zzs zzs) {
        this.zza = zzs;
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zzs zzs = this.zza;
        if (zzs.zzg != null) {
            try {
                zzs.zzg.zzf(zzfbi.zzd(1, (String) null, (zze) null));
            } catch (RemoteException e2) {
                zzbzr.zzl("#007 Could not call remote method.", e2);
            }
        }
        zzs zzs2 = this.zza;
        if (zzs2.zzg != null) {
            try {
                zzs2.zzg.zze(0);
            } catch (RemoteException e3) {
                zzbzr.zzl("#007 Could not call remote method.", e3);
            }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.zza.zzq())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            zzs zzs = this.zza;
            if (zzs.zzg != null) {
                try {
                    zzs.zzg.zzf(zzfbi.zzd(3, (String) null, (zze) null));
                } catch (RemoteException e2) {
                    zzbzr.zzl("#007 Could not call remote method.", e2);
                }
            }
            zzs zzs2 = this.zza;
            if (zzs2.zzg != null) {
                try {
                    zzs2.zzg.zze(3);
                } catch (RemoteException e3) {
                    zzbzr.zzl("#007 Could not call remote method.", e3);
                }
            }
            this.zza.zzV(0);
            return true;
        } else if (str.startsWith("gmsg://scriptLoadFailed")) {
            zzs zzs3 = this.zza;
            if (zzs3.zzg != null) {
                try {
                    zzs3.zzg.zzf(zzfbi.zzd(1, (String) null, (zze) null));
                } catch (RemoteException e4) {
                    zzbzr.zzl("#007 Could not call remote method.", e4);
                }
            }
            zzs zzs4 = this.zza;
            if (zzs4.zzg != null) {
                try {
                    zzs4.zzg.zze(0);
                } catch (RemoteException e5) {
                    zzbzr.zzl("#007 Could not call remote method.", e5);
                }
            }
            this.zza.zzV(0);
            return true;
        } else if (str.startsWith("gmsg://adResized")) {
            zzs zzs5 = this.zza;
            if (zzs5.zzg != null) {
                try {
                    zzs5.zzg.zzi();
                } catch (RemoteException e6) {
                    zzbzr.zzl("#007 Could not call remote method.", e6);
                }
            }
            this.zza.zzV(this.zza.zzb(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            zzs zzs6 = this.zza;
            if (zzs6.zzg != null) {
                try {
                    zzs6.zzg.zzc();
                    this.zza.zzg.zzh();
                } catch (RemoteException e7) {
                    zzbzr.zzl("#007 Could not call remote method.", e7);
                }
            }
            zzs.zzw(this.zza, zzs.zzo(this.zza, str));
            return true;
        }
    }
}
