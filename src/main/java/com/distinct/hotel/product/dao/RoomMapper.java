package com.distinct.hotel.product.dao;

import com.distinct.hotel.product.model.Room;
import com.distinct.hotel.product.model.RoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomMapper {
	int countByExample(RoomExample example);

	int deleteByExample(RoomExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Room record);

	int insertSelective(Room record);

	List<Room> selectByExample(RoomExample example);

	Room selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

	int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);

	int updateByPrimaryKeySelective(Room record);

	int updateByPrimaryKey(Room record);

	List<Integer> getRoomIds();

	void deleteRooms(@Param("roomIds") List<Integer> roomIds);

	List<Room> findRoom();

	List<Room> findRoomByHotelIds(@Param("hotelIds") List<Integer> hotelIds);

	List<Room> findRoomByHotelId(@Param("hotelId") int hotelId);

	Room selectByRoomId(@Param("roomId") Integer roomId);

}