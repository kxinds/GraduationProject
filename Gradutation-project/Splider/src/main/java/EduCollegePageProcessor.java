import dao.EduInfoDao;
import dao.EduInfoDaoImpl;
import model.EduInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.xsoup.Xsoup;

import java.util.List;

public class EduCollegePageProcessor implements PageProcessor {
    private String edu = "http://sdw.hunnu.edu.cn";
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        String allPage = page.getHtml().xpath("[@id='ActionArticle']//span/tidyText()").toString();//所有页数
        if (allPage != null) {
            int allpage = Integer.valueOf(allPage.split("/")[1]);
            for (int i = 1; i <= allpage - 1; i++) {
                int index = i * 8 + 1;
                page.addTargetRequest("http://sdw.hunnu.edu.cn/ActionArticle!listP.action?lanmuId=90&&startIndex=" + index);
            }
            readContent(page);
        } else {
            readContent(page);
        }
        //以下读取每页URL
    }

    private void readContent(Page page) {
        String listView = page.getHtml().xpath("//div[@id='mylist']/ul").toString();
        if (listView != null) {//判断是否是列表页
            Document document = Jsoup.parse(page.getHtml().xpath("//div[@id='mylist']/ul").toString());
            List<String> list = Xsoup.compile("//a/@href").evaluate(document).list();
            System.out.println("该页有"+list.size()+"个内容页面");
            for (String s : list
                    ) {
                page.addTargetRequest(s);//把每页的URL再在加载到爬虫中去
            }
        } else {
            readArticle(page);
        }
    }

    private void readArticle(Page page) {
        EduInfo eduInfo = new EduInfo();
        EduInfoDao eduInfoDao = new EduInfoDaoImpl();
        //以下是读取每页内容
        System.out.println(page.getHtml().xpath("[@id='textTitle']/tidyText()").toString());//标题
        eduInfo.setTitle(page.getHtml().xpath("[@id='textTitle']/tidyText()").toString());
        System.out.println(page.getHtml().xpath("[@id='textInfo']/span[1]/tidyText()").toString().split("：")[1]);//来源
        eduInfo.setSource(page.getHtml().xpath("[@id='textInfo']/span[1]/tidyText()").toString().split("：")[1]);
        System.out.println(page.getHtml().xpath("[@id='textInfo']/span[2]/tidyText()").toString().split("：")[1]);//时间
        eduInfo.setDate(page.getHtml().xpath("[@id='textInfo']/span[2]/tidyText()").toString().split("：")[1]);
        System.out.println(page.getHtml().xpath("[@id='textInfo']/span[3]/tidyText()").toString().split("：")[1].replace(",", ""));//浏览次数
        eduInfo.setNumber(Integer.valueOf(page.getHtml().xpath("[@id='textInfo']/span[3]/tidyText()").toString().split("：")[1].replace(",", "")));
        List<String> imgList = page.getHtml().xpath("[@id='mainText']/div/img/@src").all();//新闻存放的图片的相对路径
        StringBuilder img = new StringBuilder();
        for (int i = 0; i < imgList.size(); i++) {
            System.out.println(edu + imgList.get(i));
            if (i == imgList.size() - 1) {
                img.append(edu + imgList.get(i));
            } else {
                img.append(edu + imgList.get(i) + ",");
            }
        }
        System.out.println(img);
        eduInfo.setImgList(img.toString());
        List<String> mainTextList = page.getHtml().xpath("[@id='mainText']/p").all();//文章
        String mainText = "";
        for (String s : mainTextList
                ) {
            Html html = Html.create(s);
            if (html.xpath("[@style='color:#69696F']").toString() == null) {
                if(html.xpath("[@style='color:#69696F;margin-top:60px']").toString()==null) {
                    mainText += html.xpath("tidyText()").toString();
                }
            }
        }
        System.out.println(mainText);
        eduInfo.setMainText(mainText);
        String provider = page.getHtml().xpath("[@id='mainText']/[@style='color:#69696F;margin-top:60px']/tidyText()").toString();
        System.out.println(provider.split("：")[1]);
        eduInfo.setProvider(provider.split("：")[1]);
        List<String> foot = page.getHtml().xpath("[@id='mainText']/[@style='color:#69696F']/tidyText()").all();//文章尾部
        if (foot != null) {
            if (foot.size() == 1) {
                System.out.println(foot.get(0).split("：")[1]);   //值班编辑
                eduInfo.setEditor(foot.get(0).split("：")[1]);

            } else if (foot.size() == 2) {
                System.out.println(foot.get(0).split("：")[1]);   //值班编辑
                System.out.println(foot.get(1).split("：")[1]);  //校稿人
                eduInfo.setEditor(foot.get(0).split("：")[1]);
                eduInfo.setProofread(foot.get(1).split("：")[1]);

            } else if (foot.size() == 3) {
                System.out.println(foot.get(0).split("：")[1]);   //值班编辑
                System.out.println(foot.get(1).split("：")[1]);  //校稿人
                System.out.println(foot.get(2).split("：")[1]); //审核发布
                eduInfo.setEditor(foot.get(0).split("：")[1]);
                eduInfo.setProofread(foot.get(1).split("：")[1]);
                eduInfo.setReviewer(foot.get(2).split("：")[1]);

            }
        }
        eduInfoDao.saveUser(eduInfo);//持久化操作
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new EduCollegePageProcessor()).addUrl("http://sdw.hunnu.edu.cn/ActionArticle!listP.action?lanmuId=90").thread(1).run();
    }
}