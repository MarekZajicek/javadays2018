FROM jboss/keycloak:4.5.0.Final

ENV KEYCLOAK_USER=admin
ENV KEYCLOAK_PASSWORD=admin

ADD run.sh /opt/jboss
ADD themes /opt/jboss/keycloak/themes

ENTRYPOINT [ "/opt/jboss/run.sh" ]

CMD ["-b", "0.0.0.0"]