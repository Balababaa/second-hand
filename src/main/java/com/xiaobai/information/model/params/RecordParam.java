package com.xiaobai.information.model.params;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.xiaobai.information.model.dto.base.InputConverter;
import com.xiaobai.information.model.entity.Record;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author XinHuiChen
 */
@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RecordParam implements InputConverter<Record> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "图片不能为空")
    private String[] images;

    @NotNull(message = "标题不能为空")
    private String title;

    @NotNull(message = "价格不能为空")
    private Double price;

    @NotNull(message = "描述不能为空")
    private String briefDescription;

    @NotNull(message = "用户不能为空")
    private String userId;

    @NotNull(message = "微信不能为空")
    private String wx;

    @NotNull(message = "QQ不能为空")
    private String qq;

    @NotNull(message = "电话不能为空")
    private String phone;
}
