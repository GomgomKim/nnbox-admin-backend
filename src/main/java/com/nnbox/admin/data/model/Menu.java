package com.nnbox.admin.data.model;

import lombok.Data;

@Data
public class Menu {
    private Integer idx;

    private String name;

    private String nameKr;

    private String path;

    private Integer parentIdx;
}