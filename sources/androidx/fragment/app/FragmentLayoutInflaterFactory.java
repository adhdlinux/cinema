package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;

class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {

    /* renamed from: b  reason: collision with root package name */
    final FragmentManager f3404b;

    FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.f3404b = fragmentManager;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        final FragmentStateManager fragmentStateManager;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f3404b);
        }
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue((String) null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f3255d);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(R$styleable.f3256e);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.f3257f, -1);
        String string = obtainStyledAttributes.getString(R$styleable.f3258g);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !FragmentFactory.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.f3404b.h0(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.f3404b.i0(string);
        }
        if (fragment == null && id != -1) {
            fragment = this.f3404b.h0(id);
        }
        if (fragment == null) {
            fragment = this.f3404b.r0().a(context.getClassLoader(), attributeValue);
            fragment.mFromLayout = true;
            fragment.mFragmentId = resourceId != 0 ? resourceId : id;
            fragment.mContainerId = id;
            fragment.mTag = string;
            fragment.mInLayout = true;
            FragmentManager fragmentManager = this.f3404b;
            fragment.mFragmentManager = fragmentManager;
            fragment.mHost = fragmentManager.u0();
            fragment.onInflate(this.f3404b.u0().f(), attributeSet, fragment.mSavedFragmentState);
            fragmentStateManager = this.f3404b.g(fragment);
            if (FragmentManager.G0(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else if (!fragment.mInLayout) {
            fragment.mInLayout = true;
            FragmentManager fragmentManager2 = this.f3404b;
            fragment.mFragmentManager = fragmentManager2;
            fragment.mHost = fragmentManager2.u0();
            fragment.onInflate(this.f3404b.u0().f(), attributeSet, fragment.mSavedFragmentState);
            fragmentStateManager = this.f3404b.w(fragment);
            if (FragmentManager.G0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragment + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
        }
        fragment.mContainer = (ViewGroup) view;
        fragmentStateManager.m();
        fragmentStateManager.j();
        View view2 = fragment.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            fragment.mView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    Fragment k2 = fragmentStateManager.k();
                    fragmentStateManager.m();
                    SpecialEffectsController.n((ViewGroup) k2.mView.getParent(), FragmentLayoutInflaterFactory.this.f3404b).j();
                }

                public void onViewDetachedFromWindow(View view) {
                }
            });
            return fragment.mView;
        }
        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
    }
}
