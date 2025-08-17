package com.movie.ui.widget.glidepalette;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.Log;
import android.util.LruCache;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.palette.graphics.Palette;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class BitmapPalette {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final LruCache<String, Palette> f33672e = new LruCache<>(40);

    /* renamed from: a  reason: collision with root package name */
    protected String f33673a;

    /* renamed from: b  reason: collision with root package name */
    protected LinkedList<PaletteTarget> f33674b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    protected ArrayList<CallBack> f33675c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f33676d;

    public interface CallBack {
        void a(Palette palette);
    }

    private void c(PaletteTarget paletteTarget, Pair<View, Integer> pair, int i2) {
        Drawable background = ((View) pair.first).getBackground();
        Drawable[] drawableArr = new Drawable[2];
        if (background == null) {
            background = new ColorDrawable(((View) pair.first).getSolidColor());
        }
        drawableArr[0] = background;
        drawableArr[1] = new ColorDrawable(i2);
        TransitionDrawable transitionDrawable = new TransitionDrawable(drawableArr);
        ((View) pair.first).setBackground(transitionDrawable);
        transitionDrawable.startTransition(paletteTarget.f33684e);
    }

    protected static int d(Palette.Swatch swatch, int i2) {
        if (swatch == null) {
            Log.e("BitmapPalette", "error while generating Palette, null palette returned");
            return 0;
        } else if (i2 == 0) {
            return swatch.e();
        } else {
            if (i2 == 1) {
                return swatch.f();
            }
            if (i2 != 2) {
                return 0;
            }
            return swatch.b();
        }
    }

    /* access modifiers changed from: protected */
    public void b(Palette palette, boolean z2) {
        Palette.Swatch swatch;
        ArrayList<Pair<View, Integer>> arrayList;
        ArrayList<CallBack> arrayList2 = this.f33675c;
        if (arrayList2 != null) {
            Iterator<CallBack> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().a(palette);
            }
            if (palette != null) {
                Iterator<PaletteTarget> it3 = this.f33674b.iterator();
                while (it3.hasNext()) {
                    PaletteTarget next = it3.next();
                    int i2 = next.f33680a;
                    if (i2 == 0) {
                        swatch = palette.o();
                    } else if (i2 == 1) {
                        swatch = palette.g();
                    } else if (i2 == 2) {
                        swatch = palette.j();
                    } else if (i2 == 3) {
                        swatch = palette.l();
                    } else if (i2 == 4) {
                        swatch = palette.f();
                    } else if (i2 != 5) {
                        swatch = null;
                    } else {
                        swatch = palette.i();
                    }
                    if (swatch != null && (arrayList = next.f33681b) != null) {
                        Iterator<Pair<View, Integer>> it4 = arrayList.iterator();
                        while (it4.hasNext()) {
                            Pair next2 = it4.next();
                            int d2 = d(swatch, ((Integer) next2.second).intValue());
                            if (z2 || !next.f33683d) {
                                ((View) next2.first).setBackgroundColor(d2);
                            } else {
                                c(next, next2, d2);
                            }
                        }
                        ArrayList<Pair<TextView, Integer>> arrayList3 = next.f33682c;
                        if (arrayList3 != null) {
                            Iterator<Pair<TextView, Integer>> it5 = arrayList3.iterator();
                            while (it5.hasNext()) {
                                Pair next3 = it5.next();
                                ((TextView) next3.first).setTextColor(d(swatch, ((Integer) next3.second).intValue()));
                            }
                            next.a();
                            this.f33675c = null;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public BitmapPalette e(CallBack callBack) {
        if (callBack != null) {
            this.f33675c.add(callBack);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void f(Bitmap bitmap) {
        Palette palette;
        final boolean z2 = this.f33676d;
        if (z2 || (palette = f33672e.get(this.f33673a)) == null) {
            new Palette.Builder(bitmap).a(new Palette.PaletteAsyncListener() {
                public void a(Palette palette) {
                    if (!z2) {
                        BitmapPalette.f33672e.put(BitmapPalette.this.f33673a, palette);
                    }
                    BitmapPalette.this.b(palette, false);
                }
            });
        } else {
            b(palette, true);
        }
    }
}
