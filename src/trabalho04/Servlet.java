package trabalho04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Preferencia")
public class Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String nome = req.getParameter("nome");
		String matricula = req.getParameter("matricula");
		int idade = Integer.parseInt(req.getParameter("idade"));
		String sexo = req.getParameter("sexo");
		
		// imprime estes dados no cliente
		out.println("<HTML><HEAD><TITLE>Primeiro Servlet");
		out.println("</TITLE></HEAD><BODY>");
		out.println("<H1>Servlet com dados do form</H1>");
		out.println("<BR><b>Bom dia " + nome + "!</p> <br>");
		
		
		if(idade >= 18 && sexo.equalsIgnoreCase("masculino")) {
			out.println("<br>Você precisa servir ao exército.");
		}else if(idade < 18 && sexo.equalsIgnoreCase("masculino")) {
			out.println("<br>Você está ok com as obrigações militares.");
		}else if(sexo.equalsIgnoreCase("feminino")) {
			out.println("<br>Você não precisa servir ao exército.");
		}
		
		out.println("<BR></BODY></HTML>");
		out.close();
	}
}