<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">        
            <a class="navbar-brand" href="./">Loja DW</a>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav">
                <li><a href="produto?logica=Lista&categoria=Eletrodomesticos">Eletrodom�sticos</a></li>
                <li><a href="produto?logica=Lista&categoria=Informatica">Inform�tica</a></li>
                <li><a href="produto?logica=Lista&categoria=Eletroportaveis">Eletroport�veis</a></li>
                <li><a href="produto?logica=Lista&categoria=Smartphones">Smartphones</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <form class="navbar-form navbar-left" action="produto?logica=Lista" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control" id="nomeProduto" name="nomeProduto" placeholder="Nome do produto">
                    </div>
                    <button type="submit" class="btn btn-default">Pesquisar</button>
                </form >
                <li class="active"><a href="#">�rea Restrita</a></li>
            </ul>
        </div>
    </div>
</nav>	
