package com.x.demo.config;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.x.demo.entity.UserListEntity;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserListener extends AnalysisEventListener<UserListEntity> implements ApplicationListener<ReloadDataEvent> {

    private final List<UserListEntity> list = new ArrayList<>();

    @Override
    public void invoke(UserListEntity userEntity, AnalysisContext analysisContext) {
        List<UserListEntity> list1 = new ArrayList<>();
        //每读取一条数据就调用该方法一次，我这里没有与数据库进行交互，纯输出读取到的对象
        list1.add(userEntity);
        System.out.println(userEntity.getName());
        list.addAll(list1);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //读取结束会调用该方法
        System.out.println("end...");
    }

    public List<UserListEntity> getUserList() {
        return list;
    }

    @Override
    public void onApplicationEvent(ReloadDataEvent reloadDataEvent) {
        System.out.println("初始化加载==============");
    }
}
