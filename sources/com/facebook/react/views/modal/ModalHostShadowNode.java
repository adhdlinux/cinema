package com.facebook.react.views.modal;

import android.graphics.Point;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;

class ModalHostShadowNode extends LayoutShadowNode {
    public void addChildAt(ReactShadowNodeImpl reactShadowNodeImpl, int i2) {
        super.addChildAt(reactShadowNodeImpl, i2);
        Point modalHostSize = ModalHostHelper.getModalHostSize(getThemedContext());
        reactShadowNodeImpl.setStyleWidth((float) modalHostSize.x);
        reactShadowNodeImpl.setStyleHeight((float) modalHostSize.y);
    }
}
