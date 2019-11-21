# 环境配置

## maven依赖

```xml
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
```

## 驱动版本对应表

一定要注意浏览器与驱动之间的对应关系：

![image-20191113220518189](selenium.assets/image-20191113220518189.png)

## hello world程序

```java
public static void main(String[] args) {
    //chromedriver驱动应用程序的地址
    System.setProperty("webdriver.chrome.driver"
                     		,"D:\\myChromeDriver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("http://localhost:8080/");
    String title = driver.getTitle();
    System.out.printf(title);
    driver.close();
}
```

# 元素定位

## 元素定位常用操作

![image-20191113223513586](selenium.assets/image-20191113223513586.png)

**层级定位**:

![image-20191113223812058](selenium.assets/image-20191113223812058.png)

### 常见元素:radio的处理

**选中某个按钮**

![image-20191113230503989](selenium.assets/image-20191113230503989.png)

**获取元素的属性**

![image-20191113224823958](selenium.assets/image-20191113224823958.png)

### 常见元素:check的处理

其中clear()无效会报错

![image-20191113233138306](selenium.assets/image-20191113233138306.png)

### 常见元素:按钮处理

![image-20191113234605570](selenium.assets/image-20191113234605570.png)

### 常见元素:表单处理

summit()方法提交的方式只是以当前页面的URL后面加上参数进行提交，所以模拟登陆时最好使用click进行操作

![image-20191113235034671](selenium.assets/image-20191113235034671.png)

### 常见元素:上传文件处理

![image-20191114000504743](selenium.assets/image-20191114000504743.png)

### 常见元素:下拉框处理

![image-20191114000805046](selenium.assets/image-20191114000805046.png)

![image-20191114000813834](selenium.assets/image-20191114000813834.png)

![image-20191114000826233](selenium.assets/image-20191114000826233.png)

![image-20191114000845482](selenium.assets/image-20191114000845482.png)

![image-20191114000902925](selenium.assets/image-20191114000902925.png)



## 使用chrome快速获取XPATH

![image-20191113225658368](selenium.assets/image-20191113225658368.png)

## 使用selenium进行登陆操作

```java
   public static void main(String[] args) {
        //chromedriver服务地址
System.setProperty("webdriver.chrome.driver","D:\\myChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/");
        driver.manage().window().setSize(new Dimension(480, 800));
        System.out.println(driver.getTitle());
        driver.findElement(By.name("loginID")).sendKeys("xieyun0929");
        driver.findElement(By.name("passwd")).sendKeys("login123");
        driver.findElement(By.className("login")).click();
    }
```

# 详解介绍Selenium常用API的使用--Java语言（完整版）

## 控制浏览器窗口大小

有时候我们希望能以某种浏览器尺寸找开，访问的页面在这种尺寸下运行。例如可以将浏览器设置成移动端大小(480* 800)，然后访问移动站点，对其样式进行评估；

WebDriver 提供了 `manage().window().setSize()`方法来设置浏览器的大小。

- `maximize() `设置浏览器最大化
- `setSize()` 设置浏览器宽高

用法：

```java
driver.manage().window().maximize();
driver.manage().window().setSize(new Dimension(480, 800));
```

## 控制浏览器后退、前进

在使用浏览器浏览网页时，浏览器提供了后退和前进按钮，可以方便地在浏览过的网页之间切换，WebDriver也提供了对应的back()和forward()方法来模拟后退和前进按钮。下面通过例子来演示这两个方法的使用。

- back() 模拟浏览器后退按钮
- forward() 模拟浏览器前进按钮

```java
    WebDriver driver = new ChromeDriver();
    //get 到百度首页
    driver.get("https://www.baidu.com/");
    //执行浏览器后退
    driver.navigate().back();
    //执行浏览器前面
    driver.navigate().forward();
```

## 刷新页面

```java
//刷新页面
driver.navigate().refresh();
```

## 模拟鼠标操作

现在的Web产品中提供了更丰富的鼠标交互方式， 例如鼠标右击、双击、悬停、甚至是鼠标拖动等功能。在WebDriver中，将这些关于鼠标操作的方法封装在`ActionChains`类提供。
Actions 类提供了鼠标操作的常用方法：

- `contextClick()` 右击
- `clickAndHold()` 鼠标点击并控制
- `doubleClick()` 双击
- `dragAndDrop() `拖动
- `release() `释放鼠标
- `perform() `执行所有Actions中存储的行为

**使用方法：**

