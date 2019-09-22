package cn.luge.web.servlet;

import cn.luge.domain.User;
import cn.luge.service.UserService;
import cn.luge.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        boolean flag;
        String msg;
        Map<String, Object> map = new HashMap<String, Object>();
//        // 简化service层操作
//        if (username.equals("luzan") || username.equals("luge") || username.equals("james")) {
//            // 用户名已存在
//            flag = true;
//            msg = "此用户名太受欢迎，请更换一个！";
//        }
//        else {
//            flag = false;
//            msg = "当前用户名可用";
//        }
        // 调用service进行查询操作
        UserService service = new UserServiceImpl();
        User user = service.findByUsername(username);
        if (user != null) {
            // 用户名已存在
            flag = true;
            msg = "此用户名太受欢迎，请更换一个！";
        }
        else {
            flag = false;
            msg = "当前用户名可用";
        }
        // 服务器响应数据
        // 服务器响应的数据想在客户端当做json数据使用时，需要在客户端实现ajax时设置type属性"json"
        response.setContentType("text/html;charset=utf-8"); // 解决客户端的乱码问题

        map.put("userExist", flag);
        map.put("msg", msg);
        // 将map转为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
