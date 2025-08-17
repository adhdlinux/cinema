package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.uwetrottmann.trakt5.TraktV2;
import java.util.concurrent.Executor;

public final class zzdia {
    static final ImageView.ScaleType zza = ImageView.ScaleType.CENTER_INSIDE;
    private final zzg zzb;
    private final zzfai zzc;
    private final zzdhf zzd;
    private final zzdha zze;
    private final zzdim zzf;
    private final zzdiu zzg;
    private final Executor zzh;
    private final Executor zzi;
    private final zzbef zzj;
    private final zzdgx zzk;

    public zzdia(zzg zzg2, zzfai zzfai, zzdhf zzdhf, zzdha zzdha, zzdim zzdim, zzdiu zzdiu, Executor executor, Executor executor2, zzdgx zzdgx) {
        this.zzb = zzg2;
        this.zzc = zzfai;
        this.zzj = zzfai.zzi;
        this.zzd = zzdhf;
        this.zze = zzdha;
        this.zzf = zzdim;
        this.zzg = zzdiu;
        this.zzh = executor;
        this.zzi = executor2;
        this.zzk = zzdgx;
    }

    private static void zzh(RelativeLayout.LayoutParams layoutParams, int i2) {
        if (i2 == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i2 == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i2 != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    private final boolean zzi(ViewGroup viewGroup, boolean z2) {
        View view;
        FrameLayout.LayoutParams layoutParams;
        if (z2) {
            view = this.zze.zzf();
        } else {
            view = this.zze.zzg();
        }
        if (view == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzdA)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(view, layoutParams);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(ViewGroup viewGroup) {
        boolean z2;
        zzdha zzdha = this.zze;
        if (zzdha.zzf() != null) {
            if (viewGroup != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (zzdha.zzc() == 2 || zzdha.zzc() == 1) {
                this.zzb.zzI(this.zzc.zzf, String.valueOf(zzdha.zzc()), z2);
            } else if (zzdha.zzc() == 6) {
                this.zzb.zzI(this.zzc.zzf, TraktV2.API_VERSION, z2);
                this.zzb.zzI(this.zzc.zzf, "1", z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzdiw zzdiw) {
        ViewGroup viewGroup;
        View view;
        ViewGroup viewGroup2;
        zzbeo zza2;
        Drawable drawable;
        Context context = null;
        if (this.zzd.zzf() || this.zzd.zze()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, "3011"};
            int i2 = 0;
            while (true) {
                if (i2 >= 2) {
                    break;
                }
                View zzg2 = zzdiw.zzg(strArr[i2]);
                if (zzg2 != null && (zzg2 instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) zzg2;
                    break;
                }
                i2++;
            }
        }
        viewGroup = null;
        Context context2 = zzdiw.zzf().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        zzdha zzdha = this.zze;
        if (zzdha.zze() != null) {
            view = zzdha.zze();
            zzbef zzbef = this.zzj;
            if (zzbef != null && viewGroup == null) {
                zzh(layoutParams, zzbef.zze);
                view.setLayoutParams(layoutParams);
            }
        } else if (!(zzdha.zzl() instanceof zzbea)) {
            view = null;
        } else {
            zzbea zzbea = (zzbea) zzdha.zzl();
            if (viewGroup == null) {
                zzh(layoutParams, zzbea.zzc());
            }
            zzbeb zzbeb = new zzbeb(context2, zzbea, layoutParams);
            zzbeb.setContentDescription((CharSequence) zzba.zzc().zzb(zzbbm.zzdy));
            view = zzbeb;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                zza zza3 = new zza(zzdiw.zzf().getContext());
                zza3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                zza3.addView(view);
                FrameLayout zzh2 = zzdiw.zzh();
                if (zzh2 != null) {
                    zzh2.addView(zza3);
                }
            }
            zzdiw.zzq(zzdiw.zzk(), view, true);
        }
        zzfsc zzfsc = zzdhw.zza;
        int size = zzfsc.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                viewGroup2 = null;
                break;
            }
            View zzg3 = zzdiw.zzg((String) zzfsc.get(i3));
            i3++;
            if (zzg3 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) zzg3;
                break;
            }
        }
        this.zzi.execute(new zzdhx(this, viewGroup2));
        if (viewGroup2 != null) {
            if (zzi(viewGroup2, true)) {
                zzdha zzdha2 = this.zze;
                if (zzdha2.zzr() != null) {
                    zzdha2.zzr().zzao(new zzdhz(zzdiw, viewGroup2));
                    return;
                }
                return;
            }
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjg)).booleanValue() || !zzi(viewGroup2, false)) {
                viewGroup2.removeAllViews();
                View zzf2 = zzdiw.zzf();
                if (zzf2 != null) {
                    context = zzf2.getContext();
                }
                if (context != null && (zza2 = this.zzk.zza()) != null) {
                    try {
                        IObjectWrapper zzi2 = zza2.zzi();
                        if (zzi2 != null && (drawable = (Drawable) ObjectWrapper.unwrap(zzi2)) != null) {
                            ImageView imageView = new ImageView(context);
                            imageView.setImageDrawable(drawable);
                            IObjectWrapper zzj2 = zzdiw.zzj();
                            if (zzj2 != null) {
                                if (((Boolean) zzba.zzc().zzb(zzbbm.zzfV)).booleanValue()) {
                                    imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(zzj2));
                                    imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                    viewGroup2.addView(imageView);
                                }
                            }
                            imageView.setScaleType(zza);
                            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                            viewGroup2.addView(imageView);
                        }
                    } catch (RemoteException unused) {
                        zzbzr.zzj("Could not get main image drawable");
                    }
                }
            } else {
                zzdha zzdha3 = this.zze;
                if (zzdha3.zzp() != null) {
                    zzdha3.zzp().zzao(new zzdhz(zzdiw, viewGroup2));
                }
            }
        }
    }

    public final void zzc(zzdiw zzdiw) {
        if (zzdiw != null && this.zzf != null && zzdiw.zzh() != null && this.zzd.zzg()) {
            try {
                zzdiw.zzh().addView(this.zzf.zza());
            } catch (zzcfk e2) {
                zze.zzb("web view can not be obtained", e2);
            }
        }
    }

    public final void zzd(zzdiw zzdiw) {
        if (zzdiw != null) {
            Context context = zzdiw.zzf().getContext();
            if (zzbx.zzh(context, this.zzd.zza)) {
                if (!(context instanceof Activity)) {
                    zzbzr.zze("Activity context is needed for policy validator.");
                } else if (this.zzg != null && zzdiw.zzh() != null) {
                    try {
                        WindowManager windowManager = (WindowManager) context.getSystemService("window");
                        windowManager.addView(this.zzg.zza(zzdiw.zzh(), windowManager), zzbx.zzb());
                    } catch (zzcfk e2) {
                        zze.zzb("web view can not be obtained", e2);
                    }
                }
            }
        }
    }

    public final void zze(zzdiw zzdiw) {
        this.zzh.execute(new zzdhy(this, zzdiw));
    }

    public final boolean zzf(ViewGroup viewGroup) {
        return zzi(viewGroup, false);
    }

    public final boolean zzg(ViewGroup viewGroup) {
        return zzi(viewGroup, true);
    }
}
