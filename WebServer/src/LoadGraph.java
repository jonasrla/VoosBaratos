 import java.io.IOException;

 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;

 @WebServlet("/LoadGraph")
 public class LoadGraph extends HttpServlet {
     private static final long serialVersionUID = 1L;
             
     public LoadGraph() {
        super();
     }
       
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try{
            System.out.println("Origem: "+request.getAttribute("origem"));
            System.out.println("Destino: "+request.getAttribute("destino"));

            request.getRequestDispatcher("/WEB-INF/show_path.jsp").forward(request,response);
        } catch(Exception e){
            System.out.println("cannot get writer:"+e);
        }
    }
}
