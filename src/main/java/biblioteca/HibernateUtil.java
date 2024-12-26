package biblioteca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction; 

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            // Cria uma configuração do Hibernate
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")  // arquivo de configuração do Hibernate
                    .addAnnotatedClass(Aluno.class)  // Adiciona a classe Aluno
                    .addAnnotatedClass(Livro.class)  // Adiciona a classe Livro
                    .addAnnotatedClass(Emprestimo.class) // Adiciona a classe Emprestimo
                    .addAnnotatedClass(ItemEmprestimo.class) // Adiciona a classe ItemEmprestimo
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("Falha ao inicializar a SessionFactory");
        }
    }

    // Método para obter uma sessão nova e independente
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    // Método para fechar a SessionFactory
    public static void close() {
        sessionFactory.close();
    }

    public static void limparBanco() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            
            // Comando para apagar todas as tabelas
            session.createNativeQuery("DROP ALL OBJECTS").executeUpdate();
            
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

