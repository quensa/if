# CSS

## 什么是CSS

- Cascading Style Sheet层叠级联样式表

- CSS：表现（美化网页）

- 字体，颜色，边距，高度，宽度，背景图片，网页定位，网页浮动。。。


## 发展史

- 1.0
- 2.0 DIV（块）+CSS，HTML与CSS结构分离的思想，网页变得简单，SEO（搜索引擎优化）
- 2.1 浮动、定位

- 3.0 圆角，阴影，动画…浏览器兼容性~

## CSS的快速入门及优势

第一个css程序

html部分

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--  规范，style标签，css样式代码可以写在这里,每一个声明最好使用分号结尾
      语法：
        选择器{
            声明1;
            声明2;
            声明3;
        }
      -->
<!--  第一种写css代码的方式  -->
<!--    <style>-->
<!--        h1{-->
<!--            color: red;-->
<!--        }-->
<!--    </style>-->
<!--  第二种导入css样式文件  -->
    <link rel="stylesheet" href="./css/style.css">

</head>
<body>


<h1>我是标题</h1>

</body>
</html>
```

CSS部分：

```CSS
h1{
    color: red;
}
```

==**建议使用导入css样式文件的方式**==

## **CSS优势**

1. 内容和表现分离
2. 网页结构表现统一，可以实现复用
3. 样式十分丰富
4. 建议使用独立于HTML的CSS的文件
5. 利用SEO，容易被搜索引擎收录！

## 三种CSS导入方式

**html部分**

​    ==**css导入常用这种分离方式较好<link rel="stylesheet" href（目录）="./css/style.css">**==

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--  1.内部样式  -->
    <style>
        h1 {
            color: green;
        }
    </style>
    
    <!-- 2.导入式
    <style>
        @import url("css/style.css")
    </style>
    -->
    
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>

<!--优先级：就近原则，哪一个离标签元素近则应用哪一个样式
(可以理解为覆盖原则下面的覆盖上面的！)
-->

<!--3.行内样式，在标签元素中编写一个style属性，编写样式即可-->
<h1 style="color: red"></h1>

</body>
</html>
```

css部分

```css
/*外部样式*/
h1{
    color: yellow;
}
```

**外部样式的两种写法**

- 链接式
- 导入式

```html
<!--外部样式
链接式
-->
<link rel="stylesheet" href="css/style.css">

<!--导入式 
@import是CSS2.1特有的！
导入式的缺点：会先导入样式再导入表现
-->
<style>
    @import url("css/style.css");
</style>

```

![img](https://img-blog.csdnimg.cn/img_convert/9a82564b90fd070ed6057463296d860f.png)

## 三种基本选择器（重要）

作用：选择页面上的某一个或某一种元素

==三个选择器分别实际上就是一类一些一个的区别==

**基本选择器**

1、标签选择器：选择一类标签 标签{}

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        /*标签选择器，会选择到页面上所有的这个标签元素*/
        h1{
            color: green;
            background: #6ab80b;
            border-radius: 24px;
        }
        p{
            font-size: 80px;
        }
    </style>

</head>
<body>

<h1>学java</h1>
<h1>学java</h1>

<p>狂神说</p>

</body>
</html>
```

2、类选择器 class：选择所有class属性一致的标签，跨标签 .类名{}

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        /*类选择器的格式 .class的名称{}
        好处，可以多个标签归类，是同一个class，可以复用
        */
        .zhang{
            color: #d90cd9;
        }
        .li{
            color: #6ab80b;
        }
    </style>

</head>
<body>

<h1 class="zhang">标题1</h1>
<h1 class="li">标题2</h1>
<h1 class="zhang">标题3</h1>

<p class="zhang">p标签</p>

</body>
</html>

```

3、id选择器：全局唯一 #id名{}

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        /*id选择器： id必须保证全局唯一
        #id名称{}
        优先级：
        不遵循就近原则，固定的
        id选择器>class选择器>标签选择器
        */
        .style1{
            color: #6ab80b;
        }
        #zhang{
            color: #d90cd9;
        }
        h1{
            color: #675231;
        }

    </style>

</head>
<body>

<h1 class="style1" id="zhang">标题1</h1>
<h1 class="style1">标题2</h1>
<h1 class="style1">标题3</h1>
<h1>标题4</h1>
<h1>标题5</h1>

