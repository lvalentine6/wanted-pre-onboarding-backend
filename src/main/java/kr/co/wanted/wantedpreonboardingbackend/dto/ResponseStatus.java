package kr.co.wanted.wantedpreonboardingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseStatus {

	SUCCESS(true, 200, "The request has been processed successfully"),
	BAD_REQUEST(false, 400, "This request is not accepted by the server"),
	NOT_FOUND(false, 404, "The requested resource could not be found"),
	INVALID_EMAIL(false, 400, "This email is out of format. please try again"),
	INVALID_PASSWORD(false, 400, "This password is out of format. please try again"),
	INVALID_LOGIN(false, 400, "Email or password are invalid. please try again"),
	ArticleAuthUpdate(false, 401, "You can only update your own articles"),
	ArticleAuthDelete(false, 401, "You can only delete your own articles"),
	SERVER_ERROR(false, 500, "The request could not be processed due to an internal server problem");

	private final boolean isSuccess;
	private final int code;
	private final String message;
}
