package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbdd;
import com.google.android.gms.internal.ads.zzbzg;
import com.google.android.gms.internal.ads.zzbzr;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public abstract class BaseAdView extends ViewGroup {
    @NotOnlyInitialized
    protected final zzea zza;

    protected BaseAdView(Context context, int i2) {
        super(context);
        this.zza = new zzea(this, i2);
    }

    public void destroy() {
        zzbbm.zza(getContext());
        if (((Boolean) zzbdd.zze.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjG)).booleanValue()) {
                zzbzg.zzb.execute(new zze(this));
                return;
            }
        }
        this.zza.zzk();
    }

    public AdListener getAdListener() {
        return this.zza.zza();
    }

    public AdSize getAdSize() {
        return this.zza.zzb();
    }

    public String getAdUnitId() {
        return this.zza.zzj();
    }

    public OnPaidEventListener getOnPaidEventListener() {
        return this.zza.zzc();
    }

    public ResponseInfo getResponseInfo() {
        return this.zza.zzd();
    }

    public boolean isLoading() {
        return this.zza.zzA();
    }

    public void loadAd(AdRequest adRequest) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbm.zza(getContext());
        if (((Boolean) zzbdd.zzf.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjJ)).booleanValue()) {
                zzbzg.zzb.execute(new zzc(this, adRequest));
                return;
            }
        }
        this.zza.zzm(adRequest.zza);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i6 = ((i4 - i2) - measuredWidth) / 2;
            int i7 = ((i5 - i3) - measuredHeight) / 2;
            childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        AdSize adSize;
        int i5 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                adSize = getAdSize();
            } catch (NullPointerException e2) {
                zzbzr.zzh("Unable to retrieve ad size.", e2);
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i4 = adSize.getHeightInPixels(context);
                i5 = widthInPixels;
            } else {
                i4 = 0;
            }
        } else {
            measureChild(childAt, i2, i3);
            i5 = childAt.getMeasuredWidth();
            i4 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i5, getSuggestedMinimumWidth()), i2), View.resolveSize(Math.max(i4, getSuggestedMinimumHeight()), i3));
    }

    public void pause() {
        zzbbm.zza(getContext());
        if (((Boolean) zzbdd.zzg.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjH)).booleanValue()) {
                zzbzg.zzb.execute(new zzd(this));
                return;
            }
        }
        this.zza.zzn();
    }

    public void resume() {
        zzbbm.zza(getContext());
        if (((Boolean) zzbdd.zzh.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjF)).booleanValue()) {
                zzbzg.zzb.execute(new zzf(this));
                return;
            }
        }
        this.zza.zzp();
    }

    public void setAdListener(AdListener adListener) {
        this.zza.zzr(adListener);
        if (adListener == null) {
            this.zza.zzq((zza) null);
            return;
        }
        if (adListener instanceof zza) {
            this.zza.zzq((zza) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.zza.zzv((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zza.zzs(adSize);
    }

    public void setAdUnitId(String str) {
        this.zza.zzu(str);
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zza.zzx(onPaidEventListener);
    }

    protected BaseAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.zza = new zzea(this, attributeSet, false, i2);
    }

    protected BaseAdView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        this.zza = new zzea(this, attributeSet, false, i3);
    }

    protected BaseAdView(Context context, AttributeSet attributeSet, int i2, int i3, boolean z2) {
        super(context, attributeSet, i2);
        this.zza = new zzea(this, attributeSet, z2, i3);
    }

    protected BaseAdView(Context context, AttributeSet attributeSet, boolean z2) {
        super(context, attributeSet);
        this.zza = new zzea(this, attributeSet, z2);
    }
}
