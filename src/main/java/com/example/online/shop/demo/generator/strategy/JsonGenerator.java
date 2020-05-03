package com.example.online.shop.demo.generator.strategy;

import com.example.online.shop.demo.generator.domain.FileType;
import org.springframework.stereotype.Component;

@Component
public class JsonGenerator extends FileStrategy {

    public JsonGenerator() {
        super(FileType.JSON);
    }

    @Override
    public byte[] generateFile() {
        return new byte[0];
    }


}
