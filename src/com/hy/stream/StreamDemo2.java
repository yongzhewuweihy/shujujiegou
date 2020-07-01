package com.hy.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author hanyong
 * @date 2020/5/12 9:48
 */
public class StreamDemo2 {



    @Test
    public void test1(){
        List<Employee> list= EmployeeData.getEmployees();
        Stream<Employee> emstream1=list.stream();

//        filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
//        distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
//        limit(long maxSize) 截断流，使其元素不超过给定数量
//        skip(long n)
//        跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一
//        个空流。与 limit(n) 互补
        emstream1.filter(e -> e.getSalary() >7000 ).forEach(System.out::println);
        System.out.println("-------------------------");
        //只取三个
        list.stream().limit(3).forEach(System.out::println);
        System.out.println("-------------------------");
        //跳过前面3个
        list.stream().skip(3).forEach(System.out::println);

        //distinct()
        System.out.println("-------------------------");
        list.stream().distinct().forEach(System.out::println);
    }

    //映射
    @Test
    public void test2(){
        List<String> list=  Arrays.asList("qq","aa","bb","cc");
        list.stream().map(str-> str.toUpperCase()).forEach(System.out::println);
        System.out.println("-------------------------");
        List<Employee> list1= EmployeeData.getEmployees();
        list1.stream().map(Employee::getName).filter(s->s.length()>2).forEach(System.out::println);
        System.out.println("-------------------------======");

        Stream<Stream<Character>> streamStream = list.stream().map(StreamDemo2::fromStringToStream);
        streamStream.forEach(s->{
            s.forEach(System.out::println);
        });
        System.out.println("-------------------------======++++++");
        //flatMap(Function f)接收一个函数作为参数，将流中的每个值都换成另
        //一个流，然后把所有流连接成一个流
        Stream<Character> characterStream = list.stream().flatMap(StreamDemo2::fromStringToStream);
        characterStream.forEach(System.out::println);
    }


    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> characters=new ArrayList<>();
        for(Character c:str.toCharArray()){
            characters.add(c);
        }
        return characters.stream();
    }

    @Test
    public void test3(){
        List ls1=new ArrayList();
        ls1.add(1);
        ls1.add(2);
        ls1.add(3);
        List ls2=new ArrayList();
        ls2.add(4);
        ls2.add(5);
        ls2.add(6);
        //ls1.add(ls2);
        ls1.addAll(ls2);
        System.out.println(ls1);
    }

    @Test
    public void test4(){

        List<Integer> list=Arrays.asList(-75,8,9,12,89,12,-5);
        list.stream().sorted().forEach(System.out::println);

        List<Employee> list1= EmployeeData.getEmployees();

        //sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
       /* list1.stream().sorted((e1,e2) ->{
            return Integer.compare(e1.getAge(),e2.getAge());
        }).forEach(System.out::println);*/

//        list1.stream().sorted((e1,e2) ->Integer.compare(e1.getAge(),e2.getAge())).forEach(System.out::println);
        list1.stream().sorted((e1,e2) ->{
            int ageValue=Integer.compare(e1.getAge(),e2.getAge());

            return ageValue==0?ageValue:Double.compare(e1.getSalary(),e2.getSalary());
            /*if(ageValue!=0){
                return ageValue;
            }else{
                return Double.compare(e1.getSalary(),e2.getSalary());
            }*/
        }).forEach(System.out::println);
    }

}
