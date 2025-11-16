FROM registry.redhat.io/ubi8/openjdk-17-runtime

LABEL name="simple-api" \
      version="1.0.0" \
      summary="API Simples com Spring Boot"

# --- O Jeito Red Hat ---
# 1. Copie o .jar para o diretório de "deployments" padrão
# O script da imagem procura aqui por padrão.
COPY target/*.jar /deployments/app.jar

# 2. Expomos a porta (igual antes)
EXPOSE 8080

# 3. NÃO precisamos de um 'CMD' ou 'ENTRYPOINT'.
# Vamos usar o CMD padrão da imagem base (FROM), que
# já está configurado para executar o script run-java.sh.
# Esse script vai encontrar o /deployments/app.jar e
# executá-lo com as flags de memória otimizadas.
