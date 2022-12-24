package com.x.demo.common.utils;

import com.x.demo.entity.UserEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateUtils {

    /**
     * 一周前时间
     * @return
     */
    public LocalDate getWeekDate () {
        return LocalDate.now().plusDays(- 7);
    }
}