</body>
</html>
```

优先级：id>class>标签

## 层次选择器（了解）

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        /*p{*/
        /*    background: #02ff00;*/
        /*}*/

        /*  后代选择器  */
        /*body p {*/
        /*    background: red;*/
        /*}*/
        /*  子选择器  */
        /*body>p{*/
        /*    background: #3cbda6;*/
        /*}*/
        /*相邻兄弟选择器 :只有一个，相邻（向下）*/
        /*.active + p{*/
        /*    background: #a13d30;*/
        /*}*/
        /*  通用兄弟选择器:  当前选中元素的向下所有兄弟元素  */
        .active~p{
            background: #02ff00;
        }
    </style>

</head>
<body>

<p>p0</p>
<p class="active">p1</p>
<p>p2</p>
<p>p3</p>
<ul>
    <li>
        <p>p4</p>
    </li>
    <li>
        <p>p5</p>
    </li>
    <li>
        <p>p6</p>
    </li>
</ul>

<p class="active">p7</p>
<p>p8</p>

</body>
</html>

```

1、后代选择器：在某个元素的后面 祖爷爷 爷爷 爸爸 你

```html
 body p{
            background: red;
        }
```

2、子选择器，一代，儿子

```css
 body>p{
            background: #1f4794;
        }
```

3、相邻兄弟选择器(一个弟弟选择器) 同辈

```css
 */
        /*相邻兄弟选择器   只有一个，向下衍生*/
       /* .active + p{
            background: #8fd4fc;
        }
        */
```

4、通用选择器(多个弟弟选择器)

```css
 /*通用兄弟选择器   当前选中元素向下的所有兄弟元素*/
        .active~p{
            background: #675231;
        }

```

## 结构伪类选择器

**伪类(带有冒号)：==常用第四种nth-of-type==**

```css
/*ul的第一个子元素*/
ul li：first-child{
    background:#02ff00;
}
/*ul的最后一个子元素*/
ul li：last-child{
    background:#ff4832;
}
/* 选中p1：定位到父级元素，选择当前的第一个元素
选择当前p元素的父级元素，选中父级元素的第一个，并且是当前元素才生效！，顺序
*/
p:nth-child(2){
    background:#2700ff;
}
/*选中父元素，下的p元素的第二个，类型*/
p:nth-of-type(1){
    background:yellow;
}
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--  避免使用，class，id选择器  -->
    <style>
        /*ul的第一个子元素*/
        ul li:first-child{
            background: #02ff00;
        }
        /*ul的最后一个子元素*/
        ul li:last-child{
            background: #ff4832;
        }
        /* 选中p1：定位到父级元素，选择当前的第一个元素
        选择当前p元素的父级元素，选中父级元素的第一个，并且是当前元素才生效！，顺序
        */
        p:nth-child(1){
            background: #2700ff;
        }
        /*选中父元素，下的p元素的第二个，类型*/
        p:nth-of-type(1){
            background:yellow;
        }
        a:hover{
            background: yellow;
        }
    </style>

</head>
<body>

<a href="">dadioha</a>
<p>p1</p>
<p>p2</p>
<p>p3</p>
<ul>
    <li>li1</li>
    <li>li2</li>
    <li>li3</li>
</ul>

</body>
</html>
```

## 属性选择器（最重要，最常用）

```java
 //正则表达式  		
		=绝对等于
        *=包含这个元素
        ^=以这个开头
        $=以这个结尾
```

==id+class结合==		==a（标签）+[  ]+{ }==

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        .demo a{
            float:left;
            display:block;
            height:50px;
            width:50px;
            border-radius:10px;
            background:#2700ff;
            text-align:center;
            color:gainsboro;
            text-decoration:none;
            margin-right:5px;
            font:bold 20px/50px Arial;
        }
        /*属性名，属性名=属性值（可以使用正则表达式）
        =绝对等于
        *=包含这个元素
        ^=以这个开头
        $=以这个结尾
        */
        /*存在id属性的元素		a[]{}
            a[id]{
                background:yellow;
            }
        id=first的元素
            a[id=first]{
                background：#63ff23
            }
        class中有links的元素
            a[class/*="links"]{
                background:yellow;
            }
        选中href中以http开头的元素
            a[href^=http]{
                background:yellow;
            }
        */
        a[href$=jpg]{
            background:yellow;
        }
    </style>
