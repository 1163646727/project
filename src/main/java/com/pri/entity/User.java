package com.pri.entity;
import lombok.Data;
import javax.persistence.*;

@Table(name = "t_user")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;//姓名

    @Column
    private Integer age;//年龄

    @Column
    private Integer addr;//地址
}