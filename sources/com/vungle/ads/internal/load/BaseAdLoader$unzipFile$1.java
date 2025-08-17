package com.vungle.ads.internal.load;

import com.vungle.ads.internal.util.UnzipUtility;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class BaseAdLoader$unzipFile$1 implements UnzipUtility.Filter {
    final /* synthetic */ List<String> $existingPaths;

    BaseAdLoader$unzipFile$1(List<String> list) {
        this.$existingPaths = list;
    }

    public boolean matches(String str) {
        boolean z2;
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return true;
        }
        File file = new File(str);
        for (String file2 : this.$existingPaths) {
            File file3 = new File(file2);
            if (Intrinsics.a(file3, file)) {
                return false;
            }
            String path = file.getPath();
            Intrinsics.e(path, "toExtract.path");
            if (StringsKt__StringsJVMKt.G(path, file3.getPath() + File.separator, false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }
}
