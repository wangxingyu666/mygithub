package top.guke.springboot.configure.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.wangxingyu.springboot.configure.mapper.SpecialMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SpecialMapperTest {
    @Resource
    private SpecialMapper specialMapper;

    /*@Test
    void findAll() {
        List<Special> all = specialMapper.findAll();
        all.forEach(System.out::println);
    }*/
}