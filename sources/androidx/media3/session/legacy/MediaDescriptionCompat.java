package androidx.media3.session.legacy;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.Assertions;

@SuppressLint({"BanParcelableUsage"})
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() {
        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return (MediaDescriptionCompat) Assertions.f(MediaDescriptionCompat.b(MediaDescription.CREATOR.createFromParcel(parcel)));
        }

        /* renamed from: b */
        public MediaDescriptionCompat[] newArray(int i2) {
            return new MediaDescriptionCompat[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final String f9697b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f9698c;

    /* renamed from: d  reason: collision with root package name */
    private final CharSequence f9699d;

    /* renamed from: e  reason: collision with root package name */
    private final CharSequence f9700e;

    /* renamed from: f  reason: collision with root package name */
    private final Bitmap f9701f;

    /* renamed from: g  reason: collision with root package name */
    private final Uri f9702g;

    /* renamed from: h  reason: collision with root package name */
    private final Bundle f9703h;

    /* renamed from: i  reason: collision with root package name */
    private final Uri f9704i;

    /* renamed from: j  reason: collision with root package name */
    private MediaDescription f9705j;

    private static class Api21Impl {
        private Api21Impl() {
        }

        static MediaDescription a(MediaDescription.Builder builder) {
            return builder.build();
        }

        static MediaDescription.Builder b() {
            return new MediaDescription.Builder();
        }

        static CharSequence c(MediaDescription mediaDescription) {
            return mediaDescription.getDescription();
        }

        static Bundle d(MediaDescription mediaDescription) {
            return mediaDescription.getExtras();
        }

        static Bitmap e(MediaDescription mediaDescription) {
            return mediaDescription.getIconBitmap();
        }

        static Uri f(MediaDescription mediaDescription) {
            return mediaDescription.getIconUri();
        }

        static String g(MediaDescription mediaDescription) {
            return mediaDescription.getMediaId();
        }

        static CharSequence h(MediaDescription mediaDescription) {
            return mediaDescription.getSubtitle();
        }

        static CharSequence i(MediaDescription mediaDescription) {
            return mediaDescription.getTitle();
        }

        static void j(MediaDescription.Builder builder, CharSequence charSequence) {
            builder.setDescription(charSequence);
        }

        static void k(MediaDescription.Builder builder, Bundle bundle) {
            builder.setExtras(bundle);
        }

        static void l(MediaDescription.Builder builder, Bitmap bitmap) {
            builder.setIconBitmap(bitmap);
        }

        static void m(MediaDescription.Builder builder, Uri uri) {
            builder.setIconUri(uri);
        }

        static void n(MediaDescription.Builder builder, String str) {
            builder.setMediaId(str);
        }

        static void o(MediaDescription.Builder builder, CharSequence charSequence) {
            builder.setSubtitle(charSequence);
        }

        static void p(MediaDescription.Builder builder, CharSequence charSequence) {
            builder.setTitle(charSequence);
        }
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        static Uri a(MediaDescription mediaDescription) {
            return mediaDescription.getMediaUri();
        }

        static void b(MediaDescription.Builder builder, Uri uri) {
            MediaDescription.Builder unused = builder.setMediaUri(uri);
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f9706a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f9707b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f9708c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f9709d;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f9710e;

        /* renamed from: f  reason: collision with root package name */
        private Uri f9711f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f9712g;

        /* renamed from: h  reason: collision with root package name */
        private Uri f9713h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f9706a, this.f9707b, this.f9708c, this.f9709d, this.f9710e, this.f9711f, this.f9712g, this.f9713h);
        }

        public Builder b(CharSequence charSequence) {
            this.f9709d = charSequence;
            return this;
        }

        public Builder c(Bundle bundle) {
            this.f9712g = bundle;
            return this;
        }

        public Builder d(Bitmap bitmap) {
            this.f9710e = bitmap;
            return this;
        }

        public Builder e(Uri uri) {
            this.f9711f = uri;
            return this;
        }

        public Builder f(String str) {
            this.f9706a = str;
            return this;
        }

        public Builder g(Uri uri) {
            this.f9713h = uri;
            return this;
        }

        public Builder h(CharSequence charSequence) {
            this.f9708c = charSequence;
            return this;
        }

        public Builder i(CharSequence charSequence) {
            this.f9707b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f9697b = str;
        this.f9698c = charSequence;
        this.f9699d = charSequence2;
        this.f9700e = charSequence3;
        this.f9701f = bitmap;
        this.f9702g = uri;
        this.f9703h = bundle;
        this.f9704i = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.media3.session.legacy.MediaDescriptionCompat b(java.lang.Object r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L_0x0085
            int r1 = android.os.Build.VERSION.SDK_INT
            androidx.media3.session.legacy.MediaDescriptionCompat$Builder r2 = new androidx.media3.session.legacy.MediaDescriptionCompat$Builder
            r2.<init>()
            android.media.MediaDescription r9 = (android.media.MediaDescription) r9
            java.lang.String r3 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.g(r9)
            r2.f(r3)
            java.lang.CharSequence r3 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.i(r9)
            r2.i(r3)
            java.lang.CharSequence r3 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.h(r9)
            r2.h(r3)
            java.lang.CharSequence r3 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.c(r9)
            r2.b(r3)
            android.graphics.Bitmap r3 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.e(r9)
            r2.d(r3)
            android.net.Uri r3 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.f(r9)
            r2.e(r3)
            android.os.Bundle r3 = androidx.media3.session.legacy.MediaDescriptionCompat.Api21Impl.d(r9)
            android.os.Bundle r3 = androidx.media3.session.legacy.MediaSessionCompat.b(r3)
            if (r3 == 0) goto L_0x0046
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r3)
            r3 = r4
        L_0x0046:
            if (r3 == 0) goto L_0x0069
            java.lang.String r4 = "android.support.v4.media.description.MEDIA_URI"
            android.os.Parcelable r5 = r3.getParcelable(r4)
            android.net.Uri r5 = (android.net.Uri) r5
            if (r5 == 0) goto L_0x006a
            java.lang.String r6 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r7 = r3.containsKey(r6)
            if (r7 == 0) goto L_0x0062
            int r7 = r3.size()
            r8 = 2
            if (r7 != r8) goto L_0x0062
            goto L_0x006b
        L_0x0062:
            r3.remove(r4)
            r3.remove(r6)
            goto L_0x006a
        L_0x0069:
            r5 = r0
        L_0x006a:
            r0 = r3
        L_0x006b:
            r2.c(r0)
            if (r5 == 0) goto L_0x0074
            r2.g(r5)
            goto L_0x007f
        L_0x0074:
            r0 = 23
            if (r1 < r0) goto L_0x007f
            android.net.Uri r0 = androidx.media3.session.legacy.MediaDescriptionCompat.Api23Impl.a(r9)
            r2.g(r0)
        L_0x007f:
            androidx.media3.session.legacy.MediaDescriptionCompat r0 = r2.a()
            r0.f9705j = r9
        L_0x0085:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.legacy.MediaDescriptionCompat.b(java.lang.Object):androidx.media3.session.legacy.MediaDescriptionCompat");
    }

    public Object c() {
        Bundle bundle;
        MediaDescription mediaDescription = this.f9705j;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        MediaDescription.Builder b2 = Api21Impl.b();
        Api21Impl.n(b2, this.f9697b);
        Api21Impl.p(b2, this.f9698c);
        Api21Impl.o(b2, this.f9699d);
        Api21Impl.j(b2, this.f9700e);
        Api21Impl.l(b2, this.f9701f);
        Api21Impl.m(b2, this.f9702g);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23 || this.f9704i == null) {
            Api21Impl.k(b2, this.f9703h);
        } else {
            if (this.f9703h == null) {
                bundle = new Bundle();
                bundle.putBoolean(android.support.v4.media.MediaDescriptionCompat.DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
            } else {
                bundle = new Bundle(this.f9703h);
            }
            bundle.putParcelable(android.support.v4.media.MediaDescriptionCompat.DESCRIPTION_KEY_MEDIA_URI, this.f9704i);
            Api21Impl.k(b2, bundle);
        }
        if (i2 >= 23) {
            Api23Impl.b(b2, this.f9704i);
        }
        MediaDescription a2 = Api21Impl.a(b2);
        this.f9705j = a2;
        return a2;
    }

    public String d() {
        return this.f9697b;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f9698c + ", " + this.f9699d + ", " + this.f9700e;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        ((MediaDescription) c()).writeToParcel(parcel, i2);
    }
}
