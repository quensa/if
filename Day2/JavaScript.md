# JavaScript

## 概述

**语法规则没Java严格 JS可以让网页给出一定的行为**

- JavaScript一种直译式脚本语言，是一种动态类型、弱类型、基于原型的语言，内置支持类型。它的解释器被称为JavaScript引擎，为浏览器的一部分，广泛用于客户端的脚本语言，最早是在HTML（标准通用标记语言下的一个应用）网页上使用，用来给HTML网页增加动态功能。

- JavaScript组成一个完整的 JavaScript 实现是由以下 3 个不同部分组成的：

- JavaScript核心（ECMAScript）、文档对象模型（Document Object Model，简称DOM）、浏览器对象模型（Browser Object Model，简称BOM）。

- 一个合格的后端人员必须要精通JavaScript

## 引入

1.内部标签

```html
<script>	</script>
```

2.外部引入

abc.js

```html
<script scr="abc.js"></script>
```

```html
<!-- 不用显示定义type，默认就是 javascript  -->
<script type="text/javascript"></script>
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- 在script标签内写JavaScript代码   -->
    <!--<script>
       alert('hello,world'); 
         </script>-->

    <!-- 外部引入，script标签必须要成对   -->
    <script src="js/js.js"></script>


</head>
<body>

</body>
</html>
```

## 基础数据类型

**变量**   用var定义 

**number**
js中不区分小数和整数，Number

```
123  //整数123
123.5  //小数123.5
1.2555e5  //科学计数法
-5213   //负数
NaN   //not a number
Infinity  //表示无限大
```

**字符串** 单引号和双引号

**布尔值** true false

**逻辑运算符**

```
&&   全真为真。全假为假

||	 一个为真结果为真

!	 真即是假，假即为真
```

==**比较运算符（重要区别）**==

```
=		赋值

==		等于(类型不一样，值一样也会判断为true)

=== 	绝对等于(类型一样，值一样，结果为true)
```


**这是JS的一个缺陷，一定注意不要使用==来比较**

这是JS的一个缺陷，一定注意不要使用==来比较

注意：

```java
//NaN==NaN，这个和所有的数值都不相等，包括自己
//只能通过isNaN(NaN)来判断这个数是否为NaN
```

**浮点数问题:**

```
console.log((1/3)===(1-(2/3)))      //false
```


==**尽量避免使用浮点数进行计算。存在精度问题！**==

```
console.log(Math.abs(1/3-(1-2/3))<0.000001);         //true
```

**null和undefined**

```
null 空
undefined 未定义
```

**数组**

```javascript
//为了保证代码的可读性，尽量使用[]
 var arr = [1,2,3,null,true,'hello'];
 new Array (1,12,15,166,255,'world');
```


**如果下标越界了，就会：undefined**

如果下标越界了，就会：undefined

**对象**
**对象是大括号。数组是中括号**

```js
//每一个属性之间使用逗号隔开，最后一个不需要添加

//相对于定义了一个类 可以采用person.name来调用直接可以得到lf
//tag就是类似于java数组
var person = {
    name : lf,
    age : 18,
    tag: ['js','web','java','....']
}

```

## 严格检查模式

- 前提：idea需要设置支持es6语法

  **’use strict’; 严格检查模式**，预防JavaScript的随意性产生的一些问题

   **必须写在JavaScript的第一行**

   **局部变量建议使用let去定义**

```javascript
   <script>
        'use strict';
        let j = 1;
    </script>
```

## 数据类型

### 字符串

1. 正常字符串我们使用单引号或者双引号包裹
2. 转义字符

|        |                    |
| ------ | ------------------ |
| \n     | 换行               |
| \t     |                    |
| \u4e2d | \u#### Unicode字符 |
| \x41   | Ascll字符          |

3.多行字符串编写**（用`包裹）**

```javascript
//
'use scrict';
let msg = `你好呀
hello
world`
console.log(msg);
```

4.模板字符串(用${}类似于el表达式)

```javascript
let name = "sunwukong";
let age = 3;
let mes = `你好呀 ${name}`
```

5.字符串长度（student.length就是7）

6.字符串的可变性， **不可变**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210327152738354.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L01lbW9yeV9zaGFyZQ==,size_16,color_FFFFFF,t_70#pic_center)

**7.大小写转换**(跟java方法一样)

```javascript
console.log(student.toUpperCase())   //STUDENT    
console.log(student.toLowerCase())    //student
```

8.student.indexOf(‘t’) 输出在字符串中的位置

9.substring 截取字符串**(左闭右开)**

```javascript
student.substring(1)    //从第一个字符串截取到最后一个字符串
student.substring(1,3)   //[1,3)  含头不含尾
```

### 数组

==**数组里面可以包含任意的数据类型**==

```javascript
var arr = [1,2,3,4,5,6];  //通过下标取值或赋值
arr[0]  //1
```

长度

```java
//**arr.length**
//**注意**：加入给arr.length赋值，数组大小就会发生变化，如果赋值元素过小，元素就会丢失
给arr.length赋值增大则会多出空但长度增加（empty增加）如果取出empty会显示undefined
```


indexOf 通过元素获得下标索引

```
arr.indexOf(3)  //2
```


**字符串的“1”和数字1是不一样的**

**slice()也是左闭右开   截取Array的一部分，返回一个新数组，类似于String里的substring**

pash() , pop 尾部

```javascript
pash: 压入到尾部
pop : 弹出尾部的一个元素
```

unshift() ,shift() 头部

```
unshift: 压入到头部
shift:  弹出头部的一个元素
```

**排序 sort()**

```javascript
arr
(3) ["b", "c", "a"]
arr.sort()
(3) ["a", "b", "c"]
```

元素反转 resverse

```javascript
(3) ["a", "b", "c"]
arr.reverse()
(3) ["c", "b", "a"]
```

**拼接concat()**

```javascript
arr
(3) ["c", "b", "a"]
arr.concat([1,2,3])
(6) ["c", "b", "a", 1, 2, 3]
```

==**concat()并没有修改数据，只是会返回一个新的数组**==

连接符 join

打印拼接数组，使用特定的字符串连接

```javascript
(3) ["c", "b", "a"]
arr.join('-')
"c-b-a"
```

多维数组**(注意下标从0开始)**

```javascript
var arr = [[1,2],[3,4],[5,6]]
undefined
arr[1][1]
4
arr
(3) [Array(2), Array(2), Array(2)]
0: (2) [1, 2]
1: (2) [3, 4]
2: (2) [5, 6]
length: 3
```

### 对象

```javascript
var 对象名 = {
    属性名1 : 属性值1,
    属性名2 : 属性值2,
    属性名3 : 属性值3
}

