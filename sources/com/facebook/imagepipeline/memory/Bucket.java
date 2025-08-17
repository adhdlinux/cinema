package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Nullsafe;
import java.util.LinkedList;
import java.util.Queue;

@Nullsafe(Nullsafe.Mode.STRICT)
class Bucket<V> {
    private static final String TAG = "BUCKET";
    private final boolean mFixBucketsReinitialization;
    final Queue mFreeList;
    private int mInUseLength;
    public final int mItemSize;
    public final int mMaxLength;

    public Bucket(int i2, int i3, int i4, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5 = true;
        if (i2 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        if (i3 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkState(z4);
        Preconditions.checkState(i4 < 0 ? false : z5);
        this.mItemSize = i2;
        this.mMaxLength = i3;
        this.mFreeList = new LinkedList();
        this.mInUseLength = i4;
        this.mFixBucketsReinitialization = z2;
    }

    /* access modifiers changed from: package-private */
    public void addToFreeList(V v2) {
        this.mFreeList.add(v2);
    }

    public void decrementInUseCount() {
        boolean z2;
        if (this.mInUseLength > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2);
        this.mInUseLength--;
    }

    @Deprecated
    public V get() {
        V pop = pop();
        if (pop != null) {
            this.mInUseLength++;
        }
        return pop;
    }

    /* access modifiers changed from: package-private */
    public int getFreeListSize() {
        return this.mFreeList.size();
    }

    public int getInUseCount() {
        return this.mInUseLength;
    }

    public void incrementInUseCount() {
        this.mInUseLength++;
    }

    public boolean isMaxLengthExceeded() {
        return this.mInUseLength + getFreeListSize() > this.mMaxLength;
    }

    public V pop() {
        return this.mFreeList.poll();
    }

    public void release(V v2) {
        Preconditions.checkNotNull(v2);
        boolean z2 = false;
        if (this.mFixBucketsReinitialization) {
            if (this.mInUseLength > 0) {
                z2 = true;
            }
            Preconditions.checkState(z2);
            this.mInUseLength--;
            addToFreeList(v2);
            return;
        }
        int i2 = this.mInUseLength;
        if (i2 > 0) {
            this.mInUseLength = i2 - 1;
            addToFreeList(v2);
            return;
        }
        FLog.e(TAG, "Tried to release value %s from an empty bucket!", v2);
    }
}
