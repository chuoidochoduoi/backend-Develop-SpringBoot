package org.example.springboottest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
@Setter
@Getter
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;


    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(true, "Thao tác thành công", data);
    }

    // Helper để tạo nhanh response thất bại
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(false, message, null);
    }
}
