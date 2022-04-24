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
 * 
 * @TableName article_tag
 */
@TableName(value ="article_tag")
@Data
public class ArticleTag implements Serializable {
    /**
     * 文章标签ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 文章ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long articleId;

    /**
     * 标签ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long tagId;

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