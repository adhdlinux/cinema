package com.google.android.gms.internal.cast;

import java.io.IOException;

public final class zzrs extends IOException {
    zzrs() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzrs(String str, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th);
    }

    zzrs(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
