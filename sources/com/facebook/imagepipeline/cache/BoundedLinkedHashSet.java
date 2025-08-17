package com.facebook.imagepipeline.cache;

import com.facebook.infer.annotation.Nullsafe;
import java.util.LinkedHashSet;

@Nullsafe(Nullsafe.Mode.STRICT)
public class BoundedLinkedHashSet<E> {
    private LinkedHashSet<E> mLinkedHashSet;
    private int mMaxSize;

    public BoundedLinkedHashSet(int i2) {
        this.mLinkedHashSet = new LinkedHashSet<>(i2);
        this.mMaxSize = i2;
    }

    public synchronized boolean add(E e2) {
        if (this.mLinkedHashSet.size() == this.mMaxSize) {
            LinkedHashSet<E> linkedHashSet = this.mLinkedHashSet;
            linkedHashSet.remove(linkedHashSet.iterator().next());
        }
        this.mLinkedHashSet.remove(e2);
        return this.mLinkedHashSet.add(e2);
    }

    public synchronized boolean contains(E e2) {
        return this.mLinkedHashSet.contains(e2);
    }
}
