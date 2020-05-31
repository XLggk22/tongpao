package com.tongpao.util.common;

import com.tongpao.annotation.IgnoreTokenAuth;
import com.tongpao.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 扫描忽略路径
 *
 * @author raojing
 * @date 2020/4/11 13:51
 */
@Slf4j
public class ScanIgnorePathUtil {

    /**
     * 获取所有加了 IgnoreTokenAuth 注解的url
     *
     * @return
     */
    public static List<String> getAllIgnoreTokenAuthUrl(String packageName) {
        List<String> IgnoreTokenAuthUrlList = new ArrayList<>();
        Set<String> packageClass = PackageScanUtil.findPackageClass(packageName);
        List<Class> clazzList = new ArrayList<>();
        try {
            // 获取controller包下所有的class类
            for (String aClass : packageClass) {
                clazzList.add(Class.forName(aClass));
            }
        } catch (Exception e) {
            log.error("加载类异常--->{}", e.getMessage());
            throw BusinessException.operate("加载类异常");
        }

        for (Class clazz : clazzList) {
            Annotation restControllerAnno = clazz.getAnnotation(RestController.class);
            Annotation controllerAnno = clazz.getAnnotation(Controller.class);
            if (restControllerAnno != null || controllerAnno != null) {
                // 遍历controller
                String basePath = "";
                RequestMapping requestMappingAnno = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
                if (requestMappingAnno != null) {
                    basePath = formatPath(mapperValue(requestMappingAnno.value()));
                    basePath = formatWildcard(basePath);
                    log.info("{} 的根路径: {}", clazz.getName(), basePath);
                }

                // 遍历 controller 方法
                for (Method method : clazz.getMethods()) {
                    // 先扫描 controller 中加了 IgnoreTokenAuth 注解的方法，再去扫描 mapping 注解，可以少创建对象
                    IgnoreTokenAuth ignoreTokenAuthAnno = method.getAnnotation(IgnoreTokenAuth.class);
                    if (ignoreTokenAuthAnno != null) {
                        // 接口方法的 mapping 注解
                        RequestMapping methodRequestMappingAnno = method.getAnnotation(RequestMapping.class);
                        GetMapping methodGetMappingAnno = method.getAnnotation(GetMapping.class);
                        PostMapping methodPostMappingAnno = method.getAnnotation(PostMapping.class);
                        PutMapping methodPutMappingAnno = method.getAnnotation(PutMapping.class);
                        DeleteMapping methodDeleteMappingAnno = method.getAnnotation(DeleteMapping.class);

                        // 接口大部分为 post 请求，先判断 postMapping
                        boolean hasMapping = methodPostMappingAnno != null || methodGetMappingAnno != null || methodPutMappingAnno != null ||
                                methodDeleteMappingAnno != null || methodRequestMappingAnno != null;
                        if (hasMapping) {
                            String methodPath = methodPostMappingAnno != null ? mapperValue(methodPostMappingAnno.value()) :
                                    methodGetMappingAnno != null ? mapperValue(methodGetMappingAnno.value()) :
                                            methodPutMappingAnno != null ? mapperValue(methodPutMappingAnno.value()) :
                                                    methodDeleteMappingAnno != null ? mapperValue(methodDeleteMappingAnno.value()) :
                                                            methodRequestMappingAnno != null ? mapperValue(methodRequestMappingAnno.value()) : "";

                            String path = basePath + formatWildcard(formatPath(methodPath));
                            log.info("接口路径: {}", path);
                            IgnoreTokenAuthUrlList.add(path);
                        }
                    }
                }
            }
        }
        return IgnoreTokenAuthUrlList;
    }

    /**
     * 格式化地址
     *
     * @param path
     * @return
     */
    private static String formatPath(String path) {
        if (!path.startsWith("/")) {
            // 如果地址不是以 / 开头，拼接上 /
            path = "/" + path;
        }
        if (path.endsWith("/")) {
            // 如果地址是以 / 结尾，去掉末尾的 /
            path = path.substring(0, path.length() - 1);
        }
        return path;
    }

    /**
     * 格式化路径通配符
     * 当路由出现中括号时，判断中括号个数，如果只有一个:{}，用一个*号替代，如果超过一个:{}/{}，用两个*号替代
     *
     * @param path
     * @return
     */
    private static String formatWildcard(String path) {
        int startOpenIndexOf = path.indexOf("{");
        if (startOpenIndexOf >= 0) {
            // 如果有开始的括号，拿到最后的结束括号
            int lastCloseIndexOf = path.lastIndexOf("}");

            int lastOpenIndexOf = path.lastIndexOf("{");
            String replaceChar = "*";
            if (startOpenIndexOf != lastOpenIndexOf) {
                // 如果位置不相等，说明有多个中括号
                replaceChar = "**";
            }
            String substring = path.substring(startOpenIndexOf, lastCloseIndexOf + 1);
            path = path.replace(substring, replaceChar);
        }
        return path;
    }

    /**
     * 获取 mapping 中的 value，如果有 mapping，但是没有定义路由值，从注解中拿到的是长度为 0 的字符串数组
     *
     * @param args
     * @return
     */
    private static String mapperValue(String[] args) {
        return args.length == 0 ? "" : args[0];
    }

}
