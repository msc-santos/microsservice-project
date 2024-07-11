# Projeto de Micro Serviço desenvolvido durante o curso

## Projetos

- [x] Servidor de descoberta Eureka
- [x] Servidor hr-worker implementado com dados de trabalhadores que será consumido pelo micro serviço payroll
  - Implementado nesse servidor:
    - [x] Spring netflix eureka client, Cliente Eureka
- [x] Servidor hr-payroll que consome o servidor worker
  - Implementado nesse servidor:
    - [x] Spring netflix eureka client, Cliente Eureka
    - [x] Spring netflix eureka client, Balanceamento de Carga
    - [x] Spring Openfeign, para comunicação com outros microsservices
    - [x] Spring circuitbreaker resilience4j, para implementar um Circuit breaker
