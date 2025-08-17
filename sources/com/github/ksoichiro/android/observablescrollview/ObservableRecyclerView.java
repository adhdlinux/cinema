package com.github.ksoichiro.android.observablescrollview;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public class ObservableRecyclerView extends RecyclerView {

    /* renamed from: i  reason: collision with root package name */
    private int f22135i;

    /* renamed from: j  reason: collision with root package name */
    private int f22136j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f22137k;

    /* renamed from: l  reason: collision with root package name */
    private int f22138l;

    /* renamed from: m  reason: collision with root package name */
    private int f22139m;

    /* renamed from: n  reason: collision with root package name */
    private SparseIntArray f22140n;

    /* renamed from: o  reason: collision with root package name */
    private ObservableScrollViewCallbacks f22141o;

    /* renamed from: p  reason: collision with root package name */
    private ScrollState f22142p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f22143q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f22144r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f22145s;

    /* renamed from: t  reason: collision with root package name */
    private MotionEvent f22146t;

    /* renamed from: u  reason: collision with root package name */
    private ViewGroup f22147u;

    public ObservableRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    private void b() {
        this.f22140n = new SparseIntArray();
    }

    public int getCurrentScrollY() {
        return this.f22139m;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f22141o != null && motionEvent.getActionMasked() == 0) {
            this.f22144r = true;
            this.f22143q = true;
            this.f22141o.A();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        this.f22135i = savedState.f22152b;
        this.f22136j = savedState.f22153c;
        this.f22137k = savedState.f22154d;
        this.f22138l = savedState.f22155e;
        this.f22139m = savedState.f22156f;
        this.f22140n = savedState.f22157g;
        super.onRestoreInstanceState(savedState.b());
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f22152b = this.f22135i;
        savedState.f22153c = this.f22136j;
        savedState.f22154d = this.f22137k;
        savedState.f22155e = this.f22138l;
        savedState.f22156f = this.f22139m;
        savedState.f22157g = this.f22140n;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        super.onScrollChanged(i2, i3, i4, i5);
        if (this.f22141o != null && getChildCount() > 0) {
            int childPosition = getChildPosition(getChildAt(0));
            int childPosition2 = getChildPosition(getChildAt(getChildCount() - 1));
            int i10 = childPosition;
            int i11 = 0;
            while (i10 <= childPosition2) {
                if (this.f22140n.indexOfKey(i10) < 0 || getChildAt(i11).getHeight() != this.f22140n.get(i10)) {
                    this.f22140n.put(i10, getChildAt(i11).getHeight());
                }
                i10++;
                i11++;
            }
            View childAt = getChildAt(0);
            if (childAt != null) {
                int i12 = this.f22135i;
                if (i12 < childPosition) {
                    if (childPosition - i12 != 1) {
                        i8 = 0;
                        for (int i13 = childPosition - 1; i13 > this.f22135i; i13--) {
                            if (this.f22140n.indexOfKey(i13) > 0) {
                                i9 = this.f22140n.get(i13);
                            } else {
                                i9 = childAt.getHeight();
                            }
                            i8 += i9;
                        }
                    } else {
                        i8 = 0;
                    }
                    this.f22137k += this.f22136j + i8;
                    this.f22136j = childAt.getHeight();
                } else if (childPosition < i12) {
                    if (i12 - childPosition != 1) {
                        i6 = 0;
                        for (int i14 = i12 - 1; i14 > childPosition; i14--) {
                            if (this.f22140n.indexOfKey(i14) > 0) {
                                i7 = this.f22140n.get(i14);
                            } else {
                                i7 = childAt.getHeight();
                            }
                            i6 += i7;
                        }
                    } else {
                        i6 = 0;
                    }
                    this.f22137k -= childAt.getHeight() + i6;
                    this.f22136j = childAt.getHeight();
                } else if (childPosition == 0) {
                    this.f22136j = childAt.getHeight();
                    this.f22137k = 0;
                }
                if (this.f22136j < 0) {
                    this.f22136j = 0;
                }
                int top = this.f22137k - childAt.getTop();
                this.f22139m = top;
                this.f22135i = childPosition;
                this.f22141o.q(top, this.f22143q, this.f22144r);
                if (this.f22143q) {
                    this.f22143q = false;
                }
                int i15 = this.f22138l;
                int i16 = this.f22139m;
                if (i15 < i16) {
                    this.f22142p = ScrollState.UP;
                } else if (i16 < i15) {
                    this.f22142p = ScrollState.DOWN;
                } else {
                    this.f22142p = ScrollState.STOP;
                }
                this.f22138l = i16;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r0 != 3) goto L_0x0093;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks r0 = r8.f22141o
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
            android.view.MotionEvent r0 = r8.f22146t
            if (r0 != 0) goto L_0x001a
            r8.f22146t = r9
        L_0x001a:
            float r0 = r9.getY()
            android.view.MotionEvent r3 = r8.f22146t
            float r3 = r3.getY()
            float r0 = r0 - r3
            android.view.MotionEvent r3 = android.view.MotionEvent.obtainNoHistory(r9)
            r8.f22146t = r3
            int r3 = r8.getCurrentScrollY()
            float r3 = (float) r3
            float r3 = r3 - r0
            r0 = 0
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x0093
            boolean r3 = r8.f22145s
            if (r3 == 0) goto L_0x003b
            return r2
        L_0x003b:
            android.view.ViewGroup r3 = r8.f22147u
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
            r8.f22145s = r1
            r5.setAction(r2)
            com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView$1 r9 = new com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView$1
            r9.<init>(r3, r5)
            r8.post(r9)
            return r2
        L_0x0083:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        L_0x0088:
            r8.f22145s = r2
            r8.f22144r = r2
            com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks r0 = r8.f22141o
            com.github.ksoichiro.android.observablescrollview.ScrollState r1 = r8.f22142p
            r0.y(r1)
        L_0x0093:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setScrollViewCallbacks(ObservableScrollViewCallbacks observableScrollViewCallbacks) {
        this.f22141o = observableScrollViewCallbacks;
    }

    public void setTouchInterceptionViewGroup(ViewGroup viewGroup) {
        this.f22147u = viewGroup;
    }

    static class SavedState implements Parcelable {
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

        /* renamed from: i  reason: collision with root package name */
        public static final SavedState f22151i = new SavedState() {
        };

        /* renamed from: b  reason: collision with root package name */
        int f22152b;

        /* renamed from: c  reason: collision with root package name */
        int f22153c;

        /* renamed from: d  reason: collision with root package name */
        int f22154d;

        /* renamed from: e  reason: collision with root package name */
        int f22155e;

        /* renamed from: f  reason: collision with root package name */
        int f22156f;

        /* renamed from: g  reason: collision with root package name */
        SparseIntArray f22157g;

        /* renamed from: h  reason: collision with root package name */
        Parcelable f22158h;

        public Parcelable b() {
            return this.f22158h;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int i3;
            parcel.writeParcelable(this.f22158h, i2);
            parcel.writeInt(this.f22152b);
            parcel.writeInt(this.f22153c);
            parcel.writeInt(this.f22154d);
            parcel.writeInt(this.f22155e);
            parcel.writeInt(this.f22156f);
            SparseIntArray sparseIntArray = this.f22157g;
            if (sparseIntArray == null) {
                i3 = 0;
            } else {
                i3 = sparseIntArray.size();
            }
            parcel.writeInt(i3);
            if (i3 > 0) {
                for (int i4 = 0; i4 < i3; i4++) {
                    parcel.writeInt(this.f22157g.keyAt(i4));
                    parcel.writeInt(this.f22157g.valueAt(i4));
                }
            }
        }

        private SavedState() {
            this.f22153c = -1;
            this.f22158h = null;
        }

        SavedState(Parcelable parcelable) {
            this.f22153c = -1;
            this.f22158h = parcelable == f22151i ? null : parcelable;
        }

        private SavedState(Parcel parcel) {
            this.f22153c = -1;
            Parcelable readParcelable = parcel.readParcelable(RecyclerView.class.getClassLoader());
            this.f22158h = readParcelable == null ? f22151i : readParcelable;
            this.f22152b = parcel.readInt();
            this.f22153c = parcel.readInt();
            this.f22154d = parcel.readInt();
            this.f22155e = parcel.readInt();
            this.f22156f = parcel.readInt();
            this.f22157g = new SparseIntArray();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                for (int i2 = 0; i2 < readInt; i2++) {
                    this.f22157g.put(parcel.readInt(), parcel.readInt());
                }
            }
        }
    }
}
