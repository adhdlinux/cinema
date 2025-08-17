package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

class AlertController {
    NestedScrollView A;
    private int B = 0;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    int I = -1;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    private int Q = 0;
    Handler R;
    private final View.OnClickListener S = new View.OnClickListener() {
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            Message message4;
            AlertController alertController = AlertController.this;
            if (view == alertController.f336o && (message4 = alertController.f338q) != null) {
                message = Message.obtain(message4);
            } else if (view == alertController.f340s && (message3 = alertController.f342u) != null) {
                message = Message.obtain(message3);
            } else if (view != alertController.f344w || (message2 = alertController.f346y) == null) {
                message = null;
            } else {
                message = Message.obtain(message2);
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f323b).sendToTarget();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Context f322a;

    /* renamed from: b  reason: collision with root package name */
    final AppCompatDialog f323b;

    /* renamed from: c  reason: collision with root package name */
    private final Window f324c;

    /* renamed from: d  reason: collision with root package name */
    private final int f325d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f326e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f327f;

    /* renamed from: g  reason: collision with root package name */
    ListView f328g;

    /* renamed from: h  reason: collision with root package name */
    private View f329h;

    /* renamed from: i  reason: collision with root package name */
    private int f330i;

    /* renamed from: j  reason: collision with root package name */
    private int f331j;

    /* renamed from: k  reason: collision with root package name */
    private int f332k;

    /* renamed from: l  reason: collision with root package name */
    private int f333l;

    /* renamed from: m  reason: collision with root package name */
    private int f334m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f335n = false;

    /* renamed from: o  reason: collision with root package name */
    Button f336o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f337p;

    /* renamed from: q  reason: collision with root package name */
    Message f338q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f339r;

    /* renamed from: s  reason: collision with root package name */
    Button f340s;

    /* renamed from: t  reason: collision with root package name */
    private CharSequence f341t;

    /* renamed from: u  reason: collision with root package name */
    Message f342u;

    /* renamed from: v  reason: collision with root package name */
    private Drawable f343v;

    /* renamed from: w  reason: collision with root package name */
    Button f344w;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f345x;

    /* renamed from: y  reason: collision with root package name */
    Message f346y;

    /* renamed from: z  reason: collision with root package name */
    private Drawable f347z;

    public static class AlertParams {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public boolean O = true;

        /* renamed from: a  reason: collision with root package name */
        public final Context f361a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f362b;

        /* renamed from: c  reason: collision with root package name */
        public int f363c = 0;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f364d;

        /* renamed from: e  reason: collision with root package name */
        public int f365e = 0;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f366f;

        /* renamed from: g  reason: collision with root package name */
        public View f367g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f368h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f369i;

        /* renamed from: j  reason: collision with root package name */
        public Drawable f370j;

        /* renamed from: k  reason: collision with root package name */
        public DialogInterface.OnClickListener f371k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f372l;

        /* renamed from: m  reason: collision with root package name */
        public Drawable f373m;

        /* renamed from: n  reason: collision with root package name */
        public DialogInterface.OnClickListener f374n;

        /* renamed from: o  reason: collision with root package name */
        public CharSequence f375o;

        /* renamed from: p  reason: collision with root package name */
        public Drawable f376p;

        /* renamed from: q  reason: collision with root package name */
        public DialogInterface.OnClickListener f377q;

        /* renamed from: r  reason: collision with root package name */
        public boolean f378r;

        /* renamed from: s  reason: collision with root package name */
        public DialogInterface.OnCancelListener f379s;

        /* renamed from: t  reason: collision with root package name */
        public DialogInterface.OnDismissListener f380t;

        /* renamed from: u  reason: collision with root package name */
        public DialogInterface.OnKeyListener f381u;

        /* renamed from: v  reason: collision with root package name */
        public CharSequence[] f382v;

        /* renamed from: w  reason: collision with root package name */
        public ListAdapter f383w;

        /* renamed from: x  reason: collision with root package name */
        public DialogInterface.OnClickListener f384x;

        /* renamed from: y  reason: collision with root package name */
        public int f385y;

        /* renamed from: z  reason: collision with root package name */
        public View f386z;

        public AlertParams(Context context) {
            this.f361a = context;
            this.f378r = true;
            this.f362b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARNING: type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r9v3 */
        /* JADX WARNING: type inference failed for: r9v4 */
        /* JADX WARNING: type inference failed for: r2v5, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v22, types: [androidx.appcompat.app.AlertController$AlertParams$2] */
        /* JADX WARNING: type inference failed for: r1v23, types: [androidx.appcompat.app.AlertController$AlertParams$1] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(final androidx.appcompat.app.AlertController r11) {
            /*
                r10 = this;
                android.view.LayoutInflater r0 = r10.f362b
                int r1 = r11.L
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r10.G
                r8 = 1
                if (r1 == 0) goto L_0x0035
                android.database.Cursor r1 = r10.K
                if (r1 != 0) goto L_0x0026
                androidx.appcompat.app.AlertController$AlertParams$1 r9 = new androidx.appcompat.app.AlertController$AlertParams$1
                android.content.Context r3 = r10.f361a
                int r4 = r11.M
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r10.f382v
                r1 = r9
                r2 = r10
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0026:
                androidx.appcompat.app.AlertController$AlertParams$2 r9 = new androidx.appcompat.app.AlertController$AlertParams$2
                android.content.Context r3 = r10.f361a
                android.database.Cursor r4 = r10.K
                r5 = 0
                r1 = r9
                r2 = r10
                r6 = r0
                r7 = r11
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x0035:
                boolean r1 = r10.H
                if (r1 == 0) goto L_0x003c
                int r1 = r11.N
                goto L_0x003e
            L_0x003c:
                int r1 = r11.O
            L_0x003e:
                r4 = r1
                android.database.Cursor r1 = r10.K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L_0x005d
                android.widget.SimpleCursorAdapter r9 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r10.f361a
                android.database.Cursor r5 = r10.K
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r1 = r10.L
                r7 = 0
                r6[r7] = r1
                int[] r1 = new int[r8]
                r1[r7] = r2
                r2 = r9
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x006b
            L_0x005d:
                android.widget.ListAdapter r9 = r10.f383w
                if (r9 == 0) goto L_0x0062
                goto L_0x006b
            L_0x0062:
                androidx.appcompat.app.AlertController$CheckedItemAdapter r9 = new androidx.appcompat.app.AlertController$CheckedItemAdapter
                android.content.Context r1 = r10.f361a
                java.lang.CharSequence[] r3 = r10.f382v
                r9.<init>(r1, r4, r2, r3)
            L_0x006b:
                r11.H = r9
                int r1 = r10.I
                r11.I = r1
                android.content.DialogInterface$OnClickListener r1 = r10.f384x
                if (r1 == 0) goto L_0x007e
                androidx.appcompat.app.AlertController$AlertParams$3 r1 = new androidx.appcompat.app.AlertController$AlertParams$3
                r1.<init>(r11)
                r0.setOnItemClickListener(r1)
                goto L_0x008a
            L_0x007e:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r10.J
                if (r1 == 0) goto L_0x008a
                androidx.appcompat.app.AlertController$AlertParams$4 r1 = new androidx.appcompat.app.AlertController$AlertParams$4
                r1.<init>(r0, r11)
                r0.setOnItemClickListener(r1)
            L_0x008a:
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.N
                if (r1 == 0) goto L_0x0091
                r0.setOnItemSelectedListener(r1)
            L_0x0091:
                boolean r1 = r10.H
                if (r1 == 0) goto L_0x0099
                r0.setChoiceMode(r8)
                goto L_0x00a1
            L_0x0099:
                boolean r1 = r10.G
                if (r1 == 0) goto L_0x00a1
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x00a1:
                r11.f328g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.AlertParams.b(androidx.appcompat.app.AlertController):void");
        }

        public void a(AlertController alertController) {
            View view = this.f367g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f366f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f364d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i2 = this.f363c;
                if (i2 != 0) {
                    alertController.m(i2);
                }
                int i3 = this.f365e;
                if (i3 != 0) {
                    alertController.m(alertController.c(i3));
                }
            }
            CharSequence charSequence2 = this.f368h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f369i;
            if (!(charSequence3 == null && this.f370j == null)) {
                alertController.k(-1, charSequence3, this.f371k, (Message) null, this.f370j);
            }
            CharSequence charSequence4 = this.f372l;
            if (!(charSequence4 == null && this.f373m == null)) {
                alertController.k(-2, charSequence4, this.f374n, (Message) null, this.f373m);
            }
            CharSequence charSequence5 = this.f375o;
            if (!(charSequence5 == null && this.f376p == null)) {
                alertController.k(-3, charSequence5, this.f377q, (Message) null, this.f376p);
            }
            if (!(this.f382v == null && this.K == null && this.f383w == null)) {
                b(alertController);
            }
            View view2 = this.f386z;
            if (view2 == null) {
                int i4 = this.f385y;
                if (i4 != 0) {
                    alertController.r(i4);
                }
            } else if (this.E) {
                alertController.t(view2, this.A, this.B, this.C, this.D);
            } else {
                alertController.s(view2);
            }
        }
    }

    private static final class ButtonHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<DialogInterface> f399a;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.f399a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f399a.get(), message.what);
            } else if (i2 == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int i2, int i3, CharSequence[] charSequenceArr) {
            super(context, i2, i3, charSequenceArr);
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public static class RecycleListView extends ListView {

        /* renamed from: b  reason: collision with root package name */
        private final int f400b;

        /* renamed from: c  reason: collision with root package name */
        private final int f401c;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.m2);
            this.f401c = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.n2, -1);
            this.f400b = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.o2, -1);
        }

        public void a(boolean z2, boolean z3) {
            int i2;
            int i3;
            if (!z3 || !z2) {
                int paddingLeft = getPaddingLeft();
                if (z2) {
                    i2 = getPaddingTop();
                } else {
                    i2 = this.f400b;
                }
                int paddingRight = getPaddingRight();
                if (z3) {
                    i3 = getPaddingBottom();
                } else {
                    i3 = this.f401c;
                }
                setPadding(paddingLeft, i2, paddingRight, i3);
            }
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f322a = context;
        this.f323b = appCompatDialog;
        this.f324c = window;
        this.R = new ButtonHandler(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R$styleable.H, R$attr.f103n, 0);
        this.J = obtainStyledAttributes.getResourceId(R$styleable.I, 0);
        this.K = obtainStyledAttributes.getResourceId(R$styleable.K, 0);
        this.L = obtainStyledAttributes.getResourceId(R$styleable.M, 0);
        this.M = obtainStyledAttributes.getResourceId(R$styleable.N, 0);
        this.N = obtainStyledAttributes.getResourceId(R$styleable.P, 0);
        this.O = obtainStyledAttributes.getResourceId(R$styleable.L, 0);
        this.P = obtainStyledAttributes.getBoolean(R$styleable.O, true);
        this.f325d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.J, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void f(View view, View view2, View view3) {
        int i2;
        int i3 = 0;
        if (view2 != null) {
            if (view.canScrollVertically(-1)) {
                i2 = 0;
            } else {
                i2 = 4;
            }
            view2.setVisibility(i2);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i3 = 4;
            }
            view3.setVisibility(i3);
        }
    }

    private ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i2 = this.K;
        if (i2 == 0) {
            return this.J;
        }
        if (this.Q == 1) {
            return i2;
        }
        return this.J;
    }

    private void p(ViewGroup viewGroup, View view, int i2, int i3) {
        final View findViewById = this.f324c.findViewById(R$id.B);
        final View findViewById2 = this.f324c.findViewById(R$id.A);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.K0(view, i2, i3);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i2 & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i2 & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById != null || findViewById2 != null) {
            if (this.f327f != null) {
                this.A.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                    public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                        AlertController.f(nestedScrollView, findViewById, findViewById2);
                    }
                });
                this.A.post(new Runnable() {
                    public void run() {
                        AlertController.f(AlertController.this.A, findViewById, findViewById2);
                    }
                });
                return;
            }
            ListView listView = this.f328g;
            if (listView != null) {
                listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                        AlertController.f(absListView, findViewById, findViewById2);
                    }

                    public void onScrollStateChanged(AbsListView absListView, int i2) {
                    }
                });
                this.f328g.post(new Runnable() {
                    public void run() {
                        AlertController.f(AlertController.this.f328g, findViewById, findViewById2);
                    }
                });
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
            }
        }
    }

    private void u(ViewGroup viewGroup) {
        boolean z2;
        Button button = (Button) viewGroup.findViewById(16908313);
        this.f336o = button;
        button.setOnClickListener(this.S);
        boolean z3 = true;
        if (!TextUtils.isEmpty(this.f337p) || this.f339r != null) {
            this.f336o.setText(this.f337p);
            Drawable drawable = this.f339r;
            if (drawable != null) {
                int i2 = this.f325d;
                drawable.setBounds(0, 0, i2, i2);
                this.f336o.setCompoundDrawables(this.f339r, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f336o.setVisibility(0);
            z2 = true;
        } else {
            this.f336o.setVisibility(8);
            z2 = false;
        }
        Button button2 = (Button) viewGroup.findViewById(16908314);
        this.f340s = button2;
        button2.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f341t) || this.f343v != null) {
            this.f340s.setText(this.f341t);
            Drawable drawable2 = this.f343v;
            if (drawable2 != null) {
                int i3 = this.f325d;
                drawable2.setBounds(0, 0, i3, i3);
                this.f340s.setCompoundDrawables(this.f343v, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f340s.setVisibility(0);
            z2 |= true;
        } else {
            this.f340s.setVisibility(8);
        }
        Button button3 = (Button) viewGroup.findViewById(16908315);
        this.f344w = button3;
        button3.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f345x) || this.f347z != null) {
            this.f344w.setText(this.f345x);
            Drawable drawable3 = this.f347z;
            if (drawable3 != null) {
                int i4 = this.f325d;
                drawable3.setBounds(0, 0, i4, i4);
                this.f344w.setCompoundDrawables(this.f347z, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f344w.setVisibility(0);
            z2 |= true;
        } else {
            this.f344w.setVisibility(8);
        }
        if (z(this.f322a)) {
            if (z2) {
                b(this.f336o);
            } else if (z2) {
                b(this.f340s);
            } else if (z2) {
                b(this.f344w);
            }
        }
        if (!z2) {
            z3 = false;
        }
        if (!z3) {
            viewGroup.setVisibility(8);
        }
    }

    private void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f324c.findViewById(R$id.C);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.F = textView;
        if (textView != null) {
            CharSequence charSequence = this.f327f;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.A.removeView(this.F);
            if (this.f328g != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.A);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f328g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void w(ViewGroup viewGroup) {
        View view = this.f329h;
        boolean z2 = false;
        if (view == null) {
            if (this.f330i != 0) {
                view = LayoutInflater.from(this.f322a).inflate(this.f330i, viewGroup, false);
            } else {
                view = null;
            }
        }
        if (view != null) {
            z2 = true;
        }
        if (!z2 || !a(view)) {
            this.f324c.setFlags(131072, 131072);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) this.f324c.findViewById(R$id.f180o);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f335n) {
                frameLayout.setPadding(this.f331j, this.f332k, this.f333l, this.f334m);
            }
            if (this.f328g != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void x(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f324c.findViewById(R$id.U).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f324c.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f326e)) || !this.P) {
            this.f324c.findViewById(R$id.U).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f324c.findViewById(R$id.f176k);
        this.E = textView;
        textView.setText(this.f326e);
        int i2 = this.B;
        if (i2 != 0) {
            this.D.setImageResource(i2);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
            return;
        }
        this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
        this.D.setVisibility(8);
    }

    private void y() {
        boolean z2;
        boolean z3;
        boolean z4;
        ListAdapter listAdapter;
        View findViewById;
        View view;
        View findViewById2;
        View findViewById3 = this.f324c.findViewById(R$id.f191z);
        int i2 = R$id.V;
        View findViewById4 = findViewById3.findViewById(i2);
        int i3 = R$id.f179n;
        View findViewById5 = findViewById3.findViewById(i3);
        int i4 = R$id.f177l;
        View findViewById6 = findViewById3.findViewById(i4);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R$id.f181p);
        w(viewGroup);
        View findViewById7 = viewGroup.findViewById(i2);
        View findViewById8 = viewGroup.findViewById(i3);
        View findViewById9 = viewGroup.findViewById(i4);
        ViewGroup i5 = i(findViewById7, findViewById4);
        ViewGroup i6 = i(findViewById8, findViewById5);
        ViewGroup i7 = i(findViewById9, findViewById6);
        v(i6);
        u(i7);
        x(i5);
        char c2 = 0;
        if (viewGroup.getVisibility() != 8) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (i5 == null || i5.getVisibility() == 8) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (i7 == null || i7.getVisibility() == 8) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!(z4 || i6 == null || (findViewById2 = i6.findViewById(R$id.Q)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z3) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            if (this.f327f == null && this.f328g == null) {
                view = null;
            } else {
                view = i5.findViewById(R$id.T);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(i6 == null || (findViewById = i6.findViewById(R$id.R)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f328g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z3, z4);
        }
        if (!z2) {
            View view2 = this.f328g;
            if (view2 == null) {
                view2 = this.A;
            }
            if (view2 != null) {
                if (z4) {
                    c2 = 2;
                }
                p(i6, view2, z3 | c2 ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.f328g;
        if (listView2 != null && (listAdapter = this.H) != null) {
            listView2.setAdapter(listAdapter);
            int i8 = this.I;
            if (i8 > -1) {
                listView2.setItemChecked(i8, true);
                listView2.setSelection(i8);
            }
        }
    }

    private static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.f102m, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public int c(int i2) {
        TypedValue typedValue = new TypedValue();
        this.f322a.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f328g;
    }

    public void e() {
        this.f323b.setContentView(j());
        y();
    }

    public boolean g(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.s(keyEvent);
    }

    public boolean h(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.s(keyEvent);
    }

    public void k(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.f345x = charSequence;
            this.f346y = message;
            this.f347z = drawable;
        } else if (i2 == -2) {
            this.f341t = charSequence;
            this.f342u = message;
            this.f343v = drawable;
        } else if (i2 == -1) {
            this.f337p = charSequence;
            this.f338q = message;
            this.f339r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void l(View view) {
        this.G = view;
    }

    public void m(int i2) {
        this.C = null;
        this.B = i2;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (i2 != 0) {
            imageView.setVisibility(0);
            this.D.setImageResource(this.B);
            return;
        }
        imageView.setVisibility(8);
    }

    public void n(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.D.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public void o(CharSequence charSequence) {
        this.f327f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(CharSequence charSequence) {
        this.f326e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i2) {
        this.f329h = null;
        this.f330i = i2;
        this.f335n = false;
    }

    public void s(View view) {
        this.f329h = view;
        this.f330i = 0;
        this.f335n = false;
    }

    public void t(View view, int i2, int i3, int i4, int i5) {
        this.f329h = view;
        this.f330i = 0;
        this.f335n = true;
        this.f331j = i2;
        this.f332k = i3;
        this.f333l = i4;
        this.f334m = i5;
    }
}
