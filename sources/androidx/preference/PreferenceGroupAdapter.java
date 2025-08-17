package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PreferenceGroupAdapter extends RecyclerView.Adapter<PreferenceViewHolder> implements Preference.OnPreferenceChangeInternalListener, PreferenceGroup.PreferencePositionCallback {
    private Handler mHandler;
    private PreferenceGroup mPreferenceGroup;
    private List<PreferenceResourceDescriptor> mPreferenceResourceDescriptors;
    private List<Preference> mPreferences;
    private Runnable mSyncRunnable = new Runnable() {
        public void run() {
            PreferenceGroupAdapter.this.updatePreferences();
        }
    };
    private List<Preference> mVisiblePreferences;

    private static class PreferenceResourceDescriptor {

        /* renamed from: a  reason: collision with root package name */
        int f10856a;

        /* renamed from: b  reason: collision with root package name */
        int f10857b;

        /* renamed from: c  reason: collision with root package name */
        String f10858c;

        PreferenceResourceDescriptor(Preference preference) {
            this.f10858c = preference.getClass().getName();
            this.f10856a = preference.getLayoutResource();
            this.f10857b = preference.getWidgetLayoutResource();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PreferenceResourceDescriptor)) {
                return false;
            }
            PreferenceResourceDescriptor preferenceResourceDescriptor = (PreferenceResourceDescriptor) obj;
            if (this.f10856a == preferenceResourceDescriptor.f10856a && this.f10857b == preferenceResourceDescriptor.f10857b && TextUtils.equals(this.f10858c, preferenceResourceDescriptor.f10858c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f10856a) * 31) + this.f10857b) * 31) + this.f10858c.hashCode();
        }
    }

    public PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        this.mPreferenceGroup = preferenceGroup;
        this.mHandler = new Handler();
        this.mPreferenceGroup.setOnPreferenceChangeInternalListener(this);
        this.mPreferences = new ArrayList();
        this.mVisiblePreferences = new ArrayList();
        this.mPreferenceResourceDescriptors = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.mPreferenceGroup;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup2).shouldUseGeneratedIds());
        } else {
            setHasStableIds(true);
        }
        updatePreferences();
    }

    private ExpandButton createExpandButton(final PreferenceGroup preferenceGroup, List<Preference> list) {
        ExpandButton expandButton = new ExpandButton(preferenceGroup.getContext(), list, preferenceGroup.getId());
        expandButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                preferenceGroup.setInitialExpandedChildrenCount(Integer.MAX_VALUE);
                PreferenceGroupAdapter.this.onPreferenceHierarchyChange(preference);
                preferenceGroup.getOnExpandButtonClickListener();
                return true;
            }
        });
        return expandButton;
    }

    private List<Preference> createVisiblePreferencesList(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        int i2 = 0;
        for (int i3 = 0; i3 < preferenceCount; i3++) {
            Preference preference = preferenceGroup.getPreference(i3);
            if (preference.isVisible()) {
                if (!isGroupExpandable(preferenceGroup) || i2 < preferenceGroup.getInitialExpandedChildrenCount()) {
                    arrayList.add(preference);
                } else {
                    arrayList2.add(preference);
                }
                if (!(preference instanceof PreferenceGroup)) {
                    i2++;
                } else {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                    if (!preferenceGroup2.isOnSameScreenAsChildren()) {
                        continue;
                    } else if (!isGroupExpandable(preferenceGroup) || !isGroupExpandable(preferenceGroup2)) {
                        for (Preference next : createVisiblePreferencesList(preferenceGroup2)) {
                            if (!isGroupExpandable(preferenceGroup) || i2 < preferenceGroup.getInitialExpandedChildrenCount()) {
                                arrayList.add(next);
                            } else {
                                arrayList2.add(next);
                            }
                            i2++;
                        }
                    } else {
                        throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                    }
                }
            }
        }
        if (isGroupExpandable(preferenceGroup) && i2 > preferenceGroup.getInitialExpandedChildrenCount()) {
            arrayList.add(createExpandButton(preferenceGroup, arrayList2));
        }
        return arrayList;
    }

    private void flattenPreferenceGroup(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.sortPreferences();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i2 = 0; i2 < preferenceCount; i2++) {
            Preference preference = preferenceGroup.getPreference(i2);
            list.add(preference);
            PreferenceResourceDescriptor preferenceResourceDescriptor = new PreferenceResourceDescriptor(preference);
            if (!this.mPreferenceResourceDescriptors.contains(preferenceResourceDescriptor)) {
                this.mPreferenceResourceDescriptors.add(preferenceResourceDescriptor);
            }
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                if (preferenceGroup2.isOnSameScreenAsChildren()) {
                    flattenPreferenceGroup(list, preferenceGroup2);
                }
            }
            preference.setOnPreferenceChangeInternalListener(this);
        }
    }

    private boolean isGroupExpandable(PreferenceGroup preferenceGroup) {
        return preferenceGroup.getInitialExpandedChildrenCount() != Integer.MAX_VALUE;
    }

    public Preference getItem(int i2) {
        if (i2 < 0 || i2 >= getItemCount()) {
            return null;
        }
        return this.mVisiblePreferences.get(i2);
    }

    public int getItemCount() {
        return this.mVisiblePreferences.size();
    }

    public long getItemId(int i2) {
        if (!hasStableIds()) {
            return -1;
        }
        return getItem(i2).getId();
    }

    public int getItemViewType(int i2) {
        PreferenceResourceDescriptor preferenceResourceDescriptor = new PreferenceResourceDescriptor(getItem(i2));
        int indexOf = this.mPreferenceResourceDescriptors.indexOf(preferenceResourceDescriptor);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = this.mPreferenceResourceDescriptors.size();
        this.mPreferenceResourceDescriptors.add(preferenceResourceDescriptor);
        return size;
    }

    public int getPreferenceAdapterPosition(String str) {
        int size = this.mVisiblePreferences.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(str, this.mVisiblePreferences.get(i2).getKey())) {
                return i2;
            }
        }
        return -1;
    }

    public void onPreferenceChange(Preference preference) {
        int indexOf = this.mVisiblePreferences.indexOf(preference);
        if (indexOf != -1) {
            notifyItemChanged(indexOf, preference);
        }
    }

    public void onPreferenceHierarchyChange(Preference preference) {
        this.mHandler.removeCallbacks(this.mSyncRunnable);
        this.mHandler.post(this.mSyncRunnable);
    }

    public void onPreferenceVisibilityChange(Preference preference) {
        onPreferenceHierarchyChange(preference);
    }

    /* access modifiers changed from: package-private */
    public void updatePreferences() {
        for (Preference onPreferenceChangeInternalListener : this.mPreferences) {
            onPreferenceChangeInternalListener.setOnPreferenceChangeInternalListener((Preference.OnPreferenceChangeInternalListener) null);
        }
        ArrayList arrayList = new ArrayList(this.mPreferences.size());
        this.mPreferences = arrayList;
        flattenPreferenceGroup(arrayList, this.mPreferenceGroup);
        final List<Preference> list = this.mVisiblePreferences;
        final List<Preference> createVisiblePreferencesList = createVisiblePreferencesList(this.mPreferenceGroup);
        this.mVisiblePreferences = createVisiblePreferencesList;
        PreferenceManager preferenceManager = this.mPreferenceGroup.getPreferenceManager();
        if (preferenceManager == null || preferenceManager.g() == null) {
            notifyDataSetChanged();
        } else {
            final PreferenceManager.PreferenceComparisonCallback g2 = preferenceManager.g();
            DiffUtil.b(new DiffUtil.Callback() {
                public boolean a(int i2, int i3) {
                    return g2.arePreferenceContentsTheSame((Preference) list.get(i2), (Preference) createVisiblePreferencesList.get(i3));
                }

                public boolean b(int i2, int i3) {
                    return g2.arePreferenceItemsTheSame((Preference) list.get(i2), (Preference) createVisiblePreferencesList.get(i3));
                }

                public int d() {
                    return createVisiblePreferencesList.size();
                }

                public int e() {
                    return list.size();
                }
            }).c(this);
        }
        for (Preference clearWasDetached : this.mPreferences) {
            clearWasDetached.clearWasDetached();
        }
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder, int i2) {
        getItem(i2).onBindViewHolder(preferenceViewHolder);
    }

    public PreferenceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        PreferenceResourceDescriptor preferenceResourceDescriptor = this.mPreferenceResourceDescriptors.get(i2);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, R$styleable.f10931p);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.f10934q);
        if (drawable == null) {
            drawable = AppCompatResources.b(viewGroup.getContext(), 17301602);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(preferenceResourceDescriptor.f10856a, viewGroup, false);
        if (inflate.getBackground() == null) {
            ViewCompat.v0(inflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(16908312);
        if (viewGroup2 != null) {
            int i3 = preferenceResourceDescriptor.f10857b;
            if (i3 != 0) {
                from.inflate(i3, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new PreferenceViewHolder(inflate);
    }

    public int getPreferenceAdapterPosition(Preference preference) {
        int size = this.mVisiblePreferences.size();
        for (int i2 = 0; i2 < size; i2++) {
            Preference preference2 = this.mVisiblePreferences.get(i2);
            if (preference2 != null && preference2.equals(preference)) {
                return i2;
            }
        }
        return -1;
    }
}
