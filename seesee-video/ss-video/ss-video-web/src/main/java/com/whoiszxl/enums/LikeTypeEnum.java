package com.whoiszxl.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 点赞器枚举
 * @author whoiszxl
 * @date 2021/3/17
 */
@Getter
@AllArgsConstructor
public enum LikeTypeEnum {

    VIDEO(1, "video_like"),
    COMMENT(2, "comment_like"),
    ;
    private Integer code;
    private String typeName;

    public static String getTypeName(Integer type) {
        for (LikeTypeEnum likeTypeEnum : LikeTypeEnum.values()) {
            if (type.equals(likeTypeEnum.getCode())) {
                return likeTypeEnum.getTypeName();
            }
        }
        return null;
    }
}