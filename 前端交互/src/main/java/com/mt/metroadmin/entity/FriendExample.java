package com.mt.metroadmin.entity;

import java.util.ArrayList;
import java.util.List;

public class FriendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FriendExample() {
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

        public Criteria andFriend1IsNull() {
            addCriterion("friend1 is null");
            return (Criteria) this;
        }

        public Criteria andFriend1IsNotNull() {
            addCriterion("friend1 is not null");
            return (Criteria) this;
        }

        public Criteria andFriend1EqualTo(Integer value) {
            addCriterion("friend1 =", value, "friend1");
            return (Criteria) this;
        }

        public Criteria andFriend1NotEqualTo(Integer value) {
            addCriterion("friend1 <>", value, "friend1");
            return (Criteria) this;
        }

        public Criteria andFriend1GreaterThan(Integer value) {
            addCriterion("friend1 >", value, "friend1");
            return (Criteria) this;
        }

        public Criteria andFriend1GreaterThanOrEqualTo(Integer value) {
            addCriterion("friend1 >=", value, "friend1");
            return (Criteria) this;
        }

        public Criteria andFriend1LessThan(Integer value) {
            addCriterion("friend1 <", value, "friend1");
            return (Criteria) this;
        }

        public Criteria andFriend1LessThanOrEqualTo(Integer value) {
            addCriterion("friend1 <=", value, "friend1");
            return (Criteria) this;
        }

        public Criteria andFriend1In(List<Integer> values) {
            addCriterion("friend1 in", values, "friend1");
            return (Criteria) this;
        }

        public Criteria andFriend1NotIn(List<Integer> values) {
            addCriterion("friend1 not in", values, "friend1");
            return (Criteria) this;
        }

        public Criteria andFriend1Between(Integer value1, Integer value2) {
            addCriterion("friend1 between", value1, value2, "friend1");
            return (Criteria) this;
        }

        public Criteria andFriend1NotBetween(Integer value1, Integer value2) {
            addCriterion("friend1 not between", value1, value2, "friend1");
            return (Criteria) this;
        }

        public Criteria andFriend2IsNull() {
            addCriterion("friend2 is null");
            return (Criteria) this;
        }

        public Criteria andFriend2IsNotNull() {
            addCriterion("friend2 is not null");
            return (Criteria) this;
        }

        public Criteria andFriend2EqualTo(Integer value) {
            addCriterion("friend2 =", value, "friend2");
            return (Criteria) this;
        }

        public Criteria andFriend2NotEqualTo(Integer value) {
            addCriterion("friend2 <>", value, "friend2");
            return (Criteria) this;
        }

        public Criteria andFriend2GreaterThan(Integer value) {
            addCriterion("friend2 >", value, "friend2");
            return (Criteria) this;
        }

        public Criteria andFriend2GreaterThanOrEqualTo(Integer value) {
            addCriterion("friend2 >=", value, "friend2");
            return (Criteria) this;
        }

        public Criteria andFriend2LessThan(Integer value) {
            addCriterion("friend2 <", value, "friend2");
            return (Criteria) this;
        }

        public Criteria andFriend2LessThanOrEqualTo(Integer value) {
            addCriterion("friend2 <=", value, "friend2");
            return (Criteria) this;
        }

        public Criteria andFriend2In(List<Integer> values) {
            addCriterion("friend2 in", values, "friend2");
            return (Criteria) this;
        }

        public Criteria andFriend2NotIn(List<Integer> values) {
            addCriterion("friend2 not in", values, "friend2");
            return (Criteria) this;
        }

        public Criteria andFriend2Between(Integer value1, Integer value2) {
            addCriterion("friend2 between", value1, value2, "friend2");
            return (Criteria) this;
        }

        public Criteria andFriend2NotBetween(Integer value1, Integer value2) {
            addCriterion("friend2 not between", value1, value2, "friend2");
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