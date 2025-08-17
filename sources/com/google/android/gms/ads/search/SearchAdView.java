package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.internal.ads.zzbzr;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class SearchAdView extends ViewGroup {
    @NotOnlyInitialized
    private final zzea zza;

    public SearchAdView(Context context) {
        super(context);
        this.zza = new zzea(this);
    }

    public void destroy() {
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

    public void loadAd(DynamicHeightSearchAdRequest dynamicHeightSearchAdRequest) {
        if (AdSize.SEARCH.equals(getAdSize())) {
            this.zza.zzm(dynamicHeightSearchAdRequest.zza());
            return;
        }
        throw new IllegalStateException("You must use AdSize.SEARCH for a DynamicHeightSearchAdRequest");
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
        this.zza.zzn();
    }

    public void resume() {
        this.zza.zzp();
    }

    public void setAdListener(AdListener adListener) {
        this.zza.zzr(adListener);
    }

    public void setAdSize(AdSize adSize) {
        this.zza.zzs(adSize);
    }

    public void setAdUnitId(String str) {
        this.zza.zzu(str);
    }

    public SearchAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zza = new zzea(this, attributeSet, false);
    }

    public SearchAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.zza = new zzea(this, attributeSet, false);
    }

    public void loadAd(SearchAdRequest searchAdRequest) {
        this.zza.zzm(searchAdRequest.zza());
    }
}
