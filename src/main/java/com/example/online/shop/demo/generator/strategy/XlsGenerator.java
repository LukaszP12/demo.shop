package com.example.online.shop.demo.generator.strategy;

import com.example.online.shop.demo.generator.domain.FileType;
import org.springframework.stereotype.Component;

@Component
public class XlsGenerator extends FileStrategy {

    public XlsGenerator() {
        super(FileType.XLS);
    }

    @Override
    public byte[] generateFile() {
        return new byte[0];
    }

}
