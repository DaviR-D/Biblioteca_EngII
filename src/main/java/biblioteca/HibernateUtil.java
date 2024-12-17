package biblioteca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            // Cria uma configuração do Hibernate
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")  // arquivo de configuração do Hibernate
                    .addAnnotatedClass(Aluno.class)  // Adiciona a classe Aluno
                    .addAnnotatedClass(Livro.class)  // Adiciona a classe Livro
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
}

