package com.intimate.pojo;

import java.util.ArrayList;
import java.util.List;

public class IdCardInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IdCardInfoExample() {
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

        public Criteria andIdCardInfoIdIsNull() {
            addCriterion("id_card_info_id is null");
            return (Criteria) this;
        }

        public Criteria andIdCardInfoIdIsNotNull() {
            addCriterion("id_card_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardInfoIdEqualTo(Long value) {
            addCriterion("id_card_info_id =", value, "idCardInfoId");
            return (Criteria) this;
        }

        public Criteria andIdCardInfoIdNotEqualTo(Long value) {
            addCriterion("id_card_info_id <>", value, "idCardInfoId");
            return (Criteria) this;
        }

        public Criteria andIdCardInfoIdGreaterThan(Long value) {
            addCriterion("id_card_info_id >", value, "idCardInfoId");
            return (Criteria) this;
        }

        public Criteria andIdCardInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id_card_info_id >=", value, "idCardInfoId");
            return (Criteria) this;
        }

        public Criteria andIdCardInfoIdLessThan(Long value) {
            addCriterion("id_card_info_id <", value, "idCardInfoId");
            return (Criteria) this;
        }

        public Criteria andIdCardInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("id_card_info_id <=", value, "idCardInfoId");
            return (Criteria) this;
        }

        public Criteria andIdCardInfoIdIn(List<Long> values) {
            addCriterion("id_card_info_id in", values, "idCardInfoId");
            return (Criteria) this;
        }

        public Criteria andIdCardInfoIdNotIn(List<Long> values) {
            addCriterion("id_card_info_id not in", values, "idCardInfoId");
            return (Criteria) this;
        }

        public Criteria andIdCardInfoIdBetween(Long value1, Long value2) {
            addCriterion("id_card_info_id between", value1, value2, "idCardInfoId");
            return (Criteria) this;
        }

        public Criteria andIdCardInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("id_card_info_id not between", value1, value2, "idCardInfoId");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberIsNull() {
            addCriterion("id_card_number is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberIsNotNull() {
            addCriterion("id_card_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberEqualTo(Long value) {
            addCriterion("id_card_number =", value, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberNotEqualTo(Long value) {
            addCriterion("id_card_number <>", value, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberGreaterThan(Long value) {
            addCriterion("id_card_number >", value, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("id_card_number >=", value, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberLessThan(Long value) {
            addCriterion("id_card_number <", value, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberLessThanOrEqualTo(Long value) {
            addCriterion("id_card_number <=", value, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberIn(List<Long> values) {
            addCriterion("id_card_number in", values, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberNotIn(List<Long> values) {
            addCriterion("id_card_number not in", values, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberBetween(Long value1, Long value2) {
            addCriterion("id_card_number between", value1, value2, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNumberNotBetween(Long value1, Long value2) {
            addCriterion("id_card_number not between", value1, value2, "idCardNumber");
            return (Criteria) this;
        }

        public Criteria andIdCardNameIsNull() {
            addCriterion("id_card_name is null");
            return (Criteria) this;
        }

        public Criteria andIdCardNameIsNotNull() {
            addCriterion("id_card_name is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardNameEqualTo(String value) {
            addCriterion("id_card_name =", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameNotEqualTo(String value) {
            addCriterion("id_card_name <>", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameGreaterThan(String value) {
            addCriterion("id_card_name >", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_name >=", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameLessThan(String value) {
            addCriterion("id_card_name <", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameLessThanOrEqualTo(String value) {
            addCriterion("id_card_name <=", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameLike(String value) {
            addCriterion("id_card_name like", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameNotLike(String value) {
            addCriterion("id_card_name not like", value, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameIn(List<String> values) {
            addCriterion("id_card_name in", values, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameNotIn(List<String> values) {
            addCriterion("id_card_name not in", values, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameBetween(String value1, String value2) {
            addCriterion("id_card_name between", value1, value2, "idCardName");
            return (Criteria) this;
        }

        public Criteria andIdCardNameNotBetween(String value1, String value2) {
            addCriterion("id_card_name not between", value1, value2, "idCardName");
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

        public Criteria andIdCardImagePositiveIsNull() {
            addCriterion("id_card_image_positive is null");
            return (Criteria) this;
        }

        public Criteria andIdCardImagePositiveIsNotNull() {
            addCriterion("id_card_image_positive is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardImagePositiveEqualTo(String value) {
            addCriterion("id_card_image_positive =", value, "idCardImagePositive");
            return (Criteria) this;
        }

        public Criteria andIdCardImagePositiveNotEqualTo(String value) {
            addCriterion("id_card_image_positive <>", value, "idCardImagePositive");
            return (Criteria) this;
        }

        public Criteria andIdCardImagePositiveGreaterThan(String value) {
            addCriterion("id_card_image_positive >", value, "idCardImagePositive");
            return (Criteria) this;
        }

        public Criteria andIdCardImagePositiveGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_image_positive >=", value, "idCardImagePositive");
            return (Criteria) this;
        }

        public Criteria andIdCardImagePositiveLessThan(String value) {
            addCriterion("id_card_image_positive <", value, "idCardImagePositive");
            return (Criteria) this;
        }

        public Criteria andIdCardImagePositiveLessThanOrEqualTo(String value) {
            addCriterion("id_card_image_positive <=", value, "idCardImagePositive");
            return (Criteria) this;
        }

        public Criteria andIdCardImagePositiveLike(String value) {
            addCriterion("id_card_image_positive like", value, "idCardImagePositive");
            return (Criteria) this;
        }

        public Criteria andIdCardImagePositiveNotLike(String value) {
            addCriterion("id_card_image_positive not like", value, "idCardImagePositive");
            return (Criteria) this;
        }

        public Criteria andIdCardImagePositiveIn(List<String> values) {
            addCriterion("id_card_image_positive in", values, "idCardImagePositive");
            return (Criteria) this;
        }

        public Criteria andIdCardImagePositiveNotIn(List<String> values) {
            addCriterion("id_card_image_positive not in", values, "idCardImagePositive");
            return (Criteria) this;
        }

        public Criteria andIdCardImagePositiveBetween(String value1, String value2) {
            addCriterion("id_card_image_positive between", value1, value2, "idCardImagePositive");
            return (Criteria) this;
        }

        public Criteria andIdCardImagePositiveNotBetween(String value1, String value2) {
            addCriterion("id_card_image_positive not between", value1, value2, "idCardImagePositive");
            return (Criteria) this;
        }

        public Criteria andIdCardImageVersoIsNull() {
            addCriterion("id_card_image_verso is null");
            return (Criteria) this;
        }

        public Criteria andIdCardImageVersoIsNotNull() {
            addCriterion("id_card_image_verso is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardImageVersoEqualTo(String value) {
            addCriterion("id_card_image_verso =", value, "idCardImageVerso");
            return (Criteria) this;
        }

        public Criteria andIdCardImageVersoNotEqualTo(String value) {
            addCriterion("id_card_image_verso <>", value, "idCardImageVerso");
            return (Criteria) this;
        }

        public Criteria andIdCardImageVersoGreaterThan(String value) {
            addCriterion("id_card_image_verso >", value, "idCardImageVerso");
            return (Criteria) this;
        }

        public Criteria andIdCardImageVersoGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_image_verso >=", value, "idCardImageVerso");
            return (Criteria) this;
        }

        public Criteria andIdCardImageVersoLessThan(String value) {
            addCriterion("id_card_image_verso <", value, "idCardImageVerso");
            return (Criteria) this;
        }

        public Criteria andIdCardImageVersoLessThanOrEqualTo(String value) {
            addCriterion("id_card_image_verso <=", value, "idCardImageVerso");
            return (Criteria) this;
        }

        public Criteria andIdCardImageVersoLike(String value) {
            addCriterion("id_card_image_verso like", value, "idCardImageVerso");
            return (Criteria) this;
        }

        public Criteria andIdCardImageVersoNotLike(String value) {
            addCriterion("id_card_image_verso not like", value, "idCardImageVerso");
            return (Criteria) this;
        }

        public Criteria andIdCardImageVersoIn(List<String> values) {
            addCriterion("id_card_image_verso in", values, "idCardImageVerso");
            return (Criteria) this;
        }

        public Criteria andIdCardImageVersoNotIn(List<String> values) {
            addCriterion("id_card_image_verso not in", values, "idCardImageVerso");
            return (Criteria) this;
        }

        public Criteria andIdCardImageVersoBetween(String value1, String value2) {
            addCriterion("id_card_image_verso between", value1, value2, "idCardImageVerso");
            return (Criteria) this;
        }

        public Criteria andIdCardImageVersoNotBetween(String value1, String value2) {
            addCriterion("id_card_image_verso not between", value1, value2, "idCardImageVerso");
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