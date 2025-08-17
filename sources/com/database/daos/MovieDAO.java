package com.database.daos;

import com.database.entitys.MovieEntity;
import java.util.List;

public interface MovieDAO {
    int a();

    void b(MovieEntity... movieEntityArr) throws Exception;

    List<MovieEntity> c(Boolean bool, int i2);

    List<MovieEntity> d(Boolean bool);

    List<MovieEntity> e();

    int f();

    int g(MovieEntity... movieEntityArr);

    MovieEntity h(int i2);

    void i(int i2, long j2, String str, long j3, long j4);

    List<MovieEntity> j(boolean z2);

    void k(Long l2, long j2, String str, long j3, long j4);

    MovieEntity l(long j2, String str, long j3, long j4);

    int m(long j2, String str, long j3, long j4);

    List<MovieEntity> n();

    int o();

    void p(Long l2, long j2, String str, long j3, long j4);

    int q(long j2, String str, long j3, long j4, long j5, long j6, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Double d2, Long l2, Boolean bool, Boolean bool2, Boolean bool3, int i2, Long l3, Long l4);

    List<MovieEntity> r(int i2);

    long s(long j2, String str, long j3, long j4, long j5, long j6, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Double d2, Long l2, Boolean bool, Boolean bool2, Boolean bool3, int i2, Long l3, Long l4);
}
