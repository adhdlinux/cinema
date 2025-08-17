package com.facebook.ads.internal.view.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.ads.internal.q.a.j;
import com.facebook.ads.internal.q.a.x;

public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f20914a;

    /* renamed from: b  reason: collision with root package name */
    private int f20915b;

    /* renamed from: c  reason: collision with root package name */
    private int f20916c;

    public b(Context context) {
        super(context);
        this.f20914a = new ImageView(context);
        a();
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20914a = new ImageView(context, attributeSet);
        a();
    }

    public b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20914a = new ImageView(context, attributeSet, i2);
        a();
    }

    @TargetApi(21)
    public b(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f20914a = new ImageView(context, attributeSet, i2, i3);
        a();
    }

    private void a() {
        this.f20914a.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f20914a, new FrameLayout.LayoutParams(-2, -2));
        j.a(this.f20914a, j.INTERNAL_AD_MEDIA);
    }

    public void a(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            x.a((View) this, (Drawable) new BitmapDrawable(getContext().getResources(), bitmap2));
        } else {
            x.a((View) this, 0);
        }
        if (bitmap != null) {
            this.f20915b = bitmap.getWidth();
            this.f20916c = bitmap.getHeight();
            this.f20914a.setImageBitmap(Bitmap.createBitmap(bitmap));
            return;
        }
        this.f20914a.setImageDrawable((Drawable) null);
    }

    public ImageView getBodyImageView() {
        return this.f20914a;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i4 - i2;
        int i8 = i5 - i3;
        int i9 = this.f20915b;
        if (i9 <= 0 || (i6 = this.f20916c) <= 0) {
            super.onLayout(z2, i2, i3, i4, i5);
            return;
        }
        float min = Math.min(((float) i7) / ((float) i9), ((float) i8) / ((float) i6));
        int i10 = i2 + (i7 / 2);
        int i11 = i3 + (i8 / 2);
        int i12 = ((int) (((float) this.f20915b) * min)) / 2;
        int i13 = ((int) (min * ((float) this.f20916c))) / 2;
        this.f20914a.layout(i10 - i12, i11 - i13, i10 + i12, i11 + i13);
    }
}
