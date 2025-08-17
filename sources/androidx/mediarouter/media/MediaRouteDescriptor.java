package androidx.mediarouter.media;

import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class MediaRouteDescriptor {

    /* renamed from: a  reason: collision with root package name */
    final Bundle f10499a;

    /* renamed from: b  reason: collision with root package name */
    List<String> f10500b;

    /* renamed from: c  reason: collision with root package name */
    List<IntentFilter> f10501c;

    MediaRouteDescriptor(Bundle bundle) {
        this.f10499a = bundle;
    }

    public static MediaRouteDescriptor d(Bundle bundle) {
        if (bundle != null) {
            return new MediaRouteDescriptor(bundle);
        }
        return null;
    }

    public boolean a() {
        return this.f10499a.getBoolean("canDisconnect", false);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f10501c == null) {
            ArrayList parcelableArrayList = this.f10499a.getParcelableArrayList("controlFilters");
            this.f10501c = parcelableArrayList;
            if (parcelableArrayList == null) {
                this.f10501c = Collections.emptyList();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f10500b == null) {
            ArrayList<String> stringArrayList = this.f10499a.getStringArrayList("groupMemberIds");
            this.f10500b = stringArrayList;
            if (stringArrayList == null) {
                this.f10500b = Collections.emptyList();
            }
        }
    }

    public int e() {
        return this.f10499a.getInt("connectionState", 0);
    }

    public List<IntentFilter> f() {
        b();
        return this.f10501c;
    }

    public String g() {
        return this.f10499a.getString("status");
    }

    public int h() {
        return this.f10499a.getInt("deviceType");
    }

    public Bundle i() {
        return this.f10499a.getBundle("extras");
    }

    public List<String> j() {
        c();
        return this.f10500b;
    }

    public Uri k() {
        String string = this.f10499a.getString("iconUri");
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    public String l() {
        return this.f10499a.getString("id");
    }

    public int m() {
        return this.f10499a.getInt("maxClientVersion", Integer.MAX_VALUE);
    }

    public int n() {
        return this.f10499a.getInt("minClientVersion", 1);
    }

    public String o() {
        return this.f10499a.getString("name");
    }

    public int p() {
        return this.f10499a.getInt("playbackStream", -1);
    }

    public int q() {
        return this.f10499a.getInt("playbackType", 1);
    }

    public int r() {
        return this.f10499a.getInt("presentationDisplayId", -1);
    }

    public IntentSender s() {
        return (IntentSender) this.f10499a.getParcelable("settingsIntent");
    }

    public int t() {
        return this.f10499a.getInt("volume");
    }

    public String toString() {
        return "MediaRouteDescriptor{ " + "id=" + l() + ", groupMemberIds=" + j() + ", name=" + o() + ", description=" + g() + ", iconUri=" + k() + ", isEnabled=" + w() + ", connectionState=" + e() + ", controlFilters=" + Arrays.toString(f().toArray()) + ", playbackType=" + q() + ", playbackStream=" + p() + ", deviceType=" + h() + ", volume=" + t() + ", volumeMax=" + v() + ", volumeHandling=" + u() + ", presentationDisplayId=" + r() + ", extras=" + i() + ", isValid=" + x() + ", minClientVersion=" + n() + ", maxClientVersion=" + m() + " }";
    }

    public int u() {
        return this.f10499a.getInt("volumeHandling", 0);
    }

    public int v() {
        return this.f10499a.getInt("volumeMax");
    }

    public boolean w() {
        return this.f10499a.getBoolean(ViewProps.ENABLED, true);
    }

    public boolean x() {
        b();
        if (TextUtils.isEmpty(l()) || TextUtils.isEmpty(o()) || this.f10501c.contains((Object) null)) {
            return false;
        }
        return true;
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Bundle f10502a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<String> f10503b;

        /* renamed from: c  reason: collision with root package name */
        private ArrayList<IntentFilter> f10504c;

        public Builder(String str, String str2) {
            this.f10502a = new Bundle();
            m(str);
            n(str2);
        }

        public Builder a(IntentFilter intentFilter) {
            if (intentFilter != null) {
                if (this.f10504c == null) {
                    this.f10504c = new ArrayList<>();
                }
                if (!this.f10504c.contains(intentFilter)) {
                    this.f10504c.add(intentFilter);
                }
                return this;
            }
            throw new IllegalArgumentException("filter must not be null");
        }

        public Builder b(Collection<IntentFilter> collection) {
            if (collection != null) {
                if (!collection.isEmpty()) {
                    for (IntentFilter next : collection) {
                        if (next != null) {
                            a(next);
                        }
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("filters must not be null");
        }

        public Builder c(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f10503b == null) {
                    this.f10503b = new ArrayList<>();
                }
                if (!this.f10503b.contains(str)) {
                    this.f10503b.add(str);
                }
                return this;
            }
            throw new IllegalArgumentException("groupMemberId must not be empty");
        }

        public Builder d(Collection<String> collection) {
            if (collection != null) {
                if (!collection.isEmpty()) {
                    for (String c2 : collection) {
                        c(c2);
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("groupMemberIds must not be null");
        }

        public MediaRouteDescriptor e() {
            ArrayList<IntentFilter> arrayList = this.f10504c;
            if (arrayList != null) {
                this.f10502a.putParcelableArrayList("controlFilters", arrayList);
            }
            ArrayList<String> arrayList2 = this.f10503b;
            if (arrayList2 != null) {
                this.f10502a.putStringArrayList("groupMemberIds", arrayList2);
            }
            return new MediaRouteDescriptor(this.f10502a);
        }

        public Builder f(boolean z2) {
            this.f10502a.putBoolean("canDisconnect", z2);
            return this;
        }

        public Builder g(int i2) {
            this.f10502a.putInt("connectionState", i2);
            return this;
        }

        public Builder h(String str) {
            this.f10502a.putString("status", str);
            return this;
        }

        public Builder i(int i2) {
            this.f10502a.putInt("deviceType", i2);
            return this;
        }

        public Builder j(boolean z2) {
            this.f10502a.putBoolean(ViewProps.ENABLED, z2);
            return this;
        }

        public Builder k(Bundle bundle) {
            if (bundle == null) {
                this.f10502a.putBundle("extras", (Bundle) null);
            } else {
                this.f10502a.putBundle("extras", new Bundle(bundle));
            }
            return this;
        }

        public Builder l(Uri uri) {
            if (uri != null) {
                this.f10502a.putString("iconUri", uri.toString());
                return this;
            }
            throw new IllegalArgumentException("iconUri must not be null");
        }

        public Builder m(String str) {
            if (str != null) {
                this.f10502a.putString("id", str);
                return this;
            }
            throw new NullPointerException("id must not be null");
        }

        public Builder n(String str) {
            if (str != null) {
                this.f10502a.putString("name", str);
                return this;
            }
            throw new NullPointerException("name must not be null");
        }

        public Builder o(int i2) {
            this.f10502a.putInt("playbackStream", i2);
            return this;
        }

        public Builder p(int i2) {
            this.f10502a.putInt("playbackType", i2);
            return this;
        }

        public Builder q(int i2) {
            this.f10502a.putInt("presentationDisplayId", i2);
            return this;
        }

        public Builder r(int i2) {
            this.f10502a.putInt("volume", i2);
            return this;
        }

        public Builder s(int i2) {
            this.f10502a.putInt("volumeHandling", i2);
            return this;
        }

        public Builder t(int i2) {
            this.f10502a.putInt("volumeMax", i2);
            return this;
        }

        public Builder(MediaRouteDescriptor mediaRouteDescriptor) {
            if (mediaRouteDescriptor != null) {
                this.f10502a = new Bundle(mediaRouteDescriptor.f10499a);
                if (!mediaRouteDescriptor.j().isEmpty()) {
                    this.f10503b = new ArrayList<>(mediaRouteDescriptor.j());
                }
                if (!mediaRouteDescriptor.f().isEmpty()) {
                    this.f10504c = new ArrayList<>(mediaRouteDescriptor.f10501c);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("descriptor must not be null");
        }
    }
}
