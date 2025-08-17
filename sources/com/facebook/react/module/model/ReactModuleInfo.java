package com.facebook.react.module.model;

public class ReactModuleInfo {
    private final boolean mCanOverrideExistingModule;
    private String mClassName;
    private final boolean mHasConstants;
    private final boolean mIsCxxModule;
    private final boolean mIsTurboModule;
    private final String mName;
    private final boolean mNeedsEagerInit;

    public ReactModuleInfo(String str, String str2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mName = str;
        this.mClassName = str2;
        this.mCanOverrideExistingModule = z2;
        this.mNeedsEagerInit = z3;
        this.mHasConstants = z4;
        this.mIsCxxModule = z5;
        this.mIsTurboModule = z6;
    }

    public boolean canOverrideExistingModule() {
        return this.mCanOverrideExistingModule;
    }

    public String className() {
        return this.mClassName;
    }

    public boolean hasConstants() {
        return this.mHasConstants;
    }

    public boolean isCxxModule() {
        return this.mIsCxxModule;
    }

    public boolean isTurboModule() {
        return this.mIsTurboModule;
    }

    public String name() {
        return this.mName;
    }

    public boolean needsEagerInit() {
        return this.mNeedsEagerInit;
    }
}
