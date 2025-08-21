# ecommerce-multi-vendedores
"Trabalho de Conclusão de Curso da iniciativa +PraTi, criado por 10 alunos. O projeto é uma loja de e-commerce moderna, com área administrativa para funcionários, técnicos e gerentes, oferecendo compra online, gerenciamento de pedidos, chat com IA, controle de estoque e gestão de usuários.

## Padrão de Commits
Usamos o padrão abaixo para manter o histórico organizado.

- `feat:` nova funcionalidade
- `fix:` correção de bug
- `docs:` atualização de documentação
- `style:` mudanças visuais/formatação
- `refactor:` refatoração de código
- `test:` alterações nos testes

  
Descrição do projeto:


Tecnologias usadas:


Como rodar localmente:
## Backend
### Como executar local:
### README: Aplicação Ecommerce com Docker Compose

Este documento descreve como configurar e executar a aplicação Spring Boot e o banco de dados MySQL usando Docker Compose.

-----

#### Pré-requisitos

Para executar a aplicação, você precisa ter as seguintes ferramentas instaladas na sua máquina:

* **Docker & Docker Compose:** Versão mais recente instalada e em execução.
* **Java JDK:** Versão 21 ou superior para compilar o projeto.
* **Maven:** Para construir o arquivo `.jar` da aplicação.
* **Arquivo `.env`**: Um arquivo chamado `.env` deve ser criado no mesmo diretório do `docker-compose.yml` com as credenciais do banco de dados.

**Estrutura do Projeto:**
Seu projeto deve ter a seguinte estrutura básica:

```
.
├── docker-compose.yml
├── .env
├── pom.xml
├── Dockerfile
├── target/
│   └── api-0.0.1-SNAPSHOT.jar
└── db-init-scripts/
    └── init.sql (ou qualquer outro script de inicialização)
```

-----

#### Como Executar

Siga os passos abaixo para iniciar a aplicação e o banco de dados.

1.  **Crie o arquivo `.env`**

    No mesmo diretório do `docker-compose.yml`, crie um arquivo chamado `.env` e adicione as seguintes variáveis, substituindo `sua_senha_secreta` pelo valor correto:

    ```bash
    DB_NAME=dbname
    DATASOURCE_USERNAME=root
    DATASOURCE_PASSWORD=sua_senha_secreta
    ```

    **Observação:** É uma boa prática adicionar `.env` ao seu arquivo `.gitignore` para evitar que suas credenciais sejam versionadas.

2.  **Construa a Aplicação Java**

    Navegue até a pasta raiz do seu projeto e compile a aplicação Spring Boot para gerar o arquivo `.jar`.

    ```bash
    mvn clean package
    ```

3.  **Inicie os Serviços com Docker Compose**

    No mesmo diretório, inicie os containers com o seguinte comando:

    ```bash
    docker-compose up --build
    ```

    * O `docker-compose` lerá o arquivo `docker-compose.yml`.
    * Ele construirá a imagem do serviço `java` (se ainda não existir) e a iniciará.
    * Ele iniciará o container do `db`, que fará uma verificação de saúde (`healthcheck`) para garantir que o banco de dados está pronto antes de iniciar a aplicação.
    * A aplicação Spring Boot iniciará em seguida e se conectará ao banco de dados com as credenciais do arquivo `.env`.

-----

#### Como Testar a Aplicação

Uma vez que o `docker-compose up` for concluído e os logs pararem de mostrar erros, a aplicação estará em execução.

**Teste o Endpoint `https://localhost:8080/hello`**

O seu arquivo `docker-compose.yml` mapeia a porta **8080** para a comunicação **HTTP**. Se a sua aplicação Spring Security exige HTTPS, será necessário um certificado. No entanto, para fins de teste local, a URL correta para o endpoint de exemplo é:

```bash
curl http://localhost:8080/hello
```

Se a sua aplicação responder com sucesso, significa que a configuração está correta e a comunicação com o banco de dados está funcionando.



### Getting started


To make it easy for you to get started with GitLab, here's a list of recommended next steps.

