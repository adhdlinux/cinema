package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.OOMSoftReference;
import com.facebook.infer.annotation.Nullsafe;
import java.util.LinkedList;

@Nullsafe(Nullsafe.Mode.LOCAL)
class OOMSoftReferenceBucket<V> extends Bucket<V> {
    private LinkedList<OOMSoftReference<V>> mSpareReferences = new LinkedList<>();

    public OOMSoftReferenceBucket(int i2, int i3, int i4) {
        super(i2, i3, i4, false);
    }

    /* access modifiers changed from: package-private */
    public void addToFreeList(V v2) {
        OOMSoftReference poll = this.mSpareReferences.poll();
        if (poll == null) {
            poll = new OOMSoftReference();
        }
        poll.set(v2);
        this.mFreeList.add(poll);
    }

    public V pop() {
        OOMSoftReference oOMSoftReference = (OOMSoftReference) this.mFreeList.poll();
        Preconditions.checkNotNull(oOMSoftReference);
        V v2 = oOMSoftReference.get();
        oOMSoftReference.clear();
        this.mSpareReferences.add(oOMSoftReference);
        return v2;
    }
}
