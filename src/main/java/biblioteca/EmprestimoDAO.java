package biblioteca;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class EmprestimoDAO implements GenericDAO<Emprestimo> {

    @Override
    public void save(Emprestimo emprestimo) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(emprestimo);
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
    public Emprestimo findById(int id) {
        Session session = HibernateUtil.getSession();
        Emprestimo emprestimo = session.get(Emprestimo.class, id);
        session.close();
        return emprestimo;
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
    public List<Emprestimo> findAll() {
        Session session = HibernateUtil.getSession();
        List<Emprestimo> emprestimos = session.createQuery("FROM Emprestimo", Emprestimo.class).list();
        session.close();
        return emprestimos;
    }

    @Override
    public void update(Emprestimo emprestimo) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(emprestimo);
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
            Emprestimo emprestimo = session.get(Emprestimo.class, id);
            if (emprestimo != null) {
                session.delete(emprestimo);
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

