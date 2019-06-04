package com.example.demo.collections.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @package: com.example.demo.collections.domain
 * @author:
 * @email:
 * @createDate: 2019-06-04 17:45
 * @description:
 */
public class CustomDateSerializer extends StdSerializer<Date> {
    private static SimpleDateFormat formatter
            = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    public CustomDateSerializer() {
        this(null);
    }

    public CustomDateSerializer(Class<Date> t) {
        super(t);
    }

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(formatter.format(value));
    }
}
