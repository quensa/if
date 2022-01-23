# Mysql

## 数据库分类

关系型数据库：(SQL)

- MySQL, Oracle, sql Server, DB2, SQLite

- 通过表和表之间，行和列之间的关系进行数据的存储

非关系型数据库：(NoSQL) Not Only SQL

- Redis, MongDB
- 非关系型数据库，对象存储，通过对象自身的属性来决定。

**DBMS(数据库管理系统) **

- 数据库的管理软件，科学有效的管理我们的数据，维护和获取
- MySQL ，数据管理系统！

## 操作数据库

1.创建数据库

```sql
CREATE DATABASE IF NOT EXISTS westos;
```


2.删除数据库

```sql
DROP DATABASE IF EXISTS westos
```


3.使用数据库

```sql
-- ``,如果你的表名或者字段名是一个特殊字符，需要带``
USE 'school'
```


4.产看数据库

```sql
SHOW DATABASES--查看所有数据库
```

## 数据库的字段类型（重点）

unsigened:

- 无符号的整数

- 声明该列不能声明负数


zerofill:

- 0填充的

- 10的长度 1 – 0000000001 不足位数用0 填充

自增：

- 通常理解为自增，自动在上一条记录的基础上+1

- 通常用来设计唯一的主键 index,必须是整数类似
- 可以自定义设置主键自增的起始值和步长

非空 NULL not Null

- 假设设置为 not null，如何不给他赋值，就会报错

- NULL 如果不填写，默认为NULL


默认：

- 设置默认的值！

**DDL格式及相关语句**

```sql
CREATE TABLE [IF NOT EXISTS] `表名`（
`字段名` 列类型[属性][索引][注释],
`字段名` 列类型[属性][索引][注释],
...
`字段名` 列类型[属性][索引][注释]
）[表类型][表的字符集设置][注释]

SHOW CREATE DATABASE school -- 查看创建数据库的语句
SHOW CREATE TABLE student -- 查看student数据表的定义语句
DESC student -- 显示表的结构


-- 修改删除表

-- 修改表名 ALTER TABLE 旧表面 AS 新表名
ALTER TABLE student RENAME  AS student1
-- 增加表的字段 ALTER TABLE 表名 ADD 字段名 列属性
ALTER TABLE student1 ADD age INT(11)
-- 修改表的字段（重命名，修改约束）
ALTER TABLE student1 MODIFY age VARCHAR(11)  -- 修改约束
ALTER TABLE student1 CHANGE age age1 INT(1)  -- 字段重命名

-- 删除表的字段
ALTER TABLE student1 DROP age1

-- 删除表
DROP TABLE IF EXISTS student1

```

## DML

DML语言：数据操作语言

- Insert
- update
- delete

**insert语法：-- insert into 表名（[字段一], [字段二]）values(‘值1’),(‘值2’)**

```sql
-- 插入语句（添加）
-- insert into 表名（[字段一], [字段二]）values('值1'),('值2')

INSERT INTO `grade` (`gradename`) VALUES('大四')

-- 由于主键自增我们可以省略（如何不写表的字段，他会一一匹配）
INSERT INTO `grade` VALUES('大三')
INSERT INTO `grade` (`gradeid`,`gradename`) VALUES ('大三','null')

-- 一般写插入语句，我们一定要数据和字段一一对应。
-- 插入多个字段
INSERT INTO `grade`(`gradename`) VALUES ('大二'),('大一');


INSERT INTO `student`(`name`) VALUES ('张三')

INSERT INTO `student`(`name`,`pwd`,`sex`) VALUES ('张三','aaaaa','男')
INSERT INTO `student`(`name`,`pwd`,`sex`) 
VALUES ('李四','aaaaa','男'),('王五','23232','女')


```

注意事项：

1.字段和字段之间用逗号分开

2.字段可以省略，但是后面的值必须一一对应

3.可以同时插入多条数据，VALUES后面的值需要使用，隔开即可

