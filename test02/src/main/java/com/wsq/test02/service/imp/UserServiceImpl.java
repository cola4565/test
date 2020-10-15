package com.wsq.test02.service.imp;

import com.wsq.test02.dao.UserMapper;
import com.wsq.test02.model.User;
import com.wsq.test02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper mapper;
    @Override
    public boolean login(User user) {
        User user1=mapper.selectByPrimaryKey(user.getId());
        if (user1!=null){
            if (user1.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean delete(String id) {
        return mapper.delete(id)>0;
    }
    @Override
    public boolean update(User user) {
        return mapper.update(user)>0;
    }
    @Override
    public boolean insert(User user) {
        return mapper.insert(user)>0;
    }

    @Override
    public boolean select(String id) {
        return mapper.selectByPrimaryKey(id)!=null;
    }
}
