package com.example.demo.json.jackson;

import com.example.demo.collections.domain.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
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

    /*
     * 3.4. @JsonSetter
     * */
    @Test
    public void test11() throws IOException, ParseException {
        String json = "{\"id\":1,\"name\":\"My bean\"}";

        MyBean bean = new ObjectMapper()
                .readerFor(MyBean.class)
                .readValue(json);
        System.out.println(bean);

        assertEquals("My bean", bean.getTheName());
    }

    /*
     * 3.5. @JsonDeserialize
     * */
    @Test
    public void test12() throws IOException {
        String json = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Event event = new ObjectMapper()
                .readerFor(Event.class)
                .readValue(json);

        assertEquals("20-12-2014 02:30:00", df.format(event.eventDate));
    }

    @Test
    public void test13() throws JsonProcessingException {
        BeanWithIgnore bean = new BeanWithIgnore(1, "My Bean");

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);

        assertThat(result, containsString("My Bean"));
        assertThat(result, not(containsString("id")));
    }

    @Test
    public void test14() throws JsonProcessingException {
        User.Name name = new User.Name("John", "Doe");
        User user = new User(1, name);

        String result = new ObjectMapper().writeValueAsString(user);
        System.out.println(result);

        assertThat(result, containsString("1"));
        assertThat(result, not(containsString("name")));
        assertThat(result, not(containsString("John")));
    }


    @Test
    public void test15() throws JsonProcessingException {
        MyBeanWithInclude bean = new MyBeanWithInclude(1, null);

        String result = new ObjectMapper().writeValueAsString(bean);

        assertThat(result, containsString("1"));
        assertThat(result, not(containsString("name")));
    }

    @Test
    public void test16() throws JsonProcessingException {
        PrivateBean bean = new PrivateBean(1, "My bean");

        String result = new ObjectMapper().writeValueAsString(bean);

        assertThat(result, containsString("1"));
        assertThat(result, containsString("My bean"));
    }

    @Test
    public void test17() throws JsonProcessingException {
        Zoo.Dog dog = new Zoo.Dog("lacy");
        Zoo zoo = new Zoo(dog);

        String result = new ObjectMapper().writeValueAsString(zoo);
        System.out.println(result);

        assertThat(result, containsString("type"));
        assertThat(result, containsString("dog"));
    }

    @Test
    public void test18() throws IOException {
        final String json = "{\"animal\":{\"name\":\"lacy\",\"type\":\"cat\"}}";

        final Zoo zoo = new ObjectMapper().readerFor(Zoo.class).readValue(json);
        System.out.println(zoo);

        assertEquals("lacy", zoo.animal.name);
        assertEquals(Zoo.Cat.class, zoo.animal.getClass());
    }

    @Test
    public void test19() throws IOException {

        MyBeanProperty bean = new MyBeanProperty(1, "My bean");

        String result = new ObjectMapper().writeValueAsString(bean);

        assertThat(result, containsString("My bean"));
        assertThat(result, containsString("1"));

        MyBean resultBean = new ObjectMapper()
                .readerFor(MyBean.class)
                .readValue(result);
        assertEquals("My bean", resultBean.getTheName());
    }

    @Test
    public void test20() throws ParseException, JsonProcessingException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        String toParse = "20-12-2014 02:30:00";
        Date date = df.parse(toParse);
        EventFormat event = new EventFormat("party", date);

        String result = new ObjectMapper().writeValueAsString(event);
        System.out.println(result);

        assertThat(result, containsString(toParse));
    }

    @Test
    public void test21() throws JsonProcessingException {
        UnwrappedUser.Name name = new UnwrappedUser.Name("John", "Doe");
        UnwrappedUser user = new UnwrappedUser(1, name);

        String result = new ObjectMapper().writeValueAsString(user);
        System.out.println(result);

        assertThat(result, containsString("John"));
        assertThat(result, not(containsString("name")));
    }

    @Test
    public void test22() throws JsonProcessingException {
        Item item = new Item(2, "book", "John");

        String result = new ObjectMapper()
                .writerWithView(Views.Public.class)
                .writeValueAsString(item);
        System.out.println(result);

        assertThat(result, containsString("book"));
        assertThat(result, containsString("2"));
        assertThat(result, not(containsString("John")));
    }

    @Test
    public void test23() throws JsonProcessingException {
        UserWithRef user = new UserWithRef(1, "John");
        ItemWithRef item = new ItemWithRef(2, "book", user);
        user.addItem(item);

        String result = new ObjectMapper().writeValueAsString(item);
        System.out.println(result);

        assertThat(result, containsString("book"));
        assertThat(result, containsString("John"));
        assertThat(result, not(containsString("userItems")));
    }

    @Test
    public void test24() throws JsonProcessingException {
        UserWithIdentity user = new UserWithIdentity(1, "John");
        ItemWithIdentity item = new ItemWithIdentity(2, "book", user);
        user.addItem(item);

        String result = new ObjectMapper().writeValueAsString(item);
        System.out.println(result);

        assertThat(result, containsString("book"));
        assertThat(result, containsString("John"));
        assertThat(result, containsString("userItems"));
    }

    /*
     * Now, in the full test, we define the filter – which excludes all other properties except name from serialization:
     * */
    @Test
    public void test25() throws JsonProcessingException {
        BeanWithFilter bean = new BeanWithFilter(1, "My bean");

        FilterProvider filters
                = new SimpleFilterProvider().addFilter("myFilter", SimpleBeanPropertyFilter.filterOutAllExcept("name"));

        String result = new ObjectMapper()
                .writer(filters)
                .writeValueAsString(bean);
        System.out.println(result);

        assertThat(result, containsString("My bean"));
        assertThat(result, not(containsString("id")));
    }

    @Test
    public void test26() throws JsonProcessingException {
        BeanWithCustomAnnotation bean
                = new BeanWithCustomAnnotation(1, "My bean", null);

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);

        assertThat(result, containsString("My bean"));
        assertThat(result, containsString("1"));
        assertThat(result, not(containsString("dateCreated")));
    }

    @Test
    public void test27() throws JsonProcessingException {
        ItemWithMixIn item = new ItemWithMixIn(1, "book", null);

        String result = new ObjectMapper().writeValueAsString(item);
        assertThat(result, containsString("owner"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(User.class, MyMixInForIgnoreType.class);

        result = mapper.writeValueAsString(item);
        assertThat(result, not(containsString("owner")));
    }

    /*
     * 9. Disable Jackson Annotation
     *
     * Finally – let’s see how we can disable all Jackson annotations.We can do this by
     * disabling the MapperFeature.USE_ANNOTATIONS as in the following example:
     * */
    @Test
    public void test28() throws JsonProcessingException {
        MyBean bean = new MyBean(1, null);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.USE_ANNOTATIONS);
        String result = mapper.writeValueAsString(bean);
        System.out.println(result);

        assertThat(result, containsString("1"));
        assertThat(result, containsString("name"));
    }
}
