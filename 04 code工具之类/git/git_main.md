### 在Windows上安装Git

下载地址： https://gitforwindows.org/ 

安装完成后输入以下命令用以标识自己所使用的机器：

{{c1::

```git
git config --global user.name "xieyun"
git config --global user.email "136412052@qq.com"
```

}}

### 初始化一个版本库

在想要创建版本库的文件夹下输入以下命令：

{{c1::

```shell
git init
```

}}

### 把一个文件放到Git仓库需要两步：

{{c1::

1. 第一步：用`git add`将文件提交到暂存区。

   ```shell
   git add readme.txt
   ```

2. 第二步：用`git commit`将文件提交仓库。

   ```shell 
   git commit -m "wrote a readme file"
   ```



}}

### Git常见操作

```shell
# 查看工作区状态
{{c1:: git status }}
# 对比文件差异
{{c2:: git diff }}
# 查看版本历史
{{c4:: git log }}
# 以行为单位查看版本历史
{{c5:: git log --pretty=oneline}}
```

### 关于Git `warning：LF will be replaced by CRLF in readme.txt`问题的原因

首先问题出{{c1:: 在不同操作系统所使用的换行符是不一样的。}}

`Uinx/Linux`采用换行符LF表示下一行{{c1:: （`LF：LineFeed`，中文意思是换行）；}}

Dos和Windows采用回车+换行CRLF表示下一行{{c2:: （`CRLF：CarriageReturn LineFeed`，中文意思是回车换行）；}}

Mac OS采用回车CR表示下一行{{c3:: （`CR：CarriageReturn`，中文意思是回车）。}}

### 在Git中，可以通过以下命令来显示当前你的Git中采取哪种对待换行符的方式

```shell
$ {{c1::  git config core.autocrlf }}
```

此命令会有三个输出，“true”，“false”或者“input”

为true时:{{c1:: Git会将你add的所有文件视为文本文件，将结尾的CRLF转换为LF，而checkout时会再将文件的LF格式转为CRLF格式。}}

为false时:{{c1:: line endings不做任何改变，文本文件保持其原来的样子。}}

为input时:{{c1:: add时Git会把CRLF转换为LF，而check时仍旧为LF，所以Windows操作系统不建议设置此值。}}

当 `core autocrlf`为true时，**还有一个需要慎重的地方**，{{c2::当你上传一个二进制文件，Git可能会将二进制文件误以为是文本文件，从而也会修改你的二进制文件，从而产生隐患。}}

### `git log`命令

- `git log`:以列表的方式查看当前版本库的历史纪录
- `git log --pretty=oneline `:以行的方式查看当前版本库的历史纪录

### GIT的commit id（版本号）含义

{{c1:: 

Git是分布式的系统，为了避免与其他人的版本冲突，GIT 的commit id（版本号）是由SHA1计算出的一串很大的16进制数。

}}

### Git版本回退

```shell
# 回退到上一个版本
{{c1:: git reset --hard HEAD^ }}
# 回退到前20版本
{{c1:: git reset --hard HEAD~20 }}
# 使用commit id（版本号）回退到指定的版本
{{c1:: git reset --hard 3628164 }}
# 查询历史命令记录
{{c1:: git reflog }}
```

### Git的一些名词解释:

- 工作区：{{c1::当前项目中能看见的目录。}}
- 版本库：{{c1::.git是Git的版本库，不算工作区。}}
- 暂存区：{{c1::保存还没有提交到创库的修改。}}

### 管理修改

```shell
# 对比工作区和版本库中最新版本的区别
{{c1:: git diff HEAD -- readme.txt }}
# 让文件回到最近一次git commit或git add时的状态
{{c2:: git checkout -- readme.txt}}
# 将暂存区的修改撤消掉
{{c3:: git reset HEAD readme.txt }}
```

### 撤销修改的3种场景

场景1：当你改乱了工作区某个文件的内容，想直接丢弃工作区的修改时，用命令{{c3:: `git checkout -- file`。}}

场景2：当你不但改乱了工作区某个文件的内容，还添加到了暂存区时，想丢弃修改，分两步，第一步用命令{{c3:: `git reset HEAD `，}}就回到了场景1，第二步按场景1操作。

场景3：已经提交了不合适的修改到版本库时，想要撤销本次提交，{{c3::`git reset HEAD^`}}，不过前提是没有推送到远程库。

