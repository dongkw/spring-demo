package xyz.jecy.user.service.impl;

import xyz.jecy.user.entity.User;
import xyz.jecy.user.mapper.UserMapper;
import xyz.jecy.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kw
 * @since 2020-01-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
