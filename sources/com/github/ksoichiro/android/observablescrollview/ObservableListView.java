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
import android.widget.ListView;

public class ObservableListView extends ListView {

    /* renamed from: b  reason: collision with root package name */
    private int f22110b;

    /* renamed from: c  reason: collision with root package name */
    private int f22111c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f22112d;

    /* renamed from: e  reason: collision with root package name */
    private int f22113e;

    /* renamed from: f  reason: collision with root package name */
    private int f22114f;

    /* renamed from: g  reason: collision with root package name */
    private SparseIntArray f22115g;

    /* renamed from: h  reason: collision with root package name */
    private ObservableScrollViewCallbacks f22116h;

    /* renamed from: i  reason: collision with root package name */
    private ScrollState f22117i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f22118j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f22119k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f22120l;

    /* renamed from: m  reason: collision with root package name */
    private MotionEvent f22121m;

    /* renamed from: n  reason: collision with root package name */
    private ViewGroup f22122n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public AbsListView.OnScrollListener f22123o;

    /* renamed from: p  reason: collision with root package name */
    private AbsListView.OnScrollListener f22124p = new AbsListView.OnScrollListener() {
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (ObservableListView.this.f22123o != null) {
                ObservableListView.this.f22123o.onScroll(absListView, i2, i3, i4);
            }
            ObservableListView.this.d();
        }

        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (ObservableListView.this.f22123o != null) {
                ObservableListView.this.f22123o.onScrollStateChanged(absListView, i2);
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
        int f22129b;

        /* renamed from: c  reason: collision with root package name */
        int f22130c;

        /* renamed from: d  reason: collision with root package name */
        int f22131d;

        /* renamed from: e  reason: collision with root package name */
        int f22132e;

        /* renamed from: f  reason: collision with root package name */
        int f22133f;

        /* renamed from: g  reason: collision with root package name */
        SparseIntArray f22134g;

        public void writeToParcel(Parcel parcel, int i2) {
            int i3;
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f22129b);
            parcel.writeInt(this.f22130c);
            parcel.writeInt(this.f22131d);
            parcel.writeInt(this.f22132e);
            parcel.writeInt(this.f22133f);
            SparseIntArray sparseIntArray = this.f22134g;
            if (sparseIntArray == null) {
                i3 = 0;
            } else {
                i3 = sparseIntArray.size();
            }
            parcel.writeInt(i3);
            if (i3 > 0) {
                for (int i4 = 0; i4 < i3; i4++) {
                    parcel.writeInt(this.f22134g.keyAt(i4));
                    parcel.writeInt(this.f22134g.valueAt(i4));
                }
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f22130c = -1;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f22130c = -1;
            this.f22129b = parcel.readInt();
            this.f22130c = parcel.readInt();
            this.f22131d = parcel.readInt();
            this.f22132e = parcel.readInt();
            this.f22133f = parcel.readInt();
            this.f22134g = new SparseIntArray();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                for (int i2 = 0; i2 < readInt; i2++) {
                    this.f22134g.put(parcel.readInt(), parcel.readInt());
                }
            }
        }
    }

    public ObservableListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c();
    }

    private void c() {
        this.f22115g = new SparseIntArray();
        super.setOnScrollListener(this.f22124p);
    }

    /* access modifiers changed from: private */
    public void d() {
        int i2;
        int i3;
        int i4;
        int i5;
        if (this.f22116h != null && getChildCount() > 0) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int firstVisiblePosition2 = getFirstVisiblePosition();
            int i6 = 0;
            while (firstVisiblePosition2 <= getLastVisiblePosition()) {
                if (this.f22115g.indexOfKey(firstVisiblePosition2) < 0 || getChildAt(i6).getHeight() != this.f22115g.get(firstVisiblePosition2)) {
                    this.f22115g.put(firstVisiblePosition2, getChildAt(i6).getHeight());
                }
                firstVisiblePosition2++;
                i6++;
            }
            View childAt = getChildAt(0);
            if (childAt != null) {
                int i7 = this.f22110b;
                if (i7 < firstVisiblePosition) {
                    if (firstVisiblePosition - i7 != 1) {
                        i4 = 0;
                        for (int i8 = firstVisiblePosition - 1; i8 > this.f22110b; i8--) {
                            if (this.f22115g.indexOfKey(i8) > 0) {
                                i5 = this.f22115g.get(i8);
                            } else {
                                i5 = childAt.getHeight();
                            }
                            i4 += i5;
                        }
                    } else {
                        i4 = 0;
                    }
                    this.f22112d += this.f22111c + i4;
                    this.f22111c = childAt.getHeight();
                } else if (firstVisiblePosition < i7) {
                    if (i7 - firstVisiblePosition != 1) {
                        i2 = 0;
                        for (int i9 = i7 - 1; i9 > firstVisiblePosition; i9--) {
                            if (this.f22115g.indexOfKey(i9) > 0) {
                                i3 = this.f22115g.get(i9);
                            } else {
                                i3 = childAt.getHeight();
                            }
                            i2 += i3;
                        }
                    } else {
                        i2 = 0;
                    }
                    this.f22112d -= childAt.getHeight() + i2;
                    this.f22111c = childAt.getHeight();
                } else if (firstVisiblePosition == 0) {
                    this.f22111c = childAt.getHeight();
                }
                if (this.f22111c < 0) {
                    this.f22111c = 0;
                }
                int top = this.f22112d - childAt.getTop();
                this.f22114f = top;
                this.f22110b = firstVisiblePosition;
                this.f22116h.q(top, this.f22118j, this.f22119k);
                if (this.f22118j) {
                    this.f22118j = false;
                }
                int i10 = this.f22113e;
                int i11 = this.f22114f;
                if (i10 < i11) {
                    this.f22117i = ScrollState.UP;
                } else if (i11 < i10) {
                    this.f22117i = ScrollState.DOWN;
                } else {
                    this.f22117i = ScrollState.STOP;
                }
                this.f22113e = i11;
            }
        }
    }

    public int getCurrentScrollY() {
        return this.f22114f;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f22116h != null && motionEvent.getActionMasked() == 0) {
            this.f22119k = true;
            this.f22118j = true;
            this.f22116h.A();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        this.f22110b = savedState.f22129b;
        this.f22111c = savedState.f22130c;
        this.f22112d = savedState.f22131d;
        this.f22113e = savedState.f22132e;
        this.f22114f = savedState.f22133f;
        this.f22115g = savedState.f22134g;
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f22129b = this.f22110b;
        savedState.f22130c = this.f22111c;
        savedState.f22131d = this.f22112d;
        savedState.f22132e = this.f22113e;
        savedState.f22133f = this.f22114f;
        savedState.f22134g = this.f22115g;
        return savedState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r0 != 3) goto L_0x0093;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks r0 = r8.f22116h
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
            android.view.MotionEvent r0 = r8.f22121m
            if (r0 != 0) goto L_0x001a
            r8.f22121m = r9
        L_0x001a:
            float r0 = r9.getY()
            android.view.MotionEvent r3 = r8.f22121m
            float r3 = r3.getY()
            float r0 = r0 - r3
            android.view.MotionEvent r3 = android.view.MotionEvent.obtainNoHistory(r9)
            r8.f22121m = r3
            int r3 = r8.getCurrentScrollY()
            float r3 = (float) r3
            float r3 = r3 - r0
            r0 = 0
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x0093
            boolean r3 = r8.f22120l
            if (r3 == 0) goto L_0x003b
            return r2
        L_0x003b:
            android.view.ViewGroup r3 = r8.f22122n
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
            r8.f22120l = r1
            r5.setAction(r2)
            com.github.ksoichiro.android.observablescrollview.ObservableListView$2 r9 = new com.github.ksoichiro.android.observablescrollview.ObservableListView$2
            r9.<init>(r3, r5)
            r8.post(r9)
            return r2
        L_0x0083:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        L_0x0088:
            r8.f22120l = r2
            r8.f22119k = r2
            com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks r0 = r8.f22116h
            com.github.ksoichiro.android.observablescrollview.ScrollState r1 = r8.f22117i
            r0.y(r1)
        L_0x0093:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.ksoichiro.android.observablescrollview.ObservableListView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f22123o = onScrollListener;
    }

    public void setScrollViewCallbacks(ObservableScrollViewCallbacks observableScrollViewCallbacks) {
        this.f22116h = observableScrollViewCallbacks;
    }

    public void setTouchInterceptionViewGroup(ViewGroup viewGroup) {
        this.f22122n = viewGroup;
    }
}
