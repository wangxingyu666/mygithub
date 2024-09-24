package top.guke.zhihu.api.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.wangxingyu.zhihu.api.entity.Special;
import top.wangxingyu.zhihu.api.mapper.SpecialMapper;

import java.util.List;

@SpringBootTest
class SpecialMapperTest {
    @Resource
    private SpecialMapper specialMapper;

    @Test
    void selectAll() {
        List<Special> specials = specialMapper.selectAll();
        specials.forEach(System.out::println);
    }

}