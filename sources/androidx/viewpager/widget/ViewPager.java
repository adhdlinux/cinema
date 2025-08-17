package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.facebook.imageutils.JfifUtil;
import com.google.protobuf.CodedOutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() {
        /* renamed from: a */
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.f11942b - itemInfo2.f11942b;
        }
    };
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS = {16842931};
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private static final Interpolator sInterpolator = new Interpolator() {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();
    private int mActivePointerId = -1;
    PagerAdapter mAdapter;
    private List<OnAdapterChangeListener> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new Runnable() {
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.populate();
        }
    };
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems = new ArrayList<>();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = Float.MAX_VALUE;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit = 1;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private EdgeEffect mRightEdge;
    private int mScrollState = 0;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final ItemInfo mTempItem = new ItemInfo();
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    static class ItemInfo {

        /* renamed from: a  reason: collision with root package name */
        Object f11941a;

        /* renamed from: b  reason: collision with root package name */
        int f11942b;

        /* renamed from: c  reason: collision with root package name */
        boolean f11943c;

        /* renamed from: d  reason: collision with root package name */
        float f11944d;

        /* renamed from: e  reason: collision with root package name */
        float f11945e;

        ItemInfo() {
        }
    }

    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate() {
        }

        private boolean a() {
            PagerAdapter pagerAdapter = ViewPager.this.mAdapter;
            return pagerAdapter != null && pagerAdapter.getCount() > 1;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            PagerAdapter pagerAdapter;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(a());
            if (accessibilityEvent.getEventType() == 4096 && (pagerAdapter = ViewPager.this.mAdapter) != null) {
                accessibilityEvent.setItemCount(pagerAdapter.getCount());
                accessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
                accessibilityEvent.setToIndex(ViewPager.this.mCurItem);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.c0(ViewPager.class.getName());
            accessibilityNodeInfoCompat.z0(a());
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.a(CodedOutputStream.DEFAULT_BUFFER_SIZE);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.a(8192);
            }
        }

        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            if (i2 != 4096) {
                if (i2 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.mCurItem - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.mCurItem + 1);
                return true;
            }
        }
    }

    public interface OnAdapterChangeListener {
        void a(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    public interface OnPageChangeListener {
        void a(int i2, float f2, int i3);

        void b(int i2);

        void c(int i2);
    }

    public interface PageTransformer {
    }

    private class PagerObserver extends DataSetObserver {
        PagerObserver() {
        }

        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
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
        int f11954d;

        /* renamed from: e  reason: collision with root package name */
        Parcelable f11955e;

        /* renamed from: f  reason: collision with root package name */
        ClassLoader f11956f;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f11954d + "}";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f11954d);
            parcel.writeParcelable(this.f11955e, i2);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f11954d = parcel.readInt();
            this.f11955e = parcel.readParcelable(classLoader);
            this.f11956f = classLoader;
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void a(int i2, float f2, int i3) {
        }

        public void b(int i2) {
        }

        public void c(int i2) {
        }
    }

    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z2 = layoutParams.f11946a;
            if (z2 == layoutParams2.f11946a) {
                return layoutParams.f11950e - layoutParams2.f11950e;
            }
            if (z2) {
                return 1;
            }
            return -1;
        }
    }

    public ViewPager(Context context) {
        super(context);
        initViewPager();
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int i2, ItemInfo itemInfo2) {
        float f2;
        float f3;
        float f4;
        int i3;
        int i4;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f2 = ((float) this.mPageMargin) / ((float) clientWidth);
        } else {
            f2 = 0.0f;
        }
        if (itemInfo2 != null) {
            int i5 = itemInfo2.f11942b;
            int i6 = itemInfo.f11942b;
            if (i5 < i6) {
                float f5 = itemInfo2.f11945e + itemInfo2.f11944d + f2;
                int i7 = i5 + 1;
                int i8 = 0;
                while (i7 <= itemInfo.f11942b && i8 < this.mItems.size()) {
                    Object obj = this.mItems.get(i8);
                    while (true) {
                        itemInfo4 = (ItemInfo) obj;
                        if (i7 > itemInfo4.f11942b && i8 < this.mItems.size() - 1) {
                            i8++;
                            obj = this.mItems.get(i8);
                        }
                    }
                    while (i7 < itemInfo4.f11942b) {
                        f5 += this.mAdapter.getPageWidth(i7) + f2;
                        i7++;
                    }
                    itemInfo4.f11945e = f5;
                    f5 += itemInfo4.f11944d + f2;
                    i7++;
                }
            } else if (i5 > i6) {
                int size = this.mItems.size() - 1;
                float f6 = itemInfo2.f11945e;
                while (true) {
                    i5--;
                    if (i5 < itemInfo.f11942b || size < 0) {
                        break;
                    }
                    Object obj2 = this.mItems.get(size);
                    while (true) {
                        itemInfo3 = (ItemInfo) obj2;
                        if (i5 < itemInfo3.f11942b && size > 0) {
                            size--;
                            obj2 = this.mItems.get(size);
                        }
                    }
                    while (i5 > itemInfo3.f11942b) {
                        f6 -= this.mAdapter.getPageWidth(i5) + f2;
                        i5--;
                    }
                    f6 -= itemInfo3.f11944d + f2;
                    itemInfo3.f11945e = f6;
                }
            }
        }
        int size2 = this.mItems.size();
        float f7 = itemInfo.f11945e;
        int i9 = itemInfo.f11942b;
        int i10 = i9 - 1;
        if (i9 == 0) {
            f3 = f7;
        } else {
            f3 = -3.4028235E38f;
        }
        this.mFirstOffset = f3;
        int i11 = count - 1;
        if (i9 == i11) {
            f4 = (itemInfo.f11944d + f7) - 1.0f;
        } else {
            f4 = Float.MAX_VALUE;
        }
        this.mLastOffset = f4;
        int i12 = i2 - 1;
        while (i12 >= 0) {
            ItemInfo itemInfo5 = this.mItems.get(i12);
            while (true) {
                i4 = itemInfo5.f11942b;
                if (i10 <= i4) {
                    break;
                }
                f7 -= this.mAdapter.getPageWidth(i10) + f2;
                i10--;
            }
            f7 -= itemInfo5.f11944d + f2;
            itemInfo5.f11945e = f7;
            if (i4 == 0) {
                this.mFirstOffset = f7;
            }
            i12--;
            i10--;
        }
        float f8 = itemInfo.f11945e + itemInfo.f11944d + f2;
        int i13 = itemInfo.f11942b + 1;
        int i14 = i2 + 1;
        while (i14 < size2) {
            ItemInfo itemInfo6 = this.mItems.get(i14);
            while (true) {
                i3 = itemInfo6.f11942b;
                if (i13 >= i3) {
                    break;
                }
                f8 += this.mAdapter.getPageWidth(i13) + f2;
                i13++;
            }
            if (i3 == i11) {
                this.mLastOffset = (itemInfo6.f11944d + f8) - 1.0f;
            }
            itemInfo6.f11945e = f8;
            f8 += itemInfo6.f11944d + f2;
            i14++;
            i13++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean z2) {
        boolean z3;
        if (this.mScrollState == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            ItemInfo itemInfo = this.mItems.get(i2);
            if (itemInfo.f11943c) {
                itemInfo.f11943c = false;
                z3 = true;
            }
        }
        if (!z3) {
            return;
        }
        if (z2) {
            ViewCompat.j0(this, this.mEndScrollRunnable);
        } else {
            this.mEndScrollRunnable.run();
        }
    }

    private int determineTargetPage(int i2, float f2, int i3, int i4) {
        float f3;
        if (Math.abs(i4) <= this.mFlingDistance || Math.abs(i3) <= this.mMinimumVelocity) {
            if (i2 >= this.mCurItem) {
                f3 = 0.4f;
            } else {
                f3 = 0.6f;
            }
            i2 += (int) (f2 + f3);
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.mItems.size() <= 0) {
            return i2;
        }
        ArrayList<ItemInfo> arrayList = this.mItems;
        return Math.max(this.mItems.get(0).f11942b, Math.min(i2, arrayList.get(arrayList.size() - 1).f11942b));
    }

    private void dispatchOnPageScrolled(int i2, float f2, int i3) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.a(i2, f2, i3);
        }
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i4);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.a(i2, f2, i3);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.a(i2, f2, i3);
        }
    }

    private void dispatchOnPageSelected(int i2) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.c(i2);
        }
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i3);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.c(i2);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.c(i2);
        }
    }

    private void dispatchOnScrollStateChanged(int i2) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.b(i2);
        }
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i3);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.b(i2);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.b(i2);
        }
    }

    private void enableLayers(boolean z2) {
        int i2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (z2) {
                i2 = this.mPageTransformerLayerType;
            } else {
                i2 = 0;
            }
            getChildAt(i3).setLayerType(i2, (Paint) null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        float f2;
        float f3;
        int i2;
        int clientWidth = getClientWidth();
        float f4 = 0.0f;
        if (clientWidth > 0) {
            f2 = ((float) getScrollX()) / ((float) clientWidth);
        } else {
            f2 = 0.0f;
        }
        if (clientWidth > 0) {
            f3 = ((float) this.mPageMargin) / ((float) clientWidth);
        } else {
            f3 = 0.0f;
        }
        ItemInfo itemInfo = null;
        float f5 = 0.0f;
        int i3 = -1;
        int i4 = 0;
        boolean z2 = true;
        while (i4 < this.mItems.size()) {
            ItemInfo itemInfo2 = this.mItems.get(i4);
            if (!z2 && itemInfo2.f11942b != (i2 = i3 + 1)) {
                itemInfo2 = this.mTempItem;
                itemInfo2.f11945e = f4 + f5 + f3;
                itemInfo2.f11942b = i2;
                itemInfo2.f11944d = this.mAdapter.getPageWidth(i2);
                i4--;
            }
            ItemInfo itemInfo3 = itemInfo2;
            f4 = itemInfo3.f11945e;
            float f6 = itemInfo3.f11944d + f4 + f3;
            if (!z2 && f2 < f4) {
                return itemInfo;
            }
            if (f2 < f6 || i4 == this.mItems.size() - 1) {
                return itemInfo3;
            }
            int i5 = itemInfo3.f11942b;
            float f7 = itemInfo3.f11944d;
            i4++;
            z2 = false;
            ItemInfo itemInfo4 = itemInfo3;
            i3 = i5;
            f5 = f7;
            itemInfo = itemInfo4;
        }
        return itemInfo;
    }

    private static boolean isDecorView(View view) {
        if (view.getClass().getAnnotation(DecorView.class) != null) {
            return true;
        }
        return false;
    }

    private boolean isGutterDrag(float f2, float f3) {
        return (f2 < ((float) this.mGutterSize) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.mGutterSize)) && f3 < 0.0f);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i2;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.mLastMotionX = motionEvent.getX(i2);
            this.mActivePointerId = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i2) {
        if (this.mItems.size() != 0) {
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i3 = this.mPageMargin;
            int i4 = clientWidth + i3;
            float f2 = (float) clientWidth;
            int i5 = infoForCurrentScrollPosition.f11942b;
            float f3 = ((((float) i2) / f2) - infoForCurrentScrollPosition.f11945e) / (infoForCurrentScrollPosition.f11944d + (((float) i3) / f2));
            this.mCalledSuper = false;
            onPageScrolled(i5, f3, (int) (((float) i4) * f3));
            if (this.mCalledSuper) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.mFirstLayout) {
            return false;
        } else {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private boolean performDrag(float f2) {
        boolean z2;
        boolean z3;
        float f3 = this.mLastMotionX - f2;
        this.mLastMotionX = f2;
        float scrollX = ((float) getScrollX()) + f3;
        float clientWidth = (float) getClientWidth();
        float f4 = this.mFirstOffset * clientWidth;
        float f5 = this.mLastOffset * clientWidth;
        boolean z4 = false;
        ItemInfo itemInfo = this.mItems.get(0);
        ArrayList<ItemInfo> arrayList = this.mItems;
        ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
        if (itemInfo.f11942b != 0) {
            f4 = itemInfo.f11945e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (itemInfo2.f11942b != this.mAdapter.getCount() - 1) {
            f5 = itemInfo2.f11945e * clientWidth;
            z3 = false;
        } else {
            z3 = true;
        }
        if (scrollX < f4) {
            if (z2) {
                this.mLeftEdge.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z4 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z3) {
                this.mRightEdge.onPull(Math.abs(scrollX - f5) / clientWidth);
                z4 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.mLastMotionX += scrollX - ((float) i2);
        scrollTo(i2, getScrollY());
        pageScrolled(i2);
        return z4;
    }

    private void recomputeScrollPosition(int i2, int i3, int i4, int i5) {
        float f2;
        if (i3 <= 0 || this.mItems.isEmpty()) {
            ItemInfo infoForPosition = infoForPosition(this.mCurItem);
            if (infoForPosition != null) {
                f2 = Math.min(infoForPosition.f11945e, this.mLastOffset);
            } else {
                f2 = 0.0f;
            }
            int paddingLeft = (int) (f2 * ((float) ((i2 - getPaddingLeft()) - getPaddingRight())));
            if (paddingLeft != getScrollX()) {
                completeScroll(false);
                scrollTo(paddingLeft, getScrollY());
            }
        } else if (!this.mScroller.isFinished()) {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))) * ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))), getScrollY());
        }
    }

    private void removeNonDecorViews() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i2).getLayoutParams()).f11946a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        if (this.mLeftEdge.isFinished() || this.mRightEdge.isFinished()) {
            return true;
        }
        return false;
    }

    private void scrollToItem(int i2, boolean z2, int i3, boolean z3) {
        int i4;
        ItemInfo infoForPosition = infoForPosition(i2);
        if (infoForPosition != null) {
            i4 = (int) (((float) getClientWidth()) * Math.max(this.mFirstOffset, Math.min(infoForPosition.f11945e, this.mLastOffset)));
        } else {
            i4 = 0;
        }
        if (z2) {
            smoothScrollTo(i4, 0, i3);
            if (z3) {
                dispatchOnPageSelected(i2);
                return;
            }
            return;
        }
        if (z3) {
            dispatchOnPageSelected(i2);
        }
        completeScroll(false);
        scrollTo(i4, 0);
        pageScrolled(i4);
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.mScrollingCacheEnabled != z2) {
            this.mScrollingCacheEnabled = z2;
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.mDrawingOrderedChildren.add(getChildAt(i2));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        ItemInfo infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f11942b == this.mCurItem) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    /* access modifiers changed from: package-private */
    public ItemInfo addNewItem(int i2, int i3) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.f11942b = i2;
        itemInfo.f11941a = this.mAdapter.instantiateItem((ViewGroup) this, i2);
        itemInfo.f11944d = this.mAdapter.getPageWidth(i2);
        if (i3 < 0 || i3 >= this.mItems.size()) {
            this.mItems.add(itemInfo);
        } else {
            this.mItems.add(i3, itemInfo);
        }
        return itemInfo;
    }

    public void addOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(onAdapterChangeListener);
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo infoForChild;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f11942b == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean isDecorView = layoutParams2.f11946a | isDecorView(view);
        layoutParams2.f11946a = isDecorView;
        if (!this.mInLayout) {
            super.addView(view, i2, layoutParams);
        } else if (!isDecorView) {
            layoutParams2.f11949d = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean arrowScroll(int r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto L_0x000b
        L_0x0009:
            r0 = r3
            goto L_0x0069
        L_0x000b:
            if (r0 == 0) goto L_0x0069
            android.view.ViewParent r4 = r0.getParent()
        L_0x0011:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x001e
            if (r4 != r6) goto L_0x0019
            r4 = 1
            goto L_0x001f
        L_0x0019:
            android.view.ViewParent r4 = r4.getParent()
            goto L_0x0011
        L_0x001e:
            r4 = 0
        L_0x001f:
            if (r4 != 0) goto L_0x0069
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L_0x0035:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x004e
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x0035
        L_0x004e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r5)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "ViewPager"
            android.util.Log.e(r4, r0)
            goto L_0x0009
        L_0x0069:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r6, r0, r7)
            r4 = 66
            r5 = 17
            if (r3 == 0) goto L_0x00ba
            if (r3 == r0) goto L_0x00ba
            if (r7 != r5) goto L_0x009a
            android.graphics.Rect r1 = r6.mTempRect
            android.graphics.Rect r1 = r6.getChildRectInPagerCoordinates(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.mTempRect
            android.graphics.Rect r2 = r6.getChildRectInPagerCoordinates(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L_0x0094
            if (r1 < r2) goto L_0x0094
            boolean r0 = r6.pageLeft()
            goto L_0x0098
        L_0x0094:
            boolean r0 = r3.requestFocus()
        L_0x0098:
            r2 = r0
            goto L_0x00cd
        L_0x009a:
            if (r7 != r4) goto L_0x00cd
            android.graphics.Rect r1 = r6.mTempRect
            android.graphics.Rect r1 = r6.getChildRectInPagerCoordinates(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.mTempRect
            android.graphics.Rect r2 = r6.getChildRectInPagerCoordinates(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L_0x00b5
            if (r1 > r2) goto L_0x00b5
            boolean r0 = r6.pageRight()
            goto L_0x0098
        L_0x00b5:
            boolean r0 = r3.requestFocus()
            goto L_0x0098
        L_0x00ba:
            if (r7 == r5) goto L_0x00c9
            if (r7 != r1) goto L_0x00bf
            goto L_0x00c9
        L_0x00bf:
            if (r7 == r4) goto L_0x00c4
            r0 = 2
            if (r7 != r0) goto L_0x00cd
        L_0x00c4:
            boolean r2 = r6.pageRight()
            goto L_0x00cd
        L_0x00c9:
            boolean r2 = r6.pageLeft()
        L_0x00cd:
            if (r2 == 0) goto L_0x00d6
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        L_0x00d6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.arrowScroll(int):boolean");
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z2, int i2, int i3, int i4) {
        int i5;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom()) {
                    if (canScroll(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z2 || !view.canScrollHorizontally(-i2)) {
            return false;
        }
        return true;
    }

    public boolean canScrollHorizontally(int i2) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.mFirstOffset))) {
                return true;
            }
            return false;
        } else if (i2 <= 0 || scrollX >= ((int) (((float) clientWidth) * this.mLastOffset))) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.i0(this);
    }

    /* access modifiers changed from: package-private */
    public void dataSetChanged() {
        boolean z2;
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        if (this.mItems.size() >= (this.mOffscreenPageLimit * 2) + 1 || this.mItems.size() >= count) {
            z2 = false;
        } else {
            z2 = true;
        }
        int i2 = this.mCurItem;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(i3);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.f11941a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i3);
                    i3--;
                    if (!z3) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z3 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.f11942b, itemInfo.f11941a);
                    int i4 = this.mCurItem;
                    if (i4 == itemInfo.f11942b) {
                        i2 = Math.max(0, Math.min(i4, count - 1));
                    }
                } else {
                    int i5 = itemInfo.f11942b;
                    if (i5 != itemPosition) {
                        if (i5 == this.mCurItem) {
                            i2 = itemPosition;
                        }
                        itemInfo.f11942b = itemPosition;
                    }
                }
                z2 = true;
            }
            i3++;
        }
        if (z3) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z2) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i6).getLayoutParams();
                if (!layoutParams.f11946a) {
                    layoutParams.f11948c = 0.0f;
                }
            }
            setCurrentItemInternal(i2, false, true);
            requestLayout();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo infoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f11942b == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public float distanceInfluenceForSnapDuration(float f2) {
        return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
    }

    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z2 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.mAdapter) != null && pagerAdapter.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
                this.mLeftEdge.setSize(height, width);
                z2 = false | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.mRightEdge.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) width2));
                this.mRightEdge.setSize(height2, width2);
                z2 |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (z2) {
            ViewCompat.i0(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f11942b, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.f11945e) / infoForCurrentScrollPosition.f11944d, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            }
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return arrowScroll(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return arrowScroll(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return pageRight();
                } else {
                    return arrowScroll(66);
                }
            } else if (keyEvent.hasModifiers(2)) {
                return pageLeft();
            } else {
                return arrowScroll(17);
            }
        }
        return false;
    }

    public void fakeDragBy(float f2) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.mAdapter != null) {
            this.mLastMotionX += f2;
            float scrollX = ((float) getScrollX()) - f2;
            float clientWidth = (float) getClientWidth();
            float f3 = this.mFirstOffset * clientWidth;
            float f4 = this.mLastOffset * clientWidth;
            ItemInfo itemInfo = this.mItems.get(0);
            ArrayList<ItemInfo> arrayList = this.mItems;
            ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
            if (itemInfo.f11942b != 0) {
                f3 = itemInfo.f11945e * clientWidth;
            }
            if (itemInfo2.f11942b != this.mAdapter.getCount() - 1) {
                f4 = itemInfo2.f11945e * clientWidth;
            }
            if (scrollX < f3) {
                scrollX = f3;
            } else if (scrollX > f4) {
                scrollX = f4;
            }
            int i2 = (int) scrollX;
            this.mLastMotionX += scrollX - ((float) i2);
            scrollTo(i2, getScrollY());
            pageScrolled(i2);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.mDrawingOrder == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i3).getLayoutParams()).f11951f;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    /* access modifiers changed from: package-private */
    public ItemInfo infoForAnyChild(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    /* access modifiers changed from: package-private */
    public ItemInfo infoForChild(View view) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            ItemInfo itemInfo = this.mItems.get(i2);
            if (this.mAdapter.isViewFromObject(view, itemInfo.f11941a)) {
                return itemInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ItemInfo infoForPosition(int i2) {
        for (int i3 = 0; i3 < this.mItems.size(); i3++) {
            ItemInfo itemInfo = this.mItems.get(i3);
            if (itemInfo.f11942b == i2) {
                return itemInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f2);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f2);
        this.mCloseEnough = (int) (2.0f * f2);
        this.mDefaultGutterSize = (int) (f2 * 16.0f);
        ViewCompat.r0(this, new MyAccessibilityDelegate());
        if (ViewCompat.B(this) == 0) {
            ViewCompat.C0(this, 1);
        }
        ViewCompat.G0(this, new OnApplyWindowInsetsListener() {

            /* renamed from: a  reason: collision with root package name */
            private final Rect f11939a = new Rect();

            public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat d02 = ViewCompat.d0(view, windowInsetsCompat);
                if (d02.o()) {
                    return d02;
                }
                Rect rect = this.f11939a;
                rect.left = d02.i();
                rect.top = d02.k();
                rect.right = d02.j();
                rect.bottom = d02.h();
                int childCount = ViewPager.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    WindowInsetsCompat i3 = ViewCompat.i(ViewPager.this.getChildAt(i2), d02);
                    rect.left = Math.min(i3.i(), rect.left);
                    rect.top = Math.min(i3.k(), rect.top);
                    rect.right = Math.min(i3.j(), rect.right);
                    rect.bottom = Math.min(i3.h(), rect.bottom);
                }
                return d02.p(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r18) {
        /*
            r17 = this;
            r0 = r17
            super.onDraw(r18)
            int r1 = r0.mPageMargin
            if (r1 <= 0) goto L_0x00aa
            android.graphics.drawable.Drawable r1 = r0.mMarginDrawable
            if (r1 == 0) goto L_0x00aa
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r1 = r0.mItems
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x00aa
            androidx.viewpager.widget.PagerAdapter r1 = r0.mAdapter
            if (r1 == 0) goto L_0x00aa
            int r1 = r17.getScrollX()
            int r2 = r17.getWidth()
            int r3 = r0.mPageMargin
            float r3 = (float) r3
            float r4 = (float) r2
            float r3 = r3 / r4
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            float r7 = r5.f11945e
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r8 = r0.mItems
            int r8 = r8.size()
            int r9 = r5.f11942b
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r10 = r0.mItems
            int r11 = r8 + -1
            java.lang.Object r10 = r10.get(r11)
            androidx.viewpager.widget.ViewPager$ItemInfo r10 = (androidx.viewpager.widget.ViewPager.ItemInfo) r10
            int r10 = r10.f11942b
        L_0x0045:
            if (r9 >= r10) goto L_0x00aa
        L_0x0047:
            int r11 = r5.f11942b
            if (r9 <= r11) goto L_0x0058
            if (r6 >= r8) goto L_0x0058
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            int r6 = r6 + 1
            java.lang.Object r5 = r5.get(r6)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x0047
        L_0x0058:
            if (r9 != r11) goto L_0x0065
            float r7 = r5.f11945e
            float r11 = r5.f11944d
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r7 = r7 + r11
            float r7 = r7 + r3
            goto L_0x0071
        L_0x0065:
            androidx.viewpager.widget.PagerAdapter r11 = r0.mAdapter
            float r11 = r11.getPageWidth(r9)
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r11 = r11 + r3
            float r7 = r7 + r11
        L_0x0071:
            int r11 = r0.mPageMargin
            float r11 = (float) r11
            float r11 = r11 + r12
            float r13 = (float) r1
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 <= 0) goto L_0x0099
            android.graphics.drawable.Drawable r11 = r0.mMarginDrawable
            int r13 = java.lang.Math.round(r12)
            int r14 = r0.mTopPageBounds
            int r15 = r0.mPageMargin
            float r15 = (float) r15
            float r15 = r15 + r12
            int r15 = java.lang.Math.round(r15)
            r16 = r3
            int r3 = r0.mBottomPageBounds
            r11.setBounds(r13, r14, r15, r3)
            android.graphics.drawable.Drawable r3 = r0.mMarginDrawable
            r11 = r18
            r3.draw(r11)
            goto L_0x009d
        L_0x0099:
            r11 = r18
            r16 = r3
        L_0x009d:
            int r3 = r1 + r2
            float r3 = (float) r3
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a5
            goto L_0x00aa
        L_0x00a5:
            int r9 = r9 + 1
            r3 = r16
            goto L_0x0045
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onDraw(android.graphics.Canvas):void");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f2;
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & JfifUtil.MARKER_FIRST_BYTE;
        if (action == 3 || action == 1) {
            resetTouch();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.mInitialMotionX = x2;
            this.mLastMotionX = x2;
            float y2 = motionEvent.getY();
            this.mInitialMotionY = y2;
            this.mLastMotionY = y2;
            this.mActivePointerId = motionEvent2.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                completeScroll(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.mActivePointerId;
            if (i2 != -1) {
                int findPointerIndex = motionEvent2.findPointerIndex(i2);
                float x3 = motionEvent2.getX(findPointerIndex);
                float f3 = x3 - this.mLastMotionX;
                float abs = Math.abs(f3);
                float y3 = motionEvent2.getY(findPointerIndex);
                float abs2 = Math.abs(y3 - this.mInitialMotionY);
                int i3 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                if (i3 != 0 && !isGutterDrag(this.mLastMotionX, f3)) {
                    if (canScroll(this, false, (int) f3, (int) x3, (int) y3)) {
                        this.mLastMotionX = x3;
                        this.mLastMotionY = y3;
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                }
                int i4 = this.mTouchSlop;
                if (abs > ((float) i4) && abs * 0.5f > abs2) {
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    float f4 = this.mInitialMotionX;
                    float f5 = (float) this.mTouchSlop;
                    if (i3 > 0) {
                        f2 = f4 + f5;
                    } else {
                        f2 = f4 - f5;
                    }
                    this.mLastMotionX = f2;
                    this.mLastMotionY = y3;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) i4)) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && performDrag(x3)) {
                    ViewCompat.i0(this);
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent2);
        return this.mIsBeingDragged;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            r18 = this;
            r0 = r18
            int r1 = r18.getChildCount()
            int r2 = r22 - r20
            int r3 = r23 - r21
            int r4 = r18.getPaddingLeft()
            int r5 = r18.getPaddingTop()
            int r6 = r18.getPaddingRight()
            int r7 = r18.getPaddingBottom()
            int r8 = r18.getScrollX()
            r10 = 0
            r11 = 0
        L_0x0020:
            r12 = 8
            if (r10 >= r1) goto L_0x00b6
            android.view.View r13 = r0.getChildAt(r10)
            int r14 = r13.getVisibility()
            if (r14 == r12) goto L_0x00b2
            android.view.ViewGroup$LayoutParams r12 = r13.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r12 = (androidx.viewpager.widget.ViewPager.LayoutParams) r12
            boolean r14 = r12.f11946a
            if (r14 == 0) goto L_0x00b2
            int r12 = r12.f11947b
            r14 = r12 & 7
            r12 = r12 & 112(0x70, float:1.57E-43)
            r15 = 1
            if (r14 == r15) goto L_0x005c
            r15 = 3
            if (r14 == r15) goto L_0x0056
            r15 = 5
            if (r14 == r15) goto L_0x0049
            r14 = r4
            goto L_0x006d
        L_0x0049:
            int r14 = r2 - r6
            int r15 = r13.getMeasuredWidth()
            int r14 = r14 - r15
            int r15 = r13.getMeasuredWidth()
            int r6 = r6 + r15
            goto L_0x0068
        L_0x0056:
            int r14 = r13.getMeasuredWidth()
            int r14 = r14 + r4
            goto L_0x006d
        L_0x005c:
            int r14 = r13.getMeasuredWidth()
            int r14 = r2 - r14
            int r14 = r14 / 2
            int r14 = java.lang.Math.max(r14, r4)
        L_0x0068:
            r17 = r14
            r14 = r4
            r4 = r17
        L_0x006d:
            r15 = 16
            if (r12 == r15) goto L_0x008e
            r15 = 48
            if (r12 == r15) goto L_0x0088
            r15 = 80
            if (r12 == r15) goto L_0x007b
            r12 = r5
            goto L_0x009f
        L_0x007b:
            int r12 = r3 - r7
            int r15 = r13.getMeasuredHeight()
            int r12 = r12 - r15
            int r15 = r13.getMeasuredHeight()
            int r7 = r7 + r15
            goto L_0x009a
        L_0x0088:
            int r12 = r13.getMeasuredHeight()
            int r12 = r12 + r5
            goto L_0x009f
        L_0x008e:
            int r12 = r13.getMeasuredHeight()
            int r12 = r3 - r12
            int r12 = r12 / 2
            int r12 = java.lang.Math.max(r12, r5)
        L_0x009a:
            r17 = r12
            r12 = r5
            r5 = r17
        L_0x009f:
            int r4 = r4 + r8
            int r15 = r13.getMeasuredWidth()
            int r15 = r15 + r4
            int r16 = r13.getMeasuredHeight()
            int r9 = r5 + r16
            r13.layout(r4, r5, r15, r9)
            int r11 = r11 + 1
            r5 = r12
            r4 = r14
        L_0x00b2:
            int r10 = r10 + 1
            goto L_0x0020
        L_0x00b6:
            int r2 = r2 - r4
            int r2 = r2 - r6
            r6 = 0
        L_0x00b9:
            if (r6 >= r1) goto L_0x0108
            android.view.View r8 = r0.getChildAt(r6)
            int r9 = r8.getVisibility()
            if (r9 == r12) goto L_0x0105
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.f11946a
            if (r10 != 0) goto L_0x0105
            androidx.viewpager.widget.ViewPager$ItemInfo r10 = r0.infoForChild(r8)
            if (r10 == 0) goto L_0x0105
            float r13 = (float) r2
            float r10 = r10.f11945e
            float r10 = r10 * r13
            int r10 = (int) r10
            int r10 = r10 + r4
            boolean r14 = r9.f11949d
            if (r14 == 0) goto L_0x00f8
            r14 = 0
            r9.f11949d = r14
            float r9 = r9.f11948c
            float r13 = r13 * r9
            int r9 = (int) r13
            r13 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r13)
            int r14 = r3 - r5
            int r14 = r14 - r7
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r13)
            r8.measure(r9, r13)
        L_0x00f8:
            int r9 = r8.getMeasuredWidth()
            int r9 = r9 + r10
            int r13 = r8.getMeasuredHeight()
            int r13 = r13 + r5
            r8.layout(r10, r5, r9, r13)
        L_0x0105:
            int r6 = r6 + 1
            goto L_0x00b9
        L_0x0108:
            r0.mTopPageBounds = r5
            int r3 = r3 - r7
            r0.mBottomPageBounds = r3
            r0.mDecorChildCount = r11
            boolean r1 = r0.mFirstLayout
            if (r1 == 0) goto L_0x011a
            int r1 = r0.mCurItem
            r2 = 0
            r0.scrollToItem(r1, r2, r2, r2)
            goto L_0x011b
        L_0x011a:
            r2 = 0
        L_0x011b:
            r0.mFirstLayout = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
            r13 = this;
            r0 = 0
            int r14 = android.view.View.getDefaultSize(r0, r14)
            int r15 = android.view.View.getDefaultSize(r0, r15)
            r13.setMeasuredDimension(r14, r15)
            int r14 = r13.getMeasuredWidth()
            int r15 = r14 / 10
            int r1 = r13.mDefaultGutterSize
            int r15 = java.lang.Math.min(r15, r1)
            r13.mGutterSize = r15
            int r15 = r13.getPaddingLeft()
            int r14 = r14 - r15
            int r15 = r13.getPaddingRight()
            int r14 = r14 - r15
            int r15 = r13.getMeasuredHeight()
            int r1 = r13.getPaddingTop()
            int r15 = r15 - r1
            int r1 = r13.getPaddingBottom()
            int r15 = r15 - r1
            int r1 = r13.getChildCount()
            r2 = 0
        L_0x0037:
            r3 = 8
            r4 = 1
            r5 = 1073741824(0x40000000, float:2.0)
            if (r2 >= r1) goto L_0x00b2
            android.view.View r6 = r13.getChildAt(r2)
            int r7 = r6.getVisibility()
            if (r7 == r3) goto L_0x00af
            android.view.ViewGroup$LayoutParams r3 = r6.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r3 = (androidx.viewpager.widget.ViewPager.LayoutParams) r3
            if (r3 == 0) goto L_0x00af
            boolean r7 = r3.f11946a
            if (r7 == 0) goto L_0x00af
            int r7 = r3.f11947b
            r8 = r7 & 7
            r7 = r7 & 112(0x70, float:1.57E-43)
            r9 = 48
            if (r7 == r9) goto L_0x0065
            r9 = 80
            if (r7 != r9) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r7 = 0
            goto L_0x0066
        L_0x0065:
            r7 = 1
        L_0x0066:
            r9 = 3
            if (r8 == r9) goto L_0x006e
            r9 = 5
            if (r8 != r9) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r4 = 0
        L_0x006e:
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r7 == 0) goto L_0x0075
            r8 = 1073741824(0x40000000, float:2.0)
            goto L_0x007a
        L_0x0075:
            if (r4 == 0) goto L_0x007a
            r9 = 1073741824(0x40000000, float:2.0)
            goto L_0x007c
        L_0x007a:
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x007c:
            int r10 = r3.width
            r11 = -1
            r12 = -2
            if (r10 == r12) goto L_0x0089
            if (r10 == r11) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            r10 = r14
        L_0x0086:
            r8 = 1073741824(0x40000000, float:2.0)
            goto L_0x008a
        L_0x0089:
            r10 = r14
        L_0x008a:
            int r3 = r3.height
            if (r3 == r12) goto L_0x0093
            if (r3 == r11) goto L_0x0091
            goto L_0x0095
        L_0x0091:
            r3 = r15
            goto L_0x0095
        L_0x0093:
            r3 = r15
            r5 = r9
        L_0x0095:
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r8)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r5)
            r6.measure(r8, r3)
            if (r7 == 0) goto L_0x00a8
            int r3 = r6.getMeasuredHeight()
            int r15 = r15 - r3
            goto L_0x00af
        L_0x00a8:
            if (r4 == 0) goto L_0x00af
            int r3 = r6.getMeasuredWidth()
            int r14 = r14 - r3
        L_0x00af:
            int r2 = r2 + 1
            goto L_0x0037
        L_0x00b2:
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r5)
            r13.mChildWidthMeasureSpec = r1
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r5)
            r13.mChildHeightMeasureSpec = r15
            r13.mInLayout = r4
            r13.populate()
            r13.mInLayout = r0
            int r15 = r13.getChildCount()
        L_0x00c9:
            if (r0 >= r15) goto L_0x00f3
            android.view.View r1 = r13.getChildAt(r0)
            int r2 = r1.getVisibility()
            if (r2 == r3) goto L_0x00f0
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r2 = (androidx.viewpager.widget.ViewPager.LayoutParams) r2
            if (r2 == 0) goto L_0x00e1
            boolean r4 = r2.f11946a
            if (r4 != 0) goto L_0x00f0
        L_0x00e1:
            float r4 = (float) r14
            float r2 = r2.f11948c
            float r4 = r4 * r2
            int r2 = (int) r4
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r5)
            int r4 = r13.mChildHeightMeasureSpec
            r1.measure(r2, r4)
        L_0x00f0:
            int r0 = r0 + 1
            goto L_0x00c9
        L_0x00f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPageScrolled(int r12, float r13, int r14) {
        /*
            r11 = this;
            int r0 = r11.mDecorChildCount
            r1 = 1
            if (r0 <= 0) goto L_0x006a
            int r0 = r11.getScrollX()
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r4 = r11.getWidth()
            int r5 = r11.getChildCount()
            r6 = 0
        L_0x001a:
            if (r6 >= r5) goto L_0x006a
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r8 = (androidx.viewpager.widget.ViewPager.LayoutParams) r8
            boolean r9 = r8.f11946a
            if (r9 != 0) goto L_0x002b
            goto L_0x0067
        L_0x002b:
            int r8 = r8.f11947b
            r8 = r8 & 7
            if (r8 == r1) goto L_0x004c
            r9 = 3
            if (r8 == r9) goto L_0x0046
            r9 = 5
            if (r8 == r9) goto L_0x0039
            r8 = r2
            goto L_0x005b
        L_0x0039:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredWidth()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredWidth()
            int r3 = r3 + r9
            goto L_0x0058
        L_0x0046:
            int r8 = r7.getWidth()
            int r8 = r8 + r2
            goto L_0x005b
        L_0x004c:
            int r8 = r7.getMeasuredWidth()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
        L_0x0058:
            r10 = r8
            r8 = r2
            r2 = r10
        L_0x005b:
            int r2 = r2 + r0
            int r9 = r7.getLeft()
            int r2 = r2 - r9
            if (r2 == 0) goto L_0x0066
            r7.offsetLeftAndRight(r2)
        L_0x0066:
            r2 = r8
        L_0x0067:
            int r6 = r6 + 1
            goto L_0x001a
        L_0x006a:
            r11.dispatchOnPageScrolled(r12, r13, r14)
            r11.mCalledSuper = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onPageScrolled(int, float, int):void");
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        int i5;
        ItemInfo infoForChild;
        int childCount = getChildCount();
        if ((i2 & 2) != 0) {
            i4 = childCount;
            i5 = 0;
            i3 = 1;
        } else {
            i5 = childCount - 1;
            i4 = -1;
            i3 = -1;
        }
        while (i5 != i4) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.f11942b == this.mCurItem && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i5 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.b());
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.f11955e, savedState.f11956f);
            setCurrentItemInternal(savedState.f11954d, false, true);
            return;
        }
        this.mRestoredCurItem = savedState.f11954d;
        this.mRestoredAdapterState = savedState.f11955e;
        this.mRestoredClassLoader = savedState.f11956f;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f11954d = this.mCurItem;
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            savedState.f11955e = pagerAdapter.saveState();
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.mPageMargin;
            recomputeScrollPosition(i2, i4, i6, i6);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        float f2;
        if (this.mFakeDragging) {
            return true;
        }
        boolean z2 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.mAdapter) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & JfifUtil.MARKER_FIRST_BYTE;
        if (action == 0) {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            float x2 = motionEvent.getX();
            this.mInitialMotionX = x2;
            this.mLastMotionX = x2;
            float y2 = motionEvent.getY();
            this.mInitialMotionY = y2;
            this.mLastMotionY = y2;
            this.mActivePointerId = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.mIsBeingDragged) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        z2 = resetTouch();
                    } else {
                        float x3 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x3 - this.mLastMotionX);
                        float y3 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y3 - this.mLastMotionY);
                        if (abs > ((float) this.mTouchSlop) && abs > abs2) {
                            this.mIsBeingDragged = true;
                            requestParentDisallowInterceptTouchEvent(true);
                            float f3 = this.mInitialMotionX;
                            if (x3 - f3 > 0.0f) {
                                f2 = f3 + ((float) this.mTouchSlop);
                            } else {
                                f2 = f3 - ((float) this.mTouchSlop);
                            }
                            this.mLastMotionX = f2;
                            this.mLastMotionY = y3;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    z2 = false | performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.mLastMotionX = motionEvent.getX(actionIndex);
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                    this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                }
            } else if (this.mIsBeingDragged) {
                scrollToItem(this.mCurItem, true, 0, false);
                z2 = resetTouch();
            }
        } else if (this.mIsBeingDragged) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            float f4 = (float) clientWidth;
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.f11942b, ((((float) scrollX) / f4) - infoForCurrentScrollPosition.f11945e) / (infoForCurrentScrollPosition.f11944d + (((float) this.mPageMargin) / f4)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
            z2 = resetTouch();
        }
        if (z2) {
            ViewCompat.i0(this);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean pageLeft() {
        int i2 = this.mCurItem;
        if (i2 <= 0) {
            return false;
        }
        setCurrentItem(i2 - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean pageRight() {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null || this.mCurItem >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void populate() {
        populate(this.mCurItem);
    }

    public void removeOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        List<OnAdapterChangeListener> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(onAdapterChangeListener);
        }
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.mAdapter;
        if (pagerAdapter2 != null) {
            pagerAdapter2.setViewPagerObserver((DataSetObserver) null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.mItems.size(); i2++) {
                ItemInfo itemInfo = this.mItems.get(i2);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.f11942b, itemInfo.f11941a);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.mAdapter;
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (pagerAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z2 = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!z2) {
                populate();
            } else {
                requestLayout();
            }
        }
        List<OnAdapterChangeListener> list = this.mAdapterChangeListeners;
        if (list != null && !list.isEmpty()) {
            int size = this.mAdapterChangeListeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mAdapterChangeListeners.get(i3).a(this, pagerAdapter3, pagerAdapter);
            }
        }
    }

    public void setCurrentItem(int i2) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, !this.mFirstLayout, false);
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i2, boolean z2, boolean z3) {
        setCurrentItemInternal(i2, z2, z3, 0);
    }

    /* access modifiers changed from: package-private */
    public OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w(TAG, "Requested offscreen page limit " + i2 + " too small; defaulting to " + 1);
            i2 = 1;
        }
        if (i2 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i2;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setPageMargin(int i2) {
        int i3 = this.mPageMargin;
        this.mPageMargin = i2;
        int width = getWidth();
        recomputeScrollPosition(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z2, PageTransformer pageTransformer) {
        setPageTransformer(z2, pageTransformer, 2);
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (this.mScrollState != i2) {
            this.mScrollState = i2;
            dispatchOnScrollStateChanged(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i2, int i3) {
        smoothScrollTo(i2, i3, 0);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f11946a;

        /* renamed from: b  reason: collision with root package name */
        public int f11947b;

        /* renamed from: c  reason: collision with root package name */
        float f11948c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        boolean f11949d;

        /* renamed from: e  reason: collision with root package name */
        int f11950e;

        /* renamed from: f  reason: collision with root package name */
        int f11951f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.f11947b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        if (r9 == r10) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        r8 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void populate(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.mCurItem
            if (r2 == r1) goto L_0x000f
            androidx.viewpager.widget.ViewPager$ItemInfo r2 = r0.infoForPosition(r2)
            r0.mCurItem = r1
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            androidx.viewpager.widget.PagerAdapter r1 = r0.mAdapter
            if (r1 != 0) goto L_0x0018
            r17.sortChildDrawingOrder()
            return
        L_0x0018:
            boolean r1 = r0.mPopulatePending
            if (r1 == 0) goto L_0x0020
            r17.sortChildDrawingOrder()
            return
        L_0x0020:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x0027
            return
        L_0x0027:
            androidx.viewpager.widget.PagerAdapter r1 = r0.mAdapter
            r1.startUpdate((android.view.ViewGroup) r0)
            int r1 = r0.mOffscreenPageLimit
            int r4 = r0.mCurItem
            int r4 = r4 - r1
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            androidx.viewpager.widget.PagerAdapter r6 = r0.mAdapter
            int r6 = r6.getCount()
            int r7 = r6 + -1
            int r8 = r0.mCurItem
            int r8 = r8 + r1
            int r1 = java.lang.Math.min(r7, r8)
            int r7 = r0.mExpectedAdapterCount
            if (r6 != r7) goto L_0x020e
            r7 = 0
        L_0x004a:
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r8 = r0.mItems
            int r8 = r8.size()
            if (r7 >= r8) goto L_0x0066
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r8 = r0.mItems
            java.lang.Object r8 = r8.get(r7)
            androidx.viewpager.widget.ViewPager$ItemInfo r8 = (androidx.viewpager.widget.ViewPager.ItemInfo) r8
            int r9 = r8.f11942b
            int r10 = r0.mCurItem
            if (r9 < r10) goto L_0x0063
            if (r9 != r10) goto L_0x0066
            goto L_0x0067
        L_0x0063:
            int r7 = r7 + 1
            goto L_0x004a
        L_0x0066:
            r8 = 0
        L_0x0067:
            if (r8 != 0) goto L_0x0071
            if (r6 <= 0) goto L_0x0071
            int r8 = r0.mCurItem
            androidx.viewpager.widget.ViewPager$ItemInfo r8 = r0.addNewItem(r8, r7)
        L_0x0071:
            r9 = 0
            if (r8 == 0) goto L_0x019b
            int r10 = r7 + -1
            if (r10 < 0) goto L_0x0081
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r11 = r0.mItems
            java.lang.Object r11 = r11.get(r10)
            androidx.viewpager.widget.ViewPager$ItemInfo r11 = (androidx.viewpager.widget.ViewPager.ItemInfo) r11
            goto L_0x0082
        L_0x0081:
            r11 = 0
        L_0x0082:
            int r12 = r17.getClientWidth()
            r13 = 1073741824(0x40000000, float:2.0)
            if (r12 > 0) goto L_0x008c
            r14 = 0
            goto L_0x0098
        L_0x008c:
            float r14 = r8.f11944d
            float r14 = r13 - r14
            int r15 = r17.getPaddingLeft()
            float r15 = (float) r15
            float r3 = (float) r12
            float r15 = r15 / r3
            float r14 = r14 + r15
        L_0x0098:
            int r3 = r0.mCurItem
            int r3 = r3 + -1
            r15 = 0
        L_0x009d:
            if (r3 < 0) goto L_0x00fd
            int r16 = (r15 > r14 ? 1 : (r15 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x00cb
            if (r3 >= r4) goto L_0x00cb
            if (r11 != 0) goto L_0x00a8
            goto L_0x00fd
        L_0x00a8:
            int r5 = r11.f11942b
            if (r3 != r5) goto L_0x00f9
            boolean r5 = r11.f11943c
            if (r5 != 0) goto L_0x00f9
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            r5.remove(r10)
            androidx.viewpager.widget.PagerAdapter r5 = r0.mAdapter
            java.lang.Object r11 = r11.f11941a
            r5.destroyItem((android.view.ViewGroup) r0, (int) r3, (java.lang.Object) r11)
            int r10 = r10 + -1
            int r7 = r7 + -1
            if (r10 < 0) goto L_0x00f7
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x00f8
        L_0x00cb:
            if (r11 == 0) goto L_0x00e1
            int r5 = r11.f11942b
            if (r3 != r5) goto L_0x00e1
            float r5 = r11.f11944d
            float r15 = r15 + r5
            int r10 = r10 + -1
            if (r10 < 0) goto L_0x00f7
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x00f8
        L_0x00e1:
            int r5 = r10 + 1
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = r0.addNewItem(r3, r5)
            float r5 = r5.f11944d
            float r15 = r15 + r5
            int r7 = r7 + 1
            if (r10 < 0) goto L_0x00f7
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x00f8
        L_0x00f7:
            r5 = 0
        L_0x00f8:
            r11 = r5
        L_0x00f9:
            int r3 = r3 + -1
            r5 = 0
            goto L_0x009d
        L_0x00fd:
            float r3 = r8.f11944d
            int r4 = r7 + 1
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x018f
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0116
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x0117
        L_0x0116:
            r5 = 0
        L_0x0117:
            if (r12 > 0) goto L_0x011b
            r10 = 0
            goto L_0x0123
        L_0x011b:
            int r10 = r17.getPaddingRight()
            float r10 = (float) r10
            float r11 = (float) r12
            float r10 = r10 / r11
            float r10 = r10 + r13
        L_0x0123:
            int r11 = r0.mCurItem
        L_0x0125:
            int r11 = r11 + 1
            if (r11 >= r6) goto L_0x018f
            int r12 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r12 < 0) goto L_0x0159
            if (r11 <= r1) goto L_0x0159
            if (r5 != 0) goto L_0x0132
            goto L_0x018f
        L_0x0132:
            int r12 = r5.f11942b
            if (r11 != r12) goto L_0x018e
            boolean r12 = r5.f11943c
            if (r12 != 0) goto L_0x018e
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r12 = r0.mItems
            r12.remove(r4)
            androidx.viewpager.widget.PagerAdapter r12 = r0.mAdapter
            java.lang.Object r5 = r5.f11941a
            r12.destroyItem((android.view.ViewGroup) r0, (int) r11, (java.lang.Object) r5)
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0157
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x018e
        L_0x0157:
            r5 = 0
            goto L_0x018e
        L_0x0159:
            if (r5 == 0) goto L_0x0175
            int r12 = r5.f11942b
            if (r11 != r12) goto L_0x0175
            float r5 = r5.f11944d
            float r3 = r3 + r5
            int r4 = r4 + 1
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0157
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x018e
        L_0x0175:
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = r0.addNewItem(r11, r4)
            int r4 = r4 + 1
            float r5 = r5.f11944d
            float r3 = r3 + r5
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0157
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.mItems
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
        L_0x018e:
            goto L_0x0125
        L_0x018f:
            r0.calculatePageOffsets(r8, r7, r2)
            androidx.viewpager.widget.PagerAdapter r1 = r0.mAdapter
            int r2 = r0.mCurItem
            java.lang.Object r3 = r8.f11941a
            r1.setPrimaryItem((android.view.ViewGroup) r0, (int) r2, (java.lang.Object) r3)
        L_0x019b:
            androidx.viewpager.widget.PagerAdapter r1 = r0.mAdapter
            r1.finishUpdate((android.view.ViewGroup) r0)
            int r1 = r17.getChildCount()
            r2 = 0
        L_0x01a5:
            if (r2 >= r1) goto L_0x01ce
            android.view.View r3 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r4 = (androidx.viewpager.widget.ViewPager.LayoutParams) r4
            r4.f11951f = r2
            boolean r5 = r4.f11946a
            if (r5 != 0) goto L_0x01cb
            float r5 = r4.f11948c
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x01cb
            androidx.viewpager.widget.ViewPager$ItemInfo r3 = r0.infoForChild(r3)
            if (r3 == 0) goto L_0x01cb
            float r5 = r3.f11944d
            r4.f11948c = r5
            int r3 = r3.f11942b
            r4.f11950e = r3
        L_0x01cb:
            int r2 = r2 + 1
            goto L_0x01a5
        L_0x01ce:
            r17.sortChildDrawingOrder()
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x020d
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x01e2
            androidx.viewpager.widget.ViewPager$ItemInfo r3 = r0.infoForAnyChild(r1)
            goto L_0x01e3
        L_0x01e2:
            r3 = 0
        L_0x01e3:
            if (r3 == 0) goto L_0x01eb
            int r1 = r3.f11942b
            int r2 = r0.mCurItem
            if (r1 == r2) goto L_0x020d
        L_0x01eb:
            r5 = 0
        L_0x01ec:
            int r1 = r17.getChildCount()
            if (r5 >= r1) goto L_0x020d
            android.view.View r1 = r0.getChildAt(r5)
            androidx.viewpager.widget.ViewPager$ItemInfo r2 = r0.infoForChild(r1)
            if (r2 == 0) goto L_0x020a
            int r2 = r2.f11942b
            int r3 = r0.mCurItem
            if (r2 != r3) goto L_0x020a
            r2 = 2
            boolean r1 = r1.requestFocus(r2)
            if (r1 == 0) goto L_0x020a
            goto L_0x020d
        L_0x020a:
            int r5 = r5 + 1
            goto L_0x01ec
        L_0x020d:
            return
        L_0x020e:
            android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x021b }
            int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x021b }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x021b }
            goto L_0x0223
        L_0x021b:
            int r1 = r17.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x0223:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.append(r4)
            int r4 = r0.mExpectedAdapterCount
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class r1 = r17.getClass()
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            androidx.viewpager.widget.PagerAdapter r1 = r0.mAdapter
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.populate(int):void");
    }

    /* access modifiers changed from: package-private */
    public void setCurrentItemInternal(int i2, boolean z2, boolean z3, int i3) {
        PagerAdapter pagerAdapter = this.mAdapter;
        boolean z4 = false;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z3 || this.mCurItem != i2 || this.mItems.size() == 0) {
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.mAdapter.getCount()) {
                i2 = this.mAdapter.getCount() - 1;
            }
            int i4 = this.mOffscreenPageLimit;
            int i5 = this.mCurItem;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.mItems.size(); i6++) {
                    this.mItems.get(i6).f11943c = true;
                }
            }
            if (this.mCurItem != i2) {
                z4 = true;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i2;
                if (z4) {
                    dispatchOnPageSelected(i2);
                }
                requestLayout();
                return;
            }
            populate(i2);
            scrollToItem(i2, z2, i3, z4);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void setPageTransformer(boolean z2, PageTransformer pageTransformer, int i2) {
        int i3 = 1;
        boolean z3 = pageTransformer != null;
        setChildrenDrawingOrderEnabled(z3);
        if (z3) {
            if (z2) {
                i3 = 2;
            }
            this.mDrawingOrder = i3;
            this.mPageTransformerLayerType = i2;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z3) {
            populate();
        }
    }

    /* access modifiers changed from: package-private */
    public void smoothScrollTo(int i2, int i3, int i4) {
        int i5;
        int i6;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            i5 = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            i5 = getScrollX();
        }
        int i7 = i5;
        int scrollY = getScrollY();
        int i8 = i2 - i7;
        int i9 = i3 - scrollY;
        if (i8 == 0 && i9 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i10 = clientWidth / 2;
        float f2 = (float) clientWidth;
        float f3 = (float) i10;
        float distanceInfluenceForSnapDuration = f3 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i8)) * 1.0f) / f2)) * f3);
        int abs = Math.abs(i4);
        if (abs > 0) {
            i6 = Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) abs)) * 1000.0f) * 4;
        } else {
            i6 = (int) (((((float) Math.abs(i8)) / ((f2 * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 1.0f) * 100.0f);
        }
        int min = Math.min(i6, 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i7, scrollY, i8, i9, min);
        ViewCompat.i0(this);
    }

    public void setCurrentItem(int i2, boolean z2) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, z2, false);
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i2));
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViewPager();
    }
}
