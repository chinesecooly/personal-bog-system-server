package com.chinesecooly.mysql.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName message_style
 */
@TableName(value ="message_style")
@Data
public class MessageStyle implements Serializable {
    /**
     * 留言样式ID
     */
    @TableId
    private Long id;

    /**
     * 留言ID
     */
    private Long messageId;

    /**
     * 颜色
     */
    private String color;

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