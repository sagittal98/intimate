package com.intimate.pojo;

import java.util.ArrayList;
import java.util.List;

public class TownExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TownExample() {
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

        public Criteria andTownIdIsNull() {
            addCriterion("town_id is null");
            return (Criteria) this;
        }

        public Criteria andTownIdIsNotNull() {
            addCriterion("town_id is not null");
            return (Criteria) this;
        }

        public Criteria andTownIdEqualTo(Integer value) {
            addCriterion("town_id =", value, "townId");
            return (Criteria) this;
        }

        public Criteria andTownIdNotEqualTo(Integer value) {
            addCriterion("town_id <>", value, "townId");
            return (Criteria) this;
        }

        public Criteria andTownIdGreaterThan(Integer value) {
            addCriterion("town_id >", value, "townId");
            return (Criteria) this;
        }

        public Criteria andTownIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("town_id >=", value, "townId");
            return (Criteria) this;
        }

        public Criteria andTownIdLessThan(Integer value) {
            addCriterion("town_id <", value, "townId");
            return (Criteria) this;
        }

        public Criteria andTownIdLessThanOrEqualTo(Integer value) {
            addCriterion("town_id <=", value, "townId");
            return (Criteria) this;
        }

        public Criteria andTownIdIn(List<Integer> values) {
            addCriterion("town_id in", values, "townId");
            return (Criteria) this;
        }

        public Criteria andTownIdNotIn(List<Integer> values) {
            addCriterion("town_id not in", values, "townId");
            return (Criteria) this;
        }

        public Criteria andTownIdBetween(Integer value1, Integer value2) {
            addCriterion("town_id between", value1, value2, "townId");
            return (Criteria) this;
        }

        public Criteria andTownIdNotBetween(Integer value1, Integer value2) {
            addCriterion("town_id not between", value1, value2, "townId");
            return (Criteria) this;
        }

        public Criteria andTownCodeIsNull() {
            addCriterion("town_code is null");
            return (Criteria) this;
        }

        public Criteria andTownCodeIsNotNull() {
            addCriterion("town_code is not null");
            return (Criteria) this;
        }

        public Criteria andTownCodeEqualTo(Integer value) {
            addCriterion("town_code =", value, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeNotEqualTo(Integer value) {
            addCriterion("town_code <>", value, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeGreaterThan(Integer value) {
            addCriterion("town_code >", value, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("town_code >=", value, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeLessThan(Integer value) {
            addCriterion("town_code <", value, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeLessThanOrEqualTo(Integer value) {
            addCriterion("town_code <=", value, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeIn(List<Integer> values) {
            addCriterion("town_code in", values, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeNotIn(List<Integer> values) {
            addCriterion("town_code not in", values, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeBetween(Integer value1, Integer value2) {
            addCriterion("town_code between", value1, value2, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("town_code not between", value1, value2, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownNameIsNull() {
            addCriterion("town_name is null");
            return (Criteria) this;
        }

        public Criteria andTownNameIsNotNull() {
            addCriterion("town_name is not null");
            return (Criteria) this;
        }

        public Criteria andTownNameEqualTo(String value) {
            addCriterion("town_name =", value, "townName");
            return (Criteria) this;
        }

        public Criteria andTownNameNotEqualTo(String value) {
            addCriterion("town_name <>", value, "townName");
            return (Criteria) this;
        }

        public Criteria andTownNameGreaterThan(String value) {
            addCriterion("town_name >", value, "townName");
            return (Criteria) this;
        }

        public Criteria andTownNameGreaterThanOrEqualTo(String value) {
            addCriterion("town_name >=", value, "townName");
            return (Criteria) this;
        }

        public Criteria andTownNameLessThan(String value) {
            addCriterion("town_name <", value, "townName");
            return (Criteria) this;
        }

        public Criteria andTownNameLessThanOrEqualTo(String value) {
            addCriterion("town_name <=", value, "townName");
            return (Criteria) this;
        }

        public Criteria andTownNameLike(String value) {
            addCriterion("town_name like", value, "townName");
            return (Criteria) this;
        }

        public Criteria andTownNameNotLike(String value) {
            addCriterion("town_name not like", value, "townName");
            return (Criteria) this;
        }

        public Criteria andTownNameIn(List<String> values) {
            addCriterion("town_name in", values, "townName");
            return (Criteria) this;
        }

        public Criteria andTownNameNotIn(List<String> values) {
            addCriterion("town_name not in", values, "townName");
            return (Criteria) this;
        }

        public Criteria andTownNameBetween(String value1, String value2) {
            addCriterion("town_name between", value1, value2, "townName");
            return (Criteria) this;
        }

        public Criteria andTownNameNotBetween(String value1, String value2) {
            addCriterion("town_name not between", value1, value2, "townName");
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