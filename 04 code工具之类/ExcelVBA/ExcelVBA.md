### Excel中一个工程最多可以包含四类对象？

![image-20200110150316613](C:%5Cnote%5CcodeNote%5C04%20code%E5%B7%A5%E5%85%B7%E4%B9%8B%E7%B1%BB%5CExcelVBA%5CExcelVBA.assets%5Cimage-20200110150316613.png)

### VBA中的注释用两种方法表示，它们分别如下 -

- 以单引号(`'`)开头的语句都被视为注释
- 以关键字`"REM"`开头的语句

### VBA中`MsgBox`函数

```vb
MsgBox(prompt[,buttons][,title][,helpfile,context])
```

参数说明

- `prompt` - 必需的参数。在对话框中显示为消息的字符串。提示的最大长度大约为`1024`个字符。 如果消息扩展为多行，则可以使用每行之间的回车符(`Chr(13)`)或换行符(`Chr(10)`)来分隔行。
- `buttons` - 可选参数。一个数字表达式，指定要显示的按钮的类型，要使用的图标样式，默认按钮的标识以及消息框的形式。如果留空，则按钮的默认值为`0`。
- `title` - 可选参数。 显示在对话框的标题栏中的字符串表达式。 如果标题留空，应用程序名称将被放置在标题栏中。
- `helpfile` - 可选参数。一个字符串表达式，标识用于为对话框提供上下文相关帮助的帮助文件。
- `Context` - 可选参数。一个数字表达式，用于标识由帮助作者分配给相应帮助主题的帮助上下文编号。 如果提供上下文，则还必须提供`helpfile`。

`Buttons` 参数可以使用以下任何值 -

- `0 vbOKOnly ` - 仅显示`“确定”` 按钮。
- `1 vbOKCancel ` - 显示`“确定”` 和`“取消”` 按钮。
- `2 vbAbortRetryIgnore ` - 显示`“中止”`，`“重试”`和`“忽略”` 按钮。
- `3 vbYesNoCancel ` - 显示`“是”`，`“否”`和`“取消”` 按钮。
- `4 vbYesNo ` - 显示`“是”`和`“否”`按钮。
- `5 vbRetryCancel ` - 显示`“重试”`和`“取消”`按钮。
- `16 vbCritical ` - 显示严重消息图标。
- `32 vbQuestion ` - 显示警告查询图标。
- `48 vbExclamation ` - 显示警告消息图标。
- `64 vbInformation ` - 显示信息消息图标。
- `0 vbDefaultButton1 ` - 第一个按钮是默认的。
- `256 vbDefaultButton2` - 第二个按钮是默认的。
- `512 vbDefaultButton3` - 第三个按钮是默认的。
- `768 vbDefaultButton4` - 第四个按钮是默认的。
- `0 vbApplicationModal` 应用程序模式 - 当前的应用程序将不会工作，直到用户响应消息框。
- `4096 vbSystemModal` 系统模式 - 所有的应用程序将不会工作，直到用户响应消息框。

//原文出自【易百教程】，商业转载请联系作者获得授权，非商业转载请保留原文链接：https://www.yiibai.com/vba/vba_message_box.html#article-start 

上述值在逻辑上分为四组：

- 第一组(`0`至`5`)指示要在消息框中显示的按钮。
- 第二组(`16`,`32`,`48`,`64`)描述要显示的图标的样式
- 第三组(`0`,`256`,`512`,`768`)指示哪个按钮必须是默认的
- 第四组(`0`,`4096` )确定消息框的形式。

### `MsgBox`函数可以返回以下值之一，可用于标识用户在消息框中单击的按钮。

-  `vbOK ` -  `确定 ` 按钮被点击。
-  `vbCancel ` -  `取消 ` 按钮被点击。
-  `vbAbort ` -  `中止 ` 按钮被点击。
-  `vbIgnore ` -  `忽略 ` 按钮被点击。
-  `vbYes ` -  `是 ` 按钮被点击。
-  `vbNo ` -  `否 ` 按钮被点击。

> 问题：`MsgBox`各个返回值对应的整数是什么？

### VBA中`InputBox`函数

```vb
InputBox(prompt[,title][,default][,xpos][,ypos][,helpfile,context])
```

