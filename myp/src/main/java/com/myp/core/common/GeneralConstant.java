package com.myp.core.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class GeneralConstant {

    private static final LocalDateTime TODAY_START_DAY = LocalDateTime.of(LocalDate.now(), LocalTime.of(0,0,0)); //오늘 00:00:00
    private final static LocalDateTime AFTER_7DAYS = LocalDateTime.of(LocalDate.now().plusDays(7), LocalTime.of(23,59,59));
}
