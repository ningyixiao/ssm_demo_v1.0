### 使用说明
#### step1: 本地先通过maven命令创建好web app项目

      mvn archetype:generate -DgroupId=com.nyx -DartifactId=ssm_demo -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
      
> 不新建其实也可以，那就直接进行step2，将下载的项目文件名改为自己的项目文件名，然后将其中pom.xml文件中记录的项目信息改为自己要创建的项目信息，再进行step3操作。

#### step2: clone该项目到本地
`git clone https://github.com/ningyixiao/ssm_demo_v1.0.git`

#### step3: 将项目改为自己的项目
- 将src文件夹,jetty-http.xml,jetty.xml复制到本地新建的项目中，将pom.xml中没有的部分复制，记得检测pom文件中jetty的配置信息
- 更改src/main/java/下的目录名
- 更改src/main/java/下的所有java文件中的package以及import的信息
- 检测src/main/resources/下的所有配置文件，按照上两项更改来修改配置信息

#### step4: 编译一下查看target目录
- `mvn compile`
- 确保控制台没有报错
- 确保target/classes/下的目录以及文件没有问题

#### step5: 搭建本地开发环境
- 安装nginx

     1. 所有的http请求都先通过nginx来处理显示，java的部分通过nginx的proxy_pass反向代理到jetty启动的端口。基本上是一个前后端分离的形式，nginx接收到前端页面的ajax请求，将其代理到jetty的端口交由后端处理，然后返回一个json类型的数据给前端页面，前端页面接收后进行数据的处理和显示。 
     2. src/main/webapp/下的index.html就是用来测试项目的前端页面，需要放置在nginx的站点文件夹中(创建一个文件夹ssm_demo)。页面打开里面有三个按钮，分别测试ExampleController里面的三个方法。
     3. 大致的nginx配置如下
     ```
     location /api/ {
          proxy_pass http://localhost:8081/ssm_demo/;
     }     
     ```
     4. 上述的配置/api/表示nginx会将所有符合该模式的请求代理到jetty，端口号以及contextPath可以在项目里面的pom.xml文件中更改。
  
- 安装mysql

     1. 找到mysql配置文件，修改字符集为utf8mb4
     2. 找到src/main/webapp/下的example.sql文件，先用root用户执行该文件，创建好数据库example，以及数据表Example
     3. 给数据库example创建一个新用户，只有读和写权限，用户名和密码参照src/main/resources/下的spring-mybatis.xml里面的数据源信息
    
#### step6: 运行项目
- `mvn clean`
- `mvn jetty:run`

#### step7: 用户页面上测试项目运行情况
- chrome打开nginx的端口(localhost:8080/ssm_demo/index.html)
- 打开开发者工具，以便查看数据包具体情况
- 先点击注册按钮，再点击登录按钮，最后点击token验证按钮


  
