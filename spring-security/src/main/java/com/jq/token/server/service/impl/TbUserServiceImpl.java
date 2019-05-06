package com.jq.token.server.service.impl;

import com.jq.token.server.domain.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.jq.token.server.mapper.TbUserMapper;
import com.jq.token.server.service.TbUserService;
import tk.mybatis.mapper.entity.Example;

@Service
public class TbUserServiceImpl implements TbUserService{

    @Autowired
    private TbUserMapper tbUserMapper;



    @Override
    public TbUser getByUserName(String name) {
        Example example = new Example(TbUser.class);
        example.createCriteria().andEqualTo("username", name);
        return tbUserMapper.selectOneByExample(example);
    }
}
