package com.github.jYoghourt.core.service;


import com.df.core.controller.form.QueryHandle;
import com.df.core.exception.ServiceException;
import com.df.core.result.QueryResult;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 服务接口的基类
 *
 * @param <T>此服务接口服务的数据模型，即model
 */
public interface BaseService<T> {
    /**
     * 保存实体
     *
     * @param entity 欲保存的实体
     * @throws ServiceException
     */
    void save(T entity) throws ServiceException;

    /**
     * 根据选择的保存实体
     *
     * @param entity 欲保存的实体
     * @throws ServiceException
     */
    void saveForSelective(T entity) throws ServiceException;

    /**
     * 更新实体
     *
     * @param entity 实体id
     */
    void update(T entity) throws ServiceException;

    /**
     * 根据选择的更新实体
     *
     * @param entity
     * @throws ServiceException
     */
    void updateForSelective(T entity) throws ServiceException;

    /**
     * 删除实体
     *
     * @param id
     * @throws ServiceException
     */
    void delete(Serializable id) throws ServiceException;
    /**
     * 根据条件删除
     *
     * @param entity 根据非空字段当做删除条件
     * @throws ServiceException
     */
    void deleteByCondition(T entity) throws ServiceException;
    /**
     * 根据条件删除
     *
     * @param entity 根据非空字段当做删除条件
     * @throws ServiceException
     */
    public void deleteByCondition(T entity, QueryHandle queryHandle) throws ServiceException ;

    /**
     * 获取实体
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    T find(Serializable id) throws ServiceException;

    /**
     * 获取数据
     *
     * @param entity
     * @return 根据查询条件查询的查询结果集
     */
    public QueryResult<T> getData(T entity, QueryHandle queryHandle) throws ServiceException;

    /**
     * 按条件查询记录总数
     *
     * @param form
     * @return
     * @throws ServiceException
     */
    Long count(Map<String, Object> form) throws ServiceException;

    /**
     * 按条件查询记录集合
     *
     * @param entity        业务实体类或业务查询实体类
     * @param queryHandle 查询辅助类
     * @return
     * @throws ServiceException
     */
    List<T> findAll(T entity, QueryHandle queryHandle) throws ServiceException;
    /**
     * 按条件查询记录集合
     *
     * @param entity        业务实体类或业务查询实体类
     * @return
     * @throws ServiceException
     */
    List<T> findAll(T entity) throws ServiceException;

}
