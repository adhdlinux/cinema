package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzgoq extends IOException {
    zzgoq() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzgoq(String str, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.valueOf(str)), th);
    }

    zzgoq(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
