package com.peepopharma.mapper;

import com.peepopharma.config.BaseMapperConfig;
import com.peepopharma.dto.StockPurchaseDto;
import com.peepopharma.persistence.model.StockPurchase;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = BaseMapperConfig.class)
public interface StockPurchaseMapper {

    StockPurchase fromStockPurchaseDto(StockPurchaseDto stockPurchaseDto);

    StockPurchaseDto fromStockPurchase(StockPurchase stockPurchase);

    List<StockPurchaseDto> fromStockPurchaseModelList(List<StockPurchase> stockPurchases);

}
