package com.github.jYoghourt.core.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by jtwu on 2015/4/21.
 */
public class BaseEntity implements Serializable {
    @Transient
    public static final String OPERATOR_ID = "operatorId";
    @Transient
    public static final String OPERATOR_NAME = "operatorName";

    private static final long serialVersionUID = 6468926052770326495L;
    // 创建时间
    private Date createDateTime;
    // 修改时间
    private Date modifyDateTime;
    // 操作人
    private String operatorId;
    // 操作人Id
    private String operatorName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getModifyDateTime() {
        return modifyDateTime;
    }

    public void setModifyDateTime(Date modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateDateTime() {
        return createDateTime;
    }

    public BaseEntity setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
        return this;
    }


    public String getOperatorId() {
        return operatorId;
    }

    public BaseEntity setOperatorId(String operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public BaseEntity setOperatorName(String operatorName) {
        this.operatorName = operatorName;
        return this;
    }
}
