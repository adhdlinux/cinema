package com.applovin.impl.mediation.debugger.ui.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class d extends BaseAdapter implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private List<c> f14734a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Map<Integer, Integer> f14735b = new HashMap();
    /* access modifiers changed from: protected */

    /* renamed from: c  reason: collision with root package name */
    public Context f14736c;

    /* renamed from: d  reason: collision with root package name */
    private a f14737d;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f14738e;

    public interface a {
        void a(a aVar, c cVar);
    }

    protected d(Context context) {
        this.f14736c = context;
    }

    private LayoutInflater a() {
        LayoutInflater layoutInflater = this.f14738e;
        if (layoutInflater != null) {
            return layoutInflater;
        }
        LayoutInflater layoutInflater2 = (LayoutInflater) this.f14736c.getSystemService("layout_inflater");
        this.f14738e = layoutInflater2;
        return layoutInflater2;
    }

    private a e(int i2) {
        for (int i3 = 0; i3 < b(); i3++) {
            Integer num = this.f14735b.get(Integer.valueOf(i3));
            if (num != null) {
                if (i2 <= num.intValue() + a(i3)) {
                    return new a(i3, i2 - (num.intValue() + 1));
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract int a(int i2);

    public Bitmap a(ListView listView) {
        int count = getCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), 1073741824);
        int i2 = 0;
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ArrayList<Bitmap> arrayList = new ArrayList<>(count);
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            View view = getView(i4, (View) null, listView);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            arrayList.add(createBitmap);
            i3 += view.getMeasuredHeight();
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(listView.getMeasuredWidth(), i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        for (Bitmap bitmap : arrayList) {
            canvas.drawBitmap(bitmap, 0.0f, (float) i2, paint);
            i2 += bitmap.getHeight();
            bitmap.recycle();
        }
        return createBitmap2;
    }

    public void a(a aVar) {
        this.f14737d = aVar;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract int b();

    /* access modifiers changed from: protected */
    public abstract c b(int i2);

    /* access modifiers changed from: protected */
    public abstract List<c> c(int i2);

    /* renamed from: d */
    public c getItem(int i2) {
        return this.f14734a.get(i2);
    }

    public int getCount() {
        return this.f14734a.size();
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public int getItemViewType(int i2) {
        return getItem(i2).i();
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        c d2 = getItem(i2);
        if (view == null) {
            view = a().inflate(d2.j(), viewGroup, false);
            bVar = new b();
            bVar.f14694a = (TextView) view.findViewById(16908308);
            bVar.f14695b = (TextView) view.findViewById(16908309);
            bVar.f14696c = (ImageView) view.findViewById(R.id.imageView);
            bVar.f14697d = (ImageView) view.findViewById(R.id.detailImageView);
            view.setTag(bVar);
            view.setOnClickListener(this);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.a(i2);
        bVar.a(d2);
        view.setEnabled(d2.b());
        return view;
    }

    public int getViewTypeCount() {
        return c.h();
    }

    public boolean isEnabled(int i2) {
        return getItem(i2).b();
    }

    public void j() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                d.this.notifyDataSetChanged();
            }
        });
    }

    /* access modifiers changed from: protected */
    public c k() {
        return null;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f14734a = new ArrayList();
        Integer num = 0;
        Integer valueOf = Integer.valueOf(b());
        this.f14735b = new HashMap(valueOf.intValue());
        c k2 = k();
        if (k2 != null) {
            this.f14734a.add(k2);
            num = Integer.valueOf(num.intValue() + 1);
        }
        for (int i2 = 0; i2 < valueOf.intValue(); i2++) {
            Integer valueOf2 = Integer.valueOf(a(i2));
            if (valueOf2.intValue() != 0) {
                this.f14734a.add(b(i2));
                this.f14734a.addAll(c(i2));
                this.f14735b.put(Integer.valueOf(i2), num);
                num = Integer.valueOf(num.intValue() + valueOf2.intValue() + 1);
            }
        }
        this.f14734a.add(new e(""));
    }

    public void onClick(View view) {
        b bVar = (b) view.getTag();
        c b2 = bVar.b();
        a e2 = e(bVar.a());
        a aVar = this.f14737d;
        if (aVar != null && e2 != null) {
            aVar.a(e2, b2);
        }
    }
}