</head>
<body>
<p class="demo">
    <a href="http://www.baidu.com" class="links item first" id="first">1</a>
    <a href="http://blog.kuangstudy.com" class="links item active" target="_blank" title="test">2</a>
    <a href="images/123.html" class="links item">3</a>
    <a href="images/123.png" class="links item">4</a>
    <a href="images/123.jpg" class="links item">5</a>
    <a href="abc" class="links item">6</a>
    <a href="/a.pdf" class="links item">7</a>
    <a href="/abc.pdf" class="links item">8</a>
    <a href="abc.doc" class="links item">9</a>
    <a href="abcd.doc" class="links item last">10</a>
</p>
</body>
</html>

```

## CSS的作用及字体样式

 **CSS作用：**

1. 有效的传递页面信息
2. 美化网页，页面漂亮，才能吸引用户
3. 凸显页面的主题
4. 提高用户的体验

**字体样式**

**span标签：重点要突出的字，使用span套起来,然后可以加属性方便定位**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        #title1{
            font-size: 50px;
        }
    </style>

</head>
<body>

欢迎学习<span id="title1">JAVA</span>

</body>
</html>
```

字体样式：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--
font-family:字体
font-size:字体大小
font-weight:字体粗细
color:字体颜色
-->
    <style>
        body{
            font-family:"Arial Black",楷体;
            color:#a13d30;
        }
        h1{
            font-size:50px;
        }
        .p1{
            font-weight:bolder;
        }
    </style>

</head>
<body>

<h1>故事介绍</h1>
<p class="p1">
    魁拔1331年，朴心的女儿镜心出任天界魁拔司主神。她虽然成功将第五代魁拔剿杀于萌芽状态，但却没能于1664年成功剿杀第六代魁拔。第六代魁拔虽然以幼儿的形态幸存了下来，但却几乎完全失去了作为魁拔的记忆，被神圣兽国的青年蛮小满收养，取名蛮吉。父子二人都不知道蛮吉的真实身份。
</p>
<p>
    蛮小满是神圣兽国游尾郡窝窝乡的客住者，自从他来到窝窝乡之后，当地就接连不断地发生怪事（天灾人祸、桥断梁塌），再加上蛮小满生性好斗，接连不断地向村长发出比武挑战，令其成为村中众人的眼中钉。魁拔1672年，在侦测到魁拔的生命迹象之后，神圣联盟决定组织联军前往涡流岛讨伐魁拔。于是窝窝乡村长故意在比武中输给蛮小满，而后煽动其参加讨伐魁拔的联军。
</p>
<p>
    I have searched a thousand years,
    　 And I have cried a thousand tears.
    　 I found everything I need,
    　 You are everything to me.
</p>

</body>
</html>
```

==**重点记以下标签**==

```css
/*
font-family:字体
font-size:字体大小
font-weight:字体粗细
color:字体颜色
*/
body{
        font-family:"Arial Black",楷体;
        color:#a13d30;
    }
    h1{
        font-size:50px;
    }
    .p1{
        font-weight:bolder;
    }
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--  字体风格  -->
    <style>
        p {
            font: oblique bolder 12px "楷体";
        }
    </style>

</head>
<body>

<p>
    蛮小满是神圣兽国游尾郡窝窝乡的客住者，自从他来到窝窝乡之后，当地就接连不断地发生怪事（天灾人祸、桥断梁塌），再加上蛮小满生性好斗，接连不断地向村长发出比武挑战，令其成为村中众人的眼中钉。魁拔1672年，在侦测到魁拔的生命迹象之后，神圣联盟决定组织联军前往涡流岛讨伐魁拔。于是窝窝乡村长故意在比武中输给蛮小满，而后煽动其参加讨伐魁拔的联军。
</p>

</body>
</html>
```

**==字体（粗体或斜体）+粗细+大小+字体==**

==**这个是全部统一写  比较方便**==

```css
/*字体风格
oblique----斜体
*/
    p{
        font:oblique bolder 12px "楷体";
    }
```

## 文本样式

- 1、颜色：color：rgb，rgba
- **2、文本对齐的方式：text-align：center**

- **3、首行缩进：text-indent：2em**

- **4、行高（行间距）：line-height：**

- 5、装饰 ：text-decoration：

- **6、文本图片水平对齐：vertical-align：middle**

```css
/*超链接去下划线*/
a{
    text-decoration:none;
}

