package com.facebook.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.internal.q.a.x;
import java.util.ArrayList;
import java.util.List;

public class NativeAdScrollView extends LinearLayout {
    public static final int DEFAULT_INSET = 20;
    public static final int DEFAULT_MAX_ADS = 10;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f19522a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final NativeAdsManager f19523b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final AdViewProvider f19524c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final NativeAdView.Type f19525d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final int f19526e;

    /* renamed from: f  reason: collision with root package name */
    private final b f19527f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final NativeAdViewAttributes f19528g;

    public interface AdViewProvider {
        View createView(NativeAd nativeAd, int i2);

        void destroyView(NativeAd nativeAd, View view);
    }

    private class a extends PagerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private List<NativeAd> f19530b = new ArrayList();

        public a() {
        }

        public void a() {
            this.f19530b.clear();
            int min = Math.min(NativeAdScrollView.this.f19526e, NativeAdScrollView.this.f19523b.getUniqueNativeAdCount());
            for (int i2 = 0; i2 < min; i2++) {
                NativeAd nextNativeAd = NativeAdScrollView.this.f19523b.nextNativeAd();
                nextNativeAd.a(true);
                this.f19530b.add(nextNativeAd);
            }
            notifyDataSetChanged();
        }

        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            if (i2 < this.f19530b.size()) {
                if (NativeAdScrollView.this.f19525d != null) {
                    this.f19530b.get(i2).unregisterView();
                } else {
                    NativeAdScrollView.this.f19524c.destroyView(this.f19530b.get(i2), (View) obj);
                }
            }
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return this.f19530b.size();
        }

        public int getItemPosition(Object obj) {
            int indexOf = this.f19530b.indexOf(obj);
            if (indexOf >= 0) {
                return indexOf;
            }
            return -2;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            View render = NativeAdScrollView.this.f19525d != null ? NativeAdView.render(NativeAdScrollView.this.f19522a, this.f19530b.get(i2), NativeAdScrollView.this.f19525d, NativeAdScrollView.this.f19528g) : NativeAdScrollView.this.f19524c.createView(this.f19530b.get(i2), i2);
            viewGroup.addView(render);
            return render;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    private class b extends ViewPager {
        public b(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            int i4 = 0;
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                childAt.measure(i2, View.MeasureSpec.makeMeasureSpec(0, 0));
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight > i4) {
                    i4 = measuredHeight;
                }
            }
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
        }
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider) {
        this(context, nativeAdsManager, adViewProvider, (NativeAdView.Type) null, (NativeAdViewAttributes) null, 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider, int i2) {
        this(context, nativeAdsManager, adViewProvider, (NativeAdView.Type) null, (NativeAdViewAttributes) null, i2);
    }

    private NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i2) {
        super(context);
        if (!nativeAdsManager.isLoaded()) {
            throw new IllegalStateException("NativeAdsManager not loaded");
        } else if (type == null && adViewProvider == null) {
            throw new IllegalArgumentException("Must provide a NativeAdView.Type or AdViewProvider");
        } else {
            this.f19522a = context;
            this.f19523b = nativeAdsManager;
            this.f19528g = nativeAdViewAttributes;
            this.f19524c = adViewProvider;
            this.f19525d = type;
            this.f19526e = i2;
            a aVar = new a();
            b bVar = new b(context);
            this.f19527f = bVar;
            bVar.setAdapter(aVar);
            setInset(20);
            aVar.a();
            addView(bVar);
        }
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, NativeAdView.Type type) {
        this(context, nativeAdsManager, (AdViewProvider) null, type, new NativeAdViewAttributes(), 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        this(context, nativeAdsManager, (AdViewProvider) null, type, nativeAdViewAttributes, 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i2) {
        this(context, nativeAdsManager, (AdViewProvider) null, type, nativeAdViewAttributes, i2);
    }

    public void setInset(int i2) {
        if (i2 > 0) {
            float f2 = x.f20694b;
            int round = Math.round(((float) i2) * f2);
            this.f19527f.setPadding(round, 0, round, 0);
            this.f19527f.setPageMargin(Math.round(((float) (i2 / 2)) * f2));
            this.f19527f.setClipToPadding(false);
        }
    }
}
