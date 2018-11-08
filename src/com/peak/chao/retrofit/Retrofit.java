package com.peak.chao.retrofit;

import com.peak.chao.annotation.Field;
import com.peak.chao.annotation.GET;
import com.peak.chao.annotation.POST;
import com.peak.chao.annotation.Query;
import com.peak.chao.call.Call;
import com.peak.chao.model.GitHubModel;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.List;

public class Retrofit {
    private NewClass newClass = new NewClass();


    public <T> T create(final Class<T> service) {
        Object serviceImpl = Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.err.println("\n方法名: " + method.getName() + "  有以下注解:");
//                Annotation[] annotations = method.getAnnotations();
//                for (int i = 0; i < annotations.length; i++) {
//                    System.err.println("注解：" + annotations[i].toString());
//                }
                printMethod(method, args);
                //执行自己定义的操作，例如将参数传递给okhttp，使用okhttp来进行网络请求。
                //Method login = newClass.getClass().getDeclaredMethod(method.getName(), String.class, String.class);
                //login.setAccessible(true);
                //login.invoke(newClass, args);
                //login.setAccessible(false);
                //method.invoke(proxy, args);
                //return method.invoke(proxy, args);
                return null;
            }
        });
        return (T) serviceImpl;
    }

    private void printMethod(Method method, Object[] args) {
        StringBuffer url = new StringBuffer();
        for (Annotation anno : method.getDeclaredAnnotations()) {
            if (anno.annotationType().equals(GET.class)) {//找到自己的注解
                url.append(((GET) anno).value());
                System.err.println("进行GET请求，请求地址：" + ((GET) anno).value());
            } else if (anno.annotationType().equals(POST.class)) {//找到自己的注解
                url.append(((POST) anno).value());
                System.err.println("进行POST请求，请求地址：" + ((POST) anno).value());
            } else {
                throw new RuntimeException("方法没有指定请求方式！");
            }
        }
        Annotation[][] annotations = method.getParameterAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            if (i == 0) {
                url.append("?");
            }
            if (annotations[i][0].annotationType() == Field.class) {
                url.append(((Field) annotations[i][0]).value() + "=" + args[i] + "&");
            } else if (annotations[i][0].annotationType() == Query.class) {
                url.append(((Query) annotations[i][0]).value() + "=" + args[i] + "&");
            }
        }
        if (annotations.length > 1) {
            url.deleteCharAt(url.length() - 1);
        }
        for (Annotation[] anno : method.getParameterAnnotations()) {
            System.err.println(anno[0].annotationType()/* == Field.class*/);
        }
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            System.err.println(parameters[i].getType());
            System.err.println(args[i]);
        }
        System.err.println("执行请求：" + url.toString());
//        System.err.println(method.getAnnotations());
//        System.err.println(method.getReturnType());
//        System.err.println(method.getParameterTypes());
//        System.err.println(method.getParameterAnnotations());

    }

    public class NewClass {

        private Call<List<GitHubModel>> register(@Field("name") String name, @Field("pwd") String password) {
            System.err.println("register调用：\nname:" + name + "\npassword:" + password);
            return null;
        }

        private Call<List<GitHubModel>> login(@Field("name") String name, @Field("pwd") String password) {
            System.err.println("login调用：\nname:" + name + "\npassword:" + password);
            return null;
        }
    }
}
