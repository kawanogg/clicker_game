<h1>Pedro casa cmg</h1>

Obs.: Foi o Gustavo


Classes iniciadas: <br>
    Engine:
        BlackHole
        Entity
        Frame
        Game
        Generator
        GUI
        Main
        Planet
        Player
    
    Threads:
        addCurrency
            - Essa thread é utilizada para adicionar moedas por segundo baseado no PPS (pedros por segundo).
        updatePPS
            - Essa thread é utilizada para manter o PPS atualizado a cada segundo. Caso o player compre algum objeto (planeta, estrela ou cometa), o PPS é atualizado.

    • As Threads acima trabalham em conjunto, uma vez que uma atualiza o PPS e a outra consulta o PPS para adicionar as moedas a cada segundo.

    • TO DO:
        - Desacoplar as funções Getters e Setters (linha 56 do Player.java) dos objetos espaciais da classe Player. 
        - Criar uma classe Shop.java (ou semelhante) para tratar a compra dos objetos e atualizar a quantidade de cada que o player possui.
        - Dividir o pacote Engine em outros pacotes. Tem classes que não fazem função de engine no pacote.
        - Verificar se a Generator.java não faz a função do Shop.java mencionado acima.