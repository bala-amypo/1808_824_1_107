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

public Long getid()
{
    return id;
}
public void setid(Long id)
{
    this.id=id;
}
public String getTrackNo()
{
  return trackingNumber;
}
public void setTrackNo(String trackingNumber)
{
    this.trackingNumber=trackingNumber;
}
public String getSenName()
{
    return senderName;
}
public void setSenName(String senderName)
{
    this.senderName=senderName;
}
public String getRecName()
{
    return receiverName;
}
public void setRecName(String receiverName)
{
    this.receiverName=receiverName;
}
public Double getweightKg()
{
    return weightKg;
}
public void setweightKg(Double weightKg)
{
    this.weightKg=weightKg;
}
public LocalDateTime getDate()
{
    return deliveredAt;
}
public void setDate(LocalDateTime deliveredAt)
{
    this.deliveredAt=deliveredAt;
}
Parcel()
{}
Parcel(Long id,String trackingNumber,String senderName,String receiverName,Double weightKg,LocalDateTime deliveredAt)
{
  this.id=id;
  this.trackingNumber=trackingNumber;
  this.senderName=senderName;
  this.receiverName=receiverName;
  this.weightKg=weightKg;
  this.deliveredAt=deliveredAt;

}
}
