package top.xieyun.selenium;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class MarkDownHtmlData {
    @ExcelProperty("sortedFiled")
    private String sortedFiled;
    @ExcelProperty("问题")
    private String problem;
    @ExcelProperty("答案")
    private String answer;
}
