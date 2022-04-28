package com.chinesecooly.mysql.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 权限表
 * @TableName authority
 */
@TableName(value ="authority")
@Data
public class Authority implements Serializable {
    /**
     * 权限ID
     */
    @TableId
    private Long id;

    /**
     * 权限名
     */
    private String name;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 权限字符串
     */
    private String key;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifiedTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}