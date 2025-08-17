package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Group extends ConstraintHelper {
    public Group(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void b(AttributeSet attributeSet) {
        super.b(attributeSet);
        this.f1994f = false;
    }

    public void c(ConstraintLayout constraintLayout) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f2039l0.y0(0);
        layoutParams.f2039l0.b0(0);
    }

    public void e(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i2 = 0; i2 < this.f1991c; i2++) {
            View e2 = constraintLayout.e(this.f1990b[i2]);
            if (e2 != null) {
                e2.setVisibility(visibility);
                if (elevation > 0.0f) {
                    e2.setElevation(elevation);
                }
            }
        }
    }
}
