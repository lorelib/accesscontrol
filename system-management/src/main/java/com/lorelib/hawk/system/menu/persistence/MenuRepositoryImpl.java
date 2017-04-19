package com.lorelib.hawk.system.menu.persistence;

import com.lorelib.hawk.system.menu.domain.Menu;
import com.lorelib.hawk.system.menu.domain.MenuRepository;
import com.lorelib.hawk.infrastructure.helpers.algorithm.IdGenerator;
import com.lorelib.hawk.infrastructure.stereotype.Repository;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author listening
 * @description MenuRepositoryImpl:
 * @create 2017 04 11 11:16.
 */
@Repository
public class MenuRepositoryImpl implements MenuRepository {
    @Override
    public Long identifier() {
        return IdGenerator.nextId();
    }

    @Override
    public List<Menu> getAllMenu() {
        List<Menu> menus = session.selectList(MENU_MAPPER + "getAllMenu");
        return menus;
    }

    @Autowired
    private SqlSessionTemplate session;
    private final static String MENU_MAPPER = MenuRepository.class.getName() + ".";
}