**update语法： UPDATE 表名 set  字段名= value（新值） where +条件**

```sql
-- 修改学员名字

UPDATE `student` SET `name`='囷' WHERE id =1;
-- 不指定条件的情况下，会改动所有表
UPDATE `student` SET `name`='233'

-- 语法；
-- UPDATE 表名 set column_name,[] = value where 条件

UPDATE `student` SET `birthday`=CURRENT_TIME where `name`='李四' AND SEX = '男'

```

**delete语法：delete from 表名 [where 条件]**·

```sql
-- 删除数据 (避免这样写)
DELETE FROM `student`


-- 删除指定
DELETE FROM `student` where id= 1

-- 测试delete 和 truncate 区别

CREATE TABLE `test`(
`id` INT(4) NOT NULL AUTO_INCREMENT,
`coll` VARCHAR(20) NOT NULL,
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8

INSERT INTO `test`(`coll`) VALUES('1'),('2'),('3')

DELETE FROM `test` -- 不会影响自增

TRUNCATE TABLE `test` -- 自增会归零


```

delete 和 TRUNCATE 区别

- 相同点： 都能删除数据，都不会删除表结构
- 不同：
  - TRUNCATE 重新设置自增列 计数器会归零
  - TRUNCATE 不会影响事务

了解即可：`delete删除的问题` 重启数据库，现象

- innoDB 自增列会从1开始（存在内存当中，断电即失）
- MyISAM 继续从上一个自增量开始（存在文件中，不会丢失）

## DQL查询数据

**(Data Query Language) :数据查询语言**

- 所有的查询操作都用它 Select
- 简单的查询，复杂的查询它都能做
- **数据库中最核心的语言**
- 使用频率最高的语言

**select语法： `SELECT 字段 ... FROM 表`**

```sql
-- 查询  SELECT 字段 FROM 表

-- 查询指定字段  such as
SELECT `StudentNo`,`StudentName` FROM student

-- 别名，给结果起一个名字 AS   可以给字段起别名 也可以给表起别名
SELECT `StudentNo` AS 学号,`StudentName`AS 学生姓名 FROM student AS S

-- 函数 Concat(a,b)
SELECT CONCAT('姓名：',StudentName) AS 新名字 FROM student

-- 查询一下有哪些同学参加了考试，成绩
SELECT * FROM result -- 查询全部的考试成绩
-- 查询有哪些同学参加了考试
SELECT `studentNo` FROM result 
-- 发现重复数据，去重
SELECT DISTINCT `studentNo` FROM result 

SELECT VERSION()  --查询系统版本（函数）
SELECT 100*3-1 AS 计算结果 -- 用来计算（表达式）
SELECT @@auto_increment_increment --查询自增的步长（变量）

-- 学员考试成绩+1 分 查看
SELECT `StudentNo`,`StudentResult`+1 AS '提分后' FROM result

```

模糊查询：比较运算符

```sql
--  查询姓刘的同学
-- like结合 %（代表0到任意字符）  _(一个字符)
SELECT `StudentNo`,`StudentName` FROM `student`
WHERE StudentName LIKE '刘%';

-- 查询姓刘的同学，名字后只有一个字
SELECT `StudentNo`,`StudentName` FROM `student`
WHERE StudentName LIKE '刘_';

-- 查询姓刘的同学，名字后只有两个字
SELECT `StudentNo`,`StudentName` FROM `student`
WHERE StudentName LIKE '刘__';

-- 查询名字中间有嘉字的同学 %嘉%
SELECT `StudentNo`,`StudentName` FROM `student`
WHERE StudentName LIKE '%嘉%';



===================IN(具体的一个或者多个值)===========================
-- 查询1001 1002 1003 学员信息
SELECT `StudentNo`,`StudentName` FROM `student`
WHERE StudentNo = 1001
SELECT `StudentNo`,`StudentName` FROM `student`
WHERE StudentNo = 1002
SELECT `StudentNo`,`StudentName` FROM `student`
WHERE StudentNo = 1003

SELECT `StudentNo`,`StudentName` FROM `student`
WHERE StudentNo IN (1001,1002,1003);

-- 查询在北京的学生
SELECT `StudentNo`,`StudentName` FROM `student`
WHERE `Address` IN('安徽','河南洛阳');


===================NULL NOT NULL===================================
-- 查询地址为空的学生 null ''
SELECT `StudentNo`,`StudentName` FROM `student`
WHERE address=''OR address IS NULL

-- 查询有出生日期的同学  不为空
SELECT `StudentNo`,`StudentName` FROM `student`
WHERE `BornDate` IS NOT NULL;


```

