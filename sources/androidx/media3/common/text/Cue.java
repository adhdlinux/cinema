package androidx.media3.common.text;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.checkerframework.dataflow.qual.Pure;

public final class Cue {
    private static final String A = Util.B0(6);
    private static final String B = Util.B0(7);
    private static final String C = Util.B0(8);
    private static final String D = Util.B0(9);
    private static final String E = Util.B0(10);
    private static final String F = Util.B0(11);
    private static final String G = Util.B0(12);
    private static final String H = Util.B0(13);
    private static final String I = Util.B0(14);
    private static final String J = Util.B0(15);
    private static final String K = Util.B0(16);
    @Deprecated

    /* renamed from: r  reason: collision with root package name */
    public static final Cue f4549r = new Builder().o("").a();

    /* renamed from: s  reason: collision with root package name */
    private static final String f4550s = Util.B0(0);

    /* renamed from: t  reason: collision with root package name */
    private static final String f4551t = Util.B0(17);

    /* renamed from: u  reason: collision with root package name */
    private static final String f4552u = Util.B0(1);

    /* renamed from: v  reason: collision with root package name */
    private static final String f4553v = Util.B0(2);

    /* renamed from: w  reason: collision with root package name */
    private static final String f4554w = Util.B0(3);

    /* renamed from: x  reason: collision with root package name */
    private static final String f4555x = Util.B0(18);

    /* renamed from: y  reason: collision with root package name */
    private static final String f4556y = Util.B0(4);

    /* renamed from: z  reason: collision with root package name */
    private static final String f4557z = Util.B0(5);

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f4558a;

    /* renamed from: b  reason: collision with root package name */
    public final Layout.Alignment f4559b;

    /* renamed from: c  reason: collision with root package name */
    public final Layout.Alignment f4560c;

    /* renamed from: d  reason: collision with root package name */
    public final Bitmap f4561d;

    /* renamed from: e  reason: collision with root package name */
    public final float f4562e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4563f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4564g;

    /* renamed from: h  reason: collision with root package name */
    public final float f4565h;

    /* renamed from: i  reason: collision with root package name */
    public final int f4566i;

    /* renamed from: j  reason: collision with root package name */
    public final float f4567j;

    /* renamed from: k  reason: collision with root package name */
    public final float f4568k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f4569l;

    /* renamed from: m  reason: collision with root package name */
    public final int f4570m;

    /* renamed from: n  reason: collision with root package name */
    public final int f4571n;

    /* renamed from: o  reason: collision with root package name */
    public final float f4572o;

    /* renamed from: p  reason: collision with root package name */
    public final int f4573p;

    /* renamed from: q  reason: collision with root package name */
    public final float f4574q;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private CharSequence f4575a;

        /* renamed from: b  reason: collision with root package name */
        private Bitmap f4576b;

        /* renamed from: c  reason: collision with root package name */
        private Layout.Alignment f4577c;

        /* renamed from: d  reason: collision with root package name */
        private Layout.Alignment f4578d;

        /* renamed from: e  reason: collision with root package name */
        private float f4579e;

        /* renamed from: f  reason: collision with root package name */
        private int f4580f;

        /* renamed from: g  reason: collision with root package name */
        private int f4581g;

        /* renamed from: h  reason: collision with root package name */
        private float f4582h;

        /* renamed from: i  reason: collision with root package name */
        private int f4583i;

        /* renamed from: j  reason: collision with root package name */
        private int f4584j;

        /* renamed from: k  reason: collision with root package name */
        private float f4585k;

        /* renamed from: l  reason: collision with root package name */
        private float f4586l;

        /* renamed from: m  reason: collision with root package name */
        private float f4587m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f4588n;

        /* renamed from: o  reason: collision with root package name */
        private int f4589o;

        /* renamed from: p  reason: collision with root package name */
        private int f4590p;

        /* renamed from: q  reason: collision with root package name */
        private float f4591q;

        public Cue a() {
            return new Cue(this.f4575a, this.f4577c, this.f4578d, this.f4576b, this.f4579e, this.f4580f, this.f4581g, this.f4582h, this.f4583i, this.f4584j, this.f4585k, this.f4586l, this.f4587m, this.f4588n, this.f4589o, this.f4590p, this.f4591q);
        }

        public Builder b() {
            this.f4588n = false;
            return this;
        }

        @Pure
        public int c() {
            return this.f4581g;
        }

        @Pure
        public int d() {
            return this.f4583i;
        }

        @Pure
        public CharSequence e() {
            return this.f4575a;
        }

        public Builder f(Bitmap bitmap) {
            this.f4576b = bitmap;
            return this;
        }

        public Builder g(float f2) {
            this.f4587m = f2;
            return this;
        }

