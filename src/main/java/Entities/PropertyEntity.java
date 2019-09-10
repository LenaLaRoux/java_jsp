package Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "property", schema = "virtudb")
public class PropertyEntity extends EntityModel {
    private int id;
    private String type;
    private Date buildyear;
    private Double square;
    private Collection<ContractEntity> contractsById;
    private UserEntity userByOwnerid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Temporal(TemporalType.DATE)
    @Column(name = "buildyear", nullable = true)
    public Date getBuildyear() {
        return buildyear;
    }
    public void setBuildyear(Date buildyear) {
        this.buildyear = buildyear;
    }

    @Basic
    @Column(name = "square", nullable = true, precision = 0)
    public Double getSquare() {
        return square;
    }
    public void setSquare(Double square) {
        this.square = square;
    }

    /*@OneToMany(mappedBy = "propertyByPropertyId")
    public Collection<ContractEntity> getContractsById() {
        return contractsById;
    }
    private void setContractsById(Collection<ContractEntity> contractsById) {
        this.contractsById = contractsById;
    }
*/
    @ManyToOne
    @JoinColumn(name = "ownerid", referencedColumnName = "id")
    public UserEntity getUserByOwnerid() {
        return userByOwnerid;
    }
    public void setUserByOwnerid(UserEntity userByOwnerid) {
        this.userByOwnerid = userByOwnerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyEntity that = (PropertyEntity) o;

        if (id != that.id) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (buildyear != null ? !buildyear.equals(that.buildyear) : that.buildyear != null) return false;
        if (square != null ? !square.equals(that.square) : that.square != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (buildyear != null ? buildyear.hashCode() : 0);
        result = 31 * result + (square != null ? square.hashCode() : 0);
        return result;
    }
}
