package com.google.android.exoplayer2.source.chunk;

import java.util.NoSuchElementException;

public interface MediaChunkIterator {

    /* renamed from: a  reason: collision with root package name */
    public static final MediaChunkIterator f26130a = new MediaChunkIterator() {
        public long a() {
            throw new NoSuchElementException();
        }

        public long b() {
            throw new NoSuchElementException();
        }

        public boolean next() {
            return false;
        }
    };

    long a();

    long b();

    boolean next();
}
