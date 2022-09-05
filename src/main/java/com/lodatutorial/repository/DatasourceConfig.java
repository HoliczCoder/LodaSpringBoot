package com.lodatutorial.repository;

import com.lodatutorial.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
public class DatasourceConfig {
    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void initData() {
        // Insert 100 User vào H2 Database sau khi
        // DatasourceConfig được khởi tạo
        //System.out.println("hello");
        userRepository.saveAll(IntStream.range(0, 100)
                .mapToObj(i -> User.builder()
                        .name("name-" + i)
                        .build())
                .collect(Collectors.toList())
        );
    }

}