```java
	WebElement search_setting = driver.findElement(By.linkText("设置"));
    Actions action = new Actions(driver);
		//模拟鼠标悬停操作
    action.clickAndHold(search_setting).perform();
    Actions action = new Actions(driver);
    // 鼠标右键点击指定的元素
    action.contextClick(driver.findElement(By.id("element"))).perform();

    // 鼠标右键点击指定的元素
    action.doubleClick(driver.findElement(By.id("element"))).perform();

    // 鼠标拖拽动作， 将 source 元素拖放到 target 元素的位置。
    WebElement source = driver.findElement(By.name("element"));
    WebElement target = driver.findElement(By.name("element"));
    action.dragAndDrop(source,target).perform();

    // 释放鼠标
    action.release().perform();
```

## 模拟键盘操作

```java
//ctrl+a 全选输入框内容
input.sendKeys(Keys.CONTROL,"a");
Thread.sleep(2000);
```

 以下为常用的键盘操作：

- `sendKeys(Keys.BACK_SPACE) `回格键（`BackSpace`）
- `sendKeys(Keys.SPACE)` 空格键(Space)
- `sendKeys(Keys.TAB)` 制表键(Tab)
- `sendKeys(Keys.ESCAPE)` 回退键（Esc）
- `sendKeys(Keys.ENTER)` 回车键（Enter）
- `sendKeys(Keys.CONTROL,‘a’)` 全选（Ctrl+A）
- `sendKeys(Keys.CONTROL,‘c’) `复制（Ctrl+C）
- `sendKeys(Keys.CONTROL,‘x’)` 剪切（Ctrl+X）
- `sendKeys(Keys.CONTROL,‘v’)` 粘贴（Ctrl+V）
- `sendKeys(Keys.F1) `键盘 F1
  ……
  `sendKeys(Keys.F12) `键盘 F12 

## 设置元素等待

### 显示等待

WebDriver提供了显式等待方法，专门针对某个元素进行等待判断。

```java
		//显式等待， 针对某个元素等待
    WebDriverWait wait = new WebDriverWait(driver,10,1);
    wait.until(new ExpectedCondition<WebElement>(){
      @Override
      public WebElement apply(WebDriver text) {
            return text.findElement(By.id("kw"));
          }
    }).sendKeys("selenium");
```

`WebDriverWait`类是由`WebDirver`提供的等待方法。在设置时间内，默认每隔一段时间检测一次当前页面元素是否存在，如果超过设置时间检测不到则抛出异常。具体格式如下：`WebDriverWait(driver, 10, 1)`

- driver： 浏览器驱动。 
- 10： 最长超时时间， 默认以秒为单位。 
- 1： 检测的的间隔（步长） 时间， 默认为 0.5s。

### 隐式等待

WebDriver 提供了几种方法来等待元素。

- `implicitlyWait`。识别对象时的超时时间。过了这个时间如果对象还没找到的话就会抛出NoSuchElement异常。
- `setScriptTimeout`。异步脚本的超时时间。WebDriver可以异步执行脚本，这个是设置异步执行脚本脚本返回结果的超时时间。
- `pageLoadTimeout`。页面加载时的超时时间。因为WebDriver会等页面加载完毕再进行后面的操作，所以如果页面超过设置时间依然没有加载完成，那么WebDriver就会抛出异常。
- 语法：![image-20191120175741694](selenium.assets/image-20191120175741694.png)


## 多表单切换

 在 Web 应用中经常会遇到 `frame/iframe `表单嵌套页面的应用， WebDriver 只能在一个页面上对元素识别与 定位， 对于` frame/iframe `表单内嵌页面上的元素无法直接定位。 这时就需要通过 `switchTo().frame()`方法将当前定 位的主体切换为 `frame/iframe` 表单的内嵌页面中。 

```java
public static void main(String[] args){
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.126.com");
 
    WebElement xf = driver.findElement(By.xpath("//*[@id='loginDiv']/iframe"));
    driver.switchTo().frame(xf);
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("username");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.id("dologin")).click();
    driver.switchTo().defaultContent();
    //……
  }
```

 如果完成了在当前表单上的操作，则可以通过`switchTo().defaultContent()`方法跳出表单。 

![image-20191115233117317](selenium.assets/image-20191115233117317.png)

## 多窗口切换（todo:看视频理解）

 在页面操作过程中有时候点击某个链接会弹出新的窗口， 这时就需要主机切换到新打开的窗口上进行操作。WebDriver提供了`driver.switchTo().window(handle);`方法可以实现在不同的窗口之间切换。 

在本例中所涉及的新方法如下：

- `driver.getWindowHandle();`： 获得当前窗口句柄。
- `driver.getWindowHandles()`： 返回的所有窗口的句柄到当前会话。
- `switchTo().window()`： 用于切换到相应的窗口，与上一节的switchTo().frame()类似，前者用于不同窗口的切换， 后者用于不同表单之间的切换。

