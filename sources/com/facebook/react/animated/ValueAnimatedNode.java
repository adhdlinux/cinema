package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

class ValueAnimatedNode extends AnimatedNode {
    Object mAnimatedObject = null;
    double mOffset = 0.0d;
    double mValue = Double.NaN;
    private AnimatedNodeValueListener mValueListener;

    public ValueAnimatedNode() {
    }

    public void extractOffset() {
        this.mOffset += this.mValue;
        this.mValue = 0.0d;
    }

    public void flattenOffset() {
        this.mValue += this.mOffset;
        this.mOffset = 0.0d;
    }

    public Object getAnimatedObject() {
        return this.mAnimatedObject;
    }

    public double getValue() {
        if (Double.isNaN(this.mOffset + this.mValue)) {
            update();
        }
        return this.mOffset + this.mValue;
    }

    public void onValueUpdate() {
        AnimatedNodeValueListener animatedNodeValueListener = this.mValueListener;
        if (animatedNodeValueListener != null) {
            animatedNodeValueListener.onValueUpdate(getValue());
        }
    }

    public String prettyPrint() {
        return "ValueAnimatedNode[" + this.mTag + "]: value: " + this.mValue + " offset: " + this.mOffset;
    }

    public void setValueListener(AnimatedNodeValueListener animatedNodeValueListener) {
        this.mValueListener = animatedNodeValueListener;
    }

    public ValueAnimatedNode(ReadableMap readableMap) {
        this.mValue = readableMap.getDouble(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        this.mOffset = readableMap.getDouble("offset");
    }
}
