$(document).ready(function() {
    function fetchLivros() {
        $.get('/api/livros', function(data) {
            $('#livrosList').empty();
            data.forEach(function(livro) {
                $('#livrosList').append(`<li class="list-group-item">${livro.id} - ${livro.titulo} por ${livro.autor}</li>`);
            });
        });
    }

    $('#livroForm').submit(function(event) {
        event.preventDefault();
        const livro = {
            titulo: $('#titulo').val(),
            autor: $('#autor').val(),
            genero: $('#genero').val(),
            descricao: $('#descricao').val()
        };

        $.ajax({
            url: '/api/livros',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(livro),
            success: function() {
                fetchLivros();
                $('#livroForm')[0].reset();
            }
        });
    });

    fetchLivros();
});
