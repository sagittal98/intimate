package com.intimate.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoteExample() {
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

        public Criteria andNoteIdIsNull() {
            addCriterion("note_id is null");
            return (Criteria) this;
        }

        public Criteria andNoteIdIsNotNull() {
            addCriterion("note_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoteIdEqualTo(Long value) {
            addCriterion("note_id =", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdNotEqualTo(Long value) {
            addCriterion("note_id <>", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdGreaterThan(Long value) {
            addCriterion("note_id >", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdGreaterThanOrEqualTo(Long value) {
            addCriterion("note_id >=", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdLessThan(Long value) {
            addCriterion("note_id <", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdLessThanOrEqualTo(Long value) {
            addCriterion("note_id <=", value, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdIn(List<Long> values) {
            addCriterion("note_id in", values, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdNotIn(List<Long> values) {
            addCriterion("note_id not in", values, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdBetween(Long value1, Long value2) {
            addCriterion("note_id between", value1, value2, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteIdNotBetween(Long value1, Long value2) {
            addCriterion("note_id not between", value1, value2, "noteId");
            return (Criteria) this;
        }

        public Criteria andNoteTitleIsNull() {
            addCriterion("note_title is null");
            return (Criteria) this;
        }

        public Criteria andNoteTitleIsNotNull() {
            addCriterion("note_title is not null");
            return (Criteria) this;
        }

        public Criteria andNoteTitleEqualTo(String value) {
            addCriterion("note_title =", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleNotEqualTo(String value) {
            addCriterion("note_title <>", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleGreaterThan(String value) {
            addCriterion("note_title >", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleGreaterThanOrEqualTo(String value) {
            addCriterion("note_title >=", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleLessThan(String value) {
            addCriterion("note_title <", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleLessThanOrEqualTo(String value) {
            addCriterion("note_title <=", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleLike(String value) {
            addCriterion("note_title like", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleNotLike(String value) {
            addCriterion("note_title not like", value, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleIn(List<String> values) {
            addCriterion("note_title in", values, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleNotIn(List<String> values) {
            addCriterion("note_title not in", values, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleBetween(String value1, String value2) {
            addCriterion("note_title between", value1, value2, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTitleNotBetween(String value1, String value2) {
            addCriterion("note_title not between", value1, value2, "noteTitle");
            return (Criteria) this;
        }

        public Criteria andNoteTextIsNull() {
            addCriterion("note_text is null");
            return (Criteria) this;
        }

        public Criteria andNoteTextIsNotNull() {
            addCriterion("note_text is not null");
            return (Criteria) this;
        }

        public Criteria andNoteTextEqualTo(String value) {
            addCriterion("note_text =", value, "noteText");
            return (Criteria) this;
        }

        public Criteria andNoteTextNotEqualTo(String value) {
            addCriterion("note_text <>", value, "noteText");
            return (Criteria) this;
        }

        public Criteria andNoteTextGreaterThan(String value) {
            addCriterion("note_text >", value, "noteText");
            return (Criteria) this;
        }

        public Criteria andNoteTextGreaterThanOrEqualTo(String value) {
            addCriterion("note_text >=", value, "noteText");
            return (Criteria) this;
        }

        public Criteria andNoteTextLessThan(String value) {
            addCriterion("note_text <", value, "noteText");
            return (Criteria) this;
        }

        public Criteria andNoteTextLessThanOrEqualTo(String value) {
            addCriterion("note_text <=", value, "noteText");
            return (Criteria) this;
        }

        public Criteria andNoteTextLike(String value) {
            addCriterion("note_text like", value, "noteText");
            return (Criteria) this;
        }

        public Criteria andNoteTextNotLike(String value) {
            addCriterion("note_text not like", value, "noteText");
            return (Criteria) this;
        }

        public Criteria andNoteTextIn(List<String> values) {
            addCriterion("note_text in", values, "noteText");
            return (Criteria) this;
        }

        public Criteria andNoteTextNotIn(List<String> values) {
            addCriterion("note_text not in", values, "noteText");
            return (Criteria) this;
        }

        public Criteria andNoteTextBetween(String value1, String value2) {
            addCriterion("note_text between", value1, value2, "noteText");
            return (Criteria) this;
        }

        public Criteria andNoteTextNotBetween(String value1, String value2) {
            addCriterion("note_text not between", value1, value2, "noteText");
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

        public Criteria andIsCardModelIsNull() {
            addCriterion("is_card_model is null");
            return (Criteria) this;
        }

        public Criteria andIsCardModelIsNotNull() {
            addCriterion("is_card_model is not null");
            return (Criteria) this;
        }

        public Criteria andIsCardModelEqualTo(Boolean value) {
            addCriterion("is_card_model =", value, "isCardModel");
            return (Criteria) this;
        }

        public Criteria andIsCardModelNotEqualTo(Boolean value) {
            addCriterion("is_card_model <>", value, "isCardModel");
            return (Criteria) this;
        }

        public Criteria andIsCardModelGreaterThan(Boolean value) {
            addCriterion("is_card_model >", value, "isCardModel");
            return (Criteria) this;
        }

        public Criteria andIsCardModelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_card_model >=", value, "isCardModel");
            return (Criteria) this;
        }

        public Criteria andIsCardModelLessThan(Boolean value) {
            addCriterion("is_card_model <", value, "isCardModel");
            return (Criteria) this;
        }

        public Criteria andIsCardModelLessThanOrEqualTo(Boolean value) {
            addCriterion("is_card_model <=", value, "isCardModel");
            return (Criteria) this;
        }

        public Criteria andIsCardModelIn(List<Boolean> values) {
            addCriterion("is_card_model in", values, "isCardModel");
            return (Criteria) this;
        }

        public Criteria andIsCardModelNotIn(List<Boolean> values) {
            addCriterion("is_card_model not in", values, "isCardModel");
            return (Criteria) this;
        }

        public Criteria andIsCardModelBetween(Boolean value1, Boolean value2) {
            addCriterion("is_card_model between", value1, value2, "isCardModel");
            return (Criteria) this;
        }

        public Criteria andIsCardModelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_card_model not between", value1, value2, "isCardModel");
            return (Criteria) this;
        }

        public Criteria andNoteCreateTimeIsNull() {
            addCriterion("note_create_time is null");
            return (Criteria) this;
        }

        public Criteria andNoteCreateTimeIsNotNull() {
            addCriterion("note_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andNoteCreateTimeEqualTo(Date value) {
            addCriterion("note_create_time =", value, "noteCreateTime");
            return (Criteria) this;
        }

        public Criteria andNoteCreateTimeNotEqualTo(Date value) {
            addCriterion("note_create_time <>", value, "noteCreateTime");
            return (Criteria) this;
        }

        public Criteria andNoteCreateTimeGreaterThan(Date value) {
            addCriterion("note_create_time >", value, "noteCreateTime");
            return (Criteria) this;
        }

        public Criteria andNoteCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("note_create_time >=", value, "noteCreateTime");
            return (Criteria) this;
        }

        public Criteria andNoteCreateTimeLessThan(Date value) {
            addCriterion("note_create_time <", value, "noteCreateTime");
            return (Criteria) this;
        }

        public Criteria andNoteCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("note_create_time <=", value, "noteCreateTime");
            return (Criteria) this;
        }

        public Criteria andNoteCreateTimeIn(List<Date> values) {
            addCriterion("note_create_time in", values, "noteCreateTime");
            return (Criteria) this;
        }

        public Criteria andNoteCreateTimeNotIn(List<Date> values) {
            addCriterion("note_create_time not in", values, "noteCreateTime");
            return (Criteria) this;
        }

        public Criteria andNoteCreateTimeBetween(Date value1, Date value2) {
            addCriterion("note_create_time between", value1, value2, "noteCreateTime");
            return (Criteria) this;
        }

        public Criteria andNoteCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("note_create_time not between", value1, value2, "noteCreateTime");
            return (Criteria) this;
        }

        public Criteria andNoteStartTimeIsNull() {
            addCriterion("note_start_time is null");
            return (Criteria) this;
        }

        public Criteria andNoteStartTimeIsNotNull() {
            addCriterion("note_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andNoteStartTimeEqualTo(Date value) {
            addCriterion("note_start_time =", value, "noteStartTime");
            return (Criteria) this;
        }

        public Criteria andNoteStartTimeNotEqualTo(Date value) {
            addCriterion("note_start_time <>", value, "noteStartTime");
            return (Criteria) this;
        }

        public Criteria andNoteStartTimeGreaterThan(Date value) {
            addCriterion("note_start_time >", value, "noteStartTime");
            return (Criteria) this;
        }

        public Criteria andNoteStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("note_start_time >=", value, "noteStartTime");
            return (Criteria) this;
        }

        public Criteria andNoteStartTimeLessThan(Date value) {
            addCriterion("note_start_time <", value, "noteStartTime");
            return (Criteria) this;
        }

        public Criteria andNoteStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("note_start_time <=", value, "noteStartTime");
            return (Criteria) this;
        }

        public Criteria andNoteStartTimeIn(List<Date> values) {
            addCriterion("note_start_time in", values, "noteStartTime");
            return (Criteria) this;
        }

        public Criteria andNoteStartTimeNotIn(List<Date> values) {
            addCriterion("note_start_time not in", values, "noteStartTime");
            return (Criteria) this;
        }

        public Criteria andNoteStartTimeBetween(Date value1, Date value2) {
            addCriterion("note_start_time between", value1, value2, "noteStartTime");
            return (Criteria) this;
        }

        public Criteria andNoteStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("note_start_time not between", value1, value2, "noteStartTime");
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