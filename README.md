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
*Averigue se a versao do Java é compatível com a do Scala.*

**Apache Maven**: Simples [procedimento de extrair](https://maven.apache.org/install.html) o arquivo e adicionar a pasta `bin` com o comando `mvn` na variável de ambiente `PATH`.

**Scala**: Após a instalação do Java, será necessário instalar o Scala. Faça o [download](http://www.scala-lang.org/download/) do Scala, extraia e copie os arquivos para a variavel de ambiente `/usr/local/src`.
```
$ sudo mkdir /usr/local/src/scala
$ sudo tar xvf arquivo_de_instalacao_do_scala.tgz -C /usr/local/src/scala/
```
```
$ vi .bashrc
```
Adicione as seguintes linhas no final do arquivo:
```
$ export SCALA_HOME=/usr/local/src/scala/scala-SUAVERSAO
$ export PATH=$SCALA_HOME/bin:$PATH
```
Reinicie a bashrc
```
$ . .bashrc
```
Averigue se o Scala foi instalado com sucesso:
```
$ scala -version
```
Isso vai mostrar a versão do scala:

`Scala code runner version 2.10.4 -- Copyright 2002-2013, LAMP/EPFL`

**Python 3.4+**: Instale a versão 3.4 ou superior. Recomenda-se o pacote da [Anaconda](https://www.anaconda.com/download/)

##### 1.2 - Instalando o Apache Spark

Entre na [página de download](https://spark.apache.org/downloads.html) e baixe a ultima versão disponível com o Hadoop pré-compilado.

Descompacte o arquivo de download e execute o seguinte comando dentro da pasta do Apache Spark:

```
./bin/spark-shell
```
Se os passos anteriores foram seguidos corretamente, a seguinte imagem deve aparecer:

![Apache Spark Shell](https://i.imgur.com/3qk3Xrr.png)

O pacote de download do Apache Spark vem com alguns exemplos que podem ser executados. Caso deseje isso, acesse este [tutorial - Run the Java application on Apache Spark cluster](http://www.robertomarchetto.com/spark_java_maven_example).

#### 2 - Utilizando o Apache Spark em seu projeto. <a name="maven"></a>

##### 2.1 - Integração com a IDE IntelliJ IDEA <a name="idea"></a>

#### 3 - Instalando e Configurando o Apache Kakfa <a name="kafka"></a>

#### 4 - Executando o protótipo. <a name="prot"></a>