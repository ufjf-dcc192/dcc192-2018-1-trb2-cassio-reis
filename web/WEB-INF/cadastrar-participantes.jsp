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
                   <form method="post">
                <div class="form-group">
                    <label for="usr">Pedido para mesa: </label>
                    <input name="mesa" class="form-control" readonly>     
                </div>

                <div class="form-group">
                    <label for="usr"> Quantidade:</label>
                    <input type="number" min="0" max="15" value="1" class="form-control" name = "quantidade" /> 

                </div>

                <!--COMBO DE SELEÇÃO -->
                <div class="form-group">
                    <select name="produto" class="form-control">
                      </select>

                </div>

                   <input class="btn btn-primary btn-lg" type ="Submit" /> 
            </form>
        </div>
    </body>
        <%@include file ="jspf/rodape.jspf"%>

</html>
