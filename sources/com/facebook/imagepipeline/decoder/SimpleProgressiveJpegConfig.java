package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Collections;
import java.util.List;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class SimpleProgressiveJpegConfig implements ProgressiveJpegConfig {
    private final DynamicValueConfig mDynamicValueConfig;

    private static class DefaultDynamicValueConfig implements DynamicValueConfig {
        private DefaultDynamicValueConfig() {
        }

        public int getGoodEnoughScanNumber() {
            return 0;
        }

        public List<Integer> getScansToDecode() {
            return Collections.EMPTY_LIST;
        }
    }

    public interface DynamicValueConfig {
        int getGoodEnoughScanNumber();

        List<Integer> getScansToDecode();
    }

    public SimpleProgressiveJpegConfig() {
        this(new DefaultDynamicValueConfig());
    }

    public int getNextScanNumberToDecode(int i2) {
        List<Integer> scansToDecode = this.mDynamicValueConfig.getScansToDecode();
        if (scansToDecode == null || scansToDecode.isEmpty()) {
            return i2 + 1;
        }
        for (int i3 = 0; i3 < scansToDecode.size(); i3++) {
            if (scansToDecode.get(i3).intValue() > i2) {
                return scansToDecode.get(i3).intValue();
            }
        }
        return Integer.MAX_VALUE;
    }

    public QualityInfo getQualityInfo(int i2) {
        boolean z2;
        if (i2 >= this.mDynamicValueConfig.getGoodEnoughScanNumber()) {
            z2 = true;
        } else {
            z2 = false;
        }
        return ImmutableQualityInfo.of(i2, z2, false);
    }

    public SimpleProgressiveJpegConfig(DynamicValueConfig dynamicValueConfig) {
        this.mDynamicValueConfig = (DynamicValueConfig) Preconditions.checkNotNull(dynamicValueConfig);
    }
}
