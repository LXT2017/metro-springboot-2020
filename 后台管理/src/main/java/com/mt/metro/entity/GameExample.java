package com.mt.metro.entity;

import java.util.ArrayList;
import java.util.List;

public class GameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GameExample() {
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

        public Criteria andEntertainmentIsNull() {
            addCriterion("entertainment is null");
            return (Criteria) this;
        }

        public Criteria andEntertainmentIsNotNull() {
            addCriterion("entertainment is not null");
            return (Criteria) this;
        }

        public Criteria andEntertainmentEqualTo(Integer value) {
            addCriterion("entertainment =", value, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentNotEqualTo(Integer value) {
            addCriterion("entertainment <>", value, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentGreaterThan(Integer value) {
            addCriterion("entertainment >", value, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("entertainment >=", value, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentLessThan(Integer value) {
            addCriterion("entertainment <", value, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentLessThanOrEqualTo(Integer value) {
            addCriterion("entertainment <=", value, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentIn(List<Integer> values) {
            addCriterion("entertainment in", values, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentNotIn(List<Integer> values) {
            addCriterion("entertainment not in", values, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentBetween(Integer value1, Integer value2) {
            addCriterion("entertainment between", value1, value2, "entertainment");
            return (Criteria) this;
        }

        public Criteria andEntertainmentNotBetween(Integer value1, Integer value2) {
            addCriterion("entertainment not between", value1, value2, "entertainment");
            return (Criteria) this;
        }

        public Criteria andBodybuildingIsNull() {
            addCriterion("bodybuilding is null");
            return (Criteria) this;
        }

        public Criteria andBodybuildingIsNotNull() {
            addCriterion("bodybuilding is not null");
            return (Criteria) this;
        }

        public Criteria andBodybuildingEqualTo(Integer value) {
            addCriterion("bodybuilding =", value, "bodybuilding");
            return (Criteria) this;
        }

        public Criteria andBodybuildingNotEqualTo(Integer value) {
            addCriterion("bodybuilding <>", value, "bodybuilding");
            return (Criteria) this;
        }

        public Criteria andBodybuildingGreaterThan(Integer value) {
            addCriterion("bodybuilding >", value, "bodybuilding");
            return (Criteria) this;
        }

        public Criteria andBodybuildingGreaterThanOrEqualTo(Integer value) {
            addCriterion("bodybuilding >=", value, "bodybuilding");
            return (Criteria) this;
        }

        public Criteria andBodybuildingLessThan(Integer value) {
            addCriterion("bodybuilding <", value, "bodybuilding");
            return (Criteria) this;
        }

        public Criteria andBodybuildingLessThanOrEqualTo(Integer value) {
            addCriterion("bodybuilding <=", value, "bodybuilding");
            return (Criteria) this;
        }

        public Criteria andBodybuildingIn(List<Integer> values) {
            addCriterion("bodybuilding in", values, "bodybuilding");
            return (Criteria) this;
        }

        public Criteria andBodybuildingNotIn(List<Integer> values) {
            addCriterion("bodybuilding not in", values, "bodybuilding");
            return (Criteria) this;
        }

        public Criteria andBodybuildingBetween(Integer value1, Integer value2) {
            addCriterion("bodybuilding between", value1, value2, "bodybuilding");
            return (Criteria) this;
        }

        public Criteria andBodybuildingNotBetween(Integer value1, Integer value2) {
            addCriterion("bodybuilding not between", value1, value2, "bodybuilding");
            return (Criteria) this;
        }

        public Criteria andSpeedcontestIsNull() {
            addCriterion("speedContest is null");
            return (Criteria) this;
        }

        public Criteria andSpeedcontestIsNotNull() {
            addCriterion("speedContest is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedcontestEqualTo(Integer value) {
            addCriterion("speedContest =", value, "speedcontest");
            return (Criteria) this;
        }

        public Criteria andSpeedcontestNotEqualTo(Integer value) {
            addCriterion("speedContest <>", value, "speedcontest");
            return (Criteria) this;
        }

        public Criteria andSpeedcontestGreaterThan(Integer value) {
            addCriterion("speedContest >", value, "speedcontest");
            return (Criteria) this;
        }

        public Criteria andSpeedcontestGreaterThanOrEqualTo(Integer value) {
            addCriterion("speedContest >=", value, "speedcontest");
            return (Criteria) this;
        }

        public Criteria andSpeedcontestLessThan(Integer value) {
            addCriterion("speedContest <", value, "speedcontest");
            return (Criteria) this;
        }

        public Criteria andSpeedcontestLessThanOrEqualTo(Integer value) {
            addCriterion("speedContest <=", value, "speedcontest");
            return (Criteria) this;
        }

        public Criteria andSpeedcontestIn(List<Integer> values) {
            addCriterion("speedContest in", values, "speedcontest");
            return (Criteria) this;
        }

        public Criteria andSpeedcontestNotIn(List<Integer> values) {
            addCriterion("speedContest not in", values, "speedcontest");
            return (Criteria) this;
        }

        public Criteria andSpeedcontestBetween(Integer value1, Integer value2) {
            addCriterion("speedContest between", value1, value2, "speedcontest");
            return (Criteria) this;
        }

        public Criteria andSpeedcontestNotBetween(Integer value1, Integer value2) {
            addCriterion("speedContest not between", value1, value2, "speedcontest");
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