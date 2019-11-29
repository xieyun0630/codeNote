package top.xieyun.selenium;

import static org.junit.Assert.assertTrue;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import sun.rmi.transport.StreamRemoteCall;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test01(){
        File markedMD = new File("C:\\Users\\hezp\\Desktop\\mdnote\\javascript_info_marked.html");
        String htmlStr = null;
        try {
            htmlStr = FileUtils.readFileToString(markedMD);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document htmlDoc = null;
        htmlDoc = Jsoup.parse(htmlStr);
        htmlDoc.outputSettings().indentAmount(0).prettyPrint(false);
        Element write = htmlDoc.getElementById("write");
        Elements elements = write.children();
        int i=0;
        for (Element element : elements) {
            System.out.println(element.outerHtml());
        }

    }


    @Test
    public void parseHtmlOfMarkdown() {
        List<MarkDownHtmlData> records = new ArrayList<>();
        File markedMD = new File("C:\\Users\\hezp\\Desktop\\mdnote\\javascript_info_marked.html");
        Document htmlDoc = null;
        String s = "C:\\Users\\hezp\\Desktop\\mdnote\\"+System.currentTimeMillis()+".xlsx";
        try {
            String htmlStr = FileUtils.readFileToString(markedMD);
            htmlDoc = Jsoup.parse(htmlStr);
            htmlDoc.outputSettings().indentAmount(0).prettyPrint(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> headers = Arrays.asList(new String[]{"h1", "h2", "h3", "h4", "h5", "h6"});
        Element write = htmlDoc.getElementById("write");
        Elements elements = write.children();


        MarkDownHtmlData record = null;
        for (Element element : elements) {
            if (headers.contains(element.tagName())) {
                if (record != null) {
                    records.add(record);
                }
                record = new MarkDownHtmlData();
                Elements allA = element.getElementsByTag("a");
                String href = allA.get(allA.size() - 1).attr("href");
                record.setSortedFiled(href);
                record.setProblem(element.toString());
                record.setAnswer(element.toString());
                System.out.println(record.getSortedFiled()+"  "+element);
            }else{
                if(record!=null) {
                    String s1 = Strings.nullToEmpty(record.getAnswer()) + element.outerHtml();
                    record.setAnswer(s1);
                }
            }
        }

        System.out.println(JSON.toJSONString(records));

        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(s, MarkDownHtmlData.class).sheet("javascript2").doWrite(records);
    }

    public void appendIdOfTitle(String sourcePath) throws IOException {
        File originMD = new File("C:\\Users\\hezp\\Desktop\\mdnote\\javascript_info.md");
        File markedMD = new File("C:\\Users\\hezp\\Desktop\\mdnote\\javascript_info_marked.md");
        if (markedMD.exists()) {
            markedMD.delete();
        }
        FileWriter fileWriter = new FileWriter(markedMD);
        //获取文件名
        String fileName = originMD.getName().substring(0, originMD.getName().length() - 3);
        try {
            Scanner scanner = new Scanner(originMD);
            //读取行
            String line = "";
            //行号
            int lineCount = 0;
            //标题个数
            int titleCount = 0;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                int titleGrade = getTitleGrade(line);
                if (titleGrade != -1 && titleGrade > 0) {
                    line += " [\t](" + fileName + "_" + titleCount + ")";
                    System.out.println(lineCount + ":" + line);
                    titleCount++;
                }
                fileWriter.append(line + "\n");
                lineCount++;
            }
            System.out.println(titleCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
    }

    /**
     * @param title 一行markdown格式的文本
     * @return 判断是否是标题，是返回标题级数，不是标题返回-1。
     */
    public int getTitleGrade(String title) {
        int titleGrade = 0;
        title = title.trim();
        String[] titleCodes = new String[]{"#", "##", "###", "####", "#####", "######"};
        for (String x : titleCodes) {
            if (title.startsWith(x)) {
                return x.length();
            }
        }
        return -1;
    }


}
