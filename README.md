<h1>Pacotes</h1>

<h3>Engine:</h3>
<ul>
    <li>
        BlackHole
    </li>
    <li>
        Entity
    </li>
    <li>
        Frame
    </li>
    <li>
        Game
    </li>
    <li>
        Generator
    </li>
    <li>
        GUI
    </li>
    <li>
        Main
    </li>
    <li>
        Planet
    </li>
    <li>
        Player
    </li>
</ul>

<h3>Threads:</h3>
<ul>
    <li>
        addCurrency
        <ul>
            <li>Essa thread é utilizada para adicionar moedas por segundo baseado no PPS (pedros por segundo).</li>
        </ul>
    </li>
    <li>
        updatePPS
        <ul>
            <li>Essa thread é utilizada para manter o PPS atualizado a cada segundo. Caso o player compre algum objeto (planeta, estrela ou cometa), o PPS é atualizado no próximo segundo.</li>
        </ul>
    </li>
</ul>
<hr>
<p><b>As Threads acima trabalham em conjunto, uma vez que uma atualiza o PPS e a outra consulta o PPS para adicionar as moedas a cada segundo.</b></p>
<hr>
<h3>TO DO:</h3>
<ul>
    <li>
        Desacoplar as funções Getters e Setters (linha 56 do Player.java) dos objetos espaciais da classe Player.
        <ul>
            <li>
                Criar uma classe Shop.java (ou semelhante) para tratar a compra dos objetos e atualizar a quantidade de cada que o player possui.
            </li>
            <li>
                Dividir o pacote Engine em outros pacotes. Tem classes que não fazem função de engine no pacote.
            </li>
            <li>
                Verificar se a Generator.java não faz a função do Shop.java mencionado acima.
            </li>
        </ul>
    </li>
    <li>
        Dividir o pacote Engine em outros pacotes. Tem classes que não fazem função de engine no pacote.
    </li>
</ul>
