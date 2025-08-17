package com.facebook.react.views.text;

import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ReactRawTextShadowNode extends ReactShadowNodeImpl {
    @VisibleForTesting
    public static final String PROP_TEXT = "text";
    private String mText = null;

    public String getText() {
        return this.mText;
    }

    public boolean isVirtual() {
        return true;
    }

    @ReactProp(name = "text")
    public void setText(String str) {
        this.mText = str;
        markUpdated();
    }

    public String toString() {
        return getViewClass() + " [text: " + this.mText + "]";
    }
}
