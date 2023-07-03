# Relatório de Desenvolvimento

Este relatório descreve o desenvolvimento da aplicação proposta para o cargo  desenvolvedor Java.

## Tecnologias Utilizadas

- Linguagem de Programação: Java
- Framework Web: JavaServer Faces (JSF)
- Framework UI: PrimeFaces
- Persistência de dados: JPA com PostgreSQL
- Servidor de Aplicação: GlassFish Server 5
- Gerenciamento de Dependências: Apache Maven

## Funcionalidades Implementadas

### a) Criar uma aplicação Java Web utilizando JavaServer Faces (JSF)

O projeto foi desenvolvido como uma aplicação Java Web utilizando o framework JavaServer Faces (JSF). O JSF é um framework MVC (Model-View-Controller) que facilita o desenvolvimento de interfaces de usuário baseadas em componentes.
foi utilizado o JavaServer Faces (JSF) juntamente com o framework PrimeFaces para desenvolver a interface de usuário da aplicação.
O PrimeFaces é um conjunto de componentes e temas prontos para uso com o JSF. Ele fornece uma ampla variedade de componentes ricos em recursos, como tabelas, formulários, botões e menus, facilitando a criação de interfaces de usuário sofisticadas.
No projeto, aproveitamos os recursos do PrimeFaces para criar uma interface de usuário moderna e interativa. Foram utilizados componentes como DataTables para exibir e manipular a lista de tarefas, Dialogs para exibir modais, Buttons para ações de adicionar, editar e remover tarefas, entre outros.

1. Listagem de Tarefas: Permite visualizar todas as tarefas cadastradas, sendo possível exibir os detalhes de cada uma.

2. Adição de Tarefas: Permite adicionar uma nova tarefa. É necessário informar o título, descrição, responsável e data de conclusão da tarefa.

3. Edição de Tarefas: Permite editar os detalhes de uma tarefa existente, incluindo o título, descrição, situação, responsável e data de conclusão.

4. Remoção de Tarefas: Permite remover uma tarefa existente, excluindo-a permanentemente do banco de dados.

### b) Utilizar persistência em um banco de dados PostgreSQL
A aplicação utiliza o banco de dados PostgreSQL para armazenar e gerenciar os dados das tarefas. O PostgreSQL é um sistema de gerenciamento de banco de dados relacional de código aberto e amplamente utilizado. Ele oferece recursos de confiabilidade e desempenho. Através da combinação do JSF, JPA e PostgreSQL, a aplicação possui uma base sólida para a criação e gerenciamento eficiente das tarefas, garantindo a persistência e integridade dos dados.

### c) Utilizando JPA para persistência de dados.
A aplicação utiliza o Java Persistence API (JPA) como framework de persistência de dados. O JPA é uma especificação do Java que define uma API de mapeamento objeto-relacional, permitindo o mapeamento transparente de objetos Java para tabelas em um banco de dados relacional. Com o uso do JPA, é possível simplificar o acesso aos dados e facilitar as operações de persistência, remoção, atualização e consulta de objetos no banco de dados. O JPA oferece uma abstração de nível superior, permitindo que o desenvolvedor trabalhe com entidades e consultas em vez de lidar diretamente com SQL
A classe TarefaDAO é utilizada para encapsular as operações relacionadas à entidade Tarefa. Vejamos algumas funcionalidades presentes no projeto:

- O método `salvar` é responsável por persistir uma nova tarefa no banco de dados. Ele utiliza o `EntityManager` para iniciar uma transação, persistir a tarefa e confirmar a transação.

- O método `excluirTarefa` é responsável por remover uma tarefa do banco de dados. Ele utiliza o `EntityManager` para iniciar uma transação, buscar a tarefa pelo seu número (caso não esteja no estado "managed") e removê-la.

- O método `editarTarefa` é responsável por atualizar os dados de uma tarefa existente no banco de dados. Ele utiliza o `EntityManager` para iniciar uma transação, mesclar (merge) as alterações da tarefa e confirmar a transação.

- O método `concluirTarefa` é responsável por marcar uma tarefa como concluída no banco de dados. Ele utiliza o `EntityManager` para iniciar uma transação, mesclar as alterações da tarefa e confirmar a transação.

- O método `listarTarefas` é responsável por buscar as tarefas no banco de dados com base em um filtro. Ele utiliza o `EntityManager` para criar uma consulta (query) com base nos critérios definidos no filtro. A consulta é realizada utilizando a linguagem JPQL (Java Persistence Query Language), e os parâmetros do filtro são definidos usando o método `setParameter` da `TypedQuery`.

## Instruções para Execução

Para executar a aplicação em um ambiente local, siga as instruções abaixo:

1. Clone o repositório do projeto:

   ```
   git clone https://github.com/luizhtss/egs_taskmanager.git
   ```

2. Navegue até o diretório do projeto:

   ```
   cd egs_taskmanager
   ```

3. Execute o comando Maven para construir o arquivo WAR:

   ```
   mvn clean package
   ```

4. Após a conclusão do comando, você encontrará o arquivo `ESIG-Challenger-1.0.war` no diretório `target`.

5. Faça o deploy do arquivo WAR em um servidor GlassFish Server ou outro servidor Java EE.

6. Inicie o servidor GlassFish:

   ```
   $GLASSFISH_HOME/bin/asadmin start-domain
   ```

   Substitua `$GLASSFISH_HOME` pelo diretório de instalação do GlassFish Server.

   Realize o deploy do arquivo WAR:

   ```
   $GLASSFISH_HOME/bin/asadmin deploy --name=ESIG-Challenger --contextroot=/ESIG-Challenger /caminho/para/ESIG-Challenger-1.0.war
   ```

   Substitua `/caminho/para` pelo diretório onde está localizado o arquivo WAR.

6. Acesse a aplicação pelo navegador usando o seguinte endereço: [http://localhost:8080/ESIG-Challenger](http://localhost:8080/ESIG-Challenger)

> **Nota:** Certifique-se de ter o GlassFish Server ou outro servidor Java EE configurado corretamente em sua máquina e de atualizar as configurações de host, usuário e senha no arquivo `persistence.xml`.
Se você estiver utilizando outro servidor de aplicação, consulte a documentação correspondente para obter os comandos de deploy adequados.

## Executando com o docker

1. Clone o repositório do projeto:

   ```
   git clone https://github.com/luizhtss/egs_taskmanager.git
   ```

2. Navegue até o diretório do projeto:

   ```
   cd egs_taskmanager
   ```

3. Execute o comando Maven para construir o arquivo WAR:

   ```
   mvn clean package
   ```

4. Inicie o container da aplicação:

   ```
   docker-compose up
   ```
5. Após a inicialização, acesse a aplicação pelo navegador usando o seguinte endereço: [http://localhost:8080/ESIG-Challenger](http://localhost:8080/ESIG-Challenger)