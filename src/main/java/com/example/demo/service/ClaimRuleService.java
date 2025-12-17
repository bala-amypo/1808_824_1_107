import org.springframework.stereotype.Service;
import.java.util.Map;
import.java.util.Hashmap;
import.com.example.demo.model.ClaimRule;   

@service
public class ClaimRuleService
{
  Map<Float,ClaimRule>rules=new Hashmap<>();
  public ClaimRule addRule(ClaimRule rule)
  {
    rules.put(detail.getid(),detail);
    return detail;
  }
}