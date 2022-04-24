package com.chinesecooly.mysql.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleBody implements Serializable {
    private String articleBody;
    private static final long serialVersionUID = 1L;
}
