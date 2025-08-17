package com.facebook.ads.internal.q.a;

import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

public class u {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20674a = "u";

    /* renamed from: b  reason: collision with root package name */
    private boolean f20675b;

    /* renamed from: c  reason: collision with root package name */
    private int f20676c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f20677d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f20678e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f20679f = -1;

    /* renamed from: g  reason: collision with root package name */
    private long f20680g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f20681h = -1;

    /* renamed from: i  reason: collision with root package name */
    private long f20682i = -1;

    /* renamed from: j  reason: collision with root package name */
    private long f20683j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f20684k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f20685l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f20686m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f20687n = -1;

    /* renamed from: o  reason: collision with root package name */
    private float f20688o = -1.0f;

    /* renamed from: p  reason: collision with root package name */
    private float f20689p = -1.0f;

    /* renamed from: q  reason: collision with root package name */
    private float f20690q = -1.0f;

    /* renamed from: r  reason: collision with root package name */
    private View f20691r;

    /* renamed from: s  reason: collision with root package name */
    private View f20692s;

    private j f() {
        View view;
        View view2 = this.f20691r;
        if (view2 == null || (view = this.f20692s) == null) {
            return j.INTERNAL_NULL_VIEW;
        }
        if (view2 != view) {
            return j.INTERNAL_NO_CLICK;
        }
        Object tag = view2.getTag(j.f20645o);
        return tag == null ? j.INTERNAL_NO_TAG : !(tag instanceof j) ? j.INTERNAL_WRONG_TAG_CLASS : (j) tag;
    }

    public void a() {
        this.f20680g = System.currentTimeMillis();
    }

    public void a(MotionEvent motionEvent, View view, View view2) {
        if (!this.f20675b) {
            this.f20675b = true;
            InputDevice device = motionEvent.getDevice();
            if (device != null) {
                InputDevice.MotionRange motionRange = device.getMotionRange(0);
                InputDevice.MotionRange motionRange2 = device.getMotionRange(1);
                if (!(motionRange == null || motionRange2 == null)) {
                    this.f20690q = Math.min(motionRange.getRange(), motionRange2.getRange());
                }
            }
            if (this.f20690q <= 0.0f) {
                this.f20690q = (float) Math.min(view.getMeasuredWidth(), view.getMeasuredHeight());
            }
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        view2.getLocationInWindow(iArr2);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float f2 = this.f20688o;
                    float f3 = f2 - (f2 / ((float) this.f20681h));
                    this.f20688o = f3;
                    float pressure = motionEvent.getPressure();
                    int i2 = this.f20681h;
                    this.f20688o = f3 + (pressure / ((float) i2));
                    float f4 = this.f20689p;
                    float f5 = f4 - (f4 / ((float) i2));
                    this.f20689p = f5;
                    float size = motionEvent.getSize();
                    int i3 = this.f20681h;
                    this.f20689p = f5 + (size / ((float) i3));
                    this.f20681h = i3 + 1;
                    return;
                } else if (action != 3) {
                    return;
                }
            }
            this.f20683j = System.currentTimeMillis();
            float f6 = x.f20694b;
            this.f20686m = (int) (((float) ((((int) (motionEvent.getX() + 0.5f)) + iArr2[0]) - iArr[0])) / f6);
            this.f20687n = (int) (((float) ((((int) (motionEvent.getY() + 0.5f)) + iArr2[1]) - iArr[1])) / f6);
            this.f20692s = view2;
            return;
        }
        float f7 = x.f20694b;
        this.f20676c = (int) (((float) iArr[0]) / f7);
        this.f20677d = (int) (((float) iArr[1]) / f7);
        this.f20678e = (int) (((float) view.getWidth()) / f7);
        this.f20679f = (int) (((float) view.getHeight()) / f7);
        this.f20681h = 1;
        this.f20682i = System.currentTimeMillis();
        this.f20684k = (int) (((float) ((((int) (motionEvent.getX() + 0.5f)) + iArr2[0]) - iArr[0])) / f7);
        this.f20685l = (int) (((float) ((((int) (motionEvent.getY() + 0.5f)) + iArr2[1]) - iArr[1])) / f7);
        this.f20688o = motionEvent.getPressure();
        this.f20689p = motionEvent.getSize();
        this.f20691r = view2;
    }

    public boolean b() {
        return this.f20680g != -1;
    }

    public long c() {
        if (b()) {
            return System.currentTimeMillis() - this.f20680g;
        }
        return -1;
    }

    public boolean d() {
        return this.f20675b;
    }

    public Map<String, String> e() {
        long j2;
        if (!this.f20675b) {
            return null;
        }
        String valueOf = String.valueOf((this.f20689p * this.f20690q) / 2.0f);
        long j3 = this.f20680g;
        if (j3 > 0) {
            long j4 = this.f20683j;
            if (j4 > j3) {
                j2 = j4 - j3;
                HashMap hashMap = new HashMap();
                hashMap.put("adPositionX", String.valueOf(this.f20676c));
                hashMap.put("adPositionY", String.valueOf(this.f20677d));
                hashMap.put("width", String.valueOf(this.f20678e));
                hashMap.put("height", String.valueOf(this.f20679f));
                hashMap.put("clickDelayTime", String.valueOf(j2));
                hashMap.put("startTime", String.valueOf(this.f20682i));
                hashMap.put("endTime", String.valueOf(this.f20683j));
                hashMap.put("startX", String.valueOf(this.f20684k));
                hashMap.put("startY", String.valueOf(this.f20685l));
                hashMap.put("clickX", String.valueOf(this.f20686m));
                hashMap.put("clickY", String.valueOf(this.f20687n));
                hashMap.put("endX", String.valueOf(this.f20686m));
                hashMap.put("endY", String.valueOf(this.f20687n));
                hashMap.put("force", String.valueOf(this.f20688o));
                hashMap.put("radiusX", valueOf);
                hashMap.put("radiusY", valueOf);
                hashMap.put("clickedViewTag", String.valueOf(f().a()));
                return hashMap;
            }
        }
        j2 = -1;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("adPositionX", String.valueOf(this.f20676c));
        hashMap2.put("adPositionY", String.valueOf(this.f20677d));
        hashMap2.put("width", String.valueOf(this.f20678e));
        hashMap2.put("height", String.valueOf(this.f20679f));
        hashMap2.put("clickDelayTime", String.valueOf(j2));
        hashMap2.put("startTime", String.valueOf(this.f20682i));
        hashMap2.put("endTime", String.valueOf(this.f20683j));
        hashMap2.put("startX", String.valueOf(this.f20684k));
        hashMap2.put("startY", String.valueOf(this.f20685l));
        hashMap2.put("clickX", String.valueOf(this.f20686m));
        hashMap2.put("clickY", String.valueOf(this.f20687n));
        hashMap2.put("endX", String.valueOf(this.f20686m));
        hashMap2.put("endY", String.valueOf(this.f20687n));
        hashMap2.put("force", String.valueOf(this.f20688o));
        hashMap2.put("radiusX", valueOf);
        hashMap2.put("radiusY", valueOf);
        hashMap2.put("clickedViewTag", String.valueOf(f().a()));
        return hashMap2;
    }
}
