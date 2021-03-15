package com.mt.metroadmin.entity;

import java.util.ArrayList;
import java.util.List;

public class CoinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CoinExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCoinNumberIsNull() {
            addCriterion("coin_number is null");
            return (Criteria) this;
        }

        public Criteria andCoinNumberIsNotNull() {
            addCriterion("coin_number is not null");
            return (Criteria) this;
        }

        public Criteria andCoinNumberEqualTo(Integer value) {
            addCriterion("coin_number =", value, "coinNumber");
            return (Criteria) this;
        }

        public Criteria andCoinNumberNotEqualTo(Integer value) {
            addCriterion("coin_number <>", value, "coinNumber");
            return (Criteria) this;
        }

        public Criteria andCoinNumberGreaterThan(Integer value) {
            addCriterion("coin_number >", value, "coinNumber");
            return (Criteria) this;
        }

        public Criteria andCoinNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("coin_number >=", value, "coinNumber");
            return (Criteria) this;
        }

        public Criteria andCoinNumberLessThan(Integer value) {
            addCriterion("coin_number <", value, "coinNumber");
            return (Criteria) this;
        }

        public Criteria andCoinNumberLessThanOrEqualTo(Integer value) {
            addCriterion("coin_number <=", value, "coinNumber");
            return (Criteria) this;
        }

        public Criteria andCoinNumberIn(List<Integer> values) {
            addCriterion("coin_number in", values, "coinNumber");
            return (Criteria) this;
        }

        public Criteria andCoinNumberNotIn(List<Integer> values) {
            addCriterion("coin_number not in", values, "coinNumber");
            return (Criteria) this;
        }

        public Criteria andCoinNumberBetween(Integer value1, Integer value2) {
            addCriterion("coin_number between", value1, value2, "coinNumber");
            return (Criteria) this;
        }

        public Criteria andCoinNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("coin_number not between", value1, value2, "coinNumber");
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

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andWeekNumberIsNull() {
            addCriterion("week_number is null");
            return (Criteria) this;
        }

        public Criteria andWeekNumberIsNotNull() {
            addCriterion("week_number is not null");
            return (Criteria) this;
        }

        public Criteria andWeekNumberEqualTo(Integer value) {
            addCriterion("week_number =", value, "weekNumber");
            return (Criteria) this;
        }

        public Criteria andWeekNumberNotEqualTo(Integer value) {
            addCriterion("week_number <>", value, "weekNumber");
            return (Criteria) this;
        }

        public Criteria andWeekNumberGreaterThan(Integer value) {
            addCriterion("week_number >", value, "weekNumber");
            return (Criteria) this;
        }

        public Criteria andWeekNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("week_number >=", value, "weekNumber");
            return (Criteria) this;
        }

        public Criteria andWeekNumberLessThan(Integer value) {
            addCriterion("week_number <", value, "weekNumber");
            return (Criteria) this;
        }

        public Criteria andWeekNumberLessThanOrEqualTo(Integer value) {
            addCriterion("week_number <=", value, "weekNumber");
            return (Criteria) this;
        }

        public Criteria andWeekNumberIn(List<Integer> values) {
            addCriterion("week_number in", values, "weekNumber");
            return (Criteria) this;
        }

        public Criteria andWeekNumberNotIn(List<Integer> values) {
            addCriterion("week_number not in", values, "weekNumber");
            return (Criteria) this;
        }

        public Criteria andWeekNumberBetween(Integer value1, Integer value2) {
            addCriterion("week_number between", value1, value2, "weekNumber");
            return (Criteria) this;
        }

        public Criteria andWeekNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("week_number not between", value1, value2, "weekNumber");
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