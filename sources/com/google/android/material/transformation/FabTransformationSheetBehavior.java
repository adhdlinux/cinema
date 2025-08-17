package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$animator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.Positioning;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: g  reason: collision with root package name */
    private Map<View, Integer> f30221g;

    public FabTransformationSheetBehavior() {
    }

    private void c0(View view, boolean z2) {
        boolean z3;
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z2) {
                this.f30221g = new HashMap(childCount);
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (!(childAt.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) || !(((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).f() instanceof FabTransformationScrimBehavior)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (childAt != view && !z3) {
                    if (!z2) {
                        Map<View, Integer> map = this.f30221g;
                        if (map != null && map.containsKey(childAt)) {
                            ViewCompat.C0(childAt, this.f30221g.get(childAt).intValue());
                        }
                    } else {
                        this.f30221g.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        ViewCompat.C0(childAt, 4);
                    }
                }
            }
            if (!z2) {
                this.f30221g = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean G(View view, View view2, boolean z2, boolean z3) {
        c0(view2, z2);
        return super.G(view, view2, z2, z3);
    }

    /* access modifiers changed from: protected */
    public FabTransformationBehavior.FabTransformationSpec a0(Context context, boolean z2) {
        int i2;
        if (z2) {
            i2 = R$animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i2 = R$animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.FabTransformationSpec fabTransformationSpec = new FabTransformationBehavior.FabTransformationSpec();
        fabTransformationSpec.f30214a = MotionSpec.c(context, i2);
        fabTransformationSpec.f30215b = new Positioning(17, 0.0f, 0.0f);
        return fabTransformationSpec;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
