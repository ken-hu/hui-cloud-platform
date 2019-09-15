package com.hui.cloud.uc.user.model.bo;

import com.hui.cloud.uc.user.model.entity.Role;
import com.hui.cloud.uc.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b><code>UserRole</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/15 21:53.
 *
 * @author Hu-Weihui
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {

    private User user;

    private Role role;

}
