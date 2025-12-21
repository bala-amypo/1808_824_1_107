import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
import jakarta.persistence.Table;

@Entity
@Table
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
      return fileUrl;
    }
    public void setfile()
    {
      this.fileUrl=fileUrl;
    }
    public LocalDateTime gettime()
    {
      return uploadedAt;
    }
    public void settime(LocalDateTime uploadedAt)
    {
      this.uploadedAt=uploadedAt;
    }
    public Evidence()
    {

    }
    public Evidence(Long id,DamageClaim claim,String evidenceType,String fileUrl,LocalDateTime uploadedAt)
    {
      this.id=id;
      this.claim=claim;
      this.
    }

  
}