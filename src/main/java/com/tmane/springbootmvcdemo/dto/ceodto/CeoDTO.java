package com.tmane.springbootmvcdemo.dto.ceodto;

import com.tmane.springbootmvcdemo.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public abstract class CeoDTO extends BaseDTO {
}
