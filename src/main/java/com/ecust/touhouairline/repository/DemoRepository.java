package com.ecust.touhouairline.repository;

import com.ecust.touhouairline.entity.DemoEntity;

public interface DemoRepository extends BaseRepository<DemoEntity,Integer> {
    /**
     * 示例函数，什么都不干（
     * @param demo
     */
    void demo(DemoEntity demo);
}
