package com.mt.metro.entity;

import java.util.ArrayList;
import java.util.List;

public class ParameterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParameterExample() {
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

        public Criteria andPuzzleMusicIsNull() {
            addCriterion("puzzle_music is null");
            return (Criteria) this;
        }

        public Criteria andPuzzleMusicIsNotNull() {
            addCriterion("puzzle_music is not null");
            return (Criteria) this;
        }

        public Criteria andPuzzleMusicEqualTo(String value) {
            addCriterion("puzzle_music =", value, "puzzleMusic");
            return (Criteria) this;
        }

        public Criteria andPuzzleMusicNotEqualTo(String value) {
            addCriterion("puzzle_music <>", value, "puzzleMusic");
            return (Criteria) this;
        }

        public Criteria andPuzzleMusicGreaterThan(String value) {
            addCriterion("puzzle_music >", value, "puzzleMusic");
            return (Criteria) this;
        }

        public Criteria andPuzzleMusicGreaterThanOrEqualTo(String value) {
            addCriterion("puzzle_music >=", value, "puzzleMusic");
            return (Criteria) this;
        }

        public Criteria andPuzzleMusicLessThan(String value) {
            addCriterion("puzzle_music <", value, "puzzleMusic");
            return (Criteria) this;
        }

        public Criteria andPuzzleMusicLessThanOrEqualTo(String value) {
            addCriterion("puzzle_music <=", value, "puzzleMusic");
            return (Criteria) this;
        }

        public Criteria andPuzzleMusicLike(String value) {
            addCriterion("puzzle_music like", value, "puzzleMusic");
            return (Criteria) this;
        }

        public Criteria andPuzzleMusicNotLike(String value) {
            addCriterion("puzzle_music not like", value, "puzzleMusic");
            return (Criteria) this;
        }

        public Criteria andPuzzleMusicIn(List<String> values) {
            addCriterion("puzzle_music in", values, "puzzleMusic");
            return (Criteria) this;
        }

        public Criteria andPuzzleMusicNotIn(List<String> values) {
            addCriterion("puzzle_music not in", values, "puzzleMusic");
            return (Criteria) this;
        }

        public Criteria andPuzzleMusicBetween(String value1, String value2) {
            addCriterion("puzzle_music between", value1, value2, "puzzleMusic");
            return (Criteria) this;
        }

        public Criteria andPuzzleMusicNotBetween(String value1, String value2) {
            addCriterion("puzzle_music not between", value1, value2, "puzzleMusic");
            return (Criteria) this;
        }

        public Criteria andGameMusicIsNull() {
            addCriterion("game_music is null");
            return (Criteria) this;
        }

        public Criteria andGameMusicIsNotNull() {
            addCriterion("game_music is not null");
            return (Criteria) this;
        }

        public Criteria andGameMusicEqualTo(String value) {
            addCriterion("game_music =", value, "gameMusic");
            return (Criteria) this;
        }

        public Criteria andGameMusicNotEqualTo(String value) {
            addCriterion("game_music <>", value, "gameMusic");
            return (Criteria) this;
        }

        public Criteria andGameMusicGreaterThan(String value) {
            addCriterion("game_music >", value, "gameMusic");
            return (Criteria) this;
        }

        public Criteria andGameMusicGreaterThanOrEqualTo(String value) {
            addCriterion("game_music >=", value, "gameMusic");
            return (Criteria) this;
        }

        public Criteria andGameMusicLessThan(String value) {
            addCriterion("game_music <", value, "gameMusic");
            return (Criteria) this;
        }

        public Criteria andGameMusicLessThanOrEqualTo(String value) {
            addCriterion("game_music <=", value, "gameMusic");
            return (Criteria) this;
        }

        public Criteria andGameMusicLike(String value) {
            addCriterion("game_music like", value, "gameMusic");
            return (Criteria) this;
        }

        public Criteria andGameMusicNotLike(String value) {
            addCriterion("game_music not like", value, "gameMusic");
            return (Criteria) this;
        }

        public Criteria andGameMusicIn(List<String> values) {
            addCriterion("game_music in", values, "gameMusic");
            return (Criteria) this;
        }

