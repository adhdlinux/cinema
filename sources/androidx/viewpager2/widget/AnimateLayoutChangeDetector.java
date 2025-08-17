package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

final class AnimateLayoutChangeDetector {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f11994b;

    /* renamed from: a  reason: collision with root package name */
    private LinearLayoutManager f11995a;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f11994b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    AnimateLayoutChangeDetector(LinearLayoutManager linearLayoutManager) {
        this.f11995a = linearLayoutManager;
    }

    private boolean a() {
        boolean z2;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i2;
        int i3;
        int i4;
        int i5;
        int childCount = this.f11995a.getChildCount();
        if (childCount == 0) {
            return true;
        }
        if (this.f11995a.getOrientation() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = childCount;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = this.f11995a.getChildAt(i6);
            if (childAt != null) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = f11994b;
                }
                int[] iArr3 = iArr2[i6];
                if (z2) {
                    i3 = childAt.getLeft();
                    i2 = marginLayoutParams.leftMargin;
                } else {
                    i3 = childAt.getTop();
                    i2 = marginLayoutParams.topMargin;
                }
                iArr3[0] = i3 - i2;
                int[] iArr4 = iArr2[i6];
                if (z2) {
                    i5 = childAt.getRight();
                    i4 = marginLayoutParams.rightMargin;
                } else {
                    i5 = childAt.getBottom();
                    i4 = marginLayoutParams.bottomMargin;
                }
                iArr4[1] = i5 + i4;
                i6++;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr2, new Comparator<int[]>() {
            /* renamed from: a */
            public int compare(int[] iArr, int[] iArr2) {
                return iArr[0] - iArr2[0];
            }
        });
        for (int i7 = 1; i7 < childCount; i7++) {
            if (iArr2[i7 - 1][1] != iArr2[i7][0]) {
                return false;
            }
        }
        int[] iArr5 = iArr2[0];
        int i8 = iArr5[1];
        int i9 = iArr5[0];
        int i10 = i8 - i9;
        if (i9 > 0 || iArr2[childCount - 1][1] < i10) {
            return false;
        }
        return true;
    }

    private boolean b() {
        int childCount = this.f11995a.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (c(this.f11995a.getChildAt(i2))) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (c(viewGroup.getChildAt(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        if ((!a() || this.f11995a.getChildCount() <= 1) && b()) {
            return true;
        }
        return false;
    }
}
