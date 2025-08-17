package androidx.mediarouter.media;

import android.content.IntentFilter;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class MediaRouteSelector {

    /* renamed from: c  reason: collision with root package name */
    public static final MediaRouteSelector f10544c = new MediaRouteSelector(new Bundle(), (List<String>) null);

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f10545a;

    /* renamed from: b  reason: collision with root package name */
    List<String> f10546b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<String> f10547a;

        public Builder() {
        }

        public Builder a(Collection<String> collection) {
            if (collection != null) {
                if (!collection.isEmpty()) {
                    for (String b2 : collection) {
                        b(b2);
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("categories must not be null");
        }

        public Builder b(String str) {
            if (str != null) {
                if (this.f10547a == null) {
                    this.f10547a = new ArrayList<>();
                }
                if (!this.f10547a.contains(str)) {
                    this.f10547a.add(str);
                }
                return this;
            }
            throw new IllegalArgumentException("category must not be null");
        }

        public Builder c(MediaRouteSelector mediaRouteSelector) {
            if (mediaRouteSelector != null) {
                a(mediaRouteSelector.e());
                return this;
            }
            throw new IllegalArgumentException("selector must not be null");
        }

        public MediaRouteSelector d() {
            if (this.f10547a == null) {
                return MediaRouteSelector.f10544c;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("controlCategories", this.f10547a);
            return new MediaRouteSelector(bundle, this.f10547a);
        }

        public Builder(MediaRouteSelector mediaRouteSelector) {
            if (mediaRouteSelector != null) {
                mediaRouteSelector.c();
                if (!mediaRouteSelector.f10546b.isEmpty()) {
                    this.f10547a = new ArrayList<>(mediaRouteSelector.f10546b);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("selector must not be null");
        }
    }

    MediaRouteSelector(Bundle bundle, List<String> list) {
        this.f10545a = bundle;
        this.f10546b = list;
    }

    public static MediaRouteSelector d(Bundle bundle) {
        if (bundle != null) {
            return new MediaRouteSelector(bundle, (List<String>) null);
        }
        return null;
    }

    public Bundle a() {
        return this.f10545a;
    }

    public boolean b(MediaRouteSelector mediaRouteSelector) {
        if (mediaRouteSelector == null) {
            return false;
        }
        c();
        mediaRouteSelector.c();
        return this.f10546b.containsAll(mediaRouteSelector.f10546b);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f10546b == null) {
            ArrayList<String> stringArrayList = this.f10545a.getStringArrayList("controlCategories");
            this.f10546b = stringArrayList;
            if (stringArrayList == null || stringArrayList.isEmpty()) {
                this.f10546b = Collections.emptyList();
            }
        }
    }

    public List<String> e() {
        c();
        return new ArrayList(this.f10546b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MediaRouteSelector)) {
            return false;
        }
        MediaRouteSelector mediaRouteSelector = (MediaRouteSelector) obj;
        c();
        mediaRouteSelector.c();
        return this.f10546b.equals(mediaRouteSelector.f10546b);
    }

    public boolean f() {
        c();
        return this.f10546b.isEmpty();
    }

    public boolean g() {
        c();
        if (this.f10546b.contains((Object) null)) {
            return false;
        }
        return true;
    }

    public boolean h(List<IntentFilter> list) {
        if (list == null) {
            return false;
        }
        c();
        if (this.f10546b.isEmpty()) {
            return false;
        }
        for (IntentFilter next : list) {
            if (next != null) {
                for (String hasCategory : this.f10546b) {
                    if (next.hasCategory(hasCategory)) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public int hashCode() {
        c();
        return this.f10546b.hashCode();
    }

    public String toString() {
        return "MediaRouteSelector{ " + "controlCategories=" + Arrays.toString(e().toArray()) + " }";
    }
}
