package ua.savchenko.web1.servlets;



import ua.savchenko.web1.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeRequestsServlet extends HttpServlet {

    private static ArrayList citiesID;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, Object> pageVariables = createPageVariablesMap(request);
        pageVariables.put("cities", new ArrayList());

        response.getWriter().println(PageGenerator.instance().getPage("home.html", pageVariables));

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> pageVariables = createPageVariablesMap(request);
        citiesID = getItemList(request.getParameter("Path"));
        pageVariables.put("cities", citiesID);
        
        response.getWriter().println(PageGenerator.instance().getPage("home.html", pageVariables));
    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        return pageVariables;
    }

    private static ArrayList getItemList(String path) throws IOException {
        citiesID = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            citiesID.add(line);
        }
        bufferedReader.close();
        return citiesID;
    }
}
