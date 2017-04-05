package com.lorelib.hawk.infrastructure.stereotype;

import com.lorelib.hawk.infrastructure.helpers.algorithm.IdGenerator;

/**
 * Created by listening on 2017/4/5.
 */
public interface BaseRepository {
    default long identifier() {
        return IdGenerator.nextId();
    }
}
