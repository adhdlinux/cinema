package com.chartboost.sdk.impl;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

public final class ja {

    /* renamed from: a  reason: collision with root package name */
    public final String f17999a = ja.class.getSimpleName();

    public final String a(File file, String str, String str2) {
        Intrinsics.f(file, "htmlFile");
        Intrinsics.f(str, "params");
        Intrinsics.f(str2, "adm");
        try {
            return StringsKt__StringsJVMKt.C(StringsKt__StringsJVMKt.C(FilesKt__FileReadWriteKt.a(file, Charsets.f40513b), ka.f18045a, str, false, 4, (Object) null), ka.f18046b, str2, false, 4, (Object) null);
        } catch (Exception e2) {
            String str3 = this.f17999a;
            Intrinsics.e(str3, "TAG");
            w7.b(str3, "Parse sdk bidding template exception: " + e2);
            return null;
        }
    }
}
