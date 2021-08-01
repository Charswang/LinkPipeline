## Maven生命周期

maven生命周期主要包括clean、default以及site三种；

#### clean周期主要包括pre-clean、clean 和 post-clean

- pre-clean：执行一些清理前需要完成的工作
- clean：清理上一次构建生成的文件
- post-clean：执行一些清理后需要完成的工作

#### default周期：定义了<font color="red">真正构建时说需要执行的所有步骤</font>，是所有生命周期中<font color="red">最核心</font>的部分

- validate
- initzlize
- generate-sources
- process-sources：处理项目主资源文件，一般来说是对 src/main/resources 目录的内容进行变量替换等工作后，复制到项目输出的主 classpath 目录中
- generate-resources
- process-resources
- **compile**：编译项目的主源码，一般来说是对 src/main/java 目录的内容进行编译后，复制到项目输出的主 classpath 目录中
- process-classes
- generate-test-sources
- process-test-sources：处理项目测试资源文件，一般来说是对 src/test/resources 目录的内容进行变量替换等工作后，复制到项目输出的测试 classpath 目录中
- generate-test-resources
- process-test-resources
- test-compile：编译项目的测试代码，编译项目的主源码，一般来说是对 src/test/java 目录的内容进行编译后，复制到项目输出的测试 classpath 目录中
- process-test-classes
- **test**：使用单元测试框架运行测试，测试代码不会被打包或部署
- prepare-package
- **package**：接受编译好的代码，打包成可发布的格式，如JAR
- pre-integration-test
- integration-test
- post-integration-test
- verify
- **install**：将包安装到Maven本地仓库，供本地其他 Maven 项目使用
- deploy：将最终的包复制到远程仓库，供其他开发人员和Maven项目使用

#### site 生命周期主要是为了生成站点

- pre-site：执行一些在生成项目站点之前需要完成的工作
- site：生成项目站点文档
- post-site：执行一些在生成项目站点之后需要完成的工作
- site-deploy：生成项目报告，站点，发布站点。将项目放到站点上去

---

<font color="red">**在一个生命周期中，运行某个阶段的时候，它之前的所有阶段都会被运行**</font>。这是Maven很重要的一个规则，可以大大简化命令行的输入。也就是说，**mvn clean** 等同于 **mvn pre-clean clean** ，如果我们运行 **mvn post-clean** ，那么 pre-clean，clean 都会被运行。

 ## 常用maven命令

|                             命令                             |                             说明                             |
| :----------------------------------------------------------: | :----------------------------------------------------------: |
|                         mvn –version                         |                         显示版本信息                         |
|                          mvn clean                           |       清理项目生产的临时文件,一般是模块下的target目录        |
|                         mvn compile                          |        编译源代码，一般编译模块下的src/main/java目录         |
|                           mvn test                           |        测试命令,或执行src/test/java/下junit的测试用例        |
|                         mvn package                          |    项目打包工具,会在模块下的target目录生成jar或war等文件     |
|                         mvn install                          |    将打包的jar/war文件复制到你的本地仓库中,供其他模块使用    |
|                          mvn deploy                          |     将打包的文件发布到远程参考,提供其他人员进行下载依赖      |
|                           mvn site                           |                    生成项目相关信息的网站                    |
|                     mvn dependency:tree                      |                    打印出项目的整个依赖树                    |
|                    mvn archetype:generate                    |                   创建Maven的普通java项目                    |
|                        mvn tomcat:run                        |                  在tomcat容器中运行web应用                   |
|                    **mvn clean install**                     | **这个命令执行clean 和default生命周期阶段**，实际执行的为clean 生命周期的 pre-clean 和 clean 阶段；**default 生命周期的 validate 到 install 阶段** |
| **mvn clean install -Dmaven.test.skip=true -s settings.xml路径** |    **跳过测试阶段，并且指定maven settings.xml文件的路径**    |
|                           mvn test                           | 该命令调用 default 生命周期的 test阶段，实际执行的阶段从 validate 到 test 阶段。 |

#### 记录下其他命令【有用到，但不会的】