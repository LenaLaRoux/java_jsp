package Entities;

import Utils.FieldViews;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contract", schema = "virtudb")
public class ContractEntity extends EntityModel {
    @FieldViews(inEditor = true, inSelector = true, title = "ID")
    private int id;
    @FieldViews(inEditor = true, inSelector = true, title = "Номер")
    private String number;
    @FieldViews(inEditor = true, inSelector = true, title = "Дата заключения")
    private Date createDate;
    @FieldViews(inEditor = true, inSelector = true, title = "Начало срока")
    private Date validFrom;
    @FieldViews(inEditor = true, inSelector = true, title = "Конец срока")
    private Date validTo;
    @FieldViews(inEditor = true, inSelector = false, title = "Страховая сумма")
    private Double insuranceFee;
    @FieldViews(inEditor = true, inSelector = true, title = "Премия")
    private Double insurance;
    @FieldViews(inEditor = true, inSelector = false, title = "Дата расчета")
    private Date insuranceDate;
    @FieldViews(inEditor = true, inSelector = false, title = "Комментарии")
    private String comment;
    @FieldViews(inEditor = true, inSelector = true, title = "Страхователь")
    private UserEntity userByHolderId;
    @FieldViews(inEditor = true, inSelector = false, title = "Недвижимость")
    private PropertyEntity propertyByPropertyId;
    @FieldViews(inEditor = true, inSelector = false, title = "Документ")
    private DocumentEntity documentByDocumentId;

    public ContractEntity (){
        this.setCreateDate(new Date());
        this.setValidFrom(new Date());
    }
    public ContractEntity (String number){
        this();
        this.setNumber(number);
    }


    @Id
    @Column(name = "id", nullable = false, length = 16)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number", nullable = true, length = 16)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "createDate", nullable = false, insertable = true, updatable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "validFrom", nullable = false, insertable = true, updatable = true)
    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "validTo", nullable = true, insertable = true, updatable = true)
    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    @Basic
    @Column(name = "insuranceFee", nullable = true, precision = 0)
    public Double getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(Double insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    @Basic
    @Column(name = "insurance", nullable = true, precision = 0)
    public Double getInsurance() {
        return insurance;
    }

    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "insuranceDate", nullable = true)
    public Date getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(Date insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = 100)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractEntity that = (ContractEntity) o;

        if (id != that.id) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (validFrom != null ? !validFrom.equals(that.validFrom) : that.validFrom != null) return false;
        if (validTo != null ? !validTo.equals(that.validTo) : that.validTo != null) return false;
        if (insuranceFee != null ? !insuranceFee.equals(that.insuranceFee) : that.insuranceFee != null) return false;
        if (insurance != null ? !insurance.equals(that.insurance) : that.insurance != null) return false;
        if (insuranceDate != null ? !insuranceDate.equals(that.insuranceDate) : that.insuranceDate != null)
            return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (validFrom != null ? validFrom.hashCode() : 0);
        result = 31 * result + (validTo != null ? validTo.hashCode() : 0);
        result = 31 * result + (insuranceFee != null ? insuranceFee.hashCode() : 0);
        result = 31 * result + (insurance != null ? insurance.hashCode() : 0);
        result = 31 * result + (insuranceDate != null ? insuranceDate.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "holderid", referencedColumnName = "id")
    public UserEntity getUserByHolderId() {
        return userByHolderId;
    }

    public void setUserByHolderId(UserEntity userByHolderId) {
        this.userByHolderId = userByHolderId;
    }

    @ManyToOne
    @JoinColumn(name = "propertyid", referencedColumnName = "id")
    public PropertyEntity getPropertyByPropertyId() {
        return propertyByPropertyId;
    }

    public void setPropertyByPropertyId(PropertyEntity propertyByPropertyId) {
        this.propertyByPropertyId = propertyByPropertyId;
    }

    @ManyToOne
    @JoinColumn(name = "documentid", referencedColumnName = "id")
    public DocumentEntity getDocumentByDocumentId() {
        return documentByDocumentId;
    }

    public void setDocumentByDocumentId(DocumentEntity documentByDocumentiId) {
        this.documentByDocumentId = documentByDocumentiId;
    }

    public String calcTitle(){
        return this.getNumber() + " from " + this.getCreateDate();
    }

    public void calcEnsurance () throws TariffException{
        if (propertyByPropertyId == null )
            throw new TariffException("Contract property value is notdefined");
        if (propertyByPropertyId.getType() == null)
            throw new TariffException("Contract property type is notdefined");
        if (propertyByPropertyId.getSquare() == null || propertyByPropertyId.getSquare() ==0d)
            throw new TariffException("Contract property square is notdefined");
        if (propertyByPropertyId.getBuildyear() == null)
            throw new TariffException("Contract property build year is notdefined");

        double coefPropType = TariffEntity.getCoefByPropertyType(propertyByPropertyId.getType());
        double coefSquare = TariffEntity.getCoefBySquare(propertyByPropertyId.getSquare());
        double coefBuildYear = TariffEntity.getCoefByYear(propertyByPropertyId.getBuildyear());

        long difference = Math.abs(getValidFrom().getTime() - getValidTo().getTime());
        long differenceDates = difference / (24 * 60 * 60 * 1000);

        double prize = (this.getInsuranceFee() / differenceDates) * coefPropType * coefBuildYear * coefSquare;
        this.setInsurance(Double.valueOf(Math.round(prize)));
    }
}
