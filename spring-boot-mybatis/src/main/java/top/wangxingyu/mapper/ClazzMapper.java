package top.wangxingyu.mapper;

import top.wangxingyu.Clazz;

/**
 * @author 笼中雀
 */
public interface ClazzMapper {
    //根据id查询班级信息（一对多查询出该班级的所有学生信息）
    Clazz getClazzById(int clazzId);

    Clazz getClazz(int clazzId);
}
