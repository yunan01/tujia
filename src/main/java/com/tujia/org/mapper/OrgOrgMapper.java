package com.tujia.org.mapper;

import com.tujia.org.model.OrgOrg;

public interface OrgOrgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrgOrg record);

    int insertSelective(OrgOrg record);

    OrgOrg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrgOrg record);

    int updateByPrimaryKey(OrgOrg record);
}