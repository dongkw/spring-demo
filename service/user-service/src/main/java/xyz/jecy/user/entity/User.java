package xyz.jecy.user.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import xyz.jecy.api.user.bean.enums.Role;

/**
 * <p>
 *
 * </p>
 *
 * @author kw
 * @since 2020-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;

    private String name;

    private String avatar;

    private String password;

    private String version;

    private Role role;



}
