# 🏠 LeiloesTDSat

## 📖 Sobre o Projeto
Sistema de gerenciamento de leilões desenvolvido em **Java (Swing)** com integração ao **MySQL**.  
O sistema permite cadastrar, listar e controlar produtos, incluindo a funcionalidade de marcar itens como “Vendidos” e visualizar as vendas realizadas.

---

## 🎯 Objetivo
Facilitar o controle de produtos em uma casa de leilões, permitindo:
- Cadastro de novos itens;
- Listagem geral de produtos;
- Marcação de produtos vendidos;
- Visualização de produtos já vendidos.

---

## 🛠️ Tecnologias Utilizadas
- **Java JDK 17**
- **Swing (Interface Gráfica)**
- **MySQL / MariaDB**
- **Git & GitHub** (versionamento de código)
- **NetBeans IDE**

---

## 📂 Estrutura do Projeto
LeiloesTDSat/
├── src/
│ └── main/java/br/com/leiloes/
│ ├── DBConnection.java
│ ├── Produto.java
│ ├── ProdutoDAO.java
│ ├── CadastroVIEW.java
│ ├── ListagemVIEW.java
│ └── VendasVIEW.java
├── db/
│ └── script_atv_2.sql
├── README.md
└── pom.xml (se aplicável)


---

## ▶️ Como Executar

1. **Importe o projeto** no NetBeans.  
2. **Crie o banco de dados** executando o script localizado em:


db/script_atv_2.sql
