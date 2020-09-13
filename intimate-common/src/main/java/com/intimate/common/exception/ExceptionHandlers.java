package com.intimate.common.exception;


import com.intimate.common.enums.ExceptionEnum;
import com.intimate.common.model.ExceptionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 全局拦截controller请求，进行异常封装
@ControllerAdvice
public class ExceptionHandlers {
    //对自定义RuntimeException进行拦截和相关响应的修改
    @ExceptionHandler(MyException.class)
    public ResponseEntity<ExceptionModel> handlerException(MyException e) {
        ExceptionEnum ee = e.getExceptionEnum();
        return ResponseEntity.status(ee.getCode()).body(new ExceptionModel(ee));
    }
}
