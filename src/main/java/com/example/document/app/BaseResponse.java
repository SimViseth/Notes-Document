package com.example.document.app;

import lombok.Getter;
import lombok.Setter;

import static com.example.document.app.AppConstant.FAIL;
import static com.example.document.app.AppConstant.FAIL_CODE;

@Getter
@Setter
public class BaseResponse<T> {
    String code = FAIL_CODE;
    String status = FAIL;
    String msgDev;
    T data;
}
