package com.tongpao.constant;

/**
 * <p>Title: ApprovalStatusEnum</p>
 * <p>Description: </p>
 *
 * @author Administrator
 * @version 1.0
 * @date 2020/5/29 19:01
 */
public enum ApprovalStatusEnum {
	SUCCESS("SUCCESS","成功"),
	FAIL("FAIL","失败"),
	PROCESSING("PROCESSING","审核中");

	private String code;

	private String desc;

	ApprovalStatusEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}