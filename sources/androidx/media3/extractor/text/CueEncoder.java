package androidx.media3.extractor.text;

import android.os.Bundle;
import android.os.Parcel;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.BundleCollectionUtil;
import java.util.ArrayList;
import java.util.List;

public final class CueEncoder {
    public byte[] a(List<Cue> list, long j2) {
        ArrayList<Bundle> b2 = BundleCollectionUtil.b(list, new b());
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", b2);
        bundle.putLong("d", j2);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
