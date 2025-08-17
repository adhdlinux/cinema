package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

public final class GestureDetectorCompat {

    /* renamed from: a  reason: collision with root package name */
    private final GestureDetectorCompatImpl f2744a;

    interface GestureDetectorCompatImpl {
        void a(boolean z2);

        boolean onTouchEvent(MotionEvent motionEvent);
    }

    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {

        /* renamed from: a  reason: collision with root package name */
        private final GestureDetector f2745a;

        GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f2745a = new GestureDetector(context, onGestureListener, handler);
        }

        public void a(boolean z2) {
            this.f2745a.setIsLongpressEnabled(z2);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.f2745a.onTouchEvent(motionEvent);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, (Handler) null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f2744a.onTouchEvent(motionEvent);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void b(boolean z2) {
        this.f2744a.a(z2);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f2744a = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
    }
}
