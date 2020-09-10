package com.intimate.pojo;

import java.util.ArrayList;
import java.util.List;

public class ReplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReplyExample() {
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

        public Criteria andReplyIdIsNull() {
            addCriterion("reply_id is null");
            return (Criteria) this;
        }

        public Criteria andReplyIdIsNotNull() {
            addCriterion("reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplyIdEqualTo(Long value) {
            addCriterion("reply_id =", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotEqualTo(Long value) {
            addCriterion("reply_id <>", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThan(Long value) {
            addCriterion("reply_id >", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reply_id >=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThan(Long value) {
            addCriterion("reply_id <", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdLessThanOrEqualTo(Long value) {
            addCriterion("reply_id <=", value, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdIn(List<Long> values) {
            addCriterion("reply_id in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotIn(List<Long> values) {
            addCriterion("reply_id not in", values, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdBetween(Long value1, Long value2) {
            addCriterion("reply_id between", value1, value2, "replyId");
            return (Criteria) this;
        }

        public Criteria andReplyIdNotBetween(Long value1, Long value2) {
            addCriterion("reply_id not between", value1, value2, "replyId");
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

        public Criteria andReplyTextIsNull() {
            addCriterion("reply_text is null");
            return (Criteria) this;
        }

        public Criteria andReplyTextIsNotNull() {
            addCriterion("reply_text is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTextEqualTo(String value) {
            addCriterion("reply_text =", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextNotEqualTo(String value) {
            addCriterion("reply_text <>", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextGreaterThan(String value) {
            addCriterion("reply_text >", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextGreaterThanOrEqualTo(String value) {
            addCriterion("reply_text >=", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextLessThan(String value) {
            addCriterion("reply_text <", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextLessThanOrEqualTo(String value) {
            addCriterion("reply_text <=", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextLike(String value) {
            addCriterion("reply_text like", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextNotLike(String value) {
            addCriterion("reply_text not like", value, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextIn(List<String> values) {
            addCriterion("reply_text in", values, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextNotIn(List<String> values) {
            addCriterion("reply_text not in", values, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextBetween(String value1, String value2) {
            addCriterion("reply_text between", value1, value2, "replyText");
            return (Criteria) this;
        }

        public Criteria andReplyTextNotBetween(String value1, String value2) {
            addCriterion("reply_text not between", value1, value2, "replyText");
            return (Criteria) this;
        }

        public Criteria andAnswerUrlIsNull() {
            addCriterion("answer_url is null");
            return (Criteria) this;
        }

        public Criteria andAnswerUrlIsNotNull() {
            addCriterion("answer_url is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerUrlEqualTo(String value) {
            addCriterion("answer_url =", value, "answerUrl");
            return (Criteria) this;
        }

        public Criteria andAnswerUrlNotEqualTo(String value) {
            addCriterion("answer_url <>", value, "answerUrl");
            return (Criteria) this;
        }

        public Criteria andAnswerUrlGreaterThan(String value) {
            addCriterion("answer_url >", value, "answerUrl");
            return (Criteria) this;
        }

        public Criteria andAnswerUrlGreaterThanOrEqualTo(String value) {
            addCriterion("answer_url >=", value, "answerUrl");
            return (Criteria) this;
        }

        public Criteria andAnswerUrlLessThan(String value) {
            addCriterion("answer_url <", value, "answerUrl");
            return (Criteria) this;
        }

        public Criteria andAnswerUrlLessThanOrEqualTo(String value) {
            addCriterion("answer_url <=", value, "answerUrl");
            return (Criteria) this;
        }

        public Criteria andAnswerUrlLike(String value) {
            addCriterion("answer_url like", value, "answerUrl");
            return (Criteria) this;
        }

        public Criteria andAnswerUrlNotLike(String value) {
            addCriterion("answer_url not like", value, "answerUrl");
            return (Criteria) this;
        }

        public Criteria andAnswerUrlIn(List<String> values) {
            addCriterion("answer_url in", values, "answerUrl");
            return (Criteria) this;
        }

        public Criteria andAnswerUrlNotIn(List<String> values) {
            addCriterion("answer_url not in", values, "answerUrl");
            return (Criteria) this;
        }

        public Criteria andAnswerUrlBetween(String value1, String value2) {
            addCriterion("answer_url between", value1, value2, "answerUrl");
            return (Criteria) this;
        }

        public Criteria andAnswerUrlNotBetween(String value1, String value2) {
            addCriterion("answer_url not between", value1, value2, "answerUrl");
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