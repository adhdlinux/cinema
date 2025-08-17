package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$attr;

public class AppCompatSeekBar extends SeekBar {
    private final AppCompatSeekBarHelper mAppCompatSeekBarHelper;

    public AppCompatSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.mAppCompatSeekBarHelper.h();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.mAppCompatSeekBarHelper.i();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mAppCompatSeekBarHelper.g(canvas);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.O);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ThemeUtils.a(this, getContext());
        AppCompatSeekBarHelper appCompatSeekBarHelper = new AppCompatSeekBarHelper(this);
        this.mAppCompatSeekBarHelper = appCompatSeekBarHelper;
        appCompatSeekBarHelper.c(attributeSet, i2);
    }
}
