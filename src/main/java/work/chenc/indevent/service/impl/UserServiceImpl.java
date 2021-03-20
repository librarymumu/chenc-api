package work.chenc.indevent.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.chenc.indevent.mapper.UserMapper;
import work.chenc.indevent.entity.UserEntity;
import work.chenc.indevent.service.UserService;
import work.chenc.indevent.util.SHAUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserEntity> findAll() {
		System.out.println("---------------------UserServiceImpl");
//		return null;
		return userMapper.findAll();
	}

	@Override
	public Map<String, Object> login(String username, String password) {
		Map<String, Object> map = new HashMap<>();
		UserEntity userEntity = userMapper.selectUserByUserame(username);
		String shuaPassword = SHAUtil.shaEncode(username, password);
		if (userEntity == null) {
			map.put("code", "-1");
			map.put("msg", "用户不存在");
			return map;
		}
		if(!userEntity.getPassword().equals(shuaPassword)) {
			map.put("code", "-1");
			map.put("msg", "用户民或密码错误");
			return map;
		}
		StpUtil.setLoginId(username);
		map.put("code", "0000");
		map.put("msg", "登录成功");
		map.put("user", userEntity);
		return map;
	}

}
