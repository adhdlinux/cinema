package com.facebook.react.views.text;

public class ReactTagSpan implements ReactSpan {
    private final int mReactTag;

    public ReactTagSpan(int i2) {
        this.mReactTag = i2;
    }

    public int getReactTag() {
        return this.mReactTag;
    }
}
