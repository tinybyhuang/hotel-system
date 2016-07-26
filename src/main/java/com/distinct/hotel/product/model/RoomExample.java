package com.distinct.hotel.product.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProviderIdIsNull() {
            addCriterion("provider_id is null");
            return (Criteria) this;
        }

        public Criteria andProviderIdIsNotNull() {
            addCriterion("provider_id is not null");
            return (Criteria) this;
        }

        public Criteria andProviderIdEqualTo(Integer value) {
            addCriterion("provider_id =", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotEqualTo(Integer value) {
            addCriterion("provider_id <>", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThan(Integer value) {
            addCriterion("provider_id >", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("provider_id >=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThan(Integer value) {
            addCriterion("provider_id <", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThanOrEqualTo(Integer value) {
            addCriterion("provider_id <=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdIn(List<Integer> values) {
            addCriterion("provider_id in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotIn(List<Integer> values) {
            addCriterion("provider_id not in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdBetween(Integer value1, Integer value2) {
            addCriterion("provider_id between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("provider_id not between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderRoomIdIsNull() {
            addCriterion("provider_room_id is null");
            return (Criteria) this;
        }

        public Criteria andProviderRoomIdIsNotNull() {
            addCriterion("provider_room_id is not null");
            return (Criteria) this;
        }

        public Criteria andProviderRoomIdEqualTo(Integer value) {
            addCriterion("provider_room_id =", value, "providerRoomId");
            return (Criteria) this;
        }

        public Criteria andProviderRoomIdNotEqualTo(Integer value) {
            addCriterion("provider_room_id <>", value, "providerRoomId");
            return (Criteria) this;
        }

        public Criteria andProviderRoomIdGreaterThan(Integer value) {
            addCriterion("provider_room_id >", value, "providerRoomId");
            return (Criteria) this;
        }

        public Criteria andProviderRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("provider_room_id >=", value, "providerRoomId");
            return (Criteria) this;
        }

        public Criteria andProviderRoomIdLessThan(Integer value) {
            addCriterion("provider_room_id <", value, "providerRoomId");
            return (Criteria) this;
        }

        public Criteria andProviderRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("provider_room_id <=", value, "providerRoomId");
            return (Criteria) this;
        }

        public Criteria andProviderRoomIdIn(List<Integer> values) {
            addCriterion("provider_room_id in", values, "providerRoomId");
            return (Criteria) this;
        }

        public Criteria andProviderRoomIdNotIn(List<Integer> values) {
            addCriterion("provider_room_id not in", values, "providerRoomId");
            return (Criteria) this;
        }

        public Criteria andProviderRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("provider_room_id between", value1, value2, "providerRoomId");
            return (Criteria) this;
        }

        public Criteria andProviderRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("provider_room_id not between", value1, value2, "providerRoomId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNull() {
            addCriterion("hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(Integer value) {
            addCriterion("hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(Integer value) {
            addCriterion("hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(Integer value) {
            addCriterion("hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(Integer value) {
            addCriterion("hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(Integer value) {
            addCriterion("hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<Integer> values) {
            addCriterion("hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<Integer> values) {
            addCriterion("hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(Integer value1, Integer value2) {
            addCriterion("hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNull() {
            addCriterion("room_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNotNull() {
            addCriterion("room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNameEqualTo(String value) {
            addCriterion("room_name =", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotEqualTo(String value) {
            addCriterion("room_name <>", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThan(String value) {
            addCriterion("room_name >", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_name >=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThan(String value) {
            addCriterion("room_name <", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThanOrEqualTo(String value) {
            addCriterion("room_name <=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLike(String value) {
            addCriterion("room_name like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotLike(String value) {
            addCriterion("room_name not like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameIn(List<String> values) {
            addCriterion("room_name in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotIn(List<String> values) {
            addCriterion("room_name not in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameBetween(String value1, String value2) {
            addCriterion("room_name between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotBetween(String value1, String value2) {
            addCriterion("room_name not between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeIsNull() {
            addCriterion("room_bed_type is null");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeIsNotNull() {
            addCriterion("room_bed_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeEqualTo(Integer value) {
            addCriterion("room_bed_type =", value, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeNotEqualTo(Integer value) {
            addCriterion("room_bed_type <>", value, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeGreaterThan(Integer value) {
            addCriterion("room_bed_type >", value, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_bed_type >=", value, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeLessThan(Integer value) {
            addCriterion("room_bed_type <", value, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeLessThanOrEqualTo(Integer value) {
            addCriterion("room_bed_type <=", value, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeIn(List<Integer> values) {
            addCriterion("room_bed_type in", values, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeNotIn(List<Integer> values) {
            addCriterion("room_bed_type not in", values, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeBetween(Integer value1, Integer value2) {
            addCriterion("room_bed_type between", value1, value2, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("room_bed_type not between", value1, value2, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomFloorIsNull() {
            addCriterion("room_floor is null");
            return (Criteria) this;
        }

        public Criteria andRoomFloorIsNotNull() {
            addCriterion("room_floor is not null");
            return (Criteria) this;
        }

        public Criteria andRoomFloorEqualTo(String value) {
            addCriterion("room_floor =", value, "roomFloor");
            return (Criteria) this;
        }

        public Criteria andRoomFloorNotEqualTo(String value) {
            addCriterion("room_floor <>", value, "roomFloor");
            return (Criteria) this;
        }

        public Criteria andRoomFloorGreaterThan(String value) {
            addCriterion("room_floor >", value, "roomFloor");
            return (Criteria) this;
        }

        public Criteria andRoomFloorGreaterThanOrEqualTo(String value) {
            addCriterion("room_floor >=", value, "roomFloor");
            return (Criteria) this;
        }

        public Criteria andRoomFloorLessThan(String value) {
            addCriterion("room_floor <", value, "roomFloor");
            return (Criteria) this;
        }

        public Criteria andRoomFloorLessThanOrEqualTo(String value) {
            addCriterion("room_floor <=", value, "roomFloor");
            return (Criteria) this;
        }

        public Criteria andRoomFloorLike(String value) {
            addCriterion("room_floor like", value, "roomFloor");
            return (Criteria) this;
        }

        public Criteria andRoomFloorNotLike(String value) {
            addCriterion("room_floor not like", value, "roomFloor");
            return (Criteria) this;
        }

        public Criteria andRoomFloorIn(List<String> values) {
            addCriterion("room_floor in", values, "roomFloor");
            return (Criteria) this;
        }

        public Criteria andRoomFloorNotIn(List<String> values) {
            addCriterion("room_floor not in", values, "roomFloor");
            return (Criteria) this;
        }

        public Criteria andRoomFloorBetween(String value1, String value2) {
            addCriterion("room_floor between", value1, value2, "roomFloor");
            return (Criteria) this;
        }

        public Criteria andRoomFloorNotBetween(String value1, String value2) {
            addCriterion("room_floor not between", value1, value2, "roomFloor");
            return (Criteria) this;
        }

        public Criteria andRoomWindowIsNull() {
            addCriterion("room_window is null");
            return (Criteria) this;
        }

        public Criteria andRoomWindowIsNotNull() {
            addCriterion("room_window is not null");
            return (Criteria) this;
        }

        public Criteria andRoomWindowEqualTo(String value) {
            addCriterion("room_window =", value, "roomWindow");
            return (Criteria) this;
        }

        public Criteria andRoomWindowNotEqualTo(String value) {
            addCriterion("room_window <>", value, "roomWindow");
            return (Criteria) this;
        }

        public Criteria andRoomWindowGreaterThan(String value) {
            addCriterion("room_window >", value, "roomWindow");
            return (Criteria) this;
        }

        public Criteria andRoomWindowGreaterThanOrEqualTo(String value) {
            addCriterion("room_window >=", value, "roomWindow");
            return (Criteria) this;
        }

        public Criteria andRoomWindowLessThan(String value) {
            addCriterion("room_window <", value, "roomWindow");
            return (Criteria) this;
        }

        public Criteria andRoomWindowLessThanOrEqualTo(String value) {
            addCriterion("room_window <=", value, "roomWindow");
            return (Criteria) this;
        }

        public Criteria andRoomWindowLike(String value) {
            addCriterion("room_window like", value, "roomWindow");
            return (Criteria) this;
        }

        public Criteria andRoomWindowNotLike(String value) {
            addCriterion("room_window not like", value, "roomWindow");
            return (Criteria) this;
        }

        public Criteria andRoomWindowIn(List<String> values) {
            addCriterion("room_window in", values, "roomWindow");
            return (Criteria) this;
        }

        public Criteria andRoomWindowNotIn(List<String> values) {
            addCriterion("room_window not in", values, "roomWindow");
            return (Criteria) this;
        }

        public Criteria andRoomWindowBetween(String value1, String value2) {
            addCriterion("room_window between", value1, value2, "roomWindow");
            return (Criteria) this;
        }

        public Criteria andRoomWindowNotBetween(String value1, String value2) {
            addCriterion("room_window not between", value1, value2, "roomWindow");
            return (Criteria) this;
        }

        public Criteria andRoomWifiIsNull() {
            addCriterion("room_wifi is null");
            return (Criteria) this;
        }

        public Criteria andRoomWifiIsNotNull() {
            addCriterion("room_wifi is not null");
            return (Criteria) this;
        }

        public Criteria andRoomWifiEqualTo(String value) {
            addCriterion("room_wifi =", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiNotEqualTo(String value) {
            addCriterion("room_wifi <>", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiGreaterThan(String value) {
            addCriterion("room_wifi >", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiGreaterThanOrEqualTo(String value) {
            addCriterion("room_wifi >=", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiLessThan(String value) {
            addCriterion("room_wifi <", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiLessThanOrEqualTo(String value) {
            addCriterion("room_wifi <=", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiLike(String value) {
            addCriterion("room_wifi like", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiNotLike(String value) {
            addCriterion("room_wifi not like", value, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiIn(List<String> values) {
            addCriterion("room_wifi in", values, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiNotIn(List<String> values) {
            addCriterion("room_wifi not in", values, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiBetween(String value1, String value2) {
            addCriterion("room_wifi between", value1, value2, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWifiNotBetween(String value1, String value2) {
            addCriterion("room_wifi not between", value1, value2, "roomWifi");
            return (Criteria) this;
        }

        public Criteria andRoomWashIsNull() {
            addCriterion("room_wash is null");
            return (Criteria) this;
        }

        public Criteria andRoomWashIsNotNull() {
            addCriterion("room_wash is not null");
            return (Criteria) this;
        }

        public Criteria andRoomWashEqualTo(String value) {
            addCriterion("room_wash =", value, "roomWash");
            return (Criteria) this;
        }

        public Criteria andRoomWashNotEqualTo(String value) {
            addCriterion("room_wash <>", value, "roomWash");
            return (Criteria) this;
        }

        public Criteria andRoomWashGreaterThan(String value) {
            addCriterion("room_wash >", value, "roomWash");
            return (Criteria) this;
        }

        public Criteria andRoomWashGreaterThanOrEqualTo(String value) {
            addCriterion("room_wash >=", value, "roomWash");
            return (Criteria) this;
        }

        public Criteria andRoomWashLessThan(String value) {
            addCriterion("room_wash <", value, "roomWash");
            return (Criteria) this;
        }

        public Criteria andRoomWashLessThanOrEqualTo(String value) {
            addCriterion("room_wash <=", value, "roomWash");
            return (Criteria) this;
        }

        public Criteria andRoomWashLike(String value) {
            addCriterion("room_wash like", value, "roomWash");
            return (Criteria) this;
        }

        public Criteria andRoomWashNotLike(String value) {
            addCriterion("room_wash not like", value, "roomWash");
            return (Criteria) this;
        }

        public Criteria andRoomWashIn(List<String> values) {
            addCriterion("room_wash in", values, "roomWash");
            return (Criteria) this;
        }

        public Criteria andRoomWashNotIn(List<String> values) {
            addCriterion("room_wash not in", values, "roomWash");
            return (Criteria) this;
        }

        public Criteria andRoomWashBetween(String value1, String value2) {
            addCriterion("room_wash between", value1, value2, "roomWash");
            return (Criteria) this;
        }

        public Criteria andRoomWashNotBetween(String value1, String value2) {
            addCriterion("room_wash not between", value1, value2, "roomWash");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}