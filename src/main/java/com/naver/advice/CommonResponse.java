package com.naver.advice;

public class CommonResponse<T> {
    private int status;
    private T data;
    private String message;

    public CommonResponse(int status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public int getStatus() { return status; }
    public T getData() { return data; }
    public String getMessage() { return message; }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(200, data, "success");
    }
}
