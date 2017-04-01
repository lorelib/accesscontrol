package com.lorelib.hawk.accesscontrol.infrastructure.persistence;

import com.lorelib.hawk.accesscontrol.domain.Role;
import com.lorelib.hawk.accesscontrol.domain.User;
import com.lorelib.hawk.accesscontrol.domain.UserRepository;
import com.lorelib.hawk.infrastructure.stereotype.Repository;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by listening on 2017/4/1.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public void addUser(User user) {
        sqlSession.insert(RESOURCE_MAPPER + "addUser", user);
    }

    @Override
    public User getUser(String loginId) {
        return sqlSession.selectOne(RESOURCE_MAPPER + "getUser", loginId);
    }

    @Override
    public void addRoleTo(User user) {
        sqlSession.insert(RESOURCE_MAPPER + "addRoleTo");
    }

    @Override
    public void updateRoleFor(User user) {

    }

    @Override
    public void deleteRoleFor(User user) {

    }

    @Override
    public List<Role> getRolesFor(User user) {
        return null;
    }

    @Autowired
    private SqlSessionTemplate sqlSession;
    private final static String RESOURCE_MAPPER = "com.lorelib.hawk.accesscontrol.domain.UserRepository.";
}
