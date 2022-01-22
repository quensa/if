# Spring

## 简介

- Spring：春天----> 给软件行业带来了春天
- 2002，首次推出了Spring框架的出行：interface21框架
- Spring框架即以interface21框架为基础，经过重新设计，并不断丰富其内涵，于2004年3月24日正式发布1.0版本
- Spring理念：是现有的技术更加容易使用，本身是一个大杂烩。
- SSH：Struct2 + Spring + Hibernate
- SSM: SpringMVC + Spring + Mybatis

官网： https://spring.io/projects/spring-framework#overview

官方下载： https://repo.spring.io/release/org/springframework/spring/

GitHub： https://github.com/spring-projects/spring-framework

## 优点

- spring是开源的免费的容器。
- spring是一个轻量级的，非入侵式的框架。
- **控制反转（IOC），面向切面编程 (AOP)。**
- 支持事务处理，对框架整合的支持。
  ==总结：spring是一个轻量级的控制反转(IOC)和面向切面编程(AOP)的框架。==

## 组成

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201223175525840.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTQxNjY4Nw==,size_16,color_FFFFFF,t_70)

## 拓展

现代化的Java开发！说白就是基于Spring的开发！

**Spring Boot**

- 一个快速开发的脚手架。
- 基于SpringBoot可以快速的开发单个微服务。
- 约定大于配置。

**Spring Cloud**

- SpringCloud是基于SpringBoot实现的。

因为现在大多数公司都在使用SpringBoot进行快速开发，学习SpringBoot的前提，需要完全掌握Spring及SpringMVC！承上启下的作用！

**弊端：发展了太久之后，违背了原来的理念！配置十分繁琐，人称：“配置地狱！”**

## [IOC](https://so.csdn.net/so/search?q=IOC)

### **IOC组成理论推导**

==**（实质上就是把控制器给用户让他给参数从而调用通用方法去实现业务，增加set方法变成调用参数传入）**==

原来的实现方式：

1.UserDao接口

```
public interface UserDao {
    void getUser();
}
```


2.UserDaoImpl实现类

```
public class UserDaoImpl implements UserDao{
    public void getUser() {
        System.out.println("默认获取用户的数据");
    }
}
```


3.UserService业务接口

```
public interface UserService {
    void getUser();
}
```

4.UserServiceImpl实现类

    public class UserServiceImpl implements UserService{
    	private UserDao userDao = new UserDaoImpl();
    public void getUser() {
        userDao.getUser();
    }
    }

如果想要改变，就需要每次更改UserDao
**若将UesrDao使用Set接口实现**

    public class UserServiceImpl implements UserService{
    private UserDao userDao;
    //利用set进行动态实现值得注入
    public void setUserDao(UserDao userDao) {
    	this.userDao = userDao;
    }
    
    public void getUser() {
        userDao.getUser();
    }

- 之前，程序通过new主动创建对象！控制权在程序猿手上
- 使用set注入后，程序不再具有主动性，而是变成了被动的接受对象！
- 这种思想，从本质上解决了问题，程序员不用再去管理对象的创建了，降低了耦合性！

```java
总结：在以前的开发模式中，假设我现在有增加一个新的DAO了，然后要去不断的new 不断的改变Service层，显然这种情况并不是好的代码，所有我们可以用反射来改变这一模式，但是我们现在有了Spring，就先来看看Spring吧
	以前是不断的new new new 
	现在加入这个代码这种，专门来选择我们要的不同DAO层（其实就是一种模式：代理模式）
	1）使用set注入后，程序不再具有主动性，而是变成了被动的接受对象！（这个就是）
	public void setUserDAO（UserDAO userDAO） {
		this.userDao = userDao;
	}
	2）这种思想，从本质上解决了问题，程序员不用再去管理对象的创建了，降低了耦合性！
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201109112157443.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2xpNjQzOTM3NTc5,size_16,color_FFFFFF,t_70#pic_center)

### IOC本质

**控制反转IOC（Inversion of Control），是一种设计思想，DI（依赖注入）是实现IOC的一种方法**， 也**有人认为DI只是IOC的另一种说法（不正确的）**。没有IOC的程序中，我们使用面向对象编程，对象的创建与对象间的依赖关系完全硬编码在程序中，对象的创建由程序自己控制，控制反转后将对象的创建转移给第三方，**个人认为所谓的控制反转就是：获得依赖的方式反转了。**

采用XML方式配置Bean的时候，Bean的定义信息是和实现分离的，而采用注解的方式可以把两者合为一体，Bean的定义信息直接以注解的形式定义在实现类中，从而达到了零配置的目的。

控制反转是一种通过描述（xml或注解）并通过第三方去生产或获取特定对象的方式。在spring中实现控制反转的是IOC容器，其实现方法是依赖注入（Dependency Injection，DI）

## HelloSpring

先导入Spring依赖

后编写hello实体类

```java
package com.yang.pojo;

public class hello {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }

}

