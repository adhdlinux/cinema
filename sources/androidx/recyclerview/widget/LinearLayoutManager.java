package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    static class AnchorInfo {

        /* renamed from: a  reason: collision with root package name */
        OrientationHelper f11182a;

        /* renamed from: b  reason: collision with root package name */
        int f11183b;

        /* renamed from: c  reason: collision with root package name */
        int f11184c;

        /* renamed from: d  reason: collision with root package name */
        boolean f11185d;

        /* renamed from: e  reason: collision with root package name */
        boolean f11186e;

        AnchorInfo() {
            e();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i2;
            if (this.f11185d) {
                i2 = this.f11182a.i();
            } else {
                i2 = this.f11182a.m();
            }
            this.f11184c = i2;
        }

        public void b(View view, int i2) {
            if (this.f11185d) {
                this.f11184c = this.f11182a.d(view) + this.f11182a.o();
            } else {
                this.f11184c = this.f11182a.g(view);
            }
            this.f11183b = i2;
        }

        public void c(View view, int i2) {
            int o2 = this.f11182a.o();
            if (o2 >= 0) {
                b(view, i2);
                return;
            }
            this.f11183b = i2;
            if (this.f11185d) {
                int i3 = (this.f11182a.i() - o2) - this.f11182a.d(view);
                this.f11184c = this.f11182a.i() - i3;
                if (i3 > 0) {
                    int e2 = this.f11184c - this.f11182a.e(view);
                    int m2 = this.f11182a.m();
                    int min = e2 - (m2 + Math.min(this.f11182a.g(view) - m2, 0));
                    if (min < 0) {
                        this.f11184c += Math.min(i3, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g2 = this.f11182a.g(view);
            int m3 = g2 - this.f11182a.m();
            this.f11184c = g2;
            if (m3 > 0) {
                int i4 = (this.f11182a.i() - Math.min(0, (this.f11182a.i() - o2) - this.f11182a.d(view))) - (g2 + this.f11182a.e(view));
                if (i4 < 0) {
                    this.f11184c -= Math.min(m3, -i4);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (layoutParams.c() || layoutParams.a() < 0 || layoutParams.a() >= state.b()) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f11183b = -1;
            this.f11184c = Integer.MIN_VALUE;
            this.f11185d = false;
            this.f11186e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f11183b + ", mCoordinate=" + this.f11184c + ", mLayoutFromEnd=" + this.f11185d + ", mValid=" + this.f11186e + '}';
        }
    }

    protected static class LayoutChunkResult {

        /* renamed from: a  reason: collision with root package name */
        public int f11187a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f11188b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f11189c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f11190d;

        protected LayoutChunkResult() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f11187a = 0;
            this.f11188b = false;
            this.f11189c = false;
            this.f11190d = false;
        }
    }

    static class LayoutState {

        /* renamed from: a  reason: collision with root package name */
        boolean f11191a = true;

        /* renamed from: b  reason: collision with root package name */
        int f11192b;

        /* renamed from: c  reason: collision with root package name */
        int f11193c;

        /* renamed from: d  reason: collision with root package name */
        int f11194d;

        /* renamed from: e  reason: collision with root package name */
        int f11195e;

        /* renamed from: f  reason: collision with root package name */
        int f11196f;

        /* renamed from: g  reason: collision with root package name */
        int f11197g;

        /* renamed from: h  reason: collision with root package name */
        int f11198h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f11199i = 0;

        /* renamed from: j  reason: collision with root package name */
        boolean f11200j = false;

        /* renamed from: k  reason: collision with root package name */
        int f11201k;

        /* renamed from: l  reason: collision with root package name */
        List<RecyclerView.ViewHolder> f11202l = null;

        /* renamed from: m  reason: collision with root package name */
        boolean f11203m;

        LayoutState() {
        }

        private View e() {
            int size = this.f11202l.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.f11202l.get(i2).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.c() && this.f11194d == layoutParams.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b((View) null);
        }

        public void b(View view) {
            View f2 = f(view);
            if (f2 == null) {
                this.f11194d = -1;
            } else {
                this.f11194d = ((RecyclerView.LayoutParams) f2.getLayoutParams()).a();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(RecyclerView.State state) {
            int i2 = this.f11194d;
            return i2 >= 0 && i2 < state.b();
        }

        /* access modifiers changed from: package-private */
        public View d(RecyclerView.Recycler recycler) {
            if (this.f11202l != null) {
                return e();
            }
            View o2 = recycler.o(this.f11194d);
            this.f11194d += this.f11195e;
            return o2;
        }

        public View f(View view) {
            int a2;
            int size = this.f11202l.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.f11202l.get(i3).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.c() && (a2 = (layoutParams.a() - this.f11194d) * this.f11195e) >= 0 && a2 < i2) {
                    view2 = view3;
                    if (a2 == 0) {
                        break;
                    }
                    i2 = a2;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
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
        int f11204b;

        /* renamed from: c  reason: collision with root package name */
        int f11205c;

        /* renamed from: d  reason: collision with root package name */
        boolean f11206d;

        public SavedState() {
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f11204b >= 0;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f11204b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f11204b);
            parcel.writeInt(this.f11205c);
            parcel.writeInt(this.f11206d ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.f11204b = parcel.readInt();
            this.f11205c = parcel.readInt();
            this.f11206d = parcel.readInt() != 1 ? false : true;
        }

        @SuppressLint({"UnknownNullness"})
        public SavedState(SavedState savedState) {
            this.f11204b = savedState.f11204b;
            this.f11205c = savedState.f11205c;
            this.f11206d = savedState.f11206d;
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return ScrollbarHelper.a(state, orientationHelper, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return ScrollbarHelper.b(state, orientationHelper, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return ScrollbarHelper.c(state, orientationHelper, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild();
        }
        return findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild();
        }
        return findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private int fixLayoutEndGap(int i2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int i3;
        int i4 = this.mOrientationHelper.i() - i2;
        if (i4 <= 0) {
            return 0;
        }
        int i5 = -scrollBy(-i4, recycler, state);
        int i6 = i2 + i5;
        if (!z2 || (i3 = this.mOrientationHelper.i() - i6) <= 0) {
            return i5;
        }
        this.mOrientationHelper.r(i3);
        return i3 + i5;
    }

    private int fixLayoutStartGap(int i2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int m2;
        int m3 = i2 - this.mOrientationHelper.m();
        if (m3 <= 0) {
            return 0;
        }
        int i3 = -scrollBy(m3, recycler, state);
        int i4 = i2 + i3;
        if (!z2 || (m2 = i4 - this.mOrientationHelper.m()) <= 0) {
            return i3;
        }
        this.mOrientationHelper.r(-m2);
        return i3 - m2;
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler recycler, RecyclerView.State state, int i2, int i3) {
        boolean z2;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        if (state.g() && getChildCount() != 0 && !state.e() && supportsPredictiveItemAnimations()) {
            List<RecyclerView.ViewHolder> k2 = recycler.k();
            int size = k2.size();
            int position = getPosition(getChildAt(0));
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                RecyclerView.ViewHolder viewHolder = k2.get(i6);
                if (!viewHolder.isRemoved()) {
                    char c2 = 1;
                    if (viewHolder.getLayoutPosition() < position) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 != this.mShouldReverseLayout) {
                        c2 = 65535;
                    }
                    if (c2 == 65535) {
                        i4 += this.mOrientationHelper.e(viewHolder.itemView);
                    } else {
                        i5 += this.mOrientationHelper.e(viewHolder.itemView);
                    }
                }
            }
            this.mLayoutState.f11202l = k2;
            if (i4 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i2);
                LayoutState layoutState = this.mLayoutState;
                layoutState.f11198h = i4;
                layoutState.f11193c = 0;
                layoutState.a();
                fill(recycler2, this.mLayoutState, state2, false);
            }
            if (i5 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i3);
                LayoutState layoutState2 = this.mLayoutState;
                layoutState2.f11198h = i5;
                layoutState2.f11193c = 0;
                layoutState2.a();
                fill(recycler2, this.mLayoutState, state2, false);
            }
            this.mLayoutState.f11202l = null;
        }
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.g(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.f11191a && !layoutState.f11203m) {
            int i2 = layoutState.f11197g;
            int i3 = layoutState.f11199i;
            if (layoutState.f11196f == -1) {
                recycleViewsFromEnd(recycler, i2, i3);
            } else {
                recycleViewsFromStart(recycler, i2, i3);
            }
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i2, int i3) {
        if (i2 != i3) {
            if (i3 > i2) {
                for (int i4 = i3 - 1; i4 >= i2; i4--) {
                    removeAndRecycleViewAt(i4, recycler);
                }
                return;
            }
            while (i2 > i3) {
                removeAndRecycleViewAt(i2, recycler);
                i2--;
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler recycler, int i2, int i3) {
        int childCount = getChildCount();
        if (i2 >= 0) {
            int h2 = (this.mOrientationHelper.h() - i2) + i3;
            if (this.mShouldReverseLayout) {
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    if (this.mOrientationHelper.g(childAt) < h2 || this.mOrientationHelper.q(childAt) < h2) {
                        recycleChildren(recycler, 0, i4);
                        return;
                    }
                }
                return;
            }
            int i5 = childCount - 1;
            for (int i6 = i5; i6 >= 0; i6--) {
                View childAt2 = getChildAt(i6);
                if (this.mOrientationHelper.g(childAt2) < h2 || this.mOrientationHelper.q(childAt2) < h2) {
                    recycleChildren(recycler, i5, i6);
                    return;
                }
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.Recycler recycler, int i2, int i3) {
        if (i2 >= 0) {
            int i4 = i2 - i3;
            int childCount = getChildCount();
            if (this.mShouldReverseLayout) {
                int i5 = childCount - 1;
                for (int i6 = i5; i6 >= 0; i6--) {
                    View childAt = getChildAt(i6);
                    if (this.mOrientationHelper.d(childAt) > i4 || this.mOrientationHelper.p(childAt) > i4) {
                        recycleChildren(recycler, i5, i6);
                        return;
                    }
                }
                return;
            }
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt2 = getChildAt(i7);
                if (this.mOrientationHelper.d(childAt2) > i4 || this.mOrientationHelper.p(childAt2) > i4) {
                    recycleChildren(recycler, 0, i7);
                    return;
                }
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        View findReferenceChild;
        boolean z2;
        boolean z3 = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild == null || !anchorInfo.d(focusedChild, state)) {
            boolean z4 = this.mLastStackFromEnd;
            boolean z5 = this.mStackFromEnd;
            if (z4 != z5 || (findReferenceChild = findReferenceChild(recycler, state, anchorInfo.f11185d, z5)) == null) {
                return false;
            }
            anchorInfo.b(findReferenceChild, getPosition(findReferenceChild));
            if (!state.e() && supportsPredictiveItemAnimations()) {
                int g2 = this.mOrientationHelper.g(findReferenceChild);
                int d2 = this.mOrientationHelper.d(findReferenceChild);
                int m2 = this.mOrientationHelper.m();
                int i2 = this.mOrientationHelper.i();
                if (d2 > m2 || g2 >= m2) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (g2 >= i2 && d2 > i2) {
                    z3 = true;
                }
                if (z2 || z3) {
                    if (anchorInfo.f11185d) {
                        m2 = i2;
                    }
                    anchorInfo.f11184c = m2;
                }
            }
            return true;
        }
        anchorInfo.c(focusedChild, getPosition(focusedChild));
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i2;
        boolean z2;
        int i3;
        boolean z3 = false;
        if (!state.e() && (i2 = this.mPendingScrollPosition) != -1) {
            if (i2 < 0 || i2 >= state.b()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                anchorInfo.f11183b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.b()) {
                    boolean z4 = this.mPendingSavedState.f11206d;
                    anchorInfo.f11185d = z4;
                    if (z4) {
                        anchorInfo.f11184c = this.mOrientationHelper.i() - this.mPendingSavedState.f11205c;
                    } else {
                        anchorInfo.f11184c = this.mOrientationHelper.m() + this.mPendingSavedState.f11205c;
                    }
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition == null) {
                        if (getChildCount() > 0) {
                            if (this.mPendingScrollPosition < getPosition(getChildAt(0))) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2 == this.mShouldReverseLayout) {
                                z3 = true;
                            }
                            anchorInfo.f11185d = z3;
                        }
                        anchorInfo.a();
                    } else if (this.mOrientationHelper.e(findViewByPosition) > this.mOrientationHelper.n()) {
                        anchorInfo.a();
                        return true;
                    } else if (this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.m() < 0) {
                        anchorInfo.f11184c = this.mOrientationHelper.m();
                        anchorInfo.f11185d = false;
                        return true;
                    } else if (this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition) < 0) {
                        anchorInfo.f11184c = this.mOrientationHelper.i();
                        anchorInfo.f11185d = true;
                        return true;
                    } else {
                        if (anchorInfo.f11185d) {
                            i3 = this.mOrientationHelper.d(findViewByPosition) + this.mOrientationHelper.o();
                        } else {
                            i3 = this.mOrientationHelper.g(findViewByPosition);
                        }
                        anchorInfo.f11184c = i3;
                    }
                    return true;
                } else {
                    boolean z5 = this.mShouldReverseLayout;
                    anchorInfo.f11185d = z5;
                    if (z5) {
                        anchorInfo.f11184c = this.mOrientationHelper.i() - this.mPendingScrollPositionOffset;
                    } else {
                        anchorInfo.f11184c = this.mOrientationHelper.m() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        int i2;
        if (!updateAnchorFromPendingData(state, anchorInfo) && !updateAnchorFromChildren(recycler, state, anchorInfo)) {
            anchorInfo.a();
            if (this.mStackFromEnd) {
                i2 = state.b() - 1;
            } else {
                i2 = 0;
            }
            anchorInfo.f11183b = i2;
        }
    }

    private void updateLayoutState(int i2, int i3, boolean z2, RecyclerView.State state) {
        int i4;
        int i5;
        this.mLayoutState.f11203m = resolveIsInfinite();
        this.mLayoutState.f11196f = i2;
        int[] iArr = this.mReusableIntPair;
        boolean z3 = false;
        iArr[0] = 0;
        int i6 = 1;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        if (i2 == 1) {
            z3 = true;
        }
        LayoutState layoutState = this.mLayoutState;
        if (z3) {
            i4 = max2;
        } else {
            i4 = max;
        }
        layoutState.f11198h = i4;
        if (!z3) {
            max = max2;
        }
        layoutState.f11199i = max;
        if (z3) {
            layoutState.f11198h = i4 + this.mOrientationHelper.j();
            View childClosestToEnd = getChildClosestToEnd();
            LayoutState layoutState2 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i6 = -1;
            }
            layoutState2.f11195e = i6;
            int position = getPosition(childClosestToEnd);
            LayoutState layoutState3 = this.mLayoutState;
            layoutState2.f11194d = position + layoutState3.f11195e;
            layoutState3.f11192b = this.mOrientationHelper.d(childClosestToEnd);
            i5 = this.mOrientationHelper.d(childClosestToEnd) - this.mOrientationHelper.i();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.f11198h += this.mOrientationHelper.m();
            LayoutState layoutState4 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i6 = -1;
            }
            layoutState4.f11195e = i6;
            int position2 = getPosition(childClosestToStart);
            LayoutState layoutState5 = this.mLayoutState;
            layoutState4.f11194d = position2 + layoutState5.f11195e;
            layoutState5.f11192b = this.mOrientationHelper.g(childClosestToStart);
            i5 = (-this.mOrientationHelper.g(childClosestToStart)) + this.mOrientationHelper.m();
        }
        LayoutState layoutState6 = this.mLayoutState;
        layoutState6.f11193c = i3;
        if (z2) {
            layoutState6.f11193c = i3 - i5;
        }
        layoutState6.f11197g = i5;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo) {
        updateLayoutStateToFillEnd(anchorInfo.f11183b, anchorInfo.f11184c);
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo) {
        updateLayoutStateToFillStart(anchorInfo.f11183b, anchorInfo.f11184c);
    }

    @SuppressLint({"UnknownNullness"})
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* access modifiers changed from: protected */
    public void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
        int i2;
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.mLayoutState.f11196f == -1) {
            i2 = 0;
        } else {
            i2 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i2;
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @SuppressLint({"UnknownNullness"})
    public void collectAdjacentPrefetchPositions(int i2, int i3, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i4;
        if (this.mOrientation != 0) {
            i2 = i3;
        }
        if (getChildCount() != 0 && i2 != 0) {
            ensureLayoutState();
            if (i2 > 0) {
                i4 = 1;
            } else {
                i4 = -1;
            }
            updateLayoutState(i4, Math.abs(i2), true, state);
            collectPrefetchPositionsForLayoutState(state, this.mLayoutState, layoutPrefetchRegistry);
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void collectInitialPrefetchPositions(int i2, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z2;
        int i3;
        SavedState savedState = this.mPendingSavedState;
        int i4 = -1;
        if (savedState == null || !savedState.b()) {
            resolveShouldLayoutReverse();
            z2 = this.mShouldReverseLayout;
            i3 = this.mPendingScrollPosition;
            if (i3 == -1) {
                if (z2) {
                    i3 = i2 - 1;
                } else {
                    i3 = 0;
                }
            }
        } else {
            SavedState savedState2 = this.mPendingSavedState;
            z2 = savedState2.f11206d;
            i3 = savedState2.f11204b;
        }
        if (!z2) {
            i4 = 1;
        }
        for (int i5 = 0; i5 < this.mInitialPrefetchItemCount && i3 >= 0 && i3 < i2; i5++) {
            layoutPrefetchRegistry.a(i3, 0);
            i3 += i4;
        }
    }

    /* access modifiers changed from: package-private */
    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i2 = layoutState.f11194d;
        if (i2 >= 0 && i2 < state.b()) {
            layoutPrefetchRegistry.a(i2, Math.max(0, layoutState.f11197g));
        }
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @SuppressLint({"UnknownNullness"})
    public PointF computeScrollVectorForPosition(int i2) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z2 = false;
        int i3 = 1;
        if (i2 < getPosition(getChildAt(0))) {
            z2 = true;
        }
        if (z2 != this.mShouldReverseLayout) {
            i3 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i3, 0.0f);
        }
        return new PointF(0.0f, (float) i3);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    /* access modifiers changed from: package-private */
    public int convertFocusDirectionToLayoutDirection(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 17) {
                    if (i2 != 33) {
                        if (i2 != 66) {
                            if (i2 == 130 && this.mOrientation == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        } else if (this.mOrientation == 0) {
                            return 1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else if (this.mOrientation == 1) {
                        return -1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.mOrientation == 0) {
                    return -1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.mOrientation != 1 && isLayoutRTL()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.mOrientation != 1 && isLayoutRTL()) {
            return 1;
        } else {
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    public LayoutState createLayoutState() {
        return new LayoutState();
    }

    /* access modifiers changed from: package-private */
    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    /* access modifiers changed from: package-private */
    public int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z2) {
        int i2 = layoutState.f11193c;
        int i3 = layoutState.f11197g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                layoutState.f11197g = i3 + i2;
            }
            recycleByLayoutState(recycler, layoutState);
        }
        int i4 = layoutState.f11193c + layoutState.f11198h;
        LayoutChunkResult layoutChunkResult = this.mLayoutChunkResult;
        while (true) {
            if ((!layoutState.f11203m && i4 <= 0) || !layoutState.c(state)) {
                break;
            }
            layoutChunkResult.a();
            layoutChunk(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.f11188b) {
                layoutState.f11192b += layoutChunkResult.f11187a * layoutState.f11196f;
                if (!layoutChunkResult.f11189c || layoutState.f11202l != null || !state.e()) {
                    int i5 = layoutState.f11193c;
                    int i6 = layoutChunkResult.f11187a;
                    layoutState.f11193c = i5 - i6;
                    i4 -= i6;
                }
                int i7 = layoutState.f11197g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + layoutChunkResult.f11187a;
                    layoutState.f11197g = i8;
                    int i9 = layoutState.f11193c;
                    if (i9 < 0) {
                        layoutState.f11197g = i8 + i9;
                    }
                    recycleByLayoutState(recycler, layoutState);
                }
                if (z2 && layoutChunkResult.f11190d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - layoutState.f11193c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToEnd(boolean z2, boolean z3) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z2, z3);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z2, z3);
    }

    /* access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToStart(boolean z2, boolean z3) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z2, z3);
        }
        return findOneVisibleChild(0, getChildCount(), z2, z3);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    /* access modifiers changed from: package-private */
    public View findOnePartiallyOrCompletelyInvisibleChild(int i2, int i3) {
        char c2;
        int i4;
        int i5;
        ensureLayoutState();
        if (i3 > i2) {
            c2 = 1;
        } else if (i3 < i2) {
            c2 = 65535;
        } else {
            c2 = 0;
        }
        if (c2 == 0) {
            return getChildAt(i2);
        }
        if (this.mOrientationHelper.g(getChildAt(i2)) < this.mOrientationHelper.m()) {
            i5 = 16644;
            i4 = 16388;
        } else {
            i5 = 4161;
            i4 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i2, i3, i5, i4);
        }
        return this.mVerticalBoundCheck.a(i2, i3, i5, i4);
    }

    /* access modifiers changed from: package-private */
    public View findOneVisibleChild(int i2, int i3, boolean z2, boolean z3) {
        int i4;
        ensureLayoutState();
        int i5 = Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE;
        if (z2) {
            i4 = 24579;
        } else {
            i4 = Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE;
        }
        if (!z3) {
            i5 = 0;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i2, i3, i4, i5);
        }
        return this.mVerticalBoundCheck.a(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2, boolean z3) {
        int i2;
        int i3;
        int i4;
        boolean z4;
        boolean z5;
        ensureLayoutState();
        int childCount = getChildCount();
        if (z3) {
            i4 = getChildCount() - 1;
            i3 = -1;
            i2 = -1;
        } else {
            i3 = childCount;
            i4 = 0;
            i2 = 1;
        }
        int b2 = state.b();
        int m2 = this.mOrientationHelper.m();
        int i5 = this.mOrientationHelper.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i4 != i3) {
            View childAt = getChildAt(i4);
            int position = getPosition(childAt);
            int g2 = this.mOrientationHelper.g(childAt);
            int d2 = this.mOrientationHelper.d(childAt);
            if (position >= 0 && position < b2) {
                if (!((RecyclerView.LayoutParams) childAt.getLayoutParams()).c()) {
                    if (d2 > m2 || g2 >= m2) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    if (g2 < i5 || d2 <= i5) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (!z4 && !z5) {
                        return childAt;
                    }
                    if (z2) {
                        if (!z5) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                    } else if (!z4) {
                        if (view != null) {
                        }
                        view = childAt;
                    }
                    view2 = childAt;
                } else if (view3 == null) {
                    view3 = childAt;
                }
            }
            i4 += i2;
        }
        if (view != null) {
            return view;
        }
        if (view2 != null) {
            return view2;
        }
        return view3;
    }

    @SuppressLint({"UnknownNullness"})
    public View findViewByPosition(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i2 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i2) {
                return childAt;
            }
        }
        return super.findViewByPosition(i2);
    }

    @SuppressLint({"UnknownNullness"})
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.State state) {
        if (state.d()) {
            return this.mOrientationHelper.n();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    /* access modifiers changed from: package-private */
    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z2;
        boolean z3;
        View d2 = layoutState.d(recycler);
        if (d2 == null) {
            layoutChunkResult.f11188b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) d2.getLayoutParams();
        if (layoutState.f11202l == null) {
            boolean z4 = this.mShouldReverseLayout;
            if (layoutState.f11196f == -1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z4 == z3) {
                addView(d2);
            } else {
                addView(d2, 0);
            }
        } else {
            boolean z5 = this.mShouldReverseLayout;
            if (layoutState.f11196f == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z5 == z2) {
                addDisappearingView(d2);
            } else {
                addDisappearingView(d2, 0);
            }
        }
        measureChildWithMargins(d2, 0, 0);
        layoutChunkResult.f11187a = this.mOrientationHelper.e(d2);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                i6 = getWidth() - getPaddingRight();
                i5 = i6 - this.mOrientationHelper.f(d2);
            } else {
                i5 = getPaddingLeft();
                i6 = this.mOrientationHelper.f(d2) + i5;
            }
            if (layoutState.f11196f == -1) {
                int i7 = layoutState.f11192b;
                i2 = i7;
                i3 = i6;
                i4 = i7 - layoutChunkResult.f11187a;
            } else {
                int i8 = layoutState.f11192b;
                i4 = i8;
                i3 = i6;
                i2 = layoutChunkResult.f11187a + i8;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f2 = this.mOrientationHelper.f(d2) + paddingTop;
            if (layoutState.f11196f == -1) {
                int i9 = layoutState.f11192b;
                i3 = i9;
                i4 = paddingTop;
                i2 = f2;
                i5 = i9 - layoutChunkResult.f11187a;
            } else {
                int i10 = layoutState.f11192b;
                i4 = paddingTop;
                i3 = layoutChunkResult.f11187a + i10;
                i2 = f2;
                i5 = i10;
            }
        }
        layoutDecoratedWithMargins(d2, i5, i4, i3, i2);
        if (layoutParams.c() || layoutParams.b()) {
            layoutChunkResult.f11189c = true;
        }
        layoutChunkResult.f11190d = d2.hasFocusable();
    }

    /* access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int i2) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.c();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public View onFocusSearchFailed(View view, int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirection;
        View view2;
        View view3;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (((float) this.mOrientationHelper.n()) * MAX_SCROLL_FACTOR), false, state);
        LayoutState layoutState = this.mLayoutState;
        layoutState.f11197g = Integer.MIN_VALUE;
        layoutState.f11191a = false;
        fill(recycler, layoutState, state, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            view3 = getChildClosestToStart();
        } else {
            view3 = getChildClosestToEnd();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    @SuppressLint({"UnknownNullness"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        View findViewByPosition;
        int i9;
        int i10;
        int i11 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && state.b() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.b()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f11204b;
        }
        ensureLayoutState();
        this.mLayoutState.f11191a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (!anchorInfo.f11186e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            anchorInfo.e();
            AnchorInfo anchorInfo2 = this.mAnchorInfo;
            anchorInfo2.f11185d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(recycler, state, anchorInfo2);
            this.mAnchorInfo.f11186e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.g(focusedChild) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(focusedChild) <= this.mOrientationHelper.m())) {
            this.mAnchorInfo.c(focusedChild, getPosition(focusedChild));
        }
        LayoutState layoutState = this.mLayoutState;
        if (layoutState.f11201k >= 0) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        layoutState.f11196f = i2;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.m();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.j();
        if (!(!state.e() || (i8 = this.mPendingScrollPosition) == -1 || this.mPendingScrollPositionOffset == Integer.MIN_VALUE || (findViewByPosition = findViewByPosition(i8)) == null)) {
            if (this.mShouldReverseLayout) {
                i9 = this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition);
                i10 = this.mPendingScrollPositionOffset;
            } else {
                i10 = this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.m();
                i9 = this.mPendingScrollPositionOffset;
            }
            int i12 = i9 - i10;
            if (i12 > 0) {
                max += i12;
            } else {
                max2 -= i12;
            }
        }
        AnchorInfo anchorInfo3 = this.mAnchorInfo;
        if (!anchorInfo3.f11185d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i11 = 1;
        }
        onAnchorReady(recycler, state, anchorInfo3, i11);
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.f11203m = resolveIsInfinite();
        this.mLayoutState.f11200j = state.e();
        this.mLayoutState.f11199i = 0;
        AnchorInfo anchorInfo4 = this.mAnchorInfo;
        if (anchorInfo4.f11185d) {
            updateLayoutStateToFillStart(anchorInfo4);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.f11198h = max;
            fill(recycler, layoutState2, state, false);
            LayoutState layoutState3 = this.mLayoutState;
            i4 = layoutState3.f11192b;
            int i13 = layoutState3.f11194d;
            int i14 = layoutState3.f11193c;
            if (i14 > 0) {
                max2 += i14;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            LayoutState layoutState4 = this.mLayoutState;
            layoutState4.f11198h = max2;
            layoutState4.f11194d += layoutState4.f11195e;
            fill(recycler, layoutState4, state, false);
            LayoutState layoutState5 = this.mLayoutState;
            i3 = layoutState5.f11192b;
            int i15 = layoutState5.f11193c;
            if (i15 > 0) {
                updateLayoutStateToFillStart(i13, i4);
                LayoutState layoutState6 = this.mLayoutState;
                layoutState6.f11198h = i15;
                fill(recycler, layoutState6, state, false);
                i4 = this.mLayoutState.f11192b;
            }
        } else {
            updateLayoutStateToFillEnd(anchorInfo4);
            LayoutState layoutState7 = this.mLayoutState;
            layoutState7.f11198h = max2;
            fill(recycler, layoutState7, state, false);
            LayoutState layoutState8 = this.mLayoutState;
            i3 = layoutState8.f11192b;
            int i16 = layoutState8.f11194d;
            int i17 = layoutState8.f11193c;
            if (i17 > 0) {
                max += i17;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            LayoutState layoutState9 = this.mLayoutState;
            layoutState9.f11198h = max;
            layoutState9.f11194d += layoutState9.f11195e;
            fill(recycler, layoutState9, state, false);
            LayoutState layoutState10 = this.mLayoutState;
            i4 = layoutState10.f11192b;
            int i18 = layoutState10.f11193c;
            if (i18 > 0) {
                updateLayoutStateToFillEnd(i16, i3);
                LayoutState layoutState11 = this.mLayoutState;
                layoutState11.f11198h = i18;
                fill(recycler, layoutState11, state, false);
                i3 = this.mLayoutState.f11192b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap = fixLayoutEndGap(i3, recycler, state, true);
                i6 = i4 + fixLayoutEndGap;
                i5 = i3 + fixLayoutEndGap;
                i7 = fixLayoutStartGap(i6, recycler, state, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i4, recycler, state, true);
                i6 = i4 + fixLayoutStartGap;
                i5 = i3 + fixLayoutStartGap;
                i7 = fixLayoutEndGap(i5, recycler, state, false);
            }
            i4 = i6 + i7;
            i3 = i5 + i7;
        }
        layoutForPredictiveAnimations(recycler, state, i4, i3);
        if (!state.e()) {
            this.mOrientationHelper.s();
        } else {
            this.mAnchorInfo.e();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @SuppressLint({"UnknownNullness"})
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.e();
    }

    @SuppressLint({"UnknownNullness"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.c();
            }
            requestLayout();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z2 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.f11206d = z2;
            if (z2) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState.f11205c = this.mOrientationHelper.i() - this.mOrientationHelper.d(childClosestToEnd);
                savedState.f11204b = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState.f11204b = getPosition(childClosestToStart);
                savedState.f11205c = this.mOrientationHelper.g(childClosestToStart) - this.mOrientationHelper.m();
            }
        } else {
            savedState.c();
        }
        return savedState;
    }

    public void prepareForDrop(View view, View view2, int i2, int i3) {
        char c2;
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        if (position < position2) {
            c2 = 1;
        } else {
            c2 = 65535;
        }
        if (this.mShouldReverseLayout) {
            if (c2 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - (this.mOrientationHelper.g(view2) + this.mOrientationHelper.e(view)));
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - this.mOrientationHelper.d(view2));
            }
        } else if (c2 == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.g(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.d(view2) - this.mOrientationHelper.e(view));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean resolveIsInfinite() {
        if (this.mOrientationHelper.k() == 0 && this.mOrientationHelper.h() == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int scrollBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i3;
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f11191a = true;
        if (i2 > 0) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        int abs = Math.abs(i2);
        updateLayoutState(i3, abs, true, state);
        LayoutState layoutState = this.mLayoutState;
        int fill = layoutState.f11197g + fill(recycler, layoutState, state, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i2 = i3 * fill;
        }
        this.mOrientationHelper.r(-i2);
        this.mLayoutState.f11201k = i2;
        return i2;
    }

    @SuppressLint({"UnknownNullness"})
    public int scrollHorizontallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i2, recycler, state);
    }

    public void scrollToPosition(int i2) {
        this.mPendingScrollPosition = i2;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.c();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i2, int i3) {
        this.mPendingScrollPosition = i2;
        this.mPendingScrollPositionOffset = i3;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.c();
        }
        requestLayout();
    }

    @SuppressLint({"UnknownNullness"})
    public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i2, recycler, state);
    }

    public void setInitialPrefetchItemCount(int i2) {
        this.mInitialPrefetchItemCount = i2;
    }

    public void setOrientation(int i2) {
        if (i2 == 0 || i2 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i2 != this.mOrientation || this.mOrientationHelper == null) {
                OrientationHelper b2 = OrientationHelper.b(this, i2);
                this.mOrientationHelper = b2;
                this.mAnchorInfo.f11182a = b2;
                this.mOrientation = i2;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i2);
    }

    public void setRecycleChildrenOnDetach(boolean z2) {
        this.mRecycleChildrenOnDetach = z2;
    }

    public void setReverseLayout(boolean z2) {
        assertNotInLayoutOrScroll((String) null);
        if (z2 != this.mReverseLayout) {
            this.mReverseLayout = z2;
            requestLayout();
        }
    }

    public void setSmoothScrollbarEnabled(boolean z2) {
        this.mSmoothScrollbarEnabled = z2;
    }

    public void setStackFromEnd(boolean z2) {
        assertNotInLayoutOrScroll((String) null);
        if (this.mStackFromEnd != z2) {
            this.mStackFromEnd = z2;
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldMeasureTwice() {
        if (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) {
            return false;
        }
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i2);
        startSmoothScroll(linearSmoothScroller);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    /* access modifiers changed from: package-private */
    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        boolean z2 = true;
        if (getChildCount() >= 1) {
            int position = getPosition(getChildAt(0));
            int g2 = this.mOrientationHelper.g(getChildAt(0));
            if (this.mShouldReverseLayout) {
                int i2 = 1;
                while (i2 < getChildCount()) {
                    View childAt = getChildAt(i2);
                    int position2 = getPosition(childAt);
                    int g3 = this.mOrientationHelper.g(childAt);
                    if (position2 < position) {
                        logChildren();
                        StringBuilder sb = new StringBuilder();
                        sb.append("detected invalid position. loc invalid? ");
                        if (g3 >= g2) {
                            z2 = false;
                        }
                        sb.append(z2);
                        throw new RuntimeException(sb.toString());
                    } else if (g3 <= g2) {
                        i2++;
                    } else {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    }
                }
                return;
            }
            int i3 = 1;
            while (i3 < getChildCount()) {
                View childAt2 = getChildAt(i3);
                int position3 = getPosition(childAt2);
                int g4 = this.mOrientationHelper.g(childAt2);
                if (position3 < position) {
                    logChildren();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("detected invalid position. loc invalid? ");
                    if (g4 >= g2) {
                        z2 = false;
                    }
                    sb2.append(z2);
                    throw new RuntimeException(sb2.toString());
                } else if (g4 >= g2) {
                    i3++;
                } else {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context, int i2, boolean z2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i2);
        setReverseLayout(z2);
    }

    private void updateLayoutStateToFillEnd(int i2, int i3) {
        this.mLayoutState.f11193c = this.mOrientationHelper.i() - i3;
        LayoutState layoutState = this.mLayoutState;
        layoutState.f11195e = this.mShouldReverseLayout ? -1 : 1;
        layoutState.f11194d = i2;
        layoutState.f11196f = 1;
        layoutState.f11192b = i3;
        layoutState.f11197g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i2, int i3) {
        this.mLayoutState.f11193c = i3 - this.mOrientationHelper.m();
        LayoutState layoutState = this.mLayoutState;
        layoutState.f11194d = i2;
        layoutState.f11195e = this.mShouldReverseLayout ? 1 : -1;
        layoutState.f11196f = -1;
        layoutState.f11192b = i3;
        layoutState.f11197g = Integer.MIN_VALUE;
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i2, i3);
        setOrientation(properties.f11240a);
        setReverseLayout(properties.f11242c);
        setStackFromEnd(properties.f11243d);
    }
}
