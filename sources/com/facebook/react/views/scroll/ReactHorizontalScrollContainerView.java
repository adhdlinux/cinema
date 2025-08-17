package com.facebook.react.views.scroll;

import android.content.Context;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.views.view.ReactViewGroup;

public class ReactHorizontalScrollContainerView extends ReactViewGroup {
    private int mCurrentWidth = 0;
    private int mLayoutDirection;

    public ReactHorizontalScrollContainerView(Context context) {
        super(context);
        this.mLayoutDirection = I18nUtil.getInstance().isRTL(context) ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        if (this.mLayoutDirection == 1) {
            setLeft(0);
            setRight((i4 - i2) + 0);
            if (this.mCurrentWidth != getWidth()) {
                ReactHorizontalScrollView reactHorizontalScrollView = (ReactHorizontalScrollView) getParent();
                reactHorizontalScrollView.scrollTo(((reactHorizontalScrollView.getScrollX() + getWidth()) - this.mCurrentWidth) - reactHorizontalScrollView.getWidth(), reactHorizontalScrollView.getScrollY());
            }
        }
        this.mCurrentWidth = getWidth();
    }

    public void setRemoveClippedSubviews(boolean z2) {
        if (this.mLayoutDirection == 1) {
            super.setRemoveClippedSubviews(false);
        } else {
            super.setRemoveClippedSubviews(z2);
        }
    }
}
