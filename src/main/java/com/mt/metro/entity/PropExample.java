package com.mt.metro.entity;

import java.util.ArrayList;
import java.util.List;

public class PropExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PropExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPropDescribeIsNull() {
            addCriterion("prop_describe is null");
            return (Criteria) this;
        }

        public Criteria andPropDescribeIsNotNull() {
            addCriterion("prop_describe is not null");
            return (Criteria) this;
        }

        public Criteria andPropDescribeEqualTo(String value) {
            addCriterion("prop_describe =", value, "propDescribe");
            return (Criteria) this;
        }

        public Criteria andPropDescribeNotEqualTo(String value) {
            addCriterion("prop_describe <>", value, "propDescribe");
            return (Criteria) this;
        }

        public Criteria andPropDescribeGreaterThan(String value) {
            addCriterion("prop_describe >", value, "propDescribe");
            return (Criteria) this;
        }

        public Criteria andPropDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("prop_describe >=", value, "propDescribe");
            return (Criteria) this;
        }

        public Criteria andPropDescribeLessThan(String value) {
            addCriterion("prop_describe <", value, "propDescribe");
            return (Criteria) this;
        }

        public Criteria andPropDescribeLessThanOrEqualTo(String value) {
            addCriterion("prop_describe <=", value, "propDescribe");
            return (Criteria) this;
        }

        public Criteria andPropDescribeLike(String value) {
            addCriterion("prop_describe like", value, "propDescribe");
            return (Criteria) this;
        }

        public Criteria andPropDescribeNotLike(String value) {
            addCriterion("prop_describe not like", value, "propDescribe");
            return (Criteria) this;
        }

        public Criteria andPropDescribeIn(List<String> values) {
            addCriterion("prop_describe in", values, "propDescribe");
            return (Criteria) this;
        }

        public Criteria andPropDescribeNotIn(List<String> values) {
            addCriterion("prop_describe not in", values, "propDescribe");
            return (Criteria) this;
        }

        public Criteria andPropDescribeBetween(String value1, String value2) {
            addCriterion("prop_describe between", value1, value2, "propDescribe");
            return (Criteria) this;
        }

        public Criteria andPropDescribeNotBetween(String value1, String value2) {
            addCriterion("prop_describe not between", value1, value2, "propDescribe");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNull() {
            addCriterion("pic_url is null");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNotNull() {
            addCriterion("pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andPicUrlEqualTo(String value) {
            addCriterion("pic_url =", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotEqualTo(String value) {
            addCriterion("pic_url <>", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThan(String value) {
            addCriterion("pic_url >", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pic_url >=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThan(String value) {
            addCriterion("pic_url <", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThanOrEqualTo(String value) {
            addCriterion("pic_url <=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLike(String value) {
            addCriterion("pic_url like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotLike(String value) {
            addCriterion("pic_url not like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlIn(List<String> values) {
            addCriterion("pic_url in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotIn(List<String> values) {
            addCriterion("pic_url not in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlBetween(String value1, String value2) {
            addCriterion("pic_url between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotBetween(String value1, String value2) {
            addCriterion("pic_url not between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andEffectUrlIsNull() {
            addCriterion("effect_url is null");
            return (Criteria) this;
        }

        public Criteria andEffectUrlIsNotNull() {
            addCriterion("effect_url is not null");
            return (Criteria) this;
        }

        public Criteria andEffectUrlEqualTo(String value) {
            addCriterion("effect_url =", value, "effectUrl");
            return (Criteria) this;
        }

        public Criteria andEffectUrlNotEqualTo(String value) {
            addCriterion("effect_url <>", value, "effectUrl");
            return (Criteria) this;
        }

        public Criteria andEffectUrlGreaterThan(String value) {
            addCriterion("effect_url >", value, "effectUrl");
            return (Criteria) this;
        }

        public Criteria andEffectUrlGreaterThanOrEqualTo(String value) {
            addCriterion("effect_url >=", value, "effectUrl");
            return (Criteria) this;
        }

        public Criteria andEffectUrlLessThan(String value) {
            addCriterion("effect_url <", value, "effectUrl");
            return (Criteria) this;
        }

        public Criteria andEffectUrlLessThanOrEqualTo(String value) {
            addCriterion("effect_url <=", value, "effectUrl");
            return (Criteria) this;
        }

        public Criteria andEffectUrlLike(String value) {
            addCriterion("effect_url like", value, "effectUrl");
            return (Criteria) this;
        }

        public Criteria andEffectUrlNotLike(String value) {
            addCriterion("effect_url not like", value, "effectUrl");
            return (Criteria) this;
        }

        public Criteria andEffectUrlIn(List<String> values) {
            addCriterion("effect_url in", values, "effectUrl");
            return (Criteria) this;
        }

        public Criteria andEffectUrlNotIn(List<String> values) {
            addCriterion("effect_url not in", values, "effectUrl");
            return (Criteria) this;
        }

        public Criteria andEffectUrlBetween(String value1, String value2) {
            addCriterion("effect_url between", value1, value2, "effectUrl");
            return (Criteria) this;
        }

        public Criteria andEffectUrlNotBetween(String value1, String value2) {
            addCriterion("effect_url not between", value1, value2, "effectUrl");
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