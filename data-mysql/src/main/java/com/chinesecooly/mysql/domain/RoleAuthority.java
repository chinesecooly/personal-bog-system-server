package com.chinesecooly.mysql.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色权限对照表
 * @TableName role_authority
 */
@TableName(value ="role_authority")
@Data
@NoArgsConstructor
public class RoleAuthority implements Serializable {
    /**
     * 角色权限ID
     */
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 角色ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roleId;

    /**
     * 权限ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long authorityId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifiedTime;

    public RoleAuthority(Long roleId, Long authorityId) {
        this.roleId = roleId;
        this.authorityId = authorityId;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}