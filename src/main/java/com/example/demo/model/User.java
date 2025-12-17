import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.columnn;

@Entity
public class User
 {
  @Id
  private Long id;
  private String name;
  @columnn(unique=true)
  private String email;
  private String password;
  private Role.role=Role.STAFF;
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

  

}