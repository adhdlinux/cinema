package com.facebook.imagepipeline.memory;

import android.util.SparseArray;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.infer.annotation.ThreadSafe;
import java.util.LinkedList;

@Nullsafe(Nullsafe.Mode.STRICT)
@ThreadSafe
public class BucketMap<T> {
    LinkedEntry<T> mHead;
    protected final SparseArray<LinkedEntry<T>> mMap = new SparseArray<>();
    LinkedEntry<T> mTail;

    static class LinkedEntry<I> {
        int key;
        LinkedEntry<I> next;
        LinkedEntry<I> prev;
        LinkedList<I> value;

        public String toString() {
            return "LinkedEntry(key: " + this.key + ")";
        }

        private LinkedEntry(LinkedEntry<I> linkedEntry, int i2, LinkedList<I> linkedList, LinkedEntry<I> linkedEntry2) {
            this.prev = linkedEntry;
            this.key = i2;
            this.value = linkedList;
            this.next = linkedEntry2;
        }
    }

    private void maybePrune(LinkedEntry<T> linkedEntry) {
        if (linkedEntry != null && linkedEntry.value.isEmpty()) {
            prune(linkedEntry);
            this.mMap.remove(linkedEntry.key);
        }
    }

    private void moveToFront(LinkedEntry<T> linkedEntry) {
        if (this.mHead != linkedEntry) {
            prune(linkedEntry);
            LinkedEntry<T> linkedEntry2 = this.mHead;
            if (linkedEntry2 == null) {
                this.mHead = linkedEntry;
                this.mTail = linkedEntry;
                return;
            }
            linkedEntry.next = linkedEntry2;
            linkedEntry2.prev = linkedEntry;
            this.mHead = linkedEntry;
        }
    }

    private synchronized void prune(LinkedEntry<T> linkedEntry) {
        LinkedEntry<I> linkedEntry2 = linkedEntry.prev;
        LinkedEntry<I> linkedEntry3 = linkedEntry.next;
        if (linkedEntry2 != null) {
            linkedEntry2.next = linkedEntry3;
        }
        if (linkedEntry3 != null) {
            linkedEntry3.prev = linkedEntry2;
        }
        linkedEntry.prev = null;
        linkedEntry.next = null;
        if (linkedEntry == this.mHead) {
            this.mHead = linkedEntry3;
        }
        if (linkedEntry == this.mTail) {
            this.mTail = linkedEntry2;
        }
    }

    public synchronized T acquire(int i2) {
        LinkedEntry linkedEntry = this.mMap.get(i2);
        if (linkedEntry == null) {
            return null;
        }
        T pollFirst = linkedEntry.value.pollFirst();
        moveToFront(linkedEntry);
        return pollFirst;
    }

    public synchronized void release(int i2, T t2) {
        LinkedEntry linkedEntry = this.mMap.get(i2);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry((LinkedEntry) null, i2, new LinkedList(), (LinkedEntry) null);
            this.mMap.put(i2, linkedEntry);
        }
        linkedEntry.value.addLast(t2);
        moveToFront(linkedEntry);
    }

    public synchronized T removeFromEnd() {
        LinkedEntry<T> linkedEntry = this.mTail;
        if (linkedEntry == null) {
            return null;
        }
        T pollLast = linkedEntry.value.pollLast();
        maybePrune(linkedEntry);
        return pollLast;
    }

    /* access modifiers changed from: package-private */
    public synchronized int valueCount() {
        int i2;
        i2 = 0;
        for (LinkedEntry linkedEntry = this.mHead; linkedEntry != null; linkedEntry = linkedEntry.next) {
            LinkedList<I> linkedList = linkedEntry.value;
            if (linkedList != null) {
                i2 += linkedList.size();
            }
        }
        return i2;
    }
}
