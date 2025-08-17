package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransitionValues {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f11787a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public View f11788b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<Transition> f11789c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        if (this.f11788b != transitionValues.f11788b || !this.f11787a.equals(transitionValues.f11787a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f11788b.hashCode() * 31) + this.f11787a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f11788b + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE) + "    values:";
        for (String next : this.f11787a.keySet()) {
            str = str + "    " + next + ": " + this.f11787a.get(next) + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
        }
        return str;
    }
}
