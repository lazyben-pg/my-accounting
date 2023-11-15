package com.lazyben.accounting.dao.mapper;

import com.lazyben.accounting.model.dataobject.UserInfoDO;
import com.lazyben.accounting.model.dataobject.UserInfoDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoDOMapper {
    long countByExample(UserInfoDOExample example);

    int deleteByExample(UserInfoDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserInfoDO row);

    int insertSelective(UserInfoDO row);

    List<UserInfoDO> selectByExample(UserInfoDOExample example);

    UserInfoDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") UserInfoDO row, @Param("example") UserInfoDOExample example);

    int updateByExample(@Param("row") UserInfoDO row, @Param("example") UserInfoDOExample example);

    int updateByPrimaryKeySelective(UserInfoDO row);

    int updateByPrimaryKey(UserInfoDO row);
}