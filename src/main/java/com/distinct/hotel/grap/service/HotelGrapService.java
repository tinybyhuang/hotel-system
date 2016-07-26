package com.distinct.hotel.grap.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.distinct.hotel.common.Constants.Provider;
import com.distinct.hotel.common.Utils;
import com.distinct.hotel.grap.vo.Head;
import com.distinct.hotel.grap.vo.HotelDetailJson;
import com.distinct.hotel.grap.vo.HotelListJson;
import com.distinct.hotel.grap.vo.RoomJson;
import com.distinct.hotel.grap.vo.SetInfo;
import com.distinct.hotel.grap.vo.Sort;
import com.distinct.hotel.product.model.Hotel;
import com.distinct.hotel.product.model.Room;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
@Component
public class HotelGrapService {
	
	@Resource
	private HotelService hotelService;
	
	private BlockingQueue<Hotel> hotelQueue;
	
	private BlockingQueue<Room> roomQueue;
	
	private static CloseableHttpClient httpClient = HttpClients.createDefault();
	
	private Gson gson = new Gson();
	
	private JsonParser parser = new JsonParser();
	
	
	public HotelGrapService(BlockingQueue<Hotel> hotelQueue, BlockingQueue<Room> roomQueue) {
		super();
		this.hotelQueue = hotelQueue;
		this.roomQueue = roomQueue;
	}

	public HotelGrapService() {
		super();
	}

	public String getClientId(){
		
		String clientId = null;
		
		String url = "http://m.ctrip.com/restapi/soa2/10290/createclientid?systemcode=09&createtype=3&contentType=json";
		HttpGet httpGet = new HttpGet(url);
		try {
			
			CloseableHttpResponse response = httpClient.execute(httpGet);
			String result = EntityUtils.toString(response.getEntity());
			JsonObject object = parser.parse(result).getAsJsonObject();
			clientId = object.get("ClientID").getAsString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return clientId;
	}
	
	public void getHotelIds(int cityId, String inDay, String outDay, Head head){
		
			SetInfo setInfo = new SetInfo(cityId, inDay, outDay);
			 
				for(int index = 1; index < 6; index++){
					 Sort sort = new Sort(index);
					 sort.getDir();
					 HotelListJson hotelListJson = new HotelListJson(head, setInfo, sort);
					 String data = gson.toJson(hotelListJson);
					 String url = "http://m.ctrip.com/restapi/soa2/10932/hotel/Product/domestichotelget?_fxpcqlniredt=" + head.getCid();
					 String result = post(url, data);
					 JsonObject object = parser.parse(result).getAsJsonObject();
					 JsonArray hotelArray = object.get("htlInfos").getAsJsonArray();
					 int size = hotelArray.size();
					 for(int i = 0; i < size; i++){
						 int hotelId = hotelArray.get(i).getAsJsonObject().get("baseInfo").getAsJsonObject().get("id").getAsInt();
						 
						 Hotel hotel = getHotelDetailInfo(cityId, hotelId, inDay, outDay, head);
						 List<Room> rooms = getRooms(hotelId, inDay, outDay, head);
						 hotelService.addHotel(hotel);
						 hotelService.insertRoom(rooms);
					 }
				 }
	}
	
	public Hotel getHotelDetailInfo(int cityId,int hotelId,String inDay, String outDay, Head head){
		Hotel hotel = new Hotel();
		try {
			SetInfo setInfo = new SetInfo(0, inDay, outDay);
			HotelDetailJson hotelDetailJson = new HotelDetailJson(head, setInfo, hotelId);
			String data = gson.toJson(hotelDetailJson);
			String url = "http://m.ctrip.com/restapi/soa2/10932/hotel/product/hoteldetailget?_fxpcqlniredt=" + head.getCid();
			String result = post(url, data);
			JsonObject object = parser.parse(result).getAsJsonObject();
			
			JsonObject hotelBasic = object.get("baseInfo").getAsJsonObject();
			String hotelName = hotelBasic.get("name").getAsString();
			String hotelAddress = hotelBasic.get("addr").getAsString();
			
			JsonObject hotelStatic = object.get("staticInfo").getAsJsonObject();
			String hotelPhone = hotelStatic.get("phe").getAsString();
			String description = hotelStatic.get("desc").getAsString();
			
			hotel.setProviderId(Provider.Jltour.getId());
			hotel.setProviderHotelId(hotelId);
			hotel.setCityId(cityId);
			hotel.setHotelAddress(hotelAddress);
			hotel.setHotelName(hotelName);
			hotel.setHotelPhone(hotelPhone);
			hotel.setHotelStar(Utils.getHotelStar());
			hotel.setHotelIntroduction(description);
			hotel.setCreated(new Date());
			
//			hotelQueue.offer(hotel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hotel;
		
	}
	
	
	public List<Room> getRooms(int hotelId, String inDay, String outDay, Head head){
		List<Room> rooms = new ArrayList<Room>();
		
		try {
			RoomJson roomJson = new RoomJson(head, hotelId, inDay, outDay);
			String data = gson.toJson(roomJson);
			String url = "http://m.ctrip.com/restapi/soa2/10933/hotel/product/roomgetv2?_fxpcqlniredt=" + head.getCid();
			String result = post(url, data);
			JsonObject object = parser.parse(result).getAsJsonObject();
			JsonArray roomArray = object.get("rooms").getAsJsonArray();
			Set<String> roomType = new HashSet<String>();
			for(int i = 0; i < roomArray.size(); i++){
				JsonObject roomObject= roomArray.get(i).getAsJsonObject();
				String type = roomObject.get("bid").getAsInt() + "";
				if(!roomType.contains(type)){
					roomType.add(type);
					
					String roomName = roomObject.get("bname").getAsString();
					int roomId = roomObject.get("id").getAsInt();
					
					Room room = new Room();
					
					room.setHotelId(hotelId);
					room.setProviderId(Provider.Jltour.getId());
					room.setProviderRoomId(roomId);
					room.setRoomName(roomName);
					room.setRoomBedType(Utils.getBedType());
					room.setCreated(new Date());
					
					JsonArray roomBasic = roomObject.get("basicinfos").getAsJsonArray();
					
					for(int a = 0; a< roomBasic.size(); a++){
						JsonObject roomDetail = roomBasic.get(a).getAsJsonObject();
						roomDetail(room, roomDetail);
					}
					
//					roomQueue.offer(room);
					rooms.add(room);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rooms;
		
	}
	public void roomDetail(Room room, JsonObject jsonObject){
		int type = jsonObject.get("type").getAsInt();
		switch (type) {
		case 6:
			room.setRoomFloor(jsonObject.get("value").getAsString());
			break;
		case 9:
			room.setRoomWifi(jsonObject.get("value").getAsString());
			break;
		default:
			break;
		}
	}
	
	public String post(String url, String data){
		String result = null;
		HttpPost httpPost = new HttpPost(url);
		try {
			Thread.sleep(1000);
			StringEntity stringEntity = new StringEntity(data);
			httpPost.setHeader("Content-type", "application/json");
			httpPost.setEntity(stringEntity);
			CloseableHttpResponse response = httpClient.execute(httpPost);
			result = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
