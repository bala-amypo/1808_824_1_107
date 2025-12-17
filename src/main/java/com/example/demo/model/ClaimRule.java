package com.example.demo.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class ClaimRule
{   @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    private Long id;
    private String ruleName;
    private String conditionExpression;
    private Double weight;

public Long getid()
{
    return id;
}
public void setid(Long id)
{
    this.id=id;
}
public String getRname()
{
    return ruleName;
}
public  void setRname(String ruleName)
{
    this.ruleName=ruleName;
}
public  String getCondEx()
{
    return conditionExpression;
}
public void  setCondEx(String conditionExpression)
{
    this.conditionExpression=conditionExpression;
}
public Double getweight()
{
    return weight;
}
public void setweight(Double weight)
{
    this.weight=weight;
}
ClaimRule()
{}

ClaimRule(Long id,String ruleName,String conditionExpression,Double weight)
{
   this.id=id;
   this.ruleName=ruleName;
   this.conditionExpression=conditionExpression;
   this.weight=weight;
}
}
