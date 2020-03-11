package com.bookstore.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDao<T> {
   // @Autowired
    protected JdbcTemplate jdbcTemplate;

    private Class<T> type;

    public BaseDao(){
        // 子类继承BaseDao
        // 获取子类类型，获取到父类的类型
        ParameterizedType genericSuperclass = (ParameterizedType) this
                .getClass().getGenericSuperclass();
        // genericSuperclass.getActualTypeArguments获取真实的参数类型
        type = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }
    // 获取一条数据
    public T get(String sql, Object... params){
        T object = null;
        try {
            object = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(type), params);
        } catch (DataAccessException e) {
        }
        return object;
    }
    // 获取一组数据
    public List<T> getList(String sql, Object... params){
        return  jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(type), params);
    }
    // 更新数据，// 更新不成功返回0，成功返回1
    public int update(String sql, Object...params){
        return jdbcTemplate.update(sql, params);
    }

}





