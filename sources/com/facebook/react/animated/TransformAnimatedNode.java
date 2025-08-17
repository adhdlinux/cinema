package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;

class TransformAnimatedNode extends AnimatedNode {
    private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
    private final List<TransformConfig> mTransformConfigs;

    private class AnimatedTransformConfig extends TransformConfig {
        public int mNodeTag;

        private AnimatedTransformConfig() {
            super();
        }
    }

    private class StaticTransformConfig extends TransformConfig {
        public double mValue;

        private StaticTransformConfig() {
            super();
        }
    }

    private class TransformConfig {
        public String mProperty;

        private TransformConfig() {
        }
    }

    TransformAnimatedNode(ReadableMap readableMap, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        ReadableArray array = readableMap.getArray("transforms");
        this.mTransformConfigs = new ArrayList(array.size());
        for (int i2 = 0; i2 < array.size(); i2++) {
            ReadableMap map = array.getMap(i2);
            String string = map.getString("property");
            if (map.getString("type").equals("animated")) {
                AnimatedTransformConfig animatedTransformConfig = new AnimatedTransformConfig();
                animatedTransformConfig.mProperty = string;
                animatedTransformConfig.mNodeTag = map.getInt("nodeTag");
                this.mTransformConfigs.add(animatedTransformConfig);
            } else {
                StaticTransformConfig staticTransformConfig = new StaticTransformConfig();
                staticTransformConfig.mProperty = string;
                staticTransformConfig.mValue = map.getDouble(AppMeasurementSdk.ConditionalUserProperty.VALUE);
                this.mTransformConfigs.add(staticTransformConfig);
            }
        }
        this.mNativeAnimatedNodesManager = nativeAnimatedNodesManager;
    }

    public void collectViewUpdates(JavaOnlyMap javaOnlyMap) {
        double d2;
        ArrayList arrayList = new ArrayList(this.mTransformConfigs.size());
        for (TransformConfig next : this.mTransformConfigs) {
            if (next instanceof AnimatedTransformConfig) {
                AnimatedNode nodeById = this.mNativeAnimatedNodesManager.getNodeById(((AnimatedTransformConfig) next).mNodeTag);
                if (nodeById == null) {
                    throw new IllegalArgumentException("Mapped style node does not exists");
                } else if (nodeById instanceof ValueAnimatedNode) {
                    d2 = ((ValueAnimatedNode) nodeById).getValue();
                } else {
                    throw new IllegalArgumentException("Unsupported type of node used as a transform child node " + nodeById.getClass());
                }
            } else {
                d2 = ((StaticTransformConfig) next).mValue;
            }
            arrayList.add(JavaOnlyMap.of(next.mProperty, Double.valueOf(d2)));
        }
        javaOnlyMap.putArray(ViewProps.TRANSFORM, JavaOnlyArray.from(arrayList));
    }

    public String prettyPrint() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("TransformAnimatedNode[");
        sb.append(this.mTag);
        sb.append("]: mTransformConfigs: ");
        List<TransformConfig> list = this.mTransformConfigs;
        if (list != null) {
            str = list.toString();
        } else {
            str = "null";
        }
        sb.append(str);
        return sb.toString();
    }
}
