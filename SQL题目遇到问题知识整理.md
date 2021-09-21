### Leetcode 178、分数排名

> 可以利用count() + >=来判断分数的排名；

```sql
select count(distinct b.score) from scores as b where b.score >= a.score
```

这里的意思是：查找大于等于a的分数的个数。这样就可以得到a的排名了。



# sql查询效率优化事项

DDL：针对数据库、表、视图等的操作。

DML：增删改查数据的操作

