package com.tml.mouseDemo.data.data1.mapper;

import com.tml.mouseDemo.model.InvestDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InvestDetailMapper {

    List<InvestDetail> listInvestByStockName(@Param("stockName") String stockName);
}
