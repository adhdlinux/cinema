package com.google.android.exoplayer2.video.spherical;

import android.opengl.GLES20;
import android.util.Log;
import com.google.android.exoplayer2.util.GlProgram;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.video.spherical.Projection;
import java.nio.FloatBuffer;

final class ProjectionRenderer {

    /* renamed from: j  reason: collision with root package name */
    private static final float[] f28991j = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    private static final float[] f28992k = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: l  reason: collision with root package name */
    private static final float[] f28993l = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: m  reason: collision with root package name */
    private static final float[] f28994m = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: n  reason: collision with root package name */
    private static final float[] f28995n = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    private int f28996a;

    /* renamed from: b  reason: collision with root package name */
    private MeshData f28997b;

    /* renamed from: c  reason: collision with root package name */
    private MeshData f28998c;

    /* renamed from: d  reason: collision with root package name */
    private GlProgram f28999d;

    /* renamed from: e  reason: collision with root package name */
    private int f29000e;

    /* renamed from: f  reason: collision with root package name */
    private int f29001f;

    /* renamed from: g  reason: collision with root package name */
    private int f29002g;

    /* renamed from: h  reason: collision with root package name */
    private int f29003h;

    /* renamed from: i  reason: collision with root package name */
    private int f29004i;

    private static class MeshData {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f29005a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final FloatBuffer f29006b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final FloatBuffer f29007c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final int f29008d;

        public MeshData(Projection.SubMesh subMesh) {
            this.f29005a = subMesh.a();
            this.f29006b = GlUtil.e(subMesh.f28989c);
            this.f29007c = GlUtil.e(subMesh.f28990d);
            int i2 = subMesh.f28988b;
            if (i2 == 1) {
                this.f29008d = 5;
            } else if (i2 != 2) {
                this.f29008d = 4;
            } else {
                this.f29008d = 6;
            }
        }
    }

    ProjectionRenderer() {
    }

    public static boolean c(Projection projection) {
        Projection.Mesh mesh = projection.f28982a;
        Projection.Mesh mesh2 = projection.f28983b;
        if (mesh.b() == 1 && mesh.a(0).f28987a == 0 && mesh2.b() == 1 && mesh2.a(0).f28987a == 0) {
            return true;
        }
        return false;
    }

    public void a(int i2, float[] fArr, boolean z2) {
        MeshData meshData;
        float[] fArr2;
        if (z2) {
            meshData = this.f28998c;
        } else {
            meshData = this.f28997b;
        }
        if (meshData != null) {
            int i3 = this.f28996a;
            if (i3 == 1) {
                if (z2) {
                    fArr2 = f28993l;
                } else {
                    fArr2 = f28992k;
                }
            } else if (i3 != 2) {
                fArr2 = f28991j;
            } else if (z2) {
                fArr2 = f28995n;
            } else {
                fArr2 = f28994m;
            }
            GLES20.glUniformMatrix3fv(this.f29001f, 1, false, fArr2, 0);
            GLES20.glUniformMatrix4fv(this.f29000e, 1, false, fArr, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i2);
            GLES20.glUniform1i(this.f29004i, 0);
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e2) {
                Log.e("ProjectionRenderer", "Failed to bind uniforms", e2);
            }
            GLES20.glVertexAttribPointer(this.f29002g, 3, 5126, false, 12, meshData.f29006b);
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e3) {
                Log.e("ProjectionRenderer", "Failed to load position data", e3);
            }
            GLES20.glVertexAttribPointer(this.f29003h, 2, 5126, false, 8, meshData.f29007c);
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e4) {
                Log.e("ProjectionRenderer", "Failed to load texture data", e4);
            }
            GLES20.glDrawArrays(meshData.f29008d, 0, meshData.f29005a);
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e5) {
                Log.e("ProjectionRenderer", "Failed to render", e5);
            }
        }
    }

    public void b() {
        try {
            GlProgram glProgram = new GlProgram("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
            this.f28999d = glProgram;
            this.f29000e = glProgram.j("uMvpMatrix");
            this.f29001f = this.f28999d.j("uTexMatrix");
            this.f29002g = this.f28999d.e("aPosition");
            this.f29003h = this.f28999d.e("aTexCoords");
            this.f29004i = this.f28999d.j("uTexture");
        } catch (GlUtil.GlException e2) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e2);
        }
    }

    public void d(Projection projection) {
        if (c(projection)) {
            this.f28996a = projection.f28984c;
            MeshData meshData = new MeshData(projection.f28982a.a(0));
            this.f28997b = meshData;
            if (!projection.f28985d) {
                meshData = new MeshData(projection.f28983b.a(0));
            }
            this.f28998c = meshData;
        }
    }
}
