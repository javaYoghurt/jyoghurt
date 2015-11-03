package com.github.jYoghourt.core.service.impl;

import com.df.core.configuration.PageConvert;
import com.df.core.controller.form.QueryHandle;
import com.df.core.dao.BaseMapper;
import com.df.core.domain.BaseEntity;
import com.df.core.exception.ServiceException;
import com.df.core.result.EasyUIResult;
import com.df.core.result.QueryResult;
import com.df.core.service.BaseService;
import com.df.core.utils.ChainMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务支持
 * <p>
 * 为服务组件的基类，必须继承
 *
 * @param <T>
 *            该服务组件服务的数据模型，即model;
 * @author jtwu
 */
@SuppressWarnings("unchecked")
public abstract class  ServiceSupport<T, M extends BaseMapper<T>> implements BaseService<T> {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public abstract M getMapper();
    @Value("${tableJsLib}")
    private String tableJsLib;

    @Resource(name = "pageConvert")
    private PageConvert pageConvert;

    @Override
    public void save(T entity) throws ServiceException {
        if (entity instanceof BaseEntity) {
            ((BaseEntity) entity).setCreateDateTime(new Date());
            ((BaseEntity) entity).setModifyDateTime(((BaseEntity) entity).getCreateDateTime());
            ((BaseEntity) entity).setOperatorId((String) getSessionAttr(BaseEntity.OPERATOR_ID));
            ((BaseEntity) entity).setOperatorName((String) getSessionAttr(BaseEntity.OPERATOR_NAME));
        }
        getMapper().save(entity);
    }

    @Override
    public void saveForSelective(T entity) throws ServiceException {
        if (entity instanceof BaseEntity) {
            ((BaseEntity) entity).setCreateDateTime(new Date());
            ((BaseEntity) entity).setModifyDateTime(((BaseEntity) entity).getCreateDateTime());
            ((BaseEntity) entity).setOperatorId((String) getSessionAttr(BaseEntity.OPERATOR_ID));
            ((BaseEntity) entity).setOperatorName((String) getSessionAttr(BaseEntity.OPERATOR_NAME));
        }

        getMapper().saveForSelective(entity);
    }

    @Override
    public void update(T entity) throws ServiceException {
        if (entity instanceof BaseEntity) {
            ((BaseEntity) entity).setModifyDateTime(new Date());
            ((BaseEntity) entity).setOperatorId((String) getSessionAttr(BaseEntity.OPERATOR_ID));
            ((BaseEntity) entity).setOperatorName((String) getSessionAttr(BaseEntity.OPERATOR_NAME));
        }
        getMapper().update(entity);
    }

    @Override
    public void deleteByCondition(T entity) throws ServiceException {
        getMapper().deleteByCondition((Class<T>) entity.getClass(), getValueMap(entity));
    }

    @Override
    public void deleteByCondition(T entity,QueryHandle queryHandle) throws ServiceException {
        getMapper().deleteByCondition((Class<T>) entity.getClass(),getValueMap(entity, queryHandle));
    }

    @Override
    public QueryResult<T> getData(T entity, QueryHandle queryHandle) throws ServiceException {
        QueryResult<T> qr = newQueryResult();
        qr.setData(getMapper().pageData((Class<T>) entity.getClass(), getValueMap(queryHandle, entity).chainPutAll
                (queryHandle.getExpandData())));
        qr.setRecordsTotal(getMapper().pageTotalRecord((Class<T>) entity.getClass(), getValueMap(queryHandle,
                entity).chainPutAll(queryHandle.getExpandData())));
        return qr;
    }

	protected QueryResult<T> newQueryResult() {
        if(StringUtils.isEmpty(tableJsLib)){
            return new EasyUIResult<>();
        }
        return pageConvert.createQueryResult();
	}

    @Override
    public void updateForSelective(T entity) throws ServiceException {
        if (entity instanceof BaseEntity) {
            ((BaseEntity) entity).setModifyDateTime(new Date());
            ((BaseEntity) entity).setOperatorId((String) getSessionAttr(BaseEntity.OPERATOR_ID));
            ((BaseEntity) entity).setOperatorName((String) getSessionAttr(BaseEntity.OPERATOR_NAME));
        }
        getMapper().updateForSelective(entity);
    }

    @Override
    public Long count(Map<String, Object> form) throws ServiceException {
        return getMapper().count(form);
    }

    @Override
    public List<T> findAll(T entity, QueryHandle queryHandle) throws ServiceException {
        return getMapper().findAll((Class<T>) entity.getClass(), getValueMap(queryHandle, entity));
    }

    /**
     * 实体转map
     *
     * @param objs
     * @return
     */
    protected ChainMap<String, Object> getValueMap(Object... objs) throws ServiceException {
        try {
            ChainMap<String, Object> map = new ChainMap<>();
            for (Object obj : objs) {
                if (null == obj) {
                    continue;
                }
                for (Class<?> c = obj.getClass(); Object.class != c; c = c.getSuperclass()) {
                	for (Field field : c.getDeclaredFields()) {
                		field.setAccessible(true);
                        Object value = field.get(obj);
                        if (null == value) {
                            continue;
                        }
                        if(field.getType().isAssignableFrom(String.class)&& StringUtils.isEmpty((String) value)){
                            continue;
                        }
                        map.put(field.getName(), value);
                		
                	}
                }

            }
            return map;
        } catch (Exception e) {
            throw new ServiceException("Object to Map convert Error", e);
        }

    }

    @Override
    public List<T> findAll(T entity) throws ServiceException {
        return findAll(entity, null);
    }

    /**
     * 获取request
     *
     * @return HttpServletRequest
     */
    private Object getSessionAttr(String attr) {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession()
                .getAttribute(attr);
    }
}
