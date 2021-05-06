package com.tml.mouseDemo.data.data1.mapper;

import com.tml.mouseDemo.model.InvestDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InvestDetailMapper {

    List<InvestDetail> listInvestByStockName(String stockName);
}
