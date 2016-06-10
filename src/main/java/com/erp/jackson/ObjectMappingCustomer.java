package com.erp.jackson;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

/**
 * Created by shuai on 2016/4/16.
 */
public class ObjectMappingCustomer extends ObjectMapper  {

    public ObjectMappingCustomer(){
        super();
        //允许单引号
        this.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        //字段和值都加引号
        //this.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        //数字加引号
        this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
        this.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true);
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                    throws IOException, JsonProcessingException {
                jsonGenerator.writeString("");
            }
        });
    }
}
