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

```javascript
function a(){
    var x = 1;
    //内部函数可以访问外部函数的成员，反之不行
    function a1(){
        var y = x +1; //2
    }
    //外部访问了内部函数的变量，会不行
    var z = y+1; //报错
}
```


变量的一般使用
一般都先全部定义，后调用

```javascript
function zhang(){
    var x,y,z;
//之后再赋值调用
}
```
全局对象window(默认所有全局变量都自动绑定在window对象下)

alert() 这个函数本身也是一个window的变量；javascript实际上只有一个全局作用域，任何变量（函数也可以视为变量），假设没有在函数作用范围内找到，就会向外查找，如果在全局作用域都没有找到，就会报错 Refrence

```javascript
var x ='xxx';
window. alert(x);
var o1d_ _alert = window. alert;
//o1d_ alert(x);
window.alert = function () {};
//发现alertO 失效了
window. alert(123);
//恢复
window.alert = o1d_ _alert;
window. alert(456);
```

**局部作用域let**

关键字,解决局部作用域冲突问题，现建议大家都用let去定义局部变量

```javascript
function aaa() {
for(vari=0;i<100;i++){
    console.log(i)
}
console.log(i+1); //问题? i 出了这个作用域还可以使用
}

//使用let后
function aaa() {
for(leti=0;i<100;i++){
    console.log(i)
}
console.log(i+1); //Uncaught ReferenceError: i is not defined

```

**常量const**

用const定义常量

```javascript
const PI = '3.14';
console.log(PI);
PI = '123'; //报错，常量不允许修改
```

## 方法

**定义方法**
方法就是把函数放在对象的里面，对象只有两个东西：属性和方法

```javascript
var person = {
    name: 'zhang';
    brith: 1997;
    //方法 
    age: function(){
        var now = new Date().getFullYear();
        return now - this.brith; //this是默认指向调用它的那个对象，这里值person
    }
}
//属性调用
person.name;
//方法调用，方法一定要带（）
person.age();
```

**this是无法指向的，是默认指向调用它的那个对象的；**

所以会出现NaN的结果因为调用的window没有birth这个属性

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200508232827102.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Bhbl9oMTk5NQ==,size_16,color_FFFFFF,t_70)

**apply方法**

apply方法是可以控制this指向的，该方法有两个参数，第一个是getArg要使用的是那个对象，第二个是数组

```javascript
function getAge(){
    var now = new Date().getFullYear();
    return now - this.brith;
}
getAge.apply(person,[]); //this指向了person，参数为空
//person可以是任意的对象 以上图为例就可以调用kuangshen的birth属性
```

## 对象

**Date**

```javascript
var now = new Date(); //sat Jan 04 2020 10:47:06 GMT+0800 (中国标准时间)
now. getFu11YearO); //年
now. getMonth(); //月0~11 代表月
now. getDate(); //日
now. getDay(); //星期几
now. getHours(); //时
now. getMinutes(); //分
now. getseconds(); //秒
now. getTimeO); //时间戳全世界统一 1970 1.1 0:00:00到现在当前时间的毫秒数
console. log(new Date(1578106175991)) //时间戳转为时间

//date转换
now = new Date (1578106175991)
sat Jan 04 2020 10:49:35 GMT+0800 (中国标准时间)
now. toLocalestring //注意，调用是一个方式，不是一一个属性!
f toLocalestring() { [native code] }
now. toLocalestring()
"2020/1/4上午10:49:35"
now. toGMTString()
'Sat, 04 Jan 2020 02:49:35 GMT"
```

json对象

- 早期，所有数据传输习惯使用XML文件!

- JSONlavaScript Object Notation, JS对象简谱)是- -种轻量级的数据交换格式。
- 简洁和清晰的层次结构使得JSON成为理想的数据交换语言。
- 易于人阅读和编写，同时也易于机器解析和生成，并有效地提升网络传输效率。
  在JavaScript -切皆为对象、任何js支持的类型都可以用JSON来表示; number, string…

**格式:**

- 对象都用{}
- 数组都用[]
- 所有的键值对都是用key:value

json字符串和js对象的转换

```javascript
var user = {
    name :
    "qinjiang",
    age: 3,
    sex: '男'
    }

//对象转化为json字符串(json字符串每个键都用""或'包围)
var jsonuser = JSON. stringify(user); 
//输出为{"name" : "qinjiang"，"age":3,"sex" :"男"}

//json字符串转化为对象参数为json 字符串
var obj = JSON. parse(' {"name":"qinjiang" , "age" :3,"sex":"男"}');
//输出为{name:"qingjiang",age:3,sex:"男"}
```

