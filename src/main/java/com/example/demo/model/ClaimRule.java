package com.example.

import jakarta.persistence.id;
import jakarta.persistence.Entity;
import jakarta

@Entity
public class ClaimRule
{   @Id
    @
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
