package kr.ac.dankook.ace.springbootdi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class LoginUserController {
    private final LoginUserService userService;

    // constructor-based dependency injection
    @Autowired // 생성자가 1개만 있으면 생략 가능
    public LoginUserController(LoginUserService userService) {
        this.userService = userService;
        System.out.println("LoginUserController userService.findAll()=" + this.userService.findAll());
        for (var e : this.userService.getUserRepository().getUserList()) {
			System.out.println(e);
		}
    }

    @GetMapping("/list") // localhost:8080/di/user/list
    public String list(Model model) {
        model.addAttribute("userList", this.userService.getUserRepository().getUserList());
        return "userlist"; // templates/userlist.html
    }
}
