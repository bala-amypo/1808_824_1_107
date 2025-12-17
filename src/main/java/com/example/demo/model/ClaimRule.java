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

public Long getId()
{
    return id;
}
public void setId(Long id)
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
public Double getWeight()
{
    return weight;
}
public void setWeight(Double weight)
{
    this.weight=weight;
}
 public ClaimRule()
{}

 public ClaimRule(Long id,String ruleName,String conditionExpression,Double weight)
{
   this.id=id;
   this.ruleName=ruleName;
   this.conditionExpression=conditionExpression;
   this.weight=weight;
}
}
