package com.distinct.hotel.common;

public interface Constants {
	
	public static enum Provider{
		
		Jltour(1,"捷旅"),CN(2,"龙腾");
		
		private int id;
		private String name;
		
		private Provider(int id,String name){
			this.id = id;
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public String getName() {
			return name;
		}
	}
	
	public static enum Market{
		
		Ctrip(1,"携程"),Qunar(2,"去哪儿"),TaoBao(3,"淘宝");
		
		private int id;
		private String name;
		
		private Market(int id,String name){
			this.id = id;
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public String getName() {
			return name;
		}
	}
	
	public static enum IncreaseType{
		PERCENT("百分比"),PRICE_SPREAD("差价");
		
		private String name;
		
		private IncreaseType(String name){
			this.name = name;
		}
		
		public String getName(){
			return this.name;
		}
		
	}
}
