package com.facebook.react.bridge;

public class SoftAssertions {
    public static void assertCondition(boolean z2, String str) {
        if (!z2) {
            ReactSoftExceptionLogger.logSoftException("SoftAssertions", new AssertionException(str));
        }
    }

    public static <T> T assertNotNull(T t2) {
        if (t2 == null) {
            ReactSoftExceptionLogger.logSoftException("SoftAssertions", new AssertionException("Expected object to not be null!"));
        }
        return t2;
    }

    public static void assertUnreachable(String str) {
        ReactSoftExceptionLogger.logSoftException("SoftAssertions", new AssertionException(str));
    }
}
