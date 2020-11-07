package cn.siwuya.blogsys.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author shi_dd
 * @date 2020/7/10 14:19
 */
@Data
@Builder
public class UserEntity {
    private Long id;
    private String userId;
    private String username;
    private String password;
}
