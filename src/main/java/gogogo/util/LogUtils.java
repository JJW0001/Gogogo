package gogogo.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author 86155
 */
@Aspect
@Component
public class LogUtils {
    @Pointcut("execution(* gogogo.service.impl.*Impl.*(..))")
    public void pointcutService(){}

    @Before("pointcutService()")
    public void startLog(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        System.out.println("[service.impl." + signature.getName() + "]begin---parameter: " + Arrays.toString(args));
    }

    @AfterReturning(value = "pointcutService()", returning = "result")
    public void returnLog(JoinPoint joinPoint, Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("[service.impl." + signature.getName() + "]return: " + result);
    }

    @AfterThrowing(value = "pointcutService()", throwing="exception")
    public void exceptionLog(JoinPoint joinPoint, Exception exception){
        Signature signature = joinPoint.getSignature();
        System.out.println("[service.impl." + signature.getName() + "]exception："+ exception);
    }

    @After("pointcutService()")
    public void endLog(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        System.out.println("[service.impl." + signature.getName() +"]end!");
    }
}
