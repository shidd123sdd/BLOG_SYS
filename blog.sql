/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.56 : Database - blogsys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blogsys` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blogsys`;

/*Table structure for table `column_meta` */

DROP TABLE IF EXISTS `column_meta`;

CREATE TABLE `column_meta` (
  `table_id` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `data_index` varchar(50) DEFAULT NULL,
  `key` varchar(50) DEFAULT NULL,
  `width` varchar(50) DEFAULT NULL,
  `sort_order` int(10) DEFAULT NULL,
  `align` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `column_meta` */

insert  into `column_meta`(`table_id`,`title`,`data_index`,`key`,`width`,`sort_order`,`align`) values ('label_info','标签名称','labelName','labelName','15%',1,''),('label_info','是否显示','visiable','visiable','10%',3,'center'),('label_info','描述','description','description','20%',7,''),('label_info','起始日','startDate','startDate','15%',5,'center'),('label_info','终止日','endDate','endDate','15%',6,'center'),('label_info','层级','level','level','5%',2,'center'),('note_info','主标题','offTitle','offTitle','20%',1,'center'),('note_info','副标题','subTitle','subTitle','20%',2,'center'),('note_info','标签','labelListIds','labelListIds','25%',3,'center'),('note_info','发布日期','createTime','createTime','15%',4,'center'),('art_info','标题','offTitle','offTitle','30%',1,'center'),('art_info','发布日期','createTime','createTime','20%',2,'center');

/*Table structure for table `label_info` */

DROP TABLE IF EXISTS `label_info`;

CREATE TABLE `label_info` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `label_name` varchar(50) NOT NULL,
  `level` int(11) DEFAULT NULL,
  `parent_label_id` bigint(100) DEFAULT NULL,
  `parent_label_name` varchar(50) DEFAULT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `is_show` tinyint(1) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `label_info` */

insert  into `label_info`(`id`,`label_name`,`level`,`parent_label_id`,`parent_label_name`,`start_date`,`end_date`,`is_show`,`description`) values (1,'java',1,NULL,NULL,'2020-07-08','2020-08-28',1,'包含 javaSE、spring、卡夫卡等ss'),(2,'web',1,NULL,NULL,'2020-07-08','2020-08-28',1,''),(3,'spring',2,1,'java','2020-07-08','2020-08-28',1,''),(4,'mvc',3,3,'spring','2020-07-08','2020-08-28',1,'springMVC'),(32,'java-c',4,4,'mvc','2020-07-09','2020-07-16',1,'sadf');

/*Table structure for table `note_info` */

DROP TABLE IF EXISTS `note_info`;

CREATE TABLE `note_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `off_title` varchar(100) DEFAULT NULL,
  `sub_title` varchar(100) DEFAULT NULL,
  `labels` varchar(200) DEFAULT NULL,
  `dom_str` mediumtext,
  `content` mediumtext,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `img_path` varchar(200) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `note_info` */

insert  into `note_info`(`id`,`off_title`,`sub_title`,`labels`,`dom_str`,`content`,`create_time`,`update_time`,`img_path`,`type`) values (1,'JavaBeans','dispatchServlet处理流程','1;3;4','zzzzzzzzzzzzzzzzz','zzzzzzzzzzzzzz','2019-01-01 12:00:00','2020-07-27 12:08:08','http://localhost:9000/2020/8/4/1596522985951.png',1),(2,'SringMvc','dispatchServlet处理流程','1;3;4','<p>aaaaaaaaaaaaaaaa</p>\n','aaaaaaaaaaaaaaaa','2019-01-01 00:00:00','2020-07-27 12:08:28','http://localhost:9000/2020/8/4/1596523684169.png',1),(3,'java','dispatchServlet处理流程','2','xxxxxxxxxxxxxxx','xxxxxxxxxxxxxxxx','2019-01-01 00:00:00',NULL,NULL,1),(5,'vue','sfasfafasdfal;lklkasdfk','1;3;4','vvvvvvvvvvvvvv','vvvvvvvvvvvvv','2019-01-01 00:00:00',NULL,NULL,1),(6,'spring','jlksjdfkjasdfjaldfjlasd','1;3;4','ccccc','cccccc','2019-01-01 00:00:00',NULL,NULL,1),(8,'JavaBeans','dispatchServlet处理流程','1;3;4','bbbb','bbbbbb','2019-01-01 12:00:00','2020-07-27 12:08:08',NULL,1),(9,'SringMvc','dispatchServlet处理流程','1;3;4','<p>aaaaaaaaaaaaaaaa</p>\n','aaaaaaaaaaaaaaaa','2019-01-01 00:00:00','2020-07-27 12:08:28',NULL,1),(10,'java','dispatchServlet处理流程','2','eeeeeee','eeeeee','2019-01-01 00:00:00',NULL,NULL,1),(11,'vue','sfasfafasdfal;lklkasdfk','1;3;4','fffff','fffff','2019-01-01 00:00:00',NULL,NULL,1),(12,'spring','jlksjdfkjasdfjaldfjlasd','1;3;4','gggggg','gggggg','2019-01-01 00:00:00',NULL,NULL,1),(13,'JavaBeans','dispatchServlet处理流程','1;3;4','hhhhh','hhhhhhh','2019-01-01 12:00:00','2020-07-27 12:08:08',NULL,1),(14,'SringMvc','dispatchServlet处理流程','1;3;4','<p>aaaaaaaaaaaaaaaa</p>\n','aaaaaaaaaaaaaaaa','2019-01-01 00:00:00','2020-07-27 12:08:28',NULL,1),(15,'java','dispatchServlet处理流程','2','iiiiiiiiiiiiiii','iiiiiiiiiiiii','2019-01-01 00:00:00',NULL,NULL,1),(16,'vue','sfasfafasdfal;lklkasdfk','1;3;4','jjjjjjjjjjjj','jjjjjjjjjjjjjjjjj','2019-01-01 00:00:00',NULL,NULL,1),(17,'spring','jlksjdfkjasdfjaldfjlasd','1;3;4','kkkkkkkkkkkkkkkkk','kkkkkkkkkkkkkkk','2019-01-01 00:00:00',NULL,NULL,1),(18,'解决跨域问题 ','s been blocked by ','1;3;4;2','<p>坑1：</p>\n<p>由于跨域， 画布被污染，不能调用 toBlob(), toDataURL() 或 getImageData() 方法，调用它们会抛出安全错误。</p>\n<p>按网上说的做，</p>\n<pre><code>    配置 useCORS: true,\n\n    Nginx添加请求头\n\n            add_header Access-Control-Allow-Origin *;\n            add_header Access-Control-Allow-Credentials: true;\n</code></pre>\n<p>成功解决了画布被污染的问题。然而这种解决方法只可以解决你自己服务器的问题，你总不能去微信或其他第三方服务器添加请求头吧。。。更大的坑来了</p>\n<p>坑2：</p>\n<pre><div class=\"hljs\"><code class=\"lang-java\">  <span class=\"hljs-meta\">@Override</span>\n    <span class=\"hljs-function\"><span class=\"hljs-keyword\">public</span> Map&lt;String,Object&gt; <span class=\"hljs-title\">searchLabel</span><span class=\"hljs-params\">(String labelName)</span> </span>{\n        List&lt;LabelEntity&gt; labelList = labelDao.searchLabel(labelName);\n        Map&lt;String,Object&gt; resMap = <span class=\"hljs-keyword\">new</span> HashMap&lt;&gt;();\n        <span class=\"hljs-keyword\">if</span>(labelList.size() == <span class=\"hljs-number\">0</span> ) {\n            resMap.put(<span class=\"hljs-string\">\"labelList\"</span>,<span class=\"hljs-keyword\">null</span>);\n            <span class=\"hljs-keyword\">return</span> resMap;\n        }<span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span>(labelName !=<span class=\"hljs-keyword\">null</span> &amp;&amp; !labelName.equals(<span class=\"hljs-string\">\"\"</span>)){\n            resMap.put(<span class=\"hljs-string\">\"labelList\"</span>,labelList);\n            <span class=\"hljs-keyword\">return</span> resMap;\n        }\n        <span class=\"hljs-keyword\">return</span> getLabelList();\n    }\n</code></div></pre>\n','坑1：\n\n由于跨域， 画布被污染，不能调用 toBlob(), toDataURL() 或 getImageData() 方法，调用它们会抛出安全错误。\n\n按网上说的做，\n\n        配置 useCORS: true,\n\n        Nginx添加请求头\n\n                add_header Access-Control-Allow-Origin *;\n                add_header Access-Control-Allow-Credentials: true;\n\n成功解决了画布被污染的问题。然而这种解决方法只可以解决你自己服务器的问题，你总不能去微信或其他第三方服务器添加请求头吧。。。更大的坑来了\n\n \n\n坑2：\n\n\n```java\n  @Override\n    public Map<String,Object> searchLabel(String labelName) {\n        List<LabelEntity> labelList = labelDao.searchLabel(labelName);\n        Map<String,Object> resMap = new HashMap<>();\n        if(labelList.size() == 0 ) {\n            resMap.put(\"labelList\",null);\n            return resMap;\n        }else if(labelName !=null && !labelName.equals(\"\")){\n            resMap.put(\"labelList\",labelList);\n            return resMap;\n        }\n        return getLabelList();\n    }\n```\n','2020-08-04 02:56:20',NULL,'http://localhost:9000/2020/8/4/1596524157252.png',1),(19,'解决','een blocked by','1;3;4;2','<p>坑1：</p>\n<p>由于跨域， 画布被污染，不能调用 toBlob(), toDataURL() 或 getImageData() 方法，调用它们会抛出安全错误。</p>\n<p>按网上说的做，</p>\n<pre><code>    配置 useCORS: true,\n\n    Nginx添加请求头\n\n            add_header Access-Control-Allow-Origin *;\n            add_header Access-Control-Allow-Credentials: true;\n</code></pre>\n<p>成功解决了画布被污染的问题。然而这种解决方法只可以解决你自己服务器的问题，你总不能去微信或其他第三方服务器添加请求头吧。。。更大的坑来了</p>\n<p>坑2：</p>\n<pre><div class=\"hljs\"><code class=\"lang-java\"> <span class=\"hljs-comment\">/**\n     * 设置树形结构\n     * <span class=\"hljs-doctag\">@param</span> labelList\n     * <span class=\"hljs-doctag\">@param</span> labelEntity\n     * <span class=\"hljs-doctag\">@return</span>\n     */</span>\n    <span class=\"hljs-function\"><span class=\"hljs-keyword\">private</span> <span class=\"hljs-keyword\">void</span> <span class=\"hljs-title\">setVoList</span><span class=\"hljs-params\">(List&lt;LabelListVo&gt; labelList ,  LabelEntity labelEntity)</span> </span>{\n        <span class=\"hljs-keyword\">for</span>(LabelListVo vo : labelList){\n            <span class=\"hljs-keyword\">if</span>(labelEntity.getParentLabelId() == <span class=\"hljs-keyword\">null</span> ){\n                <span class=\"hljs-keyword\">continue</span>;\n            }\n            List&lt;LabelListVo&gt; child =  vo.getChildren();\n            <span class=\"hljs-keyword\">if</span>(labelEntity.getParentLabelId() != <span class=\"hljs-keyword\">null</span> &amp;&amp;labelEntity.getParentLabelId().equals(vo.getId())){\n                <span class=\"hljs-keyword\">if</span> (child == <span class=\"hljs-keyword\">null</span>) {\n                    child= <span class=\"hljs-keyword\">new</span> ArrayList&lt;&gt;();\n                }\n                child.add(createLabelVo(labelEntity));\n                vo.setChildren(child);\n                <span class=\"hljs-keyword\">return</span> ;\n            }<span class=\"hljs-keyword\">else</span>{\n                <span class=\"hljs-keyword\">if</span>(child != <span class=\"hljs-keyword\">null</span> &amp;&amp; child.size()&gt;<span class=\"hljs-number\">0</span>){\n                    setVoList(child, labelEntity);\n                }\n            }\n</code></div></pre>\n','坑1：\n\n由于跨域， 画布被污染，不能调用 toBlob(), toDataURL() 或 getImageData() 方法，调用它们会抛出安全错误。\n\n按网上说的做，\n\n        配置 useCORS: true,\n\n        Nginx添加请求头\n\n                add_header Access-Control-Allow-Origin *;\n                add_header Access-Control-Allow-Credentials: true;\n\n成功解决了画布被污染的问题。然而这种解决方法只可以解决你自己服务器的问题，你总不能去微信或其他第三方服务器添加请求头吧。。。更大的坑来了\n\n \n\n坑2：\n\n```java\n /**\n     * 设置树形结构\n     * @param labelList\n     * @param labelEntity\n     * @return\n     */\n    private void setVoList(List<LabelListVo> labelList ,  LabelEntity labelEntity) {\n        for(LabelListVo vo : labelList){\n            if(labelEntity.getParentLabelId() == null ){\n                continue;\n            }\n            List<LabelListVo> child =  vo.getChildren();\n            if(labelEntity.getParentLabelId() != null &&labelEntity.getParentLabelId().equals(vo.getId())){\n                if (child == null) {\n                    child= new ArrayList<>();\n                }\n                child.add(createLabelVo(labelEntity));\n                vo.setChildren(child);\n                return ;\n            }else{\n                if(child != null && child.size()>0){\n                    setVoList(child, labelEntity);\n                }\n            }\n```\n','2020-08-04 03:04:47','2020-08-06 05:56:31','http://localhost:9000/2020/8/4/1596524654569.png',1),(20,'跨域问题a','画布被污染，不能调用 t','1;3;4;2','<p>坑1：</p>\n<p>由于跨域， 画布被污染，不能调用 toBlob(), toDataURL() 或 getImageData() 方法，调用它们会抛出安全错误。</p>\n<p>按网上说的做，</p>\n<pre><code>配置 useCORS: true,\n\nNginx添加请求头\n\n        add_header Access-Control-Allow-Origin *;\n        add_header Access-Control-Allow-Credentials: true;\n</code></pre>\n<p>成功解决了画布被污染的问题。然而这种解决方法只可以解决你自己服务器的问题，你总不能去微信或其他第三方服务器添加请求头吧。。。更大的坑来了</p>\n<p>坑2：</p>\n<pre><div class=\"hljs\"><code class=\"lang-java\">  <span class=\"hljs-meta\">@Override</span>\n    <span class=\"hljs-function\"><span class=\"hljs-keyword\">public</span> Map&lt;String,Object&gt; <span class=\"hljs-title\">searchLabel</span><span class=\"hljs-params\">(String labelName)</span> </span>{\n        List&lt;LabelEntity&gt; labelList = labelDao.searchLabel(labelName);\n        Map&lt;String,Object&gt; resMap = <span class=\"hljs-keyword\">new</span> HashMap&lt;&gt;();\n        <span class=\"hljs-keyword\">if</span>(labelList.size() == <span class=\"hljs-number\">0</span> ) {\n            resMap.put(<span class=\"hljs-string\">\"labelList\"</span>,<span class=\"hljs-keyword\">null</span>);\n            <span class=\"hljs-keyword\">return</span> resMap;\n        }<span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span>(labelName !=<span class=\"hljs-keyword\">null</span> &amp;&amp; !labelName.equals(<span class=\"hljs-string\">\"\"</span>)){\n            resMap.put(<span class=\"hljs-string\">\"labelList\"</span>,labelList);\n            <span class=\"hljs-keyword\">return</span> resMap;\n        }\n        <span class=\"hljs-keyword\">return</span> getLabelList();\n    }\n</code></div></pre>\n','坑1：\n\n由于跨域， 画布被污染，不能调用 toBlob(), toDataURL() 或 getImageData() 方法，调用它们会抛出安全错误。\n\n按网上说的做，\n\n    配置 useCORS: true,\n\n    Nginx添加请求头\n\n            add_header Access-Control-Allow-Origin *;\n            add_header Access-Control-Allow-Credentials: true;\n成功解决了画布被污染的问题。然而这种解决方法只可以解决你自己服务器的问题，你总不能去微信或其他第三方服务器添加请求头吧。。。更大的坑来了\n\n坑2：\n\n```java\n  @Override\n    public Map<String,Object> searchLabel(String labelName) {\n        List<LabelEntity> labelList = labelDao.searchLabel(labelName);\n        Map<String,Object> resMap = new HashMap<>();\n        if(labelList.size() == 0 ) {\n            resMap.put(\"labelList\",null);\n            return resMap;\n        }else if(labelName !=null && !labelName.equals(\"\")){\n            resMap.put(\"labelList\",labelList);\n            return resMap;\n        }\n        return getLabelList();\n    }\n```\n','2020-08-04 03:31:09','2020-08-04 03:34:42','http://localhost:9000/2020/8/4/1596526261227.png',2),(21,'sssssssss','bbbbbbbb','1;2','<p>坑1：</p>\n<p>由于跨域， 画布被污染，不能调用 toBlob(), toDataURL() 或 getImageData() 方法，调用它们会抛出安全错误。</p>\n<p>按网上说的做，</p>\n<pre><code>    配置 useCORS: true,\n\n    Nginx添加请求头\n\n            add_header Access-Control-Allow-Origin *;\n            add_header Access-Control-Allow-Credentials: true;\n</code></pre>\n<p>成功解决了画布被污染的问题。然而这种解决方法只可以解决你自己服务器的问题，你总不能去微信或其他第三方服务器添加请求头吧。。。更大的坑来了</p>\n<p>坑2：</p>\n','坑1：\n\n由于跨域， 画布被污染，不能调用 toBlob(), toDataURL() 或 getImageData() 方法，调用它们会抛出安全错误。\n\n按网上说的做，\n\n        配置 useCORS: true,\n\n        Nginx添加请求头\n\n                add_header Access-Control-Allow-Origin *;\n                add_header Access-Control-Allow-Credentials: true;\n\n成功解决了画布被污染的问题。然而这种解决方法只可以解决你自己服务器的问题，你总不能去微信或其他第三方服务器添加请求头吧。。。更大的坑来了\n\n \n\n坑2：','2020-08-04 03:36:23','2020-08-07 09:33:44','http://localhost:9000/2020/8/7/1596764021465.png',1),(23,'aaaaaaaaaaaaa','ddddddddddd',NULL,'<p>坑1：</p>\n<p>由于跨域， 画布被污染，不能调用 toBlob(), toDataURL() 或 getImageData() 方法，调用它们会抛出安全错误。</p>\n<p>按网上说的做，</p>\n<pre><code>    配置 useCORS: true,\n\n    Nginx添加请求头\n\n            add_header Access-Control-Allow-Origin *;\n            add_header Access-Control-Allow-Credentials: true;\n</code></pre>\n<p>成功解决了画布被污染的问题。然而这种解决方法只可以解决你自己服务器的问题，你总不能去微信或其他第三方服务器添加请求头吧。。。更大的坑来了</p>\n<p>坑2：</p>\n','坑1：\n\n由于跨域， 画布被污染，不能调用 toBlob(), toDataURL() 或 getImageData() 方法，调用它们会抛出安全错误。\n\n按网上说的做，\n\n        配置 useCORS: true,\n\n        Nginx添加请求头\n\n                add_header Access-Control-Allow-Origin *;\n                add_header Access-Control-Allow-Credentials: true;\n\n成功解决了画布被污染的问题。然而这种解决方法只可以解决你自己服务器的问题，你总不能去微信或其他第三方服务器添加请求头吧。。。更大的坑来了\n\n \n\n坑2：','2020-08-04 03:44:55','2020-08-06 04:28:21','http://localhost:9000/2020/8/4/1596527087291.png',2),(24,'hhhhhhhhhhh','dispatchServlet处理流程',NULL,'<p>坑1：</p>\n<p>由于跨域， 画布被污染，不能调用 toBlob(), toDataURL() 或 getImageData() 方法，调用它们会抛出安全错误。</p>\n<p>按网上说的做，</p>\n<pre><code>    配置 useCORS: true,\n\n    Nginx添加请求头\n\n            add_header Access-Control-Allow-Origin *;\n            add_header Access-Control-Allow-Credentials: true;\n</code></pre>\n<p>成功解决了画布被污染的问题。然而这种解决方法只可以解决你自己服务器的问题，你总不能去微信或其他第三方服务器添加请求头吧。。。更大的坑来了</p>\n<p>坑2：</p>\n','坑1：\n\n由于跨域， 画布被污染，不能调用 toBlob(), toDataURL() 或 getImageData() 方法，调用它们会抛出安全错误。\n\n按网上说的做，\n\n        配置 useCORS: true,\n\n        Nginx添加请求头\n\n                add_header Access-Control-Allow-Origin *;\n                add_header Access-Control-Allow-Credentials: true;\n\n成功解决了画布被污染的问题。然而这种解决方法只可以解决你自己服务器的问题，你总不能去微信或其他第三方服务器添加请求头吧。。。更大的坑来了\n\n \n\n坑2：','2020-08-04 03:46:22','2020-08-07 09:24:03','http://localhost:9000/2020/8/7/1596763434998.png',2),(25,'随笔','随笔',NULL,'asdfadfasd','sdfasdfadfa','2020-08-04 03:46:22',NULL,NULL,2),(26,'随笔2',NULL,NULL,'<p>啊啊啊啊啊啊啊啊啊啊啊啊啊啊</p>\n','啊啊啊啊啊啊啊啊啊啊啊啊啊啊','2020-08-06 04:47:03','2020-08-06 06:02:24','http://localhost:9000/2020/8/6/1596708140863.png',2),(27,'随笔3',NULL,NULL,'<p>爱仕达多多多多多多多多多多多多多多多多多</p>\n','爱仕达多多多多多多多多多多多多多多多多多','2020-08-07 09:33:11','2020-08-07 09:33:27','http://localhost:9000/2020/8/7/1596764003665.png',2);

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_info` */

insert  into `user_info`(`id`,`user_id`,`username`,`password`) values (1,'sssssss','admin','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
