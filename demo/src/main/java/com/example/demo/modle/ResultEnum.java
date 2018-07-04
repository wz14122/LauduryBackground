package com.example.demo.modle;

public enum ResultEnum {
	UNKONW_ERROR(500, "未知错误"),
	SUCCESS(200, "成功"),
	NO_USER(501, "用户不存在"),
	FORM_INCOMPLETE(502, "表单不完整"),
	ENTITY_NOTFOUND(503, "实体不存在"),
	ILLEGAL_ARGUMENT(504, "参数异常");
	;

	private Integer code;

	private String msg;

	ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
