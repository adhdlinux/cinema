package androidx.mediarouter.media;

import android.os.Bundle;

public final class MediaRouteDiscoveryRequest {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f10505a;

    /* renamed from: b  reason: collision with root package name */
    private MediaRouteSelector f10506b;

    public MediaRouteDiscoveryRequest(MediaRouteSelector mediaRouteSelector, boolean z2) {
        if (mediaRouteSelector != null) {
            Bundle bundle = new Bundle();
            this.f10505a = bundle;
            this.f10506b = mediaRouteSelector;
            bundle.putBundle("selector", mediaRouteSelector.a());
            bundle.putBoolean("activeScan", z2);
            return;
        }
        throw new IllegalArgumentException("selector must not be null");
    }

    private void b() {
        if (this.f10506b == null) {
            MediaRouteSelector d2 = MediaRouteSelector.d(this.f10505a.getBundle("selector"));
            this.f10506b = d2;
            if (d2 == null) {
                this.f10506b = MediaRouteSelector.f10544c;
            }
        }
    }

    public Bundle a() {
        return this.f10505a;
    }

    public MediaRouteSelector c() {
        b();
        return this.f10506b;
    }

    public boolean d() {
        return this.f10505a.getBoolean("activeScan");
    }

    public boolean e() {
        b();
        return this.f10506b.g();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MediaRouteDiscoveryRequest)) {
            return false;
        }
        MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest = (MediaRouteDiscoveryRequest) obj;
        if (!c().equals(mediaRouteDiscoveryRequest.c()) || d() != mediaRouteDiscoveryRequest.d()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return c().hashCode() ^ d() ? 1 : 0;
    }

    public String toString() {
        return "DiscoveryRequest{ selector=" + c() + ", activeScan=" + d() + ", isValid=" + e() + " }";
    }
}
