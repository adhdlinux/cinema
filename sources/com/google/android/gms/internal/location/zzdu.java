package com.google.android.gms.internal.location;

import java.util.Iterator;

public abstract class zzdu implements Iterator {
    protected zzdu() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
