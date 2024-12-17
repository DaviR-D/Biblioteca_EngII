package biblioteca;

public class EmprestimoService {

    private LivroDAO livroDAO = new LivroDAO();
    private AlunoDAO alunoDAO = new AlunoDAO();
    private EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

    public void emprestarLivro(int matriculaAluno, int idLivro) {
        // Verifica se o aluno existe
        Aluno aluno = alunoDAO.findById(matriculaAluno);
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não encontrado!");
        }

        // Verifica se o aluno possui pendências
        if (aluno.possuiPendencias()) {
            throw new IllegalArgumentException("Aluno possui pendências. Não é possível realizar o empréstimo.");
        }

        // Verifica se o livro existe
        Livro livro = livroDAO.findById(idLivro);
        if (livro == null) {
            throw new IllegalArgumentException("Livro não encontrado!");
        }

        // Verifica a disponibilidade do livro
        if (!livro.isDisponivel()) {
            throw new IllegalArgumentException("O livro não está disponível para empréstimo.");
        }

        // Verifica se o livro está reservado
        if (livro.isReservado()) {
            throw new IllegalArgumentException("O livro está reservado.");
        }

        // Realiza o empréstimo
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setAluno(aluno);
        emprestimo.setLivro(livro);

        // Atualiza o status do livro e aluno no banco
        livro.setDisponivel(false);
        livroDAO.update(livro);

        // Persiste o empréstimo no banco de dados
        emprestimoDAO.save(emprestimo);

        System.out.println("Empréstimo realizado com sucesso! Livro: " + livro.getTitulo() + ", Aluno: " + aluno.getNome());
    }
}

