package com.github.douglashauschild.hexagonalapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
    private Long id;
    private String name;
    private String email;
}
