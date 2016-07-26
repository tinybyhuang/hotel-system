package com.distinct.hotel.product.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HotelExample() {
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

        public Criteria andProviderHotelIdIsNull() {
            addCriterion("provider_hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andProviderHotelIdIsNotNull() {
            addCriterion("provider_hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andProviderHotelIdEqualTo(Integer value) {
            addCriterion("provider_hotel_id =", value, "providerHotelId");
            return (Criteria) this;
        }

        public Criteria andProviderHotelIdNotEqualTo(Integer value) {
            addCriterion("provider_hotel_id <>", value, "providerHotelId");
            return (Criteria) this;
        }

        public Criteria andProviderHotelIdGreaterThan(Integer value) {
            addCriterion("provider_hotel_id >", value, "providerHotelId");
            return (Criteria) this;
        }

        public Criteria andProviderHotelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("provider_hotel_id >=", value, "providerHotelId");
            return (Criteria) this;
        }

        public Criteria andProviderHotelIdLessThan(Integer value) {
            addCriterion("provider_hotel_id <", value, "providerHotelId");
            return (Criteria) this;
        }

        public Criteria andProviderHotelIdLessThanOrEqualTo(Integer value) {
            addCriterion("provider_hotel_id <=", value, "providerHotelId");
            return (Criteria) this;
        }

        public Criteria andProviderHotelIdIn(List<Integer> values) {
            addCriterion("provider_hotel_id in", values, "providerHotelId");
            return (Criteria) this;
        }

        public Criteria andProviderHotelIdNotIn(List<Integer> values) {
            addCriterion("provider_hotel_id not in", values, "providerHotelId");
            return (Criteria) this;
        }

        public Criteria andProviderHotelIdBetween(Integer value1, Integer value2) {
            addCriterion("provider_hotel_id between", value1, value2, "providerHotelId");
            return (Criteria) this;
        }

        public Criteria andProviderHotelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("provider_hotel_id not between", value1, value2, "providerHotelId");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
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

        public Criteria andHotelPhoneIsNull() {
            addCriterion("hotel_phone is null");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneIsNotNull() {
            addCriterion("hotel_phone is not null");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneEqualTo(String value) {
            addCriterion("hotel_phone =", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneNotEqualTo(String value) {
            addCriterion("hotel_phone <>", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneGreaterThan(String value) {
            addCriterion("hotel_phone >", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_phone >=", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneLessThan(String value) {
            addCriterion("hotel_phone <", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneLessThanOrEqualTo(String value) {
            addCriterion("hotel_phone <=", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneLike(String value) {
            addCriterion("hotel_phone like", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneNotLike(String value) {
            addCriterion("hotel_phone not like", value, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneIn(List<String> values) {
            addCriterion("hotel_phone in", values, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneNotIn(List<String> values) {
            addCriterion("hotel_phone not in", values, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneBetween(String value1, String value2) {
            addCriterion("hotel_phone between", value1, value2, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelPhoneNotBetween(String value1, String value2) {
            addCriterion("hotel_phone not between", value1, value2, "hotelPhone");
            return (Criteria) this;
        }

        public Criteria andHotelAddressIsNull() {
            addCriterion("hotel_address is null");
            return (Criteria) this;
        }

        public Criteria andHotelAddressIsNotNull() {
            addCriterion("hotel_address is not null");
            return (Criteria) this;
        }

        public Criteria andHotelAddressEqualTo(String value) {
            addCriterion("hotel_address =", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressNotEqualTo(String value) {
            addCriterion("hotel_address <>", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressGreaterThan(String value) {
            addCriterion("hotel_address >", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_address >=", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressLessThan(String value) {
            addCriterion("hotel_address <", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressLessThanOrEqualTo(String value) {
            addCriterion("hotel_address <=", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressLike(String value) {
            addCriterion("hotel_address like", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressNotLike(String value) {
            addCriterion("hotel_address not like", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressIn(List<String> values) {
            addCriterion("hotel_address in", values, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressNotIn(List<String> values) {
            addCriterion("hotel_address not in", values, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressBetween(String value1, String value2) {
            addCriterion("hotel_address between", value1, value2, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressNotBetween(String value1, String value2) {
            addCriterion("hotel_address not between", value1, value2, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelWebsiteIsNull() {
            addCriterion("hotel_website is null");
            return (Criteria) this;
        }

        public Criteria andHotelWebsiteIsNotNull() {
            addCriterion("hotel_website is not null");
            return (Criteria) this;
        }

        public Criteria andHotelWebsiteEqualTo(String value) {
            addCriterion("hotel_website =", value, "hotelWebsite");
            return (Criteria) this;
        }

        public Criteria andHotelWebsiteNotEqualTo(String value) {
            addCriterion("hotel_website <>", value, "hotelWebsite");
            return (Criteria) this;
        }

        public Criteria andHotelWebsiteGreaterThan(String value) {
            addCriterion("hotel_website >", value, "hotelWebsite");
            return (Criteria) this;
        }

        public Criteria andHotelWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_website >=", value, "hotelWebsite");
            return (Criteria) this;
        }

        public Criteria andHotelWebsiteLessThan(String value) {
            addCriterion("hotel_website <", value, "hotelWebsite");
            return (Criteria) this;
        }

        public Criteria andHotelWebsiteLessThanOrEqualTo(String value) {
            addCriterion("hotel_website <=", value, "hotelWebsite");
            return (Criteria) this;
        }

        public Criteria andHotelWebsiteLike(String value) {
            addCriterion("hotel_website like", value, "hotelWebsite");
            return (Criteria) this;
        }

        public Criteria andHotelWebsiteNotLike(String value) {
            addCriterion("hotel_website not like", value, "hotelWebsite");
            return (Criteria) this;
        }

        public Criteria andHotelWebsiteIn(List<String> values) {
            addCriterion("hotel_website in", values, "hotelWebsite");
            return (Criteria) this;
        }

        public Criteria andHotelWebsiteNotIn(List<String> values) {
            addCriterion("hotel_website not in", values, "hotelWebsite");
            return (Criteria) this;
        }

        public Criteria andHotelWebsiteBetween(String value1, String value2) {
            addCriterion("hotel_website between", value1, value2, "hotelWebsite");
            return (Criteria) this;
        }

        public Criteria andHotelWebsiteNotBetween(String value1, String value2) {
            addCriterion("hotel_website not between", value1, value2, "hotelWebsite");
            return (Criteria) this;
        }

        public Criteria andHotelLongitudeIsNull() {
            addCriterion("hotel_longitude is null");
            return (Criteria) this;
        }

        public Criteria andHotelLongitudeIsNotNull() {
            addCriterion("hotel_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andHotelLongitudeEqualTo(String value) {
            addCriterion("hotel_longitude =", value, "hotelLongitude");
            return (Criteria) this;
        }

        public Criteria andHotelLongitudeNotEqualTo(String value) {
            addCriterion("hotel_longitude <>", value, "hotelLongitude");
            return (Criteria) this;
        }

        public Criteria andHotelLongitudeGreaterThan(String value) {
            addCriterion("hotel_longitude >", value, "hotelLongitude");
            return (Criteria) this;
        }

        public Criteria andHotelLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_longitude >=", value, "hotelLongitude");
            return (Criteria) this;
        }

        public Criteria andHotelLongitudeLessThan(String value) {
            addCriterion("hotel_longitude <", value, "hotelLongitude");
            return (Criteria) this;
        }

        public Criteria andHotelLongitudeLessThanOrEqualTo(String value) {
            addCriterion("hotel_longitude <=", value, "hotelLongitude");
            return (Criteria) this;
        }

        public Criteria andHotelLongitudeLike(String value) {
            addCriterion("hotel_longitude like", value, "hotelLongitude");
            return (Criteria) this;
        }

        public Criteria andHotelLongitudeNotLike(String value) {
            addCriterion("hotel_longitude not like", value, "hotelLongitude");
            return (Criteria) this;
        }

        public Criteria andHotelLongitudeIn(List<String> values) {
            addCriterion("hotel_longitude in", values, "hotelLongitude");
            return (Criteria) this;
        }

        public Criteria andHotelLongitudeNotIn(List<String> values) {
            addCriterion("hotel_longitude not in", values, "hotelLongitude");
            return (Criteria) this;
        }

        public Criteria andHotelLongitudeBetween(String value1, String value2) {
            addCriterion("hotel_longitude between", value1, value2, "hotelLongitude");
            return (Criteria) this;
        }

        public Criteria andHotelLongitudeNotBetween(String value1, String value2) {
            addCriterion("hotel_longitude not between", value1, value2, "hotelLongitude");
            return (Criteria) this;
        }

        public Criteria andHotelLatitudeIsNull() {
            addCriterion("hotel_latitude is null");
            return (Criteria) this;
        }

        public Criteria andHotelLatitudeIsNotNull() {
            addCriterion("hotel_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andHotelLatitudeEqualTo(String value) {
            addCriterion("hotel_latitude =", value, "hotelLatitude");
            return (Criteria) this;
        }

        public Criteria andHotelLatitudeNotEqualTo(String value) {
            addCriterion("hotel_latitude <>", value, "hotelLatitude");
            return (Criteria) this;
        }

        public Criteria andHotelLatitudeGreaterThan(String value) {
            addCriterion("hotel_latitude >", value, "hotelLatitude");
            return (Criteria) this;
        }

        public Criteria andHotelLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_latitude >=", value, "hotelLatitude");
            return (Criteria) this;
        }

        public Criteria andHotelLatitudeLessThan(String value) {
            addCriterion("hotel_latitude <", value, "hotelLatitude");
            return (Criteria) this;
        }

        public Criteria andHotelLatitudeLessThanOrEqualTo(String value) {
            addCriterion("hotel_latitude <=", value, "hotelLatitude");
            return (Criteria) this;
        }

        public Criteria andHotelLatitudeLike(String value) {
            addCriterion("hotel_latitude like", value, "hotelLatitude");
            return (Criteria) this;
        }

        public Criteria andHotelLatitudeNotLike(String value) {
            addCriterion("hotel_latitude not like", value, "hotelLatitude");
            return (Criteria) this;
        }

        public Criteria andHotelLatitudeIn(List<String> values) {
            addCriterion("hotel_latitude in", values, "hotelLatitude");
            return (Criteria) this;
        }

        public Criteria andHotelLatitudeNotIn(List<String> values) {
            addCriterion("hotel_latitude not in", values, "hotelLatitude");
            return (Criteria) this;
        }

        public Criteria andHotelLatitudeBetween(String value1, String value2) {
            addCriterion("hotel_latitude between", value1, value2, "hotelLatitude");
            return (Criteria) this;
        }

        public Criteria andHotelLatitudeNotBetween(String value1, String value2) {
            addCriterion("hotel_latitude not between", value1, value2, "hotelLatitude");
            return (Criteria) this;
        }

        public Criteria andHotelStarIsNull() {
            addCriterion("hotel_star is null");
            return (Criteria) this;
        }

        public Criteria andHotelStarIsNotNull() {
            addCriterion("hotel_star is not null");
            return (Criteria) this;
        }

        public Criteria andHotelStarEqualTo(String value) {
            addCriterion("hotel_star =", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarNotEqualTo(String value) {
            addCriterion("hotel_star <>", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarGreaterThan(String value) {
            addCriterion("hotel_star >", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_star >=", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarLessThan(String value) {
            addCriterion("hotel_star <", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarLessThanOrEqualTo(String value) {
            addCriterion("hotel_star <=", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarLike(String value) {
            addCriterion("hotel_star like", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarNotLike(String value) {
            addCriterion("hotel_star not like", value, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarIn(List<String> values) {
            addCriterion("hotel_star in", values, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarNotIn(List<String> values) {
            addCriterion("hotel_star not in", values, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarBetween(String value1, String value2) {
            addCriterion("hotel_star between", value1, value2, "hotelStar");
            return (Criteria) this;
        }

        public Criteria andHotelStarNotBetween(String value1, String value2) {
            addCriterion("hotel_star not between", value1, value2, "hotelStar");
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