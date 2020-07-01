package com.hy.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author hanyong
 * @date 2020/5/11 22:54
 */
public class StreamDemo {

    @Test
    public void test1(){
        List<Employee> list= EmployeeData.getEmployees();
        //通过集合创建stream 顺序流
        Stream<Employee> emstream1=list.stream();
        //通过集合创建并行流
        Stream<Employee> emstream2=list.parallelStream();
    }

    @Test
    public void test2(){
        List<Employee> list= EmployeeData.getEmployees();
        Employee[] employs= (Employee[]) list.toArray();
        //通过数组
        Stream<Employee> emstream1=Arrays.stream(employs);

        //基本数据类型数组
        int[] ints=new int[]{1,2,3,4,5};
        IntStream instream= Arrays.stream(ints);
    }

    @Test
    public void test3(){
        //Stream类静态方法 of()，它可以接收任意数量的参数。
        Stream<Integer> st1= Stream.of(1,2,3,4,5);

        List<Employee> list= EmployeeData.getEmployees();
        Stream<Employee> st2=Stream.of(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));
    }

    @Test
    public void test4(){
        //创建无限流
        // 迭代
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);
        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
