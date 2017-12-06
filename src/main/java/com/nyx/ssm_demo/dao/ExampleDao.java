package com.nyx.ssm_demo.dao;

import org.springframework.stereotype.Repository;

import com.nyx.ssm_demo.domain.Example;

@Repository
public interface ExampleDao {
    public int addExample(Example u);
    public Example checkExample(Example u);
}
