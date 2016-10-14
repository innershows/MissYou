package com.innershows.findwhatyoulike.http;

import com.innershows.findwhatyoulike.girls_pictures.model.ImageFuli;
import com.innershows.findwhatyoulike.girls_video.model.VideoFuli;
import com.innershows.findwhatyoulike.girls_yp.model.YP;

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
public class HtmlParser {

    /**
     * 利用jsoup框架，进行html解析
     * <p>
     * TODO 进一步学习jsoup框架
     *
     * @param httpResponse
     * @return
     */
    public static List<ImageFuli> handleImageResponse(String httpResponse) {
        List<ImageFuli> ret = new ArrayList<>();

        Document document = Jsoup.parse(httpResponse);
        Elements elements = document.select("div[class=thumbnail]>div[class=img_single]>a>img");
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

    public static List<VideoFuli> handleVideoResponse(String httpResponse) {
        List<VideoFuli> ret = new ArrayList<>();
//
//        Document document = Jsoup.parse(httpResponse);
//        Elements elements = document.select("div[class=thumbnail]>div[class=img_single]>span>a");
//        for (Element e : elements) {
//            VideoFuli videoFuli = new VideoFuli();
//
//            String link = e.attr("href");
//
//            videoFuli.setLinkUrl(link);
//
//            Elements imgs = e.getElementsByTag("img");
//
//            Element img = imgs.get(0);
//            String url = img.attr("src");
//            videoFuli.setImageUrl(url);
//
//            Elements avatarImgs = e.parent().parent().parent().select("div[class=bottombar]>span[class=fl p5]>div[class=avatar]>img");
//            Element avatarImg = avatarImgs.get(0);
//
//            String avatarUrl = avatarImg.attr("src");
//            videoFuli.setAvatarUrl(avatarUrl);
//
//
//            String author = avatarImg.parent().text();
//            videoFuli.setAuthor(author);
//
//
//            Elements titles = e.parent().parent().parent().select("div[class=bottombar]>span[class=fl p5 meta]");
//
//            Element titleEle = titles.get(0);
//            String title = titleEle.text();
//            videoFuli.setTitle(title);
//
//
//            ret.add(videoFuli);
//        }
        return ret;
    }

    public static String handleVideoDetail(String httpResponse) {
        String url = "";
        System.out.println("==httpResponse===>" + httpResponse);
        Document document = Jsoup.parse(httpResponse);
        Elements div = document.select("div[id=detailVideo]");
        url = div.attr("data-video");

        System.out.println("====解析出来的url=>" + url);
        return url;

    }

    public static List<YP> handleYPResponse(String httpResponse) {
        List<YP> ret = new ArrayList<>();

        Document document = Jsoup.parse(httpResponse);

        Elements elements = document.select("a[target=_users_detail]");

        for (Element element : elements) {
            YP yp = new YP();

            String userDetailUrl = element.attr("href");
            yp.setUserDetailUrl(userDetailUrl);
            String avatarUrl = element.getElementsByTag("img").get(0).attr("src");

            yp.setAvatarUrl(avatarUrl);

            Elements detailEle = element.parent().parent().select("div[class=infos media-body]>div[class=title media-heading]>a");

            String contentDetailUrl = detailEle.attr("href");
            yp.setContentDetailUrl(contentDetailUrl);

            String title = detailEle.text();
            yp.setTitle(title);

            Elements groupEle = element.parent().parent().select("div[class=infos media-body]>div[class=info]>a");

            String group = groupEle.text();

            yp.setGroup(group);

            Elements info = element.parent().parent().select("div[class=infos media-body]>div[class=info]");
//            groupEle.
//

            String text = info.text();
            System.out.println("==>text" + text);
            String nickname = text.split("•")[1].trim();
            String date = text.split("•")[2].trim();
            //System.out.println("==>name"+split[0]);
            //System.out.println("==>date"+split[1]);
            // System.out.println(element1);
            yp.setUserName(nickname);
            yp.setDate(date);


            ret.add(yp);
        }
        return ret;
    }
}
