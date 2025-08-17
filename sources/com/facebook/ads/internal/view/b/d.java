package com.facebook.ads.internal.view.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.internal.d.c;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.j.b;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.q.b.e;
import java.lang.ref.WeakReference;

public class d extends AsyncTask<String, Void, Bitmap[]> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f20934b = "d";

    /* renamed from: a  reason: collision with root package name */
    public boolean f20935a = false;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<Context> f20936c;

    /* renamed from: d  reason: collision with root package name */
    private final int f20937d;

    /* renamed from: e  reason: collision with root package name */
    private final WeakReference<ImageView> f20938e;

    /* renamed from: f  reason: collision with root package name */
    private final WeakReference<b> f20939f;

    /* renamed from: g  reason: collision with root package name */
    private final WeakReference<ViewGroup> f20940g;

    /* renamed from: h  reason: collision with root package name */
    private e f20941h;

    /* renamed from: i  reason: collision with root package name */
    private int f20942i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f20943j = -1;

    public d(ViewGroup viewGroup, int i2) {
        this.f20936c = new WeakReference<>(viewGroup.getContext());
        this.f20939f = null;
        this.f20938e = null;
        this.f20940g = new WeakReference<>(viewGroup);
        this.f20937d = i2;
    }

    public d(ImageView imageView) {
        this.f20936c = new WeakReference<>(imageView.getContext());
        this.f20939f = null;
        this.f20938e = new WeakReference<>(imageView);
        this.f20940g = null;
        this.f20937d = 0;
    }

    public d(b bVar) {
        this.f20936c = new WeakReference<>(bVar.getContext());
        this.f20939f = new WeakReference<>(bVar);
        this.f20938e = null;
        this.f20940g = null;
        this.f20937d = 0;
    }

    public d a() {
        this.f20942i = -1;
        this.f20943j = -1;
        return this;
    }

    public d a(int i2, int i3) {
        this.f20942i = i2;
        this.f20943j = i3;
        return this;
    }

    public d a(e eVar) {
        this.f20941h = eVar;
        return this;
    }

    public d a(boolean z2) {
        this.f20935a = z2;
        return this;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            e eVar = this.f20941h;
            if (eVar != null) {
                eVar.a(false);
                return;
            }
            return;
        }
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{str});
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Bitmap[] bitmapArr) {
        b bVar;
        ImageView imageView;
        WeakReference<ImageView> weakReference = this.f20938e;
        boolean z2 = false;
        if (!(weakReference == null || (imageView = weakReference.get()) == null)) {
            imageView.setImageBitmap(bitmapArr[0]);
        }
        WeakReference<b> weakReference2 = this.f20939f;
        if (!(weakReference2 == null || (bVar = weakReference2.get()) == null)) {
            bVar.a(bitmapArr[0], bitmapArr[1]);
        }
        WeakReference<ViewGroup> weakReference3 = this.f20940g;
        if (!(weakReference3 == null || weakReference3.get() == null || bitmapArr[1] == null)) {
            x.a((View) this.f20940g.get(), (Drawable) new BitmapDrawable(this.f20936c.get().getResources(), bitmapArr[1]));
        }
        e eVar = this.f20941h;
        if (eVar != null) {
            if (bitmapArr[0] != null) {
                z2 = true;
            }
            eVar.a(z2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bitmap[] doInBackground(String... strArr) {
        Bitmap bitmap;
        String str = strArr[0];
        Context context = this.f20936c.get();
        Bitmap bitmap2 = null;
        if (context == null) {
            return new Bitmap[]{null, null};
        }
        try {
            bitmap = c.a(context).a(str, this.f20942i, this.f20943j);
            try {
                WeakReference<b> weakReference = this.f20939f;
                boolean z2 = (weakReference == null || weakReference.get() == null) ? false : true;
                WeakReference<ViewGroup> weakReference2 = this.f20940g;
                boolean z3 = (weakReference2 == null || weakReference2.get() == null) ? false : true;
                if ((z2 || z3) && bitmap != null && !this.f20935a) {
                    e eVar = new e(bitmap);
                    int i2 = this.f20937d;
                    if (i2 == 0) {
                        i2 = Math.round(((float) bitmap.getWidth()) / 40.0f);
                    }
                    eVar.a(i2);
                    bitmap2 = eVar.a();
                }
            } catch (Throwable th) {
                th = th;
                Log.e(f20934b, "Error downloading image: " + str, th);
                b.a(a.a(th, (String) null));
                return new Bitmap[]{bitmap, bitmap2};
            }
        } catch (Throwable th2) {
            th = th2;
            bitmap = null;
            Log.e(f20934b, "Error downloading image: " + str, th);
            b.a(a.a(th, (String) null));
            return new Bitmap[]{bitmap, bitmap2};
        }
        return new Bitmap[]{bitmap, bitmap2};
    }
}
