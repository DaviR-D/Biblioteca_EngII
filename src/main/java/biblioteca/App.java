package biblioteca;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Biblioteca");

        // Tela inicial
        VBox mainMenu = new VBox(10);
        mainMenu.setPadding(new Insets(10));
        Button btnCadastrarAluno = new Button("Cadastrar Aluno");
        Button btnCadastrarLivro = new Button("Cadastrar Livro");

        mainMenu.getChildren().addAll(btnCadastrarAluno, btnCadastrarLivro);

        Scene mainScene = new Scene(mainMenu, 300, 200);
        primaryStage.setScene(mainScene);
        primaryStage.show();

        // Configuração da janela de cadastro de aluno
        Stage alunoStage = new Stage();
        alunoStage.setTitle("Cadastrar Aluno");
        GridPane alunoGrid = new GridPane();
        alunoGrid.setPadding(new Insets(10));
        alunoGrid.setHgap(10);
        alunoGrid.setVgap(10);

        Label matriculaLabel = new Label("Matrícula:");
        TextField matriculaField = new TextField();
        Label nomeAlunoLabel = new Label("Nome do Aluno:");
        TextField nomeAlunoField = new TextField();
        Label cpfAlunoLabel = new Label("CPF:");
        TextField cpfAlunoField = new TextField();
        Button cadastrarAlunoBtn = new Button("Cadastrar Aluno");

        alunoGrid.add(matriculaLabel, 0, 0);
        alunoGrid.add(matriculaField, 1, 0);
        alunoGrid.add(nomeAlunoLabel, 0, 1);
        alunoGrid.add(nomeAlunoField, 1, 1);
        alunoGrid.add(cpfAlunoLabel, 0, 2);
        alunoGrid.add(cpfAlunoField, 1, 2);
        alunoGrid.add(cadastrarAlunoBtn, 1, 3);

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

                matriculaField.clear();
                nomeAlunoField.clear();
                cpfAlunoField.clear();
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Erro", "Matrícula deve ser um número inteiro!");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Erro", "Erro ao cadastrar aluno: " + ex.getMessage());
            }
        });

        Scene alunoScene = new Scene(alunoGrid, 400, 200);
        alunoStage.setScene(alunoScene);

        // Configuração da janela de cadastro de livro
        Stage livroStage = new Stage();
        livroStage.setTitle("Cadastrar Livro");
        GridPane livroGrid = new GridPane();
        livroGrid.setPadding(new Insets(10));
        livroGrid.setHgap(10);
        livroGrid.setVgap(10);

        Label tituloLivroLabel = new Label("Título do Livro:");
        TextField tituloLivroField = new TextField();
        Label isbnLivroLabel = new Label("ISBN:");
        TextField isbnLivroField = new TextField();
        Label autorLivroLabel = new Label("Autor:");
        TextField autorLivroField = new TextField();
        Button cadastrarLivroBtn = new Button("Cadastrar Livro");

        livroGrid.add(tituloLivroLabel, 0, 0);
        livroGrid.add(tituloLivroField, 1, 0);
        livroGrid.add(isbnLivroLabel, 0, 1);
        livroGrid.add(isbnLivroField, 1, 1);
        livroGrid.add(autorLivroLabel, 0, 2);
        livroGrid.add(autorLivroField, 1, 2);
        livroGrid.add(cadastrarLivroBtn, 1, 3);

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
                livro.setDisponivel(true);

                livroService.salvarLivro(livro);
                showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Livro cadastrado com sucesso!");

                tituloLivroField.clear();
                isbnLivroField.clear();
                autorLivroField.clear();
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Erro", "Erro ao cadastrar livro: " + ex.getMessage());
            }
        });

        Scene livroScene = new Scene(livroGrid, 400, 200);
        livroStage.setScene(livroScene);

        // Ações dos botões na tela inicial
        btnCadastrarAluno.setOnAction(e -> alunoStage.show());
        btnCadastrarLivro.setOnAction(e -> livroStage.show());

        // Configuração da janela de realização de empréstimo
