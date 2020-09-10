package com.intimate.pojo;

import java.util.ArrayList;
import java.util.List;

public class VillageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VillageExample() {
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

        public Criteria andVillageIdIsNull() {
            addCriterion("village_id is null");
            return (Criteria) this;
        }

        public Criteria andVillageIdIsNotNull() {
            addCriterion("village_id is not null");
            return (Criteria) this;
        }

        public Criteria andVillageIdEqualTo(Integer value) {
            addCriterion("village_id =", value, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdNotEqualTo(Integer value) {
            addCriterion("village_id <>", value, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdGreaterThan(Integer value) {
            addCriterion("village_id >", value, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("village_id >=", value, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdLessThan(Integer value) {
            addCriterion("village_id <", value, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdLessThanOrEqualTo(Integer value) {
            addCriterion("village_id <=", value, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdIn(List<Integer> values) {
            addCriterion("village_id in", values, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdNotIn(List<Integer> values) {
            addCriterion("village_id not in", values, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdBetween(Integer value1, Integer value2) {
            addCriterion("village_id between", value1, value2, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("village_id not between", value1, value2, "villageId");
            return (Criteria) this;
        }

        public Criteria andVillageCodeIsNull() {
            addCriterion("village_code is null");
            return (Criteria) this;
        }

        public Criteria andVillageCodeIsNotNull() {
            addCriterion("village_code is not null");
            return (Criteria) this;
        }

        public Criteria andVillageCodeEqualTo(Long value) {
            addCriterion("village_code =", value, "villageCode");
            return (Criteria) this;
        }

        public Criteria andVillageCodeNotEqualTo(Long value) {
            addCriterion("village_code <>", value, "villageCode");
            return (Criteria) this;
        }

        public Criteria andVillageCodeGreaterThan(Long value) {
            addCriterion("village_code >", value, "villageCode");
            return (Criteria) this;
        }

        public Criteria andVillageCodeGreaterThanOrEqualTo(Long value) {
            addCriterion("village_code >=", value, "villageCode");
            return (Criteria) this;
        }

        public Criteria andVillageCodeLessThan(Long value) {
            addCriterion("village_code <", value, "villageCode");
            return (Criteria) this;
        }

        public Criteria andVillageCodeLessThanOrEqualTo(Long value) {
            addCriterion("village_code <=", value, "villageCode");
            return (Criteria) this;
        }

        public Criteria andVillageCodeIn(List<Long> values) {
            addCriterion("village_code in", values, "villageCode");
            return (Criteria) this;
        }

        public Criteria andVillageCodeNotIn(List<Long> values) {
            addCriterion("village_code not in", values, "villageCode");
            return (Criteria) this;
        }

        public Criteria andVillageCodeBetween(Long value1, Long value2) {
            addCriterion("village_code between", value1, value2, "villageCode");
            return (Criteria) this;
        }

        public Criteria andVillageCodeNotBetween(Long value1, Long value2) {
            addCriterion("village_code not between", value1, value2, "villageCode");
            return (Criteria) this;
        }

        public Criteria andVillageTypeIsNull() {
            addCriterion("village_type is null");
            return (Criteria) this;
        }

        public Criteria andVillageTypeIsNotNull() {
            addCriterion("village_type is not null");
            return (Criteria) this;
        }

        public Criteria andVillageTypeEqualTo(Short value) {
            addCriterion("village_type =", value, "villageType");
            return (Criteria) this;
        }

        public Criteria andVillageTypeNotEqualTo(Short value) {
            addCriterion("village_type <>", value, "villageType");
            return (Criteria) this;
        }

        public Criteria andVillageTypeGreaterThan(Short value) {
            addCriterion("village_type >", value, "villageType");
            return (Criteria) this;
        }

        public Criteria andVillageTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("village_type >=", value, "villageType");
            return (Criteria) this;
        }

        public Criteria andVillageTypeLessThan(Short value) {
            addCriterion("village_type <", value, "villageType");
            return (Criteria) this;
        }

        public Criteria andVillageTypeLessThanOrEqualTo(Short value) {
            addCriterion("village_type <=", value, "villageType");
            return (Criteria) this;
        }

        public Criteria andVillageTypeIn(List<Short> values) {
            addCriterion("village_type in", values, "villageType");
            return (Criteria) this;
        }

        public Criteria andVillageTypeNotIn(List<Short> values) {
            addCriterion("village_type not in", values, "villageType");
            return (Criteria) this;
        }

        public Criteria andVillageTypeBetween(Short value1, Short value2) {
            addCriterion("village_type between", value1, value2, "villageType");
            return (Criteria) this;
        }

        public Criteria andVillageTypeNotBetween(Short value1, Short value2) {
            addCriterion("village_type not between", value1, value2, "villageType");
            return (Criteria) this;
        }

        public Criteria andVillageNameIsNull() {
            addCriterion("village_name is null");
            return (Criteria) this;
        }

        public Criteria andVillageNameIsNotNull() {
            addCriterion("village_name is not null");
            return (Criteria) this;
        }

        public Criteria andVillageNameEqualTo(String value) {
            addCriterion("village_name =", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameNotEqualTo(String value) {
            addCriterion("village_name <>", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameGreaterThan(String value) {
            addCriterion("village_name >", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameGreaterThanOrEqualTo(String value) {
            addCriterion("village_name >=", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameLessThan(String value) {
            addCriterion("village_name <", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameLessThanOrEqualTo(String value) {
            addCriterion("village_name <=", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameLike(String value) {
            addCriterion("village_name like", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameNotLike(String value) {
            addCriterion("village_name not like", value, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameIn(List<String> values) {
            addCriterion("village_name in", values, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameNotIn(List<String> values) {
            addCriterion("village_name not in", values, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameBetween(String value1, String value2) {
            addCriterion("village_name between", value1, value2, "villageName");
            return (Criteria) this;
        }

        public Criteria andVillageNameNotBetween(String value1, String value2) {
            addCriterion("village_name not between", value1, value2, "villageName");
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