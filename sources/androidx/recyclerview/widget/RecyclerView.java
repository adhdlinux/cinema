package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R$attr;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.protobuf.CodedOutputStream;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RecyclerView extends ViewGroup implements NestedScrollingChild2 {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK = true;
    static final boolean DEBUG = false;
    private static final float DECELERATION_RATE = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = true;
    private static final float SCROLL_FRICTION = 0.015f;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final StretchEdgeEffectFactory sDefaultEdgeEffectFactory = new StretchEdgeEffectFactory();
    static final Interpolator sQuinticInterpolator = new Interpolator() {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private EdgeEffectFactory mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private OnItemTouchListener mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    private final float mPhysicalCoef;
    boolean mPostedAnimatorRunner;
    GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    final List<RecyclerListener> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;

    /* renamed from: androidx.recyclerview.widget.RecyclerView$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11222a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy[] r0 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11222a = r0
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy r1 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f11222a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy r1 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.AnonymousClass7.<clinit>():void");
        }
    }

    public static abstract class Adapter<VH extends ViewHolder> {
        private boolean mHasStableIds = false;
        private final AdapterDataObservable mObservable = new AdapterDataObservable();
        private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public final void bindViewHolder(VH vh, int i2) {
            boolean z2;
            if (vh.mBindingAdapter == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                vh.mPosition = i2;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(i2);
                }
                vh.setFlags(1, 519);
                TraceCompat.a(RecyclerView.TRACE_BIND_VIEW_TAG);
            }
            vh.mBindingAdapter = this;
            onBindViewHolder(vh, i2, vh.getUnmodifiedPayloads());
            if (z2) {
                vh.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).f11246c = true;
                }
                TraceCompat.b();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean canRestoreState() {
            int i2 = AnonymousClass7.f11222a[this.mStateRestorationPolicy.ordinal()];
            if (i2 == 1) {
                return false;
            }
            if (i2 == 2 && getItemCount() <= 0) {
                return false;
            }
            return true;
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i2) {
            try {
                TraceCompat.a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i2);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i2;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                TraceCompat.b();
            }
        }

        public int findRelativeAdapterPositionIn(Adapter<? extends ViewHolder> adapter, ViewHolder viewHolder, int i2) {
            if (adapter == this) {
                return i2;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i2) {
            return -1;
        }

        public int getItemViewType(int i2) {
            return 0;
        }

        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i2) {
            this.mObservable.d(i2, 1);
        }

        public final void notifyItemInserted(int i2) {
            this.mObservable.f(i2, 1);
        }

        public final void notifyItemMoved(int i2, int i3) {
            this.mObservable.c(i2, i3);
        }

        public final void notifyItemRangeChanged(int i2, int i3) {
            this.mObservable.d(i2, i3);
        }

        public final void notifyItemRangeInserted(int i2, int i3) {
            this.mObservable.f(i2, i3);
        }

        public final void notifyItemRangeRemoved(int i2, int i3) {
            this.mObservable.g(i2, i3);
        }

        public final void notifyItemRemoved(int i2) {
            this.mObservable.g(i2, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i2);

        public void onBindViewHolder(VH vh, int i2, List<Object> list) {
            onBindViewHolder(vh, i2);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i2);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z2) {
            if (!hasObservers()) {
                this.mHasStableIds = z2;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(StateRestorationPolicy stateRestorationPolicy) {
            this.mStateRestorationPolicy = stateRestorationPolicy;
            this.mObservable.h();
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.unregisterObserver(adapterDataObserver);
        }

        public final void notifyItemChanged(int i2, Object obj) {
            this.mObservable.e(i2, 1, obj);
        }

        public final void notifyItemRangeChanged(int i2, int i3, Object obj) {
            this.mObservable.e(i2, i3, obj);
        }
    }

    static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public boolean a() {
            return !this.mObservers.isEmpty();
        }

        public void b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onChanged();
            }
        }

        public void c(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeMoved(i2, i3, 1);
            }
        }

        public void d(int i2, int i3) {
            e(i2, i3, (Object) null);
        }

        public void e(int i2, int i3, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeChanged(i2, i3, obj);
            }
        }

        public void f(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeInserted(i2, i3);
            }
        }

        public void g(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeRemoved(i2, i3);
            }
        }

        public void h() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onStateRestorationPolicyChanged();
            }
        }
    }

    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i2, int i3) {
        }

        public void onItemRangeChanged(int i2, int i3, Object obj) {
            onItemRangeChanged(i2, i3);
        }

        public void onItemRangeInserted(int i2, int i3) {
        }

        public void onItemRangeMoved(int i2, int i3, int i4) {
        }

        public void onItemRangeRemoved(int i2, int i3) {
        }

        public void onStateRestorationPolicyChanged() {
        }
    }

    public interface ChildDrawingOrderCallback {
    }

    public static class EdgeEffectFactory {
        /* access modifiers changed from: protected */
        public EdgeEffect a(RecyclerView recyclerView, int i2) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class ItemAnimator {

        /* renamed from: a  reason: collision with root package name */
        private ItemAnimatorListener f11227a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<ItemAnimatorFinishedListener> f11228b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private long f11229c = 120;

        /* renamed from: d  reason: collision with root package name */
        private long f11230d = 120;

        /* renamed from: e  reason: collision with root package name */
        private long f11231e = 250;

        /* renamed from: f  reason: collision with root package name */
        private long f11232f = 250;

        public interface ItemAnimatorFinishedListener {
            void a();
        }

        interface ItemAnimatorListener {
            void a(ViewHolder viewHolder);
        }

        public static class ItemHolderInfo {

            /* renamed from: a  reason: collision with root package name */
            public int f11233a;

            /* renamed from: b  reason: collision with root package name */
            public int f11234b;

            /* renamed from: c  reason: collision with root package name */
            public int f11235c;

            /* renamed from: d  reason: collision with root package name */
            public int f11236d;

            public ItemHolderInfo a(ViewHolder viewHolder) {
                return b(viewHolder, 0);
            }

            public ItemHolderInfo b(ViewHolder viewHolder, int i2) {
                View view = viewHolder.itemView;
                this.f11233a = view.getLeft();
                this.f11234b = view.getTop();
                this.f11235c = view.getRight();
                this.f11236d = view.getBottom();
                return this;
            }
        }

        static int e(ViewHolder viewHolder) {
            int i2 = viewHolder.mFlags & 14;
            if (viewHolder.isInvalid()) {
                return 4;
            }
            if ((i2 & 4) != 0) {
                return i2;
            }
            int oldPosition = viewHolder.getOldPosition();
            int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
            if (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) {
                return i2;
            }
            return i2 | 2048;
        }

        public abstract boolean a(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean b(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean c(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean d(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public boolean f(ViewHolder viewHolder) {
            return true;
        }

        public boolean g(ViewHolder viewHolder, List<Object> list) {
            return f(viewHolder);
        }

        public final void h(ViewHolder viewHolder) {
            r(viewHolder);
            ItemAnimatorListener itemAnimatorListener = this.f11227a;
            if (itemAnimatorListener != null) {
                itemAnimatorListener.a(viewHolder);
            }
        }

        public final void i() {
            int size = this.f11228b.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f11228b.get(i2).a();
            }
            this.f11228b.clear();
        }

        public abstract void j(ViewHolder viewHolder);

        public abstract void k();

        public long l() {
            return this.f11229c;
        }

        public long m() {
            return this.f11232f;
        }

        public long n() {
            return this.f11231e;
        }

        public long o() {
            return this.f11230d;
        }

        public abstract boolean p();

        public ItemHolderInfo q() {
            return new ItemHolderInfo();
        }

        public void r(ViewHolder viewHolder) {
        }

        public ItemHolderInfo s(State state, ViewHolder viewHolder) {
            return q().a(viewHolder);
        }

        public ItemHolderInfo t(State state, ViewHolder viewHolder, int i2, List<Object> list) {
            return q().a(viewHolder);
        }

        public abstract void u();

        /* access modifiers changed from: package-private */
        public void v(ItemAnimatorListener itemAnimatorListener) {
            this.f11227a = itemAnimatorListener;
        }
    }

    private class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        ItemAnimatorRestoreListener() {
        }

        public void a(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                viewHolder.mShadowedHolder = null;
            }
            viewHolder.mShadowingHolder = null;
            if (!viewHolder.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(viewHolder.itemView) && viewHolder.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
            }
        }
    }

    public static abstract class ItemDecoration {
        @Deprecated
        public void d(Rect rect, int i2, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void e(Rect rect, View view, RecyclerView recyclerView, State state) {
            d(rect, ((LayoutParams) view.getLayoutParams()).a(), recyclerView);
        }

        @Deprecated
        public void f(Canvas canvas, RecyclerView recyclerView) {
        }

        public void g(Canvas canvas, RecyclerView recyclerView, State state) {
            f(canvas, recyclerView);
        }

        @Deprecated
        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, State state) {
            h(canvas, recyclerView);
        }
    }

    public static abstract class LayoutManager {
        boolean mAutoMeasure = false;
        ChildHelper mChildHelper;
        private int mHeight;
        private int mHeightMode;
        ViewBoundsCheck mHorizontalBoundCheck;
        private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback;
        boolean mIsAttachedToWindow = false;
        private boolean mItemPrefetchEnabled = true;
        private boolean mMeasurementCacheEnabled = true;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations = false;
        SmoothScroller mSmoothScroller;
        ViewBoundsCheck mVerticalBoundCheck;
        private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        public interface LayoutPrefetchRegistry {
            void a(int i2, int i3);
        }

        public static class Properties {

            /* renamed from: a  reason: collision with root package name */
            public int f11240a;

            /* renamed from: b  reason: collision with root package name */
            public int f11241b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f11242c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f11243d;
        }

        public LayoutManager() {
            AnonymousClass1 r02 = new ViewBoundsCheck.Callback() {
                public int a(View view) {
                    return LayoutManager.this.getDecoratedLeft(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
                }

                public int b() {
                    return LayoutManager.this.getPaddingLeft();
                }

                public int c() {
                    return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
                }

                public int d(View view) {
                    return LayoutManager.this.getDecoratedRight(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
                }

                public View getChildAt(int i2) {
                    return LayoutManager.this.getChildAt(i2);
                }
            };
            this.mHorizontalBoundCheckCallback = r02;
            AnonymousClass2 r12 = new ViewBoundsCheck.Callback() {
                public int a(View view) {
                    return LayoutManager.this.getDecoratedTop(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
                }

                public int b() {
                    return LayoutManager.this.getPaddingTop();
                }

                public int c() {
                    return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
                }

                public int d(View view) {
                    return LayoutManager.this.getDecoratedBottom(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
                }

                public View getChildAt(int i2) {
                    return LayoutManager.this.getChildAt(i2);
                }
            };
            this.mVerticalBoundCheckCallback = r12;
            this.mHorizontalBoundCheck = new ViewBoundsCheck(r02);
            this.mVerticalBoundCheck = new ViewBoundsCheck(r12);
        }

        private void addViewInt(View view, int i2, boolean z2) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z2 || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.b(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.p(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.c(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int m2 = this.mChildHelper.m(view);
                if (i2 == -1) {
                    i2 = this.mChildHelper.g();
                }
                if (m2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                } else if (m2 != i2) {
                    this.mRecyclerView.mLayout.moveView(m2, i2);
                }
            } else {
                this.mChildHelper.a(view, i2, false);
                layoutParams.f11246c = true;
                SmoothScroller smoothScroller = this.mSmoothScroller;
                if (smoothScroller != null && smoothScroller.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.f11247d) {
                childViewHolderInt.itemView.invalidate();
                layoutParams.f11247d = false;
            }
        }

        public static int chooseSize(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == Integer.MIN_VALUE) {
                return Math.min(size, Math.max(i3, i4));
            }
            if (mode != 1073741824) {
                return Math.max(i3, i4);
            }
            return size;
        }

        private void detachViewInternal(int i2, View view) {
            this.mChildHelper.d(i2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
            if (r3 >= 0) goto L_0x0011;
         */
        @java.lang.Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto L_0x000f
                if (r3 < 0) goto L_0x000d
                goto L_0x0011
            L_0x000d:
                r3 = 0
                goto L_0x0021
            L_0x000f:
                if (r3 < 0) goto L_0x0014
            L_0x0011:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L_0x0021
            L_0x0014:
                r4 = -1
                if (r3 != r4) goto L_0x001b
                r2 = 1073741824(0x40000000, float:2.0)
            L_0x0019:
                r3 = r1
                goto L_0x0021
            L_0x001b:
                r4 = -2
                if (r3 != r4) goto L_0x000d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0019
            L_0x0021:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, boolean):int");
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i2 = left - paddingLeft;
            int min = Math.min(0, i2);
            int i3 = top - paddingTop;
            int min2 = Math.min(0, i3);
            int i4 = width2 - width;
            int max = Math.max(0, i4);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i2, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i4);
            }
            if (min2 == 0) {
                min2 = Math.min(i3, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public static Properties getProperties(Context context, AttributeSet attributeSet, int i2, int i3) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f10971a, i2, i3);
            properties.f11240a = obtainStyledAttributes.getInt(R$styleable.f10972b, 1);
            properties.f11241b = obtainStyledAttributes.getInt(R$styleable.f10982l, 1);
            properties.f11242c = obtainStyledAttributes.getBoolean(R$styleable.f10981k, false);
            properties.f11243d = obtainStyledAttributes.getBoolean(R$styleable.f10983m, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i2, int i3) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            if (rect.left - i2 >= width || rect.right - i2 <= paddingLeft || rect.top - i3 >= height || rect.bottom - i3 <= paddingTop) {
                return false;
            }
            return true;
        }

        private static boolean isMeasurementUpToDate(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    return true;
                }
                if (mode == 1073741824 && size == i2) {
                    return true;
                }
                return false;
            } else if (size >= i2) {
                return true;
            } else {
                return false;
            }
        }

        private void scrapOrRecycleView(Recycler recycler, int i2, View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.shouldIgnore()) {
                if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.mRecyclerView.mAdapter.hasStableIds()) {
                    detachViewAt(i2);
                    recycler.I(view);
                    this.mRecyclerView.mViewInfoStore.k(childViewHolderInt);
                    return;
                }
                removeViewAt(i2);
                recycler.H(childViewHolderInt);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(View view, int i2, LayoutParams layoutParams) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.b(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.p(childViewHolderInt);
            }
            this.mChildHelper.c(view, i2, layoutParams, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        @SuppressLint({"UnknownNullness"})
        public void collectAdjacentPrefetchPositions(int i2, int i3, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        @SuppressLint({"UnknownNullness"})
        public void collectInitialPrefetchPositions(int i2, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public int computeHorizontalScrollExtent(State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(State state) {
            return 0;
        }

        public int computeVerticalScrollRange(State state) {
            return 0;
        }

        public void detachAndScrapAttachedViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, Recycler recycler) {
            scrapOrRecycleView(recycler, this.mChildHelper.m(view), view);
        }

        public void detachAndScrapViewAt(int i2, Recycler recycler) {
            scrapOrRecycleView(recycler, i2, getChildAt(i2));
        }

        public void detachView(View view) {
            int m2 = this.mChildHelper.m(view);
            if (m2 >= 0) {
                detachViewInternal(m2, view);
            }
        }

        public void detachViewAt(int i2) {
            detachViewInternal(i2, getChildAt(i2));
        }

        /* access modifiers changed from: package-private */
        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        /* access modifiers changed from: package-private */
        public void dispatchDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        @SuppressLint({"UnknownNullness"})
        public void endAnimation(View view) {
            ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.j(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.n(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i2) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i2 && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.e() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        @SuppressLint({"UnknownNullness"})
        public abstract LayoutParams generateDefaultLayoutParams();

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f11245b.bottom;
        }

        public View getChildAt(int i2) {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.f(i2);
            }
            return null;
        }

        public int getChildCount() {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.g();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state) {
            return -1;
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f11245b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f11245b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            Adapter adapter;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                adapter = recyclerView.getAdapter();
            } else {
                adapter = null;
            }
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.D(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f11245b.left;
        }

        public int getMinimumHeight() {
            return ViewCompat.E(this.mRecyclerView);
        }

        public int getMinimumWidth() {
            return ViewCompat.F(this.mRecyclerView);
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.H(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.I(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).a();
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f11245b.right;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state) {
            return -1;
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f11245b.top;
        }

        public void getTransformedBoundingBox(View view, boolean z2, Rect rect) {
            Matrix matrix;
            if (z2) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f11245b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.mRecyclerView == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        /* access modifiers changed from: package-private */
        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.q(childViewHolderInt);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            return smoothScroller != null && smoothScroller.isRunning();
        }

        public boolean isViewPartiallyVisible(View view, boolean z2, boolean z3) {
            boolean z4;
            if (!this.mHorizontalBoundCheck.b(view, 24579) || !this.mVerticalBoundCheck.b(view, 24579)) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z2) {
                return z4;
            }
            return !z4;
        }

        public void layoutDecorated(View view, int i2, int i3, int i4, int i5) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f11245b;
            view.layout(i2 + rect.left, i3 + rect.top, i4 - rect.right, i5 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i2, int i3, int i4, int i5) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f11245b;
            view.layout(i2 + rect.left + layoutParams.leftMargin, i3 + rect.top + layoutParams.topMargin, (i4 - rect.right) - layoutParams.rightMargin, (i5 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void measureChild(View view, int i2, int i3) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i4 = i2 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i5 = i3 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i4, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i5, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(View view, int i2, int i3) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i4 = i2 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i5 = i3 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + i4, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + i5, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i2, int i3) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                detachViewAt(i2);
                attachView(childAt, i3);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2 + this.mRecyclerView.toString());
        }

        public void offsetChildrenHorizontal(int i2) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i2);
            }
        }

        public void offsetChildrenVertical(int i2) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i2);
            }
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i2, int i3) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        @SuppressLint({"UnknownNullness"})
        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        public View onFocusSearchFailed(View view, int i2, Recycler recycler, State state) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        /* access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, accessibilityNodeInfoCompat);
        }

        /* access modifiers changed from: package-private */
        public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.mChildHelper.n(childViewHolderInt.itemView)) {
                RecyclerView recyclerView = this.mRecyclerView;
                onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, accessibilityNodeInfoCompat);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public View onInterceptFocusSearch(View view, int i2) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
            onItemsUpdated(recyclerView, i2, i3);
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutCompleted(State state) {
        }

        public void onMeasure(Recycler recycler, State state, int i2, int i3) {
            this.mRecyclerView.defaultOnMeasure(i2, i3);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        @SuppressLint({"UnknownNullness"})
        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i2) {
        }

        /* access modifiers changed from: package-private */
        public void onSmoothScrollerStopped(SmoothScroller smoothScroller) {
            if (this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean performAccessibilityAction(int i2, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i2, bundle);
        }

        /* access modifiers changed from: package-private */
        public boolean performAccessibilityActionForItem(View view, int i2, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i2, bundle);
        }

        public boolean performAccessibilityActionForItem(Recycler recycler, State state, View view, int i2, Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                ViewCompat.j0(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.q(childCount);
            }
        }

        public void removeAndRecycleAllViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void removeAndRecycleScrapInt(Recycler recycler) {
            int j2 = recycler.j();
            for (int i2 = j2 - 1; i2 >= 0; i2--) {
                View n2 = recycler.n(i2);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(n2);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(n2, false);
                    }
                    ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
                    if (itemAnimator != null) {
                        itemAnimator.j(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    recycler.D(n2);
                }
            }
            recycler.e();
            if (j2 > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, Recycler recycler) {
            removeView(view);
            recycler.G(view);
        }

        public void removeAndRecycleViewAt(int i2, Recycler recycler) {
            View childAt = getChildAt(i2);
            removeViewAt(i2);
            recycler.G(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        @SuppressLint({"UnknownNullness"})
        public void removeView(View view) {
            this.mChildHelper.p(view);
        }

        public void removeViewAt(int i2) {
            if (getChildAt(i2) != null) {
                this.mChildHelper.q(i2);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z2) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z2, false);
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollHorizontallyBy(int i2, Recycler recycler, State state) {
            return 0;
        }

        public void scrollToPosition(int i2) {
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollVerticallyBy(int i2, Recycler recycler, State state) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z2) {
            this.mAutoMeasure = z2;
        }

        /* access modifiers changed from: package-private */
        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z2) {
            if (z2 != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z2;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.P();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setMeasureSpecs(int i2, int i3) {
            this.mWidth = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.mHeightMode = mode2;
            if (mode2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = 0;
            }
        }

        public void setMeasuredDimension(Rect rect, int i2, int i3) {
            setMeasuredDimension(chooseSize(i2, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i3, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        /* access modifiers changed from: package-private */
        public void setMeasuredDimensionFromChildren(int i2, int i3) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i2, i3);
                return;
            }
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MAX_VALUE;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i9 = rect.left;
                if (i9 < i6) {
                    i6 = i9;
                }
                int i10 = rect.right;
                if (i10 > i4) {
                    i4 = i10;
                }
                int i11 = rect.top;
                if (i11 < i7) {
                    i7 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i5) {
                    i5 = i12;
                }
            }
            this.mRecyclerView.mTempRect.set(i6, i7, i4, i5);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i2, i3);
        }

        public void setMeasurementCacheEnabled(boolean z2) {
            this.mMeasurementCacheEnabled = z2;
        }

        /* access modifiers changed from: package-private */
        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldMeasureChild(View view, int i2, int i3, LayoutParams layoutParams) {
            if (view.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getWidth(), i2, layoutParams.width) || !isMeasurementUpToDate(view.getHeight(), i3, layoutParams.height)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldMeasureTwice() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldReMeasureChild(View view, int i2, int i3, LayoutParams layoutParams) {
            if (!this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getMeasuredWidth(), i2, layoutParams.width) || !isMeasurementUpToDate(view.getMeasuredHeight(), i3, layoutParams.height)) {
                return true;
            }
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i2) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        @SuppressLint({"UnknownNullness"})
        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.mSmoothScroller;
            if (!(smoothScroller2 == null || smoothScroller == smoothScroller2 || !smoothScroller2.isRunning())) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = smoothScroller;
            smoothScroller.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        /* access modifiers changed from: package-private */
        public void stopSmoothScroller() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller != null) {
                smoothScroller.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view, int i2) {
            addViewInt(view, i2, true);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view, int i2) {
            addViewInt(view, i2, false);
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z2 = true;
                if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                    z2 = false;
                }
                accessibilityEvent.setScrollable(z2);
                Adapter adapter = this.mRecyclerView.mAdapter;
                if (adapter != null) {
                    accessibilityEvent.setItemCount(adapter.getItemCount());
                }
            }
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.a(8192);
                accessibilityNodeInfoCompat.z0(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.a(CodedOutputStream.DEFAULT_BUFFER_SIZE);
                accessibilityNodeInfoCompat.z0(true);
            }
            accessibilityNodeInfoCompat.e0(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, State state, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x0093 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean performAccessibilityAction(androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10, int r11, android.os.Bundle r12) {
            /*
                r8 = this;
                androidx.recyclerview.widget.RecyclerView r9 = r8.mRecyclerView
                r10 = 0
                if (r9 != 0) goto L_0x0006
                return r10
            L_0x0006:
                int r9 = r8.getHeight()
                int r12 = r8.getWidth()
                android.graphics.Rect r0 = new android.graphics.Rect
                r0.<init>()
                androidx.recyclerview.widget.RecyclerView r1 = r8.mRecyclerView
                android.graphics.Matrix r1 = r1.getMatrix()
                boolean r1 = r1.isIdentity()
                if (r1 == 0) goto L_0x002f
                androidx.recyclerview.widget.RecyclerView r1 = r8.mRecyclerView
                boolean r1 = r1.getGlobalVisibleRect(r0)
                if (r1 == 0) goto L_0x002f
                int r9 = r0.height()
                int r12 = r0.width()
            L_0x002f:
                r0 = 4096(0x1000, float:5.74E-42)
                r1 = 1
                if (r11 == r0) goto L_0x0065
                r0 = 8192(0x2000, float:1.14794E-41)
                if (r11 == r0) goto L_0x003b
                r3 = 0
                r4 = 0
                goto L_0x0091
            L_0x003b:
                androidx.recyclerview.widget.RecyclerView r11 = r8.mRecyclerView
                r0 = -1
                boolean r11 = r11.canScrollVertically(r0)
                if (r11 == 0) goto L_0x0050
                int r11 = r8.getPaddingTop()
                int r9 = r9 - r11
                int r11 = r8.getPaddingBottom()
                int r9 = r9 - r11
                int r9 = -r9
                goto L_0x0051
            L_0x0050:
                r9 = 0
            L_0x0051:
                androidx.recyclerview.widget.RecyclerView r11 = r8.mRecyclerView
                boolean r11 = r11.canScrollHorizontally(r0)
                if (r11 == 0) goto L_0x008f
                int r11 = r8.getPaddingLeft()
                int r12 = r12 - r11
                int r11 = r8.getPaddingRight()
                int r12 = r12 - r11
                int r11 = -r12
                goto L_0x008c
            L_0x0065:
                androidx.recyclerview.widget.RecyclerView r11 = r8.mRecyclerView
                boolean r11 = r11.canScrollVertically(r1)
                if (r11 == 0) goto L_0x0078
                int r11 = r8.getPaddingTop()
                int r9 = r9 - r11
                int r11 = r8.getPaddingBottom()
                int r9 = r9 - r11
                goto L_0x0079
            L_0x0078:
                r9 = 0
            L_0x0079:
                androidx.recyclerview.widget.RecyclerView r11 = r8.mRecyclerView
                boolean r11 = r11.canScrollHorizontally(r1)
                if (r11 == 0) goto L_0x008f
                int r11 = r8.getPaddingLeft()
                int r12 = r12 - r11
                int r11 = r8.getPaddingRight()
                int r11 = r12 - r11
            L_0x008c:
                r4 = r9
                r3 = r11
                goto L_0x0091
            L_0x008f:
                r4 = r9
                r3 = 0
            L_0x0091:
                if (r4 != 0) goto L_0x0096
                if (r3 != 0) goto L_0x0096
                return r10
            L_0x0096:
                androidx.recyclerview.widget.RecyclerView r2 = r8.mRecyclerView
                r5 = 0
                r6 = -2147483648(0xffffffff80000000, float:-0.0)
                r7 = 1
                r2.smoothScrollBy(r3, r4, r5, r6, r7)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.performAccessibilityAction(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, android.os.Bundle):boolean");
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z2, boolean z3) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i2 = childRectangleOnScreenScrollAmount[0];
            int i3 = childRectangleOnScreenScrollAmount[1];
            if ((z3 && !isFocusedChildVisibleAfterScrolling(recyclerView, i2, i3)) || (i2 == 0 && i3 == 0)) {
                return false;
            }
            if (z2) {
                recyclerView.scrollBy(i2, i3);
            } else {
                recyclerView.smoothScrollBy(i2, i3);
            }
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001a
                if (r7 < 0) goto L_0x0011
                goto L_0x001c
            L_0x0011:
                if (r7 != r1) goto L_0x002f
                if (r5 == r2) goto L_0x0021
                if (r5 == 0) goto L_0x002f
                if (r5 == r3) goto L_0x0021
                goto L_0x002f
            L_0x001a:
                if (r7 < 0) goto L_0x001f
            L_0x001c:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L_0x0031
            L_0x001f:
                if (r7 != r1) goto L_0x0023
            L_0x0021:
                r7 = r4
                goto L_0x0031
            L_0x0023:
                if (r7 != r0) goto L_0x002f
                if (r5 == r2) goto L_0x002c
                if (r5 != r3) goto L_0x002a
                goto L_0x002c
            L_0x002a:
                r5 = 0
                goto L_0x0021
            L_0x002c:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0021
            L_0x002f:
                r5 = 0
                r7 = 0
            L_0x0031:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public void attachView(View view, int i2) {
            attachView(view, i2, (LayoutParams) view.getLayoutParams());
        }

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int i2, int i3) {
            this.mRecyclerView.setMeasuredDimension(i2, i3);
        }

        public void attachView(View view) {
            attachView(view, -1);
        }
    }

    public interface OnChildAttachStateChangeListener {
        void a(View view);

        void b(View view);
    }

    public static abstract class OnFlingListener {
        public abstract boolean a(int i2, int i3);
    }

    public interface OnItemTouchListener {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z2);
    }

    public static abstract class OnScrollListener {
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        }

        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        }
    }

    public static class RecycledViewPool {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<ScrapData> f11248a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        int f11249b = 0;

        /* renamed from: c  reason: collision with root package name */
        Set<Adapter<?>> f11250c = Collections.newSetFromMap(new IdentityHashMap());

        static class ScrapData {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList<ViewHolder> f11251a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f11252b = 5;

            /* renamed from: c  reason: collision with root package name */
            long f11253c = 0;

            /* renamed from: d  reason: collision with root package name */
            long f11254d = 0;

            ScrapData() {
            }
        }

        private ScrapData i(int i2) {
            ScrapData scrapData = this.f11248a.get(i2);
            if (scrapData != null) {
                return scrapData;
            }
            ScrapData scrapData2 = new ScrapData();
            this.f11248a.put(i2, scrapData2);
            return scrapData2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f11249b++;
        }

        /* access modifiers changed from: package-private */
        public void b(Adapter<?> adapter) {
            this.f11250c.add(adapter);
        }

        public void c() {
            for (int i2 = 0; i2 < this.f11248a.size(); i2++) {
                ScrapData valueAt = this.f11248a.valueAt(i2);
                Iterator<ViewHolder> it2 = valueAt.f11251a.iterator();
                while (it2.hasNext()) {
                    PoolingContainer.a(it2.next().itemView);
                }
                valueAt.f11251a.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f11249b--;
        }

        /* access modifiers changed from: package-private */
        public void e(Adapter<?> adapter, boolean z2) {
            this.f11250c.remove(adapter);
            if (this.f11250c.size() == 0 && !z2) {
                for (int i2 = 0; i2 < this.f11248a.size(); i2++) {
                    SparseArray<ScrapData> sparseArray = this.f11248a;
                    ArrayList<ViewHolder> arrayList = sparseArray.get(sparseArray.keyAt(i2)).f11251a;
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        PoolingContainer.a(arrayList.get(i3).itemView);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f(int i2, long j2) {
            ScrapData i3 = i(i2);
            i3.f11254d = l(i3.f11254d, j2);
        }

        /* access modifiers changed from: package-private */
        public void g(int i2, long j2) {
            ScrapData i3 = i(i2);
            i3.f11253c = l(i3.f11253c, j2);
        }

        public ViewHolder h(int i2) {
            ScrapData scrapData = this.f11248a.get(i2);
            if (scrapData == null || scrapData.f11251a.isEmpty()) {
                return null;
            }
            ArrayList<ViewHolder> arrayList = scrapData.f11251a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void j(Adapter<?> adapter, Adapter<?> adapter2, boolean z2) {
            if (adapter != null) {
                d();
            }
            if (!z2 && this.f11249b == 0) {
                c();
            }
            if (adapter2 != null) {
                a();
            }
        }

        public void k(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> arrayList = i(itemViewType).f11251a;
            if (this.f11248a.get(itemViewType).f11252b <= arrayList.size()) {
                PoolingContainer.a(viewHolder.itemView);
                return;
            }
            viewHolder.resetInternal();
            arrayList.add(viewHolder);
        }

        /* access modifiers changed from: package-private */
        public long l(long j2, long j3) {
            return j2 == 0 ? j3 : ((j2 / 4) * 3) + (j3 / 4);
        }

        /* access modifiers changed from: package-private */
        public boolean m(int i2, long j2, long j3) {
            long j4 = i(i2).f11254d;
            return j4 == 0 || j2 + j4 < j3;
        }

        /* access modifiers changed from: package-private */
        public boolean n(int i2, long j2, long j3) {
            long j4 = i(i2).f11253c;
            return j4 == 0 || j2 + j4 < j3;
        }
    }

    public final class Recycler {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<ViewHolder> f11255a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<ViewHolder> f11256b = null;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<ViewHolder> f11257c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        private final List<ViewHolder> f11258d;

        /* renamed from: e  reason: collision with root package name */
        private int f11259e;

        /* renamed from: f  reason: collision with root package name */
        int f11260f;

        /* renamed from: g  reason: collision with root package name */
        RecycledViewPool f11261g;

        /* renamed from: h  reason: collision with root package name */
        private ViewCacheExtension f11262h;

        public Recycler() {
            ArrayList<ViewHolder> arrayList = new ArrayList<>();
            this.f11255a = arrayList;
            this.f11258d = Collections.unmodifiableList(arrayList);
            this.f11259e = 2;
            this.f11260f = 2;
        }

        private void B(Adapter<?> adapter) {
            C(adapter, false);
        }

        private void C(Adapter<?> adapter, boolean z2) {
            RecycledViewPool recycledViewPool = this.f11261g;
            if (recycledViewPool != null) {
                recycledViewPool.e(adapter, z2);
            }
        }

        private boolean M(ViewHolder viewHolder, int i2, int i3, long j2) {
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = viewHolder.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j2 != Long.MAX_VALUE && !this.f11261g.m(itemViewType, nanoTime, j2)) {
                return false;
            }
            RecyclerView.this.mAdapter.bindViewHolder(viewHolder, i2);
            this.f11261g.f(viewHolder.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            b(viewHolder);
            if (!RecyclerView.this.mState.e()) {
                return true;
            }
            viewHolder.mPreLayoutPosition = i3;
            return true;
        }

        private void b(ViewHolder viewHolder) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = viewHolder.itemView;
                if (ViewCompat.B(view) == 0) {
                    ViewCompat.C0(view, 1);
                }
                RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.mAccessibilityDelegate;
                if (recyclerViewAccessibilityDelegate != null) {
                    AccessibilityDelegateCompat a2 = recyclerViewAccessibilityDelegate.a();
                    if (a2 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                        ((RecyclerViewAccessibilityDelegate.ItemDelegate) a2).b(view);
                    }
                    ViewCompat.r0(view, a2);
                }
            }
        }

        private void q(ViewGroup viewGroup, boolean z2) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z2) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        private void r(ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        private void u() {
            if (this.f11261g != null) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mAdapter != null && recyclerView.isAttachedToWindow()) {
                    this.f11261g.b(RecyclerView.this.mAdapter);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void A() {
            for (int i2 = 0; i2 < this.f11257c.size(); i2++) {
                PoolingContainer.a(this.f11257c.get(i2).itemView);
            }
            B(RecyclerView.this.mAdapter);
        }

        /* access modifiers changed from: package-private */
        public void D(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            H(childViewHolderInt);
        }

        /* access modifiers changed from: package-private */
        public void E() {
            for (int size = this.f11257c.size() - 1; size >= 0; size--) {
                F(size);
            }
            this.f11257c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.b();
            }
        }

        /* access modifiers changed from: package-private */
        public void F(int i2) {
            a(this.f11257c.get(i2), true);
            this.f11257c.remove(i2);
        }

        public void G(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            H(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                RecyclerView.this.mItemAnimator.j(childViewHolderInt);
            }
        }

        /* access modifiers changed from: package-private */
        public void H(ViewHolder viewHolder) {
            boolean z2;
            boolean z3;
            boolean z4 = false;
            boolean z5 = true;
            if (viewHolder.isScrap() || viewHolder.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(viewHolder.isScrap());
                sb.append(" isAttached:");
                if (viewHolder.itemView.getParent() != null) {
                    z4 = true;
                }
                sb.append(z4);
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            } else if (viewHolder.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder + RecyclerView.this.exceptionLabel());
            } else if (!viewHolder.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = viewHolder.doesTransientStatePreventRecycling();
                Adapter adapter = RecyclerView.this.mAdapter;
                if (adapter == null || !doesTransientStatePreventRecycling || !adapter.onFailedToRecycleView(viewHolder)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2 || viewHolder.isRecyclable()) {
                    if (this.f11260f <= 0 || viewHolder.hasAnyOfTheFlags(526)) {
                        z3 = false;
                    } else {
                        int size = this.f11257c.size();
                        if (size >= this.f11260f && size > 0) {
                            F(0);
                            size--;
                        }
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.d(viewHolder.mPosition)) {
                            int i2 = size - 1;
                            while (i2 >= 0) {
                                if (!RecyclerView.this.mPrefetchRegistry.d(this.f11257c.get(i2).mPosition)) {
                                    break;
                                }
                                i2--;
                            }
                            size = i2 + 1;
                        }
                        this.f11257c.add(size, viewHolder);
                        z3 = true;
                    }
                    if (!z3) {
                        a(viewHolder, true);
                        z4 = z3;
                        RecyclerView.this.mViewInfoStore.q(viewHolder);
                        if (!z4 && !z5 && doesTransientStatePreventRecycling) {
                            PoolingContainer.a(viewHolder.itemView);
                            viewHolder.mBindingAdapter = null;
                            viewHolder.mOwnerRecyclerView = null;
                            return;
                        }
                        return;
                    }
                    z4 = z3;
                }
                z5 = false;
                RecyclerView.this.mViewInfoStore.q(viewHolder);
                if (!z4) {
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
        }

        /* access modifiers changed from: package-private */
        public void I(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f11256b == null) {
                    this.f11256b = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.f11256b.add(childViewHolderInt);
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                this.f11255a.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            }
        }

        /* access modifiers changed from: package-private */
        public void J(RecycledViewPool recycledViewPool) {
            B(RecyclerView.this.mAdapter);
            RecycledViewPool recycledViewPool2 = this.f11261g;
            if (recycledViewPool2 != null) {
                recycledViewPool2.d();
            }
            this.f11261g = recycledViewPool;
            if (!(recycledViewPool == null || RecyclerView.this.getAdapter() == null)) {
                this.f11261g.a();
            }
            u();
        }

        /* access modifiers changed from: package-private */
        public void K(ViewCacheExtension viewCacheExtension) {
            this.f11262h = viewCacheExtension;
        }

        public void L(int i2) {
            this.f11259e = i2;
            P();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01a2  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01cb  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x01ce  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x01fe  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x020c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.ViewHolder N(int r17, boolean r18, long r19) {
            /*
                r16 = this;
                r6 = r16
                r3 = r17
                r0 = r18
                if (r3 < 0) goto L_0x022f
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r1 = r1.mState
                int r1 = r1.b()
                if (r3 >= r1) goto L_0x022f
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r1 = r1.mState
                boolean r1 = r1.e()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r16.h(r17)
                if (r1 == 0) goto L_0x0028
                r4 = 1
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r16.m(r17, r18)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.Q(r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.addFlags(r5)
                boolean r5 = r1.isScrap()
                if (r5 == 0) goto L_0x004e
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r1.itemView
                r5.removeDetachedView(r9, r8)
                r1.unScrap()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.wasReturnedFromScrap()
                if (r5 == 0) goto L_0x0057
                r1.clearReturnedFromScrapFlag()
            L_0x0057:
                r6.H(r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = 1
            L_0x005d:
                if (r1 != 0) goto L_0x0181
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.AdapterHelper r5 = r5.mAdapterHelper
                int r5 = r5.m(r3)
                if (r5 < 0) goto L_0x0149
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.mAdapter
                int r9 = r9.getItemCount()
                if (r5 >= r9) goto L_0x0149
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.mAdapter
                int r9 = r9.getItemViewType(r5)
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r10 = r10.mAdapter
                boolean r10 = r10.hasStableIds()
                if (r10 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.mAdapter
                long r10 = r1.getItemId(r5)
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r6.l(r10, r9, r0)
                if (r1 == 0) goto L_0x0096
                r1.mPosition = r5
                r4 = 1
            L_0x0096:
                if (r1 != 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView$ViewCacheExtension r0 = r6.f11262h
                if (r0 == 0) goto L_0x00eb
                android.view.View r0 = r0.a(r6, r3, r9)
                if (r0 == 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r1.getChildViewHolder(r0)
                if (r1 == 0) goto L_0x00ce
                boolean r0 = r1.shouldIgnore()
                if (r0 != 0) goto L_0x00b1
                goto L_0x00eb
            L_0x00b1:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00ce:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00eb:
                if (r1 != 0) goto L_0x0102
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r0 = r16.i()
                androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r0.h(r9)
                if (r0 == 0) goto L_0x0101
                r0.resetInternal()
                boolean r1 = androidx.recyclerview.widget.RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST
                if (r1 == 0) goto L_0x0101
                r6.r(r0)
            L_0x0101:
                r1 = r0
            L_0x0102:
                if (r1 != 0) goto L_0x0181
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                long r0 = r0.getNanoTime()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
                if (r5 == 0) goto L_0x0120
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r10 = r6.f11261g
                r11 = r9
                r12 = r0
                r14 = r19
                boolean r5 = r10.n(r11, r12, r14)
                if (r5 != 0) goto L_0x0120
                return r2
            L_0x0120:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r5 = r2.mAdapter
                androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r5.createViewHolder(r2, r9)
                boolean r5 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
                if (r5 == 0) goto L_0x013b
                android.view.View r5 = r2.itemView
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.findNestedRecyclerView(r5)
                if (r5 == 0) goto L_0x013b
                java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
                r10.<init>(r5)
                r2.mNestedRecyclerView = r10
            L_0x013b:
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                long r10 = r5.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r5 = r6.f11261g
                long r10 = r10 - r0
                r5.g(r9, r10)
                r9 = r2
                goto L_0x0182
            L_0x0149:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ").state:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.mState
                int r2 = r2.b()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0181:
                r9 = r1
            L_0x0182:
                r10 = r4
                if (r10 == 0) goto L_0x01bb
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r0 = r0.mState
                boolean r0 = r0.e()
                if (r0 != 0) goto L_0x01bb
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r9.hasAnyOfTheFlags(r0)
                if (r1 == 0) goto L_0x01bb
                r9.setFlags(r8, r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r0 = r0.mState
                boolean r0 = r0.f11283k
                if (r0 == 0) goto L_0x01bb
                int r0 = androidx.recyclerview.widget.RecyclerView.ItemAnimator.e(r9)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$ItemAnimator r2 = r1.mItemAnimator
                androidx.recyclerview.widget.RecyclerView$State r1 = r1.mState
                java.util.List r4 = r9.getUnmodifiedPayloads()
                androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r0 = r2.t(r1, r9, r0, r4)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.recordAnimationInfoIfBouncedHiddenView(r9, r0)
            L_0x01bb:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r0 = r0.mState
                boolean r0 = r0.e()
                if (r0 == 0) goto L_0x01ce
                boolean r0 = r9.isBound()
                if (r0 == 0) goto L_0x01ce
                r9.mPreLayoutPosition = r3
                goto L_0x01e1
            L_0x01ce:
                boolean r0 = r9.isBound()
                if (r0 == 0) goto L_0x01e3
                boolean r0 = r9.needsUpdate()
                if (r0 != 0) goto L_0x01e3
                boolean r0 = r9.isInvalid()
                if (r0 == 0) goto L_0x01e1
                goto L_0x01e3
            L_0x01e1:
                r0 = 0
                goto L_0x01f6
            L_0x01e3:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.AdapterHelper r0 = r0.mAdapterHelper
                int r2 = r0.m(r3)
                r0 = r16
                r1 = r9
                r3 = r17
                r4 = r19
                boolean r0 = r0.M(r1, r2, r3, r4)
            L_0x01f6:
                android.view.View r1 = r9.itemView
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x020c
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
                android.view.View r2 = r9.itemView
                r2.setLayoutParams(r1)
                goto L_0x0224
            L_0x020c:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x0222
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
                android.view.View r2 = r9.itemView
                r2.setLayoutParams(r1)
                goto L_0x0224
            L_0x0222:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
            L_0x0224:
                r1.f11244a = r9
                if (r10 == 0) goto L_0x022b
                if (r0 == 0) goto L_0x022b
                goto L_0x022c
            L_0x022b:
                r7 = 0
            L_0x022c:
                r1.f11247d = r7
                return r9
            L_0x022f:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.mState
                int r2 = r2.b()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.N(int, boolean, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        /* access modifiers changed from: package-private */
        public void O(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.f11256b.remove(viewHolder);
            } else {
                this.f11255a.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        /* access modifiers changed from: package-private */
        public void P() {
            int i2;
            LayoutManager layoutManager = RecyclerView.this.mLayout;
            if (layoutManager != null) {
                i2 = layoutManager.mPrefetchMaxCountObserved;
            } else {
                i2 = 0;
            }
            this.f11260f = this.f11259e + i2;
            for (int size = this.f11257c.size() - 1; size >= 0 && this.f11257c.size() > this.f11260f; size--) {
                F(size);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean Q(ViewHolder viewHolder) {
            if (viewHolder.isRemoved()) {
                return RecyclerView.this.mState.e();
            }
            int i2 = viewHolder.mPosition;
            if (i2 < 0 || i2 >= RecyclerView.this.mAdapter.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder + RecyclerView.this.exceptionLabel());
            } else if (!RecyclerView.this.mState.e() && RecyclerView.this.mAdapter.getItemViewType(viewHolder.mPosition) != viewHolder.getItemViewType()) {
                return false;
            } else {
                if (!RecyclerView.this.mAdapter.hasStableIds() || viewHolder.getItemId() == RecyclerView.this.mAdapter.getItemId(viewHolder.mPosition)) {
                    return true;
                }
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public void R(int i2, int i3) {
            int i4;
            int i5 = i3 + i2;
            for (int size = this.f11257c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f11257c.get(size);
                if (viewHolder != null && (i4 = viewHolder.mPosition) >= i2 && i4 < i5) {
                    viewHolder.addFlags(2);
                    F(size);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(ViewHolder viewHolder, boolean z2) {
            AccessibilityDelegateCompat accessibilityDelegateCompat;
            RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
            View view = viewHolder.itemView;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.mAccessibilityDelegate;
            if (recyclerViewAccessibilityDelegate != null) {
                AccessibilityDelegateCompat a2 = recyclerViewAccessibilityDelegate.a();
                if (a2 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                    accessibilityDelegateCompat = ((RecyclerViewAccessibilityDelegate.ItemDelegate) a2).a(view);
                } else {
                    accessibilityDelegateCompat = null;
                }
                ViewCompat.r0(view, accessibilityDelegateCompat);
            }
            if (z2) {
                g(viewHolder);
            }
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = null;
            i().k(viewHolder);
        }

        public void c() {
            this.f11255a.clear();
            E();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            int size = this.f11257c.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f11257c.get(i2).clearOldPosition();
            }
            int size2 = this.f11255a.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f11255a.get(i3).clearOldPosition();
            }
            ArrayList<ViewHolder> arrayList = this.f11256b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    this.f11256b.get(i4).clearOldPosition();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f11255a.clear();
            ArrayList<ViewHolder> arrayList = this.f11256b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i2) {
            if (i2 < 0 || i2 >= RecyclerView.this.mState.b()) {
                throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + RecyclerView.this.mState.b() + RecyclerView.this.exceptionLabel());
            } else if (!RecyclerView.this.mState.e()) {
                return i2;
            } else {
                return RecyclerView.this.mAdapterHelper.m(i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void g(ViewHolder viewHolder) {
            RecyclerListener recyclerListener = RecyclerView.this.mRecyclerListener;
            if (recyclerListener != null) {
                recyclerListener.a(viewHolder);
            }
            int size = RecyclerView.this.mRecyclerListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                RecyclerView.this.mRecyclerListeners.get(i2).a(viewHolder);
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter != null) {
                adapter.onViewRecycled(viewHolder);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.q(viewHolder);
            }
        }

        /* access modifiers changed from: package-private */
        public ViewHolder h(int i2) {
            int size;
            int m2;
            ArrayList<ViewHolder> arrayList = this.f11256b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i3 = 0;
                int i4 = 0;
                while (i4 < size) {
                    ViewHolder viewHolder = this.f11256b.get(i4);
                    if (viewHolder.wasReturnedFromScrap() || viewHolder.getLayoutPosition() != i2) {
                        i4++;
                    } else {
                        viewHolder.addFlags(32);
                        return viewHolder;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (m2 = RecyclerView.this.mAdapterHelper.m(i2)) > 0 && m2 < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(m2);
                    while (i3 < size) {
                        ViewHolder viewHolder2 = this.f11256b.get(i3);
                        if (viewHolder2.wasReturnedFromScrap() || viewHolder2.getItemId() != itemId) {
                            i3++;
                        } else {
                            viewHolder2.addFlags(32);
                            return viewHolder2;
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public RecycledViewPool i() {
            if (this.f11261g == null) {
                this.f11261g = new RecycledViewPool();
                u();
            }
            return this.f11261g;
        }

        /* access modifiers changed from: package-private */
        public int j() {
            return this.f11255a.size();
        }

        public List<ViewHolder> k() {
            return this.f11258d;
        }

        /* access modifiers changed from: package-private */
        public ViewHolder l(long j2, int i2, boolean z2) {
            for (int size = this.f11255a.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f11255a.get(size);
                if (viewHolder.getItemId() == j2 && !viewHolder.wasReturnedFromScrap()) {
                    if (i2 == viewHolder.getItemViewType()) {
                        viewHolder.addFlags(32);
                        if (viewHolder.isRemoved() && !RecyclerView.this.mState.e()) {
                            viewHolder.setFlags(2, 14);
                        }
                        return viewHolder;
                    } else if (!z2) {
                        this.f11255a.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        D(viewHolder.itemView);
                    }
                }
            }
            int size2 = this.f11257c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                ViewHolder viewHolder2 = this.f11257c.get(size2);
                if (viewHolder2.getItemId() == j2 && !viewHolder2.isAttachedToTransitionOverlay()) {
                    if (i2 == viewHolder2.getItemViewType()) {
                        if (!z2) {
                            this.f11257c.remove(size2);
                        }
                        return viewHolder2;
                    } else if (!z2) {
                        F(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public ViewHolder m(int i2, boolean z2) {
            View e2;
            int size = this.f11255a.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                ViewHolder viewHolder = this.f11255a.get(i4);
                if (viewHolder.wasReturnedFromScrap() || viewHolder.getLayoutPosition() != i2 || viewHolder.isInvalid() || (!RecyclerView.this.mState.f11280h && viewHolder.isRemoved())) {
                    i4++;
                } else {
                    viewHolder.addFlags(32);
                    return viewHolder;
                }
            }
            if (z2 || (e2 = RecyclerView.this.mChildHelper.e(i2)) == null) {
                int size2 = this.f11257c.size();
                while (i3 < size2) {
                    ViewHolder viewHolder2 = this.f11257c.get(i3);
                    if (viewHolder2.isInvalid() || viewHolder2.getLayoutPosition() != i2 || viewHolder2.isAttachedToTransitionOverlay()) {
                        i3++;
                    } else {
                        if (!z2) {
                            this.f11257c.remove(i3);
                        }
                        return viewHolder2;
                    }
                }
                return null;
            }
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(e2);
            RecyclerView.this.mChildHelper.s(e2);
            int m2 = RecyclerView.this.mChildHelper.m(e2);
            if (m2 != -1) {
                RecyclerView.this.mChildHelper.d(m2);
                I(e2);
                childViewHolderInt.addFlags(8224);
                return childViewHolderInt;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
        }

        /* access modifiers changed from: package-private */
        public View n(int i2) {
            return this.f11255a.get(i2).itemView;
        }

        public View o(int i2) {
            return p(i2, false);
        }

        /* access modifiers changed from: package-private */
        public View p(int i2, boolean z2) {
            return N(i2, z2, Long.MAX_VALUE).itemView;
        }

        /* access modifiers changed from: package-private */
        public void s() {
            int size = this.f11257c.size();
            for (int i2 = 0; i2 < size; i2++) {
                LayoutParams layoutParams = (LayoutParams) this.f11257c.get(i2).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f11246c = true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void t() {
            int size = this.f11257c.size();
            for (int i2 = 0; i2 < size; i2++) {
                ViewHolder viewHolder = this.f11257c.get(i2);
                if (viewHolder != null) {
                    viewHolder.addFlags(6);
                    viewHolder.addChangePayload((Object) null);
                }
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter == null || !adapter.hasStableIds()) {
                E();
            }
        }

        /* access modifiers changed from: package-private */
        public void v(int i2, int i3) {
            int size = this.f11257c.size();
            for (int i4 = 0; i4 < size; i4++) {
                ViewHolder viewHolder = this.f11257c.get(i4);
                if (viewHolder != null && viewHolder.mPosition >= i2) {
                    viewHolder.offsetPosition(i3, false);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void w(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            if (i2 < i3) {
                i6 = -1;
                i5 = i2;
                i4 = i3;
            } else {
                i6 = 1;
                i4 = i2;
                i5 = i3;
            }
            int size = this.f11257c.size();
            for (int i8 = 0; i8 < size; i8++) {
                ViewHolder viewHolder = this.f11257c.get(i8);
                if (viewHolder != null && (i7 = viewHolder.mPosition) >= i5 && i7 <= i4) {
                    if (i7 == i2) {
                        viewHolder.offsetPosition(i3 - i2, false);
                    } else {
                        viewHolder.offsetPosition(i6, false);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void x(int i2, int i3, boolean z2) {
            int i4 = i2 + i3;
            for (int size = this.f11257c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f11257c.get(size);
                if (viewHolder != null) {
                    int i5 = viewHolder.mPosition;
                    if (i5 >= i4) {
                        viewHolder.offsetPosition(-i3, z2);
                    } else if (i5 >= i2) {
                        viewHolder.addFlags(8);
                        F(size);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void y(Adapter<?> adapter, Adapter<?> adapter2, boolean z2) {
            c();
            C(adapter, true);
            i().j(adapter, adapter2, z2);
            u();
        }

        /* access modifiers changed from: package-private */
        public void z() {
            u();
        }
    }

    public interface RecyclerListener {
        void a(ViewHolder viewHolder);
    }

    private class RecyclerViewDataObserver extends AdapterDataObserver {
        RecyclerViewDataObserver() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    ViewCompat.j0(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }

        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.f11279g = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (!RecyclerView.this.mAdapterHelper.p()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void onItemRangeChanged(int i2, int i3, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.r(i2, i3, obj)) {
                a();
            }
        }

        public void onItemRangeInserted(int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.s(i2, i3)) {
                a();
            }
        }

        public void onItemRangeMoved(int i2, int i3, int i4) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.t(i2, i3, i4)) {
                a();
            }
        }

        public void onItemRangeRemoved(int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.u(i2, i3)) {
                a();
            }
        }

        public void onStateRestorationPolicyChanged() {
            Adapter adapter;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mPendingSavedState != null && (adapter = recyclerView.mAdapter) != null && adapter.canRestoreState()) {
                RecyclerView.this.requestLayout();
            }
        }
    }

    public static abstract class SmoothScroller {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final Action mRecyclingAction = new Action(0, 0);
        private boolean mRunning;
        private boolean mStarted;
        private int mTargetPosition = -1;
        private View mTargetView;

        public static class Action {

            /* renamed from: a  reason: collision with root package name */
            private int f11266a;

            /* renamed from: b  reason: collision with root package name */
            private int f11267b;

            /* renamed from: c  reason: collision with root package name */
            private int f11268c;

            /* renamed from: d  reason: collision with root package name */
            private int f11269d;

            /* renamed from: e  reason: collision with root package name */
            private Interpolator f11270e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f11271f;

            /* renamed from: g  reason: collision with root package name */
            private int f11272g;

            public Action(int i2, int i3) {
                this(i2, i3, Integer.MIN_VALUE, (Interpolator) null);
            }

            private void e() {
                if (this.f11270e != null && this.f11268c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f11268c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            /* access modifiers changed from: package-private */
            public boolean a() {
                return this.f11269d >= 0;
            }

            public void b(int i2) {
                this.f11269d = i2;
            }

            /* access modifiers changed from: package-private */
            public void c(RecyclerView recyclerView) {
                int i2 = this.f11269d;
                if (i2 >= 0) {
                    this.f11269d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i2);
                    this.f11271f = false;
                } else if (this.f11271f) {
                    e();
                    recyclerView.mViewFlinger.e(this.f11266a, this.f11267b, this.f11268c, this.f11270e);
                    int i3 = this.f11272g + 1;
                    this.f11272g = i3;
                    if (i3 > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f11271f = false;
                } else {
                    this.f11272g = 0;
                }
            }

            public void d(int i2, int i3, int i4, Interpolator interpolator) {
                this.f11266a = i2;
                this.f11267b = i3;
                this.f11268c = i4;
                this.f11270e = interpolator;
                this.f11271f = true;
            }

            public Action(int i2, int i3, int i4, Interpolator interpolator) {
                this.f11269d = -1;
                this.f11271f = false;
                this.f11272g = 0;
                this.f11266a = i2;
                this.f11267b = i3;
                this.f11268c = i4;
                this.f11270e = interpolator;
            }
        }

        public interface ScrollVectorProvider {
            PointF computeScrollVectorForPosition(int i2);
        }

        public PointF computeScrollVectorForPosition(int i2) {
            LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i2);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        public View findViewByPosition(int i2) {
            return this.mRecyclerView.mLayout.findViewByPosition(i2);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int i2) {
            this.mRecyclerView.scrollToPosition(i2);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        /* access modifiers changed from: protected */
        public void normalize(PointF pointF) {
            float f2 = pointF.x;
            float f3 = pointF.y;
            float sqrt = (float) Math.sqrt((double) ((f2 * f2) + (f3 * f3)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        /* access modifiers changed from: package-private */
        public void onAnimation(int i2, int i3) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null) {
                float f2 = computeScrollVectorForPosition.x;
                if (!(f2 == RecyclerView.DECELERATION_RATE && computeScrollVectorForPosition.y == RecyclerView.DECELERATION_RATE)) {
                    recyclerView.scrollStep((int) Math.signum(f2), (int) Math.signum(computeScrollVectorForPosition.y), (int[]) null);
                }
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.c(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i2, i3, recyclerView.mState, this.mRecyclingAction);
                boolean a2 = this.mRecyclingAction.a();
                this.mRecyclingAction.c(recyclerView);
                if (a2 && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.d();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void onSeekTargetStep(int i2, int i3, State state, Action action);

        /* access modifiers changed from: protected */
        public abstract void onStart();

        /* access modifiers changed from: protected */
        public abstract void onStop();

        /* access modifiers changed from: protected */
        public abstract void onTargetFound(View view, State state, Action action);

        public void setTargetPosition(int i2) {
            this.mTargetPosition = i2;
        }

        /* access modifiers changed from: package-private */
        public void start(RecyclerView recyclerView, LayoutManager layoutManager) {
            recyclerView.mViewFlinger.f();
            if (this.mStarted) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = layoutManager;
            int i2 = this.mTargetPosition;
            if (i2 != -1) {
                recyclerView.mState.f11273a = i2;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                this.mRecyclerView.mViewFlinger.d();
                this.mStarted = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* access modifiers changed from: protected */
        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.f11273a = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    public static class State {

        /* renamed from: a  reason: collision with root package name */
        int f11273a = -1;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<Object> f11274b;

        /* renamed from: c  reason: collision with root package name */
        int f11275c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f11276d = 0;

        /* renamed from: e  reason: collision with root package name */
        int f11277e = 1;

        /* renamed from: f  reason: collision with root package name */
        int f11278f = 0;

        /* renamed from: g  reason: collision with root package name */
        boolean f11279g = false;

        /* renamed from: h  reason: collision with root package name */
        boolean f11280h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f11281i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f11282j = false;

        /* renamed from: k  reason: collision with root package name */
        boolean f11283k = false;

        /* renamed from: l  reason: collision with root package name */
        boolean f11284l = false;

        /* renamed from: m  reason: collision with root package name */
        int f11285m;

        /* renamed from: n  reason: collision with root package name */
        long f11286n;

        /* renamed from: o  reason: collision with root package name */
        int f11287o;

        /* renamed from: p  reason: collision with root package name */
        int f11288p;

        /* renamed from: q  reason: collision with root package name */
        int f11289q;

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if ((this.f11277e & i2) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.f11277e));
            }
        }

        public int b() {
            if (this.f11280h) {
                return this.f11275c - this.f11276d;
            }
            return this.f11278f;
        }

        public int c() {
            return this.f11273a;
        }

        public boolean d() {
            return this.f11273a != -1;
        }

        public boolean e() {
            return this.f11280h;
        }

        /* access modifiers changed from: package-private */
        public void f(Adapter adapter) {
            this.f11277e = 1;
            this.f11278f = adapter.getItemCount();
            this.f11280h = false;
            this.f11281i = false;
            this.f11282j = false;
        }

        public boolean g() {
            return this.f11284l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f11273a + ", mData=" + this.f11274b + ", mItemCount=" + this.f11278f + ", mIsMeasuring=" + this.f11282j + ", mPreviousLayoutItemCount=" + this.f11275c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f11276d + ", mStructureChanged=" + this.f11279g + ", mInPreLayout=" + this.f11280h + ", mRunSimpleAnimations=" + this.f11283k + ", mRunPredictiveAnimations=" + this.f11284l + '}';
        }
    }

    static class StretchEdgeEffectFactory extends EdgeEffectFactory {
        StretchEdgeEffectFactory() {
        }

        /* access modifiers changed from: protected */
        public EdgeEffect a(RecyclerView recyclerView, int i2) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class ViewCacheExtension {
        public abstract View a(Recycler recycler, int i2, int i3);
    }

    class ViewFlinger implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int f11290b;

        /* renamed from: c  reason: collision with root package name */
        private int f11291c;

        /* renamed from: d  reason: collision with root package name */
        OverScroller f11292d;

        /* renamed from: e  reason: collision with root package name */
        Interpolator f11293e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f11294f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f11295g = false;

        ViewFlinger() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.f11293e = interpolator;
            this.f11292d = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i2, int i3) {
            boolean z2;
            int i4;
            int abs = Math.abs(i2);
            int abs2 = Math.abs(i3);
            if (abs > abs2) {
                z2 = true;
            } else {
                z2 = false;
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (z2) {
                i4 = recyclerView.getWidth();
            } else {
                i4 = recyclerView.getHeight();
            }
            if (!z2) {
                abs = abs2;
            }
            return Math.min((int) (((((float) abs) / ((float) i4)) + 1.0f) * 300.0f), 2000);
        }

        private void c() {
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.j0(RecyclerView.this, this);
        }

        public void b(int i2, int i3) {
            RecyclerView.this.setScrollState(2);
            this.f11291c = 0;
            this.f11290b = 0;
            Interpolator interpolator = this.f11293e;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.f11293e = interpolator2;
                this.f11292d = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f11292d.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            d();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (this.f11294f) {
                this.f11295g = true;
            } else {
                c();
            }
        }

        public void e(int i2, int i3, int i4, Interpolator interpolator) {
            if (i4 == Integer.MIN_VALUE) {
                i4 = a(i2, i3);
            }
            int i5 = i4;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f11293e != interpolator) {
                this.f11293e = interpolator;
                this.f11292d = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f11291c = 0;
            this.f11290b = 0;
            RecyclerView.this.setScrollState(2);
            this.f11292d.startScroll(0, 0, i2, i3, i5);
            if (Build.VERSION.SDK_INT < 23) {
                this.f11292d.computeScrollOffset();
            }
            d();
        }

        public void f() {
            RecyclerView.this.removeCallbacks(this);
            this.f11292d.abortAnimation();
        }

        public void run() {
            int i2;
            int i3;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            int i4;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                f();
                return;
            }
            this.f11295g = false;
            this.f11294f = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.f11292d;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i5 = currX - this.f11290b;
                int i6 = currY - this.f11291c;
                this.f11290b = currX;
                this.f11291c = currY;
                int consumeFlingInHorizontalStretch = RecyclerView.this.consumeFlingInHorizontalStretch(i5);
                int consumeFlingInVerticalStretch = RecyclerView.this.consumeFlingInVerticalStretch(i6);
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, iArr, (int[]) null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    consumeFlingInHorizontalStretch -= iArr2[0];
                    consumeFlingInVerticalStretch -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i2 = iArr4[0];
                    i3 = iArr4[1];
                    consumeFlingInHorizontalStretch -= i2;
                    consumeFlingInVerticalStretch -= i3;
                    SmoothScroller smoothScroller = recyclerView4.mLayout.mSmoothScroller;
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int b2 = RecyclerView.this.mState.b();
                        if (b2 == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.getTargetPosition() >= b2) {
                            smoothScroller.setTargetPosition(b2 - 1);
                            smoothScroller.onAnimation(i2, i3);
                        } else {
                            smoothScroller.onAnimation(i2, i3);
                        }
                    }
                } else {
                    i3 = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i2, i3, consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, (int[]) null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.mReusableIntPair;
                int i7 = consumeFlingInHorizontalStretch - iArr6[0];
                int i8 = consumeFlingInVerticalStretch - iArr6[1];
                if (!(i2 == 0 && i3 == 0)) {
                    recyclerView6.dispatchOnScrolled(i2, i3);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                if (overScroller.getCurrX() == overScroller.getFinalX()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (overScroller.getCurrY() == overScroller.getFinalY()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (overScroller.isFinished() || ((z2 || i7 != 0) && (z3 || i8 != 0))) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                SmoothScroller smoothScroller2 = RecyclerView.this.mLayout.mSmoothScroller;
                if (smoothScroller2 == null || !smoothScroller2.isPendingInitialRun()) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (z5 || !z4) {
                    d();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    GapWorker gapWorker = recyclerView7.mGapWorker;
                    if (gapWorker != null) {
                        gapWorker.f(recyclerView7, i2, i3);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i7 < 0) {
                            i4 = -currVelocity;
                        } else if (i7 > 0) {
                            i4 = currVelocity;
                        } else {
                            i4 = 0;
                        }
                        if (i8 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i8 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i4, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.b();
                    }
                }
            }
            SmoothScroller smoothScroller3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (smoothScroller3 != null && smoothScroller3.isPendingInitialRun()) {
                smoothScroller3.onAnimation(0, 0);
            }
            this.f11294f = false;
            if (this.f11295g) {
                c();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }
    }

    public static abstract class ViewHolder {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        Adapter<? extends ViewHolder> mBindingAdapter;
        int mFlags;
        boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        long mItemId = -1;
        int mItemViewType = -1;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition = -1;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads = null;
        int mPendingAccessibilityState = -1;
        int mPosition = -1;
        int mPreLayoutPosition = -1;
        Recycler mScrapContainer = null;
        ViewHolder mShadowedHolder = null;
        ViewHolder mShadowingHolder = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public ViewHolder(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        /* access modifiers changed from: package-private */
        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        /* access modifiers changed from: package-private */
        public void addFlags(int i2) {
            this.mFlags = i2 | this.mFlags;
        }

        /* access modifiers changed from: package-private */
        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        /* access modifiers changed from: package-private */
        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        /* access modifiers changed from: package-private */
        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        /* access modifiers changed from: package-private */
        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        /* access modifiers changed from: package-private */
        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && ViewCompat.S(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public void flagRemovedAndOffsetPosition(int i2, int i3, boolean z2) {
            addFlags(8);
            offsetPosition(i3, z2);
            this.mPosition = i2;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final Adapter<? extends ViewHolder> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            Adapter adapter;
            int adapterPositionInRecyclerView;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i2 = this.mPreLayoutPosition;
            return i2 == -1 ? this.mPosition : i2;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i2 = this.mPreLayoutPosition;
            return i2 == -1 ? this.mPosition : i2;
        }

        /* access modifiers changed from: package-private */
        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        /* access modifiers changed from: package-private */
        public boolean hasAnyOfTheFlags(int i2) {
            return (i2 & this.mFlags) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        /* access modifiers changed from: package-private */
        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) != 0 || ViewCompat.S(this.itemView)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        /* access modifiers changed from: package-private */
        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public void offsetPosition(int i2, boolean z2) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z2) {
                this.mPreLayoutPosition += i2;
            }
            this.mPosition += i2;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).f11246c = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i2 = this.mPendingAccessibilityState;
            if (i2 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i2;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.B(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        /* access modifiers changed from: package-private */
        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        /* access modifiers changed from: package-private */
        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        /* access modifiers changed from: package-private */
        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* access modifiers changed from: package-private */
        public void setFlags(int i2, int i3) {
            this.mFlags = (i2 & i3) | (this.mFlags & (~i3));
        }

        public final void setIsRecyclable(boolean z2) {
            int i2;
            int i3 = this.mIsRecyclableCount;
            if (z2) {
                i2 = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
            this.mIsRecyclableCount = i2;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z2 && i2 == 1) {
                this.mFlags |= 16;
            } else if (z2 && i2 == 0) {
                this.mFlags &= -17;
            }
        }

        /* access modifiers changed from: package-private */
        public void setScrapContainer(Recycler recycler, boolean z2) {
            this.mScrapContainer = recycler;
            this.mInChangeScrap = z2;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        /* access modifiers changed from: package-private */
        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            String str;
            String str2;
            if (getClass().isAnonymousClass()) {
                str = "ViewHolder";
            } else {
                str = getClass().getSimpleName();
            }
            StringBuilder sb = new StringBuilder(str + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                if (this.mInChangeScrap) {
                    str2 = "[changeScrap]";
                } else {
                    str2 = "[attachedScrap]";
                }
                sb.append(str2);
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public void unScrap() {
            this.mScrapContainer.O(this);
        }

        /* access modifiers changed from: package-private */
        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            int[] r1 = new int[r0]
            r2 = 16843830(0x1010436, float:2.369658E-38)
            r3 = 0
            r1[r3] = r2
            NESTED_SCROLLING_ATTRS = r1
            r1 = 4605200834963974390(0x3fe8f5c28f5c28f6, double:0.78)
            double r1 = java.lang.Math.log(r1)
            r4 = 4606281698874543309(0x3feccccccccccccd, double:0.9)
            double r4 = java.lang.Math.log(r4)
            double r1 = r1 / r4
            float r1 = (float) r1
            DECELERATION_RATE = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            FORCE_INVALIDATE_DISPLAY_LIST = r3
            r2 = 23
            if (r1 < r2) goto L_0x002b
            r1 = 1
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            ALLOW_SIZE_IN_UNSPECIFIED_SPEC = r1
            POST_UPDATES_ON_ANIMATION = r0
            ALLOW_THREAD_GAP_WORK = r0
            FORCE_ABS_FOCUS_SEARCH_DIRECTION = r3
            IGNORE_DETACHED_FOCUSED_CHILD = r3
            r1 = 4
            java.lang.Class[] r1 = new java.lang.Class[r1]
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r1[r3] = r2
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r1[r0] = r2
            java.lang.Class r0 = java.lang.Integer.TYPE
            r2 = 2
            r1[r2] = r0
            r2 = 3
            r1[r2] = r0
            LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = r1
            androidx.recyclerview.widget.RecyclerView$3 r0 = new androidx.recyclerview.widget.RecyclerView$3
            r0.<init>()
            sQuinticInterpolator = r0
            androidx.recyclerview.widget.RecyclerView$StretchEdgeEffectFactory r0 = new androidx.recyclerview.widget.RecyclerView$StretchEdgeEffectFactory
            r0.<init>()
            sDefaultEdgeEffectFactory = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<clinit>():void");
    }

    public RecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        boolean z2;
        View view = viewHolder.itemView;
        if (view.getParent() == this) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mRecycler.O(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.c(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.mChildHelper.b(view, true);
        } else {
            this.mChildHelper.k(view);
        }
    }

    private void animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z2, boolean z3) {
        viewHolder.setIsRecyclable(false);
        if (z2) {
            addAnimatingView(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z3) {
                addAnimatingView(viewHolder2);
            }
            viewHolder.mShadowedHolder = viewHolder2;
            addAnimatingView(viewHolder);
            this.mRecycler.O(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.mShadowingHolder = viewHolder;
        }
        if (this.mItemAnimator.b(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    static void clearNestedRecyclerViewIfNotNested(ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.mNestedRecyclerView;
        if (weakReference != null) {
            View view = weakReference.get();
            while (view != null) {
                if (view != viewHolder.itemView) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof View) {
                        view = (View) parent;
                    } else {
                        view = null;
                    }
                } else {
                    return;
                }
            }
            viewHolder.mNestedRecyclerView = null;
        }
    }

    private int consumeFlingInStretch(int i2, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i3) {
        if (i2 > 0 && edgeEffect != null && EdgeEffectCompat.b(edgeEffect) != DECELERATION_RATE) {
            int round = Math.round((((float) (-i3)) / FLING_DESTRETCH_FACTOR) * EdgeEffectCompat.d(edgeEffect, (((float) (-i2)) * FLING_DESTRETCH_FACTOR) / ((float) i3), 0.5f));
            if (round != i2) {
                edgeEffect.finish();
            }
            return i2 - round;
        } else if (i2 >= 0 || edgeEffect2 == null || EdgeEffectCompat.b(edgeEffect2) == DECELERATION_RATE) {
            return i2;
        } else {
            float f2 = (float) i3;
            int round2 = Math.round((f2 / FLING_DESTRETCH_FACTOR) * EdgeEffectCompat.d(edgeEffect2, (((float) i2) * FLING_DESTRETCH_FACTOR) / f2, 0.5f));
            if (round2 != i2) {
                edgeEffect2.finish();
            }
            return i2 - round2;
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Object[] objArr;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(LayoutManager.class);
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                    } catch (NoSuchMethodException e2) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e3) {
                    e3.initCause(e2);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e4);
                } catch (InvocationTargetException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e6);
                } catch (IllegalAccessException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e7);
                } catch (ClassCastException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e8);
                }
            }
        }
    }

    private boolean didChildRangeChange(int i2, int i3) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        if (iArr[0] == i2 && iArr[1] == i3) {
            return false;
        }
        return true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i2 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i2 != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            AccessibilityEventCompat.b(obtain, i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void dispatchLayoutStep1() {
        boolean z2 = true;
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f11282j = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.f();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State state = this.mState;
        if (!state.f11283k || !this.mItemsChanged) {
            z2 = false;
        }
        state.f11281i = z2;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        state.f11280h = state.f11284l;
        state.f11278f = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f11283k) {
            int g2 = this.mChildHelper.g();
            for (int i2 = 0; i2 < g2; i2++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i2));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.e(childViewHolderInt, this.mItemAnimator.t(this.mState, childViewHolderInt, ItemAnimator.e(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.f11281i && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.c(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f11284l) {
            saveOldPositions();
            State state2 = this.mState;
            boolean z3 = state2.f11279g;
            state2.f11279g = false;
            this.mLayout.onLayoutChildren(this.mRecycler, state2);
            this.mState.f11279g = z3;
            for (int i3 = 0; i3 < this.mChildHelper.g(); i3++) {
                ViewHolder childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.f(i3));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.i(childViewHolderInt2)) {
                    int e2 = ItemAnimator.e(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        e2 |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
                    }
                    ItemAnimator.ItemHolderInfo t2 = this.mItemAnimator.t(this.mState, childViewHolderInt2, e2, childViewHolderInt2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, t2);
                    } else {
                        this.mViewInfoStore.a(childViewHolderInt2, t2);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f11277e = 2;
    }

    private void dispatchLayoutStep2() {
        boolean z2;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.j();
        this.mState.f11278f = this.mAdapter.getItemCount();
        this.mState.f11276d = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            Parcelable parcelable = this.mPendingSavedState.f11265d;
            if (parcelable != null) {
                this.mLayout.onRestoreInstanceState(parcelable);
            }
            this.mPendingSavedState = null;
        }
        State state = this.mState;
        state.f11280h = false;
        this.mLayout.onLayoutChildren(this.mRecycler, state);
        State state2 = this.mState;
        state2.f11279g = false;
        if (!state2.f11283k || this.mItemAnimator == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        state2.f11283k = z2;
        state2.f11277e = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        State state = this.mState;
        state.f11277e = 1;
        if (state.f11283k) {
            for (int g2 = this.mChildHelper.g() - 1; g2 >= 0; g2--) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(g2));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    ItemAnimator.ItemHolderInfo s2 = this.mItemAnimator.s(this.mState, childViewHolderInt);
                    ViewHolder g3 = this.mViewInfoStore.g(changedHolderKey);
                    if (g3 == null || g3.shouldIgnore()) {
                        this.mViewInfoStore.d(childViewHolderInt, s2);
                    } else {
                        boolean h2 = this.mViewInfoStore.h(g3);
                        boolean h3 = this.mViewInfoStore.h(childViewHolderInt);
                        if (!h2 || g3 != childViewHolderInt) {
                            ItemAnimator.ItemHolderInfo n2 = this.mViewInfoStore.n(g3);
                            this.mViewInfoStore.d(childViewHolderInt, s2);
                            ItemAnimator.ItemHolderInfo m2 = this.mViewInfoStore.m(childViewHolderInt);
                            if (n2 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, g3);
                            } else {
                                animateChange(g3, childViewHolderInt, n2, m2, h2, h3);
                            }
                        } else {
                            this.mViewInfoStore.d(childViewHolderInt, s2);
                        }
                    }
                }
            }
            this.mViewInfoStore.o(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        State state2 = this.mState;
        state2.f11275c = state2.f11278f;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        state2.f11283k = false;
        state2.f11284l = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<ViewHolder> arrayList = this.mRecycler.f11256b;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager.mPrefetchMaxObservedInInitialPrefetch) {
            layoutManager.mPrefetchMaxCountObserved = 0;
            layoutManager.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.P();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.f();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        OnItemTouchListener onItemTouchListener = this.mInterceptingOnItemTouchListener;
        if (onItemTouchListener != null) {
            onItemTouchListener.a(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mInterceptingOnItemTouchListener = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return findInterceptingOnItemTouchListener(motionEvent);
        }
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        int i2 = 0;
        while (i2 < size) {
            OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(i2);
            if (!onItemTouchListener.b(this, motionEvent) || action == 3) {
                i2++;
            } else {
                this.mInterceptingOnItemTouchListener = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int g2 = this.mChildHelper.g();
        if (g2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < g2; i4++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i4));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i2));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    private View findNextViewToFocus() {
        ViewHolder findViewHolderForAdapterPosition;
        State state = this.mState;
        int i2 = state.f11285m;
        if (i2 == -1) {
            i2 = 0;
        }
        int b2 = state.b();
        int i3 = i2;
        while (i3 < b2) {
            ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            } else {
                i3++;
            }
        }
        int min = Math.min(b2, i2);
        while (true) {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            }
        }
    }

    static ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f11244a;
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f11245b;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }

    private float getSplineFlingDistance(int i2) {
        double log = Math.log((double) ((((float) Math.abs(i2)) * INFLEXION) / (this.mPhysicalCoef * SCROLL_FRICTION)));
        float f2 = DECELERATION_RATE;
        return (float) (((double) (this.mPhysicalCoef * SCROLL_FRICTION)) * Math.exp((((double) f2) / (((double) f2) - 1.0d)) * log));
    }

    private void handleMissingPreInfoForChangeError(long j2, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int g2 = this.mChildHelper.g();
        for (int i2 = 0; i2 < g2; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i2));
            if (childViewHolderInt != viewHolder && getChangedHolderKey(childViewHolderInt) == j2) {
                Adapter adapter = this.mAdapter;
                if (adapter == null || !adapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int g2 = this.mChildHelper.g();
        for (int i2 = 0; i2 < g2; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (ViewCompat.C(this) == 0) {
            ViewCompat.D0(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new ChildHelper.Callback() {
            public void a(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
                }
            }

            public ViewHolder b(View view) {
                return RecyclerView.getChildViewHolderInt(view);
            }

            public void c(int i2) {
                ViewHolder childViewHolderInt;
                View childAt = getChildAt(i2);
                if (!(childAt == null || (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) == null)) {
                    if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                        childViewHolderInt.addFlags(UserVerificationMethods.USER_VERIFY_HANDPRINT);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                }
                RecyclerView.this.detachViewFromParent(i2);
            }

            public void d(View view, int i2) {
                RecyclerView.this.addView(view, i2);
                RecyclerView.this.dispatchChildAttached(view);
            }

            public void e() {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            public int f(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            public void g(View view) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                }
            }

            public View getChildAt(int i2) {
                return RecyclerView.this.getChildAt(i2);
            }

            public int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            public void h(int i2) {
                View childAt = RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    RecyclerView.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i2);
            }

            public void i(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                        childViewHolderInt.clearTmpDetachFlag();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                }
                RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }
        });
    }

    private boolean isPreferredNextFocus(View view, View view2, int i2) {
        int i3;
        int i4;
        if (view2 == null || view2 == this || view2 == view || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c2 = 65535;
        if (this.mLayout.getLayoutDirection() == 1) {
            i3 = -1;
        } else {
            i3 = 1;
        }
        Rect rect = this.mTempRect;
        int i5 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i6 = rect2.left;
        if ((i5 < i6 || rect.right <= i6) && rect.right < rect2.right) {
            i4 = 1;
        } else {
            int i7 = rect.right;
            int i8 = rect2.right;
            if ((i7 > i8 || i5 >= i8) && i5 > i6) {
                i4 = -1;
            } else {
                i4 = 0;
            }
        }
        int i9 = rect.top;
        int i10 = rect2.top;
        if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
            c2 = 1;
        } else {
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            if ((i11 <= i12 && i9 < i12) || i9 <= i10) {
                c2 = 0;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 17) {
                    if (i2 != 33) {
                        if (i2 != 66) {
                            if (i2 != 130) {
                                throw new IllegalArgumentException("Invalid direction: " + i2 + exceptionLabel());
                            } else if (c2 > 0) {
                                return true;
                            } else {
                                return false;
                            }
                        } else if (i4 > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (c2 < 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i4 < 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (c2 > 0 || (c2 == 0 && i4 * i3 > 0)) {
                return true;
            } else {
                return false;
            }
        } else if (c2 < 0 || (c2 == 0 && i4 * i3 < 0)) {
            return true;
        } else {
            return false;
        }
    }

    private void nestedScrollByInternal(int i2, int i3, MotionEvent motionEvent, int i4) {
        boolean z2;
        float f2;
        float f3;
        int i5;
        int i6;
        int i7;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            int[] iArr = this.mReusableIntPair;
            int i8 = 0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollVertically) {
                z2 = canScrollHorizontally | true;
            } else {
                z2 = canScrollHorizontally;
            }
            if (motionEvent == null) {
                f2 = ((float) getHeight()) / 2.0f;
            } else {
                f2 = motionEvent.getY();
            }
            if (motionEvent == null) {
                f3 = ((float) getWidth()) / 2.0f;
            } else {
                f3 = motionEvent.getX();
            }
            int releaseHorizontalGlow = i2 - releaseHorizontalGlow(i2, f2);
            int releaseVerticalGlow = i3 - releaseVerticalGlow(i3, f3);
            startNestedScroll(z2 ? 1 : 0, i4);
            if (canScrollHorizontally) {
                i5 = releaseHorizontalGlow;
            } else {
                i5 = 0;
            }
            if (canScrollVertically) {
                i6 = releaseVerticalGlow;
            } else {
                i6 = 0;
            }
            if (dispatchNestedPreScroll(i5, i6, this.mReusableIntPair, this.mScrollOffset, i4)) {
                int[] iArr2 = this.mReusableIntPair;
                releaseHorizontalGlow -= iArr2[0];
                releaseVerticalGlow -= iArr2[1];
            }
            if (canScrollHorizontally) {
                i7 = releaseHorizontalGlow;
            } else {
                i7 = 0;
            }
            if (canScrollVertically) {
                i8 = releaseVerticalGlow;
            }
            scrollByInternal(i7, i8, motionEvent, i4);
            GapWorker gapWorker = this.mGapWorker;
            if (!(gapWorker == null || (releaseHorizontalGlow == 0 && releaseVerticalGlow == 0))) {
                gapWorker.f(this, releaseHorizontalGlow, releaseVerticalGlow);
            }
            stopNestedScroll(i4);
        }
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int i2;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            if (actionIndex == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.mScrollPointerId = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z2;
        boolean z3;
        boolean z4;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.y();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.w();
        } else {
            this.mAdapterHelper.j();
        }
        boolean z5 = false;
        if (this.mItemsAddedOrRemoved || this.mItemsChanged) {
            z2 = true;
        } else {
            z2 = false;
        }
        State state = this.mState;
        if (!this.mFirstLayoutComplete || this.mItemAnimator == null || ((!(z4 = this.mDataSetHasChangedAfterLayout) && !z2 && !this.mLayout.mRequestedSimpleAnimations) || (z4 && !this.mAdapter.hasStableIds()))) {
            z3 = false;
        } else {
            z3 = true;
        }
        state.f11283k = z3;
        State state2 = this.mState;
        if (state2.f11283k && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z5 = true;
        }
        state2.f11284l = z5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0021
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r3 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.EdgeEffectCompat.d(r3, r4, r9)
        L_0x001f:
            r9 = 1
            goto L_0x003c
        L_0x0021:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x003b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r3 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.EdgeEffectCompat.d(r3, r4, r9)
            goto L_0x001f
        L_0x003b:
            r9 = 0
        L_0x003c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0056
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.EdgeEffectCompat.d(r9, r0, r7)
            goto L_0x0072
        L_0x0056:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0071
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.EdgeEffectCompat.d(r9, r3, r0)
            goto L_0x0072
        L_0x0071:
            r1 = r9
        L_0x0072:
            if (r1 != 0) goto L_0x007c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x007c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x007f
        L_0x007c:
            androidx.core.view.ViewCompat.i0(r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void recoverFocusFromState() {
        ViewHolder viewHolder;
        View findViewById;
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.mChildHelper.n(focusedChild)) {
                            return;
                        }
                    } else if (this.mChildHelper.g() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                if (this.mState.f11286n == -1 || !this.mAdapter.hasStableIds()) {
                    viewHolder = null;
                } else {
                    viewHolder = findViewHolderForItemId(this.mState.f11286n);
                }
                if (viewHolder != null && !this.mChildHelper.n(viewHolder.itemView) && viewHolder.itemView.hasFocusable()) {
                    view = viewHolder.itemView;
                } else if (this.mChildHelper.g() > 0) {
                    view = findNextViewToFocus();
                }
                if (view != null) {
                    int i2 = this.mState.f11287o;
                    if (!(((long) i2) == -1 || (findViewById = view.findViewById(i2)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void releaseGlows() {
        boolean z2;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.mLeftGlow.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.mBottomGlow.isFinished();
        }
        if (z2) {
            ViewCompat.i0(this);
        }
    }

    private int releaseHorizontalGlow(int i2, float f2) {
        float height = f2 / ((float) getHeight());
        float width = ((float) i2) / ((float) getWidth());
        EdgeEffect edgeEffect = this.mLeftGlow;
        float f3 = DECELERATION_RATE;
        if (edgeEffect == null || EdgeEffectCompat.b(edgeEffect) == DECELERATION_RATE) {
            EdgeEffect edgeEffect2 = this.mRightGlow;
            if (!(edgeEffect2 == null || EdgeEffectCompat.b(edgeEffect2) == DECELERATION_RATE)) {
                if (canScrollHorizontally(1)) {
                    this.mRightGlow.onRelease();
                } else {
                    float d2 = EdgeEffectCompat.d(this.mRightGlow, width, height);
                    if (EdgeEffectCompat.b(this.mRightGlow) == DECELERATION_RATE) {
                        this.mRightGlow.onRelease();
                    }
                    f3 = d2;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.mLeftGlow.onRelease();
            } else {
                float f4 = -EdgeEffectCompat.d(this.mLeftGlow, -width, 1.0f - height);
                if (EdgeEffectCompat.b(this.mLeftGlow) == DECELERATION_RATE) {
                    this.mLeftGlow.onRelease();
                }
                f3 = f4;
            }
            invalidate();
        }
        return Math.round(f3 * ((float) getWidth()));
    }

    private int releaseVerticalGlow(int i2, float f2) {
        float width = f2 / ((float) getWidth());
        float height = ((float) i2) / ((float) getHeight());
        EdgeEffect edgeEffect = this.mTopGlow;
        float f3 = DECELERATION_RATE;
        if (edgeEffect == null || EdgeEffectCompat.b(edgeEffect) == DECELERATION_RATE) {
            EdgeEffect edgeEffect2 = this.mBottomGlow;
            if (!(edgeEffect2 == null || EdgeEffectCompat.b(edgeEffect2) == DECELERATION_RATE)) {
                if (canScrollVertically(1)) {
                    this.mBottomGlow.onRelease();
                } else {
                    float d2 = EdgeEffectCompat.d(this.mBottomGlow, height, 1.0f - width);
                    if (EdgeEffectCompat.b(this.mBottomGlow) == DECELERATION_RATE) {
                        this.mBottomGlow.onRelease();
                    }
                    f3 = d2;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.mTopGlow.onRelease();
            } else {
                float f4 = -EdgeEffectCompat.d(this.mTopGlow, -height, width);
                if (EdgeEffectCompat.b(this.mTopGlow) == DECELERATION_RATE) {
                    this.mTopGlow.onRelease();
                }
                f3 = f4;
            }
            invalidate();
        }
        return Math.round(f3 * ((float) getHeight()));
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3;
        boolean z2;
        if (view2 != null) {
            view3 = view2;
        } else {
            view3 = view;
        }
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f11246c) {
                Rect rect = layoutParams2.f11245b;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        LayoutManager layoutManager = this.mLayout;
        Rect rect3 = this.mTempRect;
        boolean z3 = !this.mFirstLayoutComplete;
        if (view2 == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        layoutManager.requestChildRectangleOnScreen(this, view, rect3, z3, z2);
    }

    private void resetFocusInfo() {
        State state = this.mState;
        state.f11286n = -1;
        state.f11285m = -1;
        state.f11287o = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        View view;
        long j2;
        int i2;
        ViewHolder viewHolder = null;
        if (!this.mPreserveFocusAfterLayout || !hasFocus() || this.mAdapter == null) {
            view = null;
        } else {
            view = getFocusedChild();
        }
        if (view != null) {
            viewHolder = findContainingViewHolder(view);
        }
        if (viewHolder == null) {
            resetFocusInfo();
            return;
        }
        State state = this.mState;
        if (this.mAdapter.hasStableIds()) {
            j2 = viewHolder.getItemId();
        } else {
            j2 = -1;
        }
        state.f11286n = j2;
        State state2 = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            i2 = -1;
        } else if (viewHolder.isRemoved()) {
            i2 = viewHolder.mOldPosition;
        } else {
            i2 = viewHolder.getAbsoluteAdapterPosition();
        }
        state2.f11285m = i2;
        this.mState.f11287o = getDeepestFocusedViewWithId(viewHolder.itemView);
    }

    private void setAdapterInternal(Adapter<?> adapter, boolean z2, boolean z3) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z2 || z3) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.y();
        Adapter adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(adapter3, this.mAdapter);
        }
        this.mRecycler.y(adapter3, this.mAdapter, z2);
        this.mState.f11279g = true;
    }

    private boolean shouldAbsorb(EdgeEffect edgeEffect, int i2, int i3) {
        if (i2 > 0) {
            return true;
        }
        if (getSplineFlingDistance(-i2) < EdgeEffectCompat.b(edgeEffect) * ((float) i3)) {
            return true;
        }
        return false;
    }

    private boolean stopGlowAnimations(MotionEvent motionEvent) {
        boolean z2;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || EdgeEffectCompat.b(edgeEffect) == DECELERATION_RATE || canScrollHorizontally(-1)) {
            z2 = false;
        } else {
            EdgeEffectCompat.d(this.mLeftGlow, DECELERATION_RATE, 1.0f - (motionEvent.getY() / ((float) getHeight())));
            z2 = true;
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (!(edgeEffect2 == null || EdgeEffectCompat.b(edgeEffect2) == DECELERATION_RATE || canScrollHorizontally(1))) {
            EdgeEffectCompat.d(this.mRightGlow, DECELERATION_RATE, motionEvent.getY() / ((float) getHeight()));
            z2 = true;
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (!(edgeEffect3 == null || EdgeEffectCompat.b(edgeEffect3) == DECELERATION_RATE || canScrollVertically(-1))) {
            EdgeEffectCompat.d(this.mTopGlow, DECELERATION_RATE, motionEvent.getX() / ((float) getWidth()));
            z2 = true;
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 == null || EdgeEffectCompat.b(edgeEffect4) == DECELERATION_RATE || canScrollVertically(1)) {
            return z2;
        }
        EdgeEffectCompat.d(this.mBottomGlow, DECELERATION_RATE, 1.0f - (motionEvent.getX() / ((float) getWidth())));
        return true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.f();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.stopSmoothScroller();
        }
    }

    /* access modifiers changed from: package-private */
    public void absorbGlows(int i2, int i3) {
        if (i2 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i3);
            }
        }
        if (i2 != 0 || i3 != 0) {
            ViewCompat.i0(this);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.mItemDecorations.add(itemDecoration);
        } else {
            this.mItemDecorations.add(i2, itemDecoration);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    public void addRecyclerListener(RecyclerListener recyclerListener) {
        boolean z2;
        if (recyclerListener != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.b(z2, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(recyclerListener);
    }

    /* access modifiers changed from: package-private */
    public void animateAppearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.a(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    /* access modifiers changed from: package-private */
    public void animateDisappearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.c(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    /* access modifiers changed from: package-private */
    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    /* access modifiers changed from: package-private */
    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator == null || itemAnimator.g(viewHolder, viewHolder.getUnmodifiedPayloads())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void clearOldPositions() {
        int j2 = this.mChildHelper.j();
        for (int i2 = 0; i2 < j2; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.d();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void considerReleasingGlowsOnScroll(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.mLeftGlow.onRelease();
            z2 = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.mRightGlow.onRelease();
            z2 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.mTopGlow.onRelease();
            z2 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.mBottomGlow.onRelease();
            z2 |= this.mBottomGlow.isFinished();
        }
        if (z2) {
            ViewCompat.i0(this);
        }
    }

    /* access modifiers changed from: package-private */
    public int consumeFlingInHorizontalStretch(int i2) {
        return consumeFlingInStretch(i2, this.mLeftGlow, this.mRightGlow, getWidth());
    }

    /* access modifiers changed from: package-private */
    public int consumeFlingInVerticalStretch(int i2) {
        return consumeFlingInStretch(i2, this.mTopGlow, this.mBottomGlow, getHeight());
    }

    /* access modifiers changed from: package-private */
    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            TraceCompat.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            TraceCompat.b();
        } else if (this.mAdapterHelper.p()) {
            if (this.mAdapterHelper.o(4) && !this.mAdapterHelper.o(11)) {
                TraceCompat.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.w();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.i();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                TraceCompat.b();
            } else if (this.mAdapterHelper.p()) {
                TraceCompat.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                TraceCompat.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void defaultOnMeasure(int i2, int i3) {
        setMeasuredDimension(LayoutManager.chooseSize(i2, getPaddingLeft() + getPaddingRight(), ViewCompat.F(this)), LayoutManager.chooseSize(i3, getPaddingTop() + getPaddingBottom(), ViewCompat.E(this)));
    }

    /* access modifiers changed from: package-private */
    public void dispatchChildAttached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.mAdapter;
        if (!(adapter == null || childViewHolderInt == null)) {
            adapter.onViewAttachedToWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).b(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchChildDetached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.mAdapter;
        if (!(adapter == null || childViewHolderInt == null)) {
            adapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).a(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchLayout() {
        boolean z2;
        if (this.mAdapter == null) {
            Log.w(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
        } else {
            this.mState.f11282j = false;
            if (!this.mLastAutoMeasureSkippedDueToExact || (this.mLastAutoMeasureNonExactMeasuredWidth == getWidth() && this.mLastAutoMeasureNonExactMeasuredHeight == getHeight())) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.mLastAutoMeasureNonExactMeasuredWidth = 0;
            this.mLastAutoMeasureNonExactMeasuredHeight = 0;
            this.mLastAutoMeasureSkippedDueToExact = false;
            if (this.mState.f11277e == 1) {
                dispatchLayoutStep1();
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else if (this.mAdapterHelper.q() || z2 || this.mLayout.getWidth() != getWidth() || this.mLayout.getHeight() != getHeight()) {
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else {
                this.mLayout.setExactMeasureSpecsFrom(this);
            }
            dispatchLayoutStep3();
        }
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().f(i2, i3, i4, i5, iArr);
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnScrollStateChanged(int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(i2);
        }
        onScrollStateChanged(i2);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i2);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnScrolled(int i2, int i3) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        onScrolled(i2, i3);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i2, i3);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i2, i3);
            }
        }
        this.mDispatchScrollCounter--;
    }

    /* access modifiers changed from: package-private */
    public void dispatchPendingImportantForAccessibilityChanges() {
        int i2;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.mPendingAccessibilityImportanceChange.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (i2 = viewHolder.mPendingAccessibilityState) != -1) {
                ViewCompat.C0(viewHolder.itemView, i2);
                viewHolder.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        int i3;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z5 = false;
        for (int i4 = 0; i4 < size; i4++) {
            this.mItemDecorations.get(i4).i(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z6 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            if (this.mClipToPadding) {
                i3 = getPaddingBottom();
            } else {
                i3 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + i3), DECELERATION_RATE);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            if (edgeEffect2 == null || !edgeEffect2.draw(canvas)) {
                z2 = false;
            } else {
                z2 = true;
            }
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            if (edgeEffect4 == null || !edgeEffect4.draw(canvas)) {
                z4 = false;
            } else {
                z4 = true;
            }
            z2 |= z4;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.mClipToPadding) {
                i2 = getPaddingTop();
            } else {
                i2 = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) i2, (float) (-width));
            EdgeEffect edgeEffect6 = this.mRightGlow;
            if (edgeEffect6 == null || !edgeEffect6.draw(canvas)) {
                z3 = false;
            } else {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z5 = true;
            }
            z2 |= z5;
            canvas.restoreToCount(save4);
        }
        if (z2 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.p()) {
            z6 = z2;
        }
        if (z6) {
            ViewCompat.i0(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    /* access modifiers changed from: package-private */
    public void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            EdgeEffect a2 = this.mEdgeEffectFactory.a(this, 3);
            this.mBottomGlow = a2;
            if (this.mClipToPadding) {
                a2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a2.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            EdgeEffect a2 = this.mEdgeEffectFactory.a(this, 0);
            this.mLeftGlow = a2;
            if (this.mClipToPadding) {
                a2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a2.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureRightGlow() {
        if (this.mRightGlow == null) {
            EdgeEffect a2 = this.mEdgeEffectFactory.a(this, 2);
            this.mRightGlow = a2;
            if (this.mClipToPadding) {
                a2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a2.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureTopGlow() {
        if (this.mTopGlow == null) {
            EdgeEffect a2 = this.mEdgeEffectFactory.a(this, 1);
            this.mTopGlow = a2;
            if (this.mClipToPadding) {
                a2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a2.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    /* access modifiers changed from: package-private */
    public final void fillRemainingScrollValues(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.f11292d;
            state.f11288p = overScroller.getFinalX() - overScroller.getCurrX();
            state.f11289q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        state.f11288p = 0;
        state.f11289q = 0;
    }

    public View findChildViewUnder(float f2, float f3) {
        for (int g2 = this.mChildHelper.g() - 1; g2 >= 0; g2--) {
            View f4 = this.mChildHelper.f(g2);
            float translationX = f4.getTranslationX();
            float translationY = f4.getTranslationY();
            if (f2 >= ((float) f4.getLeft()) + translationX && f2 <= ((float) f4.getRight()) + translationX && f3 >= ((float) f4.getTop()) + translationY && f3 <= ((float) f4.getBottom()) + translationY) {
                return f4;
            }
        }
        return null;
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public ViewHolder findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public ViewHolder findViewHolderForAdapterPosition(int i2) {
        ViewHolder viewHolder = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int j2 = this.mChildHelper.j();
        for (int i3 = 0; i3 < j2; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i2) {
                if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j2) {
        Adapter adapter = this.mAdapter;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int j3 = this.mChildHelper.j();
            for (int i2 = 0; i2 < j3; i2++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i2));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j2) {
                    if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    viewHolder = childViewHolderInt;
                }
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForLayoutPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean fling(int r8, int r9) {
        /*
            r7 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r7.mLayout
            r1 = 0
            if (r0 != 0) goto L_0x000d
            java.lang.String r8 = "RecyclerView"
            java.lang.String r9 = "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument."
            android.util.Log.e(r8, r9)
            return r1
        L_0x000d:
            boolean r2 = r7.mLayoutSuppressed
            if (r2 == 0) goto L_0x0012
            return r1
        L_0x0012:
            boolean r0 = r0.canScrollHorizontally()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r7.mLayout
            boolean r2 = r2.canScrollVertically()
            if (r0 == 0) goto L_0x0026
            int r3 = java.lang.Math.abs(r8)
            int r4 = r7.mMinFlingVelocity
            if (r3 >= r4) goto L_0x0027
        L_0x0026:
            r8 = 0
        L_0x0027:
            if (r2 == 0) goto L_0x0031
            int r3 = java.lang.Math.abs(r9)
            int r4 = r7.mMinFlingVelocity
            if (r3 >= r4) goto L_0x0032
        L_0x0031:
            r9 = 0
        L_0x0032:
            if (r8 != 0) goto L_0x0037
            if (r9 != 0) goto L_0x0037
            return r1
        L_0x0037:
            r3 = 0
            if (r8 == 0) goto L_0x007a
            android.widget.EdgeEffect r4 = r7.mLeftGlow
            if (r4 == 0) goto L_0x005c
            float r4 = androidx.core.widget.EdgeEffectCompat.b(r4)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x005c
            android.widget.EdgeEffect r4 = r7.mLeftGlow
            int r5 = -r8
            int r6 = r7.getWidth()
            boolean r4 = r7.shouldAbsorb(r4, r5, r6)
            if (r4 == 0) goto L_0x0059
            android.widget.EdgeEffect r8 = r7.mLeftGlow
            r8.onAbsorb(r5)
        L_0x0058:
            r8 = 0
        L_0x0059:
            r4 = r8
            r8 = 0
            goto L_0x007b
        L_0x005c:
            android.widget.EdgeEffect r4 = r7.mRightGlow
            if (r4 == 0) goto L_0x007a
            float r4 = androidx.core.widget.EdgeEffectCompat.b(r4)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x007a
            android.widget.EdgeEffect r4 = r7.mRightGlow
            int r5 = r7.getWidth()
            boolean r4 = r7.shouldAbsorb(r4, r8, r5)
            if (r4 == 0) goto L_0x0059
            android.widget.EdgeEffect r4 = r7.mRightGlow
            r4.onAbsorb(r8)
            goto L_0x0058
        L_0x007a:
            r4 = 0
        L_0x007b:
            if (r9 == 0) goto L_0x00bc
            android.widget.EdgeEffect r5 = r7.mTopGlow
            if (r5 == 0) goto L_0x009e
            float r5 = androidx.core.widget.EdgeEffectCompat.b(r5)
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x009e
            android.widget.EdgeEffect r3 = r7.mTopGlow
            int r5 = -r9
            int r6 = r7.getHeight()
            boolean r3 = r7.shouldAbsorb(r3, r5, r6)
            if (r3 == 0) goto L_0x009c
            android.widget.EdgeEffect r9 = r7.mTopGlow
            r9.onAbsorb(r5)
        L_0x009b:
            r9 = 0
        L_0x009c:
            r3 = 0
            goto L_0x00be
        L_0x009e:
            android.widget.EdgeEffect r5 = r7.mBottomGlow
            if (r5 == 0) goto L_0x00bc
            float r5 = androidx.core.widget.EdgeEffectCompat.b(r5)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x00bc
            android.widget.EdgeEffect r3 = r7.mBottomGlow
            int r5 = r7.getHeight()
            boolean r3 = r7.shouldAbsorb(r3, r9, r5)
            if (r3 == 0) goto L_0x009c
            android.widget.EdgeEffect r3 = r7.mBottomGlow
            r3.onAbsorb(r9)
            goto L_0x009b
        L_0x00bc:
            r3 = r9
            r9 = 0
        L_0x00be:
            if (r4 != 0) goto L_0x00c2
            if (r9 == 0) goto L_0x00dd
        L_0x00c2:
            int r5 = r7.mMaxFlingVelocity
            int r6 = -r5
            int r4 = java.lang.Math.min(r4, r5)
            int r4 = java.lang.Math.max(r6, r4)
            int r5 = r7.mMaxFlingVelocity
            int r6 = -r5
            int r9 = java.lang.Math.min(r9, r5)
            int r9 = java.lang.Math.max(r6, r9)
            androidx.recyclerview.widget.RecyclerView$ViewFlinger r5 = r7.mViewFlinger
            r5.b(r4, r9)
        L_0x00dd:
            r5 = 1
            if (r8 != 0) goto L_0x00e8
            if (r3 != 0) goto L_0x00e8
            if (r4 != 0) goto L_0x00e6
            if (r9 == 0) goto L_0x00e7
        L_0x00e6:
            r1 = 1
        L_0x00e7:
            return r1
        L_0x00e8:
            float r9 = (float) r8
            float r4 = (float) r3
            boolean r6 = r7.dispatchNestedPreFling(r9, r4)
            if (r6 != 0) goto L_0x012b
            if (r0 != 0) goto L_0x00f7
            if (r2 == 0) goto L_0x00f5
            goto L_0x00f7
        L_0x00f5:
            r6 = 0
            goto L_0x00f8
        L_0x00f7:
            r6 = 1
        L_0x00f8:
            r7.dispatchNestedFling(r9, r4, r6)
            androidx.recyclerview.widget.RecyclerView$OnFlingListener r9 = r7.mOnFlingListener
            if (r9 == 0) goto L_0x0106
            boolean r9 = r9.a(r8, r3)
            if (r9 == 0) goto L_0x0106
            return r5
        L_0x0106:
            if (r6 == 0) goto L_0x012b
            if (r2 == 0) goto L_0x010c
            r0 = r0 | 2
        L_0x010c:
            r7.startNestedScroll(r0, r5)
            int r9 = r7.mMaxFlingVelocity
            int r0 = -r9
            int r8 = java.lang.Math.min(r8, r9)
            int r8 = java.lang.Math.max(r0, r8)
            int r9 = r7.mMaxFlingVelocity
            int r0 = -r9
            int r9 = java.lang.Math.min(r3, r9)
            int r9 = java.lang.Math.max(r0, r9)
            androidx.recyclerview.widget.RecyclerView$ViewFlinger r0 = r7.mViewFlinger
            r0.b(r8, r9)
            return r5
        L_0x012b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.fling(int, int):boolean");
    }

    public View focusSearch(View view, int i2) {
        boolean z2;
        View view2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i3;
        int i4;
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i2);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z6 = true;
        if (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) {
            z2 = false;
        } else {
            z2 = true;
        }
        FocusFinder instance = FocusFinder.getInstance();
        if (!z2 || !(i2 == 2 || i2 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus != null || !z2) {
                view2 = findNextFocus;
            } else {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
        } else {
            if (this.mLayout.canScrollVertically()) {
                if (i2 == 2) {
                    i4 = Sdk$SDKError.Reason.MRAID_DOWNLOAD_JS_ERROR_VALUE;
                } else {
                    i4 = 33;
                }
                if (instance.findNextFocus(this, view, i4) == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i4;
                }
            } else {
                z3 = false;
            }
            if (!z3 && this.mLayout.canScrollHorizontally()) {
                if (this.mLayout.getLayoutDirection() == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (i2 == 2) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z4 ^ z5) {
                    i3 = 66;
                } else {
                    i3 = 17;
                }
                if (instance.findNextFocus(this, view, i3) != null) {
                    z6 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i3;
                }
                z3 = z6;
            }
            if (z3) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = instance.findNextFocus(this, view, i2);
        }
        if (view2 == null || view2.hasFocusable()) {
            if (isPreferredNextFocus(view, view2, i2)) {
                return view2;
            }
            return super.focusSearch(view, i2);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        } else {
            requestChildOnScreen(view2, (View) null);
            return view;
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    /* access modifiers changed from: package-private */
    public int getAdapterPositionInRecyclerView(ViewHolder viewHolder) {
        if (viewHolder.hasAnyOfTheFlags(524) || !viewHolder.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.e(viewHolder.mPosition);
    }

    public int getBaseline() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: package-private */
    public long getChangedHolderKey(ViewHolder viewHolder) {
        return this.mAdapter.hasStableIds() ? viewHolder.getItemId() : (long) viewHolder.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        return super.getChildDrawingOrder(i2, i3);
    }

    public long getChildItemId(View view) {
        ViewHolder childViewHolderInt;
        Adapter adapter = this.mAdapter;
        if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    /* access modifiers changed from: package-private */
    public Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f11246c) {
            return layoutParams.f11245b;
        }
        if (this.mState.e() && (layoutParams.b() || layoutParams.d())) {
            return layoutParams.f11245b;
        }
        Rect rect = layoutParams.f11245b;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i2).e(this.mTempRect, view, this, this.mState);
            int i3 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f11246c = false;
        return rect;
    }

    public ItemDecoration getItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            return this.mItemDecorations.get(i2);
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0;
    }

    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.i();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    public boolean hasPendingAdapterUpdates() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.p()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback() {
            public void a(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForMove(i2, i3);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public void b(AdapterHelper.UpdateOp updateOp) {
                i(updateOp);
            }

            public void c(AdapterHelper.UpdateOp updateOp) {
                i(updateOp);
            }

            public void d(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForRemove(i2, i3, false);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public void e(int i2, int i3, Object obj) {
                RecyclerView.this.viewRangeUpdate(i2, i3, obj);
                RecyclerView.this.mItemsChanged = true;
            }

            public ViewHolder f(int i2) {
                ViewHolder findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i2, true);
                if (findViewHolderForPosition != null && !RecyclerView.this.mChildHelper.n(findViewHolderForPosition.itemView)) {
                    return findViewHolderForPosition;
                }
                return null;
            }

            public void g(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForInsert(i2, i3);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }

            public void h(int i2, int i3) {
                RecyclerView.this.offsetPositionRecordsForRemove(i2, i3, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.f11276d += i3;
            }

            /* access modifiers changed from: package-private */
            public void i(AdapterHelper.UpdateOp updateOp) {
                int i2 = updateOp.f10992a;
                if (i2 == 1) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.mLayout.onItemsAdded(recyclerView, updateOp.f10993b, updateOp.f10995d);
                } else if (i2 == 2) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.mLayout.onItemsRemoved(recyclerView2, updateOp.f10993b, updateOp.f10995d);
                } else if (i2 == 4) {
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.mLayout.onItemsUpdated(recyclerView3, updateOp.f10993b, updateOp.f10995d, updateOp.f10994c);
                } else if (i2 == 8) {
                    RecyclerView recyclerView4 = RecyclerView.this;
                    recyclerView4.mLayout.onItemsMoved(recyclerView4, updateOp.f10993b, updateOp.f10995d, 1);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
        Resources resources = getContext().getResources();
        new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R$dimen.f10968a), resources.getDimensionPixelSize(R$dimen.f10970c), resources.getDimensionPixelOffset(R$dimen.f10969b));
    }

    /* access modifiers changed from: package-private */
    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        return itemAnimator != null && itemAnimator.p();
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    /* access modifiers changed from: package-private */
    public void jumpToPositionForSmoothScroller(int i2) {
        if (this.mLayout != null) {
            setScrollState(2);
            this.mLayout.scrollToPosition(i2);
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: package-private */
    public void markItemDecorInsetsDirty() {
        int j2 = this.mChildHelper.j();
        for (int i2 = 0; i2 < j2; i2++) {
            ((LayoutParams) this.mChildHelper.i(i2).getLayoutParams()).f11246c = true;
        }
        this.mRecycler.s();
    }

    /* access modifiers changed from: package-private */
    public void markKnownViewsInvalid() {
        int j2 = this.mChildHelper.j();
        for (int i2 = 0; i2 < j2; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.t();
    }

    public void nestedScrollBy(int i2, int i3) {
        nestedScrollByInternal(i2, i3, (MotionEvent) null, 1);
    }

    public void offsetChildrenHorizontal(int i2) {
        int g2 = this.mChildHelper.g();
        for (int i3 = 0; i3 < g2; i3++) {
            this.mChildHelper.f(i3).offsetLeftAndRight(i2);
        }
    }

    public void offsetChildrenVertical(int i2) {
        int g2 = this.mChildHelper.g();
        for (int i3 = 0; i3 < g2; i3++) {
            this.mChildHelper.f(i3).offsetTopAndBottom(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForInsert(int i2, int i3) {
        int j2 = this.mChildHelper.j();
        for (int i4 = 0; i4 < j2; i4++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2) {
                childViewHolderInt.offsetPosition(i3, false);
                this.mState.f11279g = true;
            }
        }
        this.mRecycler.v(i2, i3);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForMove(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int j2 = this.mChildHelper.j();
        if (i2 < i3) {
            i6 = -1;
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i8 = 0; i8 < j2; i8++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i8));
            if (childViewHolderInt != null && (i7 = childViewHolderInt.mPosition) >= i5 && i7 <= i4) {
                if (i7 == i2) {
                    childViewHolderInt.offsetPosition(i3 - i2, false);
                } else {
                    childViewHolderInt.offsetPosition(i6, false);
                }
                this.mState.f11279g = true;
            }
        }
        this.mRecycler.w(i2, i3);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void offsetPositionRecordsForRemove(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int j2 = this.mChildHelper.j();
        for (int i5 = 0; i5 < j2; i5++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i5));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i6 = childViewHolderInt.mPosition;
                if (i6 >= i4) {
                    childViewHolderInt.offsetPosition(-i3, z2);
                    this.mState.f11279g = true;
                } else if (i6 >= i2) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i2 - 1, -i3, z2);
                    this.mState.f11279g = true;
                }
            }
        }
        this.mRecycler.x(i2, i3, z2);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r1 >= 30.0f) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.mLayoutOrScrollCounter = r0
            r1 = 1
            r5.mIsAttached = r1
            boolean r2 = r5.mFirstLayoutComplete
            if (r2 == 0) goto L_0x0014
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r5.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.RecyclerView$Recycler r1 = r5.mRecycler
            r1.z()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r5.mLayout
            if (r1 == 0) goto L_0x0023
            r1.dispatchAttachedToWindow(r5)
        L_0x0023:
            r5.mPostedAnimatorRunner = r0
            boolean r0 = ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L_0x0066
            java.lang.ThreadLocal<androidx.recyclerview.widget.GapWorker> r0 = androidx.recyclerview.widget.GapWorker.f11143f
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.GapWorker r1 = (androidx.recyclerview.widget.GapWorker) r1
            r5.mGapWorker = r1
            if (r1 != 0) goto L_0x0061
            androidx.recyclerview.widget.GapWorker r1 = new androidx.recyclerview.widget.GapWorker
            r1.<init>()
            r5.mGapWorker = r1
            android.view.Display r1 = androidx.core.view.ViewCompat.w(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L_0x0053
            if (r1 == 0) goto L_0x0053
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r1 = 1114636288(0x42700000, float:60.0)
        L_0x0055:
            androidx.recyclerview.widget.GapWorker r2 = r5.mGapWorker
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f11147d = r3
            r0.set(r2)
        L_0x0061:
            androidx.recyclerview.widget.GapWorker r0 = r5.mGapWorker
            r0.a(r5)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.k();
        }
        stopScroll();
        this.mIsAttached = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.j();
        this.mRecycler.A();
        PoolingContainer.b(this);
        if (ALLOW_THREAD_GAP_WORK && (gapWorker = this.mGapWorker) != null) {
            gapWorker.j(this);
            this.mGapWorker = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).g(canvas, this, this.mState);
        }
    }

    /* access modifiers changed from: package-private */
    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    /* access modifiers changed from: package-private */
    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                if (this.mLayout.canScrollVertically()) {
                    f3 = -motionEvent.getAxisValue(9);
                } else {
                    f3 = DECELERATION_RATE;
                }
                if (this.mLayout.canScrollHorizontally()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (!(f3 == DECELERATION_RATE && f2 == DECELERATION_RATE)) {
                        nestedScrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f3 * this.mScaledVerticalScrollFactor), motionEvent, 1);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.mLayout.canScrollVertically()) {
                        f3 = -axisValue;
                    } else if (this.mLayout.canScrollHorizontally()) {
                        f2 = axisValue;
                        f3 = DECELERATION_RATE;
                        nestedScrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f3 * this.mScaledVerticalScrollFactor), motionEvent, 1);
                    }
                }
                f3 = DECELERATION_RATE;
            }
            f2 = DECELERATION_RATE;
            nestedScrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f3 * this.mScaledVerticalScrollFactor), motionEvent, 1);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
            if (stopGlowAnimations(motionEvent) || this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            if (canScrollVertically) {
                canScrollHorizontally |= true;
            }
            startNestedScroll(canScrollHorizontally ? 1 : 0, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i2 = x3 - this.mInitialTouchX;
                int i3 = y3 - this.mInitialTouchY;
                if (!canScrollHorizontally || Math.abs(i2) <= this.mTouchSlop) {
                    z2 = false;
                } else {
                    this.mLastTouchX = x3;
                    z2 = true;
                }
                if (canScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                    this.mLastTouchY = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x4;
            this.mInitialTouchX = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y4;
            this.mInitialTouchY = y4;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        if (this.mScrollState == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        TraceCompat.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.b();
        this.mFirstLayoutComplete = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            defaultOnMeasure(i2, i3);
            return;
        }
        boolean z2 = false;
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z2;
            if (!z2 && this.mAdapter != null) {
                if (this.mState.f11277e == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.setMeasureSpecs(i2, i3);
                this.mState.f11282j = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
                if (this.mLayout.shouldMeasureTwice()) {
                    this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.f11282j = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
                }
                this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
                this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                State state = this.mState;
                if (state.f11284l) {
                    state.f11280h = true;
                } else {
                    this.mAdapterHelper.j();
                    this.mState.f11280h = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.f11284l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.mAdapter;
            if (adapter != null) {
                this.mState.f11278f = adapter.getItemCount();
            } else {
                this.mState.f11278f = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            stopInterceptRequestLayout(false);
            this.mState.f11280h = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.b());
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.c(savedState2);
        } else {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                savedState.f11265d = layoutManager.onSaveInstanceState();
            } else {
                savedState.f11265d = null;
            }
        }
        return savedState;
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onScrolled(int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            invalidateGlows();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            boolean r0 = r6.mLayoutSuppressed
            r8 = 0
            if (r0 != 0) goto L_0x01f2
            boolean r0 = r6.mIgnoreMotionEventTillDown
            if (r0 == 0) goto L_0x000f
            goto L_0x01f2
        L_0x000f:
            boolean r0 = r17.dispatchToOnItemTouchListeners(r18)
            r9 = 1
            if (r0 == 0) goto L_0x001a
            r17.cancelScroll()
            return r9
        L_0x001a:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r6.mLayout
            if (r0 != 0) goto L_0x001f
            return r8
        L_0x001f:
            boolean r10 = r0.canScrollHorizontally()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r6.mLayout
            boolean r11 = r0.canScrollVertically()
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            if (r0 != 0) goto L_0x0033
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.mVelocityTracker = r0
        L_0x0033:
            int r0 = r18.getActionMasked()
            int r1 = r18.getActionIndex()
            if (r0 != 0) goto L_0x0043
            int[] r2 = r6.mNestedOffsets
            r2[r9] = r8
            r2[r8] = r8
        L_0x0043:
            android.view.MotionEvent r12 = android.view.MotionEvent.obtain(r18)
            int[] r2 = r6.mNestedOffsets
            r3 = r2[r8]
            float r3 = (float) r3
            r2 = r2[r9]
            float r2 = (float) r2
            r12.offsetLocation(r3, r2)
            r2 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L_0x01c6
            if (r0 == r9) goto L_0x0184
            r3 = 2
            if (r0 == r3) goto L_0x008c
            r3 = 3
            if (r0 == r3) goto L_0x0087
            r3 = 5
            if (r0 == r3) goto L_0x006b
            r1 = 6
            if (r0 == r1) goto L_0x0066
            goto L_0x01e7
        L_0x0066:
            r17.onPointerUp(r18)
            goto L_0x01e7
        L_0x006b:
            int r0 = r7.getPointerId(r1)
            r6.mScrollPointerId = r0
            float r0 = r7.getX(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchX = r0
            r6.mInitialTouchX = r0
            float r0 = r7.getY(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchY = r0
            r6.mInitialTouchY = r0
            goto L_0x01e7
        L_0x0087:
            r17.cancelScroll()
            goto L_0x01e7
        L_0x008c:
            int r0 = r6.mScrollPointerId
            int r0 = r7.findPointerIndex(r0)
            if (r0 >= 0) goto L_0x00b2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error processing scroll; pointer index for id "
            r0.append(r1)
            int r1 = r6.mScrollPointerId
            r0.append(r1)
            java.lang.String r1 = " not found. Did any MotionEvents get skipped?"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RecyclerView"
            android.util.Log.e(r1, r0)
            return r8
        L_0x00b2:
            float r1 = r7.getX(r0)
            float r1 = r1 + r2
            int r13 = (int) r1
            float r0 = r7.getY(r0)
            float r0 = r0 + r2
            int r14 = (int) r0
            int r0 = r6.mLastTouchX
            int r0 = r0 - r13
            int r1 = r6.mLastTouchY
            int r1 = r1 - r14
            int r2 = r6.mScrollState
            if (r2 == r9) goto L_0x00fb
            if (r10 == 0) goto L_0x00df
            if (r0 <= 0) goto L_0x00d4
            int r2 = r6.mTouchSlop
            int r0 = r0 - r2
            int r0 = java.lang.Math.max(r8, r0)
            goto L_0x00db
        L_0x00d4:
            int r2 = r6.mTouchSlop
            int r0 = r0 + r2
            int r0 = java.lang.Math.min(r8, r0)
        L_0x00db:
            if (r0 == 0) goto L_0x00df
            r2 = 1
            goto L_0x00e0
        L_0x00df:
            r2 = 0
        L_0x00e0:
            if (r11 == 0) goto L_0x00f6
            if (r1 <= 0) goto L_0x00ec
            int r3 = r6.mTouchSlop
            int r1 = r1 - r3
            int r1 = java.lang.Math.max(r8, r1)
            goto L_0x00f3
        L_0x00ec:
            int r3 = r6.mTouchSlop
            int r1 = r1 + r3
            int r1 = java.lang.Math.min(r8, r1)
        L_0x00f3:
            if (r1 == 0) goto L_0x00f6
            r2 = 1
        L_0x00f6:
            if (r2 == 0) goto L_0x00fb
            r6.setScrollState(r9)
        L_0x00fb:
            int r2 = r6.mScrollState
            if (r2 != r9) goto L_0x01e7
            int[] r2 = r6.mReusableIntPair
            r2[r8] = r8
            r2[r9] = r8
            float r2 = r18.getY()
            int r2 = r6.releaseHorizontalGlow(r0, r2)
            int r15 = r0 - r2
            float r0 = r18.getX()
            int r0 = r6.releaseVerticalGlow(r1, r0)
            int r16 = r1 - r0
            if (r10 == 0) goto L_0x011d
            r1 = r15
            goto L_0x011e
        L_0x011d:
            r1 = 0
        L_0x011e:
            if (r11 == 0) goto L_0x0123
            r2 = r16
            goto L_0x0124
        L_0x0123:
            r2 = 0
        L_0x0124:
            int[] r3 = r6.mReusableIntPair
            int[] r4 = r6.mScrollOffset
            r5 = 0
            r0 = r17
            boolean r0 = r0.dispatchNestedPreScroll(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0153
            int[] r0 = r6.mReusableIntPair
            r1 = r0[r8]
            int r15 = r15 - r1
            r0 = r0[r9]
            int r16 = r16 - r0
            int[] r0 = r6.mNestedOffsets
            r1 = r0[r8]
            int[] r2 = r6.mScrollOffset
            r3 = r2[r8]
            int r1 = r1 + r3
            r0[r8] = r1
            r1 = r0[r9]
            r2 = r2[r9]
            int r1 = r1 + r2
            r0[r9] = r1
            android.view.ViewParent r0 = r17.getParent()
            r0.requestDisallowInterceptTouchEvent(r9)
        L_0x0153:
            r0 = r16
            int[] r1 = r6.mScrollOffset
            r2 = r1[r8]
            int r13 = r13 - r2
            r6.mLastTouchX = r13
            r1 = r1[r9]
            int r14 = r14 - r1
            r6.mLastTouchY = r14
            if (r10 == 0) goto L_0x0165
            r1 = r15
            goto L_0x0166
        L_0x0165:
            r1 = 0
        L_0x0166:
            if (r11 == 0) goto L_0x016a
            r2 = r0
            goto L_0x016b
        L_0x016a:
            r2 = 0
        L_0x016b:
            boolean r1 = r6.scrollByInternal(r1, r2, r7, r8)
            if (r1 == 0) goto L_0x0178
            android.view.ViewParent r1 = r17.getParent()
            r1.requestDisallowInterceptTouchEvent(r9)
        L_0x0178:
            androidx.recyclerview.widget.GapWorker r1 = r6.mGapWorker
            if (r1 == 0) goto L_0x01e7
            if (r15 != 0) goto L_0x0180
            if (r0 == 0) goto L_0x01e7
        L_0x0180:
            r1.f(r6, r15, r0)
            goto L_0x01e7
        L_0x0184:
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r12)
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            int r1 = r6.mMaxFlingVelocity
            float r1 = (float) r1
            r2 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r2, r1)
            r0 = 0
            if (r10 == 0) goto L_0x01a0
            android.view.VelocityTracker r1 = r6.mVelocityTracker
            int r2 = r6.mScrollPointerId
            float r1 = r1.getXVelocity(r2)
            float r1 = -r1
            goto L_0x01a1
        L_0x01a0:
            r1 = 0
        L_0x01a1:
            if (r11 == 0) goto L_0x01ad
            android.view.VelocityTracker r2 = r6.mVelocityTracker
            int r3 = r6.mScrollPointerId
            float r2 = r2.getYVelocity(r3)
            float r2 = -r2
            goto L_0x01ae
        L_0x01ad:
            r2 = 0
        L_0x01ae:
            int r3 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x01b6
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x01be
        L_0x01b6:
            int r0 = (int) r1
            int r1 = (int) r2
            boolean r0 = r6.fling(r0, r1)
            if (r0 != 0) goto L_0x01c1
        L_0x01be:
            r6.setScrollState(r8)
        L_0x01c1:
            r17.resetScroll()
            r8 = 1
            goto L_0x01e7
        L_0x01c6:
            int r0 = r7.getPointerId(r8)
            r6.mScrollPointerId = r0
            float r0 = r18.getX()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchX = r0
            r6.mInitialTouchX = r0
            float r0 = r18.getY()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchY = r0
            r6.mInitialTouchY = r0
            if (r11 == 0) goto L_0x01e4
            r10 = r10 | 2
        L_0x01e4:
            r6.startNestedScroll(r10, r8)
        L_0x01e7:
            if (r8 != 0) goto L_0x01ee
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r12)
        L_0x01ee:
            r12.recycle()
            return r9
        L_0x01f2:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            ViewCompat.j0(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void processDataSetCompletelyChanged(boolean z2) {
        this.mDispatchItemsChangedEvent = z2 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    /* access modifiers changed from: package-private */
    public void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, 8192);
        if (this.mState.f11281i && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.mViewInfoStore.c(getChangedHolderKey(viewHolder), viewHolder);
        }
        this.mViewInfoStore.e(viewHolder, itemHolderInfo);
    }

    /* access modifiers changed from: package-private */
    public void removeAndRecycleViews() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.k();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.c();
    }

    /* access modifiers changed from: package-private */
    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean r2 = this.mChildHelper.r(view);
        if (r2) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.O(childViewHolderInt);
            this.mRecycler.H(childViewHolderInt);
        }
        stopInterceptRequestLayout(!r2);
        return r2;
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z2) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z2);
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        boolean z2;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(itemDecoration);
        if (this.mItemDecorations.isEmpty()) {
            if (getOverScrollMode() == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            setWillNotDraw(z2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 < 0 || i2 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i2));
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.remove(onChildAttachStateChangeListener);
        }
    }

    public void removeOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.remove(onItemTouchListener);
        if (this.mInterceptingOnItemTouchListener == onItemTouchListener) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    public void removeRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecyclerListeners.remove(recyclerListener);
    }

    /* access modifiers changed from: package-private */
    public void repositionShadowingViews() {
        ViewHolder viewHolder;
        int g2 = this.mChildHelper.g();
        for (int i2 = 0; i2 < g2; i2++) {
            View f2 = this.mChildHelper.f(i2);
            ViewHolder childViewHolder = getChildViewHolder(f2);
            if (!(childViewHolder == null || (viewHolder = childViewHolder.mShadowingHolder) == null)) {
                View view = viewHolder.itemView;
                int left = f2.getLeft();
                int top = f2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mOnItemTouchListeners.get(i2).c(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void saveOldPositions() {
        int j2 = this.mChildHelper.j();
        for (int i2 = 0; i2 < j2; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    public void scrollBy(int i2, int i3) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i2 = 0;
                }
                if (!canScrollVertically) {
                    i3 = 0;
                }
                scrollByInternal(i2, i3, (MotionEvent) null, 0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean scrollByInternal(int i2, int i3, MotionEvent motionEvent, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z2;
        int i9 = i2;
        int i10 = i3;
        MotionEvent motionEvent2 = motionEvent;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i9, i10, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i11 = iArr2[0];
            int i12 = iArr2[1];
            i8 = i12;
            i7 = i11;
            i6 = i9 - i11;
            i5 = i10 - i12;
        } else {
            i8 = 0;
            i7 = 0;
            i6 = 0;
            i5 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i7, i8, i6, i5, this.mScrollOffset, i4, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i13 = iArr4[0];
        int i14 = i6 - i13;
        int i15 = iArr4[1];
        int i16 = i5 - i15;
        if (i13 == 0 && i15 == 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        int i17 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        int i18 = iArr5[0];
        this.mLastTouchX = i17 - i18;
        int i19 = this.mLastTouchY;
        int i20 = iArr5[1];
        this.mLastTouchY = i19 - i20;
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + i18;
        iArr6[1] = iArr6[1] + i20;
        if (getOverScrollMode() != 2) {
            if (motionEvent2 != null && !MotionEventCompat.a(motionEvent2, 8194)) {
                pullGlows(motionEvent.getX(), (float) i14, motionEvent.getY(), (float) i16);
            }
            considerReleasingGlowsOnScroll(i2, i3);
        }
        if (!(i7 == 0 && i8 == 0)) {
            dispatchOnScrolled(i7, i8);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (!z2 && i7 == 0 && i8 == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void scrollStep(int i2, int i3, int[] iArr) {
        int i4;
        int i5;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        TraceCompat.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (i2 != 0) {
            i4 = this.mLayout.scrollHorizontallyBy(i2, this.mRecycler, this.mState);
        } else {
            i4 = 0;
        }
        if (i3 != 0) {
            i5 = this.mLayout.scrollVerticallyBy(i3, this.mRecycler, this.mState);
        } else {
            i5 = 0;
        }
        TraceCompat.b();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = i4;
            iArr[1] = i5;
        }
    }

    public void scrollTo(int i2, int i3) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i2) {
        if (!this.mLayoutSuppressed) {
            stopScroll();
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null) {
                Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            layoutManager.scrollToPosition(i2);
            awakenScrollBars();
        }
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.r0(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback != null) {
            setChildrenDrawingOrderEnabled(false);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int i2) {
        if (isComputingLayout()) {
            viewHolder.mPendingAccessibilityState = i2;
            this.mPendingAccessibilityImportanceChange.add(viewHolder);
            return false;
        }
        ViewCompat.C0(viewHolder.itemView, i2);
        return true;
    }

    public void setClipToPadding(boolean z2) {
        if (z2 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z2;
        super.setClipToPadding(z2);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(EdgeEffectFactory edgeEffectFactory) {
        Preconditions.g(edgeEffectFactory);
        this.mEdgeEffectFactory = edgeEffectFactory;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z2) {
        this.mHasFixedSize = z2;
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.mItemAnimator;
        if (itemAnimator2 != null) {
            itemAnimator2.k();
            this.mItemAnimator.v((ItemAnimator.ItemAnimatorListener) null);
        }
        this.mItemAnimator = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.v(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.mRecycler.L(i2);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                ItemAnimator itemAnimator = this.mItemAnimator;
                if (itemAnimator != null) {
                    itemAnimator.k();
                }
                this.mLayout.removeAndRecycleAllViews(this.mRecycler);
                this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
                this.mRecycler.c();
                if (this.mIsAttached) {
                    this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
                }
                this.mLayout.setRecyclerView((RecyclerView) null);
                this.mLayout = null;
            } else {
                this.mRecycler.c();
            }
            this.mChildHelper.o();
            this.mLayout = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.mRecyclerView == null) {
                    layoutManager.setRecyclerView(this);
                    if (this.mIsAttached) {
                        this.mLayout.dispatchAttachedToWindow(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.mRecyclerView.exceptionLabel());
                }
            }
            this.mRecycler.P();
            requestLayout();
        }
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition((LayoutTransition) null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().n(z2);
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.mPreserveFocusAfterLayout = z2;
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        this.mRecycler.J(recycledViewPool);
    }

    @Deprecated
    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecyclerListener = recyclerListener;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (i2 != this.mScrollState) {
            this.mScrollState = i2;
            if (i2 != 2) {
                stopScrollersInternal();
            }
            dispatchOnScrollStateChanged(i2);
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.mRecycler.K(viewCacheExtension);
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i2;
        int i3 = 0;
        if (!isComputingLayout()) {
            return false;
        }
        if (accessibilityEvent != null) {
            i2 = AccessibilityEventCompat.a(accessibilityEvent);
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            i3 = i2;
        }
        this.mEatenAccessibilityChangeFlags |= i3;
        return true;
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, (Interpolator) null);
    }

    public void smoothScrollToPosition(int i2) {
        if (!this.mLayoutSuppressed) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null) {
                Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                layoutManager.smoothScrollToPosition(this, this.mState, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void startInterceptRequestLayout() {
        int i2 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i2;
        if (i2 == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().p(i2);
    }

    /* access modifiers changed from: package-private */
    public void stopInterceptRequestLayout(boolean z2) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z2 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z2 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().r();
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    public final void suppressLayout(boolean z2) {
        if (z2 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z2) {
                this.mLayoutSuppressed = false;
                if (!(!this.mLayoutWasDefered || this.mLayout == null || this.mAdapter == null)) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, DECELERATION_RATE, DECELERATION_RATE, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public void swapAdapter(Adapter adapter, boolean z2) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z2);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void viewRangeUpdate(int i2, int i3, Object obj) {
        int i4;
        int j2 = this.mChildHelper.j();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < j2; i6++) {
            View i7 = this.mChildHelper.i(i6);
            ViewHolder childViewHolderInt = getChildViewHolderInt(i7);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i4 = childViewHolderInt.mPosition) >= i2 && i4 < i5) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) i7.getLayoutParams()).f11246c = true;
            }
        }
        this.mRecycler.R(i2, i3);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f10967a);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().d(i2, i3, iArr, iArr2, i4);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().g(i2, i3, i4, i5, iArr, i6);
    }

    /* access modifiers changed from: package-private */
    public ViewHolder findViewHolderForPosition(int i2, boolean z2) {
        int j2 = this.mChildHelper.j();
        ViewHolder viewHolder = null;
        for (int i3 = 0; i3 < j2; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z2) {
                    if (childViewHolderInt.mPosition != i2) {
                        continue;
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i2) {
                    continue;
                }
                if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    public boolean hasNestedScrollingParent(int i2) {
        return getScrollingChildHelper().l(i2);
    }

    /* access modifiers changed from: package-private */
    public void onExitLayoutOrScroll(boolean z2) {
        int i2 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i2;
        if (i2 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z2) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator) {
        smoothScrollBy(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    public boolean startNestedScroll(int i2, int i3) {
        return getScrollingChildHelper().q(i2, i3);
    }

    public void stopNestedScroll(int i2) {
        getScrollingChildHelper().s(i2);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: d  reason: collision with root package name */
        Parcelable f11265d;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f11265d = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        /* access modifiers changed from: package-private */
        public void c(SavedState savedState) {
            this.f11265d = savedState.f11265d;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.f11265d, 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        int i3 = i2;
        this.mObserver = new RecyclerViewDataObserver();
        this.mRecycler = new Recycler();
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new Runnable() {
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    if (!recyclerView2.mIsAttached) {
                        recyclerView2.requestLayout();
                    } else if (recyclerView2.mLayoutSuppressed) {
                        recyclerView2.mLayoutWasDefered = true;
                    } else {
                        recyclerView2.consumePendingUpdateOperations();
                    }
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = sDefaultEdgeEffectFactory;
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() {
            public void run() {
                ItemAnimator itemAnimator = RecyclerView.this.mItemAnimator;
                if (itemAnimator != null) {
                    itemAnimator.u();
                }
                RecyclerView.this.mPostedAnimatorRunner = false;
            }
        };
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback() {
            public void a(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            public void b(ViewHolder viewHolder) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.removeAndRecycleView(viewHolder.itemView, recyclerView.mRecycler);
            }

            public void c(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.mRecycler.O(viewHolder);
                RecyclerView.this.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            public void d(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.setIsRecyclable(false);
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mDataSetHasChangedAfterLayout) {
                    if (recyclerView.mItemAnimator.b(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        RecyclerView.this.postAnimationRunner();
                    }
                } else if (recyclerView.mItemAnimator.d(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.b(viewConfiguration, context2);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.d(viewConfiguration, context2);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mPhysicalCoef = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.v(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.B(this) == 0) {
            ViewCompat.C0(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        int[] iArr = R$styleable.f10971a;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, iArr, i3, 0);
        ViewCompat.p0(this, context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        String string = obtainStyledAttributes.getString(R$styleable.f10980j);
        if (obtainStyledAttributes.getInt(R$styleable.f10974d, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(R$styleable.f10973c, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.f10975e, false);
        this.mEnableFastScroller = z2;
        if (z2) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.f10978h), obtainStyledAttributes.getDrawable(R$styleable.f10979i), (StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.f10976f), obtainStyledAttributes.getDrawable(R$styleable.f10977g));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i2, 0);
        int[] iArr2 = NESTED_SCROLLING_ATTRS;
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet2, iArr2, i3, 0);
        ViewCompat.p0(this, context, iArr2, attributeSet, obtainStyledAttributes2, i2, 0);
        boolean z3 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z3);
        PoolingContainer.d(this, true);
    }

    public final void dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4) {
        smoothScrollBy(i2, i3, interpolator, i4, false);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        ViewHolder f11244a;

        /* renamed from: b  reason: collision with root package name */
        final Rect f11245b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        boolean f11246c = true;

        /* renamed from: d  reason: collision with root package name */
        boolean f11247d = false;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int a() {
            return this.f11244a.getLayoutPosition();
        }

        public boolean b() {
            return this.f11244a.isUpdated();
        }

        public boolean c() {
            return this.f11244a.isRemoved();
        }

        public boolean d() {
            return this.f11244a.isInvalid();
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            int i5 = 0;
            if (!layoutManager.canScrollHorizontally()) {
                i2 = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i3 = 0;
            }
            if (i2 != 0 || i3 != 0) {
                if (i4 == Integer.MIN_VALUE || i4 > 0) {
                    if (z2) {
                        if (i2 != 0) {
                            i5 = 1;
                        }
                        if (i3 != 0) {
                            i5 |= 2;
                        }
                        startNestedScroll(i5, 1);
                    }
                    this.mViewFlinger.e(i2, i3, i4, interpolator);
                    return;
                }
                scrollBy(i2, i3);
            }
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }
}
