package kr.co.wanted.wantedpreonboardingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseStatus {

	SUCCESS(true, 200, "The request has been processed successfully"),
	BAD_REQUEST(false, 400, "This request is not accepted by the server"),
	NOT_FOUND(false, 404, "The requested resource could not be found"),
	SERVER_ERROR(false, 500, "The request could not be processed due to an internal server problem");

	private final boolean isSuccess;
	private final int code;
	private final String message;
}
