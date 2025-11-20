# Sistema Acadêmico - Frontend (placeholder)

Este diretório deve conter a aplicação frontend que consome a API do backend.

Requisitos sugeridos:
- Listar, cadastrar e editar alunos e cursos
- Associar alunos a cursos
- Autenticação integrada (HTTP Basic neste scaffold; preferir JWT / Keycloak para produção)
- Responsividade

Tecnologias sugeridas: React + Vite ou Angular.

Como rodar localmente (exemplo React + Vite)

# Sistema Acadêmico - Frontend (placeholder)

Este diretório contém instruções e um placeholder para a aplicação frontend que consome a API do backend.

Requisitos sugeridos
- Listar, cadastrar e editar alunos e cursos
- Associar alunos a cursos (relação N:N)
- Autenticação integrada (no scaffold atual usa HTTP Basic; para produção prefira JWT ou Keycloak)
- Interface responsiva

Tecnologias sugeridas
- React + Vite ou Angular

Como rodar localmente (exemplo com React + Vite)

```powershell
cd C:\Users\ivank\Documents\Av2\frontend
npm install
npm run dev
```

Como consumir a API
- Defina a URL base como `http://localhost:8080` ou utilize uma variável de ambiente para isso.

Deploy
- Vercel: conectar o repositório e apontar a pasta `frontend/` para deploy automático.

Observações
- Se desejar, eu posso gerar um scaffold mínimo em React + Vite que implemente as operações básicas (listar, criar, editar, associar).
