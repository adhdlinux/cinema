package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.MetadataRepo;
import java.util.Arrays;

final class EmojiProcessor {

    /* renamed from: a  reason: collision with root package name */
    private final EmojiCompat.SpanFactory f3089a;

    /* renamed from: b  reason: collision with root package name */
    private final MetadataRepo f3090b;

    /* renamed from: c  reason: collision with root package name */
    private EmojiCompat.GlyphChecker f3091c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3092d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f3093e;

    private static final class CodepointIndexFinder {
        private CodepointIndexFinder() {
        }

        static int a(CharSequence charSequence, int i2, int i3) {
            int length = charSequence.length();
            if (i2 < 0 || length < i2 || i3 < 0) {
                return -1;
            }
            while (true) {
                boolean z2 = false;
                while (i3 != 0) {
                    i2--;
                    if (i2 >= 0) {
                        char charAt = charSequence.charAt(i2);
                        if (z2) {
                            if (!Character.isHighSurrogate(charAt)) {
                                return -1;
                            }
                            i3--;
                        } else if (!Character.isSurrogate(charAt)) {
                            i3--;
                        } else if (Character.isHighSurrogate(charAt)) {
                            return -1;
                        } else {
                            z2 = true;
                        }
                    } else if (z2) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
                return i2;
            }
        }

        static int b(CharSequence charSequence, int i2, int i3) {
            int length = charSequence.length();
            if (i2 < 0 || length < i2 || i3 < 0) {
                return -1;
            }
            while (true) {
                boolean z2 = false;
                while (i3 != 0) {
                    if (r7 < length) {
                        char charAt = charSequence.charAt(r7);
                        if (z2) {
                            if (!Character.isLowSurrogate(charAt)) {
                                return -1;
                            }
                            i3--;
                            i2 = r7 + 1;
                        } else if (!Character.isSurrogate(charAt)) {
                            i3--;
                            r7++;
                        } else if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        } else {
                            r7++;
                            z2 = true;
                        }
                    } else if (z2) {
                        return -1;
                    } else {
                        return length;
                    }
                }
                return r7;
            }
        }
    }

    static final class ProcessorSm {

        /* renamed from: a  reason: collision with root package name */
        private int f3094a = 1;

        /* renamed from: b  reason: collision with root package name */
        private final MetadataRepo.Node f3095b;

        /* renamed from: c  reason: collision with root package name */
        private MetadataRepo.Node f3096c;

        /* renamed from: d  reason: collision with root package name */
        private MetadataRepo.Node f3097d;

        /* renamed from: e  reason: collision with root package name */
        private int f3098e;

        /* renamed from: f  reason: collision with root package name */
        private int f3099f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f3100g;

        /* renamed from: h  reason: collision with root package name */
        private final int[] f3101h;

        ProcessorSm(MetadataRepo.Node node, boolean z2, int[] iArr) {
            this.f3095b = node;
            this.f3096c = node;
            this.f3100g = z2;
            this.f3101h = iArr;
        }

        private static boolean d(int i2) {
            return i2 == 65039;
        }

        private static boolean f(int i2) {
            return i2 == 65038;
        }

