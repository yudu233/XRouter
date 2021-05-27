package com.rain.arouterdemo;

import java.io.Serializable;

/**
 *  @AuthorName :       Rain
 *  @Org        :       https://www.yudu233.com
 *  @CreateDate :       5/26/21 4:37 PM
 *  @VersonCode :       1.0
 *  @Descroption :      选择联系人bean类
 */
public class SelectInfo implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
