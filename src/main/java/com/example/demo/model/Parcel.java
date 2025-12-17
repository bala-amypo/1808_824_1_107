import.jakarta.persistence.Entity;
import.jakarta.persistence.id;
import.jakarta.persistence.columnn;
@Entity
public class Parcel
{
  @id
  private Long id;
  @columnn(unique=true)
  private String trackingNumber;
  private String senderName;
  private String receiverName;
  private Double weightKg;
  private LocalDateTime deliveredAt;

}
public Long getid()
{
    return id;
}
public Long setid(Long)
{
    this.
}