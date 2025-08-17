package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

class MultiplicationAnimatedNode extends ValueAnimatedNode {
    private final int[] mInputNodes;
    private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;

    public MultiplicationAnimatedNode(ReadableMap readableMap, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        this.mNativeAnimatedNodesManager = nativeAnimatedNodesManager;
        ReadableArray array = readableMap.getArray("input");
        this.mInputNodes = new int[array.size()];
        int i2 = 0;
        while (true) {
            int[] iArr = this.mInputNodes;
            if (i2 < iArr.length) {
                iArr[i2] = array.getInt(i2);
                i2++;
            } else {
                return;
            }
        }
    }

    public String prettyPrint() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("MultiplicationAnimatedNode[");
        sb.append(this.mTag);
        sb.append("]: input nodes: ");
        int[] iArr = this.mInputNodes;
        if (iArr != null) {
            str = iArr.toString();
        } else {
            str = "null";
        }
        sb.append(str);
        sb.append(" - super: ");
        sb.append(super.prettyPrint());
        return sb.toString();
    }

    public void update() {
        this.mValue = 1.0d;
        int i2 = 0;
        while (true) {
            int[] iArr = this.mInputNodes;
            if (i2 < iArr.length) {
                AnimatedNode nodeById = this.mNativeAnimatedNodesManager.getNodeById(iArr[i2]);
                if (nodeById != null && (nodeById instanceof ValueAnimatedNode)) {
                    this.mValue *= ((ValueAnimatedNode) nodeById).getValue();
                    i2++;
                }
            } else {
                return;
            }
        }
        throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.multiply node");
    }
}
