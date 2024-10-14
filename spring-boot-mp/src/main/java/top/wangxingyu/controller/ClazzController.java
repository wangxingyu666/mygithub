package top.wangxingyu.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.wangxingyu.entity.Clazz;
import top.wangxingyu.service.ClazzService;

/**
 * @author 笼中雀
 */

@RestController
@RequestMapping("/clazz")
@AllArgsConstructor
public class ClazzController {
    private final ClazzService clazzService;

    @GetMapping("/{id}")
    public Clazz getClazzWithTeacher(@PathVariable Long id) {
        return clazzService.getClazzWithTeacher(id);
    }
}
