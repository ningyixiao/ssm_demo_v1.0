### 使用说明
#### step1: 本地先通过maven命令创建好web app项目
      mvn archetype:generate -DgroupId=com.nyx -DartifactId=ssm_demo -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false
      
#### step2: clone该项目到本地
`git clone https://github.com/ningyixiao/ssm_demo_v1.0.git`

#### step3: 将项目改为自己的项目
- 将src文件夹,jetty-http.xml,jetty.xml复制到本地新建的项目中，将pom.xml中没有的部分复制
- 更改src/main/java/下的目录名
- 更改src/main/java/下的所有java文件中的package以及import的信息
- 检测src/main/resources/下的所有配置文件，按照上两项更改来修改配置信息

#### step4: 编译一下查看target目录
- `mvn compile`
- 确保控制台没有报错
- 确保target/classes/下的目录以及文件没有问题

#### step5: 搭建本地开发环境
- 安装nginx

    1. 这里静态资源通过nginx来处理显示，java的部分通过nginx的proxy_pass反向代理到jetty启动的端口。基本上是一个前后端分离的形式，nginx接收到前端页面的ajax请求，将其代理到jetty的端口交由后端处理，然后返回一个json类型的数据给前端页面，前端页面接收后进行数据的处理和显示。
    
    2. src/main/webapp/下的index.html就是用来测试项目的前端页面，需要放置在nginx的站点文件夹中。页面打开里面有三个按钮，分别测试ExampleController里面的三个方法。
    
    3. 大致的nginx配置如下
  
    location /api/ {
        proxy_pass http://localhost:8081/ssm_demo/;
    }
        
- 安装mysql