```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--
        颜色：
        	单词
        	RGB 0~F
        	RGBA A:0~1
        	rgb：red green black 0~F
            rgba：a表示透明度取值在0~1
        text-align:center;   排版，居中，
        text-indent:2em;	段落首行缩进
        height:300px;
        line-height:300px;
        	行高，和块的高度一致，就可以上下居中
    -->
    <style>
        h1{
            color:rgba(0,255,255,0.9);
            text-align:center;
        }
        .p1{
            text-indent:2em;
        }
        .p3{
            background:#2700ff;
            height:300px;
            line_height:300px;
        }
        /*下划线*/
        .l1{
            text-decoration:underline;
        }
        /*中划线*/
        .l2{
            text-decoration:line-through;
        }
        /*上划线*/
        .l3{
            text-decoration:overline;
        }
    </style>

</head>
<body>

<p class="l1">1231231</p>
<p class="l2">1231231</p>
<p class="l3">1231231</p>

<h1>故事介绍</h1>
<p class="p1">
    魁拔1331年，朴心的女儿镜心出任天界魁拔司主神。她虽然成功将第五代魁拔剿杀于萌芽状态，但却没能于1664年成功剿杀第六代魁拔。第六代魁拔虽然以幼儿的形态幸存了下来，但却几乎完全失去了作为魁拔的记忆，被神圣兽国的青年蛮小满收养，取名蛮吉。父子二人都不知道蛮吉的真实身份。
</p>
<p>
    蛮小满是神圣兽国游尾郡窝窝乡的客住者，自从他来到窝窝乡之后，当地就接连不断地发生怪事（天灾人祸、桥断梁塌），再加上蛮小满生性好斗，接连不断地向村长发出比武挑战，令其成为村中众人的眼中钉。魁拔1672年，在侦测到魁拔的生命迹象之后，神圣联盟决定组织联军前往涡流岛讨伐魁拔。于是窝窝乡村长故意在比武中输给蛮小满，而后煽动其参加讨伐魁拔的联军。
</p>
<p class="p3">
    I have searched a thousand years,
    　 And I have cried a thousand tears.
    　 I found everything I need,
    　 You are everything to me.
</p>

</body>
</html>

```

**图片和文字居中**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--
        水平对齐~	参照物，	a，b
    -->
    <style>
        img,span{
            vertical-align:middle;
        }
    </style>

</head>
<body>

<p>
    <img src="images/a.png" alt="">
    <span>adasdadafsdfsdfafasdfs</span>
</p>

</body>
</html>
```

## 文本阴影和超链接伪类

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        /*默认的颜色*/
        a{
            text-decoration: none;
            color: #000000;
        }
        /*鼠标悬浮的状态*/
        a:hover{
            color: orange;
            font-size: 50px;
        }
        /*鼠标按住未释放的状态*/
        a:active{
            color: green;
        }
        /*text-shadow:阴影颜色，水平偏移，垂直偏移，阴影半径*/
        #price{
            text-shadow:#3cc7f5 10px -10px 2px;
        }
    </style>

</head>
<body>

<a href="#">
    <img src="images/a.jpg" alt="">
</a>
<p>
    <a href="#">百度图片</a>
</p>
<p>
    <a href="#">下载本地</a>
</p>
<p id="price">
    链接:"*"
</p>

</body>
```

**文本阴影**

```css
/*text-shadow:阴影颜色，水平偏移，垂直偏移，阴影半径*/
#price{
    text-shadow:#3cc7f5 10px -10px 2px;
}
```

==**超链接伪类**==

**正常情况下只使用：a，a：hover**

