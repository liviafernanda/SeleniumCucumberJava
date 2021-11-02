# Author
# Date
# Description

Feature: Componente para testar a funcionalidade de pesquisa do Google

  Scenario: Validar se a ferramenta de pesquisa do Google esta funcionando
    
    Given navegador esta aberto
    And usuario esta na pagina inicial do Google
    When usuario digita um texto na caixa de pesquisa
    And pressiona a tecla Enter
    Then usuario e direcionado para os resultados da pesquisa

