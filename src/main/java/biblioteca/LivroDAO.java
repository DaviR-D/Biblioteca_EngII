package biblioteca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class LivroDAO implements GenericDAO<Livro> {

    @Override
    public void save(Livro livro) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(livro);
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
    public Livro findById(int id) {
        Session session = HibernateUtil.getSession();
        Livro livro = session.get(Livro.class, id);
        session.close();
        return livro;
    }

    public Livro findByISBN(String isbn) {
        Session session = HibernateUtil.getSession();
        Livro livro = null;
        try {
            Query<Livro> query = session.createQuery("FROM Livro WHERE isbn = :isbn", Livro.class);
            query.setParameter("isbn", isbn);
            livro = query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return livro;
    }
    

    @Override
    public List<Livro> findAll() {
        Session session = HibernateUtil.getSession();
        List<Livro> livros = session.createQuery("from Livro", Livro.class).list();
        session.close();
        return livros;
    }

    @Override
    public void update(Livro livro) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(livro);
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
            Livro livro = session.get(Livro.class, id);
            if (livro != null) {
                session.delete(livro);
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

