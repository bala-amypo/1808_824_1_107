package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class User
 {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Column(unique=true)
  private String email;
  private String password;
  private Role role=Role.AGENT;
  public enum Role{
    ADMIN,
    AGENT
  }
  public Long getid()
  {
    return id;
  }
  public void setid(Long id)
  {
    this.id=id;
  }
  public String getname()
  {
    return name;
  }
  public void setname(String name)
  {
    this.name=name;
  }
  public String getmail()
  {
    return email;
  }
  public void setmail()
  {
    this.email=email;
  }
  public String getpass()
  {
    return password;
  }
  public void setpass()
  {
    this.password=password;
  }
  public Role getRole()
  {
    return role;
  }
  public void  setRole( Role roll)
  {
    this.role=role;
  }
  
  public User(Long id,String name,String email,String password,Role role)
  {
    this.id=id;
    this.name=name;
    this.email=email;
    this.password=password;
    this.role=role;
  }
  public User(){}

}