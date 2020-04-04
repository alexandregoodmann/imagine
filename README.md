ANOTAÇÕES
- criar artefato mavem para criar novos projetos
- Container MongoDB
- Acessar container MongoDB
- Java + MongoDB
- Considerar um plus rabbitmq
- Usar DDD
- Superclass generic api
- equals hash code
- ler qual annotation usar no spring
- Documentação de arquitetura
- Melhores práticas de Loggin

REFERENCIAS
- https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-structuring-your-code
==============================================================

Desafio Desenvolvedor Backend

Situação

Você trabalha numa empresa que precisa armazenar de forma segura e eficiente os dados de seus clientes. Crie endpoints de API onde se possa:
enviar um formulário em JSON (dados cadastrais normais, como CPF, nome, telefone e e-mail) com o máximo de validações possível e que você conseguir imaginar. A resposta deve ter pelo menos um ID para que possa ser resgatado na chamada seguinte.

buscar os dados cadastrais através de um ID
enviar arquivos com fotos (fotos da pessoa e de documentos) e onde exista um tratamento que otimize tanto o espaço ocupado, como a verificação da integridade dos dados
buscar as imagens de forma separada.
Requisitos
Somente utilize as seguintes tecnologias no backend: Java SpringBoot, Grails, Node.js ou Python.
A comunicação se dá através de API Rest.
Adicione um README.md ao projeto explicando como devemos proceder para executar o projeto localmente. Tente deixar o mais simplificado possível esse processo. Ele deve ser executado via terminal e chamado através de um cliente Rest.
Colocar o código no repositório público github.
Para explicar as decisões e arquitetura você deverá:
Documentar ao máximo possível no README.md tudo que utilizou e o porquê de ter utilizado
Diferenciais
Testes são bem-vindos. Se conseguir implementar alguns, descrever como executá-los no README.md.
Se for possível, adicionar algum tipo de segurança, adicione endpoints para realização da criação de tokens de acesso (nada de token estático). Adicione instruções no README.md
Lembre-se de quem vai avaliar o código e adicione logs no console para entendermos o que está acontecendo