```

==**service实体类中可以实现其他实体类的方法从而调用不同的接口实现业务处理这样就只用在xml中改用对应参数就能实现对应输出语句**==

```java
package com.yang.service;

import com.yang.dao.daouser;

public class userimpl implements service{

    daouser daouser;

    public void setDaouser(com.yang.dao.daouser daouser) {
        this.daouser = daouser;
    }

    @Override
    public void get() {
        daouser.get();
    }
}
```

编写bean.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--使用Spring来创建对象，在Spring这些都称为Bean
   类型 变量名 = new 类型();
   Hello hello = new Hello();

   id = 变量名
   class = new的对象
   property 相当于给对象中的属性设置一个值！
       -->

    <bean id="hello" class="com.yang.pojo.hello">
        <property name="name" value="sl"/>
    </bean>
    <bean id="mysql" class="com.yang.dao.mysql"></bean>
    <bean id="oracle" class="com.yang.dao.oracle"></bean>
    <bean id="userimpl" class="com.yang.service.userimpl">
        <property name="daouser" ref="oracle"></property>
    </bean>
    <!--ref 引用spring中创建好的对应对象（实现接口dao的实体类）
		value 表示具体的值，基本数据类型
-->
</beans>
```

最后测试**（代码一开始的基本不变，变的是xml中的参数，就是调用什么接口）**

```java
import com.yang.pojo.hello;
import com.yang.service.userimpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class text {
    public static void main(String[] args) {
        //new 对象返回要改为这个ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //这里要强转成对应的实体类
        hello hello = (hello) context.getBean("hello");
        System.out.println(hello);
        //这里要强转成对应的实体类
        userimpl userimpl = (userimpl) context.getBean("userimpl");
        //最后调用对应的方法
        userimpl.get();
       
    }
}
```

## IOC创建对象的方式

1. 使用无参构造创建对象，默认！
2. 假设我们要使用有参构造创建对象。

1.下标赋值

```xml
<!--第一种方式：下标赋值    -->
<bean id="user" class="com.kuang.pojo.User">
    <constructor-arg index="0" value="狂神说Java"/>
</bean>
```

**2.类型（不建议使用）**

```xml
<!--第二种方式：通过类型的创建，不建议使用    -->
<bean id="user" class="com.kuang.pojo.User">
    <constructor-arg type="java.lang.String" value="lifa"/>
</bean>
```


==**3.参数名(推荐用这个)**==

```xml
<!--第三种方式：直接通过参数名来设置    -->
<bean id="user" class="com.kuang.pojo.User">
    <constructor-arg name="name" value="李发"/>
</bean>
```

==**总结：在配置文件加载的时候，容器中管理的对象就已经初始化了！**==

## Spring配置

1.别名(一般不用用下面的name就能很好的取代别名的作用)

```xml
 <!--别名，如果添加了别名，我们也可以使用别名获取到这个对象-->
 <alias name="user" alias="userNew"/>
```

2.Bean的配置

```xml
<!--
id：bean的唯一标识符，也就是相当于我们学的对象名（必须和建立的类名相同）
class：bean对象所对应的全限定名：包名+类名
name：也是别名，而且name可以同时取多个别名
-->
 <bean id="userT" class="com.kuang.pojo.UserT" name="user2 u2,u3;u4">
        <property name="name" value="黑心白莲"/>
</bean>
```


