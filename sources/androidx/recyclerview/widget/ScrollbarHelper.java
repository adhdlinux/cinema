package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class ScrollbarHelper {
    private ScrollbarHelper() {
    }

    static int a(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z2) {
        if (layoutManager.getChildCount() == 0 || state.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1;
        }
        return Math.min(orientationHelper.n(), orientationHelper.d(view2) - orientationHelper.g(view));
    }

    static int b(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z2, boolean z3) {
        int i2;
        if (layoutManager.getChildCount() == 0 || state.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        int max = Math.max(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        if (z3) {
            i2 = Math.max(0, (state.b() - max) - 1);
        } else {
            i2 = Math.max(0, min);
        }
        if (!z2) {
            return i2;
        }
        return Math.round((((float) i2) * (((float) Math.abs(orientationHelper.d(view2) - orientationHelper.g(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1)))) + ((float) (orientationHelper.m() - orientationHelper.g(view))));
    }

    static int c(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z2) {
        if (layoutManager.getChildCount() == 0 || state.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return state.b();
        }
        return (int) ((((float) (orientationHelper.d(view2) - orientationHelper.g(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1))) * ((float) state.b()));
    }
}
