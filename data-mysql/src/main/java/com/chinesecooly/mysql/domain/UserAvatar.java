package com.chinesecooly.mysql.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 用户头像表
 * @TableName user_avatar
 */
@TableName(value ="user_avatar")
@Data
public class UserAvatar implements Serializable {
    /**
     * 头像ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId
    private Long id;
    /**
     * 用户ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    /**
     * 头发类型
     */
    private String hairType;

    /**
     * 眉毛类型
     */
    private String eyebrowType;

    /**
     * 眼睛类型
     */
    private String eyeType;

    /**
     * 眼睛类型
     */
    private String mouthType;

    /**
     * 衣服类型
     */
    private String clotheType;

    /**
     * 胡子类型
     */
    private String facialHairType;

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