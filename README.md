**skipper的demo项目**
    
    该项目旨在将平时学到的通用型工具或者框架集成起来，方便以后学习查看。
    
此项目中存在很多模块，暂时不拆分，以后可考虑拆分


activiti层存在的意义

    对activiti进行封装并以接口形式暴露

api层存在的意义

    api层作为dubbo协议对外暴露的部分，暴露给web层以及外部其他接口。
    
boot层存在的意义

    boot层作为springboot初始化层，作为springboot的配置设置。
    
dao层存在的意义

    dao层作为数据库交互层，主要负责mybatis集成，sql文，entity，
    以及日常数据库更新脚本存储和运行的位置
    
elasticsearch层存在的意义

    主要负责搜索服务相关的代码，包括es中index、type的创建，查询服务的对外暴露。
    
helper层存在的意义

    主要负责一些通用的util或者exception或者其他封装。
    
service层存在的意义

    主要负责主要业务逻辑的实现。
    
web层存在的意义

    主要负责与外部服务的交互，通过http协议进行暴露。