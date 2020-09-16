package com.peepopharma.mapper;

import com.peepopharma.config.BaseMapperConfig;
import com.peepopharma.dto.StockPurchaseDto;
import com.peepopharma.persistence.model.StockPurchase;
import org.mapstruct.Mapper;

@Mapper(config = BaseMapperConfig.class)
public interface StockPurchaseMapper {

  StockPurchase fromStockPurchaseDto(StockPurchaseDto stockPurchaseDto);

  StockPurchaseDto fromStockPurchase(StockPurchase stockPurchase);

}
