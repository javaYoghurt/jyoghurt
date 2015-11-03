package com.github.jYoghourt.core.controller.form;

/**
 * Created by jtwu on 2015/6/9.
 * sql 运算符
 */
public class OperatorHandle {
    public enum operatorType {
        EQUAL, LIKE, LESS_THEN, MORE_THEN, LESS_EQUAL, MORE_EQUAL,IN
    }

    private String column;
    private operatorType operator;
    private Object[] values;
    public OperatorHandle() {
    }

    public OperatorHandle(String column, operatorType operator) {
        this.column = column;
        this.operator = operator;
    }

    public OperatorHandle(String column, operatorType operator, Object[] values) {
        this.column = column;
        this.operator = operator;
        this.values = values;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public operatorType getOperator() {
        return operator;
    }

    public void setOperator(operatorType operator) {
        this.operator = operator;
    }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }
}
