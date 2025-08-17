package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.mediacodec.DefaultMediaCodecAdapterFactory;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionRenderer;
import java.util.ArrayList;

public class DefaultRenderersFactory implements RenderersFactory {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22874a;

    /* renamed from: b  reason: collision with root package name */
    private final DefaultMediaCodecAdapterFactory f22875b = new DefaultMediaCodecAdapterFactory();

    /* renamed from: c  reason: collision with root package name */
    private int f22876c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f22877d = 5000;

    /* renamed from: e  reason: collision with root package name */
    private boolean f22878e;

    /* renamed from: f  reason: collision with root package name */
    private MediaCodecSelector f22879f = MediaCodecSelector.f25330a;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22880g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f22881h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f22882i;

    public DefaultRenderersFactory(Context context) {
        this.f22874a = context;
    }

    public Renderer[] a(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        ArrayList arrayList = new ArrayList();
        h(this.f22874a, this.f22876c, this.f22879f, this.f22878e, handler, videoRendererEventListener, this.f22877d, arrayList);
        AudioSink c2 = c(this.f22874a, this.f22880g, this.f22881h, this.f22882i);
        if (c2 != null) {
            b(this.f22874a, this.f22876c, this.f22879f, this.f22878e, c2, handler, audioRendererEventListener, arrayList);
        }
        ArrayList arrayList2 = arrayList;
        g(this.f22874a, textOutput, handler.getLooper(), this.f22876c, arrayList2);
        e(this.f22874a, metadataOutput, handler.getLooper(), this.f22876c, arrayList2);
        d(this.f22874a, this.f22876c, arrayList);
        Handler handler2 = handler;
        f(this.f22874a, handler, this.f22876c, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005b, code lost:
        throw new java.lang.RuntimeException("Error instantiating MIDI extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
        throw new java.lang.RuntimeException("Error instantiating Opus extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00cb, code lost:
        throw new java.lang.RuntimeException("Error instantiating FLAC extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053 A[ExcHandler: Exception (r0v8 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008c A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:20:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c3 A[ExcHandler: Exception (r0v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:33:0x0098] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r16, int r17, com.google.android.exoplayer2.mediacodec.MediaCodecSelector r18, boolean r19, com.google.android.exoplayer2.audio.AudioSink r20, android.os.Handler r21, com.google.android.exoplayer2.audio.AudioRendererEventListener r22, java.util.ArrayList<com.google.android.exoplayer2.Renderer> r23) {
        /*
            r15 = this;
            r0 = r17
            r9 = r23
            java.lang.Class<com.google.android.exoplayer2.audio.AudioSink> r10 = com.google.android.exoplayer2.audio.AudioSink.class
            java.lang.Class<com.google.android.exoplayer2.audio.AudioRendererEventListener> r11 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class
            java.lang.Class<android.os.Handler> r12 = android.os.Handler.class
            java.lang.String r13 = "DefaultRenderersFactory"
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer r14 = new com.google.android.exoplayer2.audio.MediaCodecAudioRenderer
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Factory r3 = r15.i()
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
            java.lang.String r3 = "com.google.android.exoplayer2.decoder.midi.MidiRenderer"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x005c, Exception -> 0x0053 }
            java.lang.Class[] r4 = new java.lang.Class[r0]     // Catch:{ ClassNotFoundException -> 0x005c, Exception -> 0x0053 }
            java.lang.reflect.Constructor r3 = r3.getConstructor(r4)     // Catch:{ ClassNotFoundException -> 0x005c, Exception -> 0x0053 }
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch:{ ClassNotFoundException -> 0x005c, Exception -> 0x0053 }
            java.lang.Object r3 = r3.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x005c, Exception -> 0x0053 }
            com.google.android.exoplayer2.Renderer r3 = (com.google.android.exoplayer2.Renderer) r3     // Catch:{ ClassNotFoundException -> 0x005c, Exception -> 0x0053 }
            int r4 = r1 + 1
            r9.add(r1, r3)     // Catch:{ ClassNotFoundException -> 0x0051, Exception -> 0x0053 }
            java.lang.String r1 = "Loaded MidiRenderer."
            com.google.android.exoplayer2.util.Log.f(r13, r1)     // Catch:{ ClassNotFoundException -> 0x0051, Exception -> 0x0053 }
            goto L_0x005d
        L_0x0051:
            r1 = r4
            goto L_0x005c
        L_0x0053:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating MIDI extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x005c:
            r4 = r1
        L_0x005d:
            r1 = 3
            r3 = 1
            java.lang.String r5 = "com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch:{ ClassNotFoundException -> 0x0095, Exception -> 0x008c }
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x0095, Exception -> 0x008c }
            r6[r0] = r12     // Catch:{ ClassNotFoundException -> 0x0095, Exception -> 0x008c }
            r6[r3] = r11     // Catch:{ ClassNotFoundException -> 0x0095, Exception -> 0x008c }
            r6[r2] = r10     // Catch:{ ClassNotFoundException -> 0x0095, Exception -> 0x008c }
            java.lang.reflect.Constructor r5 = r5.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x0095, Exception -> 0x008c }
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x0095, Exception -> 0x008c }
            r6[r0] = r21     // Catch:{ ClassNotFoundException -> 0x0095, Exception -> 0x008c }
            r6[r3] = r22     // Catch:{ ClassNotFoundException -> 0x0095, Exception -> 0x008c }
            r6[r2] = r20     // Catch:{ ClassNotFoundException -> 0x0095, Exception -> 0x008c }
            java.lang.Object r5 = r5.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x0095, Exception -> 0x008c }
            com.google.android.exoplayer2.Renderer r5 = (com.google.android.exoplayer2.Renderer) r5     // Catch:{ ClassNotFoundException -> 0x0095, Exception -> 0x008c }
            int r6 = r4 + 1
            r9.add(r4, r5)     // Catch:{ ClassNotFoundException -> 0x008a, Exception -> 0x008c }
            java.lang.String r4 = "Loaded LibopusAudioRenderer."
            com.google.android.exoplayer2.util.Log.f(r13, r4)     // Catch:{ ClassNotFoundException -> 0x008a, Exception -> 0x008c }
            goto L_0x0096
        L_0x008a:
            r4 = r6
            goto L_0x0095
        L_0x008c:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating Opus extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x0095:
            r6 = r4
        L_0x0096:
            java.lang.String r4 = "com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ ClassNotFoundException -> 0x00cc, Exception -> 0x00c3 }
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x00cc, Exception -> 0x00c3 }
            r5[r0] = r12     // Catch:{ ClassNotFoundException -> 0x00cc, Exception -> 0x00c3 }
            r5[r3] = r11     // Catch:{ ClassNotFoundException -> 0x00cc, Exception -> 0x00c3 }
            r5[r2] = r10     // Catch:{ ClassNotFoundException -> 0x00cc, Exception -> 0x00c3 }
            java.lang.reflect.Constructor r4 = r4.getConstructor(r5)     // Catch:{ ClassNotFoundException -> 0x00cc, Exception -> 0x00c3 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x00cc, Exception -> 0x00c3 }
            r5[r0] = r21     // Catch:{ ClassNotFoundException -> 0x00cc, Exception -> 0x00c3 }
            r5[r3] = r22     // Catch:{ ClassNotFoundException -> 0x00cc, Exception -> 0x00c3 }
            r5[r2] = r20     // Catch:{ ClassNotFoundException -> 0x00cc, Exception -> 0x00c3 }
            java.lang.Object r4 = r4.newInstance(r5)     // Catch:{ ClassNotFoundException -> 0x00cc, Exception -> 0x00c3 }
            com.google.android.exoplayer2.Renderer r4 = (com.google.android.exoplayer2.Renderer) r4     // Catch:{ ClassNotFoundException -> 0x00cc, Exception -> 0x00c3 }
            int r5 = r6 + 1
            r9.add(r6, r4)     // Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00c3 }
            java.lang.String r4 = "Loaded LibflacAudioRenderer."
            com.google.android.exoplayer2.util.Log.f(r13, r4)     // Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00c3 }
            goto L_0x00cd
        L_0x00c1:
            r6 = r5
            goto L_0x00cc
        L_0x00c3:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FLAC extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00cc:
            r5 = r6
        L_0x00cd:
            java.lang.String r4 = "com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer"
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ ClassNotFoundException -> 0x00ff, Exception -> 0x00f6 }
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x00ff, Exception -> 0x00f6 }
            r6[r0] = r12     // Catch:{ ClassNotFoundException -> 0x00ff, Exception -> 0x00f6 }
            r6[r3] = r11     // Catch:{ ClassNotFoundException -> 0x00ff, Exception -> 0x00f6 }
            r6[r2] = r10     // Catch:{ ClassNotFoundException -> 0x00ff, Exception -> 0x00f6 }
            java.lang.reflect.Constructor r4 = r4.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x00ff, Exception -> 0x00f6 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x00ff, Exception -> 0x00f6 }
            r1[r0] = r21     // Catch:{ ClassNotFoundException -> 0x00ff, Exception -> 0x00f6 }
            r1[r3] = r22     // Catch:{ ClassNotFoundException -> 0x00ff, Exception -> 0x00f6 }
            r1[r2] = r20     // Catch:{ ClassNotFoundException -> 0x00ff, Exception -> 0x00f6 }
            java.lang.Object r0 = r4.newInstance(r1)     // Catch:{ ClassNotFoundException -> 0x00ff, Exception -> 0x00f6 }
            com.google.android.exoplayer2.Renderer r0 = (com.google.android.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00ff, Exception -> 0x00f6 }
            r9.add(r5, r0)     // Catch:{ ClassNotFoundException -> 0x00ff, Exception -> 0x00f6 }
            java.lang.String r0 = "Loaded FfmpegAudioRenderer."
            com.google.android.exoplayer2.util.Log.f(r13, r0)     // Catch:{ ClassNotFoundException -> 0x00ff, Exception -> 0x00f6 }
            goto L_0x00ff
        L_0x00f6:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FFmpeg extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultRenderersFactory.b(android.content.Context, int, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, boolean, com.google.android.exoplayer2.audio.AudioSink, android.os.Handler, com.google.android.exoplayer2.audio.AudioRendererEventListener, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    public AudioSink c(Context context, boolean z2, boolean z3, boolean z4) {
        return new DefaultAudioSink.Builder().g(AudioCapabilities.c(context)).i(z2).h(z3).j(z4 ? 1 : 0).f();
    }

    /* access modifiers changed from: protected */
    public void d(Context context, int i2, ArrayList<Renderer> arrayList) {
        arrayList.add(new CameraMotionRenderer());
    }

    /* access modifiers changed from: protected */
    public void e(Context context, MetadataOutput metadataOutput, Looper looper, int i2, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    /* access modifiers changed from: protected */
    public void f(Context context, Handler handler, int i2, ArrayList<Renderer> arrayList) {
    }

    /* access modifiers changed from: protected */
    public void g(Context context, TextOutput textOutput, Looper looper, int i2, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0074, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007c, code lost:
        throw new java.lang.RuntimeException("Error instantiating VP9 extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0074 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0039] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(android.content.Context r17, int r18, com.google.android.exoplayer2.mediacodec.MediaCodecSelector r19, boolean r20, android.os.Handler r21, com.google.android.exoplayer2.video.VideoRendererEventListener r22, long r23, java.util.ArrayList<com.google.android.exoplayer2.Renderer> r25) {
        /*
            r16 = this;
            r0 = r18
            r11 = r25
            java.lang.String r12 = "DefaultRenderersFactory"
            java.lang.Class<com.google.android.exoplayer2.video.VideoRendererEventListener> r13 = com.google.android.exoplayer2.video.VideoRendererEventListener.class
            java.lang.Class<android.os.Handler> r14 = android.os.Handler.class
            com.google.android.exoplayer2.video.MediaCodecVideoRenderer r15 = new com.google.android.exoplayer2.video.MediaCodecVideoRenderer
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Factory r3 = r16.i()
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
            java.lang.String r7 = "com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer"
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
            com.google.android.exoplayer2.Renderer r7 = (com.google.android.exoplayer2.Renderer) r7     // Catch:{ ClassNotFoundException -> 0x007d, Exception -> 0x0074 }
            int r8 = r1 + 1
            r11.add(r1, r7)     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0074 }
            java.lang.String r1 = "Loaded LibvpxVideoRenderer."
            com.google.android.exoplayer2.util.Log.f(r12, r1)     // Catch:{ ClassNotFoundException -> 0x0072, Exception -> 0x0074 }
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
            java.lang.String r1 = "com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            java.lang.Class r9 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            r7[r4] = r9     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            r7[r6] = r14     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            r7[r2] = r13     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            r7[r3] = r9     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            java.lang.Long r7 = java.lang.Long.valueOf(r23)     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            r5[r4] = r7     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            r5[r6] = r21     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            r5[r2] = r22     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            r5[r3] = r0     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            java.lang.Object r0 = r1.newInstance(r5)     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            com.google.android.exoplayer2.Renderer r0 = (com.google.android.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            r11.add(r8, r0)     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            java.lang.String r0 = "Loaded Libgav1VideoRenderer."
            com.google.android.exoplayer2.util.Log.f(r12, r0)     // Catch:{ ClassNotFoundException -> 0x00c0, Exception -> 0x00b7 }
            goto L_0x00c0
        L_0x00b7:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating AV1 extension"
            r1.<init>(r2, r0)
            throw r1
        L_0x00c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultRenderersFactory.h(android.content.Context, int, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, boolean, android.os.Handler, com.google.android.exoplayer2.video.VideoRendererEventListener, long, java.util.ArrayList):void");
    }

    /* access modifiers changed from: protected */
    public MediaCodecAdapter.Factory i() {
        return this.f22875b;
    }
}
