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

     public Long getid()
    {
      return id;
    }
    public void setid(Long id)
    {
      this.id=id;
    }
    public DamageClaim getclaim()
    {
      return DamageClaim claim;
    }
    public void setclaim(DamageClaim claim)
    {
      this.claim=claim;
    }
    public String getevidence()
    {
      return evidenceType;
    }
    public void setevidence(String evidenceType)
    {
      this.evidenceType=evidenceType;
    }
    public String getfile()
    {
      return file
    }

  
}