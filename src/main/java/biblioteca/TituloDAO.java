package biblioteca;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TituloDAO implements GenericDAO<Titulo> {

    @Override
    public void save(Titulo titulo) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(titulo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Titulo findById(int id) {
        Session session = HibernateUtil.getSession();
        Titulo titulo = session.get(Titulo.class, id);
        session.close();
        return titulo;
    }

    @Override
    public List<Titulo> findAll() {
        Session session = HibernateUtil.getSession();
        List<Titulo> titulos = session.createQuery("from Titulo", Titulo.class).list();
        session.close();
        return titulos;
    }

    @Override
    public void update(Titulo titulo) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(titulo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(int id) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Titulo titulo = session.get(Titulo.class, id);
            if (titulo != null) {
                session.delete(titulo);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
