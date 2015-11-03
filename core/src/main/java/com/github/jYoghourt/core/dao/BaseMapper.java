package com.github.jYoghourt.core.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by jtwu on 2015/4/21.
 * mybatis通用处理类
 */

public interface BaseMapper<T> {
    String ENTITY_CLASS = "entityClass";
    String ENTITY = "entity";
    String ID = "id";
    String DATA = "data";

    /**
     * 插入一条记录
     *
     * @param entity 业务实体
     */
    @InsertProvider(type = BaseMapperProvider.class, method = "save")
    void save(@Param(ENTITY) T entity);

    /**
     * 插入非空字段
     *
     * @param entity 业务实体
     */
    @InsertProvider(type = BaseMapperProvider.class, method = "saveForSelective")
    void saveForSelective(@Param(ENTITY) T entity);

    /**
     * 更新一条记录
     *
     * @param entity 业务实体
     */
    @UpdateProvider(type = BaseMapperProvider.class, method = "update")
    void update(@Param(ENTITY) T entity);

    /**
     * 更新非空字段
     *
     * @param entity 业务实体
     */
    @UpdateProvider(type = BaseMapperProvider.class, method = "updateForSelective")
    void updateForSelective(@Param(ENTITY) T entity);

    /**
     * 删除
     *
     * @param entityClass 实体类型
     * @param id          主键
     */
    @DeleteProvider(type = BaseMapperProvider.class, method = "delete")
    void delete(@Param(ENTITY_CLASS) Class<?> entityClass, @Param(ID) Serializable id);


    /**
     * 删除实体
     *
     * @param entity 业务实体
     */
//    @DeleteProvider(type = BaseMapperProvider.class,method="delete")
//    void delete(T entity);

    /**
     * 根据条件删除
     *
     * @param map 删除条件
     */
    @DeleteProvider(type = BaseMapperProvider.class, method = "deleteByCondition")
    void deleteByCondition(@Param(ENTITY_CLASS) Class<T> entityClass, @Param(DATA) Map<String, Object> map);

    /**
     * 根据主键查询
     * 此处来写注解，在子类里面生效
     *
     * @param entityClass 业务实体
     * @param id          业务主键
     */
    T selectById(@Param(ENTITY_CLASS) Class<T> entityClass, @Param(ID) Serializable id);

    /**
     * 获取分页记录总数
     * 此处来写注解，在子类里面生效
     *
     * @param map
     * @return
     * @throws Exception
     */
    List<T> pageData(@Param(ENTITY_CLASS) Class<T> entityClass, @Param(DATA) Map<String, Object> map);

    /**
     * 统计分页记录总数
     *
     * @param map
     * @return
     * @throws Exception
     */
    @SelectProvider(type = BaseMapperProvider.class, method = "pageTotalRecord")
    Long pageTotalRecord(@Param(ENTITY_CLASS) Class<T> entityClass, @Param(DATA) Map<String, Object> map);

    /**
     * 按条件查询记录总数
     *
     * @param form
     * @return
     * @throws Exception
     */
    Long count(Map<String, Object> form);

    /**
     * 按条件查询记录集合
     * 此处来写注解，在子类里面生效
     *
     * @param map
     * @return
     * @throws Exception
     */
    List<T> findAll(@Param(ENTITY_CLASS) Class<T> entityClass, @Param(DATA) Map<String, Object> data);
}