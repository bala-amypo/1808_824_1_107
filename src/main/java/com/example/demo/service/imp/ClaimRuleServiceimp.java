import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.ClaimRule;
import com.example.demo.repository.ClaimRuleRepository;
import com.example.demo.service.ClaimRuleService;

@Service
public class ClaimRuleServiceimp implements ClaimRuleService{
    @Autowired
    ClaimRuleRepository crr;
    public ClaimRule addRule(ClaimRule rule)
    {
        crr.
    }

    
}