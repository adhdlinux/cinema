package androidx.palette.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseBooleanArray;
import androidx.collection.ArrayMap;
import androidx.core.graphics.ColorUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class Palette {

    /* renamed from: f  reason: collision with root package name */
    static final Filter f10774f = new Filter() {
        private boolean b(float[] fArr) {
            return fArr[2] <= 0.05f;
        }

        private boolean c(float[] fArr) {
            float f2 = fArr[0];
            return f2 >= 10.0f && f2 <= 37.0f && fArr[1] <= 0.82f;
        }

        private boolean d(float[] fArr) {
            return fArr[2] >= 0.95f;
        }

        public boolean a(int i2, float[] fArr) {
            return !d(fArr) && !b(fArr) && !c(fArr);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final List<Swatch> f10775a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Target> f10776b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Target, Swatch> f10777c = new ArrayMap();

    /* renamed from: d  reason: collision with root package name */
    private final SparseBooleanArray f10778d = new SparseBooleanArray();

    /* renamed from: e  reason: collision with root package name */
    private final Swatch f10779e = a();

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final List<Swatch> f10780a;

        /* renamed from: b  reason: collision with root package name */
        private final Bitmap f10781b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Target> f10782c;

        /* renamed from: d  reason: collision with root package name */
        private int f10783d = 16;

        /* renamed from: e  reason: collision with root package name */
        private int f10784e = 12544;

        /* renamed from: f  reason: collision with root package name */
        private int f10785f = -1;

        /* renamed from: g  reason: collision with root package name */
        private final List<Filter> f10786g;

        /* renamed from: h  reason: collision with root package name */
        private Rect f10787h;

        public Builder(Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.f10782c = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f10786g = arrayList2;
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            arrayList2.add(Palette.f10774f);
            this.f10781b = bitmap;
            this.f10780a = null;
            arrayList.add(Target.f10799e);
            arrayList.add(Target.f10800f);
            arrayList.add(Target.f10801g);
            arrayList.add(Target.f10802h);
            arrayList.add(Target.f10803i);
            arrayList.add(Target.f10804j);
        }

        private int[] c(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.f10787h;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.f10787h.height();
            int[] iArr2 = new int[(width2 * height2)];
            for (int i2 = 0; i2 < height2; i2++) {
                Rect rect2 = this.f10787h;
                System.arraycopy(iArr, ((rect2.top + i2) * width) + rect2.left, iArr2, i2 * width2, width2);
            }
            return iArr2;
        }

        private Bitmap e(Bitmap bitmap) {
            int max;
            int i2;
            double d2 = -1.0d;
            if (this.f10784e > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i3 = this.f10784e;
                if (width > i3) {
                    d2 = Math.sqrt(((double) i3) / ((double) width));
                }
            } else if (this.f10785f > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i2 = this.f10785f)) {
                d2 = ((double) i2) / ((double) max);
            }
            if (d2 <= 0.0d) {
                return bitmap;
            }
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * d2), (int) Math.ceil(((double) bitmap.getHeight()) * d2), false);
        }

        public AsyncTask<Bitmap, Void, Palette> a(final PaletteAsyncListener paletteAsyncListener) {
            if (paletteAsyncListener != null) {
                return new AsyncTask<Bitmap, Void, Palette>() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public Palette doInBackground(Bitmap... bitmapArr) {
                        try {
                            return Builder.this.b();
                        } catch (Exception e2) {
                            Log.e("Palette", "Exception thrown during async generate", e2);
                            return null;
                        }
                    }

                    /* access modifiers changed from: protected */
                    /* renamed from: b */
                    public void onPostExecute(Palette palette) {
                        paletteAsyncListener.a(palette);
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[]{this.f10781b});
            }
            throw new IllegalArgumentException("listener can not be null");
        }

        public Palette b() {
            List<Swatch> list;
            Filter[] filterArr;
            Bitmap bitmap = this.f10781b;
            if (bitmap != null) {
                Bitmap e2 = e(bitmap);
                Rect rect = this.f10787h;
                if (!(e2 == this.f10781b || rect == null)) {
                    double width = ((double) e2.getWidth()) / ((double) this.f10781b.getWidth());
                    rect.left = (int) Math.floor(((double) rect.left) * width);
                    rect.top = (int) Math.floor(((double) rect.top) * width);
                    rect.right = Math.min((int) Math.ceil(((double) rect.right) * width), e2.getWidth());
                    rect.bottom = Math.min((int) Math.ceil(((double) rect.bottom) * width), e2.getHeight());
                }
                int[] c2 = c(e2);
                int i2 = this.f10783d;
                if (this.f10786g.isEmpty()) {
                    filterArr = null;
                } else {
                    List<Filter> list2 = this.f10786g;
                    filterArr = (Filter[]) list2.toArray(new Filter[list2.size()]);
                }
                ColorCutQuantizer colorCutQuantizer = new ColorCutQuantizer(c2, i2, filterArr);
                if (e2 != this.f10781b) {
                    e2.recycle();
                }
                list = colorCutQuantizer.d();
            } else {
                list = this.f10780a;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            Palette palette = new Palette(list, this.f10782c);
            palette.c();
            return palette;
        }

        public Builder d(int i2) {
            this.f10783d = i2;
            return this;
        }
    }

    public interface Filter {
        boolean a(int i2, float[] fArr);
    }

    public interface PaletteAsyncListener {
        void a(Palette palette);
    }

    public static final class Swatch {

        /* renamed from: a  reason: collision with root package name */
        private final int f10790a;

        /* renamed from: b  reason: collision with root package name */
        private final int f10791b;

        /* renamed from: c  reason: collision with root package name */
        private final int f10792c;

        /* renamed from: d  reason: collision with root package name */
        private final int f10793d;

        /* renamed from: e  reason: collision with root package name */
        private final int f10794e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f10795f;

        /* renamed from: g  reason: collision with root package name */
        private int f10796g;

        /* renamed from: h  reason: collision with root package name */
        private int f10797h;

        /* renamed from: i  reason: collision with root package name */
        private float[] f10798i;

        public Swatch(int i2, int i3) {
            this.f10790a = Color.red(i2);
            this.f10791b = Color.green(i2);
            this.f10792c = Color.blue(i2);
            this.f10793d = i2;
            this.f10794e = i3;
        }

        private void a() {
            int i2;
            int i3;
            if (!this.f10795f) {
                int g2 = ColorUtils.g(-1, this.f10793d, 4.5f);
                int g3 = ColorUtils.g(-1, this.f10793d, 3.0f);
                if (g2 == -1 || g3 == -1) {
                    int g4 = ColorUtils.g(-16777216, this.f10793d, 4.5f);
                    int g5 = ColorUtils.g(-16777216, this.f10793d, 3.0f);
                    if (g4 == -1 || g5 == -1) {
                        if (g2 != -1) {
                            i2 = ColorUtils.p(-1, g2);
                        } else {
                            i2 = ColorUtils.p(-16777216, g4);
                        }
                        this.f10797h = i2;
                        if (g3 != -1) {
                            i3 = ColorUtils.p(-1, g3);
                        } else {
                            i3 = ColorUtils.p(-16777216, g5);
                        }
                        this.f10796g = i3;
                        this.f10795f = true;
                        return;
                    }
                    this.f10797h = ColorUtils.p(-16777216, g4);
                    this.f10796g = ColorUtils.p(-16777216, g5);
                    this.f10795f = true;
                    return;
                }
                this.f10797h = ColorUtils.p(-1, g2);
                this.f10796g = ColorUtils.p(-1, g3);
                this.f10795f = true;
            }
        }

        public int b() {
            a();
            return this.f10797h;
        }

        public float[] c() {
            if (this.f10798i == null) {
                this.f10798i = new float[3];
            }
            ColorUtils.a(this.f10790a, this.f10791b, this.f10792c, this.f10798i);
            return this.f10798i;
        }

        public int d() {
            return this.f10794e;
        }

        public int e() {
            return this.f10793d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Swatch.class != obj.getClass()) {
                return false;
            }
            Swatch swatch = (Swatch) obj;
            if (this.f10794e == swatch.f10794e && this.f10793d == swatch.f10793d) {
                return true;
            }
            return false;
        }

        public int f() {
            a();
            return this.f10796g;
        }

        public int hashCode() {
            return (this.f10793d * 31) + this.f10794e;
        }

        public String toString() {
            return Swatch.class.getSimpleName() + " [RGB: #" + Integer.toHexString(e()) + ']' + " [HSL: " + Arrays.toString(c()) + ']' + " [Population: " + this.f10794e + ']' + " [Title Text: #" + Integer.toHexString(f()) + ']' + " [Body Text: #" + Integer.toHexString(b()) + ']';
        }
    }

    Palette(List<Swatch> list, List<Target> list2) {
        this.f10775a = list;
        this.f10776b = list2;
    }

    private Swatch a() {
        int size = this.f10775a.size();
        int i2 = Integer.MIN_VALUE;
        Swatch swatch = null;
        for (int i3 = 0; i3 < size; i3++) {
            Swatch swatch2 = this.f10775a.get(i3);
            if (swatch2.d() > i2) {
                i2 = swatch2.d();
                swatch = swatch2;
            }
        }
        return swatch;
    }

    public static Builder b(Bitmap bitmap) {
        return new Builder(bitmap);
    }

    private float d(Swatch swatch, Target target) {
        int i2;
        float f2;
        float f3;
        float[] c2 = swatch.c();
        Swatch swatch2 = this.f10779e;
        if (swatch2 != null) {
            i2 = swatch2.d();
        } else {
            i2 = 1;
        }
        float f4 = 0.0f;
        if (target.g() > 0.0f) {
            f2 = target.g() * (1.0f - Math.abs(c2[1] - target.i()));
        } else {
            f2 = 0.0f;
        }
        if (target.a() > 0.0f) {
            f3 = target.a() * (1.0f - Math.abs(c2[2] - target.h()));
        } else {
            f3 = 0.0f;
        }
        if (target.f() > 0.0f) {
            f4 = target.f() * (((float) swatch.d()) / ((float) i2));
        }
        return f2 + f3 + f4;
    }

    private Swatch e(Target target) {
        Swatch k2 = k(target);
        if (k2 != null && target.j()) {
            this.f10778d.append(k2.e(), true);
        }
        return k2;
    }

    private Swatch k(Target target) {
        int size = this.f10775a.size();
        float f2 = 0.0f;
        Swatch swatch = null;
        for (int i2 = 0; i2 < size; i2++) {
            Swatch swatch2 = this.f10775a.get(i2);
            if (p(swatch2, target)) {
                float d2 = d(swatch2, target);
                if (swatch == null || d2 > f2) {
                    swatch = swatch2;
                    f2 = d2;
                }
            }
        }
        return swatch;
    }

    private boolean p(Swatch swatch, Target target) {
        float[] c2 = swatch.c();
        if (c2[1] < target.e() || c2[1] > target.c() || c2[2] < target.d() || c2[2] > target.b() || this.f10778d.get(swatch.e())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int size = this.f10776b.size();
        for (int i2 = 0; i2 < size; i2++) {
            Target target = this.f10776b.get(i2);
            target.k();
            this.f10777c.put(target, e(target));
        }
        this.f10778d.clear();
    }

    public Swatch f() {
        return m(Target.f10804j);
    }

    public Swatch g() {
        return m(Target.f10801g);
    }

    public int h(int i2) {
        Swatch swatch = this.f10779e;
        return swatch != null ? swatch.e() : i2;
    }

    public Swatch i() {
        return m(Target.f10802h);
    }

    public Swatch j() {
        return m(Target.f10799e);
    }

    public Swatch l() {
        return m(Target.f10803i);
    }

    public Swatch m(Target target) {
        return this.f10777c.get(target);
    }

    public List<Swatch> n() {
        return Collections.unmodifiableList(this.f10775a);
    }

    public Swatch o() {
        return m(Target.f10800f);
    }
}
