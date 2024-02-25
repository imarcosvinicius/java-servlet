package tech.maviprogressus.web;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cadastroAPI")
public class CadastroAPI extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;
    List<Usuario> usuarios = new ArrayList<>();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        usuarios.add(new Usuario("Ronaldo", "ronaldo@gmail.com"));
        usuarios.add(new Usuario("Pelé", "pele@gmail.com"));
        usuarios.add(new Usuario("Cafú", "cafu@gmail.com"));

        Gson gson = new Gson();
        String usuarioConvertidos = gson.toJson(usuarios);

        resp.getWriter().append(usuarioConvertidos);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(req.getInputStream()));
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        Gson gson = new Gson();
        var usuario = gson.fromJson(String.valueOf(stringBuilder), Usuario.class);
        System.out.println(usuario);
        usuarios.add(usuario);
    }

    record Usuario(String name, String email) {

    }

}