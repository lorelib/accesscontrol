package com.lorelib.hawk.system.domain.menu;

import com.lorelib.hawk.infrastructure.helpers.base.BaseRepository;

import java.util.List;

/**
 * @author listening
 * @description MenuRepository:
 * @create 2017 04 10 11:53.
 */
public interface MenuRepository extends BaseRepository {
    List<Menu> getAllMenu();
}
