import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;

public class DamageClaim
{
    @Id
    @GenerateValue(strategy=GeneratedType.Identity)
    private Long id;
    private String claimDescription;
    private String status;
    private Double score;


}
