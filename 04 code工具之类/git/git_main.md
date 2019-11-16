### 关于Git `warning：LF will be replaced by CRLF in readme.txt`问题的原因

首先问题出在不同操作系统所使用的换行符是不一样的，下面罗列一下三大主流操作系统的换行符：

`Uinx/Linux`采用换行符LF表示下一行（`LF：LineFeed`，中文意思是换行）；

Dos和Windows采用回车+换行CRLF表示下一行（`CRLF：CarriageReturn LineFeed`，中文意思是回车换行）；

Mac OS采用回车CR表示下一行（`CR：CarriageReturn`，中文意思是回车）。

### 在Git中，可以通过以下命令来显示当前你的Git中采取哪种对待换行符的方式

```shell
$ git config core.autocrlf
```

此命令会有三个输出，“true”，“false”或者“input”

为true时:Git会将你add的所有文件视为文本文件，将结尾的CRLF转换为LF，而checkout时会再将文件的LF格式转为CRLF格式。

为false时:line endings不做任何改变，文本文件保持其原来的样子。

为input时:add时Git会把CRLF转换为LF，而check时仍旧为LF，所以Windows操作系统不建议设置此值。

**解决办法：**

将`core.autocrlf`设为false即可解决这个问题，如果你和你的伙伴只工作于Windows平台或者Linux平台，那么没问题，不过如果是存在跨平台的现象的话，还是需要考虑一下。

当 `core autocrlf`为true时，**还有一个需要慎重的地方**，当你上传一个二进制文件，Git可能会将二进制文件误以为是文本文件，从而也会修改你的二进制文件，从而产生隐患。

### `git log`命令

- `git log`:以列表的方式查看当前版本库的历史纪录
- `git log --pretty=oneline `:以行的方式查看当前版本库的历史纪录

### GIT的commit id（版本号）含义

