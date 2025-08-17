package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.exoplayer2.video.spherical.OrientationListener;

final class TouchTracker extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, OrientationListener.Listener {

    /* renamed from: b  reason: collision with root package name */
    private final PointF f29046b = new PointF();

    /* renamed from: c  reason: collision with root package name */
    private final PointF f29047c = new PointF();

    /* renamed from: d  reason: collision with root package name */
    private final Listener f29048d;

    /* renamed from: e  reason: collision with root package name */
    private final float f29049e;

    /* renamed from: f  reason: collision with root package name */
    private final GestureDetector f29050f;

    /* renamed from: g  reason: collision with root package name */
    private volatile float f29051g;

    public interface Listener {
        void b(PointF pointF);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    public TouchTracker(Context context, Listener listener, float f2) {
        this.f29048d = listener;
        this.f29049e = f2;
        this.f29050f = new GestureDetector(context, this);
        this.f29051g = 3.1415927f;
    }

    public void a(float[] fArr, float f2) {
        this.f29051g = -f2;
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.f29046b.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        float x2 = (motionEvent2.getX() - this.f29046b.x) / this.f29049e;
        float y2 = motionEvent2.getY();
        PointF pointF = this.f29046b;
        float f4 = (y2 - pointF.y) / this.f29049e;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d2 = (double) this.f29051g;
        float cos = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        PointF pointF2 = this.f29047c;
        pointF2.x -= (cos * x2) - (sin * f4);
        float f5 = pointF2.y + (sin * x2) + (cos * f4);
        pointF2.y = f5;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f5));
        this.f29048d.b(this.f29047c);
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f29048d.onSingleTapUp(motionEvent);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f29050f.onTouchEvent(motionEvent);
    }
}
