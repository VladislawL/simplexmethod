<%@ page language="java" contentType="text/html"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp"></jsp:include>
<body>
	<div class="container h-100">
        <table style="width: 100%; height: 100%">
            <tr align="center">
                <td valign="center">
					<%
						out.println("solution.jsp");
						out.println(request.getParameterValues("table[]"));
						if(request.getParameterValues("table[]") != null)
							for(String str : request.getParameterValues("table[]"))
								out.print(str);
					%>
                </td>
            </tr>
        </table>
    </div>
</body>
<jsp:include page="foot.jsp"></jsp:include>
</html>