package org.starrysea.mail.common.handler;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String, String> handleBindException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> objectErrors = bindingResult.getAllErrors();
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("success", "false");
        if (CollUtil.isNotEmpty(objectErrors)) {
            errorMap.put("message", objectErrors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(",")));
            return errorMap;
        } else {
            errorMap.put("message", "数据校验失败");
            return errorMap;
        }
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public Map<String, String> handleBindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> objectErrors = bindingResult.getAllErrors();
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("success", "false");
        if (CollUtil.isNotEmpty(objectErrors)) {
            errorMap.put("message", objectErrors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(",")));
            return errorMap;
        } else {
            errorMap.put("message", "数据校验失败");
            return errorMap;
        }
    }
}
