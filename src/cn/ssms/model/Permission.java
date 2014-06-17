package cn.ssms.model;

import java.io.Serializable;

/**
	author:lijiqun
	date:2014年6月17日 上午10:54:09 
 */
public class Permission implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7630995592800282350L;
	private Integer id;
	private String code;
	private String name;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", code=" + code + ", name=" + name
				+ "]";
	}

}