        public Criteria andGameMusicNotIn(List<String> values) {
            addCriterion("game_music not in", values, "gameMusic");
            return (Criteria) this;
        }

        public Criteria andGameMusicBetween(String value1, String value2) {
            addCriterion("game_music between", value1, value2, "gameMusic");
            return (Criteria) this;
        }

        public Criteria andGameMusicNotBetween(String value1, String value2) {
            addCriterion("game_music not between", value1, value2, "gameMusic");
            return (Criteria) this;
        }

        public Criteria andPuzzlePicIsNull() {
            addCriterion("puzzle_pic is null");
            return (Criteria) this;
        }

        public Criteria andPuzzlePicIsNotNull() {
            addCriterion("puzzle_pic is not null");
            return (Criteria) this;
        }

        public Criteria andPuzzlePicEqualTo(String value) {
            addCriterion("puzzle_pic =", value, "puzzlePic");
            return (Criteria) this;
        }

        public Criteria andPuzzlePicNotEqualTo(String value) {
            addCriterion("puzzle_pic <>", value, "puzzlePic");
            return (Criteria) this;
        }

        public Criteria andPuzzlePicGreaterThan(String value) {
            addCriterion("puzzle_pic >", value, "puzzlePic");
            return (Criteria) this;
        }

        public Criteria andPuzzlePicGreaterThanOrEqualTo(String value) {
            addCriterion("puzzle_pic >=", value, "puzzlePic");
            return (Criteria) this;
        }

        public Criteria andPuzzlePicLessThan(String value) {
            addCriterion("puzzle_pic <", value, "puzzlePic");
            return (Criteria) this;
        }

        public Criteria andPuzzlePicLessThanOrEqualTo(String value) {
            addCriterion("puzzle_pic <=", value, "puzzlePic");
            return (Criteria) this;
        }

        public Criteria andPuzzlePicLike(String value) {
            addCriterion("puzzle_pic like", value, "puzzlePic");
            return (Criteria) this;
        }

        public Criteria andPuzzlePicNotLike(String value) {
            addCriterion("puzzle_pic not like", value, "puzzlePic");
            return (Criteria) this;
        }

        public Criteria andPuzzlePicIn(List<String> values) {
            addCriterion("puzzle_pic in", values, "puzzlePic");
            return (Criteria) this;
        }

        public Criteria andPuzzlePicNotIn(List<String> values) {
            addCriterion("puzzle_pic not in", values, "puzzlePic");
            return (Criteria) this;
        }

        public Criteria andPuzzlePicBetween(String value1, String value2) {
            addCriterion("puzzle_pic between", value1, value2, "puzzlePic");
            return (Criteria) this;
        }

        public Criteria andPuzzlePicNotBetween(String value1, String value2) {
            addCriterion("puzzle_pic not between", value1, value2, "puzzlePic");
            return (Criteria) this;
        }

        public Criteria andGamePicIsNull() {
            addCriterion("game_pic is null");
            return (Criteria) this;
        }

        public Criteria andGamePicIsNotNull() {
            addCriterion("game_pic is not null");
            return (Criteria) this;
        }

        public Criteria andGamePicEqualTo(String value) {
            addCriterion("game_pic =", value, "gamePic");
            return (Criteria) this;
        }

        public Criteria andGamePicNotEqualTo(String value) {
            addCriterion("game_pic <>", value, "gamePic");
            return (Criteria) this;
        }

        public Criteria andGamePicGreaterThan(String value) {
            addCriterion("game_pic >", value, "gamePic");
            return (Criteria) this;
        }

        public Criteria andGamePicGreaterThanOrEqualTo(String value) {
            addCriterion("game_pic >=", value, "gamePic");
            return (Criteria) this;
        }

        public Criteria andGamePicLessThan(String value) {
            addCriterion("game_pic <", value, "gamePic");
            return (Criteria) this;
        }

        public Criteria andGamePicLessThanOrEqualTo(String value) {
            addCriterion("game_pic <=", value, "gamePic");
            return (Criteria) this;
        }

        public Criteria andGamePicLike(String value) {
            addCriterion("game_pic like", value, "gamePic");
            return (Criteria) this;
        }

        public Criteria andGamePicNotLike(String value) {
            addCriterion("game_pic not like", value, "gamePic");
            return (Criteria) this;
        }

