<html>
    <head><title>JSP</title></head>
    <body>
       <% 
           String titulo = "Primeira P�gina JSP!" ; 
           String autor  = "Joyce Miranda";
       %>
       <h1> <% out.print(titulo); %> </h1>
       <h2> Autor: <%=autor%> </h2>
    </body>
</html>
