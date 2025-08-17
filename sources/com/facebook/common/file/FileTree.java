package com.facebook.common.file;

import com.facebook.infer.annotation.Nullsafe;
import java.io.File;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class FileTree {
    public static boolean deleteContents(File file) {
        File[] listFiles = file.listFiles();
        boolean z2 = true;
        if (listFiles != null) {
            for (File deleteRecursively : listFiles) {
                z2 &= deleteRecursively(deleteRecursively);
            }
        }
        return z2;
    }

    public static boolean deleteRecursively(File file) {
        if (file.isDirectory()) {
            deleteContents(file);
        }
        return file.delete();
    }

    public static void walkFileTree(File file, FileTreeVisitor fileTreeVisitor) {
        fileTreeVisitor.preVisitDirectory(file);
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    walkFileTree(file2, fileTreeVisitor);
                } else {
                    fileTreeVisitor.visitFile(file2);
                }
            }
        }
        fileTreeVisitor.postVisitDirectory(file);
    }
}