        private int g() {
            this.f3094a = 1;
            this.f3096c = this.f3095b;
            this.f3099f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f3096c.b().j() || d(this.f3098e)) {
                return true;
            }
            if (this.f3100g) {
                if (this.f3101h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f3101h, this.f3096c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public int a(int i2) {
            MetadataRepo.Node a2 = this.f3096c.a(i2);
            int i3 = 2;
            if (this.f3094a != 2) {
                if (a2 == null) {
                    i3 = g();
                } else {
                    this.f3094a = 2;
                    this.f3096c = a2;
                    this.f3099f = 1;
                }
            } else if (a2 != null) {
                this.f3096c = a2;
                this.f3099f++;
            } else if (f(i2)) {
                i3 = g();
            } else if (!d(i2)) {
                if (this.f3096c.b() != null) {
                    i3 = 3;
                    if (this.f3099f != 1) {
                        this.f3097d = this.f3096c;
                        g();
                    } else if (h()) {
                        this.f3097d = this.f3096c;
                        g();
                    } else {
                        i3 = g();
                    }
                } else {
                    i3 = g();
                }
            }
            this.f3098e = i2;
            return i3;
        }

        /* access modifiers changed from: package-private */
        public EmojiMetadata b() {
            return this.f3096c.b();
        }

        /* access modifiers changed from: package-private */
        public EmojiMetadata c() {
            return this.f3097d.b();
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            if (this.f3094a != 2 || this.f3096c.b() == null || (this.f3099f <= 1 && !h())) {
                return false;
            }
            return true;
        }
    }

    EmojiProcessor(MetadataRepo metadataRepo, EmojiCompat.SpanFactory spanFactory, EmojiCompat.GlyphChecker glyphChecker, boolean z2, int[] iArr) {
        this.f3089a = spanFactory;
        this.f3090b = metadataRepo;
        this.f3091c = glyphChecker;
        this.f3092d = z2;
        this.f3093e = iArr;
    }

    private void a(Spannable spannable, EmojiMetadata emojiMetadata, int i2, int i3) {
        spannable.setSpan(this.f3089a.a(emojiMetadata), i2, i3, 33);
    }

    private static boolean b(Editable editable, KeyEvent keyEvent, boolean z2) {
        EmojiSpan[] emojiSpanArr;
        if (g(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!f(selectionStart, selectionEnd) && (emojiSpanArr = (EmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, EmojiSpan.class)) != null && emojiSpanArr.length > 0) {
            int length = emojiSpanArr.length;
            int i2 = 0;
            while (i2 < length) {
                EmojiSpan emojiSpan = emojiSpanArr[i2];
                int spanStart = editable.getSpanStart(emojiSpan);
                int spanEnd = editable.getSpanEnd(emojiSpan);
                if ((!z2 || spanStart != selectionStart) && ((z2 || spanEnd != selectionStart) && (selectionStart <= spanStart || selectionStart >= spanEnd))) {
                    i2++;
                } else {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean c(InputConnection inputConnection, Editable editable, int i2, int i3, boolean z2) {
        int i4;
        int i5;
        if (editable != null && inputConnection != null && i2 >= 0 && i3 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (f(selectionStart, selectionEnd)) {
                return false;
            }
            if (z2) {
                i5 = CodepointIndexFinder.a(editable, selectionStart, Math.max(i2, 0));
                i4 = CodepointIndexFinder.b(editable, selectionEnd, Math.max(i3, 0));
                if (i5 == -1 || i4 == -1) {
                    return false;
                }
            } else {
                i5 = Math.max(selectionStart - i2, 0);
                i4 = Math.min(selectionEnd + i3, editable.length());
            }
            EmojiSpan[] emojiSpanArr = (EmojiSpan[]) editable.getSpans(i5, i4, EmojiSpan.class);
            if (emojiSpanArr != null && emojiSpanArr.length > 0) {
                for (EmojiSpan emojiSpan : emojiSpanArr) {
                    int spanStart = editable.getSpanStart(emojiSpan);
                    int spanEnd = editable.getSpanEnd(emojiSpan);
                    i5 = Math.min(spanStart, i5);
                    i4 = Math.max(spanEnd, i4);
                }
                int max = Math.max(i5, 0);
                int min = Math.min(i4, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max, min);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    static boolean d(Editable editable, int i2, KeyEvent keyEvent) {
        boolean z2;
        if (i2 == 67) {
            z2 = b(editable, keyEvent, false);
        } else if (i2 != 112) {
            z2 = false;
        } else {
            z2 = b(editable, keyEvent, true);
        }
        if (!z2) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean e(CharSequence charSequence, int i2, int i3, EmojiMetadata emojiMetadata) {
        if (emojiMetadata.d() == 0) {
            emojiMetadata.k(this.f3091c.a(charSequence, i2, i3, emojiMetadata.h()));
        }
        if (emojiMetadata.d() == 2) {
            return true;
        }
        return false;
    }

    private static boolean f(int i2, int i3) {
        return i2 == -1 || i3 == -1 || i2 != i3;
    }

    private static boolean g(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046 A[Catch:{ all -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062 A[Catch:{ all -> 0x0129 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.CharSequence h(java.lang.CharSequence r11, int r12, int r13, int r14, boolean r15) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof androidx.emoji2.text.SpannableBuilder
            if (r0 == 0) goto L_0x000a
            r1 = r11
            androidx.emoji2.text.SpannableBuilder r1 = (androidx.emoji2.text.SpannableBuilder) r1
            r1.a()
        L_0x000a:
            java.lang.Class<androidx.emoji2.text.EmojiSpan> r1 = androidx.emoji2.text.EmojiSpan.class
            if (r0 != 0) goto L_0x002c
            boolean r2 = r11 instanceof android.text.Spannable     // Catch:{ all -> 0x0129 }
            if (r2 == 0) goto L_0x0013
            goto L_0x002c
        L_0x0013:
            boolean r2 = r11 instanceof android.text.Spanned     // Catch:{ all -> 0x0129 }
            if (r2 == 0) goto L_0x002a
            r2 = r11
            android.text.Spanned r2 = (android.text.Spanned) r2     // Catch:{ all -> 0x0129 }
            int r3 = r12 + -1
            int r4 = r13 + 1
            int r2 = r2.nextSpanTransition(r3, r4, r1)     // Catch:{ all -> 0x0129 }
            if (r2 > r13) goto L_0x002a
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r2 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x0129 }
            r2.<init>((java.lang.CharSequence) r11)     // Catch:{ all -> 0x0129 }
            goto L_0x0034
        L_0x002a:
            r2 = 0
            goto L_0x0034
        L_0x002c:
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r2 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x0129 }
            r3 = r11
            android.text.Spannable r3 = (android.text.Spannable) r3     // Catch:{ all -> 0x0129 }
            r2.<init>((android.text.Spannable) r3)     // Catch:{ all -> 0x0129 }
        L_0x0034:
            r3 = 0
            if (r2 == 0) goto L_0x0060
            java.lang.Object[] r4 = r2.getSpans(r12, r13, r1)     // Catch:{ all -> 0x0129 }
            androidx.emoji2.text.EmojiSpan[] r4 = (androidx.emoji2.text.EmojiSpan[]) r4     // Catch:{ all -> 0x0129 }
            if (r4 == 0) goto L_0x0060
            int r5 = r4.length     // Catch:{ all -> 0x0129 }
            if (r5 <= 0) goto L_0x0060
            int r5 = r4.length     // Catch:{ all -> 0x0129 }
            r6 = 0
        L_0x0044:
            if (r6 >= r5) goto L_0x0060
            r7 = r4[r6]     // Catch:{ all -> 0x0129 }
            int r8 = r2.getSpanStart(r7)     // Catch:{ all -> 0x0129 }
            int r9 = r2.getSpanEnd(r7)     // Catch:{ all -> 0x0129 }
            if (r8 == r13) goto L_0x0055
            r2.removeSpan(r7)     // Catch:{ all -> 0x0129 }
        L_0x0055:
            int r12 = java.lang.Math.min(r8, r12)     // Catch:{ all -> 0x0129 }
            int r13 = java.lang.Math.max(r9, r13)     // Catch:{ all -> 0x0129 }
            int r6 = r6 + 1
            goto L_0x0044
        L_0x0060:
            if (r12 == r13) goto L_0x0120
            int r4 = r11.length()     // Catch:{ all -> 0x0129 }
            if (r12 < r4) goto L_0x006a
            goto L_0x0120
        L_0x006a:
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r14 == r4) goto L_0x007d
            if (r2 == 0) goto L_0x007d
            int r4 = r2.length()     // Catch:{ all -> 0x0129 }
            java.lang.Object[] r1 = r2.getSpans(r3, r4, r1)     // Catch:{ all -> 0x0129 }
            androidx.emoji2.text.EmojiSpan[] r1 = (androidx.emoji2.text.EmojiSpan[]) r1     // Catch:{ all -> 0x0129 }
            int r1 = r1.length     // Catch:{ all -> 0x0129 }
            int r14 = r14 - r1
        L_0x007d:
            androidx.emoji2.text.EmojiProcessor$ProcessorSm r1 = new androidx.emoji2.text.EmojiProcessor$ProcessorSm     // Catch:{ all -> 0x0129 }
            androidx.emoji2.text.MetadataRepo r4 = r10.f3090b     // Catch:{ all -> 0x0129 }
            androidx.emoji2.text.MetadataRepo$Node r4 = r4.f()     // Catch:{ all -> 0x0129 }
            boolean r5 = r10.f3092d     // Catch:{ all -> 0x0129 }
            int[] r6 = r10.f3093e     // Catch:{ all -> 0x0129 }
            r1.<init>(r4, r5, r6)     // Catch:{ all -> 0x0129 }
            int r4 = java.lang.Character.codePointAt(r11, r12)     // Catch:{ all -> 0x0129 }
            r3 = r2
            r5 = r4
            r4 = 0
        L_0x0093:
            r2 = r12
        L_0x0094:
            if (r12 >= r13) goto L_0x00e6
            if (r4 >= r14) goto L_0x00e6
            int r6 = r1.a(r5)     // Catch:{ all -> 0x0129 }
            r7 = 1
            if (r6 == r7) goto L_0x00d4
            r7 = 2
            if (r6 == r7) goto L_0x00c8
            r7 = 3
            if (r6 == r7) goto L_0x00a6
            goto L_0x0094
        L_0x00a6:
            if (r15 != 0) goto L_0x00b2
            androidx.emoji2.text.EmojiMetadata r6 = r1.c()     // Catch:{ all -> 0x0129 }
            boolean r6 = r10.e(r11, r2, r12, r6)     // Catch:{ all -> 0x0129 }
            if (r6 != 0) goto L_0x0093
        L_0x00b2:
            if (r3 != 0) goto L_0x00be
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r3 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x0129 }
            android.text.SpannableString r6 = new android.text.SpannableString     // Catch:{ all -> 0x0129 }
            r6.<init>(r11)     // Catch:{ all -> 0x0129 }
            r3.<init>((android.text.Spannable) r6)     // Catch:{ all -> 0x0129 }
        L_0x00be:
            androidx.emoji2.text.EmojiMetadata r6 = r1.c()     // Catch:{ all -> 0x0129 }
            r10.a(r3, r6, r2, r12)     // Catch:{ all -> 0x0129 }
            int r4 = r4 + 1
            goto L_0x0093
        L_0x00c8:
            int r6 = java.lang.Character.charCount(r5)     // Catch:{ all -> 0x0129 }
            int r12 = r12 + r6
            if (r12 >= r13) goto L_0x0094
            int r5 = java.lang.Character.codePointAt(r11, r12)     // Catch:{ all -> 0x0129 }
            goto L_0x0094
        L_0x00d4:
            int r12 = java.lang.Character.codePointAt(r11, r2)     // Catch:{ all -> 0x0129 }
            int r12 = java.lang.Character.charCount(r12)     // Catch:{ all -> 0x0129 }
            int r2 = r2 + r12
            if (r2 >= r13) goto L_0x00e4
            int r12 = java.lang.Character.codePointAt(r11, r2)     // Catch:{ all -> 0x0129 }
            r5 = r12
        L_0x00e4:
            r12 = r2
            goto L_0x0094
        L_0x00e6:
            boolean r13 = r1.e()     // Catch:{ all -> 0x0129 }
            if (r13 == 0) goto L_0x0109
            if (r4 >= r14) goto L_0x0109
            if (r15 != 0) goto L_0x00fa
            androidx.emoji2.text.EmojiMetadata r13 = r1.b()     // Catch:{ all -> 0x0129 }
            boolean r13 = r10.e(r11, r2, r12, r13)     // Catch:{ all -> 0x0129 }
            if (r13 != 0) goto L_0x0109
        L_0x00fa:
            if (r3 != 0) goto L_0x0102
            androidx.emoji2.text.UnprecomputeTextOnModificationSpannable r13 = new androidx.emoji2.text.UnprecomputeTextOnModificationSpannable     // Catch:{ all -> 0x0129 }
            r13.<init>((java.lang.CharSequence) r11)     // Catch:{ all -> 0x0129 }
            r3 = r13
        L_0x0102:
            androidx.emoji2.text.EmojiMetadata r13 = r1.b()     // Catch:{ all -> 0x0129 }
            r10.a(r3, r13, r2, r12)     // Catch:{ all -> 0x0129 }
        L_0x0109:
            if (r3 == 0) goto L_0x0117
            android.text.Spannable r12 = r3.b()     // Catch:{ all -> 0x0129 }
            if (r0 == 0) goto L_0x0116
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
            r11.d()
        L_0x0116:
            return r12
        L_0x0117:
            if (r0 == 0) goto L_0x011f
            r12 = r11
            androidx.emoji2.text.SpannableBuilder r12 = (androidx.emoji2.text.SpannableBuilder) r12
            r12.d()
        L_0x011f:
            return r11
        L_0x0120:
            if (r0 == 0) goto L_0x0128
            r12 = r11
            androidx.emoji2.text.SpannableBuilder r12 = (androidx.emoji2.text.SpannableBuilder) r12
            r12.d()
        L_0x0128:
            return r11
        L_0x0129:
            r12 = move-exception
            if (r0 == 0) goto L_0x0131
            androidx.emoji2.text.SpannableBuilder r11 = (androidx.emoji2.text.SpannableBuilder) r11
            r11.d()
        L_0x0131:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.EmojiProcessor.h(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }
}
