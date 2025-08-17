package com.startapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.startapp.la;
import com.startapp.sdk.ads.banner.BannerOptions;
import com.startapp.sdk.ads.banner.banner3d.Banner3DView;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.model.AdDetails;
import java.util.concurrent.atomic.AtomicBoolean;

public class s3 implements la.b, Parcelable {
    public static final Parcelable.Creator<s3> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public AdDetails f35836a;

    /* renamed from: b  reason: collision with root package name */
    public Point f35837b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f35838c = null;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f35839d = null;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f35840e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public TrackingParams f35841f;

    /* renamed from: g  reason: collision with root package name */
    public z6 f35842g = null;

    /* renamed from: h  reason: collision with root package name */
    public Banner3DView f35843h = null;

    public static class a implements Parcelable.Creator<s3> {
        public Object createFromParcel(Parcel parcel) {
            return new s3(parcel);
        }

        public Object[] newArray(int i2) {
            return new s3[i2];
        }
    }

    public s3(Context context, ViewGroup viewGroup, AdDetails adDetails, BannerOptions bannerOptions, TrackingParams trackingParams) {
        this.f35836a = adDetails;
        this.f35841f = trackingParams;
        a(context, bannerOptions, viewGroup);
    }

    public void a(Context context, BannerOptions bannerOptions, ViewGroup viewGroup) {
        int round = Math.round(TypedValue.applyDimension(1, (float) (bannerOptions.d() - 5), context.getResources().getDisplayMetrics()));
        this.f35837b = new Point((int) (((float) Math.round(TypedValue.applyDimension(1, (float) bannerOptions.o(), context.getResources().getDisplayMetrics()))) * bannerOptions.p()), (int) (((float) Math.round(TypedValue.applyDimension(1, (float) bannerOptions.d(), context.getResources().getDisplayMetrics()))) * bannerOptions.e()));
        Banner3DView banner3DView = new Banner3DView(context, new Point(bannerOptions.o(), bannerOptions.d()));
        this.f35843h = banner3DView;
        banner3DView.setText(this.f35836a.t());
        this.f35843h.setRating(this.f35836a.q());
        this.f35843h.setDescription(this.f35836a.i());
        this.f35843h.setButtonText(this.f35836a.z());
        Bitmap bitmap = this.f35838c;
        if (bitmap != null) {
            this.f35843h.setImage(bitmap, round, round);
        } else {
            this.f35843h.setImage(17301651, round, round);
            new la(context, this.f35836a.j(), this, 0).a();
        }
        Point point = this.f35837b;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(point.x, point.y);
        layoutParams.addRule(13);
        viewGroup.addView(this.f35843h, layoutParams);
        this.f35843h.setVisibility(8);
        a();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f35836a, i2);
        parcel.writeInt(this.f35837b.x);
        parcel.writeInt(this.f35837b.y);
        parcel.writeParcelable(this.f35838c, i2);
        parcel.writeBooleanArray(new boolean[]{this.f35840e.get()});
        parcel.writeSerializable(this.f35841f);
    }

    public s3(Parcel parcel) {
        this.f35836a = (AdDetails) parcel.readParcelable(AdDetails.class.getClassLoader());
        Point point = new Point(1, 1);
        this.f35837b = point;
        point.x = parcel.readInt();
        this.f35837b.y = parcel.readInt();
        this.f35838c = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f35840e.set(zArr[0]);
        this.f35841f = (TrackingParams) parcel.readSerializable();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        r1 = r4.f35837b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r4 = this;
            com.startapp.sdk.ads.banner.banner3d.Banner3DView r0 = r4.f35843h
            if (r0 == 0) goto L_0x0011
            android.graphics.Bitmap r0 = a(r0)     // Catch:{ OutOfMemoryError -> 0x0011, all -> 0x0009 }
            goto L_0x0012
        L_0x0009:
            r1 = move-exception
            android.content.Context r0 = r0.getContext()
            com.startapp.y8.a((android.content.Context) r0, (java.lang.Throwable) r1)
        L_0x0011:
            r0 = 0
        L_0x0012:
            r4.f35839d = r0
            if (r0 != 0) goto L_0x0017
            return
        L_0x0017:
            android.graphics.Point r1 = r4.f35837b
            int r2 = r1.x
            if (r2 <= 0) goto L_0x0028
            int r1 = r1.y
            if (r1 <= 0) goto L_0x0028
            r3 = 0
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createScaledBitmap(r0, r2, r1, r3)
            r4.f35839d = r0
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.s3.a():void");
    }

    public static Bitmap a(View view) {
        view.measure(view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.draw(canvas);
        return createBitmap;
    }

    public void a(Bitmap bitmap, int i2) {
        Banner3DView banner3DView;
        if (bitmap != null && (banner3DView = this.f35843h) != null) {
            this.f35838c = bitmap;
            banner3DView.setImage(bitmap);
            a();
        }
    }
}