3.import
这个import。一般用于团队开发使用，它可以将多个配置文件，导入合并为一个。
假设，现在项目中有多个人开发，这三个人负责不同的类开发，不同的类需要注册在不同的bean中，我们可以利用import将所有人的beans.xml合并为一个总的！

- 张三
- 李四
- 王五
- applicationContext.xml

```xml
<import resource="bean.xml"/>
<import resource="bean2.xml"/>
<import resource="bean3.xml"/>
```

==**使用的时候，直接使用总的配置（applicationContext.xml）就可以了。而且spring会智能的将多个xml重复的合并并且调用寻找对应的bean**==

## 依赖注入

### **构造器注入**

前面已经介绍过，参考**IOC创建对象的方式**

### Set方式注入【重点】

- 依赖注入：Set注入
  - 依赖：bean对象的创建依赖于容器！
  - 注入：bean对象中的所有属性，由容器来注入！

【环境搭建】

复杂类型

```jade
public class Address {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }

}
```

真实测试对象

```java
public class Student {

    private String name;
    private Address address;
    private String[] books;
    private List<String> hobbies;
    private Map<String,String> card;
    private Set<String> games;
    private String wife;
    private Properties info;
}
```

beans.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="student" class="com.kuang.pojo.Student">
        <!--第一种：普通值注入，value        -->
        <property name="name" value="黑心白莲"/>
    </bean>
</beans>
```

测试类

==**context.getBean("student"，student.class)第二个写上student的反射对象就可以不用强转**==

```java
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Student student =  context.getBean("student"，student.class);
        System.out.println(student.getName());
    }
}
```

**完善注入信息**

==**特别注意类注入ref，map是用entry，null可以自闭合和properties标签的不同**==

**==其他注入格式类似==**

```xml
    <bean id="address" class="com.kuang.pojo.Address">
        <property name="address" value="西安"/>
    </bean>
	
    <bean id="student" class="com.kuang.pojo.Student">
        <!--第一种：普通值注入，value        -->
        <property name="name" value="lf"/>

        <!--第二种：        -->
        <property name="address" ref="address"/>

        <!--数组        -->
        <property name="books">
            <array>
                <value>红楼梦</value>
                <value>西游记</value>
                <value>水浒传</value>
                <value>三国演义</value>
            </array>
        </property>

        <!--List        -->
        <property name="hobbies">
            <list>
                <value>打篮球</value>
                <value>看电影</value>
                <value>敲代码</value>
            </list>
        </property>

        <!--Map        -->
        <property name="card">
            <map>
                <entry key="身份证" value="123456789987456321"/>
                <entry key="银行卡" value="359419496419481649"/>
            </map>
        </property>

        <!--Set        -->
        <property name="games">
            <set>
                <value>LOL</value>
                <value>csgo</value>
            </set>
        </property>

        <!--NULL        -->
        <property name="wife">
            <null/>
        </property>

        <!--Properties        -->
        <property name="info">
            <props>
                <prop key="driver">20210122</prop>
                <prop key="url">102.0913.524.4585</prop>
                <prop key="user">lf</prop>
                <prop key="password">123456</prop>
            </props>
        </property>

    </bean>
```

### pc命名空间方式注入

我们可以使用p命名空间和c命名空间进行注入

==**p命名就是set方式注入，需要无参构造和set方法，c命名就是类似于构造器注入，需要有参构造**==

==**注意点：p命名和c命名空间不能直接使用，需要导入xml约束！  格式p/c加冒号**==

```xml
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
```

user实体类要加有参（c报错）无参（p报错）构造不然会报错

```java
public class User {
     private String name;
     private int age;
    
    public User(){}
    
    public User(String name,int age){
         this.name = name;
         this.age = age;

    }
 
     public void setName(String name) {
         this.name = name;
    }
 
     public void setAge(int age) {
         this.age = age;
    }
 
     @Override
     public String toString() {
         return "User{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 '}';
    }
 }
