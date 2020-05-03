package com.example.online.shop.demo.generator.strategy;

import com.example.online.shop.demo.generator.domain.FileType;
import org.springframework.stereotype.Component;

@Component
public class CsvGenerator extends FileStrategy {

    public CsvGenerator() {
        super(FileType.CSV);
    }

    @Override
    public byte[] generateFile() {
        return new byte[0];
    }

}
