package com.hui.cloud.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <b><code>MybatisMetaObjectHandler</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/17 23:41.
 *
 * @author Gary.Hu
 */
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        List<FieldValObj> fieldValObjs = Arrays.asList(
                new FieldValObj("creaateTime", new Date()),
                new FieldValObj("modifyTime", new Date()),
                new FieldValObj("createUser", "Gary.Hu"),
                new FieldValObj("modifyUser", "Gary.Hu"),
                new FieldValObj("deleted", 0)
        );
        fieldValObjs.forEach(x -> fieldFill(x, metaObject));
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        List<FieldValObj> fieldValObjs = Arrays.asList(
                new FieldValObj("modifyTime", new Date()),
                new FieldValObj("modifyUser", "Gary.Hu")
        );
        fieldValObjs.forEach(x -> fieldFill(x, metaObject));
    }

    /**
     * 字段填充
     *
     * @param fieldValObj
     * @param metaObject
     */
    private void fieldFill(FieldValObj fieldValObj, MetaObject metaObject) {
        Object val = getFieldValByName(fieldValObj.getFieldName(), metaObject);
        if (null != val) {
            setUpdateFieldValByName(fieldValObj.getFieldName(), fieldValObj.getData(), metaObject);
        }
    }


    @Data
    @AllArgsConstructor
    static class FieldValObj {
        private String fieldName;
        private Object data;
    }
}
