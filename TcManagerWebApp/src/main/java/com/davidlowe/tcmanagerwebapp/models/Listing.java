package com.davidlowe.tcmanagerwebapp.models;


import java.util.List;
import java.util.Map;
import java.util.Objects;


public class Listing
{

  private int id;
  private Address address;
  private PropertyType propertyType;
  private ListingStatus listingStatus;
  private DocumentComplianceStatus documentComplianceStatus;
  private DataInputStatus dataInputStatus;
  private double price;
  private java.sql.Date receivedDate;
  private java.sql.Date listDate;
  private java.sql.Date expirationDate;

  private List<Person> sellers;
  private List<Realtor> sellerAgents;
  private List<Person> buyers;
  private List<Realtor> buyerAgents;
  private Map<User, String> notes;

  private User creatorUser;
  private java.sql.Timestamp creationDate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }


  public PropertyType getPropertyType() {
    return propertyType;
  }

  public void setPropertyType(PropertyType propertyType) {
    this.propertyType = propertyType;
  }


  public ListingStatus getListingStatus() {
    return listingStatus;
  }

  public void setListingStatus(ListingStatus listingStatus) {
    this.listingStatus = listingStatus;
  }


  public DocumentComplianceStatus getDocumentComplianceStatus() {
    return documentComplianceStatus;
  }

  public void setDocumentComplianceStatus(DocumentComplianceStatus documentComplianceStatus) {
    this.documentComplianceStatus = documentComplianceStatus;
  }


  public DataInputStatus getDataInputStatus() {
    return dataInputStatus;
  }

  public void setDataInputStatus(DataInputStatus dataInputStatus) {
    this.dataInputStatus = dataInputStatus;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public java.sql.Date getReceivedDate() {
    return receivedDate;
  }

  public void setReceivedDate(java.sql.Date receivedDate) {
    this.receivedDate = receivedDate;
  }


  public java.sql.Date getListDate() {
    return listDate;
  }

  public void setListDate(java.sql.Date listDate) {
    this.listDate = listDate;
  }


  public java.sql.Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(java.sql.Date expirationDate) {
    this.expirationDate = expirationDate;
  }


  public User getCreatorUser() {
    return creatorUser;
  }

  public void setCreatorUser(User creatorUser) {
    this.creatorUser = creatorUser;
  }


  public java.sql.Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(java.sql.Timestamp creationDate) {
    this.creationDate = creationDate;
  }


  public List<Person> getSellers()
  {
    return sellers;
  }

  public void setSellers(List<Person> sellers)
  {
    this.sellers = sellers;
  }

  public List<Realtor> getSellerAgents()
  {
    return sellerAgents;
  }

  public void setSellerAgents(List<Realtor> sellerAgents)
  {
    this.sellerAgents = sellerAgents;
  }


  public List<Person> getBuyers()
  {
    return buyers;
  }

  public void setBuyers(List<Person> buyers)
  {
    this.buyers = buyers;
  }

  public List<Realtor> getBuyerAgents()
  {
    return buyerAgents;
  }

  public void setBuyerAgents(List<Realtor> buyerAgents)
  {
    this.buyerAgents = buyerAgents;
  }

  public Map<User, String> getNotes()
  {
    return notes;
  }

  public void setNotes(Map<User, String> notes)
  {
    this.notes = notes;
  }


  @Override
  public String toString()
  {
    return "Listing{" +
            "listingId=" + id +
            ", address=" + address +
            ", propertyType=" + propertyType +
            ", listingStatus=" + listingStatus +
            ", documentComplianceStatus=" + documentComplianceStatus +
            ", dataInputStatus=" + dataInputStatus +
            ", price=" + price +
            ", receivedDate=" + receivedDate +
            ", listDate=" + listDate +
            ", expirationDate=" + expirationDate +
            ", creatorUser=" + creatorUser +
            ", creationDate=" + creationDate +
            ", sellers=" + sellers +
            ", sellerAgents=" + sellerAgents +
            ", buyers=" + buyers +
            ", buyerAgents=" + buyerAgents +
            ", notes=" + notes +
            '}';
  }


  @Override
  public boolean equals(Object o)
  {
    if (this == o)
    {
      return true;
    }
    if (o == null || getClass() != o.getClass())
    {
      return false;
    }

    Listing listing = (Listing) o;

    if (id != listing.id)
    {
      return false;
    }
    if (Double.compare(listing.price, price) != 0)
    {
      return false;
    }
    if (!Objects.equals(address, listing.address))
    {
      return false;
    }
    if (!Objects.equals(propertyType, listing.propertyType))
    {
      return false;
    }
    if (!Objects.equals(listingStatus, listing.listingStatus))
    {
      return false;
    }
    if (!Objects.equals(documentComplianceStatus, listing.documentComplianceStatus))
    {
      return false;
    }
    if (!Objects.equals(dataInputStatus, listing.dataInputStatus))
    {
      return false;
    }
    if (!Objects.equals(receivedDate, listing.receivedDate))
    {
      return false;
    }
    if (!Objects.equals(listDate, listing.listDate))
    {
      return false;
    }
    if (!Objects.equals(expirationDate, listing.expirationDate))
    {
      return false;
    }
    if (!Objects.equals(creatorUser, listing.creatorUser))
    {
      return false;
    }
    if (!Objects.equals(creationDate, listing.creationDate))
    {
      return false;
    }
    if (!Objects.equals(sellers, listing.sellers))
    {
      return false;
    }
    if (!Objects.equals(sellerAgents, listing.sellerAgents))
    {
      return false;
    }
    if (!Objects.equals(buyers, listing.buyers))
    {
      return false;
    }
    if (!Objects.equals(buyerAgents, listing.buyerAgents))
    {
      return false;
    }
    return Objects.equals(notes, listing.notes);
  }

  @Override
  public int hashCode()
  {
    int result;
    long temp;
    result = (int) (id ^ (id >>> 32));
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (propertyType != null ? propertyType.hashCode() : 0);
    result = 31 * result + (listingStatus != null ? listingStatus.hashCode() : 0);
    result = 31 * result + (documentComplianceStatus != null ? documentComplianceStatus.hashCode() : 0);
    result = 31 * result + (dataInputStatus != null ? dataInputStatus.hashCode() : 0);
    temp = Double.doubleToLongBits(price);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (receivedDate != null ? receivedDate.hashCode() : 0);
    result = 31 * result + (listDate != null ? listDate.hashCode() : 0);
    result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
    result = 31 * result + (creatorUser != null ? creatorUser.hashCode() : 0);
    result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
    result = 31 * result + (sellers != null ? sellers.hashCode() : 0);
    result = 31 * result + (sellerAgents != null ? sellerAgents.hashCode() : 0);
    result = 31 * result + (buyers != null ? buyers.hashCode() : 0);
    result = 31 * result + (buyerAgents != null ? buyerAgents.hashCode() : 0);
    result = 31 * result + (notes != null ? notes.hashCode() : 0);
    return result;
  }
}
