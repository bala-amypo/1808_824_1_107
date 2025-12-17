import.jakarta.persistence.Entity;
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
  

}