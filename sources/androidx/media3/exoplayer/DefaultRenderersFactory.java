package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.image.ImageDecoder;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.image.ImageRenderer;
import androidx.media3.exoplayer.mediacodec.DefaultMediaCodecAdapterFactory;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.metadata.MetadataRenderer;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.text.TextRenderer;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.spherical.CameraMotionRenderer;
import java.util.ArrayList;

public class DefaultRenderersFactory implements RenderersFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5222a;

    /* renamed from: b  reason: collision with root package name */
    private final DefaultMediaCodecAdapterFactory f5223b;

    /* renamed from: c  reason: collision with root package name */
    private int f5224c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f5225d = 5000;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5226e;

    /* renamed from: f  reason: collision with root package name */
    private MediaCodecSelector f5227f = MediaCodecSelector.f6742a;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5228g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5229h;

    public DefaultRenderersFactory(Context context) {
        this.f5222a = context;
        this.f5223b = new DefaultMediaCodecAdapterFactory(context);
    }

    public Renderer[] a(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        ArrayList arrayList = new ArrayList();
        i(this.f5222a, this.f5224c, this.f5227f, this.f5226e, handler, videoRendererEventListener, this.f5225d, arrayList);
        AudioSink c2 = c(this.f5222a, this.f5228g, this.f5229h);
        if (c2 != null) {
            b(this.f5222a, this.f5224c, this.f5227f, this.f5226e, c2, handler, audioRendererEventListener, arrayList);
        }
        ArrayList arrayList2 = arrayList;
        h(this.f5222a, textOutput, handler.getLooper(), this.f5224c, arrayList2);
        f(this.f5222a, metadataOutput, handler.getLooper(), this.f5224c, arrayList2);
        d(this.f5222a, this.f5224c, arrayList);
        e(arrayList);
        Handler handler2 = handler;
        g(this.f5222a, handler, this.f5224c, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0062, code lost:
        throw new java.lang.RuntimeException("Error instantiating MIDI extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0092, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009a, code lost:
        throw new java.lang.RuntimeException("Error instantiating Opus extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d1, code lost:
        throw new java.lang.RuntimeException("Error instantiating FLAC extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a A[ExcHandler: Exception (r0v8 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0092 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:20:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c9 A[ExcHandler: Exception (r0v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:33:0x009e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r16, int r17, androidx.media3.exoplayer.mediacodec.MediaCodecSelector r18, boolean r19, androidx.media3.exoplayer.audio.AudioSink r20, android.os.Handler r21, androidx.media3.exoplayer.audio.AudioRendererEventListener r22, java.util.ArrayList<androidx.media3.exoplayer.Renderer> r23) {
        /*
            r15 = this;
            r0 = r17
            r9 = r23
            java.lang.Class<androidx.media3.exoplayer.audio.AudioSink> r10 = androidx.media3.exoplayer.audio.AudioSink.class
            java.lang.Class<androidx.media3.exoplayer.audio.AudioRendererEventListener> r11 = androidx.media3.exoplayer.audio.AudioRendererEventListener.class
            java.lang.Class<android.os.Handler> r12 = android.os.Handler.class
            java.lang.String r13 = "DefaultRenderersFactory"
            androidx.media3.exoplayer.audio.MediaCodecAudioRenderer r14 = new androidx.media3.exoplayer.audio.MediaCodecAudioRenderer
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter$Factory r3 = r15.j()
            r1 = r14
            r2 = r16
            r4 = r18
            r5 = r19
            r6 = r21
            r7 = r22
            r8 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r9.add(r14)
            if (r0 != 0) goto L_0x0028
            return
        L_0x0028:
            int r1 = r23.size()
            r2 = 2
            if (r0 != r2) goto L_0x0031
            int r1 = r1 + -1
        L_0x0031:
            r0 = 0
            r3 = 1
            java.lang.String r4 = "androidx.media3.decoder.midi.MidiRenderer"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005a }
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005a }
            java.lang.Class<android.content.Context> r6 = android.content.Context.class
            r5[r0] = r6     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005a }
            java.lang.reflect.Constructor r4 = r4.getConstructor(r5)     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005a }
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005a }
            r5[r0] = r16     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005a }
            java.lang.Object r4 = r4.newInstance(r5)     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005a }
            androidx.media3.exoplayer.Renderer r4 = (androidx.media3.exoplayer.Renderer) r4     // Catch:{ ClassNotFoundException -> 0x0063, Exception -> 0x005a }
            int r5 = r1 + 1
            r9.add(r1, r4)     // Catch:{ ClassNotFoundException -> 0x0058, Exception -> 0x005a }
            java.lang.String r1 = "Loaded MidiRenderer."
            androidx.media3.common.util.Log.f(r13, r1)     // Catch:{ ClassNotFoundException -> 0x0058, Exception -> 0x005a }
            goto L_0x0064
        L_0x0058:
            r1 = r5
            goto L_0x0063
        L_0x005a:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating MIDI extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x0063:
            r5 = r1
        L_0x0064:
            r1 = 3
            java.lang.String r4 = "androidx.media3.decoder.opus.LibopusAudioRenderer"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ ClassNotFoundException -> 0x009b, Exception -> 0x0092 }
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x009b, Exception -> 0x0092 }
            r6[r0] = r12     // Catch:{ ClassNotFoundException -> 0x009b, Exception -> 0x0092 }
            r6[r3] = r11     // Catch:{ ClassNotFoundException -> 0x009b, Exception -> 0x0092 }
            r6[r2] = r10     // Catch:{ ClassNotFoundException -> 0x009b, Exception -> 0x0092 }
            java.lang.reflect.Constructor r4 = r4.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x009b, Exception -> 0x0092 }
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x009b, Exception -> 0x0092 }
            r6[r0] = r21     // Catch:{ ClassNotFoundException -> 0x009b, Exception -> 0x0092 }
            r6[r3] = r22     // Catch:{ ClassNotFoundException -> 0x009b, Exception -> 0x0092 }
            r6[r2] = r20     // Catch:{ ClassNotFoundException -> 0x009b, Exception -> 0x0092 }
            java.lang.Object r4 = r4.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x009b, Exception -> 0x0092 }
            androidx.media3.exoplayer.Renderer r4 = (androidx.media3.exoplayer.Renderer) r4     // Catch:{ ClassNotFoundException -> 0x009b, Exception -> 0x0092 }
            int r6 = r5 + 1
            r9.add(r5, r4)     // Catch:{ ClassNotFoundException -> 0x0090, Exception -> 0x0092 }
            java.lang.String r4 = "Loaded LibopusAudioRenderer."
            androidx.media3.common.util.Log.f(r13, r4)     // Catch:{ ClassNotFoundException -> 0x0090, Exception -> 0x0092 }
            goto L_0x009c
        L_0x0090:
            r5 = r6
            goto L_0x009b
        L_0x0092:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating Opus extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x009b:
            r6 = r5
        L_0x009c:
            java.lang.String r4 = "androidx.media3.decoder.flac.LibflacAudioRenderer"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ ClassNotFoundException -> 0x00d2, Exception -> 0x00c9 }
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x00d2, Exception -> 0x00c9 }
            r5[r0] = r12     // Catch:{ ClassNotFoundException -> 0x00d2, Exception -> 0x00c9 }
            r5[r3] = r11     // Catch:{ ClassNotFoundException -> 0x00d2, Exception -> 0x00c9 }
            r5[r2] = r10     // Catch:{ ClassNotFoundException -> 0x00d2, Exception -> 0x00c9 }
            java.lang.reflect.Constructor r4 = r4.getConstructor(r5)     // Catch:{ ClassNotFoundException -> 0x00d2, Exception -> 0x00c9 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x00d2, Exception -> 0x00c9 }
            r5[r0] = r21     // Catch:{ ClassNotFoundException -> 0x00d2, Exception -> 0x00c9 }
            r5[r3] = r22     // Catch:{ ClassNotFoundException -> 0x00d2, Exception -> 0x00c9 }
            r5[r2] = r20     // Catch:{ ClassNotFoundException -> 0x00d2, Exception -> 0x00c9 }
            java.lang.Object r4 = r4.newInstance(r5)     // Catch:{ ClassNotFoundException -> 0x00d2, Exception -> 0x00c9 }
            androidx.media3.exoplayer.Renderer r4 = (androidx.media3.exoplayer.Renderer) r4     // Catch:{ ClassNotFoundException -> 0x00d2, Exception -> 0x00c9 }
            int r5 = r6 + 1
            r9.add(r6, r4)     // Catch:{ ClassNotFoundException -> 0x00c7, Exception -> 0x00c9 }
            java.lang.String r4 = "Loaded LibflacAudioRenderer."
            androidx.media3.common.util.Log.f(r13, r4)     // Catch:{ ClassNotFoundException -> 0x00c7, Exception -> 0x00c9 }
            goto L_0x00d3
        L_0x00c7:
            r6 = r5
            goto L_0x00d2
        L_0x00c9:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FLAC extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00d2:
            r5 = r6
        L_0x00d3:
            java.lang.Class<androidx.media3.decoder.ffmpeg.FfmpegAudioRenderer> r4 = androidx.media3.decoder.ffmpeg.FfmpegAudioRenderer.class
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x0101, Exception -> 0x00f8 }
            r6[r0] = r12     // Catch:{ ClassNotFoundException -> 0x0101, Exception -> 0x00f8 }
            r6[r3] = r11     // Catch:{ ClassNotFoundException -> 0x0101, Exception -> 0x00f8 }
            r6[r2] = r10     // Catch:{ ClassNotFoundException -> 0x0101, Exception -> 0x00f8 }
            java.lang.reflect.Constructor r4 = r4.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x0101, Exception -> 0x00f8 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x0101, Exception -> 0x00f8 }
            r1[r0] = r21     // Catch:{ ClassNotFoundException -> 0x0101, Exception -> 0x00f8 }
            r1[r3] = r22     // Catch:{ ClassNotFoundException -> 0x0101, Exception -> 0x00f8 }
            r1[r2] = r20     // Catch:{ ClassNotFoundException -> 0x0101, Exception -> 0x00f8 }
            java.lang.Object r0 = r4.newInstance(r1)     // Catch:{ ClassNotFoundException -> 0x0101, Exception -> 0x00f8 }
            androidx.media3.exoplayer.Renderer r0 = (androidx.media3.exoplayer.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x0101, Exception -> 0x00f8 }
            r9.add(r5, r0)     // Catch:{ ClassNotFoundException -> 0x0101, Exception -> 0x00f8 }
            java.lang.String r0 = "Loaded FfmpegAudioRenderer."
            androidx.media3.common.util.Log.f(r13, r0)     // Catch:{ ClassNotFoundException -> 0x0101, Exception -> 0x00f8 }
            goto L_0x0101
        L_0x00f8:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FFmpeg extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x0101:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.DefaultRenderersFactory.b(android.content.Context, int, androidx.media3.exoplayer.mediacodec.MediaCodecSelector, boolean, androidx.media3.exoplayer.audio.AudioSink, android.os.Handler, androidx.media3.exoplayer.audio.AudioRendererEventListener, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    public AudioSink c(Context context, boolean z2, boolean z3) {
        return new DefaultAudioSink.Builder(context).n(z2).m(z3).i();
    }

    /* access modifiers changed from: protected */
    public void d(Context context, int i2, ArrayList<Renderer> arrayList) {
        arrayList.add(new CameraMotionRenderer());
    }

    /* access modifiers changed from: protected */
    public void e(ArrayList<Renderer> arrayList) {
        arrayList.add(new ImageRenderer(ImageDecoder.Factory.f6605a, (ImageOutput) null));
    }

    /* access modifiers changed from: protected */
    public void f(Context context, MetadataOutput metadataOutput, Looper looper, int i2, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void g(Context context, Handler handler, int i2, ArrayList<Renderer> arrayList) {
    }

    /* access modifiers changed from: protected */
    public void h(Context context, TextOutput textOutput, Looper looper, int i2, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0074, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007c, code lost:
        throw new java.lang.RuntimeException("Error instantiating VP9 extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c1, code lost:
        throw new java.lang.RuntimeException("Error instantiating AV1 extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0074 A[ExcHandler: Exception (r0v8 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b9 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:20:0x0080] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(android.content.Context r17, int r18, androidx.media3.exoplayer.mediacodec.MediaCodecSelector r19, boolean r20, android.os.Handler r21, androidx.media3.exoplayer.video.VideoRendererEventListener r22, long r23, java.util.ArrayList<androidx.media3.exoplayer.Renderer> r25) {
        /*
            r16 = this;
            r0 = r18
            r11 = r25
            java.lang.String r12 = "DefaultRenderersFactory"
            java.lang.Class<androidx.media3.exoplayer.video.VideoRendererEventListener> r13 = androidx.media3.exoplayer.video.VideoRendererEventListener.class
            java.lang.Class<android.os.Handler> r14 = android.os.Handler.class
            androidx.media3.exoplayer.video.MediaCodecVideoRenderer r15 = new androidx.media3.exoplayer.video.MediaCodecVideoRenderer
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter$Factory r3 = r16.j()
            r10 = 50
            r1 = r15
            r2 = r17
            r4 = r19
            r5 = r23
            r7 = r20
            r8 = r21
            r9 = r22
            r1.<init>(r2, r3, r4, r5, r7, r8, r9, r10)
            r11.add(r15)
            if (r0 != 0) goto L_0x0028
            return
        L_0x0028:
            int r1 = r25.size()
            r2 = 2
            if (r0 != r2) goto L_0x0031
            int r1 = r1 + -1
        L_0x0031:
            r0 = 50
            r3 = 3
            r4 = 0
            r5 = 4
            r6 = 1
            java.lang.String r7 = "androidx.media3.decoder.vp9.LibvpxVideoRenderer"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Class r9 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r8[r4] = r9     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r8[r6] = r14     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r8[r2] = r13     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r8[r3] = r9     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.reflect.Constructor r7 = r7.getConstructor(r8)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Long r9 = java.lang.Long.valueOf(r23)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r8[r4] = r9     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r8[r6] = r21     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r8[r2] = r22     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            r8[r3] = r9     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            java.lang.Object r7 = r7.newInstance(r8)     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            androidx.media3.exoplayer.Renderer r7 = (androidx.media3.exoplayer.Renderer) r7     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            int r8 = r1 + 1
            r11.add(r1, r7)     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0074 }
            java.lang.String r1 = "Loaded LibvpxVideoRenderer."
            androidx.media3.common.util.Log.f(r12, r1)     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0074 }
            goto L_0x007e
        L_0x0072:
            r1 = r8
            goto L_0x007d
        L_0x0074:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating VP9 extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x007d:
            r8 = r1
        L_0x007e:
            java.lang.Class<androidx.media3.decoder.av1.Libgav1VideoRenderer> r1 = androidx.media3.decoder.av1.Libgav1VideoRenderer.class
            int r7 = androidx.media3.decoder.av1.Libgav1VideoRenderer.f5096e0     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            java.lang.Class r9 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            r7[r4] = r9     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            r7[r6] = r14     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            r7[r2] = r13     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            r7[r3] = r9     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            java.lang.Long r9 = java.lang.Long.valueOf(r23)     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            r7[r4] = r9     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            r7[r6] = r21     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            r7[r2] = r22     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            r7[r3] = r9     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            java.lang.Object r1 = r1.newInstance(r7)     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            androidx.media3.exoplayer.Renderer r1 = (androidx.media3.exoplayer.Renderer) r1     // Catch:{ ClassNotFoundException -> 0x00c2, Exception -> 0x00b9 }
            int r7 = r8 + 1
            r11.add(r8, r1)     // Catch:{ ClassNotFoundException -> 0x00b7, Exception -> 0x00b9 }
            java.lang.String r1 = "Loaded Libgav1VideoRenderer."
            androidx.media3.common.util.Log.f(r12, r1)     // Catch:{ ClassNotFoundException -> 0x00b7, Exception -> 0x00b9 }
            goto L_0x00c3
        L_0x00b7:
            r8 = r7
            goto L_0x00c2
        L_0x00b9:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating AV1 extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00c2:
            r7 = r8
        L_0x00c3:
            java.lang.String r1 = "androidx.media3.decoder.ffmpeg.ExperimentalFfmpegVideoRenderer"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            java.lang.Class r9 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            r8[r4] = r9     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            r8[r6] = r14     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            r8[r2] = r13     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            r8[r3] = r9     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r8)     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            java.lang.Long r8 = java.lang.Long.valueOf(r23)     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            r5[r4] = r8     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            r5[r6] = r21     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            r5[r2] = r22     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            r5[r3] = r0     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            java.lang.Object r0 = r1.newInstance(r5)     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            androidx.media3.exoplayer.Renderer r0 = (androidx.media3.exoplayer.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            r11.add(r7, r0)     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            java.lang.String r0 = "Loaded FfmpegVideoRenderer."
            androidx.media3.common.util.Log.f(r12, r0)     // Catch:{ ClassNotFoundException -> 0x0105, Exception -> 0x00fc }
            goto L_0x0105
        L_0x00fc:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FFmpeg extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x0105:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.DefaultRenderersFactory.i(android.content.Context, int, androidx.media3.exoplayer.mediacodec.MediaCodecSelector, boolean, android.os.Handler, androidx.media3.exoplayer.video.VideoRendererEventListener, long, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    public MediaCodecAdapter.Factory j() {
        return this.f5223b;
    }

    public final DefaultRenderersFactory k(boolean z2) {
        this.f5226e = z2;
        return this;
    }

    public final DefaultRenderersFactory l(int i2) {
        this.f5224c = i2;
        return this;
    }
}