**联表查询(重难点)**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200708013558863.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMzOTU2NTM2,size_16,color_FFFFFF,t_70)

| Inner join | 如果表中至少有一个匹配，就返回行             |
| ---------- | -------------------------------------------- |
| left join  | 即使左表中没有匹配，也会从左表中返回所有的值 |
| right jion | 即使右表中没有匹配，也会从右表中返回所有的值 |

```sql
======================联表查询 join ==============================
-- 查询参加考试的同学 （学号，姓名，考试编号，分数）

SELECT * FROM student 
SELECT * FROM result

/*
1. 分析需求，分析查询的字段来自哪些表
2.确定使用哪种连接查询？7种
确定交叉点（这两个表中哪个数据是相同的）
判断的条件： 学生表中 studentNo = 成绩表中 studentNo 

*/

-- JION（表） ON （判断的条件）连接查询
-- where 等值查询
SELECT studentNo,studentName,SubjectNo,StudentResult
FROM student AS s
INNER JOIN result AS r
WHERE s.studentNo=r.studentNo

--Right Join
SELECT s.studentNo,studentName,SubjectNo,StudentResult
FROM student AS s
RIGHT JOIN result AS r
ON s.studentNo = r.studentNo

--LEFT Join
SELECT s.studentNo,studentName,SubjectNo,StudentResult
FROM student AS s
LEFT JOIN result AS r
ON s.studentNo = r.studentNo
```

**自连接**

自己的表跟自己的表连接，核心：**一张表拆为两张一样的表**

**分页和排序**

**分页语法 `limit(查询起始下标，pagesize)`**

```sql
-- 为什么要分页
-- 缓解数据库压力，给人的体验更好


-- 分页，每页显示五条数据

-- 语法： limit 当前页，页面的大小
-- limit 0,5 1-5
-- limit 1,5 1-5
-- limit 6,5
SELECT s.`StudentNo`,`StudentName`,`SubjectName`,`StudentResult`
FROM student s
INNER JOIN `result` r
ON s.`StudentNo`=r.`StudentNo`
INNER JOIN `subject` sub
ON r.`subjectNo`=sub.`subjectNo`
WHERE subjectName='数据结构-1'
ORDER BY StudentResult ASC
LIMIT 0,5

-- 第一页 limit 0,5
-- 第二页 limit 5,5
-- 第三页 limit 10,5
-- 第N页 limit 5*（n-1）,5


-- 排序：  升序ASC  降序  DESC
SELECT  xx
FROM xx
JOIN xx
WHERE  xx
ORDER BY  xx
ASC   ||  DESC
```

**子查询（本质：在where语句中嵌套一个子查询语句（复合嵌套））**

