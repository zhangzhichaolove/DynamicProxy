package com.peak.chao.retrofit;

import com.peak.chao.annotation.Path;
import com.peak.chao.call.Call;
import com.peak.chao.model.GitHubModel;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class Retrofit {
    private NewClass newClass = new NewClass();


    public <T> T create(final Class<T> service) {
        Object serviceImpl = Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.err.println("\n方法名: " + method.getName() + "  有以下注解:");
                Annotation[] annotations = method.getAnnotations();
                for (int i = 0; i < annotations.length; i++) {
                    System.err.println("注解：" + annotations[i].toString());
                }
                //执行自己定义的操作，例如将参数传递给okhttp，使用okhttp来进行网络请求。
                Method login = newClass.getClass().getDeclaredMethod(method.getName(), String.class, String.class);
                login.setAccessible(true);
                login.invoke(newClass, args);
                login.setAccessible(false);
                //method.invoke(proxy, args);
                //return method.invoke(proxy, args);
                return null;
            }
        });
        return (T) serviceImpl;
    }

    public class NewClass {

        private Call<List<GitHubModel>> register(@Path("name") String name, @Path("pwd") String password) {
            System.err.println("register调用：\nname:" + name + "\npassword:" + password);
            return null;
        }

        private Call<List<GitHubModel>> login(@Path("name") String name, @Path("pwd") String password) {
            System.err.println("login调用：\nname:" + name + "\npassword:" + password);
            return null;
        }
    }
}