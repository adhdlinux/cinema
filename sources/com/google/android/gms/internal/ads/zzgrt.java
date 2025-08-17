package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzgrt implements Iterator {
    zzgrt() {
    }

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
