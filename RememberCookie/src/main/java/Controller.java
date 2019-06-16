import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class Controller {
//    @RequestMapping("/login")
    public void remember(HttpServletRequest request, HttpServletResponse response) {
        //用户名
        String name = request.getParameter("userName");
        //密码
        String passWord = request.getParameter("pwd");

        //记住用户名、密码功能(注意：cookie存放密码会存在安全隐患)
        String remFlag = request.getParameter("remFlag");
        if ("1".equals(remFlag)) { //"1"表示用户勾选记住密码
             /*String cookieUserName = Utils.encrypt(name);
             String cookiePwd = Utils.encrypt(passWord);
             String loginInfo = cookieUserName+","+cookiePwd;*/
            String loginInfo = name + "," + passWord;
            Cookie userCookie = new Cookie("loginInfo", loginInfo);

            userCookie.setMaxAge(30 * 24 * 60 * 60);   //存活期为一个月 30*24*60*60
            userCookie.setPath("/");
            response.addCookie(userCookie);
        }
    }
}
