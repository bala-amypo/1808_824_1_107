import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;
import com.example.demo.model.Parcel;
import com.example.demo.model.ClaimRule;
import java.time.
public class DamageClaim
{
    @Id
    @GenerateValue(strategy=GeneratedType.Identity)
    private Long id;
    @ManyToOne
    @joinColumn(name="parcel_id")
    private Parcel parcel;
    private LocalDateTime filedAt;
    private String claimDescription;
    private String status;
    private Double score;

public Long getId()
{
    return id;
}
public void setid(Long id)
{
    this.id=id;
}
public String getClaimDes()
{
    return claimDes;
}
}
