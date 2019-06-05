package com.example.demo.json.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @package: com.example.demo.json.jackson
 * @author:
 * @email:
 * @createDate: 2019-06-05 17:19
 * @description:
 */
public class MarshallStringToJsonNode {
    /*
     * 2. Quick Parsing
     * Very simply, to parse the JSON String we only need an ObjectMapper:
     * */
    @Test
    public void test1() throws IOException {
        String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);

        System.out.println(jsonNode);
        assertNotNull(jsonNode);
    }

    /*
     * 3. Low Level Parsing
     * If, for some reason, you need to go lower level than that, the following example exposes
     * the JsonParser responsible with the actual parsing of the String:
     * */
    @Test
    public void test2() throws IOException {
        String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonFactory factory = objectMapper.getFactory();
        JsonParser parser = factory.createParser(jsonString);
        TreeNode treeNode = objectMapper.readTree(parser);

        System.out.println(treeNode);
        assertNotNull(treeNode);
    }

    /*
     * 4. Using the JsonNode
     * After the JSON is parsed into a JsonNode Object, we can work with the Jackson JSON Tree Model:
     * */
    @Test
    public void test3() throws IOException {
        String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);

        JsonNode jsonNode1 = jsonNode.get("k1");
        assertThat(jsonNode1.textValue(), equalTo("v1"));
    }
}
