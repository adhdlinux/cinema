package com.vungle.ads.internal.task;

import android.content.Context;
import com.vungle.ads.internal.util.PathProvider;
import kotlin.jvm.internal.Intrinsics;

public final class VungleJobCreator implements JobCreator {
    private final Context context;
    private final PathProvider pathProvider;

    public VungleJobCreator(Context context2, PathProvider pathProvider2) {
        Intrinsics.f(context2, "context");
        Intrinsics.f(pathProvider2, "pathProvider");
        this.context = context2;
        this.pathProvider = pathProvider2;
    }

    public Job create(String str) throws UnknownTagException {
        boolean z2;
        Intrinsics.f(str, "tag");
        if (str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            throw new UnknownTagException("Job tag is null");
        } else if (Intrinsics.a(str, CleanupJob.TAG)) {
            return new CleanupJob(this.context, this.pathProvider);
        } else {
            if (Intrinsics.a(str, ResendTpatJob.TAG)) {
                return new ResendTpatJob(this.context, this.pathProvider);
            }
            throw new UnknownTagException("Unknown Job Type " + str);
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final PathProvider getPathProvider() {
        return this.pathProvider;
    }
}