        public Builder h(float f2, int i2) {
            this.f4579e = f2;
            this.f4580f = i2;
            return this;
        }

        public Builder i(int i2) {
            this.f4581g = i2;
            return this;
        }

        public Builder j(Layout.Alignment alignment) {
            this.f4578d = alignment;
            return this;
        }

        public Builder k(float f2) {
            this.f4582h = f2;
            return this;
        }

        public Builder l(int i2) {
            this.f4583i = i2;
            return this;
        }

        public Builder m(float f2) {
            this.f4591q = f2;
            return this;
        }

        public Builder n(float f2) {
            this.f4586l = f2;
            return this;
        }

        public Builder o(CharSequence charSequence) {
            this.f4575a = charSequence;
            return this;
        }

        public Builder p(Layout.Alignment alignment) {
            this.f4577c = alignment;
            return this;
        }

        public Builder q(float f2, int i2) {
            this.f4585k = f2;
            this.f4584j = i2;
            return this;
        }

        public Builder r(int i2) {
            this.f4590p = i2;
            return this;
        }

        public Builder s(int i2) {
            this.f4589o = i2;
            this.f4588n = true;
            return this;
        }

        public Builder() {
            this.f4575a = null;
            this.f4576b = null;
            this.f4577c = null;
            this.f4578d = null;
            this.f4579e = -3.4028235E38f;
            this.f4580f = Integer.MIN_VALUE;
            this.f4581g = Integer.MIN_VALUE;
            this.f4582h = -3.4028235E38f;
            this.f4583i = Integer.MIN_VALUE;
            this.f4584j = Integer.MIN_VALUE;
            this.f4585k = -3.4028235E38f;
            this.f4586l = -3.4028235E38f;
            this.f4587m = -3.4028235E38f;
            this.f4588n = false;
            this.f4589o = -16777216;
            this.f4590p = Integer.MIN_VALUE;
        }

