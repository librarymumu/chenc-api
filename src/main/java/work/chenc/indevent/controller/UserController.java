package work.chenc.indevent.controller;


import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import work.chenc.indevent.entity.UserEntity;
import work.chenc.indevent.service.UserService;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/findAll")
	@ResponseBody
	public List<UserEntity> findAll() {
		System.out.println("---------------------UserController");
		if (!StpUtil.isLogin()) {
			return null;
		}
		return userService.findAll();
	}

}
