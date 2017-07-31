import dao.EduInfoDao;
import dao.EduInfoDaoImpl;
import model.EduInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.xsoup.Xsoup;

import java.util.List;

public class oldEduCollegePageProcessor implements PageProcessor {
    private String edu = "http://sdw0.hunnu.edu.cn";
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        String allPage = page.getHtml().xpath("[@class='PageList']/tidyText()").toString();//所有页数
        if (allPage != null) {
            allPage = allPage.split("页 共")[0].split(":")[1];
            int all = Integer.valueOf(allPage.split("/")[1]);
            for (int i = 2; i <= all; i++) {
                page.addTargetRequest("http://sdw0.hunnu.edu.cn/ArticleList.asp?C_ID=245&ShowType=news&page=" + i);
            }
              readContent(page);
        } else {
            readContent(page);
        }
        }
    private void readContent(Page page) {
        String listView = page.getHtml().xpath("//div[@id='ArticleList']/ul").toString();
        if (listView != null) {//判断是否是列表页
            Document document = Jsoup.parse(page.getHtml().xpath("//div[@id='ArticleList']/ul").toString());
            List<String> list = Xsoup.compile("//a/@href").evaluate(document).list();
            System.out.println("该页有" + list.size() + "个内容页面");
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
        System.out.println(page.getHtml().xpath("[@class='content_title']/h1/tidyText()").toString());//标题
        eduInfo.setTitle(page.getHtml().xpath("[@class='content_title']/h1/tidyText()").toString());
        //System.out.println(page.getHtml().xpath("[@class='pubbox articlemes gray_fonts']/tidyText()").toString());
        String[] allinfo=page.getHtml().xpath("[@class='pubbox articlemes gray_fonts']/tidyText()").toString().split("    ");
        if(allinfo[0].split("：").length==2){
            System.out.println(allinfo[0].split("：")[1]);//供稿人
            eduInfo.setProvider(allinfo[0].split("：")[1]);
        }
        System.out.println(allinfo[1].split("：")[1].toString().replace("/","-"));
        eduInfo.setDate(allinfo[1].split("：")[1].toString().replace("/","-"));
        System.out.println(allinfo[2].split(" <")[0]);//来源
        eduInfo.setSource(allinfo[2].split(" <")[0]);
        System.out.println(allinfo[3].split("：")[1]);//点击次数
        eduInfo.setNumber(Integer.valueOf(allinfo[3].split("：")[1]));
        List<String> imgList = page.getHtml().xpath("[@id='ArticleContent']//img/@src").all();//新闻存放的图片的相对路径
        StringBuilder img = new StringBuilder();
        for (int i = 0; i < imgList.size(); i++) {
            if (i == imgList.size() - 1) {
                img.append(edu + imgList.get(i));
            } else {
                img.append(edu + imgList.get(i) + ",");
            }
        }
        System.out.println(img);
        eduInfo.setImgList(img.toString());
        String Editor=page.getHtml().xpath("[@id='ArticleContent']//p[@align='right']//tidyText()").toString();
        if(Editor=="null"){
            System.out.println(Editor.split("：")[1].split("）")[0]);//编辑人
            eduInfo.setEditor(Editor.split("：")[1].split("）")[0]);
        }
        List<String> mainText=page.getHtml().xpath("[@id='ArticleContent']//p//tidyText()").all();
        StringBuilder Text= new StringBuilder();
        for (String s:mainText){
            Text.append(s);
        }
        System.out.println(Text);
        eduInfo.setMainText(Text.toString());
        eduInfoDao.saveUser(eduInfo);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new oldEduCollegePageProcessor()).addUrl("http://sdw0.hunnu.edu.cn/ArticleList.asp?C_ID=245&ShowType=news").thread(1).run();
    }
}