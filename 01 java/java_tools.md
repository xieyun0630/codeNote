#                            EasyExcel 

## 导出Demo

### 将List写入Excel

```java
fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
// 这里 需要指定写用哪个class去写
//{{c1::
ExcelWriter excelWriter = EasyExcel.write(s, DemoData.class).build();
WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
excelWriter.write(data(), writeSheet);
}}
/// 千万别忘记finish 会帮忙关闭流
excelWriter.finish();
```

### 根据参数只导出指定列

```java
Set<String> excludeColumnFiledNames = new HashSet<String>();
excludeColumnFiledNames.add("date");
excludeColumnFiledNames.add("string");
// 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//{{c1::
EasyExcel.write(fileName, DemoData.class)
  			 .excludeColumnFiledNames(excludeColumnFiledNames)
  			 .sheet("模板")
  			 .doWrite(new ArrayList<DemoData>());
}}
```

### 指定写入的列

```java
// 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
// 使用{@link ExcelProperty}注解指定写入的列
//{{c1::
  EasyExcel.write(fileName, IndexData.class)
   				 .sheet("模板")
    			 .doWrite(data());
 //这里IndexData中使用@ExcelProperty注解标注data()返回的List中对象的部分属性。
 }}
//复杂头写入
// 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//{{c1::
EasyExcel.write(fileName, ComplexHeadData.class).sheet("模板").doWrite(data()); 
}}
```

ComplexHeadData类：

{{c3::

```
@Data
public class ComplexHeadData {
    @ExcelProperty({"主标题", "字符串标题"})
    private String string;
    @ExcelProperty({"主标题", "日期标题"})
    private Date date;
    @ExcelProperty({"主标题", "数字标题"})
    private Double doubleData;
}
```

 }}

复杂头写入效果：

![image-20191203173533187](java%20tools.assets/image-20191203173533187.png)

### 重复多次写入Excel                                         

- 如果写到同一个sheet

  ```java
  //只创建一次sheet即可
  WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
  excelWriter.write(data, writeSheet);
  ```

- 如果写到不同的sheet 同一个对象 

  ``` java
  //每次都要创建writeSheet 这里注意必须指定sheetNo
  writeSheet = EasyExcel.writerSheet(i, "模板"+i).build();
  excelWriter.write(data, writeSheet);
  ```

- 如果写到不同的sheet 不同的对象

  ```
  
  ```

  
