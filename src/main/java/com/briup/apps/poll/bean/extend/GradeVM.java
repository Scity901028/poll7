package com.briup.apps.poll.bean.extend;

import com.briup.apps.poll.bean.School;

public class GradeVM {
	private Long id;
	private String name;
	private String description;
	private School school;// 一个年级所属学校的信息

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}
