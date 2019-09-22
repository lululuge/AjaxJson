package cn.luge.test;

import cn.luge.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JacksonTest {
    /**
     * java对象转为json字符串
     */
    @Test
    public void test1() throws IOException {
        Person p1 = new Person();
        p1.setName("陆昝");
        p1.setAge(23);
        p1.setGender("男");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p1);
        System.out.println(json);

        mapper.writeValue(new File("C:\\Users\\34759\\Desktop\\Ajax&Json\\src\\1.txt"), p1);
        mapper.writeValue(new FileWriter("C:\\Users\\34759\\Desktop\\Ajax&Json\\src\\2.txt"), p1);

    }

    @Test
    public void test2() throws JsonProcessingException {
        Person p = new Person();
        p.setName("james");
        p.setAge(30);
        p.setGender("男");
        p.setBirthday(new Date());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
    }

    @Test
    public void test3() throws JsonProcessingException {
        Person p1 = new Person();
        p1.setName("陆昝");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("luge");
        p2.setAge(33);
        p2.setGender("男");
        p2.setBirthday(new Date());

        Person p3 = new Person();
        p3.setName("luke");
        p3.setAge(43);
        p3.setGender("男");
        p3.setBirthday(new Date());

        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
    }

    @Test
    public void test4() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "luzan");
        map.put("age", 24);
        map.put("gender", "男");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }
}
