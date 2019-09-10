package Utils;

import Entities.EntityModel;
import Entities.IEntity;
import EntityGroups.ModelGroup;
import Utils.ColumnEditor.ColumnEditor;
import Utils.ColumnEditor.ValEditorFactory;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metamodel.spi.MetamodelImplementor;
import org.hibernate.service.NullServiceException;

import javax.persistence.metamodel.Metamodel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public  class Meta {
    protected Class clazz;
    private ColumnsFilter columnsFilter = null;
    public static class ColumnsFilter implements Iterable<Column>{
        private List<Column> list = new ArrayList<Column>();
        public Iterator<Column> iterator() {
            return list.iterator();
        }
        public void add(Column c) {
            list.add(c);
        }
        public List<Column> getList(){
            return list;
        }

    }
    public static class Columns implements Iterable<Column>{
        private List<Column> list = new ArrayList<Column>();
        public Iterator<Column> iterator() {

            return (Iterator<Column>) list.iterator();
        }
        public void add(Column c) {
            list.add(c);
        }
        public List<Column> getList(){
            return list;
        }

    }
    public static class Column {
        private String name;
        private Object value = null;
        private String title;
        private boolean isRequired = false;
        private Class valType = null;
        private ColumnEditor editor = null;

        public Column (String name, Object value){
            this.name = name;
            this.value = value;
        }
        public Column (String name, String title){
            this.name = name;
            this.title = title;
        }
        public String getName(){
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isRequired() {
            return isRequired;
        }

        public void setRequired(boolean required) {
            isRequired = required;
        }

        public Class getValType() {
            return valType;
        }

        public void setValType(Class valType) {
            this.valType = valType;
        }

        public ColumnEditor getEditor(){
            if (editor == null)
                editor = ValEditorFactory.getInstance(this);
            return editor;
        }

        public String toHtml(){
            return getEditor().toHtml();
        }
        public String valueToString(){
            return getEditor().toString();
        }
    }


    public class EntityMeta {

        private IEntity entity;
        private Columns columns = null;
        private ColumnsFilter columnsFilter = null;

        public EntityMeta(IEntity e) {
            entity = e;
            clazz = e.getClass();
        }

        /*public Columns getColumns (){
            if (columns == null)
                initColumns();
            return columns;
        }*/
        public void setColumnFilter (ColumnsFilter filter){
            this.columnsFilter = filter;
        }
        public ColumnsFilter getColumnsFilter(){
            return columnsFilter;
        }
        /*ColumnsFilter getComputedColumnsFilter(){
            //возвращает групповой фильтр для текущей entity
            ModelGroup group = ((EntityModel)entity).getGroupModel();
            if (group != null && group.getColumnsFilter() !=null){
                return group.getColumnsFilter();
            }else{
                //если для entity не определена группа, то возращаем фильтр самой entity
                //фильтр самой  entity может быть null, если он явно не задан программно
                return this.getColumnsFilter();
            }
        }*/

        public String getEntityName() {
            javax.persistence.Entity e = entity.getClass().getAnnotation(javax.persistence.Entity.class);
            return  e.name();
        }

        public String getTableName() {
            javax.persistence.Table t = entity.getClass().getAnnotation(javax.persistence.Table.class);
            return t.name();
        }

        /*protected void initColumns (){
            Session session = HibernateSessionFactory.getSessionFactory().openSession();

            Metamodel metaModel = session.getMetamodel();
            MetamodelImplementor metaImpl = (MetamodelImplementor) metaModel;
            ClassMetadata classMetadata = (ClassMetadata) metaImpl.entityPersister(clazz);

//            ColumnsFilter columnsFilter= getComputedColumnsFilter();
//            if (columnsFilter!= null){
//                columns = selectorColumns(classMetadata, columnsFilter, entity);
//            }else{
//                columns = initColumns(classMetadata,entity);
//            }
//
//            session.close();
            ModelGroup group = ((EntityModel)entity).getGroupModel();
            if (group != null && group.getColumnsFilter() !=null){
                columns = selectorColumns(session, classMetadata, group.getColumnsFilter(), entity);
            }else{
                columns = editorColumns(classMetadata, entity);
            }
        }*/
        public Columns selectorColumns (/*Session session, ClassMetadata classMetadata, ColumnsFilter columnsFilter, IEntity entity*/){
            Session session = HibernateSessionFactory.getSessionFactory().openSession();

            Metamodel metaModel = session.getMetamodel();
            MetamodelImplementor metaImpl = (MetamodelImplementor) metaModel;
            ClassMetadata classMetadata = (ClassMetadata) metaImpl.entityPersister(clazz);

            Columns columns = new Columns();
            ModelGroup group = ((EntityModel)entity).getGroupModel();
            if (group == null ){
                return null;
            }

            group.getColumnsFilter().forEach((x)->{
                Column c = null;
                try {
                    Object val;
                    if (classMetadata.getIdentifierPropertyName().equals(x.getName()))
                        val = classMetadata.getIdentifier(entity, (SharedSessionContractImplementor) session);
                    else
                        val = classMetadata.getPropertyValue(entity, x.name);
                    c = new Column(x.name, val);
                    Field f = clazz.getDeclaredField(x.name);
                    c.setValType(f.getType());


                }catch (NoSuchFieldException e){
                    c = new Column(x.name, "data error");
                    c.setValType(String.class);
                }catch (NullPointerException ee){
                    c = new Column(x.name, x.getName()+": "+ee.getMessage());
                    c.setValType(String.class);
                } finally {
                    columns.add(c);
                }
            });
            return  columns;
        }
        private boolean searchInFilter (String fieldName){
            if (this.getColumnsFilter() == null)
                return true;

            boolean found = false;
            for (Column x : this.getColumnsFilter()){
                if (x.name.equals(fieldName)) {
                    found = true;
                    break;
                }
            }
            return found;
        }
        public Columns editorColumns(/*ClassMetadata classMetadata, IEntity entity*/) {
            Session session = HibernateSessionFactory.getSessionFactory().openSession();

            Metamodel metaModel = session.getMetamodel();
            MetamodelImplementor metaImpl = (MetamodelImplementor) metaModel;
            ClassMetadata classMetadata = (ClassMetadata) metaImpl.entityPersister(clazz);
            /*String[] propNames = classMetadata.getPropertyNames();

            Columns columns = new Columns();

            for (String pName : propNames) {
                Column c = new Column(pName, classMetadata.getPropertyValue(entity, pName));
                columns.add(c);
            }*/
            Columns columns = new Columns();

            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                if (!field.isAnnotationPresent(FieldViews.class))
                    continue;
                if (!searchInFilter(field.getName())){
                    continue;
                }
                FieldViews views = field.getAnnotation(FieldViews.class);
                if (!views.inEditor())
                    continue;

                Column c = new Column(field.getName(), views.title());
                c.setValType(field.getType());

                if (field.isAnnotationPresent(javax.persistence.Column.class)) {
                    javax.persistence.Column nullValue = field.getAnnotation(javax.persistence.Column.class);
                    c.setRequired(!nullValue.nullable());
                }
                if (classMetadata.getIdentifierPropertyName().equals(field.getName()))
                    c.setValue(classMetadata.getIdentifier(entity, (SharedSessionContractImplementor) session));
                else
                    c.setValue(classMetadata.getPropertyValue(entity, field.getName()));

                columns.add(c);
            }

            return columns;
        }
    }

    public class GroupMeta {

        public GroupMeta(Class cl){
            clazz = cl;
        }

        public void setColumnFilter(ColumnsFilter filter) {
            columnsFilter = filter;
        }

        public ColumnsFilter getColumnFilter() {
            if (columnsFilter == null)
                initSelectorColumns();
            return columnsFilter;
        }

        private void initSelectorColumns() {

            final Field[] fields = clazz.getDeclaredFields();
            final ColumnsFilter cols = new ColumnsFilter();

            for (Field field : fields) {
                if (!field.isAnnotationPresent(FieldViews.class))
                    continue;
                FieldViews views = field.getAnnotation(FieldViews.class);
                if (!views.inSelector())
                    continue;

                cols.add(new Column(field.getName(), views.title()));
            }
            columnsFilter = cols;
        }
    }

}
