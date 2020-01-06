package xyz.jecy.user.util;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.util.CollectionUtils;
import xyz.jecy.api.user.bean.UserInfo;
import xyz.jecy.user.entity.User;

/**
 * @Author dkw[dongkewei@xinzhili.cn]
 * @data 2020/1/3 4:09 下午
 */
public class UserFactory {


  public static Wrapper<User> of(String name) {
    User user = new User();
    user.setName(name);
    return Wrappers.query(user);
  }

  public static List<UserInfo> api(List<User> users) {
    if (CollectionUtils.isEmpty(users)) {
      return List.of();
    }
    return users.stream().map(t -> {
      UserInfo userInfo = new UserInfo();
      userInfo.setId(t.getId() + "");
      userInfo.setName(t.getName());
      return userInfo;
    }).collect(Collectors.toList());

  }
}
