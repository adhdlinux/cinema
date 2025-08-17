package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.cast.MediaError;
import java.util.ArrayList;
import java.util.List;

final class ExpandButton extends Preference {

    /* renamed from: b  reason: collision with root package name */
    private long f10812b;

    ExpandButton(Context context, List<Preference> list, long j2) {
        super(context);
        a();
        b(list);
        this.f10812b = j2 + 1000000;
    }

    private void a() {
        setLayoutResource(R$layout.expand_button);
        setIcon(R$drawable.ic_arrow_down_24dp);
        setTitle(R$string.expand_button_title);
        setOrder(MediaError.DetailedErrorCode.GENERIC);
    }

    private void b(List<Preference> list) {
        ArrayList arrayList = new ArrayList();
        CharSequence charSequence = null;
        for (Preference next : list) {
            CharSequence title = next.getTitle();
            boolean z2 = next instanceof PreferenceGroup;
            if (z2 && !TextUtils.isEmpty(title)) {
                arrayList.add((PreferenceGroup) next);
            }
            if (arrayList.contains(next.getParent())) {
                if (z2) {
                    arrayList.add((PreferenceGroup) next);
                }
            } else if (!TextUtils.isEmpty(title)) {
                if (charSequence == null) {
                    charSequence = title;
                } else {
                    charSequence = getContext().getString(R$string.summary_collapsed_preference_list, new Object[]{charSequence, title});
                }
            }
        }
        setSummary(charSequence);
    }

    /* access modifiers changed from: package-private */
    public long getId() {
        return this.f10812b;
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        preferenceViewHolder.d(false);
    }
}
