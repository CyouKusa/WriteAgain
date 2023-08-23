package com.example.writeagain.exception;

import com.example.writeagain.vo.Result;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.jws.WebResult;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@ControllerAdvice
@ResponseBody
public class MyGlobalException {
    @ExceptionHandler({Exception.class})
    public Result ReturnException(Exception e, HttpServletResponse response){
        response.setStatus(500);
        if (e instanceof BindException){
            BindException b = (BindException) e;//判断抛出的异常是不是BindException异常,如果是则强转为BindException异常
            List<ObjectError> allErrors = b.getAllErrors();
            ObjectError objectError = allErrors.get(0);
            String defaultMessage = objectError.getDefaultMessage();
            return Result.error(defaultMessage);
        }//上面代码是固定的,可以debug看到相互之间的从属关系以及message在BindException的位置 . 总之就是找出我们写的message发给网页

        String message = e.getMessage();
        if (e instanceof RuntimeException){
            if (e instanceof MethodArgumentNotValidException){
                MethodArgumentNotValidException m = (MethodArgumentNotValidException) e;
                String errorMsg = m.getBindingResult().getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining("\n", "", ""));
            }
            if (e instanceof ConstraintViolationException){
                ConstraintViolationException c = (ConstraintViolationException) e;
                String errorMsg = c.getConstraintViolations().stream()
                        .map(ConstraintViolation::getMessage)
                        .collect(Collectors.joining("\n", "", ""));
                return Result.error(errorMsg);
            }
            if (e instanceof SQLException){
                SQLException s = (SQLException) e;
                return Result.error(e.getMessage());
            }
            if(e instanceof ArithmeticException){
                return Result.error("系统出错,请联系管理员");
            }
            if (message.length()<=20){
                return Result.error(message);
            }else{
                return Result.error();
            }
        }
        if (message.length()<=20){
            return Result.error(message);
        }else{
            return Result.error();
        }
    }
    }
