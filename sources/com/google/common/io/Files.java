package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.graph.SuccessorsFunction;
import java.io.File;

public final class Files {

    /* renamed from: a  reason: collision with root package name */
    private static final SuccessorsFunction<File> f30688a = new SuccessorsFunction<File>() {
    };

    private Files() {
    }

    public static String a(String str) {
        Preconditions.l(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(lastIndexOf + 1);
    }
}
