package top.wangxingyu.zhihu.api.service;

import top.wangxingyu.zhihu.api.entity.Special;

import java.util.List;

public interface SpecialService {
    List<Special> getAll();

    List<Special> getByPage(int limit, int offset);
}
