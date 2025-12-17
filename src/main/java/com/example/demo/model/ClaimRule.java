import.jakarta.persistence.id;
import.jakarta.persstence.Entity;

@Entity
public class ClaimRule
{   @Id
    private Long id;
    private String ruleName;
    private String conditionExpression;
    private Double weight;

public Long getid()
{
    return id;
}
public void setid(Long id)
{
    this.id=id;
}
public String getRname()
{
    return ruleName;
}
public  void setRname(String ruleName)
{
    this.ruleName=ruleName;
}
public  String getCondEx()
{
    return conditionExpression;
}
public void  setCondEx(String conditionExpression)
{
    this.conditionExpression=conditionExpression;
}
public Double getweight()
{
    return weight;
}
public void setweight(Double weight)
{
    this.weight=weight;
}
ClaimRule()
}