```sql
-- ===========================where=========================

-- 1.查询 数据库结构-1的所有考试结构（学号，科目编号，成绩） 降序
-- 方式一： 连接查询
SELECT `StudentNo`,r.`SubjectName`,`StudentResult`
FROM `result` r
INNER JOIN `subject` sub
ON r.SubjectNo = sun.SubjectNo
WHERE subjectName = '数据库结构-1'
ORDER BY StudentResult DESC

-- 方式二：使用子查询(由里及外)
SELECT `StudentNo`,r.`SubjectName`,`StudentResult`
FROM `result`
WHERE StudentNo=(
	SELECT SubjectNo FROM  `subject` 
    WHERE SubjectName = '数据库结构-1'
)
ORDER BY StudentResult DESC


-- 分数不少于80分的学生的学号和姓名
SELECT DISTINCT s.`StudentNo`,`StudentName`
FROM student s
INNER JOIN result r
ON r.StudentNo = s.StudentNo
WHERE StudentResult>=80

-- 在这个基础上 增加一个科目 ，高等数学-2
SELECT DISTINCT s.`StudentNo`,`StudentName`
FROM student s
INNER JOIN result r
ON r.StudentNo = s.StudentNo
WHERE StudentResult>=80 AND `SubjectNo`=(
    SELECT Subject FROM `subject`
    WHERE SubjectName='高等数学-2'
)

-- 查询课程为 高等数学-2 且分数不小于80分的同学的学号和姓名
SELECT s.`StudentNo`,`StudentName`
FROM student s
INNER JOIN result r
ON s.StudentNo = r.StudentNo
INNER JOIN `subject` sub
ON r.`SubjectName`='高等数学-2'
WHERE `SubjectaName`='高等数学-2' AND StudentResult >=80


-- 再改造 (由里即外)
SELECT `StudentNo`,`StudentName` FROM student
WHERE StudentNo IN(
SELECT StudentNo result WHERE StudentResult >80 AND SubjectNo =(
SELECT SubjectNo FROM `subject` WHERE `SubjectaName`='高等数学-2'
)
)
```

**分组**

```sql
-- 查询不同课程的平均分，最高分，最低分，平均分大于80
-- 核心：（根据不同的课程分组）

SELECT `SubjectName`,AVG(StudentResult),MAX(StudentResult)
FROM result r
INNER JOIN `Subject` sub
ON r.SubjectNo=sub.SubjectNo

GROUP BY r.SubjectNo -- 通过什么字段来分组
HAVING AVG(StudentResult)>80

```

## 事务(面试常问)

**什么是事务**
**要么都成功，要么都失败**

- SQL执行， A给B转账 A 1000–> 200 B200
- SQL 执行， B收到A的钱 A800 — B400

将一组SQL放在一个批次中执行

```
事务原则 ： ACID原则 原子性，一致性，隔离性，持久性 （脏读，幻读…）
```

- **原子性（Atomicity）-------要么都成功，要么都失败**

- **一致性（Consistency）-------事务前后的数据完整性要保持一致**

- **持久性（Durability）–事务提交-------事务一旦提交就不可逆转，被持久化到数据库中**

- **隔离性-------事务产生多并发时，互不干扰**

**隔离产生的问题**

**脏读：**
指一个事务读取了另外一个事务未提交的数据。

**不可重复读：**
在一个事务内读取表中的某一行数据，多次读取结果不同。（这个不一定是错误，只是某些场合不对）

**虚读(幻读)**
是指在一个事务内读取到了别的事务插入的数据，导致前后读取不一致。
（一般是行影响，多了一行）

**执行事务:**

```sql
-- mysql 自动开启事务提交
SET autocommit=0 -- 关闭
SET autocommit=1 -- 开启（默认的）

-- 手动处理事务
SET autocommit =0 -- 关闭自动提交

-- 事务开启

START TRANSACTION -- 标记一个事务的开始，从这个之后的SQP都在同一个事务内

INSERT XX
INSERT XX

-- 提交 ： 持久化(成功)
COMMIT 
-- 回滚：  回到原来的样子（失败）
ROLLBACK
-- 事务结束
SET autocommit = 1 -- 开启自动提交
-- 了解
SAVEPOINT 保存点名称 -- 设置一个事务的保存点
ROLLBACK TO SAVEPOINT 保存点名 -- 回滚到保存点
RELEASE SAVEPOINT 保存点 -- 删除保存点
```

## 索引

**在一个表中，主键索引只能有一个，唯一索引可以有多个**

