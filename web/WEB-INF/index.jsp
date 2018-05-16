

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Amigoculto dos amigos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>

    <body style="background-color:black;">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html"><b>Amigoculto dos amigos</b></a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.html">Home</a></li>
                    <li><a href="mesas.html">Cadastrar</a></li>
                    <li><a href="cardapio.html">Fazer Login</a></li>
                </ul>
            </div>
        </nav>




        <div class="container text-center">
            <div class="container-fluid">
                <h1 style="color:white">AMigoculto dos amigos</h1>
                <img src="http://www.theatrocentral.com.br/wp-content/uploads/2016/07/logo_ufjf_v7.png" alt="Logo">
                <h3 style="color:gray">Laboratório de Desenvolvimento JavaWeb</h3>
                <a href="cadastro-pessoas.html" class="btn btn-danger btn-lg"> Cadastra-se </a>
                <a href="login.html"  data-toggle="modal" data-target="#myModal"  class="btn btn-default btn-lg"> Faça seu login </a>
            </div>
        </div>


        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Faça seu login</h4>
                    </div>
                    <form method="post">
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="usr">Email:</label>
                                <input type="text" class="form-control" id="usr" name = "email">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" id="pwd" name="senha">
                            </div>         </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-default"> Entrar </button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </form>
                </div>


            </div>
        </div>



        <footer style="color: #c1c1c3; text-align: center;"  class="footer navbar-fixed-bottom">
            <p> © 2018 Copyright:Cássio Reis</p>
        </footer>
    </body>
</html>