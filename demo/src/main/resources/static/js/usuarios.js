$(document).ready(function() {
    function fetchUsuarios() {
        $.get('/api/usuarios', function(data) {
            $('#usuariosList').empty();
            data.forEach(function(usuario) {
                $('#usuariosList').append(`<li class="list-group-item">${usuario.cpf} - ${usuario.nome} ${usuario.sobrenome}</li>`);
            });
        }).fail(function() {
            alert("Erro ao buscar usuários.");
        });
    }

    $('#usuarioForm').submit(function(event) {
        event.preventDefault();
        const usuario = {
            cpf: $('#cpf').val(),
            nome: $('#nome').val(),
            sobrenome: $('#sobrenome').val(),
            senha: $('#senha').val()
        };

        $.ajax({
            url: '/api/usuarios',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(usuario),
            success: function() {
                fetchUsuarios();
                $('#usuarioForm')[0].reset();
            },
            error: function() {
                alert("Erro ao adicionar usuário.");
            }
        });
    });

    fetchUsuarios();
});
