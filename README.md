# PDF报表打印概述
## 概述
#### 在企业级应用开发中，报表生成、报表打印下载是其重要的一个环节。在之前的课程中我们已经学习了报表中比较重要的一种：Excel报表。其实除了Excel报表之外，PDF报表也有广泛的应用场景，必须用户详细资料，用户简历等。接下来的课程，我们就来共同学习PDF报表
## 常见PDF报表的制作方式
#### 目前世面上比较流行的制作PDF报表的工具如下：
```
1. iText PDF：iText是著名的开放项目，是用于生成PDF文档的一个java类库。通过iText不仅可以生成PDF或rtf的文档，而且可以将XML、Html文件转化为PDF文件。
2. Openoffice：openoffice是开源软件且能在windows和linux平台下运行，可以灵活的将word或者Excel转化为PDF文档。
3. Jasper Report：是一个强大、灵活的报表生成工具，能够展示丰富的页面内容，并将之转换成PDF
```
## 1.JasperReport框架的介绍
```
JasperReport是一个强大、灵活的报表生成工具，能够展示丰富的页面内容，并将之转换成PDF，HTML，或者
XML格式。该库完全由Java写成，可以用于在各种Java应用程序，包括J2EE，Web应用程序中生成动态内容。只需
要将JasperReport引入工程中即可完成PDF报表的编译、显示、输出等工作。
在开源的JAVA报表工具中，JASPER Report发展是比较好的，比一些商业的报表引擎做得还好，如支持了十字
交叉报表、统计报表、图形报表，支持多种报表格式的输出，如PDF、RTF、XML、CSV、XHTML、TEXT、
DOCX以及OpenOffice。
数据源支持更多，常用 JDBC SQL查询、XML文件、CSV文件 、HQL（Hibernate查询），HBase，JAVA集合
等。还允许你义自己的数据源，通过JASPER文件及数据源，JASPER就能生成最终用户想要的文档格式。
```
# JasperReport的开发步骤
## JasperReport生命周期
#### 通常我们提到PDF报表的时候,浮现在脑海中的是最终的PDF文档文件。在JasperReports中，这只是报表生命周期的最后阶段。通过JasperReports生成PDF报表一共要经过三个阶段，我们称之为 JasperReport的生命周期，这三个阶段为：设计（Design）阶段、执行（Execution）阶段以及输出（Export）阶段：
```
1. 设计阶段（Design）：所谓的报表设计就是创建一些模板，模板包含了报表的布局与设计，包括执行计算的复杂公式、可选的从数据源获取数据的查询语句、以及其它的一些信息。模板设计完成之后，我们将模板保存为JRXML文件（JR代表JasperReports）,其实就是一个XML文件。
2. 执行阶段（Execution）：使用以JRXML文件编译为可执行的二进制文件（即.Jasper文件）结合数据进行执行，填充报表数据
3. 输出阶段（Export）：数据填充结束，可以指定输出为多种形式的报表
```
## JasperReport原理简述
```
1. JRXML:报表填充模板，本质是一个XML.
JasperReport已经封装了一个dtd，只要按照规定的格式写这个xml文件，那么jasperReport就可以将其解析
最终生成报表，但是jasperReport所解析的不是我们常见的.xml文件，而是.jrxml文件，其实跟xml是一样
的，只是后缀不一样。
2. Jasper:由JRXML模板编译生成的二进制文件，用于代码填充数据。
解析完成后JasperReport就开始编译.jrxml文件，将其编译成.jasper文件，因为JasperReport只可以
对.jasper文件进行填充数据和转换，这步操作就跟我们java中将java文件编译成class文件是一样的
3. Jrprint:当用数据填充完Jasper后生成的文件，用于输出报表。
这一步才是JasperReport的核心所在，它会根据你在xml里面写好的查询语句来查询指定是数据库，也可以控
制在后台编写查询语句，参数，数据库。在报表填充完后，会再生成一个.jrprint格式的文件（读取jasper文
件进行填充，然后生成一个jrprint文件）
4. Exporter:决定要输出的报表为何种格式，报表输出的管理类。
5. Jasperreport可以输出多种格式的报表文件，常见的有Html,PDF,xls等
```
## 开发流程概述
```
制作报表模板
模板编译
构造数据
填充模板数据
```
# 模板工具Jaspersoft Studio
## 概述
#### Jaspersoft Studio是JasperReports库和JasperReports服务器的基于Eclipse的报告设计器; 它可以作为Eclipse插件或作为独立的应用程序使用。Jaspersoft Studio允许您创建包含图表，图像，子报表，交叉表等的复杂布局。您可以通过JDBC，TableModels，JavaBeans，XML，Hibernate，大数据（如Hive），CSV，XML / A以及自定义来源等各种来源访问数据，然后将报告发布为PDF，RTF， XML，XLS，CSV，HTML，XHTML，文本，DOCX或OpenOffice。Jaspersoft Studio 是一个可视化的报表设计工具,使用该软件可以方便地对报表进行可视化的设计，设计结果为格式.jrxml 的 XML 文件，并且可以把.jrxml 文件编译成.jasper 格式文件方便 JasperReport 报表引擎解析、显示。
##安装配置
```
到JasperReport官网下载 https://community.jaspersoft.com/community-download
下载 Library Jar包（传统导入jar包工程需下载）和模板设计器Jaspersoft studio。并安装Jaspersoft studio，安装
的过程比较简单，一直下一步直至安装成功即可。
```
## 面板介绍
```
Report editing area （主编辑区域）中，您直观地通过拖动，定位，对齐和通过 Designer palette（设计器
调色板）对报表元素调整大小。JasperSoft Studio 有一个多标签编辑器，Design,Source 和 Preview：
Design tab：当你打开一个报告文件，它允许您以图形方式创建报表选中
Source tab： 包含用于报表的 JRXML 源代码。
Preview tab： 允许在选择数据源和输出格式后，运行报表预览。
Repository Explorer view：包含 JasperServer 生成的连接和可用的数据适配器列表
Project Explorer view：包含 JasperReports 的工程项目清单
Outline view：在大纲视图中显示了一个树的形式的方式报告的完整结构。
Properties view：通常是任何基于 Eclipse 的产品/插件的基础之一。它通常被填充与实际所选元素的属性的
信息。这就是这样，当你从主设计区域（即：一个文本字段）选择一个报表元素或从大纲，视图显示了它的
信息。其中一些属性可以是只读的，但大部分都是可编辑的，对其进行修改，通常会通知更改绘制的元素
（如：元素的宽度或高度）。
Problems view：显示的问题和错误，例如可以阻断报告的正确的编译。
Report state summary 提供了有关在报表编译/填充/执行统计用户有用的信息。错误会显示在这里
```
## 基本使用
### 模板制作
```
（1）打开Jaspersoft Studio ，新建一个project, 步骤： File -> New -> Project-> JasperReports Project
（2）新建一个Jasper Report模板，在 Stidio的左下方Project Explorer 找到刚才新建的Project (我这里新建的是DemoReport),步骤：项目右键 -> New -> Jasper Report
（3）选择 Blank A4 (A4纸大小的模板)，然后 Next 命名为DemoReport1.jrxml.
如图所示，报表模板被垂直的分层，每一个部分都是一个Band,每一个Band的特点不同：
Title(标题)：只在整个报表的第一页的最上端显示。只在第一页显示，其他页面均不显示。
Page Header(页头)：在整个报表中每一页都会显示。在第一页中，出现的位置在 Title Band的下面。在除了
第一页的其他页面中Page Header 的内容均在页面的最上端显示。
Page Footer(页脚)：在整个报表中每一页都会显示。显示在页面的最下端。一般用来显示页码。
Detail 1(详细)：报表内容，每一页都会显示。
Column Header(列头)：Detail中打印的是一张表的话，这Column Header就是表中列的列头。
Column Footer(列脚)：Detail中打印的是一张表的话，这Column Footer就是表中列的列脚。
Summary(统计)：表格的合计段，出现在整个报表的最后一页中，在Detail 1 Band后面。主要是用来做报表
的合计显示。
```
### 编译模板
```
右键单机模板文件 -> compile Report 对模板进行编译，生成.jasper文件
```
### 整合工程
```
（1）新建SpringBoot工程引入坐标
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.0.5.RELEASE</version>
    <relativePath/>
</parent>
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>net.sf.jasperreports</groupId>
        <artifactId>jasperreports</artifactId>
        <version>6.5.0</version>
    </dependency>
    <dependency>
        <groupId>org.olap4j</groupId>
        <artifactId>olap4j</artifactId>
        <version>1.2.0</version>
    </dependency>
    <dependency>
        <groupId>com.lowagie</groupId>
        <artifactId>itext</artifactId>
        <version>2.1.7</version>
    </dependency>
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi</artifactId>
        <version>4.0.1</version>
    </dependency>
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi-ooxml</artifactId>
        <version>4.0.1</version>
    </dependency>
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi-ooxml-schemas</artifactId>
        <version>4.0.1</version>
    </dependency>
</dependencies>
（2）引入配置文件
server:
    port: 8181
spring:
    application:
        name: jasper-demo #指定服务名
    resources:
        static-locations: classpath:/templates/
    datasource:
        driver-class-name: com.mysql.jdbc.Driver
        url: jdbc:mysql://localhost:3306/ihrm?useUnicode=true&characterEncoding=utf8
        username: root
        password: 111111
（3）创建启动类
@SpringBootApplication(scanBasePackages = "cn.itcast")
public class JasperApplication {
    public static void main(String[] args) {
        SpringApplication.run(JasperApplication.class, args);
    }
}
（4）导入生成的.jasper文件
（5）创建测试controller

```
### 中文处理
```
（1）设计阶段需要指定中文样式
（2）通过手动指定中文字体的形式解决中文不现实

添加properties文件：
@RestController
public class JasperController {
    @GetMapping("/testJasper")
    public void createHtml(HttpServletResponse response, HttpServletRequestrequest)throws Exception{
        //引入jasper文件。由JRXML模板编译生成的二进制文件，用于代码填充数据
        Resource resource = new ClassPathResource("templates/test01.jasper");
        //加载jasper文件创建inputStream
        FileInputStream isRef = new FileInputStream(resource.getFile());
        ServletOutputStream sosRef = response.getOutputStream();
        try {
            //创建JasperPrint对象
            JasperPrint jasperPrint = JasperFillManager.fillReport(isRef, new HashMap<>
            (),new JREmptyDataSource());
            //写入pdf数据
            JasperExportManager.exportReportToPdfStream(jasperPrint,sosRef);
        } finally {
            sosRef.flush();
            sosRef.close();
        }
    }
}
指定中文配置文件fonts.xml
引入字体库stsong.TTF
```

