package ex.aaronfae.report.controller;

import ex.aaronfae.report.vo.UsersVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(UsersVO user) {
        System.out.println("username:" + user.getUsername());
        System.out.println("password:" + user.getPassword());
        ModelAndView modelAndView = new ModelAndView("login");
        if (user.getUsername() == null || "".equals(user.getUsername())) {
            return modelAndView.addObject("msg", "请输入用户名");
        }
        if (user.getPassword() == null || "".equals(user.getPassword())) {
            return modelAndView.addObject("msg", "请输入密码");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            System.out.println("^-^账号不存在哦Up");
            modelAndView.addObject("msg", "^-^账号不存在哦Up");
        } catch (IncorrectCredentialsException e) {
            System.out.println("^-^密码不正确哦Up");
            modelAndView.addObject("msg", "^-^密码不正确哦Up");
        }
        return modelAndView;
    }
}