//定义了一个person对象，它有四个属性
 var person = {
            name : "xiaoming",
            age : 5,
            email : "378214218@qq.com",
            score : 60

        }
```

若干个键值对

JavaScript中对象，{…}表示一个对象，键值对描述属性 xxx ： xxx 多个属性之间使用逗号隔开，最后一个不加逗号

**JavaScript中所有的键都是字符串==(所以用键时一定要加双引号或者单引号)==，值是任意对象！**

对象赋值

```
person.age = 76
76
person.age
76
```

使用一个不存在的属性时，不会报错

```
person.haha
undefined
```

动态的删减属性，通过**delete**删除对象的属性

```javascript
delete person.score
true
person
{name: "xiaoming", age: 76, email: "378214218@qq.com"}
```

动态的添加属性，**直接给新的属性添加值即可**

```javascript
person.haha = "haha"
"haha"
person
{name: "xiaoming", age: 76, email: "378214218@qq.com", haha: "haha"}
```


判断属性值是否在这个对象中！ **xxx in xxx**

```javascript
'age' in person
true

//继承的也可以，也在这个对象中
'toString' in person
true
```

判断一个属性是否是这个对象自身拥有的**(hasOwnProperty())**

```javascript
person.hasOwnProperty('age')
true

person.hasOwnProperty('jah')
false
```

### 流程控制(跟java差不多)

- if...else if....else
- for
- while
- **for Each循环**

```javascript
var arr = [15,56,1,56,56,25,2,8,47];

arr.forEach(function (value){
    console.log(value);    //lamdba表达式遍历arr（跟增强for差不多）
})
```

- **for…in**

```javascript
var arr = [15,56,1,56,56,25,2,8,47];
//let 索引 in 数组 遍历arr
for (let number in arr) {
            if (arr.hasOwnProperty(number)){
                console.log("存在");
                console.log(arr[number]);
            }
        }
```

### Map和Set

- Map

```javascript
'use strict'
var map = new Map([['Tom',100],['Jack',90],['Danny',60]]);
var name = map.get('Tom');
console.log(name);   //通过key获得value
map.set('Jenny',120); //新增或修改
map.delete('Jack');  //删除
```

- Set：无序不重复的集合

```javascript
var set = new Set([3,2,1,1,1]);//Set默认去掉重复值
set.add(5);  //增加
set.delete(1);  //删除
console.log(set.has(2));//判断是否包含某个元素
```

### Iterator

- 通过for in来遍历下标
- 通过for of来遍历数组内容
- 遍历ma  --for of
- 遍历set  --for of

![image-20220118205309640](C:\Users\lf\AppData\Roaming\Typora\typora-user-images\image-20220118205309640.png)

## 函数

### 定义函数（js用function定义）

```javascript
//绝对值函数
function abs(x){
    if (x>=0){
        return x;
    }else
        return -x;
}
```

一旦执行到return代表函数结束，直接返回结果!

如果没有执行return，函数执行完也会返回结果，也就是undefined

#### arguments

**arguments**是JavaScript免费赠送的一个关键字

**代表传递进来所有的参数**，是一个数组！

```javascript
var abs = function (x){
    console.log("x=>"+x);

    for (var i = 0;i<arguments.length;i++){
        console.log(arguments[i]);
    }
    if (x>=0){
        return x;
    }else
        return -x;
}
```

![image-20220118212526416](C:\Users\lf\AppData\Roaming\Typora\typora-user-images\image-20220118212526416.png)

==**测试结果看出函数里可以传入多个参数但是只显示第一个参数值（因为只定义了一个函数接受）而arguments则是代表传入所有参数的数组传入都可以通过调用arguments来调用传入参数**==

==**问题**：arguments包含所有的参数，我们有时候想使用多余的参数来进行附加操作。需要排除已有的参数==

#### rest

==**ES6引入的新特性，获取除了已经定义的参数之外的所有参数…**==

==**rest参数只能写在最后面，必须用…标识。**==

```javascript
function abc(a,b,...rest){
     console.log("a=>"+a);
     console.log("b=>"+b);
     console.log(rest);
 }
```

![image-20220118213050946](C:\Users\lf\AppData\Roaming\Typora\typora-user-images\image-20220118213050946.png)

==**测试发现如果传入参数不足函数所需参数则后面的参数显示未定义**==

### 变量的作用域