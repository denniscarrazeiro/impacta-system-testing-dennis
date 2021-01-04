# language: pt
    @wip
    Funcionalidade: Crud processos

      Contexto:
        Dado que o usuário está na página inicial
        E que o usuário clicar no menu processos
        E que o usuário clicar no botão novo processo
        E que o usuário preenche o campo "vara" com o valor "10º vara" no cadastro de processos
        E que o usuário preenche o campo "número processo" com o valor "123456" no cadastro de processos
        E que o usuário preenche o campo "natureza" com o valor "separação" no cadastro de processos
        E que o usuário preenche o campo "partes" com o valor "Vingadores" no cadastro de processos
        E que o usuário preenche o campo "urgente" com o valor "Sim" no cadastro de processos
        E que o usuário preenche o campo "arbitramento" com o valor "Governo EUA" no cadastro de processos
        E que o usuário preenche o campo "assistente social" com o valor "Nick Fury" no cadastro de processos
        E que o usuário preenche o campo "data entrada" com o valor "04/04/2020" no cadastro de processos
        E que o usuário preenche o campo "status" com o valor "aberto" no cadastro de processos

      Cenario: apagar processo | DELETE
        E o usuário clicar no botão salvar no cadastro de processos
        E que o usuário está na página inicial
        E que o usuário clicar no menu processos
        Quando o usuário clicar no botão apagar e confirmar mensagem
        Entao o usuário não verá mais o processo na lista

      Cenario: adicionar processo | POST
        Quando o usuário clicar no botão salvar no cadastro de processos
        Entao o usuário deveria ver a mensagem "Processo foi criado com sucesso." no cadastro de processos

      Cenario: mostrar processo | GET
        E o usuário clicar no botão salvar no cadastro de processos
        E que o usuário está na página inicial
        E que o usuário clicar no menu processos
        Quando o usuário clicar no botão mostrar
        Entao usuário deve obter o código

      Cenario: atualizar processo | PUT
        E o usuário clicar no botão salvar no cadastro de processos
        E que o usuário está na página inicial
        E que o usuário clicar no menu processos
        E o usuário clicar no botão editar
        E o usuário preenche o campo vara com o valor "1 vara atualizado" no editar processos
        Quando o usuário clicar em salvar
        Entao o usuário deveria ver a mensagem "Processo atualizado com sucesso." no editar processos

      Esquema do Cenario: Validação do post com esquema de cenário
        Dado que o usuário está na página inicial
        E que o usuário clicar no menu processos
        E que o usuário clicar no botão novo processo
        E que o usuário preenche o campo "vara" com o valor "<vara>" no cadastro de processos
        E que o usuário preenche o campo "número processo" com o valor "<numero_processo>" no cadastro de processos
        E que o usuário preenche o campo "natureza" com o valor "<natureza>" no cadastro de processos
        E que o usuário preenche o campo "partes" com o valor "<partes>" no cadastro de processos
        E que o usuário preenche o campo "urgente" com o valor "<urgente>" no cadastro de processos
        E que o usuário preenche o campo "arbitramento" com o valor "<arbitramento>" no cadastro de processos
        E que o usuário preenche o campo "assistente social" com o valor "<assistente_social>" no cadastro de processos
        E que o usuário preenche o campo "data entrada" com o valor "<data_entrada>" no cadastro de processos
        E que o usuário preenche o campo "status" com o valor "<status>" no cadastro de processos
        Quando o usuário clicar no botão salvar no cadastro de processos
        Entao o usuário deveria ver a mensagem "Processo foi criado com sucesso." no cadastro de processos

        Exemplos:
          | vara    | numero_processo | natureza    | partes          | urgente | arbitramento | assistente_social   | data_entrada | status     |
          | 1º vara | 12133           | adoção      | jose x maria    | Não     | Sim          | joao                | 04/04/2021   | Aguardando |
          | 2º vara | 12345           | separação   | manoel x renata | Sim     | Não          | marcio              | 01/01/2021   | Finalizado |
