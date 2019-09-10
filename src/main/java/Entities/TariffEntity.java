package Entities;

import Utils.FieldViews;
import Utils.Meta;
import Utils.Service;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tariff", schema = "virtudb")
public class TariffEntity extends EntityModel {
    @FieldViews(inEditor = true, inSelector = true, title = "ID")
    private int id;
    @FieldViews(inEditor = true, inSelector = true, title = "Построен с")
    private Date buildyearfrom;
    @FieldViews(inEditor = true, inSelector = true, title = "Построен до")
    private Date buildyearto;
    @FieldViews(inEditor = true, inSelector = true, title = "Площадь с")
    private Double squarefrom;
    @FieldViews(inEditor = true, inSelector = true, title = "Площадь до")
    private Double squareto;
    @FieldViews(inEditor = true, inSelector = true, title = "Тип недвижимости")
    private String propertytype;
    @FieldViews(inEditor = true, inSelector = true, title = "Коэффициент")
    private Double value;
    @FieldViews(inEditor = true, inSelector = true, title = "Тип")
    private TariffType type;
    @FieldViews(inEditor = true, inSelector = true, title = "Версия с")
    private Timestamp versionstart;
    @FieldViews(inEditor = true, inSelector = true, title = "Версия до")
    private Timestamp versionend;

    public TariffEntity (){
        this.setVersionstart(new java.sql.Timestamp (new Date().getTime()));
    }
    private TariffEntity (Double value){
        this();
        this.setValue(value==null? 0 : value);
    }

    public TariffEntity (Date buildyearfrom, Date buildYearTo, Double value){
        this(value);
        this.setBuildyearfrom(buildyearfrom);
        this.setBuildyearto(buildYearTo);
        this.setType(TariffType.byyear);
    }
    public TariffEntity (String  propertyTpe, Double value){
        this(value);
        this.setPropertytype(propertyTpe);
        this.setType(TariffType.bytype);
    }
    public TariffEntity (Double squarefrom, Double squareto, Double value){
        this(value);
        this.setSquarefrom(squarefrom);
        this.setSquareto(squareto);
        this.setType(TariffType.bysquare);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "buildyearfrom", nullable = true)
    public Date getBuildyearfrom() {
        return buildyearfrom;
    }
    public void setBuildyearfrom(Date buildyearfrom) {
        this.buildyearfrom = buildyearfrom;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "buildyearto", nullable = true)
    public Date getBuildyearto() {
        return buildyearto;
    }
    public void setBuildyearto(Date buildyearto) {
        this.buildyearto = buildyearto;
    }

    @Basic
    @Column(name = "squarefrom", nullable = true, precision = 0)
    public Double getSquarefrom() {
        return squarefrom;
    }
    public void setSquarefrom(Double squarefrom) {
        this.squarefrom = squarefrom;
    }

    @Basic
    @Column(name = "squareto", nullable = true, precision = 0)
    public Double getSquareto() {
        return squareto;
    }
    public void setSquareto(Double squareto) {
        this.squareto = squareto;
    }

    @Basic
    @Column(name = "propertytype", nullable = true, length = 16)
    public String getPropertytype() {
        return propertytype;
    }
    public void setPropertytype(String propertytype) {
        this.propertytype = propertytype;
    }

