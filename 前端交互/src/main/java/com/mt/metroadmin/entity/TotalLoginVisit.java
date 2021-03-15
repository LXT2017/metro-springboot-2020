package com.mt.metroadmin.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TotalLoginVisit {

    LocalDateTime statime;
    int totalnum;
}
