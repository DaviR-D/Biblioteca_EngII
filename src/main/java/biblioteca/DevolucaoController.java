package biblioteca;

import java.util.Date;

public class DevolucaoController {
    private EmprestimoDAO emprestimoDAO;

    public DevolucaoController(EmprestimoDAO emprestimoDAO) {
        this.emprestimoDAO = emprestimoDAO;
    }

    public void registrarDevolucao(int emprestimoId, Date dataDevolucao) {
        // Buscar o empréstimo pelo ID
        Emprestimo emprestimo = emprestimoDAO.findById(emprestimoId);
        if (emprestimo == null) {
            System.out.println("Empréstimo não encontrado.");
            return;
        }

        // Verificar atraso e calcular multa
        Date dataPrevista = emprestimo.getDataPrevistaDevolucao();
        Devolucao devolucao = new Devolucao(dataDevolucao, false, 0, 0);
        boolean atraso = devolucao.verificarAtraso(dataPrevista);
        devolucao.setAtraso(atraso);

        if (atraso) {
            float multa = devolucao.calcularMulta(dataPrevista, 5.0f); // Valor por dia de atraso
            devolucao.setMulta(multa);
            System.out.println("Devolução com atraso. Multa calculada: R$ " + multa);
        } else {
            System.out.println("Devolução dentro do prazo. Sem multa.");
        }

        // Atualizar disponibilidade dos livros
        for (ItemEmprestimo item : emprestimo.getItensEmprestados()) {
            Livro livro = item.getLivro();
            livro.setDisponivel(true);
        }

        // Deletar o empréstimo do banco de dados
        emprestimoDAO.delete(emprestimoId);

        // Exibir mensagem de sucesso
        System.out.println("Devolução registrada com sucesso. Todos os itens foram devolvidos e o empréstimo foi excluído.");
    }
}

