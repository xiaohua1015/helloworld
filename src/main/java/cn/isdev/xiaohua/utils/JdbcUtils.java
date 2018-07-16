package cn.isdev.xiaohua.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by Administrator on 2018/7/16.
 */
public class JdbcUtils {

    private static DataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource();
    }

    public static QueryRunner getQueryRunner(){
        return new QueryRunner(dataSource);
    }
}
