package top.guke.springboot.configure.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.wangxingyu.springboot.configure.entity.Server;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServerTest {
    @Resource
    private Server server;

    @Test
    void test() {
        System.out.println(server);
    }


}