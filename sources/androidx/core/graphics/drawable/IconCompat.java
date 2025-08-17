package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k  reason: collision with root package name */
    static final PorterDuff.Mode f2577k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f2578a;

    /* renamed from: b  reason: collision with root package name */
    Object f2579b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f2580c;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f2581d;

    /* renamed from: e  reason: collision with root package name */
    public int f2582e;

    /* renamed from: f  reason: collision with root package name */
    public int f2583f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f2584g;

    /* renamed from: h  reason: collision with root package name */
    PorterDuff.Mode f2585h;

    /* renamed from: i  reason: collision with root package name */
    public String f2586i;

    /* renamed from: j  reason: collision with root package name */
    public String f2587j;

    static class Api23Impl {
        private Api23Impl() {
        }

        static IconCompat a(Object obj) {
            Preconditions.g(obj);
            int d2 = d(obj);
            if (d2 == 2) {
                return IconCompat.h((Resources) null, c(obj), b(obj));
            }
            if (d2 == 4) {
                return IconCompat.f(e(obj));
            }
            if (d2 == 6) {
                return IconCompat.d(e(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f2579b = obj;
            return iconCompat;
        }

        static int b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e2) {
                Log.e("IconCompat", "Unable to get icon resource", e2);
                return 0;
            } catch (InvocationTargetException e3) {
                Log.e("IconCompat", "Unable to get icon resource", e3);
                return 0;
            } catch (NoSuchMethodException e4) {
                Log.e("IconCompat", "Unable to get icon resource", e4);
                return 0;
            }
        }

        static String c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e2) {
                Log.e("IconCompat", "Unable to get icon package", e2);
                return null;
            } catch (InvocationTargetException e3) {
                Log.e("IconCompat", "Unable to get icon package", e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.e("IconCompat", "Unable to get icon package", e4);
                return null;
            }
        }

        static int d(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e2) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e2);
                return -1;
            } catch (InvocationTargetException e3) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e3);
                return -1;
            } catch (NoSuchMethodException e4) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e4);
                return -1;
            }
        }

        static Uri e(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e2) {
                Log.e("IconCompat", "Unable to get icon uri", e2);
                return null;
            } catch (InvocationTargetException e3) {
                Log.e("IconCompat", "Unable to get icon uri", e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.e("IconCompat", "Unable to get icon uri", e4);
                return null;
            }
        }

        static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        static Icon g(IconCompat iconCompat, Context context) {
            Icon icon;
            switch (iconCompat.f2578a) {
                case -1:
                    return (Icon) iconCompat.f2579b;
                case 1:
                    icon = Icon.createWithBitmap((Bitmap) iconCompat.f2579b);
                    break;
                case 2:
                    icon = Icon.createWithResource(iconCompat.j(), iconCompat.f2582e);
                    break;
                case 3:
                    icon = Icon.createWithData((byte[]) iconCompat.f2579b, iconCompat.f2582e, iconCompat.f2583f);
                    break;
                case 4:
                    icon = Icon.createWithContentUri((String) iconCompat.f2579b);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT < 26) {
                        icon = Icon.createWithBitmap(IconCompat.c((Bitmap) iconCompat.f2579b, false));
                        break;
                    } else {
                        icon = Api26Impl.b((Bitmap) iconCompat.f2579b);
                        break;
                    }
                case 6:
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 30) {
                        icon = Api30Impl.a(iconCompat.l());
                        break;
                    } else if (context != null) {
                        InputStream m2 = iconCompat.m(context);
                        if (m2 != null) {
                            if (i2 < 26) {
                                icon = Icon.createWithBitmap(IconCompat.c(BitmapFactory.decodeStream(m2), false));
                                break;
                            } else {
                                icon = Api26Impl.b(BitmapFactory.decodeStream(m2));
                                break;
                            }
                        } else {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.l());
                        }
                    } else {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.l());
                    }
                default:
                    throw new IllegalArgumentException("Unknown type");
            }
            ColorStateList colorStateList = iconCompat.f2584g;
            if (colorStateList != null) {
                Icon unused = icon.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f2585h;
            if (mode != IconCompat.f2577k) {
                Icon unused2 = icon.setTintMode(mode);
            }
            return icon;
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f2578a = -1;
        this.f2580c = null;
        this.f2581d = null;
        this.f2582e = 0;
        this.f2583f = 0;
        this.f2584g = null;
        this.f2585h = f2577k;
        this.f2586i = null;
    }

    public static IconCompat b(Icon icon) {
        return Api23Impl.a(icon);
    }

    static Bitmap c(Bitmap bitmap, boolean z2) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f2 = (float) min;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z2) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate(((float) (-(bitmap.getWidth() - min))) / 2.0f, ((float) (-(bitmap.getHeight() - min))) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    public static IconCompat d(Uri uri) {
        ObjectsCompat.c(uri);
        return e(uri.toString());
    }

    public static IconCompat e(String str) {
        ObjectsCompat.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f2579b = str;
        return iconCompat;
    }

    public static IconCompat f(Uri uri) {
        ObjectsCompat.c(uri);
        return g(uri.toString());
    }

    public static IconCompat g(String str) {
        ObjectsCompat.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f2579b = str;
        return iconCompat;
    }

    public static IconCompat h(Resources resources, String str, int i2) {
        ObjectsCompat.c(str);
        if (i2 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f2582e = i2;
            if (resources != null) {
                try {
                    iconCompat.f2579b = resources.getResourceName(i2);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f2579b = str;
            }
            iconCompat.f2587j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    private static String r(int i2) {
        switch (i2) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public int i() {
        int i2 = this.f2578a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.b(this.f2579b);
        }
        if (i2 == 2) {
            return this.f2582e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String j() {
        int i2 = this.f2578a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.c(this.f2579b);
        }
        if (i2 == 2) {
            String str = this.f2587j;
            if (str == null || TextUtils.isEmpty(str)) {
                return ((String) this.f2579b).split(":", -1)[0];
            }
            return this.f2587j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int k() {
        int i2 = this.f2578a;
        if (i2 != -1 || Build.VERSION.SDK_INT < 23) {
            return i2;
        }
        return Api23Impl.d(this.f2579b);
    }

    public Uri l() {
        int i2 = this.f2578a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.e(this.f2579b);
        }
        if (i2 == 4 || i2 == 6) {
            return Uri.parse((String) this.f2579b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream m(Context context) {
        Uri l2 = l();
        String scheme = l2.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(l2);
            } catch (Exception e2) {
                Log.w("IconCompat", "Unable to load image from URI: " + l2, e2);
                return null;
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f2579b));
            } catch (FileNotFoundException e3) {
                Log.w("IconCompat", "Unable to load image from path: " + l2, e3);
                return null;
            }
        }
    }

    public void n() {
        this.f2585h = PorterDuff.Mode.valueOf(this.f2586i);
        switch (this.f2578a) {
            case -1:
                Parcelable parcelable = this.f2581d;
                if (parcelable != null) {
                    this.f2579b = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                Parcelable parcelable2 = this.f2581d;
                if (parcelable2 != null) {
                    this.f2579b = parcelable2;
                    return;
                }
                byte[] bArr = this.f2580c;
                this.f2579b = bArr;
                this.f2578a = 3;
                this.f2582e = 0;
                this.f2583f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f2580c, Charset.forName("UTF-16"));
                this.f2579b = str;
                if (this.f2578a == 2 && this.f2587j == null) {
                    this.f2587j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f2579b = this.f2580c;
                return;
            default:
                return;
        }
    }

    public void o(boolean z2) {
        this.f2586i = this.f2585h.name();
        switch (this.f2578a) {
            case -1:
                if (!z2) {
                    this.f2581d = (Parcelable) this.f2579b;
                    return;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            case 1:
            case 5:
                if (z2) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f2579b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f2580c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.f2581d = (Parcelable) this.f2579b;
                return;
            case 2:
                this.f2580c = ((String) this.f2579b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f2580c = (byte[]) this.f2579b;
                return;
            case 4:
            case 6:
                this.f2580c = this.f2579b.toString().getBytes(Charset.forName("UTF-16"));
                return;
            default:
                return;
        }
    }

    @Deprecated
    public Icon p() {
        return q((Context) null);
    }

    public Icon q(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.g(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public String toString() {
        if (this.f2578a == -1) {
            return String.valueOf(this.f2579b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(r(this.f2578a));
        switch (this.f2578a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f2579b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f2579b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f2587j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", new Object[]{Integer.valueOf(i())}));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f2582e);
                if (this.f2583f != 0) {
                    sb.append(" off=");
                    sb.append(this.f2583f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f2579b);
                break;
        }
        if (this.f2584g != null) {
            sb.append(" tint=");
            sb.append(this.f2584g);
        }
        if (this.f2585h != f2577k) {
            sb.append(" mode=");
            sb.append(this.f2585h);
        }
        sb.append(")");
        return sb.toString();
    }

    IconCompat(int i2) {
        this.f2580c = null;
        this.f2581d = null;
        this.f2582e = 0;
        this.f2583f = 0;
        this.f2584g = null;
        this.f2585h = f2577k;
        this.f2586i = null;
        this.f2578a = i2;
    }
}
