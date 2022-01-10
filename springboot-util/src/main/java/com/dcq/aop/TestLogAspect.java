package com.dcq.aop;

import com.alibaba.fastjson.JSON;
import com.dcq.annotation.TestLog;
import com.dcq.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;
// 使当前类成为切面类
@Aspect
@Component
@Slf4j
public class TestLogAspect {
    // 定义切入点，这边是对注解切入，也可以对类切入。
    @Pointcut("@annotation(com.dcq.annotation.TestLog)")
    public void pointCut(){}

    /**
     *环绕通知
     1）目标方法的调用由环绕通知决定，即你可以决定是否调用目标方法，而前置和后置通知是不能决定的，它们只是在方法的调用前后执行通知而已，即目标方法肯定是要执行的。joinPoint.proceed()就是执行目标方法的代码。

     2）环绕通知可以控制返回对象，即可以返回一个与目标对象完全不同的返回值。虽然这很危险，但是却可以做到。
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取方法签名 : 包含方法名和形参列表
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        System.out.println("获取方法");
        Method method = ms.getMethod();
        Object result = null;
        try {
            // 执行方法返回结果
            result = joinPoint.proceed();
            System.out.println("执行方法逻辑");
            return result;
        } catch (Throwable throwable) {
            result = throwable.getMessage();
            throw throwable;
        } finally {
            System.out.println("执行注解方法结束后的逻辑");
            String operation = method.getName();
            // 获取注解类
            TestLog testLog = method.getAnnotation(TestLog.class);
            if (testLog != null) {
                // 获取属性注解值
                operation = testLog.value();
            }
            Map<String, Object> argsMap = JSON.parseObject(JSON.toJSONString(joinPoint.getArgs()[0]), Map.class) ;
            log.info("\n      [调用类型]:{}\n      [参数]:{}\n      [操作人]:{}\n      [操作站点]:{}\n      [调用结果]:{}",
                    JSON.toJSONString(operation),
                    JSON.toJSONString(joinPoint.getArgs()[0]),
                    "admin",
                    WebUtils.getIpAddr(WebUtils.getHttpServletRequest()),
                    JSON.toJSONString(result));
            try {
                    //另新增逻辑
                //冻结
                /*if (ExterCallType.FROZEN.equals(operation)) {
                    JSONObject dataJson = JSON.parseObject(JSON.toJSONString(result));
                    investFeeChargeJour.setUnfrozenBalance(
                            new BigDecimal(dataJson.getString("rest_balance")));
                    investFeeChargeJour.setFrozenBalance(new BigDecimal(dataJson.getString("success_balance")));
                } else if (ExterCallType.REFUND.equals(operation)) {
                    investFeeChargeJour.setChargedBalance(investFeeChargeJour.getOccurBalance());
                }
                investFeeChargeJour.setCommitDate(new Date());
                investFeeChargeJour.setOperatorNo(RequestUtils.getUserName());
                investFeeChargeJour.setOpStation(WebUtils.getIpAddr(WebUtils.getHttpServletRequest()));
                investFeeChargeJourQueue.offer(investFeeChargeJour);*/
            } catch (Exception e) {
                log.warn(e.getMessage(), e);
            }
        }

    }

}
