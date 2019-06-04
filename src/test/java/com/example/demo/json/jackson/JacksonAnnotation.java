package com.example.demo.json.jackson;

import com.example.demo.collections.domain.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

/**
 * @package: com.example.demo.json.jackson
 * @author:
 * @email:
 * @createDate: 2019-06-04 16:53
 * @description:
 */
public class JacksonAnnotation {
    /*
     * 2.1. @JsonAnyGetter
     * */
    @Test
    public void test1() throws JsonProcessingException {
        ExtendableBean bean = new ExtendableBean("My bean");
        bean.add("attr1", "val1");
        bean.add("attr2", "val2");

        String result = new ObjectMapper().writeValueAsString(bean);

        // {"name":"My bean","id":1}
        System.out.println(result);

        assertThat(result, containsString("attr1"));
        assertThat(result, containsString("val1"));
    }

    /*
     * 2.2. @JsonGetter
     * */
    @Test
    public void test2() throws JsonProcessingException {
        MyBean bean = new MyBean(1, "My bean");

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);

        assertThat(result, containsString("My bean"));
        assertThat(result, containsString("1"));
    }

    /*
     * 2.3. @JsonPropertyOrder
     * */
    @Test
    public void test3() throws JsonProcessingException {
        MyBean bean = new MyBean(1, "My bean");

        String result = new ObjectMapper().writeValueAsString(bean);

        // {"id":1,"name":"My bean"}
        System.out.println(result);
    }

    /*
     * 2.4. @JsonRawValue
     * */
    @Test
    public void test4() throws JsonProcessingException {
        RawBean bean = new RawBean("My bean", "{\"attr\":false}");

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);

        assertThat(result, containsString("My bean"));
        assertThat(result, containsString("{\"attr\":false}"));
    }

    /*
     * 2.5. @JsonValue
     * */
    @Test
    public void test5() throws JsonProcessingException {
        String enumAsString = new ObjectMapper().writeValueAsString(TypeEnumWithValue.TYPE1);
        System.out.println(enumAsString);

//        assertThat(enumAsString, is("\"Type 1"\"));
        assertThat(enumAsString, is("\"Type 1\""));
    }

    /*
     * 2.6. @JsonRootName
     * */
    @Test
    public void test6() throws JsonProcessingException {
        UserWithRoot user = new UserWithRoot(1, "John");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = mapper.writeValueAsString(user);
        System.out.println(result);

//        assertThat(result, containsString("John"));
        assertThat(result, containsString("user"));
    }

    /*
     * 2.7. @JsonSerialize
     * */
    @Test
    public void test7() throws JsonProcessingException, ParseException {

        SimpleDateFormat df
                = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        String toParse = "20-12-2014 02:30:00";
        Date date = df.parse(toParse);
        Event event = new Event("party", date);

        String result = new ObjectMapper().writeValueAsString(event);
        System.out.println(result);

        assertThat(result, containsString(toParse));
    }

    /*
     * 3. Jackson Deserialization Annotations
     *
     * 3.1. @JsonCreator
     * */
    @Test
    public void test8() throws IOException, ParseException {
        String json = "{\"id\":1,\"theName\":\"My bean\"}";

        BeanWithCreator bean = new ObjectMapper()
                .readerFor(BeanWithCreator.class)
                .readValue(json);
        System.out.println(bean);

        assertEquals("My bean", bean.name);
    }

    /*
     * 3.2. @JacksonInject
     * */
    @Test
    public void test9() throws IOException, ParseException {
        String json = "{\"name\":\"My bean\"}";

        InjectableValues inject = new InjectableValues.Std()
                .addValue(int.class, 1);
        BeanWithInject bean = new ObjectMapper().reader(inject)
                .forType(BeanWithInject.class)
                .readValue(json);
        System.out.println(bean);


        assertEquals("My bean", bean.name);
        assertEquals(1, bean.id);
    }

    /*
     * 3.3. @JsonAnySetter
     * */
    @Test
    public void test10() throws IOException, ParseException {
        String json = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";

        ExtendableBean bean = new ObjectMapper()
                .readerFor(ExtendableBean.class)
                .readValue(json);

        assertEquals("My bean", bean.name);
        assertEquals("val2", bean.getProperties().get("attr2"));
    }
}
