### Clickhouse学习文档

clickhouse是一款MPP架构的列式存储数据库。

提供SQL作为查询语言。

对于大小写是敏感的。

clickhose一个节点只能有一个分片。所以如果要实现1分片+1副本的话，那就需要两个节点。

#### OLAP

> 联机分析

#### 列式存储

列式存储可以有效的减少查询时所需要扫描的数据量。

列式存储对于数据压缩来说更友好。

#### 向量化执行

“单条指令操作多条数据”  -  数据级并行

#### 多线程与分布式

不仅通过向量化在数据级实现单指令多数据并行处理，还支持线程级并行。因为SIMD不适合用于带有较多分支判断的场景，因此，Clickhouse使用了多线程技术来和向量化执行形成了互补。

#### 分区与分片？？

**分区**：纵向扩展，利用多线程原理。针对本地数据而言。

**分片**（Shard）：横向扩展，利用分布式原理。分片是一个逻辑概念，时间的物理承载还是由副本承担。

#### 多主架构  -- Multi-Master

每个节点角色对等，所有节点功能相同，**规避了单点故障**的问题。适用于多数据中心以及异地多活的场景。

#### Column和Field

**Column**：当作是一列，然后获取一列的时候，可以直接使用类似ColumnString、ColumnArray等接收。

**Field**：当作是一列中的单个值。当获取这单个值的时候，可以直接使用String、Array等数据类型和处理逻辑进行相关处理。

#### 本地表与分布式表

本地表等同于一份数据的分片。

分布式表本身不存储任何数据，知识本地表的访问带代理。

#### DataType -- 序列化与反序列化

IDataType接口定义了许多序列化相关的方法，正反序列化成对出现。具体方法的实现有对应的数据类型承载，而这些数据类型往往会引用Column和Field对象的书类型。例如：DataType对应ColumnString等。

#### Block

Block是将Column、DataType等对象进行抽象和封装。可以仅仅通过Block对象就完成一系列的数据操作。**Block没有直接聚合Column和DataType对象，而是通过ColumnWithTypeAndName对象进行间接引用。**

**Block流**：IBlockInputStream负责数据读取与关系运算。IBlockOutputStream负责将数据输出到下一环节。这两个接口有着很多的实现类。其中输入输出主要分为三种：1、用于处理数据定义的DDL操作。2、处理关系运算。3、与每个表引擎呼应。

#### IStorage

- clickhouse中**实际上并没有Table对象**，而是直接使用哦个IStorage接口指代数据表。不同的表引擎由IStorage不同的实现类实现。

- IStorage**主要负责**数据的定义、查询与写入。

- **对Table发起一次操作的过程**：1、接收AST查询语句。2、根据AST返回指定列数据。3、将数据交给Interpreter解释器做进一步处理（对数据的进一步加工、计算和过滤）。

#### Parser与Interpreter

Parser将sql语句解析成AST语法树形式。不同的sql，Parser也不同。

Interpereter：xxx

#### Functions和Aggregate Functions

普通函数（**IFunction接口**）和聚合函数（**IAggregateFunction接口**）。

#### 数据类型

基础类型、复合类型、特殊类型

#### 卸载和装载分区

常用于**分区数据的迁移**和**备份场景**

#### 备份与还原分区

---

### 数据字典<font color="red">P80</font>？？？？

字典数据常驻内存。非常适合保存常量或者经常使用的维度表数据。避免不必要的join查询。

- 内置字典
- 扩展字典

内置字典目前没有内置任何数据。config.xml中的**path_to_regions_hierarchy_file**和**path_to_regions_names_files**打开。

扩展字典。config.xml中的**dictionaries_config**配置项指定。

---

### 表引擎

https://blog.csdn.net/vkingnew/article/details/106988056

**<font color="red">MergeTree</font>**与其家族系列*MergeTree

> MergeTree表引擎支持**主键索引**，**数据分区**、**数据副本**、**数据采样**等，**支持Alter**操作等

MergeTree以数据片段的形式写入磁盘，并且定期合并这些数据片段。



P108





CollapsingMergerTree

ReplicatedMergerTree

Log



shard & replica

聚合操作

