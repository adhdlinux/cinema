package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class MediaItem {

    /* renamed from: i  reason: collision with root package name */
    public static final MediaItem f4071i = new Builder().a();

    /* renamed from: j  reason: collision with root package name */
    private static final String f4072j = Util.B0(0);

    /* renamed from: k  reason: collision with root package name */
    private static final String f4073k = Util.B0(1);

    /* renamed from: l  reason: collision with root package name */
    private static final String f4074l = Util.B0(2);

    /* renamed from: m  reason: collision with root package name */
    private static final String f4075m = Util.B0(3);

    /* renamed from: n  reason: collision with root package name */
    private static final String f4076n = Util.B0(4);

    /* renamed from: o  reason: collision with root package name */
    private static final String f4077o = Util.B0(5);

    /* renamed from: a  reason: collision with root package name */
    public final String f4078a;

    /* renamed from: b  reason: collision with root package name */
    public final LocalConfiguration f4079b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public final LocalConfiguration f4080c;

    /* renamed from: d  reason: collision with root package name */
    public final LiveConfiguration f4081d;

    /* renamed from: e  reason: collision with root package name */
    public final MediaMetadata f4082e;

    /* renamed from: f  reason: collision with root package name */
    public final ClippingConfiguration f4083f;
    @Deprecated

    /* renamed from: g  reason: collision with root package name */
    public final ClippingProperties f4084g;

    /* renamed from: h  reason: collision with root package name */
    public final RequestMetadata f4085h;

    public static final class AdsConfiguration {
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f4086a;

        /* renamed from: b  reason: collision with root package name */
        private Uri f4087b;

        /* renamed from: c  reason: collision with root package name */
        private String f4088c;

        /* renamed from: d  reason: collision with root package name */
        private ClippingConfiguration.Builder f4089d;

        /* renamed from: e  reason: collision with root package name */
        private DrmConfiguration.Builder f4090e;

        /* renamed from: f  reason: collision with root package name */
        private List<StreamKey> f4091f;

        /* renamed from: g  reason: collision with root package name */
        private String f4092g;

        /* renamed from: h  reason: collision with root package name */
        private ImmutableList<SubtitleConfiguration> f4093h;

        /* renamed from: i  reason: collision with root package name */
        private Object f4094i;

        /* renamed from: j  reason: collision with root package name */
        private long f4095j;

        /* renamed from: k  reason: collision with root package name */
        private MediaMetadata f4096k;

        /* renamed from: l  reason: collision with root package name */
        private LiveConfiguration.Builder f4097l;

        /* renamed from: m  reason: collision with root package name */
        private RequestMetadata f4098m;

        public MediaItem a() {
            boolean z2;
            LocalConfiguration localConfiguration;
            if (this.f4090e.f4140b == null || this.f4090e.f4139a != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.h(z2);
            Uri uri = this.f4087b;
            DrmConfiguration drmConfiguration = null;
            if (uri != null) {
                String str = this.f4088c;
                if (this.f4090e.f4139a != null) {
                    drmConfiguration = this.f4090e.i();
                }
                localConfiguration = new LocalConfiguration(uri, str, drmConfiguration, (AdsConfiguration) null, this.f4091f, this.f4092g, this.f4093h, this.f4094i, this.f4095j);
            } else {
                localConfiguration = null;
            }
            String str2 = this.f4086a;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            ClippingProperties g2 = this.f4089d.g();
            LiveConfiguration f2 = this.f4097l.f();
            MediaMetadata mediaMetadata = this.f4096k;
            if (mediaMetadata == null) {
                mediaMetadata = MediaMetadata.J;
            }
            return new MediaItem(str3, g2, localConfiguration, f2, mediaMetadata, this.f4098m);
        }

        public Builder b(LiveConfiguration liveConfiguration) {
            this.f4097l = liveConfiguration.a();
            return this;
        }

        public Builder c(String str) {
            this.f4086a = (String) Assertions.f(str);
            return this;
        }

        public Builder d(String str) {
            this.f4088c = str;
            return this;
        }

        public Builder e(List<SubtitleConfiguration> list) {
            this.f4093h = ImmutableList.n(list);
            return this;
        }

        public Builder f(Object obj) {
            this.f4094i = obj;
            return this;
        }

        public Builder g(Uri uri) {
            this.f4087b = uri;
            return this;
        }

        public Builder h(String str) {
            return g(str == null ? null : Uri.parse(str));
        }

        public Builder() {
            this.f4089d = new ClippingConfiguration.Builder();
            this.f4090e = new DrmConfiguration.Builder();
            this.f4091f = Collections.emptyList();
            this.f4093h = ImmutableList.r();
            this.f4097l = new LiveConfiguration.Builder();
            this.f4098m = RequestMetadata.f4180d;
            this.f4095j = -9223372036854775807L;
        }

        private Builder(MediaItem mediaItem) {
            this();
            DrmConfiguration.Builder builder;
            this.f4089d = mediaItem.f4083f.a();
            this.f4086a = mediaItem.f4078a;
            this.f4096k = mediaItem.f4082e;
            this.f4097l = mediaItem.f4081d.a();
            this.f4098m = mediaItem.f4085h;
            LocalConfiguration localConfiguration = mediaItem.f4079b;
            if (localConfiguration != null) {
                this.f4092g = localConfiguration.f4175e;
                this.f4088c = localConfiguration.f4172b;
                this.f4087b = localConfiguration.f4171a;
                this.f4091f = localConfiguration.f4174d;
                this.f4093h = localConfiguration.f4176f;
                this.f4094i = localConfiguration.f4178h;
                DrmConfiguration drmConfiguration = localConfiguration.f4173c;
                if (drmConfiguration != null) {
                    builder = drmConfiguration.b();
                } else {
                    builder = new DrmConfiguration.Builder();
                }
                this.f4090e = builder;
                this.f4095j = localConfiguration.f4179i;
            }
        }
    }

    public static class ClippingConfiguration {

        /* renamed from: h  reason: collision with root package name */
        public static final ClippingConfiguration f4099h = new Builder().f();

        /* renamed from: i  reason: collision with root package name */
        private static final String f4100i = Util.B0(0);

        /* renamed from: j  reason: collision with root package name */
        private static final String f4101j = Util.B0(1);

        /* renamed from: k  reason: collision with root package name */
        private static final String f4102k = Util.B0(2);

        /* renamed from: l  reason: collision with root package name */
        private static final String f4103l = Util.B0(3);

        /* renamed from: m  reason: collision with root package name */
        private static final String f4104m = Util.B0(4);

        /* renamed from: n  reason: collision with root package name */
        static final String f4105n = Util.B0(5);

        /* renamed from: o  reason: collision with root package name */
        static final String f4106o = Util.B0(6);

        /* renamed from: a  reason: collision with root package name */
        public final long f4107a;

        /* renamed from: b  reason: collision with root package name */
        public final long f4108b;

        /* renamed from: c  reason: collision with root package name */
        public final long f4109c;

        /* renamed from: d  reason: collision with root package name */
        public final long f4110d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f4111e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f4112f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f4113g;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public long f4114a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public long f4115b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public boolean f4116c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public boolean f4117d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public boolean f4118e;

            public ClippingConfiguration f() {
                return new ClippingConfiguration(this);
            }

            @Deprecated
            public ClippingProperties g() {
                return new ClippingProperties(this);
            }

            public Builder() {
                this.f4115b = Long.MIN_VALUE;
            }

            private Builder(ClippingConfiguration clippingConfiguration) {
                this.f4114a = clippingConfiguration.f4108b;
                this.f4115b = clippingConfiguration.f4110d;
                this.f4116c = clippingConfiguration.f4111e;
                this.f4117d = clippingConfiguration.f4112f;
                this.f4118e = clippingConfiguration.f4113g;
            }
        }

        public Builder a() {
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
            if (this.f4108b == clippingConfiguration.f4108b && this.f4110d == clippingConfiguration.f4110d && this.f4111e == clippingConfiguration.f4111e && this.f4112f == clippingConfiguration.f4112f && this.f4113g == clippingConfiguration.f4113g) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j2 = this.f4108b;
            long j3 = this.f4110d;
            return (((((((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.f4111e ? 1 : 0)) * 31) + (this.f4112f ? 1 : 0)) * 31) + (this.f4113g ? 1 : 0);
        }

        private ClippingConfiguration(Builder builder) {
            this.f4107a = Util.t1(builder.f4114a);
            this.f4109c = Util.t1(builder.f4115b);
            this.f4108b = builder.f4114a;
            this.f4110d = builder.f4115b;
            this.f4111e = builder.f4116c;
            this.f4112f = builder.f4117d;
            this.f4113g = builder.f4118e;
        }
    }

    @Deprecated
    public static final class ClippingProperties extends ClippingConfiguration {

        /* renamed from: p  reason: collision with root package name */
        public static final ClippingProperties f4119p = new ClippingConfiguration.Builder().g();

        private ClippingProperties(ClippingConfiguration.Builder builder) {
            super(builder);
        }
    }

    public static final class DrmConfiguration {

        /* renamed from: l  reason: collision with root package name */
        private static final String f4120l = Util.B0(0);

        /* renamed from: m  reason: collision with root package name */
        private static final String f4121m = Util.B0(1);

        /* renamed from: n  reason: collision with root package name */
        private static final String f4122n = Util.B0(2);

        /* renamed from: o  reason: collision with root package name */
        private static final String f4123o = Util.B0(3);

        /* renamed from: p  reason: collision with root package name */
        static final String f4124p = Util.B0(4);

        /* renamed from: q  reason: collision with root package name */
        private static final String f4125q = Util.B0(5);

        /* renamed from: r  reason: collision with root package name */
        private static final String f4126r = Util.B0(6);

        /* renamed from: s  reason: collision with root package name */
        private static final String f4127s = Util.B0(7);

        /* renamed from: a  reason: collision with root package name */
        public final UUID f4128a;
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public final UUID f4129b;

        /* renamed from: c  reason: collision with root package name */
        public final Uri f4130c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public final ImmutableMap<String, String> f4131d;

        /* renamed from: e  reason: collision with root package name */
        public final ImmutableMap<String, String> f4132e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f4133f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f4134g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f4135h;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        public final ImmutableList<Integer> f4136i;

        /* renamed from: j  reason: collision with root package name */
        public final ImmutableList<Integer> f4137j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public final byte[] f4138k;

        public Builder b() {
            return new Builder();
        }

        public byte[] c() {
            byte[] bArr = this.f4138k;
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
            if (!this.f4128a.equals(drmConfiguration.f4128a) || !Util.c(this.f4130c, drmConfiguration.f4130c) || !Util.c(this.f4132e, drmConfiguration.f4132e) || this.f4133f != drmConfiguration.f4133f || this.f4135h != drmConfiguration.f4135h || this.f4134g != drmConfiguration.f4134g || !this.f4137j.equals(drmConfiguration.f4137j) || !Arrays.equals(this.f4138k, drmConfiguration.f4138k)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2;
            int hashCode = this.f4128a.hashCode() * 31;
            Uri uri = this.f4130c;
            if (uri != null) {
                i2 = uri.hashCode();
            } else {
                i2 = 0;
            }
            return ((((((((((((hashCode + i2) * 31) + this.f4132e.hashCode()) * 31) + (this.f4133f ? 1 : 0)) * 31) + (this.f4135h ? 1 : 0)) * 31) + (this.f4134g ? 1 : 0)) * 31) + this.f4137j.hashCode()) * 31) + Arrays.hashCode(this.f4138k);
        }

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public UUID f4139a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public Uri f4140b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public ImmutableMap<String, String> f4141c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public boolean f4142d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public boolean f4143e;
            /* access modifiers changed from: private */

            /* renamed from: f  reason: collision with root package name */
            public boolean f4144f;
            /* access modifiers changed from: private */

            /* renamed from: g  reason: collision with root package name */
            public ImmutableList<Integer> f4145g;
            /* access modifiers changed from: private */

            /* renamed from: h  reason: collision with root package name */
            public byte[] f4146h;

            public DrmConfiguration i() {
                return new DrmConfiguration(this);
            }

            @Deprecated
            private Builder() {
                this.f4141c = ImmutableMap.k();
                this.f4143e = true;
                this.f4145g = ImmutableList.r();
            }

            private Builder(DrmConfiguration drmConfiguration) {
                this.f4139a = drmConfiguration.f4128a;
                this.f4140b = drmConfiguration.f4130c;
                this.f4141c = drmConfiguration.f4132e;
                this.f4142d = drmConfiguration.f4133f;
                this.f4143e = drmConfiguration.f4134g;
                this.f4144f = drmConfiguration.f4135h;
                this.f4145g = drmConfiguration.f4137j;
                this.f4146h = drmConfiguration.f4138k;
            }
        }

        private DrmConfiguration(Builder builder) {
            Assertions.h(!builder.f4144f || builder.f4140b != null);
            UUID uuid = (UUID) Assertions.f(builder.f4139a);
            this.f4128a = uuid;
            this.f4129b = uuid;
            this.f4130c = builder.f4140b;
            this.f4131d = builder.f4141c;
            this.f4132e = builder.f4141c;
            this.f4133f = builder.f4142d;
            this.f4135h = builder.f4144f;
            this.f4134g = builder.f4143e;
            this.f4136i = builder.f4145g;
            this.f4137j = builder.f4145g;
            this.f4138k = builder.f4146h != null ? Arrays.copyOf(builder.f4146h, builder.f4146h.length) : null;
        }
    }

    public static final class LiveConfiguration {

        /* renamed from: f  reason: collision with root package name */
        public static final LiveConfiguration f4147f = new Builder().f();

        /* renamed from: g  reason: collision with root package name */
        private static final String f4148g = Util.B0(0);

        /* renamed from: h  reason: collision with root package name */
        private static final String f4149h = Util.B0(1);

        /* renamed from: i  reason: collision with root package name */
        private static final String f4150i = Util.B0(2);

        /* renamed from: j  reason: collision with root package name */
        private static final String f4151j = Util.B0(3);

        /* renamed from: k  reason: collision with root package name */
        private static final String f4152k = Util.B0(4);

        /* renamed from: a  reason: collision with root package name */
        public final long f4153a;

        /* renamed from: b  reason: collision with root package name */
        public final long f4154b;

        /* renamed from: c  reason: collision with root package name */
        public final long f4155c;

        /* renamed from: d  reason: collision with root package name */
        public final float f4156d;

        /* renamed from: e  reason: collision with root package name */
        public final float f4157e;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public long f4158a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public long f4159b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public long f4160c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public float f4161d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public float f4162e;

            public LiveConfiguration f() {
                return new LiveConfiguration(this);
            }

            public Builder g(long j2) {
                this.f4160c = j2;
                return this;
            }

            public Builder h(float f2) {
                this.f4162e = f2;
                return this;
            }

            public Builder i(long j2) {
                this.f4159b = j2;
                return this;
            }

            public Builder j(float f2) {
                this.f4161d = f2;
                return this;
            }

            public Builder k(long j2) {
                this.f4158a = j2;
                return this;
            }

            public Builder() {
                this.f4158a = -9223372036854775807L;
                this.f4159b = -9223372036854775807L;
                this.f4160c = -9223372036854775807L;
                this.f4161d = -3.4028235E38f;
                this.f4162e = -3.4028235E38f;
            }

            private Builder(LiveConfiguration liveConfiguration) {
                this.f4158a = liveConfiguration.f4153a;
                this.f4159b = liveConfiguration.f4154b;
                this.f4160c = liveConfiguration.f4155c;
                this.f4161d = liveConfiguration.f4156d;
                this.f4162e = liveConfiguration.f4157e;
            }
        }

        public Builder a() {
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
            if (this.f4153a == liveConfiguration.f4153a && this.f4154b == liveConfiguration.f4154b && this.f4155c == liveConfiguration.f4155c && this.f4156d == liveConfiguration.f4156d && this.f4157e == liveConfiguration.f4157e) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2;
            long j2 = this.f4153a;
            long j3 = this.f4154b;
            long j4 = this.f4155c;
            int i3 = ((((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            float f2 = this.f4156d;
            int i4 = 0;
            if (f2 != 0.0f) {
                i2 = Float.floatToIntBits(f2);
            } else {
                i2 = 0;
            }
            int i5 = (i3 + i2) * 31;
            float f3 = this.f4157e;
            if (f3 != 0.0f) {
                i4 = Float.floatToIntBits(f3);
            }
            return i5 + i4;
        }

        private LiveConfiguration(Builder builder) {
            this(builder.f4158a, builder.f4159b, builder.f4160c, builder.f4161d, builder.f4162e);
        }

        @Deprecated
        public LiveConfiguration(long j2, long j3, long j4, float f2, float f3) {
            this.f4153a = j2;
            this.f4154b = j3;
            this.f4155c = j4;
            this.f4156d = f2;
            this.f4157e = f3;
        }
    }

    public static final class LocalConfiguration {

        /* renamed from: j  reason: collision with root package name */
        private static final String f4163j = Util.B0(0);

        /* renamed from: k  reason: collision with root package name */
        private static final String f4164k = Util.B0(1);

        /* renamed from: l  reason: collision with root package name */
        private static final String f4165l = Util.B0(2);

        /* renamed from: m  reason: collision with root package name */
        private static final String f4166m = Util.B0(3);

        /* renamed from: n  reason: collision with root package name */
        private static final String f4167n = Util.B0(4);

        /* renamed from: o  reason: collision with root package name */
        private static final String f4168o = Util.B0(5);

        /* renamed from: p  reason: collision with root package name */
        private static final String f4169p = Util.B0(6);

        /* renamed from: q  reason: collision with root package name */
        private static final String f4170q = Util.B0(7);

        /* renamed from: a  reason: collision with root package name */
        public final Uri f4171a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4172b;

        /* renamed from: c  reason: collision with root package name */
        public final DrmConfiguration f4173c;

        /* renamed from: d  reason: collision with root package name */
        public final List<StreamKey> f4174d;

        /* renamed from: e  reason: collision with root package name */
        public final String f4175e;

        /* renamed from: f  reason: collision with root package name */
        public final ImmutableList<SubtitleConfiguration> f4176f;
        @Deprecated

        /* renamed from: g  reason: collision with root package name */
        public final List<Subtitle> f4177g;

        /* renamed from: h  reason: collision with root package name */
        public final Object f4178h;

        /* renamed from: i  reason: collision with root package name */
        public final long f4179i;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalConfiguration)) {
                return false;
            }
            LocalConfiguration localConfiguration = (LocalConfiguration) obj;
            if (!this.f4171a.equals(localConfiguration.f4171a) || !Util.c(this.f4172b, localConfiguration.f4172b) || !Util.c(this.f4173c, localConfiguration.f4173c) || !Util.c((Object) null, (Object) null) || !this.f4174d.equals(localConfiguration.f4174d) || !Util.c(this.f4175e, localConfiguration.f4175e) || !this.f4176f.equals(localConfiguration.f4176f) || !Util.c(this.f4178h, localConfiguration.f4178h) || !Util.c(Long.valueOf(this.f4179i), Long.valueOf(localConfiguration.f4179i))) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2;
            int i3;
            int i4;
            int hashCode = this.f4171a.hashCode() * 31;
            String str = this.f4172b;
            int i5 = 0;
            if (str == null) {
                i2 = 0;
            } else {
                i2 = str.hashCode();
            }
            int i6 = (hashCode + i2) * 31;
            DrmConfiguration drmConfiguration = this.f4173c;
            if (drmConfiguration == null) {
                i3 = 0;
            } else {
                i3 = drmConfiguration.hashCode();
            }
            int hashCode2 = (((((i6 + i3) * 31) + 0) * 31) + this.f4174d.hashCode()) * 31;
            String str2 = this.f4175e;
            if (str2 == null) {
                i4 = 0;
            } else {
                i4 = str2.hashCode();
            }
            int hashCode3 = (((hashCode2 + i4) * 31) + this.f4176f.hashCode()) * 31;
            Object obj = this.f4178h;
            if (obj != null) {
                i5 = obj.hashCode();
            }
            return (int) ((((long) (hashCode3 + i5)) * 31) + this.f4179i);
        }

        private LocalConfiguration(Uri uri, String str, DrmConfiguration drmConfiguration, AdsConfiguration adsConfiguration, List<StreamKey> list, String str2, ImmutableList<SubtitleConfiguration> immutableList, Object obj, long j2) {
            this.f4171a = uri;
            this.f4172b = MimeTypes.t(str);
            this.f4173c = drmConfiguration;
            this.f4174d = list;
            this.f4175e = str2;
            this.f4176f = immutableList;
            ImmutableList.Builder k2 = ImmutableList.k();
            for (int i2 = 0; i2 < immutableList.size(); i2++) {
                k2.d(immutableList.get(i2).a().j());
            }
            this.f4177g = k2.k();
            this.f4178h = obj;
            this.f4179i = j2;
        }
    }

    public static final class RequestMetadata {

        /* renamed from: d  reason: collision with root package name */
        public static final RequestMetadata f4180d = new Builder().d();

        /* renamed from: e  reason: collision with root package name */
        private static final String f4181e = Util.B0(0);

        /* renamed from: f  reason: collision with root package name */
        private static final String f4182f = Util.B0(1);

        /* renamed from: g  reason: collision with root package name */
        private static final String f4183g = Util.B0(2);

        /* renamed from: a  reason: collision with root package name */
        public final Uri f4184a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4185b;

        /* renamed from: c  reason: collision with root package name */
        public final Bundle f4186c;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public Uri f4187a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public String f4188b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public Bundle f4189c;

            public RequestMetadata d() {
                return new RequestMetadata(this);
            }
        }

        public boolean equals(Object obj) {
            boolean z2;
            boolean z3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestMetadata)) {
                return false;
            }
            RequestMetadata requestMetadata = (RequestMetadata) obj;
            if (Util.c(this.f4184a, requestMetadata.f4184a) && Util.c(this.f4185b, requestMetadata.f4185b)) {
                if (this.f4186c == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (requestMetadata.f4186c == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z2 == z3) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i2;
            int i3;
            Uri uri = this.f4184a;
            int i4 = 0;
            if (uri == null) {
                i2 = 0;
            } else {
                i2 = uri.hashCode();
            }
            int i5 = i2 * 31;
            String str = this.f4185b;
            if (str == null) {
                i3 = 0;
            } else {
                i3 = str.hashCode();
            }
            int i6 = (i5 + i3) * 31;
            if (this.f4186c != null) {
                i4 = 1;
            }
            return i6 + i4;
        }

        private RequestMetadata(Builder builder) {
            this.f4184a = builder.f4187a;
            this.f4185b = builder.f4188b;
            this.f4186c = builder.f4189c;
        }
    }

    @Deprecated
    public static final class Subtitle extends SubtitleConfiguration {
        private Subtitle(SubtitleConfiguration.Builder builder) {
            super(builder);
        }
    }

    public static class SubtitleConfiguration {

        /* renamed from: h  reason: collision with root package name */
        private static final String f4190h = Util.B0(0);

        /* renamed from: i  reason: collision with root package name */
        private static final String f4191i = Util.B0(1);

        /* renamed from: j  reason: collision with root package name */
        private static final String f4192j = Util.B0(2);

        /* renamed from: k  reason: collision with root package name */
        private static final String f4193k = Util.B0(3);

        /* renamed from: l  reason: collision with root package name */
        private static final String f4194l = Util.B0(4);

        /* renamed from: m  reason: collision with root package name */
        private static final String f4195m = Util.B0(5);

        /* renamed from: n  reason: collision with root package name */
        private static final String f4196n = Util.B0(6);

        /* renamed from: a  reason: collision with root package name */
        public final Uri f4197a;

        /* renamed from: b  reason: collision with root package name */
        public final String f4198b;

        /* renamed from: c  reason: collision with root package name */
        public final String f4199c;

        /* renamed from: d  reason: collision with root package name */
        public final int f4200d;

        /* renamed from: e  reason: collision with root package name */
        public final int f4201e;

        /* renamed from: f  reason: collision with root package name */
        public final String f4202f;

        /* renamed from: g  reason: collision with root package name */
        public final String f4203g;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public Uri f4204a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public String f4205b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public String f4206c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public int f4207d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public int f4208e;
            /* access modifiers changed from: private */

            /* renamed from: f  reason: collision with root package name */
            public String f4209f;
            /* access modifiers changed from: private */

            /* renamed from: g  reason: collision with root package name */
            public String f4210g;

            /* access modifiers changed from: private */
            public Subtitle j() {
                return new Subtitle(this);
            }

            public SubtitleConfiguration i() {
                return new SubtitleConfiguration(this);
            }

            public Builder k(String str) {
                this.f4210g = str;
                return this;
            }

            public Builder l(String str) {
                this.f4209f = str;
                return this;
            }

            public Builder m(String str) {
                this.f4206c = str;
                return this;
            }

            public Builder n(String str) {
                this.f4205b = MimeTypes.t(str);
                return this;
            }

            public Builder o(int i2) {
                this.f4207d = i2;
                return this;
            }

            public Builder(Uri uri) {
                this.f4204a = uri;
            }

            private Builder(SubtitleConfiguration subtitleConfiguration) {
                this.f4204a = subtitleConfiguration.f4197a;
                this.f4205b = subtitleConfiguration.f4198b;
                this.f4206c = subtitleConfiguration.f4199c;
                this.f4207d = subtitleConfiguration.f4200d;
                this.f4208e = subtitleConfiguration.f4201e;
                this.f4209f = subtitleConfiguration.f4202f;
                this.f4210g = subtitleConfiguration.f4203g;
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
            if (!this.f4197a.equals(subtitleConfiguration.f4197a) || !Util.c(this.f4198b, subtitleConfiguration.f4198b) || !Util.c(this.f4199c, subtitleConfiguration.f4199c) || this.f4200d != subtitleConfiguration.f4200d || this.f4201e != subtitleConfiguration.f4201e || !Util.c(this.f4202f, subtitleConfiguration.f4202f) || !Util.c(this.f4203g, subtitleConfiguration.f4203g)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i2;
            int i3;
            int i4;
            int hashCode = this.f4197a.hashCode() * 31;
            String str = this.f4198b;
            int i5 = 0;
            if (str == null) {
                i2 = 0;
            } else {
                i2 = str.hashCode();
            }
            int i6 = (hashCode + i2) * 31;
            String str2 = this.f4199c;
            if (str2 == null) {
                i3 = 0;
            } else {
                i3 = str2.hashCode();
            }
            int i7 = (((((i6 + i3) * 31) + this.f4200d) * 31) + this.f4201e) * 31;
            String str3 = this.f4202f;
            if (str3 == null) {
                i4 = 0;
            } else {
                i4 = str3.hashCode();
            }
            int i8 = (i7 + i4) * 31;
            String str4 = this.f4203g;
            if (str4 != null) {
                i5 = str4.hashCode();
            }
            return i8 + i5;
        }

        private SubtitleConfiguration(Builder builder) {
            this.f4197a = builder.f4204a;
            this.f4198b = builder.f4205b;
            this.f4199c = builder.f4206c;
            this.f4200d = builder.f4207d;
            this.f4201e = builder.f4208e;
            this.f4202f = builder.f4209f;
            this.f4203g = builder.f4210g;
        }
    }

    public static MediaItem b(String str) {
        return new Builder().h(str).a();
    }

    public Builder a() {
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
        if (!Util.c(this.f4078a, mediaItem.f4078a) || !this.f4083f.equals(mediaItem.f4083f) || !Util.c(this.f4079b, mediaItem.f4079b) || !Util.c(this.f4081d, mediaItem.f4081d) || !Util.c(this.f4082e, mediaItem.f4082e) || !Util.c(this.f4085h, mediaItem.f4085h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2;
        int hashCode = this.f4078a.hashCode() * 31;
        LocalConfiguration localConfiguration = this.f4079b;
        if (localConfiguration != null) {
            i2 = localConfiguration.hashCode();
        } else {
            i2 = 0;
        }
        return ((((((((hashCode + i2) * 31) + this.f4081d.hashCode()) * 31) + this.f4083f.hashCode()) * 31) + this.f4082e.hashCode()) * 31) + this.f4085h.hashCode();
    }

    private MediaItem(String str, ClippingProperties clippingProperties, LocalConfiguration localConfiguration, LiveConfiguration liveConfiguration, MediaMetadata mediaMetadata, RequestMetadata requestMetadata) {
        this.f4078a = str;
        this.f4079b = localConfiguration;
        this.f4080c = localConfiguration;
        this.f4081d = liveConfiguration;
        this.f4082e = mediaMetadata;
        this.f4083f = clippingProperties;
        this.f4084g = clippingProperties;
        this.f4085h = requestMetadata;
    }
}
