package com.intimate.pojo;

import java.util.ArrayList;
import java.util.List;

public class CourierNumberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourierNumberExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCnIdIsNull() {
            addCriterion("cn_id is null");
            return (Criteria) this;
        }

        public Criteria andCnIdIsNotNull() {
            addCriterion("cn_id is not null");
            return (Criteria) this;
        }

        public Criteria andCnIdEqualTo(Long value) {
            addCriterion("cn_id =", value, "cnId");
            return (Criteria) this;
        }

        public Criteria andCnIdNotEqualTo(Long value) {
            addCriterion("cn_id <>", value, "cnId");
            return (Criteria) this;
        }

        public Criteria andCnIdGreaterThan(Long value) {
            addCriterion("cn_id >", value, "cnId");
            return (Criteria) this;
        }

        public Criteria andCnIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cn_id >=", value, "cnId");
            return (Criteria) this;
        }

        public Criteria andCnIdLessThan(Long value) {
            addCriterion("cn_id <", value, "cnId");
            return (Criteria) this;
        }

        public Criteria andCnIdLessThanOrEqualTo(Long value) {
            addCriterion("cn_id <=", value, "cnId");
            return (Criteria) this;
        }

        public Criteria andCnIdIn(List<Long> values) {
            addCriterion("cn_id in", values, "cnId");
            return (Criteria) this;
        }

        public Criteria andCnIdNotIn(List<Long> values) {
            addCriterion("cn_id not in", values, "cnId");
            return (Criteria) this;
        }

        public Criteria andCnIdBetween(Long value1, Long value2) {
            addCriterion("cn_id between", value1, value2, "cnId");
            return (Criteria) this;
        }

        public Criteria andCnIdNotBetween(Long value1, Long value2) {
            addCriterion("cn_id not between", value1, value2, "cnId");
            return (Criteria) this;
        }

        public Criteria andCnNumberIsNull() {
            addCriterion("cn_number is null");
            return (Criteria) this;
        }

        public Criteria andCnNumberIsNotNull() {
            addCriterion("cn_number is not null");
            return (Criteria) this;
        }

        public Criteria andCnNumberEqualTo(String value) {
            addCriterion("cn_number =", value, "cnNumber");
            return (Criteria) this;
        }

        public Criteria andCnNumberNotEqualTo(String value) {
            addCriterion("cn_number <>", value, "cnNumber");
            return (Criteria) this;
        }

        public Criteria andCnNumberGreaterThan(String value) {
            addCriterion("cn_number >", value, "cnNumber");
            return (Criteria) this;
        }

        public Criteria andCnNumberGreaterThanOrEqualTo(String value) {
            addCriterion("cn_number >=", value, "cnNumber");
            return (Criteria) this;
        }

        public Criteria andCnNumberLessThan(String value) {
            addCriterion("cn_number <", value, "cnNumber");
            return (Criteria) this;
        }

        public Criteria andCnNumberLessThanOrEqualTo(String value) {
            addCriterion("cn_number <=", value, "cnNumber");
            return (Criteria) this;
        }

        public Criteria andCnNumberLike(String value) {
            addCriterion("cn_number like", value, "cnNumber");
            return (Criteria) this;
        }

        public Criteria andCnNumberNotLike(String value) {
            addCriterion("cn_number not like", value, "cnNumber");
            return (Criteria) this;
        }

        public Criteria andCnNumberIn(List<String> values) {
            addCriterion("cn_number in", values, "cnNumber");
            return (Criteria) this;
        }

        public Criteria andCnNumberNotIn(List<String> values) {
            addCriterion("cn_number not in", values, "cnNumber");
            return (Criteria) this;
        }

        public Criteria andCnNumberBetween(String value1, String value2) {
            addCriterion("cn_number between", value1, value2, "cnNumber");
            return (Criteria) this;
        }

        public Criteria andCnNumberNotBetween(String value1, String value2) {
            addCriterion("cn_number not between", value1, value2, "cnNumber");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIsNull() {
            addCriterion("notice_id is null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIsNotNull() {
            addCriterion("notice_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdEqualTo(Long value) {
            addCriterion("notice_id =", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotEqualTo(Long value) {
            addCriterion("notice_id <>", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThan(Long value) {
            addCriterion("notice_id >", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("notice_id >=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThan(Long value) {
            addCriterion("notice_id <", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThanOrEqualTo(Long value) {
            addCriterion("notice_id <=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIn(List<Long> values) {
            addCriterion("notice_id in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotIn(List<Long> values) {
            addCriterion("notice_id not in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdBetween(Long value1, Long value2) {
            addCriterion("notice_id between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotBetween(Long value1, Long value2) {
            addCriterion("notice_id not between", value1, value2, "noticeId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}