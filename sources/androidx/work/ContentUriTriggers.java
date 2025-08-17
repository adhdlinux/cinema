package androidx.work;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

public final class ContentUriTriggers {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Trigger> f12153a = new HashSet();

    public static final class Trigger {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f12154a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f12155b;

        Trigger(Uri uri, boolean z2) {
            this.f12154a = uri;
            this.f12155b = z2;
        }

        public Uri a() {
            return this.f12154a;
        }

        public boolean b() {
            return this.f12155b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Trigger.class != obj.getClass()) {
                return false;
            }
            Trigger trigger = (Trigger) obj;
            if (this.f12155b != trigger.f12155b || !this.f12154a.equals(trigger.f12154a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f12154a.hashCode() * 31) + (this.f12155b ? 1 : 0);
        }
    }

    public void a(Uri uri, boolean z2) {
        this.f12153a.add(new Trigger(uri, z2));
    }

    public Set<Trigger> b() {
        return this.f12153a;
    }

    public int c() {
        return this.f12153a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ContentUriTriggers.class != obj.getClass()) {
            return false;
        }
        return this.f12153a.equals(((ContentUriTriggers) obj).f12153a);
    }

    public int hashCode() {
        return this.f12153a.hashCode();
    }
}
