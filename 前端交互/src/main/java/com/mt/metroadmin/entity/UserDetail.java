package com.mt.metroadmin.entity;

import lombok.Data;

@Data
public class UserDetail {
        private Integer id;

        private Integer gender;

        private String nickname;

        private String city;

        private String statement;

        private String defaultStation;

        private Integer coinNumber;

        private Integer weekNumber;

        private Integer dailyScore;

        private Integer weekScore;

        private Integer totalScore;

        private Integer dailyRanking;

        private Integer weekRanking;

        private Integer currentStrength;

        private String headPortrait;

}
