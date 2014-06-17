package cn.ssms.dao;

import cn.ssms.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);
/**
 * 
 * @param record
 * @return
 */
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	User findUserByLoginName(String username);
}