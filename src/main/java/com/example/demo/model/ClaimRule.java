import.jakarta.persistence.id;
import.jakarta.persistence.Entity;
public class ClaimRule
{   @Id
    private Long id;
    private String ruleName;
    private String conditionExpression;
    private Double weight;
}