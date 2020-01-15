package com.xiaobai.information.model.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.xiaobai.information.model.dto.base.OutputConverter;
import com.xiaobai.information.model.entity.Record;
import lombok.Data;

/**
 * @author XinHuiChen
 */
@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RecordDTO implements OutputConverter<RecordDTO, Record> {
    private Integer id;

    private String[] images;

    private String title;

    private Double price;

    private String briefDescription;

    private String userId;

    private String wx;

    private String qq;

    private String phone;
}