Already a pro? Just edit this README.md and make it your own. Want to make it easy? [Use the template at the bottom](#editing-this-readme)!

### Add your files

- [ ] [Create](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#create-a-file) or [upload](https://docs.gitlab.com/ee/user/project/repository/web_editor.html#upload-a-file) files
- [ ] [Add files using the command line](https://docs.gitlab.com/topics/git/add_files/#add-files-to-a-git-repository) or push an existing Git repository with the following command:

```
cd existing_repo
git remote add origin https://gitlab.com/codifica1/backend.git
git branch -M main
git push -uf origin main
```

### Integrate with your tools

- [ ] [Set up project integrations](https://gitlab.com/codifica1/backend/-/settings/integrations)

### Collaborate with your team

- [ ] [Invite team members and collaborators](https://docs.gitlab.com/ee/user/project/members/)
- [ ] [Create a new merge request](https://docs.gitlab.com/ee/user/project/merge_requests/creating_merge_requests.html)
- [ ] [Automatically close issues from merge requests](https://docs.gitlab.com/ee/user/project/issues/managing_issues.html#closing-issues-automatically)
- [ ] [Enable merge request approvals](https://docs.gitlab.com/ee/user/project/merge_requests/approvals/)
- [ ] [Set auto-merge](https://docs.gitlab.com/user/project/merge_requests/auto_merge/)

### Test and Deploy

Use the built-in continuous integration in GitLab.

- [ ] [Get started with GitLab CI/CD](https://docs.gitlab.com/ee/ci/quick_start/)
- [ ] [Analyze your code for known vulnerabilities with Static Application Security Testing (SAST)](https://docs.gitlab.com/ee/user/application_security/sast/)
- [ ] [Deploy to Kubernetes, Amazon EC2, or Amazon ECS using Auto Deploy](https://docs.gitlab.com/ee/topics/autodevops/requirements.html)
- [ ] [Use pull-based deployments for improved Kubernetes management](https://docs.gitlab.com/ee/user/clusters/agent/)
- [ ] [Set up protected environments](https://docs.gitlab.com/ee/ci/environments/protected_environments.html)

***

## Editing this README

When you're ready to make this README your own, just edit this file and use the handy template below (or feel free to structure it however you want - this is just a starting point!). Thanks to [makeareadme.com](https://www.makeareadme.com/) for this template.

## Suggestions for a good README

Every project is different, so consider which of these sections apply to yours. The sections used in the template are suggestions for most open source projects. Also keep in mind that while a README can be too long and detailed, too long is better than too short. If you think your README is too long, consider utilizing another form of documentation rather than cutting out information.

## Name
Choose a self-explaining name for your project.

## Description
Let people know what your project can do specifically. Provide context and add a link to any reference visitors might be unfamiliar with. A list of Features or a Background subsection can also be added here. If there are alternatives to your project, this is a good place to list differentiating factors.

## Badges
On some READMEs, you may see small images that convey metadata, such as whether or not all the tests are passing for the project. You can use Shields to add some to your README. Many services also have instructions for adding a badge.

## Visuals
Depending on what you are making, it can be a good idea to include screenshots or even a video (you'll frequently see GIFs rather than actual videos). Tools like ttygif can help, but check out Asciinema for a more sophisticated method.

## Installation
Within a particular ecosystem, there may be a common way of installing things, such as using Yarn, NuGet, or Homebrew. However, consider the possibility that whoever is reading your README is a novice and would like more guidance. Listing specific steps helps remove ambiguity and gets people to using your project as quickly as possible. If it only runs in a specific context like a particular programming language version or operating system or has dependencies that have to be installed manually, also add a Requirements subsection.

## Usage
Use examples liberally, and show the expected output if you can. It's helpful to have inline the smallest example of usage that you can demonstrate, while providing links to more sophisticated examples if they are too long to reasonably include in the README.

## Support
Tell people where they can go to for help. It can be any combination of an issue tracker, a chat room, an email address, etc.

## Roadmap
If you have ideas for releases in the future, it is a good idea to list them in the README.

## Contributing
State if you are open to contributions and what your requirements are for accepting them.

For people who want to make changes to your project, it's helpful to have some documentation on how to get started. Perhaps there is a script that they should run or some environment variables that they need to set. Make these steps explicit. These instructions could also be useful to your future self.

You can also document commands to lint the code or run tests. These steps help to ensure high code quality and reduce the likelihood that the changes inadvertently break something. Having instructions for running tests is especially helpful if it requires external setup, such as starting a Selenium server for testing in a browser.

## Authors and acknowledgment
Show your appreciation to those who have contributed to the project.

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.
