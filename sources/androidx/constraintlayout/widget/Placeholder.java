package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.imageutils.JfifUtil;
import com.vungle.ads.internal.protos.Sdk$SDKError;

public class Placeholder extends View {

    /* renamed from: b  reason: collision with root package name */
    private int f2121b = -1;

    /* renamed from: c  reason: collision with root package name */
    private View f2122c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f2123d = 4;

    public Placeholder(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        super.setVisibility(this.f2123d);
        this.f2121b = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.f2149i0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R$styleable.f2152j0) {
                    this.f2121b = obtainStyledAttributes.getResourceId(index, this.f2121b);
                } else if (index == R$styleable.f2155k0) {
                    this.f2123d = obtainStyledAttributes.getInt(index, this.f2123d);
                }
            }
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f2122c != null) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f2122c.getLayoutParams();
            layoutParams2.f2039l0.x0(0);
            layoutParams.f2039l0.y0(layoutParams2.f2039l0.D());
            layoutParams.f2039l0.b0(layoutParams2.f2039l0.r());
            layoutParams2.f2039l0.x0(8);
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        if (this.f2121b == -1 && !isInEditMode()) {
            setVisibility(this.f2123d);
        }
        View findViewById = constraintLayout.findViewById(this.f2121b);
        this.f2122c = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.LayoutParams) findViewById.getLayoutParams()).f2017a0 = true;
            this.f2122c.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f2122c;
    }

    public int getEmptyVisibility() {
        return this.f2123d;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(Sdk$SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, Sdk$SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, Sdk$SDKError.Reason.STALE_CACHED_RESPONSE_VALUE);
            Paint paint = new Paint();
            paint.setARGB(JfifUtil.MARKER_FIRST_BYTE, Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE, Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE, Sdk$SDKError.Reason.AD_NOT_LOADED_VALUE);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i2) {
        View findViewById;
        if (this.f2121b != i2) {
            View view = this.f2122c;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.LayoutParams) this.f2122c.getLayoutParams()).f2017a0 = false;
                this.f2122c = null;
            }
            this.f2121b = i2;
            if (i2 != -1 && (findViewById = ((View) getParent()).findViewById(i2)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i2) {
        this.f2123d = i2;
    }
}
