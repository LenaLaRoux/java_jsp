package Utils;

import Entities.EntityModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class ServiceGroup implements IServiceGroup {
    private Class<? extends EntityModel> clazz;

    public ServiceGroup(Class cl){
        clazz = cl;
    }

    public <T extends EntityModel> List<T> reread() {
        String q = "From "+clazz.getName() +" ";

        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<T> users = (List<T>) session.createQuery(q).list();
        session.close();
        return users;
    }

    public <T  extends EntityModel> T findById( int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        T e = (T)session.get(clazz,id);
        session.close();
        return  e;
    }
}
