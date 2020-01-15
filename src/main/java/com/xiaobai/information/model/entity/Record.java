package com.xiaobai.information.model.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.*;

/**
 * @author XinHuiChen
 */
@Data
@Table(name = "t_record")
@Entity
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Record extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "images")
    private String images;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Double price;

    @Column(name = "brief_description")
    private String briefDescription;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "wx")
    private String wx;

    @Column(name = "qq")
    private String qq;

    @Column(name = "phone")
    private String phone;
}
