package com.intimate.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoticeExample() {
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

        public Criteria andNoticeTitleIsNull() {
            addCriterion("notice_title is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIsNotNull() {
            addCriterion("notice_title is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleEqualTo(String value) {
            addCriterion("notice_title =", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotEqualTo(String value) {
            addCriterion("notice_title <>", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleGreaterThan(String value) {
            addCriterion("notice_title >", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("notice_title >=", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLessThan(String value) {
            addCriterion("notice_title <", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLessThanOrEqualTo(String value) {
            addCriterion("notice_title <=", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleLike(String value) {
            addCriterion("notice_title like", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotLike(String value) {
            addCriterion("notice_title not like", value, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleIn(List<String> values) {
            addCriterion("notice_title in", values, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotIn(List<String> values) {
            addCriterion("notice_title not in", values, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleBetween(String value1, String value2) {
            addCriterion("notice_title between", value1, value2, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTitleNotBetween(String value1, String value2) {
            addCriterion("notice_title not between", value1, value2, "noticeTitle");
            return (Criteria) this;
        }

        public Criteria andNoticeTextIsNull() {
            addCriterion("notice_text is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTextIsNotNull() {
            addCriterion("notice_text is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTextEqualTo(String value) {
            addCriterion("notice_text =", value, "noticeText");
            return (Criteria) this;
        }

        public Criteria andNoticeTextNotEqualTo(String value) {
            addCriterion("notice_text <>", value, "noticeText");
            return (Criteria) this;
        }

        public Criteria andNoticeTextGreaterThan(String value) {
            addCriterion("notice_text >", value, "noticeText");
            return (Criteria) this;
        }

        public Criteria andNoticeTextGreaterThanOrEqualTo(String value) {
            addCriterion("notice_text >=", value, "noticeText");
            return (Criteria) this;
        }

        public Criteria andNoticeTextLessThan(String value) {
            addCriterion("notice_text <", value, "noticeText");
            return (Criteria) this;
        }

        public Criteria andNoticeTextLessThanOrEqualTo(String value) {
            addCriterion("notice_text <=", value, "noticeText");
            return (Criteria) this;
        }

        public Criteria andNoticeTextLike(String value) {
            addCriterion("notice_text like", value, "noticeText");
            return (Criteria) this;
        }

        public Criteria andNoticeTextNotLike(String value) {
            addCriterion("notice_text not like", value, "noticeText");
            return (Criteria) this;
        }

        public Criteria andNoticeTextIn(List<String> values) {
            addCriterion("notice_text in", values, "noticeText");
            return (Criteria) this;
        }

        public Criteria andNoticeTextNotIn(List<String> values) {
            addCriterion("notice_text not in", values, "noticeText");
            return (Criteria) this;
        }

        public Criteria andNoticeTextBetween(String value1, String value2) {
            addCriterion("notice_text between", value1, value2, "noticeText");
            return (Criteria) this;
        }

        public Criteria andNoticeTextNotBetween(String value1, String value2) {
            addCriterion("notice_text not between", value1, value2, "noticeText");
            return (Criteria) this;
        }

        public Criteria andNoticeLinkIsNull() {
            addCriterion("notice_link is null");
            return (Criteria) this;
        }

        public Criteria andNoticeLinkIsNotNull() {
            addCriterion("notice_link is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeLinkEqualTo(String value) {
            addCriterion("notice_link =", value, "noticeLink");
            return (Criteria) this;
        }

        public Criteria andNoticeLinkNotEqualTo(String value) {
            addCriterion("notice_link <>", value, "noticeLink");
            return (Criteria) this;
        }

        public Criteria andNoticeLinkGreaterThan(String value) {
            addCriterion("notice_link >", value, "noticeLink");
            return (Criteria) this;
        }

        public Criteria andNoticeLinkGreaterThanOrEqualTo(String value) {
            addCriterion("notice_link >=", value, "noticeLink");
            return (Criteria) this;
        }

        public Criteria andNoticeLinkLessThan(String value) {
            addCriterion("notice_link <", value, "noticeLink");
            return (Criteria) this;
        }

        public Criteria andNoticeLinkLessThanOrEqualTo(String value) {
            addCriterion("notice_link <=", value, "noticeLink");
            return (Criteria) this;
        }

        public Criteria andNoticeLinkLike(String value) {
            addCriterion("notice_link like", value, "noticeLink");
            return (Criteria) this;
        }

        public Criteria andNoticeLinkNotLike(String value) {
            addCriterion("notice_link not like", value, "noticeLink");
            return (Criteria) this;
        }

        public Criteria andNoticeLinkIn(List<String> values) {
            addCriterion("notice_link in", values, "noticeLink");
            return (Criteria) this;
        }

        public Criteria andNoticeLinkNotIn(List<String> values) {
            addCriterion("notice_link not in", values, "noticeLink");
            return (Criteria) this;
        }

        public Criteria andNoticeLinkBetween(String value1, String value2) {
            addCriterion("notice_link between", value1, value2, "noticeLink");
            return (Criteria) this;
        }

        public Criteria andNoticeLinkNotBetween(String value1, String value2) {
            addCriterion("notice_link not between", value1, value2, "noticeLink");
            return (Criteria) this;
        }

        public Criteria andNoticeStateIsNull() {
            addCriterion("notice_state is null");
            return (Criteria) this;
        }

        public Criteria andNoticeStateIsNotNull() {
            addCriterion("notice_state is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeStateEqualTo(Byte value) {
            addCriterion("notice_state =", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateNotEqualTo(Byte value) {
            addCriterion("notice_state <>", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateGreaterThan(Byte value) {
            addCriterion("notice_state >", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("notice_state >=", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateLessThan(Byte value) {
            addCriterion("notice_state <", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateLessThanOrEqualTo(Byte value) {
            addCriterion("notice_state <=", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateIn(List<Byte> values) {
            addCriterion("notice_state in", values, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateNotIn(List<Byte> values) {
            addCriterion("notice_state not in", values, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateBetween(Byte value1, Byte value2) {
            addCriterion("notice_state between", value1, value2, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateNotBetween(Byte value1, Byte value2) {
            addCriterion("notice_state not between", value1, value2, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeCreateDateIsNull() {
            addCriterion("notice_create_date is null");
            return (Criteria) this;
        }

        public Criteria andNoticeCreateDateIsNotNull() {
            addCriterion("notice_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeCreateDateEqualTo(Date value) {
            addCriterion("notice_create_date =", value, "noticeCreateDate");
            return (Criteria) this;
        }

        public Criteria andNoticeCreateDateNotEqualTo(Date value) {
            addCriterion("notice_create_date <>", value, "noticeCreateDate");
            return (Criteria) this;
        }

        public Criteria andNoticeCreateDateGreaterThan(Date value) {
            addCriterion("notice_create_date >", value, "noticeCreateDate");
            return (Criteria) this;
        }

        public Criteria andNoticeCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("notice_create_date >=", value, "noticeCreateDate");
            return (Criteria) this;
        }

        public Criteria andNoticeCreateDateLessThan(Date value) {
            addCriterion("notice_create_date <", value, "noticeCreateDate");
            return (Criteria) this;
        }

        public Criteria andNoticeCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("notice_create_date <=", value, "noticeCreateDate");
            return (Criteria) this;
        }

        public Criteria andNoticeCreateDateIn(List<Date> values) {
            addCriterion("notice_create_date in", values, "noticeCreateDate");
            return (Criteria) this;
        }

        public Criteria andNoticeCreateDateNotIn(List<Date> values) {
            addCriterion("notice_create_date not in", values, "noticeCreateDate");
            return (Criteria) this;
        }

        public Criteria andNoticeCreateDateBetween(Date value1, Date value2) {
            addCriterion("notice_create_date between", value1, value2, "noticeCreateDate");
            return (Criteria) this;
        }

        public Criteria andNoticeCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("notice_create_date not between", value1, value2, "noticeCreateDate");
            return (Criteria) this;
        }

        public Criteria andNoticeEndDateIsNull() {
            addCriterion("notice_end_date is null");
            return (Criteria) this;
        }

        public Criteria andNoticeEndDateIsNotNull() {
            addCriterion("notice_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeEndDateEqualTo(Date value) {
            addCriterion("notice_end_date =", value, "noticeEndDate");
            return (Criteria) this;
        }

        public Criteria andNoticeEndDateNotEqualTo(Date value) {
            addCriterion("notice_end_date <>", value, "noticeEndDate");
            return (Criteria) this;
        }

        public Criteria andNoticeEndDateGreaterThan(Date value) {
            addCriterion("notice_end_date >", value, "noticeEndDate");
            return (Criteria) this;
        }

        public Criteria andNoticeEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("notice_end_date >=", value, "noticeEndDate");
            return (Criteria) this;
        }

        public Criteria andNoticeEndDateLessThan(Date value) {
            addCriterion("notice_end_date <", value, "noticeEndDate");
            return (Criteria) this;
        }

        public Criteria andNoticeEndDateLessThanOrEqualTo(Date value) {
            addCriterion("notice_end_date <=", value, "noticeEndDate");
            return (Criteria) this;
        }

        public Criteria andNoticeEndDateIn(List<Date> values) {
            addCriterion("notice_end_date in", values, "noticeEndDate");
            return (Criteria) this;
        }

        public Criteria andNoticeEndDateNotIn(List<Date> values) {
            addCriterion("notice_end_date not in", values, "noticeEndDate");
            return (Criteria) this;
        }

        public Criteria andNoticeEndDateBetween(Date value1, Date value2) {
            addCriterion("notice_end_date between", value1, value2, "noticeEndDate");
            return (Criteria) this;
        }

        public Criteria andNoticeEndDateNotBetween(Date value1, Date value2) {
            addCriterion("notice_end_date not between", value1, value2, "noticeEndDate");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Long value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Long value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Long value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Long value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Long> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Long> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Long value1, Long value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
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