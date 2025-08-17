package com.movie.ui.fragment.mylist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.database.entitys.UserListEntity;
import com.yoku.marumovie.R;

public class UserListAdapter extends ListAdapter<UserListEntity, ViewHolder> {

    /* renamed from: q  reason: collision with root package name */
    private static final DiffUtil.ItemCallback<UserListEntity> f33402q = new DiffUtil.ItemCallback<UserListEntity>() {
        /* renamed from: d */
        public boolean a(UserListEntity userListEntity, UserListEntity userListEntity2) {
            return userListEntity.f19321c.equals(userListEntity2.f19321c) && userListEntity.f19322d.equals(userListEntity2.f19322d) && userListEntity.f19320b.equals(userListEntity2.f19320b);
        }

        /* renamed from: e */
        public boolean b(UserListEntity userListEntity, UserListEntity userListEntity2) {
            return userListEntity.f19321c.equals(userListEntity2.f19321c);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public Listener f33403p;

    interface Listener {
        void D(UserListEntity userListEntity);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: j  reason: collision with root package name */
        private final View f33407j;

        /* renamed from: k  reason: collision with root package name */
        public ImageButton f33408k;

        /* renamed from: l  reason: collision with root package name */
        public ImageView f33409l;

        ViewHolder(View view) {
            super(view);
            this.f33407j = view;
        }

        /* access modifiers changed from: package-private */
        public void a(UserListEntity userListEntity) {
            this.f33408k = (ImageButton) this.f33407j.findViewById(R.id.addToList);
            this.f33409l = (ImageView) this.f33407j.findViewById(R.id.added);
            ((TextView) this.f33407j.findViewById(R.id.listId)).setText(userListEntity.f19321c);
            ((TextView) this.f33407j.findViewById(R.id.listName)).setText(userListEntity.f19320b);
            ((TextView) this.f33407j.findViewById(R.id.pivacy)).setText(userListEntity.f19323e);
            if (userListEntity.f19325g.booleanValue()) {
                this.f33408k.setVisibility(8);
                this.f33409l.setVisibility(0);
                return;
            }
            this.f33408k.setVisibility(0);
            this.f33409l.setVisibility(8);
        }
    }

    protected UserListAdapter() {
        super(f33402q);
    }

    /* renamed from: g */
    public void onBindViewHolder(final ViewHolder viewHolder, int i2) {
        final UserListEntity userListEntity = (UserListEntity) c(i2);
        viewHolder.a(userListEntity);
        viewHolder.f33408k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (UserListAdapter.this.f33403p != null) {
                    UserListAdapter.this.f33403p.D(userListEntity);
                    viewHolder.f33408k.setVisibility(8);
                    viewHolder.f33409l.setVisibility(0);
                }
            }
        });
    }

    /* renamed from: h */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_userlist, viewGroup, false));
    }

    public void i(Listener listener) {
        this.f33403p = listener;
    }
}
