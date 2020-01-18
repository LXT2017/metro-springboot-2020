package com.mt.metro.entity;

import java.util.ArrayList;
import java.util.List;

public class CarbonRankingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarbonRankingExample() {
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

        public Criteria andDailyScoreIsNull() {
            addCriterion("daily_score is null");
            return (Criteria) this;
        }

        public Criteria andDailyScoreIsNotNull() {
            addCriterion("daily_score is not null");
            return (Criteria) this;
        }

        public Criteria andDailyScoreEqualTo(Integer value) {
            addCriterion("daily_score =", value, "dailyScore");
            return (Criteria) this;
        }

        public Criteria andDailyScoreNotEqualTo(Integer value) {
            addCriterion("daily_score <>", value, "dailyScore");
            return (Criteria) this;
        }

        public Criteria andDailyScoreGreaterThan(Integer value) {
            addCriterion("daily_score >", value, "dailyScore");
            return (Criteria) this;
        }

        public Criteria andDailyScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("daily_score >=", value, "dailyScore");
            return (Criteria) this;
        }

        public Criteria andDailyScoreLessThan(Integer value) {
            addCriterion("daily_score <", value, "dailyScore");
            return (Criteria) this;
        }

        public Criteria andDailyScoreLessThanOrEqualTo(Integer value) {
            addCriterion("daily_score <=", value, "dailyScore");
            return (Criteria) this;
        }

        public Criteria andDailyScoreIn(List<Integer> values) {
            addCriterion("daily_score in", values, "dailyScore");
            return (Criteria) this;
        }

        public Criteria andDailyScoreNotIn(List<Integer> values) {
            addCriterion("daily_score not in", values, "dailyScore");
            return (Criteria) this;
        }

        public Criteria andDailyScoreBetween(Integer value1, Integer value2) {
            addCriterion("daily_score between", value1, value2, "dailyScore");
            return (Criteria) this;
        }

        public Criteria andDailyScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("daily_score not between", value1, value2, "dailyScore");
            return (Criteria) this;
        }

        public Criteria andWeekScoreIsNull() {
            addCriterion("week_score is null");
            return (Criteria) this;
        }

        public Criteria andWeekScoreIsNotNull() {
            addCriterion("week_score is not null");
            return (Criteria) this;
        }

        public Criteria andWeekScoreEqualTo(Integer value) {
            addCriterion("week_score =", value, "weekScore");
            return (Criteria) this;
        }

        public Criteria andWeekScoreNotEqualTo(Integer value) {
            addCriterion("week_score <>", value, "weekScore");
            return (Criteria) this;
        }

        public Criteria andWeekScoreGreaterThan(Integer value) {
            addCriterion("week_score >", value, "weekScore");
            return (Criteria) this;
        }

        public Criteria andWeekScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("week_score >=", value, "weekScore");
            return (Criteria) this;
        }

        public Criteria andWeekScoreLessThan(Integer value) {
            addCriterion("week_score <", value, "weekScore");
            return (Criteria) this;
        }

        public Criteria andWeekScoreLessThanOrEqualTo(Integer value) {
            addCriterion("week_score <=", value, "weekScore");
            return (Criteria) this;
        }

        public Criteria andWeekScoreIn(List<Integer> values) {
            addCriterion("week_score in", values, "weekScore");
            return (Criteria) this;
        }

        public Criteria andWeekScoreNotIn(List<Integer> values) {
            addCriterion("week_score not in", values, "weekScore");
            return (Criteria) this;
        }

        public Criteria andWeekScoreBetween(Integer value1, Integer value2) {
            addCriterion("week_score between", value1, value2, "weekScore");
            return (Criteria) this;
        }

        public Criteria andWeekScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("week_score not between", value1, value2, "weekScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNull() {
            addCriterion("total_score is null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNotNull() {
            addCriterion("total_score is not null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreEqualTo(Integer value) {
            addCriterion("total_score =", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotEqualTo(Integer value) {
            addCriterion("total_score <>", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThan(Integer value) {
            addCriterion("total_score >", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_score >=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThan(Integer value) {
            addCriterion("total_score <", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThanOrEqualTo(Integer value) {
            addCriterion("total_score <=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIn(List<Integer> values) {
            addCriterion("total_score in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotIn(List<Integer> values) {
            addCriterion("total_score not in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreBetween(Integer value1, Integer value2) {
            addCriterion("total_score between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("total_score not between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andDailyRankingIsNull() {
            addCriterion("daily_ranking is null");
            return (Criteria) this;
        }

        public Criteria andDailyRankingIsNotNull() {
            addCriterion("daily_ranking is not null");
            return (Criteria) this;
        }

        public Criteria andDailyRankingEqualTo(Integer value) {
            addCriterion("daily_ranking =", value, "dailyRanking");
            return (Criteria) this;
        }

        public Criteria andDailyRankingNotEqualTo(Integer value) {
            addCriterion("daily_ranking <>", value, "dailyRanking");
            return (Criteria) this;
        }

        public Criteria andDailyRankingGreaterThan(Integer value) {
            addCriterion("daily_ranking >", value, "dailyRanking");
            return (Criteria) this;
        }

        public Criteria andDailyRankingGreaterThanOrEqualTo(Integer value) {
            addCriterion("daily_ranking >=", value, "dailyRanking");
            return (Criteria) this;
        }

        public Criteria andDailyRankingLessThan(Integer value) {
            addCriterion("daily_ranking <", value, "dailyRanking");
            return (Criteria) this;
        }

        public Criteria andDailyRankingLessThanOrEqualTo(Integer value) {
            addCriterion("daily_ranking <=", value, "dailyRanking");
            return (Criteria) this;
        }

        public Criteria andDailyRankingIn(List<Integer> values) {
            addCriterion("daily_ranking in", values, "dailyRanking");
            return (Criteria) this;
        }

        public Criteria andDailyRankingNotIn(List<Integer> values) {
            addCriterion("daily_ranking not in", values, "dailyRanking");
            return (Criteria) this;
        }

        public Criteria andDailyRankingBetween(Integer value1, Integer value2) {
            addCriterion("daily_ranking between", value1, value2, "dailyRanking");
            return (Criteria) this;
        }

        public Criteria andDailyRankingNotBetween(Integer value1, Integer value2) {
            addCriterion("daily_ranking not between", value1, value2, "dailyRanking");
            return (Criteria) this;
        }

        public Criteria andWeekRankingIsNull() {
            addCriterion("week_ranking is null");
            return (Criteria) this;
        }

        public Criteria andWeekRankingIsNotNull() {
            addCriterion("week_ranking is not null");
            return (Criteria) this;
        }

        public Criteria andWeekRankingEqualTo(Integer value) {
            addCriterion("week_ranking =", value, "weekRanking");
            return (Criteria) this;
        }

        public Criteria andWeekRankingNotEqualTo(Integer value) {
            addCriterion("week_ranking <>", value, "weekRanking");
            return (Criteria) this;
        }

        public Criteria andWeekRankingGreaterThan(Integer value) {
            addCriterion("week_ranking >", value, "weekRanking");
            return (Criteria) this;
        }

        public Criteria andWeekRankingGreaterThanOrEqualTo(Integer value) {
            addCriterion("week_ranking >=", value, "weekRanking");
            return (Criteria) this;
        }

        public Criteria andWeekRankingLessThan(Integer value) {
            addCriterion("week_ranking <", value, "weekRanking");
            return (Criteria) this;
        }

        public Criteria andWeekRankingLessThanOrEqualTo(Integer value) {
            addCriterion("week_ranking <=", value, "weekRanking");
            return (Criteria) this;
        }

        public Criteria andWeekRankingIn(List<Integer> values) {
            addCriterion("week_ranking in", values, "weekRanking");
            return (Criteria) this;
        }

        public Criteria andWeekRankingNotIn(List<Integer> values) {
            addCriterion("week_ranking not in", values, "weekRanking");
            return (Criteria) this;
        }

        public Criteria andWeekRankingBetween(Integer value1, Integer value2) {
            addCriterion("week_ranking between", value1, value2, "weekRanking");
            return (Criteria) this;
        }

        public Criteria andWeekRankingNotBetween(Integer value1, Integer value2) {
            addCriterion("week_ranking not between", value1, value2, "weekRanking");
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

        public Criteria andCurrentStrengthIsNull() {
            addCriterion("current_strength is null");
            return (Criteria) this;
        }

        public Criteria andCurrentStrengthIsNotNull() {
            addCriterion("current_strength is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentStrengthEqualTo(Integer value) {
            addCriterion("current_strength =", value, "currentStrength");
            return (Criteria) this;
        }

        public Criteria andCurrentStrengthNotEqualTo(Integer value) {
            addCriterion("current_strength <>", value, "currentStrength");
            return (Criteria) this;
        }

        public Criteria andCurrentStrengthGreaterThan(Integer value) {
            addCriterion("current_strength >", value, "currentStrength");
            return (Criteria) this;
        }

        public Criteria andCurrentStrengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_strength >=", value, "currentStrength");
            return (Criteria) this;
        }

        public Criteria andCurrentStrengthLessThan(Integer value) {
            addCriterion("current_strength <", value, "currentStrength");
            return (Criteria) this;
        }

        public Criteria andCurrentStrengthLessThanOrEqualTo(Integer value) {
            addCriterion("current_strength <=", value, "currentStrength");
            return (Criteria) this;
        }

        public Criteria andCurrentStrengthIn(List<Integer> values) {
            addCriterion("current_strength in", values, "currentStrength");
            return (Criteria) this;
        }

        public Criteria andCurrentStrengthNotIn(List<Integer> values) {
            addCriterion("current_strength not in", values, "currentStrength");
            return (Criteria) this;
        }

        public Criteria andCurrentStrengthBetween(Integer value1, Integer value2) {
            addCriterion("current_strength between", value1, value2, "currentStrength");
            return (Criteria) this;
        }

        public Criteria andCurrentStrengthNotBetween(Integer value1, Integer value2) {
            addCriterion("current_strength not between", value1, value2, "currentStrength");
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