package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f30192a = 0;

    public ExpandableBehavior() {
    }

    private boolean E(boolean z2) {
        if (z2) {
            int i2 = this.f30192a;
            if (i2 == 0 || i2 == 2) {
                return true;
            }
            return false;
        } else if (this.f30192a == 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public ExpandableWidget F(CoordinatorLayout coordinatorLayout, View view) {
        List<View> r2 = coordinatorLayout.r(view);
        int size = r2.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = r2.get(i2);
            if (e(coordinatorLayout, view, view2)) {
                return (ExpandableWidget) view2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract boolean G(View view, View view2, boolean z2, boolean z3);

    public abstract boolean e(CoordinatorLayout coordinatorLayout, View view, View view2);

    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        int i2;
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        if (!E(expandableWidget.a())) {
            return false;
        }
        if (expandableWidget.a()) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        this.f30192a = i2;
        return G((View) expandableWidget, view, expandableWidget.a(), true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r3 = F(r3, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean l(androidx.coordinatorlayout.widget.CoordinatorLayout r3, final android.view.View r4, int r5) {
        /*
            r2 = this;
            boolean r5 = androidx.core.view.ViewCompat.V(r4)
            if (r5 != 0) goto L_0x002d
            com.google.android.material.expandable.ExpandableWidget r3 = r2.F(r3, r4)
            if (r3 == 0) goto L_0x002d
            boolean r5 = r3.a()
            boolean r5 = r2.E(r5)
            if (r5 == 0) goto L_0x002d
            boolean r5 = r3.a()
            if (r5 == 0) goto L_0x001e
            r5 = 1
            goto L_0x001f
        L_0x001e:
            r5 = 2
        L_0x001f:
            r2.f30192a = r5
            android.view.ViewTreeObserver r0 = r4.getViewTreeObserver()
            com.google.android.material.transformation.ExpandableBehavior$1 r1 = new com.google.android.material.transformation.ExpandableBehavior$1
            r1.<init>(r4, r5, r3)
            r0.addOnPreDrawListener(r1)
        L_0x002d:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transformation.ExpandableBehavior.l(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
