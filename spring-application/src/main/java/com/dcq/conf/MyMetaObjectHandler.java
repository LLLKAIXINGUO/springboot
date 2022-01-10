package com.dcq.conf;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.SstDocument;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        // 先获取到创建人人的值，再进行判断，如果为空，就进行填充，如果不为空，就不做处理
        Object createBy = getFieldValByName("createBy", metaObject);
        if (createBy == null){
            setFieldValByName("createBy","system",metaObject);
        }
        // 先获取到操作人的值，再进行判断，如果为空，就进行填充，如果不为空，就不做处理
        Object updateBy = getFieldValByName("updateBy", metaObject);
        if (updateBy == null){
            setFieldValByName("updateBy","system",metaObject);
        }
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐)
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐)
    }
}