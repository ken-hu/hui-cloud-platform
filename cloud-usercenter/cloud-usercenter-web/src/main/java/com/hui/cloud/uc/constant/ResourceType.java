package com.hui.cloud.uc.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <b><code>ResourceType</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/3/22 15:04.
 *
 * @author Hu-Weihui
 * @since hui-cloud-platform ${PROJECT_VERSION}
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum  ResourceType {
    //菜单
    MENU("MENU","菜单权限"),
    //按钮等元素
    ELEMENT("ELEMENT","按钮权限"),
    //文件
    FILE("FILE","文件权限"),
    //数据权限
    DATA("DATA","数据权限");

    private String code;
    private String name;
}
