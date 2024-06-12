package com.framework.util;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;

public class PaginationUtil {

    /**
     *@author: Joshma
     *@date: 2024-06-12
     *@desc:
     */

    public static HttpHeaders generatePaginationHttpHeaders(Page<?> page) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", Long.toString(page.getTotalElements()));
        headers.add("X-Total-Pages", Long.toString(page.getTotalPages()));
        headers.add("X-Current-Page", Integer.toString(page.getNumber()));
        return headers;
    }
}
