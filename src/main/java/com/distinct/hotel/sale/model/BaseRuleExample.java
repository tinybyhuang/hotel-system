package com.distinct.hotel.sale.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BaseRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseRuleExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andSaleRuleIdIsNull() {
            addCriterion("sale_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andSaleRuleIdIsNotNull() {
            addCriterion("sale_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andSaleRuleIdEqualTo(Integer value) {
            addCriterion("sale_rule_id =", value, "saleRuleId");
            return (Criteria) this;
        }

        public Criteria andSaleRuleIdNotEqualTo(Integer value) {
            addCriterion("sale_rule_id <>", value, "saleRuleId");
            return (Criteria) this;
        }

        public Criteria andSaleRuleIdGreaterThan(Integer value) {
            addCriterion("sale_rule_id >", value, "saleRuleId");
            return (Criteria) this;
        }

        public Criteria andSaleRuleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_rule_id >=", value, "saleRuleId");
            return (Criteria) this;
        }

        public Criteria andSaleRuleIdLessThan(Integer value) {
            addCriterion("sale_rule_id <", value, "saleRuleId");
            return (Criteria) this;
        }

        public Criteria andSaleRuleIdLessThanOrEqualTo(Integer value) {
            addCriterion("sale_rule_id <=", value, "saleRuleId");
            return (Criteria) this;
        }

        public Criteria andSaleRuleIdIn(List<Integer> values) {
            addCriterion("sale_rule_id in", values, "saleRuleId");
            return (Criteria) this;
        }

        public Criteria andSaleRuleIdNotIn(List<Integer> values) {
            addCriterion("sale_rule_id not in", values, "saleRuleId");
            return (Criteria) this;
        }

        public Criteria andSaleRuleIdBetween(Integer value1, Integer value2) {
            addCriterion("sale_rule_id between", value1, value2, "saleRuleId");
            return (Criteria) this;
        }

        public Criteria andSaleRuleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_rule_id not between", value1, value2, "saleRuleId");
            return (Criteria) this;
        }

        public Criteria andIncreaseTypeIsNull() {
            addCriterion("increase_type is null");
            return (Criteria) this;
        }

        public Criteria andIncreaseTypeIsNotNull() {
            addCriterion("increase_type is not null");
            return (Criteria) this;
        }

        public Criteria andIncreaseTypeEqualTo(String value) {
            addCriterion("increase_type =", value, "increaseType");
            return (Criteria) this;
        }

        public Criteria andIncreaseTypeNotEqualTo(String value) {
            addCriterion("increase_type <>", value, "increaseType");
            return (Criteria) this;
        }

        public Criteria andIncreaseTypeGreaterThan(String value) {
            addCriterion("increase_type >", value, "increaseType");
            return (Criteria) this;
        }

        public Criteria andIncreaseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("increase_type >=", value, "increaseType");
            return (Criteria) this;
        }

        public Criteria andIncreaseTypeLessThan(String value) {
            addCriterion("increase_type <", value, "increaseType");
            return (Criteria) this;
        }

        public Criteria andIncreaseTypeLessThanOrEqualTo(String value) {
            addCriterion("increase_type <=", value, "increaseType");
            return (Criteria) this;
        }

        public Criteria andIncreaseTypeLike(String value) {
            addCriterion("increase_type like", value, "increaseType");
            return (Criteria) this;
        }

        public Criteria andIncreaseTypeNotLike(String value) {
            addCriterion("increase_type not like", value, "increaseType");
            return (Criteria) this;
        }

        public Criteria andIncreaseTypeIn(List<String> values) {
            addCriterion("increase_type in", values, "increaseType");
            return (Criteria) this;
        }

        public Criteria andIncreaseTypeNotIn(List<String> values) {
            addCriterion("increase_type not in", values, "increaseType");
            return (Criteria) this;
        }

        public Criteria andIncreaseTypeBetween(String value1, String value2) {
            addCriterion("increase_type between", value1, value2, "increaseType");
            return (Criteria) this;
        }

        public Criteria andIncreaseTypeNotBetween(String value1, String value2) {
            addCriterion("increase_type not between", value1, value2, "increaseType");
            return (Criteria) this;
        }

        public Criteria andIncreaseAmountIsNull() {
            addCriterion("increase_amount is null");
            return (Criteria) this;
        }

        public Criteria andIncreaseAmountIsNotNull() {
            addCriterion("increase_amount is not null");
            return (Criteria) this;
        }

        public Criteria andIncreaseAmountEqualTo(Double value) {
            addCriterion("increase_amount =", value, "increaseAmount");
            return (Criteria) this;
        }

        public Criteria andIncreaseAmountNotEqualTo(Double value) {
            addCriterion("increase_amount <>", value, "increaseAmount");
            return (Criteria) this;
        }

        public Criteria andIncreaseAmountGreaterThan(Double value) {
            addCriterion("increase_amount >", value, "increaseAmount");
            return (Criteria) this;
        }

        public Criteria andIncreaseAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("increase_amount >=", value, "increaseAmount");
            return (Criteria) this;
        }

        public Criteria andIncreaseAmountLessThan(Double value) {
            addCriterion("increase_amount <", value, "increaseAmount");
            return (Criteria) this;
        }

        public Criteria andIncreaseAmountLessThanOrEqualTo(Double value) {
            addCriterion("increase_amount <=", value, "increaseAmount");
            return (Criteria) this;
        }

        public Criteria andIncreaseAmountIn(List<Double> values) {
            addCriterion("increase_amount in", values, "increaseAmount");
            return (Criteria) this;
        }

        public Criteria andIncreaseAmountNotIn(List<Double> values) {
            addCriterion("increase_amount not in", values, "increaseAmount");
            return (Criteria) this;
        }

        public Criteria andIncreaseAmountBetween(Double value1, Double value2) {
            addCriterion("increase_amount between", value1, value2, "increaseAmount");
            return (Criteria) this;
        }

        public Criteria andIncreaseAmountNotBetween(Double value1, Double value2) {
            addCriterion("increase_amount not between", value1, value2, "increaseAmount");
            return (Criteria) this;
        }

        public Criteria andLowerPriceIsNull() {
            addCriterion("lower_price is null");
            return (Criteria) this;
        }

        public Criteria andLowerPriceIsNotNull() {
            addCriterion("lower_price is not null");
            return (Criteria) this;
        }

        public Criteria andLowerPriceEqualTo(Integer value) {
            addCriterion("lower_price =", value, "lowerPrice");
            return (Criteria) this;
        }

        public Criteria andLowerPriceNotEqualTo(Integer value) {
            addCriterion("lower_price <>", value, "lowerPrice");
            return (Criteria) this;
        }

        public Criteria andLowerPriceGreaterThan(Integer value) {
            addCriterion("lower_price >", value, "lowerPrice");
            return (Criteria) this;
        }

        public Criteria andLowerPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("lower_price >=", value, "lowerPrice");
            return (Criteria) this;
        }

        public Criteria andLowerPriceLessThan(Integer value) {
            addCriterion("lower_price <", value, "lowerPrice");
            return (Criteria) this;
        }

        public Criteria andLowerPriceLessThanOrEqualTo(Integer value) {
            addCriterion("lower_price <=", value, "lowerPrice");
            return (Criteria) this;
        }

        public Criteria andLowerPriceIn(List<Integer> values) {
            addCriterion("lower_price in", values, "lowerPrice");
            return (Criteria) this;
        }

        public Criteria andLowerPriceNotIn(List<Integer> values) {
            addCriterion("lower_price not in", values, "lowerPrice");
            return (Criteria) this;
        }

        public Criteria andLowerPriceBetween(Integer value1, Integer value2) {
            addCriterion("lower_price between", value1, value2, "lowerPrice");
            return (Criteria) this;
        }

        public Criteria andLowerPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("lower_price not between", value1, value2, "lowerPrice");
            return (Criteria) this;
        }

        public Criteria andSafePriceIsNull() {
            addCriterion("safe_price is null");
            return (Criteria) this;
        }

        public Criteria andSafePriceIsNotNull() {
            addCriterion("safe_price is not null");
            return (Criteria) this;
        }

        public Criteria andSafePriceEqualTo(Integer value) {
            addCriterion("safe_price =", value, "safePrice");
            return (Criteria) this;
        }

        public Criteria andSafePriceNotEqualTo(Integer value) {
            addCriterion("safe_price <>", value, "safePrice");
            return (Criteria) this;
        }

        public Criteria andSafePriceGreaterThan(Integer value) {
            addCriterion("safe_price >", value, "safePrice");
            return (Criteria) this;
        }

        public Criteria andSafePriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("safe_price >=", value, "safePrice");
            return (Criteria) this;
        }

        public Criteria andSafePriceLessThan(Integer value) {
            addCriterion("safe_price <", value, "safePrice");
            return (Criteria) this;
        }

        public Criteria andSafePriceLessThanOrEqualTo(Integer value) {
            addCriterion("safe_price <=", value, "safePrice");
            return (Criteria) this;
        }

        public Criteria andSafePriceIn(List<Integer> values) {
            addCriterion("safe_price in", values, "safePrice");
            return (Criteria) this;
        }

        public Criteria andSafePriceNotIn(List<Integer> values) {
            addCriterion("safe_price not in", values, "safePrice");
            return (Criteria) this;
        }

        public Criteria andSafePriceBetween(Integer value1, Integer value2) {
            addCriterion("safe_price between", value1, value2, "safePrice");
            return (Criteria) this;
        }

        public Criteria andSafePriceNotBetween(Integer value1, Integer value2) {
            addCriterion("safe_price not between", value1, value2, "safePrice");
            return (Criteria) this;
        }

        public Criteria andRoomDetainIsNull() {
            addCriterion("room_detain is null");
            return (Criteria) this;
        }

        public Criteria andRoomDetainIsNotNull() {
            addCriterion("room_detain is not null");
            return (Criteria) this;
        }

        public Criteria andRoomDetainEqualTo(Integer value) {
            addCriterion("room_detain =", value, "roomDetain");
            return (Criteria) this;
        }

        public Criteria andRoomDetainNotEqualTo(Integer value) {
            addCriterion("room_detain <>", value, "roomDetain");
            return (Criteria) this;
        }

        public Criteria andRoomDetainGreaterThan(Integer value) {
            addCriterion("room_detain >", value, "roomDetain");
            return (Criteria) this;
        }

        public Criteria andRoomDetainGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_detain >=", value, "roomDetain");
            return (Criteria) this;
        }

        public Criteria andRoomDetainLessThan(Integer value) {
            addCriterion("room_detain <", value, "roomDetain");
            return (Criteria) this;
        }

        public Criteria andRoomDetainLessThanOrEqualTo(Integer value) {
            addCriterion("room_detain <=", value, "roomDetain");
            return (Criteria) this;
        }

        public Criteria andRoomDetainIn(List<Integer> values) {
            addCriterion("room_detain in", values, "roomDetain");
            return (Criteria) this;
        }

        public Criteria andRoomDetainNotIn(List<Integer> values) {
            addCriterion("room_detain not in", values, "roomDetain");
            return (Criteria) this;
        }

        public Criteria andRoomDetainBetween(Integer value1, Integer value2) {
            addCriterion("room_detain between", value1, value2, "roomDetain");
            return (Criteria) this;
        }

        public Criteria andRoomDetainNotBetween(Integer value1, Integer value2) {
            addCriterion("room_detain not between", value1, value2, "roomDetain");
            return (Criteria) this;
        }

        public Criteria andPresentSaleIsNull() {
            addCriterion("present_sale is null");
            return (Criteria) this;
        }

        public Criteria andPresentSaleIsNotNull() {
            addCriterion("present_sale is not null");
            return (Criteria) this;
        }

        public Criteria andPresentSaleEqualTo(Date value) {
            addCriterionForJDBCTime("present_sale =", value, "presentSale");
            return (Criteria) this;
        }

        public Criteria andPresentSaleNotEqualTo(Date value) {
            addCriterionForJDBCTime("present_sale <>", value, "presentSale");
            return (Criteria) this;
        }

        public Criteria andPresentSaleGreaterThan(Date value) {
            addCriterionForJDBCTime("present_sale >", value, "presentSale");
            return (Criteria) this;
        }

        public Criteria andPresentSaleGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("present_sale >=", value, "presentSale");
            return (Criteria) this;
        }

        public Criteria andPresentSaleLessThan(Date value) {
            addCriterionForJDBCTime("present_sale <", value, "presentSale");
            return (Criteria) this;
        }

        public Criteria andPresentSaleLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("present_sale <=", value, "presentSale");
            return (Criteria) this;
        }

        public Criteria andPresentSaleIn(List<Date> values) {
            addCriterionForJDBCTime("present_sale in", values, "presentSale");
            return (Criteria) this;
        }

        public Criteria andPresentSaleNotIn(List<Date> values) {
            addCriterionForJDBCTime("present_sale not in", values, "presentSale");
            return (Criteria) this;
        }

        public Criteria andPresentSaleBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("present_sale between", value1, value2, "presentSale");
            return (Criteria) this;
        }

        public Criteria andPresentSaleNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("present_sale not between", value1, value2, "presentSale");
            return (Criteria) this;
        }

        public Criteria andHotelInstructionIsNull() {
            addCriterion("hotel_instruction is null");
            return (Criteria) this;
        }

        public Criteria andHotelInstructionIsNotNull() {
            addCriterion("hotel_instruction is not null");
            return (Criteria) this;
        }

        public Criteria andHotelInstructionEqualTo(String value) {
            addCriterion("hotel_instruction =", value, "hotelInstruction");
            return (Criteria) this;
        }

        public Criteria andHotelInstructionNotEqualTo(String value) {
            addCriterion("hotel_instruction <>", value, "hotelInstruction");
            return (Criteria) this;
        }

        public Criteria andHotelInstructionGreaterThan(String value) {
            addCriterion("hotel_instruction >", value, "hotelInstruction");
            return (Criteria) this;
        }

        public Criteria andHotelInstructionGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_instruction >=", value, "hotelInstruction");
            return (Criteria) this;
        }

        public Criteria andHotelInstructionLessThan(String value) {
            addCriterion("hotel_instruction <", value, "hotelInstruction");
            return (Criteria) this;
        }

        public Criteria andHotelInstructionLessThanOrEqualTo(String value) {
            addCriterion("hotel_instruction <=", value, "hotelInstruction");
            return (Criteria) this;
        }

        public Criteria andHotelInstructionLike(String value) {
            addCriterion("hotel_instruction like", value, "hotelInstruction");
            return (Criteria) this;
        }

        public Criteria andHotelInstructionNotLike(String value) {
            addCriterion("hotel_instruction not like", value, "hotelInstruction");
            return (Criteria) this;
        }

        public Criteria andHotelInstructionIn(List<String> values) {
            addCriterion("hotel_instruction in", values, "hotelInstruction");
            return (Criteria) this;
        }

        public Criteria andHotelInstructionNotIn(List<String> values) {
            addCriterion("hotel_instruction not in", values, "hotelInstruction");
            return (Criteria) this;
        }

        public Criteria andHotelInstructionBetween(String value1, String value2) {
            addCriterion("hotel_instruction between", value1, value2, "hotelInstruction");
            return (Criteria) this;
        }

        public Criteria andHotelInstructionNotBetween(String value1, String value2) {
            addCriterion("hotel_instruction not between", value1, value2, "hotelInstruction");
            return (Criteria) this;
        }

        public Criteria andRoomInstructionIsNull() {
            addCriterion("\"room_ instruction\" is null");
            return (Criteria) this;
        }

        public Criteria andRoomInstructionIsNotNull() {
            addCriterion("\"room_ instruction\" is not null");
            return (Criteria) this;
        }

        public Criteria andRoomInstructionEqualTo(String value) {
            addCriterion("\"room_ instruction\" =", value, "roomInstruction");
            return (Criteria) this;
        }

        public Criteria andRoomInstructionNotEqualTo(String value) {
            addCriterion("\"room_ instruction\" <>", value, "roomInstruction");
            return (Criteria) this;
        }

        public Criteria andRoomInstructionGreaterThan(String value) {
            addCriterion("\"room_ instruction\" >", value, "roomInstruction");
            return (Criteria) this;
        }

        public Criteria andRoomInstructionGreaterThanOrEqualTo(String value) {
            addCriterion("\"room_ instruction\" >=", value, "roomInstruction");
            return (Criteria) this;
        }

        public Criteria andRoomInstructionLessThan(String value) {
            addCriterion("\"room_ instruction\" <", value, "roomInstruction");
            return (Criteria) this;
        }

        public Criteria andRoomInstructionLessThanOrEqualTo(String value) {
            addCriterion("\"room_ instruction\" <=", value, "roomInstruction");
            return (Criteria) this;
        }

        public Criteria andRoomInstructionLike(String value) {
            addCriterion("\"room_ instruction\" like", value, "roomInstruction");
            return (Criteria) this;
        }

        public Criteria andRoomInstructionNotLike(String value) {
            addCriterion("\"room_ instruction\" not like", value, "roomInstruction");
            return (Criteria) this;
        }

        public Criteria andRoomInstructionIn(List<String> values) {
            addCriterion("\"room_ instruction\" in", values, "roomInstruction");
            return (Criteria) this;
        }

        public Criteria andRoomInstructionNotIn(List<String> values) {
            addCriterion("\"room_ instruction\" not in", values, "roomInstruction");
            return (Criteria) this;
        }

        public Criteria andRoomInstructionBetween(String value1, String value2) {
            addCriterion("\"room_ instruction\" between", value1, value2, "roomInstruction");
            return (Criteria) this;
        }

        public Criteria andRoomInstructionNotBetween(String value1, String value2) {
            addCriterion("\"room_ instruction\" not between", value1, value2, "roomInstruction");
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

        public Criteria andModifiedIsNull() {
            addCriterion("modified is null");
            return (Criteria) this;
        }

        public Criteria andModifiedIsNotNull() {
            addCriterion("modified is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedEqualTo(Date value) {
            addCriterion("modified =", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotEqualTo(Date value) {
            addCriterion("modified <>", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThan(Date value) {
            addCriterion("modified >", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("modified >=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThan(Date value) {
            addCriterion("modified <", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedLessThanOrEqualTo(Date value) {
            addCriterion("modified <=", value, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedIn(List<Date> values) {
            addCriterion("modified in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotIn(List<Date> values) {
            addCriterion("modified not in", values, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedBetween(Date value1, Date value2) {
            addCriterion("modified between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andModifiedNotBetween(Date value1, Date value2) {
            addCriterion("modified not between", value1, value2, "modified");
            return (Criteria) this;
        }

        public Criteria andModUserIdIsNull() {
            addCriterion("mod_user_id is null");
            return (Criteria) this;
        }

        public Criteria andModUserIdIsNotNull() {
            addCriterion("mod_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andModUserIdEqualTo(Integer value) {
            addCriterion("mod_user_id =", value, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdNotEqualTo(Integer value) {
            addCriterion("mod_user_id <>", value, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdGreaterThan(Integer value) {
            addCriterion("mod_user_id >", value, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mod_user_id >=", value, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdLessThan(Integer value) {
            addCriterion("mod_user_id <", value, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("mod_user_id <=", value, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdIn(List<Integer> values) {
            addCriterion("mod_user_id in", values, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdNotIn(List<Integer> values) {
            addCriterion("mod_user_id not in", values, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdBetween(Integer value1, Integer value2) {
            addCriterion("mod_user_id between", value1, value2, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mod_user_id not between", value1, value2, "modUserId");
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