package cn.kxind.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/29.
 */
@Controller
public class UrlController {
    /**
     * 展示
     * @return
     */
    @GetMapping("/showInfo")
    public String showInfo(){
        return "graph_visit";
    }

    /**
     * 文章统计
     * @return
     */
    @GetMapping("/countArticle")
    public String countArticle(){
        return "graph_flot";
    }

    /**
     * 注册
     * @return
     */
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 登录
     * @return
     */
    @GetMapping("/login")
    public String Login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null){
            return "layouts";

        }
        return "login";
    }

    /**
     * 主页跳转
     * @return
     */
    @GetMapping("/")
    public String index(){

        return  "layouts";
    }

    /**
     * 覆盖率
     * @return
     */
    @GetMapping("/coverage")
    public String coverage(){
        return "graph_sparkline";
    }

    /**
     * 数据详情
     * @return
     */
    @GetMapping("/dataInfo")
    public String getDate(){
        return "graph_data";
    }
    /**
     * 字符云
     * @return
     */
    @GetMapping("/wordCloud")
    public String getWord(){
        return "graph_word";
    }

    /**
     * 编辑、校稿统计
     * @return
     */
    @GetMapping("/editorInfo")
    public String getEditor(){

        return "graph_editor";
    }

}