![image-20211012184754241](https://img-blog.csdnimg.cn/img_convert/e9dabcaf312fba797d8d3e6bd24e49f2.png)

## 列表样式练习

**HTML部分**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="css/style.css" type="text/css">

</head>
<body>
<div id="nav">
    <h2 class="title">全部商品分类</h2>
    <ul>
        <li><a href="#">图书</a>&nbsp;&nbsp;<a href="#">音像</a>&nbsp;&nbsp;<a href="#">数字商品</a></li>
        <li><a href="#">家用电器</a>&nbsp;&nbsp;<a href="#">手机</a>&nbsp;&nbsp;<a href="#">数码</a></li>
        <li><a href="#">电脑</a>&nbsp;&nbsp;<a href="#">办公</a></li>
        <li><a href="#">家居</a>&nbsp;&nbsp;<a href="#">家装</a>&nbsp;&nbsp;<a href="#">厨具</a></li>
        <li><a href="#">服饰鞋帽</a>&nbsp;&nbsp;<a href="#">个护化妆</a></li>
        <li><a href="#">礼品箱包</a>&nbsp;&nbsp;<a href="#">钟表</a>&nbsp;&nbsp;<a href="#">珠宝</a></li>
        <li><a href="#">食品饮料</a>&nbsp;&nbsp;<a href="#">保健食品</a></li>
        <li><a href="#">彩票</a>&nbsp;&nbsp;<a href="#">旅行</a>&nbsp;&nbsp;<a href="#">充值</a>&nbsp;&nbsp;<a href="#">票务</a></li>
    </ul>
</div>


</body>
</html>
```

**CSS部分**

```css
#nav{
    width:300px;
    background:#a0a0a0;
}
.title{
    font-size:18px;
    font-weight:bold;
    text-indent:1em;
    line-height:35px;
    background:red;
}
/*ul li*/
/*
list-style:
	none	去掉圆点
	circle	空心圆
	decimal	数字
	square	正方形
*/
/*
ul{
background:#a0a0a0;
}
*/
ul li{
    height:30px;
    list-style:none;
    text-indent:1em;
}
a{
    text-decoration:none;
    font-size:14px;
    color:#000;
}
a:hover{
    color:orange;
    text-decoration:underline;
}
```

## 背景图像应用及渐变([(grabient.com)](https://www.grabient.com/))

**直接去该网站上提取渐变的css代码**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        div{
            width:1000px;
            height:700px;
            border:1px solid red;
            background-image:url("images/a.jpg");
            /*默认是全部平铺的* repeat/
        }
        .div1{
            /*水平平铺*/
            background-repeat:repeat-x;
        }
        .div2{
            /*垂直平铺*/
            background-repeat:repeat-y;
        }
        .div3{
            /*不平铺*/
            background-repeat:no-repeat;
        }
    </style>

</head>
<body>

<div class="div1"></div>
<div class="div2"></div>
<div class="div3"></div>

</body>
</html>

```

**背景图片列表应用**

将之前列表部分练习部分的css修改如下

```css
#nav{
    width:300px;
    background:#a0a0a0;
}
.title{
    font-size:18px;
    font-weight:bold;
    text-indent:1em;
    line-height:35px;
    /*颜色 图片 图片位置 平铺方式*/
    background:red url("../images/a.jpg") 270px 5px no-repeat;
}
/*ul li*/
/*
list-style:
	none	去掉圆点
	circle	空心圆
	decimal	数字
	square	正方形
*/
/*
ul{
background:#a0a0a0;
}
*/
ul li{
    height:30px;
    list-style:none;
    text-indent:1em;
    background-image: url("../images/a.jpg");
    background-repeat: no-repeat;
    background-position: 236px 2px;
}
a{
    text-decoration:none;
    font-size:14px;
    color:#000;
}
a:hover{
    color:orange;
    text-decoration:underline;
}
```

**渐变**

1、径向渐变

2、圆形渐变

```css
background-color:#FFFFFF;
background-image:linear-gradient(115deg,#FFFFFF 0%,#6284FF 50%,#FF0000 100%)
```

## 盒子模型及边框使用

![image-20211014154431235](https://img-blog.csdnimg.cn/img_convert/39b37da2d45b8491f1ed9860403437dd.png)

margin：外边距

padding：内边距

border：边框   		==**border:粗细，样式，颜色**==

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        /*body总有一个默认的外边距margin:0，常见操作就是一开始就把所有的内外边距都调为0*/
        /*h1,ul,li,a,body{*/
        /*margin:0;*/
        /*padding:0;*/
        /*text-decoration:none;*/
        /*}*/
        /*border:粗细，样式，颜色*/
        #box{
            width:300px;
            border:1px solid red;
        }
        h2{
            font-size:16px;
            background-color:#3cbda6;
            line-height:30px;
            color:white;
        }
        form{
            background:#3cbda6;
        }
        div:nth-of-type(1) input{
            /*solid实线*/
            border:3px solid black;
        }
        div:nth-of-type(2) input{
            /*dashed虚线*/
            border:3px dashed #4d0b8c;
        }
        div:nth-of-type(2) input{
            border:2px dashed #008c27;
        }
    </style>

</head>
<body>

<div id="box">
    <h2>会员登录</h2>
    <form action="#">
        <div>
            <span>用户名:</span>
            <input type="text">
        </div>
        <div>
            <span>密码:</span>
            <input type="password">
        </div>
        <div>
            <span>邮箱:</span>
            <input type="email">
        </div>
    </form>
