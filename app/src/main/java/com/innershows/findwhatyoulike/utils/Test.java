package com.innershows.findwhatyoulike.utils;

import com.innershows.findwhatyoulike.girls_pictures.model.ImageFuli;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by innershows on 16/8/10.
 *
 * @author innershows
 * @date 16/8/10
 * @e_mail innershow@gmail.com
 */
public class Test {
    public static String test = "\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"zh-CN\">\n" +
            "  <head>\n" +
            "    <title>闫盼盼pandorar \"\" | 秒拍福利 - 微拍福利 | 美女视频分享社区</title>\n" +
            "<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"http://www.dbmeinv.com/dbgroup/resource/images/favicon.ico\" />\n" +
            "<meta charset=\"utf-8\">\n" +
            "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" /> \n" +
            "<meta name=\"description\" content=\"豆瓣妹子是最真实的妹子私房照分享社区。收集豆瓣羞涩组等热门小组的妹子私房照福利，豆瓣宅男福利，在这有豆瓣妹子的私房照和豆瓣福利、豆瓣大尺度照片、宅男福利，也可以使用豆瓣帖子搜索功能。\">\n" +
            "<meta name=\"keywords\" content=\"豆瓣妹子,豆瓣美女,豆瓣福利,豆瓣妹子网,豆瓣女,微拍福利,豆瓣美妞,妹子,妹子网,豆瓣妹子的私房照,豆瓣小组妹子,豆瓣妹子福利,豆瓣美女私房照,豆瓣帖子搜索,请不要害羞\"/>\n" +
            "<link rel=\"stylesheet\" href=\"http://www.dbmeinv.com/dbgroup/resource/css/bootstrap.min.css\">\n" +
            "<link rel=\"stylesheet\" href=\"http://www.dbmeinv.com/dbgroup/resource/css/bootstrap.new.theme.min.css\">\n" +
            "<link rel=\"stylesheet\" href=\"http://www.dbmeinv.com/dbgroup/resource/css/dbmeinv.css\">\n" +
            "<script src=\"http://www.dbmeinv.com/resource/js/plugin/jquery.min.js\"></script>\n" +
            "<script src=\"http://www.dbmeinv.com/dbgroup/resource/js/dbmeinv.js\"></script>\n" +
            "<script type=\"text/javascript\">\n" +
            "var basePath = \"http://www.dbmeinv.com\";\n" +
            "var pc_flag = checkSystem();\n" +
            "</script>\n" +
            "<!--[if lt IE 9]>\n" +
            "\t<script src=\"http://www.dbmeinv.com/resource/js/plugin/bootstrap/js/html5shiv.min.js\"></script>\n" +
            "\t<script src=\"http://www.dbmeinv.com/resource/js/plugin/bootstrap/js/respond.min.js\"></script>\n" +
            "<![endif]-->  </head>\n" +
            " <body>\n" +
            "\t<!-- 头部 -->\n" +
            "<!--[if lte IE 9]>\n" +
            "<div class=\"container\">\n" +
            "<p style=\"color:red;text-align:center\">你正在使用<strong>过时</strong>的浏览器，豆瓣美女 不提供支持。 请 <a href=\"http://browsehappy.com/\" target=\"_blank\">升级浏览器</a>以获得更好的体验！</p>\n" +
            "</div>\n" +
            "<![endif]-->\n" +
            "<div class=\"header\">\n" +
            "\t<nav class=\"navbar navbar-inverse navbar-static-top navbar-default\">\n" +
            "\t\t<div class=\"container\">\n" +
            "\t\t\t<div class=\"navbar-header\">\n" +
            "\t\t\t\t<a href=\"http://www.dbmeinv.com\" class=\"navbar-brand\"><b>豆瓣美女</b></a>\n" +
            "\t\t\t</div>\n" +
            "\t\t\t<ul class=\"nav navbar-nav\">\n" +
            "\t\t\t\t<li id=\"dbgroup_menu\"><a href=\"http://www.dbmeinv.com/dbgroup/show.htm\">首页</a></li>\n" +
            "\t\t\t\t<li id=\"dbgroup_topics\"><a href=\"http://www.dbmeinv.com/dbgroup/topics.htm\">找帖子</a></li>\n" +
            "\t\t\t\t<li class=\"dropdown\">\n" +
            "\t\t          <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">找妹子<span class=\"caret\"></span></a>\n" +
            "\t\t          <ul class=\"dropdown-menu\">\n" +
            "\t\t            <li id=\"users_menu\"><a href=\"http://www.dbmeinv.com/dbgroup/users.htm\">找妹子</a></li>\n" +
            "\t\t            <li role=\"separator\" class=\"divider\"></li>\n" +
            "\t\t            <li id=\"district_menu\" ><a href=\"http://www.dbmeinv.com/dbgroup/district.htm\">妹子地区统计</a></li>\n" +
            "\t\t          </ul>\n" +
            "\t\t        </li>\n" +
            "\t\t\t\t<li id=\"dbgroup_rank\"><a href=\"http://www.dbmeinv.com/dbgroup/rank.htm\">豆瓣福利</a></li>\n" +
            "\t\t\t\t<li id=\"dbgroup_today\"><a href=\"http://www.dbmeinv.com/dbgroup/today.htm\">今日妹子</a></li>\n" +
            "\t\t\t\t<li id=\"dbgroup_current\"><a href=\"http://www.dbmeinv.com/dbgroup/current.htm\">豆瓣小组</a></li>\n" +
            "\t\t\t\t<!--<li id=\"dbgroup_random\"><a href=\"http://www.dbmeinv.com/dbgroup/random.htm\">穿越妹子</a></li> -->\n" +
            "\t\t\t\t<li id=\"videos_menu\"><a href=\"http://www.dbmeinv.com/dbgroup/videos.htm\">微拍福利</a></li>\n" +
            "\t\t\t\t<li id=\"\"><a href=\"http://www.dbmeinv.com/dbgroup/app.htm\">APP</a></li>\n" +
            "\t\t\t\t\n" +
            "\t\t\t</ul>\n" +
            "\t\t\t\t<ul class=\"nav user-bar navbar-nav navbar-right\">\n" +
            "\t\t\t\t\t<li><a href=\"http://www.dbmeinv.com/dbgroup/register.htm\">注册</a></li>\n" +
            "\t\t\t\t\t<li><a href=\"http://www.dbmeinv.com/dbgroup/login.htm\">登录</a></li>\n" +
            "\t\t\t\t</ul>\n" +
            "\n" +
            "\t\t\t<!-- <ul class=\"nav navbar-nav navbar-right\">\n" +
            "\t\t\t\t<li class=\"nav-search hidden-xs\">\n" +
            "\t\t\t\t\t<form class=\"navbar-form form-search\" action=\"\" method=\"GET\">\n" +
            "\t\t\t\t\t\t<div class=\"form-group\">\n" +
            "\t\t\t\t\t\t\t<input class=\"form-control\" name=\"q\" type=\"text\" value=\"\" placeholder=\"搜索本站内容\" />\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t<i class=\"fa btn-search fa-search\"></i> <i class=\"fa btn-close fa-times-circle\"></i>\n" +
            "\t\t\t\t\t</form>\n" +
            "\t\t\t\t</li>\n" +
            "\t\t\t\t<li class=\"notification-count\">\n" +
            "\t            \t<a href=\"javascript:;\" class=\"\" title=\"通知\"><i class=\"fa fa-bell\"></i><span class=\"count\">1</span></a>\n" +
            "\t          \t</li>\n" +
            "\t\t\t</ul> -->\n" +
            "\t\t</div>\n" +
            "\t</nav>\n" +
            "</div>\n" +
            "\n" +
            "\n" +
            "\t<div id=\"main\" class=\"main-container container\">\n" +
            "\t\t<div class=\"row\">\n" +
            "\t\t\t<div class=\"col-md-9\">\n" +
            "\t\t\t\t<div class=\"topic-detail panel panel-default\">\n" +
            "\t\t\t\t\t<div class=\"panel-heading media clearfix\">\n" +
            "\t\t\t\t\t\t<div class=\"media-body\">\n" +
            "\t\t\t\t\t\t\t<h1 class=\"media-heading\">闫盼盼pandorar \"\"</h1>\n" +
            "\t\t\t\t\t\t\t<div class=\"info\">\n" +
            "\t\t\t\t\t\t\t\t<a data-author=\"true\" href=\"javascript:;\">闫盼盼pandorar</a> \n" +
            "\t\t\t\t\t\t\t\t·&nbsp;于&nbsp;<abbr>2016-06-28 14:48:08.0</abbr>发布\n" +
            "\t\t\t\t\t\t\t\t·&nbsp;<a href=\"http://www.miaopai.com/show/q6ZDRX99li39M7ey5bxNxg__.htm\" target=\"_blank\">看看原帖</a>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t<!-- 内容 begin -->\n" +
            "\t\t\t\t\t<div class=\"panel-body markdown\">\n" +
            "\t\t            \t<div class=\"mobile-hide\" style=\"width: auto;height: 480px\">\n" +
            "\t                \t\t<!-- 秒拍视频播放器 -->\n" +
            "\t                \t\t<object width=\"100%\" height=\"100%\" classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\">\n" +
            "\t\t\t                    <param name=\"src\" value=\"http://wscdn.miaopai.com/splayer2.0.8.swf?scid=q6ZDRX99li39M7ey5bxNxg__&token=&autopause=false&fromweibo=false\"> \n" +
            "\t\t\t\t \t\t\t\t<param name=\"wmode\" value=\"transparent\">  \n" +
            "\t\t\t\t \t\t\t\t<param name=\"wmode\" value=\"opaque\">   \n" +
            "\t\t\t\t \t\t\t\t<param name=\"quality\" value=\"high\">   \n" +
            "\t\t\t\t\t\t\t\t<param name=\"allowfullscreen\" value=\"true\">   \n" +
            "\t\t\t\t\t\t\t\t<param name=\"allowscriptaccess\" value=\"always\">   \n" +
            "\t\t\t\t\t\t\t<embed id=em src=\"http://wscdn.miaopai.com/splayer2.0.8.swf?scid=q6ZDRX99li39M7ey5bxNxg__&token=&autopause=false&fromweibo=false\" type=\"application/x-shockwave-flash\" autostart=false width=\"100%\" height=\"100%\" quality=\"high\" allowfullscreen=\"true\" wmode=\"transparent\" allowscriptaccess=\"always\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\">    \n" +
            "\t\t\t\t\t\t\t</object>\n" +
            "\t                \t</div>\n" +
            "\t\t\t\t\t\t<!-- 手机使用HTML5播放器-->\n" +
            "\t\t\t\t\t\t<script type=\"text/javascript\">if(pc_flag != \"pc\") {document.write('<div style=\"width:98%;overflow:hidden\"><script type=\"text/javascript\">var cpro_id = \"u1654293\";</script' + '>' + '<script src=\"http://cpro.baidustatic.com/cpro/ui/cm.js\" type=\"text/javascript\"></script</script' + '></div><video id=\"videohtml5\" style=\"margin-bottom:15px\" width=\"100%\" height=\"auto\" autobuffer=\"\" autoplay=\"\" loop=\"\" controls=\"\" preload=\"metadata\" x-webkit-airplay=\"\" poster=\"http://lxqncdn.miaopai.com/stream/q6ZDRX99li39M7ey5bxNxg___m.jpg\"><source src=\"http://gslb.miaopai.com/stream/q6ZDRX99li39M7ey5bxNxg__.mp4\"></video>');}</script>\n" +
            "\t\t\t\t\t\t\n" +
            "\t                \t<br />\n" +
            "\t                \t\"\"\n" +
            "\t                \t\n" +
            "\t                \t<div class=\"mobile-hide\">\n" +
            "\t\t\t\t\t\t\t<br>\n" +
            "\t\t\t\t\t\t\t<!-- JiaThis Button BEGIN -->\n" +
            "\t\t\t\t\t\t\t<div class=\"jiathis_style_24x24\"><span class=\"jiathis_txt\">分享到：</span>\n" +
            "\t\t\t\t\t\t\t<a class=\"jiathis_button_qzone\"></a><a class=\"jiathis_button_tsina\"></a><a class=\"jiathis_button_tqq\"></a>\n" +
            "\t\t\t\t\t\t\t<a class=\"jiathis_button_weixin\"></a><a class=\"jiathis_button_renren\"></a><a href=\"http://www.jiathis.com/share\" class=\"jiathis jiathis_txt jtico jtico_jiathis\" target=\"_blank\"></a><a class=\"jiathis_counter_style\"></a>\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t<script type=\"text/javascript\" >\n" +
            "\t\t\t\t\t\t\tvar jiathis_config={\n" +
            "\t\t\t\t\t\t\t\turl:window.location.href,\n" +
            "\t\t\t\t\t\t\t\tsummary:\"#秒拍女神#\",\n" +
            "\t\t\t\t\t\t\t\ttitle:\"\"\" \"\"\",\n" +
            "\t\t\t\t\t\t\t\t//pic:\"\",\n" +
            "\t\t\t\t\t\t\t\tralateuid:{\n" +
            "\t\t\t\t\t\t\t\t\t\"tsina\":\"5501886937\"\n" +
            "\t\t\t\t\t\t\t\t}, shortUrl:false, hideMore:false\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t</script>\n" +
            "\t\t\t\t\t\t\t<script type=\"text/javascript\" src=\"http://v3.jiathis.com/code/jia.js\" charset=\"utf-8\"></script>\n" +
            "\t\t\t\t\t\t\t<!-- JiaThis Button END -->\n" +
            "\t\t\t\t\t\t\t<br/>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t<div class=\"mobile-hide\"><p>&nbsp;</p><script type=\"text/javascript\">/*760*90 图片 */var cpro_id = \"u2294368\";</script><script src=\"http://cpro.baidustatic.com/cpro/ui/c.js\" type=\"text/javascript\"></script></div>\n" +
            "\t\t\t\t\t\t<div class=\"mobile-hide\">\n" +
            "\t\t\t\t\t\t\t<!-- baidu tuijian -->\n" +
            "\t\t\t\t\t\t\t<div id=\"hm_t_74019\"></div>\n" +
            "\t\t\t\t\t\t\t<!-- baidu tuijian -->\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\n" +
            "\t\t\t\t\t<div class=\"panel-footer clearfix\">\n" +
            "\t\t\t\t\t\t<div class=\"opts\">\n" +
            "\t\t\t\t\t\t\t<span class=\"mobile-hide\">本页固定链接：<a href=\"http://www.dbmeinv.com/dbgroup/v-21253\">http://www.dbmeinv.com/dbgroup/v-21253</a></span>\n" +
            "\t\t\t\t\t\t\t<span class=\"pull-right opts\">\n" +
            "\t\t\t\t\t\t\t\t<a class=\"\" href=\"javascript:;\"><i class=\"fa fa-heart-o\"></i><span>喜欢</span></a>\t\n" +
            "\t\t\t\t\t\t\t</span>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t</div>\n" +
            "\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<!-- 回复begin -->\n" +
            "\t\t\t\t<div id=\"replies\" class=\"panel panel-default\" data-last-floor=\"6\">\n" +
            "\t\t\t\t\t<div class=\"total panel-heading\">评论</div>\n" +
            "\t\t\t\t\t<div class=\"items panel-body\">\n" +
            "\t\t\t\t\t\t<!-- 多说评论框 start -->\n" +
            "\t\t\t\t\t\t<div class=\"ds-thread\" data-thread-key=\"21253\" data-title=\"\" data-url=\"http://www.dbmeinv.com/dbgroup/v-21253\"></div>\n" +
            "\t\t\t\t\t\t<script type=\"text/javascript\">\n" +
            "\t\t\t\t\t\t\tvar duoshuoQuery = {short_name:\"dbmeinv\"};\n" +
            "\t\t\t\t\t\t\t(function() {\n" +
            "\t\t\t\t\t\t\t\tvar ds = document.createElement('script');\n" +
            "\t\t\t\t\t\t\t\tds.type = 'text/javascript';ds.async = true;\n" +
            "\t\t\t\t\t\t\t\tds.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') + '//static.duoshuo.com/embed.js';\n" +
            "\t\t\t\t\t\t\t\tds.charset = 'UTF-8';\n" +
            "\t\t\t\t\t\t\t\t(document.getElementsByTagName('head')[0] \n" +
            "\t\t\t\t\t\t\t\t || document.getElementsByTagName('body')[0]).appendChild(ds);\n" +
            "\t\t\t\t\t\t\t})();\n" +
            "\t\t\t\t\t\t</script>\n" +
            "\t\t\t\t\t\t<!-- 多说评论框 end -->\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<div class=\"panel-footer clearfix\"></div>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<!-- 登陆提示begin -->\n" +
            "\t\t\t\t<div class=\"panel panel-default\">\n" +
            "\t\t\t\t\t<div class=\"panel-body\">\n" +
            "\t\t\t\t\t\t<div id=\"reply\" class=\"form box\">\n" +
            "\t\t\t\t\t\t\t<div style=\"padding: 20px;\">\n" +
            "\t\t\t\t\t\t\t\t<a class=\"btn btn-primary\" href=\"http://www.dbmeinv.com/dbgroup/login.htm\">登录</a>\n" +
            "\t\t\t\t\t\t\t\t后将获得更多功能，如果你还没有账号你可以 <a class=\"btn btn-danger\" href=\"http://www.dbmeinv.com/dbgroup/register.htm\">注册</a>&nbsp;一个帐号。\n" +
            "\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t<!-- 登陆提示end -->\n" +
            "\t\t\t\t\n" +
            "\n" +
            "\t\t\t</div>\n" +
            "\t\t\t\n" +
            "\t\t\t\n" +
            "\t\t\t<div class=\"sidebar col-md-3\">\n" +
            "\t\t\t\t<!-- 用户信息 begin -->\n" +
            "\t           \t<div class=\"user-card\">\n" +
            "\t\t\t\t\t<div class=\"pic\">\n" +
            "\t\t\t\t\t\t<img width=\"70px\" height=\"70px\" src=\"http://dynimg2.yixia.com/square.124/storage.video.sina.com.cn/user-icon/sSefTIrbgsjLORxISl9-Og___480__1468132034122.jpg\" alt=\"\" class=\"img-circle\">\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<div class=\"info\">\n" +
            "\t\t\t\t\t\t<ul style=\"line-height: 20px\">\n" +
            "\t\t\t\t\t\t\t<li class=\"name\">闫盼盼pandorar</li>\n" +
            "\t\t\t\t\t\t\t<li class=\"loc\">\n" +
            "\t\t\t\t     \t\t \t常居:&nbsp;暂无\n" +
            "\t\t\t\t      \t\t</li>\n" +
            "\t\t\t\t      \t\t<li class=\"home-link\">\n" +
            "\t\t\t\t      \t\t\t<a target=\"_blank\" href=\"http://www.miaopai.com/u/qqsso_0jm6lxhs7d\">视频主页</a>\n" +
            "\t\t\t\t      \t\t</li>\n" +
            "\t\t\t\t    \t</ul>\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t<!-- 用户信息 end -->\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t<!-- 用户相关帖子 begin -->\n" +
            "\t\t\t\t<div class=\"panel panel-default\">\n" +
            "\t\t\t\t\t<div class=\"panel-heading\">随机美女</div>\n" +
            "\t\t\t\t\t<ul class=\"list-group\">\n" +
            "\t\t\t\t\t\t<li class=\"list-group-item\">\n" +
            "\t\t\t\t\t\t\t<a href=\"http://www.dbmeinv.com/dbgroup/v-4168\">\n" +
            "\t\t\t\t\t\t\t\t<img title=\"小爱姐\" style=\"width: 100px;\" src=\"http://wscdn.miaopai.com/stream/bjF4EpwpqgUEMPXCo4XD2g___tmp_11_223_.jpg\" alt=\"小爱姐\" />\n" +
            "\t\t\t\t\t\t\t</a>\n" +
            "\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t<li class=\"list-group-item\">\n" +
            "\t\t\t\t\t\t\t<a href=\"http://www.dbmeinv.com/dbgroup/v-4168\">\n" +
            "\t\t\t\t\t\t\t\t<img title=\"【红人堂】好希望自己也成为一个灰姑娘[可爱][太开心][害羞]～\" style=\"width: 100px;\" src=\"http://wscdn.miaopai.com/stream/J23V-wYpXSKdb-lHvhmstA___m.jpg\" alt=\"【红人堂】好希望自己也成为一个灰姑娘[可爱][太开心][害羞]～\" />\n" +
            "\t\t\t\t\t\t\t</a>\n" +
            "\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t<li class=\"list-group-item\">\n" +
            "\t\t\t\t\t\t\t<a href=\"http://www.dbmeinv.com/dbgroup/v-4168\">\n" +
            "\t\t\t\t\t\t\t\t<img title=\"原来我也可以做一只小鲜肉?\" style=\"width: 100px;\" src=\"http://wscdn.miaopai.com/stream/jvZSzwCuzVfo5gDEJVK7CQ___m.jpg\" alt=\"原来我也可以做一只小鲜肉?\" />\n" +
            "\t\t\t\t\t\t\t</a>\n" +
            "\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t<li class=\"list-group-item\">\n" +
            "\t\t\t\t\t\t\t<a href=\"http://www.dbmeinv.com/dbgroup/v-4168\">\n" +
            "\t\t\t\t\t\t\t\t<img title=\"灰姑娘的眼泪。\" style=\"width: 100px;\" src=\"http://wsacdn3.miaopai.com/stream/leKbA8uvFmFGSoljH1halQ___tmp_7.jpg\" alt=\"灰姑娘的眼泪。\" />\n" +
            "\t\t\t\t\t\t\t</a>\n" +
            "\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t<li class=\"list-group-item\">\n" +
            "\t\t\t\t\t\t\t<a href=\"http://www.dbmeinv.com/dbgroup/v-4168\">\n" +
            "\t\t\t\t\t\t\t\t<img title=\"用@秒拍 客户端里的任意一个电影特效拍视频，加话题#我看我有戏#上传至秒拍，并同步微博，就有机会得到“秒拍奥斯卡奖”获得AppleWatch噢！\" style=\"width: 100px;\" src=\"http://wscdn.miaopai.com/stream/XdCxPX38no1BFaPQ8d5LxA___tmp_11_673_.jpg\" alt=\"用@秒拍 客户端里的任意一个电影特效拍视频，加话题#我看我有戏#上传至秒拍，并同步微博，就有机会得到“秒拍奥斯卡奖”获得AppleWatch噢！\" />\n" +
            "\t\t\t\t\t\t\t</a>\n" +
            "\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t\t<li class=\"list-group-item\">\n" +
            "\t\t\t\t\t\t\t<a href=\"http://www.dbmeinv.com/dbgroup/v-4168\">\n" +
            "\t\t\t\t\t\t\t\t<img title=\"\" style=\"width: 100px;\" src=\"http://wscdn.miaopai.com/stream/N7HTJpu75bOdQnjsTEvN0Q___m.jpg\" alt=\"\" />\n" +
            "\t\t\t\t\t\t\t</a>\n" +
            "\t\t\t\t\t\t</li>\n" +
            "\t\t\t\t\t</ul>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t<!-- 用户相关帖子 end -->\n" +
            "\n" +
            "\t\t\t\t<!-- 广告 -->\n" +
            "<!-- 3cerp \n" +
            "<div class=\"panel panel-default\">\n" +
            "\t<div class=\"panel-heading\">3C网店宝-专业的3C类目网店ERP软件</div>\n" +
            "\t<center>\n" +
            "\t<a href=\"http://www.3cerp.com\" target=\"_blank\" title=\"专业的3c网店erp软件\">\n" +
            "\t\t<div style=\"background:url(http://ww1.sinaimg.cn/large/0060lm7Tgw1ewcsgyhn0nj307a062aar.jpg) no-repeat;height:218px; width: auto;\"></div>\n" +
            "\t</a>\n" +
            "\t</center>\n" +
            "</div>-->\t\t\t\t\n" +
            "\t\t\t\t<!-- 推荐 -->\n" +
            "\t\t\t\t<div id=\"baidu_reigt_advert\" class=\"panel panel-default\">\n" +
            "                \t<div class=\"panel-heading\">推荐信息</div>\n" +
            "                \t<center>\n" +
            "\t\t\t\t\t\t<script type=\"text/javascript\">/*250*250 图片*/var cpro_id = \"u2294310\";</script>\n" +
            "\t\t\t\t\t\t<script src=\"http://cpro.baidustatic.com/cpro/ui/c.js\" type=\"text/javascript\"></script>\n" +
            "\t\t\t\t\t\t<br>\n" +
            "\t\t\t\t\t\t<script>QIHOO_UNION_SLOT={w:250, h:250, ls:\"s02e1f5c18c\"};</script><script src=\"http://s.lianmeng.360.cn/so/inlay.js\" charset=\"utf-8\"></script>\n" +
            "\t\t\t\t\t</center>\n" +
            "\t\t\t\t</div> \n" +
            "\t\t\t\t\n" +
            "\t\t\t</div>\n" +
            "\t\t</div>\n" +
            "\t\t\n" +
            "\t</div>\n" +
            "\t\n" +
            "\t<!-- 底部 -->\n" +
            "<footer class=\"footer\">\n" +
            "\t<div class=\"container\">\n" +
            "\t\t<div class=\"media\">\n" +
            "\t\t\t<!-- <div class=\"media-left\" style=\"margin-right: 20px;\">\n" +
            "\t\t\t\t<img class=\"media-object\" src=\"\" style=\"width: 56px;\" />\n" +
            "\t\t\t</div> -->\n" +
            "\t\t\t<div class=\"media-body\">\n" +
            "\t\t\t\t<div class=\"links\">\n" +
            "\t\t\t\t\t<a href=\"http://www.dbmeinv.com/dbgroup/videos.htm\" baidu_event=\"friendlink,www.dbmeinv.com,\">秒拍福利</a>&nbsp;/&nbsp;\n" +
            "\t\t\t\t\t<a href=\"http://www.dbmeinv.com/\" baidu_event=\"friendlink,www.dbmeinv.com,\">豆瓣妹子</a>&nbsp;/&nbsp;\n" +
            "\t\t\t\t\t<a href=\"http://www.dbmeinv.com/dbgroup/announce.htm\">免责声明</a>&nbsp;/&nbsp;\n" +
            "\t\t\t\t\t<a href=\"http://www.dbmeinv.com/dbgroup/app.htm\">APP下载</a>&nbsp;/&nbsp;\n" +
            "\t\t\t\t\t<a href=\"http://www.dbmeinv.com/dbgroup/feedback.htm\">站内留言</a>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t\t<div class=\"copyright\">\n" +
            "\t\t\t\t\t豆瓣美女是基于豆瓣请不要害羞、大胸妹、大长腿等豆瓣热门小组的第三方爆照交友社区。<br /> \n" +
            "\t\t\t\t\tCopyright&copy;2015 dbmeinv.com 苏ICP备14036269号-2&nbsp;|&nbsp;声明：本站所有图片来源于互联网！若有任何版权问题，请联系我们，我们将立即予以纠正注明来源！\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t</div>\n" +
            "\t\t\t<div class=\"media-right\" style=\"width: 200px; text-align: right;\">\n" +
            "\t\t\t\t&nbsp;\n" +
            "\t\t\t</div>\n" +
            "\t\t</div>\n" +
            "\t</div>\n" +
            "</footer>\n" +
            "\n" +
            "<script src=\"http://www.dbmeinv.com/resource/js/plugin/bootstrap/js/bootstrap.min.js\"></script>\n" +
            "<script src=\"http://www.dbmeinv.com/resource/js/plugin/other/backtop.js\"></script>\n" +
            "<script src=\"http://www.dbmeinv.com/dbgroup/resource/js/db_common.js\"></script>\n" +
            "<script type=\"text/javascript\">\n" +
            "if(pc_flag != \"pc\") {\n" +
            "\t$(\".mobile-hide\").hide();\n" +
            "\tdocument.write('<script type=\"text/javascript\">/*20:3 手机底悬浮*/var cpro_id = \"u1668553\";</script' + '>' + '<script src=\"http://cpro.baidustatic.com/cpro/ui/cm.js\" type=\"text/javascript\"></script</script' + '>');\n" +
            "    document.write('<script type=\"text/javascript\">/*插屏-进入展开*/ var cpro_id = \"u2382969\";</script' + '>' + '<script src=\"http://cpro.baidustatic.com/cpro/ui/cm.js\" type=\"text/javascript\"></script</script' + '>');\t\n" +
            "}\n" +
            "</script> \n" +
            "\n" +
            "<div style=\"display:none\">\n" +
            "\t<!-- baidu tongji -->\n" +
            "\t<script type=\"text/javascript\">\n" +
            "\tvar _bdhmProtocol = ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");\n" +
            "\tdocument.write(unescape(\"%3Cscript src='\" + _bdhmProtocol + \"hm.baidu.com/h.js%3F65499fd57541d09e46def2791033d87f' type='text/javascript'%3E%3C/script%3E\"));\n" +
            "\t</script>\n" +
            "\t<!-- cnzz -->\n" +
            "\t<script src=\"http://s4.cnzz.com/z_stat.php?id=1254770214&web_id=1254770214\" language=\"JavaScript\"></script>\n" +
            "</div>\n" +
            "    <script type=\"text/javascript\">\n" +
            "\t    $(function (){\n" +
            "\t    \t$(window).manhuatoTop({showHeight : 100,/*设置滚动高度时显示*/ speed : 500 /*返回顶部的速度以毫秒为单位*/\t});\n" +
            "\t    });\n" +
            "\t</script>\n" +
            " </body>\n" +
            "</html>\n";

    public static void main(String[] args){
        //List<ImageFuli> imageFulis = handleVideoResponse(test);

        Document dom = Jsoup.parse(test);
        dom.select("");


    }

    public static List<ImageFuli> handleVideoResponse(String httpResponse) {
        List<ImageFuli> ret = new ArrayList<>();

        Document document = Jsoup.parse(httpResponse);
        Elements elements = document.select("div[class=thumbnail]>div[class=img_single]>span>a>img");
        for (Element e : elements) {
            String url = e.attr("src");
            String title = e.attr("title");
            ImageFuli imageFuli = new ImageFuli(url);
            imageFuli.setType(0);
            imageFuli.setTitle(title);
            ret.add(imageFuli);
        }
        return ret;
    }
}
