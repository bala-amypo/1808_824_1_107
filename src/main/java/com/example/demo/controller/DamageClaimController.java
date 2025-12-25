@RestController
@RequestMapping("/api/claims")
public class DamageClaimController {

    private final DamageClaimRepository repo;
    private final ClaimRuleRepository ruleRepo;

    public DamageClaimController(DamageClaimRepository repo, ClaimRuleRepository ruleRepo) {
        this.repo = repo;
        this.ruleRepo = ruleRepo;
    }

    @PutMapping("/evaluate/{id}")
    public DamageClaim evaluate(@PathVariable Long id) {
        DamageClaim claim = repo.findById(id).orElseThrow();
        double score = RuleEngineUtil.evaluate(
                claim.getDescription(),
                ruleRepo.findAll()
        );
        claim.setScore(score);
        claim.setStatus(score > 5 ? "APPROVED" : "SUSPICIOUS");
        return repo.save(claim);
    }
}