</div>

</body>
</html>
```

## 内外边距及div居中

**使用外边距可以居中元素**（margin: 0 auto;）

**内外边距**

```html
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        /*border:粗细，样式，颜色*/
        /*margin可以居中元素
        margin: 0 auto;
        */
        #box{
            width:300px;
            border:1px solid red;
            margin: 0 auto;
        }
        /*
            顺时针旋转
            margin:0;
            margin:0 1px;
            margin:0 1px 2px 3px;
        */
        h2{
            font-size:16px;
            background-color:#3cbda6;
            line-height:30px;
            color:white;
            margin:0 1px 2px 3px;
        }
        form{
            background:#3cbda6;
        }
        div:nth-of-type(1){
            padding: 10px 2px;
        }
        input{
            border: 1px solid black;
        }
    </style>

</head>
<body>

<div id="box">
    <h2>会员登录</h2>
    <form action="#">
        <div>
            <span>用户名:</span>
            <input type="text">
        </div>
        <div>
            <span>密码:</span>
            <input type="password">
        </div>
        <div>
            <span>邮箱:</span>
            <input type="email">
        </div>
    </form>
</div>

</body>
</html>
```

**盒子的计算方式**：你这个元素到底多大？
==margin+border+padding+内容宽度==

## 圆角边框及阴影和经验分享

圆角边框

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--
        左上	右上	右下	左下，顺时针方向
    -->
    <!--
        圆圈：圆角=宽度
    -->
    <style>
        div{
            width:100px;
            height:100px;
            border:10px solid red;
            border-radius:50px 20px 10px 5px;
        }
    </style>

</head>
<body>

<div></div>

</body>
</html>

```

border-radius最多可以有四个参数

修改：圆圈： 圆角 = 半径！

扇形：

```html
<style>
    div{
        width:100px;
        height:50px;
        margin:30px;
        background:red;
        border-radius:50px 50px 0 0;
    }
</style>

```

**阴影**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

<!--  margin:0 auto;居中
  要求：块元素，块元素有固定的宽度
  -->
    <style>
        div{
            width: 100px;
            height: 100px;
            border: 10px solid red;
            box-shadow: 10px 10px 100px yellow;
        }
        img{
            border-radius: 50px;
            box-shadow: 10px 10px 100px yellow;
        }
    </style>

</head>
<body>
<div></div>

<div style="width: 500px;display: block;text-align: center">
    <img src="images/a.jpg" alt="">
</div>

</body>
</html>
```

## display和浮动

块级元素：独占一行

h1~h6	p	div		列表。。。。

行内元素：不独占一行

span	a	img	  strong。。。

行内元素可以被包含在块级元素中，反之，则不可以~

**display**

这个也是一种实现行内元素排列的方式，**但是我们很多情况都使用float**

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--
        block	块元素
        inline	行内元素
        inline-block	是块元素，但是可以内联，在一行！
        none
    -->
    <style>
        div{
            width:100px;
            height:100px;
            border:10px solid red;
            display:none;
        }
        span{
            width:100px;
            height:100px;
            border:10px solid red;
            display:inline-block;
        }
    </style>

</head>
<body>

<div>div块元素</div>
<span>span行内元素</span>

</body>
</html>

```

**浮动float**

左右浮动:

html部分

```HTML
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>浮动</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="father">
    <div class="layer01"><img src="images/1.jpg" alt=""/></div>
    <div class="layer02"><img src="images/2.jpg" alt=""/></div>
    <div class="layer03"><img src="images/3.jpg" alt=""/></div>
    <div class="layer04">
        浮动的盒子可以向左浮动，也可以向右浮动，直到它的外边缘碰到包含它的元素
    </div>
</div>
</body>
</html>

```

css部分

```CSS
div{
    margin:10px;
    padding:5px;
}
#father{
    border:1px #000 solid;
}
.layer01{
    border:1px #F00 dashed;
    display:inline-block;
    float:right;
}
.layer02{
    border:1px #00F dashed;
    display:inline-block;
    float:right;
}
.layer03{
    border:1px #060 dashed;
    display:inline-block;
    float:right;
}
.layer04{
    border:1px #666 dashed;
    font-size:12px;
    line-height:23px;
    display:inline-block;
    float:right;
}
```

