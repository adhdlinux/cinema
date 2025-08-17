package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class ActionBarBackgroundDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f964a;

    private static class Api21Impl {
        private Api21Impl() {
        }

        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.f964a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f964a;
        if (actionBarContainer.f972i) {
            Drawable drawable = actionBarContainer.f971h;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f969f;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f964a;
        Drawable drawable3 = actionBarContainer2.f970g;
        if (drawable3 != null && actionBarContainer2.f973j) {
            drawable3.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f964a;
        if (!actionBarContainer.f972i) {
            Drawable drawable = actionBarContainer.f969f;
            if (drawable != null) {
                Api21Impl.a(drawable, outline);
            }
        } else if (actionBarContainer.f971h != null) {
            Api21Impl.a(actionBarContainer.f969f, outline);
        }
    }

    public void setAlpha(int i2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
