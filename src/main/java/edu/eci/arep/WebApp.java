package edu.eci.arep;

import edu.eci.arep.resources.Fibonacci;
import spark.Request;
import spark.Response;
import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Class that deploy on web
 * @author Maria Hernandez
 */
public class WebApp {
    public static void main(String[] args) {
        port (getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    /**
     * Method that show the first page
     * @param req
     * @param res
     * @return
     */
    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Calculadora de Fibonacci</h2>"
                + "<h4>A continuacion ingrese el numero que desea evaluar</h4>"
                + "<h4>NOTA: Por favor solo ingrese numeros enteros, no son validas las letras</h4>"
                + "<form action=\"/results\">"
                + "  Valor:"
                + "  <input type=\"text\" name=\"data\" size= 20 placeholder=\"10\n\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Evaluar\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    /**
     * Method that reads the file with the data input
     * @param req
     * @param res
     * @return
     */
    private static String resultsPage(Request req, Response res) {
        int value, number = 0;
        if (req.queryParams("data") != null) {
            number = Integer.parseInt(req.queryParams("data"));
        }
        value = Fibonacci.calculate(number);
        return "El numero de Fibonacci para el valor " + req.queryParams("data") + " es: " + value;
    }

    /**
     * Method that returns port service
     * @return
     */
    public static int getPort() {
        if (System.getenv("PORT") != null)
        {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}