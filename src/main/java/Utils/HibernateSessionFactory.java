package Utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory = buildSessionFactory();
    private static StandardServiceRegistry registry;

    public static SessionFactory buildSessionFactory() {
        // A SessionFactory is set up once for an application!
        if (sessionFactory == null) {
            try {
                // Create registry
                registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);
                /*// Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();
                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();*/
                Metadata metadata = sources.buildMetadata();
                sessionFactory = metadata.buildSessionFactory();

            }catch (Exception e){
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
                e.printStackTrace();
                throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
            }
        }
        return sessionFactory;
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
