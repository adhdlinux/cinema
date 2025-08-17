package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.facebook.imageutils.JfifUtil;

class MediaRouteVolumeSlider extends AppCompatSeekBar {

    /* renamed from: b  reason: collision with root package name */
    private final float f10450b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10451c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f10452d;

    /* renamed from: e  reason: collision with root package name */
    private int f10453e;

    /* renamed from: f  reason: collision with root package name */
    private int f10454f;

    public MediaRouteVolumeSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.O);
    }

    public void a(int i2) {
        b(i2, i2);
    }

    public void b(int i2, int i3) {
        if (this.f10453e != i2) {
            if (Color.alpha(i2) != 255) {
                Log.e("MediaRouteVolumeSlider", "Volume slider progress and thumb color cannot be translucent: #" + Integer.toHexString(i2));
            }
            this.f10453e = i2;
        }
        if (this.f10454f != i3) {
            if (Color.alpha(i3) != 255) {
                Log.e("MediaRouteVolumeSlider", "Volume slider background color cannot be translucent: #" + Integer.toHexString(i3));
            }
            this.f10454f = i3;
        }
    }

    public void c(boolean z2) {
        Drawable drawable;
        if (this.f10451c != z2) {
            this.f10451c = z2;
            if (z2) {
                drawable = null;
            } else {
                drawable = this.f10452d;
            }
            super.setThumb(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        int i2;
        super.drawableStateChanged();
        if (isEnabled()) {
            i2 = JfifUtil.MARKER_FIRST_BYTE;
        } else {
            i2 = (int) (this.f10450b * 255.0f);
        }
        this.f10452d.setColorFilter(this.f10453e, PorterDuff.Mode.SRC_IN);
        this.f10452d.setAlpha(i2);
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) getProgressDrawable();
            Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908301);
            layerDrawable.findDrawableByLayerId(16908288).setColorFilter(this.f10454f, PorterDuff.Mode.SRC_IN);
            progressDrawable = findDrawableByLayerId;
        }
        progressDrawable.setColorFilter(this.f10453e, PorterDuff.Mode.SRC_IN);
        progressDrawable.setAlpha(i2);
    }

    public void setThumb(Drawable drawable) {
        this.f10452d = drawable;
        if (this.f10451c) {
            drawable = null;
        }
        super.setThumb(drawable);
    }

    public MediaRouteVolumeSlider(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f10450b = MediaRouterThemeHelper.h(context);
    }
}
