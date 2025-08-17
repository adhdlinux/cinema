package com.startapp.sdk.ads.banner.banner3d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.startapp.ha;
import com.startapp.hc;
import com.startapp.n3;
import com.startapp.o6;
import com.startapp.p;
import com.startapp.q3;
import com.startapp.r3;
import com.startapp.s3;
import com.startapp.sdk.ads.banner.BannerBase;
import com.startapp.sdk.ads.banner.BannerInterface;
import com.startapp.sdk.ads.banner.BannerListener;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.banner.BannerOptions;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.adinformation.AdInformationObject;
import com.startapp.sdk.adsbase.adinformation.AdInformationOverrides;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.consent.ConsentData;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.y8;
import com.startapp.z6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class Banner3D extends BannerBase implements AdEventListener, BannerInterface {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public AdInformationOverrides N;
    public List<s3> O;
    public int P;
    public BannerListener Q;
    public Runnable R;

    /* renamed from: r  reason: collision with root package name */
    public BannerOptions f35896r;

    /* renamed from: s  reason: collision with root package name */
    public Banner3DAd f35897s;

    /* renamed from: t  reason: collision with root package name */
    public List<AdDetails> f35898t;

    /* renamed from: u  reason: collision with root package name */
    public AdPreferences f35899u;

    /* renamed from: v  reason: collision with root package name */
    public Camera f35900v;

    /* renamed from: w  reason: collision with root package name */
    public Matrix f35901w;

    /* renamed from: x  reason: collision with root package name */
    public Paint f35902x;

    /* renamed from: y  reason: collision with root package name */
    public float f35903y;

    /* renamed from: z  reason: collision with root package name */
    public float f35904z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        public AdRulesResult adRulesResult;
        public boolean bDefaultLoad;
        public boolean bIsVisible;
        private int currentImage;
        private AdDetails[] details;
        public s3[] faces;
        private int firstRotation;
        private int firstRotationFinished;
        public boolean loaded;
        public boolean loading;
        public BannerOptions options;
        public AdInformationOverrides overrides;
        private float rotation;

        public int describeContents() {
            return 0;
        }

        public int getCurrentImage() {
            return this.currentImage;
        }

        public List<AdDetails> getDetails() {
            return Arrays.asList(this.details);
        }

        public float getRotation() {
            return this.rotation;
        }

        public boolean isFirstRotation() {
            return this.firstRotation == 1;
        }

        public boolean isFirstRotationFinished() {
            return this.firstRotationFinished == 1;
        }

        public void setCurrentImage(int i2) {
            this.currentImage = i2;
        }

        public void setDetails(List<AdDetails> list) {
            this.details = new AdDetails[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.details[i2] = list.get(i2);
            }
        }

        public void setFirstRotation(boolean z2) {
            this.firstRotation = z2 ? 1 : 0;
        }

        public void setFirstRotationFinished(boolean z2) {
            this.firstRotationFinished = z2 ? 1 : 0;
        }

        public void setRotation(float f2) {
            this.rotation = f2;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            if (!this.bIsVisible) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(this.currentImage);
            parcel.writeFloat(this.rotation);
            parcel.writeInt(this.firstRotation);
            parcel.writeInt(this.firstRotationFinished);
            parcel.writeParcelableArray(this.details, i2);
            parcel.writeInt(this.loaded ? 1 : 0);
            parcel.writeInt(this.loading ? 1 : 0);
            parcel.writeInt(this.bDefaultLoad ? 1 : 0);
            s3[] s3VarArr = this.faces;
            if (s3VarArr == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(s3VarArr.length);
                for (s3 writeParcelable : this.faces) {
                    parcel.writeParcelable(writeParcelable, i2);
                }
            }
            parcel.writeSerializable(this.overrides);
            parcel.writeSerializable(this.options);
            parcel.writeSerializable(this.adRulesResult);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            if (parcel.readInt() == 1) {
                this.bIsVisible = true;
                this.currentImage = parcel.readInt();
                this.rotation = parcel.readFloat();
                this.firstRotation = parcel.readInt();
                this.firstRotationFinished = parcel.readInt();
                Parcelable[] readParcelableArray = parcel.readParcelableArray(AdDetails.class.getClassLoader());
                if (readParcelableArray != null) {
                    AdDetails[] adDetailsArr = new AdDetails[readParcelableArray.length];
                    this.details = adDetailsArr;
                    System.arraycopy(readParcelableArray, 0, adDetailsArr, 0, readParcelableArray.length);
                }
                int readInt = parcel.readInt();
                this.loaded = false;
                if (readInt == 1) {
                    this.loaded = true;
                }
                int readInt2 = parcel.readInt();
                this.loading = false;
                if (readInt2 == 1) {
                    this.loading = true;
                }
                int readInt3 = parcel.readInt();
                this.bDefaultLoad = false;
                if (readInt3 == 1) {
                    this.bDefaultLoad = true;
                }
                int readInt4 = parcel.readInt();
                if (readInt4 > 0) {
                    this.faces = new s3[readInt4];
                    for (int i2 = 0; i2 < readInt4; i2++) {
                        this.faces[i2] = (s3) parcel.readParcelable(s3.class.getClassLoader());
                    }
                }
                this.overrides = (AdInformationOverrides) parcel.readSerializable();
                this.options = (BannerOptions) parcel.readSerializable();
                this.adRulesResult = (AdRulesResult) parcel.readSerializable();
                return;
            }
            this.bIsVisible = false;
        }
    }

    public Banner3D(Activity activity) {
        this((Context) activity);
    }

    public void a(List<AdDetails> list, boolean z2) {
        n3 n3Var;
        Banner3DAd banner3DAd;
        this.f35898t = list;
        if (list != null) {
            r3 r3Var = new r3();
            if (p.a(getContext(), getParent(), this.f35896r, this, r3Var)) {
                setMinimumWidth(p.a(getContext(), this.f35896r.o()));
                setMinimumHeight(p.a(getContext(), this.f35896r.d()));
                if (getLayoutParams() != null && getLayoutParams().width == -1) {
                    setMinimumWidth(p.a(getContext(), r3Var.f35750a.x));
                }
                if (getLayoutParams() != null && getLayoutParams().height == -1) {
                    setMinimumHeight(p.a(getContext(), r3Var.f35750a.y));
                }
                if (getLayoutParams() != null) {
                    if (getLayoutParams().width > 0) {
                        setMinimumWidth(getLayoutParams().width);
                    }
                    if (getLayoutParams().height > 0) {
                        setMinimumHeight(getLayoutParams().height);
                    }
                    if (getLayoutParams().width > 0 && getLayoutParams().height > 0 && (banner3DAd = this.f35897s) != null) {
                        banner3DAd.b(true);
                    }
                }
                List<s3> list2 = this.O;
                if (list2 == null || list2.size() == 0) {
                    n();
                    removeAllViews();
                    this.O = new ArrayList();
                    for (AdDetails s3Var : list) {
                        this.O.add(new s3(getContext(), this, s3Var, this.f35896r, new TrackingParams(this.f35878j)));
                    }
                    this.P = 0;
                } else {
                    for (s3 a2 : this.O) {
                        a2.a(getContext(), this.f35896r, this);
                    }
                }
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(r(), o());
                layoutParams.addRule(13);
                int p2 = p();
                layoutParams.rightMargin = p2;
                layoutParams.leftMargin = p2;
                int q2 = q();
                layoutParams.topMargin = q2;
                layoutParams.bottomMargin = q2;
                addView(relativeLayout, layoutParams);
                new AdInformationObject(getContext(), AdInformationObject.Size.SMALL, AdPreferences.Placement.INAPP_BANNER, this.N, (ConsentData) null).a(relativeLayout);
                if (this.f35902x == null) {
                    Paint paint = new Paint();
                    this.f35902x = paint;
                    paint.setAntiAlias(true);
                    this.f35902x.setFilterBitmap(true);
                }
                if (!this.G) {
                    this.G = true;
                    u();
                }
                if (this.H) {
                    t();
                }
                if (z2) {
                    Context context = getContext();
                    BannerListener bannerListener = this.Q;
                    if (bannerListener == null) {
                        n3Var = null;
                    } else {
                        n3Var = new n3(bannerListener, this, context);
                    }
                    o6.a((Runnable) n3Var);
                    return;
                }
                return;
            }
            setErrorMessage("Error in banner screen size");
            setVisibility(8);
            if (z2) {
                p.a(getContext(), this.Q, (View) this);
                return;
            }
            return;
        }
        setErrorMessage("No ads to load");
        if (z2) {
            p.a(getContext(), this.Q, (View) this);
        }
    }

    public int d() {
        return this.f35876h;
    }

    public String e() {
        return "StartApp Banner3D";
    }

    public int f() {
        return BannerMetaData.f35889b.a().j();
    }

    public String getBidToken() {
        Banner3DAd banner3DAd = this.f35897s;
        if (banner3DAd != null) {
            return banner3DAd.getBidToken();
        }
        return null;
    }

    public int getHeightInDp() {
        return 50;
    }

    public int getWidthInDp() {
        return 300;
    }

    public void hideBanner() {
        this.H = false;
        setVisibility(8);
    }

    public void i() {
        if (!this.K) {
            this.f35896r = BannerMetaData.f35889b.b();
            this.f35898t = new ArrayList();
            if (this.f35899u == null) {
                this.f35899u = new AdPreferences();
            }
            this.N = new AdInformationOverrides();
            n();
            this.O = new ArrayList();
            this.K = true;
            setBackgroundColor(0);
            if (getId() == -1) {
                setId(this.f35876h);
            }
            if (this.I) {
                getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        ViewTreeObserver viewTreeObserver = Banner3D.this.getViewTreeObserver();
                        int i2 = hc.f34643a;
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                        Banner3D banner3D = Banner3D.this;
                        banner3D.a(banner3D.f35899u);
                        Banner3D banner3D2 = Banner3D.this;
                        if (!banner3D2.J) {
                            banner3D2.k();
                        }
                    }
                });
            }
        }
    }

    public void l() {
        int i2 = 0;
        this.J = false;
        this.K = true;
        this.G = false;
        this.A = true;
        this.C = true;
        this.D = false;
        this.E = false;
        this.f35875g = false;
        this.f35871c = null;
        n();
        this.O = new ArrayList();
        Context context = getContext();
        Banner3DAd banner3DAd = this.f35897s;
        if (banner3DAd != null) {
            i2 = banner3DAd.h();
        }
        this.f35897s = new Banner3DAd(context, i2);
        if (this.f35899u == null) {
            this.f35899u = new AdPreferences();
        }
        this.f35897s.load(this.f35899u, this);
    }

    public final void n() {
        List<s3> list = this.O;
        if (list != null && !list.isEmpty()) {
            for (s3 next : this.O) {
                if (next != null) {
                    Bitmap bitmap = next.f35838c;
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    Bitmap bitmap2 = next.f35839d;
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                    }
                    next.f35838c = null;
                    next.f35839d = null;
                    z6 z6Var = next.f35842g;
                    if (z6Var != null) {
                        z6Var.a("AD_CLOSED_TOO_QUICKLY", (JSONObject) null);
                    }
                    Banner3DView banner3DView = next.f35843h;
                    if (banner3DView != null) {
                        banner3DView.removeAllViews();
                        next.f35843h = null;
                    }
                }
            }
        }
    }

    public final int o() {
        return (int) (((float) p.a(getContext(), this.f35896r.d())) * this.f35896r.e());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.L = true;
        BannerOptions bannerOptions = this.f35896r;
        if (bannerOptions == null || !bannerOptions.s()) {
            this.C = false;
            this.D = true;
        }
        u();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.L = false;
        removeCallbacks(this.R);
        List<s3> list = this.O;
        if (list != null) {
            for (s3 s3Var : list) {
                z6 z6Var = s3Var.f35842g;
                if (z6Var != null) {
                    z6Var.a("AD_CLOSED_TOO_QUICKLY", (JSONObject) null);
                }
            }
        }
    }

    public void onDraw(Canvas canvas) {
        boolean z2;
        Bitmap bitmap;
        Bitmap bitmap2;
        super.onDraw(canvas);
        if (!this.f35875g && !this.K) {
            this.f35875g = true;
            u();
        }
        if (!isInEditMode() && this.H) {
            List<s3> list = this.O;
            if (list == null || list.size() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                try {
                    int r2 = r();
                    int o2 = o();
                    int p2 = p();
                    int q2 = q();
                    float g2 = this.f35896r.g() + (((float) Math.pow((double) (Math.abs(this.f35903y - 45.0f) / 45.0f), (double) this.f35896r.l())) * (1.0f - this.f35896r.g()));
                    if (!this.D) {
                        g2 = this.f35896r.g();
                    }
                    float f2 = g2;
                    Bitmap bitmap3 = this.O.get(((this.P - 1) + this.O.size()) % this.O.size()).f35839d;
                    Bitmap bitmap4 = this.O.get(this.P).f35839d;
                    if (bitmap4 != null && bitmap3 != null) {
                        float f3 = this.f35903y;
                        if (f3 < 45.0f) {
                            if (f3 > 3.0f) {
                                float rotationMultiplier = (f3 - 90.0f) * ((float) this.f35896r.c().getRotationMultiplier());
                                bitmap2 = bitmap3;
                                a(canvas, bitmap4, q2, p2, r2 / 2, o2 / 2, f2, rotationMultiplier);
                            } else {
                                bitmap2 = bitmap3;
                            }
                            Canvas canvas2 = canvas;
                            Bitmap bitmap5 = bitmap2;
                            int i2 = q2;
                            int i3 = p2;
                            a(canvas2, bitmap5, i2, i3, r2 / 2, o2 / 2, f2, this.f35903y * ((float) this.f35896r.c().getRotationMultiplier()));
                            return;
                        }
                        Bitmap bitmap6 = bitmap3;
                        if (f3 < 87.0f) {
                            float rotationMultiplier2 = f3 * ((float) this.f35896r.c().getRotationMultiplier());
                            bitmap = bitmap4;
                            a(canvas, bitmap6, q2, p2, r2 / 2, o2 / 2, f2, rotationMultiplier2);
                        } else {
                            bitmap = bitmap4;
                        }
                        Canvas canvas3 = canvas;
                        Bitmap bitmap7 = bitmap;
                        int i4 = q2;
                        int i5 = p2;
                        a(canvas3, bitmap7, i4, i5, r2 / 2, o2 / 2, f2, (this.f35903y - 90.0f) * ((float) this.f35896r.c().getRotationMultiplier()));
                        if (!this.C) {
                            this.D = true;
                        }
                    }
                } catch (Throwable th) {
                    y8.a(getContext(), th);
                }
            }
        }
    }

    public void onFailedToReceiveAd(Ad ad) {
        if (ad != null) {
            setErrorMessage(ad.getErrorMessage());
        }
        p.a(getContext(), this.Q, (View) this);
    }

    public void onReceiveAd(Ad ad) {
        this.J = true;
        this.K = false;
        this.N = this.f35897s.getAdInfoOverride();
        List<AdDetails> g2 = ((JsonAd) ad).g();
        this.f35898t = g2;
        a(g2, this.M);
        this.M = false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        boolean z2 = savedState.bIsVisible;
        this.H = z2;
        if (z2) {
            this.f35898t = savedState.getDetails();
            this.f35903y = savedState.getRotation();
            this.C = savedState.isFirstRotation();
            this.D = savedState.isFirstRotationFinished();
            this.P = savedState.getCurrentImage();
            s3[] s3VarArr = savedState.faces;
            n();
            this.O = new ArrayList();
            if (s3VarArr != null) {
                for (s3 add : s3VarArr) {
                    this.O.add(add);
                }
            }
            this.J = savedState.loaded;
            this.K = savedState.loading;
            this.I = savedState.bDefaultLoad;
            this.N = savedState.overrides;
            this.f35896r = savedState.options;
            if (this.f35898t.size() == 0) {
                this.I = true;
                h();
                return;
            }
            post(new Runnable() {
                public void run() {
                    Banner3D banner3D = Banner3D.this;
                    banner3D.a(banner3D.f35898t, false);
                }
            });
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.bIsVisible = this.H;
        savedState.setDetails(this.f35898t);
        savedState.setRotation(this.f35903y);
        savedState.setFirstRotation(this.C);
        savedState.setFirstRotationFinished(this.D);
        savedState.setCurrentImage(this.P);
        savedState.options = this.f35896r;
        savedState.faces = new s3[this.O.size()];
        savedState.loaded = this.J;
        savedState.loading = this.K;
        savedState.overrides = this.N;
        for (int i2 = 0; i2 < this.O.size(); i2++) {
            savedState.faces[i2] = this.O.get(i2);
        }
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        List<s3> list;
        boolean z3;
        int r2 = r();
        int o2 = o();
        int p2 = p();
        int q2 = q();
        if (motionEvent.getX() < ((float) p2) || motionEvent.getY() < ((float) q2) || motionEvent.getX() > ((float) (p2 + r2)) || motionEvent.getY() > ((float) (q2 + o2))) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2 || (list = this.O) == null || list.size() == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.F = true;
            this.f35904z = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2 && this.f35904z - motionEvent.getY() >= 10.0f) {
                this.F = false;
                this.f35904z = motionEvent.getY();
            }
        } else if (this.F) {
            if (this.f35903y < 45.0f) {
                s();
            }
            this.F = false;
            this.A = false;
            setClicked(true);
            postDelayed(new Runnable() {
                public void run() {
                    Banner3D.this.A = true;
                }
            }, AdsCommonMetaData.f36186h.z());
            s3 s3Var = this.O.get(this.P);
            Context context = getContext();
            String m2 = s3Var.f35836a.m();
            boolean a2 = o6.a(context, AdPreferences.Placement.INAPP_BANNER);
            z6 z6Var = s3Var.f35842g;
            q3 q3Var = null;
            if (z6Var != null) {
                z6Var.a((String) null, (JSONObject) null);
            }
            if (m2 != null && !"null".equals(m2) && !TextUtils.isEmpty(m2)) {
                o6.a(m2, s3Var.f35836a.l(), s3Var.f35836a.g(), context, s3Var.f35841f);
            } else if (!s3Var.f35836a.A() || a2) {
                String g2 = s3Var.f35836a.g();
                String[] u2 = s3Var.f35836a.u();
                TrackingParams trackingParams = s3Var.f35841f;
                if (!s3Var.f35836a.B() || a2) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                o6.a(context, g2, u2, trackingParams, z3, false);
            } else {
                o6.a(context, s3Var.f35836a.g(), s3Var.f35836a.u(), s3Var.f35836a.p(), s3Var.f35841f, AdsCommonMetaData.f36186h.z(), AdsCommonMetaData.f36186h.y(), s3Var.f35836a.B(), s3Var.f35836a.C(), false, (Runnable) null);
            }
            Context context2 = getContext();
            BannerListener bannerListener = this.Q;
            if (bannerListener != null) {
                q3Var = new q3(bannerListener, this, context2);
            }
            o6.a((Runnable) q3Var);
        }
        return true;
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            this.L = true;
            BannerOptions bannerOptions = this.f35896r;
            if (bannerOptions == null || !bannerOptions.s()) {
                this.C = false;
                this.D = true;
            }
            u();
            return;
        }
        this.L = false;
        if (!this.B) {
            removeCallbacks(this.R);
        }
    }

    public final int p() {
        return (getWidth() - r()) / 2;
    }

    public final int q() {
        return (getHeight() - o()) / 2;
    }

    public final int r() {
        return (int) (((float) p.a(getContext(), this.f35896r.o())) * this.f35896r.p());
    }

    public final void s() {
        this.P = ((this.P - 1) + this.O.size()) % this.O.size();
    }

    public void setAdTag(String str) {
        this.f35878j = str;
    }

    public void setBannerListener(BannerListener bannerListener) {
        this.Q = bannerListener;
    }

    public void showBanner() {
        this.H = true;
        t();
    }

    public final void t() {
        setVisibility(0);
        if (this.f35897s != null) {
            ha r2 = ComponentLocator.a(getContext()).r();
            AdPreferences.Placement placement = AdPreferences.Placement.INAPP_BANNER;
            String adId = this.f35897s.getAdId();
            r2.getClass();
            if (adId != null) {
                r2.f34636a.put(new ha.a(placement, -1), adId);
            }
        }
    }

    public final void u() {
        if (this.L && this.f35875g) {
            removeCallbacks(this.R);
            post(this.R);
        }
    }

    public Banner3D(Activity activity, AdPreferences adPreferences) {
        this((Context) activity, adPreferences);
    }

    public Banner3D(Activity activity, BannerListener bannerListener) {
        this((Context) activity, bannerListener);
    }

    public Banner3D(Activity activity, AdPreferences adPreferences, BannerListener bannerListener) {
        this((Context) activity, adPreferences, bannerListener);
    }

    public Banner3D(Activity activity, boolean z2) {
        this((Context) activity, z2);
    }

    public Banner3D(Activity activity, boolean z2, AdPreferences adPreferences) {
        this((Context) activity, z2, adPreferences);
    }

    public Banner3D(Activity activity, AttributeSet attributeSet) {
        this((Context) activity, attributeSet);
    }

    public Banner3D(Activity activity, AttributeSet attributeSet, int i2) {
        this((Context) activity, attributeSet, i2);
    }

    @Deprecated
    public Banner3D(Context context) {
        this(context, true, (AdPreferences) null);
    }

    @Deprecated
    public Banner3D(Context context, AdPreferences adPreferences) {
        this(context, true, adPreferences);
    }

    @Deprecated
    public Banner3D(Context context, BannerListener bannerListener) {
        this(context, true, (AdPreferences) null);
        setBannerListener(bannerListener);
    }

    @Deprecated
    public Banner3D(Context context, AdPreferences adPreferences, BannerListener bannerListener) {
        this(context, true, adPreferences);
        setBannerListener(bannerListener);
    }

    @Deprecated
    public Banner3D(Context context, boolean z2) {
        this(context, z2, (AdPreferences) null);
    }

    @Deprecated
    public Banner3D(Context context, boolean z2, AdPreferences adPreferences) {
        super(context);
        this.f35900v = null;
        this.f35901w = null;
        this.f35902x = null;
        this.f35903y = 45.0f;
        this.f35904z = 0.0f;
        this.A = true;
        this.B = false;
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = true;
        this.O = new ArrayList();
        this.P = 0;
        this.R = new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:51:0x0130  */
            /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r11 = this;
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.J
                    if (r1 == 0) goto L_0x0134
                    java.util.List<com.startapp.s3> r0 = r0.O
                    int r0 = r0.size()
                    if (r0 != 0) goto L_0x0010
                    goto L_0x0134
                L_0x0010:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.H
                    r2 = 0
                    r3 = 1
                    if (r1 == 0) goto L_0x008c
                    boolean r0 = r0.isShown()
                    if (r0 == 0) goto L_0x008c
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.f35875g
                    if (r1 == 0) goto L_0x008c
                    java.util.List<com.startapp.s3> r1 = r0.O
                    int r0 = r0.P
                    java.lang.Object r0 = r1.get(r0)
                    com.startapp.s3 r0 = (com.startapp.s3) r0
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r1 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    android.content.Context r5 = r1.getContext()
                    com.startapp.sdk.adsbase.model.AdDetails r4 = r0.f35836a
                    java.lang.String[] r4 = r4.w()
                    int r4 = r4.length
                    if (r4 <= 0) goto L_0x007b
                    java.util.concurrent.atomic.AtomicBoolean r4 = r0.f35840e
                    boolean r4 = r4.compareAndSet(r2, r3)
                    if (r4 == 0) goto L_0x007b
                    com.startapp.z6 r10 = new com.startapp.z6
                    com.startapp.sdk.adsbase.model.AdDetails r4 = r0.f35836a
                    java.lang.String[] r6 = r4.w()
                    com.startapp.sdk.adsbase.commontracking.TrackingParams r7 = r0.f35841f
                    com.startapp.sdk.adsbase.model.AdDetails r4 = r0.f35836a
                    java.lang.Long r4 = r4.h()
                    if (r4 == 0) goto L_0x0068
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
                    com.startapp.sdk.adsbase.model.AdDetails r8 = r0.f35836a
                    java.lang.Long r8 = r8.h()
                    long r8 = r8.longValue()
                    long r8 = r4.toMillis(r8)
                    goto L_0x0074
                L_0x0068:
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
                    com.startapp.sdk.adsbase.remoteconfig.MetaData r8 = com.startapp.sdk.adsbase.remoteconfig.MetaData.f36379h
                    long r8 = r8.n()
                    long r8 = r4.toMillis(r8)
                L_0x0074:
                    r4 = r10
                    r4.<init>(r5, r6, r7, r8)
                    r0.f35842g = r10
                    goto L_0x007c
                L_0x007b:
                    r10 = 0
                L_0x007c:
                    if (r10 == 0) goto L_0x0081
                    r1.a((com.startapp.z6) r10)
                L_0x0081:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.E
                    if (r1 != 0) goto L_0x008c
                    r0.E = r3
                    r0.a()
                L_0x008c:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.A
                    if (r1 == 0) goto L_0x00d7
                    com.startapp.sdk.ads.banner.BannerOptions r1 = r0.f35896r
                    int r1 = r1.m()
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r4 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r5 = r4.D
                    if (r5 != 0) goto L_0x00a5
                    com.startapp.sdk.ads.banner.BannerOptions r4 = r4.f35896r
                    int r4 = r4.k()
                    goto L_0x00a6
                L_0x00a5:
                    r4 = 1
                L_0x00a6:
                    int r1 = r1 * r4
                    float r1 = (float) r1
                    float r4 = r0.f35903y
                    float r4 = r4 + r1
                    r0.f35903y = r4
                    r1 = 1119092736(0x42b40000, float:90.0)
                    int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                    if (r4 < 0) goto L_0x00c5
                    int r4 = r0.P
                    int r4 = r4 + r3
                    java.util.List<com.startapp.s3> r5 = r0.O
                    int r5 = r5.size()
                    int r4 = r4 % r5
                    r0.P = r4
                    float r4 = r0.f35903y
                    float r4 = r4 - r1
                    r0.f35903y = r4
                L_0x00c5:
                    float r4 = r0.f35903y
                    r5 = 0
                    int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                    if (r4 > 0) goto L_0x00d4
                    r0.s()
                    float r4 = r0.f35903y
                    float r4 = r4 + r1
                    r0.f35903y = r4
                L_0x00d4:
                    r0.invalidate()
                L_0x00d7:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    float r1 = r0.f35903y
                    com.startapp.sdk.ads.banner.BannerOptions r0 = r0.f35896r
                    int r0 = r0.m()
                    int r0 = 90 - r0
                    float r0 = (float) r0
                    int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
                    if (r0 <= 0) goto L_0x0112
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    float r1 = r0.f35903y
                    com.startapp.sdk.ads.banner.BannerOptions r0 = r0.f35896r
                    int r0 = r0.m()
                    int r0 = r0 + 90
                    float r0 = (float) r0
                    int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
                    if (r0 >= 0) goto L_0x0112
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.C
                    if (r1 != 0) goto L_0x0112
                    boolean r1 = r0.L
                    if (r1 == 0) goto L_0x010d
                    com.startapp.sdk.ads.banner.BannerOptions r1 = r0.f35896r
                    int r1 = r1.b()
                    long r4 = (long) r1
                    r0.postDelayed(r11, r4)
                L_0x010d:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    r0.B = r2
                    goto L_0x0122
                L_0x0112:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    com.startapp.sdk.ads.banner.BannerOptions r1 = r0.f35896r
                    int r1 = r1.n()
                    long r4 = (long) r1
                    r0.postDelayed(r11, r4)
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    r0.B = r3
                L_0x0122:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    int r1 = r0.P
                    int r1 = r1 + r3
                    java.util.List<com.startapp.s3> r0 = r0.O
                    int r0 = r0.size()
                    int r1 = r1 % r0
                    if (r1 != 0) goto L_0x0134
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    r0.C = r2
                L_0x0134:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.banner.banner3d.Banner3D.AnonymousClass1.run():void");
            }
        };
        try {
            this.I = z2;
            if (adPreferences == null) {
                this.f35899u = new AdPreferences();
            } else {
                this.f35899u = adPreferences;
            }
            h();
        } catch (Throwable th) {
            y8.a(context, th);
        }
    }

    @Deprecated
    public Banner3D(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public Banner3D(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f35900v = null;
        this.f35901w = null;
        this.f35902x = null;
        this.f35903y = 45.0f;
        this.f35904z = 0.0f;
        this.A = true;
        this.B = false;
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = true;
        this.O = new ArrayList();
        this.P = 0;
        this.R = new Runnable() {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r11 = this;
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.J
                    if (r1 == 0) goto L_0x0134
                    java.util.List<com.startapp.s3> r0 = r0.O
                    int r0 = r0.size()
                    if (r0 != 0) goto L_0x0010
                    goto L_0x0134
                L_0x0010:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.H
                    r2 = 0
                    r3 = 1
                    if (r1 == 0) goto L_0x008c
                    boolean r0 = r0.isShown()
                    if (r0 == 0) goto L_0x008c
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.f35875g
                    if (r1 == 0) goto L_0x008c
                    java.util.List<com.startapp.s3> r1 = r0.O
                    int r0 = r0.P
                    java.lang.Object r0 = r1.get(r0)
                    com.startapp.s3 r0 = (com.startapp.s3) r0
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r1 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    android.content.Context r5 = r1.getContext()
                    com.startapp.sdk.adsbase.model.AdDetails r4 = r0.f35836a
                    java.lang.String[] r4 = r4.w()
                    int r4 = r4.length
                    if (r4 <= 0) goto L_0x007b
                    java.util.concurrent.atomic.AtomicBoolean r4 = r0.f35840e
                    boolean r4 = r4.compareAndSet(r2, r3)
                    if (r4 == 0) goto L_0x007b
                    com.startapp.z6 r10 = new com.startapp.z6
                    com.startapp.sdk.adsbase.model.AdDetails r4 = r0.f35836a
                    java.lang.String[] r6 = r4.w()
                    com.startapp.sdk.adsbase.commontracking.TrackingParams r7 = r0.f35841f
                    com.startapp.sdk.adsbase.model.AdDetails r4 = r0.f35836a
                    java.lang.Long r4 = r4.h()
                    if (r4 == 0) goto L_0x0068
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
                    com.startapp.sdk.adsbase.model.AdDetails r8 = r0.f35836a
                    java.lang.Long r8 = r8.h()
                    long r8 = r8.longValue()
                    long r8 = r4.toMillis(r8)
                    goto L_0x0074
                L_0x0068:
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
                    com.startapp.sdk.adsbase.remoteconfig.MetaData r8 = com.startapp.sdk.adsbase.remoteconfig.MetaData.f36379h
                    long r8 = r8.n()
                    long r8 = r4.toMillis(r8)
                L_0x0074:
                    r4 = r10
                    r4.<init>(r5, r6, r7, r8)
                    r0.f35842g = r10
                    goto L_0x007c
                L_0x007b:
                    r10 = 0
                L_0x007c:
                    if (r10 == 0) goto L_0x0081
                    r1.a((com.startapp.z6) r10)
                L_0x0081:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.E
                    if (r1 != 0) goto L_0x008c
                    r0.E = r3
                    r0.a()
                L_0x008c:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.A
                    if (r1 == 0) goto L_0x00d7
                    com.startapp.sdk.ads.banner.BannerOptions r1 = r0.f35896r
                    int r1 = r1.m()
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r4 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r5 = r4.D
                    if (r5 != 0) goto L_0x00a5
                    com.startapp.sdk.ads.banner.BannerOptions r4 = r4.f35896r
                    int r4 = r4.k()
                    goto L_0x00a6
                L_0x00a5:
                    r4 = 1
                L_0x00a6:
                    int r1 = r1 * r4
                    float r1 = (float) r1
                    float r4 = r0.f35903y
                    float r4 = r4 + r1
                    r0.f35903y = r4
                    r1 = 1119092736(0x42b40000, float:90.0)
                    int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                    if (r4 < 0) goto L_0x00c5
                    int r4 = r0.P
                    int r4 = r4 + r3
                    java.util.List<com.startapp.s3> r5 = r0.O
                    int r5 = r5.size()
                    int r4 = r4 % r5
                    r0.P = r4
                    float r4 = r0.f35903y
                    float r4 = r4 - r1
                    r0.f35903y = r4
                L_0x00c5:
                    float r4 = r0.f35903y
                    r5 = 0
                    int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                    if (r4 > 0) goto L_0x00d4
                    r0.s()
                    float r4 = r0.f35903y
                    float r4 = r4 + r1
                    r0.f35903y = r4
                L_0x00d4:
                    r0.invalidate()
                L_0x00d7:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    float r1 = r0.f35903y
                    com.startapp.sdk.ads.banner.BannerOptions r0 = r0.f35896r
                    int r0 = r0.m()
                    int r0 = 90 - r0
                    float r0 = (float) r0
                    int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
                    if (r0 <= 0) goto L_0x0112
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    float r1 = r0.f35903y
                    com.startapp.sdk.ads.banner.BannerOptions r0 = r0.f35896r
                    int r0 = r0.m()
                    int r0 = r0 + 90
                    float r0 = (float) r0
                    int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
                    if (r0 >= 0) goto L_0x0112
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    boolean r1 = r0.C
                    if (r1 != 0) goto L_0x0112
                    boolean r1 = r0.L
                    if (r1 == 0) goto L_0x010d
                    com.startapp.sdk.ads.banner.BannerOptions r1 = r0.f35896r
                    int r1 = r1.b()
                    long r4 = (long) r1
                    r0.postDelayed(r11, r4)
                L_0x010d:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    r0.B = r2
                    goto L_0x0122
                L_0x0112:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    com.startapp.sdk.ads.banner.BannerOptions r1 = r0.f35896r
                    int r1 = r1.n()
                    long r4 = (long) r1
                    r0.postDelayed(r11, r4)
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    r0.B = r3
                L_0x0122:
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    int r1 = r0.P
                    int r1 = r1 + r3
                    java.util.List<com.startapp.s3> r0 = r0.O
                    int r0 = r0.size()
                    int r1 = r1 % r0
                    if (r1 != 0) goto L_0x0134
                    com.startapp.sdk.ads.banner.banner3d.Banner3D r0 = com.startapp.sdk.ads.banner.banner3d.Banner3D.this
                    r0.C = r2
                L_0x0134:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.banner.banner3d.Banner3D.AnonymousClass1.run():void");
            }
        };
        try {
            h();
        } catch (Throwable th) {
            y8.a(context, th);
        }
    }

    public final void a(Canvas canvas, Bitmap bitmap, int i2, int i3, int i4, int i5, float f2, float f3) {
        if (this.f35900v == null) {
            this.f35900v = new Camera();
        }
        this.f35900v.save();
        this.f35900v.translate(0.0f, 0.0f, (float) i5);
        this.f35900v.rotateX(f3);
        float f4 = (float) (-i5);
        this.f35900v.translate(0.0f, 0.0f, f4);
        if (this.f35901w == null) {
            this.f35901w = new Matrix();
        }
        this.f35900v.getMatrix(this.f35901w);
        this.f35900v.restore();
        this.f35901w.preTranslate((float) (-i4), f4);
        this.f35901w.postScale(f2, f2);
        this.f35901w.postTranslate((float) (i3 + i4), (float) (i2 + i5));
        canvas.drawBitmap(bitmap, this.f35901w, this.f35902x);
    }

    public void a(int i2) {
        this.f35876h = i2;
    }
}
