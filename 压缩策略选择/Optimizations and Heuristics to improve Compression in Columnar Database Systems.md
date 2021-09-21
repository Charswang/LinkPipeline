##### [Optimizations and Heuristics to improve Compression in Columnar Database Systems](https://arxiv.org/abs/1609.07823)

1、研究了压缩列数组、后字典编码的几种压缩方法

2、介绍两种新的压缩技术优化——块大小优化的聚类编码和块大小优化的间接编码

3、提出了在常用压缩方案中**选择最佳编码**的启发式算法。**选择的是最佳编码而不是最佳算法？**

---

##### Introduction

本文主要讨论了柱状数据库系统中各种最先进的压缩方案。并进一步提出优化和启发式方法，以获得正确的压缩方案。

**字典编码相关？**

---

### 4、 ENCODING DECISION HEURISTICS

