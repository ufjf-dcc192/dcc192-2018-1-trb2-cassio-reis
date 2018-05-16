
package trabalho.ufjf.dcc192;

import javax.servlet.http.HttpServletRequest;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface Comando {

    void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
}
