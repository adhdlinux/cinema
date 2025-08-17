package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.PreferenceManager;

public final class PreferenceScreen extends PreferenceGroup {
    private boolean mShouldUseGeneratedIds = true;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, TypedArrayUtils.a(context, R$attr.preferenceScreenStyle, 16842891));
    }

    /* access modifiers changed from: protected */
    public boolean isOnSameScreenAsChildren() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onClick() {
        PreferenceManager.OnNavigateToScreenListener e2;
        if (getIntent() == null && getFragment() == null && getPreferenceCount() != 0 && (e2 = getPreferenceManager().e()) != null) {
            e2.onNavigateToScreen(this);
        }
    }

    public void setShouldUseGeneratedIds(boolean z2) {
        if (!isAttached()) {
            this.mShouldUseGeneratedIds = z2;
            return;
        }
        throw new IllegalStateException("Cannot change the usage of generated IDs while attached to the preference hierarchy");
    }

    public boolean shouldUseGeneratedIds() {
        return this.mShouldUseGeneratedIds;
    }
}