-  `Prompt ` - 必需的参数。 在对话框中显示为消息的字符串。提示的最大长度大约为`1024`个字符。 如果消息扩展为多行，则可以使用每行之间的回车符(`Chr(13)`)或换行符(`Chr(10)`)来分隔行。
-  `title ` - 一个可选参数。显示在对话框的标题栏中的字符串表达式。如果标题留空，应用程序名称将被放置在标题栏中。
-  `default ` - 一个可选参数。用户希望显示的文本框中的默认文本。
-  `xpos ` - 一个可选参数。`X`轴的位置表示水平从屏幕左侧的提示距离。 如果留空，则输入框水平居中。
-  `ypos ` - 一个可选参数。`Y`轴的位置表示竖直方向从屏幕左侧的提示距离。如果留空，则输入框垂直居中。
-  `helpfile ` - 一个可选参数。一个字符串表达式，标识用于为对话框提供上下文相关帮助的帮助文件。 
-  `context ` - 一个可选参数。一个数字表达式，用于标识由帮助作者分配给相应帮助主题的帮助上下文编号。如果提供上下文，则还必须提供`helpfile`。

### 变量声明

```VB
Dim <<variable_name>> As <<variable_type>>
```

### VBA中的数据类型

### VBA数字数据类型

| 编号 | 数字类型   | 范围值                                                       |
| ---- | ---------- | ------------------------------------------------------------ |
| 1    | `Byte`     | 0 ~ 255                                                      |
| 2    | `Integer`  | -32,768 ~ 32,767                                             |
| 3    | `Long`     | -2,147,483,648 ~ 2,147,483,648                               |
| 4    | `Single`   | 负值：`-3.402823E+38 ~ -1.401298E-45`，正值： `1.401298E-45 ~ 3.402823E+38` |
| 5    | `Double`   | 负值：`-1.79769313486232e+308 ~ -4.94065645841247E-324`，正值： `4.94065645841247E-324 ~ 1.79769313486232e+308` |
| 6    | `Currency` | -922,337,203,685,477.5808 ~ 922,337,203,685,477.5807         |
| 7    | `Decimal`  | 如果不使用小数，则为`+/- 79,228,162,514,264,337,593,543,950,335`；如果使用小数，则为：`+/- 7.9228162514264337593543950335` |

###  VBA非数字数据类型

下表显示了非数字数据类型和允许的值范围。

| 编号 | 数字类型            | 范围值                      |
| ---- | ------------------- | --------------------------- |
| 1    | 固定长度：`String`  | 1 ~ 65,400个字符            |
| 2    | 可变长度：`String`  | 0到20亿字符                 |
| 3    | `Date`              | 100年1月1日至9999年12月31日 |
| 4    | `Boolean`           | `True` / `False`            |
| 5    | `Object`            | 任何嵌入的对象              |
| 6    | `Variant (numeric)` | 任何大到double的数字值      |
| 7    | `Variant (text)`    | 与可变长度的`string`一样    |

### 常量声明

```vb
Const <<constant_name>> As <<constant_type>> = <<constant_value>>
```

### VBA支持的2种连接运算符

假设变量`A=5`，变量`B=10`，则 -

| 运算符 | 描述                                            | 示例          |
| ------ | ----------------------------------------------- | ------------- |
| `+`    | 将两个值添加为变量，数字输出总和2，字符串为拼接 | `A + B = 15`  |
| `&`    | 连接两个值                                      | `A & B = 510` |

### `IF`语句示例

```vb
Private Sub nested_if_demo_Click()
   Dim a As Integer
   a = 12
   If a > 0 Then
      MsgBox ("The Number is a POSITIVE Number")

      If a = 1 Then
         MsgBox ("The Number is Neither Prime NOR Composite")
      ElseIf a = 2 Then
         MsgBox ("The Number is the Only Even Prime Number")
      ElseIf a = 3 Then
         MsgBox ("The Number is the Least Odd Prime Number")
      Else
         MsgBox ("The Number is NOT 0,1,2 or 3")
      End If
   ElseIf a < 0 Then
      MsgBox ("The Number is a NEGATIVE Number")
   Else
      MsgBox ("The Number is ZERO")
   End If
End Sub
```

### `Switch`语句示例

```vb
Private Sub switch_demo_Click()
   Dim MyVar As Integer
   MyVar = 1

   Select Case MyVar
      Case 1
         MsgBox "The Number is the Least Composite Number"
      Case 2
         MsgBox "The Number is the only Even Prime Number"
      Case 3
         MsgBox "The Number is the Least Odd Prime Number"
      Case Else
         MsgBox "Unknown Number"
   End Select
End Sub
```

### `for`循环示例

```vb
Private Sub Constant_demo_Click()
   Dim a As Integer
   a = 10

   For i = 0 To a Step 2
      MsgBox ("The value is i is : " & i)
   Next
End Sub
```

