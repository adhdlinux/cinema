package it.gmariotti.changelibs.library.internal;

import java.util.Iterator;
import java.util.LinkedList;

public class ChangeLog {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<ChangeLogRow> f40187a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f40188b;

    public void a(ChangeLogRow changeLogRow) {
        if (changeLogRow != null) {
            if (this.f40187a == null) {
                this.f40187a = new LinkedList<>();
            }
            this.f40187a.add(changeLogRow);
        }
    }

    public LinkedList<ChangeLogRow> b() {
        return this.f40187a;
    }

    public void c(boolean z2) {
        this.f40188b = z2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("bulletedList=" + this.f40188b);
        sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        LinkedList<ChangeLogRow> linkedList = this.f40187a;
        if (linkedList != null) {
            Iterator<ChangeLogRow> it2 = linkedList.iterator();
            while (it2.hasNext()) {
                sb.append("row=[");
                sb.append(it2.next().toString());
                sb.append("]\n");
            }
        } else {
            sb.append("rows:none");
        }
        return sb.toString();
    }
}
