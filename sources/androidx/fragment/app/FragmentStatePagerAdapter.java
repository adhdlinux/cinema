package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

@Deprecated
public abstract class FragmentStatePagerAdapter extends PagerAdapter {

    /* renamed from: c  reason: collision with root package name */
    private final FragmentManager f3500c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3501d;

    /* renamed from: e  reason: collision with root package name */
    private FragmentTransaction f3502e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<Fragment.SavedState> f3503f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<Fragment> f3504g;

    /* renamed from: h  reason: collision with root package name */
    private Fragment f3505h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3506i;

    @Deprecated
    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public abstract Fragment a(int i2);

    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment.SavedState savedState;
        Fragment fragment = (Fragment) obj;
        if (this.f3502e == null) {
            this.f3502e = this.f3500c.n();
        }
        while (this.f3503f.size() <= i2) {
            this.f3503f.add((Object) null);
        }
        ArrayList<Fragment.SavedState> arrayList = this.f3503f;
        if (fragment.isAdded()) {
            savedState = this.f3500c.n1(fragment);
        } else {
            savedState = null;
        }
        arrayList.set(i2, savedState);
        this.f3504g.set(i2, (Object) null);
        this.f3502e.o(fragment);
        if (fragment.equals(this.f3505h)) {
            this.f3505h = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f3502e;
        if (fragmentTransaction != null) {
            if (!this.f3506i) {
                try {
                    this.f3506i = true;
                    fragmentTransaction.k();
                    this.f3506i = false;
                } catch (Throwable th) {
                    this.f3506i = false;
                    throw th;
                }
            }
            this.f3502e = null;
        }
    }

    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.f3504g.size() > i2 && (fragment = this.f3504g.get(i2)) != null) {
            return fragment;
        }
        if (this.f3502e == null) {
            this.f3502e = this.f3500c.n();
        }
        Fragment a2 = a(i2);
        if (this.f3503f.size() > i2 && (savedState = this.f3503f.get(i2)) != null) {
            a2.setInitialSavedState(savedState);
        }
        while (this.f3504g.size() <= i2) {
            this.f3504g.add((Object) null);
        }
        a2.setMenuVisibility(false);
        if (this.f3501d == 0) {
            a2.setUserVisibleHint(false);
        }
        this.f3504g.set(i2, a2);
        this.f3502e.b(viewGroup.getId(), a2);
        if (this.f3501d == 1) {
            this.f3502e.s(a2, Lifecycle.State.STARTED);
        }
        return a2;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f3503f.clear();
            this.f3504g.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f3503f.add((Fragment.SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment p02 = this.f3500c.p0(bundle, str);
                    if (p02 != null) {
                        while (this.f3504g.size() <= parseInt) {
                            this.f3504g.add((Object) null);
                        }
                        p02.setMenuVisibility(false);
                        this.f3504g.set(parseInt, p02);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public Parcelable saveState() {
        Bundle bundle;
        if (this.f3503f.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.f3503f.size()];
            this.f3503f.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        for (int i2 = 0; i2 < this.f3504g.size(); i2++) {
            Fragment fragment = this.f3504g.get(i2);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f3500c.d1(bundle, "f" + i2, fragment);
            }
        }
        return bundle;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.f3505h;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.f3501d == 1) {
                    if (this.f3502e == null) {
                        this.f3502e = this.f3500c.n();
                    }
                    this.f3502e.s(this.f3505h, Lifecycle.State.STARTED);
                } else {
                    this.f3505h.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.f3501d == 1) {
                if (this.f3502e == null) {
                    this.f3502e = this.f3500c.n();
                }
                this.f3502e.s(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.f3505h = fragment;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public FragmentStatePagerAdapter(FragmentManager fragmentManager, int i2) {
        this.f3502e = null;
        this.f3503f = new ArrayList<>();
        this.f3504g = new ArrayList<>();
        this.f3505h = null;
        this.f3500c = fragmentManager;
        this.f3501d = i2;
    }
}
