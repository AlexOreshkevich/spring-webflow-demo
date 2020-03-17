# How to launch application
`mvn clean package tomee:run` and then navigate to http://localhost:8081/spring-mvc-webflow

# Integration with remote EJB
Make sure you have running instance of javaee-showcase application on WildFly 18+ on localhost:8080, it's JNDI would be used for lookup. It was configured under
`dispatcher-serlet.xml` config file:
```$xml
<jee:remote-slsb id="helloService" jndi-name="ejb:ear/com.rednavis-ejb-impl-1.0-SNAPSHOT/HelloImpl!com.rednavis.showcase.api.Hello"
    business-interface="com.rednavis.showcase.api.Hello">
    <jee:environment>
        java.naming.factory.initial=org.jboss.naming.remote.client.InitialContextFactory
        java.naming.provider.url=http-remoting://localhost:8080
        jboss.naming.client.ejb.context=true
    </jee:environment>
</jee:remote-slsb>
```

JNDI name starting with `ejb:ear/...` was the only working lookup name. Check `ExploreContenxt.java` for details.