**主键索引 （PRIMARY KEY）**

唯一的标识，主键不可重复，只能有一个列作为主键

**唯一索引 （UNIQUE KEY）`**

避免重复的列出现，唯一索引可以重复，多个列都可以标识唯一索引

**常规索引（KEY/INDEX）**

默认的，index,key关键字来设置

**全文索引（FULLTEXT）**

在特点的数据库引擎下才有，MyISAM

快速定位数据

```sql
-- 索引的使用
-- 1.在创建表的时候给字段增加索引
-- 2.创建完毕后，增加索引

-- 显示所有的索引信息
SHOW INDEX FROM 表

-- 增加一个索引
ALTER TABLE 表 ADD FULLTEXT INDEX 索引名（字段名）

-- EXPLAIN 分析sql执行状况
EXPLAIN SELECT * FROM student -- 非全文索引

```

测试索引

```sql
CREATE TABLE `app_user` (
`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) DEFAULT '',
`email` VARCHAR(50) NOT NULL,
`phone` VARCHAR(20) DEFAULT '',
`gender` TINYINT(4) UNSIGNED DEFAULT '0',
`password` VARCHAR(100) NOT NULL DEFAULT '',
`age` TINYINT(4) DEFAULT NULL,
`create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

-- 插入100万数据
DELIMITER $$ --  写函数之前必写
CREATE FUNCTION mock_data()
RETURNS INT 
BEGIN
DECLARE num INT DEFAULT 1000000;
DECLARE i INT DEFAULT 0;

WHILE i<num DO
-- 插入语句
INSERT INTO app_user(`name`,`email`,`phone`,`gender`,`password`,`age`)
VALUE(CONCAT('用户',i),'534240118@qq.com',FLOOR (CONCAT('18',RAND()*9999999)),FLOOR (RAND()*2),
UUID(),FLOOR (RAND()*100));

SET i = i+1;
END WHILE;
RETURN i;


END;

INSERT INTO app_user(`name`,`email`,`phone`,`gender`,`password`,`age`)
VALUE(CONCAT('用户',i),'534240118@qq.com',FLOOR (CONCAT('18',RAND()*9999999)),FLOOR (RAND()*2),
UUID(),FLOOR (RAND()*100))


SELECT mock_data();

SELECT * FROM app_user WHERE `name`='用户9999' -- 接近半秒

EXPLAIN SELECT * FROM app_user WHERE `name`='用户9999'  -- 查询99999条记录

-- id _ 表名_字段名
-- create index on 字段
CREATE INDEX id_app_user_name ON app_user(`name`); -- 0.001 s
EXPLAIN SELECT * FROM app_user WHERE `name`='用户9999'  -- 查询一条记录
```

索引原则

- 索引不是越多越好
- 不要对经常变动的数据加索引
- 小数据量的表不需要加索引
- 索引一般加在常用来查询的字段上

> 索引的数据结构

Hash 类型的索引

Btree: 默认innodb 的数据结构

## 三大范式

为什么需要数据规范化？

- 信息重复
- 更新异常
- 插入异常
- 删除异常
  - 无法正常显示异常
- 删除异常
  - 丢失有效的信息

==**三大范式**==

**第一范式（1NF）**

**原子性：保证每一列不可再分**

**第二范式（2NF）**

**前提：满足第一范式**

**每张表只描述一件事情**

**第三范式（3NF）**

**前提：满足第一范式和第二范式**

**第三范式需要确保数据表中的每一列数据都和主键直接相关，而不能间接相关。**

**（规范数据库的设计）**

==**规范性和性能的问题**==

关联查询的表，不得超过三张表

- 考虑商业化的需求和目标（成本和用户体验） 数据库的性能更加重要
- 再规范性能的问题的时候，需要适当的考虑一下，规范性
- 故意给某些表加一些冗余的字段（从多表，变成单表）
- 故意增加一些计算列（从大数据量降低为小数据量的查询：索引）

