package com.nnk.springboot.dto;

import java.util.Objects;

import com.nnk.springboot.model.RuleName;

public class RuleNameDTO {

	private int id;
	private String name;
	private String description;
	private String json;
	private String template;
	private String sqlStr;
	private String sqlPart;

	public RuleNameDTO() {
	}

	public RuleNameDTO(String name, String description, String json, String template, String sqlStr, String sqlPart) {
		this.name = name;
		this.description = description;
		this.json = json;
		this.template = template;
		this.sqlStr = sqlStr;
		this.sqlPart = sqlPart;
	}

	public RuleNameDTO(RuleName ruleName) {
		this.id = ruleName.getId();
		this.name = ruleName.getName();
		this.description = ruleName.getDescription();
		this.json = ruleName.getJson();
		this.template = ruleName.getTemplate();
		this.sqlStr = ruleName.getSqlStr();
		this.sqlPart = ruleName.getSqlPart();
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getSqlStr() {
		return sqlStr;
	}

	public void setSqlStr(String sqlStr) {
		this.sqlStr = sqlStr;
	}

	public String getSqlPart() {
		return sqlPart;
	}

	public void setSqlPart(String sqlPart) {
		this.sqlPart = sqlPart;
	}

	@Override
	public String toString() {
		return "RuleNameDTO [id=" + id + ", name=" + name + ", description=" + description + ", json=" + json
				+ ", template=" + template + ", sqlStr=" + sqlStr + ", sqlPart=" + sqlPart + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, json, name, sqlPart, sqlStr, template);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RuleNameDTO other = (RuleNameDTO) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(json, other.json) && Objects.equals(name, other.name)
				&& Objects.equals(sqlPart, other.sqlPart) && Objects.equals(sqlStr, other.sqlStr)
				&& Objects.equals(template, other.template);
	}

}
