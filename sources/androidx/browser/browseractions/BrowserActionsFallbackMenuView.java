package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.browser.R$dimen;

@Deprecated
public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    private final int f1583b = getResources().getDimensionPixelOffset(R$dimen.f1582b);

    /* renamed from: c  reason: collision with root package name */
    private final int f1584c = getResources().getDimensionPixelOffset(R$dimen.f1581a);

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f1583b * 2), this.f1584c), 1073741824), i3);
    }
}