## overflow及父级边框塌陷问题(笔试常问)

**父级边框塌陷问题**

clear

```CSS
/*
clear:right;右侧不允许又浮动元素
clear:left;左侧不允许又浮动元素
clear:both;两侧不允许又浮动元素
clear:none;
*/
.layer04{
    border:1px #666 dashed;
    font-size:12px;
    line-height:23px;
    display:inline-block;
    float:right;
    clear:both;
}

```

html

```HTML
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>浮动</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="father">
    <div class="layer01"><img src="images/1.jpg" alt=""/></div>
    <div class="layer02"><img src="images/2.jpg" alt=""/></div>
    <div class="layer03"><img src="images/3.jpg" alt=""/></div>
    <div class="layer04">
        浮动的盒子可以向左浮动，也可以向右浮动，直到它的外边缘碰到包含它的元素
    </div>
<!--<div class="clear"></div>-->
</div>
</body>
</html>

```

css

```CSS
div{
    margin:10px;
    padding:5px;
}
#father{
    /*方法一：增加父级元素的高度*/
    border:1px #000 solid;
    /*height:800px;*/
    /*方法三：在父级元素中添加一个overflow属性*/
    /*overflow: hidden;*/
}
/*方法四：父类添加一个伪类：after*/
/*father:after{
    content:'';
    display:block;
    clear:both;
}*/
.layer01{
    border:1px #F00 dashed;
    display:inline-block;
    float:right;
}
.layer02{
    border:1px #00F dashed;
    display:inline-block;
    float:right;
}
.layer03{
    border:1px #060 dashed;
    display:inline-block;
    float:right;
}
/*
clear:right;右侧不允许又浮动元素
clear:left;左侧不允许又浮动元素
clear:both;两侧不允许又浮动元素
clear:none;
*/
.layer04{
    border:1px #666 dashed;
    font-size:12px;
    line-height:23px;
    display:inline-block;
    float:right;
    clear:both;
}
/*方法二:在浮动元素后面增加一个空的div标签清除浮动*/
/*
.clear{
	clear:both;
	margin:0;
	padding:0;
}
*/

```

解决方案：

1、增加父级元素的高度

```css
#father{
    border:1px #000 solid;
    height:800px;
}
```


2、在浮动元素后面增加一个空的div标签清除浮动

```css
.clear{
	clear:both;
	margin:0;
	padding:0;
}
```

3、overflow

在父级元素中添加一个overflow属性

```css
#father{
    border:1px #000 solid;
    overflow:hidden;
```

**4、父类添加一个伪类：after(常用)**

```css
#father:after{
    content:'';
    display:block;
    clear:both;
}
```

**小结：**

- 1、浮动元素后面添加空的div

- 简单，代码中尽量避免空div

- 2、设置父元素的高度

- 简单，元素假设有了固定的高度就会被限制

- 3、overflow

- 简单，下拉的一些场景避免使用

- ==**4、父类添加一个伪类after(只在css中修改)**==
- ==**写法稍微复杂但是没有副作用（推荐使用）**==

对比display和float

- display

- 方向不可以控制

- float

- 浮动起来的话会脱离标准文档流，所以要解决父级边框塌陷的问题~


## 相对定位的使用及练习

**相对定位**

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!--  相对定位
      相对于自己原来的位置进行偏移~
      -->
    <style>
        body{
            padding: 20px;
        }
        div {
            margin: 10px;
            padding: 5px;
            font-size: 12px;
            line-height: 25px;
        }
        #father {
            border: 1px solid #666;
            padding: 0;
        }
        #first {
            background-color: #a13d30;
            border: 1px dashed #b27530;
            /*相对定位:上下左右*/
            position: relative;
            top: -20px;
            left: 20px;
        }
        #second {
            background-color: #255099;
            border: 1px dashed #255066;
        }
        #third {
            background-color: #1c6699;
            border: 1px dashed #1c6615;
            position: relative;
            top: -10px;
            left: 20px;
        }
    </style>

</head>
<body>

<div id="father">
    <div id="first">第一个盒子</div>
    <div id="second">第二个盒子</div>
    <div id="third">第三个盒子</div>
</div>

