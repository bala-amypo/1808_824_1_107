import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;
import com.example.demo.model.parcel;
public class DamageClaim
{
    @Id
    @GenerateValue(strategy=GeneratedType.Identity)
    private Long id;
    @ManyToOne
    @joinColumn(name="parcel_id")
    private Parcel parcel;
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
