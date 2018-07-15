package cn.isdev.xiaohua.jdbc;

import cn.isdev.xiaohua.utils.JdbcUtils;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/15.
 */
public class BaseDao {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    public void update(String sql, Object[] paramsValue) {
        conn = JdbcUtils.getConn();
        if (conn == null) {
//            throw new Exception("conn is null");
            System.out.println("conn is null");
            return;
        }
        try {
            pst = conn.prepareStatement(sql);
            int count = pst.getParameterMetaData().getParameterCount();
            if (paramsValue == null || paramsValue.length <= 0) {
                System.out.println("paramsValues is null");
                return;
            }
            for (int i = 0; i < count; i++) {
                pst.setObject(i + 1, paramsValue[i]);
            }
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.clossAll(conn, pst, null);
        }
    }

    public <T> List<T> query(String sql, Object[] paramsValue, Class type) {
        List<T> list = new ArrayList<>();
        T t = null;
        Connection conn = JdbcUtils.getConn();
        if (conn == null) {
            System.out.println("conn is null");
            return null;
        }
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            if(paramsValue != null && paramsValue.length>0){
                for (int i=0;i<paramsValue.length; i++) {
                    pst.setObject(i+1, paramsValue[i]);
                }
            }
            ResultSet rs = pst.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int coluCount = rsmd.getColumnCount();
            while(rs.next()) {
                t = (T) type.newInstance();
                for (int i=0; i<coluCount; i++) {
                    String columnName = rsmd.getColumnName(i + 1);
                    Object value = rs.getObject(columnName);
                    BeanUtils.copyProperty(t, columnName, value);
                }
                list.add(t);
            }
            return  list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }  finally {
            JdbcUtils.clossAll(conn, pst, rs);
        }
    }

}
