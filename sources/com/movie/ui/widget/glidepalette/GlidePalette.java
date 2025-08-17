package com.movie.ui.widget.glidepalette;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.movie.ui.widget.glidepalette.BitmapPalette;

public class GlidePalette<TranscodeType> extends BitmapPalette implements RequestListener<TranscodeType> {

    /* renamed from: f  reason: collision with root package name */
    protected RequestListener<TranscodeType> f33679f;

    public interface BitmapHolder {
        Bitmap a();
    }

    protected GlidePalette() {
    }

    public static GlidePalette<Drawable> h(String str) {
        GlidePalette<Drawable> glidePalette = new GlidePalette<>();
        glidePalette.f33673a = str;
        return glidePalette;
    }

    public GlidePalette<TranscodeType> g(BitmapPalette.CallBack callBack) {
        super.e(callBack);
        return this;
    }

    public boolean onLoadFailed(GlideException glideException, Object obj, Target<TranscodeType> target, boolean z2) {
        RequestListener<TranscodeType> requestListener = this.f33679f;
        return requestListener != null && requestListener.onLoadFailed(glideException, obj, target, z2);
    }

    public boolean onResourceReady(TranscodeType transcodetype, Object obj, Target<TranscodeType> target, DataSource dataSource, boolean z2) {
        boolean z3;
        Bitmap bitmap;
        RequestListener<TranscodeType> requestListener = this.f33679f;
        if (requestListener == null || !requestListener.onResourceReady(transcodetype, obj, target, dataSource, z2)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (transcodetype instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) transcodetype).getBitmap();
        } else if (transcodetype instanceof GifDrawable) {
            bitmap = ((GifDrawable) transcodetype).e();
        } else if (target instanceof BitmapHolder) {
            bitmap = ((BitmapHolder) target).a();
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            f(bitmap);
        }
        return z3;
    }
}
