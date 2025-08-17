package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.NetworkInfo;
import com.facebook.imagepipeline.common.RotationOptions;
import com.squareup.picasso.NetworkRequestHandler;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

class BitmapHunter implements Runnable {
    private static final Object DECODE_LOCK = new Object();
    private static final RequestHandler ERRORING_HANDLER = new RequestHandler() {
        public boolean canHandleRequest(Request request) {
            return true;
        }

        public RequestHandler.Result load(Request request, int i2) throws IOException {
            throw new IllegalStateException("Unrecognized type of request: " + request);
        }
    };
    private static final ThreadLocal<StringBuilder> NAME_BUILDER = new ThreadLocal<StringBuilder>() {
        /* access modifiers changed from: protected */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    };
    private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();
    Action action;
    List<Action> actions;
    final Cache cache;
    final Request data;
    final Dispatcher dispatcher;
    Exception exception;
    int exifOrientation;
    Future<?> future;
    final String key;
    Picasso.LoadedFrom loadedFrom;
    final int memoryPolicy;
    int networkPolicy;
    final Picasso picasso;
    Picasso.Priority priority;
    final RequestHandler requestHandler;
    Bitmap result;
    int retryCount;
    final int sequence = SEQUENCE_GENERATOR.incrementAndGet();
    final Stats stats;

    BitmapHunter(Picasso picasso2, Dispatcher dispatcher2, Cache cache2, Stats stats2, Action action2, RequestHandler requestHandler2) {
        this.picasso = picasso2;
        this.dispatcher = dispatcher2;
        this.cache = cache2;
        this.stats = stats2;
        this.action = action2;
        this.key = action2.getKey();
        this.data = action2.getRequest();
        this.priority = action2.getPriority();
        this.memoryPolicy = action2.getMemoryPolicy();
        this.networkPolicy = action2.getNetworkPolicy();
        this.requestHandler = requestHandler2;
        this.retryCount = requestHandler2.getRetryCount();
    }

