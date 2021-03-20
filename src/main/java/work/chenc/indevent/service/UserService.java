package work.chenc.indevent.service;

import work.chenc.indevent.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserService {

	public List<UserEntity> findAll();

	public Map<String, Object> login(String username, String password);
}
