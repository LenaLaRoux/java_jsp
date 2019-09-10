package Entities;

import Utils.FieldViews;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "user", schema = "virtudb")
public class UserEntity extends EntityModel {
    @FieldViews(inEditor = true, inSelector = true, title = "ID")
    private int id;
    @FieldViews(inEditor = true, inSelector = true, title = "ФИО")
    private String name;
    @FieldViews(inEditor = true, inSelector = true, title = "Дата рождения")
    private Date birthdate;
    private Collection<ContractEntity> contractsById;
    private Collection<DocumentEntity> documentsById;
    private Collection<PropertyEntity> propertiesById;

    public UserEntity (){
    }

    public UserEntity (String name, java.util.Date birthDate){
        this();
        this.setName(name);
        this.setBirthdate(new Date());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 16)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birthdate", nullable = true)
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (birthdate != null ? !birthdate.equals(that.birthdate) : that.birthdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        return result;
    }
    /*@OneToMany(mappedBy = "userByHolderId")
    public Collection<ContractEntity> getContractsById() {
        return contractsById;
    }

    public void setContractsById(Collection<ContractEntity> contractsById) {
        this.contractsById = contractsById;
    }
*/
    /*@OneToMany(mappedBy = "userByUserid")
    public Collection<DocumentEntity> getDocumentsById() {
        return documentsById;
    }

    public void setDocumentsById(Collection<DocumentEntity> documentsById) {
        this.documentsById = documentsById;
    }*/
/*
    @OneToMany(mappedBy = "userByOwnerid")
    public Collection<PropertyEntity> getPropertiesById() {
        return propertiesById;
    }

    public void setPropertiesById(Collection<PropertyEntity> propertiesById) {
        this.propertiesById = propertiesById;
    }

 */
    @Override
    public String calcTitle(){
        return this.name;
    }
}
