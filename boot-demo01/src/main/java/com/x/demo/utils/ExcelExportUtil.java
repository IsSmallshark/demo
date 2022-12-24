package com.x.demo.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.x.demo.entity.LogEntity;

import java.io.IOException;
import java.util.List;

public class ExcelExportUtil {

    public static void exportExcel(List<LogEntity> dataList, String filePath) throws IOException {
        // 创建 ExcelWriter 对象
        ExcelWriter writer = EasyExcel.write(filePath, LogEntity.class).build();
        // 创建工作表
        WriteSheet sheet = EasyExcel.writerSheet("Sheet1").build();
        // 写入数据
        writer.write(dataList, sheet);
        // 关闭 ExcelWriter
        writer.finish();
    }
}
