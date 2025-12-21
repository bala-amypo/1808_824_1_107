import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
public class Evidence
{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @ManytoOne
  @JoinColoumn(name="claim_id")
  private DamageClaim claim;
  private String evidenceType;
  private String fileUrl;
  private LocatDateTime uploadedAt;
  @PrePersist
  public void onUpdate()
   {
    this.uploadedAt = LocalDateTime.now();
    }

    String getid()
    {
      return id;
    }

  
}