package com.distinct.hotel.order.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andMarketIdIsNull() {
            addCriterion("market_id is null");
            return (Criteria) this;
        }

        public Criteria andMarketIdIsNotNull() {
            addCriterion("market_id is not null");
            return (Criteria) this;
        }

        public Criteria andMarketIdEqualTo(Integer value) {
            addCriterion("market_id =", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdNotEqualTo(Integer value) {
            addCriterion("market_id <>", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdGreaterThan(Integer value) {
            addCriterion("market_id >", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("market_id >=", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdLessThan(Integer value) {
            addCriterion("market_id <", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdLessThanOrEqualTo(Integer value) {
            addCriterion("market_id <=", value, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdIn(List<Integer> values) {
            addCriterion("market_id in", values, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdNotIn(List<Integer> values) {
            addCriterion("market_id not in", values, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdBetween(Integer value1, Integer value2) {
            addCriterion("market_id between", value1, value2, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketIdNotBetween(Integer value1, Integer value2) {
            addCriterion("market_id not between", value1, value2, "marketId");
            return (Criteria) this;
        }

        public Criteria andMarketOrderNoIsNull() {
            addCriterion("market_order_no is null");
            return (Criteria) this;
        }

        public Criteria andMarketOrderNoIsNotNull() {
            addCriterion("market_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andMarketOrderNoEqualTo(String value) {
            addCriterion("market_order_no =", value, "marketOrderNo");
            return (Criteria) this;
        }

        public Criteria andMarketOrderNoNotEqualTo(String value) {
            addCriterion("market_order_no <>", value, "marketOrderNo");
            return (Criteria) this;
        }

        public Criteria andMarketOrderNoGreaterThan(String value) {
            addCriterion("market_order_no >", value, "marketOrderNo");
            return (Criteria) this;
        }

        public Criteria andMarketOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("market_order_no >=", value, "marketOrderNo");
            return (Criteria) this;
        }

        public Criteria andMarketOrderNoLessThan(String value) {
            addCriterion("market_order_no <", value, "marketOrderNo");
            return (Criteria) this;
        }

        public Criteria andMarketOrderNoLessThanOrEqualTo(String value) {
            addCriterion("market_order_no <=", value, "marketOrderNo");
            return (Criteria) this;
        }

        public Criteria andMarketOrderNoLike(String value) {
            addCriterion("market_order_no like", value, "marketOrderNo");
            return (Criteria) this;
        }

        public Criteria andMarketOrderNoNotLike(String value) {
            addCriterion("market_order_no not like", value, "marketOrderNo");
            return (Criteria) this;
        }

        public Criteria andMarketOrderNoIn(List<String> values) {
            addCriterion("market_order_no in", values, "marketOrderNo");
            return (Criteria) this;
        }

        public Criteria andMarketOrderNoNotIn(List<String> values) {
            addCriterion("market_order_no not in", values, "marketOrderNo");
            return (Criteria) this;
        }

        public Criteria andMarketOrderNoBetween(String value1, String value2) {
            addCriterion("market_order_no between", value1, value2, "marketOrderNo");
            return (Criteria) this;
        }

        public Criteria andMarketOrderNoNotBetween(String value1, String value2) {
            addCriterion("market_order_no not between", value1, value2, "marketOrderNo");
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

        public Criteria andProviderOrderNoIsNull() {
            addCriterion("provider_order_no is null");
            return (Criteria) this;
        }

        public Criteria andProviderOrderNoIsNotNull() {
            addCriterion("provider_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andProviderOrderNoEqualTo(String value) {
            addCriterion("provider_order_no =", value, "providerOrderNo");
            return (Criteria) this;
        }

        public Criteria andProviderOrderNoNotEqualTo(String value) {
            addCriterion("provider_order_no <>", value, "providerOrderNo");
            return (Criteria) this;
        }

        public Criteria andProviderOrderNoGreaterThan(String value) {
            addCriterion("provider_order_no >", value, "providerOrderNo");
            return (Criteria) this;
        }

        public Criteria andProviderOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("provider_order_no >=", value, "providerOrderNo");
            return (Criteria) this;
        }

        public Criteria andProviderOrderNoLessThan(String value) {
            addCriterion("provider_order_no <", value, "providerOrderNo");
            return (Criteria) this;
        }

        public Criteria andProviderOrderNoLessThanOrEqualTo(String value) {
            addCriterion("provider_order_no <=", value, "providerOrderNo");
            return (Criteria) this;
        }

        public Criteria andProviderOrderNoLike(String value) {
            addCriterion("provider_order_no like", value, "providerOrderNo");
            return (Criteria) this;
        }

        public Criteria andProviderOrderNoNotLike(String value) {
            addCriterion("provider_order_no not like", value, "providerOrderNo");
            return (Criteria) this;
        }

        public Criteria andProviderOrderNoIn(List<String> values) {
            addCriterion("provider_order_no in", values, "providerOrderNo");
            return (Criteria) this;
        }

        public Criteria andProviderOrderNoNotIn(List<String> values) {
            addCriterion("provider_order_no not in", values, "providerOrderNo");
            return (Criteria) this;
        }

        public Criteria andProviderOrderNoBetween(String value1, String value2) {
            addCriterion("provider_order_no between", value1, value2, "providerOrderNo");
            return (Criteria) this;
        }

        public Criteria andProviderOrderNoNotBetween(String value1, String value2) {
            addCriterion("provider_order_no not between", value1, value2, "providerOrderNo");
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

        public Criteria andHotelIdEqualTo(String value) {
            addCriterion("hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(String value) {
            addCriterion("hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(String value) {
            addCriterion("hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(String value) {
            addCriterion("hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(String value) {
            addCriterion("hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLike(String value) {
            addCriterion("hotel_id like", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotLike(String value) {
            addCriterion("hotel_id not like", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<String> values) {
            addCriterion("hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<String> values) {
            addCriterion("hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(String value1, String value2) {
            addCriterion("hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(String value1, String value2) {
            addCriterion("hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNull() {
            addCriterion("hotel_name is null");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNotNull() {
            addCriterion("hotel_name is not null");
            return (Criteria) this;
        }

        public Criteria andHotelNameEqualTo(String value) {
            addCriterion("hotel_name =", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotEqualTo(String value) {
            addCriterion("hotel_name <>", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThan(String value) {
            addCriterion("hotel_name >", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_name >=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThan(String value) {
            addCriterion("hotel_name <", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThanOrEqualTo(String value) {
            addCriterion("hotel_name <=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLike(String value) {
            addCriterion("hotel_name like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotLike(String value) {
            addCriterion("hotel_name not like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameIn(List<String> values) {
            addCriterion("hotel_name in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotIn(List<String> values) {
            addCriterion("hotel_name not in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameBetween(String value1, String value2) {
            addCriterion("hotel_name between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotBetween(String value1, String value2) {
            addCriterion("hotel_name not between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(String value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(String value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(String value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(String value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(String value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(String value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLike(String value) {
            addCriterion("room_id like", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotLike(String value) {
            addCriterion("room_id not like", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<String> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<String> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(String value1, String value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(String value1, String value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
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

        public Criteria andBookUserIsNull() {
            addCriterion("book_user is null");
            return (Criteria) this;
        }

        public Criteria andBookUserIsNotNull() {
            addCriterion("book_user is not null");
            return (Criteria) this;
        }

        public Criteria andBookUserEqualTo(String value) {
            addCriterion("book_user =", value, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserNotEqualTo(String value) {
            addCriterion("book_user <>", value, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserGreaterThan(String value) {
            addCriterion("book_user >", value, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserGreaterThanOrEqualTo(String value) {
            addCriterion("book_user >=", value, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserLessThan(String value) {
            addCriterion("book_user <", value, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserLessThanOrEqualTo(String value) {
            addCriterion("book_user <=", value, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserLike(String value) {
            addCriterion("book_user like", value, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserNotLike(String value) {
            addCriterion("book_user not like", value, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserIn(List<String> values) {
            addCriterion("book_user in", values, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserNotIn(List<String> values) {
            addCriterion("book_user not in", values, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserBetween(String value1, String value2) {
            addCriterion("book_user between", value1, value2, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookUserNotBetween(String value1, String value2) {
            addCriterion("book_user not between", value1, value2, "bookUser");
            return (Criteria) this;
        }

        public Criteria andBookAmoutIsNull() {
            addCriterion("book_amout is null");
            return (Criteria) this;
        }

        public Criteria andBookAmoutIsNotNull() {
            addCriterion("book_amout is not null");
            return (Criteria) this;
        }

        public Criteria andBookAmoutEqualTo(Integer value) {
            addCriterion("book_amout =", value, "bookAmout");
            return (Criteria) this;
        }

        public Criteria andBookAmoutNotEqualTo(Integer value) {
            addCriterion("book_amout <>", value, "bookAmout");
            return (Criteria) this;
        }

        public Criteria andBookAmoutGreaterThan(Integer value) {
            addCriterion("book_amout >", value, "bookAmout");
            return (Criteria) this;
        }

        public Criteria andBookAmoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_amout >=", value, "bookAmout");
            return (Criteria) this;
        }

        public Criteria andBookAmoutLessThan(Integer value) {
            addCriterion("book_amout <", value, "bookAmout");
            return (Criteria) this;
        }

        public Criteria andBookAmoutLessThanOrEqualTo(Integer value) {
            addCriterion("book_amout <=", value, "bookAmout");
            return (Criteria) this;
        }

        public Criteria andBookAmoutIn(List<Integer> values) {
            addCriterion("book_amout in", values, "bookAmout");
            return (Criteria) this;
        }

        public Criteria andBookAmoutNotIn(List<Integer> values) {
            addCriterion("book_amout not in", values, "bookAmout");
            return (Criteria) this;
        }

        public Criteria andBookAmoutBetween(Integer value1, Integer value2) {
            addCriterion("book_amout between", value1, value2, "bookAmout");
            return (Criteria) this;
        }

        public Criteria andBookAmoutNotBetween(Integer value1, Integer value2) {
            addCriterion("book_amout not between", value1, value2, "bookAmout");
            return (Criteria) this;
        }

        public Criteria andBookPhoneIsNull() {
            addCriterion("book_phone is null");
            return (Criteria) this;
        }

        public Criteria andBookPhoneIsNotNull() {
            addCriterion("book_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBookPhoneEqualTo(String value) {
            addCriterion("book_phone =", value, "bookPhone");
            return (Criteria) this;
        }

        public Criteria andBookPhoneNotEqualTo(String value) {
            addCriterion("book_phone <>", value, "bookPhone");
            return (Criteria) this;
        }

        public Criteria andBookPhoneGreaterThan(String value) {
            addCriterion("book_phone >", value, "bookPhone");
            return (Criteria) this;
        }

        public Criteria andBookPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("book_phone >=", value, "bookPhone");
            return (Criteria) this;
        }

        public Criteria andBookPhoneLessThan(String value) {
            addCriterion("book_phone <", value, "bookPhone");
            return (Criteria) this;
        }

        public Criteria andBookPhoneLessThanOrEqualTo(String value) {
            addCriterion("book_phone <=", value, "bookPhone");
            return (Criteria) this;
        }

        public Criteria andBookPhoneLike(String value) {
            addCriterion("book_phone like", value, "bookPhone");
            return (Criteria) this;
        }

        public Criteria andBookPhoneNotLike(String value) {
            addCriterion("book_phone not like", value, "bookPhone");
            return (Criteria) this;
        }

        public Criteria andBookPhoneIn(List<String> values) {
            addCriterion("book_phone in", values, "bookPhone");
            return (Criteria) this;
        }

        public Criteria andBookPhoneNotIn(List<String> values) {
            addCriterion("book_phone not in", values, "bookPhone");
            return (Criteria) this;
        }

        public Criteria andBookPhoneBetween(String value1, String value2) {
            addCriterion("book_phone between", value1, value2, "bookPhone");
            return (Criteria) this;
        }

        public Criteria andBookPhoneNotBetween(String value1, String value2) {
            addCriterion("book_phone not between", value1, value2, "bookPhone");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNull() {
            addCriterion("begin_date is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(Date value) {
            addCriterionForJDBCDate("begin_date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(Date value) {
            addCriterionForJDBCDate("begin_date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begin_date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<Date> values) {
            addCriterionForJDBCDate("begin_date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("begin_date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begin_date not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("days is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("days is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(Integer value) {
            addCriterion("days =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Integer value) {
            addCriterion("days <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Integer value) {
            addCriterion("days >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("days >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Integer value) {
            addCriterion("days <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Integer value) {
            addCriterion("days <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Integer> values) {
            addCriterion("days in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Integer> values) {
            addCriterion("days not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Integer value1, Integer value2) {
            addCriterion("days between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("days not between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andMarketAmountIsNull() {
            addCriterion("market_amount is null");
            return (Criteria) this;
        }

        public Criteria andMarketAmountIsNotNull() {
            addCriterion("market_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMarketAmountEqualTo(Float value) {
            addCriterion("market_amount =", value, "marketAmount");
            return (Criteria) this;
        }

        public Criteria andMarketAmountNotEqualTo(Float value) {
            addCriterion("market_amount <>", value, "marketAmount");
            return (Criteria) this;
        }

        public Criteria andMarketAmountGreaterThan(Float value) {
            addCriterion("market_amount >", value, "marketAmount");
            return (Criteria) this;
        }

        public Criteria andMarketAmountGreaterThanOrEqualTo(Float value) {
            addCriterion("market_amount >=", value, "marketAmount");
            return (Criteria) this;
        }

        public Criteria andMarketAmountLessThan(Float value) {
            addCriterion("market_amount <", value, "marketAmount");
            return (Criteria) this;
        }

        public Criteria andMarketAmountLessThanOrEqualTo(Float value) {
            addCriterion("market_amount <=", value, "marketAmount");
            return (Criteria) this;
        }

        public Criteria andMarketAmountIn(List<Float> values) {
            addCriterion("market_amount in", values, "marketAmount");
            return (Criteria) this;
        }

        public Criteria andMarketAmountNotIn(List<Float> values) {
            addCriterion("market_amount not in", values, "marketAmount");
            return (Criteria) this;
        }

        public Criteria andMarketAmountBetween(Float value1, Float value2) {
            addCriterion("market_amount between", value1, value2, "marketAmount");
            return (Criteria) this;
        }

        public Criteria andMarketAmountNotBetween(Float value1, Float value2) {
            addCriterion("market_amount not between", value1, value2, "marketAmount");
            return (Criteria) this;
        }

        public Criteria andProviderAmountIsNull() {
            addCriterion("provider_amount is null");
            return (Criteria) this;
        }

        public Criteria andProviderAmountIsNotNull() {
            addCriterion("provider_amount is not null");
            return (Criteria) this;
        }

        public Criteria andProviderAmountEqualTo(Float value) {
            addCriterion("provider_amount =", value, "providerAmount");
            return (Criteria) this;
        }

        public Criteria andProviderAmountNotEqualTo(Float value) {
            addCriterion("provider_amount <>", value, "providerAmount");
            return (Criteria) this;
        }

        public Criteria andProviderAmountGreaterThan(Float value) {
            addCriterion("provider_amount >", value, "providerAmount");
            return (Criteria) this;
        }

        public Criteria andProviderAmountGreaterThanOrEqualTo(Float value) {
            addCriterion("provider_amount >=", value, "providerAmount");
            return (Criteria) this;
        }

        public Criteria andProviderAmountLessThan(Float value) {
            addCriterion("provider_amount <", value, "providerAmount");
            return (Criteria) this;
        }

        public Criteria andProviderAmountLessThanOrEqualTo(Float value) {
            addCriterion("provider_amount <=", value, "providerAmount");
            return (Criteria) this;
        }

        public Criteria andProviderAmountIn(List<Float> values) {
            addCriterion("provider_amount in", values, "providerAmount");
            return (Criteria) this;
        }

        public Criteria andProviderAmountNotIn(List<Float> values) {
            addCriterion("provider_amount not in", values, "providerAmount");
            return (Criteria) this;
        }

        public Criteria andProviderAmountBetween(Float value1, Float value2) {
            addCriterion("provider_amount between", value1, value2, "providerAmount");
            return (Criteria) this;
        }

        public Criteria andProviderAmountNotBetween(Float value1, Float value2) {
            addCriterion("provider_amount not between", value1, value2, "providerAmount");
            return (Criteria) this;
        }

        public Criteria andMarketStatusIsNull() {
            addCriterion("market_status is null");
            return (Criteria) this;
        }

        public Criteria andMarketStatusIsNotNull() {
            addCriterion("market_status is not null");
            return (Criteria) this;
        }

        public Criteria andMarketStatusEqualTo(String value) {
            addCriterion("market_status =", value, "marketStatus");
            return (Criteria) this;
        }

        public Criteria andMarketStatusNotEqualTo(String value) {
            addCriterion("market_status <>", value, "marketStatus");
            return (Criteria) this;
        }

        public Criteria andMarketStatusGreaterThan(String value) {
            addCriterion("market_status >", value, "marketStatus");
            return (Criteria) this;
        }

        public Criteria andMarketStatusGreaterThanOrEqualTo(String value) {
            addCriterion("market_status >=", value, "marketStatus");
            return (Criteria) this;
        }

        public Criteria andMarketStatusLessThan(String value) {
            addCriterion("market_status <", value, "marketStatus");
            return (Criteria) this;
        }

        public Criteria andMarketStatusLessThanOrEqualTo(String value) {
            addCriterion("market_status <=", value, "marketStatus");
            return (Criteria) this;
        }

        public Criteria andMarketStatusLike(String value) {
            addCriterion("market_status like", value, "marketStatus");
            return (Criteria) this;
        }

        public Criteria andMarketStatusNotLike(String value) {
            addCriterion("market_status not like", value, "marketStatus");
            return (Criteria) this;
        }

        public Criteria andMarketStatusIn(List<String> values) {
            addCriterion("market_status in", values, "marketStatus");
            return (Criteria) this;
        }

        public Criteria andMarketStatusNotIn(List<String> values) {
            addCriterion("market_status not in", values, "marketStatus");
            return (Criteria) this;
        }

        public Criteria andMarketStatusBetween(String value1, String value2) {
            addCriterion("market_status between", value1, value2, "marketStatus");
            return (Criteria) this;
        }

        public Criteria andMarketStatusNotBetween(String value1, String value2) {
            addCriterion("market_status not between", value1, value2, "marketStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusIsNull() {
            addCriterion("provider_status is null");
            return (Criteria) this;
        }

        public Criteria andProviderStatusIsNotNull() {
            addCriterion("provider_status is not null");
            return (Criteria) this;
        }

        public Criteria andProviderStatusEqualTo(String value) {
            addCriterion("provider_status =", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusNotEqualTo(String value) {
            addCriterion("provider_status <>", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusGreaterThan(String value) {
            addCriterion("provider_status >", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("provider_status >=", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusLessThan(String value) {
            addCriterion("provider_status <", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusLessThanOrEqualTo(String value) {
            addCriterion("provider_status <=", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusLike(String value) {
            addCriterion("provider_status like", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusNotLike(String value) {
            addCriterion("provider_status not like", value, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusIn(List<String> values) {
            addCriterion("provider_status in", values, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusNotIn(List<String> values) {
            addCriterion("provider_status not in", values, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusBetween(String value1, String value2) {
            addCriterion("provider_status between", value1, value2, "providerStatus");
            return (Criteria) this;
        }

        public Criteria andProviderStatusNotBetween(String value1, String value2) {
            addCriterion("provider_status not between", value1, value2, "providerStatus");
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