    static Bitmap applyCustomTransformations(List<Transformation> list, Bitmap bitmap) {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            final Transformation transformation = list.get(i2);
            try {
                Bitmap transform = transformation.transform(bitmap);
                if (transform == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(transformation.key());
                    sb.append(" returned null after ");
                    sb.append(i2);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (Transformation key2 : list) {
                        sb.append(key2.key());
                        sb.append(10);
                    }
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            throw new NullPointerException(sb.toString());
                        }
                    });
                    return null;
                } else if (transform == bitmap && bitmap.isRecycled()) {
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            throw new IllegalStateException("Transformation " + transformation.key() + " returned input Bitmap but recycled it.");
                        }
                    });
                    return null;
                } else if (transform == bitmap || bitmap.isRecycled()) {
                    i2++;
                    bitmap = transform;
                } else {
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            throw new IllegalStateException("Transformation " + transformation.key() + " mutated input Bitmap but failed to recycle the original.");
                        }
                    });
                    return null;
                }
            } catch (RuntimeException e2) {
                Picasso.HANDLER.post(new Runnable() {
                    public void run() {
                        throw new RuntimeException("Transformation " + transformation.key() + " crashed with exception.", e2);
                    }
                });
                return null;
            }
        }
        return bitmap;
    }

    private Picasso.Priority computeNewPriority() {
        boolean z2;
        Picasso.Priority priority2 = Picasso.Priority.LOW;
        List<Action> list = this.actions;
        boolean z3 = true;
        if (list == null || list.isEmpty()) {
            z2 = false;
        } else {
            z2 = true;
        }
        Action action2 = this.action;
        if (action2 == null && !z2) {
            z3 = false;
        }
        if (!z3) {
            return priority2;
        }
        if (action2 != null) {
            priority2 = action2.getPriority();
        }
        if (z2) {
            int size = this.actions.size();
            for (int i2 = 0; i2 < size; i2++) {
                Picasso.Priority priority3 = this.actions.get(i2).getPriority();
                if (priority3.ordinal() > priority2.ordinal()) {
                    priority2 = priority3;
                }
            }
        }
        return priority2;
    }

    static Bitmap decodeStream(Source source, Request request) throws IOException {
        BufferedSource d2 = Okio.d(source);
        boolean isWebPFile = Utils.isWebPFile(d2);
        boolean z2 = request.purgeable;
        BitmapFactory.Options createBitmapOptions = RequestHandler.createBitmapOptions(request);
        boolean requiresInSampleSize = RequestHandler.requiresInSampleSize(createBitmapOptions);
        if (!isWebPFile) {
            InputStream d3 = d2.d();
            if (requiresInSampleSize) {
                MarkableInputStream markableInputStream = new MarkableInputStream(d3);
                markableInputStream.allowMarksToExpire(false);
                long savePosition = markableInputStream.savePosition(1024);
                BitmapFactory.decodeStream(markableInputStream, (Rect) null, createBitmapOptions);
                RequestHandler.calculateInSampleSize(request.targetWidth, request.targetHeight, createBitmapOptions, request);
                markableInputStream.reset(savePosition);
                markableInputStream.allowMarksToExpire(true);
                d3 = markableInputStream;
            }
            Bitmap decodeStream = BitmapFactory.decodeStream(d3, (Rect) null, createBitmapOptions);
            if (decodeStream != null) {
                return decodeStream;
            }
            throw new IOException("Failed to decode stream.");
        }
        byte[] U = d2.U();
        if (requiresInSampleSize) {
            BitmapFactory.decodeByteArray(U, 0, U.length, createBitmapOptions);
            RequestHandler.calculateInSampleSize(request.targetWidth, request.targetHeight, createBitmapOptions, request);
        }
        return BitmapFactory.decodeByteArray(U, 0, U.length, createBitmapOptions);
    }

    static BitmapHunter forRequest(Picasso picasso2, Dispatcher dispatcher2, Cache cache2, Stats stats2, Action action2) {
        Request request = action2.getRequest();
        List<RequestHandler> requestHandlers = picasso2.getRequestHandlers();
        int size = requestHandlers.size();
        for (int i2 = 0; i2 < size; i2++) {
            RequestHandler requestHandler2 = requestHandlers.get(i2);
            if (requestHandler2.canHandleRequest(request)) {
                return new BitmapHunter(picasso2, dispatcher2, cache2, stats2, action2, requestHandler2);
            }
        }
        return new BitmapHunter(picasso2, dispatcher2, cache2, stats2, action2, ERRORING_HANDLER);
    }

    static int getExifRotation(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return RotationOptions.ROTATE_180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return RotationOptions.ROTATE_270;
            default:
                return 0;
        }
    }

    static int getExifTranslation(int i2) {
        return (i2 == 2 || i2 == 7 || i2 == 4 || i2 == 5) ? -1 : 1;
    }

    private static boolean shouldResize(boolean z2, int i2, int i3, int i4, int i5) {
        return !z2 || (i4 != 0 && i2 > i4) || (i5 != 0 && i3 > i5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0265  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Bitmap transformResult(com.squareup.picasso.Request r26, android.graphics.Bitmap r27, int r28) {
        /*
            r0 = r26
            int r1 = r27.getWidth()
            int r2 = r27.getHeight()
            boolean r3 = r0.onlyScaleDown
            android.graphics.Matrix r9 = new android.graphics.Matrix
            r9.<init>()
            boolean r4 = r26.needsMatrixTransform()
            if (r4 != 0) goto L_0x001f
            if (r28 == 0) goto L_0x001a
            goto L_0x001f
        L_0x001a:
            r3 = r1
            r5 = r2
            r0 = r9
            goto L_0x0251
        L_0x001f:
            int r4 = r0.targetWidth
            int r6 = r0.targetHeight
            float r7 = r0.rotationDegrees
            r8 = 0
            int r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r8 == 0) goto L_0x0144
            double r10 = (double) r7
            double r12 = java.lang.Math.toRadians(r10)
            double r12 = java.lang.Math.cos(r12)
            double r10 = java.lang.Math.toRadians(r10)
            double r10 = java.lang.Math.sin(r10)
            boolean r4 = r0.hasRotationPivot
            if (r4 == 0) goto L_0x00d5
            float r4 = r0.rotationPivotX
            float r6 = r0.rotationPivotY
            r9.setRotate(r7, r4, r6)
            float r4 = r0.rotationPivotX
            double r6 = (double) r4
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r14 = r14 - r12
            double r6 = r6 * r14
            float r8 = r0.rotationPivotY
            r16 = r2
            r17 = r3
            double r2 = (double) r8
            double r2 = r2 * r10
            double r6 = r6 + r2
            double r2 = (double) r8
            double r2 = r2 * r14
            double r14 = (double) r4
            double r14 = r14 * r10
            double r2 = r2 - r14
            int r4 = r0.targetWidth
            double r14 = (double) r4
            double r14 = r14 * r12
            double r14 = r14 + r6
            r18 = r6
            double r5 = (double) r4
            double r5 = r5 * r10
            double r5 = r5 + r2
            r20 = r9
            double r8 = (double) r4
            double r8 = r8 * r12
            double r7 = r18 + r8
            int r9 = r0.targetHeight
            r22 = r1
            double r0 = (double) r9
            double r0 = r0 * r10
            double r7 = r7 - r0
            double r0 = (double) r4
            double r0 = r0 * r10
            double r0 = r0 + r2
            r23 = r5
            double r4 = (double) r9
            double r4 = r4 * r12
            double r0 = r0 + r4
            double r4 = (double) r9
            double r4 = r4 * r10
            double r4 = r18 - r4
            double r9 = (double) r9
            double r9 = r9 * r12
            double r9 = r9 + r2
            r11 = r18
            r18 = r9
            double r9 = java.lang.Math.max(r11, r14)
            double r9 = java.lang.Math.max(r7, r9)
            double r9 = java.lang.Math.max(r4, r9)
            double r11 = java.lang.Math.min(r11, r14)
            double r6 = java.lang.Math.min(r7, r11)
            double r4 = java.lang.Math.min(r4, r6)
            r6 = r23
            double r11 = java.lang.Math.max(r2, r6)
            double r11 = java.lang.Math.max(r0, r11)
            r13 = r18
            double r11 = java.lang.Math.max(r13, r11)
            double r2 = java.lang.Math.min(r2, r6)
            double r0 = java.lang.Math.min(r0, r2)
            double r0 = java.lang.Math.min(r13, r0)
            double r9 = r9 - r4
            double r2 = java.lang.Math.floor(r9)
            int r4 = (int) r2
            double r11 = r11 - r0
            double r0 = java.lang.Math.floor(r11)
            int r6 = (int) r0
            r0 = r20
            goto L_0x014b
        L_0x00d5:
            r22 = r1
            r16 = r2
            r17 = r3
            r0 = r9
            r0.setRotate(r7)
            r1 = r26
            int r2 = r1.targetWidth
            double r3 = (double) r2
            double r3 = r3 * r12
            double r5 = (double) r2
            double r5 = r5 * r10
            double r7 = (double) r2
            double r7 = r7 * r12
            int r9 = r1.targetHeight
            double r14 = (double) r9
            double r14 = r14 * r10
            double r7 = r7 - r14
            double r14 = (double) r2
            double r14 = r14 * r10
            double r1 = (double) r9
            double r1 = r1 * r12
            double r14 = r14 + r1
            double r1 = (double) r9
            double r1 = r1 * r10
            double r1 = -r1
            double r9 = (double) r9
            double r9 = r9 * r12
            r11 = 0
            r18 = r9
            double r9 = java.lang.Math.max(r11, r3)
            double r9 = java.lang.Math.max(r7, r9)
            double r9 = java.lang.Math.max(r1, r9)
            double r3 = java.lang.Math.min(r11, r3)
            double r3 = java.lang.Math.min(r7, r3)
            double r1 = java.lang.Math.min(r1, r3)
            double r3 = java.lang.Math.max(r11, r5)
            double r3 = java.lang.Math.max(r14, r3)
            r7 = r18
            double r3 = java.lang.Math.max(r7, r3)
            double r5 = java.lang.Math.min(r11, r5)
            double r5 = java.lang.Math.min(r14, r5)
            double r5 = java.lang.Math.min(r7, r5)
            double r9 = r9 - r1
            double r1 = java.lang.Math.floor(r9)
            int r1 = (int) r1
            double r3 = r3 - r5
            double r2 = java.lang.Math.floor(r3)
            int r6 = (int) r2
            r4 = r1
            goto L_0x014b
        L_0x0144:
            r22 = r1
            r16 = r2
            r17 = r3
            r0 = r9
        L_0x014b:
            if (r28 == 0) goto L_0x0171
            int r1 = getExifRotation(r28)
            int r2 = getExifTranslation(r28)
            if (r1 == 0) goto L_0x0168
            float r3 = (float) r1
            r0.preRotate(r3)
            r3 = 90
            if (r1 == r3) goto L_0x0163
            r3 = 270(0x10e, float:3.78E-43)
            if (r1 != r3) goto L_0x0168
        L_0x0163:
            r25 = r6
            r6 = r4
            r4 = r25
        L_0x0168:
            r1 = 1
            if (r2 == r1) goto L_0x0171
            float r1 = (float) r2
            r2 = 1065353216(0x3f800000, float:1.0)
            r0.postScale(r1, r2)
        L_0x0171:
            r1 = r26
            boolean r2 = r1.centerCrop
            if (r2 == 0) goto L_0x0206
            if (r4 == 0) goto L_0x0181
            float r2 = (float) r4
            r3 = r22
            float r5 = (float) r3
            float r2 = r2 / r5
            r5 = r16
            goto L_0x0188
        L_0x0181:
            r3 = r22
            float r2 = (float) r6
            r5 = r16
            float r7 = (float) r5
            float r2 = r2 / r7
        L_0x0188:
            if (r6 == 0) goto L_0x018d
            float r7 = (float) r6
            float r8 = (float) r5
            goto L_0x018f
        L_0x018d:
            float r7 = (float) r4
            float r8 = (float) r3
        L_0x018f:
            float r7 = r7 / r8
            int r8 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x01bf
            float r8 = (float) r5
            float r7 = r7 / r2
            float r8 = r8 * r7
            double r7 = (double) r8
            double r7 = java.lang.Math.ceil(r7)
            int r7 = (int) r7
            int r1 = r1.centerCropGravity
            r8 = r1 & 48
            r9 = 48
            if (r8 != r9) goto L_0x01a8
            r1 = 0
            goto L_0x01b4
        L_0x01a8:
            r8 = 80
            r1 = r1 & r8
            if (r1 != r8) goto L_0x01b0
            int r1 = r5 - r7
            goto L_0x01b4
        L_0x01b0:
            int r1 = r5 - r7
            int r1 = r1 / 2
        L_0x01b4:
            float r8 = (float) r6
            float r9 = (float) r7
            float r8 = r8 / r9
            r9 = r7
            r10 = r17
            r21 = 0
            r7 = r1
            r1 = r3
            goto L_0x01f7
        L_0x01bf:
            int r8 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r8 >= 0) goto L_0x01ee
            float r8 = (float) r3
            float r2 = r2 / r7
            float r8 = r8 * r2
            double r8 = (double) r8
            double r8 = java.lang.Math.ceil(r8)
            int r2 = (int) r8
            int r1 = r1.centerCropGravity
            r8 = r1 & 3
            r9 = 3
            if (r8 != r9) goto L_0x01d6
            r1 = 0
            goto L_0x01e1
        L_0x01d6:
            r8 = 5
            r1 = r1 & r8
            if (r1 != r8) goto L_0x01dd
            int r1 = r3 - r2
            goto L_0x01e1
        L_0x01dd:
            int r1 = r3 - r2
            int r1 = r1 / 2
        L_0x01e1:
            float r8 = (float) r4
            float r9 = (float) r2
            float r8 = r8 / r9
            r21 = r1
            r1 = r2
            r9 = r5
            r2 = r8
            r10 = r17
            r8 = r7
            r7 = 0
            goto L_0x01f7
        L_0x01ee:
            r1 = r3
            r9 = r5
            r2 = r7
            r8 = r2
            r10 = r17
            r7 = 0
            r21 = 0
        L_0x01f7:
            boolean r3 = shouldResize(r10, r3, r5, r4, r6)
            if (r3 == 0) goto L_0x0200
            r0.preScale(r2, r8)
        L_0x0200:
            r6 = r7
            r8 = r9
            r5 = r21
            r7 = r1
            goto L_0x0255
        L_0x0206:
            r5 = r16
            r10 = r17
            r3 = r22
            boolean r1 = r1.centerInside
            if (r1 == 0) goto L_0x0230
            if (r4 == 0) goto L_0x0215
            float r1 = (float) r4
            float r2 = (float) r3
            goto L_0x0217
        L_0x0215:
            float r1 = (float) r6
            float r2 = (float) r5
        L_0x0217:
            float r1 = r1 / r2
            if (r6 == 0) goto L_0x021d
            float r2 = (float) r6
            float r7 = (float) r5
            goto L_0x021f
        L_0x021d:
            float r2 = (float) r4
            float r7 = (float) r3
        L_0x021f:
            float r2 = r2 / r7
            int r7 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x0225
            goto L_0x0226
        L_0x0225:
            r1 = r2
        L_0x0226:
            boolean r2 = shouldResize(r10, r3, r5, r4, r6)
            if (r2 == 0) goto L_0x0251
            r0.preScale(r1, r1)
            goto L_0x0251
        L_0x0230:
            if (r4 != 0) goto L_0x0234
            if (r6 == 0) goto L_0x0251
        L_0x0234:
            if (r4 != r3) goto L_0x0238
            if (r6 == r5) goto L_0x0251
        L_0x0238:
            if (r4 == 0) goto L_0x023d
            float r1 = (float) r4
            float r2 = (float) r3
            goto L_0x023f
        L_0x023d:
            float r1 = (float) r6
            float r2 = (float) r5
        L_0x023f:
            float r1 = r1 / r2
            if (r6 == 0) goto L_0x0245
            float r2 = (float) r6
            float r7 = (float) r5
            goto L_0x0247
        L_0x0245:
            float r2 = (float) r4
            float r7 = (float) r3
        L_0x0247:
            float r2 = r2 / r7
            boolean r4 = shouldResize(r10, r3, r5, r4, r6)
            if (r4 == 0) goto L_0x0251
            r0.preScale(r1, r2)
        L_0x0251:
            r7 = r3
            r8 = r5
            r5 = 0
            r6 = 0
        L_0x0255:
            r10 = 1
            r4 = r27
            r9 = r0
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r4, r5, r6, r7, r8, r9, r10)
            r1 = r27
            if (r0 == r1) goto L_0x0265
            r27.recycle()
            goto L_0x0266
        L_0x0265:
            r0 = r1
        L_0x0266:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.BitmapHunter.transformResult(com.squareup.picasso.Request, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    static void updateThreadName(Request request) {
        String name = request.getName();
        StringBuilder sb = NAME_BUILDER.get();
        sb.ensureCapacity(name.length() + 8);
        sb.replace(8, sb.length(), name);
        Thread.currentThread().setName(sb.toString());
    }

    /* access modifiers changed from: package-private */
    public void attach(Action action2) {
        boolean z2 = this.picasso.loggingEnabled;
        Request request = action2.request;
        if (this.action == null) {
            this.action = action2;
            if (z2) {
                List<Action> list = this.actions;
                if (list == null || list.isEmpty()) {
                    Utils.log("Hunter", "joined", request.logId(), "to empty hunter");
                } else {
                    Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to "));
                }
            }
        } else {
            if (this.actions == null) {
                this.actions = new ArrayList(3);
            }
            this.actions.add(action2);
            if (z2) {
                Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to "));
            }
            Picasso.Priority priority2 = action2.getPriority();
            if (priority2.ordinal() > this.priority.ordinal()) {
                this.priority = priority2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean cancel() {
        Future<?> future2;
        if (this.action != null) {
            return false;
        }
        List<Action> list = this.actions;
        if ((list == null || list.isEmpty()) && (future2 = this.future) != null && future2.cancel(false)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void detach(Action action2) {
        boolean z2;
        if (this.action == action2) {
            this.action = null;
            z2 = true;
        } else {
            List<Action> list = this.actions;
            if (list != null) {
                z2 = list.remove(action2);
            } else {
                z2 = false;
            }
        }
        if (z2 && action2.getPriority() == this.priority) {
            this.priority = computeNewPriority();
        }
        if (this.picasso.loggingEnabled) {
            Utils.log("Hunter", "removed", action2.request.logId(), Utils.getLogIdsForHunter(this, "from "));
        }
    }

    /* access modifiers changed from: package-private */
    public Action getAction() {
        return this.action;
    }

    /* access modifiers changed from: package-private */
    public List<Action> getActions() {
        return this.actions;
    }

    /* access modifiers changed from: package-private */
    public Request getData() {
        return this.data;
    }

    /* access modifiers changed from: package-private */
    public Exception getException() {
        return this.exception;
    }

    /* access modifiers changed from: package-private */
    public String getKey() {
        return this.key;
    }

    /* access modifiers changed from: package-private */
    public Picasso.LoadedFrom getLoadedFrom() {
        return this.loadedFrom;
    }

    /* access modifiers changed from: package-private */
    public int getMemoryPolicy() {
        return this.memoryPolicy;
    }

    /* access modifiers changed from: package-private */
    public Picasso getPicasso() {
        return this.picasso;
    }

    /* access modifiers changed from: package-private */
    public Picasso.Priority getPriority() {
        return this.priority;
    }

    /* access modifiers changed from: package-private */
    public Bitmap getResult() {
        return this.result;
    }

    /* access modifiers changed from: package-private */
    public Bitmap hunt() throws IOException {
        Bitmap bitmap;
        int i2;
        if (MemoryPolicy.shouldReadFromMemoryCache(this.memoryPolicy)) {
            bitmap = this.cache.get(this.key);
            if (bitmap != null) {
                this.stats.dispatchCacheHit();
                this.loadedFrom = Picasso.LoadedFrom.MEMORY;
                if (this.picasso.loggingEnabled) {
                    Utils.log("Hunter", "decoded", this.data.logId(), "from cache");
                }
                return bitmap;
            }
        } else {
            bitmap = null;
        }
        if (this.retryCount == 0) {
            i2 = NetworkPolicy.OFFLINE.index;
        } else {
            i2 = this.networkPolicy;
        }
        this.networkPolicy = i2;
        RequestHandler.Result load = this.requestHandler.load(this.data, i2);
        if (load != null) {
            this.loadedFrom = load.getLoadedFrom();
            this.exifOrientation = load.getExifOrientation();
            bitmap = load.getBitmap();
            if (bitmap == null) {
                Source source = load.getSource();
                try {
                    bitmap = decodeStream(source, this.data);
                } finally {
                    try {
                        source.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }
        if (bitmap != null) {
            if (this.picasso.loggingEnabled) {
                Utils.log("Hunter", "decoded", this.data.logId());
            }
            this.stats.dispatchBitmapDecoded(bitmap);
            if (this.data.needsTransformation() || this.exifOrientation != 0) {
                synchronized (DECODE_LOCK) {
                    if (this.data.needsMatrixTransform() || this.exifOrientation != 0) {
                        bitmap = transformResult(this.data, bitmap, this.exifOrientation);
                        if (this.picasso.loggingEnabled) {
                            Utils.log("Hunter", "transformed", this.data.logId());
                        }
                    }
                    if (this.data.hasCustomTransformations()) {
                        bitmap = applyCustomTransformations(this.data.transformations, bitmap);
                        if (this.picasso.loggingEnabled) {
                            Utils.log("Hunter", "transformed", this.data.logId(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.stats.dispatchBitmapTransformed(bitmap);
                }
            }
        }
        return bitmap;
    }

    /* access modifiers changed from: package-private */
    public boolean isCancelled() {
        Future<?> future2 = this.future;
        return future2 != null && future2.isCancelled();
    }

    public void run() {
        try {
            updateThreadName(this.data);
            if (this.picasso.loggingEnabled) {
                Utils.log("Hunter", "executing", Utils.getLogIdsForHunter(this));
            }
            Bitmap hunt = hunt();
            this.result = hunt;
            if (hunt == null) {
                this.dispatcher.dispatchFailed(this);
            } else {
                this.dispatcher.dispatchComplete(this);
            }
        } catch (NetworkRequestHandler.ResponseException e2) {
            if (!NetworkPolicy.isOfflineOnly(e2.networkPolicy) || e2.code != 504) {
                this.exception = e2;
            }
            this.dispatcher.dispatchFailed(this);
        } catch (IOException e3) {
            this.exception = e3;
            this.dispatcher.dispatchRetry(this);
        } catch (OutOfMemoryError e4) {
            StringWriter stringWriter = new StringWriter();
            this.stats.createSnapshot().dump(new PrintWriter(stringWriter));
            this.exception = new RuntimeException(stringWriter.toString(), e4);
            this.dispatcher.dispatchFailed(this);
        } catch (Exception e5) {
            this.exception = e5;
            this.dispatcher.dispatchFailed(this);
        } catch (Throwable th) {
            Thread.currentThread().setName("Picasso-Idle");
            throw th;
        }
        Thread.currentThread().setName("Picasso-Idle");
    }

    /* access modifiers changed from: package-private */
    public boolean shouldRetry(boolean z2, NetworkInfo networkInfo) {
        boolean z3;
        int i2 = this.retryCount;
        if (i2 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return false;
        }
        this.retryCount = i2 - 1;
        return this.requestHandler.shouldRetry(z2, networkInfo);
    }

    /* access modifiers changed from: package-private */
    public boolean supportsReplay() {
        return this.requestHandler.supportsReplay();
    }
}
