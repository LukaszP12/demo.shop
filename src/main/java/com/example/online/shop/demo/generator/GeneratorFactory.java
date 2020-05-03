package com.example.online.shop.demo.generator;

import com.example.online.shop.demo.generator.domain.FileType;
import com.example.online.shop.demo.generator.strategy.FileStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GeneratorFactory {

    private final List<FileStrategy> strategyList;

    private Map<FileType,FileStrategy> fileStrategyMap;

    @PostConstruct
    public void init(){
        strategyList.stream().collect(Collectors.toMap(
                FileStrategy::getFileType,
                
        ))
    }

}
