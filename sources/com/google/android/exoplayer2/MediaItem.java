package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class MediaItem implements Bundleable {

    /* renamed from: j  reason: collision with root package name */
    public static final MediaItem f23121j = new Builder().a();

    /* renamed from: k  reason: collision with root package name */
    private static final String f23122k = Util.u0(0);

    /* renamed from: l  reason: collision with root package name */
    private static final String f23123l = Util.u0(1);

    /* renamed from: m  reason: collision with root package name */
    private static final String f23124m = Util.u0(2);

    /* renamed from: n  reason: collision with root package name */
    private static final String f23125n = Util.u0(3);

    /* renamed from: o  reason: collision with root package name */
    private static final String f23126o = Util.u0(4);

    /* renamed from: p  reason: collision with root package name */
    public static final Bundleable.Creator<MediaItem> f23127p = new a1();

    /* renamed from: b  reason: collision with root package name */
    public final String f23128b;

    /* renamed from: c  reason: collision with root package name */
    public final LocalConfiguration f23129c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public final PlaybackProperties f23130d;

    /* renamed from: e  reason: collision with root package name */
    public final LiveConfiguration f23131e;

    /* renamed from: f  reason: collision with root package name */
    public final MediaMetadata f23132f;

    /* renamed from: g  reason: collision with root package name */
    public final ClippingConfiguration f23133g;
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public final ClippingProperties f23134h;

    /* renamed from: i  reason: collision with root package name */
    public final RequestMetadata f23135i;

    public static final class AdsConfiguration {
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f23136a;

        /* renamed from: b  reason: collision with root package name */
        private Uri f23137b;

        /* renamed from: c  reason: collision with root package name */
        private String f23138c;

        /* renamed from: d  reason: collision with root package name */
        private ClippingConfiguration.Builder f23139d;

        /* renamed from: e  reason: collision with root package name */
        private DrmConfiguration.Builder f23140e;

        /* renamed from: f  reason: collision with root package name */
        private List<StreamKey> f23141f;

        /* renamed from: g  reason: collision with root package name */
        private String f23142g;

        /* renamed from: h  reason: collision with root package name */
        private ImmutableList<SubtitleConfiguration> f23143h;

        /* renamed from: i  reason: collision with root package name */
        private Object f23144i;

        /* renamed from: j  reason: collision with root package name */
        private MediaMetadata f23145j;

        /* renamed from: k  reason: collision with root package name */
        private LiveConfiguration.Builder f23146k;

        /* renamed from: l  reason: collision with root package name */
        private RequestMetadata f23147l;

        public MediaItem a() {
            boolean z2;
            PlaybackProperties playbackProperties;
            if (this.f23140e.f23178b == null || this.f23140e.f23177a != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            Uri uri = this.f23137b;
            DrmConfiguration drmConfiguration = null;
            if (uri != null) {
                String str = this.f23138c;
                if (this.f23140e.f23177a != null) {
                    drmConfiguration = this.f23140e.i();
                }
                playbackProperties = new PlaybackProperties(uri, str, drmConfiguration, (AdsConfiguration) null, this.f23141f, this.f23142g, this.f23143h, this.f23144i);
            } else {
                playbackProperties = null;
            }
            String str2 = this.f23136a;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            ClippingProperties g2 = this.f23139d.g();
            LiveConfiguration f2 = this.f23146k.f();
            MediaMetadata mediaMetadata = this.f23145j;
            if (mediaMetadata == null) {
                mediaMetadata = MediaMetadata.J;
            }
            return new MediaItem(str3, g2, playbackProperties, f2, mediaMetadata, this.f23147l);
        }

        public Builder b(String str) {
            this.f23142g = str;
            return this;
        }

        public Builder c(LiveConfiguration liveConfiguration) {
            this.f23146k = liveConfiguration.b();
            return this;
        }

        public Builder d(String str) {
            this.f23136a = (String) Assertions.e(str);
            return this;
        }

        public Builder e(String str) {
            this.f23138c = str;
            return this;
        }

        public Builder f(List<StreamKey> list) {
            List<StreamKey> list2;
            if (list == null || list.isEmpty()) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.unmodifiableList(new ArrayList(list));
            }
            this.f23141f = list2;
            return this;
        }

        public Builder g(List<SubtitleConfiguration> list) {
            this.f23143h = ImmutableList.n(list);
            return this;
        }

        public Builder h(Object obj) {
            this.f23144i = obj;
            return this;
        }

        public Builder i(Uri uri) {
            this.f23137b = uri;
            return this;
        }

        public Builder j(String str) {
            return i(str == null ? null : Uri.parse(str));
        }

        public Builder() {
            this.f23139d = new ClippingConfiguration.Builder();
            this.f23140e = new DrmConfiguration.Builder();
            this.f23141f = Collections.emptyList();
            this.f23143h = ImmutableList.r();
            this.f23146k = new LiveConfiguration.Builder();
            this.f23147l = RequestMetadata.f23210e;
        }

        private Builder(MediaItem mediaItem) {
            this();
            DrmConfiguration.Builder builder;
            this.f23139d = mediaItem.f23133g.b();
            this.f23136a = mediaItem.f23128b;
            this.f23145j = mediaItem.f23132f;
            this.f23146k = mediaItem.f23131e.b();
            this.f23147l = mediaItem.f23135i;
            LocalConfiguration localConfiguration = mediaItem.f23129c;
            if (localConfiguration != null) {
                this.f23142g = localConfiguration.f23206e;
                this.f23138c = localConfiguration.f23203b;
                this.f23137b = localConfiguration.f23202a;
                this.f23141f = localConfiguration.f23205d;
                this.f23143h = localConfiguration.f23207f;
                this.f23144i = localConfiguration.f23209h;
                DrmConfiguration drmConfiguration = localConfiguration.f23204c;
                if (drmConfiguration != null) {
                    builder = drmConfiguration.b();
                } else {
                    builder = new DrmConfiguration.Builder();
                }
                this.f23140e = builder;
            }
        }
    }

    public static class ClippingConfiguration implements Bundleable {

        /* renamed from: g  reason: collision with root package name */
        public static final ClippingConfiguration f23148g = new Builder().f();

        /* renamed from: h  reason: collision with root package name */
        private static final String f23149h = Util.u0(0);

        /* renamed from: i  reason: collision with root package name */
        private static final String f23150i = Util.u0(1);

        /* renamed from: j  reason: collision with root package name */
        private static final String f23151j = Util.u0(2);

        /* renamed from: k  reason: collision with root package name */
        private static final String f23152k = Util.u0(3);

        /* renamed from: l  reason: collision with root package name */
        private static final String f23153l = Util.u0(4);

        /* renamed from: m  reason: collision with root package name */
        public static final Bundleable.Creator<ClippingProperties> f23154m = new b1();

        /* renamed from: b  reason: collision with root package name */
        public final long f23155b;

        /* renamed from: c  reason: collision with root package name */
        public final long f23156c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f23157d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f23158e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f23159f;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public long f23160a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public long f23161b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public boolean f23162c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public boolean f23163d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public boolean f23164e;

            public ClippingConfiguration f() {
                return g();
            }

            @Deprecated
            public ClippingProperties g() {
                return new ClippingProperties(this);
            }

            public Builder h(long j2) {
                boolean z2;
                if (j2 == Long.MIN_VALUE || j2 >= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.a(z2);
                this.f23161b = j2;
                return this;
            }

            public Builder i(boolean z2) {
                this.f23163d = z2;
                return this;
            }

            public Builder j(boolean z2) {
                this.f23162c = z2;
                return this;
            }

            public Builder k(long j2) {
                boolean z2;
                if (j2 >= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Assertions.a(z2);
                this.f23160a = j2;
                return this;
            }

            public Builder l(boolean z2) {
                this.f23164e = z2;
                return this;
            }

            public Builder() {
                this.f23161b = Long.MIN_VALUE;
            }

            private Builder(ClippingConfiguration clippingConfiguration) {
                this.f23160a = clippingConfiguration.f23155b;
                this.f23161b = clippingConfiguration.f23156c;
                this.f23162c = clippingConfiguration.f23157d;
                this.f23163d = clippingConfiguration.f23158e;
                this.f23164e = clippingConfiguration.f23159f;
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ ClippingProperties c(Bundle bundle) {
            Builder builder = new Builder();
            String str = f23149h;
            ClippingConfiguration clippingConfiguration = f23148g;
            return builder.k(bundle.getLong(str, clippingConfiguration.f23155b)).h(bundle.getLong(f23150i, clippingConfiguration.f23156c)).j(bundle.getBoolean(f23151j, clippingConfiguration.f23157d)).i(bundle.getBoolean(f23152k, clippingConfiguration.f23158e)).l(bundle.getBoolean(f23153l, clippingConfiguration.f23159f)).g();
        }

        public Builder b() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClippingConfiguration)) {
                return false;
            }
            ClippingConfiguration clippingConfiguration = (ClippingConfiguration) obj;
            if (this.f23155b == clippingConfiguration.f23155b && this.f23156c == clippingConfiguration.f23156c && this.f23157d == clippingConfiguration.f23157d && this.f23158e == clippingConfiguration.f23158e && this.f23159f == clippingConfiguration.f23159f) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j2 = this.f23155b;
            long j3 = this.f23156c;
            return (((((((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.f23157d ? 1 : 0)) * 31) + (this.f23158e ? 1 : 0)) * 31) + (this.f23159f ? 1 : 0);
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            long j2 = this.f23155b;
            ClippingConfiguration clippingConfiguration = f23148g;
            if (j2 != clippingConfiguration.f23155b) {
                bundle.putLong(f23149h, j2);
            }
            long j3 = this.f23156c;
            if (j3 != clippingConfiguration.f23156c) {
                bundle.putLong(f23150i, j3);
            }
            boolean z2 = this.f23157d;
            if (z2 != clippingConfiguration.f23157d) {
                bundle.putBoolean(f23151j, z2);
            }
            boolean z3 = this.f23158e;
            if (z3 != clippingConfiguration.f23158e) {
                bundle.putBoolean(f23152k, z3);
            }
            boolean z4 = this.f23159f;
            if (z4 != clippingConfiguration.f23159f) {
                bundle.putBoolean(f23153l, z4);
            }
            return bundle;
        }

        private ClippingConfiguration(Builder builder) {
            this.f23155b = builder.f23160a;
            this.f23156c = builder.f23161b;
            this.f23157d = builder.f23162c;
            this.f23158e = builder.f23163d;
            this.f23159f = builder.f23164e;
        }
    }

    @Deprecated
    public static final class ClippingProperties extends ClippingConfiguration {

        /* renamed from: n  reason: collision with root package name */
        public static final ClippingProperties f23165n = new ClippingConfiguration.Builder().g();

        private ClippingProperties(ClippingConfiguration.Builder builder) {
            super(builder);
        }
    }

    public static final class DrmConfiguration {

        /* renamed from: a  reason: collision with root package name */
        public final UUID f23166a;
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public final UUID f23167b;

        /* renamed from: c  reason: collision with root package name */
        public final Uri f23168c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public final ImmutableMap<String, String> f23169d;

        /* renamed from: e  reason: collision with root package name */
        public final ImmutableMap<String, String> f23170e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f23171f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f23172g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f23173h;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        public final ImmutableList<Integer> f23174i;

        /* renamed from: j  reason: collision with root package name */
        public final ImmutableList<Integer> f23175j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public final byte[] f23176k;

        public Builder b() {
            return new Builder();
        }

        public byte[] c() {
            byte[] bArr = this.f23176k;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrmConfiguration)) {
                return false;
            }
            DrmConfiguration drmConfiguration = (DrmConfiguration) obj;
            if (!this.f23166a.equals(drmConfiguration.f23166a) || !Util.c(this.f23168c, drmConfiguration.f23168c) || !Util.c(this.f23170e, drmConfiguration.f23170e) || this.f23171f != drmConfiguration.f23171f || this.f23173h != drmConfiguration.f23173h || this.f23172g != drmConfiguration.f23172g || !this.f23175j.equals(drmConfiguration.f23175j) || !Arrays.equals(this.f23176k, drmConfiguration.f23176k)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2;
            int hashCode = this.f23166a.hashCode() * 31;
            Uri uri = this.f23168c;
            if (uri != null) {
                i2 = uri.hashCode();
            } else {
                i2 = 0;
            }
            return ((((((((((((hashCode + i2) * 31) + this.f23170e.hashCode()) * 31) + (this.f23171f ? 1 : 0)) * 31) + (this.f23173h ? 1 : 0)) * 31) + (this.f23172g ? 1 : 0)) * 31) + this.f23175j.hashCode()) * 31) + Arrays.hashCode(this.f23176k);
        }

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public UUID f23177a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public Uri f23178b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public ImmutableMap<String, String> f23179c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public boolean f23180d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public boolean f23181e;
            /* access modifiers changed from: private */

            /* renamed from: f  reason: collision with root package name */
            public boolean f23182f;
            /* access modifiers changed from: private */

            /* renamed from: g  reason: collision with root package name */
            public ImmutableList<Integer> f23183g;
            /* access modifiers changed from: private */

            /* renamed from: h  reason: collision with root package name */
            public byte[] f23184h;

            public DrmConfiguration i() {
                return new DrmConfiguration(this);
            }

            @Deprecated
            private Builder() {
                this.f23179c = ImmutableMap.k();
                this.f23183g = ImmutableList.r();
            }

            private Builder(DrmConfiguration drmConfiguration) {
                this.f23177a = drmConfiguration.f23166a;
                this.f23178b = drmConfiguration.f23168c;
                this.f23179c = drmConfiguration.f23170e;
                this.f23180d = drmConfiguration.f23171f;
                this.f23181e = drmConfiguration.f23172g;
                this.f23182f = drmConfiguration.f23173h;
                this.f23183g = drmConfiguration.f23175j;
                this.f23184h = drmConfiguration.f23176k;
            }
        }

        private DrmConfiguration(Builder builder) {
            Assertions.g(!builder.f23182f || builder.f23178b != null);
            UUID uuid = (UUID) Assertions.e(builder.f23177a);
            this.f23166a = uuid;
            this.f23167b = uuid;
            this.f23168c = builder.f23178b;
            this.f23169d = builder.f23179c;
            this.f23170e = builder.f23179c;
            this.f23171f = builder.f23180d;
            this.f23173h = builder.f23182f;
            this.f23172g = builder.f23181e;
            this.f23174i = builder.f23183g;
            this.f23175j = builder.f23183g;
            this.f23176k = builder.f23184h != null ? Arrays.copyOf(builder.f23184h, builder.f23184h.length) : null;
        }
    }

    public static final class LiveConfiguration implements Bundleable {

        /* renamed from: g  reason: collision with root package name */
        public static final LiveConfiguration f23185g = new Builder().f();

        /* renamed from: h  reason: collision with root package name */
        private static final String f23186h = Util.u0(0);

        /* renamed from: i  reason: collision with root package name */
        private static final String f23187i = Util.u0(1);

        /* renamed from: j  reason: collision with root package name */
        private static final String f23188j = Util.u0(2);

        /* renamed from: k  reason: collision with root package name */
        private static final String f23189k = Util.u0(3);

        /* renamed from: l  reason: collision with root package name */
        private static final String f23190l = Util.u0(4);

        /* renamed from: m  reason: collision with root package name */
        public static final Bundleable.Creator<LiveConfiguration> f23191m = new c1();

        /* renamed from: b  reason: collision with root package name */
        public final long f23192b;

        /* renamed from: c  reason: collision with root package name */
        public final long f23193c;

        /* renamed from: d  reason: collision with root package name */
        public final long f23194d;

        /* renamed from: e  reason: collision with root package name */
        public final float f23195e;

        /* renamed from: f  reason: collision with root package name */
        public final float f23196f;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public long f23197a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public long f23198b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public long f23199c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public float f23200d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public float f23201e;

            public LiveConfiguration f() {
                return new LiveConfiguration(this);
            }

            public Builder g(long j2) {
                this.f23199c = j2;
                return this;
            }

            public Builder h(float f2) {
                this.f23201e = f2;
                return this;
            }

            public Builder i(long j2) {
                this.f23198b = j2;
                return this;
            }

            public Builder j(float f2) {
                this.f23200d = f2;
                return this;
            }

            public Builder k(long j2) {
                this.f23197a = j2;
                return this;
            }

            public Builder() {
                this.f23197a = -9223372036854775807L;
                this.f23198b = -9223372036854775807L;
                this.f23199c = -9223372036854775807L;
                this.f23200d = -3.4028235E38f;
                this.f23201e = -3.4028235E38f;
            }

            private Builder(LiveConfiguration liveConfiguration) {
                this.f23197a = liveConfiguration.f23192b;
                this.f23198b = liveConfiguration.f23193c;
                this.f23199c = liveConfiguration.f23194d;
                this.f23200d = liveConfiguration.f23195e;
                this.f23201e = liveConfiguration.f23196f;
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ LiveConfiguration c(Bundle bundle) {
            String str = f23186h;
            LiveConfiguration liveConfiguration = f23185g;
            return new LiveConfiguration(bundle.getLong(str, liveConfiguration.f23192b), bundle.getLong(f23187i, liveConfiguration.f23193c), bundle.getLong(f23188j, liveConfiguration.f23194d), bundle.getFloat(f23189k, liveConfiguration.f23195e), bundle.getFloat(f23190l, liveConfiguration.f23196f));
        }

        public Builder b() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LiveConfiguration)) {
                return false;
            }
            LiveConfiguration liveConfiguration = (LiveConfiguration) obj;
            if (this.f23192b == liveConfiguration.f23192b && this.f23193c == liveConfiguration.f23193c && this.f23194d == liveConfiguration.f23194d && this.f23195e == liveConfiguration.f23195e && this.f23196f == liveConfiguration.f23196f) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2;
            long j2 = this.f23192b;
            long j3 = this.f23193c;
            long j4 = this.f23194d;
            int i3 = ((((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            float f2 = this.f23195e;
            int i4 = 0;
            if (f2 != 0.0f) {
                i2 = Float.floatToIntBits(f2);
            } else {
                i2 = 0;
            }
            int i5 = (i3 + i2) * 31;
            float f3 = this.f23196f;
            if (f3 != 0.0f) {
                i4 = Float.floatToIntBits(f3);
            }
            return i5 + i4;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            long j2 = this.f23192b;
            LiveConfiguration liveConfiguration = f23185g;
            if (j2 != liveConfiguration.f23192b) {
                bundle.putLong(f23186h, j2);
            }
            long j3 = this.f23193c;
            if (j3 != liveConfiguration.f23193c) {
                bundle.putLong(f23187i, j3);
            }
            long j4 = this.f23194d;
            if (j4 != liveConfiguration.f23194d) {
                bundle.putLong(f23188j, j4);
            }
            float f2 = this.f23195e;
            if (f2 != liveConfiguration.f23195e) {
                bundle.putFloat(f23189k, f2);
            }
            float f3 = this.f23196f;
            if (f3 != liveConfiguration.f23196f) {
                bundle.putFloat(f23190l, f3);
            }
            return bundle;
        }

        private LiveConfiguration(Builder builder) {
            this(builder.f23197a, builder.f23198b, builder.f23199c, builder.f23200d, builder.f23201e);
        }

        @Deprecated
        public LiveConfiguration(long j2, long j3, long j4, float f2, float f3) {
            this.f23192b = j2;
            this.f23193c = j3;
            this.f23194d = j4;
            this.f23195e = f2;
            this.f23196f = f3;
        }
    }

    public static class LocalConfiguration {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f23202a;

        /* renamed from: b  reason: collision with root package name */
        public final String f23203b;

        /* renamed from: c  reason: collision with root package name */
        public final DrmConfiguration f23204c;

        /* renamed from: d  reason: collision with root package name */
        public final List<StreamKey> f23205d;

        /* renamed from: e  reason: collision with root package name */
        public final String f23206e;

        /* renamed from: f  reason: collision with root package name */
        public final ImmutableList<SubtitleConfiguration> f23207f;
        @Deprecated

        /* renamed from: g  reason: collision with root package name */
        public final List<Subtitle> f23208g;

        /* renamed from: h  reason: collision with root package name */
        public final Object f23209h;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalConfiguration)) {
                return false;
            }
            LocalConfiguration localConfiguration = (LocalConfiguration) obj;
            if (!this.f23202a.equals(localConfiguration.f23202a) || !Util.c(this.f23203b, localConfiguration.f23203b) || !Util.c(this.f23204c, localConfiguration.f23204c) || !Util.c((Object) null, (Object) null) || !this.f23205d.equals(localConfiguration.f23205d) || !Util.c(this.f23206e, localConfiguration.f23206e) || !this.f23207f.equals(localConfiguration.f23207f) || !Util.c(this.f23209h, localConfiguration.f23209h)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2;
            int i3;
            int i4;
            int hashCode = this.f23202a.hashCode() * 31;
            String str = this.f23203b;
            int i5 = 0;
            if (str == null) {
                i2 = 0;
            } else {
                i2 = str.hashCode();
            }
            int i6 = (hashCode + i2) * 31;
            DrmConfiguration drmConfiguration = this.f23204c;
            if (drmConfiguration == null) {
                i3 = 0;
            } else {
                i3 = drmConfiguration.hashCode();
            }
            int hashCode2 = (((((i6 + i3) * 31) + 0) * 31) + this.f23205d.hashCode()) * 31;
            String str2 = this.f23206e;
            if (str2 == null) {
                i4 = 0;
            } else {
                i4 = str2.hashCode();
            }
            int hashCode3 = (((hashCode2 + i4) * 31) + this.f23207f.hashCode()) * 31;
            Object obj = this.f23209h;
            if (obj != null) {
                i5 = obj.hashCode();
            }
            return hashCode3 + i5;
        }

        private LocalConfiguration(Uri uri, String str, DrmConfiguration drmConfiguration, AdsConfiguration adsConfiguration, List<StreamKey> list, String str2, ImmutableList<SubtitleConfiguration> immutableList, Object obj) {
            this.f23202a = uri;
            this.f23203b = str;
            this.f23204c = drmConfiguration;
            this.f23205d = list;
            this.f23206e = str2;
            this.f23207f = immutableList;
            ImmutableList.Builder k2 = ImmutableList.k();
            for (int i2 = 0; i2 < immutableList.size(); i2++) {
                k2.d(immutableList.get(i2).a().i());
            }
            this.f23208g = k2.k();
            this.f23209h = obj;
        }
    }

    @Deprecated
    public static final class PlaybackProperties extends LocalConfiguration {
        private PlaybackProperties(Uri uri, String str, DrmConfiguration drmConfiguration, AdsConfiguration adsConfiguration, List<StreamKey> list, String str2, ImmutableList<SubtitleConfiguration> immutableList, Object obj) {
            super(uri, str, drmConfiguration, adsConfiguration, list, str2, immutableList, obj);
        }
    }

    public static final class RequestMetadata implements Bundleable {

        /* renamed from: e  reason: collision with root package name */
        public static final RequestMetadata f23210e = new Builder().d();

        /* renamed from: f  reason: collision with root package name */
        private static final String f23211f = Util.u0(0);

        /* renamed from: g  reason: collision with root package name */
        private static final String f23212g = Util.u0(1);

        /* renamed from: h  reason: collision with root package name */
        private static final String f23213h = Util.u0(2);

        /* renamed from: i  reason: collision with root package name */
        public static final Bundleable.Creator<RequestMetadata> f23214i = new d1();

        /* renamed from: b  reason: collision with root package name */
        public final Uri f23215b;

        /* renamed from: c  reason: collision with root package name */
        public final String f23216c;

        /* renamed from: d  reason: collision with root package name */
        public final Bundle f23217d;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public Uri f23218a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public String f23219b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public Bundle f23220c;

            public RequestMetadata d() {
                return new RequestMetadata(this);
            }

            public Builder e(Bundle bundle) {
                this.f23220c = bundle;
                return this;
            }

            public Builder f(Uri uri) {
                this.f23218a = uri;
                return this;
            }

            public Builder g(String str) {
                this.f23219b = str;
                return this;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestMetadata)) {
                return false;
            }
            RequestMetadata requestMetadata = (RequestMetadata) obj;
            if (!Util.c(this.f23215b, requestMetadata.f23215b) || !Util.c(this.f23216c, requestMetadata.f23216c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2;
            Uri uri = this.f23215b;
            int i3 = 0;
            if (uri == null) {
                i2 = 0;
            } else {
                i2 = uri.hashCode();
            }
            int i4 = i2 * 31;
            String str = this.f23216c;
            if (str != null) {
                i3 = str.hashCode();
            }
            return i4 + i3;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            Uri uri = this.f23215b;
            if (uri != null) {
                bundle.putParcelable(f23211f, uri);
            }
            String str = this.f23216c;
            if (str != null) {
                bundle.putString(f23212g, str);
            }
            Bundle bundle2 = this.f23217d;
            if (bundle2 != null) {
                bundle.putBundle(f23213h, bundle2);
            }
            return bundle;
        }

        private RequestMetadata(Builder builder) {
            this.f23215b = builder.f23218a;
            this.f23216c = builder.f23219b;
            this.f23217d = builder.f23220c;
        }
    }

    @Deprecated
    public static final class Subtitle extends SubtitleConfiguration {
        private Subtitle(SubtitleConfiguration.Builder builder) {
            super(builder);
        }
    }

    public static class SubtitleConfiguration {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f23221a;

        /* renamed from: b  reason: collision with root package name */
        public final String f23222b;

        /* renamed from: c  reason: collision with root package name */
        public final String f23223c;

        /* renamed from: d  reason: collision with root package name */
        public final int f23224d;

        /* renamed from: e  reason: collision with root package name */
        public final int f23225e;

        /* renamed from: f  reason: collision with root package name */
        public final String f23226f;

        /* renamed from: g  reason: collision with root package name */
        public final String f23227g;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public Uri f23228a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public String f23229b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public String f23230c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public int f23231d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public int f23232e;
            /* access modifiers changed from: private */

            /* renamed from: f  reason: collision with root package name */
            public String f23233f;
            /* access modifiers changed from: private */

            /* renamed from: g  reason: collision with root package name */
            public String f23234g;

            /* access modifiers changed from: private */
            public Subtitle i() {
                return new Subtitle(this);
            }

            private Builder(SubtitleConfiguration subtitleConfiguration) {
                this.f23228a = subtitleConfiguration.f23221a;
                this.f23229b = subtitleConfiguration.f23222b;
                this.f23230c = subtitleConfiguration.f23223c;
                this.f23231d = subtitleConfiguration.f23224d;
                this.f23232e = subtitleConfiguration.f23225e;
                this.f23233f = subtitleConfiguration.f23226f;
                this.f23234g = subtitleConfiguration.f23227g;
            }
        }

        public Builder a() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubtitleConfiguration)) {
                return false;
            }
            SubtitleConfiguration subtitleConfiguration = (SubtitleConfiguration) obj;
            if (!this.f23221a.equals(subtitleConfiguration.f23221a) || !Util.c(this.f23222b, subtitleConfiguration.f23222b) || !Util.c(this.f23223c, subtitleConfiguration.f23223c) || this.f23224d != subtitleConfiguration.f23224d || this.f23225e != subtitleConfiguration.f23225e || !Util.c(this.f23226f, subtitleConfiguration.f23226f) || !Util.c(this.f23227g, subtitleConfiguration.f23227g)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2;
            int i3;
            int i4;
            int hashCode = this.f23221a.hashCode() * 31;
            String str = this.f23222b;
            int i5 = 0;
            if (str == null) {
                i2 = 0;
            } else {
                i2 = str.hashCode();
            }
            int i6 = (hashCode + i2) * 31;
            String str2 = this.f23223c;
            if (str2 == null) {
                i3 = 0;
            } else {
                i3 = str2.hashCode();
            }
            int i7 = (((((i6 + i3) * 31) + this.f23224d) * 31) + this.f23225e) * 31;
            String str3 = this.f23226f;
            if (str3 == null) {
                i4 = 0;
            } else {
                i4 = str3.hashCode();
            }
            int i8 = (i7 + i4) * 31;
            String str4 = this.f23227g;
            if (str4 != null) {
                i5 = str4.hashCode();
            }
            return i8 + i5;
        }

        private SubtitleConfiguration(Builder builder) {
            this.f23221a = builder.f23228a;
            this.f23222b = builder.f23229b;
            this.f23223c = builder.f23230c;
            this.f23224d = builder.f23231d;
            this.f23225e = builder.f23232e;
            this.f23226f = builder.f23233f;
            this.f23227g = builder.f23234g;
        }
    }

    /* access modifiers changed from: private */
    public static MediaItem c(Bundle bundle) {
        LiveConfiguration liveConfiguration;
        MediaMetadata mediaMetadata;
        ClippingProperties clippingProperties;
        RequestMetadata requestMetadata;
        String str = (String) Assertions.e(bundle.getString(f23122k, ""));
        Bundle bundle2 = bundle.getBundle(f23123l);
        if (bundle2 == null) {
            liveConfiguration = LiveConfiguration.f23185g;
        } else {
            liveConfiguration = LiveConfiguration.f23191m.a(bundle2);
        }
        LiveConfiguration liveConfiguration2 = liveConfiguration;
        Bundle bundle3 = bundle.getBundle(f23124m);
        if (bundle3 == null) {
            mediaMetadata = MediaMetadata.J;
        } else {
            mediaMetadata = MediaMetadata.f23252r0.a(bundle3);
        }
        MediaMetadata mediaMetadata2 = mediaMetadata;
        Bundle bundle4 = bundle.getBundle(f23125n);
        if (bundle4 == null) {
            clippingProperties = ClippingProperties.f23165n;
        } else {
            clippingProperties = ClippingConfiguration.f23154m.a(bundle4);
        }
        ClippingProperties clippingProperties2 = clippingProperties;
        Bundle bundle5 = bundle.getBundle(f23126o);
        if (bundle5 == null) {
            requestMetadata = RequestMetadata.f23210e;
        } else {
            requestMetadata = RequestMetadata.f23214i.a(bundle5);
        }
        return new MediaItem(str, clippingProperties2, (PlaybackProperties) null, liveConfiguration2, mediaMetadata2, requestMetadata);
    }

    public static MediaItem d(Uri uri) {
        return new Builder().i(uri).a();
    }

    public static MediaItem e(String str) {
        return new Builder().j(str).a();
    }

    public Builder b() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) obj;
        if (!Util.c(this.f23128b, mediaItem.f23128b) || !this.f23133g.equals(mediaItem.f23133g) || !Util.c(this.f23129c, mediaItem.f23129c) || !Util.c(this.f23131e, mediaItem.f23131e) || !Util.c(this.f23132f, mediaItem.f23132f) || !Util.c(this.f23135i, mediaItem.f23135i)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int hashCode = this.f23128b.hashCode() * 31;
        LocalConfiguration localConfiguration = this.f23129c;
        if (localConfiguration != null) {
            i2 = localConfiguration.hashCode();
        } else {
            i2 = 0;
        }
        return ((((((((hashCode + i2) * 31) + this.f23131e.hashCode()) * 31) + this.f23133g.hashCode()) * 31) + this.f23132f.hashCode()) * 31) + this.f23135i.hashCode();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (!this.f23128b.equals("")) {
            bundle.putString(f23122k, this.f23128b);
        }
        if (!this.f23131e.equals(LiveConfiguration.f23185g)) {
            bundle.putBundle(f23123l, this.f23131e.toBundle());
        }
        if (!this.f23132f.equals(MediaMetadata.J)) {
            bundle.putBundle(f23124m, this.f23132f.toBundle());
        }
        if (!this.f23133g.equals(ClippingConfiguration.f23148g)) {
            bundle.putBundle(f23125n, this.f23133g.toBundle());
        }
        if (!this.f23135i.equals(RequestMetadata.f23210e)) {
            bundle.putBundle(f23126o, this.f23135i.toBundle());
        }
        return bundle;
    }

    private MediaItem(String str, ClippingProperties clippingProperties, PlaybackProperties playbackProperties, LiveConfiguration liveConfiguration, MediaMetadata mediaMetadata, RequestMetadata requestMetadata) {
        this.f23128b = str;
        this.f23129c = playbackProperties;
        this.f23130d = playbackProperties;
        this.f23131e = liveConfiguration;
        this.f23132f = mediaMetadata;
        this.f23133g = clippingProperties;
        this.f23134h = clippingProperties;
        this.f23135i = requestMetadata;
    }
}
