package com.nnbox.admin.common.exception;

import com.nnbox.admin.common.constants.ErrorCode;

import lombok.Getter;

@Getter
public class BasicException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorCode code;
	private String msg = "";

	public BasicException(ErrorCode code) {
		super(code.name());
		this.code = code;
	}

	public BasicException(ErrorCode code, String msg) {
		super(code.name());
		this.code = code;
		this.msg = msg;
	}
}