### `for…each`循环示例

```vb
Private Sub Constant_demo_Click()  
   'fruits is an array
   fruits = Array("苹果", "橙子", "樱桃")
   Dim fruitnames As Variant

   'iterating using For each loop.
   For Each Item In fruits
      fruitnames = fruitnames & Item & Chr(10)
   Next

   MsgBox fruitnames-
End Sub
Vb
```

### `while…wend`循环示例

```vb
Private Sub Constant_demo_Click()
   Dim Counter :  Counter = 10   

   While Counter < 15     ' Test value of Counter.
      Counter = Counter + 1   ' Increment Counter.
      msgbox "The Current Value of the Counter is : " & Counter
   Wend   ' While loop exits if Counter Value becomes 15.
End Sub
```

### `do…while`循环

```vb
Private Sub Constant_demo_Click() 
   i = 10
   Do
      i = i + 1
      MsgBox "The value of i is : " & i
   Loop While i < 3 'Condition is false.Hence loop is executed once.
End Sub
```

### `Exit For`语句的示例

```vb
Private Sub Constant_demo_Click()
   Dim a As Integer
   a = 10

   For i = 0 To a Step 2 'i is the counter variable and it is incremented by 2
      MsgBox ("The value is i is : " & i)
      If i = 4 Then
         i = i * 10 'This is executed only if i=4
         MsgBox ("The value is i is : " & i)
         Exit For 'Exited when i=4
      End If
   Next
End Sub
```

## `Exit Do`语句的示例

以下示例演示如何使用`Exit Do`语句，如果计数器的值达到`10`，则退出`Do`循环，并在`For`循环之后立即跳转到下一个语句。

```vb
Private Sub Constant_demo_Click()
   i = 0
   Do While i <= 100
      If i > 10 Then
         Exit Do   ' Loop Exits if i>10
      End If
      MsgBox ("The Value of i is : " & i)
      i = i + 2
   Loop
End Sub
```

### VBA数组声明

```vb
'Method 1 : Using Dim
Dim arr1()    'Without Size

'Method 2 : Mentioning the Size
Dim arr2(5)  'Declared with size of 5

'Method 3 : using 'Array' Parameter
Dim arr3
arr3 = Array("apple","Orange","Grapes")


Private Sub Constant_demo_Click()
   Dim arr(5)
   arr(0) = "1"           'Number as String
   arr(1) = "VBScript"    'String
   arr(2) = 100            'Number
   arr(3) = 2.45            'Decimal Number
   arr(4) = #10/07/2013#  'Date
   arr(5) = #12.45 PM#    'Time

   msgbox("Value stored in Array index 0 : " & arr(0))
   msgbox("Value stored in Array index 1 : " & arr(1))
   msgbox("Value stored in Array index 2 : " & arr(2))
   msgbox("Value stored in Array index 3 : " & arr(3))
   msgbox("Value stored in Array index 4 : " & arr(4))
   msgbox("Value stored in Array index 5 : " & arr(5))
End Sub
```

我们都知道，一个变量是一个存储值的容器。 有时，开发人员希望一次可以在一个变量中保存多个值。 当一系列值存储在单个变量中时，则称为数组变量。

## 数组声明

数组声明的方式与声明变量相同，只是数组变量的声明使用括号。 在下面的例子中，括号里提到了数组的大小。参考以下示例 - 

```vb
'Method 1 : Using Dim
Dim arr1()    'Without Size

'Method 2 : Mentioning the Size
Dim arr2(5)  'Declared with size of 5

'Method 3 : using 'Array' Parameter
Dim arr3
arr3 = Array("apple","Orange","Grapes")
Vb
```

在上面代码中，

- 虽然数组大小被指定为`5`，但是当数组索引从零开始时，它可以保持`6`个值。
- 数组索引不能是负数。
- VBScript数组可以在数组中存储任何类型的变量。因此，一个数组可以在一个数组变量中存储一个整数，字符串或字符。

## 赋值给数组

通过为每个要分配的值指定一个数组索引值，将这些值分配给数组。它可以是一个字符串。

#### **例子**

添加一个模块并添加以下代码 - 

```vb
Private Sub Constant_demo_Click()
   Dim arr(5)
   arr(0) = "1"           'Number as String
   arr(1) = "VBScript"    'String
   arr(2) = 100            'Number
   arr(3) = 2.45            'Decimal Number
   arr(4) = #10/07/2013#  'Date
   arr(5) = #12.45 PM#    'Time

   msgbox("Value stored in Array index 0 : " & arr(0))
   msgbox("Value stored in Array index 1 : " & arr(1))
   msgbox("Value stored in Array index 2 : " & arr(2))
   msgbox("Value stored in Array index 3 : " & arr(3))
   msgbox("Value stored in Array index 4 : " & arr(4))
   msgbox("Value stored in Array index 5 : " & arr(5))
End Sub
Vb
```

