package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;

@Deprecated
public class MediaView extends FrameLayout {
    private MediaContent zza;
    private ImageView.ScaleType zzb;

    public MediaView(Context context) {
        super(context);
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.zzb = scaleType;
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.zza = mediaContent;
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @TargetApi(21)
    public MediaView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }
}
