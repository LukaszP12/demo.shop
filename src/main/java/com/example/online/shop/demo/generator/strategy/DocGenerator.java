package com.example.online.shop.demo.generator.strategy;

import com.example.online.shop.demo.generator.domain.FileType;
import org.springframework.stereotype.Component;

@Component
public class DocGenerator extends FileStrategy {

    public DocGenerator() {
        super(FileType.DOC);
    }

    @Override
    public byte[] generateFile() {
        return new byte[0];
    }
}
