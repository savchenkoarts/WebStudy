package ua.savchenko.web1.main;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ua.savchenko.web1.servlets.HomeRequestsServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        HomeRequestsServlet homeRequestsServlet = new HomeRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(homeRequestsServlet), "/home");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
    }
}
