package com.google.ar.core;

enum ai {
    BASE_TRACKABLE(1095893248, Trackable.class),
    UNKNOWN_TO_JAVA(-1, (int) null),
    PLANE(1095893249, Plane.class),
    POINT(1095893250, Point.class),
    AUGMENTED_IMAGE(1095893252, AugmentedImage.class),
    FACE(1095893253, AugmentedFace.class),
    STREETSCAPE_GEOMETRY(1095893251, StreetscapeGeometry.class),
    EARTH(1095893257, Earth.class),
    DEPTH_POINT(1095893265, DepthPoint.class),
    INSTANT_PLACEMENT_POINT(1095893266, InstantPlacementPoint.class);
    

    /* renamed from: b  reason: collision with root package name */
    final int f30302b;

    /* renamed from: c  reason: collision with root package name */
    private final Class f30303c;

    private ai(int i2, Class cls) {
        this.f30302b = i2;
        this.f30303c = cls;
    }

    public static ai a(Class cls) {
        for (ai aiVar : values()) {
            Class cls2 = aiVar.f30303c;
            if (cls2 != null && cls2.equals(cls)) {
                return aiVar;
            }
        }
        return UNKNOWN_TO_JAVA;
    }
}
