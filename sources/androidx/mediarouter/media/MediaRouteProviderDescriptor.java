package androidx.mediarouter.media;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class MediaRouteProviderDescriptor {

    /* renamed from: a  reason: collision with root package name */
    final List<MediaRouteDescriptor> f10540a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f10541b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private List<MediaRouteDescriptor> f10542a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f10543b = false;

        public Builder a(MediaRouteDescriptor mediaRouteDescriptor) {
            if (mediaRouteDescriptor != null) {
                List<MediaRouteDescriptor> list = this.f10542a;
                if (list == null) {
                    this.f10542a = new ArrayList();
                } else if (list.contains(mediaRouteDescriptor)) {
                    throw new IllegalArgumentException("route descriptor already added");
                }
                this.f10542a.add(mediaRouteDescriptor);
                return this;
            }
            throw new IllegalArgumentException("route must not be null");
        }

        public Builder b(Collection<MediaRouteDescriptor> collection) {
            if (collection != null) {
                if (!collection.isEmpty()) {
                    for (MediaRouteDescriptor a2 : collection) {
                        a(a2);
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("routes must not be null");
        }

        public MediaRouteProviderDescriptor c() {
            return new MediaRouteProviderDescriptor(this.f10542a, this.f10543b);
        }

        public Builder d(boolean z2) {
            this.f10543b = z2;
            return this;
        }
    }

    MediaRouteProviderDescriptor(List<MediaRouteDescriptor> list, boolean z2) {
        this.f10540a = list == null ? Collections.emptyList() : list;
        this.f10541b = z2;
    }

    public static MediaRouteProviderDescriptor a(Bundle bundle) {
        ArrayList arrayList = null;
        if (bundle == null) {
            return null;
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("routes");
        if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
            int size = parcelableArrayList.size();
            ArrayList arrayList2 = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(MediaRouteDescriptor.d((Bundle) parcelableArrayList.get(i2)));
            }
            arrayList = arrayList2;
        }
        return new MediaRouteProviderDescriptor(arrayList, bundle.getBoolean("supportsDynamicGroupRoute", false));
    }

    public List<MediaRouteDescriptor> b() {
        return this.f10540a;
    }

    public boolean c() {
        int size = b().size();
        for (int i2 = 0; i2 < size; i2++) {
            MediaRouteDescriptor mediaRouteDescriptor = this.f10540a.get(i2);
            if (mediaRouteDescriptor == null || !mediaRouteDescriptor.x()) {
                return false;
            }
        }
        return true;
    }

    public boolean d() {
        return this.f10541b;
    }

    public String toString() {
        return "MediaRouteProviderDescriptor{ " + "routes=" + Arrays.toString(b().toArray()) + ", isValid=" + c() + " }";
    }
}
