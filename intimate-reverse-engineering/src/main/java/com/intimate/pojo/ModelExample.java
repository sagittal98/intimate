package com.intimate.pojo;

import java.util.ArrayList;
import java.util.List;

public class ModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModelExample() {
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

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(Long value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(Long value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(Long value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(Long value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(Long value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<Long> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<Long> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(Long value1, Long value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(Long value1, Long value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelTitleIsNull() {
            addCriterion("model_title is null");
            return (Criteria) this;
        }

        public Criteria andModelTitleIsNotNull() {
            addCriterion("model_title is not null");
            return (Criteria) this;
        }

        public Criteria andModelTitleEqualTo(String value) {
            addCriterion("model_title =", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleNotEqualTo(String value) {
            addCriterion("model_title <>", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleGreaterThan(String value) {
            addCriterion("model_title >", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleGreaterThanOrEqualTo(String value) {
            addCriterion("model_title >=", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleLessThan(String value) {
            addCriterion("model_title <", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleLessThanOrEqualTo(String value) {
            addCriterion("model_title <=", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleLike(String value) {
            addCriterion("model_title like", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleNotLike(String value) {
            addCriterion("model_title not like", value, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleIn(List<String> values) {
            addCriterion("model_title in", values, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleNotIn(List<String> values) {
            addCriterion("model_title not in", values, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleBetween(String value1, String value2) {
            addCriterion("model_title between", value1, value2, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelTitleNotBetween(String value1, String value2) {
            addCriterion("model_title not between", value1, value2, "modelTitle");
            return (Criteria) this;
        }

        public Criteria andModelImageUrlIsNull() {
            addCriterion("model_image_url is null");
            return (Criteria) this;
        }

        public Criteria andModelImageUrlIsNotNull() {
            addCriterion("model_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andModelImageUrlEqualTo(String value) {
            addCriterion("model_image_url =", value, "modelImageUrl");
            return (Criteria) this;
        }

        public Criteria andModelImageUrlNotEqualTo(String value) {
            addCriterion("model_image_url <>", value, "modelImageUrl");
            return (Criteria) this;
        }

        public Criteria andModelImageUrlGreaterThan(String value) {
            addCriterion("model_image_url >", value, "modelImageUrl");
            return (Criteria) this;
        }

        public Criteria andModelImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("model_image_url >=", value, "modelImageUrl");
            return (Criteria) this;
        }

        public Criteria andModelImageUrlLessThan(String value) {
            addCriterion("model_image_url <", value, "modelImageUrl");
            return (Criteria) this;
        }

        public Criteria andModelImageUrlLessThanOrEqualTo(String value) {
            addCriterion("model_image_url <=", value, "modelImageUrl");
            return (Criteria) this;
        }

        public Criteria andModelImageUrlLike(String value) {
            addCriterion("model_image_url like", value, "modelImageUrl");
            return (Criteria) this;
        }

        public Criteria andModelImageUrlNotLike(String value) {
            addCriterion("model_image_url not like", value, "modelImageUrl");
            return (Criteria) this;
        }

        public Criteria andModelImageUrlIn(List<String> values) {
            addCriterion("model_image_url in", values, "modelImageUrl");
            return (Criteria) this;
        }

        public Criteria andModelImageUrlNotIn(List<String> values) {
            addCriterion("model_image_url not in", values, "modelImageUrl");
            return (Criteria) this;
        }

        public Criteria andModelImageUrlBetween(String value1, String value2) {
            addCriterion("model_image_url between", value1, value2, "modelImageUrl");
            return (Criteria) this;
        }

        public Criteria andModelImageUrlNotBetween(String value1, String value2) {
            addCriterion("model_image_url not between", value1, value2, "modelImageUrl");
            return (Criteria) this;
        }

        public Criteria andModelLevelIsNull() {
            addCriterion("model_level is null");
            return (Criteria) this;
        }

        public Criteria andModelLevelIsNotNull() {
            addCriterion("model_level is not null");
            return (Criteria) this;
        }

        public Criteria andModelLevelEqualTo(Byte value) {
            addCriterion("model_level =", value, "modelLevel");
            return (Criteria) this;
        }

        public Criteria andModelLevelNotEqualTo(Byte value) {
            addCriterion("model_level <>", value, "modelLevel");
            return (Criteria) this;
        }

        public Criteria andModelLevelGreaterThan(Byte value) {
            addCriterion("model_level >", value, "modelLevel");
            return (Criteria) this;
        }

        public Criteria andModelLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("model_level >=", value, "modelLevel");
            return (Criteria) this;
        }

        public Criteria andModelLevelLessThan(Byte value) {
            addCriterion("model_level <", value, "modelLevel");
            return (Criteria) this;
        }

        public Criteria andModelLevelLessThanOrEqualTo(Byte value) {
            addCriterion("model_level <=", value, "modelLevel");
            return (Criteria) this;
        }

        public Criteria andModelLevelIn(List<Byte> values) {
            addCriterion("model_level in", values, "modelLevel");
            return (Criteria) this;
        }

        public Criteria andModelLevelNotIn(List<Byte> values) {
            addCriterion("model_level not in", values, "modelLevel");
            return (Criteria) this;
        }

        public Criteria andModelLevelBetween(Byte value1, Byte value2) {
            addCriterion("model_level between", value1, value2, "modelLevel");
            return (Criteria) this;
        }

        public Criteria andModelLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("model_level not between", value1, value2, "modelLevel");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNull() {
            addCriterion("model_type is null");
            return (Criteria) this;
        }

        public Criteria andModelTypeIsNotNull() {
            addCriterion("model_type is not null");
            return (Criteria) this;
        }

        public Criteria andModelTypeEqualTo(Byte value) {
            addCriterion("model_type =", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotEqualTo(Byte value) {
            addCriterion("model_type <>", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThan(Byte value) {
            addCriterion("model_type >", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("model_type >=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThan(Byte value) {
            addCriterion("model_type <", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeLessThanOrEqualTo(Byte value) {
            addCriterion("model_type <=", value, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeIn(List<Byte> values) {
            addCriterion("model_type in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotIn(List<Byte> values) {
            addCriterion("model_type not in", values, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeBetween(Byte value1, Byte value2) {
            addCriterion("model_type between", value1, value2, "modelType");
            return (Criteria) this;
        }

        public Criteria andModelTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("model_type not between", value1, value2, "modelType");
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