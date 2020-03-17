package ru.javabegin.training.springwebflow;

import com.rednavis.showcase.api.Hello;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ExploreContext {

  public static void main(String[] args) throws Exception {

    Hashtable<String, String> map = new Hashtable<>();

    // valid variables for JBoss AS started on localhost:8080
    map.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
    map.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

    final Context context = new InitialContext(map);

    String initialNames = "java:global/ear/com.rednavis-ejb-impl-1.0-SNAPSHOT/HelloImpl!com.rednavis.showcase.api.Hello"
        + " java:app/com.rednavis-ejb-impl-1.0-SNAPSHOT/HelloImpl!com.rednavis.showcase.api.Hello"
        + " java:module/HelloImpl!com.rednavis.showcase.api.Hello"
        + " java:jboss/exported/ear/com.rednavis-ejb-impl-1.0-SNAPSHOT/HelloImpl!com.rednavis.showcase.api.Hello"
        + " ejb:ear/com.rednavis-ejb-impl-1.0-SNAPSHOT/HelloImpl!com.rednavis.showcase.api.Hello"
        + " java:global/ear/com.rednavis-ejb-impl-1.0-SNAPSHOT/HelloImpl"
        + " java:app/com.rednavis-ejb-impl-1.0-SNAPSHOT/HelloImpl"
        + " java:module/HelloImpl";

    String[] names = initialNames.split(" ");

    List<String> matched = new ArrayList<>();

    for (String name : names) {
      try {
        System.out.printf("Using %s lookup\n", name);
        Hello helloService = (Hello) context.lookup(name);
        matched.add(name);
      }
      catch (Exception e){
      }
    }

    System.out.println("\nFound valid JNDI names:");
    System.out.println(matched);
  }
}
