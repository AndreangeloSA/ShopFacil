# ShopFácil - Padrões de Projeto GoF em Java

## 📖 Sobre o Projeto

O **ShopFácil** é um projeto acadêmico desenvolvido em Java com o objetivo de demonstrar a aplicação prática de padrões de projeto do catálogo **GoF (Gang of Four)** em um cenário de e-commerce.

A aplicação simula o back-end de uma startup responsável pela venda de produtos, processamento de pagamentos, gerenciamento de catálogo e fluxo de checkout.

O sistema funciona inteiramente via terminal (CLI), priorizando a organização do código, reutilização de componentes e separação de responsabilidades.

---

# 🚀 Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos (POO)
- Padrões de Projeto GoF
- IntelliJ IDEA
- Git/GitHub

---

# 📂 Estrutura do Projeto

```text
src/backend
│
├── adapter
│   ├── GlobalPayAdapter.java
│   ├── GlobalPayService.java
│   ├── Pagamento.java
│   ├── PayBrasilAdapter.java
│   └── PayBrasilService.java
│
├── decorator
│   ├── DescontoDecorator.java
│   ├── EmbrulhoDecorator.java
│   ├── FreteExpressDecorator.java
│   ├── Pedido.java
│   ├── PedidoDecorator.java
│   └── PedidoBase.java
│
├── facade
│   ├── CheckoutFacade.java
│   ├── EstoqueService.java
│   ├── FreteService.java
│   ├── NotaFiscalService.java
│   └── PagamentoService.java
│
├── proxy
│   ├── CatalogoProxy.java
│   ├── CatalogoReal.java
│   └── CatalogoService.java
│
├── singleton
│   └── NetworkManager.java
│
└── Main.java
```

---

# 🎯 Padrões de Projeto Implementados

## 1. Singleton

### Classe:
- `NetworkManager`

### Objetivo:
Garantir que exista apenas uma instância responsável pelo gerenciamento de conexões/requisições da aplicação.

---

## 2. Adapter

### Classes:
- `PayBrasilAdapter`
- `GlobalPayAdapter`
- `GlobalPayService`
- `PayBrasilAdapter`

### Objetivo:
Padronizar a comunicação entre diferentes gateways de pagamento.

---

## 3. Decorator

### Classes:
- `DescontoDecorator`
- `EmbrulhoDecorator`
- `FreteExpressDecorator`
- `PedidoBase`
- `PedidoDecorator`

### Objetivo:
Adicionar funcionalidades dinamicamente aos pedidos sem alterar sua estrutura base.

---

## 4. Facade

### Classe:
- `CheckoutFacade`
- `EstoqueService`
- `FreteService`
- `NotaFiscalService`
- `PagamentoService`

### Objetivo:
Simplificar o processo de checkout centralizando múltiplos serviços.

---

## 5. Proxy

### Classes:
- `CatalogoProxy`
- `CatalogoReal`

### Objetivo:
Controlar o acesso ao catálogo de produtos.

---

# ▶️ Como Executar

## 1. Clone o repositório

```bash
git clone <URL_DO_REPOSITORIO>
```

## 2. Compile e execute

```bash
javac src/backend/Main.java
java backend.Main
```

---

# 📚 Objetivos Acadêmicos

- Aplicação prática de padrões GoF
- Arquitetura orientada a objetos
- Boas práticas de desenvolvimento
- Organização modular de código

---
