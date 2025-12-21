import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Evidence
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @ManytoOne
  @JoinColoumn(name="claim_id
  
}