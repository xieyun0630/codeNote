### 初始化Velocity引擎

```java
public static void main(String[] args) {
    // 初始化模板引擎
    VelocityEngine ve = new VelocityEngine();
    ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
    ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
    ve.init();
    // 获取模板文件
    Template t = ve.getTemplate("hellovelocity.vm");
    // 设置变量
    VelocityContext ctx = new VelocityContext();
    ctx.put("name", "Velocity");
    List list = new ArrayList();
    list.add("1");
    list.add("2");
    ctx.put("list", list);
    // 输出
    StringWriter sw = new StringWriter();
    t.merge(ctx,sw);
    System.out.println(sw.toString());
}
```

> `ClasspathResourceLoader`的作用是什么

接下来就是写 hellovelocity.vm 文件了，这个文件实际定义了 Velocity 的输出内容和格式。hellovelocity.vm 的内容如下：

```velocity
#set( $iAmVariable = "good!" )
Welcome $name to velocity.com
today is $date.
#foreach ($i in $list)
$i
#end
$iAmVariable
```

输出结果如下：

```velocity
Welcome velocity to velocity.com
today is Sun Mar 23 19:19:04 CST 2014.
1
2
good!
```

## 基本模板语言语法使用

### 变量定义

在 Velocity 中所有的关键字都是以 # 开头的，而所有的变量则是以$开头。

```velocity
#set($name =“velocity”)
```

等号后面的字符串 Velocity 引擎将重新解析，例如出现以$开始的字符串时，将做变量的替换。

```velocity
#set($hello =“hello $name”)
```

上面的这个等式将会给$hello 赋值为“hello velocity”

### 变量的使用

- 在模板文件中使用$name 或者${name} 来使用定义的变量。
- 推荐使用${name} 这种格式，因为在模板中同时可能定义了类似$name 和$names 的两个变量，如果不选用大括号的话，引擎就没有办法正确识别$names 这个变量。
- 可以使用${person.name} 来访问 person 的 name 属性。
- 这里的${person.name} 并不是直接访问 person 的 name 属性，而是访问 person 的 getName() 方法

### 变量赋值

可以将以下六种数据类型赋给一个 Velocity 变量

- 变量引用 
- 字面字符串
- 属性引用
- 方法引用
- 字面数字
- 数组列表

```velocity
#set($foo = $bar)
#set($foo =“hello”)
#set($foo.name = $bar.name)
#set($foo.name = $bar.getName($arg))
#set($foo = 123)
#set($foo = [“foo”,$bar])
```

### 循环使用

Velocity 引擎会将 list 中的值循环赋给 element 变量，同时会创建一个$velocityCount 的变量作为计数，从 1 开始，每次循环都会加 1.

```velocity
#foreach($element in $list)
 This is $element
 $velocityCount
#end
```

### 条件语句的语法

```velocity
#if(condition)
...
#elseif(condition)
…
#else
…
#end
```

### 关系操作符

Velocity 引擎提供了 AND、OR 和 NOT 操作符，分别对应&&、||和! 例如：

```velocity
#if($foo && $bar)
#end
```

### 宏的定义与使用

```velocity
// 这里的参数之间使用空格隔开
#macro(macroName arg1 arg2 …)
...
#end
```

调用这个宏的语法是：

```velocity
#macroName(arg1 arg2 …)
```

使用 Velocity 宏的例子：

```velocity
#macro(sayHello $name)
hello $name 
#end
#sayHello(“velocity”)
// 输出的结果为 hello velocity
```

### \#parse 和 #include

```velocity
#parse(“foo.vm”)
// 输出结果为：velocity
    
#include(“foo.vm”)
// 输出结果为：#set($name =“velocity”)
```

