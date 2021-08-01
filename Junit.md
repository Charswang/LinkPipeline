### Junit注解

|     注解      |                             解释                             |
| :-----------: | :----------------------------------------------------------: |
|     @Test     |             测试注解，标记一个方法可以是测试用例             |
|    @Before    | 该方法必须在类中的每个测试之前执行,以便执行某些必要的先决条件。每个**测试方法**都会运行一次 |
|    @After     | 该方法在每项测试后执行（如执行每一个测试后重置某些变量，删除临时变量等）。每个**测试方法**都会运行一次 |
| @BeforeClass  | 附着在**静态方法**必须执行一次并在类的所有测试之前，这种情况一般用于测试计算、共享配制方法(如数据库连接)。每个**测试类**只运行一次 |
|  @AfterClass  | 所有测试在JUnit测试用例类后执行，AlterClass注解可以使用以**清理一些资源**（如数据库连接），注意：方法必须为**静态方法**。每个**测试类**只运行一次 |
|    @Ignore    |                      暂时不测试这个用例                      |
|   @Runwith    | 放在测试类名之前，用来确定这个类怎么运行的【**通过哪种测试运行器来运行**】。也可以不标注，会使用默认运行器。@RunWith(XXX.class) |
| @SuiteClasses |                    用于套件测试【没用过】                    |
|  @Parameters  |                 用于使用参数化功能【没用过】                 |

### Junit断言

注意使用；

|                             断言                             |                             描述                             |
| :----------------------------------------------------------: | :----------------------------------------------------------: |
| void assertArrayEquals([String message],expectedArray,resultArray) | 断言预期数组和结果数组相等，数组类型可能是int，short，long，byte，char，Object |
| void assertEquals([String message],expected value,actual value) | 断言两个值相等。值类型可能是int，short，long，byte，char，Object，第一个参数是一个可选字符串消息 |
|     void assertFalse([String message],boolean condition)     |                       断言一个条件为假                       |
|     void assertTrue([String message],boolean condition)      |                       断言一个条件为真                       |
| void assertNotSame(String message],java.lang.Object unexpected,java.lang.Object actual) |                断言两个对象不是引用同一个对象                |
| void assertSame([String message],java.lang.Object expected,java.lang.Object actual) |                  断言两个对象引用相同的对象                  |
|  void assertNull([String message],java.lang.Object object)   |                   断言一个对象为空（null）                   |
| void assertNotNull([String message],java.lang.Object object) |                  断言一个对象不为空（null）                  |

等等还有很多。。。

注意记忆，练习；