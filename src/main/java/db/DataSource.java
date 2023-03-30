package db;

import entity.Resident;
import entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DataSource {

    public SessionFactory config(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Resident.class);
        configuration.addAnnotatedClass(Vehicle.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }

    public void insertResidentDetailsAndVehicleInfo(SessionFactory sessionFactory, Resident resident, Vehicle vehicle){

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            resident.setVehicle(vehicle);
            vehicle.setResident(resident);
            session.save(vehicle);

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Error Message ::" + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
