package Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "document", schema = "virtudb")
public class DocumentEntity extends EntityModel {
    private int id;
    private String type;
    private String number;
    private String series;
    private Date date;
    private Status status;
   /* @OneToMany(mappedBy = "documentByDocumentId")
    private Collection<ContractEntity> contractsByid;*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
    private UserEntity userByUserid;

    public DocumentEntity(){
        this.setStatus(Status.active);
    }
    public DocumentEntity (String number, String series, java.util.Date docDate){
        this();
        this.setNumber(number);
        this.setSeries(series);
        if (docDate != null)
            this.setDate(docDate);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 16)
    public int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 16)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "number", nullable = true, length = 16)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "series", nullable = true, length = 16)
    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }


/*
    public Collection<ContractEntity> getContractsByid() {
        return this.contractsByid;
    }*
    public void setContractsByid(Collection<ContractEntity> contractsById) {
        this.contractsByid = contractsById;
    }
*/
    public UserEntity getUserByUserid() {
        return userByUserid;
    }
    public void setUserByUserid(UserEntity userByUserid) {
        this.userByUserid = userByUserid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentEntity that = (DocumentEntity) o;

        if (id != that.id) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (series != null ? !series.equals(that.series) : that.series != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (series != null ? series.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String calcTitle (){
        return this.getSeries() + " " + this.getNumber();
    }
}
