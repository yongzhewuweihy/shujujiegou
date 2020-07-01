package com.hy;

import java.util.*;

/**
 * @author hanyong
 * @date 2020/5/8 18:48
 */
public class MapTest {
    public static void main(String[] args) {

       /* Map<String,String> map=new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        map.put("key5","value5");

        //遍历方法以
      Set<String> keys=  map.keySet();
      for(String key:keys){
          System.out.println(key);
      }
        System.out.println("-----------------------------------------------------");

       Collection<String> values= map.values();
        for (String v:
        values ) {
            System.out.println(v);
        }

        Set<Map.Entry<String, String>> entries=map.entrySet();
        Iterator<Map.Entry<String, String>> entryIterator=entries.iterator();
        while(entryIterator.hasNext()){
            Map.Entry<String,String> entry= entryIterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }*/

       Map<Person,String> map=new HashMap<>();
       Person p1=new Person(12,"hy1");
       Person p2=new Person(13,"hy2");
       Person p3=new Person(14,"hy3");
       Person p4=new Person(14,"hy3");
        System.out.println(p4.equals(p2));
        map.put(p3,"hy3");
        System.out.println(map.get(p4));
        System.out.println(map.get(p3));
    }
}
class Person{
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        if (age != person.age) {
            return false;
        }
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + name.hashCode();
        return result;
    }

    private int age;
    private String name;
    public Person(int age,String name){
        this.age=age;
        this.name=name;
    }


}