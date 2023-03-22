package com.myp.core.util;

import com.myp.core.common.BaseParams;

import java.util.ArrayList;
import java.util.List;

public final class Page<T> {

    private final int page;
    private final int perPage;
    private final long totalItems;
    private final List<T> contents;

    public Page(List<T> contents, BaseParams params, Long totalItems) {
        this.page = params.getPage();
        this.perPage = params.getPerPage();
        this.totalItems = totalItems;
        if (contents != null && !contents.isEmpty()) {
            this.contents = contents;
        } else {
            this.contents = new ArrayList();
        }

    }

    public long getTotalPages() {
        long page = (long)Math.ceil((double)this.totalItems / (double)this.perPage);
        return Math.max(page, 1L);
    }

    public int getPage() {
        return this.page;
    }

    public int getPerPage() {
        return this.perPage;
    }

    public long getTotalItems() {
        return this.totalItems;
    }

    public List<T> getContents() {
        return this.contents;
    }
}
