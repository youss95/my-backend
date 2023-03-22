package com.myp.core.common;

import lombok.Getter;

@Getter
public abstract class BaseParams {

    private int page = 1;

    private int perPage = 10;

    public int getOffset() {
      return (this.page-1) * this.perPage;
    }
}
