package androidx.media3.extractor.text;

import android.os.Bundle;
import android.os.Parcel;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import java.util.ArrayList;

public final class CueDecoder {
    public CuesWithTiming a(long j2, byte[] bArr, int i2, int i3) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, i2, i3);
        obtain.setDataPosition(0);
        Bundle readBundle = obtain.readBundle(Bundle.class.getClassLoader());
        obtain.recycle();
        return new CuesWithTiming(BundleCollectionUtil.a(new a(), (ArrayList) Assertions.f(readBundle.getParcelableArrayList("c"))), j2, readBundle.getLong("d"));
    }
}
