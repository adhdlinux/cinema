package androidx.work;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

public interface ProgressUpdater {
    ListenableFuture<Void> a(Context context, UUID uuid, Data data);
}
