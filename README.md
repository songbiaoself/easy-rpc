# easy-rpc

#### 介绍
自己动手实现一个简单的rpc框架，一个非常适合入门的rpc demo

#### 软件架构
jdk1.8+maven+socket+fastjson
![思维导图](https://images.gitee.com/uploads/images/2021/0331/221757_8df57b82_5489834.png "RPC思维导图.png")

通信采用tcp协议


#### 安装教程

1. 需提前安装好maven
2. 导入开发工具即可


#### 使用说明

1.  先启动服务端 后启动客户端
2.  编写rpc测试参考客户端示例
3.  编写服务端新接口参考服务端接口实例  

#### 运行demo

1. 服务端
![暴露api实现](https://images.gitee.com/uploads/images/2021/0422/152504_c3b4f2ff_5489834.png "屏幕截图.png")
![服务端控制台](https://images.gitee.com/uploads/images/2021/0422/152552_c5554211_5489834.png "屏幕截图.png")


2. 客户端
![客户端web](https://images.gitee.com/uploads/images/2021/0422/152721_bc3cb401_5489834.png "屏幕截图.png")
![客户端控制台](https://images.gitee.com/uploads/images/2021/0422/152843_b23baabb_5489834.png "屏幕截图.png")

#### 目前已知存在问题

1. 方法反射包装类的问题（已解决）
2. 方法反射多态的问题（已解决）

#### 参与贡献

若发现本项目代码中存在问题，还请指出。

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
