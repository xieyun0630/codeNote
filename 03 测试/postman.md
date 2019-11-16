

# java爬虫

## 环境配置：

第一步：IDEA下创建maven工程

第二步：导入依赖

![image-20191101215636203](postman.assets/image-20191101215636203.png)

第三步：

log4j配置文件![image-20191101215709373](postman.assets/image-20191101215709373.png)

## 第一个案例：模拟获得一个网站的页面

![image-20191101220207852](postman.assets/image-20191101220207852.png)

### task:使用上面的方式，获取当前localhost:8080的页面信息

## 完整的获取一个页面

![image-20191101221347591](postman.assets/image-20191101221347591.png)

**注意最后关闭response，httpClient**

## 带参数的get请求

![image-20191101222147200](postman.assets/image-20191101222147200.png)

## 发送post请求

和不带参数的get请求差不多

![image-20191101222407503](postman.assets/image-20191101222407503.png)

## 带参数（表单）的post请求

![image-20191101222735272](postman.assets/image-20191101222735272.png)

## 使用连接池管理器发起请求

第一步：创建连接池对象

![image-20191101223601101](postman.assets/image-20191101223601101.png)

第二步：使用连接池发送get请求

![image-20191101223303715](postman.assets/image-20191101223303715.png)

## 配置请求信息RequestConfig

![image-20191101224049615](postman.assets/image-20191101224049615.png)

# jsoup工具

## 引入依赖

![image-20191101224618445](postman.assets/image-20191101224618445.png)

![image-20191101224647520](postman.assets/image-20191101224647520.png)

![image-20191101224732354](postman.assets/image-20191101224732354.png)

StringUtils类的依赖

![image-20191101224804526](postman.assets/image-20191101224804526.png)

## 使用jsoup访问一个网站的title

![image-20191101225240505](postman.assets/image-20191101225240505.png)

![image-20191101225259351](postman.assets/image-20191101225259351.png)

## jsoup的解析

![image-20191101225511946](postman.assets/image-20191101225511946.png)

![image-20191101225643844](postman.assets/image-20191101225643844.png)

## jsoup使用dom的方式获取元素

![image-20191101225926040](postman.assets/image-20191101225926040.png)

![image-20191101230114503](postman.assets/image-20191101230114503.png)

![image-20191101230713159](postman.assets/image-20191101230713159.png)

![image-20191101230703042](postman.assets/image-20191101230703042.png)

![image-20191101230733850](postman.assets/image-20191101230733850.png)

## jsoup获取元素中的内容

 ![image-20191101230815618](postman.assets/image-20191101230815618.png)

![image-20191101231459782](postman.assets/image-20191101231459782.png)

![image-20191101231512187](postman.assets/image-20191101231512187.png)

![image-20191101231715868](postman.assets/image-20191101231715868.png)



## selector的使用

![image-20191101232138264](postman.assets/image-20191101232138264.png)

![image-20191101232623996](postman.assets/image-20191101232623996.png)

 ![image-20191101232738079](postman.assets/image-20191101232738079.png)

![image-20191101232841685](postman.assets/image-20191101232841685.png)

注意直接子元素

![image-20191101233041131](postman.assets/image-20191101233041131.png)

![image-20191101233138045](postman.assets/image-20191101233138045.png)

# 爬虫案例：将京东的手机数据抓取下来

## 数据库表：

![image-20191102192148610](postman.assets/image-20191102192148610.png)

## 依赖：

![image-20191102192259633](postman.assets/image-20191102192259633.png)

![image-20191102192334741](postman.assets/image-20191102192334741.png)

## 配置文件：

 ![image-20191102192411891](postman.assets/image-20191102192411891.png)

## 创建POJO：

![image-20191102192531784](postman.assets/image-20191102192531784.png)

![image-20191102192542856](postman.assets/image-20191102192542856.png)

## 创建DAO

![image-20191102192742092](postman.assets/image-20191102192742092.png)

JpaRepository<Item,Long>  Item是实体名，Long是主键。

