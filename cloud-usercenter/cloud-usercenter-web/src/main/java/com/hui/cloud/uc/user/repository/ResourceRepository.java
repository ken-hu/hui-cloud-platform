package com.hui.cloud.uc.user.repository;

import com.hui.cloud.uc.user.model.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <b><code>ResourceRepository</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/15 21:39.
 *
 * @author Hu-Weihui
 */
public interface ResourceRepository extends JpaRepository<Resource,Long> {
}