        public Criteria andGamePicIn(List<String> values) {
            addCriterion("game_pic in", values, "gamePic");
            return (Criteria) this;
        }

        public Criteria andGamePicNotIn(List<String> values) {
            addCriterion("game_pic not in", values, "gamePic");
            return (Criteria) this;
        }

        public Criteria andGamePicBetween(String value1, String value2) {
            addCriterion("game_pic between", value1, value2, "gamePic");
            return (Criteria) this;
        }

        public Criteria andGamePicNotBetween(String value1, String value2) {
            addCriterion("game_pic not between", value1, value2, "gamePic");
            return (Criteria) this;
        }

        public Criteria andAdditionIsNull() {
            addCriterion("addition is null");
            return (Criteria) this;
        }

        public Criteria andAdditionIsNotNull() {
            addCriterion("addition is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionEqualTo(Integer value) {
            addCriterion("addition =", value, "addition");
            return (Criteria) this;
        }

        public Criteria andAdditionNotEqualTo(Integer value) {
            addCriterion("addition <>", value, "addition");
            return (Criteria) this;
        }

        public Criteria andAdditionGreaterThan(Integer value) {
            addCriterion("addition >", value, "addition");
            return (Criteria) this;
        }

        public Criteria andAdditionGreaterThanOrEqualTo(Integer value) {
            addCriterion("addition >=", value, "addition");
            return (Criteria) this;
        }

        public Criteria andAdditionLessThan(Integer value) {
            addCriterion("addition <", value, "addition");
            return (Criteria) this;
        }

        public Criteria andAdditionLessThanOrEqualTo(Integer value) {
            addCriterion("addition <=", value, "addition");
            return (Criteria) this;
        }

        public Criteria andAdditionIn(List<Integer> values) {
            addCriterion("addition in", values, "addition");
            return (Criteria) this;
        }

        public Criteria andAdditionNotIn(List<Integer> values) {
            addCriterion("addition not in", values, "addition");
            return (Criteria) this;
        }

        public Criteria andAdditionBetween(Integer value1, Integer value2) {
            addCriterion("addition between", value1, value2, "addition");
            return (Criteria) this;
        }

        public Criteria andAdditionNotBetween(Integer value1, Integer value2) {
            addCriterion("addition not between", value1, value2, "addition");
            return (Criteria) this;
        }

        public Criteria andTotalStrengthIsNull() {
            addCriterion("total_strength is null");
            return (Criteria) this;
        }

        public Criteria andTotalStrengthIsNotNull() {
            addCriterion("total_strength is not null");
            return (Criteria) this;
        }

        public Criteria andTotalStrengthEqualTo(Integer value) {
            addCriterion("total_strength =", value, "totalStrength");
            return (Criteria) this;
        }

        public Criteria andTotalStrengthNotEqualTo(Integer value) {
            addCriterion("total_strength <>", value, "totalStrength");
            return (Criteria) this;
        }

        public Criteria andTotalStrengthGreaterThan(Integer value) {
            addCriterion("total_strength >", value, "totalStrength");
            return (Criteria) this;
        }

        public Criteria andTotalStrengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_strength >=", value, "totalStrength");
            return (Criteria) this;
        }

        public Criteria andTotalStrengthLessThan(Integer value) {
            addCriterion("total_strength <", value, "totalStrength");
            return (Criteria) this;
        }

        public Criteria andTotalStrengthLessThanOrEqualTo(Integer value) {
            addCriterion("total_strength <=", value, "totalStrength");
            return (Criteria) this;
        }

        public Criteria andTotalStrengthIn(List<Integer> values) {
            addCriterion("total_strength in", values, "totalStrength");
            return (Criteria) this;
        }

        public Criteria andTotalStrengthNotIn(List<Integer> values) {
            addCriterion("total_strength not in", values, "totalStrength");
            return (Criteria) this;
        }

        public Criteria andTotalStrengthBetween(Integer value1, Integer value2) {
            addCriterion("total_strength between", value1, value2, "totalStrength");
            return (Criteria) this;
        }

        public Criteria andTotalStrengthNotBetween(Integer value1, Integer value2) {
            addCriterion("total_strength not between", value1, value2, "totalStrength");
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