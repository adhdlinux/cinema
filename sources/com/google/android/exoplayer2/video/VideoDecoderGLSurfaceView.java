package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.exoplayer2.decoder.VideoDecoderOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlProgram;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import okhttp3.internal.http2.Http2;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements VideoDecoderOutputBufferRenderer {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int f28911c = 0;

    /* renamed from: b  reason: collision with root package name */
    private final Renderer f28912b;

    private static final class Renderer implements GLSurfaceView.Renderer {

        /* renamed from: l  reason: collision with root package name */
        private static final float[] f28913l = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};

        /* renamed from: m  reason: collision with root package name */
        private static final float[] f28914m = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

        /* renamed from: n  reason: collision with root package name */
        private static final float[] f28915n = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};

        /* renamed from: o  reason: collision with root package name */
        private static final String[] f28916o = {"y_tex", "u_tex", "v_tex"};

        /* renamed from: p  reason: collision with root package name */
        private static final FloatBuffer f28917p = GlUtil.e(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

        /* renamed from: b  reason: collision with root package name */
        private final GLSurfaceView f28918b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f28919c = new int[3];

        /* renamed from: d  reason: collision with root package name */
        private final int[] f28920d = new int[3];

        /* renamed from: e  reason: collision with root package name */
        private final int[] f28921e = new int[3];

        /* renamed from: f  reason: collision with root package name */
        private final int[] f28922f = new int[3];

        /* renamed from: g  reason: collision with root package name */
        private final AtomicReference<VideoDecoderOutputBuffer> f28923g = new AtomicReference<>();

        /* renamed from: h  reason: collision with root package name */
        private final FloatBuffer[] f28924h = new FloatBuffer[3];

        /* renamed from: i  reason: collision with root package name */
        private GlProgram f28925i;

        /* renamed from: j  reason: collision with root package name */
        private int f28926j;

        /* renamed from: k  reason: collision with root package name */
        private VideoDecoderOutputBuffer f28927k;

        public Renderer(GLSurfaceView gLSurfaceView) {
            this.f28918b = gLSurfaceView;
            for (int i2 = 0; i2 < 3; i2++) {
                int[] iArr = this.f28921e;
                this.f28922f[i2] = -1;
                iArr[i2] = -1;
            }
        }

        @RequiresNonNull({"program"})
        private void b() {
            try {
                GLES20.glGenTextures(3, this.f28919c, 0);
                for (int i2 = 0; i2 < 3; i2++) {
                    GLES20.glUniform1i(this.f28925i.j(f28916o[i2]), i2);
                    GLES20.glActiveTexture(33984 + i2);
                    GlUtil.a(3553, this.f28919c[i2]);
                }
                GlUtil.b();
            } catch (GlUtil.GlException e2) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures", e2);
            }
        }

        public void a(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
            VideoDecoderOutputBuffer andSet = this.f28923g.getAndSet(videoDecoderOutputBuffer);
            if (andSet != null) {
                andSet.p();
            }
            this.f28918b.requestRender();
        }

        public void onDrawFrame(GL10 gl10) {
            boolean z2;
            int i2;
            VideoDecoderOutputBuffer andSet = this.f28923g.getAndSet((Object) null);
            if (andSet != null || this.f28927k != null) {
                if (andSet != null) {
                    VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.f28927k;
                    if (videoDecoderOutputBuffer != null) {
                        videoDecoderOutputBuffer.p();
                    }
                    this.f28927k = andSet;
                }
                VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = (VideoDecoderOutputBuffer) Assertions.e(this.f28927k);
                float[] fArr = f28914m;
                int i3 = videoDecoderOutputBuffer2.f23994i;
                if (i3 == 1) {
                    fArr = f28913l;
                } else if (i3 == 3) {
                    fArr = f28915n;
                }
                GLES20.glUniformMatrix3fv(this.f28926j, 1, false, fArr, 0);
                int[] iArr = (int[]) Assertions.e(videoDecoderOutputBuffer2.f23993h);
                ByteBuffer[] byteBufferArr = (ByteBuffer[]) Assertions.e(videoDecoderOutputBuffer2.f23992g);
                for (int i4 = 0; i4 < 3; i4++) {
                    if (i4 == 0) {
                        i2 = videoDecoderOutputBuffer2.f23991f;
                    } else {
                        i2 = (videoDecoderOutputBuffer2.f23991f + 1) / 2;
                    }
                    GLES20.glActiveTexture(33984 + i4);
                    GLES20.glBindTexture(3553, this.f28919c[i4]);
                    GLES20.glPixelStorei(3317, 1);
                    GLES20.glTexImage2D(3553, 0, 6409, iArr[i4], i2, 0, 6409, 5121, byteBufferArr[i4]);
                }
                int[] iArr2 = new int[3];
                int i5 = videoDecoderOutputBuffer2.f23990e;
                iArr2[0] = i5;
                int i6 = (i5 + 1) / 2;
                iArr2[2] = i6;
                iArr2[1] = i6;
                for (int i7 = 0; i7 < 3; i7++) {
                    if (this.f28921e[i7] != iArr2[i7] || this.f28922f[i7] != iArr[i7]) {
                        if (iArr[i7] != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        Assertions.g(z2);
                        float f2 = ((float) iArr2[i7]) / ((float) iArr[i7]);
                        this.f28924h[i7] = GlUtil.e(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f2, 0.0f, f2, 1.0f});
                        GLES20.glVertexAttribPointer(this.f28920d[i7], 2, 5126, false, 0, this.f28924h[i7]);
                        this.f28921e[i7] = iArr2[i7];
                        this.f28922f[i7] = iArr[i7];
                    }
                }
                GLES20.glClear(Http2.INITIAL_MAX_FRAME_SIZE);
                GLES20.glDrawArrays(5, 0, 4);
                try {
                    GlUtil.b();
                } catch (GlUtil.GlException e2) {
                    Log.e("VideoDecoderGLSV", "Failed to draw a frame", e2);
                }
            }
        }

        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            GLES20.glViewport(0, 0, i2, i3);
        }

        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            try {
                GlProgram glProgram = new GlProgram("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
                this.f28925i = glProgram;
                GLES20.glVertexAttribPointer(glProgram.e("in_pos"), 2, 5126, false, 0, f28917p);
                this.f28920d[0] = this.f28925i.e("in_tc_y");
                this.f28920d[1] = this.f28925i.e("in_tc_u");
                this.f28920d[2] = this.f28925i.e("in_tc_v");
                this.f28926j = this.f28925i.j("mColorConversion");
                GlUtil.b();
                b();
                GlUtil.b();
            } catch (GlUtil.GlException e2) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures and program", e2);
            }
        }
    }

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, (AttributeSet) null);
    }

    @Deprecated
    public VideoDecoderOutputBufferRenderer getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.f28912b.a(videoDecoderOutputBuffer);
    }

    public VideoDecoderGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Renderer renderer = new Renderer(this);
        this.f28912b = renderer;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(renderer);
        setRenderMode(0);
    }
}
