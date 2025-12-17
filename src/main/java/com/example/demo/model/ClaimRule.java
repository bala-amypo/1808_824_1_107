import.jakarta.persistence.id;
import.jakarta.persstence.Entity;

@Entity
public class ClaimRule
{   @Id
    private Long id;
    private String ruleName;
    private String conditionExpression;
    private Double weight;
}
public getid()
{
    return id;
}
public setid(long id)
{
    this.id=id;
}
public getRname()
{
    return ruleName;
}
public setRname(String ruleName)
{
    this.ruleName=ruleName;
}
public getCondE()
{
    return conditionExpression;
}