json和js对象的区别：

```javascript
var obj = {a: 'he11o' ,b: 'he11ob'};
//json字符串一定要单双引号互相包裹（内单外双）
var json = '{"a": "he11o" , "b":"he1lob"}'
```

## 面向对象编程

**面向对象原型继承(了解 现多用class继承)**
1、原型对象
当创建一个新函数时，系统会根据一组特定的规则为函数创建一个prototype属性，该属性会指向一个名为原型对象的对象，在默认情况下，该对象会自动生成一个构造函数（constructor），该构造函数是一个指向函数的指针。而在原型对象中，除了有这个构造函数，我们还可以添加其他的属性和方法。

通俗来讲就是，当我们新建一个函数A时，函数A内部会有一个属性，该属性指向一个对象（名字叫原型对象），而这个对象里面默认有一个构造函数，这个构造函数指向我们最初新建的函数A。然后，我们还可以在原型对象中添加属性和方法

```javascript
//①默认情况下，构造函数是空的

function Person（）{//构造函数首字母大写

}

//②添加属性和方法

Person.prototype.name="dp";
Person.prototype.doSomething=function(）{
    alert(this.name);
};

//③定义好构造函数和其他属性方法之后，就可以创建实例了

var person1=new Person();
var person2=new Person();
```

**面向对象class继承(跟java类似)**

1、添加方法

2、继承

```javascript
//给student添加一个方法 
//先定义一个类、属性、方法
class student{
    constructor(name){
        this.name = name;
    }

    hello(){
        alert('hello');
    }
}
//使用方法
var person = new student('小明');
person.hello();

//继承
class student{
    constructor(name){
        this.name = name;
    }

    hello(){
        alert('hello');
    }
}
class xiaoStudent extends student{
    constructor(name,grade){
        //继承必须有父类的东西
        super(name);
        this.grade = grade;
    }
    mygrade(){
        alert('小学生')
    }
}
//使用
var xiaoStudent = new xiaoStudent("xiaohong",1);

```

面向对象class继承的本质：查看对象原型（实际上最终继承的还是原型对象）而原型又是走不完的--形成原型链

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200509212115371.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3Bhbl9oMTk5NQ==,size_16,color_FFFFFF,t_70)

## 操作BOM对象（重点）

JavaScript和浏览器关系？
JavaScript诞生就是为了能够让他在浏览器中运行！

BOM：浏览器对象模型

- IE6~11
- chrome
- Safari
- Firefox
- opera

**window**
window代表浏览器窗口

```javascript
window.alert(1)
undefined
window.innerHeight
258 
window.innerwidth
919
window.outerHeight
994
window.outerwidth
919
//可以调整浏览器窗口试试
```

**Navigator(了解  不常用)**
Navigator，封装了浏览器的信息

```javascript
navigator . appName
"Netscape"
navigator . appVersion
"5.0 (windows NT 10.0; WOw64) Applewebkit/537.36 (KHTML， like Gecko)
Chrome/63.0.3239.132 Safari/537.36"
navigator . userAgent
"Mozi11a/5.0 (Windows NT 10. 0; WOw64) ApplewebKit/537.36 (KHTML， like :
Gecko) Chrome/63.0. 3239.132 Safari/537.36"
navigator. platform
"Win32"
```

**screen**
代表屏幕尺寸

```javascript
screen.width
1920
screen.Height
1080
```

**lacation**
**代表当前页面的URL信息**

location属性：

- 主机：host
- 当前指向的位置：href
- 协议:protocol
- 重新加载的方法：f reload() //location.reload()刷新网页
- (设置新的地址:location.assign(‘想要跳转的地址’))

**document**
document代表当前的页面，HTML DOM文档树

document.title 改变网页标题 

```javascript
//获取具体的文档树节点：
<d1 id="app">
    <dt> Java</dt>
    <dd> JavaSE</dd>
    <dd> JavaEE</dd>
</d1>
<script>
    var d] = document. getElementById(' app ');
</script>

//获取cookie
document.cookie

//劫持cookie原理：把一段能劫持cookie的js代码放在网站上 一点开就能把你的cookie拿了
<script src='劫持cookie'></script>
<!-- 获取你的cookie上传到他的服务器 -->
//服务器端可以设置cookie为httpOnly---cookie只读防止劫持
```

**history(少用 可以用框架封装实现)**
history代表浏览器的历史记录

