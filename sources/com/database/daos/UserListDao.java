package com.database.daos;

import com.database.entitys.UserListEntity;
import io.reactivex.Flowable;
import java.util.List;

public interface UserListDao {
    void a();

    void b(String str);

    void c(String str);

    void d(UserListEntity... userListEntityArr);

    void e(UserListEntity... userListEntityArr);

    void f(UserListEntity... userListEntityArr);

    Flowable<List<UserListEntity>> g();

    UserListEntity get(String str);

    List<UserListEntity> h();
}
