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
    public void addRoleTo(User user) {
        sqlSession.insert(RESOURCE_MAPPER + "addRoleTo", user);
    }

    @Override
    public void updateRoleFor(User user) {

    }

    @Override
    public void deleteRoleFor(User user) {

    }

    @Override
    public List<Role> getRolesFor(User user) {
        return sqlSession.selectList(RESOURCE_MAPPER + "getRolesFor", user);
    }

    @Autowired
    private SqlSessionTemplate sqlSession;
    private final static String RESOURCE_MAPPER = "com.lorelib.hawk.accesscontrol.domain.UserRepository.";
}
