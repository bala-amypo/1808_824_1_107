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
  private Role.role
  

}