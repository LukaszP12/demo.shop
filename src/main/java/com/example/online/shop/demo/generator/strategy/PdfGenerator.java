package com.example.online.shop.demo.generator.strategy;

import com.example.online.shop.demo.generator.domain.FileType;
import org.springframework.stereotype.Component;

@Component
public class PdfGenerator extends FileStrategy {

    public PdfGenerator() {
        super(FileType.PDF);
    }

    @Override
    public byte[] generateFile() {
        return new byte[0];
    }

}
