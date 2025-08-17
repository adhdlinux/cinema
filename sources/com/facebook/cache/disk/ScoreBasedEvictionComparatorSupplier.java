package com.facebook.cache.disk;

import com.facebook.cache.disk.DiskStorage;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ScoreBasedEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {
    private final float mAgeWeight;
    private final float mSizeWeight;

    public ScoreBasedEvictionComparatorSupplier(float f2, float f3) {
        this.mAgeWeight = f2;
        this.mSizeWeight = f3;
    }

    /* access modifiers changed from: package-private */
    public float calculateScore(DiskStorage.Entry entry, long j2) {
        return (this.mAgeWeight * ((float) (j2 - entry.getTimestamp()))) + (this.mSizeWeight * ((float) entry.getSize()));
    }

    public EntryEvictionComparator get() {
        return new EntryEvictionComparator() {
            long now = System.currentTimeMillis();

            public int compare(DiskStorage.Entry entry, DiskStorage.Entry entry2) {
                float calculateScore = ScoreBasedEvictionComparatorSupplier.this.calculateScore(entry, this.now);
                float calculateScore2 = ScoreBasedEvictionComparatorSupplier.this.calculateScore(entry2, this.now);
                if (calculateScore < calculateScore2) {
                    return 1;
                }
                return calculateScore2 == calculateScore ? 0 : -1;
            }
        };
    }
}
