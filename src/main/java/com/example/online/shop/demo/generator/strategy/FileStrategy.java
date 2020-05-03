package com.example.online.shop.demo.generator.strategy;

import com.example.online.shop.demo.generator.domain.FileType;
import lombok.Getter;

public abstract class FileStrategy {

    @Getter
    private FileType fileType;

    public FileStrategy(FileType fileType) {
        this.fileType = fileType;
    }

    public abstract byte[] generateFile();

}
