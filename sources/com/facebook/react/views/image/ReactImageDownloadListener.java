package com.facebook.react.views.image;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ForwardingDrawable;

public class ReactImageDownloadListener<INFO> extends ForwardingDrawable implements ControllerListener<INFO> {
    private static final int MAX_LEVEL = 10000;

    private static final class EmptyDrawable extends Drawable {
        private EmptyDrawable() {
        }

        public void draw(Canvas canvas) {
        }

        public int getOpacity() {
            return -1;
        }

        public void setAlpha(int i2) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public ReactImageDownloadListener() {
        super(new EmptyDrawable());
    }

    public void onFailure(String str, Throwable th) {
    }

    public void onFinalImageSet(String str, INFO info, Animatable animatable) {
    }

    public void onIntermediateImageFailed(String str, Throwable th) {
    }

    public void onIntermediateImageSet(String str, INFO info) {
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        onProgressChange(i2, MAX_LEVEL);
        return super.onLevelChange(i2);
    }

    public void onProgressChange(int i2, int i3) {
    }

    public void onRelease(String str) {
    }

    public void onSubmit(String str, Object obj) {
    }
}