## 2.wkhtmltopdf 实现html转换pdf
```
1.安装wkhtmltopdf 
官网地址:https://wkhtmltopdf.org/
```
### wkhtmltopdf配置
```
/**
 * Input表单或JavaScript脚本支持：--enable-forms，下面这些是网友整理的参数说明
 * wkhtmltopdf [OPTIONS]... <input file> [More input files] <output file>
 * 常规选项
 * --allow <path>                  允许加载从指定的文件夹中的文件或文件（可重复）
 * --book*                         设置一会打印一本书的时候，通常设置的选项
 * --collate                       打印多份副本时整理
 * --cookie <name> <value>         设置一个额外的cookie（可重复）
 * --cookie-jar <path>             读取和写入的Cookie，并在提供的cookie jar文件
 * --copies <number>               复印打印成pdf文件数（默认为1）
 * --cover* <url>                  使用HTML文件作为封面。它会带页眉和页脚的TOC之前插入
 * --custom-header <name> <value>  设置一个附加的HTTP头（可重复）
 * --debug-javascript              显示的javascript调试输出
 * --default-header*               添加一个缺省的头部，与页面的左边的名称，页面数到右边，例如： --header-left '[webpage]' --header-right '[page]/[toPage]'  --header-line
 * --disable-external-links*       禁止生成链接到远程网页
 * --disable-internal-links*       禁止使用本地链接
 * --disable-javascript            禁止让网页执行JavaScript
 * --disable-pdf-compression*      禁止在PDF对象使用无损压缩
 * --disable-smart-shrinking*      禁止使用WebKit的智能战略收缩，使像素/ DPI比没有不变
 * --disallow-local-file-access    禁止允许转换的本地文件读取其他本地文件，除非explecitily允许用 --allow
 * --dpi <dpi>                     显式更改DPI（这对基于X11的系统没有任何影响）
 * --enable-plugins                启用已安装的插件（如Flash
 * --encoding <encoding>           设置默认的文字编码
 * --extended-help                 显示更广泛的帮助，详细介绍了不常见的命令开关
 * --forms*                        打开HTML表单字段转换为PDF表单域
 * --grayscale                     PDF格式将在灰阶产生
 * --help                          Display help
 * --htmldoc                       输出程序HTML帮助
 * --ignore-load-errors            忽略claimes加载过程中已经遇到了一个错误页面
 * --lowquality                    产生低品质的PDF/ PS。有用缩小结果文档的空间
 * --manpage                       输出程序手册页
 * --margin-bottom <unitreal>      设置页面下边距 (default 10mm)
 * --margin-left <unitreal>        将左边页边距 (default 10mm)
 * --margin-right <unitreal>       设置页面右边距 (default 10mm)
 * --margin-top <unitreal>         设置页面上边距 (default 10mm)
 * --minimum-font-size             <)
 * --no-background                 不打印背景
 * --orientation <orientation>     设置方向为横向或纵向
 * --page-height <unitreal>        页面高度 (default unit millimeter)
 * --page-offset* <offset>         设置起始页码 (default )
 * --page-size <size>              设置纸张大小: A4, Letter, etc.
 * --page-width <unitreal>         页面宽度 (default unit millimeter)
 * --password <password>           HTTP验证密码
 * --post <name> <value>           Add an additional post field (repeatable)
 * --post-file <name> <path>       Post an aditional file (repeatable)
 * --print-media-type*             使用的打印介质类型，而不是屏幕
 * --proxy <proxy>                 使用代理
 * --quiet                         Be less verbose
 * --read-args-from-stdin          读取标准输入的命令行参数
 * --readme                        输出程序自述
 * --redirect-delay <msec>         等待几毫秒为JS-重定向(default )
 * --replace* <name> <value>       替换名称，值的页眉和页脚（可重复）
 * --stop-slow-scripts             停止运行缓慢的JavaScripts
 * --title <text>                  生成的PDF文件的标题（第一个文档的标题使用，如果没有指定）
 * --toc*                          插入的内容的表中的文件的开头
 * --use-xserver*                  使用X服务器（一些插件和其他的东西没有X11可能无法正常工作）
 * --user-style-sheet <url>        指定用户的样式表，加载在每一页中
 * --username <username>           HTTP认证的用户名
 * --version                       输出版本信息退出
 * --zoom                          <)
 *
 * 页眉和页脚选项
 * --header-center*    <text>  (设置在中心位置的页眉内容)
 * --header-font-name* <name>  (default Arial)(设置页眉的字体名称)
 * --header-font-size* <size>  (设置页眉的字体大小)
 * --header-html*      <url>   (添加一个HTML页眉，后面是网址)
 * --header-left*      <text>  (左对齐的页眉文本)
 * --header-line*              (显示一条线在页眉下)
 * --header-right*     <text>  (右对齐页眉文本)
 * --header-spacing*   <real>  (设置页眉和内容的距离，默认0)
 * --footer-center*    <text>  (设置在中心位置的页脚内容)
 * --footer-font-name* <name>  (设置页脚的字体名称)
 * --footer-font-size* <size>  (设置页脚的字体大小default )
 * --footer-html*      <url>   (添加一个HTML页脚，后面是网址)
 * --footer-left*      <text>  (左对齐的页脚文本)
 * --footer-line*              显示一条线在页脚内容上)
 * --footer-right*     <text>  (右对齐页脚文本)
 * --footer-spacing*   <real>  (设置页脚和内容的距离)
 *
 * 页脚和页眉
 * [page]       由当前正在打印的页的数目代替
 * [frompage]   由要打印的第一页的数量取代
 * [topage]     由最后一页要打印的数量取代
 * [webpage]    通过正在打印的页面的URL替换
 * [section]    由当前节的名称替换
 * [subsection] 由当前小节的名称替换
 * [date]       由当前日期系统的本地格式取代
 * [time]       由当前时间，系统的本地格式取代
 *
 * 轮廓选项
 * --dump-outline  <file>  转储目录到一个文件
 * --outline               显示目录（文章中h1，h2来定）
 * --outline-depth <level> 设置目录的深度（默认为4）
 *
 * 表内容选项中
 *  --toc-depth*              <level>  Set the depth of the toc (default)
 *  --toc-disable-back-links*          Do not link from section header to toc
 *  --toc-disable-links*               Do not link from toc to sections
 *  --toc-font-name*          <name>   Set the font used for the toc (default Arial)
 *  --toc-header-font-name*   <name>   The font of the toc header (if unset use --toc-font-name)
 *  --toc-header-font-size*   <size>   The font size of the toc header (default)
 *  --toc-header-text*        <text>   The header text of the toc (default Table Of Contents)
 *  --toc-l1-font-size*       <size>   Set the font size on level of the toc (default)
 *  --toc-l1-indentation*     <num>    Set indentation on level of the toc (default)
 *  --toc-l2-font-size*       <size>   Set the font size on level of the toc (default)
 *  --toc-l2-indentation*     <num>    Set indentation on level of the toc (default)
 *  --toc-l3-font-size*       <size>   Set the font size on level of the toc (default)
 *  --toc-l3-indentation*     <num>    Set indentation on level of the toc (default)
 *  --toc-l4-font-size*       <size>   Set the font size on level of the toc (default)
 *  --toc-l4-indentation*     <num>    Set indentation on level of the toc (default)
 *  --toc-l5-font-size*       <size>   Set the font size on level of the toc (default)
 *  --toc-l5-indentation*     <num>    Set indentation on level of the toc (default)
 *  --toc-l6-font-size*       <size>   Set the font size on level of the toc (default)
 *  --toc-l6-indentation*     <num>    Set indentation on level of the toc (default)
 *  --toc-l7-font-size*       <size>   Set the font size on level of the toc (default)
 *  --toc-l7-indentation*     <num>    Set indentation on level of the toc (default)
 *  --toc-no-dots*                     Do not use dots, in the toc
 * ------------------------------------------------------------------------------------------------------------*/
```

