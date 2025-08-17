package com.github.ksoichiro.android.observablescrollview;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;

public class ObservableGridView extends GridView {

    /* renamed from: b  reason: collision with root package name */
    private int f22085b;

    /* renamed from: c  reason: collision with root package name */
    private int f22086c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f22087d;

    /* renamed from: e  reason: collision with root package name */
    private int f22088e;

    /* renamed from: f  reason: collision with root package name */
    private int f22089f;

    /* renamed from: g  reason: collision with root package name */
    private SparseIntArray f22090g;

    /* renamed from: h  reason: collision with root package name */
    private ObservableScrollViewCallbacks f22091h;

    /* renamed from: i  reason: collision with root package name */
    private ScrollState f22092i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f22093j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f22094k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f22095l;

    /* renamed from: m  reason: collision with root package name */
    private MotionEvent f22096m;

    /* renamed from: n  reason: collision with root package name */
    private ViewGroup f22097n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public AbsListView.OnScrollListener f22098o;

    /* renamed from: p  reason: collision with root package name */
    private AbsListView.OnScrollListener f22099p = new AbsListView.OnScrollListener() {
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (ObservableGridView.this.f22098o != null) {
                ObservableGridView.this.f22098o.onScroll(absListView, i2, i3, i4);
            }
            ObservableGridView.this.d();
        }

        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (ObservableGridView.this.f22098o != null) {
                ObservableGridView.this.f22098o.onScrollStateChanged(absListView, i2);
            }
        }
    };

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
        int f22104b;

        /* renamed from: c  reason: collision with root package name */
        int f22105c;

        /* renamed from: d  reason: collision with root package name */
        int f22106d;

        /* renamed from: e  reason: collision with root package name */
        int f22107e;

        /* renamed from: f  reason: collision with root package name */
        int f22108f;

        /* renamed from: g  reason: collision with root package name */
        SparseIntArray f22109g;

        public void writeToParcel(Parcel parcel, int i2) {
            int i3;
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f22104b);
            parcel.writeInt(this.f22105c);
            parcel.writeInt(this.f22106d);
            parcel.writeInt(this.f22107e);
            parcel.writeInt(this.f22108f);
            SparseIntArray sparseIntArray = this.f22109g;
            if (sparseIntArray == null) {
                i3 = 0;
            } else {
                i3 = sparseIntArray.size();
            }
            parcel.writeInt(i3);
            if (i3 > 0) {
                for (int i4 = 0; i4 < i3; i4++) {
                    parcel.writeInt(this.f22109g.keyAt(i4));
                    parcel.writeInt(this.f22109g.valueAt(i4));
                }
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f22105c = -1;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f22105c = -1;
            this.f22104b = parcel.readInt();
            this.f22105c = parcel.readInt();
            this.f22106d = parcel.readInt();
            this.f22107e = parcel.readInt();
            this.f22108f = parcel.readInt();
            this.f22109g = new SparseIntArray();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                for (int i2 = 0; i2 < readInt; i2++) {
                    this.f22109g.put(parcel.readInt(), parcel.readInt());
                }
            }
        }
    }

    public ObservableGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    private void c() {
        this.f22090g = new SparseIntArray();
        super.setOnScrollListener(this.f22099p);
    }

    /* access modifiers changed from: private */
    public void d() {
        int i2;
        int i3;
        if (this.f22091h != null && getChildCount() > 0) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int firstVisiblePosition2 = getFirstVisiblePosition();
            int i4 = 0;
            while (firstVisiblePosition2 <= getLastVisiblePosition()) {
                if ((this.f22090g.indexOfKey(firstVisiblePosition2) < 0 || getChildAt(i4).getHeight() != this.f22090g.get(firstVisiblePosition2)) && firstVisiblePosition2 % getNumColumnsCompat() == 0) {
                    this.f22090g.put(firstVisiblePosition2, getChildAt(i4).getHeight());
                }
                firstVisiblePosition2++;
                i4++;
            }
            View childAt = getChildAt(0);
            if (childAt != null) {
                int i5 = this.f22085b;
                if (i5 < firstVisiblePosition) {
                    if (firstVisiblePosition - i5 != 1) {
                        i3 = 0;
                        for (int i6 = firstVisiblePosition - 1; i6 > this.f22085b; i6--) {
                            if (this.f22090g.indexOfKey(i6) > 0) {
                                i3 += this.f22090g.get(i6);
                            }
                        }
                    } else {
                        i3 = 0;
                    }
                    this.f22087d += this.f22086c + i3;
                    this.f22086c = childAt.getHeight();
                } else if (firstVisiblePosition < i5) {
                    if (i5 - firstVisiblePosition != 1) {
                        i2 = 0;
                        for (int i7 = i5 - 1; i7 > firstVisiblePosition; i7--) {
                            if (this.f22090g.indexOfKey(i7) > 0) {
                                i2 += this.f22090g.get(i7);
                            }
                        }
                    } else {
                        i2 = 0;
                    }
                    this.f22087d -= childAt.getHeight() + i2;
                    this.f22086c = childAt.getHeight();
                } else if (firstVisiblePosition == 0) {
                    this.f22086c = childAt.getHeight();
                }
                if (this.f22086c < 0) {
                    this.f22086c = 0;
                }
                int top = this.f22087d - childAt.getTop();
                this.f22089f = top;
                this.f22085b = firstVisiblePosition;
                this.f22091h.q(top, this.f22093j, this.f22094k);
                if (this.f22093j) {
                    this.f22093j = false;
                }
                int i8 = this.f22088e;
                int i9 = this.f22089f;
                if (i8 < i9) {
                    this.f22092i = ScrollState.UP;
                } else if (i9 < i8) {
                    this.f22092i = ScrollState.DOWN;
                } else {
                    this.f22092i = ScrollState.STOP;
                }
                this.f22088e = i9;
            }
        }
    }

    private int getNumColumnsCompat() {
        return getNumColumns();
    }

    public int getCurrentScrollY() {
        return this.f22089f;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f22091h != null && motionEvent.getActionMasked() == 0) {
            this.f22094k = true;
            this.f22093j = true;
            this.f22091h.A();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        this.f22085b = savedState.f22104b;
        this.f22086c = savedState.f22105c;
        this.f22087d = savedState.f22106d;
        this.f22088e = savedState.f22107e;
        this.f22089f = savedState.f22108f;
        this.f22090g = savedState.f22109g;
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f22104b = this.f22085b;
        savedState.f22105c = this.f22086c;
        savedState.f22106d = this.f22087d;
        savedState.f22107e = this.f22088e;
        savedState.f22108f = this.f22089f;
        savedState.f22109g = this.f22090g;
        return savedState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r0 != 3) goto L_0x0093;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks r0 = r8.f22091h
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
            android.view.MotionEvent r0 = r8.f22096m
            if (r0 != 0) goto L_0x001a
            r8.f22096m = r9
        L_0x001a:
            float r0 = r9.getY()
            android.view.MotionEvent r3 = r8.f22096m
            float r3 = r3.getY()
            float r0 = r0 - r3
            android.view.MotionEvent r3 = android.view.MotionEvent.obtainNoHistory(r9)
            r8.f22096m = r3
            int r3 = r8.getCurrentScrollY()
            float r3 = (float) r3
            float r3 = r3 - r0
            r0 = 0
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x0093
            boolean r3 = r8.f22095l
            if (r3 == 0) goto L_0x003b
            return r2
        L_0x003b:
            android.view.ViewGroup r3 = r8.f22097n
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
            r8.f22095l = r1
            r5.setAction(r2)
            com.github.ksoichiro.android.observablescrollview.ObservableGridView$2 r9 = new com.github.ksoichiro.android.observablescrollview.ObservableGridView$2
            r9.<init>(r3, r5)
            r8.post(r9)
            return r2
        L_0x0083:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        L_0x0088:
            r8.f22095l = r2
            r8.f22094k = r2
            com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks r0 = r8.f22091h
            com.github.ksoichiro.android.observablescrollview.ScrollState r1 = r8.f22092i
            r0.y(r1)
        L_0x0093:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.ksoichiro.android.observablescrollview.ObservableGridView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f22098o = onScrollListener;
    }

    public void setScrollViewCallbacks(ObservableScrollViewCallbacks observableScrollViewCallbacks) {
        this.f22091h = observableScrollViewCallbacks;
    }

    public void setTouchInterceptionViewGroup(ViewGroup viewGroup) {
        this.f22097n = viewGroup;
    }
}
