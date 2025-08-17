package com.facebook.react.common;

import androidx.core.util.Pools$Pool;

public class ClearableSynchronizedPool<T> implements Pools$Pool<T> {
    private final Object[] mPool;
    private int mSize = 0;

    public ClearableSynchronizedPool(int i2) {
        this.mPool = new Object[i2];
    }

    public synchronized T acquire() {
        int i2 = this.mSize;
        if (i2 == 0) {
            return null;
        }
        int i3 = i2 - 1;
        this.mSize = i3;
        T[] tArr = this.mPool;
        T t2 = tArr[i3];
        tArr[i3] = null;
        return t2;
    }

    public synchronized void clear() {
        for (int i2 = 0; i2 < this.mSize; i2++) {
            this.mPool[i2] = null;
        }
        this.mSize = 0;
    }

    public synchronized boolean release(T t2) {
        int i2 = this.mSize;
        Object[] objArr = this.mPool;
        if (i2 == objArr.length) {
            return false;
        }
        objArr[i2] = t2;
        this.mSize = i2 + 1;
        return true;
    }
}
