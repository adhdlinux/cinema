package org.mozilla.universalchardet;

import com.startapp.y1;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.EscCharsetProber;
import org.mozilla.universalchardet.prober.Latin1Prober;
import org.mozilla.universalchardet.prober.MBCSGroupProber;
import org.mozilla.universalchardet.prober.SBCSGroupProber;

public class UniversalDetector {

    /* renamed from: a  reason: collision with root package name */
    private InputState f41870a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f41871b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f41872c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f41873d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f41874e;

    /* renamed from: f  reason: collision with root package name */
    private byte f41875f;

    /* renamed from: g  reason: collision with root package name */
    private String f41876g;

    /* renamed from: h  reason: collision with root package name */
    private CharsetProber[] f41877h;

    /* renamed from: i  reason: collision with root package name */
    private CharsetProber f41878i;

    public enum InputState {
        PURE_ASCII,
        ESC_ASCII,
        HIGHBYTE
    }

    public UniversalDetector() {
        this((CharsetListener) null);
    }

    private static String b(byte[] bArr, int i2) {
        int i3 = i2 + 3;
        if (bArr.length <= i3) {
            return null;
        }
        byte b2 = bArr[i2] & 255;
        byte b3 = bArr[i2 + 1] & 255;
        byte b4 = bArr[i2 + 2] & 255;
        byte b5 = bArr[i3] & 255;
        if (b2 != 0) {
            if (b2 != 239) {
                if (b2 != 254) {
                    if (b2 != 255) {
                        return null;
                    }
                    if (b3 == 254 && b4 == 0 && b5 == 0) {
                        return Constants.f41868y;
                    }
                    if (b3 == 254) {
                        return Constants.f41866w;
                    }
                    return null;
                } else if (b3 == 255 && b4 == 0 && b5 == 0) {
                    return Constants.C;
                } else {
                    if (b3 == 255) {
                        return Constants.f41865v;
                    }
                    return null;
                }
            } else if (b3 == 187 && b4 == 191) {
                return Constants.f41864u;
            } else {
                return null;
            }
        } else if (b3 == 0 && b4 == 254 && b5 == 255) {
            return Constants.f41867x;
        } else {
            if (b3 == 0 && b4 == 255 && b5 == 254) {
                return Constants.D;
            }
            return null;
        }
    }

    public void a() {
        CharsetProber[] charsetProberArr;
        if (this.f41873d) {
            if (this.f41876g != null) {
                this.f41871b = true;
                return;
            }
            InputState inputState = this.f41870a;
            if (inputState == InputState.HIGHBYTE) {
                int i2 = 0;
                int i3 = 0;
                float f2 = 0.0f;
                while (true) {
                    charsetProberArr = this.f41877h;
                    if (i2 >= charsetProberArr.length) {
                        break;
                    }
                    float d2 = charsetProberArr[i2].d();
                    if (d2 > f2) {
                        i3 = i2;
                        f2 = d2;
                    }
                    i2++;
                }
                if (f2 > 0.2f) {
                    this.f41876g = charsetProberArr[i3].c();
                }
            } else if (inputState != InputState.ESC_ASCII && inputState == InputState.PURE_ASCII && this.f41874e) {
                this.f41876g = Constants.A;
            }
        }
    }

    public String c() {
        return this.f41876g;
    }

    public void d(byte[] bArr, int i2, int i3) {
        boolean z2;
        String b2;
        if (!this.f41871b) {
            if (i3 > 0) {
                this.f41873d = true;
            }
            int i4 = 0;
            if (this.f41872c) {
                this.f41872c = false;
                if (i3 > 3 && (b2 = b(bArr, i2)) != null) {
                    this.f41876g = b2;
                    this.f41871b = true;
                    return;
                }
            }
            int i5 = i2 + i3;
            for (int i6 = i2; i6 < i5; i6++) {
                byte b3 = bArr[i6];
                byte b4 = b3 & 255;
                if ((b4 & y1.f36938c) == 0 || b4 == 160) {
                    InputState inputState = this.f41870a;
                    InputState inputState2 = InputState.PURE_ASCII;
                    if (inputState == inputState2 && (b4 == 27 || (b4 == 123 && this.f41875f == 126))) {
                        this.f41870a = InputState.ESC_ASCII;
                    }
                    if (this.f41870a == inputState2 && this.f41874e) {
                        if ((b4 >= 32 && b4 <= 126) || b4 == 10 || b4 == 13 || b4 == 9) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.f41874e = z2;
                    }
                    this.f41875f = b3;
                } else {
                    InputState inputState3 = this.f41870a;
                    InputState inputState4 = InputState.HIGHBYTE;
                    if (inputState3 != inputState4) {
                        this.f41870a = inputState4;
                        if (this.f41878i != null) {
                            this.f41878i = null;
                        }
                        CharsetProber[] charsetProberArr = this.f41877h;
                        if (charsetProberArr[0] == null) {
                            charsetProberArr[0] = new MBCSGroupProber();
                        }
                        CharsetProber[] charsetProberArr2 = this.f41877h;
                        if (charsetProberArr2[1] == null) {
                            charsetProberArr2[1] = new SBCSGroupProber();
                        }
                        CharsetProber[] charsetProberArr3 = this.f41877h;
                        if (charsetProberArr3[2] == null) {
                            charsetProberArr3[2] = new Latin1Prober();
                        }
                    }
                }
            }
            InputState inputState5 = this.f41870a;
            if (inputState5 == InputState.ESC_ASCII) {
                if (this.f41878i == null) {
                    this.f41878i = new EscCharsetProber();
                }
                if (this.f41878i.f(bArr, i2, i3) == CharsetProber.ProbingState.FOUND_IT) {
                    this.f41871b = true;
                    this.f41876g = this.f41878i.c();
                }
            } else if (inputState5 == InputState.HIGHBYTE) {
                while (true) {
                    CharsetProber[] charsetProberArr4 = this.f41877h;
                    if (i4 >= charsetProberArr4.length) {
                        return;
                    }
                    if (charsetProberArr4[i4].f(bArr, i2, i3) == CharsetProber.ProbingState.FOUND_IT) {
                        this.f41871b = true;
                        this.f41876g = this.f41877h[i4].c();
                        return;
                    }
                    i4++;
                }
            }
        }
    }

    public boolean e() {
        return this.f41871b;
    }

    public final void f() {
        int i2 = 0;
        this.f41871b = false;
        this.f41872c = true;
        this.f41876g = null;
        this.f41873d = false;
        this.f41870a = InputState.PURE_ASCII;
        this.f41875f = 0;
        CharsetProber charsetProber = this.f41878i;
        if (charsetProber != null) {
            charsetProber.j();
        }
        while (true) {
            CharsetProber[] charsetProberArr = this.f41877h;
            if (i2 < charsetProberArr.length) {
                CharsetProber charsetProber2 = charsetProberArr[i2];
                if (charsetProber2 != null) {
                    charsetProber2.j();
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public UniversalDetector(CharsetListener charsetListener) {
        this.f41874e = true;
        this.f41878i = null;
        this.f41877h = new CharsetProber[3];
        f();
    }
}