    @Basic
    @Column(name = "value", nullable = false, precision = 0)
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = true, length = 10)
    public TariffType getType() {
        return type;
    }
    public void setType(TariffType type) {
        this.type = type;
    }

    @Column(name = "versionstart", nullable = true)
    public Timestamp getVersionstart() {
        return versionstart;
    }
    public void setVersionstart(Timestamp versionstart) {
        this.versionstart = versionstart;
    }

    @Column(name = "versionend", nullable = true)
    public Timestamp getVersionend() {
        return versionend;
    }
    public void setVersionend(Timestamp versionend) {
        this.versionend = versionend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TariffEntity that = (TariffEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.value, value) != 0) return false;
        if (buildyearfrom != null ? !buildyearfrom.equals(that.buildyearfrom) : that.buildyearfrom != null)
            return false;
        if (buildyearto != null ? !buildyearto.equals(that.buildyearto) : that.buildyearto != null) return false;
        if (squarefrom != null ? !squarefrom.equals(that.squarefrom) : that.squarefrom != null) return false;
        if (squareto != null ? !squareto.equals(that.squareto) : that.squareto != null) return false;
        if (propertytype != null ? !propertytype.equals(that.propertytype) : that.propertytype != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (versionstart != null ? !versionstart.equals(that.versionstart) : that.versionstart != null) return false;
        if (versionend != null ? !versionend.equals(that.versionend) : that.versionend != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (buildyearfrom != null ? buildyearfrom.hashCode() : 0);
        result = 31 * result + (buildyearto != null ? buildyearto.hashCode() : 0);
        result = 31 * result + (squarefrom != null ? squarefrom.hashCode() : 0);
        result = 31 * result + (squareto != null ? squareto.hashCode() : 0);
        result = 31 * result + (propertytype != null ? propertytype.hashCode() : 0);
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (versionstart != null ? versionstart.hashCode() : 0);
        result = 31 * result + (versionend != null ? versionend.hashCode() : 0);
        return result;
    }

    public void close (){
        this.setVersionend(new java.sql.Timestamp(new Date().getTime()));
    }
    public void reopen (){
        this.setVersionend(null);
    }

    @Transient
    public boolean isActive () {
        return this.getVersionend() != null;
    }

    @Override
    public String calcTitle () {
        return this.getType() + " from " + this.getVersionstart();
    }

    private static String sqlSelect (TariffType tType, Double square, Date buildDate, String propertyType){
        StringBuilder sb = new StringBuilder();
        sb.append(" select value from TariffEntity ");
        sb.append(" where type = '" + tType+ "' ");

        switch (tType) {
            case bysquare:{
                sb.append(" and squarefrom <= '" + square + "' ");
                sb.append(" and squareto >= '" + square + "' ");
                break;
            }
            case byyear:
                sb.append(" and buildyearfrom <= '" + buildDate+ "' ");
                sb.append(" and buildyearto >= '" + buildDate+ "' ");
                break;
            case bytype:
                sb.append(" and propertytype = '" + propertyType+ "' ");
                break;
        };

        sb.append(" and versionend is null and versionstart < now()" );
        sb.append(" order by versionstart desc ");
        //sb.append(" limit 1");

        return sb.toString();
    }

    public static double getCoefByPropertyType(String propertyType) throws TariffException {
        String sql = sqlSelect (TariffType.bytype, null, null, propertyType);
        List<Double> res = Service.<Double>executeStatementSelect(sql);

        if (res.isEmpty())
            throw new TariffException("There is no active tariff for property type");

        return res.get(0);
    }

    public static double getCoefBySquare(Double square) throws TariffException{
        String sql = sqlSelect (TariffType.bysquare, square, null, null);
        List<Double> res = Service.<Double>executeStatementSelect(sql);

        if (res.isEmpty())
            throw new TariffException("There is no active tariff for property square");

        return res.get(0);
    }

    public static double getCoefByYear(Date year) throws TariffException{
        String sql = sqlSelect (TariffType.byyear, null, year, null);
        List<Double> res = Service.<Double>executeStatementSelect(sql);

        if (res.isEmpty())
            throw new TariffException("There is no active tariff for property build year");

        return res.get(0);
    }

       /*public String toHtml(){
        StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"editor\">");
        sb.append("<form id=\"frmId\">");
        sb.append("<fieldset form=\"frmId\">");
        sb.append("<legend>Тариф</legend>");
        sb.append("<div class=\"prop-wrapper\">");
        sb.append(" <div>");
        for (Meta.Column col : this.getColumns()){
            sb.append(col.toHtml());
        }
        sb.append(" </fieldset>");
        sb.append("</form>");
        sb.append("</div>");

        return sb.toString();
    }*/

}
