package com.distinct.hotel.sale.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilterRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FilterRuleExample() {
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

        public Criteria andFilterTypeIsNull() {
            addCriterion("filter_type is null");
            return (Criteria) this;
        }

        public Criteria andFilterTypeIsNotNull() {
            addCriterion("filter_type is not null");
            return (Criteria) this;
        }

        public Criteria andFilterTypeEqualTo(String value) {
            addCriterion("filter_type =", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeNotEqualTo(String value) {
            addCriterion("filter_type <>", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeGreaterThan(String value) {
            addCriterion("filter_type >", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeGreaterThanOrEqualTo(String value) {
            addCriterion("filter_type >=", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeLessThan(String value) {
            addCriterion("filter_type <", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeLessThanOrEqualTo(String value) {
            addCriterion("filter_type <=", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeLike(String value) {
            addCriterion("filter_type like", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeNotLike(String value) {
            addCriterion("filter_type not like", value, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeIn(List<String> values) {
            addCriterion("filter_type in", values, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeNotIn(List<String> values) {
            addCriterion("filter_type not in", values, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeBetween(String value1, String value2) {
            addCriterion("filter_type between", value1, value2, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterTypeNotBetween(String value1, String value2) {
            addCriterion("filter_type not between", value1, value2, "filterType");
            return (Criteria) this;
        }

        public Criteria andFilterIdIsNull() {
            addCriterion("filter_id is null");
            return (Criteria) this;
        }

        public Criteria andFilterIdIsNotNull() {
            addCriterion("filter_id is not null");
            return (Criteria) this;
        }

        public Criteria andFilterIdEqualTo(Integer value) {
            addCriterion("filter_id =", value, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdNotEqualTo(Integer value) {
            addCriterion("filter_id <>", value, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdGreaterThan(Integer value) {
            addCriterion("filter_id >", value, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("filter_id >=", value, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdLessThan(Integer value) {
            addCriterion("filter_id <", value, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdLessThanOrEqualTo(Integer value) {
            addCriterion("filter_id <=", value, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdIn(List<Integer> values) {
            addCriterion("filter_id in", values, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdNotIn(List<Integer> values) {
            addCriterion("filter_id not in", values, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdBetween(Integer value1, Integer value2) {
            addCriterion("filter_id between", value1, value2, "filterId");
            return (Criteria) this;
        }

        public Criteria andFilterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("filter_id not between", value1, value2, "filterId");
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