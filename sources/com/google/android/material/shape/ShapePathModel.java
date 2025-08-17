package com.google.android.material.shape;

public class ShapePathModel {

    /* renamed from: i  reason: collision with root package name */
    private static final CornerTreatment f29994i = new CornerTreatment();

    /* renamed from: j  reason: collision with root package name */
    private static final EdgeTreatment f29995j = new EdgeTreatment();

    /* renamed from: a  reason: collision with root package name */
    private CornerTreatment f29996a;

    /* renamed from: b  reason: collision with root package name */
    private CornerTreatment f29997b;

    /* renamed from: c  reason: collision with root package name */
    private CornerTreatment f29998c;

    /* renamed from: d  reason: collision with root package name */
    private CornerTreatment f29999d;

    /* renamed from: e  reason: collision with root package name */
    private EdgeTreatment f30000e;

    /* renamed from: f  reason: collision with root package name */
    private EdgeTreatment f30001f;

    /* renamed from: g  reason: collision with root package name */
    private EdgeTreatment f30002g;

    /* renamed from: h  reason: collision with root package name */
    private EdgeTreatment f30003h;

    public ShapePathModel() {
        CornerTreatment cornerTreatment = f29994i;
        this.f29996a = cornerTreatment;
        this.f29997b = cornerTreatment;
        this.f29998c = cornerTreatment;
        this.f29999d = cornerTreatment;
        EdgeTreatment edgeTreatment = f29995j;
        this.f30000e = edgeTreatment;
        this.f30001f = edgeTreatment;
        this.f30002g = edgeTreatment;
        this.f30003h = edgeTreatment;
    }

    public EdgeTreatment a() {
        return this.f30002g;
    }

    public CornerTreatment b() {
        return this.f29999d;
    }

    public CornerTreatment c() {
        return this.f29998c;
    }

    public EdgeTreatment d() {
        return this.f30003h;
    }

    public EdgeTreatment e() {
        return this.f30001f;
    }

    public EdgeTreatment f() {
        return this.f30000e;
    }

    public CornerTreatment g() {
        return this.f29996a;
    }

    public CornerTreatment h() {
        return this.f29997b;
    }

    public void i(EdgeTreatment edgeTreatment) {
        this.f30000e = edgeTreatment;
    }
}
