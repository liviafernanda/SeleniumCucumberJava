Feature: Teste de preechimento do formulario do Google Forms

Scenario: Validar o preenchimento de um formulario simples

Given navegador aberto em formulario do Google

When usuario preenche o nome

And preenche o email

And preenche o assunto

And preenche a mensagem

And envia o formulario

Then o formulario deve ser enviado com sucesso