package androidx.media3.exoplayer.video.spherical;

import android.opengl.GLES20;
import android.util.Log;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.exoplayer.video.spherical.Projection;
import java.nio.FloatBuffer;

final class ProjectionRenderer {

    /* renamed from: j  reason: collision with root package name */
    private static final float[] f7817j = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    private static final float[] f7818k = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: l  reason: collision with root package name */
    private static final float[] f7819l = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: m  reason: collision with root package name */
    private static final float[] f7820m = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: n  reason: collision with root package name */
    private static final float[] f7821n = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    private int f7822a;

    /* renamed from: b  reason: collision with root package name */
    private MeshData f7823b;

    /* renamed from: c  reason: collision with root package name */
    private MeshData f7824c;

    /* renamed from: d  reason: collision with root package name */
    private GlProgram f7825d;

    /* renamed from: e  reason: collision with root package name */
    private int f7826e;

    /* renamed from: f  reason: collision with root package name */
    private int f7827f;

    /* renamed from: g  reason: collision with root package name */
    private int f7828g;

    /* renamed from: h  reason: collision with root package name */
    private int f7829h;

    /* renamed from: i  reason: collision with root package name */
    private int f7830i;

    private static class MeshData {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f7831a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final FloatBuffer f7832b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final FloatBuffer f7833c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final int f7834d;

        public MeshData(Projection.SubMesh subMesh) {
            this.f7831a = subMesh.a();
            this.f7832b = GlUtil.e(subMesh.f7815c);
            this.f7833c = GlUtil.e(subMesh.f7816d);
            int i2 = subMesh.f7814b;
            if (i2 == 1) {
                this.f7834d = 5;
            } else if (i2 != 2) {
                this.f7834d = 4;
            } else {
                this.f7834d = 6;
            }
        }
    }

    ProjectionRenderer() {
    }

    public static boolean c(Projection projection) {
        Projection.Mesh mesh = projection.f7808a;
        Projection.Mesh mesh2 = projection.f7809b;
        if (mesh.b() == 1 && mesh.a(0).f7813a == 0 && mesh2.b() == 1 && mesh2.a(0).f7813a == 0) {
            return true;
        }
        return false;
    }

    public void a(int i2, float[] fArr, boolean z2) {
        MeshData meshData;
        float[] fArr2;
        if (z2) {
            meshData = this.f7824c;
        } else {
            meshData = this.f7823b;
        }
        if (meshData != null) {
            int i3 = this.f7822a;
            if (i3 == 1) {
                if (z2) {
                    fArr2 = f7819l;
                } else {
                    fArr2 = f7818k;
                }
            } else if (i3 != 2) {
                fArr2 = f7817j;
            } else if (z2) {
                fArr2 = f7821n;
            } else {
                fArr2 = f7820m;
            }
            GLES20.glUniformMatrix3fv(this.f7827f, 1, false, fArr2, 0);
            GLES20.glUniformMatrix4fv(this.f7826e, 1, false, fArr, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i2);
            GLES20.glUniform1i(this.f7830i, 0);
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e2) {
                Log.e("ProjectionRenderer", "Failed to bind uniforms", e2);
            }
            GLES20.glVertexAttribPointer(this.f7828g, 3, 5126, false, 12, meshData.f7832b);
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e3) {
                Log.e("ProjectionRenderer", "Failed to load position data", e3);
            }
            GLES20.glVertexAttribPointer(this.f7829h, 2, 5126, false, 8, meshData.f7833c);
            try {
                GlUtil.b();
            } catch (GlUtil.GlException e4) {
                Log.e("ProjectionRenderer", "Failed to load texture data", e4);
            }
            GLES20.glDrawArrays(meshData.f7834d, 0, meshData.f7831a);
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
            this.f7825d = glProgram;
            this.f7826e = glProgram.j("uMvpMatrix");
            this.f7827f = this.f7825d.j("uTexMatrix");
            this.f7828g = this.f7825d.e("aPosition");
            this.f7829h = this.f7825d.e("aTexCoords");
            this.f7830i = this.f7825d.j("uTexture");
        } catch (GlUtil.GlException e2) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e2);
        }
    }

    public void d(Projection projection) {
        if (c(projection)) {
            this.f7822a = projection.f7810c;
            MeshData meshData = new MeshData(projection.f7808a.a(0));
            this.f7823b = meshData;
            if (!projection.f7811d) {
                meshData = new MeshData(projection.f7809b.a(0));
            }
            this.f7824c = meshData;
        }
    }
}
