package com.tml.mouseDemo.core.stream;

import java.util.Comparator;
import java.util.function.*;

public class FunctionDemo {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, String> biFunction = (x, y) -> x + "---" + y;

        Function<String, String> function = str -> "function:" + str;
        System.out.println(biFunction.apply(5, 8));

        System.out.println(biFunction.andThen(function).apply(1, 7));


        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
        Comparator<Integer> comparator = Comparator.comparingInt(x -> x);
        Integer apply = BinaryOperator.minBy(comparator).apply(4, 7);
        System.out.println(apply);



        System.out.println("=======================================");
        /**
         * 有一个输入，没有输出的静态方法
         * 使用Consumer
         *
         * 有一个输入，一个输出，使用Function
         *
         * 没有输入，有一个输出，使用Supplier
         */
        Consumer<Integer> consumer = Person::sleep;

        consumer.accept(8);

        Person person = new Person("zhangsan");
        Function<String,String> fun1=person::study;
        System.out.println(fun1.apply("java"));

        Supplier<String> supplier = person::play;
        System.out.println(supplier.get());

        Function<String, Person> fun2 = Person::new;
        System.out.println(fun2.apply("张三"));


        Supplier<Person> supplier1 = Person::new;
        System.out.println(supplier1.get());



    }
}
