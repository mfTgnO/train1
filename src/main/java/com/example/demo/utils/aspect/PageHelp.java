package com.example.demo.utils.aspect;

import com.example.demo.utils.JsonResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @package: com.example.demo.utils.aspect
 * @author:
 * @email:
 * @createDate: 2019-06-13 19:13
 * @description:
 */
@Aspect
@Component
public class PageHelp {
    public PageHelp() {
        System.out.println("aspect loading PageHelp");
    }


    @Pointcut("@annotation(com.example.demo.utils.annotation.PageHelp)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        /*String pageNo = request.getParameter("page_no");
        String pageSize = request.getParameter("page_size");*/
        String pageNo = request.getParameter("page");
        String pageSize = request.getParameter("limit");
        if (StringUtils.isNotBlank(pageNo) && StringUtils.isNotBlank(pageSize)) {
            PageHelper.startPage(Integer.valueOf(pageNo), Integer.valueOf(pageSize));
        }
    }

    @AfterReturning(returning = "result", pointcut = "pointCut()")
    public void doAfter(JsonResult result) {
        Object data = result.getData();
        if (data instanceof com.github.pagehelper.Page) {
            long total = ((Page) data).getTotal();
            result.setTotal((int) (total));
            result.setCount((int) total);
        }
        //考虑是在这里 赋值total 还是JsonResult在setData 的时候直接 instanceof 并赋值
    }
}