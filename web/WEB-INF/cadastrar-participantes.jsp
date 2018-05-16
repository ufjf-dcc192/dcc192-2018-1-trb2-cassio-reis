<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Pedido</title>
        <%@include file ="jspf/cabecalho.jspf"%>
    </head>
    <body>
        <div class="container">
            <h1> Bem-vindo </h1>
            <h3> Faça seu cadastro </h3>
        </div>
        <div class="container">
            <form method="post">
                <div class="form-group">
                    <label for="usr">Nome:</label>
                    <input name="mesa" class="form-control" required>     
                </div>

                <div class="form-group">
                    <label for="usr">Email</label>
                    <input type="email" name="email" class="form-control" required>     
                </div>

                <div class="form-group">
                    <label for="usr">Senha</label>
                    <input type="password" name="senha" class="form-control" required>     
                </div>

                <input class="btn btn-primary btn" type ="Submit" /> 
                <input class="btn btn-primary btn" type ="Reset" /> 
            </form>
        </div>
    </body>
    <%@include file ="jspf/rodape.jspf"%>

</html>