Stage emprestimoStage = new Stage();
emprestimoStage.setTitle("Realizar Empréstimo");

GridPane emprestimoGrid = new GridPane();
emprestimoGrid.setPadding(new Insets(10));
emprestimoGrid.setHgap(10);
emprestimoGrid.setVgap(10);

Label alunoLabel = new Label("Matrícula do Aluno:");
TextField alunoField = new TextField();
Label livrosLabel = new Label("ISBNs dos Livros (separados por vírgula):");
TextField livrosField = new TextField();
Button realizarEmprestimoBtn = new Button("Realizar Empréstimo");

emprestimoGrid.add(alunoLabel, 0, 0);
emprestimoGrid.add(alunoField, 1, 0);
emprestimoGrid.add(livrosLabel, 0, 1);
emprestimoGrid.add(livrosField, 1, 1);
emprestimoGrid.add(realizarEmprestimoBtn, 1, 2);

realizarEmprestimoBtn.setOnAction(e -> {
    String matriculaTexto = alunoField.getText();
    String livrosTexto = livrosField.getText();

    if (matriculaTexto.isEmpty() || livrosTexto.isEmpty()) {
        showAlert(Alert.AlertType.ERROR, "Erro", "Preencha todos os campos!");
        return;
    }

    try {
        int matricula = Integer.parseInt(matriculaTexto);
        String[] livrosIsbns = livrosTexto.split(",");
        EmprestimoService emprestimoService = new EmprestimoService(new EmprestimoDAO(), new AlunoDAO(), new LivroDAO(), new ReservaDAO(), new DevolucaoDAO(), new ImpressoraService());

        AlunoDAO alunoDAO = new AlunoDAO();
        LivroDAO livroDAO = new LivroDAO();
        Aluno aluno = alunoDAO.findById(matricula);
        
        if (aluno == null) {
            showAlert(Alert.AlertType.ERROR, "Erro", "Aluno não encontrado!");
            return;
        }

        List<Livro> livros = new java.util.ArrayList<>();
        for (String isbn : livrosIsbns) {
            Livro livro = livroDAO.findByISBN(isbn.trim()); // Alterado para buscar pelo ISBN
            if (livro != null && livro.isDisponivel()) {
                livros.add(livro);
            } else {
                showAlert(Alert.AlertType.WARNING, "Aviso", "Livro ISBN " + isbn + " não disponível ou não encontrado.");
            }
        }

        if (livros.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Erro", "Nenhum livro válido selecionado para empréstimo.");
            return;
        }

        emprestimoService.realizarEmprestimo(aluno, livros);
        showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Empréstimo realizado com sucesso!");

        alunoField.clear();
        livrosField.clear();
    } catch (NumberFormatException ex) {
        showAlert(Alert.AlertType.ERROR, "Erro", "Matrícula e ISBNs dos livros devem ser números inteiros!");
    } catch (Exception ex) {
        showAlert(Alert.AlertType.ERROR, "Erro", "Erro ao realizar empréstimo: " + ex.getMessage());
    }
});

Scene emprestimoScene = new Scene(emprestimoGrid, 400, 200);
emprestimoStage.setScene(emprestimoScene);

// Adicionar botão de realização de empréstimo no menu principal
Button btnRealizarEmprestimo = new Button("Realizar Empréstimo");
btnRealizarEmprestimo.setOnAction(e -> emprestimoStage.show());
mainMenu.getChildren().add(btnRealizarEmprestimo);


        //HibernateUtil.limparBanco();
        // Imprimir dados de alunos e livros
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
                System.out.println("Título: " + livro.getTitulo() + ", ISBN: " + livro.getIsbn() + ", Autor: " + livro.getAutor() + ", Disponível: " + livro.isDisponivel());
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