        private Builder(Cue cue) {
            this.f4575a = cue.f4558a;
            this.f4576b = cue.f4561d;
            this.f4577c = cue.f4559b;
            this.f4578d = cue.f4560c;
            this.f4579e = cue.f4562e;
            this.f4580f = cue.f4563f;
            this.f4581g = cue.f4564g;
            this.f4582h = cue.f4565h;
            this.f4583i = cue.f4566i;
            this.f4584j = cue.f4571n;
            this.f4585k = cue.f4572o;
            this.f4586l = cue.f4567j;
            this.f4587m = cue.f4568k;
            this.f4588n = cue.f4569l;
            this.f4589o = cue.f4570m;
            this.f4590p = cue.f4573p;
            this.f4591q = cue.f4574q;
        }
    }

    public static Cue b(Bundle bundle) {
        Builder builder = new Builder();
        CharSequence charSequence = bundle.getCharSequence(f4550s);
        if (charSequence != null) {
            builder.o(charSequence);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(f4551t);
            if (parcelableArrayList != null) {
                SpannableString valueOf = SpannableString.valueOf(charSequence);
                Iterator it2 = parcelableArrayList.iterator();
                while (it2.hasNext()) {
                    CustomSpanBundler.c((Bundle) it2.next(), valueOf);
                }
                builder.o(valueOf);
            }
        }
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(f4552u);
        if (alignment != null) {
            builder.p(alignment);
        }
        Layout.Alignment alignment2 = (Layout.Alignment) bundle.getSerializable(f4553v);
        if (alignment2 != null) {
            builder.j(alignment2);
        }
        Bitmap bitmap = (Bitmap) bundle.getParcelable(f4554w);
        if (bitmap != null) {
            builder.f(bitmap);
        } else {
            byte[] byteArray = bundle.getByteArray(f4555x);
            if (byteArray != null) {
                builder.f(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));
            }
        }
        String str = f4556y;
        if (bundle.containsKey(str)) {
            String str2 = f4557z;
            if (bundle.containsKey(str2)) {
                builder.h(bundle.getFloat(str), bundle.getInt(str2));
            }
        }
        String str3 = A;
        if (bundle.containsKey(str3)) {
            builder.i(bundle.getInt(str3));
        }
        String str4 = B;
        if (bundle.containsKey(str4)) {
            builder.k(bundle.getFloat(str4));
        }
        String str5 = C;
        if (bundle.containsKey(str5)) {
            builder.l(bundle.getInt(str5));
        }
        String str6 = E;
        if (bundle.containsKey(str6)) {
            String str7 = D;
            if (bundle.containsKey(str7)) {
                builder.q(bundle.getFloat(str6), bundle.getInt(str7));
            }
        }
        String str8 = F;
        if (bundle.containsKey(str8)) {
            builder.n(bundle.getFloat(str8));
        }
        String str9 = G;
        if (bundle.containsKey(str9)) {
            builder.g(bundle.getFloat(str9));
        }
        String str10 = H;
        if (bundle.containsKey(str10)) {
            builder.s(bundle.getInt(str10));
        }
        if (!bundle.getBoolean(I, false)) {
            builder.b();
        }
        String str11 = J;
        if (bundle.containsKey(str11)) {
            builder.r(bundle.getInt(str11));
        }
        String str12 = K;
        if (bundle.containsKey(str12)) {
            builder.m(bundle.getFloat(str12));
        }
        return builder.a();
    }

    private Bundle c() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.f4558a;
        if (charSequence != null) {
            bundle.putCharSequence(f4550s, charSequence);
            CharSequence charSequence2 = this.f4558a;
            if (charSequence2 instanceof Spanned) {
                ArrayList<Bundle> a2 = CustomSpanBundler.a((Spanned) charSequence2);
                if (!a2.isEmpty()) {
                    bundle.putParcelableArrayList(f4551t, a2);
                }
            }
        }
        bundle.putSerializable(f4552u, this.f4559b);
        bundle.putSerializable(f4553v, this.f4560c);
        bundle.putFloat(f4556y, this.f4562e);
        bundle.putInt(f4557z, this.f4563f);
        bundle.putInt(A, this.f4564g);
        bundle.putFloat(B, this.f4565h);
        bundle.putInt(C, this.f4566i);
        bundle.putInt(D, this.f4571n);
        bundle.putFloat(E, this.f4572o);
        bundle.putFloat(F, this.f4567j);
        bundle.putFloat(G, this.f4568k);
        bundle.putBoolean(I, this.f4569l);
        bundle.putInt(H, this.f4570m);
        bundle.putInt(J, this.f4573p);
        bundle.putFloat(K, this.f4574q);
        return bundle;
    }

    public Builder a() {
        return new Builder();
    }

    public Bundle d() {
        Bundle c2 = c();
        if (this.f4561d != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Assertions.h(this.f4561d.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream));
            c2.putByteArray(f4555x, byteArrayOutputStream.toByteArray());
        }
        return c2;
    }

    public boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || Cue.class != obj.getClass()) {
            return false;
        }
        Cue cue = (Cue) obj;
        if (TextUtils.equals(this.f4558a, cue.f4558a) && this.f4559b == cue.f4559b && this.f4560c == cue.f4560c && ((bitmap = this.f4561d) != null ? !((bitmap2 = cue.f4561d) == null || !bitmap.sameAs(bitmap2)) : cue.f4561d == null) && this.f4562e == cue.f4562e && this.f4563f == cue.f4563f && this.f4564g == cue.f4564g && this.f4565h == cue.f4565h && this.f4566i == cue.f4566i && this.f4567j == cue.f4567j && this.f4568k == cue.f4568k && this.f4569l == cue.f4569l && this.f4570m == cue.f4570m && this.f4571n == cue.f4571n && this.f4572o == cue.f4572o && this.f4573p == cue.f4573p && this.f4574q == cue.f4574q) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(this.f4558a, this.f4559b, this.f4560c, this.f4561d, Float.valueOf(this.f4562e), Integer.valueOf(this.f4563f), Integer.valueOf(this.f4564g), Float.valueOf(this.f4565h), Integer.valueOf(this.f4566i), Float.valueOf(this.f4567j), Float.valueOf(this.f4568k), Boolean.valueOf(this.f4569l), Integer.valueOf(this.f4570m), Integer.valueOf(this.f4571n), Float.valueOf(this.f4572o), Integer.valueOf(this.f4573p), Float.valueOf(this.f4574q));
    }

    private Cue(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f2, int i2, int i3, float f3, int i4, int i5, float f4, float f5, float f6, boolean z2, int i6, int i7, float f7) {
        CharSequence charSequence2 = charSequence;
        Bitmap bitmap2 = bitmap;
        if (charSequence2 == null) {
            Assertions.f(bitmap);
        } else {
            Assertions.a(bitmap2 == null);
        }
        if (charSequence2 instanceof Spanned) {
            this.f4558a = SpannedString.valueOf(charSequence);
        } else if (charSequence2 != null) {
            this.f4558a = charSequence.toString();
        } else {
            this.f4558a = null;
        }
        this.f4559b = alignment;
        this.f4560c = alignment2;
        this.f4561d = bitmap2;
        this.f4562e = f2;
        this.f4563f = i2;
        this.f4564g = i3;
        this.f4565h = f3;
        this.f4566i = i4;
        this.f4567j = f5;
        this.f4568k = f6;
        this.f4569l = z2;
        this.f4570m = i6;
        this.f4571n = i5;
        this.f4572o = f4;
        this.f4573p = i7;
        this.f4574q = f7;
    }
}
