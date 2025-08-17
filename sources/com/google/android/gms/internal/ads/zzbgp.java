package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.internal.client.zzct;
import com.google.android.gms.ads.internal.client.zzcw;
import com.google.android.gms.ads.internal.client.zzcx;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzep;
import com.google.android.gms.ads.internal.client.zzfe;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzbgp extends UnifiedNativeAd {
    private final zzbgo zza;
    private final List zzb = new ArrayList();
    private final zzbes zzc;
    private final VideoController zzd = new VideoController();
    private final NativeAd.AdChoicesInfo zze;
    private final List zzf = new ArrayList();

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050 A[Catch:{ RemoteException -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00af A[Catch:{ RemoteException -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0027 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbgp(com.google.android.gms.internal.ads.zzbgo r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzb = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.zzd = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzf = r1
            r5.zza = r6
            r1 = 0
            java.util.List r6 = r6.zzu()     // Catch:{ RemoteException -> 0x005b }
            if (r6 == 0) goto L_0x005f
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x005b }
        L_0x0027:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x005b }
            if (r2 == 0) goto L_0x005f
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x005b }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x005b }
            if (r3 == 0) goto L_0x004d
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x005b }
            if (r2 != 0) goto L_0x003a
            goto L_0x004d
        L_0x003a:
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch:{ RemoteException -> 0x005b }
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzber     // Catch:{ RemoteException -> 0x005b }
            if (r4 == 0) goto L_0x0047
            com.google.android.gms.internal.ads.zzber r3 = (com.google.android.gms.internal.ads.zzber) r3     // Catch:{ RemoteException -> 0x005b }
            goto L_0x004e
        L_0x0047:
            com.google.android.gms.internal.ads.zzbep r3 = new com.google.android.gms.internal.ads.zzbep     // Catch:{ RemoteException -> 0x005b }
            r3.<init>(r2)     // Catch:{ RemoteException -> 0x005b }
            goto L_0x004e
        L_0x004d:
            r3 = r1
        L_0x004e:
            if (r3 == 0) goto L_0x0027
            java.util.List r2 = r5.zzb     // Catch:{ RemoteException -> 0x005b }
            com.google.android.gms.internal.ads.zzbes r4 = new com.google.android.gms.internal.ads.zzbes     // Catch:{ RemoteException -> 0x005b }
            r4.<init>(r3)     // Catch:{ RemoteException -> 0x005b }
            r2.add(r4)     // Catch:{ RemoteException -> 0x005b }
            goto L_0x0027
        L_0x005b:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbzr.zzh(r0, r6)
        L_0x005f:
            com.google.android.gms.internal.ads.zzbgo r6 = r5.zza     // Catch:{ RemoteException -> 0x008e }
            java.util.List r6 = r6.zzv()     // Catch:{ RemoteException -> 0x008e }
            if (r6 == 0) goto L_0x0092
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RemoteException -> 0x008e }
        L_0x006b:
            boolean r2 = r6.hasNext()     // Catch:{ RemoteException -> 0x008e }
            if (r2 == 0) goto L_0x0092
            java.lang.Object r2 = r6.next()     // Catch:{ RemoteException -> 0x008e }
            boolean r3 = r2 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x008e }
            if (r3 == 0) goto L_0x0080
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch:{ RemoteException -> 0x008e }
            com.google.android.gms.ads.internal.client.zzcw r2 = com.google.android.gms.ads.internal.client.zzcv.zzb(r2)     // Catch:{ RemoteException -> 0x008e }
            goto L_0x0081
        L_0x0080:
            r2 = r1
        L_0x0081:
            if (r2 == 0) goto L_0x006b
            java.util.List r3 = r5.zzf     // Catch:{ RemoteException -> 0x008e }
            com.google.android.gms.ads.internal.client.zzcx r4 = new com.google.android.gms.ads.internal.client.zzcx     // Catch:{ RemoteException -> 0x008e }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x008e }
            r3.add(r4)     // Catch:{ RemoteException -> 0x008e }
            goto L_0x006b
        L_0x008e:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbzr.zzh(r0, r6)
        L_0x0092:
            com.google.android.gms.internal.ads.zzbgo r6 = r5.zza     // Catch:{ RemoteException -> 0x00a0 }
            com.google.android.gms.internal.ads.zzber r6 = r6.zzk()     // Catch:{ RemoteException -> 0x00a0 }
            if (r6 == 0) goto L_0x00a4
            com.google.android.gms.internal.ads.zzbes r2 = new com.google.android.gms.internal.ads.zzbes     // Catch:{ RemoteException -> 0x00a0 }
            r2.<init>(r6)     // Catch:{ RemoteException -> 0x00a0 }
            goto L_0x00a5
        L_0x00a0:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbzr.zzh(r0, r6)
        L_0x00a4:
            r2 = r1
        L_0x00a5:
            r5.zzc = r2
            com.google.android.gms.internal.ads.zzbgo r6 = r5.zza     // Catch:{ RemoteException -> 0x00bc }
            com.google.android.gms.internal.ads.zzbej r6 = r6.zzi()     // Catch:{ RemoteException -> 0x00bc }
            if (r6 == 0) goto L_0x00c0
            com.google.android.gms.internal.ads.zzbek r6 = new com.google.android.gms.internal.ads.zzbek     // Catch:{ RemoteException -> 0x00bc }
            com.google.android.gms.internal.ads.zzbgo r2 = r5.zza     // Catch:{ RemoteException -> 0x00bc }
            com.google.android.gms.internal.ads.zzbej r2 = r2.zzi()     // Catch:{ RemoteException -> 0x00bc }
            r6.<init>(r2)     // Catch:{ RemoteException -> 0x00bc }
            r1 = r6
            goto L_0x00c0
        L_0x00bc:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzbzr.zzh(r0, r6)
        L_0x00c0:
            r5.zze = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgp.<init>(com.google.android.gms.internal.ads.zzbgo):void");
    }

    public final void cancelUnconfirmedClick() {
        try {
            this.zza.zzw();
        } catch (RemoteException e2) {
            zzbzr.zzh("Failed to cancelUnconfirmedClick", e2);
        }
    }

    public final void destroy() {
        try {
            this.zza.zzx();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final void enableCustomClickGesture() {
        try {
            this.zza.zzC();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zze;
    }

    public final String getAdvertiser() {
        try {
            return this.zza.zzn();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return null;
        }
    }

    public final String getBody() {
        try {
            return this.zza.zzo();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return null;
        }
    }

    public final String getCallToAction() {
        try {
            return this.zza.zzp();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            Bundle zzf2 = this.zza.zzf();
            if (zzf2 != null) {
                return zzf2;
            }
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
        return new Bundle();
    }

    public final String getHeadline() {
        try {
            return this.zza.zzq();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return null;
        }
    }

    public final NativeAd.Image getIcon() {
        return this.zzc;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    public final MediaContent getMediaContent() {
        try {
            if (this.zza.zzj() != null) {
                return new zzep(this.zza.zzj(), (zzbfl) null);
            }
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
        return null;
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zza.zzr();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return null;
        }
    }

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzf;
    }

    public final String getPrice() {
        try {
            return this.zza.zzs();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return null;
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzdn zzdn;
        try {
            zzdn = this.zza.zzg();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            zzdn = null;
        }
        return ResponseInfo.zza(zzdn);
    }

    public final Double getStarRating() {
        try {
            double zze2 = this.zza.zze();
            if (zze2 == -1.0d) {
                return null;
            }
            return Double.valueOf(zze2);
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return null;
        }
    }

    public final String getStore() {
        try {
            return this.zza.zzt();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zza.zzh() != null) {
                this.zzd.zzb(this.zza.zzh());
            }
        } catch (RemoteException e2) {
            zzbzr.zzh("Exception occurred while getting video controller", e2);
        }
        return this.zzd;
    }

    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zza.zzG();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return false;
        }
    }

    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zza.zzH();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return false;
        }
    }

    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (this.zza.zzH()) {
                if (muteThisAdReason == null) {
                    try {
                        this.zza.zzy((zzcw) null);
                        return;
                    } catch (RemoteException e2) {
                        zzbzr.zzh("", e2);
                        return;
                    }
                } else if (muteThisAdReason instanceof zzcx) {
                    this.zza.zzy(((zzcx) muteThisAdReason).zza());
                    return;
                } else {
                    zzbzr.zzg("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
                    return;
                }
            }
        } catch (RemoteException e3) {
            zzbzr.zzh("", e3);
        }
        zzbzr.zzg("Ad is not custom mute enabled");
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zza.zzz(bundle);
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final void recordCustomClickGesture() {
        try {
            this.zza.zzA();
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zza.zzI(bundle);
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zza.zzB(bundle);
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zza.zzD(new zzct(muteThisAdListener));
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zza.zzE(new zzfe(onPaidEventListener));
        } catch (RemoteException e2) {
            zzbzr.zzh("Failed to setOnPaidEventListener", e2);
        }
    }

    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zza.zzF(new zzbha(unconfirmedClickListener));
        } catch (RemoteException e2) {
            zzbzr.zzh("Failed to setUnconfirmedClickListener", e2);
        }
    }

    public final Object zza() {
        try {
            IObjectWrapper zzl = this.zza.zzl();
            if (zzl != null) {
                return ObjectWrapper.unwrap(zzl);
            }
            return null;
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
            return null;
        }
    }
}
