package com.hy.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author hanyong
 * @date 2020/5/12 18:31
 */
public class StreamEndDemo {
//    allMatch(Predicate p) 检查是否匹配所有元素
//    anyMatch(Predicate p) 检查是否至少匹配一个元素
//    noneMatch(Predicate p) 检查是否没有匹配所有元素
//    findFirst() 返回第一个元素
//    findAny() 返回当前流中的任意元素

    @Test
    public void test1() {
        List<Employee> list1 = EmployeeData.getEmployees();
        //是否所有员工年龄都大于18
        System.out.println(list1.stream().allMatch(employee -> employee.getAge() > 18));
        //是否有员工工资大于9000
        System.out.println(list1.stream().anyMatch(employee -> employee.getSalary() > 9000));
        //是否存在员工性“雷”
        System.out.println(list1.stream().noneMatch(employee -> employee.getName().startsWith("雷")));
        Optional<Employee> first = list1.stream().findFirst();
        System.out.println(first);
//        count() 返回流中元素总数
//        max(Comparator c) 返回流中最大值
//        min(Comparator c) 返回流中最小值
//        forEach(Consumer c)
//        内部迭代(使用 Collection 接口需要用户去做迭代，
//                称为外部迭代。相反，Stream API 使用内部迭
//                代——它帮你把迭代做了)
    }

    @Test
    public void test2() {
        List<Employee> list1 = EmployeeData.getEmployees();
        //max(Comparator c) 返回流中最大值工资
        Stream<Double> doubleStream = list1.stream().map(employee -> employee.getSalary());
        Optional<Double> max = doubleStream.max(Double::compare);
        System.out.println(max);
        //返回工资最低的员工
        Optional<Employee> min = list1.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);
    }

    //归约
    @Test
    public void test3() {
//        reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一
//        个值。返回 T
        //计算自然数1到10的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer integer = list.stream().reduce(0, Integer::sum);
        System.out.println(integer);
//        reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一
//        个值。返回 Optional<T>
        //计算公司所有员工工资的和
        List<Employee> list1 = EmployeeData.getEmployees();
//        Optional<Double> sumSalary = list1.stream().map(Employee::getSalary).reduce(Double::sum);
        Optional<Double> sumSalary = list1.stream().map(Employee::getSalary).reduce((d1, d2) -> d1 + d2);
        System.out.println(sumSalary);
    }

    @Test
    public void test4() {
        List<Employee> list1 = EmployeeData.getEmployees();
        //获取宫紫大于6000的员工，返回一个list或者set
        List<Employee> collect = list1.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println();
        Set<Employee> collect1 = list1.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toSet());
        collect1.forEach(System.out::println);
    }
}
