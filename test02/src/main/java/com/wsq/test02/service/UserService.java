package com.wsq.test02.service;

import com.wsq.test02.model.User;

public interface UserService {
    boolean login(User user);
    boolean delete(String id);
    boolean update(User user);
    boolean insert(User user);
    boolean select(String id);
}
