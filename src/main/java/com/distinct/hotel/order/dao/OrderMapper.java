package com.distinct.hotel.order.dao;

import com.distinct.hotel.common.page.PageBounds;
import com.distinct.hotel.common.page.PageList;
import com.distinct.hotel.order.model.Order;
import com.distinct.hotel.order.model.OrderExample;
import com.distinct.hotel.order.vo.SearchOrderVO;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
	int countByExample(OrderExample example);

	int deleteByExample(OrderExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Order record);

	int insertSelective(Order record);

	List<Order> selectByExampleWithBLOBs(OrderExample example);

	List<Order> selectByExample(OrderExample example);

	Order selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

	int updateByExampleWithBLOBs(@Param("record") Order record, @Param("example") OrderExample example);

	int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

	int updateByPrimaryKeySelective(Order record);

	int updateByPrimaryKeyWithBLOBs(Order record);

	int updateByPrimaryKey(Order record);

	//返回该用户可以操作的平台
	List<Integer> findAllMarketId();

	PageList<Order> findAllOrder(PageBounds pageBounds);

	//可以修改SearchOrderVO的参数
	PageList<Order> findOrderPurpose(PageBounds pageBounds, SearchOrderVO searchOrderVO);

}