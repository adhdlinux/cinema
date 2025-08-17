package com.uwetrottmann.trakt5.entities;

public class UserSlug {
    public static final UserSlug ME = new UserSlug("me");
    private final String userSlug;

    public UserSlug(String str) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                this.userSlug = trim;
                return;
            }
            throw new IllegalArgumentException("trakt user slug can not be empty.");
        }
        throw new IllegalArgumentException("trakt user slug can not be null.");
    }

    public static UserSlug fromUsername(String str) {
        if (str != null) {
            return new UserSlug(str.replace(".", "-").replace(" ", "-").replaceAll("(-)+", "-"));
        }
        throw new IllegalArgumentException("trakt username can not be null.");
    }

    public String toString() {
        return this.userSlug;
    }
}
