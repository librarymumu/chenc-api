package work.chenc.indevent.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserEntity extends ComonProperty implements Serializable {

	private int id;

	private String username;

	private String realname;

	private String sex;

	private int age;

	private String cell;

	private String password;

	private String introduce;
}
