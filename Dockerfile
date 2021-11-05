FROM openjdk:11

COPY src/main/java/trilha/back/ /project

WORKDIR /project

CMD Finacys_Spring