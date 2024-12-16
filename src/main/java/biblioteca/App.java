package biblioteca;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Biblioteca");

        // GridPane para organizar os formulários
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // Campos para cadastrar aluno
        Label nomeAlunoLabel = new Label("Nome do Aluno:");
        TextField nomeAlunoField = new TextField();
        Label cpfAlunoLabel = new Label("CPF:");
        TextField cpfAlunoField = new TextField();
        Button cadastrarAlunoBtn = new Button("Cadastrar Aluno");

        grid.add(nomeAlunoLabel, 0, 0);
        grid.add(nomeAlunoField, 1, 0);
        grid.add(cpfAlunoLabel, 0, 1);
        grid.add(cpfAlunoField, 1, 1);
        grid.add(cadastrarAlunoBtn, 1, 2);

        // Ação do botão de cadastrar aluno
        cadastrarAlunoBtn.setOnAction(e -> {
            String nome = nomeAlunoField.getText();
            String cpf = cpfAlunoField.getText();
            
            if (nome.isEmpty() || cpf.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Erro", "Preencha todos os campos!");
                return;
            }
            
            try {
                AlunoService alunoService = new AlunoService();
                AlunoFactory alunoFactory = new AlunoFactory();
                Aluno aluno = alunoFactory.criarAluno(nome, cpf, "Endereço genérico");
                alunoService.salvarAluno(aluno);
                showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Aluno cadastrado com sucesso!");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Erro", "Erro ao cadastrar aluno: " + ex.getMessage());
            }
        });

        // Campos para cadastrar livro
        Label tituloLivroLabel = new Label("Título do Livro:");
        TextField tituloLivroField = new TextField();
        Label isbnLivroLabel = new Label("ISBN:");
        TextField isbnLivroField = new TextField();
        Button cadastrarLivroBtn = new Button("Cadastrar Livro");

        grid.add(tituloLivroLabel, 0, 3);
        grid.add(tituloLivroField, 1, 3);
        grid.add(isbnLivroLabel, 0, 4);
        grid.add(isbnLivroField, 1, 4);
        grid.add(cadastrarLivroBtn, 1, 5);

        // Ação do botão de cadastrar livro
        cadastrarLivroBtn.setOnAction(e -> {
            String titulo = tituloLivroField.getText();
            String isbn = isbnLivroField.getText();
            
            if (titulo.isEmpty() || isbn.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Erro", "Preencha todos os campos!");
                return;
            }
            
            try {
                LivroService livroService = new LivroService();
                LivroFactory livroFactory = new LivroFactory();
                Livro livro = livroFactory.criarLivro(titulo, "Autor genérico", isbn);
                livroService.salvarLivro(livro);
                showAlert(Alert.AlertType.INFORMATION, "Sucesso", "Livro cadastrado com sucesso!");
            } catch (Exception ex) {
                showAlert(Alert.AlertType.ERROR, "Erro", "Erro ao cadastrar livro: " + ex.getMessage());
            }
        });

        // Configuração da cena
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
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

