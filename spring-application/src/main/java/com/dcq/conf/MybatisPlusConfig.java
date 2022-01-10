package com.dcq.conf;

import com.baomidou.mybatisplus.annotation.DbType;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
   /* @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setLimit(1000L);
        return paginationInterceptor;
    }*/
    // 最新版
    /**
     * 分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }
   /* @Bean
    public MetaObjectHandler metaObjectHandler(){
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                this.strictInsertFill(metaObject, "createTime", Date.class, new Date()); // 起始版本 3.3.0(推荐使用)
                this.strictInsertFill(metaObject, "updateTime", Date.class, new Date()); // 起始版本 3.3.0(推荐)
//                System.out.println("==============================进来了配置类");
                // 先获取到创建人的值，再进行判断，如果为空，就进行填充，如果不为空，就不做处理
                Object createBy = getFieldValByName("createBy", metaObject);
                if (createBy == null){
                    setFieldValByName("createBy","system",metaObject);
                }

                //先获取到操作人的值，再进行判断，如果为空，就进行填充，如果不为空，就不做处理
                Object updateBy = getFieldValByName("updateBy", metaObject);
                if (updateBy == null){
                    setFieldValByName("updateBy","system",metaObject);
                }
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now()); // 起始版本 3.3.0(推荐)
                Object updateBy = getFieldValByName("updateBy", metaObject);
                if (updateBy == null){
                    setFieldValByName("updateBy","system",metaObject);
                }
            }
        };
    }*/
}
