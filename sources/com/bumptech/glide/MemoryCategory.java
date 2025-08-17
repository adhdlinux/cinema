package com.bumptech.glide;

public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);
    

    /* renamed from: b  reason: collision with root package name */
    private final float f16146b;

    private MemoryCategory(float f2) {
        this.f16146b = f2;
    }
}
