package com.nyx.ssm_demo.domain;

import org.hibernate.validator.constraints.NotBlank;

public class Example {
	// 成员变量
	private long id;
	@NotBlank
	private String username;
	@NotBlank
	private String password;

	// 构造函数
	public Example() {
		super();
	}

	public Example(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	// 成员方法

	public String getUsername() {
		return username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
