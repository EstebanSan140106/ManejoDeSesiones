package org.esteban.ManejoDeSesiones.Filtro;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.esteban.ManejoDeSesiones.util.Conexion;
import org.esteban.ManejoDeSesiones.services.ServiceJdbcException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter()

public class ConexionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        try (Connection con = Conexion.getConnection()){
            if (con.getAutoCommit()) {
                con.setAutoCommit(false);

            }
            try {
                filterChain.doFilter(req, resp);
                con.commit();
            } catch (SQLException | ServiceJdbcException e) {
                con.rollback();
                ((HttpServletResponse)resp).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage() );
            }
        } catch (SQLException throwables) {
        throwables.printStackTrace();
        }
    }

}
