package it.gmariotti.changelibs.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import it.gmariotti.changelibs.R$string;
import it.gmariotti.changelibs.R$styleable;
import it.gmariotti.changelibs.library.Constants;
import it.gmariotti.changelibs.library.Util;
import it.gmariotti.changelibs.library.internal.ChangeLog;
import it.gmariotti.changelibs.library.internal.ChangeLogAdapter;
import it.gmariotti.changelibs.library.parser.XmlParser;

public class ChangeLogListView extends ListView implements AdapterView.OnItemClickListener {

    /* renamed from: g  reason: collision with root package name */
    protected static String f40220g = "ChangeLogListView";

    /* renamed from: b  reason: collision with root package name */
    protected int f40221b = Constants.f40184b;

    /* renamed from: c  reason: collision with root package name */
    protected int f40222c = Constants.f40185c;

    /* renamed from: d  reason: collision with root package name */
    protected int f40223d = Constants.f40183a;

    /* renamed from: e  reason: collision with root package name */
    protected String f40224e = null;

    /* renamed from: f  reason: collision with root package name */
    protected ChangeLogAdapter f40225f;

    protected class ParseAsyncTask extends AsyncTask<Void, Void, ChangeLog> {

        /* renamed from: a  reason: collision with root package name */
        private ChangeLogAdapter f40226a;

        /* renamed from: b  reason: collision with root package name */
        private XmlParser f40227b;

        public ParseAsyncTask(ChangeLogAdapter changeLogAdapter, XmlParser xmlParser) {
            this.f40226a = changeLogAdapter;
            this.f40227b = xmlParser;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ChangeLog doInBackground(Void... voidArr) {
            try {
                XmlParser xmlParser = this.f40227b;
                if (xmlParser != null) {
                    return xmlParser.a();
                }
                return null;
            } catch (Exception e2) {
                Log.e(ChangeLogListView.f40220g, ChangeLogListView.this.getResources().getString(R$string.changelog_internal_error_parsing), e2);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(ChangeLog changeLog) {
            if (changeLog != null) {
                this.f40226a.addAll(changeLog.b());
                this.f40226a.notifyDataSetChanged();
            }
        }
    }

    public ChangeLogListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setNestedScrollingEnabled(true);
        a(attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet, int i2) {
        c(attributeSet, i2);
        b();
        setDividerHeight(0);
    }

    /* access modifiers changed from: protected */
    public void b() {
        XmlParser xmlParser;
        try {
            if (this.f40224e != null) {
                xmlParser = new XmlParser(getContext(), this.f40224e);
            } else {
                xmlParser = new XmlParser(getContext(), this.f40223d);
            }
            ChangeLogAdapter changeLogAdapter = new ChangeLogAdapter(getContext(), new ChangeLog().b());
            this.f40225f = changeLogAdapter;
            changeLogAdapter.b(this.f40221b);
            this.f40225f.a(this.f40222c);
            String str = this.f40224e;
            if (str != null) {
                if (str == null || !Util.a(getContext())) {
                    Toast.makeText(getContext(), R$string.changelog_internal_error_internet_connection, 1).show();
                    setAdapter(this.f40225f);
                }
            }
            new ParseAsyncTask(this.f40225f, xmlParser).execute(new Void[0]);
            setAdapter(this.f40225f);
        } catch (Exception e2) {
            Log.e(f40220g, getResources().getString(R$string.changelog_internal_error_parsing), e2);
        }
    }

    /* access modifiers changed from: protected */
    public void c(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R$styleable.f40177a, i2, i2);
        try {
            this.f40221b = obtainStyledAttributes.getResourceId(R$styleable.f40181e, this.f40221b);
            this.f40222c = obtainStyledAttributes.getResourceId(R$styleable.f40180d, this.f40222c);
            this.f40223d = obtainStyledAttributes.getResourceId(R$styleable.f40178b, this.f40223d);
            this.f40224e = obtainStyledAttributes.getString(R$styleable.f40179c);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
    }

    public void setAdapter(ChangeLogAdapter changeLogAdapter) {
        super.setAdapter(changeLogAdapter);
    }
}
