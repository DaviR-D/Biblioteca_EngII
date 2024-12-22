package biblioteca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AlunoDAO implements GenericDAO<Aluno> {

    @Override
    public void save(Aluno aluno) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(aluno);
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
    public Aluno findById(int id) {
        Session session = HibernateUtil.getSession();
        Aluno aluno = session.get(Aluno.class, id);
        session.close();
        return aluno;
    }

    @Override
    public List<Aluno> findAll() {
        Session session = HibernateUtil.getSession();
        List<Aluno> alunos = session.createQuery("from Aluno", Aluno.class).list();
        session.close();
        return alunos;
    }

    @Override
    public void update(Aluno aluno) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(aluno);
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
            Aluno aluno = session.get(Aluno.class, id);
            if (aluno != null) {
                session.delete(aluno);
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

    public boolean possuiDebitos(Aluno aluno) {
        // Lógica para verificar débitos
        return false;
    }
    
    public boolean possuiReservasPendentes(Aluno aluno) {
        // Lógica para verificar reservas
        return false;
    }
    
}

