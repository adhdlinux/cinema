package com.startapp;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import com.startapp.sdk.ads.list3d.List3DActivity;
import com.startapp.sdk.ads.list3d.List3DView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class e4 {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, z6> f34424a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Hashtable<String, Bitmap> f34425b = new Hashtable<>();

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f34426c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    public n4 f34427d;

    /* renamed from: e  reason: collision with root package name */
    public int f34428e = 0;

    /* renamed from: f  reason: collision with root package name */
    public ConcurrentLinkedQueue<b> f34429f = new ConcurrentLinkedQueue<>();

    public class a extends AsyncTask<Void, Void, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public int f34430a;

        /* renamed from: b  reason: collision with root package name */
        public String f34431b;

        /* renamed from: c  reason: collision with root package name */
        public String f34432c;

        public a(int i2, String str, String str2) {
            this.f34430a = i2;
            this.f34431b = str;
            this.f34432c = str2;
        }

        public Object doInBackground(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            return ma.b(this.f34432c);
        }

        public void onPostExecute(Object obj) {
            List<j4> list;
            Bitmap bitmap = (Bitmap) obj;
            e4 e4Var = e4.this;
            boolean z2 = true;
            e4Var.f34428e--;
            if (bitmap != null) {
                e4Var.f34425b.put(this.f34431b, bitmap);
                n4 n4Var = e4.this.f34427d;
                if (n4Var != null) {
                    int i2 = this.f34430a;
                    List3DActivity list3DActivity = (List3DActivity) n4Var;
                    List3DView list3DView = list3DActivity.f35956a;
                    View childAt = list3DView.getChildAt(i2 - list3DView.f35980i);
                    if (childAt != null) {
                        k4 k4Var = (k4) childAt.getTag();
                        l4 a2 = m4.f34897a.a(list3DActivity.f35963h);
                        if (!(a2 == null || (list = a2.f34855b) == null || i2 >= list.size())) {
                            j4 j4Var = a2.f34855b.get(i2);
                            k4Var.f34814b.setImageBitmap(a2.f34854a.a(i2, j4Var.f34716a, j4Var.f34724i));
                            k4Var.f34814b.requestLayout();
                            if (j4Var.f34729n == null) {
                                z2 = false;
                            }
                            k4Var.a(z2);
                        }
                    }
                }
                e4 e4Var2 = e4.this;
                if (!e4Var2.f34429f.isEmpty()) {
                    b poll = e4Var2.f34429f.poll();
                    new a(poll.f34434a, poll.f34435b, poll.f34436c).execute(new Void[0]);
                }
            }
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f34434a;

        /* renamed from: b  reason: collision with root package name */
        public String f34435b;

        /* renamed from: c  reason: collision with root package name */
        public String f34436c;

        public b(e4 e4Var, int i2, String str, String str2) {
            this.f34434a = i2;
            this.f34435b = str;
            this.f34436c = str2;
        }
    }

    public final String a(String[] strArr, String str) {
        if (strArr == null) {
            return null;
        }
        return TextUtils.join("^", strArr) + str;
    }

    public Bitmap a(int i2, String str, String str2) {
        Bitmap bitmap = this.f34425b.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        if (this.f34426c.contains(str)) {
            return null;
        }
        this.f34426c.add(str);
        int i3 = this.f34428e;
        if (i3 >= 15) {
            this.f34429f.add(new b(this, i2, str, str2));
            return null;
        }
        this.f34428e = i3 + 1;
        new a(i2, str, str2).execute(new Void[0]);
        return null;
    }
}
