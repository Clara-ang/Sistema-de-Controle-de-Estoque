# Sistema-de-Controle-de-Estoque:
   - Cadastro de produtos, categorias e fornecedores.
   - Controle de entrada e saída de produtos.
   - Alertas de estoque mínimo.


### Especificação ###

#### 1. **Modo de executação do projeto**:

- Entrar nas pastas: 
   cd Controle-de-estoque
   cd src 
- Para compilar:
   javac -d ../bin -sourcepath . -cp ../bin -encoding UTF-8 model/*.java service/*.java view/*.java
- Para rodar:
   java -cp ../bin view.Main   

#### 2. **Requisitos Funcionais**:
   - O sistema deve permitir o **cadastro, edição, exclusão e consulta** das entidades principais (ex: livros, usuários, produtos, etc.).
   - Deve haver funcionalidades específicas para o domínio do sistema (ex: empréstimo de livros, fechamento de pedidos, agendamento de consultas, etc.).
   - O sistema deve gerar **relatórios** ou listagens relevantes (ex: listar todos os livros emprestados, produtos com estoque baixo, consultas agendadas, etc.).

#### 3. **Requisitos Técnicos**:
   - **Classes e Objetos**: Criar classes que representem as entidades do sistema, com atributos e métodos bem definidos.
   - **Encapsulamento**: Utilizar atributos privados e métodos públicos (getters e setters) para garantir o encapsulamento.
   - **Herança e Polimorfismo**: Criar hierarquias de classes e utilizar polimorfismo quando aplicável.
   - **Interfaces**: Definir interfaces para comportamentos comuns (ex: `Emprestavel`, `Pagavel`, etc.).
   - **Coleções**: Utilizar coleções como `ArrayList`, `HashMap`, etc., para armazenar listas de objetos.
   - **Exceções**: Implementar tratamento de exceções para situações de erro (ex: tentativa de emprestar um livro já emprestado).
   - **Persistência de Dados**: Salvar e carregar dados em arquivos (ex: `.txt`, `.csv`).

#### 4. **Funcionalidades Adicionais**:
   - **Validação de Dados**: Validar entradas do usuário (ex: CPF, e-mail, datas, etc.).
   - **Interface de Usuário**: Implementar uma interface simples via console ou, opcionalmente, uma interface gráfica usando JavaFX ou Swing.

#### 5. **Entregáveis**:
   - **Código Fonte**: O projeto completo, organizado em pacotes e seguindo as boas práticas de POO.
   - **Diagrama**: Diagrama de Classes com todas as classes, interfaces e records do sistema.
   - **Documentação**: Comentários no código e um arquivo `README.md` explicando como executar o projeto e suas funcionalidades.
   - **Relatório**: Um relatório descrevendo as decisões de projeto, desafios enfrentados e soluções implementadas.

#### 6. **Critérios de Avaliação**:
   - **Funcionalidade**: O sistema deve atender a todos os requisitos funcionais.
   - **Qualidade do Código**: O código deve ser modular, bem organizado e seguir as boas práticas de POO.
   - **Originalidade**: O sistema deve ser único e criativo, evitando cópias de projetos prontos.
   - **Complexidade**: O projeto deve demonstrar um nível adequado de complexidade, utilizando os conceitos aprendidos na disciplina.


#### 7. **Funcionalidades**:

=== SISTEMA DE ESTOQUE ===
1 - Cadastrar Categoria
2 - Cadastrar Fornecedor
3 - Cadastrar Produto
4 - Editar Categoria
2 - Cadastrar Fornecedor
3 - Cadastrar Produto
4 - Editar Categoria
3 - Cadastrar Produto
4 - Editar Categoria
5 - Remover Categoria
5 - Remover Categoria
6 - Editar Fornecedor
7 - Remover Fornecedor
8 - Editar Produto
9 - Remover Produto
10 - Entrada de Estoque
11 - Saída de Estoque
12 - Listar Produtos
13 - Listar Estoque Baixo
0 - Sair