</body>
</html>
```

**相对定位：**

**position：relative；**

==**相对于原来的位置，进行指定的偏移(top:-20px实际上就是向下移动20px)**，相对定位的话，它任然在标准文档流中，原来的位置会被保留==

![image-20210607143742585](https://img-blog.csdnimg.cn/img_convert/5d4687209529a89bb739f0a2ec286e3c.png)

## 方块定位练习讲解

![image-20220104162550230](C:\Users\lf\AppData\Roaming\Typora\typora-user-images\image-20220104162550230.png)

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        #box{
            width: 300px;
            height: 300px;
            padding: 10px;
            border: 2px solid red;
        }
        a{
            width: 100px;
            height: 100px;
            text-decoration: none;
            background: #ffa1f2;
            line-height: 100px;
            text-align: center;
            color: white;
            display: block;
        }
        a:hover{
            background: #47a4ff;
        }
        .a2,.a4{
            position: relative;
            left: 200px;
            top: -100px;
        }
        .a5{
            position: relative;
            left: 100px;
            top: -300px;
        }
    </style>

</head>
<body>

<div id="box">
    <a href="#" class="a1">链接1</a>
    <a href="#" class="a2">链接2</a>
    <a href="#" class="a3">链接3</a>
    <a href="#" class="a4">链接4</a>
    <a href="#" class="a5">链接5</a>
</div>

</body>
</html>

```

## 绝对定位(absolute)和固定定位(fixed,类似于回到顶部按钮)

**绝对定位**

定位：基于XXX定位，上下左右

1、没有父级元素定位的前提下，相对于浏览器定位

2、假设父级存在定位，我们通常会相对于父级元素进行偏移~

3、在父级元素范围内进行移动

相对于父级或浏览器的位置，进行指定的偏移，绝对定位的话，它不再在标准文档流中，原来的位置不会被保留

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        div{
            margin: 10px;
            padding: 5px;
            font-size: 12px;
            line-height: 25px;
        }
        #father{
            border:1px solid #666;
            padding:0;
        }
        #first{
            background-color:#a13d30;
            border:1px dashed #b27530;
        }
        #second{
            background-color:#255099;
            border:1px dashed #255066;
            position: absolute;
            left: 100px;
        }
        #third{
            background-color:#1c6699;
            border:1px dashed #1c6615;
        }
    </style>

</head>
<body>

<div id="father">
    <div id="first">第一个盒子</div>
    <div id="second">第二个盒子</div>
    <div id="third">第三个盒子</div>
</div>

</body>
</html>
```

**固定定位fixed**

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        body{
            height: 1000px;
        }
        div:nth-of-type(1){/*绝对定位：相对与浏览器*/
            width: 100px;
            height: 100px;
            background: red;
            position: absolute;
            right: 0;
            bottom: 0;
        }
        div:nth-of-type(2){/*fixed，固定定位*/
            width: 50px;
            height: 50px;
            background: yellow;
            position: fixed;
            right: 0;
            bottom: 0;
        }
    </style>

</head>
<body>
<div>div1</div>
<div>div2</div>
</body>
</html>
```

## z-index及透明度

![image-20210607145719003](https://img-blog.csdnimg.cn/img_convert/7c5d5c5686a980a9e472697292dc718b.png)

图层~

**z-index：默认是0，最高无限~999**

**尽量将想要展示的东西层级设置高一些(999)**

html部分

```HTML
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="content">
    <ul>
        <li><img src="images/1.jpg" alt=""></li>
        <li class="tipText">学习微服务，找狂神</li>
        <li class="tipBg"></li>
        <li>时间:2099-01-01</li>
        <li>地点:月球一号基地</li>
    </ul>
</div>
</body>
</html>
```

css部分  

==**背景透明度：opacity:0.5**==

```CSS
#content{
    height: 300px;
    width:380px;
    padding:0px;
    margin:0px;
    overflow:hidden;
    font-size:12px;
    line-height:25px;
    border:1px #000 solid;
}
ul,li{
    padding:0px;
    margin:0px;
    list-style:none;
}
/*父级元素相对定位*/
#content ul{
    position:relative;
}
.tipText,.tipBg{
    position:absolute;
    width:380px;
    height:25px;
    top:216px;
}
.tipText{
    color:white;
    /*z-index:1;*/
}
.tipBg{
    background:#000;
    opacity:0.5;/*背景透明度*/
    filter：Alpha(opacity=50)
}
```

## 动画及视野拓展

**可以对canvas进行了解**

**一般不纯使用css做动画**

## CSS小结流程图

![CSS总结](https://img-blog.csdnimg.cn/img_convert/fd4503a599dbecf26dd6396494ecc925.png)
