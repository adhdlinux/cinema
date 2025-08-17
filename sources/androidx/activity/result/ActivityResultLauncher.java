package androidx.activity.result;

import android.annotation.SuppressLint;
import androidx.core.app.ActivityOptionsCompat;

public abstract class ActivityResultLauncher<I> {
    public void a(@SuppressLint({"UnknownNullness"}) I i2) {
        b(i2, (ActivityOptionsCompat) null);
    }

    public abstract void b(@SuppressLint({"UnknownNullness"}) I i2, ActivityOptionsCompat activityOptionsCompat);

    public abstract void c();
}
