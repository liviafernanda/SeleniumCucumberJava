Feature: Testar login com erro em ambiente acessivel para usuario surdo

	Scenario: login no central do interpretes com email nao cadastrado
	
		Given navegador aberto
		
		And logado na central de interpretes
	
		When Usuario assiste ao video sinalizando o preenchimento do email
		
		And preenche o campo com o email
		
		And assiste ao video sinalizando o preenchimento da senha
		
		And preenche o campo com senha
		
		And clica no botao Entrar
		
		Then sistema entra na tela inicial
		
		