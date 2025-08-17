package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Nullsafe(Nullsafe.Mode.STRICT)
public class CountingLruMap<K, V> {
    private final LinkedHashMap<K, V> mMap = new LinkedHashMap<>();
    private int mSizeInBytes = 0;
    private final ValueDescriptor<V> mValueDescriptor;

    public CountingLruMap(ValueDescriptor<V> valueDescriptor) {
        this.mValueDescriptor = valueDescriptor;
    }

    private int getValueSizeInBytes(V v2) {
        if (v2 == null) {
            return 0;
        }
        return this.mValueDescriptor.getSizeInBytes(v2);
    }

    public synchronized ArrayList<V> clear() {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>(this.mMap.values());
        this.mMap.clear();
        this.mSizeInBytes = 0;
        return arrayList;
    }

    public synchronized boolean contains(K k2) {
        return this.mMap.containsKey(k2);
    }

    public synchronized V get(K k2) {
        return this.mMap.get(k2);
    }

    public synchronized int getCount() {
        return this.mMap.size();
    }

    public synchronized K getFirstKey() {
        K k2;
        if (this.mMap.isEmpty()) {
            k2 = null;
        } else {
            k2 = this.mMap.keySet().iterator().next();
        }
        return k2;
    }

    /* access modifiers changed from: package-private */
    public synchronized ArrayList<K> getKeys() {
        return new ArrayList<>(this.mMap.keySet());
    }

    public synchronized ArrayList<Map.Entry<K, V>> getMatchingEntries(Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.mMap.entrySet().size());
        for (Map.Entry next : this.mMap.entrySet()) {
            if (predicate == null || predicate.apply(next.getKey())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public synchronized int getSizeInBytes() {
        return this.mSizeInBytes;
    }

    /* access modifiers changed from: package-private */
    public synchronized ArrayList<V> getValues() {
        return new ArrayList<>(this.mMap.values());
    }

    public synchronized V put(K k2, V v2) {
        V remove;
        remove = this.mMap.remove(k2);
        this.mSizeInBytes -= getValueSizeInBytes(remove);
        this.mMap.put(k2, v2);
        this.mSizeInBytes += getValueSizeInBytes(v2);
        return remove;
    }

    public synchronized V remove(K k2) {
        V remove;
        remove = this.mMap.remove(k2);
        this.mSizeInBytes -= getValueSizeInBytes(remove);
        return remove;
    }

    public synchronized ArrayList<V> removeAll(Predicate<K> predicate) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it2 = this.mMap.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            if (predicate == null || predicate.apply(next.getKey())) {
                arrayList.add(next.getValue());
                this.mSizeInBytes -= getValueSizeInBytes(next.getValue());
                it2.remove();
            }
        }
        return arrayList;
    }
}
