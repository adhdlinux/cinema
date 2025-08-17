package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.R$attr;

public class AppCompatRatingBar extends RatingBar {

    /* renamed from: b  reason: collision with root package name */
    private final AppCompatProgressBarHelper f1160b;

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.M);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Bitmap b2 = this.f1160b.b();
        if (b2 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b2.getWidth() * getNumStars(), i2, 0), getMeasuredHeight());
        }
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ThemeUtils.a(this, getContext());
        AppCompatProgressBarHelper appCompatProgressBarHelper = new AppCompatProgressBarHelper(this);
        this.f1160b = appCompatProgressBarHelper;
        appCompatProgressBarHelper.c(attributeSet, i2);
    }
}
