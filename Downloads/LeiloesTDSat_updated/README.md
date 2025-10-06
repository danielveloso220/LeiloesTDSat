LeiloesTDSat - Projeto atualizado
================================

O projeto foi criado como um projeto Maven Java Swing para facilitar a importação no NetBeans.
Funcionalidades implementadas:
- CadastroVIEW definido como tela principal (classe com main).
- Botão "Salvar" que persiste os dados na tabela `produtos` do banco `uc11`.
- Mensagens de sucesso/erro exibidas via JOptionPane.
- ListagemVIEW com JTable que lista todos os itens cadastrados.

Configuração do banco:
- O dump SQL que você forneceu contém a estrutura e dados iniciais da tabela `produtos`. Utilize esse script para criar o banco e a tabela. Referência do arquivo SQL enviado: fileciteturn0file0

- No arquivo DBConnection.java estão as configurações padrão:
    URL = jdbc:mysql://localhost:3306/uc11
    USER = root
    PASS = (string vazia)
  Altere conforme seu ambiente (usuário/senha/host/porta).

Como importar no NetBeans:
1. Abra o NetBeans.
2. Escolha "Open Project" e selecione a pasta do projeto (onde está o pom.xml). NetBeans reconhece projetos Maven automaticamente.
3. Execute o projeto (Run) — a tela de cadastro (CadastroVIEW) abrirá como tela inicial.
4. Certifique-se de que sua máquina tenha acesso à internet para o NetBeans baixar a dependência do conector MySQL (mysql-connector-java).

Observações:
- Se preferir, pode alterar os campos e mensagens conforme necessidade.
- O projeto foi feito para ser o mais compatível possível com o formato que NetBeans importa (Maven).
