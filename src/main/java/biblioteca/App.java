package biblioteca;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query; // Para a classe Query do Hibernate
import java.util.List; // Para usar List

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Biblioteca");

        // GridPane para organizar os formulários
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // ===========================
        // Campos para cadastrar aluno
        // ===========================
        Label matriculaLabel = new Label("Matrícula:");
        TextField matriculaField = new TextField();
        Label nomeAlunoLabel = new Label("Nome do Aluno:");
        TextField nomeAlunoField = new TextField();
        Label cpfAlunoLabel = new Label("CPF:");
        TextField cpfAlunoField = new TextField();
        Button cadastrarAlunoBtn = new Button("Cadastrar Aluno");

        grid.add(matriculaLabel, 0, 0);
        grid.add(matriculaField, 1, 0);
        grid.add(nomeAlunoLabel, 0, 1);
        grid.add(nomeAlunoField, 1, 1);
        grid.add(cpfAlunoLabel, 0, 2);
        grid.add(cpfAlunoField, 1, 2);
        grid.add(cadastrarAlunoBtn, 1, 3);

        // Ação do botão de cadastrar aluno
        cadastrarAlunoBtn.setOnAction(e -> {
            String matriculaTexto = matriculaField.getText();
            String nome = nomeAlunoField.getText();
            String cpf = cpfAlunoField.getText();

            if (matriculaTexto.isEmpty() || nome.isEmpty() || cpf.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Erro", "Preencha todos os campos!");
                return;
            }

            try {
                int matricula = Integer.parseInt(matriculaTexto);

                AlunoService alunoService = new AlunoService();
                Aluno aluno = new Aluno();
                aluno.setMatricula(matricula);
                aluno.setNome(nome);
                aluno.setCpf(cpf);
                aluno.setEndereco("Endereço genérico");

                alunoService.salvarAluno(aluno);
                showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Aluno cadastrado com sucesso!");
                
                // Limpar campos após cadastro
                matriculaField.clear();
                nomeAlunoField.clear();
                cpfAlunoField.clear();
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Erro", "Matrícula deve ser um número inteiro!");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Erro", "Erro ao cadastrar aluno: " + ex.getMessage());
            }
        });

 // ===========================
// Campos para cadastrar livro
// ===========================
Label tituloLivroLabel = new Label("Título do Livro:");
TextField tituloLivroField = new TextField();
Label isbnLivroLabel = new Label("ISBN:");
TextField isbnLivroField = new TextField();
Label autorLivroLabel = new Label("Autor:");
TextField autorLivroField = new TextField();
Button cadastrarLivroBtn = new Button("Cadastrar Livro");

grid.add(tituloLivroLabel, 0, 4);
grid.add(tituloLivroField, 1, 4);
grid.add(isbnLivroLabel, 0, 5);
grid.add(isbnLivroField, 1, 5);
grid.add(autorLivroLabel, 0, 6);
grid.add(autorLivroField, 1, 6);
grid.add(cadastrarLivroBtn, 1, 7);

// Ação do botão de cadastrar livro
cadastrarLivroBtn.setOnAction(e -> {
    String titulo = tituloLivroField.getText();
    String isbn = isbnLivroField.getText();
    String autor = autorLivroField.getText();

    if (titulo.isEmpty() || isbn.isEmpty() || autor.isEmpty()) {
        showAlert(Alert.AlertType.ERROR, "Erro", "Preencha todos os campos!");
        return;
    }

    try {
        LivroService livroService = new LivroService();
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setIsbn(isbn);
        livro.setAutor(autor);

        livroService.salvarLivro(livro);
        showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Livro cadastrado com sucesso!");

        // Limpar campos após cadastro
        tituloLivroField.clear();
        isbnLivroField.clear();
        autorLivroField.clear();
    } catch (Exception ex) {
        showAlert(Alert.AlertType.ERROR, "Erro", "Erro ao cadastrar livro: " + ex.getMessage());
    }
});


        // ===========================
        // Configuração da cena
        // ===========================
        Scene scene = new Scene(grid, 500, 350);
        primaryStage.setScene(scene);
        primaryStage.show();

        imprimirAlunos();
    }

    private void imprimirAlunos() {
        // Iniciar uma transação
        Session session = HibernateUtil.getSession(); // Usando o método correto para obter a sessão
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            
            // Buscar todos os alunos
            Query<Aluno> queryAlunos = session.createQuery("FROM Aluno", Aluno.class);
            List<Aluno> alunos = queryAlunos.getResultList();
            
            // Imprimir no console os alunos
            for (Aluno aluno : alunos) {
                System.out.println("Matrícula: " + aluno.getMatricula() + ", Nome: " + aluno.getNome() + ", CPF: " + aluno.getCpf());
            }
    
            // Buscar todos os livros
            Query<Livro> queryLivros = session.createQuery("FROM Livro", Livro.class);
            List<Livro> livros = queryLivros.getResultList();
            
            // Imprimir no console os livros
            for (Livro livro : livros) {
                System.out.println("Título: " + livro.getTitulo() + ", ISBN: " + livro.getIsbn() + ", Autor: " + livro.getAutor());
            }
            
            // Confirmar a transação
            transaction.commit();
            
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback(); // Reverter a transação em caso de erro
            }
            System.out.println("Erro ao recuperar dados: " + ex.getMessage());
        } finally {
            session.close(); // Fechar a sessão
        }
    }
    
    

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



