package core;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RefelctDemo {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        List<Integer> list = new ArrayList<>();
        list.add(10086);
        //list.add("hehe");  编译错误

        Class<? extends List> aClass = list.getClass();
        Method method = aClass.getDeclaredMethod("add", Object.class);
        Object hehe = method.invoke(list, "hehe");

        log.info("list:{}", list);

    }

}