当执行上面的函数时，它会产生下面的输出。

```shell
Value stored in Array index 0 : 1
Value stored in Array index 1 : VBScript
Value stored in Array index 2 : 100
Value stored in Array index 3 : 2.45
Value stored in Array index 4 : 7/10/2013
Value stored in Array index 5 : 12:45:00 PM
Shell
```

### 多维数组

```vb
Private Sub Constant_demo_Click()
   Dim arr(2,3) as Variant    ' Which has 3 rows and 4 columns
   arr(0,0) = "Apple" 
   arr(0,1) = "Orange"
   arr(0,2) = "Grapes"           
   arr(0,3) = "pineapple" 
   arr(1,0) = "cucumber"           
   arr(1,1) = "beans"           
   arr(1,2) = "carrot"           
   arr(1,3) = "tomato"           
   arr(2,0) = "potato"             
   arr(2,1) = "sandwitch"            
   arr(2,2) = "coffee"             
   arr(2,3) = "nuts"            

   msgbox("Value in Array index 0,1 : " &  arr(0,1))
   msgbox("Value in Array index 2,2 : " &  arr(2,2))
End Sub
```

### ReDim语句

`ReDim`语句用于声明动态数组变量并分配或重新分配存储空间。

```vb
Private Sub Constant_demo_Click()
   Dim a() as variant
   i = 0
   redim a(5)
   a(0) = "XYZ"
   a(1) = 41.25
   a(2) = 22

   REDIM PRESERVE a(7)
   For i = 3 to 7
   a(i) = i
   Next

   'to Fetch the output
   For i = 0 to ubound(a)
      Msgbox a(i)
   Next
End Sub
```

### 数组函数

BScript中有各种内置函数，可以帮助开发人员有效地处理数组。 下面列出了与数组一起使用的所有方法。请点击方法名称来详细了解它们如何应用。

| 编号 | 方法                                                         | 描述                                                         |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | [LBound](http://www.yiibai.com/vba/vba_lbound_function.html) | 它返回一个整数，对应于给定数组的最小下标。                   |
| 2    | [UBound](http://www.yiibai.com/vba/vba_ubound_function.html) | 它返回一个整数，对应于给定数组的最大下标。                   |
| 3    | [Split](http://www.yiibai.com/vba/vba_split_function.html)   | 它返回一个包含指定数量值的数组。根据分隔符分割。             |
| 4    | [Join](http://www.yiibai.com/vba/vba_join_function.html)     | 它返回一个包含数组中指定数量的子串的字符串。这是`Split`方法的一个完全相反的功能。 |
| 5    | [Filter](http://www.yiibai.com/vba/vba_filter_function.html) | 它返回一个基于零的数组，该数组包含基于特定过滤条件的字符串数组的子集。 |
| 6    | [IsArray](http://www.yiibai.com/vba/vba_isarray_function.html) | 它返回一个布尔值，表示输入变量是否是一个数组。               |
| 7    | [Erase](http://www.yiibai.com/vba/vba_erase_function.html)   | 为数组变量恢复分配的内存。                                   |

### Erase()函数

```vb
Erase ArrayName
```

- 固定数值数组，数组中的每个元素重置为零。
- 固定字符串数组，数组中的每个元素被重置为零长度`""`。
- 对象数组，数组中的每个元素被重置为特殊值`Nothing`。

### VBA函数声明的例子

```vb
Function findArea(Length As Double, Optional Width As Variant)
   If IsMissing(Width) Then
      findArea = Length * Length
   Else
      findArea = Length * Width
   End If
End Function
```

### 子程序(*Sub Procedures*，也叫子过程)与函数类似，但有一些差异

- 子过程不需要有返回一个值，而函数可能会或可能不会有返回一个值。

- 子程序可以不用`call`关键字来调用。

- 子程序总是包含在`Sub`和`End Sub`语句中。

- 函数语法示例：
	```vb
Sub Area(x As Double, y As Double)
   MsgBox x * y
End Sub
	```
	
- 调用子过程示例：

  ```vb
  Function findArea(Length As Double, Width As Variant)
     area Length, Width    ' To Calculate Area 'area' sub proc is called
  End Function
  ```

  

