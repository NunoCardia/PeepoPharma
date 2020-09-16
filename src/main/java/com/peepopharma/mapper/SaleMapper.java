package com.peepopharma.mapper;

import com.peepopharma.config.BaseMapperConfig;
import com.peepopharma.dto.SaleDto;
import com.peepopharma.persistence.model.Sale;
import com.peepopharma.persistence.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = BaseMapperConfig.class)
public interface SaleMapper {

  SaleDto fromSaleModel(Sale sale);

  Sale fromSaleDto(SaleDto saleDto);

  @Mapping(target = "name", expression = "java(user)")
  User fromUser(String user);

  default String fromUser(User user){
    return user.getName();
  }
}
