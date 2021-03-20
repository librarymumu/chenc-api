package work.chenc.indevent.mapper;

import work.chenc.indevent.entity.UserEntity;

import java.util.List;


public interface UserMapper {

	public List<UserEntity> findAll();

	public UserEntity selectUserByUserame(String username);

}
