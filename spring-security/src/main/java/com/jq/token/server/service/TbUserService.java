package com.jq.token.server.service;

import com.jq.token.server.domain.TbUser;

public interface TbUserService{
    TbUser getByUserName(String name);
}