```java
public static void main(String[] arge) throws InterruptedException{
 
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.baidu.com");
 
    //获得当前窗口句柄
    String search_handle = driver.getWindowHandle();
 
    //打开百度注册窗口
    driver.findElement(By.linkText("登录")).click();
    Thread.sleep(3000);
    driver.findElement(By.linkText("立即注册")).click();
 
    //获得所有窗口句柄
    Set<String> handles = driver.getWindowHandles();
 
    //判断是否为注册窗口， 并操作注册窗口上的元素
    for(String handle : handles){
      if (handle.equals(search_handle)==false){
          
        //切换到注册页面
        driver.switchTo().window(handle);
          
        System.out.println("now register window!");
        Thread.sleep(2000);
        driver.findElement(By.name("userName")).clear();
        driver.findElement(By.name("userName")).sendKeys("user name");
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys("phone number");
        //......
        Thread.sleep(2000);
        //关闭当前窗口
        driver.close();
      }
    }
    Thread.sleep(2000);
 
    driver.quit();
  }
}
```

## 下拉框选择

```html
<select id="nr" name="NR">
  <option value="10" selected>每页显示 10 条</option>
  <option value="20">每页显示 20 条</option>
  <option value="50">每页显示 50 条</option>
<select>
```

```java
    //<select>标签的下拉框选择,选择第2条
    WebElement el = driver.findElement(By.xpath("//select"));
    Select sel = new Select(el);
    sel.selectByValue("20");
    Thread.sleep(2000);
```



## 警告框处理

在 WebDriver中处理JavaScript所生成的alert、confirm以及prompt十分简单，具体做法是使用switch_to_alert()方法定位到alert/confirm/prompt，然后使用text/accept/dismiss/sendKeys等方法进行操作。

- `getText()`： 返回 alert/confirm/prompt 中的文字信息。
- `accept()`： 接受现有警告框。
- `dismiss()`： 解散现有警告框。
- `sendKeys(keysToSend)`： 发送文本至警告框。
- `keysToSend`： 将文本发送至警告框。

如下图，百度搜索设置弹出的窗口是不能通过前端工具对其进行定位的，这个时候就可以通过switchTo().alert()方法接受这个弹窗。

## 文件上传

 对于通过input标签实现的上传功能，可以将其看作是一个输入框，即通过`sendKeys()`**指定本地文件路径**的方式实现文件上传。 

 创建upfile.html文件，代码如下： 

```html
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<title>upload_file</title>
<link href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
  <div class="row-fluid">
	<div class="span6 well">
	<h3>upload_file</h3>
	  <input type="file" name="file" />
	</div>
  </div>
</body>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.js"></scrip>
</html>
```

```java
//定位上传按钮， 添加本地文件
driver.findElement(By.name("file")).sendKeys("D:\\upload_file.txt");
Thread.sleep(5000);
```

## 浏览器cookie操作

WebDriver 操作Cookie的方法：

- `getCookies() `获得所有 cookie 信息。
- `getCookieNamed(String name) `返回字典的key为“name”的Cookie信息。
- `addCookie(cookie dict) `添加Cookie。`“cookie_dict”`指字典对象，必须有 name和value值。
- `deleteCookieNamed(String name) `删除Cookie 信息。 “name”是要删除的 cookie的名称； 
- `optionsString` 是该Cookie的选项，目前支持的选项包括“路径” ， “域” 。
- `deleteAllCookies()` 删除所有 cookie 信息。

```java
WebDriver driver = new ChromeDriver();
driver.get("https://www.baidu.com");

Cookie c1 = new Cookie("name", "key-aaaaaaa");
Cookie c2 = new Cookie("value", "value-bbbbbb");
driver.manage().addCookie(c1);
driver.manage().addCookie(c2);

//获得 cookie
Set<Cookie> coo = driver.manage().getCookies();
System.out.println(coo);

//删除所有 cookie
//driver.manage().deleteAllCookies();
```

**`js`实现页面打开自动定位到指定元素位置**

```js
 document.getElementById("moreMerchant").scrollIntoView() 
```

### 执行JS

```JS
       String js = "window.scrollTo(100,450);";
        ((JavascriptExecutor) driver).executeScript(js);
```



##  获取窗口截图 

自动化用例是由程序去执行，因此有时候打印的错误信息并不十分明确。如果在脚本执行出错的时候能对当前窗口截图保存，那么通过图片就可以非常直观地看出出错的原因。 WebDriver提供了截图函数`getScreenshotAs()`来截取当前窗口。

```java
  public static void main(String[] arge){
 
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.baidu.com");
 
    File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(srcFile,new File("d:\\screenshot.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    driver.quit();
  }

```

# Selenium 常用类解释 与 常见问题处理

## `WebDriver`类