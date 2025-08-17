package com.google.android.exoplayer2.text;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

public final class CueDecoder {
    public ImmutableList<Cue> a(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        Bundle readBundle = obtain.readBundle(Bundle.class.getClassLoader());
        obtain.recycle();
        return BundleableUtil.b(Cue.K, (ArrayList) Assertions.e(readBundle.getParcelableArrayList("c")));
    }
}
