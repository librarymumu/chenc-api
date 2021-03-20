package work.chenc.indevent.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.chenc.indevent.bean.LoginParamRequest;
import work.chenc.indevent.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	@ResponseBody
	public Map<String, Object> login(@RequestBody LoginParamRequest loginParamRequest, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		map.put("result", userService.login(loginParamRequest.getUsername(), loginParamRequest.getPassword()));
		return map;
	}
}
