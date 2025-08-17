package com.google.android.exoplayer2.text;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.exoplayer2.util.BundleableUtil;
import java.util.ArrayList;
import java.util.List;

public final class CueEncoder {
    public byte[] a(List<Cue> list) {
        ArrayList<Bundle> d2 = BundleableUtil.d(list);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", d2);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