## 创建Service

接口：

![image-20191102192853895](postman.assets/image-20191102192853895.png)

![image-20191102192910226](postman.assets/image-20191102192910226.png)

实现：

![image-20191102192947700](postman.assets/image-20191102192947700.png)

![image-20191102192957877](postman.assets/image-20191102192957877.png)

![image-20191102193005623](postman.assets/image-20191102193005623.png)

![image-20191102193045798](postman.assets/image-20191102193045798.png)

## springBoot引导类

 ![image-20191102193140234](postman.assets/image-20191102193140234.png)

## 封装HttpClient

![image-20191102194113501](postman.assets/image-20191102194113501.png)

![image-20191102194100146](postman.assets/image-20191102194100146.png)

![image-20191102193839133](postman.assets/image-20191102193839133.png)![image-20191102194013602](postman.assets/image-20191102194013602.png)

![image-20191102194029464](postman.assets/image-20191102194029464.png) 

![image-20191102194229350](postman.assets/image-20191102194229350.png)

### 下载图片

![image-20191102194416654](postman.assets/image-20191102194416654.png)

![image-20191102204534989](postman.assets/image-20191102204534989.png)

![image-20191102205223437](postman.assets/image-20191102205223437.png)

# WebMagic

![image-20191102214333863](postman.assets/image-20191102214333863.png)

## 依赖

![image-20191102215517998](postman.assets/image-20191102215517998.png)



```http
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Accept-Ranges: bytes
ETag: W/"41044-1560135754000"
Last-Modified: Mon, 10 Jun 2019 03:02:34 GMT
Content-Type: text/html
Content-Length: 41044
Date: Sat, 02 Nov 2019 12:07:01 GMT
```

```http
POST /clubkatene/api/login.do?by=katene HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 72
Accept: application/json, text/javascript, */*; q=0.01
Origin: http://localhost:8080
X-Requested-With: XMLHttpRequest
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.10 Safari/537.36
Sec-Fetch-Mode: cors
Content-Type: application/x-www-form-urlencoded; charset=UTF-8
Sec-Fetch-Site: same-origin
Referer: http://localhost:8080/
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9,ja;q=0.8
Cookie: JSESSIONID=6E134F3016D93ECDFAFDB0DCCDE4DC31; Idea-444d716e=97974c4d-ad86-42c0-8c8a-46b035ab0ead; __utma=111872281.306456456.1568871682.1568871682.1568871682.1; __utmz=111872281.1568871682.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); _ga=GA1.1.306456456.1568871682; Webstorm-47287ac7=5c7cb770-002e-4af9-890e-f82e2c638815; fontsize=bFontS; rare_popup=201910; _gid=GA1.1.1561031928.1572227554; _gat_newTracker=1; _gat_UA-67685261-1=1
```

```http
POST /clubkatene/api/login.do?by=katene HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Content-Length: 72
Accept: application/json, text/javascript, */*; q=0.01
Origin: http://localhost:8080
X-Requested-With: XMLHttpRequest
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.10 Safari/537.36
Sec-Fetch-Mode: cors
Content-Type: application/x-www-form-urlencoded; charset=UTF-8
Sec-Fetch-Site: same-origin
Referer: http://localhost:8080/
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9,ja;q=0.8
Cookie: JSESSIONID=CDF8009DBC029E08BB2D85548C138039; Idea-444d716e=97974c4d-ad86-42c0-8c8a-46b035ab0ead; __utma=111872281.306456456.1568871682.1568871682.1568871682.1; __utmz=111872281.1568871682.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); _ga=GA1.1.306456456.1568871682; Webstorm-47287ac7=5c7cb770-002e-4af9-890e-f82e2c638815; fontsize=bFontS; rare_popup=201910; _gid=GA1.1.1561031928.1572227554; _gat_newTracker=1; _gat_UA-67685261-1=1
```

```http
loginID: xieyun0929
passwd: login123
ref: file://172.18.7.136
by: 
id:
```

