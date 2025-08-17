package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.core.util.Preconditions;
import java.util.Objects;

public final class ContentInfoCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Compat f2729a;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final BuilderCompat f2730a;

        public Builder(ClipData clipData, int i2) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f2730a = new BuilderCompat31Impl(clipData, i2);
            } else {
                this.f2730a = new BuilderCompatImpl(clipData, i2);
            }
        }

        public ContentInfoCompat a() {
            return this.f2730a.build();
        }

        public Builder b(Bundle bundle) {
            this.f2730a.setExtras(bundle);
            return this;
        }

        public Builder c(int i2) {
            this.f2730a.setFlags(i2);
            return this;
        }

        public Builder d(Uri uri) {
            this.f2730a.a(uri);
            return this;
        }
    }

    private interface BuilderCompat {
        void a(Uri uri);

        ContentInfoCompat build();

        void setExtras(Bundle bundle);

        void setFlags(int i2);
    }

    private static final class BuilderCompat31Impl implements BuilderCompat {

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo.Builder f2731a;

        BuilderCompat31Impl(ClipData clipData, int i2) {
            this.f2731a = new ContentInfo.Builder(clipData, i2);
        }

        public void a(Uri uri) {
            ContentInfo.Builder unused = this.f2731a.setLinkUri(uri);
        }

        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.f2731a.build()));
        }

        public void setExtras(Bundle bundle) {
            ContentInfo.Builder unused = this.f2731a.setExtras(bundle);
        }

        public void setFlags(int i2) {
            ContentInfo.Builder unused = this.f2731a.setFlags(i2);
        }
    }

    private static final class BuilderCompatImpl implements BuilderCompat {

        /* renamed from: a  reason: collision with root package name */
        ClipData f2732a;

        /* renamed from: b  reason: collision with root package name */
        int f2733b;

        /* renamed from: c  reason: collision with root package name */
        int f2734c;

        /* renamed from: d  reason: collision with root package name */
        Uri f2735d;

        /* renamed from: e  reason: collision with root package name */
        Bundle f2736e;

        BuilderCompatImpl(ClipData clipData, int i2) {
            this.f2732a = clipData;
            this.f2733b = i2;
        }

        public void a(Uri uri) {
            this.f2735d = uri;
        }

        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        public void setExtras(Bundle bundle) {
            this.f2736e = bundle;
        }

        public void setFlags(int i2) {
            this.f2734c = i2;
        }
    }

    private interface Compat {
        ContentInfo a();

        int b();

        ClipData c();

        int getFlags();
    }

    private static final class Compat31Impl implements Compat {

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo f2737a;

        Compat31Impl(ContentInfo contentInfo) {
            this.f2737a = (ContentInfo) Preconditions.g(contentInfo);
        }

        public ContentInfo a() {
            return this.f2737a;
        }

        public int b() {
            return this.f2737a.getSource();
        }

        public ClipData c() {
            return this.f2737a.getClip();
        }

        public int getFlags() {
            return this.f2737a.getFlags();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f2737a + "}";
        }
    }

    private static final class CompatImpl implements Compat {

        /* renamed from: a  reason: collision with root package name */
        private final ClipData f2738a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2739b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2740c;

        /* renamed from: d  reason: collision with root package name */
        private final Uri f2741d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f2742e;

        CompatImpl(BuilderCompatImpl builderCompatImpl) {
            this.f2738a = (ClipData) Preconditions.g(builderCompatImpl.f2732a);
            this.f2739b = Preconditions.c(builderCompatImpl.f2733b, 0, 5, "source");
            this.f2740c = Preconditions.f(builderCompatImpl.f2734c, 1);
            this.f2741d = builderCompatImpl.f2735d;
            this.f2742e = builderCompatImpl.f2736e;
        }

        public ContentInfo a() {
            return null;
        }

        public int b() {
            return this.f2739b;
        }

        public ClipData c() {
            return this.f2738a;
        }

        public int getFlags() {
            return this.f2740c;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f2738a.getDescription());
            sb.append(", source=");
            sb.append(ContentInfoCompat.e(this.f2739b));
            sb.append(", flags=");
            sb.append(ContentInfoCompat.a(this.f2740c));
            String str2 = "";
            if (this.f2741d == null) {
                str = str2;
            } else {
                str = ", hasLinkUri(" + this.f2741d.toString().length() + ")";
            }
            sb.append(str);
            if (this.f2742e != null) {
                str2 = ", hasExtras";
            }
            sb.append(str2);
            sb.append("}");
            return sb.toString();
        }
    }

    ContentInfoCompat(Compat compat) {
        this.f2729a = compat;
    }

    static String a(int i2) {
        if ((i2 & 1) != 0) {
            return "FLAG_CONVERT_TO_PLAIN_TEXT";
        }
        return String.valueOf(i2);
    }

    static String e(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? String.valueOf(i2) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public static ContentInfoCompat g(ContentInfo contentInfo) {
        return new ContentInfoCompat(new Compat31Impl(contentInfo));
    }

    public ClipData b() {
        return this.f2729a.c();
    }

    public int c() {
        return this.f2729a.getFlags();
    }

    public int d() {
        return this.f2729a.b();
    }

    public ContentInfo f() {
        ContentInfo a2 = this.f2729a.a();
        Objects.requireNonNull(a2);
        ContentInfo contentInfo = a2;
        return a2;
    }

    public String toString() {
        return this.f2729a.toString();
    }
}
