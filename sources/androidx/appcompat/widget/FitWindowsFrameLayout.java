package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FitWindowsFrameLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private FitWindowsViewGroup$OnFitSystemWindowsListener f1273b;

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        FitWindowsViewGroup$OnFitSystemWindowsListener fitWindowsViewGroup$OnFitSystemWindowsListener = this.f1273b;
        if (fitWindowsViewGroup$OnFitSystemWindowsListener != null) {
            fitWindowsViewGroup$OnFitSystemWindowsListener.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(FitWindowsViewGroup$OnFitSystemWindowsListener fitWindowsViewGroup$OnFitSystemWindowsListener) {
        this.f1273b = fitWindowsViewGroup$OnFitSystemWindowsListener;
    }
}
