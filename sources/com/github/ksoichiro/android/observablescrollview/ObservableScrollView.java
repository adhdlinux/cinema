package com.github.ksoichiro.android.observablescrollview;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

public class ObservableScrollView extends ScrollView {

    /* renamed from: b  reason: collision with root package name */
    private int f22159b;

    /* renamed from: c  reason: collision with root package name */
    private int f22160c;

    /* renamed from: d  reason: collision with root package name */
    private ObservableScrollViewCallbacks f22161d;

    /* renamed from: e  reason: collision with root package name */
    private ScrollState f22162e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22163f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22164g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f22165h;

    /* renamed from: i  reason: collision with root package name */
    private MotionEvent f22166i;

    /* renamed from: j  reason: collision with root package name */
    private ViewGroup f22167j;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        int f22171b;

        /* renamed from: c  reason: collision with root package name */
        int f22172c;

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f22171b);
            parcel.writeInt(this.f22172c);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f22171b = parcel.readInt();
            this.f22172c = parcel.readInt();
        }
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getCurrentScrollY() {
        return this.f22160c;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f22161d != null && motionEvent.getActionMasked() == 0) {
            this.f22164g = true;
            this.f22163f = true;
            this.f22161d.A();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        this.f22159b = savedState.f22171b;
        this.f22160c = savedState.f22172c;
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f22171b = this.f22159b;
        savedState.f22172c = this.f22160c;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        ObservableScrollViewCallbacks observableScrollViewCallbacks = this.f22161d;
        if (observableScrollViewCallbacks != null) {
            this.f22160c = i3;
            observableScrollViewCallbacks.q(i3, this.f22163f, this.f22164g);
            if (this.f22163f) {
                this.f22163f = false;
            }
            int i6 = this.f22159b;
            if (i6 < i3) {
                this.f22162e = ScrollState.UP;
            } else if (i3 < i6) {
                this.f22162e = ScrollState.DOWN;
            }
            this.f22159b = i3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r0 != 3) goto L_0x0093;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks r0 = r8.f22161d
            if (r0 == 0) goto L_0x0093
            int r0 = r9.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x0088
            r3 = 2
            if (r0 == r3) goto L_0x0014
            r1 = 3
            if (r0 == r1) goto L_0x0088
            goto L_0x0093
        L_0x0014:
            android.view.MotionEvent r0 = r8.f22166i
            if (r0 != 0) goto L_0x001a
            r8.f22166i = r9
        L_0x001a:
            float r0 = r9.getY()
            android.view.MotionEvent r3 = r8.f22166i
            float r3 = r3.getY()
            float r0 = r0 - r3
            android.view.MotionEvent r3 = android.view.MotionEvent.obtainNoHistory(r9)
            r8.f22166i = r3
            int r3 = r8.getCurrentScrollY()
            float r3 = (float) r3
            float r3 = r3 - r0
            r0 = 0
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x0093
            boolean r3 = r8.f22165h
            if (r3 == 0) goto L_0x003b
            return r2
        L_0x003b:
            android.view.ViewGroup r3 = r8.f22167j
            if (r3 != 0) goto L_0x0045
            android.view.ViewParent r3 = r8.getParent()
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
        L_0x0045:
            r4 = 0
            r5 = r8
        L_0x0047:
            if (r5 == 0) goto L_0x0068
            if (r5 == r3) goto L_0x0068
            int r6 = r5.getLeft()
            int r7 = r5.getScrollX()
            int r6 = r6 - r7
            float r6 = (float) r6
            float r0 = r0 + r6
            int r6 = r5.getTop()
            int r7 = r5.getScrollY()
            int r6 = r6 - r7
            float r6 = (float) r6
            float r4 = r4 + r6
            android.view.ViewParent r5 = r5.getParent()
            android.view.View r5 = (android.view.View) r5
            goto L_0x0047
        L_0x0068:
            android.view.MotionEvent r5 = android.view.MotionEvent.obtainNoHistory(r9)
            r5.offsetLocation(r0, r4)
            boolean r0 = r3.onInterceptTouchEvent(r5)
            if (r0 == 0) goto L_0x0083
            r8.f22165h = r1
            r5.setAction(r2)
            com.github.ksoichiro.android.observablescrollview.ObservableScrollView$1 r9 = new com.github.ksoichiro.android.observablescrollview.ObservableScrollView$1
            r9.<init>(r3, r5)
            r8.post(r9)
            return r2
        L_0x0083:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        L_0x0088:
            r8.f22165h = r2
            r8.f22164g = r2
            com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks r0 = r8.f22161d
            com.github.ksoichiro.android.observablescrollview.ScrollState r1 = r8.f22162e
            r0.y(r1)
        L_0x0093:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.ksoichiro.android.observablescrollview.ObservableScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setScrollViewCallbacks(ObservableScrollViewCallbacks observableScrollViewCallbacks) {
        this.f22161d = observableScrollViewCallbacks;
    }

    public void setTouchInterceptionViewGroup(ViewGroup viewGroup) {
        this.f22167j = viewGroup;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
