package androidx.media3.common.util;

import android.os.Bundle;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class BundleCollectionUtil {
    private BundleCollectionUtil() {
    }

    public static <T> ImmutableList<T> a(Function<Bundle, T> function, List<Bundle> list) {
        ImmutableList.Builder k2 = ImmutableList.k();
        for (int i2 = 0; i2 < list.size(); i2++) {
            k2.d(function.apply((Bundle) Assertions.f(list.get(i2))));
        }
        return k2.k();
    }

    public static <T> ArrayList<Bundle> b(Collection<T> collection, Function<T, Bundle> function) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        for (T apply : collection) {
            arrayList.add(function.apply(apply));
        }
        return arrayList;
    }
}
