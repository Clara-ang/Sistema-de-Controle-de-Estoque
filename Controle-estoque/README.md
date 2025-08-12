# O projeto foi feito seguindo Programação Orientada a Objetos (POO), com pacotes para organizar o    projeto:
model → contém as entidades do sistema (dados e regras básicas)

service → lógica de negócio 

view →  menu no console

Main.java → Roda MenuPrincipal


2. Classes e Responsabilidades
+ model
- Usuario (classe abstrata): Superclasse que centraliza o atributo id e o getId() para evitar repetição.

- Objetivo: padronizar o identificador(Id) em todas as classes (Categoria, Fornecedor, Produto, ).

+ Categoria: Contém id, nome e descricao.
- Representa um tipo de produto (Ex.: "Base", "corretivo").

+ Fornecedor: Contém id, nome, cnpj, contato.
- empresa que fornece os produtos.

+ Produto: tem dados de compra/venda, estoque mínimo e relação com categoria e fornecedores.

- Possui métodos para aumentar/diminuir estoque, atualizar preço etc.


+ Fornecimento: vínculo entre um produto e um fornecedor.

- Objetivo: ter um objeto intermediário para guardar mais informações se houver necessidade (como preço de compra específico).

+ service
- EstoqueService: guarda listas (List<>) de todas as classes.

- Métodos: adicionarProduto, aumentarEstoque, diminuirEstoque, listarEstoqueBaixo, buscarFornecedor.

Objetivo: concentrar as operações de negócio no EstoqueService evitando que o menu console manipule os dados diretamente.

+ view
- MenuPrincipal: Apresenta o menu no console.

- Recebe entrada do usuário (Scanner).

- Chama métodos de EstoqueService para executar ações.

Objetivo: separar completamente a interface do usuário da lógica de negócio, facilitando a troca da interface (poderia ser Swing, JavaFX, API REST, etc.).

Main
Chama MenuPrincipal.iniciar().

3. Persistência
Decidiu-se usar arquivos CSV para salvar e carregar produtos, categorias e fornecedores.

Vantagens:

Simples de implementar sem banco de dados.

Portável e fácil de abrir em Excel.

Desvantagem:

Menos seguro e eficiente que um banco de dados, mas suficiente para sistemas pequenos.

4. Decisões de Design
Encapsulamento → atributos privados e getters/setters públicos.

Herança → Entidade como classe base para evitar repetição de id.

Polimorfismo → possível de expandir no futuro (por exemplo, Pessoa como superclasse de Cliente e Funcionario).

Coesão alta e acoplamento baixo → view não conhece detalhes de implementação das entidades, só chama serviços.

5. Fluxo de Funcionamento
Usuário inicia o sistema (Main → MenuPrincipal.iniciar()).

MenuPrincipal exibe opções.

Ao escolher, ele lê os dados do usuário, chama EstoqueService para executar a ação.

EstoqueService altera as listas em memória e, quando necessário, salva no CSV.

O usuário pode listar, editar, excluir e registrar entradas/saídas de estoque.

Ao sair, o programa pode salvar todos os dados no CSV para persistência.

