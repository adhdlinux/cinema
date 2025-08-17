package com.facebook.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.ads.internal.adapters.h;
import com.facebook.ads.internal.l.a;
import com.facebook.ads.internal.m.c;
import com.facebook.ads.internal.m.d;
import com.facebook.ads.internal.n.g;
import com.facebook.ads.internal.q.a.j;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.b.b;
import com.facebook.ads.internal.view.b.e;
import com.facebook.ads.internal.view.k;

public class MediaView extends g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19477a = "MediaView";

    /* renamed from: b  reason: collision with root package name */
    private static final int f19478b = Color.argb(51, 145, 150, 165);

    /* renamed from: c  reason: collision with root package name */
    private b f19479c;

    /* renamed from: d  reason: collision with root package name */
    private com.facebook.ads.internal.view.hscroll.b f19480d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public MediaViewVideoRenderer f19481e;

    /* renamed from: f  reason: collision with root package name */
    private View f19482f;

    /* renamed from: g  reason: collision with root package name */
    private MediaViewListener f19483g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f19484h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f19485i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f19486j;

    public MediaView(Context context) {
        super(context);
        setImageRenderer(new b(context));
        setCarouselRenderer(new com.facebook.ads.internal.view.hscroll.b(context));
        setVideoRenderer(new DefaultMediaViewVideoRenderer(context));
        a();
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setImageRenderer(new b(context, attributeSet));
        setCarouselRenderer(new com.facebook.ads.internal.view.hscroll.b(context, attributeSet));
        setVideoRenderer(new DefaultMediaViewVideoRenderer(context, attributeSet));
        a();
    }

    public MediaView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setImageRenderer(new b(context, attributeSet, i2));
        setCarouselRenderer(new com.facebook.ads.internal.view.hscroll.b(context, attributeSet, i2));
        setVideoRenderer(new DefaultMediaViewVideoRenderer(context, attributeSet, i2));
        a();
    }

    @TargetApi(21)
    public MediaView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        setImageRenderer(new b(context, attributeSet, i2, i3));
        setCarouselRenderer(new com.facebook.ads.internal.view.hscroll.b(context, attributeSet, i2));
        setVideoRenderer(new DefaultMediaViewVideoRenderer(context, attributeSet, i2, i3));
        a();
    }

    private void a() {
        x.a((View) this, f19478b);
        j jVar = j.INTERNAL_AD_MEDIA;
        j.a(this, jVar);
        j.a(this.f19479c, jVar);
        j.a(this.f19481e, jVar);
        j.a(this.f19480d, jVar);
        this.f19485i = true;
    }

    private boolean a(NativeAd nativeAd) {
        return !TextUtils.isEmpty(nativeAd.a());
    }

    private boolean b(NativeAd nativeAd) {
        if (nativeAd.e() == null) {
            return false;
        }
        for (NativeAd adCoverImage : nativeAd.e()) {
            if (adCoverImage.getAdCoverImage() == null) {
                return false;
            }
        }
        return true;
    }

    private void setCarouselRenderer(com.facebook.ads.internal.view.hscroll.b bVar) {
        if (!this.f19484h) {
            com.facebook.ads.internal.view.hscroll.b bVar2 = this.f19480d;
            if (bVar2 != null) {
                removeView(bVar2);
            }
            float f2 = x.f20694b;
            int round = Math.round(4.0f * f2);
            int round2 = Math.round(f2 * 12.0f);
            bVar.setChildSpacing(round);
            bVar.setPadding(0, round2, 0, round2);
            bVar.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView((View) bVar, (ViewGroup.LayoutParams) layoutParams);
            this.f19480d = bVar;
            return;
        }
        throw new IllegalStateException("Carousel renderer must be set before nativeAd.");
    }

    private void setImageRenderer(b bVar) {
        if (!this.f19484h) {
            b bVar2 = this.f19479c;
            if (bVar2 != null) {
                removeView(bVar2);
            }
            bVar.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView((View) bVar, (ViewGroup.LayoutParams) layoutParams);
            this.f19479c = bVar;
            return;
        }
        throw new IllegalStateException("Image renderer must be set before nativeAd.");
    }

    /* access modifiers changed from: package-private */
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        this.f19485i = false;
        addView(view, layoutParams);
        this.f19485i = true;
    }

    public void addView(View view) {
        if (!this.f19485i) {
            super.addView(view);
        }
    }

    public void addView(View view, int i2) {
        if (!this.f19485i) {
            super.addView(view, i2);
        }
    }

    public void addView(View view, int i2, int i3) {
        if (!this.f19485i) {
            super.addView(view, i2, i3);
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!this.f19485i) {
            super.addView(view, i2, layoutParams);
        }
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.f19485i) {
            super.addView(view, layoutParams);
        }
    }

    public void bringChildToFront(View view) {
        if (view == this.f19480d || view == this.f19481e || view == this.f19479c) {
            super.bringChildToFront(view);
        }
    }

    public void destroy() {
        this.f19481e.pause(false);
        this.f19481e.destroy();
    }

    /* access modifiers changed from: protected */
    public View getAdContentsView() {
        return this.f19482f;
    }

    /* access modifiers changed from: protected */
    public c getAdEventManager() {
        return d.a(getContext());
    }

    public void setListener(final MediaViewListener mediaViewListener) {
        this.f19483g = mediaViewListener;
        if (mediaViewListener == null) {
            this.f19481e.setListener((k) null);
        } else {
            this.f19481e.setListener(new k() {
                public void a() {
                    MediaViewListener mediaViewListener = mediaViewListener;
                    MediaView mediaView = MediaView.this;
                    mediaViewListener.onVolumeChange(mediaView, mediaView.f19481e.getVolume());
                }

                public void b() {
                    mediaViewListener.onPause(MediaView.this);
                }

                public void c() {
                    mediaViewListener.onPlay(MediaView.this);
                }

                public void d() {
                    mediaViewListener.onFullscreenBackground(MediaView.this);
                }

                public void e() {
                    mediaViewListener.onFullscreenForeground(MediaView.this);
                }

                public void f() {
                    mediaViewListener.onExitFullscreen(MediaView.this);
                }

                public void g() {
                    mediaViewListener.onEnterFullscreen(MediaView.this);
                }

                public void h() {
                    mediaViewListener.onComplete(MediaView.this);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void setNativeAd(final NativeAd nativeAd) {
        View view;
        this.f19484h = true;
        nativeAd.a(this);
        if (b(nativeAd)) {
            this.f19482f = this.f19480d;
            this.f19479c.setVisibility(8);
            this.f19479c.a((Bitmap) null, (Bitmap) null);
            this.f19481e.setVisibility(8);
            this.f19481e.a();
            bringChildToFront(this.f19480d);
            this.f19480d.setCurrentPosition(0);
            h hVar = new h(this.f19480d, nativeAd.g().F());
            hVar.a((h.a) new h.a() {
                public void a() {
                    nativeAd.g().a(true, true);
                }
            });
            this.f19480d.setAdapter(hVar);
            view = this.f19480d;
        } else if (a(nativeAd)) {
            nativeAd.g().b(this.f19486j);
            this.f19482f = this.f19481e.getVideoView();
            this.f19479c.setVisibility(8);
            this.f19479c.a((Bitmap) null, (Bitmap) null);
            this.f19480d.setVisibility(8);
            this.f19480d.setAdapter((RecyclerView.Adapter) null);
            bringChildToFront(this.f19481e);
            this.f19481e.setNativeAd(nativeAd);
            view = this.f19481e;
        } else if (nativeAd.getAdCoverImage() != null) {
            this.f19482f = this.f19479c.getBodyImageView();
            this.f19481e.setVisibility(8);
            this.f19481e.a();
            this.f19480d.setVisibility(8);
            this.f19480d.setAdapter((RecyclerView.Adapter) null);
            bringChildToFront(this.f19479c);
            this.f19479c.setVisibility(0);
            new com.facebook.ads.internal.view.b.d(this.f19479c).a(getHeight(), getWidth()).a(a.e(getContext())).a((e) new e() {
                public void a(boolean z2) {
                    nativeAd.g().a(z2, true);
                }
            }).a(nativeAd.g().k().a());
            return;
        } else {
            return;
        }
        view.setVisibility(0);
    }

    public void setVideoRenderer(MediaViewVideoRenderer mediaViewVideoRenderer) {
        if (!this.f19484h) {
            MediaViewVideoRenderer mediaViewVideoRenderer2 = this.f19481e;
            if (mediaViewVideoRenderer2 != null) {
                removeView(mediaViewVideoRenderer2);
                this.f19481e.destroy();
            }
            mediaViewVideoRenderer.setAdEventManager(getAdEventManager());
            mediaViewVideoRenderer.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            a(mediaViewVideoRenderer, layoutParams);
            this.f19481e = mediaViewVideoRenderer;
            this.f19486j = !(mediaViewVideoRenderer instanceof DefaultMediaViewVideoRenderer);
            return;
        }
        throw new IllegalStateException("Video renderer must be set before nativeAd.");
    }
}