```



使用：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--p命名空间注入，可以直接注入属性的值：property-->
    <bean id="user" class="com.kuang.pojo.User" p:name="lf" p:age="19"/>

    <!--c命名空间注入，通过构造器注入：constructor-args-->
    <bean id="user2" class="com.kuang.pojo.User" c:name="ly" c:age="11"/>

</beans>
```

测试：

```java
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");

        User user = context.getBean("user",User.class);
        System.out.println(user);

        User user2 = context.getBean("user2",User.class);
        System.out.println(user2);
    }
```

### bean的作用域

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201111101635200.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2xpNjQzOTM3NTc5,size_16,color_FFFFFF,t_70#pic_center)

**单例模式（Spring默认机制）重点了解一般单线程用这个**

```xml
<bean id="user2" class="com.kuang.pojo.User" c:name="狂神" c:age="22" scope="singleton"/>
```

**原型模式：每次从容器中get的时候，都会产生一个新对象！实际上就是从一个对象克隆多个对象，他们的地址值不同（hashcode）**

```xml
<bean id="user2" class="com.kuang.pojo.User" c:name="狂神" c:age="22" scope="prototype"/>
```

其余的request、session、application、这些只能在web开发中使用到！

## Bean的自动装配

- 自动装配是Spring满足bean依赖一种方式！
- Spring会在上下文中自动寻找，并自动给bean装配属性！

在Spring中有三种装配的方式：

- 在xml中显式的配置；（这之前的都是显示配置）
- 在java中显式配置；（以后再出现）
- **隐式的自动装配bean【重要】**

测试
环境搭建：创建项目，一个人有两个宠物！

-------一猫一狗一人三对象实体类，人中有三属性猫狗名字

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

   <bean id="dog" class="com.kuang.pojo.Dog"/>
   <bean id="cat" class="com.kuang.pojo.Cat"/>

   <bean id="user" class="com.kuang.pojo.User">
       <property name="cat" ref="cat"/>
       <property name="dog" ref="dog"/>
       <property name="str" value="lf"/>
   </bean>
</beans>
```

### ByName自动装配

**autowire byName (按名称自动装配)**

由于在手动配置xml过程中，常常发生字母缺漏和大小写等错误，而无法对其进行检查，使得开发效率降低。

采用自动装配将避免这些错误，并且使配置简单化。

```xml
     <?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

   <bean id="dog" class="com.kuang.pojo.Dog"/>
   <bean id="cat" class="com.kuang.pojo.Cat"/>   
		<!--
        byName：会自动在容器上下文中查找，和自己对象set方法后面的值对应的bean id！
            -->
        <bean id="people" class="com.kuang.pojo.People" autowire="byName">
            <property name="name" value="lf"/>
        </bean>
```

**小结：**

当一个bean节点带有 autowire byName的属性时。

1. 将查找其类中所有的set方法名，例如setCat，获得将set去掉并且首字母小写的字符串，即cat。
2. 去spring容器中寻找是否有此字符串名称id的对象。
3. 如果有，就取出注入；如果没有，就报空指针异常java.lang.NullPointerException。因为按byName规则找不对应set方法，真正的setCat就没执行，对象就没有初始化，所以调用时就会报空指针错误。。

### ByType自动装配

**autowire byType (按类型自动装配)**

使用autowire byType首先需要保证：同一类型的对象，在spring容器中唯一。如果不唯一，会报不唯一的异常。

```java
//NoUniqueBeanDefinitionException
```

**因为是按类型装配，所以并不会报异常，也不影响最后的结果。甚至将id属性去掉，也不影响结果。**

```xml
        <!--
        byType：会自动在容器上下文中查找，和自己对象属性类型相同的bean！
            -->
        <bean id="people" class="com.kuang.pojo.People" autowire="byType">
            <property name="name" value="lf"/>
        </bean>
```

小结：

- ByName的时候，需要保证所有bean的id唯一，并且这个bean需要和自动注入的属性的set方法的值一致！
- ByType的时候，需要保证所有bean的class唯一，并且这个bean需要和自动注入的属性的类型一致且**保证全局唯一**！

### 使用注解实现自动装配