```javascript
history.back() //后退
history.forward() //前进
```

## 操作DOM对象(重点)

**获得dom节点**

这是原生代码，之后都用jQuery

```javascript
<div>
    <h1>标题一</h1>
    <p id='p1'>p1</p>
    <p class='p2'>p2</p>
</div>
<script>
//对应css选择器
var h1 = document.getElementByTagName('h1'); //这里就是获取到了这个dom节点(标签)
var p1 = document.getElementByID('p1');
var p2 = document.getElementByclassName('p1');
var father = document.getElementByID('father');

var childrens = father.children;// 获取父节点下的所有子节点
var childrens = father.children[index]; //获取其中一个节点
//father.firstchild 获取父节点的第一个子节点
//father.lostchild 获取父节点的最后一个子节点
</script>
```

**更新dom节点**

```js
<div id="id1">
    
</div>

<script>
    var id1 = document.getElementByID('id1')
</script>

id1.innerText = '123' //innerText方法修改文本内容  
id1.innerHTML = '<strong>123</strong>' //innerHTML解析HTML超文本的 可以修改id的样式
id1.style.color = 'red' //style.什么：style方法修改css样式。即可以在js里操作修改样式
id1.style.padding  '2em' //属性使用字符串包裹
id1.style.fontsize='20px'//css里的下划线-在js里转为驼峰命名
```

**删除dom节点**

删除节点的步骤： 先获取父节点，通过父节点删除自己



```javascript
<div>
    <h1>标题一</h1>
    <p id='p1'>p1</p>
    <p class='p2'>p2</p>
</div>
<script>
    var self = document.getElementByID('p1');//找到p1节点
    var father = p1.parentElement; //找到p1的父节点
    father.removechild(self) //通过父节点使用removechild删掉自己（只有标记为id选择器的节点才可以删除）

//father.removechild(father.children[n])也可以删除父节点下的第n个节点只不过他是个动态的过程--子节点会改变下标
</script>
```

注意：删除多个节点是，children是时刻变化的，不能直接father.removechild(father.children[0])这样从第一个索引开始删

**插入dom节点**

我们获得了某个dom节点，假设这个dom节点是空的，我们通过innerHTML就可以增加一个元素了，但是这个dom节点以及存在元素了，就不能这么干了，因为会产生覆盖，这个时候就使用追加节点的方法：

```javascript
<p id="js">JavaScript</p>
<div id="list">
    <p id="se">JavaSE</p>
    <p id="ee">JavaEE</p>
    <p id="me">JavaME</p>
</div>

<script>
    var js = document.getElementByID('js'); //获取想要加入的节点
    var list = document.getElementByID('list'); //获取想要加入的父节点
    list.appendchild(js); //在list节点下追加子节点  js直接加到最后
</script>
```

在js中创建一个新的节点追加

```javascript
<script>
    //第一个方法：通过js创建一个新节点
    var new = document.creatElement('p'); //创建一个p标签
    new.id = 'new';
    new.innerText = 'hello'; //在这个标签上输入文本
    list.appendchild(new); //在父节点下加进去

    //用第二种方法创建一个有自己属性的标签节点
    var myScript = document.creatElement('script');//创建一个script标签节点
    myScript.setAttribute('type','text/javascript'); /*setAttribute方法加入属性和属性值。第一个参数为属性名，第二个参数为属性值。生成效果为<script type='text/javascript'></sript>*/

    //可以创建一个style标签
    var myStyle= document.createElement('style'); //创建了一个 空style标签
    myStyle.setAttribute('type', 'text/css');
    myStyle.innerHTML = 'body{background-color: chartreuse;}'; //设置标签内容
    document.getElementsByTagName( 'head' )[0]. appendChild(myStyle) //在父节点追加这个style标签

</script>
```

在前面插入节点：insertBefore

```javascript
var ee = document. getElementById('ee');
var js = document . getElementById('js');
var list = document . getElementById( 'list');
//要包含的节点. insertBefore(newNode, targetNode)参数分别是前后顺序
list. insertBefore(js,ee); //在list节点中（list是父节点），在ee节点前加入目标节点js
```

## 操作表单

**获取表单信息**

