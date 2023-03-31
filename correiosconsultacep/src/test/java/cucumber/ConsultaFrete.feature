Feature: Pesquisa de frete por cep consultando API externa

  Scenario: Verificar resultado de um pesquisa de um frete dado um cep válido
    Given Eu performo uma operação com o cep "06454-000"
    Then Eu encontro o frete

  Scenario: Pesquisa de um frete dado um cep inexistente
    Given Eu performo uma operação com o cep "04711-035"
    Then Eu recebo mensagem de erro CEP inexistente

  Scenario: Pesquisa de um frete com dados inválidos
    Given Eu performo uma operação com o cep "04711-035"
    Then Eu recebo mensagem de erro CEP inválido