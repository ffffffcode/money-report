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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> ajaxLogin(String username, String password, Boolean rememberMe) {
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        Map<String, Object> resultMap = new LinkedHashMap<>();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
            SecurityUtils.getSubject().login(token);
            resultMap.put("status", 200);
            resultMap.put("message", "登录成功");

        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", e.getMessage());
        }
        return resultMap;
    }

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
            modelAndView.addObject("msg", "用户名不存在");
        } catch (IncorrectCredentialsException e) {
            modelAndView.addObject("msg", "密码不正确");
        }
        return modelAndView;
    }
}
