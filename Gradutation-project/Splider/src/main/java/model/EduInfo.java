package model;


/**
 * Created by kexin on 2017/3/13.
 */
public class EduInfo {
    //标题
    private String title;
    //文章来源
    private String source;
    //发表时间
    private String date;
    //该文章浏览次数
    private int number;
    //图片资源
    private String imgList;
    //文章
    private String mainText;
    //供稿人
    private String provider;
    //编辑人
    private String Editor;
    //校稿人
    private String proofread;
    //审核人
    private  String reviewer;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getImgList() {
        return imgList;
    }

    public void setImgList(String imgList) {
        this.imgList = imgList;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getEditor() {
        return Editor;
    }

    public void setEditor(String editor) {
        Editor = editor;
    }

    public String getProofread() {
        return proofread;
    }

    public void setProofread(String proofread) {
        this.proofread = proofread;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public EduInfo(String title, String source, String date, int number, String imgList, String mainText, String provider, String editor, String proofread, String reviewer) {
        this.title = title;
        this.source = source;
        this.date = date;
        this.number = number;
        this.imgList = imgList;
        this.mainText = mainText;
        this.provider = provider;
        Editor = editor;
        this.proofread = proofread;
        this.reviewer = reviewer;
    }

    public EduInfo() {
    }
}
