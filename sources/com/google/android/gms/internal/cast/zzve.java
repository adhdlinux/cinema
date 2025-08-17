package com.google.android.gms.internal.cast;

final class zzve extends IllegalArgumentException {
    zzve(int i2, int i3) {
        super("Unpaired surrogate at index " + i2 + " of " + i3);
    }
}
