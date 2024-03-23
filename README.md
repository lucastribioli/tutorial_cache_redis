# TUTORIAL CACHE

Esse projeto aborda 3 maneiras diferentes de obter os dados:

* Sem cache, pegando de um Map
* Com cache em memória, usando recursos do Spring Cache
* E com o Redis, que é uma ferramenta completa para esse fim

## Para executar o Redis localmente na máquina

Vá na raiz do projeto e digite:

```shell
    docker build -t my-redis .
```
Depois da imagem criada na usa máquina, execute:
```shell
    docker run -p 6379:6379 --name my-running-redis -d my-redis
```
Depois de rodar a aplicação, se quiser analisar o arquivo de cache, execute o comando:
```shell
    docker exec -it my-running-redis sh 
```
Depois de acessar o container digite:
```shell
    redis-cli
```
E depois que acesso ou modo CLI do redis, liste as chaves:
```shell
    keys *
```



*** Precisa ter o Docker instalado na máquina