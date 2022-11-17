package com.x.demo.common.utils;

import com.x.demo.entity.UserEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateUtils {

    public static void main(String[] args) {
        List<UserEntity> lsit1 = new ArrayList<>();
        List<UserEntity> lsit2 = new ArrayList<>();
        UserEntity one= new UserEntity();
        one.setId(1);
        lsit1.add(one);
        UserEntity two = new UserEntity();
        one.setUsername("xxxxxx");
        lsit2.add(two);
        Stream<List<UserEntity>> lsit11 = Stream.of(lsit1, lsit2);
        List<List<UserEntity>> collect = lsit11.collect(Collectors.toList());
        for (List<UserEntity> userEntities : collect) {

        }
    }

}
