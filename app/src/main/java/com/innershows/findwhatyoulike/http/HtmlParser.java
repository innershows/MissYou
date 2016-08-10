package com.innershows.findwhatyoulike.http;

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
public class HtmlParser {

    /**
     * 利用jsoup框架，进行html解析
     * <p/>
     * TODO 进一步学习jsoup框架
     *
     * @param httpResponse
     * @return
     */
    public static List<ImageFuli> handleResponse(String httpResponse) {
        List<ImageFuli> ret = new ArrayList<>();

        Document document = Jsoup.parse(httpResponse);
        Elements elements = document.select("div[class=thumbnail]>div[class=img_single]>a>img");
        for (Element e : elements) {
            String url = e.attr("src");
            ImageFuli imageFuli = new ImageFuli(url);
            imageFuli.setType(0);
            ret.add(imageFuli);
        }
        return ret;
    }
}
