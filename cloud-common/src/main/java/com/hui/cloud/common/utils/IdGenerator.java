package com.hui.cloud.common.utils;

import com.hui.cloud.common.utils.SnowflakeIdHelper;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

/**
 * <b><code>IdGenerator</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/14 23:13.
 *
 * @author Hu-Weihui
 */
public class IdGenerator extends IdentityGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor s, Object obj) {
        Object id = SnowflakeIdHelper.nextId();
        if (null != id) {
            return (Serializable) id;
        }
        return super.generate(s, obj);
    }
}
