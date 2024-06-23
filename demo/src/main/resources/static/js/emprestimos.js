$(document).ready(function() {
    function fetchEmprestimos() {
        $.get('/api/emprestimos', function(data) {
            $('#emprestimosList').empty();
            data.forEach(function(emprestimo) {
                $('#emprestimosList').append(`<li class="list-group-item">${emprestimo.id} - Livro ID: ${emprestimo.livros.id} - Usuário CPF: ${emprestimo.usuarios.cpf} - De: ${emprestimo.dataEmprestimo} Até: ${emprestimo.dataDevolucao}</li>`);
            });
        });
    }

    $('#emprestimoForm').submit(function(event) {
        event.preventDefault();
        const emprestimo = {
            livros: { id: $('#livroId').val() },
            usuarios: { cpf: $('#usuarioCpf').val() },
            dataEmprestimo: $('#dataEmprestimo').val(),
            dataDevolucao: $('#dataDevolucao').val()
        };

        $.ajax({
            url: '/api/emprestimos',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(emprestimo),
            success: function() {
                fetchEmprestimos();
                $('#emprestimoForm')[0].reset();
            }
        });
    });

    fetchEmprestimos();
});