```javascript
<body>
<form action='#' method="post">
    //文本框
    <p>
    <span>用户名：</span>
    <input type="text" id="username">
    </p>

    //单选框
    <p>
    <span>性别</span>
    <input type="radio" name="sex" value="man" id="boy">男
    <input type="radio" name="sex" value="women" id="girl">女

    </p>
</form>
</body>

<script>
    var input_text = document.getElementById('username';)
    //得到文本框的值
    input_text.value
    //修改文本框的值
    input_text.value='123'

    var boy_radio = document.getElementById('boy';)
    var girl_radio = document.getElementById('girl')
    //对于单选框、多选课等固定的value，boy_radio.value只能去到当前的值  
    boy_radio.checked; //看返回的结果，是否为true，如果为true则被选中
    boy_radio.checked=true; //赋值

</script>
```

**提交表单，MD5加密**

表单提交，md5加密优化版：

```javascript
<!-- 使用form提交事件aaa()
    οnsubmit=绑定一个检测的函数，返回true或false
    将这个结果返回给表单，使用onsubmit接收
    οnsubmit="return aaa()"
 -->
 <form action="https ://www. baidu. com/" method="post" onsubmit="return aaa()">
    <P>
        <span>用户名: </span> <input type="text" id="username" name="username">
    </p>
    <p>
        <span>密码: </span> <input type="password" id=" input - password" >
    </p>
    <input type= "hidden" id="md5-password" name=" password" >
    </form>
<script>
    function aaa() {
        alert(1);
        var uname = document.getElementById( 'username' );
        var pwd = document.getElementById(" input-password" );
        //通过隐藏去提交
        var md5pwd = document.getElementById('md5-password' );
        md5pwd.value = md5(pwd.value);
        //可以校验判断表中内容，true就是通过提交，false, 阻止提交
        return true;
        }
</script>
```

# jquery

[j查询 (jquery.com)](https://jquery.com/)**看文档！**

使用时导入包或者jQuery的cdn网址

==**jquary使用的公式：$(selector).action() //这个selector选择器就是css的选择器.action是事件**==

**选择器**
原生的js选择器的种类有：

- 标签选择器：document.getElementByTagName()

- id选择器： document.getElementByID()
- 类选择器： document.getElementByClassName()

jq选择器有（css中的选择器他全部都能用）：

- 标签选择器：$(‘p’).click();
- id选择器：$(’#id名’).click();
- class选择器：$(’.class名’).click();
- …查看文档看更多

```js
<a href="" id="test_jquery">点我</a>
<script>
    <!-- 在这个a标签中添加一个单击事件 -->
    // 使用js语法
    var id = document.getElementById('test_jquery')
    id.click(function(){
         alert('jQuery');
    })
    // 使用jq语法
    $('#test_jquery').click(function(){
        alert('jQuery');
    })
</script>
```

**事件**

有鼠标事件、键盘事件、其他事件

```javascript
<!-- 要求：获取鼠标当前的一个坐标 -->
mouse:<span id="mouseMove"></span>
<div id="divMove">
    在这里移动鼠标试试
</div>
<script>
    // 当前网页元素加载完毕之后，响应事件
    // $(document).ready(function(){ //document默认是文档，ready默认是加载完
    // })
    // 上面这行的简写
    $(function(){
        $('#divMove').mousemove(function(e){ //获取了divMove的鼠标移动的坐标
            $('#mouseMove').text('x:'+e.pageX+'Y:'+e.pageY) //在mouseMove这个span里显示鼠标移动的坐标

        })
    });
</script>
```

**操作DOM事件**

节点文本操作

```js
<ul id="test_ul">
    <li class="js">JavaScript</li>
    <li name="python">Python</li>
</ul>

<script>
    //拿到这个标签的文本，类似于方法重载
    $('#test_ul li[name=python]').text();
    //修改这个标签的文本
    $('#test_ul li[name=python]').text('123');
    //修改样式
    $('#test_ul').html();
</script>
```

css的操作

```js
<script>
     $('#test_ul').css("color","red"); //使用键值对来表示属性和属性值
</script>
```

元素的显示和消失：本质是display：none

```html
$('#test_ul').show();
$('#test_ul').hide();
ouse:<span id="mouseMove"></span>
<div id="divMove">
    在这里移动鼠标试试
</div>
<script>
    // 当前网页元素加载完毕之后，响应事件
    // $(document).ready(function(){ //document默认是文档，ready默认是加载完
    // })
    // 上面这行的简写
    $(function(){
        $('#divMove').mousemove(function(e){ //获取了divMove的鼠标移动的坐标
            $('#mouseMove').text('x:'+e.pageX+'Y:'+e.pageY) //在mouseMove这个span里显示鼠标移动的坐标
        })
    });
</script>
```

