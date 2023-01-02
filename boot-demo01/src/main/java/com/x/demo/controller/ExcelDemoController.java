package com.x.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.x.demo.common.config.UserListener;
import com.x.demo.entity.LogEntity;
import com.x.demo.entity.UserListEntity;
import com.x.demo.utils.ExcelExportUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/excel")
public class ExcelDemoController {


    //http://localhost:8080/test
    @GetMapping("/test")
    public String test(String date) throws Exception {
        //excel文件路径
        String path = "D:\\user.xlsx";
        List<UserListEntity> objects = EasyExcel.read(path, UserListEntity.class, new UserListener()).sheet().doReadSync();
        String key = "After request [GET /dashboard/api/search";
        List<LogEntity> dataList = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("D:\\30dayLog\\app-"+date+".log"));
            String str;
            while ((str = in.readLine()) != null) {
                if (str.contains(key)) {
                    LogEntity log = new LogEntity();
                    log.setDate(date);
                    String type = str.substring(str.indexOf("api/search/") + 11, str.indexOf("?keywords"));
                    String keywords = str.substring(str.indexOf("keywords=") + 9,str.indexOf("pageSize") - 1);
                    log.setType(type);
                    String china = "";
                    china = URLDecoder.decode(keywords,"utf-8");
                    log.setKeyWords(china);
                    if (str.contains("userid")) {
                        try {
                            String team = str.substring(str.indexOf(", team:") + 1, str.indexOf("user-agent") - 2);
                            log.setTeam(team);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        String userId = "";
                        try{
                            userId = str.substring(str.indexOf("userid"), str.indexOf(", team:"));

                        } catch (Exception e) {

                        }
                        System.out.println(userId);
                        if (userId.contains(", cookie")) {
                            userId = userId.substring(userId.indexOf("userid"), userId.indexOf(", cookie"));
                        }
                        log.setUserId(userId);
                        Map<String, List<UserListEntity>> collect = objects
                                .stream().collect(Collectors.groupingBy(UserListEntity::getName));
                        List<UserListEntity> userListEntities = collect.get(userId);
                        if (userListEntities != null) {
                            log.setUsername(userListEntities.get(0).getUsername());
                        }
//                        out.write(team);
//                        out.newLine();
                    }
                    dataList.add(log);
                }
            }
//            out.close();
            // 使用工具类导出 Excel 表格// 要导出的数据列表
            // 导出的 Excel 文件路径
            String filePath = "D:\\"+date+".xlsx";
            ExcelExportUtil.exportExcel(dataList, filePath);
            System.out.println("文件创建成功！");
        } catch (IOException e) {
        }
        return "ok";
    }
}
