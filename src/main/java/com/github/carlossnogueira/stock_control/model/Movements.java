package com.github.carlossnogueira.stock_control.model;


import com.github.carlossnogueira.stock_control.model.enums.MovimentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

@Entity(name = "movements")
@Data
public class Movements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product produtct;

    private MovimentType type;

    @Min(1)
    private Integer quantity;

    private String description;

    @CurrentTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
