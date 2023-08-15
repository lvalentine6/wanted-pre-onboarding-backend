package kr.co.wanted.wantedpreonboardingbackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;

@Getter
public class ResponseDto<T> {
	private final boolean isSuccess;
	private final int code;
	private final String message;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private final T data;

	public ResponseDto(ResponseStatus responseStatus, T data) {
		this.isSuccess = responseStatus.isSuccess();
		this.code = responseStatus.getCode();
		this.message = responseStatus.getMessage();
		this.data = data;
	}

	public static <T> ResponseDto<T> of(ResponseStatus responseStatus, T data) {
		return new ResponseDto<>(responseStatus, data);
	}
}
