**Como Executar o Projeto com Gradle**

**Linha de comando:** ./gradlew bootRun


**Como Executar os Testes Unitários**

**Linha de Comando:** ./gradlew test

**IDE's Recomendadas**

- Eclipse
- Intellij

*Comentários do Desenvolvedor*
Conforme solicitado pelo desafio, fiz majoritáriamentes duas Apis uma para Estatíticas sobre a população e outra para Campanhas;

-Para executar o recurso da Api de Estatisticas a URI é /ano/{ano} onde deve-se passar o filtro pela variável através caminho especificado na URI {ano}.
Logo para se extrair a informação do ano de 2010, basta requisitar o recurso da seguinte maneira: htpp://localhost:8080/ano/2010
para o ano de 2017: htpp://localhost:8080/ano/2017 e assim por diante; 
A Api de Estatisticas possui valores referentes aos anos de 2000 a 2017, sendo 2017 uma projeção calculada de acordo com a fórmula (((P(10)/P(0))^0.1)-1);
-recurso ano/{ano}
	este recurso recebe como filtro a PathVariable ano e retorna um JSON contendo:
		-Ano 
		-Quantidade da População
		-Proporção de homens 
		-Proporção de mulheres

-Para executar a Api de Campanhas, que é composta por dois recursos, notifica e campanhas
 - recurso para inserir notificação de participação de campanha:
 	/notifica/{ano}/{sexo}/{campanha}
	como resposta esse recurso envia o JSON da informação inserida na base de dados, contendo Ano, Campanha, e Sexo do participante;
- recurso para buscar informações de campanha com base no ano
	/campanhas/{ano}
	mais uma vez o filtro é o ano passado pela PathVariable da URI;
	como resposta o cliente receberá um JSON contendo o Ano filtrado e um array com todas as campanhas realizadas juntamente com suas estatísticas que possuí:
		- Nome da campanha;
		- Quantidade de participantes total;
		- Quantidade de Homens participantes;
		- Quantidades de Mulheres participantes;
		- Proporção de homens;
		- Proporção de mulheres;
		
Na pasta do projeto também contém um arquivo chamado Classes.pdf que mostra a estrutura das classes e interfaces das Api's; 