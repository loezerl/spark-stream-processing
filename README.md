### Spark Streaming Mining - Protótipo
*Esse protótipo está em fase de desenvolvimento para melhorar a arquitetura e facilitar a interoperabilidade de novos módulos de mineração de fluxo de dados.*

#### Sumário
**[1. Instalando do Apache Spark](#install)**

**[2. Utilizando o Apache Spark em seu projeto.](#maven)**

**[2.1 Integração com a IDE IntelliJ IDEA](#idea)**

**[3. Instalando e Configurando o Apache Kafka](#kafka)**

**[4. Executando o protótipo.](#prot)**


#### 1 - Instalando o Apache Spark <a name="install"></a>
##### 1.1 - Dependencias
Para executar o Apache Spark com sucesso, algumas dependencias são necessárias. Dentre elas:
**Java7+ SE**: Instale a versão do Java 7 ou superior e configure ela para ficar na variável de ambiente `JAVA_HOME`. Recomenda-se a instalação Java 8.

**Scala**: Após a instalação do Java, será necessário instalar o Scala. Faça o [download](http://www.scala-lang.org/download/) do Scala, extraia e copie os arquivos para a variavel de ambiente `/usr/local/src`.
```bash
$ sudo mkdir /usr/local/src/scala
$ sudo tar xvf arquivo_de_instalacao_do_scala.tgz -C /usr/local/src/scala/
```
```bash
$ vi .bashrc
```
Adicione as seguintes linhas no final do arquivo:
```bash
$ export SCALA_HOME=/usr/local/src/scala/scala-SUAVERSAO
$ export PATH=$SCALA_HOME/bin:$PATH
```
Reinicie a bashrc
```bash
$ . .bashrc
```
Averigue se o Scala foi instalado com sucesso:
```
$ scala -version
```
Isso vai mostrar a versão do scala:
`Scala code runner version 2.10.4 -- Copyright 2002-2013, LAMP/EPFL`

- Entre na [página de download](https://spark.apache.org/downloads.html) e baixe a ultima versão disponível com o Hadoop pré-compilado.


#### 2 - Utilizando o Apache Spark em seu projeto. <a name="maven"></a>

##### 2.1 - Integração com a IDE IntelliJ IDEA <a name="idea"></a>

#### 3 - Instalando e Configurando o Apache Kakfa <a name="kafka"></a>

#### 4 - Executando o protótipo. <a name="prot"></a>